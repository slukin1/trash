package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerOnce;
import com.android.installreferrer.api.InstallReferrerStateListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;

public class InstallReferrer implements InvocationHandler {
    private static final String PACKAGE_BASE_NAME = "com.android.installreferrer.";
    private static final int STATUS_DEVELOPER_ERROR = 3;
    private static final int STATUS_FEATURE_NOT_SUPPORTED = 2;
    private static final int STATUS_OK = 0;
    private static final int STATUS_SERVICE_DISCONNECTED = -1;
    private static final int STATUS_SERVICE_UNAVAILABLE = 1;
    private Context context;
    private ThreadExecutor executor;
    private ILogger logger = AdjustFactory.getLogger();
    /* access modifiers changed from: private */
    public final InstallReferrerReadListener referrerCallback;
    private Object referrerClient;
    private int retries;
    private TimerOnce retryTimer;
    private int retryWaitTime = 3000;
    private final AtomicBoolean shouldTryToRead;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            InstallReferrer.this.startConnection();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f13910a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Method f13911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object[] f13912c;

        public b(Object obj, Method method, Object[] objArr) {
            this.f13910a = obj;
            this.f13911b = method;
            this.f13912c = objArr;
        }

        public final void run() {
            try {
                Object unused = InstallReferrer.this.invokeI(this.f13910a, this.f13911b, this.f13912c);
            } catch (Throwable th2) {
                InstallReferrer.this.referrerCallback.onFail(Util.formatString("invoke error (%s) thrown by (%s)", th2.getMessage(), th2.getClass().getCanonicalName()));
            }
        }
    }

    public InstallReferrer(Context context2, InstallReferrerReadListener installReferrerReadListener) {
        this.context = context2;
        this.shouldTryToRead = new AtomicBoolean(true);
        this.retries = 0;
        this.retryTimer = new TimerOnce(new a(), "InstallReferrer");
        this.referrerCallback = installReferrerReadListener;
        this.executor = new SingleThreadCachedScheduler("InstallReferrer");
    }

    private void closeReferrerClient() {
        Object obj = this.referrerClient;
        if (obj != null) {
            try {
                Reflection.invokeInstanceMethod(obj, "endConnection", (Class[]) null, new Object[0]);
                this.logger.debug("Install Referrer API connection closed", new Object[0]);
            } catch (Exception e11) {
                this.logger.error("closeReferrerClient error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            }
            this.referrerClient = null;
        }
    }

    private Object createInstallReferrerClient(Context context2) {
        String str;
        InstallReferrerReadListener installReferrerReadListener;
        try {
            return Reflection.invokeInstanceMethod(Reflection.invokeStaticMethod("com.android.installreferrer.api.InstallReferrerClient", "newBuilder", new Class[]{Context.class}, context2), "build", (Class[]) null, new Object[0]);
        } catch (ClassNotFoundException e11) {
            installReferrerReadListener = this.referrerCallback;
            str = Util.formatString("InstallReferrer not integrated in project (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            installReferrerReadListener.onFail(str);
            return null;
        } catch (Exception e12) {
            installReferrerReadListener = this.referrerCallback;
            str = Util.formatString("createInstallReferrerClient error (%s) from (%s)", e12.getMessage(), e12.getClass().getCanonicalName());
            installReferrerReadListener.onFail(str);
            return null;
        }
    }

    private Object createProxyInstallReferrerStateListener(Class cls) {
        InstallReferrerReadListener installReferrerReadListener;
        String str;
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (IllegalArgumentException unused) {
            installReferrerReadListener = this.referrerCallback;
            str = "InstallReferrer proxy violating parameter restrictions";
            installReferrerReadListener.onFail(str);
            return null;
        } catch (NullPointerException unused2) {
            installReferrerReadListener = this.referrerCallback;
            str = "Null argument passed to InstallReferrer proxy";
            installReferrerReadListener.onFail(str);
            return null;
        }
    }

    private Boolean getBooleanGooglePlayInstantParam(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Boolean.valueOf(((Boolean) Reflection.invokeInstanceMethod(obj, "getGooglePlayInstantParam", (Class[]) null, new Object[0])).booleanValue());
        } catch (Exception unused) {
            return null;
        }
    }

    private long getInstallBeginTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e11) {
            this.logger.error("getInstallBeginTimestampSeconds error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return -1;
        }
    }

    private long getInstallBeginTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getInstallBeginTimestampServerSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private Object getInstallReferrer() {
        Object obj = this.referrerClient;
        if (obj == null) {
            return null;
        }
        try {
            return Reflection.invokeInstanceMethod(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e11) {
            this.logger.error("getInstallReferrer error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return null;
        }
    }

    private Class getInstallReferrerStateListenerClass() {
        return InstallReferrerStateListener.class;
    }

    private long getReferrerClickTimestampSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception e11) {
            this.logger.error("getReferrerClickTimestampSeconds error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return -1;
        }
    }

    private long getReferrerClickTimestampServerSeconds(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            return ((Long) Reflection.invokeInstanceMethod(obj, "getReferrerClickTimestampServerSeconds", (Class[]) null, new Object[0])).longValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private String getStringInstallReferrer(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallReferrer", (Class[]) null, new Object[0]);
        } catch (Exception e11) {
            this.logger.error("getStringInstallReferrer error (%s) thrown by (%s)", e11.getMessage(), e11.getClass().getCanonicalName());
            return null;
        }
    }

    private String getStringInstallVersion(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (String) Reflection.invokeInstanceMethod(obj, "getInstallVersion", (Class[]) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public Object invokeI(Object obj, Method method, Object[] objArr) {
        InstallReferrerReadListener installReferrerReadListener;
        String str;
        if (method == null) {
            installReferrerReadListener = this.referrerCallback;
            str = "InstallReferrer invoke method null";
        } else {
            String name = method.getName();
            if (name == null) {
                installReferrerReadListener = this.referrerCallback;
                str = "InstallReferrer invoke method name null";
            } else {
                this.logger.debug("InstallReferrer invoke method name: %s", name);
                if (objArr == null) {
                    this.logger.warn("InstallReferrer invoke args null", new Object[0]);
                    objArr = new Object[0];
                }
                for (Object obj2 : objArr) {
                    this.logger.debug("InstallReferrer invoke arg: %s", obj2);
                }
                if (name.equals("onInstallReferrerSetupFinished")) {
                    if (objArr.length != 1) {
                        installReferrerReadListener = this.referrerCallback;
                        str = Util.formatString("InstallReferrer invoke onInstallReferrerSetupFinished args lenght not 1: %d", Integer.valueOf(objArr.length));
                    } else {
                        Object obj3 = objArr[0];
                        if (!(obj3 instanceof Integer)) {
                            installReferrerReadListener = this.referrerCallback;
                            str = "InstallReferrer invoke onInstallReferrerSetupFinished arg not int";
                        } else {
                            Integer num = (Integer) obj3;
                            if (num == null) {
                                installReferrerReadListener = this.referrerCallback;
                                str = "InstallReferrer invoke onInstallReferrerSetupFinished responseCode arg is null";
                            } else {
                                onInstallReferrerSetupFinishedIntI(num.intValue());
                            }
                        }
                    }
                } else if (name.equals("onInstallReferrerServiceDisconnected")) {
                    this.logger.debug("Connection to install referrer service was lost. Retrying ...", new Object[0]);
                    retryI("onInstallReferrerServiceDisconnected");
                } else {
                    this.referrerCallback.onFail(Util.formatString("Reflection call method name not expected: %s", name));
                }
                return null;
            }
        }
        installReferrerReadListener.onFail(str);
        return null;
    }

    private void onInstallReferrerSetupFinishedIntI(int i11) {
        int i12 = i11;
        boolean z11 = true;
        if (i12 != -1) {
            if (i12 == 0) {
                try {
                    Object installReferrer = getInstallReferrer();
                    String stringInstallReferrer = getStringInstallReferrer(installReferrer);
                    long referrerClickTimestampSeconds = getReferrerClickTimestampSeconds(installReferrer);
                    long installBeginTimestampSeconds = getInstallBeginTimestampSeconds(installReferrer);
                    this.logger.debug("installReferrer: %s, clickTime: %d, installBeginTime: %d", stringInstallReferrer, Long.valueOf(referrerClickTimestampSeconds), Long.valueOf(installBeginTimestampSeconds));
                    String stringInstallVersion = getStringInstallVersion(installReferrer);
                    long referrerClickTimestampServerSeconds = getReferrerClickTimestampServerSeconds(installReferrer);
                    long installBeginTimestampServerSeconds = getInstallBeginTimestampServerSeconds(installReferrer);
                    Boolean booleanGooglePlayInstantParam = getBooleanGooglePlayInstantParam(installReferrer);
                    this.logger.debug("installVersion: %s, clickTimeServer: %d, installBeginServer: %d, googlePlayInstant: %b", stringInstallVersion, Long.valueOf(referrerClickTimestampServerSeconds), Long.valueOf(installBeginTimestampServerSeconds), booleanGooglePlayInstantParam);
                    this.logger.debug("Install Referrer read successfully. Closing connection", new Object[0]);
                    this.referrerCallback.onInstallReferrerRead(new ReferrerDetails(stringInstallReferrer, referrerClickTimestampSeconds, installBeginTimestampSeconds, referrerClickTimestampServerSeconds, installBeginTimestampServerSeconds, stringInstallVersion, booleanGooglePlayInstantParam, (Boolean) null), Constants.REFERRER_API_GOOGLE);
                } catch (Exception e11) {
                    this.logger.warn("Couldn't get install referrer from client (%s). Retrying...", e11.getMessage());
                }
            } else if (i12 == 1) {
                this.logger.debug("Could not initiate connection to the Install Referrer service. Retrying...", new Object[0]);
            } else if (i12 == 2) {
                this.referrerCallback.onFail("Install Referrer API not supported by the installed Play Store app. Closing connection");
            } else if (i12 != 3) {
                this.referrerCallback.onFail(Util.formatString("Unexpected response code of install referrer response: %d. Closing connection", Integer.valueOf(i11)));
            } else {
                this.logger.debug("Install Referrer API general errors caused by incorrect usage. Retrying...", new Object[0]);
            }
            z11 = false;
        } else {
            this.logger.debug("Play Store service is not connected now. Retrying...", new Object[0]);
        }
        if (z11) {
            retryI("end of onInstallReferrerSetupFinishedIntI");
            return;
        }
        this.shouldTryToRead.set(false);
        closeReferrerClient();
    }

    private void retryI(String str) {
        if (!this.shouldTryToRead.get()) {
            this.referrerCallback.onFail(Util.formatString("Should not try to read Install referrer from %s", str));
            closeReferrerClient();
        } else if (this.retries + 1 > 2) {
            this.referrerCallback.onFail(Util.formatString("Limit number of retry of %d for install referrer surpassed from %s", 2, str));
        } else {
            long fireIn = this.retryTimer.getFireIn();
            if (fireIn > 0) {
                this.logger.debug("Already waiting to retry to read install referrer in %d milliseconds", Long.valueOf(fireIn));
                return;
            }
            int i11 = this.retries + 1;
            this.retries = i11;
            this.logger.debug("Retry number %d to connect to install referrer API", Integer.valueOf(i11));
            this.retryTimer.startIn((long) this.retryWaitTime);
        }
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.executor.submit(new b(obj, method, objArr));
        return null;
    }

    public void startConnection() {
        Class installReferrerStateListenerClass;
        Object createProxyInstallReferrerStateListener;
        InstallReferrerReadListener installReferrerReadListener;
        String str;
        if (!AdjustFactory.getTryInstallReferrer()) {
            installReferrerReadListener = this.referrerCallback;
            str = "Sdk has been configured to not try install referrer";
        } else {
            closeReferrerClient();
            if (!this.shouldTryToRead.get()) {
                installReferrerReadListener = this.referrerCallback;
                str = "Should not try to read the install referrer any longer";
            } else {
                Context context2 = this.context;
                if (context2 == null) {
                    installReferrerReadListener = this.referrerCallback;
                    str = "Requires context to read the install referrer";
                } else {
                    Object createInstallReferrerClient = createInstallReferrerClient(context2);
                    this.referrerClient = createInstallReferrerClient;
                    if (createInstallReferrerClient != null && (installReferrerStateListenerClass = getInstallReferrerStateListenerClass()) != null && (createProxyInstallReferrerStateListener = createProxyInstallReferrerStateListener(installReferrerStateListenerClass)) != null) {
                        startConnection(installReferrerStateListenerClass, createProxyInstallReferrerStateListener);
                        return;
                    }
                    return;
                }
            }
        }
        installReferrerReadListener.onFail(str);
    }

    private void startConnection(Class cls, Object obj) {
        InstallReferrerReadListener installReferrerReadListener;
        String formatString;
        try {
            Reflection.invokeInstanceMethod(this.referrerClient, "startConnection", new Class[]{cls}, obj);
            return;
        } catch (InvocationTargetException e11) {
            if (Util.hasRootCause(e11)) {
                installReferrerReadListener = this.referrerCallback;
                formatString = Util.formatString("InstallReferrer encountered an InvocationTargetException %s", Util.getRootCause(e11));
            } else {
                this.referrerCallback.onFail("InstallReferrer encountered an InvocationTargetException");
                return;
            }
        } catch (Exception e12) {
            installReferrerReadListener = this.referrerCallback;
            formatString = Util.formatString("startConnection error (%s) thrown by (%s)", e12.getMessage(), e12.getClass().getCanonicalName());
        }
        installReferrerReadListener.onFail(formatString);
    }
}

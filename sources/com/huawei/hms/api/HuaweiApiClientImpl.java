package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    private static final Object A = new Object();
    private static final Object B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f37779a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final Context f37780b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37781c;

    /* renamed from: d  reason: collision with root package name */
    private String f37782d;

    /* renamed from: e  reason: collision with root package name */
    private String f37783e;

    /* renamed from: f  reason: collision with root package name */
    private volatile IAIDLInvoke f37784f;

    /* renamed from: g  reason: collision with root package name */
    private String f37785g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<Activity> f37786h;

    /* renamed from: i  reason: collision with root package name */
    private WeakReference<Activity> f37787i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f37788j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AtomicInteger f37789k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    private List<Scope> f37790l;

    /* renamed from: m  reason: collision with root package name */
    private List<PermissionInfo> f37791m;

    /* renamed from: n  reason: collision with root package name */
    private Map<Api<?>, Api.ApiOptions> f37792n;

    /* renamed from: o  reason: collision with root package name */
    private SubAppInfo f37793o;

    /* renamed from: p  reason: collision with root package name */
    private long f37794p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f37795q = 0;

    /* renamed from: r  reason: collision with root package name */
    private final Object f37796r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private final ReentrantLock f37797s;

    /* renamed from: t  reason: collision with root package name */
    private final Condition f37798t;

    /* renamed from: u  reason: collision with root package name */
    private ConnectionResult f37799u;

    /* renamed from: v  reason: collision with root package name */
    private HuaweiApiClient.ConnectionCallbacks f37800v;

    /* renamed from: w  reason: collision with root package name */
    private HuaweiApiClient.OnConnectionFailedListener f37801w;

    /* renamed from: x  reason: collision with root package name */
    private Handler f37802x;

    /* renamed from: y  reason: collision with root package name */
    private Handler f37803y;

    /* renamed from: z  reason: collision with root package name */
    private CheckUpdatelistener f37804z;

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f37789k.get() == 5) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f37789k.get() == 2) {
                HuaweiApiClientImpl.this.c(1);
                HuaweiApiClientImpl.this.b();
            }
            return true;
        }
    }

    public class c extends IAIDLCallback.Stub {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ResultCallback f37807a;

        public c(ResultCallback resultCallback) {
            this.f37807a = resultCallback;
        }

        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                ResponseHeader responseHeader = new ResponseHeader();
                find.decode(dataBuffer.header, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f37807a.onResult(bundleResult);
                return;
            }
            HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f37807a.onResult(new BundleResult(-1, (Bundle) null));
        }
    }

    public static class d extends PendingResultImpl<Status, IMessageEntity> {
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        /* renamed from: a */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    public class e implements ResultCallback<ResolveResult<ConnectResp>> {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResolveResult f37810a;

            public a(ResolveResult resolveResult) {
                this.f37810a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.a((ResolveResult<ConnectResp>) this.f37810a);
            }
        }

        private e() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResolveResult f37813a;

            public a(ResolveResult resolveResult) {
                this.f37813a = resolveResult;
            }

            public void run() {
                HuaweiApiClientImpl.this.b((ResolveResult<DisconnectResp>) this.f37813a);
            }
        }

        private f() {
        }

        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        public /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private g() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
            r4 = r4.getValue();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResult(com.huawei.hms.support.api.ResolveResult<com.huawei.hms.support.api.entity.core.JosGetNoticeResp> r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x004c
                com.huawei.hms.support.api.client.Status r0 = r4.getStatus()
                boolean r0 = r0.isSuccess()
                if (r0 == 0) goto L_0x004c
                java.lang.Object r4 = r4.getValue()
                com.huawei.hms.support.api.entity.core.JosGetNoticeResp r4 = (com.huawei.hms.support.api.entity.core.JosGetNoticeResp) r4
                android.content.Intent r0 = r4.getNoticeIntent()
                if (r0 == 0) goto L_0x004c
                int r4 = r4.getStatusCode()
                if (r4 != 0) goto L_0x004c
                java.lang.String r4 = "HuaweiApiClientImpl"
                java.lang.String r1 = "get notice has intent."
                com.huawei.hms.support.log.HMSLog.i(r4, r1)
                com.huawei.hms.api.HuaweiApiClientImpl r1 = com.huawei.hms.api.HuaweiApiClientImpl.this
                java.lang.ref.WeakReference r1 = r1.f37786h
                java.lang.Object r1 = r1.get()
                android.app.Activity r1 = (android.app.Activity) r1
                com.huawei.hms.api.HuaweiApiClientImpl r2 = com.huawei.hms.api.HuaweiApiClientImpl.this
                android.app.Activity r2 = r2.getTopActivity()
                android.app.Activity r1 = com.huawei.hms.utils.Util.getValidActivity(r1, r2)
                if (r1 != 0) goto L_0x0043
                java.lang.String r0 = "showNotice no valid activity!"
                com.huawei.hms.support.log.HMSLog.e(r4, r0)
                return
            L_0x0043:
                com.huawei.hms.api.HuaweiApiClientImpl r4 = com.huawei.hms.api.HuaweiApiClientImpl.this
                r2 = 1
                boolean unused = r4.f37788j = r2
                r1.startActivity(r0)
            L_0x004c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.g.onResult(com.huawei.hms.support.api.ResolveResult):void");
        }

        public /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f37797s = reentrantLock;
        this.f37798t = reentrantLock.newCondition();
        this.f37802x = null;
        this.f37803y = null;
        this.f37804z = null;
        this.f37780b = context;
        String appId = Util.getAppId(context);
        this.f37781c = appId;
        this.f37782d = appId;
        this.f37783e = Util.getCpId(context);
    }

    private DisconnectInfo d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f37792n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return new DisconnectInfo(this.f37790l, arrayList);
    }

    private int e() {
        int hmsVersion = Util.getHmsVersion(this.f37780b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int f11 = f();
        if (g()) {
            if (f11 < 20503000) {
                return 20503000;
            }
            return f11;
        } else if (f11 < 20600000) {
            return 20600000;
        } else {
            return f11;
        }
    }

    private int f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i11 = 0;
        if (apiMap == null) {
            return 0;
        }
        for (Api<?> apiName : apiMap.keySet()) {
            String apiName2 = apiName.getApiName();
            if (!TextUtils.isEmpty(apiName2) && (num = HuaweiApiAvailability.getApiMap().get(apiName2)) != null && (intValue = num.intValue()) > i11) {
                i11 = intValue;
            }
        }
        return i11;
    }

    private boolean g() {
        Map<Api<?>, Api.ApiOptions> map = this.f37792n;
        if (map == null) {
            return false;
        }
        for (Api<?> apiName : map.keySet()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(apiName.getApiName())) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        Handler handler = this.f37802x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f37802x = new Handler(Looper.getMainLooper(), new a());
        }
        this.f37802x.sendEmptyMessageDelayed(2, 5000);
    }

    private void i() {
        synchronized (B) {
            Handler handler = this.f37803y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.f37803y = new Handler(Looper.getMainLooper(), new b());
            }
            boolean sendEmptyMessageDelayed = this.f37803y.sendEmptyMessageDelayed(3, 3000);
            HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
        }
    }

    private void j() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, c()).setResultCallback(new e(this, (a) null));
    }

    private void k() {
        ConnectService.disconnect(this, d()).setResultCallback(new f(this, (a) null));
    }

    private void l() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, c()).setResultCallback(new e(this, (a) null));
    }

    private void m() {
        if (this.f37788j) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f37780b) == 0) {
            ConnectService.getNotice(this, 0, "6.11.0.302").setResultCallback(new g(this, (a) null));
        }
    }

    private void n() {
        Util.unBindServiceCatchException(this.f37780b, this);
        this.f37784f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i11, ResultCallback<BundleResult> resultCallback) {
        HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback == null || str == null || bundle == null) {
            HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        } else if (!innerIsConnected()) {
            HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
            return CommonCode.ErrorCode.CLIENT_API_INVALID;
        } else {
            DataBuffer dataBuffer = new DataBuffer(str, i11);
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 61100302, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new c(resultCallback));
                return 0;
            } catch (RemoteException e11) {
                HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e11.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
    }

    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.e("HuaweiApiClientImpl", "listener is null!");
        } else if (activity == null || activity.isFinishing()) {
            HMSLog.e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
            checkUpdatelistener.onResult(-1);
        } else {
            this.f37804z = checkUpdatelistener;
            try {
                Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
                Object newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                cls.getMethod("initCheckUpdateCallBack", new Class[]{Object.class, Activity.class}).invoke(newInstance, new Object[]{this, activity});
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
                HMSLog.e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e11.getMessage());
                checkUpdatelistener.onResult(-1);
            }
        }
    }

    public void connect(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i11 = this.f37789k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i11);
        if (i11 != 3 && i11 != 5 && i11 != 2 && i11 != 4) {
            if (activity != null) {
                this.f37786h = new WeakReference<>(activity);
                this.f37787i = new WeakReference<>(activity);
            }
            this.f37782d = TextUtils.isEmpty(this.f37781c) ? Util.getAppId(this.f37780b) : this.f37781c;
            int e11 = e();
            HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e11);
            HuaweiApiAvailability.setServicesVersionCode(e11);
            int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f37780b, e11);
            HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
            this.f37795q = HMSPackageManager.getInstance(this.f37780b).getHmsMultiServiceVersion();
            if (isHuaweiMobileServicesAvailable == 0) {
                c(5);
                if (this.f37784f == null) {
                    a();
                    return;
                }
                c(2);
                j();
                i();
            } else if (this.f37801w != null) {
                b(isHuaweiMobileServicesAvailable);
            }
        }
    }

    public void connectForeground() {
        HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 61100302 ======");
        int i11 = this.f37789k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i11);
        if (i11 != 3 && i11 != 5 && i11 != 2 && i11 != 4) {
            this.f37782d = TextUtils.isEmpty(this.f37781c) ? Util.getAppId(this.f37780b) : this.f37781c;
            l();
        }
    }

    public void disableLifeCycleManagement(Activity activity) {
        if (this.f37779a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f37779a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    public PendingResult<Status> discardAndReconnect() {
        return new d(this, (String) null, (IMessageEntity) null);
    }

    public void disconnect() {
        int i11 = this.f37789k.get();
        HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i11);
        if (i11 == 2) {
            c(4);
        } else if (i11 == 3) {
            c(4);
            k();
        } else if (i11 == 5) {
            a(2);
            c(4);
        }
    }

    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f37792n;
    }

    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f37792n;
        if (map != null) {
            for (Api<?> apiName : map.keySet()) {
                arrayList.add(apiName.getApiName());
            }
        }
        return arrayList;
    }

    public String getAppID() {
        return this.f37782d;
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f37799u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f37799u;
        if (connectionResult != null) {
            return connectionResult;
        }
        return new ConnectionResult(13, (PendingIntent) null);
    }

    public Context getContext() {
        return this.f37780b;
    }

    public String getCpID() {
        return this.f37783e;
    }

    public String getPackageName() {
        return this.f37780b.getPackageName();
    }

    public List<PermissionInfo> getPermissionInfos() {
        return this.f37791m;
    }

    public List<Scope> getScopes() {
        return this.f37790l;
    }

    public IAIDLInvoke getService() {
        return this.f37784f;
    }

    public String getSessionId() {
        return this.f37785g;
    }

    public final SubAppInfo getSubAppInfo() {
        return this.f37793o;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f37787i;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f37796r) {
            if (this.f37801w == onConnectionFailedListener) {
                return true;
            }
            return false;
        }
    }

    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f37796r) {
            if (this.f37800v == connectionCallbacks) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|5) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect() {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0065
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x005e }
        L_0x0013:
            boolean r1 = r3.isConnecting()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0033
            java.util.concurrent.locks.Condition r1 = r3.f37798t     // Catch:{ InterruptedException -> 0x001f }
            r1.await()     // Catch:{ InterruptedException -> 0x001f }
            goto L_0x0013
        L_0x001f:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005e }
            r1.interrupt()     // Catch:{ all -> 0x005e }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 15
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.unlock()
            return r1
        L_0x0033:
            boolean r1 = r3.isConnected()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0047
            r3.f37799u = r0     // Catch:{ all -> 0x005e }
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 0
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.unlock()
            return r1
        L_0x0047:
            com.huawei.hms.api.ConnectionResult r1 = r3.f37799u     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0051
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.unlock()
            return r1
        L_0x0051:
            com.huawei.hms.api.ConnectionResult r1 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x005e }
            r2 = 13
            r1.<init>((int) r2, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.unlock()
            return r1
        L_0x005e:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantLock r1 = r3.f37797s
            r1.unlock()
            throw r0
        L_0x0065:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect():com.huawei.hms.api.ConnectionResult");
    }

    public boolean innerIsConnected() {
        return this.f37789k.get() == 3 || this.f37789k.get() == 4;
    }

    public boolean isConnected() {
        if (this.f37795q == 0) {
            this.f37795q = HMSPackageManager.getInstance(this.f37780b).getHmsMultiServiceVersion();
        }
        if (this.f37795q >= 20504000) {
            return innerIsConnected();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f37794p;
        if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
            return innerIsConnected();
        }
        if (!innerIsConnected()) {
            return false;
        }
        Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000, TimeUnit.MILLISECONDS).getStatus();
        if (status.isSuccess()) {
            this.f37794p = System.currentTimeMillis();
            return true;
        }
        int statusCode = status.getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
        if (statusCode == 907135004) {
            return false;
        }
        n();
        c(1);
        this.f37794p = System.currentTimeMillis();
        return false;
    }

    public boolean isConnecting() {
        int i11 = this.f37789k.get();
        return i11 == 2 || i11 == 5;
    }

    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    public void onResult(int i11) {
        this.f37804z.onResult(i11);
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.f37787i = new WeakReference<>(activity);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        a(2);
        this.f37784f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f37784f == null) {
            HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            n();
            c(1);
            if (this.f37801w != null) {
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.f37786h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f37786h.get(), 10);
                }
                ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                this.f37801w.onConnectionFailed(connectionResult);
                this.f37799u = connectionResult;
            }
        } else if (this.f37789k.get() == 5) {
            c(2);
            j();
            i();
        } else if (this.f37789k.get() != 3) {
            n();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f37784f = null;
        c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f37800v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f37796r) {
            if (this.f37801w != onConnectionFailedListener) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f37801w = null;
            }
        }
    }

    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f37796r) {
            if (this.f37800v != connectionCallbacks) {
                HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f37800v = null;
            }
        }
    }

    public void resetListener() {
        this.f37804z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f37792n = map;
    }

    public void setAutoLifecycleClientId(int i11) {
        this.f37779a = i11;
    }

    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f37800v = connectionCallbacks;
    }

    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f37801w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z11) {
        this.f37788j = z11;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f37791m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f37790l = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f37781c) ? Util.getAppId(this.f37780b) : this.f37781c)) {
            HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f37793o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* access modifiers changed from: private */
    public void c(int i11) {
        this.f37789k.set(i11);
        if (i11 == 1 || i11 == 3 || i11 == 2) {
            this.f37797s.lock();
            try {
                this.f37798t.signalAll();
            } finally {
                this.f37797s.unlock();
            }
        }
    }

    private void b(int i11) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f37786h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f37786h.get(), i11);
            HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i11);
        }
        ConnectionResult connectionResult = new ConnectionResult(i11, pendingIntent);
        this.f37801w.onConnectionFailed(connectionResult);
        this.f37799u = connectionResult;
    }

    private void a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f37780b).getServiceAction());
        HMSPackageManager.getInstance(this.f37780b).refreshForMultiService();
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f37780b).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.e("HuaweiApiClientImpl", "servicePackageName is empty, Service is invalid, bind core service fail.");
                c(1);
                b();
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (A) {
                if (this.f37780b.bindService(intent, this, 1)) {
                    h();
                    return;
                }
                c(1);
                HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
                b();
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            c(1);
            HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
            b();
        }
    }

    private ConnectInfo c() {
        String packageSignature = new PackageManagerHelper(this.f37780b).getPackageSignature(this.f37780b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f37793o;
        return new ConnectInfo(getApiNameList(), this.f37790l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* access modifiers changed from: private */
    public void b() {
        n();
        if (this.f37801w != null) {
            int i11 = UIUtil.isBackground(this.f37780b) ? 7 : 6;
            PendingIntent pendingIntent = null;
            WeakReference<Activity> weakReference = this.f37786h;
            if (!(weakReference == null || weakReference.get() == null)) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f37786h.get(), i11);
            }
            ConnectionResult connectionResult = new ConnectionResult(i11, pendingIntent);
            this.f37801w.onConnectionFailed(connectionResult);
            this.f37799u = connectionResult;
        }
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        c(3);
        this.f37799u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f37800v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f37786h != null) {
            m();
        }
        for (Map.Entry next : getApiMap().entrySet()) {
            if (((Api) next.getKey()).getmConnetctPostList() != null && !((Api) next.getKey()).getmConnetctPostList().isEmpty()) {
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor run : ((Api) next.getKey()).getmConnetctPostList()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    run.run(this, this.f37786h);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        n();
        c(1);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:14|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        return new com.huawei.hms.api.ConnectionResult(15, (android.app.PendingIntent) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.api.ConnectionResult holdUpConnect(long r4, java.util.concurrent.TimeUnit r6) {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0080
            java.util.concurrent.locks.ReentrantLock r0 = r3.f37797s
            r0.lock()
            r0 = 0
            r3.connect((android.app.Activity) r0)     // Catch:{ all -> 0x0079 }
            long r4 = r6.toNanos(r4)     // Catch:{ all -> 0x0079 }
        L_0x0017:
            boolean r6 = r3.isConnecting()     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x004e
            r1 = 0
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r3.disconnect()     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 14
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            return r4
        L_0x0033:
            java.util.concurrent.locks.Condition r6 = r3.f37798t     // Catch:{ InterruptedException -> 0x003a }
            long r4 = r6.awaitNanos(r4)     // Catch:{ InterruptedException -> 0x003a }
            goto L_0x0017
        L_0x003a:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0079 }
            r4.interrupt()     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 15
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            return r4
        L_0x004e:
            boolean r4 = r3.isConnected()     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x0062
            r3.f37799u = r0     // Catch:{ all -> 0x0079 }
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 0
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            return r4
        L_0x0062:
            com.huawei.hms.api.ConnectionResult r4 = r3.f37799u     // Catch:{ all -> 0x0079 }
            if (r4 == 0) goto L_0x006c
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            return r4
        L_0x006c:
            com.huawei.hms.api.ConnectionResult r4 = new com.huawei.hms.api.ConnectionResult     // Catch:{ all -> 0x0079 }
            r5 = 13
            r4.<init>((int) r5, (android.app.PendingIntent) r0)     // Catch:{ all -> 0x0079 }
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            return r4
        L_0x0079:
            r4 = move-exception
            java.util.concurrent.locks.ReentrantLock r5 = r3.f37797s
            r5.unlock()
            throw r4
        L_0x0080:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "blockingConnect must not be called on the UI thread"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.api.HuaweiApiClientImpl.holdUpConnect(long, java.util.concurrent.TimeUnit):com.huawei.hms.api.ConnectionResult");
    }

    public void connect(int i11) {
        connect((Activity) null);
    }

    private void a(int i11) {
        if (i11 == 2) {
            synchronized (A) {
                Handler handler = this.f37802x;
                if (handler != null) {
                    handler.removeMessages(i11);
                    this.f37802x = null;
                }
            }
        }
        if (i11 == 3) {
            synchronized (B) {
                Handler handler2 = this.f37803y;
                if (handler2 != null) {
                    handler2.removeMessages(i11);
                    this.f37803y = null;
                }
            }
        }
        synchronized (A) {
            Handler handler3 = this.f37802x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.f37802x = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f37784f == null || this.f37789k.get() != 2) {
            HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
            return;
        }
        a(3);
        ConnectResp value = resolveResult.getValue();
        if (value != null) {
            this.f37785g = value.sessionId;
        }
        SubAppInfo subAppInfo = this.f37793o;
        PendingIntent pendingIntent = null;
        String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
        if (!TextUtils.isEmpty(subAppID)) {
            this.f37782d = subAppID;
        }
        int statusCode = resolveResult.getStatus().getStatusCode();
        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
        if (Status.SUCCESS.equals(resolveResult.getStatus())) {
            c(resolveResult);
        } else if (resolveResult.getStatus() == null || resolveResult.getStatus().getStatusCode() != 1001) {
            n();
            c(1);
            if (this.f37801w != null) {
                WeakReference<Activity> weakReference = this.f37786h;
                if (!(weakReference == null || weakReference.get() == null)) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent((Activity) this.f37786h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f37801w.onConnectionFailed(connectionResult);
                this.f37799u = connectionResult;
            }
        } else {
            n();
            c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f37800v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(3);
            }
        }
    }
}

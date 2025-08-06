package com.tencent.tpns.mqttchannel.core.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttDeliveryToken;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpush.common.Constants;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IMqttServiceImpl extends IMqttService.Stub implements MqttCallbackExtended {
    private static ConcurrentHashMap<Long, IMqttCallback> C = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static long f49977b = System.currentTimeMillis();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49978c = true;

    /* renamed from: d  reason: collision with root package name */
    private static ExecutorService f49979d = Executors.newSingleThreadExecutor();

    /* renamed from: k  reason: collision with root package name */
    private static int f49980k = 4;
    private a A = new a(2);
    private List<IMqttCallback> B = new CopyOnWriteArrayList();
    private Queue<Request> D = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public long E = 0;
    private volatile boolean F = false;
    private ReentrantLock G = new ReentrantLock();

    /* renamed from: a  reason: collision with root package name */
    public Object f49981a = new Object();

    /* renamed from: e  reason: collision with root package name */
    private volatile MqttAsyncClient f49982e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile MqttConnectState f49983f = MqttConnectState.DISCONNECTED;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile int f49984g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile int f49985h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile int f49986i = 0;

    /* renamed from: j  reason: collision with root package name */
    private volatile int[] f49987j = {4, 16, 32, 64, 128};
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Context f49988l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Map<Long, Pair<IMqttCallback, TTask>> f49989m = new ConcurrentHashMap();

    /* renamed from: n  reason: collision with root package name */
    private boolean f49990n;

    /* renamed from: o  reason: collision with root package name */
    private Class f49991o = null;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Handler f49992p = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f49993q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f49994r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f49995s = false;

    /* renamed from: t  reason: collision with root package name */
    private volatile int f49996t;

    /* renamed from: u  reason: collision with root package name */
    private volatile int f49997u;

    /* renamed from: v  reason: collision with root package name */
    private BaseMqttClientService f49998v;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f49999w = false;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public com.tencent.tpns.mqttchannel.core.services.a.b f50000x;

    /* renamed from: y  reason: collision with root package name */
    private a f50001y = new a(0);

    /* renamed from: z  reason: collision with root package name */
    private a f50002z = new a(1);

    /* renamed from: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50004a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$b[] r0 = com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50004a = r0
                com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$b r1 = com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.b.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50004a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$b r1 = com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.b.CONNECTING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.AnonymousClass10.<clinit>():void");
        }
    }

    public class a extends TTask {

        /* renamed from: b  reason: collision with root package name */
        private int f50040b = 0;

        public a(int i11) {
            super("MQTTActionTask");
            this.f50040b = i11;
        }

        public void TRun() {
            int i11 = this.f50040b;
            if (i11 == 0) {
                IMqttServiceImpl.this.p();
            } else if (i11 == 1) {
                IMqttServiceImpl.this.w();
            } else if (i11 != 2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "unknow actiontype:" + this.f50040b);
            } else {
                IMqttServiceImpl.this.f();
            }
        }
    }

    public enum b {
        CONNECTED,
        CONNECTING,
        IDLE,
        STOPED,
        f50045e
    }

    public IMqttServiceImpl(Context context) {
        this.f49988l = context;
        this.f49990n = a(context);
        this.f49993q = GuidInfoManager.isServerDestroy(context);
        h();
        this.f49996t = GuidInfoManager.getEncryptLevel(context);
        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.f49996t + ", compressLevel: " + this.f49997u);
        d();
        if (this.f49992p == null) {
            r();
        }
        j();
        this.f49999w = false;
    }

    public static /* synthetic */ int k(IMqttServiceImpl iMqttServiceImpl) {
        int i11 = iMqttServiceImpl.f49985h;
        iMqttServiceImpl.f49985h = i11 + 1;
        return i11;
    }

    /* access modifiers changed from: private */
    public synchronized void q() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - initAfterConnected, encryptLevel:" + this.f49996t);
        if (!(this.f49982e == null || this.f49982e.getClientId() == null)) {
            try {
                this.f49982e.subscribe(this.f49996t == 1 ? this.f49997u == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.g(this.f49988l, this.f49982e.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.h(this.f49988l, this.f49982e.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.c(this.f49988l, this.f49982e.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.d(this.f49988l, this.f49982e.getClientId())} : this.f49997u == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.e(this.f49988l, this.f49982e.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.f(this.f49988l, this.f49982e.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.a(this.f49988l, this.f49982e.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.b(this.f49988l, this.f49982e.getClientId())}, new int[]{1, 1}, (Object) null, (IMqttActionListener) new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        IMqttServiceImpl.k(IMqttServiceImpl.this);
                        IMqttServiceImpl.this.stopConnect((IMqttCallback) null);
                        IMqttServiceImpl.this.o();
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error: ", th2);
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "subscribe INIT TOPIC success");
                        int unused = IMqttServiceImpl.this.f49985h = 0;
                        IMqttServiceImpl.this.a(MqttConnectState.SUBTOPICS);
                        IMqttServiceImpl.this.v();
                    }
                });
            } catch (Throwable th2) {
                this.f49985h++;
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error MqttException ", th2);
            }
        }
        return;
    }

    @SuppressLint({"HandlerLeak"})
    private void r() {
        if (this.f49992p == null) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "initHandler");
            this.f49992p = new Handler() {
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message != null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handler cmd: " + message.what);
                        int i11 = message.what;
                        if (i11 != 1) {
                            if (i11 == 2) {
                                IMqttServiceImpl.this.startConnect((IMqttCallback) null);
                            } else if (i11 == 1006) {
                                IMqttServiceImpl.this.s();
                            } else if (i11 == 1010) {
                                IMqttServiceImpl.this.a(1010, message);
                            } else if (i11 != 1011) {
                                switch (i11) {
                                    case 1001:
                                        IMqttServiceImpl.this.a(1001, message);
                                        return;
                                    case 1002:
                                        IMqttServiceImpl.this.a(1002, message);
                                        return;
                                    case 1003:
                                        IMqttServiceImpl.this.a(1003, message);
                                        return;
                                    default:
                                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "unknown handler msg = " + message.what);
                                        return;
                                }
                            } else {
                                try {
                                    IMqttServiceImpl.this.k();
                                } catch (Throwable th2) {
                                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "handle HANDLER_SEND_PING error " + message.what + l.f34627b + th2.toString());
                                }
                            }
                        } else if (com.tencent.tpns.mqttchannel.core.common.a.b.a(IMqttServiceImpl.this.f49988l)) {
                            IMqttServiceImpl.this.b((IMqttCallback) null);
                        } else {
                            com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "net Work is not alive, stop connect");
                        }
                    }
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handlePingTimeOut");
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                IMqttServiceImpl.this.t();
            }
        });
    }

    /* access modifiers changed from: private */
    public void t() {
        if (c()) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("TPush", "handlePingFailed mqtt is running");
            return;
        }
        try {
            if (this.G.isLocked()) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Handling ping failed, return this time");
            } else {
                this.G.lock();
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handlePingFailed");
                stopConnect((IMqttCallback) null);
                if (u()) {
                    startConnect((IMqttCallback) null);
                }
                try {
                    this.G.unlock();
                    Util.stopWakeCpu();
                } catch (Exception unused) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "pingLock Exception");
                }
            }
        } finally {
            try {
                this.G.unlock();
                Util.stopWakeCpu();
            } catch (Exception unused2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "pingLock Exception");
            }
        }
    }

    private boolean u() {
        if (Util.checkPermission(this.f49988l, "android.permission.INTERNET") && Util.checkPermission(this.f49988l, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f49988l.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return false;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void v() {
        try {
            if (this.D.size() > 0) {
                CommonWorkingThread.getInstance().remove((TTask) this.f50002z);
                CommonWorkingThread.getInstance().execute(this.f50002z);
                return;
            }
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "cacheMessages is empty ");
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendCachedMessage failed:", th2);
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action : sendCachedMessageInner");
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "Cache message length: " + this.D.size());
            while (true) {
                Request poll = this.D.poll();
                if (poll != null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action : sendCachedMessage " + poll);
                    a(poll);
                } else {
                    return;
                }
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendCachedMessage", th2);
        }
    }

    public void connectComplete(boolean z11, String str) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "connectComplete: " + str + ", reconnect:" + z11);
        this.f49998v.onConnectComplete(z11);
    }

    public void connectionLost(Throwable th2) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "connectionLost, cause:" + th2 + " retryCount:" + this.f49984g);
        th2.printStackTrace();
        a(MqttConnectState.DISCONNECTED);
        this.f49998v.onConnectionLost();
        o();
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - deliveryComplete");
    }

    public void getConnectState(IMqttCallback iMqttCallback) {
        if (b.CONNECTED == i()) {
            a(iMqttCallback, 0, this.f49983f.toString());
        } else {
            a(iMqttCallback, (int) ErrCode.MQTT_CONNECT_ERROR, this.f49983f.toString());
        }
    }

    public void isValidClientId(IMqttCallback iMqttCallback) {
        String tokenFromFile = GuidInfoManager.getTokenFromFile(this.f49988l);
        if (com.tencent.tpns.mqttchannel.core.common.a.b.a(tokenFromFile) || this.f49982e == null || !TextUtils.equals(tokenFromFile, this.f49982e.getClientId())) {
            b i11 = i();
            String str = null;
            if (!com.tencent.tpns.mqttchannel.core.common.a.b.a(tokenFromFile) && (b.CONNECTED == i11 || b.CONNECTING == i11)) {
                stopConnect((IMqttCallback) null);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("invalid clientId token:");
            sb2.append(tokenFromFile);
            sb2.append(" , clientId:");
            if (this.f49982e != null) {
                str = this.f49982e.getClientId();
            }
            sb2.append(str);
            a(iMqttCallback, -1, sb2.toString());
            return;
        }
        a(iMqttCallback, 0, "valid clientId");
    }

    public void messageArrived(String str, MqttMessage mqttMessage) {
        byte[] bArr;
        byte[] bArr2;
        if (mqttMessage == null) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived mqttMessage null");
        } else if (com.tencent.tpns.mqttchannel.core.common.a.b.i(this.f49988l, str) || com.tencent.tpns.mqttchannel.core.common.a.b.k(this.f49988l, str) || com.tencent.tpns.mqttchannel.core.common.a.b.m(this.f49988l, str) || com.tencent.tpns.mqttchannel.core.common.a.b.o(this.f49988l, str)) {
            try {
                if (com.tencent.tpns.mqttchannel.core.common.a.b.o(this.f49988l, str)) {
                    byte[] decryptSrvData = Security.decryptSrvData(mqttMessage.getPayload());
                    if (decryptSrvData == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                    bArr = CommonHelper.decodeGZipContent(decryptSrvData);
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response unzip after decrypt failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.a.b.m(this.f49988l, str)) {
                    bArr = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response unzip failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.a.b.k(this.f49988l, str)) {
                    bArr = Security.decryptSrvData(mqttMessage.getPayload());
                    if (bArr == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                } else {
                    bArr = mqttMessage.getPayload();
                }
                String str2 = new String(bArr);
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "MessageArrived, rpc topic :" + str + ", payload:" + str2);
                JSONObject jSONObject = new JSONObject(str2);
                long j11 = jSONObject.getLong("id");
                int optInt = jSONObject.optInt("ret", 0);
                String optString = jSONObject.optString("result", "");
                Pair remove = this.f49989m.remove(Long.valueOf(j11));
                if (remove != null) {
                    CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                    a((IMqttCallback) remove.first, optInt, optString);
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "Not found the rpc Request id");
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived handle RpcReceiveTopic throw JSONException " + th2.toString() + ", payload: " + new String(mqttMessage.getPayload()));
            }
        } else {
            if (com.tencent.tpns.mqttchannel.core.common.a.b.p(this.f49988l, str)) {
                byte[] decryptSrvData2 = Security.decryptSrvData(mqttMessage.getPayload());
                if (decryptSrvData2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
                bArr2 = CommonHelper.decodeGZipContent(decryptSrvData2);
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message unzip after decrypt failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.a.b.n(this.f49988l, str)) {
                bArr2 = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message unzip failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.a.b.l(this.f49988l, str)) {
                bArr2 = Security.decryptSrvData(mqttMessage.getPayload());
                if (bArr2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
            } else {
                bArr2 = mqttMessage.getPayload();
            }
            String str3 = new String(bArr2);
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "MessageArrived, topic :" + str + ", payload:" + str3);
            Request request = new Request(0, str, str3);
            this.f49998v.onMessageArrived(request.getTopic(), request.getContent());
        }
    }

    public void ping(IMqttCallback iMqttCallback) {
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                IMqttServiceImpl.this.l();
            }
        });
    }

    public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1001, request);
        }
        b(request, iMqttCallback);
    }

    public void sendRequest(Request request, IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRequest");
        if (this.f49993q || this.f49994r || this.f49995s) {
            g(iMqttCallback);
            return;
        }
        if (request.getId() > 0) {
            a(1010, request);
        }
        if (this.f49996t == 1) {
            if (this.f49997u == 1) {
                a(request, iMqttCallback, "_xg/rpc/send/gzip_aes");
            } else {
                a(request, iMqttCallback, "_xg/rpc/send/aes");
            }
        } else if (this.f49997u == 1) {
            a(request, iMqttCallback, "_xg/rpc/send/gzip");
        } else {
            a(request, iMqttCallback, "_xg/rpc/send");
        }
    }

    public void startConnect(IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - startConnect");
        if (com.tencent.tpns.mqttchannel.core.common.a.b.a(this.f49988l)) {
            b(iMqttCallback);
        } else {
            com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "net Work is not alive, stop connect");
        }
        if (this.f49999w) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", " reschedulePing");
            j();
            this.f49999w = false;
        }
    }

    public void stopConnect(IMqttCallback iMqttCallback) {
        d();
        this.f50000x.b(iMqttCallback);
    }

    public void subscrbie(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1002, request);
        }
        c(request, iMqttCallback);
    }

    public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1003, request);
        }
        d(request, iMqttCallback);
    }

    private void d() {
        try {
            if (this.f50000x == null) {
                com.tencent.tpns.mqttchannel.core.services.a.b bVar = new com.tencent.tpns.mqttchannel.core.services.a.b(this);
                this.f50000x = bVar;
                bVar.start();
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "MqttConnectTrigger satrt failed:" + th2);
        }
    }

    private void e() {
        try {
            if (this.B.size() > 0) {
                CommonWorkingThread.getInstance().execute(this.A);
            } else {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "connetCallbackList is empty");
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "callAllConnectBackSuccess failed:" + th2);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - callAllConnectBackSuccessInner");
        if (!com.tencent.tpns.mqttchannel.core.common.a.b.a(GuidInfoManager.getToken(this.f49988l))) {
            for (IMqttCallback a11 : this.B) {
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "callAllBackSucess");
                a(a11, 0, "success");
            }
        } else {
            g();
        }
        this.B.clear();
    }

    private void g() {
        for (IMqttCallback a11 : this.B) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "callAllConnectBackFailed");
            a(a11, (int) ErrCode.INNER_ERROR_TOKEN_NULL, "connect failed beacuse token is null");
        }
    }

    private void h() {
        int refuseRate = GuidInfoManager.getRefuseRate(this.f49988l);
        if (refuseRate <= 0 || new Random().nextInt(100) >= refuseRate) {
            this.f49994r = false;
            return;
        }
        this.f49994r = true;
        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "Resources exceeded Limit, refuse this connect!");
    }

    private b i() {
        if (this.f49982e == null) {
            return b.IDLE;
        }
        if (this.f49982e.isConnected() && (this.f49983f == MqttConnectState.CONNECTED || this.f49983f == MqttConnectState.SUBTOPICS)) {
            return b.CONNECTED;
        }
        if (this.f49982e.isConnecting()) {
            return b.CONNECTING;
        }
        return b.STOPED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance().execute(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r5 = this;
            android.os.Handler r0 = r5.f49992p     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0007
            r5.r()     // Catch:{ all -> 0x0038 }
        L_0x0007:
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$1 r0 = new com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$1     // Catch:{ all -> 0x0038 }
            r0.<init>()     // Catch:{ all -> 0x0038 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0030 }
            java.lang.Thread r1 = r1.getThread()     // Catch:{ all -> 0x0030 }
            long r1 = r1.getId()     // Catch:{ all -> 0x0030 }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
            long r3 = r3.getId()     // Catch:{ all -> 0x0030 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x002c
            com.tencent.tpns.baseapi.base.util.CommonWorkingThread r1 = com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance()     // Catch:{ all -> 0x0030 }
            r1.execute(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x0040
        L_0x002c:
            r0.run()     // Catch:{ all -> 0x0030 }
            goto L_0x0040
        L_0x0030:
            com.tencent.tpns.baseapi.base.util.CommonWorkingThread r1 = com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance()     // Catch:{ all -> 0x0038 }
            r1.execute(r0)     // Catch:{ all -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r0 = move-exception
            java.lang.String r1 = "IMqttServiceImpl"
            java.lang.String r2 = "schedulePing failed "
            com.tencent.tpns.mqttchannel.core.common.a.a.a(r1, r2, r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.j():void");
    }

    /* access modifiers changed from: private */
    public void k() {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "startNextPing");
            if (this.f49992p == null) {
                r();
            }
            if (MqttConfigImpl.keepAliveInterval == null || com.tencent.tpns.mqttchannel.core.common.a.b.f49966b == null) {
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        int keepAliveInterval = MqttConfigImpl.getKeepAliveInterval(IMqttServiceImpl.this.f49988l);
                        if (!IMqttServiceImpl.this.f49992p.hasMessages(1011)) {
                            Message obtainMessage = IMqttServiceImpl.this.f49992p.obtainMessage(1011);
                            obtainMessage.what = 1011;
                            IMqttServiceImpl.this.f49992p.sendMessageDelayed(obtainMessage, (long) (keepAliveInterval * 1000));
                        }
                        com.tencent.tpns.mqttchannel.core.common.a.b.b(IMqttServiceImpl.this.f49988l);
                    }
                });
            } else {
                try {
                    if (!this.f49992p.hasMessages(1011)) {
                        Message obtainMessage = this.f49992p.obtainMessage(1011);
                        obtainMessage.what = 1011;
                        this.f49992p.sendMessageDelayed(obtainMessage, (long) (MqttConfigImpl.keepAliveInterval.intValue() * 1000));
                    }
                    com.tencent.tpns.mqttchannel.core.common.a.b.c(this.f49988l);
                } catch (Throwable unused) {
                }
            }
            Util.getWakeCpu(this.f49988l);
            ping((IMqttCallback) null);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "startNextPing error: " + th2.toString());
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        b i11 = i();
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - ping: " + i11);
        try {
            int i12 = AnonymousClass10.f50004a[i11.ordinal()];
            if (i12 != 1) {
                if (i12 != 2) {
                    startConnect((IMqttCallback) null);
                    Util.stopWakeCpu();
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "The client is connecting");
                Util.stopWakeCpu();
            } else if (Math.abs(System.currentTimeMillis() - this.E) >= 15000) {
                m();
                b();
                this.f49982e.ping(new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Ping onFailure", th2);
                        IMqttServiceImpl.this.n();
                        IMqttServiceImpl.this.t();
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.n();
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "Ping succeed");
                        long unused = IMqttServiceImpl.this.E = System.currentTimeMillis();
                        Util.stopWakeCpu();
                    }
                });
            }
        } catch (Throwable th2) {
            n();
            Util.stopWakeCpu();
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "ping", th2);
        }
    }

    private void m() {
        this.f49992p.removeMessages(1006);
        this.f49992p.sendEmptyMessageDelayed(1006, 10000);
    }

    /* access modifiers changed from: private */
    public void n() {
        this.f49992p.removeMessages(1006);
    }

    /* access modifiers changed from: private */
    public void o() {
        try {
            CommonWorkingThread.getInstance().remove((TTask) this.f50001y);
            CommonWorkingThread.getInstance().execute(this.f50001y, 1000);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "tryRetryConnectDelay failed:" + th2);
        }
    }

    /* access modifiers changed from: private */
    public void p() {
        int i11;
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action tryRetryConnectDelayInner");
        int recons = CloudManager.getInstance(this.f49988l).getRecons();
        if (recons <= 0) {
            recons = f49980k;
        }
        this.f49984g++;
        if (this.f49984g > recons || this.f49985h > f49980k) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "tryReConnect too times, give up connect retryCount: " + this.f49984g + ", sub retryCount: " + this.f49985h);
            try {
                if (!f49978c) {
                    if (System.currentTimeMillis() - f49977b <= Period.MIN30_MILLS) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "get offline msg by HTTP time not reached");
                        return;
                    }
                }
                ArrayList<String> b11 = b(this.f49988l);
                if (b11 != null) {
                    if (b11.size() != 0) {
                        f49978c = false;
                        f49977b = System.currentTimeMillis();
                        Iterator<String> it2 = b11.iterator();
                        while (it2.hasNext()) {
                            Request request = new Request(0, "/_xg/push/" + XGApiConfig.getAccessId(this.f49988l) + "/" + GuidInfoManager.getToken(this.f49988l), it2.next());
                            this.f49998v.onMessageArrived(request.getTopic(), request.getContent());
                        }
                        return;
                    }
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "can't get any offline msg");
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "request for offline msg by http error", th2);
            }
        } else {
            Message obtainMessage = this.f49992p.obtainMessage(1);
            this.f49992p.removeMessages(1);
            int max = Math.max(this.f49984g, this.f49985h);
            if (max > this.f49987j.length) {
                i11 = this.f49987j[this.f49987j.length - 1];
            } else {
                i11 = this.f49987j[max - 1];
            }
            long j11 = (long) (i11 * 1000);
            if (DeviceInfos.isScreenOn(this.f49988l) || DeviceInfos.getChangedStatus(this.f49988l) > 0) {
                j11 /= 2;
            }
            this.f49992p.sendMessageDelayed(obtainMessage, j11);
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "tryReConnect -> retryCount:" + this.f49984g + ", subRetryCount:" + this.f49985h + ", delay:" + j11);
        }
    }

    private Request c(Long l11) {
        for (Request request : this.D) {
            if (l11.longValue() == request.getId()) {
                return request;
            }
        }
        return null;
    }

    private IMqttCallback b(Long l11) {
        boolean z11 = false;
        try {
            Iterator it2 = this.D.iterator();
            while (it2.hasNext()) {
                if (l11.longValue() == ((Request) it2.next()).getId()) {
                    it2.remove();
                    z11 = true;
                }
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "removeCacheMessages", th2);
        }
        if (!z11) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "removeCacheMessages error id " + l11);
        }
        return a(l11);
    }

    private boolean c(IMqttCallback iMqttCallback) {
        if (i() == b.CONNECTED) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action:reConnect - CONNECTED");
            if (iMqttCallback != null) {
                a(iMqttCallback, 0, "success");
            }
            return false;
        } else if (!b(iMqttCallback, true)) {
            return false;
        } else {
            return d(iMqttCallback);
        }
    }

    private void g(IMqttCallback iMqttCallback) {
        if (this.f49993q) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed");
            a(iMqttCallback, -3, "connect onFailure: Resources have been destroyed");
        } else if (this.f49994r) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources exceeded limit");
            a(iMqttCallback, -4, "connect onFailure: Resources exceeded limit");
        } else if (this.f49995s) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed by cloud");
            a(iMqttCallback, -4, "connect onFailure: Resources have been destroyed by cloud");
        }
    }

    private boolean d(IMqttCallback iMqttCallback) {
        if (!b(iMqttCallback, true)) {
            return false;
        }
        boolean e11 = e(iMqttCallback);
        if (!e11) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "CreateMqttAsyncClientAndConnect failed");
        }
        return e11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x012a A[Catch:{ all -> 0x010c, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013b A[Catch:{ all -> 0x010c, all -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016e A[Catch:{ all -> 0x01a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x017f A[Catch:{ all -> 0x01a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f49981a
            monitor-enter(r0)
            r1 = 0
            boolean r2 = r10.b((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11, (boolean) r1)     // Catch:{ all -> 0x0234 }
            if (r2 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x000c:
            if (r11 == 0) goto L_0x0011
            r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11)     // Catch:{ all -> 0x0234 }
        L_0x0011:
            r2 = 1
            r10.a((boolean) r2)     // Catch:{ all -> 0x0234 }
            boolean r3 = r10.f49993q     // Catch:{ all -> 0x0234 }
            if (r3 != 0) goto L_0x0227
            boolean r3 = r10.f49994r     // Catch:{ all -> 0x0234 }
            if (r3 == 0) goto L_0x001f
            goto L_0x0227
        L_0x001f:
            com.tencent.tpns.mqttchannel.api.MqttConnectState r3 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTING     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r3)     // Catch:{ all -> 0x0234 }
            android.content.Context r3 = r10.f49988l     // Catch:{ all -> 0x0234 }
            r4 = 0
            com.tencent.tpns.baseapi.base.device.GUIDInfo r3 = com.tencent.tpns.baseapi.base.device.GuidInfoManager.getFinalGuidInfo(r3, r1, r4)     // Catch:{ all -> 0x0234 }
            if (r3 == 0) goto L_0x0206
            boolean r5 = r3.isError()     // Catch:{ all -> 0x0234 }
            if (r5 == 0) goto L_0x0035
            goto L_0x0206
        L_0x0035:
            android.content.Context r5 = r10.f49988l     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.baseapi.base.util.CloudManager r5 = com.tencent.tpns.baseapi.base.util.CloudManager.getInstance(r5)     // Catch:{ all -> 0x0234 }
            boolean r5 = r5.shouldRefuse()     // Catch:{ all -> 0x0234 }
            r10.f49995s = r5     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "IMqttServiceImpl"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r6.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r7 = "Mqtt cloudRefuse: "
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            boolean r7 = r10.f49995s     // Catch:{ all -> 0x0234 }
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r5, r6)     // Catch:{ all -> 0x0234 }
            boolean r5 = r10.f49995s     // Catch:{ all -> 0x0234 }
            if (r5 == 0) goto L_0x006a
            r10.g((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11)     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r11 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTFAIL     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r11)     // Catch:{ all -> 0x0234 }
            r10.a((boolean) r1)     // Catch:{ all -> 0x0234 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x006a:
            int r5 = r3.encrypt     // Catch:{ all -> 0x0234 }
            r10.f49996t = r5     // Catch:{ all -> 0x0234 }
            android.content.Context r5 = r10.f49988l     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.baseapi.base.util.CloudManager r5 = com.tencent.tpns.baseapi.base.util.CloudManager.getInstance(r5)     // Catch:{ all -> 0x0234 }
            int r5 = r5.getCompressLevel()     // Catch:{ all -> 0x0234 }
            r10.f49997u = r5     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "IMqttServiceImpl"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r6.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r7 = "update encryptLevel: "
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            int r7 = r10.f49996t     // Catch:{ all -> 0x0234 }
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            java.lang.String r7 = ", compressLevel: "
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            int r7 = r10.f49997u     // Catch:{ all -> 0x0234 }
            r6.append(r7)     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.core.common.a.a.c(r5, r6)     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = r3.mqttServerIP     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = "IMqttServiceImpl"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r7.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r8 = "Finally get finalMqttServerAddr = "
            r7.append(r8)     // Catch:{ all -> 0x0234 }
            r7.append(r5)     // Catch:{ all -> 0x0234 }
            java.lang.String r8 = ""
            r7.append(r8)     // Catch:{ all -> 0x0234 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r6, r7)     // Catch:{ all -> 0x0234 }
            android.content.Context r6 = r10.f49988l     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = com.tencent.tpns.baseapi.XGApiConfig.getDebugMQTTServer(r6)     // Catch:{ all -> 0x0234 }
            boolean r6 = com.tencent.tpns.mqttchannel.core.common.a.b.a((java.lang.String) r6)     // Catch:{ all -> 0x0234 }
            if (r6 != 0) goto L_0x00cb
            android.content.Context r5 = r10.f49988l     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = com.tencent.tpns.baseapi.XGApiConfig.getDebugMQTTServer(r5)     // Catch:{ all -> 0x0234 }
        L_0x00cb:
            java.lang.String r6 = "IMqttServiceImpl"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r7.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r8 = "doMqttConnect -> connecting host: "
            r7.append(r8)     // Catch:{ all -> 0x0234 }
            r7.append(r5)     // Catch:{ all -> 0x0234 }
            java.lang.String r8 = ", state: "
            r7.append(r8)     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r8 = r10.f49983f     // Catch:{ all -> 0x0234 }
            r7.append(r8)     // Catch:{ all -> 0x0234 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r6, r7)     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = "IMqttServiceImpl"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r7.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r8 = "Mqtt clientId: "
            r7.append(r8)     // Catch:{ all -> 0x01cb }
            java.lang.String r8 = r3.token     // Catch:{ all -> 0x01cb }
            r7.append(r8)     // Catch:{ all -> 0x01cb }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01cb }
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r6, r7)     // Catch:{ all -> 0x01cb }
            com.tencent.android.tpns.mqtt.MqttAsyncClient r6 = r10.f49982e     // Catch:{ all -> 0x01cb }
            if (r6 == 0) goto L_0x0127
            boolean r6 = r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r4, (boolean) r2)     // Catch:{ all -> 0x010c }
            goto L_0x0128
        L_0x010c:
            r6 = move-exception
            java.lang.String r7 = "IMqttServiceImpl"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01cb }
            r8.<init>()     // Catch:{ all -> 0x01cb }
            java.lang.String r9 = "unexpected for release mqttAsyncClient"
            r8.append(r9)     // Catch:{ all -> 0x01cb }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x01cb }
            r8.append(r6)     // Catch:{ all -> 0x01cb }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x01cb }
            com.tencent.tpns.mqttchannel.core.common.a.a.a(r7, r6)     // Catch:{ all -> 0x01cb }
        L_0x0127:
            r6 = r1
        L_0x0128:
            if (r6 == 0) goto L_0x013b
            java.lang.String r6 = "IMqttServiceImpl"
            java.lang.String r7 = "connecting -  wait disconnect complete..."
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r6, r7)     // Catch:{ all -> 0x01cb }
            com.tencent.tpns.mqttchannel.core.services.a.b r6 = r10.f50000x     // Catch:{ all -> 0x01cb }
            if (r6 == 0) goto L_0x0142
            r7 = -1
            r6.a((long) r7)     // Catch:{ all -> 0x01cb }
            goto L_0x0142
        L_0x013b:
            java.lang.String r6 = "IMqttServiceImpl"
            java.lang.String r7 = "do connecting..."
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r6, r7)     // Catch:{ all -> 0x01cb }
        L_0x0142:
            com.tencent.android.tpns.mqtt.MqttAsyncClient r6 = r10.f49982e     // Catch:{ all -> 0x01cb }
            r10.a((com.tencent.android.tpns.mqtt.MqttAsyncClient) r6)     // Catch:{ all -> 0x01cb }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r6 = com.tencent.tpns.mqttchannel.api.MqttConnectState.DISCONNECTED     // Catch:{ all -> 0x01cb }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r6)     // Catch:{ all -> 0x01cb }
            com.tencent.android.tpns.mqtt.MqttAsyncClient r6 = new com.tencent.android.tpns.mqtt.MqttAsyncClient     // Catch:{ all -> 0x01cb }
            java.lang.String r7 = r3.token     // Catch:{ all -> 0x01cb }
            com.tencent.android.tpns.mqtt.persist.MemoryPersistence r8 = new com.tencent.android.tpns.mqtt.persist.MemoryPersistence     // Catch:{ all -> 0x01cb }
            r8.<init>()     // Catch:{ all -> 0x01cb }
            r6.<init>(r5, r7, r8, r4)     // Catch:{ all -> 0x01cb }
            r10.f49982e = r6     // Catch:{ all -> 0x01cb }
            com.tencent.android.tpns.mqtt.MqttConnectOptions r4 = new com.tencent.android.tpns.mqtt.MqttConnectOptions     // Catch:{ all -> 0x0234 }
            r4.<init>()     // Catch:{ all -> 0x0234 }
            r4.setAutomaticReconnect(r1)     // Catch:{ all -> 0x0234 }
            r4.setCleanSession(r2)     // Catch:{ all -> 0x0234 }
            java.lang.String r6 = r3.userName     // Catch:{ all -> 0x0234 }
            r4.setUserName(r6)     // Catch:{ all -> 0x0234 }
            java.lang.String r3 = r3.passWord     // Catch:{ all -> 0x0234 }
            if (r3 == 0) goto L_0x0175
            char[] r3 = r3.toCharArray()     // Catch:{ all -> 0x0234 }
            r4.setPassword(r3)     // Catch:{ all -> 0x0234 }
        L_0x0175:
            android.content.Context r3 = r10.f49988l     // Catch:{ all -> 0x0234 }
            int r3 = com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl.getKeepAliveInterval(r3)     // Catch:{ all -> 0x0234 }
            r6 = 60
            if (r3 >= r6) goto L_0x0180
            r3 = r6
        L_0x0180:
            r4.setKeepAliveInterval(r3)     // Catch:{ all -> 0x0234 }
            com.tencent.android.tpns.mqtt.MqttAsyncClient r3 = r10.f49982e     // Catch:{ all -> 0x01a0 }
            r3.setCallback(r10)     // Catch:{ all -> 0x01a0 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r3 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTING     // Catch:{ all -> 0x01a0 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r3)     // Catch:{ all -> 0x01a0 }
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x01a0 }
            r3[r1] = r5     // Catch:{ all -> 0x01a0 }
            r4.setServerURIs(r3)     // Catch:{ all -> 0x01a0 }
            com.tencent.android.tpns.mqtt.MqttAsyncClient r3 = r10.f49982e     // Catch:{ all -> 0x01a0 }
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$14 r5 = new com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$14     // Catch:{ all -> 0x01a0 }
            r5.<init>()     // Catch:{ all -> 0x01a0 }
            r3.connect(r4, r11, r5)     // Catch:{ all -> 0x01a0 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r2
        L_0x01a0:
            r2 = move-exception
            r10.a((boolean) r1)     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r3 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTFAIL     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r3)     // Catch:{ all -> 0x0234 }
            java.lang.String r3 = "IMqttServiceImpl"
            java.lang.String r4 = "doMqttConnect mqtt client connect error:"
            com.tencent.tpns.mqttchannel.core.common.a.a.a(r3, r4, r2)     // Catch:{ all -> 0x0234 }
            r3 = -1101(0xfffffffffffffbb3, float:NaN)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r4.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "mqtt client connect error: "
            r4.append(r5)     // Catch:{ all -> 0x0234 }
            r4.append(r2)     // Catch:{ all -> 0x0234 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11, (int) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0234 }
            r10.o()     // Catch:{ all -> 0x0234 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x01cb:
            r2 = move-exception
            r10.a((boolean) r1)     // Catch:{ all -> 0x0234 }
            java.lang.String r3 = "IMqttServiceImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r4.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "create mqtt client error, e:"
            r4.append(r5)     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0234 }
            r4.append(r5)     // Catch:{ all -> 0x0234 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.core.common.a.a.a(r3, r4, r2)     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r3 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTFAIL     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r3)     // Catch:{ all -> 0x0234 }
            r3 = -1102(0xfffffffffffffbb2, float:NaN)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0234 }
            r4.<init>()     // Catch:{ all -> 0x0234 }
            java.lang.String r5 = "create mqtt client error "
            r4.append(r5)     // Catch:{ all -> 0x0234 }
            r4.append(r2)     // Catch:{ all -> 0x0234 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11, (int) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0234 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x0206:
            if (r3 != 0) goto L_0x020f
            r2 = -5
            java.lang.String r3 = "getFinalMqttServerAddrAndGuidInfo GUID is null"
            r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11, (int) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0234 }
            goto L_0x0216
        L_0x020f:
            int r2 = r3.errCode     // Catch:{ all -> 0x0234 }
            java.lang.String r3 = r3.result     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11, (int) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0234 }
        L_0x0216:
            com.tencent.tpns.mqttchannel.api.MqttConnectState r11 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTFAIL     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r11)     // Catch:{ all -> 0x0234 }
            java.lang.String r11 = "IMqttServiceImpl"
            java.lang.String r2 = "doMqttConnect -> connecting falied with null guid  "
            com.tencent.tpns.mqttchannel.core.common.a.a.b(r11, r2)     // Catch:{ all -> 0x0234 }
            r10.a((boolean) r1)     // Catch:{ all -> 0x0234 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x0227:
            r10.g((com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback) r11)     // Catch:{ all -> 0x0234 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r11 = com.tencent.tpns.mqttchannel.api.MqttConnectState.CONNECTFAIL     // Catch:{ all -> 0x0234 }
            r10.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r11)     // Catch:{ all -> 0x0234 }
            r10.a((boolean) r1)     // Catch:{ all -> 0x0234 }
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            return r1
        L_0x0234:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0234 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.e(com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback):boolean");
    }

    private void d(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - unSubscrbieReal");
        int i11 = AnonymousClass10.f50004a[i().ordinal()];
        if (i11 == 1) {
            try {
                this.f49982e.unsubscribe(request.getTopic(), (Object) null, (IMqttActionListener) new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "unSubscrbie -> callback onFailure:", th2);
                        IMqttServiceImpl.this.b(1003, request);
                        IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                        IMqttCallback iMqttCallback = iMqttCallback;
                        iMqttServiceImpl.a(iMqttCallback, -10, "unSubscrbie onFailure: " + th2.toString());
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.b(1003, request);
                        IMqttServiceImpl.this.a(iMqttCallback, 0, "success");
                    }
                });
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th2);
                a(iMqttCallback, -1001, "unSubscrbie error " + th2);
            }
        } else if (i11 != 2) {
            a(request, iMqttCallback);
            startConnect((IMqttCallback) null);
        } else {
            a(request, iMqttCallback);
        }
    }

    /* access modifiers changed from: private */
    public void f(IMqttCallback iMqttCallback) {
        if (iMqttCallback != null && this.B.remove(iMqttCallback)) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "remove old callback success");
        }
        e();
    }

    private void a(IMqttCallback iMqttCallback) {
        if (this.B.size() > 100) {
            this.B.remove(0);
        }
        this.B.add(iMqttCallback);
    }

    private void c(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - subscrbieReal");
        int i11 = AnonymousClass10.f50004a[i().ordinal()];
        if (i11 == 1) {
            try {
                this.f49982e.subscribe(request.getTopic(), 1, (Object) null, (IMqttActionListener) new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie -> callback onFailure:", th2);
                        IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                        IMqttCallback iMqttCallback = iMqttCallback;
                        iMqttServiceImpl.a(iMqttCallback, -9, "subscribe onFailure: " + th2.toString());
                        IMqttServiceImpl.this.b(1002, request);
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.a(iMqttCallback, 0, "success");
                        IMqttServiceImpl.this.b(1002, request);
                    }
                });
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th2);
                a(iMqttCallback, (int) ErrCode.MQTT_SUB_ERROR, "subscrbie error " + th2);
            }
        } else if (i11 != 2) {
            a(request, iMqttCallback);
            startConnect((IMqttCallback) null);
        } else {
            a(request, iMqttCallback);
        }
    }

    /* access modifiers changed from: private */
    public void b(IMqttCallback iMqttCallback) {
        d();
        this.f50000x.a(iMqttCallback);
    }

    private static void a(Long l11, IMqttCallback iMqttCallback) {
        try {
            if (C.size() > 2000) {
                ArrayList arrayList = new ArrayList(C.keySet());
                Collections.sort(arrayList);
                C.remove(arrayList.get(0));
            }
            C.put(l11, iMqttCallback);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "putTagAliasCallback", th2);
        }
    }

    public boolean b(com.tencent.tpns.mqttchannel.core.services.a.a aVar) {
        if (aVar != null) {
            return a(aVar.f50050c, false);
        }
        return a((IMqttCallback) null, false);
    }

    private boolean b(IMqttCallback iMqttCallback, boolean z11) {
        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "doMqttConnect -> try connect, state: " + this.f49983f + ", MQTTStatus:" + i());
        if (i() == b.CONNECTED && (this.f49983f == MqttConnectState.CONNECTED || this.f49983f == MqttConnectState.SUBTOPICS)) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt already connected, give up");
            if (iMqttCallback != null) {
                a(iMqttCallback, 0, "success");
            }
            return false;
        } else if (!z11 || !c()) {
            return true;
        } else {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt is connecting, give up");
            if (iMqttCallback != null) {
                a(iMqttCallback);
            }
            return false;
        }
    }

    public boolean c() {
        return this.F;
    }

    private static IMqttCallback a(Long l11) {
        try {
            return C.remove(l11);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "getTagAliasCallback", th2);
            return null;
        }
    }

    private void a(Request request, IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "addCacheMessage " + request);
        try {
            this.D.offer(request);
            if (this.D.size() > 100) {
                this.D.poll();
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "addCacheMessage", th2);
        }
        if (request.getId() > 0 && iMqttCallback != null) {
            a(Long.valueOf(request.getId()), iMqttCallback);
        }
    }

    /* access modifiers changed from: private */
    public void b(MqttAsyncClient mqttAsyncClient) {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "destroyMqttClient");
            if (mqttAsyncClient != null) {
                mqttAsyncClient.shutdownConnection();
                mqttAsyncClient.destroy();
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "stopConnect close error:", th2);
        }
        if (this.f49982e != mqttAsyncClient) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "destroyMqttClient already a new mqttAsyncClient");
            this.f49982e = null;
            return;
        }
        a(MqttConnectState.DISCONNECTED);
        this.f49999w = true;
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                if (!XGApiConfig.isEnableService(IMqttServiceImpl.this.f49988l)) {
                    IMqttServiceImpl.this.f49992p.removeCallbacksAndMessages((Object) null);
                    com.tencent.tpns.mqttchannel.core.common.a.b.d(IMqttServiceImpl.this.f49988l);
                    Util.killPushProcess(IMqttServiceImpl.this.f49988l);
                }
            }
        });
    }

    private boolean a(Context context) {
        try {
            this.f49991o = Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            Intent intent = new Intent(context, this.f49991o);
            intent.setPackage(context.getPackageName());
            try {
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 512);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, querey intent info is null or empty");
                    return false;
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Has Xgpush!!!");
                return true;
            } catch (Throwable unused) {
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, querey intent fail");
                return false;
            }
        } catch (Throwable unused2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, Not found xgpush class");
            return false;
        }
    }

    private void b(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRealPublishData");
        int i11 = AnonymousClass10.f50004a[i().ordinal()];
        if (i11 == 1) {
            try {
                if (this.f49982e.getClientId() == null) {
                    a(iMqttCallback, (int) ErrCode.INNER_ERROR_TOKEN_NULL, "sendPublishData token is null");
                    return;
                }
                request.setToken(this.f49982e.getClientId());
                MqttMessage mqttMessage = new MqttMessage(request.getContent().getBytes());
                mqttMessage.setQos(1);
                this.f49982e.publish(request.getTopic(), mqttMessage, (Object) null, (IMqttActionListener) new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        IMqttServiceImpl.this.b(1001, request);
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData -> callback onFailure:", th2);
                        IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                        IMqttCallback iMqttCallback = iMqttCallback;
                        iMqttServiceImpl.a(iMqttCallback, -8, "sendPublishData onFailure: " + th2.toString());
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.b(1001, request);
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData success, body: " + request.getContent());
                        IMqttServiceImpl.this.a(iMqttCallback, 0, "success");
                    }
                });
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData error MqttException ", th2);
                a(iMqttCallback, (int) ErrCode.MQTT_SEND_PUB_ERROR, "sendPublishData error: " + th2);
            }
        } else if (i11 != 2) {
            a(request, iMqttCallback);
            startConnect((IMqttCallback) null);
        } else {
            a(request, iMqttCallback);
        }
    }

    public IMqttServiceImpl(Context context, BaseMqttClientService baseMqttClientService) {
        this.f49988l = context;
        this.f49998v = baseMqttClientService;
        this.f49990n = a(context);
        this.f49993q = GuidInfoManager.isServerDestroy(context);
        h();
        this.f49996t = GuidInfoManager.getEncryptLevel(context);
        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.f49996t + ", compressLevel: " + this.f49997u);
        d();
        if (this.f49992p == null) {
            r();
        }
        j();
    }

    public boolean a(com.tencent.tpns.mqttchannel.core.services.a.a aVar) {
        if (aVar != null) {
            return c(aVar.f50050c);
        }
        return c((IMqttCallback) null);
    }

    public void a(MqttAsyncClient mqttAsyncClient) {
        try {
            mqttAsyncClient.shutdownConnection();
            mqttAsyncClient.destroy();
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "destoryInvideMqttClient failed:" + th2);
        }
    }

    public boolean a(final IMqttCallback iMqttCallback, final boolean z11) {
        int reasonCode;
        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "stopConnect current connectState " + this.f49983f);
        if (this.f49983f != MqttConnectState.CONNECTED && this.f49983f != MqttConnectState.CONNECTING && this.f49983f != MqttConnectState.SUBTOPICS) {
            String str = "Mqtt is not connected： " + this.f49983f;
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", str);
            a(iMqttCallback, 0, str);
            return false;
        } else if (this.f49982e == null) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "stopConnect error: mqttAsyncClient is null");
            a(iMqttCallback, (int) ErrCode.MQTT_DISCONNECT_FAIL_NULL, "stopConnect error: mqttAsyncClient is null");
            return false;
        } else {
            try {
                if (!this.f49982e.isConnected()) {
                    if (!this.f49982e.isConnecting()) {
                        return false;
                    }
                }
                this.f49982e.disconnect(10000, this.f49982e, new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "stopConnect -> callback onFailure:", th2);
                        IMqttServiceImpl.this.b(iMqttToken.getUserContext() instanceof MqttAsyncClient ? (MqttAsyncClient) iMqttToken.getUserContext() : null);
                        iMqttToken.setUserContext((Object) null);
                        IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                        IMqttCallback iMqttCallback = iMqttCallback;
                        iMqttServiceImpl.a(iMqttCallback, -6, "stopConnect onFailure: " + th2.toString());
                        if (z11) {
                            if (IMqttServiceImpl.this.f50000x != null) {
                                IMqttServiceImpl.this.f50000x.b();
                            }
                        } else if (IMqttServiceImpl.this.f50000x != null) {
                            IMqttServiceImpl.this.f50000x.a();
                        }
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "disconnect success");
                        IMqttServiceImpl.this.b(iMqttToken.getUserContext() instanceof MqttAsyncClient ? (MqttAsyncClient) iMqttToken.getUserContext() : null);
                        iMqttToken.setUserContext((Object) null);
                        IMqttServiceImpl.this.a(iMqttCallback, 0, "success");
                        if (z11) {
                            IMqttServiceImpl.this.f50000x.b();
                        } else {
                            IMqttServiceImpl.this.f50000x.a();
                        }
                    }
                });
                return true;
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "stopConnect error MqttException " + th2);
                if (!(th2 instanceof MqttException) || !((reasonCode = th2.getReasonCode()) == 32111 || reasonCode == 32101 || reasonCode == 32102)) {
                    b(this.f49982e);
                    a(iMqttCallback, (int) ErrCode.MQTT_DISCONNECT_ERROR, "stopConnect error MqttException: " + th2);
                    return false;
                }
                String str2 = "stopConnect MqttException " + th2;
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", str2);
                b(this.f49982e);
                a(iMqttCallback, (int) ErrCode.MQTT_DISCONNECT_ERROR, str2);
                return false;
            }
        }
    }

    public void b() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "onHeartBeat ");
        if (this.f49982e != null && !this.f49982e.isConnected()) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "onHeartBeat: mqttAsyncClient not connect!");
            a(MqttConnectState.DISCONNECTED);
            b((IMqttCallback) null);
        }
        this.f49998v.onHeartBeat();
    }

    /* access modifiers changed from: private */
    public void b(int i11, Request request) {
        this.f49992p.removeMessages(i11, request);
        b(Long.valueOf(request.getId()));
    }

    private ArrayList<String> b(Context context) {
        if (!Util.checkAccessId(XGApiConfig.getAccessId(context)) || !Util.checkAccessKey(XGApiConfig.getAccessKey(context)) || com.tencent.tpns.mqttchannel.core.common.a.b.a(GuidInfoManager.getToken(context)) || CloudManager.getInstance(context).disablePullMsg()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long accessId = XGApiConfig.getAccessId(context);
        String accessKey = XGApiConfig.getAccessKey(context);
        try {
            jSONObject.put("accessId", accessId);
            jSONObject.put("accessKey", accessKey);
            jSONObject.put("deviceType", 0);
            jSONObject.put("sdkVersion", "1.4.4.2");
            jSONObject.put("seq", currentTimeMillis);
            String token = GuidInfoManager.getToken(context);
            if (token != null) {
                jSONObject.put("token", token);
            }
            JSONArray jSONArray = new JSONArray();
            String notifiedMsgIds = Util.getNotifiedMsgIds(context, accessId);
            if (notifiedMsgIds != null && notifiedMsgIds.length() > 0) {
                String packageName = context.getPackageName();
                String[] split = notifiedMsgIds.split(packageName + TIMMentionEditText.TIM_MENTION_TAG);
                int length = split.length;
                for (int i11 = 0; i11 < length; i11++) {
                    try {
                        jSONArray.put(Long.parseLong(split[i11].substring(1)));
                    } catch (Throwable unused) {
                    }
                }
            }
            jSONObject.put("recMsgIdList", jSONArray);
            jSONObject.put("protocolVersion", 1);
            String offlineMsg = CommonHelper.getOfflineMsg(context, XGApiConfig.getOfflineMsgServerAddr(context), jSONObject.toString(), (HttpRequestCallback) null);
            if (offlineMsg == null || offlineMsg.length() <= 0) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "get offline msg http request error");
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(offlineMsg);
                int optInt = jSONObject2.optInt("retCode");
                if (optInt != 0) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "get offline msg error with retCode: " + optInt + ", msg: " + jSONObject2.optString(RemoteMessageConst.MessageBody.MSG));
                    return null;
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("msgList");
                ArrayList<String> arrayList = new ArrayList<>();
                if (optJSONArray == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "no offline msg send to this package");
                } else {
                    com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "get offline msg number: " + optJSONArray.length());
                    for (int i12 = 0; i12 < optJSONArray.length(); i12++) {
                        arrayList.add(optJSONArray.optJSONObject(i12).toString());
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "parse offline msg response error: ", th2);
                return null;
            }
        } catch (Throwable th3) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "generate offline msg request error: ", th3);
            return null;
        }
    }

    public void a(MqttConnectState mqttConnectState) {
        this.f49983f = mqttConnectState;
    }

    /* access modifiers changed from: private */
    public void a(Request request, IMqttCallback iMqttCallback, String str) {
        byte[] bArr;
        final Request request2 = request;
        final IMqttCallback iMqttCallback2 = iMqttCallback;
        final String str2 = str;
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRealRequest");
        int i11 = AnonymousClass10.f50004a[i().ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                a(request, iMqttCallback);
                startConnect((IMqttCallback) null);
                return;
            }
            a(request, iMqttCallback);
        } else if (this.f49983f != MqttConnectState.SUBTOPICS) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "sub topic not finish!");
            a(request, iMqttCallback);
        } else if (this.f49982e.getClientId() == null) {
            a(iMqttCallback2, (int) ErrCode.INNER_ERROR_TOKEN_NULL, "sendRealRequest token is null");
        } else {
            request2.setToken(this.f49982e.getClientId());
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "sendRequest " + request2);
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", request.getId());
                jSONObject.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, request.getTopic());
                jSONObject.put("paramsMd5", request.getParamsMd5());
                jSONObject.put("params", new JSONObject(request.getContent()));
                AnonymousClass17 r12 = new TTask() {
                    public void TRun() {
                        IMqttServiceImpl.this.f49989m.remove(Long.valueOf(request2.getId()));
                        request2.addRetryCount();
                        if (request2.getRetryCount() <= 1) {
                            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "sendRealRequest timeout and retry, request:" + request2);
                            IMqttServiceImpl.this.a(request2, iMqttCallback2, str2);
                        } else if (request2.isSent) {
                            IMqttServiceImpl.this.a(iMqttCallback2, -2, "Waiting for server response timeout!");
                        } else {
                            IMqttServiceImpl.this.a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_TIMEOUT, "sendRequest timeout!");
                        }
                    }
                };
                this.f49989m.put(Long.valueOf(request.getId()), new Pair(iMqttCallback2, r12));
                CommonWorkingThread.getInstance().execute(r12, 10000);
                try {
                    if (str2.equals("_xg/rpc/send/gzip_aes")) {
                        String jSONObject2 = jSONObject.toString();
                        byte[] encodeGZipContent = CommonHelper.encodeGZipContent(jSONObject2.getBytes());
                        if (encodeGZipContent == null) {
                            a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_COMPRESS_FAIL, "sendRequest " + request.getTopic() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject2.length() + ", after: " + encodeGZipContent.length);
                        bArr = Security.encryptSrvData(encodeGZipContent);
                        if (bArr == null) {
                            a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_ENCRYPT_FAIL, "sendRequest " + request.getTopic() + " encrypt failed");
                            return;
                        }
                    } else if (str2.equals("_xg/rpc/send/gzip")) {
                        String jSONObject3 = jSONObject.toString();
                        byte[] encodeGZipContent2 = CommonHelper.encodeGZipContent(jSONObject3.getBytes());
                        if (encodeGZipContent2 == null) {
                            a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_COMPRESS_FAIL, "sendRequest " + request.getTopic() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject3.length() + ", after: " + encodeGZipContent2.length);
                        bArr = encodeGZipContent2;
                    } else if (str2.equals("_xg/rpc/send/aes")) {
                        bArr = Security.encryptSrvData(jSONObject.toString().getBytes());
                        if (bArr == null) {
                            a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_ENCRYPT_FAIL, "sendRequest " + request.getTopic() + " encrypt failed");
                            return;
                        }
                    } else {
                        bArr = jSONObject.toString().getBytes();
                    }
                    MqttMessage mqttMessage = new MqttMessage(bArr);
                    mqttMessage.setQos(1);
                    final Request request3 = request;
                    final String str3 = str;
                    final IMqttCallback iMqttCallback3 = iMqttCallback;
                    this.f49982e.publish(str2, mqttMessage, (Object) null, (IMqttActionListener) new IMqttActionListener() {
                        public void onFailure(IMqttToken iMqttToken, Throwable th2) {
                            IMqttServiceImpl.this.b(1010, request3);
                            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest -> callback onFailure:", th2);
                            Pair pair = (Pair) IMqttServiceImpl.this.f49989m.remove(Long.valueOf(request3.getId()));
                            if (pair != null) {
                                CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) pair.second);
                                IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                                IMqttCallback iMqttCallback = iMqttCallback3;
                                iMqttServiceImpl.a(iMqttCallback, -7, "sendRequest onFailure: " + th2.toString());
                                return;
                            }
                            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "onFailure but Not found the rpc Request id");
                        }

                        public void onSuccess(IMqttToken iMqttToken) {
                            request3.isSent = true;
                            int unused = IMqttServiceImpl.this.f49986i = 0;
                            IMqttServiceImpl.this.b(1010, request3);
                            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest onSuccess topic:" + str3 + " body: " + jSONObject.toString());
                        }
                    });
                } catch (Throwable th2) {
                    b(1010, request2);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest error MqttException ", th2);
                    Pair remove = this.f49989m.remove(Long.valueOf(request.getId()));
                    if (remove != null) {
                        CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                        if (this.f49986i >= 1) {
                            a(iMqttCallback2, (int) ErrCode.MQTT_SEND_REQ_ERROR, "sendRequest error: " + th2.toString());
                            return;
                        }
                        this.f49986i++;
                        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "stop connect and retry sendRequest");
                        stopConnect((IMqttCallback) null);
                        CommonWorkingThread.getInstance().execute(new TTask() {
                            public void TRun() {
                                IMqttServiceImpl.this.sendRequest(request2, iMqttCallback2);
                            }
                        }, 500);
                    }
                }
            } catch (JSONException e11) {
                b(1010, request2);
                a(iMqttCallback2, (int) ErrCode.INNER_ERROR_JSON, "sendRealRequest JSONException: " + e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(IMqttCallback iMqttCallback, int i11, String str) {
        if (iMqttCallback != null) {
            try {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - doCallback, code:" + i11 + ", message:" + str);
                iMqttCallback.handleCallback(i11, str);
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Callback code:" + i11 + ", message:" + str + " RemoteException:", th2);
            }
        }
    }

    private void a(int i11, Request request) {
        Message message = new Message();
        message.obj = request;
        message.what = i11;
        if (!this.f49992p.hasMessages(i11, Long.valueOf(request.getId()))) {
            this.f49992p.sendMessageDelayed(message, 30000);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, Message message) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handleTimeOut " + i11 + " obj : " + message.obj);
        try {
            long id2 = ((Request) message.obj).getId();
            Request c11 = c(Long.valueOf(id2));
            if (c11 != null && c11.type == 6) {
                this.f49989m.remove(Long.valueOf(c11.getId()));
            }
            final IMqttCallback b11 = b(Long.valueOf(id2));
            if (b11 != null) {
                f49979d.execute(new Runnable() {
                    public void run() {
                        IMqttServiceImpl.this.a(b11, (int) ErrCode.MQTT_CONNECT_TIMEOUT, "Mqtt is not connected, timeout");
                    }
                });
            }
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Unknown msg " + i11, th2);
        }
    }

    public void a(boolean z11) {
        this.F = z11;
    }

    private void a(Request request) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - handMQTTMsg");
        switch (request.type) {
            case 1:
                c(request, a(Long.valueOf(request.getId())));
                return;
            case 2:
                b(request, a(Long.valueOf(request.getId())));
                return;
            case 3:
                d(request, a(Long.valueOf(request.getId())));
                return;
            case 4:
                return;
            case 5:
                b(request, a(Long.valueOf(request.getId())));
                return;
            case 6:
                IMqttCallback a11 = a(Long.valueOf(request.getId()));
                if (this.f49996t == 1) {
                    if (this.f49997u == 1) {
                        a(request, a11, "_xg/rpc/send/gzip_aes");
                        return;
                    } else {
                        a(request, a11, "_xg/rpc/send/aes");
                        return;
                    }
                } else if (this.f49997u == 1) {
                    a(request, a11, "_xg/rpc/send/gzip");
                    return;
                } else {
                    a(request, a11, "_xg/rpc/send");
                    return;
                }
            default:
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "Error type of MQTTMessage");
                return;
        }
    }
}

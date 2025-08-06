package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient implements AidlApiClient {
    public static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f37895i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicInteger f37896j = new AtomicInteger(1);

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f37897k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    private static BinderAdapter f37898l;

    /* renamed from: m  reason: collision with root package name */
    private static BinderAdapter f37899m;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f37900a;

    /* renamed from: b  reason: collision with root package name */
    private String f37901b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientSettings f37902c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile IAIDLInvoke f37903d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ConnectionCallbacks f37904e;

    /* renamed from: f  reason: collision with root package name */
    private final OnConnectionFailedListener f37905f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f37906g = null;

    /* renamed from: h  reason: collision with root package name */
    private HuaweiApi.RequestHandler f37907h;
    public String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i11);
    }

    public static final class ConnectionResultWrapper {

        /* renamed from: a  reason: collision with root package name */
        private HuaweiApi.RequestHandler f37912a;

        /* renamed from: b  reason: collision with root package name */
        private ConnectionResult f37913b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f37912a = requestHandler;
            this.f37913b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f37913b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f37912a;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f37900a = context;
        this.f37902c = clientSettings;
        if (clientSettings != null) {
            this.f37901b = clientSettings.getAppID();
        }
        this.f37905f = onConnectionFailedListener;
        this.f37904e = connectionCallbacks;
    }

    private BinderAdapter.BinderCallBack d() {
        return new BinderAdapter.BinderCallBack() {
            public void onBinderFailed(int i11) {
                onBinderFailed(i11, (Intent) null);
            }

            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.b(1);
                BaseHmsClient.this.a(10);
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.b(1);
                RequestManager.getHandler().sendEmptyMessage(10013);
                if (BaseHmsClient.this.f37904e != null && !(BaseHmsClient.this.f37904e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f37904e.onConnectionSuspended(1);
                }
            }

            public void onTimedDisconnected() {
                BaseHmsClient.this.b(6);
                if (BaseHmsClient.this.f37904e != null && !(BaseHmsClient.this.f37904e instanceof HuaweiApi.RequestHandler)) {
                    BaseHmsClient.this.f37904e.onConnectionSuspended(1);
                }
            }

            public void onBinderFailed(int i11, Intent intent) {
                if (intent != null) {
                    Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                    if (activeActivity != null) {
                        HMSLog.i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                        long time = new Timestamp(System.currentTimeMillis()).getTime();
                        FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() {
                            public void binderCallBack(int i11) {
                                if (i11 != 0) {
                                    BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                                    IAIDLInvoke unused = BaseHmsClient.this.f37903d = null;
                                }
                            }
                        });
                        intent.putExtra("callId", time);
                        activeActivity.startActivity(intent);
                        return;
                    }
                    HMSLog.i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f37900a, 11, intent, 67108864)));
                    IAIDLInvoke unused = BaseHmsClient.this.f37903d = null;
                    return;
                }
                HMSLog.i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.a(new ConnectionResult(10, (PendingIntent) null));
                IAIDLInvoke unused2 = BaseHmsClient.this.f37903d = null;
            }
        };
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f37902c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f37899m;
            if (binderAdapter == null) {
                HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f37898l;
            if (binderAdapter2 == null) {
                HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        b(1);
        a(10);
    }

    private void f() {
        if (this.f37902c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f37899m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f37898l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i11) {
        a(i11, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f37903d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f37903d == null) {
            HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
            e();
            return;
        }
        onConnecting();
    }

    public final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(10011);
        ConnectionCallbacks connectionCallbacks = this.f37904e;
        if (connectionCallbacks != null && !(connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            connectionCallbacks.onConnected();
        }
    }

    public void disconnect() {
        int i11 = (this.f37902c.isUseInnerHms() ? f37897k : f37896j).get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + i11);
        if (i11 == 3) {
            f();
            b(1);
        } else if (i11 == 5) {
            b();
            b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f37902c.isUseInnerHms() + ", mInnerBinderAdapter:" + f37899m + ", mOuterBinderAdapter:" + f37898l);
        return this.f37902c.isUseInnerHms() ? f37899m : f37898l;
    }

    public List<String> getApiNameList() {
        return this.f37902c.getApiName();
    }

    public String getAppID() {
        return this.f37901b;
    }

    public ClientSettings getClientSettings() {
        return this.f37902c;
    }

    public int getConnectionStatus() {
        return (this.f37902c.isUseInnerHms() ? f37897k : f37896j).get();
    }

    public Context getContext() {
        return this.f37900a;
    }

    public String getCpID() {
        return this.f37902c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public String getPackageName() {
        return this.f37902c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    public IAIDLInvoke getService() {
        return this.f37903d;
    }

    public String getServiceAction() {
        HMSPackageManager instance = HMSPackageManager.getInstance(this.f37900a);
        if (this.f37902c.isUseInnerHms()) {
            return instance.getInnerServiceAction();
        }
        return instance.getServiceAction();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public SubAppInfo getSubAppInfo() {
        return this.f37902c.getSubAppID();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean isConnected() {
        return !this.f37902c.isUseInnerHms() ? f37896j.get() == 3 : f37897k.get() == 3;
    }

    public boolean isConnecting() {
        return (this.f37902c.isUseInnerHms() ? f37897k : f37896j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f37907h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f37903d = iAIDLInvoke;
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return HMSPackageManager.getInstance(this.f37900a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    public void b(int i11) {
        if (this.f37902c.isUseInnerHms()) {
            f37897k.set(i11);
        } else {
            f37896j.set(i11);
        }
    }

    public void connect(int i11, boolean z11) {
        a(i11, z11);
    }

    private void b() {
        synchronized (f37895i) {
            Handler handler = this.f37906g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f37906g = null;
            }
        }
    }

    public void a() {
        String innerHmsPkg = this.f37902c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        a(innerHmsPkg, serviceAction);
    }

    private void a(String str, String str2) {
        if (this.f37902c.isUseInnerHms()) {
            f37899m = InnerBinderAdapter.getInstance(this.f37900a, str2, str);
            if (isConnected()) {
                HMSLog.i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            }
            b(5);
            f37899m.binder(d());
            return;
        }
        f37898l = OuterBinderAdapter.getInstance(this.f37900a, str2, str);
        if (isConnected()) {
            HMSLog.i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
            return;
        }
        b(5);
        f37898l.binder(d());
    }

    private void b(AvailableAdapter availableAdapter, int i11) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f37900a, i11, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() {
                public void onComplete(int i11) {
                    if (i11 != 0 || !BaseHmsClient.this.c()) {
                        BaseHmsClient.this.a(i11);
                    } else {
                        BaseHmsClient.this.a();
                    }
                }
            });
        } else {
            a(26);
        }
    }

    private void a(int i11, boolean z11) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61100302 ======");
        int i12 = (this.f37902c.isUseInnerHms() ? f37897k : f37896j).get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + i12);
        if (z11 || !(i12 == 3 || i12 == 5)) {
            if (getMinApkVersion() > i11) {
                i11 = getMinApkVersion();
            }
            HMSLog.i("BaseHmsClient", "connect minVersion:" + i11 + " packageName:" + this.f37902c.getInnerHmsPkg());
            if (this.f37900a.getPackageName().equals(this.f37902c.getInnerHmsPkg())) {
                HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
                a();
            } else if (Util.isAvailableLibExist(this.f37900a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i11);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f37900a);
                HMSLog.i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    a();
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    b(availableAdapter, isHuaweiMobileServicesAvailable);
                } else if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                    a(availableAdapter, isHuaweiMobileServicesAvailable);
                } else {
                    HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    a(isHuaweiMobileServicesAvailable);
                }
            } else {
                int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f37900a, i11);
                HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
                if (isHuaweiMobileServicesAvailable2 == 0) {
                    a();
                } else {
                    a(isHuaweiMobileServicesAvailable2);
                }
            }
        }
    }

    private void a(AvailableAdapter availableAdapter, int i11) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i11 == 29) {
                i11 = 9;
            }
            a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f37900a, i11, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() {
                public void onComplete(int i11) {
                    BaseHmsClient.this.a(i11);
                }
            });
        } else {
            a(26);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + i11);
        Message message = new Message();
        message.what = 10012;
        message.obj = new ConnectionResultWrapper(this.f37907h, new ConnectionResult(i11));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f37905f;
        if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i11));
        }
    }

    /* access modifiers changed from: private */
    public void a(ConnectionResult connectionResult) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = 10012;
        HuaweiApi.RequestHandler requestHandler = this.f37907h;
        this.f37907h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f37905f;
        if (onConnectionFailedListener != null && !(onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            onConnectionFailedListener.onConnectionFailed(connectionResult);
        }
    }
}

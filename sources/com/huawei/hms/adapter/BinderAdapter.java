package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BinderAdapter implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f37717a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37718b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37719c;

    /* renamed from: d  reason: collision with root package name */
    private BinderCallBack f37720d;

    /* renamed from: e  reason: collision with root package name */
    private IBinder f37721e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f37722f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private boolean f37723g = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler f37724h = null;

    /* renamed from: i  reason: collision with root package name */
    private Handler f37725i = null;

    public interface BinderCallBack {
        void onBinderFailed(int i11);

        void onBinderFailed(int i11, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f37717a = context;
        this.f37718b = str;
        this.f37719c = str2;
    }

    private void c() {
        synchronized (this.f37722f) {
            Handler handler = this.f37724h;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
                this.f37724h = null;
            }
        }
    }

    private void d() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.getMsgDelayDisconnect()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 1800s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack b11 = BinderAdapter.this.f();
                if (b11 == null) {
                    return true;
                }
                b11.onTimedDisconnected();
                return true;
            }
        });
        this.f37725i = handler;
        handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), Period.MIN30_MILLS);
    }

    private void e() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        try {
            ComponentName componentName = new ComponentName(this.f37717a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack f11 = f();
            if (f11 != null) {
                f11.onBinderFailed(-1, intent);
            }
        } catch (RuntimeException e11) {
            HMSLog.e("BinderAdapter", "getBindFailPendingIntent failed " + e11.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public BinderCallBack f() {
        return this.f37720d;
    }

    private void g() {
        Handler handler = this.f37724h;
        if (handler != null) {
            handler.removeMessages(getConnTimeOut());
        } else {
            this.f37724h = new Handler(Looper.getMainLooper(), new Handler.Callback() {
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.getConnTimeOut()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.b();
                    return true;
                }
            });
        }
        this.f37724h.sendEmptyMessageDelayed(getConnTimeOut(), 10000);
    }

    private void h() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f37725i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
            }
        }
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack != null) {
            this.f37720d = binderCallBack;
            a();
        }
    }

    public int getConnTimeOut() {
        return 0;
    }

    public int getMsgDelayDisconnect() {
        return 0;
    }

    public String getServiceAction() {
        return this.f37718b;
    }

    public IBinder getServiceBinder() {
        return this.f37721e;
    }

    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.f37723g) {
            this.f37723g = false;
            return;
        }
        unBind();
        c();
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onNullBinding(componentName);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.f37721e = iBinder;
        c();
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onServiceConnected(componentName, iBinder);
        }
        d();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onServiceDisconnected(componentName);
        }
        h();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f37717a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            Handler handler = this.f37725i;
            if (handler != null) {
                handler.removeMessages(getMsgDelayDisconnect());
                this.f37725i.sendEmptyMessageDelayed(getMsgDelayDisconnect(), Period.MIN30_MILLS);
            }
        }
    }

    private void a() {
        if (TextUtils.isEmpty(this.f37718b) || TextUtils.isEmpty(this.f37719c)) {
            e();
        }
        Intent intent = new Intent(this.f37718b);
        try {
            intent.setPackage(this.f37719c);
        } catch (IllegalArgumentException unused) {
            HMSLog.e("BinderAdapter", "IllegalArgumentException when bindCoreService intent.setPackage");
            e();
        }
        synchronized (this.f37722f) {
            if (this.f37717a.bindService(intent, this, 1)) {
                g();
                return;
            }
            this.f37723g = true;
            e();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        BinderCallBack f11 = f();
        if (f11 != null) {
            f11.onBinderFailed(-1);
        }
    }
}

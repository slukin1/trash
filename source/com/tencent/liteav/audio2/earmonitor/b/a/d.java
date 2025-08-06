package com.tencent.liteav.audio2.earmonitor.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.audio2.earmonitor.a.a;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Integer> f21364a = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f21365b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.tencent.liteav.audio2.earmonitor.a.a f21366c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f21367d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f21368e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public IBinder f21369f = null;

    /* renamed from: g  reason: collision with root package name */
    private ServiceConnection f21370g = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.liteav.audio2.earmonitor.a.a unused = d.this.f21366c = a.C0165a.a(iBinder);
            if (d.this.f21366c != null) {
                boolean unused2 = d.this.f21367d = true;
                d.this.f21368e.a(0);
                d dVar = d.this;
                d.a(dVar, dVar.f21365b.getPackageName(), "1.0.1");
                d.a(d.this, iBinder);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.tencent.liteav.audio2.earmonitor.a.a unused = d.this.f21366c = null;
            boolean unused2 = d.this.f21367d = false;
            d.this.f21368e.a(4);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public IBinder.DeathRecipient f21371h = new IBinder.DeathRecipient() {
        public final void binderDied() {
            d.this.f21369f.unlinkToDeath(d.this.f21371h, 0);
            d.this.f21368e.a(6);
            LiteavLog.e("HwAudioKit.HwAudioKit", "service binder died");
            IBinder unused = d.this.f21369f = null;
        }
    };

    public enum a {
        ;
        
        public int mFeatureType;

        private a(int i11) {
            this.mFeatureType = 1;
        }
    }

    public d(Context context, e eVar) {
        b a11 = b.a();
        this.f21368e = a11;
        a11.f21350a = eVar;
        this.f21365b = context;
    }

    public final void b() {
        if (this.f21367d) {
            this.f21367d = false;
            b.a(this.f21365b, this.f21370g);
        }
    }

    public final void a() {
        Context context = this.f21365b;
        if (context == null) {
            this.f21368e.a(7);
        } else if (!b.a(context)) {
            this.f21368e.a(2);
        } else {
            Context context2 = this.f21365b;
            if (this.f21368e != null && !this.f21367d) {
                b.a(context2, this.f21370g, "com.huawei.multimedia.audioengine.HwAudioEngineService");
            }
        }
    }

    public final <T extends a> T b(a aVar) {
        if (this.f21368e == null || aVar == null) {
            return null;
        }
        return b.a(aVar.mFeatureType, this.f21365b);
    }

    public final boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            com.tencent.liteav.audio2.earmonitor.a.a aVar2 = this.f21366c;
            if (aVar2 != null && this.f21367d) {
                return aVar2.a(aVar.mFeatureType);
            }
        } catch (RemoteException e11) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e11.getMessage());
        }
        return false;
    }

    public static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            com.tencent.liteav.audio2.earmonitor.a.a aVar = dVar.f21366c;
            if (aVar != null && dVar.f21367d) {
                aVar.a(str, str2);
            }
        } catch (RemoteException e11) {
            LiteavLog.e("HwAudioKit.HwAudioKit", "isFeatureSupported,RemoteException ex : %s", e11.getMessage());
        }
    }

    public static /* synthetic */ void a(d dVar, IBinder iBinder) {
        dVar.f21369f = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(dVar.f21371h, 0);
            } catch (RemoteException unused) {
                dVar.f21368e.a(5);
                LiteavLog.e("HwAudioKit.HwAudioKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }
}

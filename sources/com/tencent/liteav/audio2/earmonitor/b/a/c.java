package com.tencent.liteav.audio2.earmonitor.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.liteav.audio2.earmonitor.a.b;
import com.tencent.liteav.base.util.LiteavLog;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public Context f21351a;

    /* renamed from: b  reason: collision with root package name */
    public b f21352b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21353c;

    /* renamed from: d  reason: collision with root package name */
    public b f21354d;

    /* renamed from: e  reason: collision with root package name */
    public IBinder f21355e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder.DeathRecipient f21356f;

    /* renamed from: g  reason: collision with root package name */
    private ServiceConnection f21357g;

    public enum a {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");
        
        public String mParameName;

        private a(String str) {
            this.mParameName = str;
        }
    }

    public c(Context context) {
        this.f21352b = null;
        this.f21353c = false;
        this.f21355e = null;
        this.f21357g = new ServiceConnection() {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                c.this.f21354d = b.a.a(iBinder);
                c cVar = c.this;
                if (cVar.f21354d != null) {
                    cVar.f21353c = true;
                    cVar.f21352b.a(1000);
                    c cVar2 = c.this;
                    String packageName = cVar2.f21351a.getPackageName();
                    try {
                        b bVar = cVar2.f21354d;
                        if (bVar != null && cVar2.f21353c) {
                            bVar.a(packageName);
                        }
                    } catch (RemoteException e11) {
                        LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "isFeatureSupported,RemoteException ex : %s", e11.getMessage());
                    }
                    c.a(c.this, iBinder);
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                c cVar = c.this;
                cVar.f21353c = false;
                b bVar = cVar.f21352b;
                if (bVar != null) {
                    bVar.a(1001);
                }
            }
        };
        this.f21356f = new IBinder.DeathRecipient() {
            public final void binderDied() {
                LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
                c cVar = c.this;
                cVar.f21355e.unlinkToDeath(cVar.f21356f, 0);
                c.this.f21352b.a(1003);
                c.this.f21355e = null;
            }
        };
        this.f21352b = b.a();
        this.f21351a = context;
    }

    public final void a(Context context) {
        if (context != null) {
            if (!b.a(context)) {
                this.f21352b.a(2);
            } else if (this.f21352b != null && !this.f21353c) {
                b.a(context, this.f21357g, "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService");
            }
        }
    }

    public final void a() {
        if (this.f21353c) {
            this.f21353c = false;
            b.a(this.f21351a, this.f21357g);
        }
    }

    public final int a(boolean z11) {
        try {
            b bVar = this.f21354d;
            if (bVar == null || !this.f21353c) {
                return -2;
            }
            return bVar.a(z11);
        } catch (RemoteException e11) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "enableKaraokeFeature,RemoteException ex : %s", e11.getMessage());
            return -2;
        }
    }

    public final int a(a aVar, int i11) {
        if (aVar == null) {
            return 1807;
        }
        try {
            b bVar = this.f21354d;
            if (bVar == null || !this.f21353c) {
                return -2;
            }
            return bVar.a(aVar.mParameName, i11);
        } catch (RemoteException e11) {
            LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "setParameter,RemoteException ex : %s", e11.getMessage());
            return -2;
        }
    }

    public static /* synthetic */ void a(c cVar, IBinder iBinder) {
        cVar.f21355e = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(cVar.f21356f, 0);
            } catch (RemoteException unused) {
                cVar.f21352b.a(1002);
                LiteavLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "serviceLinkToDeath, RemoteException");
            }
        }
    }
}

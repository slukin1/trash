package com.tencent.liteav.audio2;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import com.tencent.liteav.audio2.c;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.ThreadUtils;

public final class e extends PhoneStateListener implements c.a {

    /* renamed from: b  reason: collision with root package name */
    public static c f21327b = new c();

    /* renamed from: a  reason: collision with root package name */
    public TelephonyManager f21328a;

    /* renamed from: c  reason: collision with root package name */
    public int f21329c = 0;

    /* renamed from: d  reason: collision with root package name */
    private AudioManager f21330d;

    /* renamed from: e  reason: collision with root package name */
    private a f21331e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21332f = false;

    public interface a {
        void onInterruptedByPhoneCall();

        void onResumedByPhoneCall();
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
        }
    }

    public e(a aVar) {
        this.f21331e = aVar;
        this.f21328a = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService(PlaceFields.PHONE);
        this.f21330d = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    }

    public static boolean b() {
        Context applicationContext = ContextUtils.getApplicationContext();
        boolean z11 = false;
        if (applicationContext == null) {
            return false;
        }
        try {
            if (applicationContext.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
                z11 = true;
            }
            return z11;
        } catch (Throwable th2) {
            Log.e("PhoneStateManager", "check permission exception, " + th2.getMessage(), new Object[0]);
            return true;
        }
    }

    public static void c() {
        if (Build.VERSION.SDK_INT >= 26 && f21327b != null) {
            Log.i("PhoneStateManager", "unregister audio playback callback.", new Object[0]);
            f21327b.f21325a = null;
        }
    }

    public final void a() {
        ThreadUtils.getUiThreadHandler().postDelayed(f.a(this), 500);
    }

    public final void onCallStateChanged(int i11, String str) {
        a aVar = this.f21331e;
        if (aVar != null && this.f21329c != i11) {
            this.f21329c = i11;
            if (i11 == 2) {
                aVar.onInterruptedByPhoneCall();
            } else if (i11 == 0) {
                aVar.onResumedByPhoneCall();
            }
        }
    }

    public static /* synthetic */ void a(e eVar) {
        a aVar = eVar.f21331e;
        if (aVar != null) {
            try {
                if (eVar.f21330d.getMode() == 2) {
                    eVar.f21332f = true;
                    aVar.onInterruptedByPhoneCall();
                } else if (eVar.f21332f) {
                    eVar.f21332f = false;
                    aVar.onResumedByPhoneCall();
                }
            } catch (Throwable th2) {
                Log.e("PhoneStateManager", "get Mode exception, " + th2.getMessage(), new Object[0]);
            }
        }
    }
}

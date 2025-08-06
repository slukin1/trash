package com.sumsub.sns.internal.nfc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class d {

    /* renamed from: g  reason: collision with root package name */
    public static final a f35144g = new a((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static final String f35145h = "NfcManager";

    /* renamed from: i  reason: collision with root package name */
    public static final String f35146i = "android.nfc.tech.IsoDep";

    /* renamed from: a  reason: collision with root package name */
    public final a f35147a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    public Activity f35148b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35149c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35150d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35151e;

    /* renamed from: f  reason: collision with root package name */
    public l<? super IsoDep, Unit> f35152f;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public final void a(AppCompatActivity appCompatActivity, l<? super IsoDep, Unit> lVar) {
        this.f35152f = lVar;
        this.f35151e = true;
        this.f35147a.a(appCompatActivity);
    }

    public final void b(Activity activity) {
        c cVar = c.f35142a;
        c.a(cVar, f35145h, "disableNfc", (Throwable) null, 4, (Object) null);
        if (!this.f35150d) {
            c.a(cVar, f35145h, "NFC already disabled, ignoring", (Throwable) null, 4, (Object) null);
            return;
        }
        try {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
            if (defaultAdapter != null) {
                defaultAdapter.disableForegroundDispatch(activity);
                c.a(cVar, f35145h, "NFC disabled", (Throwable) null, 4, (Object) null);
                return;
            }
            c.a(cVar, f35145h, "NfcAdapter is null", (Throwable) null, 4, (Object) null);
        } catch (Exception e11) {
            c.f35142a.a(f35145h, "Failed to disable NFC", e11);
        }
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public final void c(Activity activity) {
        PendingIntent pendingIntent;
        c cVar = c.f35142a;
        c.a(cVar, f35145h, "enableNfc", (Throwable) null, 4, (Object) null);
        if (this.f35150d) {
            c.a(cVar, f35145h, "NFC already enabled, ignoring", (Throwable) null, 4, (Object) null);
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
        if (defaultAdapter != null) {
            Intent intent = new Intent(activity, activity.getClass());
            intent.setFlags(536870912);
            if (Build.VERSION.SDK_INT >= 31) {
                PushAutoTrackHelper.hookIntentGetActivity(activity, 0, intent, 167772160);
                pendingIntent = PendingIntent.getActivity(activity, 0, intent, 167772160);
                PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, activity, 0, intent, 167772160);
            } else {
                PushAutoTrackHelper.hookIntentGetActivity(activity, 0, intent, 134217728);
                pendingIntent = PendingIntent.getActivity(activity, 0, intent, 134217728);
                PushAutoTrackHelper.hookPendingIntentGetActivity(pendingIntent, activity, 0, intent, 134217728);
            }
            try {
                defaultAdapter.enableForegroundDispatch(activity, pendingIntent, (IntentFilter[]) null, new String[][]{new String[]{f35146i}});
                c.a(cVar, f35145h, "NFC enabled", (Throwable) null, 4, (Object) null);
            } catch (Exception e11) {
                c.f35142a.a(f35145h, "Failed to enable NFC", e11);
            }
        } else {
            c.a(cVar, f35145h, "NfcAdapter is null", (Throwable) null, 4, (Object) null);
        }
    }

    public final void d(Activity activity) {
        c.a(c.f35142a, f35145h, "onActivityPause", (Throwable) null, 4, (Object) null);
        this.f35148b = null;
        this.f35149c = false;
        a(activity);
    }

    public final void e(Activity activity) {
        c.a(c.f35142a, f35145h, "onActivityResume", (Throwable) null, 4, (Object) null);
        this.f35148b = activity;
        this.f35149c = true;
        a(activity);
    }

    public final void a() {
        this.f35152f = null;
        this.f35151e = false;
        this.f35147a.a();
    }

    public final void a(Intent intent) {
        String[] techList;
        if (this.f35151e) {
            if (x.b("android.nfc.action.TECH_DISCOVERED", intent != null ? intent.getAction() : null)) {
                c cVar = c.f35142a;
                c.a(cVar, f35145h, "onNewIntent:" + intent, (Throwable) null, 4, (Object) null);
                Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
                boolean z11 = true;
                if (tag == null || (techList = tag.getTechList()) == null || !ArraysKt___ArraysKt.C(techList, f35146i)) {
                    z11 = false;
                }
                if (z11) {
                    IsoDep isoDep = IsoDep.get(tag);
                    c.a(cVar, f35145h, "Got IsoDep in onNewIntent", (Throwable) null, 4, (Object) null);
                    l<? super IsoDep, Unit> lVar = this.f35152f;
                    if (lVar != null) {
                        lVar.invoke(isoDep);
                    }
                }
            }
        }
    }

    public final void a(Activity activity) {
        if (!this.f35149c || !this.f35151e) {
            b(activity);
            this.f35150d = false;
            return;
        }
        c(activity);
        this.f35150d = true;
    }
}

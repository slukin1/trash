package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class i extends BroadcastReceiver {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35643b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final IntentFilter f35644c = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");

    /* renamed from: a  reason: collision with root package name */
    public final b f35645a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final IntentFilter a() {
            return i.f35644c;
        }

        public a() {
        }
    }

    public interface b {
        void b();

        void d();
    }

    public i(b bVar) {
        this.f35645a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (x.b(intent != null ? intent.getAction() : null, "android.nfc.action.ADAPTER_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", 1);
            if (intExtra == 1) {
                this.f35645a.b();
            } else if (intExtra == 2) {
                this.f35645a.d();
            } else if (intExtra == 3) {
                this.f35645a.d();
            } else if (intExtra == 4) {
                this.f35645a.b();
            }
        }
    }
}

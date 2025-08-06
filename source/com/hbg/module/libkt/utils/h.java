package com.hbg.module.libkt.utils;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.adjust.sdk.Constants;
import com.hbg.module.libkt.base.ext.b;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f24896a = new h();

    public static final class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f24897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f24898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f24899c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f24900d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f24901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f24902f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<CountDownTimer> f24903g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(long j11, FragmentActivity fragmentActivity, TextView textView, TextView textView2, TextView textView3, TextView textView4, g gVar, Ref$ObjectRef<CountDownTimer> ref$ObjectRef) {
            super(j11, 1000);
            this.f24897a = fragmentActivity;
            this.f24898b = textView;
            this.f24899c = textView2;
            this.f24900d = textView3;
            this.f24901e = textView4;
            this.f24902f = gVar;
            this.f24903g = ref$ObjectRef;
        }

        public void onFinish() {
            this.f24902f.a();
        }

        public void onTick(long j11) {
            if (b.e(this.f24897a)) {
                long j12 = (long) 86400000;
                long j13 = j11 / j12;
                long j14 = j11 - (j12 * j13);
                long j15 = (long) Constants.ONE_HOUR;
                long j16 = j14 / j15;
                long j17 = j14 - (j15 * j16);
                long j18 = (long) 60000;
                long j19 = j17 / j18;
                long j21 = (j17 - (j18 * j19)) / ((long) 1000);
                String valueOf = String.valueOf(j13);
                if (valueOf.length() < 2) {
                    valueOf = '0' + valueOf;
                }
                this.f24898b.setText(valueOf);
                String valueOf2 = String.valueOf(j16);
                if (valueOf2.length() < 2) {
                    valueOf2 = '0' + valueOf2;
                }
                this.f24899c.setText(valueOf2);
                String valueOf3 = String.valueOf(j19);
                if (valueOf3.length() < 2) {
                    valueOf3 = '0' + valueOf3;
                }
                this.f24900d.setText(valueOf3);
                String valueOf4 = String.valueOf(j21);
                if (valueOf4.length() < 2) {
                    valueOf4 = '0' + valueOf4;
                }
                this.f24901e.setText(valueOf4);
                this.f24902f.b(j11);
                return;
            }
            CountDownTimer countDownTimer = (CountDownTimer) this.f24903g.element;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f24903g.element = null;
        }
    }

    public static final CountDownTimer a(FragmentActivity fragmentActivity, long j11, TextView textView, TextView textView2, TextView textView3, TextView textView4, g gVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        a aVar = new a(j11, fragmentActivity, textView, textView2, textView3, textView4, gVar, ref$ObjectRef);
        ref$ObjectRef.element = aVar;
        aVar.start();
        return (CountDownTimer) ref$ObjectRef.element;
    }
}

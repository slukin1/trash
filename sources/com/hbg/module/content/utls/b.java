package com.hbg.module.content.utls;

import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.adjust.sdk.Constants;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18837a = new b();

    public static final class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f18838a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f18839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TextView f18840c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f18841d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f18842e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f18843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<CountDownTimer> f18844g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(long j11, FragmentActivity fragmentActivity, TextView textView, TextView textView2, TextView textView3, TextView textView4, a aVar, Ref$ObjectRef<CountDownTimer> ref$ObjectRef) {
            super(j11, 1000);
            this.f18838a = fragmentActivity;
            this.f18839b = textView;
            this.f18840c = textView2;
            this.f18841d = textView3;
            this.f18842e = textView4;
            this.f18843f = aVar;
            this.f18844g = ref$ObjectRef;
        }

        public void onFinish() {
            HbgLiveHelper.f18227a.K(0);
            this.f18843f.a();
        }

        public void onTick(long j11) {
            HbgLiveHelper.f18227a.K(j11);
            if (com.hbg.module.libkt.base.ext.b.e(this.f18838a)) {
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
                this.f18839b.setText(valueOf);
                String valueOf2 = String.valueOf(j16);
                if (valueOf2.length() < 2) {
                    valueOf2 = '0' + valueOf2;
                }
                this.f18840c.setText(valueOf2);
                String valueOf3 = String.valueOf(j19);
                if (valueOf3.length() < 2) {
                    valueOf3 = '0' + valueOf3;
                }
                this.f18841d.setText(valueOf3);
                String valueOf4 = String.valueOf(j21);
                if (valueOf4.length() < 2) {
                    valueOf4 = '0' + valueOf4;
                }
                this.f18842e.setText(valueOf4);
                this.f18843f.b(j11);
                return;
            }
            CountDownTimer countDownTimer = (CountDownTimer) this.f18844g.element;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f18844g.element = null;
        }
    }

    public static final CountDownTimer a(FragmentActivity fragmentActivity, long j11, TextView textView, TextView textView2, TextView textView3, TextView textView4, a aVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        a aVar2 = new a(j11, fragmentActivity, textView, textView2, textView3, textView4, aVar, ref$ObjectRef);
        ref$ObjectRef.element = aVar2;
        aVar2.start();
        return (CountDownTimer) ref$ObjectRef.element;
    }
}

package com.huobi.edgeengine.widget;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import com.hbg.lib.widgets.SafeLottieView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.util.HBResType;
import com.huochat.community.network.domain.DomainTool;
import fk.d;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import rj.n;

public final class LottieWidget extends Widget {

    /* renamed from: m0  reason: collision with root package name */
    public static final a f44384m0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f44385h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f44386i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44387j0 = "stop";

    /* renamed from: k0  reason: collision with root package name */
    public String f44388k0;

    /* renamed from: l0  reason: collision with root package name */
    public n.c f44389l0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LottieWidget f44390b;

        public b(LottieWidget lottieWidget) {
            this.f44390b = lottieWidget;
        }

        public void onAnimationCancel(Animator animator) {
            this.f44390b.b0("stop");
        }

        public void onAnimationEnd(Animator animator) {
            this.f44390b.b0("stop");
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            this.f44390b.b0("play");
        }
    }

    public static final void e0(LottieWidget lottieWidget, View view, Object obj) {
        lottieWidget.c0((SafeLottieView) view, (String) obj);
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44385h0 = map.get("resource");
        String str = map.get("loop");
        if (str != null && x.b(str, "true")) {
            this.f44386i0 = true;
        }
        String str2 = map.get("playStatus");
        if (str2 != null) {
            this.f44387j0 = str2;
        }
        String str3 = map.get("onStatusChange");
        if (str3 != null) {
            this.f44388k0 = str3;
        }
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        if (Q instanceof SafeLottieView) {
            Z((SafeLottieView) Q, nVar);
            this.f44389l0 = p(nVar, this.f44387j0, new d(this, Q));
        }
        return Q;
    }

    public final void Z(SafeLottieView safeLottieView, n nVar) {
        safeLottieView.addAnimatorListener(new b(this));
    }

    public final void a0(SafeLottieView safeLottieView) {
        if (this.f44386i0) {
            safeLottieView.setRepeatCount(-1);
        } else {
            safeLottieView.setRepeatCount(0);
        }
    }

    public final void b0(String str) {
        if (!sd.a.c(this.f44388k0)) {
            String str2 = this.f44388k0;
            d0 d0Var = d0.f56774a;
            z(StringsKt__StringsJVMKt.G(str2, "@eventParams", String.format("'%s'", Arrays.copyOf(new Object[]{str}, 1)), false, 4, (Object) null), this.f44154e0);
        }
        n.c cVar = this.f44389l0;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public final void c0(SafeLottieView safeLottieView, String str) {
        switch (str.hashCode()) {
            case -934426579:
                if (str.equals("resume")) {
                    safeLottieView.resumeAnimation();
                    return;
                }
                break;
            case 3443508:
                if (str.equals("play")) {
                    safeLottieView.playAnimation();
                    return;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    safeLottieView.pauseAnimation();
                    return;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    safeLottieView.pauseAnimation();
                    return;
                }
                break;
        }
        safeLottieView.cancelAnimation();
    }

    public final void d0(SafeLottieView safeLottieView, Context context) {
        String str = this.f44385h0;
        String str2 = null;
        boolean z11 = true;
        if (str != null && StringsKt__StringsJVMKt.M(str, "@raw", false, 2, (Object) null)) {
            String str3 = this.f44385h0;
            if ((str3 != null ? Integer.valueOf(str3.length()) : null).intValue() > 5) {
                String str4 = this.f44385h0;
                if (str4 != null) {
                    str2 = str4.substring(5);
                }
                safeLottieView.setAnimation(ek.a.f47514a.a(context, HBResType.Raw, str2));
                return;
            }
        }
        String str5 = this.f44385h0;
        if (str5 != null && StringsKt__StringsJVMKt.M(str5, "{", false, 2, (Object) null)) {
            safeLottieView.setAnimationFromJson(this.f44385h0);
            return;
        }
        String str6 = this.f44385h0;
        if (!(str6 != null && StringsKt__StringsJVMKt.M(str6, DomainTool.DOMAIN_PREFIX_HTTP, false, 2, (Object) null))) {
            String str7 = this.f44385h0;
            if (str7 == null || !StringsKt__StringsJVMKt.M(str7, DomainTool.DOMAIN_PREFIX, false, 2, (Object) null)) {
                z11 = false;
            }
            if (!z11) {
                return;
            }
        }
        safeLottieView.setAnimationFromUrl(this.f44385h0);
    }

    public View q(Context context) {
        SafeLottieView safeLottieView = new SafeLottieView(context);
        d0(safeLottieView, context);
        a0(safeLottieView);
        return safeLottieView;
    }
}

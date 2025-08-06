package yl;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.common.utils.SP;
import com.huobi.utils.j0;
import i6.n;
import java.io.InputStream;
import pro.huobi.R;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f76840a;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f76841b;

    /* renamed from: c  reason: collision with root package name */
    public LottieAnimationView f76842c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f76843d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f76844e;

    /* renamed from: f  reason: collision with root package name */
    public LottieAnimationView f76845f;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f76846g;

    /* renamed from: h  reason: collision with root package name */
    public LottieAnimationView f76847h;

    /* renamed from: i  reason: collision with root package name */
    public LottieAnimationView f76848i;

    /* renamed from: j  reason: collision with root package name */
    public LottieAnimationView f76849j;

    /* renamed from: k  reason: collision with root package name */
    public LottieAnimationView f76850k;

    public l(ViewGroup viewGroup, LottieAnimationView lottieAnimationView) {
        this.f76840a = viewGroup;
        this.f76841b = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_notice);
        this.f76843d = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_home);
        this.f76842c = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_quick);
        this.f76844e = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_biz);
        this.f76845f = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_hot_coin);
        this.f76846g = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_middle);
        this.f76847h = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_ranking);
        this.f76848i = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_earn);
        this.f76849j = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_animation_view_index_information);
        this.f76846g.setVisibility(8);
        this.f76849j.setVisibility(8);
        this.f76850k = lottieAnimationView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        e(this.f76841b, j0.a(), 750.0f, 86.0f);
        e(this.f76843d, j0.j(), 750.0f, 172.0f);
        e(this.f76842c, j0.b(), 750.0f, 286.0f);
        e(this.f76844e, j0.c(), 750.0f, 310.0f);
        e(this.f76845f, j0.i(), 375.0f, 152.0f);
        e(this.f76847h, j0.d(), 750.0f, 1064.0f);
        e(this.f76848i, j0.e(), 750.0f, 454.0f);
        this.f76841b.playAnimation();
        this.f76843d.playAnimation();
        this.f76842c.playAnimation();
        this.f76844e.playAnimation();
        if (SP.l("key_display_recommend_region_area", false)) {
            this.f76845f.playAnimation();
        }
        this.f76847h.playAnimation();
        this.f76848i.playAnimation();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        e(this.f76850k, j0.d(), 750.0f, 1064.0f);
        this.f76850k.playAnimation();
    }

    public void c() {
        if (this.f76840a.getVisibility() == 0) {
            this.f76841b.cancelAnimation();
            this.f76843d.cancelAnimation();
            this.f76842c.cancelAnimation();
            this.f76844e.cancelAnimation();
            if (SP.l("key_display_recommend_region_area", false)) {
                this.f76845f.cancelAnimation();
            }
            this.f76847h.cancelAnimation();
            this.f76848i.cancelAnimation();
        }
    }

    public void d() {
        this.f76850k.setVisibility(8);
        this.f76850k.cancelAnimation();
    }

    public final void e(LottieAnimationView lottieAnimationView, int i11, float f11, float f12) {
        FragmentActivity fragmentActivity;
        if (!lottieAnimationView.hasMasks() && (fragmentActivity = (FragmentActivity) this.f76840a.getContext()) != null) {
            InputStream openRawResource = fragmentActivity.getResources().openRawResource(i11);
            lottieAnimationView.setAnimation(openRawResource, "rawRes_" + (fragmentActivity.getResources().getConfiguration().uiMode & 32) + "_" + i11);
            lottieAnimationView.setRepeatCount(-1);
            ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
            int g11 = n.g(fragmentActivity);
            layoutParams.width = g11;
            layoutParams.height = (int) ((((float) g11) / f11) * f12);
            lottieAnimationView.setLayoutParams(layoutParams);
        }
    }

    public boolean f() {
        return this.f76840a.getVisibility() == 0 || this.f76850k.getVisibility() == 0;
    }

    public final void i() {
        if (this.f76840a.getVisibility() == 0) {
            this.f76840a.post(new k(this));
        }
    }

    public void j() {
        this.f76850k.setVisibility(0);
        this.f76850k.post(new j(this));
    }

    public void k(boolean z11) {
        if (z11) {
            this.f76840a.setVisibility(0);
            i();
            return;
        }
        this.f76840a.setVisibility(8);
        c();
    }
}

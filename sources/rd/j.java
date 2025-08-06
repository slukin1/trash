package rd;

import android.animation.Animator;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class j {

    /* renamed from: h  reason: collision with root package name */
    public static volatile j f23357h;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<ViewGroup> f23358a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<View> f23359b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<View> f23360c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23361d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f23362e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public boolean f23363f = false;

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f23364g;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            boolean unused = j.this.f23363f = false;
            j.this.f23362e.clear();
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = j.this.f23363f = false;
            if (!j.this.f23362e.isEmpty()) {
                j.this.h((String) j.this.f23362e.remove(0));
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f23366a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f23367b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23368c;

        public b(TextView textView, ImageView imageView, ViewGroup viewGroup) {
            this.f23366a = textView;
            this.f23367b = imageView;
            this.f23368c = viewGroup;
        }

        public void onAnimationEnd(Animation animation) {
            this.f23366a.setVisibility(8);
            this.f23367b.setVisibility(8);
            this.f23368c.setBackgroundResource(0);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f23370a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AnimationSet f23371b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImageView f23372c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LottieAnimationView f23373d;

        public c(TextView textView, AnimationSet animationSet, ImageView imageView, LottieAnimationView lottieAnimationView) {
            this.f23370a = textView;
            this.f23371b = animationSet;
            this.f23372c = imageView;
            this.f23373d = lottieAnimationView;
        }

        public static /* synthetic */ void b(TextView textView, AnimationSet animationSet, ImageView imageView, LottieAnimationView lottieAnimationView) {
            textView.startAnimation(animationSet);
            imageView.startAnimation(animationSet);
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setTranslationX((float) (-PixelUtils.a(54.0f)));
            lottieAnimationView.setAnimation("huobi_live_drop_coin.json");
            lottieAnimationView.playAnimation();
        }

        public void onAnimationEnd(Animation animation) {
            TextView textView = this.f23370a;
            textView.postDelayed(new k(textView, this.f23371b, this.f23372c, this.f23373d), 400);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static j f() {
        if (f23357h == null) {
            synchronized (j.class) {
                if (f23357h == null) {
                    f23357h = new j();
                }
            }
        }
        return f23357h;
    }

    public static /* synthetic */ void i(Throwable th2) {
    }

    public void j(ViewGroup viewGroup, View view) {
        this.f23361d = true;
        LottieAnimationView lottieAnimationView = this.f23364g;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        this.f23364g = null;
        this.f23363f = false;
        this.f23358a = new WeakReference<>(viewGroup);
        if (view != null) {
            this.f23359b = new WeakReference<>(view);
        } else {
            this.f23359b = null;
        }
    }

    public void k(ViewGroup viewGroup, View view, View view2) {
        j(viewGroup, view);
        this.f23361d = false;
        if (view2 != null) {
            this.f23360c = new WeakReference<>(view2);
        } else {
            this.f23360c = null;
        }
    }

    /* renamed from: l */
    public void g(String str) {
        WeakReference<View> weakReference;
        String str2 = str;
        if (this.f23358a != null && this.f23359b != null) {
            if (this.f23361d || !((weakReference = this.f23360c) == null || weakReference.get() == null || ((View) this.f23360c.get()).getVisibility() == 0)) {
                View view = (View) this.f23359b.get();
                ViewGroup viewGroup = (ViewGroup) this.f23358a.get();
                if (view != null && viewGroup != null) {
                    viewGroup.setBackgroundResource(R$color.color_99000000);
                    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                        viewGroup.post(new i(this, str2));
                        return;
                    }
                    TextView textView = (TextView) viewGroup.findViewById(R$id.live_drop_coin_tv);
                    textView.setText(str2);
                    ImageView imageView = (ImageView) viewGroup.findViewById(R$id.live_drop_coin_iv);
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                    animationSet.addAnimation(new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f));
                    animationSet.setDuration(400);
                    AnimationSet animationSet2 = new AnimationSet(true);
                    animationSet2.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                    animationSet2.addAnimation(new TranslateAnimation(0.0f, 0.0f, 100.0f, 0.0f));
                    AnimationSet animationSet3 = new AnimationSet(true);
                    animationSet3.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                    animationSet3.setDuration(400);
                    animationSet3.setAnimationListener(new b(textView, imageView, viewGroup));
                    animationSet.setAnimationListener(new c(textView, animationSet3, imageView, (LottieAnimationView) viewGroup.findViewById(R$id.live_drop_coin_lottie)));
                    imageView.setVisibility(0);
                    textView.setVisibility(0);
                    imageView.startAnimation(animationSet);
                    textView.startAnimation(animationSet2);
                }
            }
        }
    }

    /* renamed from: m */
    public void h(String str) {
        ViewGroup viewGroup;
        WeakReference<View> weakReference;
        if (this.f23358a != null && !TextUtils.isEmpty(str) && str.endsWith(MTPushConstants.Analysis.KEY_JSON)) {
            if ((!this.f23361d && ((weakReference = this.f23360c) == null || weakReference.get() == null || ((View) this.f23360c.get()).getVisibility() == 0)) || (viewGroup = (ViewGroup) this.f23358a.get()) == null) {
                return;
            }
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                viewGroup.post(new h(this, str));
                return;
            }
            if (this.f23364g == null) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(R$id.live_large_gift_lottie);
                this.f23364g = lottieAnimationView;
                lottieAnimationView.addAnimatorListener(new a());
            }
            if (this.f23364g.isAnimating() || this.f23363f) {
                this.f23362e.add(str);
                return;
            }
            this.f23363f = true;
            this.f23364g.setAnimationFromUrl(str, str);
            this.f23364g.setVisibility(0);
            this.f23364g.playAnimation();
        }
    }

    public void n() {
        ViewGroup viewGroup;
        WeakReference<ViewGroup> weakReference = this.f23358a;
        if (weakReference != null && (viewGroup = (ViewGroup) weakReference.get()) != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(R$id.live_large_gift_lottie);
            lottieAnimationView.setFailureListener(g.f70532a);
            if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setVisibility(8);
                viewGroup.setBackgroundResource(0);
            }
        }
    }
}

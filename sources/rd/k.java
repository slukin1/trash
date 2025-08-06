package rd;

import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import rd.j;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f70537b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AnimationSet f70538c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f70539d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f70540e;

    public /* synthetic */ k(TextView textView, AnimationSet animationSet, ImageView imageView, LottieAnimationView lottieAnimationView) {
        this.f70537b = textView;
        this.f70538c = animationSet;
        this.f70539d = imageView;
        this.f70540e = lottieAnimationView;
    }

    public final void run() {
        j.c.b(this.f70537b, this.f70538c, this.f70539d, this.f70540e);
    }
}

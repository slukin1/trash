package tv;

import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.viewholder.CommunityTopHolder;
import com.nineoldandroids.animation.ValueAnimator;

public final /* synthetic */ class v implements ValueAnimator.g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.Behavior f60518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f60519b;

    public /* synthetic */ v(AppBarLayout.Behavior behavior, int i11) {
        this.f60518a = behavior;
        this.f60519b = i11;
    }

    public final void a(ValueAnimator valueAnimator) {
        CommunityTopHolder.scrollAppBarLayout$lambda$3(this.f60518a, this.f60519b, valueAnimator);
    }
}

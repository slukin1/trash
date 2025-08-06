package fa;

import android.animation.ValueAnimator;
import com.hbg.lib.widgets.expandable.ExpandableTextView;
import com.hbg.lib.widgets.expandable.StatusType;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f54472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f54473c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StatusType f54474d;

    public /* synthetic */ c(ExpandableTextView expandableTextView, boolean z11, StatusType statusType) {
        this.f54472b = expandableTextView;
        this.f54473c = z11;
        this.f54474d = statusType;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f54472b.I(this.f54473c, this.f54474d, valueAnimator);
    }
}

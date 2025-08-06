package com.huochat.community.widget.expandable;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f38715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f38716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StatusType f38717d;

    public /* synthetic */ a(ExpandableTextView expandableTextView, boolean z11, StatusType statusType) {
        this.f38715b = expandableTextView;
        this.f38716c = z11;
        this.f38717d = statusType;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f38715b.lambda$action$2(this.f38716c, this.f38717d, valueAnimator);
    }
}

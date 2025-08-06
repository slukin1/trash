package com.airbnb.lottie;

public final /* synthetic */ class a implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f13984a;

    public /* synthetic */ a(LottieAnimationView lottieAnimationView) {
        this.f13984a = lottieAnimationView;
    }

    public final void onResult(Object obj) {
        this.f13984a.setComposition((LottieComposition) obj);
    }
}

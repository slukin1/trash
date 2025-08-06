package com.twitter.sdk.android.tweetui;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class c implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTweetView f51220b;

    public /* synthetic */ c(BaseTweetView baseTweetView) {
        this.f51220b = baseTweetView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f51220b.lambda$linkifyProfilePhotoView$1(view, motionEvent);
    }
}

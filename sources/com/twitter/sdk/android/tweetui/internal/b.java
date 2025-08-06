package com.twitter.sdk.android.tweetui.internal;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class b implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpanClickHandler f51233b;

    public /* synthetic */ b(SpanClickHandler spanClickHandler) {
        this.f51233b = spanClickHandler;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SpanClickHandler.lambda$enableClicksOnSpans$0(this.f51233b, view, motionEvent);
    }
}

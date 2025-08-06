package com.huochat.community.widget;

import android.view.View;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f38709b;

    public /* synthetic */ b(View view) {
        this.f38709b = view;
    }

    public final void run() {
        CommunityBubbleHintHelper.showCommunityTips$lambda$1(this.f38709b);
    }
}

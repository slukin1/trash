package com.twitter.sdk.android.tweetui;

import android.view.View;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerController f51236b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f51237c;

    public /* synthetic */ j(PlayerController playerController, String str) {
        this.f51236b = playerController;
        this.f51237c = str;
    }

    public final void onClick(View view) {
        this.f51236b.lambda$setUpCallToActionListener$3(this.f51237c, view);
    }
}

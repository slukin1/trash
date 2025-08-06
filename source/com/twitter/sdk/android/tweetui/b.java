package com.twitter.sdk.android.tweetui;

import android.view.View;
import com.twitter.sdk.android.core.models.Tweet;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseTweetView f51218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Tweet f51219c;

    public /* synthetic */ b(BaseTweetView baseTweetView, Tweet tweet) {
        this.f51218b = baseTweetView;
        this.f51219c = tweet;
    }

    public final void onClick(View view) {
        this.f51218b.lambda$linkifyProfilePhotoView$0(this.f51219c, view);
    }
}

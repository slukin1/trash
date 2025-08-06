package com.twitter.sdk.android.tweetcomposer;

import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;

public final /* synthetic */ class d implements ObservableScrollView.ScrollViewListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComposerView f51206a;

    public /* synthetic */ d(ComposerView composerView) {
        this.f51206a = composerView;
    }

    public final void onScrollChanged(int i11) {
        this.f51206a.lambda$onFinishInflate$3(i11);
    }
}

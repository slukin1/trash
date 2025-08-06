package com.twitter.sdk.android.tweetcomposer;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class c implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComposerView f51205b;

    public /* synthetic */ c(ComposerView composerView) {
        this.f51205b = composerView;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f51205b.lambda$onFinishInflate$2(textView, i11, keyEvent);
    }
}

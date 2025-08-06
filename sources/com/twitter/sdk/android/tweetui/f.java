package com.twitter.sdk.android.tweetui;

import android.media.MediaPlayer;

public final /* synthetic */ class f implements MediaPlayer.OnInfoListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerController f51226b;

    public /* synthetic */ f(PlayerController playerController) {
        this.f51226b = playerController;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
        return this.f51226b.lambda$prepare$1(mediaPlayer, i11, i12);
    }
}

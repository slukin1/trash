package com.twitter.sdk.android.tweetui;

import android.media.MediaPlayer;

public final /* synthetic */ class g implements MediaPlayer.OnPreparedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerController f51227b;

    public /* synthetic */ g(PlayerController playerController) {
        this.f51227b = playerController;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f51227b.lambda$prepare$0(mediaPlayer);
    }
}

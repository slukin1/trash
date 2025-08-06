package com.google.android.exoplayer2;

public interface ControlDispatcher {
    boolean dispatchFastForward(Player player);

    boolean dispatchNext(Player player);

    boolean dispatchPrepare(Player player);

    boolean dispatchPrevious(Player player);

    boolean dispatchRewind(Player player);

    boolean dispatchSeekTo(Player player, int i11, long j11);

    boolean dispatchSetPlayWhenReady(Player player, boolean z11);

    boolean dispatchSetPlaybackParameters(Player player, PlaybackParameters playbackParameters);

    boolean dispatchSetRepeatMode(Player player, int i11);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z11);

    boolean dispatchStop(Player player, boolean z11);

    boolean isFastForwardEnabled();

    boolean isRewindEnabled();
}

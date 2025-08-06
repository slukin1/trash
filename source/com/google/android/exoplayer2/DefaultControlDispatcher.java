package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;

public class DefaultControlDispatcher implements ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    private static final int MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline.Window window;

    public DefaultControlDispatcher() {
        this(15000, 5000);
    }

    private static void seekToOffset(Player player, long j11) {
        long currentPosition = player.getCurrentPosition() + j11;
        long duration = player.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        player.seekTo(player.getCurrentWindowIndex(), Math.max(currentPosition, 0));
    }

    public boolean dispatchFastForward(Player player) {
        if (!isFastForwardEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, this.fastForwardIncrementMs);
        return true;
    }

    public boolean dispatchNext(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int nextWindowIndex = player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                player.seekTo(nextWindowIndex, -9223372036854775807L);
            } else if (this.window.isLive() && this.window.isDynamic) {
                player.seekTo(currentWindowIndex, -9223372036854775807L);
            }
        }
        return true;
    }

    public boolean dispatchPrepare(Player player) {
        player.prepare();
        return true;
    }

    public boolean dispatchPrevious(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
            int currentWindowIndex = player.getCurrentWindowIndex();
            currentTimeline.getWindow(currentWindowIndex, this.window);
            int previousWindowIndex = player.getPreviousWindowIndex();
            boolean z11 = this.window.isLive() && !this.window.isSeekable;
            if (previousWindowIndex != -1 && (player.getCurrentPosition() <= 3000 || z11)) {
                player.seekTo(previousWindowIndex, -9223372036854775807L);
            } else if (!z11) {
                player.seekTo(currentWindowIndex, 0);
            }
        }
        return true;
    }

    public boolean dispatchRewind(Player player) {
        if (!isRewindEnabled() || !player.isCurrentWindowSeekable()) {
            return true;
        }
        seekToOffset(player, -this.rewindIncrementMs);
        return true;
    }

    public boolean dispatchSeekTo(Player player, int i11, long j11) {
        player.seekTo(i11, j11);
        return true;
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean z11) {
        player.setPlayWhenReady(z11);
        return true;
    }

    public boolean dispatchSetPlaybackParameters(Player player, PlaybackParameters playbackParameters) {
        player.setPlaybackParameters(playbackParameters);
        return true;
    }

    public boolean dispatchSetRepeatMode(Player player, int i11) {
        player.setRepeatMode(i11);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z11) {
        player.setShuffleModeEnabled(z11);
        return true;
    }

    public boolean dispatchStop(Player player, boolean z11) {
        player.stop(z11);
        return true;
    }

    public long getFastForwardIncrementMs() {
        return this.fastForwardIncrementMs;
    }

    public long getRewindIncrementMs() {
        return this.rewindIncrementMs;
    }

    public boolean isFastForwardEnabled() {
        return this.fastForwardIncrementMs > 0;
    }

    public boolean isRewindEnabled() {
        return this.rewindIncrementMs > 0;
    }

    @Deprecated
    public void setFastForwardIncrementMs(long j11) {
        this.fastForwardIncrementMs = j11;
    }

    @Deprecated
    public void setRewindIncrementMs(long j11) {
        this.rewindIncrementMs = j11;
    }

    public DefaultControlDispatcher(long j11, long j12) {
        this.fastForwardIncrementMs = j11;
        this.rewindIncrementMs = j12;
        this.window = new Timeline.Window();
    }
}

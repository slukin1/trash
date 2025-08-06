package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class BasePlayer implements Player {
    public final Timeline.Window window = new Timeline.Window();

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    public final void addMediaItem(int i11, MediaItem mediaItem) {
        addMediaItems(i11, Collections.singletonList(mediaItem));
    }

    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public Player.Commands getAvailableCommands(Player.Commands commands) {
        boolean z11 = false;
        Player.Commands.Builder addIf = new Player.Commands.Builder().addAll(commands).addIf(3, !isPlayingAd()).addIf(4, isCurrentWindowSeekable() && !isPlayingAd()).addIf(5, hasNext() && !isPlayingAd());
        if (hasPrevious() && !isPlayingAd()) {
            z11 = true;
        }
        return addIf.addIf(6, z11).addIf(7, true ^ isPlayingAd()).build();
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -9223372036854775807L;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
    }

    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).windowStartTimeMs != -9223372036854775807L) {
            return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
        }
        return -9223372036854775807L;
    }

    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).manifest;
    }

    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem;
    }

    @Deprecated
    public final Object getCurrentTag() {
        MediaItem.PlaybackProperties playbackProperties;
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && (playbackProperties = currentTimeline.getWindow(getCurrentWindowIndex(), this.window).mediaItem.playbackProperties) != null) {
            return playbackProperties.tag;
        }
        return null;
    }

    public final MediaItem getMediaItemAt(int i11) {
        return getCurrentTimeline().getWindow(i11, this.window).mediaItem;
    }

    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    public final int getNextWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Deprecated
    public final ExoPlaybackException getPlaybackError() {
        return getPlayerError();
    }

    public final int getPreviousWindowIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentWindowIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final boolean hasNext() {
        return getNextWindowIndex() != -1;
    }

    public final boolean hasPrevious() {
        return getPreviousWindowIndex() != -1;
    }

    public final boolean isCommandAvailable(int i11) {
        return getAvailableCommands().contains(i11);
    }

    public final boolean isCurrentWindowDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    public final boolean isCurrentWindowLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isLive();
    }

    public final boolean isCurrentWindowSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void moveMediaItem(int i11, int i12) {
        if (i11 != i12) {
            moveMediaItems(i11, i11 + 1, i12);
        }
    }

    public final void next() {
        int nextWindowIndex = getNextWindowIndex();
        if (nextWindowIndex != -1) {
            seekToDefaultPosition(nextWindowIndex);
        }
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    public final void play() {
        setPlayWhenReady(true);
    }

    public final void previous() {
        int previousWindowIndex = getPreviousWindowIndex();
        if (previousWindowIndex != -1) {
            seekToDefaultPosition(previousWindowIndex);
        }
    }

    public final void removeMediaItem(int i11) {
        removeMediaItems(i11, i11 + 1);
    }

    public final void seekTo(long j11) {
        seekTo(getCurrentWindowIndex(), j11);
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    public final void setPlaybackSpeed(float f11) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f11));
    }

    public final void stop() {
        stop(false);
    }

    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    public final void seekToDefaultPosition(int i11) {
        seekTo(i11, -9223372036854775807L);
    }

    public final void setMediaItem(MediaItem mediaItem, long j11) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j11);
    }

    public final void setMediaItem(MediaItem mediaItem, boolean z11) {
        setMediaItems(Collections.singletonList(mediaItem), z11);
    }
}

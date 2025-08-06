package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ExoFlags;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public interface Player {
    public static final int COMMAND_ADJUST_DEVICE_VOLUME = 20;
    public static final int COMMAND_CHANGE_MEDIA_ITEMS = 14;
    public static final int COMMAND_GET_AUDIO_ATTRIBUTES = 15;
    public static final int COMMAND_GET_CURRENT_MEDIA_ITEM = 11;
    public static final int COMMAND_GET_DEVICE_VOLUME = 17;
    public static final int COMMAND_GET_MEDIA_ITEMS = 12;
    public static final int COMMAND_GET_MEDIA_ITEMS_METADATA = 13;
    public static final int COMMAND_GET_TEXT = 22;
    public static final int COMMAND_GET_VOLUME = 16;
    public static final int COMMAND_PLAY_PAUSE = 1;
    public static final int COMMAND_PREPARE_STOP = 2;
    public static final int COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM = 4;
    public static final int COMMAND_SEEK_TO_DEFAULT_POSITION = 3;
    public static final int COMMAND_SEEK_TO_MEDIA_ITEM = 7;
    public static final int COMMAND_SEEK_TO_NEXT_MEDIA_ITEM = 5;
    public static final int COMMAND_SEEK_TO_PREVIOUS_MEDIA_ITEM = 6;
    public static final int COMMAND_SET_DEVICE_VOLUME = 19;
    public static final int COMMAND_SET_REPEAT_MODE = 10;
    public static final int COMMAND_SET_SHUFFLE_MODE = 9;
    public static final int COMMAND_SET_SPEED_AND_PITCH = 8;
    public static final int COMMAND_SET_VIDEO_SURFACE = 21;
    public static final int COMMAND_SET_VOLUME = 18;
    public static final int DISCONTINUITY_REASON_AUTO_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_INTERNAL = 5;
    public static final int DISCONTINUITY_REASON_REMOVE = 4;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int DISCONTINUITY_REASON_SKIP = 3;
    public static final int EVENT_AVAILABLE_COMMANDS_CHANGED = 14;
    public static final int EVENT_IS_LOADING_CHANGED = 4;
    public static final int EVENT_IS_PLAYING_CHANGED = 8;
    public static final int EVENT_MEDIA_ITEM_TRANSITION = 1;
    public static final int EVENT_MEDIA_METADATA_CHANGED = 15;
    public static final int EVENT_PLAYBACK_PARAMETERS_CHANGED = 13;
    public static final int EVENT_PLAYBACK_STATE_CHANGED = 5;
    public static final int EVENT_PLAYBACK_SUPPRESSION_REASON_CHANGED = 7;
    public static final int EVENT_PLAYER_ERROR = 11;
    public static final int EVENT_PLAY_WHEN_READY_CHANGED = 6;
    public static final int EVENT_POSITION_DISCONTINUITY = 12;
    public static final int EVENT_REPEAT_MODE_CHANGED = 9;
    public static final int EVENT_SHUFFLE_MODE_ENABLED_CHANGED = 10;
    public static final int EVENT_STATIC_METADATA_CHANGED = 3;
    public static final int EVENT_TIMELINE_CHANGED = 0;
    public static final int EVENT_TRACKS_CHANGED = 2;
    public static final int MEDIA_ITEM_TRANSITION_REASON_AUTO = 1;
    public static final int MEDIA_ITEM_TRANSITION_REASON_PLAYLIST_CHANGED = 3;
    public static final int MEDIA_ITEM_TRANSITION_REASON_REPEAT = 0;
    public static final int MEDIA_ITEM_TRANSITION_REASON_SEEK = 2;
    public static final int PLAYBACK_SUPPRESSION_REASON_NONE = 0;
    public static final int PLAYBACK_SUPPRESSION_REASON_TRANSIENT_AUDIO_FOCUS_LOSS = 1;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_BECOMING_NOISY = 3;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_FOCUS_LOSS = 2;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_END_OF_MEDIA_ITEM = 5;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_REMOTE = 4;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_USER_REQUEST = 1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_PLAYLIST_CHANGED = 0;
    public static final int TIMELINE_CHANGE_REASON_SOURCE_UPDATE = 1;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Command {
    }

    public static final class Commands {
        public static final Commands EMPTY = new Builder().build();
        /* access modifiers changed from: private */
        public final ExoFlags flags;

        public static final class Builder {
            private final ExoFlags.Builder flagsBuilder = new ExoFlags.Builder();

            public Builder add(int i11) {
                this.flagsBuilder.add(i11);
                return this;
            }

            public Builder addAll(int... iArr) {
                this.flagsBuilder.addAll(iArr);
                return this;
            }

            public Builder addIf(int i11, boolean z11) {
                this.flagsBuilder.addIf(i11, z11);
                return this;
            }

            public Commands build() {
                return new Commands(this.flagsBuilder.build());
            }

            public Builder addAll(Commands commands) {
                this.flagsBuilder.addAll(commands.flags);
                return this;
            }
        }

        public boolean contains(int i11) {
            return this.flags.contains(i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Commands)) {
                return false;
            }
            return this.flags.equals(((Commands) obj).flags);
        }

        public int get(int i11) {
            return this.flags.get(i11);
        }

        public int hashCode() {
            return this.flags.hashCode();
        }

        public int size() {
            return this.flags.size();
        }

        private Commands(ExoFlags exoFlags) {
            this.flags = exoFlags;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventFlags {
    }

    @Deprecated
    public interface EventListener {
        void onAvailableCommandsChanged(Commands commands);

        void onEvents(Player player, Events events);

        void onIsLoadingChanged(boolean z11);

        void onIsPlayingChanged(boolean z11);

        @Deprecated
        void onLoadingChanged(boolean z11);

        void onMediaItemTransition(MediaItem mediaItem, int i11);

        void onMediaMetadataChanged(MediaMetadata mediaMetadata);

        void onPlayWhenReadyChanged(boolean z11, int i11);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlaybackStateChanged(int i11);

        void onPlaybackSuppressionReasonChanged(int i11);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        @Deprecated
        void onPlayerStateChanged(boolean z11, int i11);

        @Deprecated
        void onPositionDiscontinuity(int i11);

        void onPositionDiscontinuity(PositionInfo positionInfo, PositionInfo positionInfo2, int i11);

        void onRepeatModeChanged(int i11);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z11);

        void onStaticMetadataChanged(List<Metadata> list);

        void onTimelineChanged(Timeline timeline, int i11);

        @Deprecated
        void onTimelineChanged(Timeline timeline, Object obj, int i11);

        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);
    }

    public static final class Events {
        private final ExoFlags flags;

        public Events(ExoFlags exoFlags) {
            this.flags = exoFlags;
        }

        public boolean contains(int i11) {
            return this.flags.contains(i11);
        }

        public boolean containsAny(int... iArr) {
            return this.flags.containsAny(iArr);
        }

        public int get(int i11) {
            return this.flags.get(i11);
        }

        public int size() {
            return this.flags.size();
        }
    }

    public interface Listener extends VideoListener, AudioListener, TextOutput, MetadataOutput, DeviceListener, EventListener {
        void onCues(List<Cue> list);

        void onMetadata(Metadata metadata);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    public static final class PositionInfo implements Bundleable {
        public static final Bundleable.Creator<PositionInfo> CREATOR = p0.f65970a;
        private static final int FIELD_AD_GROUP_INDEX = 4;
        private static final int FIELD_AD_INDEX_IN_AD_GROUP = 5;
        private static final int FIELD_CONTENT_POSITION_MS = 3;
        private static final int FIELD_PERIOD_INDEX = 1;
        private static final int FIELD_POSITION_MS = 2;
        private static final int FIELD_WINDOW_INDEX = 0;
        public final int adGroupIndex;
        public final int adIndexInAdGroup;
        public final long contentPositionMs;
        public final int periodIndex;
        public final Object periodUid;
        public final long positionMs;
        public final int windowIndex;
        public final Object windowUid;

        public PositionInfo(Object obj, int i11, Object obj2, int i12, long j11, long j12, int i13, int i14) {
            this.windowUid = obj;
            this.windowIndex = i11;
            this.periodUid = obj2;
            this.periodIndex = i12;
            this.positionMs = j11;
            this.contentPositionMs = j12;
            this.adGroupIndex = i13;
            this.adIndexInAdGroup = i14;
        }

        /* access modifiers changed from: private */
        public static PositionInfo fromBundle(Bundle bundle) {
            return new PositionInfo((Object) null, bundle.getInt(keyForField(0), -1), (Object) null, bundle.getInt(keyForField(1), -1), bundle.getLong(keyForField(2), -9223372036854775807L), bundle.getLong(keyForField(3), -9223372036854775807L), bundle.getInt(keyForField(4), -1), bundle.getInt(keyForField(5), -1));
        }

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PositionInfo.class != obj.getClass()) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) obj;
            if (this.windowIndex == positionInfo.windowIndex && this.periodIndex == positionInfo.periodIndex && this.positionMs == positionInfo.positionMs && this.contentPositionMs == positionInfo.contentPositionMs && this.adGroupIndex == positionInfo.adGroupIndex && this.adIndexInAdGroup == positionInfo.adIndexInAdGroup && Objects.equal(this.windowUid, positionInfo.windowUid) && Objects.equal(this.periodUid, positionInfo.periodUid)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.windowUid, Integer.valueOf(this.windowIndex), this.periodUid, Integer.valueOf(this.periodIndex), Integer.valueOf(this.windowIndex), Long.valueOf(this.positionMs), Long.valueOf(this.contentPositionMs), Integer.valueOf(this.adGroupIndex), Integer.valueOf(this.adIndexInAdGroup));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(keyForField(0), this.windowIndex);
            bundle.putInt(keyForField(1), this.periodIndex);
            bundle.putLong(keyForField(2), this.positionMs);
            bundle.putLong(keyForField(3), this.contentPositionMs);
            bundle.putInt(keyForField(4), this.adGroupIndex);
            bundle.putInt(keyForField(5), this.adIndexInAdGroup);
            return bundle;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    @Deprecated
    void addListener(EventListener eventListener);

    void addListener(Listener listener);

    void addMediaItem(int i11, MediaItem mediaItem);

    void addMediaItem(MediaItem mediaItem);

    void addMediaItems(int i11, List<MediaItem> list);

    void addMediaItems(List<MediaItem> list);

    void clearMediaItems();

    void clearVideoSurface();

    void clearVideoSurface(Surface surface);

    void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void clearVideoSurfaceView(SurfaceView surfaceView);

    void clearVideoTextureView(TextureView textureView);

    void decreaseDeviceVolume();

    Looper getApplicationLooper();

    AudioAttributes getAudioAttributes();

    Commands getAvailableCommands();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    List<Cue> getCurrentCues();

    long getCurrentLiveOffset();

    Object getCurrentManifest();

    MediaItem getCurrentMediaItem();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    List<Metadata> getCurrentStaticMetadata();

    @Deprecated
    Object getCurrentTag();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    DeviceInfo getDeviceInfo();

    int getDeviceVolume();

    long getDuration();

    MediaItem getMediaItemAt(int i11);

    int getMediaItemCount();

    MediaMetadata getMediaMetadata();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    @Deprecated
    ExoPlaybackException getPlaybackError();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    ExoPlaybackException getPlayerError();

    int getPreviousWindowIndex();

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    long getTotalBufferedDuration();

    VideoSize getVideoSize();

    float getVolume();

    boolean hasNext();

    boolean hasPrevious();

    void increaseDeviceVolume();

    boolean isCommandAvailable(int i11);

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowLive();

    boolean isCurrentWindowSeekable();

    boolean isDeviceMuted();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void moveMediaItem(int i11, int i12);

    void moveMediaItems(int i11, int i12, int i13);

    void next();

    void pause();

    void play();

    void prepare();

    void previous();

    void release();

    @Deprecated
    void removeListener(EventListener eventListener);

    void removeListener(Listener listener);

    void removeMediaItem(int i11);

    void removeMediaItems(int i11, int i12);

    void seekTo(int i11, long j11);

    void seekTo(long j11);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int i11);

    void setDeviceMuted(boolean z11);

    void setDeviceVolume(int i11);

    void setMediaItem(MediaItem mediaItem);

    void setMediaItem(MediaItem mediaItem, long j11);

    void setMediaItem(MediaItem mediaItem, boolean z11);

    void setMediaItems(List<MediaItem> list);

    void setMediaItems(List<MediaItem> list, int i11, long j11);

    void setMediaItems(List<MediaItem> list, boolean z11);

    void setPlayWhenReady(boolean z11);

    void setPlaybackParameters(PlaybackParameters playbackParameters);

    void setPlaybackSpeed(float f11);

    void setRepeatMode(int i11);

    void setShuffleModeEnabled(boolean z11);

    void setVideoSurface(Surface surface);

    void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

    void setVideoSurfaceView(SurfaceView surfaceView);

    void setVideoTextureView(TextureView textureView);

    void setVolume(float f11);

    void stop();

    @Deprecated
    void stop(boolean z11);
}

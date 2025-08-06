package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem implements Bundleable {
    public static final Bundleable.Creator<MediaItem> CREATOR = f0.f65911a;
    public static final String DEFAULT_MEDIA_ID = "";
    private static final int FIELD_CLIPPING_PROPERTIES = 3;
    private static final int FIELD_LIVE_CONFIGURATION = 1;
    private static final int FIELD_MEDIA_ID = 0;
    private static final int FIELD_MEDIA_METADATA = 2;
    public final ClippingProperties clippingProperties;
    public final LiveConfiguration liveConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;
    public final PlaybackProperties playbackProperties;

    public static final class AdsConfiguration {
        public final Uri adTagUri;
        public final Object adsId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            if (!this.adTagUri.equals(adsConfiguration.adTagUri) || !Util.areEqual(this.adsId, adsConfiguration.adsId)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.adTagUri.hashCode() * 31;
            Object obj = this.adsId;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }

        private AdsConfiguration(Uri uri, Object obj) {
            this.adTagUri = uri;
            this.adsId = obj;
        }
    }

    public static final class Builder {
        private Uri adTagUri;
        private Object adsId;
        private long clipEndPositionMs;
        private boolean clipRelativeToDefaultPosition;
        private boolean clipRelativeToLiveWindow;
        private long clipStartPositionMs;
        private boolean clipStartsAtKeyFrame;
        private String customCacheKey;
        private boolean drmForceDefaultLicenseUri;
        private byte[] drmKeySetId;
        private Map<String, String> drmLicenseRequestHeaders;
        private Uri drmLicenseUri;
        private boolean drmMultiSession;
        private boolean drmPlayClearContentWithoutKey;
        private List<Integer> drmSessionForClearTypes;
        private UUID drmUuid;
        private long liveMaxOffsetMs;
        private float liveMaxPlaybackSpeed;
        private long liveMinOffsetMs;
        private float liveMinPlaybackSpeed;
        private long liveTargetOffsetMs;
        private String mediaId;
        private MediaMetadata mediaMetadata;
        private String mimeType;
        private List<StreamKey> streamKeys;
        private List<Subtitle> subtitles;
        private Object tag;
        private Uri uri;

        public MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.drmLicenseUri == null || this.drmUuid != null);
            Uri uri2 = this.uri;
            if (uri2 != null) {
                String str = this.mimeType;
                UUID uuid = this.drmUuid;
                DrmConfiguration drmConfiguration = uuid != null ? new DrmConfiguration(uuid, this.drmLicenseUri, this.drmLicenseRequestHeaders, this.drmMultiSession, this.drmForceDefaultLicenseUri, this.drmPlayClearContentWithoutKey, this.drmSessionForClearTypes, this.drmKeySetId) : null;
                Uri uri3 = this.adTagUri;
                playbackProperties = new PlaybackProperties(uri2, str, drmConfiguration, uri3 != null ? new AdsConfiguration(uri3, this.adsId) : null, this.streamKeys, this.customCacheKey, this.subtitles, this.tag);
            } else {
                playbackProperties = null;
            }
            String str2 = this.mediaId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties clippingProperties = new ClippingProperties(this.clipStartPositionMs, this.clipEndPositionMs, this.clipRelativeToLiveWindow, this.clipRelativeToDefaultPosition, this.clipStartsAtKeyFrame);
            LiveConfiguration liveConfiguration = new LiveConfiguration(this.liveTargetOffsetMs, this.liveMinOffsetMs, this.liveMaxOffsetMs, this.liveMinPlaybackSpeed, this.liveMaxPlaybackSpeed);
            MediaMetadata mediaMetadata2 = this.mediaMetadata;
            if (mediaMetadata2 == null) {
                mediaMetadata2 = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, clippingProperties, playbackProperties, liveConfiguration, mediaMetadata2);
        }

        public Builder setAdTagUri(String str) {
            return setAdTagUri(str != null ? Uri.parse(str) : null);
        }

        public Builder setClipEndPositionMs(long j11) {
            Assertions.checkArgument(j11 == Long.MIN_VALUE || j11 >= 0);
            this.clipEndPositionMs = j11;
            return this;
        }

        public Builder setClipRelativeToDefaultPosition(boolean z11) {
            this.clipRelativeToDefaultPosition = z11;
            return this;
        }

        public Builder setClipRelativeToLiveWindow(boolean z11) {
            this.clipRelativeToLiveWindow = z11;
            return this;
        }

        public Builder setClipStartPositionMs(long j11) {
            Assertions.checkArgument(j11 >= 0);
            this.clipStartPositionMs = j11;
            return this;
        }

        public Builder setClipStartsAtKeyFrame(boolean z11) {
            this.clipStartsAtKeyFrame = z11;
            return this;
        }

        public Builder setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        public Builder setDrmForceDefaultLicenseUri(boolean z11) {
            this.drmForceDefaultLicenseUri = z11;
            return this;
        }

        public Builder setDrmKeySetId(byte[] bArr) {
            this.drmKeySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public Builder setDrmLicenseRequestHeaders(Map<String, String> map) {
            Map<String, String> map2;
            if (map == null || map.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(new HashMap(map));
            }
            this.drmLicenseRequestHeaders = map2;
            return this;
        }

        public Builder setDrmLicenseUri(Uri uri2) {
            this.drmLicenseUri = uri2;
            return this;
        }

        public Builder setDrmMultiSession(boolean z11) {
            this.drmMultiSession = z11;
            return this;
        }

        public Builder setDrmPlayClearContentWithoutKey(boolean z11) {
            this.drmPlayClearContentWithoutKey = z11;
            return this;
        }

        public Builder setDrmSessionForClearPeriods(boolean z11) {
            List list;
            if (z11) {
                list = Arrays.asList(new Integer[]{2, 1});
            } else {
                list = Collections.emptyList();
            }
            setDrmSessionForClearTypes(list);
            return this;
        }

        public Builder setDrmSessionForClearTypes(List<Integer> list) {
            List<Integer> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.drmSessionForClearTypes = list2;
            return this;
        }

        public Builder setDrmUuid(UUID uuid) {
            this.drmUuid = uuid;
            return this;
        }

        public Builder setLiveMaxOffsetMs(long j11) {
            this.liveMaxOffsetMs = j11;
            return this;
        }

        public Builder setLiveMaxPlaybackSpeed(float f11) {
            this.liveMaxPlaybackSpeed = f11;
            return this;
        }

        public Builder setLiveMinOffsetMs(long j11) {
            this.liveMinOffsetMs = j11;
            return this;
        }

        public Builder setLiveMinPlaybackSpeed(float f11) {
            this.liveMinPlaybackSpeed = f11;
            return this;
        }

        public Builder setLiveTargetOffsetMs(long j11) {
            this.liveTargetOffsetMs = j11;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mediaId = (String) Assertions.checkNotNull(str);
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata2) {
            this.mediaMetadata = mediaMetadata2;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setStreamKeys(List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.streamKeys = list2;
            return this;
        }

        public Builder setSubtitles(List<Subtitle> list) {
            List<Subtitle> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.subtitles = list2;
            return this;
        }

        public Builder setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setUri(String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.clipEndPositionMs = Long.MIN_VALUE;
            this.drmSessionForClearTypes = Collections.emptyList();
            this.drmLicenseRequestHeaders = Collections.emptyMap();
            this.streamKeys = Collections.emptyList();
            this.subtitles = Collections.emptyList();
            this.liveTargetOffsetMs = -9223372036854775807L;
            this.liveMinOffsetMs = -9223372036854775807L;
            this.liveMaxOffsetMs = -9223372036854775807L;
            this.liveMinPlaybackSpeed = -3.4028235E38f;
            this.liveMaxPlaybackSpeed = -3.4028235E38f;
        }

        public Builder setAdTagUri(Uri uri2) {
            return setAdTagUri(uri2, (Object) null);
        }

        public Builder setDrmLicenseUri(String str) {
            this.drmLicenseUri = str == null ? null : Uri.parse(str);
            return this;
        }

        public Builder setUri(Uri uri2) {
            this.uri = uri2;
            return this;
        }

        public Builder setAdTagUri(Uri uri2, Object obj) {
            this.adTagUri = uri2;
            this.adsId = obj;
            return this;
        }

        private Builder(MediaItem mediaItem) {
            this();
            ClippingProperties clippingProperties = mediaItem.clippingProperties;
            this.clipEndPositionMs = clippingProperties.endPositionMs;
            this.clipRelativeToLiveWindow = clippingProperties.relativeToLiveWindow;
            this.clipRelativeToDefaultPosition = clippingProperties.relativeToDefaultPosition;
            this.clipStartPositionMs = clippingProperties.startPositionMs;
            this.clipStartsAtKeyFrame = clippingProperties.startsAtKeyFrame;
            this.mediaId = mediaItem.mediaId;
            this.mediaMetadata = mediaItem.mediaMetadata;
            LiveConfiguration liveConfiguration = mediaItem.liveConfiguration;
            this.liveTargetOffsetMs = liveConfiguration.targetOffsetMs;
            this.liveMinOffsetMs = liveConfiguration.minOffsetMs;
            this.liveMaxOffsetMs = liveConfiguration.maxOffsetMs;
            this.liveMinPlaybackSpeed = liveConfiguration.minPlaybackSpeed;
            this.liveMaxPlaybackSpeed = liveConfiguration.maxPlaybackSpeed;
            PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                this.customCacheKey = playbackProperties.customCacheKey;
                this.mimeType = playbackProperties.mimeType;
                this.uri = playbackProperties.uri;
                this.streamKeys = playbackProperties.streamKeys;
                this.subtitles = playbackProperties.subtitles;
                this.tag = playbackProperties.tag;
                DrmConfiguration drmConfiguration = playbackProperties.drmConfiguration;
                if (drmConfiguration != null) {
                    this.drmLicenseUri = drmConfiguration.licenseUri;
                    this.drmLicenseRequestHeaders = drmConfiguration.requestHeaders;
                    this.drmMultiSession = drmConfiguration.multiSession;
                    this.drmForceDefaultLicenseUri = drmConfiguration.forceDefaultLicenseUri;
                    this.drmPlayClearContentWithoutKey = drmConfiguration.playClearContentWithoutKey;
                    this.drmSessionForClearTypes = drmConfiguration.sessionForClearTypes;
                    this.drmUuid = drmConfiguration.uuid;
                    this.drmKeySetId = drmConfiguration.getKeySetId();
                }
                AdsConfiguration adsConfiguration = playbackProperties.adsConfiguration;
                if (adsConfiguration != null) {
                    this.adTagUri = adsConfiguration.adTagUri;
                    this.adsId = adsConfiguration.adsId;
                }
            }
        }
    }

    public static final class ClippingProperties implements Bundleable {
        public static final Bundleable.Creator<ClippingProperties> CREATOR = g0.f65913a;
        private static final int FIELD_END_POSITION_MS = 1;
        private static final int FIELD_RELATIVE_TO_DEFAULT_POSITION = 3;
        private static final int FIELD_RELATIVE_TO_LIVE_WINDOW = 2;
        private static final int FIELD_STARTS_AT_KEY_FRAME = 4;
        private static final int FIELD_START_POSITION_MS = 0;
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ClippingProperties lambda$static$0(Bundle bundle) {
            return new ClippingProperties(bundle.getLong(keyForField(0), 0), bundle.getLong(keyForField(1), Long.MIN_VALUE), bundle.getBoolean(keyForField(2), false), bundle.getBoolean(keyForField(3), false), bundle.getBoolean(keyForField(4), false));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingProperties)) {
                return false;
            }
            ClippingProperties clippingProperties = (ClippingProperties) obj;
            if (this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j11 = this.startPositionMs;
            long j12 = this.endPositionMs;
            return (((((((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) ((j12 >>> 32) ^ j12))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.startPositionMs);
            bundle.putLong(keyForField(1), this.endPositionMs);
            bundle.putBoolean(keyForField(2), this.relativeToLiveWindow);
            bundle.putBoolean(keyForField(3), this.relativeToDefaultPosition);
            bundle.putBoolean(keyForField(4), this.startsAtKeyFrame);
            return bundle;
        }

        private ClippingProperties(long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.startPositionMs = j11;
            this.endPositionMs = j12;
            this.relativeToLiveWindow = z11;
            this.relativeToDefaultPosition = z12;
            this.startsAtKeyFrame = z13;
        }
    }

    public static final class DrmConfiguration {
        public final boolean forceDefaultLicenseUri;
        private final byte[] keySetId;
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final Map<String, String> requestHeaders;
        public final List<Integer> sessionForClearTypes;
        public final UUID uuid;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (!this.uuid.equals(drmConfiguration.uuid) || !Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) || !Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) || this.multiSession != drmConfiguration.multiSession || this.forceDefaultLicenseUri != drmConfiguration.forceDefaultLicenseUri || this.playClearContentWithoutKey != drmConfiguration.playClearContentWithoutKey || !this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes) || !Arrays.equals(this.keySetId, drmConfiguration.keySetId)) {
                return false;
            }
            return true;
        }

        public byte[] getKeySetId() {
            byte[] bArr = this.keySetId;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int hashCode = this.uuid.hashCode() * 31;
            Uri uri = this.licenseUri;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.sessionForClearTypes.hashCode()) * 31) + Arrays.hashCode(this.keySetId);
        }

        private DrmConfiguration(UUID uuid2, Uri uri, Map<String, String> map, boolean z11, boolean z12, boolean z13, List<Integer> list, byte[] bArr) {
            Assertions.checkArgument(!z12 || uri != null);
            this.uuid = uuid2;
            this.licenseUri = uri;
            this.requestHeaders = map;
            this.multiSession = z11;
            this.forceDefaultLicenseUri = z12;
            this.playClearContentWithoutKey = z13;
            this.sessionForClearTypes = list;
            this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }
    }

    public static final class LiveConfiguration implements Bundleable {
        public static final Bundleable.Creator<LiveConfiguration> CREATOR = h0.f65915a;
        private static final int FIELD_MAX_OFFSET_MS = 2;
        private static final int FIELD_MAX_PLAYBACK_SPEED = 4;
        private static final int FIELD_MIN_OFFSET_MS = 1;
        private static final int FIELD_MIN_PLAYBACK_SPEED = 3;
        private static final int FIELD_TARGET_OFFSET_MS = 0;
        public static final LiveConfiguration UNSET = new LiveConfiguration(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;

        public LiveConfiguration(long j11, long j12, long j13, float f11, float f12) {
            this.targetOffsetMs = j11;
            this.minOffsetMs = j12;
            this.maxOffsetMs = j13;
            this.minPlaybackSpeed = f11;
            this.maxPlaybackSpeed = f12;
        }

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LiveConfiguration lambda$static$0(Bundle bundle) {
            return new LiveConfiguration(bundle.getLong(keyForField(0), -9223372036854775807L), bundle.getLong(keyForField(1), -9223372036854775807L), bundle.getLong(keyForField(2), -9223372036854775807L), bundle.getFloat(keyForField(3), -3.4028235E38f), bundle.getFloat(keyForField(4), -3.4028235E38f));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            if (this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j11 = this.targetOffsetMs;
            long j12 = this.minOffsetMs;
            long j13 = this.maxOffsetMs;
            int i11 = ((((((int) (j11 ^ (j11 >>> 32))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) ((j13 >>> 32) ^ j13))) * 31;
            float f11 = this.minPlaybackSpeed;
            int i12 = 0;
            int floatToIntBits = (i11 + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.maxPlaybackSpeed;
            if (f12 != 0.0f) {
                i12 = Float.floatToIntBits(f12);
            }
            return floatToIntBits + i12;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.targetOffsetMs);
            bundle.putLong(keyForField(1), this.minOffsetMs);
            bundle.putLong(keyForField(2), this.maxOffsetMs);
            bundle.putFloat(keyForField(3), this.minPlaybackSpeed);
            bundle.putFloat(keyForField(4), this.maxPlaybackSpeed);
            return bundle;
        }
    }

    public static final class PlaybackProperties {
        public final AdsConfiguration adsConfiguration;
        public final String customCacheKey;
        public final DrmConfiguration drmConfiguration;
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final List<Subtitle> subtitles;
        public final Object tag;
        public final Uri uri;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            if (!this.uri.equals(playbackProperties.uri) || !Util.areEqual(this.mimeType, playbackProperties.mimeType) || !Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) || !Util.areEqual(this.adsConfiguration, playbackProperties.adsConfiguration) || !this.streamKeys.equals(playbackProperties.streamKeys) || !Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) || !this.subtitles.equals(playbackProperties.subtitles) || !Util.areEqual(this.tag, playbackProperties.tag)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int i11 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration2 = this.drmConfiguration;
            int hashCode3 = (hashCode2 + (drmConfiguration2 == null ? 0 : drmConfiguration2.hashCode())) * 31;
            AdsConfiguration adsConfiguration2 = this.adsConfiguration;
            int hashCode4 = (((hashCode3 + (adsConfiguration2 == null ? 0 : adsConfiguration2.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitles.hashCode()) * 31;
            Object obj = this.tag;
            if (obj != null) {
                i11 = obj.hashCode();
            }
            return hashCode5 + i11;
        }

        private PlaybackProperties(Uri uri2, String str, DrmConfiguration drmConfiguration2, AdsConfiguration adsConfiguration2, List<StreamKey> list, String str2, List<Subtitle> list2, Object obj) {
            this.uri = uri2;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration2;
            this.adsConfiguration = adsConfiguration2;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitles = list2;
            this.tag = obj;
        }
    }

    public static final class Subtitle {
        public final String label;
        public final String language;
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        public Subtitle(Uri uri2, String str, String str2) {
            this(uri2, str, str2, 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) obj;
            if (!this.uri.equals(subtitle.uri) || !this.mimeType.equals(subtitle.mimeType) || !Util.areEqual(this.language, subtitle.language) || this.selectionFlags != subtitle.selectionFlags || this.roleFlags != subtitle.roleFlags || !Util.areEqual(this.label, subtitle.label)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = ((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31;
            String str = this.language;
            int i11 = 0;
            int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str2 = this.label;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode2 + i11;
        }

        public Subtitle(Uri uri2, String str, String str2, int i11) {
            this(uri2, str, str2, i11, 0, (String) null);
        }

        public Subtitle(Uri uri2, String str, String str2, int i11, int i12, String str3) {
            this.uri = uri2;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i11;
            this.roleFlags = i12;
            this.label = str3;
        }
    }

    /* access modifiers changed from: private */
    public static MediaItem fromBundle(Bundle bundle) {
        LiveConfiguration liveConfiguration2;
        MediaMetadata mediaMetadata2;
        ClippingProperties clippingProperties2;
        Bundle bundle2 = bundle;
        String str = (String) Assertions.checkNotNull(bundle2.getString(keyForField(0), ""));
        Bundle bundle3 = bundle2.getBundle(keyForField(1));
        if (bundle3 == null) {
            liveConfiguration2 = LiveConfiguration.UNSET;
        } else {
            liveConfiguration2 = LiveConfiguration.CREATOR.fromBundle(bundle3);
        }
        LiveConfiguration liveConfiguration3 = liveConfiguration2;
        Bundle bundle4 = bundle2.getBundle(keyForField(2));
        if (bundle4 == null) {
            mediaMetadata2 = MediaMetadata.EMPTY;
        } else {
            mediaMetadata2 = MediaMetadata.CREATOR.fromBundle(bundle4);
        }
        MediaMetadata mediaMetadata3 = mediaMetadata2;
        Bundle bundle5 = bundle2.getBundle(keyForField(3));
        if (bundle5 == null) {
            clippingProperties2 = new ClippingProperties(0, Long.MIN_VALUE, false, false, false);
        } else {
            clippingProperties2 = ClippingProperties.CREATOR.fromBundle(bundle5);
        }
        return new MediaItem(str, clippingProperties2, (PlaybackProperties) null, liveConfiguration3, mediaMetadata3);
    }

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (!Util.areEqual(this.mediaId, mediaItem.mediaId) || !this.clippingProperties.equals(mediaItem.clippingProperties) || !Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) || !Util.areEqual(this.liveConfiguration, mediaItem.liveConfiguration) || !Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.mediaId.hashCode() * 31;
        PlaybackProperties playbackProperties2 = this.playbackProperties;
        return ((((((hashCode + (playbackProperties2 != null ? playbackProperties2.hashCode() : 0)) * 31) + this.liveConfiguration.hashCode()) * 31) + this.clippingProperties.hashCode()) * 31) + this.mediaMetadata.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), this.mediaId);
        bundle.putBundle(keyForField(1), this.liveConfiguration.toBundle());
        bundle.putBundle(keyForField(2), this.mediaMetadata.toBundle());
        bundle.putBundle(keyForField(3), this.clippingProperties.toBundle());
        return bundle;
    }

    private MediaItem(String str, ClippingProperties clippingProperties2, PlaybackProperties playbackProperties2, LiveConfiguration liveConfiguration2, MediaMetadata mediaMetadata2) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties2;
        this.liveConfiguration = liveConfiguration2;
        this.mediaMetadata = mediaMetadata2;
        this.clippingProperties = clippingProperties2;
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }
}

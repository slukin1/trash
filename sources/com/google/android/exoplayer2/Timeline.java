package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public abstract class Timeline implements Bundleable {
    public static final Bundleable.Creator<Timeline> CREATOR = w0.f66127a;
    public static final Timeline EMPTY = new Timeline() {
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        public Period getPeriod(int i11, Period period, boolean z11) {
            throw new IndexOutOfBoundsException();
        }

        public int getPeriodCount() {
            return 0;
        }

        public Object getUidOfPeriod(int i11) {
            throw new IndexOutOfBoundsException();
        }

        public Window getWindow(int i11, Window window, long j11) {
            throw new IndexOutOfBoundsException();
        }

        public int getWindowCount() {
            return 0;
        }
    };
    private static final int FIELD_PERIODS = 1;
    private static final int FIELD_SHUFFLED_WINDOW_INDICES = 2;
    private static final int FIELD_WINDOWS = 0;

    public static final class Period implements Bundleable {
        public static final Bundleable.Creator<Period> CREATOR = x0.f66129a;
        private static final int FIELD_AD_PLAYBACK_STATE = 4;
        private static final int FIELD_DURATION_US = 1;
        private static final int FIELD_PLACEHOLDER = 3;
        private static final int FIELD_POSITION_IN_WINDOW_US = 2;
        private static final int FIELD_WINDOW_INDEX = 0;
        /* access modifiers changed from: private */
        public AdPlaybackState adPlaybackState = AdPlaybackState.NONE;
        public long durationUs;

        /* renamed from: id  reason: collision with root package name */
        public Object f65680id;
        public boolean isPlaceholder;
        public long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        /* access modifiers changed from: private */
        public static Period fromBundle(Bundle bundle) {
            AdPlaybackState adPlaybackState2;
            int i11 = bundle.getInt(keyForField(0), 0);
            long j11 = bundle.getLong(keyForField(1), -9223372036854775807L);
            long j12 = bundle.getLong(keyForField(2), 0);
            boolean z11 = bundle.getBoolean(keyForField(3));
            Bundle bundle2 = bundle.getBundle(keyForField(4));
            if (bundle2 != null) {
                adPlaybackState2 = AdPlaybackState.CREATOR.fromBundle(bundle2);
            } else {
                adPlaybackState2 = AdPlaybackState.NONE;
            }
            AdPlaybackState adPlaybackState3 = adPlaybackState2;
            Period period = new Period();
            period.set((Object) null, (Object) null, i11, j11, j12, adPlaybackState3, z11);
            return period;
        }

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Period.class.equals(obj.getClass())) {
                return false;
            }
            Period period = (Period) obj;
            if (Util.areEqual(this.f65680id, period.f65680id) && Util.areEqual(this.uid, period.uid) && this.windowIndex == period.windowIndex && this.durationUs == period.durationUs && this.positionInWindowUs == period.positionInWindowUs && this.isPlaceholder == period.isPlaceholder && Util.areEqual(this.adPlaybackState, period.adPlaybackState)) {
                return true;
            }
            return false;
        }

        public int getAdCountInAdGroup(int i11) {
            return this.adPlaybackState.adGroups[i11].count;
        }

        public long getAdDurationUs(int i11, int i12) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i11];
            if (adGroup.count != -1) {
                return adGroup.durationsUs[i12];
            }
            return -9223372036854775807L;
        }

        public int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public int getAdGroupIndexAfterPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j11, this.durationUs);
        }

        public int getAdGroupIndexForPositionUs(long j11) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j11, this.durationUs);
        }

        public long getAdGroupTimeUs(int i11) {
            return this.adPlaybackState.adGroupTimesUs[i11];
        }

        public long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public Object getAdsId() {
            return this.adPlaybackState.adsId;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public int getFirstAdIndexToPlay(int i11) {
            return this.adPlaybackState.adGroups[i11].getFirstAdIndexToPlay();
        }

        public int getNextAdIndexToPlay(int i11, int i12) {
            return this.adPlaybackState.adGroups[i11].getNextAdIndexToPlay(i12);
        }

        public long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public boolean hasPlayedAdGroup(int i11) {
            return !this.adPlaybackState.adGroups[i11].hasUnplayedAds();
        }

        public int hashCode() {
            Object obj = this.f65680id;
            int i11 = 0;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.uid;
            if (obj2 != null) {
                i11 = obj2.hashCode();
            }
            long j11 = this.durationUs;
            long j12 = this.positionInWindowUs;
            return ((((((((((hashCode + i11) * 31) + this.windowIndex) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + this.adPlaybackState.hashCode();
        }

        public Period set(Object obj, Object obj2, int i11, long j11, long j12) {
            return set(obj, obj2, i11, j11, j12, AdPlaybackState.NONE, false);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(keyForField(0), this.windowIndex);
            bundle.putLong(keyForField(1), this.durationUs);
            bundle.putLong(keyForField(2), this.positionInWindowUs);
            bundle.putBoolean(keyForField(3), this.isPlaceholder);
            bundle.putBundle(keyForField(4), this.adPlaybackState.toBundle());
            return bundle;
        }

        public Period set(Object obj, Object obj2, int i11, long j11, long j12, AdPlaybackState adPlaybackState2, boolean z11) {
            this.f65680id = obj;
            this.uid = obj2;
            this.windowIndex = i11;
            this.durationUs = j11;
            this.positionInWindowUs = j12;
            this.adPlaybackState = adPlaybackState2;
            this.isPlaceholder = z11;
            return this;
        }
    }

    public static final class RemotableTimeline extends Timeline {
        private final ImmutableList<Period> periods;
        private final int[] shuffledWindowIndices;
        private final int[] windowIndicesInShuffled;
        private final ImmutableList<Window> windows;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            Assertions.checkArgument(immutableList.size() == iArr.length);
            this.windows = immutableList;
            this.periods = immutableList2;
            this.shuffledWindowIndices = iArr;
            this.windowIndicesInShuffled = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.windowIndicesInShuffled[iArr[i11]] = i11;
            }
        }

        public int getFirstWindowIndex(boolean z11) {
            if (isEmpty()) {
                return -1;
            }
            if (z11) {
                return this.shuffledWindowIndices[0];
            }
            return 0;
        }

        public int getIndexOfPeriod(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int getLastWindowIndex(boolean z11) {
            if (isEmpty()) {
                return -1;
            }
            if (z11) {
                return this.shuffledWindowIndices[getWindowCount() - 1];
            }
            return getWindowCount() - 1;
        }

        public int getNextWindowIndex(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != getLastWindowIndex(z11)) {
                return z11 ? this.shuffledWindowIndices[this.windowIndicesInShuffled[i11] + 1] : i11 + 1;
            }
            if (i12 == 2) {
                return getFirstWindowIndex(z11);
            }
            return -1;
        }

        public Period getPeriod(int i11, Period period, boolean z11) {
            Period period2 = this.periods.get(i11);
            period.set(period2.f65680id, period2.uid, period2.windowIndex, period2.durationUs, period2.positionInWindowUs, period2.adPlaybackState, period2.isPlaceholder);
            return period;
        }

        public int getPeriodCount() {
            return this.periods.size();
        }

        public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
            if (i12 == 1) {
                return i11;
            }
            if (i11 != getFirstWindowIndex(z11)) {
                return z11 ? this.shuffledWindowIndices[this.windowIndicesInShuffled[i11] - 1] : i11 - 1;
            }
            if (i12 == 2) {
                return getLastWindowIndex(z11);
            }
            return -1;
        }

        public Object getUidOfPeriod(int i11) {
            throw new UnsupportedOperationException();
        }

        public Window getWindow(int i11, Window window, long j11) {
            Window window2 = window;
            Window window3 = this.windows.get(i11);
            Object obj = window3.uid;
            MediaItem mediaItem = window3.mediaItem;
            MediaItem mediaItem2 = mediaItem;
            Window window4 = window3;
            Window window5 = window;
            window5.set(obj, mediaItem2, window3.manifest, window3.presentationStartTimeMs, window3.windowStartTimeMs, window3.elapsedRealtimeEpochOffsetMs, window3.isSeekable, window3.isDynamic, window3.liveConfiguration, window3.defaultPositionUs, window4.durationUs, window4.firstPeriodIndex, window4.lastPeriodIndex, window4.positionInFirstPeriodUs);
            Window window6 = window;
            window6.isPlaceholder = window4.isPlaceholder;
            return window6;
        }

        public int getWindowCount() {
            return this.windows.size();
        }
    }

    public static final class Window implements Bundleable {
        public static final Bundleable.Creator<Window> CREATOR = y0.f66131a;
        private static final MediaItem EMPTY_MEDIA_ITEM = new MediaItem.Builder().setMediaId("com.google.android.exoplayer2.Timeline").setUri(Uri.EMPTY).build();
        private static final Object FAKE_WINDOW_UID = new Object();
        private static final int FIELD_DEFAULT_POSITION_US = 9;
        private static final int FIELD_DURATION_US = 10;
        private static final int FIELD_ELAPSED_REALTIME_EPOCH_OFFSET_MS = 4;
        private static final int FIELD_FIRST_PERIOD_INDEX = 11;
        private static final int FIELD_IS_DYNAMIC = 6;
        private static final int FIELD_IS_PLACEHOLDER = 8;
        private static final int FIELD_IS_SEEKABLE = 5;
        private static final int FIELD_LAST_PERIOD_INDEX = 12;
        private static final int FIELD_LIVE_CONFIGURATION = 7;
        private static final int FIELD_MEDIA_ITEM = 1;
        private static final int FIELD_POSITION_IN_FIRST_PERIOD_US = 13;
        private static final int FIELD_PRESENTATION_START_TIME_MS = 2;
        private static final int FIELD_WINDOW_START_TIME_MS = 3;
        public static final Object SINGLE_WINDOW_UID = new Object();
        public long defaultPositionUs;
        public long durationUs;
        public long elapsedRealtimeEpochOffsetMs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        @Deprecated
        public boolean isLive;
        public boolean isPlaceholder;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public MediaItem.LiveConfiguration liveConfiguration;
        public Object manifest;
        public MediaItem mediaItem = EMPTY_MEDIA_ITEM;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;
        @Deprecated
        public Object tag;
        public Object uid = SINGLE_WINDOW_UID;
        public long windowStartTimeMs;

        /* access modifiers changed from: private */
        public static Window fromBundle(Bundle bundle) {
            Bundle bundle2 = bundle;
            Bundle bundle3 = bundle2.getBundle(keyForField(1));
            MediaItem.LiveConfiguration liveConfiguration2 = null;
            MediaItem fromBundle = bundle3 != null ? MediaItem.CREATOR.fromBundle(bundle3) : null;
            long j11 = bundle2.getLong(keyForField(2), -9223372036854775807L);
            long j12 = bundle2.getLong(keyForField(3), -9223372036854775807L);
            long j13 = bundle2.getLong(keyForField(4), -9223372036854775807L);
            boolean z11 = bundle2.getBoolean(keyForField(5), false);
            boolean z12 = bundle2.getBoolean(keyForField(6), false);
            Bundle bundle4 = bundle2.getBundle(keyForField(7));
            if (bundle4 != null) {
                liveConfiguration2 = MediaItem.LiveConfiguration.CREATOR.fromBundle(bundle4);
            }
            boolean z13 = bundle2.getBoolean(keyForField(8), false);
            long j14 = bundle2.getLong(keyForField(9), 0);
            long j15 = bundle2.getLong(keyForField(10), -9223372036854775807L);
            int i11 = bundle2.getInt(keyForField(11), 0);
            int i12 = bundle2.getInt(keyForField(12), 0);
            long j16 = bundle2.getLong(keyForField(13), 0);
            Window window = r0;
            Window window2 = new Window();
            window.set(FAKE_WINDOW_UID, fromBundle, (Object) null, j11, j12, j13, z11, z12, liveConfiguration2, j14, j15, i11, i12, j16);
            window2.isPlaceholder = z13;
            return window2;
        }

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Window.class.equals(obj.getClass())) {
                return false;
            }
            Window window = (Window) obj;
            if (Util.areEqual(this.uid, window.uid) && Util.areEqual(this.mediaItem, window.mediaItem) && Util.areEqual(this.manifest, window.manifest) && Util.areEqual(this.liveConfiguration, window.liveConfiguration) && this.presentationStartTimeMs == window.presentationStartTimeMs && this.windowStartTimeMs == window.windowStartTimeMs && this.elapsedRealtimeEpochOffsetMs == window.elapsedRealtimeEpochOffsetMs && this.isSeekable == window.isSeekable && this.isDynamic == window.isDynamic && this.isPlaceholder == window.isPlaceholder && this.defaultPositionUs == window.defaultPositionUs && this.durationUs == window.durationUs && this.firstPeriodIndex == window.firstPeriodIndex && this.lastPeriodIndex == window.lastPeriodIndex && this.positionInFirstPeriodUs == window.positionInFirstPeriodUs) {
                return true;
            }
            return false;
        }

        public long getCurrentUnixTimeMs() {
            return Util.getNowUnixTimeMs(this.elapsedRealtimeEpochOffsetMs);
        }

        public long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public int hashCode() {
            int hashCode = (((217 + this.uid.hashCode()) * 31) + this.mediaItem.hashCode()) * 31;
            Object obj = this.manifest;
            int i11 = 0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration2 = this.liveConfiguration;
            if (liveConfiguration2 != null) {
                i11 = liveConfiguration2.hashCode();
            }
            long j11 = this.presentationStartTimeMs;
            long j12 = this.windowStartTimeMs;
            long j13 = this.elapsedRealtimeEpochOffsetMs;
            long j14 = this.defaultPositionUs;
            long j15 = this.durationUs;
            long j16 = this.positionInFirstPeriodUs;
            return ((((((((((((((((((((((hashCode2 + i11) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.isSeekable ? 1 : 0)) * 31) + (this.isDynamic ? 1 : 0)) * 31) + (this.isPlaceholder ? 1 : 0)) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.firstPeriodIndex) * 31) + this.lastPeriodIndex) * 31) + ((int) (j16 ^ (j16 >>> 32)));
        }

        public boolean isLive() {
            Assertions.checkState(this.isLive == (this.liveConfiguration != null));
            if (this.liveConfiguration != null) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            r1 = r1.playbackProperties;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.Timeline.Window set(java.lang.Object r6, com.google.android.exoplayer2.MediaItem r7, java.lang.Object r8, long r9, long r11, long r13, boolean r15, boolean r16, com.google.android.exoplayer2.MediaItem.LiveConfiguration r17, long r18, long r20, int r22, int r23, long r24) {
            /*
                r5 = this;
                r0 = r5
                r1 = r7
                r2 = r17
                r3 = r6
                r0.uid = r3
                if (r1 == 0) goto L_0x000b
                r3 = r1
                goto L_0x000d
            L_0x000b:
                com.google.android.exoplayer2.MediaItem r3 = EMPTY_MEDIA_ITEM
            L_0x000d:
                r0.mediaItem = r3
                if (r1 == 0) goto L_0x0018
                com.google.android.exoplayer2.MediaItem$PlaybackProperties r1 = r1.playbackProperties
                if (r1 == 0) goto L_0x0018
                java.lang.Object r1 = r1.tag
                goto L_0x0019
            L_0x0018:
                r1 = 0
            L_0x0019:
                r0.tag = r1
                r1 = r8
                r0.manifest = r1
                r3 = r9
                r0.presentationStartTimeMs = r3
                r3 = r11
                r0.windowStartTimeMs = r3
                r3 = r13
                r0.elapsedRealtimeEpochOffsetMs = r3
                r1 = r15
                r0.isSeekable = r1
                r1 = r16
                r0.isDynamic = r1
                r1 = 0
                if (r2 == 0) goto L_0x0033
                r3 = 1
                goto L_0x0034
            L_0x0033:
                r3 = r1
            L_0x0034:
                r0.isLive = r3
                r0.liveConfiguration = r2
                r2 = r18
                r0.defaultPositionUs = r2
                r2 = r20
                r0.durationUs = r2
                r2 = r22
                r0.firstPeriodIndex = r2
                r2 = r23
                r0.lastPeriodIndex = r2
                r2 = r24
                r0.positionInFirstPeriodUs = r2
                r0.isPlaceholder = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.Timeline.Window.set(java.lang.Object, com.google.android.exoplayer2.MediaItem, java.lang.Object, long, long, long, boolean, boolean, com.google.android.exoplayer2.MediaItem$LiveConfiguration, long, long, int, int, long):com.google.android.exoplayer2.Timeline$Window");
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(keyForField(1), this.mediaItem.toBundle());
            bundle.putLong(keyForField(2), this.presentationStartTimeMs);
            bundle.putLong(keyForField(3), this.windowStartTimeMs);
            bundle.putLong(keyForField(4), this.elapsedRealtimeEpochOffsetMs);
            bundle.putBoolean(keyForField(5), this.isSeekable);
            bundle.putBoolean(keyForField(6), this.isDynamic);
            MediaItem.LiveConfiguration liveConfiguration2 = this.liveConfiguration;
            if (liveConfiguration2 != null) {
                bundle.putBundle(keyForField(7), liveConfiguration2.toBundle());
            }
            bundle.putBoolean(keyForField(8), this.isPlaceholder);
            bundle.putLong(keyForField(9), this.defaultPositionUs);
            bundle.putLong(keyForField(10), this.durationUs);
            bundle.putInt(keyForField(11), this.firstPeriodIndex);
            bundle.putInt(keyForField(12), this.lastPeriodIndex);
            bundle.putLong(keyForField(13), this.positionInFirstPeriodUs);
            return bundle;
        }
    }

    /* access modifiers changed from: private */
    public static Timeline fromBundle(Bundle bundle) {
        ImmutableList<Window> fromBundleListRetriever = fromBundleListRetriever(Window.CREATOR, BundleUtil.getBinder(bundle, keyForField(0)));
        ImmutableList<Period> fromBundleListRetriever2 = fromBundleListRetriever(Period.CREATOR, BundleUtil.getBinder(bundle, keyForField(1)));
        int[] intArray = bundle.getIntArray(keyForField(2));
        if (intArray == null) {
            intArray = generateUnshuffledIndices(fromBundleListRetriever.size());
        }
        return new RemotableTimeline(fromBundleListRetriever, fromBundleListRetriever2, intArray);
    }

    private static <T extends Bundleable> ImmutableList<T> fromBundleListRetriever(Bundleable.Creator<T> creator, IBinder iBinder) {
        if (iBinder == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Bundle> list = BundleListRetriever.getList(iBinder);
        for (int i11 = 0; i11 < list.size(); i11++) {
            builder.add((Object) creator.fromBundle(list.get(i11)));
        }
        return builder.build();
    }

    private static int[] generateUnshuffledIndices(int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = i12;
        }
        return iArr;
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.getWindowCount() != getWindowCount() || timeline.getPeriodCount() != getPeriodCount()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i11 = 0; i11 < getWindowCount(); i11++) {
            if (!getWindow(i11, window).equals(timeline.getWindow(i11, window2))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < getPeriodCount(); i12++) {
            if (!getPeriod(i12, period, true).equals(timeline.getPeriod(i12, period2, true))) {
                return false;
            }
        }
        return true;
    }

    public int getFirstWindowIndex(boolean z11) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z11) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i11, Period period, Window window, int i12, boolean z11) {
        int i13 = getPeriod(i11, period).windowIndex;
        if (getWindow(i13, window).lastPeriodIndex != i11) {
            return i11 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i13, i12, z11);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i11, int i12, boolean z11) {
        if (i12 != 0) {
            if (i12 == 1) {
                return i11;
            }
            if (i12 == 2) {
                return i11 == getLastWindowIndex(z11) ? getFirstWindowIndex(z11) : i11 + 1;
            }
            throw new IllegalStateException();
        } else if (i11 == getLastWindowIndex(z11)) {
            return -1;
        } else {
            return i11 + 1;
        }
    }

    public final Period getPeriod(int i11, Period period) {
        return getPeriod(i11, period, false);
    }

    public abstract Period getPeriod(int i11, Period period, boolean z11);

    public Period getPeriodByUid(Object obj, Period period) {
        return getPeriod(getIndexOfPeriod(obj), period, true);
    }

    public abstract int getPeriodCount();

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i11, long j11) {
        return (Pair) Assertions.checkNotNull(getPeriodPosition(window, period, i11, j11, 0));
    }

    public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
        if (i12 != 0) {
            if (i12 == 1) {
                return i11;
            }
            if (i12 == 2) {
                return i11 == getFirstWindowIndex(z11) ? getLastWindowIndex(z11) : i11 - 1;
            }
            throw new IllegalStateException();
        } else if (i11 == getFirstWindowIndex(z11)) {
            return -1;
        } else {
            return i11 - 1;
        }
    }

    public abstract Object getUidOfPeriod(int i11);

    public final Window getWindow(int i11, Window window) {
        return getWindow(i11, window, 0);
    }

    public abstract Window getWindow(int i11, Window window, long j11);

    public abstract int getWindowCount();

    public int hashCode() {
        Window window = new Window();
        Period period = new Period();
        int windowCount = 217 + getWindowCount();
        for (int i11 = 0; i11 < getWindowCount(); i11++) {
            windowCount = (windowCount * 31) + getWindow(i11, window).hashCode();
        }
        int periodCount = (windowCount * 31) + getPeriodCount();
        for (int i12 = 0; i12 < getPeriodCount(); i12++) {
            periodCount = (periodCount * 31) + getPeriod(i12, period, true).hashCode();
        }
        return periodCount;
    }

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i11, Period period, Window window, int i12, boolean z11) {
        return getNextPeriodIndex(i11, period, window, i12, z11) == -1;
    }

    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int windowCount = getWindowCount();
        Window window = new Window();
        for (int i11 = 0; i11 < windowCount; i11++) {
            arrayList.add(getWindow(i11, window, 0).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int periodCount = getPeriodCount();
        Period period = new Period();
        for (int i12 = 0; i12 < periodCount; i12++) {
            arrayList2.add(getPeriod(i12, period, false).toBundle());
        }
        int[] iArr = new int[windowCount];
        if (windowCount > 0) {
            iArr[0] = getFirstWindowIndex(true);
        }
        for (int i13 = 1; i13 < windowCount; i13++) {
            iArr[i13] = getNextWindowIndex(iArr[i13 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.putBinder(bundle, keyForField(0), new BundleListRetriever(arrayList));
        BundleUtil.putBinder(bundle, keyForField(1), new BundleListRetriever(arrayList2));
        bundle.putIntArray(keyForField(2), iArr);
        return bundle;
    }

    @Deprecated
    public final Window getWindow(int i11, Window window, boolean z11) {
        return getWindow(i11, window, 0);
    }

    public final Pair<Object, Long> getPeriodPosition(Window window, Period period, int i11, long j11, long j12) {
        Assertions.checkIndex(i11, 0, getWindowCount());
        getWindow(i11, window, j12);
        if (j11 == -9223372036854775807L) {
            j11 = window.getDefaultPositionUs();
            if (j11 == -9223372036854775807L) {
                return null;
            }
        }
        int i12 = window.firstPeriodIndex;
        getPeriod(i12, period);
        while (i12 < window.lastPeriodIndex && period.positionInWindowUs != j11) {
            int i13 = i12 + 1;
            if (getPeriod(i13, period).positionInWindowUs > j11) {
                break;
            }
            i12 = i13;
        }
        getPeriod(i12, period, true);
        return Pair.create(Assertions.checkNotNull(period.uid), Long.valueOf(j11 - period.positionInWindowUs));
    }
}

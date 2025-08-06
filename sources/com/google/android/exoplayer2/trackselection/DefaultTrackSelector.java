package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DefaultTrackSelector extends MappingTrackSelector {
    /* access modifiers changed from: private */
    public static final Ordering<Integer> FORMAT_VALUE_ORDERING = Ordering.from(c.f66069b);
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    /* access modifiers changed from: private */
    public static final Ordering<Integer> NO_ORDER = Ordering.from(b.f66068b);
    private static final int[] NO_TRACKS = new int[0];
    private final AtomicReference<Parameters> parametersReference;
    private final ExoTrackSelection.Factory trackSelectionFactory;

    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredMimeTypeMatchIndex;
        private final int preferredRoleFlagsScore;
        private final int sampleRate;

        public AudioTrackScore(Format format, Parameters parameters2, int i11) {
            int i12;
            int i13;
            int i14;
            this.parameters = parameters2;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i15 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i11, false);
            int i16 = 0;
            while (true) {
                i12 = Integer.MAX_VALUE;
                if (i16 >= parameters2.preferredAudioLanguages.size()) {
                    i13 = 0;
                    i16 = Integer.MAX_VALUE;
                    break;
                }
                i13 = DefaultTrackSelector.getFormatLanguageScore(format, parameters2.preferredAudioLanguages.get(i16), false);
                if (i13 > 0) {
                    break;
                }
                i16++;
            }
            this.preferredLanguageIndex = i16;
            this.preferredLanguageScore = i13;
            this.preferredRoleFlagsScore = Integer.bitCount(format.roleFlags & parameters2.preferredAudioRoleFlags);
            boolean z11 = true;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            int i17 = format.channelCount;
            this.channelCount = i17;
            this.sampleRate = format.sampleRate;
            int i18 = format.bitrate;
            this.bitrate = i18;
            if ((i18 != -1 && i18 > parameters2.maxAudioBitrate) || (i17 != -1 && i17 > parameters2.maxAudioChannelCount)) {
                z11 = false;
            }
            this.isWithinConstraints = z11;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i19 = 0;
            while (true) {
                if (i19 >= systemLanguageCodes.length) {
                    i14 = 0;
                    i19 = Integer.MAX_VALUE;
                    break;
                }
                i14 = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i19], false);
                if (i14 > 0) {
                    break;
                }
                i19++;
            }
            this.localeLanguageMatchIndex = i19;
            this.localeLanguageScore = i14;
            while (true) {
                if (i15 < parameters2.preferredAudioMimeTypes.size()) {
                    String str = format.sampleMimeType;
                    if (str != null && str.equals(parameters2.preferredAudioMimeTypes.get(i15))) {
                        i12 = i15;
                        break;
                    }
                    i15++;
                } else {
                    break;
                }
            }
            this.preferredMimeTypeMatchIndex = i12;
        }

        public int compareTo(AudioTrackScore audioTrackScore) {
            Ordering ordering;
            if (!this.isWithinConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, audioTrackScore.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(audioTrackScore.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, audioTrackScore.preferredLanguageScore).compare(this.preferredRoleFlagsScore, audioTrackScore.preferredRoleFlagsScore).compareFalseFirst(this.isWithinConstraints, audioTrackScore.isWithinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(audioTrackScore.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(audioTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compareFalseFirst(this.isDefaultSelectionFlag, audioTrackScore.isDefaultSelectionFlag).compare(Integer.valueOf(this.localeLanguageMatchIndex), Integer.valueOf(audioTrackScore.localeLanguageMatchIndex), Ordering.natural().reverse()).compare(this.localeLanguageScore, audioTrackScore.localeLanguageScore).compare(Integer.valueOf(this.channelCount), Integer.valueOf(audioTrackScore.channelCount), ordering).compare(Integer.valueOf(this.sampleRate), Integer.valueOf(audioTrackScore.sampleRate), ordering);
            Integer valueOf = Integer.valueOf(this.bitrate);
            Integer valueOf2 = Integer.valueOf(audioTrackScore.bitrate);
            if (!Util.areEqual(this.language, audioTrackScore.language)) {
                ordering = DefaultTrackSelector.NO_ORDER;
            }
            return compare.compare(valueOf, valueOf2, ordering).result();
        }
    }

    public static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean isDefault;
        private final boolean isWithinRendererCapabilities;

        public OtherTrackScore(Format format, int i11) {
            this.isDefault = (format.selectionFlags & 1) == 0 ? false : true;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i11, false);
        }

        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, otherTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isDefault, otherTrackScore.isDefault).result();
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            public Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            public Parameters[] newArray(int i11) {
                return new Parameters[i11];
            }
        };
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowMultipleAdaptiveSelections;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final int minVideoBitrate;
        public final int minVideoFrameRate;
        public final int minVideoHeight;
        public final int minVideoWidth;
        public final ImmutableList<String> preferredAudioMimeTypes;
        public final ImmutableList<String> preferredVideoMimeTypes;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final boolean tunnelingEnabled;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Parameters(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11, boolean z12, boolean z13, int i19, int i21, boolean z14, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, int i22, int i23, int i24, boolean z15, boolean z16, boolean z17, boolean z18, ImmutableList<String> immutableList3, ImmutableList<String> immutableList4, int i25, boolean z19, int i26, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(immutableList2, i22, immutableList4, i25, z19, i26);
            this.maxVideoWidth = i11;
            this.maxVideoHeight = i12;
            this.maxVideoFrameRate = i13;
            this.maxVideoBitrate = i14;
            this.minVideoWidth = i15;
            this.minVideoHeight = i16;
            this.minVideoFrameRate = i17;
            this.minVideoBitrate = i18;
            this.exceedVideoConstraintsIfNecessary = z11;
            this.allowVideoMixedMimeTypeAdaptiveness = z12;
            this.allowVideoNonSeamlessAdaptiveness = z13;
            this.viewportWidth = i19;
            this.viewportHeight = i21;
            this.viewportOrientationMayChange = z14;
            this.preferredVideoMimeTypes = immutableList;
            this.maxAudioChannelCount = i23;
            this.maxAudioBitrate = i24;
            this.exceedAudioConstraintsIfNecessary = z15;
            this.allowAudioMixedMimeTypeAdaptiveness = z16;
            this.allowAudioMixedSampleRateAdaptiveness = z17;
            this.allowAudioMixedChannelCountAdaptiveness = z18;
            this.preferredAudioMimeTypes = immutableList3;
            this.forceLowestBitrate = z21;
            this.forceHighestSupportedBitrate = z22;
            this.exceedRendererCapabilitiesIfNecessary = z23;
            this.tunnelingEnabled = z24;
            this.allowMultipleAdaptiveSelections = z25;
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i11)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i11 = 0; i11 < size; i11++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i11));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i11), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i12 = 0; i12 < readInt3; i12++) {
                    hashMap.put((TrackGroupArray) Assertions.checkNotNull((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                int keyAt = sparseArray.keyAt(i11);
                Map valueAt = sparseArray.valueAt(i11);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            if (super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.minVideoWidth == parameters.minVideoWidth && this.minVideoHeight == parameters.minVideoHeight && this.minVideoFrameRate == parameters.minVideoFrameRate && this.minVideoBitrate == parameters.minVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.preferredVideoMimeTypes.equals(parameters.preferredVideoMimeTypes) && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.preferredAudioMimeTypes.equals(parameters.preferredAudioMimeTypes) && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == parameters.allowMultipleAdaptiveSelections && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                return true;
            }
            return false;
        }

        public final boolean getRendererDisabled(int i11) {
            return this.rendererDisabledFlags.get(i11);
        }

        public final SelectionOverride getSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i11);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean hasSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i11);
            return map != null && map.containsKey(trackGroupArray);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.preferredVideoMimeTypes.hashCode()) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + this.preferredAudioMimeTypes.hashCode()) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            parcel.writeInt(this.minVideoWidth);
            parcel.writeInt(this.minVideoHeight);
            parcel.writeInt(this.minVideoFrameRate);
            parcel.writeInt(this.minVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeList(this.preferredVideoMimeTypes);
            parcel.writeInt(this.maxAudioChannelCount);
            parcel.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            parcel.writeList(this.preferredAudioMimeTypes);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            Util.writeBoolean(parcel, this.tunnelingEnabled);
            Util.writeBoolean(parcel, this.allowMultipleAdaptiveSelections);
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
        }

        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.google.android.exoplayer2.source.TrackGroupArray, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.google.android.exoplayer2.source.TrackGroupArray r1 = (com.google.android.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.google.android.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }

        public Parameters(Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.minVideoWidth = parcel.readInt();
            this.minVideoHeight = parcel.readInt();
            this.minVideoFrameRate = parcel.readInt();
            this.minVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, (ClassLoader) null);
            this.preferredVideoMimeTypes = ImmutableList.copyOf(arrayList);
            this.maxAudioChannelCount = parcel.readInt();
            this.maxAudioBitrate = parcel.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel);
            ArrayList arrayList2 = new ArrayList();
            parcel.readList(arrayList2, (ClassLoader) null);
            this.preferredAudioMimeTypes = ImmutableList.copyOf(arrayList2);
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.tunnelingEnabled = Util.readBoolean(parcel);
            this.allowMultipleAdaptiveSelections = Util.readBoolean(parcel);
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = (SparseBooleanArray) Util.castNonNull(parcel.readSparseBooleanArray());
        }
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private boolean allowAudioMixedChannelCountAdaptiveness;
        private boolean allowAudioMixedMimeTypeAdaptiveness;
        private boolean allowAudioMixedSampleRateAdaptiveness;
        private boolean allowMultipleAdaptiveSelections;
        private boolean allowVideoMixedMimeTypeAdaptiveness;
        private boolean allowVideoNonSeamlessAdaptiveness;
        private boolean exceedAudioConstraintsIfNecessary;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private int minVideoBitrate;
        private int minVideoFrameRate;
        private int minVideoHeight;
        private int minVideoWidth;
        private ImmutableList<String> preferredAudioMimeTypes;
        private ImmutableList<String> preferredVideoMimeTypes;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private boolean tunnelingEnabled;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                sparseArray2.put(sparseArray.keyAt(i11), new HashMap(sparseArray.valueAt(i11)));
            }
            return sparseArray2;
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioMimeTypes"})
        private void setInitialValuesWithoutContext() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.preferredVideoMimeTypes = ImmutableList.of();
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.preferredAudioMimeTypes = ImmutableList.of();
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingEnabled = false;
            this.allowMultipleAdaptiveSelections = true;
        }

        public final ParametersBuilder clearSelectionOverride(int i11, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i11);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i11);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i11) {
            Map map = this.selectionOverrides.get(i11);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i11);
            }
            return this;
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z11) {
            this.allowAudioMixedChannelCountAdaptiveness = z11;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z11) {
            this.allowAudioMixedMimeTypeAdaptiveness = z11;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z11) {
            this.allowAudioMixedSampleRateAdaptiveness = z11;
            return this;
        }

        public ParametersBuilder setAllowMultipleAdaptiveSelections(boolean z11) {
            this.allowMultipleAdaptiveSelections = z11;
            return this;
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z11) {
            this.allowVideoMixedMimeTypeAdaptiveness = z11;
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z11) {
            this.allowVideoNonSeamlessAdaptiveness = z11;
            return this;
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z11) {
            this.exceedAudioConstraintsIfNecessary = z11;
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z11) {
            this.exceedRendererCapabilitiesIfNecessary = z11;
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z11) {
            this.exceedVideoConstraintsIfNecessary = z11;
            return this;
        }

        public ParametersBuilder setForceHighestSupportedBitrate(boolean z11) {
            this.forceHighestSupportedBitrate = z11;
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z11) {
            this.forceLowestBitrate = z11;
            return this;
        }

        public ParametersBuilder setMaxAudioBitrate(int i11) {
            this.maxAudioBitrate = i11;
            return this;
        }

        public ParametersBuilder setMaxAudioChannelCount(int i11) {
            this.maxAudioChannelCount = i11;
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int i11) {
            this.maxVideoBitrate = i11;
            return this;
        }

        public ParametersBuilder setMaxVideoFrameRate(int i11) {
            this.maxVideoFrameRate = i11;
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int i11, int i12) {
            this.maxVideoWidth = i11;
            this.maxVideoHeight = i12;
            return this;
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public ParametersBuilder setMinVideoBitrate(int i11) {
            this.minVideoBitrate = i11;
            return this;
        }

        public ParametersBuilder setMinVideoFrameRate(int i11) {
            this.minVideoFrameRate = i11;
            return this;
        }

        public ParametersBuilder setMinVideoSize(int i11, int i12) {
            this.minVideoWidth = i11;
            this.minVideoHeight = i12;
            return this;
        }

        public ParametersBuilder setPreferredAudioMimeType(String str) {
            if (str == null) {
                return setPreferredAudioMimeTypes(new String[0]);
            }
            return setPreferredAudioMimeTypes(str);
        }

        public ParametersBuilder setPreferredAudioMimeTypes(String... strArr) {
            this.preferredAudioMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        public ParametersBuilder setPreferredVideoMimeType(String str) {
            if (str == null) {
                return setPreferredVideoMimeTypes(new String[0]);
            }
            return setPreferredVideoMimeTypes(str);
        }

        public ParametersBuilder setPreferredVideoMimeTypes(String... strArr) {
            this.preferredVideoMimeTypes = ImmutableList.copyOf((E[]) strArr);
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i11, boolean z11) {
            if (this.rendererDisabledFlags.get(i11) == z11) {
                return this;
            }
            if (z11) {
                this.rendererDisabledFlags.put(i11, true);
            } else {
                this.rendererDisabledFlags.delete(i11);
            }
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i11, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            Map map = this.selectionOverrides.get(i11);
            if (map == null) {
                map = new HashMap();
                this.selectionOverrides.put(i11, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public ParametersBuilder setTunnelingEnabled(boolean z11) {
            this.tunnelingEnabled = z11;
            return this;
        }

        public ParametersBuilder setViewportSize(int i11, int i12, boolean z11) {
            this.viewportWidth = i11;
            this.viewportHeight = i12;
            this.viewportOrientationMayChange = z11;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z11) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z11);
        }

        @Deprecated
        public ParametersBuilder() {
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
        }

        public Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.minVideoWidth, this.minVideoHeight, this.minVideoFrameRate, this.minVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredVideoMimeTypes, this.preferredAudioLanguages, this.preferredAudioRoleFlags, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredAudioMimeTypes, this.preferredTextLanguages, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingEnabled, this.allowMultipleAdaptiveSelections, this.selectionOverrides, this.rendererDisabledFlags);
        }

        public ParametersBuilder setDisabledTextTrackSelectionFlags(int i11) {
            super.setDisabledTextTrackSelectionFlags(i11);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguage(String str) {
            super.setPreferredAudioLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredAudioLanguages(String... strArr) {
            super.setPreferredAudioLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredAudioRoleFlags(int i11) {
            super.setPreferredAudioRoleFlags(i11);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguage(String str) {
            super.setPreferredTextLanguage(str);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        public ParametersBuilder setPreferredTextLanguages(String... strArr) {
            super.setPreferredTextLanguages(strArr);
            return this;
        }

        public ParametersBuilder setPreferredTextRoleFlags(int i11) {
            super.setPreferredTextRoleFlags(i11);
            return this;
        }

        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z11) {
            super.setSelectUndeterminedTextLanguage(z11);
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        public ParametersBuilder(Context context) {
            super(context);
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        private ParametersBuilder(Parameters parameters) {
            super((TrackSelectionParameters) parameters);
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoFrameRate = parameters.maxVideoFrameRate;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.minVideoWidth = parameters.minVideoWidth;
            this.minVideoHeight = parameters.minVideoHeight;
            this.minVideoFrameRate = parameters.minVideoFrameRate;
            this.minVideoBitrate = parameters.minVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = parameters.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
            this.preferredVideoMimeTypes = parameters.preferredVideoMimeTypes;
            this.maxAudioChannelCount = parameters.maxAudioChannelCount;
            this.maxAudioBitrate = parameters.maxAudioBitrate;
            this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = parameters.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = parameters.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = parameters.allowAudioMixedChannelCountAdaptiveness;
            this.preferredAudioMimeTypes = parameters.preferredAudioMimeTypes;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = parameters.forceHighestSupportedBitrate;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingEnabled = parameters.tunnelingEnabled;
            this.allowMultipleAdaptiveSelections = parameters.allowMultipleAdaptiveSelections;
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            public SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            public SelectionOverride[] newArray(int i11) {
                return new SelectionOverride[i11];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;
        public final int type;

        public SelectionOverride(int i11, int... iArr) {
            this(i11, iArr, 0);
        }

        public boolean containsTrack(int i11) {
            for (int i12 : this.tracks) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            if (this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.type == selectionOverride.type) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.type;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.type);
        }

        public SelectionOverride(int i11, int[] iArr, int i12) {
            this.groupIndex = i11;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            this.type = i12;
            Arrays.sort(copyOf);
        }

        public SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
            this.type = parcel.readInt();
        }
    }

    public static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean isDefault;
        private final boolean isForced;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageIndex;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format, Parameters parameters, int i11, String str) {
            ImmutableList<String> immutableList;
            int i12;
            boolean z11 = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i11, false);
            int i13 = format.selectionFlags & (~parameters.disabledTextTrackSelectionFlags);
            this.isDefault = (i13 & 1) != 0;
            this.isForced = (i13 & 2) != 0;
            int i14 = Integer.MAX_VALUE;
            if (parameters.preferredTextLanguages.isEmpty()) {
                immutableList = ImmutableList.of("");
            } else {
                immutableList = parameters.preferredTextLanguages;
            }
            int i15 = 0;
            while (true) {
                if (i15 >= immutableList.size()) {
                    i12 = 0;
                    break;
                }
                i12 = DefaultTrackSelector.getFormatLanguageScore(format, immutableList.get(i15), parameters.selectUndeterminedTextLanguage);
                if (i12 > 0) {
                    i14 = i15;
                    break;
                }
                i15++;
            }
            this.preferredLanguageIndex = i14;
            this.preferredLanguageScore = i12;
            int bitCount = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = bitCount;
            this.hasCaptionRoleFlags = (format.roleFlags & SPHINCS256Config.CRYPTO_SECRETKEYBYTES) != 0;
            int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            this.selectedAudioLanguageScore = formatLanguageScore;
            if (i12 > 0 || ((parameters.preferredTextLanguages.isEmpty() && bitCount > 0) || this.isDefault || (this.isForced && formatLanguageScore > 0))) {
                z11 = true;
            }
            this.isWithinConstraints = z11;
        }

        public int compareTo(TextTrackScore textTrackScore) {
            ComparisonChain compare = ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, textTrackScore.isWithinRendererCapabilities).compare(Integer.valueOf(this.preferredLanguageIndex), Integer.valueOf(textTrackScore.preferredLanguageIndex), Ordering.natural().reverse()).compare(this.preferredLanguageScore, textTrackScore.preferredLanguageScore).compare(this.preferredRoleFlagsScore, textTrackScore.preferredRoleFlagsScore).compareFalseFirst(this.isDefault, textTrackScore.isDefault).compare(Boolean.valueOf(this.isForced), Boolean.valueOf(textTrackScore.isForced), this.preferredLanguageScore == 0 ? Ordering.natural() : Ordering.natural().reverse()).compare(this.selectedAudioLanguageScore, textTrackScore.selectedAudioLanguageScore);
            if (this.preferredRoleFlagsScore == 0) {
                compare = compare.compareTrueFirst(this.hasCaptionRoleFlags, textTrackScore.hasCaptionRoleFlags);
            }
            return compare.result();
        }
    }

    public static final class VideoTrackScore implements Comparable<VideoTrackScore> {
        private final int bitrate;
        public final boolean isWithinMaxConstraints;
        private final boolean isWithinMinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final Parameters parameters;
        private final int pixelCount;
        private final int preferredMimeTypeMatchIndex;

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            if (r10 < ((float) r8.minVideoFrameRate)) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005b, code lost:
            if (r10 < r8.minVideoBitrate) goto L_0x005e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0091 A[EDGE_INSN: B:50:0x0091->B:48:0x0091 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackScore(com.google.android.exoplayer2.Format r7, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.parameters = r8
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = 1
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L_0x0033
                int r4 = r7.width
                if (r4 == r3) goto L_0x0014
                int r5 = r8.maxVideoWidth
                if (r4 > r5) goto L_0x0033
            L_0x0014:
                int r4 = r7.height
                if (r4 == r3) goto L_0x001c
                int r5 = r8.maxVideoHeight
                if (r4 > r5) goto L_0x0033
            L_0x001c:
                float r4 = r7.frameRate
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 == 0) goto L_0x0029
                int r5 = r8.maxVideoFrameRate
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L_0x0033
            L_0x0029:
                int r4 = r7.bitrate
                if (r4 == r3) goto L_0x0031
                int r5 = r8.maxVideoBitrate
                if (r4 > r5) goto L_0x0033
            L_0x0031:
                r4 = r1
                goto L_0x0034
            L_0x0033:
                r4 = r2
            L_0x0034:
                r6.isWithinMaxConstraints = r4
                if (r10 == 0) goto L_0x005e
                int r10 = r7.width
                if (r10 == r3) goto L_0x0040
                int r4 = r8.minVideoWidth
                if (r10 < r4) goto L_0x005e
            L_0x0040:
                int r10 = r7.height
                if (r10 == r3) goto L_0x0048
                int r4 = r8.minVideoHeight
                if (r10 < r4) goto L_0x005e
            L_0x0048:
                float r10 = r7.frameRate
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x0055
                int r0 = r8.minVideoFrameRate
                float r0 = (float) r0
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L_0x005e
            L_0x0055:
                int r10 = r7.bitrate
                if (r10 == r3) goto L_0x005f
                int r0 = r8.minVideoBitrate
                if (r10 < r0) goto L_0x005e
                goto L_0x005f
            L_0x005e:
                r1 = r2
            L_0x005f:
                r6.isWithinMinConstraints = r1
                boolean r9 = com.google.android.exoplayer2.trackselection.DefaultTrackSelector.isSupported(r9, r2)
                r6.isWithinRendererCapabilities = r9
                int r9 = r7.bitrate
                r6.bitrate = r9
                int r9 = r7.getPixelCount()
                r6.pixelCount = r9
                r9 = 2147483647(0x7fffffff, float:NaN)
            L_0x0074:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.preferredVideoMimeTypes
                int r10 = r10.size()
                if (r2 >= r10) goto L_0x0091
                java.lang.String r10 = r7.sampleMimeType
                if (r10 == 0) goto L_0x008e
                com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.preferredVideoMimeTypes
                java.lang.Object r0 = r0.get(r2)
                boolean r10 = r10.equals(r0)
                if (r10 == 0) goto L_0x008e
                r9 = r2
                goto L_0x0091
            L_0x008e:
                int r2 = r2 + 1
                goto L_0x0074
            L_0x0091:
                r6.preferredMimeTypeMatchIndex = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.VideoTrackScore.<init>(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters, int, boolean):void");
        }

        public int compareTo(VideoTrackScore videoTrackScore) {
            Ordering ordering;
            if (!this.isWithinMaxConstraints || !this.isWithinRendererCapabilities) {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse();
            } else {
                ordering = DefaultTrackSelector.FORMAT_VALUE_ORDERING;
            }
            return ComparisonChain.start().compareFalseFirst(this.isWithinRendererCapabilities, videoTrackScore.isWithinRendererCapabilities).compareFalseFirst(this.isWithinMaxConstraints, videoTrackScore.isWithinMaxConstraints).compareFalseFirst(this.isWithinMinConstraints, videoTrackScore.isWithinMinConstraints).compare(Integer.valueOf(this.preferredMimeTypeMatchIndex), Integer.valueOf(videoTrackScore.preferredMimeTypeMatchIndex), Ordering.natural().reverse()).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), this.parameters.forceLowestBitrate ? DefaultTrackSelector.FORMAT_VALUE_ORDERING.reverse() : DefaultTrackSelector.NO_ORDER).compare(Integer.valueOf(this.pixelCount), Integer.valueOf(videoTrackScore.pixelCount), ordering).compare(Integer.valueOf(this.bitrate), Integer.valueOf(videoTrackScore.bitrate), ordering).result();
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i11, String str, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i11, i12, i13, i14, i15, i16, i17, i18, i19)) {
                list2.remove(size);
            }
        }
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, int i11, int i12, boolean z11, boolean z12, boolean z13) {
        TrackGroup trackGroup2 = trackGroup;
        int i13 = i11;
        Format format = trackGroup.getFormat(i11);
        int[] iArr2 = new int[trackGroup2.length];
        int i14 = 0;
        for (int i15 = 0; i15 < trackGroup2.length; i15++) {
            if (i15 == i13 || isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i15), iArr[i15], format, i12, z11, z12, z13)) {
                iArr2[i14] = i15;
                i14++;
            }
        }
        return Arrays.copyOf(iArr2, i14);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i11, String str, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, List<Integer> list) {
        int i21 = 0;
        for (int i22 = 0; i22 < list.size(); i22++) {
            int intValue = list.get(i22).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i11, i12, i13, i14, i15, i16, i17, i18, i19)) {
                i21++;
            }
        }
        return i21;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, boolean z12) {
        String str;
        HashSet hashSet;
        int i23;
        int i24;
        TrackGroup trackGroup2 = trackGroup;
        if (trackGroup2.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, i21, i22, z12);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z11) {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i25 = 0;
            int i26 = 0;
            while (i26 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup2.getFormat(viewportFilteredTrackIndices.get(i26).intValue()).sampleMimeType;
                if (hashSet2.add(str3)) {
                    String str4 = str3;
                    i24 = i25;
                    i23 = i26;
                    hashSet = hashSet2;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i11, str3, i12, i13, i14, i15, i16, i17, i18, i19, viewportFilteredTrackIndices);
                    if (adaptiveVideoTrackCountForMimeType > i24) {
                        i25 = adaptiveVideoTrackCountForMimeType;
                        str2 = str4;
                        i26 = i23 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i24 = i25;
                    i23 = i26;
                    hashSet = hashSet2;
                }
                i25 = i24;
                i26 = i23 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        } else {
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i11, str, i12, i13, i14, i15, i16, i17, i18, i19, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Ints.toArray(viewportFilteredTrackIndices);
    }

    public static int getFormatLanguageScore(Format format, String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z11 || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0])) {
                return 2;
            }
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = r3
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = r0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i11, int i12, boolean z11) {
        int i13;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i14 = 0; i14 < trackGroup.length; i14++) {
            arrayList.add(Integer.valueOf(i14));
        }
        if (!(i11 == Integer.MAX_VALUE || i12 == Integer.MAX_VALUE)) {
            int i15 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < trackGroup.length; i16++) {
                Format format = trackGroup.getFormat(i16);
                int i17 = format.width;
                if (i17 > 0 && (i13 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z11, i11, i12, i17, i13);
                    int i18 = format.width;
                    int i19 = format.height;
                    int i21 = i18 * i19;
                    if (i18 >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i19 >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i21 < i15) {
                        i15 = i21;
                    }
                }
            }
            if (i15 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i15) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isSupported(int i11, boolean z11) {
        int d11 = s0.d(i11);
        return d11 == 4 || (z11 && d11 == 3);
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i11, Format format2, int i12, boolean z11, boolean z12, boolean z13) {
        int i13;
        int i14;
        String str;
        int i15;
        if (!isSupported(i11, false) || (i13 = format.bitrate) == -1 || i13 > i12) {
            return false;
        }
        if (!z13 && ((i15 = format.channelCount) == -1 || i15 != format2.channelCount)) {
            return false;
        }
        if (!z11 && ((str = format.sampleMimeType) == null || !TextUtils.equals(str, format2.sampleMimeType))) {
            return false;
        }
        if (z12 || ((i14 = format.sampleRate) != -1 && i14 == format2.sampleRate)) {
            return true;
        }
        return false;
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21) {
        int i22;
        if ((format.roleFlags & 16384) != 0 || !isSupported(i11, false) || (i11 & i12) == 0) {
            return false;
        }
        if (str != null && !Util.areEqual(format.sampleMimeType, str)) {
            return false;
        }
        int i23 = format.width;
        if (i23 != -1 && (i17 > i23 || i23 > i13)) {
            return false;
        }
        int i24 = format.height;
        if (i24 != -1 && (i18 > i24 || i24 > i14)) {
            return false;
        }
        float f11 = format.frameRate;
        if ((f11 == -1.0f || (((float) i19) <= f11 && f11 <= ((float) i15))) && (i22 = format.bitrate) != -1 && i21 <= i22 && i22 <= i16) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(Integer num, Integer num2) {
        return 0;
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z11;
        boolean z12 = false;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            if (i11 >= mappedTrackInfo.getRendererCount()) {
                z11 = true;
                break;
            }
            int rendererType = mappedTrackInfo.getRendererType(i11);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i11];
            if ((rendererType == 1 || rendererType == 2) && exoTrackSelection != null && rendererSupportsTunneling(iArr[i11], mappedTrackInfo.getTrackGroups(i11), exoTrackSelection)) {
                if (rendererType == 1) {
                    if (i13 != -1) {
                        break;
                    }
                    i13 = i11;
                } else if (i12 != -1) {
                    break;
                } else {
                    i12 = i11;
                }
            }
            i11++;
        }
        z11 = false;
        if (!(i13 == -1 || i12 == -1)) {
            z12 = true;
        }
        if (z11 && z12) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(true);
            rendererConfigurationArr[i13] = rendererConfiguration;
            rendererConfigurationArr[i12] = rendererConfiguration;
        }
    }

    public static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(exoTrackSelection.getTrackGroup());
        for (int i11 = 0; i11 < exoTrackSelection.length(); i11++) {
            if (s0.e(iArr[indexOf][exoTrackSelection.getIndexInTrackGroup(i11)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private static ExoTrackSelection.Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i11, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i12 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z11 = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i11 & i12) != 0;
        int i13 = 0;
        while (i13 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i13);
            int[] iArr2 = iArr[i13];
            int i14 = parameters2.maxVideoWidth;
            int i15 = parameters2.maxVideoHeight;
            int i16 = parameters2.maxVideoFrameRate;
            int i17 = parameters2.maxVideoBitrate;
            int i18 = parameters2.minVideoWidth;
            int i19 = parameters2.minVideoHeight;
            int i21 = parameters2.minVideoFrameRate;
            int i22 = parameters2.minVideoBitrate;
            int i23 = parameters2.viewportWidth;
            int i24 = parameters2.viewportHeight;
            boolean z12 = parameters2.viewportOrientationMayChange;
            TrackGroup trackGroup2 = trackGroup;
            int i25 = i13;
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr2, z11, i12, i14, i15, i16, i17, i18, i19, i21, i22, i23, i24, z12);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new ExoTrackSelection.Definition(trackGroup2, adaptiveVideoTracksForGroup);
            }
            i13 = i25 + 1;
            trackGroupArray2 = trackGroupArray;
            parameters2 = parameters;
        }
        return null;
    }

    private static ExoTrackSelection.Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i11 = -1;
        TrackGroup trackGroup = null;
        VideoTrackScore videoTrackScore = null;
        for (int i12 = 0; i12 < trackGroupArray2.length; i12++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i12);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < trackGroup2.length; i13++) {
                Format format = trackGroup2.getFormat(i13);
                if ((format.roleFlags & 16384) == 0 && isSupported(iArr2[i13], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    VideoTrackScore videoTrackScore2 = new VideoTrackScore(format, parameters2, iArr2[i13], viewportFilteredTrackIndices.contains(Integer.valueOf(i13)));
                    if ((videoTrackScore2.isWithinMaxConstraints || parameters2.exceedVideoConstraintsIfNecessary) && (videoTrackScore == null || videoTrackScore2.compareTo(videoTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i11 = i13;
                        videoTrackScore = videoTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i11);
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition[] selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo r22, int[][][] r23, int[] r24, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters r25) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
            r8 = r25
            int r9 = r22.getRendererCount()
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition[] r10 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition[r9]
            r11 = 0
            r0 = r11
            r12 = r0
            r13 = r12
        L_0x0010:
            r14 = 2
            r15 = 1
            if (r12 >= r9) goto L_0x0044
            int r1 = r7.getRendererType(r12)
            if (r14 != r1) goto L_0x0041
            if (r0 != 0) goto L_0x0036
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r12)
            r2 = r23[r12]
            r3 = r24[r12]
            r5 = 1
            r0 = r21
            r4 = r25
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r0 = r0.selectVideoTrack(r1, r2, r3, r4, r5)
            r10[r12] = r0
            r0 = r10[r12]
            if (r0 == 0) goto L_0x0035
            r0 = r15
            goto L_0x0036
        L_0x0035:
            r0 = r11
        L_0x0036:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r12)
            int r1 = r1.length
            if (r1 <= 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r15 = r11
        L_0x0040:
            r13 = r13 | r15
        L_0x0041:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x0044:
            r12 = -1
            r16 = 0
            r5 = r11
            r2 = r12
            r3 = r16
            r4 = r3
        L_0x004c:
            if (r5 >= r9) goto L_0x00b7
            int r0 = r7.getRendererType(r5)
            if (r15 != r0) goto L_0x00a8
            boolean r0 = r8.allowMultipleAdaptiveSelections
            if (r0 != 0) goto L_0x005e
            if (r13 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r17 = r11
            goto L_0x0060
        L_0x005e:
            r17 = r15
        L_0x0060:
            com.google.android.exoplayer2.source.TrackGroupArray r1 = r7.getTrackGroups(r5)
            r18 = r23[r5]
            r19 = r24[r5]
            r0 = r21
            r14 = r2
            r2 = r18
            r15 = r3
            r3 = r19
            r20 = r4
            r4 = r25
            r19 = r5
            r5 = r17
            android.util.Pair r0 = r0.selectAudioTrack(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00ae
            if (r15 == 0) goto L_0x008a
            java.lang.Object r1 = r0.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore r1 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r1
            int r1 = r1.compareTo((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r15)
            if (r1 <= 0) goto L_0x00ae
        L_0x008a:
            if (r14 == r12) goto L_0x008e
            r10[r14] = r16
        L_0x008e:
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r1 = (com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition) r1
            r10[r19] = r1
            com.google.android.exoplayer2.source.TrackGroup r2 = r1.group
            int[] r1 = r1.tracks
            r1 = r1[r11]
            com.google.android.exoplayer2.Format r1 = r2.getFormat(r1)
            java.lang.String r4 = r1.language
            java.lang.Object r0 = r0.second
            r3 = r0
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$AudioTrackScore r3 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore) r3
            r2 = r19
            goto L_0x00b2
        L_0x00a8:
            r14 = r2
            r15 = r3
            r20 = r4
            r19 = r5
        L_0x00ae:
            r2 = r14
            r3 = r15
            r4 = r20
        L_0x00b2:
            int r5 = r19 + 1
            r14 = 2
            r15 = 1
            goto L_0x004c
        L_0x00b7:
            r20 = r4
            r1 = r12
            r0 = r16
        L_0x00bc:
            if (r11 >= r9) goto L_0x010d
            int r2 = r7.getRendererType(r11)
            r3 = 1
            if (r2 == r3) goto L_0x0105
            r4 = 2
            if (r2 == r4) goto L_0x0102
            r5 = 3
            if (r2 == r5) goto L_0x00d8
            com.google.android.exoplayer2.source.TrackGroupArray r5 = r7.getTrackGroups(r11)
            r13 = r23[r11]
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r2 = r6.selectOtherTrack(r2, r5, r13, r8)
            r10[r11] = r2
            goto L_0x0102
        L_0x00d8:
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r7.getTrackGroups(r11)
            r5 = r23[r11]
            r13 = r20
            android.util.Pair r2 = r6.selectTextTrack(r2, r5, r8, r13)
            if (r2 == 0) goto L_0x0108
            if (r0 == 0) goto L_0x00f2
            java.lang.Object r5 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackScore r5 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r5
            int r5 = r5.compareTo((com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r0)
            if (r5 <= 0) goto L_0x0108
        L_0x00f2:
            if (r1 == r12) goto L_0x00f6
            r10[r1] = r16
        L_0x00f6:
            java.lang.Object r0 = r2.first
            com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition r0 = (com.google.android.exoplayer2.trackselection.ExoTrackSelection.Definition) r0
            r10[r11] = r0
            java.lang.Object r0 = r2.second
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackScore r0 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.TextTrackScore) r0
            r1 = r11
            goto L_0x0108
        L_0x0102:
            r13 = r20
            goto L_0x0108
        L_0x0105:
            r13 = r20
            r4 = 2
        L_0x0108:
            int r11 = r11 + 1
            r20 = r13
            goto L_0x00bc
        L_0x010d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.trackselection.DefaultTrackSelector.selectAllTracks(com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo, int[][][], int[], com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition[]");
    }

    public Pair<ExoTrackSelection.Definition, AudioTrackScore> selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i11, Parameters parameters, boolean z11) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        ExoTrackSelection.Definition definition = null;
        AudioTrackScore audioTrackScore = null;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < trackGroupArray2.length; i14++) {
            TrackGroup trackGroup = trackGroupArray2.get(i14);
            int[] iArr2 = iArr[i14];
            for (int i15 = 0; i15 < trackGroup.length; i15++) {
                if (isSupported(iArr2[i15], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i15), parameters2, iArr2[i15]);
                    if ((audioTrackScore2.isWithinConstraints || parameters2.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i12 = i14;
                        i13 = i15;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i12 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.get(i12);
        if (!parameters2.forceHighestSupportedBitrate && !parameters2.forceLowestBitrate && z11) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i12], i13, parameters2.maxAudioBitrate, parameters2.allowAudioMixedMimeTypeAdaptiveness, parameters2.allowAudioMixedSampleRateAdaptiveness, parameters2.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 1) {
                definition = new ExoTrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new ExoTrackSelection.Definition(trackGroup2, i13);
        }
        return Pair.create(definition, (AudioTrackScore) Assertions.checkNotNull(audioTrackScore));
    }

    public ExoTrackSelection.Definition selectOtherTrack(int i11, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i12 = 0;
        for (int i13 = 0; i13 < trackGroupArray.length; i13++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < trackGroup2.length; i14++) {
                if (isSupported(iArr2[i14], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(trackGroup2.getFormat(i14), iArr2[i14]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = trackGroup2;
                        i12 = i14;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i12);
    }

    public Pair<ExoTrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i11 = -1;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        for (int i12 = 0; i12 < trackGroupArray2.length; i12++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < trackGroup2.length; i13++) {
                if (isSupported(iArr2[i13], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore2 = new TextTrackScore(trackGroup2.getFormat(i13), parameters2, iArr2[i13], str);
                    if (textTrackScore2.isWithinConstraints && (textTrackScore == null || textTrackScore2.compareTo(textTrackScore) > 0)) {
                        trackGroup = trackGroup2;
                        i11 = i13;
                        textTrackScore = textTrackScore2;
                    }
                } else {
                    String str2 = str;
                }
            }
            String str3 = str;
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new ExoTrackSelection.Definition(trackGroup, i11), (TextTrackScore) Assertions.checkNotNull(textTrackScore));
    }

    public final Pair<RendererConfiguration[], ExoTrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        ExoTrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i11 = 0;
        while (true) {
            ExoTrackSelection.Definition definition = null;
            if (i11 >= rendererCount) {
                break;
            }
            if (parameters.getRendererDisabled(i11)) {
                selectAllTracks[i11] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i11);
                if (parameters.hasSelectionOverride(i11, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i11, trackGroups);
                    if (selectionOverride != null) {
                        definition = new ExoTrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.type);
                    }
                    selectAllTracks[i11] = definition;
                }
            }
            i11++;
        }
        ExoTrackSelection[] createTrackSelections = this.trackSelectionFactory.createTrackSelections(selectAllTracks, getBandwidthMeter(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i12 = 0; i12 < rendererCount; i12++) {
            rendererConfigurationArr[i12] = !parameters.getRendererDisabled(i12) && (mappedTrackInfo.getRendererType(i12) == 7 || createTrackSelections[i12] != null) ? RendererConfiguration.DEFAULT : null;
        }
        if (parameters.tunnelingEnabled) {
            maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections);
        }
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    public ExoTrackSelection.Definition selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i11, Parameters parameters, boolean z11) throws ExoPlaybackException {
        ExoTrackSelection.Definition selectAdaptiveVideoTrack = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || !z11) ? null : selectAdaptiveVideoTrack(trackGroupArray, iArr, i11, parameters);
        return selectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : selectAdaptiveVideoTrack;
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.parametersReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    @Deprecated
    public DefaultTrackSelector(ExoTrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Context context) {
        this(context, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(Parameters.getDefaults(context), factory);
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public DefaultTrackSelector(Parameters parameters, ExoTrackSelection.Factory factory) {
        this.trackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(parameters);
    }
}

package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class AdPlaybackState implements Bundleable {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final Bundleable.Creator<AdPlaybackState> CREATOR = a.f65984a;
    private static final int FIELD_AD_GROUPS = 2;
    private static final int FIELD_AD_GROUP_TIMES_US = 1;
    private static final int FIELD_AD_RESUME_POSITION_US = 3;
    private static final int FIELD_CONTENT_DURATION_US = 4;
    public static final AdPlaybackState NONE = new AdPlaybackState((Object) null, new long[0], (AdGroup[]) null, 0, -9223372036854775807L);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final Object adsId;
    public final long contentDurationUs;

    public static final class AdGroup implements Bundleable {
        public static final Bundleable.Creator<AdGroup> CREATOR = b.f65985a;
        private static final int FIELD_COUNT = 0;
        private static final int FIELD_DURATIONS_US = 3;
        private static final int FIELD_STATES = 2;
        private static final int FIELD_URIS = 1;
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i11) {
            int length = jArr.length;
            int max = Math.max(i11, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i11) {
            int length = iArr.length;
            int max = Math.max(i11, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        /* access modifiers changed from: private */
        public static AdGroup fromBundle(Bundle bundle) {
            Uri[] uriArr;
            int i11 = bundle.getInt(keyForField(0), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(keyForField(1));
            int[] intArray = bundle.getIntArray(keyForField(2));
            long[] longArray = bundle.getLongArray(keyForField(3));
            if (intArray == null) {
                intArray = new int[0];
            }
            if (parcelableArrayList == null) {
                uriArr = new Uri[0];
            } else {
                uriArr = (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            }
            if (longArray == null) {
                longArray = new long[0];
            }
            return new AdGroup(i11, intArray, uriArr, longArray);
        }

        private static String keyForField(int i11) {
            return Integer.toString(i11, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            if (this.count != adGroup.count || !Arrays.equals(this.uris, adGroup.uris) || !Arrays.equals(this.states, adGroup.states) || !Arrays.equals(this.durationsUs, adGroup.durationsUs)) {
                return false;
            }
            return true;
        }

        public int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int i11) {
            int i12 = i11 + 1;
            while (true) {
                int[] iArr = this.states;
                if (i12 >= iArr.length || iArr[i12] == 0 || iArr[i12] == 1) {
                    return i12;
                }
                i12++;
            }
            return i12;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || getFirstAdIndexToPlay() < this.count;
        }

        public int hashCode() {
            return (((((this.count * 31) + Arrays.hashCode(this.uris)) * 31) + Arrays.hashCode(this.states)) * 31) + Arrays.hashCode(this.durationsUs);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(keyForField(0), this.count);
            bundle.putParcelableArrayList(keyForField(1), new ArrayList(Arrays.asList(this.uris)));
            bundle.putIntArray(keyForField(2), this.states);
            bundle.putLongArray(keyForField(3), this.durationsUs);
            return bundle;
        }

        public AdGroup withAdCount(int i11) {
            return new AdGroup(i11, copyStatesWithSpaceForAdCount(this.states, i11), (Uri[]) Arrays.copyOf(this.uris, i11), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i11));
        }

        public AdGroup withAdDurationsUs(long[] jArr) {
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            } else if (this.count != -1 && jArr.length > uriArr.length) {
                jArr = Arrays.copyOf(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        public AdGroup withAdState(int i11, int i12) {
            int i13 = this.count;
            boolean z11 = false;
            Assertions.checkArgument(i13 == -1 || i12 < i13);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i12 + 1);
            if (copyStatesWithSpaceForAdCount[i12] == 0 || copyStatesWithSpaceForAdCount[i12] == 1 || copyStatesWithSpaceForAdCount[i12] == i11) {
                z11 = true;
            }
            Assertions.checkArgument(z11);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i12] = i11;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        public AdGroup withAdUri(Uri uri, int i11) {
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i11 + 1);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i11] = uri;
            copyStatesWithSpaceForAdCount[i11] = 1;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        public AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i11 = 0; i11 < length; i11++) {
                if (copyOf[i11] == 1 || copyOf[i11] == 0) {
                    copyOf[i11] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        private AdGroup(int i11, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i11;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(Object obj, long... jArr) {
        this(obj, jArr, (AdGroup[]) null, 0, -9223372036854775807L);
    }

    /* access modifiers changed from: private */
    public static AdPlaybackState fromBundle(Bundle bundle) {
        AdGroup[] adGroupArr;
        long[] longArray = bundle.getLongArray(keyForField(1));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(keyForField(2));
        if (parcelableArrayList == null) {
            adGroupArr = null;
        } else {
            AdGroup[] adGroupArr2 = new AdGroup[parcelableArrayList.size()];
            for (int i11 = 0; i11 < parcelableArrayList.size(); i11++) {
                adGroupArr2[i11] = AdGroup.CREATOR.fromBundle((Bundle) parcelableArrayList.get(i11));
            }
            adGroupArr = adGroupArr2;
        }
        long j11 = bundle.getLong(keyForField(3), 0);
        long j12 = bundle.getLong(keyForField(4), -9223372036854775807L);
        if (longArray == null) {
            longArray = new long[0];
        }
        return new AdPlaybackState((Object) null, longArray, adGroupArr, j11, j12);
    }

    private boolean isPositionBeforeAdGroup(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        long j13 = this.adGroupTimesUs[i11];
        return j13 == Long.MIN_VALUE ? j12 == -9223372036854775807L || j11 < j12 : j11 < j13;
    }

    private static String keyForField(int i11) {
        return Integer.toString(i11, 36);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        if (!Util.areEqual(this.adsId, adPlaybackState.adsId) || this.adGroupCount != adPlaybackState.adGroupCount || this.adResumePositionUs != adPlaybackState.adResumePositionUs || this.contentDurationUs != adPlaybackState.contentDurationUs || !Arrays.equals(this.adGroupTimesUs, adPlaybackState.adGroupTimesUs) || !Arrays.equals(this.adGroups, adPlaybackState.adGroups)) {
            return false;
        }
        return true;
    }

    public int getAdGroupIndexAfterPositionUs(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != -9223372036854775807L && j11 >= j12) {
            return -1;
        }
        int i11 = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i11 < jArr.length && ((jArr[i11] != Long.MIN_VALUE && jArr[i11] <= j11) || !this.adGroups[i11].hasUnplayedAds())) {
                i11++;
            }
        }
        if (i11 < this.adGroupTimesUs.length) {
            return i11;
        }
        return -1;
    }

    public int getAdGroupIndexForPositionUs(long j11, long j12) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0 && isPositionBeforeAdGroup(j11, j12, length)) {
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    public int hashCode() {
        int i11 = this.adGroupCount * 31;
        Object obj = this.adsId;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.adResumePositionUs)) * 31) + ((int) this.contentDurationUs)) * 31) + Arrays.hashCode(this.adGroupTimesUs)) * 31) + Arrays.hashCode(this.adGroups);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r4 = r0[r4];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAdInErrorState(int r4, int r5) {
        /*
            r3 = this;
            com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup[] r0 = r3.adGroups
            int r1 = r0.length
            r2 = 0
            if (r4 < r1) goto L_0x0007
            return r2
        L_0x0007:
            r4 = r0[r4]
            int r0 = r4.count
            r1 = -1
            if (r0 == r1) goto L_0x0019
            if (r5 < r0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            int[] r4 = r4.states
            r4 = r4[r5]
            r5 = 4
            if (r4 != r5) goto L_0x0019
            r2 = 1
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ads.AdPlaybackState.isAdInErrorState(int, int):boolean");
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putLongArray(keyForField(1), this.adGroupTimesUs);
        ArrayList arrayList = new ArrayList();
        for (AdGroup bundle2 : this.adGroups) {
            arrayList.add(bundle2.toBundle());
        }
        bundle.putParcelableArrayList(keyForField(2), arrayList);
        bundle.putLong(keyForField(3), this.adResumePositionUs);
        bundle.putLong(keyForField(4), this.contentDurationUs);
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.adsId);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.adResumePositionUs);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.adGroups.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.adGroupTimesUs[i11]);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.adGroups[i11].states.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.adGroups[i11].states[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append(Matrix.MATRIX_TYPE_RANDOM_REGULAR);
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.adGroups[i11].durationsUs[i12]);
                sb2.append(')');
                if (i12 < this.adGroups[i11].states.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.adGroups.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }

    public AdPlaybackState withAdCount(int i11, int i12) {
        Assertions.checkArgument(i12 > 0);
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i11].count == i12) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = this.adGroups[i11].withAdCount(i12);
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        for (int i11 = 0; i11 < this.adGroupCount; i11++) {
            adGroupArr2[i11] = adGroupArr2[i11].withAdDurationsUs(jArr[i11]);
        }
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdLoadError(int i11, int i12) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = adGroupArr2[i11].withAdState(4, i12);
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdResumePositionUs(long j11) {
        if (this.adResumePositionUs == j11) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, this.adGroups, j11, this.contentDurationUs);
    }

    public AdPlaybackState withAdUri(int i11, int i12, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = adGroupArr2[i11].withAdUri(uri, i12);
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withContentDurationUs(long j11) {
        if (this.contentDurationUs == j11) {
            return this;
        }
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j11);
    }

    public AdPlaybackState withPlayedAd(int i11, int i12) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = adGroupArr2[i11].withAdState(3, i12);
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAd(int i11, int i12) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = adGroupArr2[i11].withAdState(2, i12);
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAdGroup(int i11) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.nullSafeArrayCopy(adGroupArr, adGroupArr.length);
        adGroupArr2[i11] = adGroupArr2[i11].withAllAdsSkipped();
        return new AdPlaybackState(this.adsId, this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    private AdPlaybackState(Object obj, long[] jArr, AdGroup[] adGroupArr, long j11, long j12) {
        Assertions.checkArgument(adGroupArr == null || adGroupArr.length == jArr.length);
        this.adsId = obj;
        this.adGroupTimesUs = jArr;
        this.adResumePositionUs = j11;
        this.contentDurationUs = j12;
        int length = jArr.length;
        this.adGroupCount = length;
        if (adGroupArr == null) {
            adGroupArr = new AdGroup[length];
            for (int i11 = 0; i11 < this.adGroupCount; i11++) {
                adGroupArr[i11] = new AdGroup();
            }
        }
        this.adGroups = adGroupArr;
    }
}

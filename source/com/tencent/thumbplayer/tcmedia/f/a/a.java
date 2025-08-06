package com.tencent.thumbplayer.tcmedia.f.a;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.api.TPTimeRange;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.tcmedia.core.richmedia.TPNativeTimeRange;
import com.tencent.thumbplayer.tcmedia.core.richmedia.async.ITPNativeRichMediaAsyncRequester;
import com.tencent.thumbplayer.tcmedia.core.richmedia.async.ITPNativeRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.tcmedia.core.richmedia.async.TPNativeRichMediaAsyncRequester;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class a implements ITPRichMediaAsyncRequester {

    /* renamed from: a  reason: collision with root package name */
    private final ITPNativeRichMediaAsyncRequester f49173a;

    /* renamed from: com.tencent.thumbplayer.tcmedia.f.a.a$a  reason: collision with other inner class name */
    public class C0621a implements ITPNativeRichMediaAsyncRequesterListener {

        /* renamed from: b  reason: collision with root package name */
        private final ITPRichMediaAsyncRequesterListener f49175b;

        public C0621a(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener) {
            this.f49175b = iTPRichMediaAsyncRequesterListener;
        }

        public void onFeatureDataRequestFailure(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i11, int i12, int i13) {
            this.f49175b.onFeatureDataRequestFailure(a.this, i11, i12, i13);
        }

        public void onFeatureDataRequestSuccess(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i11, int i12, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData) {
            this.f49175b.onFeatureDataRequestSuccess(a.this, i11, i12, new TPRichMediaFeatureData(tPNativeRichMediaFeatureData));
        }

        public void onRequesterError(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester, int i11) {
            this.f49175b.onRequesterError(a.this, i11);
        }

        public void onRequesterPrepared(ITPNativeRichMediaAsyncRequester iTPNativeRichMediaAsyncRequester) {
            this.f49175b.onRequesterPrepared(a.this);
        }
    }

    public a(Context context) {
        this.f49173a = new TPNativeRichMediaAsyncRequester(context);
    }

    private TPRichMediaFeature[] a(TPNativeRichMediaFeature[] tPNativeRichMediaFeatureArr) {
        if (tPNativeRichMediaFeatureArr == null || tPNativeRichMediaFeatureArr.length == 0) {
            return new TPRichMediaFeature[0];
        }
        TPRichMediaFeature[] tPRichMediaFeatureArr = new TPRichMediaFeature[tPNativeRichMediaFeatureArr.length];
        for (int i11 = 0; i11 < tPNativeRichMediaFeatureArr.length; i11++) {
            tPRichMediaFeatureArr[i11] = new TPRichMediaFeature(tPNativeRichMediaFeatureArr[i11]);
        }
        return tPRichMediaFeatureArr;
    }

    private TPNativeTimeRange[] a(TPTimeRange[] tPTimeRangeArr) {
        if (tPTimeRangeArr == null || tPTimeRangeArr.length == 0) {
            return new TPNativeTimeRange[0];
        }
        TPNativeTimeRange[] tPNativeTimeRangeArr = new TPNativeTimeRange[tPTimeRangeArr.length];
        for (int i11 = 0; i11 < tPTimeRangeArr.length; i11++) {
            TPTimeRange tPTimeRange = tPTimeRangeArr[i11];
            if (tPTimeRange == null) {
                return new TPNativeTimeRange[0];
            }
            tPNativeTimeRangeArr[i11] = new TPNativeTimeRange(tPTimeRange.getStartTimeMs(), tPTimeRange.getEndTimeMs());
        }
        return tPNativeTimeRangeArr;
    }

    public void cancelRequest(int i11) {
        this.f49173a.cancelRequest(i11);
    }

    public TPRichMediaFeature[] getFeatures() {
        return a(this.f49173a.getFeatures());
    }

    public void prepareAsync() {
        this.f49173a.prepareAsync();
    }

    public void release() {
        this.f49173a.release();
    }

    public int requestFeatureDataAsyncAtTimeMs(int i11, long j11) {
        return this.f49173a.requestFeatureDataAsyncAtTimeMs(i11, j11);
    }

    public int requestFeatureDataAsyncAtTimeMsArray(int i11, long[] jArr) {
        return this.f49173a.requestFeatureDataAsyncAtTimeMsArray(i11, jArr);
    }

    public int requestFeatureDataAsyncAtTimeRange(int i11, TPTimeRange tPTimeRange) {
        if (tPTimeRange != null) {
            return this.f49173a.requestFeatureDataAsyncAtTimeRange(i11, new TPNativeTimeRange(tPTimeRange.getStartTimeMs(), tPTimeRange.getEndTimeMs()));
        }
        TPLogUtil.w("TPRichMediaAsyncRequester", "requestFeatureDataAsyncAtTimeRange, timeRange == null");
        return -1;
    }

    public int requestFeatureDataAsyncAtTimeRanges(int i11, TPTimeRange[] tPTimeRangeArr) {
        TPNativeTimeRange[] a11 = a(tPTimeRangeArr);
        if (a11.length != 0) {
            return this.f49173a.requestFeatureDataAsyncAtTimeRanges(i11, a11);
        }
        TPLogUtil.w("TPRichMediaAsyncRequester", "requestFeatureDataAsyncAtTimeRanges, toNativeTimeRanges return empty array");
        return -1;
    }

    public void setRequesterListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener) {
        this.f49173a.setRequesterListener(new C0621a(iTPRichMediaAsyncRequesterListener));
    }

    public void setRichMediaSource(String str) {
        this.f49173a.setRichMediaSource(str);
    }
}

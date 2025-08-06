package com.tencent.ugc.preprocessor;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.g;
import com.tencent.ugc.beauty.gpufilters.BeautyBrightFilter;
import com.tencent.ugc.beauty.gpufilters.BeautyInterFace;
import com.tencent.ugc.beauty.gpufilters.TXCGPUMotionBase;
import com.tencent.ugc.beauty.gpufilters.pitu.BeautyPITUFilter;
import com.tencent.ugc.beauty.gpufilters.smooth.BeautySmoothFilter;
import com.tencent.ugc.beauty.gpufilters.vague.BeautyVagueFilter;
import com.tencent.ugc.common.TXCBuildsUtil;
import com.tencent.ugc.videobase.base.AIDetectListener;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilterChain;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.FloatUtils;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("liteav::ugc")
public class BeautyProcessor extends TXCGPUImageFilterChain {
    private static final String TAG = "TXCBeautyManager";
    private final SparseArray<TXCGPUImageFilter> mBeautyFilters;
    private float mBeautyLevel = 0.0f;
    private BeautyProcessorStatusListener mBeautyManagerStatusListener;
    private final Map<String, String> mBeautyStats = new HashMap();
    private int mBeautyStyle = -1;
    private TXCGPUImageFilter mCurrentBeautyFilter = null;
    private final boolean mIsEnterPriseProEnabled;
    private boolean mIsPerformanceMode = true;
    private final TXCGPUMotionBase mMotionFilter;
    private float mRuddyLevel = 0.0f;
    private float mSharpnessLevel = 0.4f;
    private float mUserSetSharpnessLevel = 0.0f;
    private float mWhitenessLevel = 0.0f;

    public interface BeautyProcessorStatusListener {
        void onBeautyStatsChanged(String str);
    }

    public BeautyProcessor(Context context, boolean z11) {
        this.mIsEnterPriseProEnabled = z11;
        this.mBeautyFilters = new SparseArray<>();
        this.mMotionFilter = TXCBuildsUtil.createMotionFilter(context);
    }

    private float getSharpnessLevel() {
        float f11 = this.mUserSetSharpnessLevel;
        if (f11 != 0.0f) {
            return f11;
        }
        if (!this.mIsPerformanceMode) {
            Size size = this.mOutputSize;
            if (Math.min(size.width, size.height) >= 540) {
                return 0.4f;
            }
        }
        return 0.0f;
    }

    public static /* synthetic */ void lambda$setBeautyLevel$0(BeautyProcessor beautyProcessor, float f11) {
        beautyProcessor.updateBeautyInternal(beautyProcessor.mBeautyStyle, f11, beautyProcessor.mWhitenessLevel, beautyProcessor.mRuddyLevel, beautyProcessor.mSharpnessLevel);
        beautyProcessor.updateStatsInternal("beautyLevel", f11);
    }

    public static /* synthetic */ void lambda$setPerformanceMode$3(BeautyProcessor beautyProcessor, boolean z11) {
        beautyProcessor.mIsPerformanceMode = z11;
        beautyProcessor.updateSharpenLevelInternal();
    }

    public static /* synthetic */ void lambda$setWhitenessLevel$1(BeautyProcessor beautyProcessor, float f11) {
        beautyProcessor.updateBeautyInternal(beautyProcessor.mBeautyStyle, beautyProcessor.mBeautyLevel, f11, beautyProcessor.mRuddyLevel, beautyProcessor.mSharpnessLevel);
        beautyProcessor.updateStatsInternal("whiteLevel", f11);
    }

    private void updateBeautyInternal(int i11, float f11, float f12, float f13, float f14) {
        Size size = this.mOutputSize;
        if (size.width != -1 && size.height != -1) {
            if (this.mBeautyStyle != i11) {
                updateStatsOnDraw("beautyStyle", i11);
            }
            TXCGPUImageFilter tXCGPUImageFilter = this.mBeautyFilters.get(i11);
            boolean z11 = true;
            if (tXCGPUImageFilter == null) {
                if (i11 == 0) {
                    tXCGPUImageFilter = new BeautySmoothFilter();
                } else if (i11 == 1) {
                    tXCGPUImageFilter = new BeautyVagueFilter();
                } else if (i11 != 2) {
                    tXCGPUImageFilter = new BeautyBrightFilter();
                } else {
                    tXCGPUImageFilter = new BeautyPITUFilter();
                }
                tXCGPUImageFilter.initialize(this.mTexturePool);
                Size size2 = this.mOutputSize;
                tXCGPUImageFilter.onOutputSizeChanged(size2.width, size2.height);
                this.mBeautyFilters.put(i11, tXCGPUImageFilter);
            }
            BeautyInterFace beautyInterFace = (BeautyInterFace) tXCGPUImageFilter;
            beautyInterFace.setBeautyLevel(f11);
            beautyInterFace.setRuddyLevel(f13);
            beautyInterFace.setWhitenessLevel(f12);
            beautyInterFace.setSharpenLevel(f14);
            if (!(this.mBeautyStyle == i11 && FloatUtils.isEqual(this.mBeautyLevel, f11) && FloatUtils.isEqual(this.mWhitenessLevel, f12) && FloatUtils.isEqual(this.mRuddyLevel, f13) && FloatUtils.isEqual(this.mSharpnessLevel, f14))) {
                this.mBeautyStyle = i11;
                this.mBeautyLevel = f11;
                this.mWhitenessLevel = f12;
                this.mRuddyLevel = f13;
                this.mSharpnessLevel = f14;
                removeAllFilterAndInterceptor();
                this.mCurrentBeautyFilter = null;
                if (!isLessOrEqualZero(this.mBeautyLevel) || !isLessOrEqualZero(this.mRuddyLevel) || !isLessOrEqualZero(this.mWhitenessLevel)) {
                    z11 = false;
                }
                if (!z11) {
                    addFilter(tXCGPUImageFilter);
                    this.mCurrentBeautyFilter = tXCGPUImageFilter;
                }
                addFilter(this.mMotionFilter);
            }
        }
    }

    private void updateSharpenLevelInternal() {
        float sharpnessLevel = getSharpnessLevel();
        LiteavLog.d(TAG, "sharpnessLevel: ".concat(String.valueOf(sharpnessLevel)));
        updateBeautyInternal(this.mBeautyStyle, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, sharpnessLevel);
    }

    /* access modifiers changed from: private */
    public void updateStatsInternal(String str, float f11) {
        this.mBeautyStats.put(str, String.valueOf(f11));
        if (this.mBeautyManagerStatusListener != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.mBeautyStats.entrySet()) {
                sb2.append((String) next.getKey());
                sb2.append(":");
                sb2.append((String) next.getValue());
                sb2.append(" ");
            }
            this.mBeautyManagerStatusListener.onBeautyStatsChanged("{" + sb2 + "}");
        }
    }

    public boolean canBeSkipped() {
        return canBeSkipped(this.mCurrentBeautyFilter) && this.mMotionFilter.canBeSkipped();
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mMotionFilter.initialize(gLTexturePool);
        int i11 = this.mBeautyStyle;
        if (i11 == -1) {
            i11 = 0;
        }
        updateBeautyInternal(i11, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, this.mSharpnessLevel);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        this.mMotionFilter.onOutputSizeChanged(i11, i12);
        float sharpnessLevel = getSharpnessLevel();
        for (int i13 = 0; i13 < this.mBeautyFilters.size(); i13++) {
            TXCGPUImageFilter valueAt = this.mBeautyFilters.valueAt(i13);
            valueAt.onOutputSizeChanged(i11, i12);
            if (valueAt instanceof BeautyInterFace) {
                ((BeautyInterFace) valueAt).setSharpenLevel(sharpnessLevel);
            }
        }
        int i14 = this.mBeautyStyle;
        updateBeautyInternal(i14 == -1 ? 0 : i14, this.mBeautyLevel, this.mWhitenessLevel, this.mRuddyLevel, sharpnessLevel);
    }

    public void onUninit() {
        super.onUninit();
        this.mMotionFilter.uninitialize();
        for (int i11 = 0; i11 < this.mBeautyFilters.size(); i11++) {
            this.mBeautyFilters.valueAt(i11).uninitialize();
        }
    }

    public void setAIDetectListener(AIDetectListener aIDetectListener) {
        this.mMotionFilter.setAIDetectListener(aIDetectListener);
    }

    public void setBeautyLevel(float f11) {
        float a11 = g.a(f11, 0.0f);
        LiteavLog.d(TAG, "setBeautyLevel beautyLevel:".concat(String.valueOf(f11)));
        runOnDraw(a.a(this, a11));
    }

    public void setBeautyManagerStatusListener(BeautyProcessorStatusListener beautyProcessorStatusListener) {
        this.mBeautyManagerStatusListener = beautyProcessorStatusListener;
    }

    public void setHomeOrientation(int i11) {
        this.mMotionFilter.setHomeOrientation(i11);
    }

    public void setPerformanceMode(boolean z11) {
        LiteavLog.d(TAG, "setPerformanceMode: ".concat(String.valueOf(z11)));
        runOnDraw(d.a(this, z11));
    }

    public void setWhitenessLevel(float f11) {
        float a11 = g.a(f11, 0.0f);
        LiteavLog.d(TAG, "setWhitenessLevel whitenessLevel:".concat(String.valueOf(f11)));
        runOnDraw(b.a(this, a11));
    }

    public void updateStatsOnDraw(String str, int i11) {
        runOnDraw(c.a(this, str, i11));
    }

    private boolean canBeSkipped(TXCGPUImageFilter tXCGPUImageFilter) {
        if (tXCGPUImageFilter == null) {
            return true;
        }
        return tXCGPUImageFilter.canBeSkipped();
    }
}

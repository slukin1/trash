package com.tencent.ugc.videoprocessor;

import android.content.Context;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import com.tencent.ugc.videoprocessor.transitions.BounceFilter;
import com.tencent.ugc.videoprocessor.transitions.BurnFilter;
import com.tencent.ugc.videoprocessor.transitions.CircleCropFilter;
import com.tencent.ugc.videoprocessor.transitions.CircleFilter;
import com.tencent.ugc.videoprocessor.transitions.CrossWarpFilter;
import com.tencent.ugc.videoprocessor.transitions.CrossZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.CubeFilter;
import com.tencent.ugc.videoprocessor.transitions.DirectionalFilter;
import com.tencent.ugc.videoprocessor.transitions.DirectionalWarpFilter;
import com.tencent.ugc.videoprocessor.transitions.DoorWayFilter;
import com.tencent.ugc.videoprocessor.transitions.DreamyZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.FadeColorFilter;
import com.tencent.ugc.videoprocessor.transitions.FadeGrayScaleFilter;
import com.tencent.ugc.videoprocessor.transitions.FlyEyeFilter;
import com.tencent.ugc.videoprocessor.transitions.GlitchDisplaceFilter;
import com.tencent.ugc.videoprocessor.transitions.GlitchMemoriesFilter;
import com.tencent.ugc.videoprocessor.transitions.GridFlipFilter;
import com.tencent.ugc.videoprocessor.transitions.HexagonalizeFilter;
import com.tencent.ugc.videoprocessor.transitions.InvertedPageCurlFilter;
import com.tencent.ugc.videoprocessor.transitions.KaleidoScopeFilter;
import com.tencent.ugc.videoprocessor.transitions.LinearBlurFilter;
import com.tencent.ugc.videoprocessor.transitions.MosaicFilter;
import com.tencent.ugc.videoprocessor.transitions.PixelizeFilter;
import com.tencent.ugc.videoprocessor.transitions.SimpleZoomFilter;
import com.tencent.ugc.videoprocessor.transitions.SqueezeFilter;
import com.tencent.ugc.videoprocessor.transitions.StereoViewerFilter;
import com.tencent.ugc.videoprocessor.transitions.SwapFilter;
import com.tencent.ugc.videoprocessor.transitions.SwirlFilter;
import com.tencent.ugc.videoprocessor.transitions.TXCGPUTransitionFilterBase;
import com.tencent.ugc.videoprocessor.transitions.WaterDropFilter;
import com.tencent.ugc.videoprocessor.transitions.data.TransitionConfig;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.List;

public class VideoTransitionProcessor {
    private static final String TAG = "TransitionProcessor";
    private final Context mContext;
    private long mFirstFrameTime = -1;
    private GLTexturePool mGLTexturePool;
    private boolean mIsReverse = false;
    private final TransitionConfig mTransitionConfig;
    private TXCGPUTransitionFilterBase mTransitionFilter;
    private long mVideoDuration = -1;

    public VideoTransitionProcessor(Context context) {
        this.mContext = context;
        this.mTransitionConfig = new TransitionConfig();
    }

    private void createTransitionFilter(int i11) {
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase;
        DirectionalFilter directionalFilter;
        switch (i11) {
            case 1:
                directionalFilter = new DirectionalFilter(i11, new float[]{1.0f, 0.0f});
                break;
            case 2:
                directionalFilter = new DirectionalFilter(i11, new float[]{-1.0f, 0.0f});
                break;
            case 3:
                directionalFilter = new DirectionalFilter(i11, new float[]{0.0f, -1.0f});
                break;
            case 4:
                directionalFilter = new DirectionalFilter(i11, new float[]{0.0f, 1.0f});
                break;
            case 5:
                tXCGPUTransitionFilterBase = new FadeColorFilter(i11);
                break;
            case 7:
                tXCGPUTransitionFilterBase = new SimpleZoomFilter(i11);
                break;
            case 8:
                tXCGPUTransitionFilterBase = new LinearBlurFilter(i11);
                break;
            case 9:
                tXCGPUTransitionFilterBase = new WaterDropFilter(i11);
                break;
            case 10:
                tXCGPUTransitionFilterBase = new InvertedPageCurlFilter(i11);
                break;
            case 11:
                tXCGPUTransitionFilterBase = new GlitchMemoriesFilter(i11);
                break;
            case 12:
                tXCGPUTransitionFilterBase = new StereoViewerFilter(i11);
                break;
            case 13:
                tXCGPUTransitionFilterBase = new DirectionalWarpFilter(i11);
                break;
            case 14:
                tXCGPUTransitionFilterBase = new BounceFilter(i11);
                break;
            case 15:
                tXCGPUTransitionFilterBase = new CircleCropFilter(i11);
                break;
            case 16:
                tXCGPUTransitionFilterBase = new SwirlFilter(i11);
                break;
            case 17:
                tXCGPUTransitionFilterBase = new CrossZoomFilter(i11);
                break;
            case 18:
                tXCGPUTransitionFilterBase = new GridFlipFilter(i11);
                break;
            case 19:
                tXCGPUTransitionFilterBase = new MosaicFilter(i11);
                break;
            case 22:
                tXCGPUTransitionFilterBase = new KaleidoScopeFilter(i11);
                break;
            case 23:
                tXCGPUTransitionFilterBase = new HexagonalizeFilter(i11);
                break;
            case 24:
                tXCGPUTransitionFilterBase = new GlitchDisplaceFilter(i11);
                break;
            case 25:
                tXCGPUTransitionFilterBase = new DreamyZoomFilter(i11);
                break;
            case 27:
                tXCGPUTransitionFilterBase = new BurnFilter(i11);
                break;
            case 28:
                tXCGPUTransitionFilterBase = new CircleFilter(i11);
                break;
            case 29:
                tXCGPUTransitionFilterBase = new CrossWarpFilter(i11);
                break;
            case 30:
                tXCGPUTransitionFilterBase = new CubeFilter(i11);
                break;
            case 31:
                tXCGPUTransitionFilterBase = new DoorWayFilter(i11);
                break;
            case 32:
                tXCGPUTransitionFilterBase = new FadeGrayScaleFilter(i11);
                break;
            case 33:
                tXCGPUTransitionFilterBase = new FlyEyeFilter(i11);
                break;
            case 34:
                tXCGPUTransitionFilterBase = new PixelizeFilter(i11);
                break;
            case 35:
                tXCGPUTransitionFilterBase = new SqueezeFilter(i11);
                break;
            case 36:
                tXCGPUTransitionFilterBase = new SwapFilter(i11);
                break;
            default:
                tXCGPUTransitionFilterBase = null;
                break;
        }
        tXCGPUTransitionFilterBase = directionalFilter;
        if (tXCGPUTransitionFilterBase != null) {
            tXCGPUTransitionFilterBase.initialize(this.mGLTexturePool);
        }
        this.mTransitionFilter = tXCGPUTransitionFilterBase;
    }

    private TransitionConfig.TransitionBean getCurrentTransition(long j11) {
        List<TransitionConfig.TransitionBean> transitionList = this.mTransitionConfig.getTransitionList();
        if (CollectionUtils.isEmpty((Collection<?>) transitionList)) {
            return null;
        }
        for (int size = transitionList.size() - 1; size >= 0; size--) {
            TransitionConfig.TransitionBean transitionBean = transitionList.get(size);
            if (isInTransitionRange(j11, transitionBean)) {
                return transitionBean;
            }
        }
        return null;
    }

    private float getTransitionProgress(TransitionConfig.TransitionBean transitionBean, long j11) {
        if (this.mFirstFrameTime == -1) {
            this.mFirstFrameTime = j11;
        }
        long abs = Math.abs(j11 - this.mFirstFrameTime);
        long abs2 = Math.abs(transitionBean.endTimeMs - transitionBean.startTimeMs);
        if (abs2 <= 0) {
            return -1.0f;
        }
        return g.a((((float) abs) * 1.0f) / ((float) abs2), 0.0f);
    }

    private boolean isInTransitionRange(long j11, TransitionConfig.TransitionBean transitionBean) {
        long j12 = transitionBean.startTimeMs;
        if (j11 >= j12 && j11 <= transitionBean.endTimeMs) {
            return true;
        }
        if (j11 < transitionBean.endTimeMs || j11 > j12) {
            return false;
        }
        return true;
    }

    public PixelFrame applyTransitionFilter(PixelFrame pixelFrame, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        long timestamp = pixelFrame.getTimestamp();
        if (this.mIsReverse) {
            long j11 = this.mVideoDuration;
            timestamp = g.a(j11 - timestamp, 0, j11);
        }
        TransitionConfig.TransitionBean currentTransition = getCurrentTransition(timestamp);
        if (currentTransition == null) {
            this.mFirstFrameTime = -1;
            return null;
        }
        float transitionProgress = getTransitionProgress(currentTransition, timestamp);
        if (transitionProgress < 0.0f) {
            return null;
        }
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase = this.mTransitionFilter;
        if (!(tXCGPUTransitionFilterBase == null || tXCGPUTransitionFilterBase.mType == currentTransition.type)) {
            tXCGPUTransitionFilterBase.uninitialize();
            this.mTransitionFilter = null;
        }
        if (this.mTransitionFilter == null) {
            createTransitionFilter(currentTransition.type);
        }
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase2 = this.mTransitionFilter;
        if (tXCGPUTransitionFilterBase2 == null) {
            return null;
        }
        tXCGPUTransitionFilterBase2.onOutputSizeChanged(pixelFrame.getWidth(), pixelFrame.getHeight());
        this.mTransitionFilter.setProgressForTransition(transitionProgress);
        GLTexture obtain = this.mGLTexturePool.obtain(pixelFrame.getWidth(), pixelFrame.getHeight());
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        this.mTransitionFilter.onDraw(pixelFrame.getTextureId(), obtain, floatBuffer, floatBuffer2);
        PixelFrame wrap = obtain.wrap(pixelFrame.getGLContext());
        wrap.setTimestamp(pixelFrame.getTimestamp());
        obtain.release();
        return wrap;
    }

    public void deleteLastTransitionEffect() {
        this.mTransitionConfig.deleteLastTransitionEffect();
    }

    public void destroy() {
        TXCGPUTransitionFilterBase tXCGPUTransitionFilterBase = this.mTransitionFilter;
        if (tXCGPUTransitionFilterBase != null) {
            tXCGPUTransitionFilterBase.uninitialize();
            this.mTransitionFilter = null;
        }
    }

    public void init(GLTexturePool gLTexturePool) {
        this.mGLTexturePool = gLTexturePool;
    }

    public void setReverse(boolean z11, long j11) {
        this.mIsReverse = z11;
        this.mVideoDuration = j11;
    }

    public boolean setTransitionEffect(int i11, long j11, long j12, long j13) {
        boolean z11;
        if (j12 <= j11) {
            long j14 = j13 + j12;
            if (j14 <= j11) {
                List<TransitionConfig.TransitionBean> transitionList = this.mTransitionConfig.getTransitionList();
                if (transitionList.size() != 0) {
                    for (TransitionConfig.TransitionBean next : transitionList) {
                        if (j12 >= next.startTimeMs && j12 <= next.endTimeMs) {
                            LiteavLog.w(TAG, "setTransitionEffect,start time invalid");
                        } else if (isInTransitionRange(j14, next)) {
                            LiteavLog.w(TAG, "setTransitionEffect,end time invalid");
                        }
                        z11 = false;
                    }
                    z11 = true;
                    if (!z11) {
                        return false;
                    }
                }
                TransitionConfig.TransitionBean transitionBean = new TransitionConfig.TransitionBean(i11);
                transitionBean.startTimeMs = j12;
                transitionBean.endTimeMs = j14;
                this.mTransitionConfig.addTransition(transitionBean);
                LiteavLog.d(TAG, "setTransitionEffect,success:".concat(String.valueOf(transitionBean)));
                return true;
            }
        }
        LiteavLog.w(TAG, "setTransitionEffect,not suitable for videoTotalDurationMs");
        return false;
    }
}

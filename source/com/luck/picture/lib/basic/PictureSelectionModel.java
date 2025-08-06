package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureSelectorFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnMediaEditInterceptListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class PictureSelectionModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionModel(PictureSelector pictureSelector, int i11) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i11;
        setMaxVideoSelectNum(selectorConfig.maxVideoSelectNum);
    }

    public PictureSelectorFragment build() {
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        if (activity instanceof IBridgePictureBehavior) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            selectorConfig.onResultCallListener = null;
            return new PictureSelectorFragment();
        }
        throw new NullPointerException("Use only build PictureSelectorFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
    }

    public PictureSelectorFragment buildLaunch(int i11, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        Objects.requireNonNull(onResultCallbackListener, "OnResultCallbackListener cannot be null");
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isResultListenerBack = true;
        selectorConfig.isActivityResultBack = false;
        selectorConfig.onResultCallListener = onResultCallbackListener;
        FragmentManager fragmentManager = null;
        if (activity instanceof FragmentActivity) {
            fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        }
        Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
        PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
        Fragment m02 = fragmentManager.m0(pictureSelectorFragment.getFragmentTag());
        if (m02 != null) {
            fragmentManager.q().s(m02).k();
        }
        fragmentManager.q().c(i11, pictureSelectorFragment, pictureSelectorFragment.getFragmentTag()).h(pictureSelectorFragment.getFragmentTag()).k();
        return pictureSelectorFragment;
    }

    public void forResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(onResultCallbackListener, "OnResultCallbackListener cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = true;
            selectorConfig.isActivityResultBack = false;
            selectorConfig.onResultCallListener = onResultCallbackListener;
            if (selectorConfig.imageEngine != null || selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                activity.startActivity(new Intent(activity, PictureSelectorSupporterActivity.class));
                activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
                return;
            }
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
    }

    public PictureSelectionModel isAutoVideoPlay(boolean z11) {
        this.selectionConfig.isAutoVideoPlay = z11;
        return this;
    }

    public PictureSelectionModel isAutomaticTitleRecyclerTop(boolean z11) {
        this.selectionConfig.isAutomaticTitleRecyclerTop = z11;
        return this;
    }

    public PictureSelectionModel isBmp(boolean z11) {
        this.selectionConfig.isBmp = z11;
        return this;
    }

    public PictureSelectionModel isCameraAroundState(boolean z11) {
        this.selectionConfig.isCameraAroundState = z11;
        return this;
    }

    public PictureSelectionModel isCameraForegroundService(boolean z11) {
        this.selectionConfig.isCameraForegroundService = z11;
        return this;
    }

    public PictureSelectionModel isCameraRotateImage(boolean z11) {
        this.selectionConfig.isCameraRotateImage = z11;
        return this;
    }

    public PictureSelectionModel isDirectReturnSingle(boolean z11) {
        boolean z12 = false;
        if (z11) {
            this.selectionConfig.isFastSlidingSelect = false;
        }
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1 && z11) {
            z12 = true;
        }
        selectorConfig.isDirectReturnSingle = z12;
        return this;
    }

    public PictureSelectionModel isDisplayCamera(boolean z11) {
        this.selectionConfig.isDisplayCamera = z11;
        return this;
    }

    public PictureSelectionModel isDisplayTimeAxis(boolean z11) {
        this.selectionConfig.isDisplayTimeAxis = z11;
        return this;
    }

    public PictureSelectionModel isEmptyResultReturn(boolean z11) {
        this.selectionConfig.isEmptyResultReturn = z11;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isEnableVideoSize(boolean z11) {
        this.selectionConfig.isSyncWidthAndHeight = z11;
        return this;
    }

    public PictureSelectionModel isFastSlidingSelect(boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.isDirectReturnSingle) {
            selectorConfig.isFastSlidingSelect = false;
        } else {
            selectorConfig.isFastSlidingSelect = z11;
        }
        return this;
    }

    public PictureSelectionModel isFilterSizeDuration(boolean z11) {
        this.selectionConfig.isFilterSizeDuration = z11;
        return this;
    }

    public PictureSelectionModel isGif(boolean z11) {
        this.selectionConfig.isGif = z11;
        return this;
    }

    public PictureSelectionModel isLoopAutoVideoPlay(boolean z11) {
        this.selectionConfig.isLoopAutoPlay = z11;
        return this;
    }

    public PictureSelectionModel isMaxSelectEnabledMask(boolean z11) {
        this.selectionConfig.isMaxSelectEnabledMask = z11;
        return this;
    }

    public PictureSelectionModel isOnlyObtainSandboxDir(boolean z11) {
        this.selectionConfig.isOnlySandboxDir = z11;
        return this;
    }

    public PictureSelectionModel isOpenClickSound(boolean z11) {
        this.selectionConfig.isOpenClickSound = z11;
        return this;
    }

    public PictureSelectionModel isOriginalControl(boolean z11) {
        this.selectionConfig.isOriginalControl = z11;
        return this;
    }

    public PictureSelectionModel isOriginalSkipCompress(boolean z11) {
        this.selectionConfig.isOriginalSkipCompress = z11;
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z11) {
        this.selectionConfig.isPageStrategy = z11;
        return this;
    }

    public PictureSelectionModel isPageSyncAlbumCount(boolean z11) {
        this.selectionConfig.isPageSyncAsCount = z11;
        return this;
    }

    public PictureSelectionModel isPreloadFirst(boolean z11) {
        this.selectionConfig.isPreloadFirst = z11;
        return this;
    }

    public PictureSelectionModel isPreviewAudio(boolean z11) {
        this.selectionConfig.isEnablePreviewAudio = z11;
        return this;
    }

    public PictureSelectionModel isPreviewFullScreenMode(boolean z11) {
        this.selectionConfig.isPreviewFullScreenMode = z11;
        return this;
    }

    public PictureSelectionModel isPreviewImage(boolean z11) {
        this.selectionConfig.isEnablePreviewImage = z11;
        return this;
    }

    public PictureSelectionModel isPreviewVideo(boolean z11) {
        this.selectionConfig.isEnablePreviewVideo = z11;
        return this;
    }

    public PictureSelectionModel isPreviewZoomEffect(boolean z11) {
        if (this.selectionConfig.chooseMode == SelectMimeType.ofAudio()) {
            this.selectionConfig.isPreviewZoomEffect = false;
        } else {
            this.selectionConfig.isPreviewZoomEffect = z11;
        }
        return this;
    }

    public PictureSelectionModel isQuickCapture(boolean z11) {
        this.selectionConfig.isQuickCapture = z11;
        return this;
    }

    public PictureSelectionModel isSelectZoomAnim(boolean z11) {
        this.selectionConfig.isSelectZoomAnim = z11;
        return this;
    }

    public PictureSelectionModel isSyncCover(boolean z11) {
        this.selectionConfig.isSyncCover = z11;
        return this;
    }

    public PictureSelectionModel isSyncWidthAndHeight(boolean z11) {
        this.selectionConfig.isSyncWidthAndHeight = z11;
        return this;
    }

    public PictureSelectionModel isUseSystemVideoPlayer(boolean z11) {
        this.selectionConfig.isUseSystemVideoPlayer = z11;
        return this;
    }

    public PictureSelectionModel isVideoPauseResumePlay(boolean z11) {
        this.selectionConfig.isPauseResumePlay = z11;
        return this;
    }

    public PictureSelectionModel isWebp(boolean z11) {
        this.selectionConfig.isWebp = z11;
        return this;
    }

    public PictureSelectionModel isWithSelectVideoImage(boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isWithVideoImage = selectorConfig.chooseMode == SelectMimeType.ofAll() && z11;
        return this;
    }

    public PictureSelectionModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    public PictureSelectionModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCompressEngine(CompressEngine compressEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressEngine = compressEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionModel setDefaultAlbumName(String str) {
        this.selectionConfig.defaultAlbumName = str;
        return this;
    }

    public PictureSelectionModel setDefaultLanguage(int i11) {
        this.selectionConfig.defaultLanguage = i11;
        return this;
    }

    public PictureSelectionModel setEditMediaInterceptListener(OnMediaEditInterceptListener onMediaEditInterceptListener) {
        this.selectionConfig.onEditMediaEventListener = onMediaEditInterceptListener;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setExtendLoaderEngine(ExtendLoaderEngine extendLoaderEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.loaderDataEngine = extendLoaderEngine;
        selectorConfig.isLoaderDataEngine = true;
        return this;
    }

    public PictureSelectionModel setFilterMaxFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j11;
        } else {
            this.selectionConfig.filterMaxFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setFilterMinFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.filterMinFileSize = j11;
        } else {
            this.selectionConfig.filterMinFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setFilterVideoMaxSecond(int i11) {
        this.selectionConfig.filterVideoMaxSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionModel setFilterVideoMinSecond(int i11) {
        this.selectionConfig.filterVideoMinSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionModel setGridItemSelectAnimListener(OnGridItemSelectAnimListener onGridItemSelectAnimListener) {
        this.selectionConfig.onItemSelectAnimListener = onGridItemSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionModel setImageSpanCount(int i11) {
        this.selectionConfig.imageSpanCount = i11;
        return this;
    }

    public PictureSelectionModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isInjectLayoutResource = onInjectLayoutResourceListener != null;
        selectorConfig.onLayoutResourceListener = onInjectLayoutResourceListener;
        return this;
    }

    public PictureSelectionModel setLanguage(int i11) {
        this.selectionConfig.language = i11;
        return this;
    }

    public PictureSelectionModel setLoaderFactoryEngine(IBridgeLoaderFactory iBridgeLoaderFactory) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.loaderFactory = iBridgeLoaderFactory;
        selectorConfig.isLoaderFactoryEngine = true;
        return this;
    }

    public PictureSelectionModel setMagicalEffectInterpolator(InterpolatorFactory interpolatorFactory) {
        this.selectionConfig.interpolatorFactory = interpolatorFactory;
        return this;
    }

    public PictureSelectionModel setMaxSelectNum(int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i11 = 1;
        }
        selectorConfig.maxSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setMaxVideoSelectNum(int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i11 = 0;
        }
        selectorConfig.maxVideoSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setMinAudioSelectNum(int i11) {
        this.selectionConfig.minAudioSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setMinSelectNum(int i11) {
        this.selectionConfig.minSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setMinVideoSelectNum(int i11) {
        this.selectionConfig.minVideoSelectNum = i11;
        return this;
    }

    public PictureSelectionModel setOfAllCameraType(int i11) {
        this.selectionConfig.ofAllCameraType = i11;
        return this;
    }

    public PictureSelectionModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionModel setPreviewInterceptListener(OnPreviewInterceptListener onPreviewInterceptListener) {
        this.selectionConfig.onPreviewInterceptListener = onPreviewInterceptListener;
        return this;
    }

    public PictureSelectionModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionModel setQueryOnlyMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.queryOnlyList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel setQuerySandboxDir(String str) {
        this.selectionConfig.sandboxDir = str;
        return this;
    }

    public PictureSelectionModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionModel setRecordVideoMaxSecond(int i11) {
        this.selectionConfig.recordVideoMaxSecond = i11;
        return this;
    }

    public PictureSelectionModel setRecordVideoMinSecond(int i11) {
        this.selectionConfig.recordVideoMinSecond = i11;
        return this;
    }

    public PictureSelectionModel setRecyclerAnimationMode(int i11) {
        this.selectionConfig.animationMode = i11;
        return this;
    }

    public PictureSelectionModel setRequestedOrientation(int i11) {
        this.selectionConfig.requestedOrientation = i11;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.sandboxFileEngine = sandboxFileEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionModel setSelectAnimListener(OnSelectAnimListener onSelectAnimListener) {
        this.selectionConfig.onSelectAnimListener = onSelectAnimListener;
        return this;
    }

    public PictureSelectionModel setSelectFilterListener(OnSelectFilterListener onSelectFilterListener) {
        this.selectionConfig.onSelectFilterListener = onSelectFilterListener;
        return this;
    }

    public PictureSelectionModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionModel setSelectMaxDurationSecond(int i11) {
        this.selectionConfig.selectMaxDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMaxFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j11;
        } else {
            this.selectionConfig.selectMaxFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectMinDurationSecond(int i11) {
        this.selectionConfig.selectMinDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionModel setSelectMinFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMinFileSize = j11;
        } else {
            this.selectionConfig.selectMinFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode != 1 || !selectorConfig.isDirectReturnSingle) {
            selectorConfig.addAllSelectResult(new ArrayList(list));
        } else {
            selectorConfig.selectedResult.clear();
        }
        return this;
    }

    public PictureSelectionModel setSelectionMode(int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.selectionMode = i11;
        int i12 = 1;
        if (i11 != 1) {
            i12 = selectorConfig.maxSelectNum;
        }
        selectorConfig.maxSelectNum = i12;
        return this;
    }

    public PictureSelectionModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionModel setSkipCropMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.skipCropList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    @Deprecated
    public PictureSelectionModel setVideoQuality(int i11) {
        this.selectionConfig.videoQuality = i11;
        return this;
    }

    public PictureSelectionModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionModel isPageStrategy(boolean z11, int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z11;
        if (i11 < 10) {
            i11 = 60;
        }
        selectorConfig.pageSize = i11;
        return this;
    }

    public PictureSelectionModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    public PictureSelectionModel setCompressEngine(CompressFileEngine compressFileEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressFileEngine = compressFileEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z11, boolean z12) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z11;
        selectorConfig.isFilterInvalidFile = z12;
        return this;
    }

    public PictureSelectionModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionModel isPageStrategy(boolean z11, int i11, boolean z12) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z11;
        if (i11 < 10) {
            i11 = 60;
        }
        selectorConfig.pageSize = i11;
        selectorConfig.isFilterInvalidFile = z12;
        return this;
    }

    public void forResult(int i11) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            if (selectorConfig.imageEngine != null || selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                Intent intent = new Intent(activity, PictureSelectorSupporterActivity.class);
                Fragment fragment = this.selector.getFragment();
                if (fragment != null) {
                    fragment.startActivityForResult(intent, i11);
                } else {
                    activity.startActivityForResult(intent, i11);
                }
                activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
                return;
            }
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
    }

    public void forResult(ActivityResultLauncher<Intent> activityResultLauncher) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(activityResultLauncher, "ActivityResultLauncher cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            if (selectorConfig.imageEngine != null || selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                activityResultLauncher.a(new Intent(activity, PictureSelectorSupporterActivity.class));
                activity.overridePendingTransition(this.selectionConfig.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
                return;
            }
            throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
        }
    }
}

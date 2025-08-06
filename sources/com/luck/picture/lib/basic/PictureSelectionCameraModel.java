package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureOnlyCameraFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnBitmapWatermarkEventListener;
import com.luck.picture.lib.interfaces.OnCameraInterceptListener;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRecordAudioInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class PictureSelectionCameraModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionCameraModel(PictureSelector pictureSelector, int i11) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i11;
        selectorConfig.isOnlyCamera = true;
        selectorConfig.isDisplayTimeAxis = false;
        selectorConfig.isPreviewFullScreenMode = false;
        selectorConfig.isPreviewZoomEffect = false;
        selectorConfig.isOpenClickSound = false;
    }

    private PictureSelectionCameraModel setMaxSelectNum(int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode == 1) {
            i11 = 1;
        }
        selectorConfig.maxSelectNum = i11;
        return this;
    }

    public PictureOnlyCameraFragment build() {
        Activity activity = this.selector.getActivity();
        Objects.requireNonNull(activity, "Activity cannot be null");
        if (activity instanceof IBridgePictureBehavior) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            selectorConfig.onResultCallListener = null;
            return new PictureOnlyCameraFragment();
        }
        throw new NullPointerException("Use only build PictureOnlyCameraFragment,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
    }

    public PictureOnlyCameraFragment buildLaunch(int i11, OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
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
        PictureOnlyCameraFragment pictureOnlyCameraFragment = new PictureOnlyCameraFragment();
        Fragment m02 = fragmentManager.m0(pictureOnlyCameraFragment.getFragmentTag());
        if (m02 != null) {
            fragmentManager.q().s(m02).k();
        }
        fragmentManager.q().c(i11, pictureOnlyCameraFragment, pictureOnlyCameraFragment.getFragmentTag()).h(pictureOnlyCameraFragment.getFragmentTag()).k();
        return pictureOnlyCameraFragment;
    }

    public void forResult() {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            FragmentManager fragmentManager = null;
            if (activity instanceof FragmentActivity) {
                fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            }
            Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
            if (activity instanceof IBridgePictureBehavior) {
                String str = PictureOnlyCameraFragment.TAG;
                Fragment m02 = fragmentManager.m0(str);
                if (m02 != null) {
                    fragmentManager.q().s(m02).k();
                }
                FragmentInjectManager.injectSystemRoomFragment(fragmentManager, str, PictureOnlyCameraFragment.newInstance());
                return;
            }
            throw new NullPointerException("Use only camera openCamera mode,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
    }

    public void forResultActivity(int i11) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            Intent intent = new Intent(activity, PictureSelectorTransparentActivity.class);
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i11);
            } else {
                activity.startActivityForResult(intent, i11);
            }
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
    }

    public PictureSelectionCameraModel isCameraAroundState(boolean z11) {
        this.selectionConfig.isCameraAroundState = z11;
        return this;
    }

    public PictureSelectionCameraModel isCameraForegroundService(boolean z11) {
        this.selectionConfig.isCameraForegroundService = z11;
        return this;
    }

    public PictureSelectionCameraModel isCameraRotateImage(boolean z11) {
        this.selectionConfig.isCameraRotateImage = z11;
        return this;
    }

    public PictureSelectionCameraModel isOriginalControl(boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isOriginalControl = z11;
        selectorConfig.isCheckOriginalImage = z11;
        return this;
    }

    public PictureSelectionCameraModel isOriginalSkipCompress(boolean z11) {
        this.selectionConfig.isOriginalSkipCompress = z11;
        return this;
    }

    public PictureSelectionCameraModel isQuickCapture(boolean z11) {
        this.selectionConfig.isQuickCapture = z11;
        return this;
    }

    public PictureSelectionCameraModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormat(String str) {
        this.selectionConfig.cameraImageFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraImageFormatForQ(String str) {
        this.selectionConfig.cameraImageFormatForQ = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraInterceptListener(OnCameraInterceptListener onCameraInterceptListener) {
        this.selectionConfig.onCameraInterceptListener = onCameraInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormat(String str) {
        this.selectionConfig.cameraVideoFormat = str;
        return this;
    }

    public PictureSelectionCameraModel setCameraVideoFormatForQ(String str) {
        this.selectionConfig.cameraVideoFormatForQ = str;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCompressEngine(CompressEngine compressEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressEngine = compressEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionCameraModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionCameraModel setDefaultLanguage(int i11) {
        this.selectionConfig.defaultLanguage = i11;
        return this;
    }

    public PictureSelectionCameraModel setLanguage(int i11) {
        this.selectionConfig.language = i11;
        return this;
    }

    public PictureSelectionCameraModel setMaxVideoSelectNum(int i11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            i11 = 0;
        }
        selectorConfig.maxVideoSelectNum = i11;
        return this;
    }

    public PictureSelectionCameraModel setOfAllCameraType(int i11) {
        this.selectionConfig.ofAllCameraType = i11;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioDir(String str) {
        this.selectionConfig.outPutAudioDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputAudioFileName(String str) {
        this.selectionConfig.outPutAudioFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraDir(String str) {
        this.selectionConfig.outPutCameraDir = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraImageFileName(String str) {
        this.selectionConfig.outPutCameraImageFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setOutputCameraVideoFileName(String str) {
        this.selectionConfig.outPutCameraVideoFileName = str;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionCameraModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setRecordAudioInterceptListener(OnRecordAudioInterceptListener onRecordAudioInterceptListener) {
        this.selectionConfig.onRecordAudioListener = onRecordAudioInterceptListener;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMaxSecond(int i11) {
        this.selectionConfig.recordVideoMaxSecond = i11;
        return this;
    }

    public PictureSelectionCameraModel setRecordVideoMinSecond(int i11) {
        this.selectionConfig.recordVideoMinSecond = i11;
        return this;
    }

    public PictureSelectionCameraModel setRequestedOrientation(int i11) {
        this.selectionConfig.requestedOrientation = i11;
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.sandboxFileEngine = sandboxFileEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxDurationSecond(int i11) {
        this.selectionConfig.selectMaxDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionCameraModel setSelectMaxFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j11;
        } else {
            this.selectionConfig.selectMaxFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectMinDurationSecond(int i11) {
        this.selectionConfig.selectMinDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionCameraModel setSelectMinFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMinFileSize = j11;
        } else {
            this.selectionConfig.selectMinFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionCameraModel setSelectedData(List<LocalMedia> list) {
        if (list == null) {
            return this;
        }
        setMaxSelectNum(list.size() + 1);
        setMaxVideoSelectNum(list.size() + 1);
        SelectorConfig selectorConfig = this.selectionConfig;
        if (selectorConfig.selectionMode != 1 || !selectorConfig.isDirectReturnSingle) {
            selectorConfig.addAllSelectResult(new ArrayList(list));
        } else {
            selectorConfig.selectedResult.clear();
        }
        return this;
    }

    @Deprecated
    public PictureSelectionCameraModel setVideoQuality(int i11) {
        this.selectionConfig.videoQuality = i11;
        return this;
    }

    public PictureSelectionCameraModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionCameraModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    public PictureSelectionCameraModel setCompressEngine(CompressFileEngine compressFileEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressFileEngine = compressFileEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionCameraModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public void forResultActivity(ActivityResultLauncher<Intent> activityResultLauncher) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(activityResultLauncher, "ActivityResultLauncher cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            activityResultLauncher.a(new Intent(activity, PictureSelectorTransparentActivity.class));
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
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
            FragmentManager fragmentManager = null;
            if (activity instanceof FragmentActivity) {
                fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            }
            Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
            String str = PictureOnlyCameraFragment.TAG;
            Fragment m02 = fragmentManager.m0(str);
            if (m02 != null) {
                fragmentManager.q().s(m02).k();
            }
            FragmentInjectManager.injectSystemRoomFragment(fragmentManager, str, PictureOnlyCameraFragment.newInstance());
        }
    }

    public void forResultActivity(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(onResultCallbackListener, "OnResultCallbackListener cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = true;
            selectorConfig.isActivityResultBack = false;
            selectorConfig.onResultCallListener = onResultCallbackListener;
            activity.startActivity(new Intent(activity, PictureSelectorTransparentActivity.class));
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
    }
}

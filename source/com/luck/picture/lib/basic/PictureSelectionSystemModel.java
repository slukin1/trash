package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.luck.picture.lib.PictureSelectorSystemFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
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
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnPermissionDeniedListener;
import com.luck.picture.lib.interfaces.OnPermissionDescriptionListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.interfaces.OnSelectFilterListener;
import com.luck.picture.lib.interfaces.OnSelectLimitTipsListener;
import com.luck.picture.lib.interfaces.OnVideoThumbnailEventListener;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.Arrays;
import java.util.Objects;

public final class PictureSelectionSystemModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionSystemModel(PictureSelector pictureSelector, int i11) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i11;
        selectorConfig.isPreviewFullScreenMode = false;
        selectorConfig.isPreviewZoomEffect = false;
    }

    public void forSystemResult(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(onResultCallbackListener, "OnResultCallbackListener cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.onResultCallListener = onResultCallbackListener;
            selectorConfig.isResultListenerBack = true;
            selectorConfig.isActivityResultBack = false;
            FragmentManager fragmentManager = null;
            if (activity instanceof FragmentActivity) {
                fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            }
            Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
            String str = PictureSelectorSystemFragment.TAG;
            Fragment m02 = fragmentManager.m0(str);
            if (m02 != null) {
                fragmentManager.q().s(m02).k();
            }
            FragmentInjectManager.injectSystemRoomFragment(fragmentManager, str, PictureSelectorSystemFragment.newInstance());
        }
    }

    public void forSystemResultActivity(int i11) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            Intent intent = new Intent(activity, PictureSelectorTransparentActivity.class);
            intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
            Fragment fragment = this.selector.getFragment();
            if (fragment != null) {
                fragment.startActivityForResult(intent, i11);
            } else {
                activity.startActivityForResult(intent, i11);
            }
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
    }

    public PictureSelectionSystemModel isOriginalControl(boolean z11) {
        this.selectionConfig.isCheckOriginalImage = z11;
        return this;
    }

    public PictureSelectionSystemModel isOriginalSkipCompress(boolean z11) {
        this.selectionConfig.isOriginalSkipCompress = z11;
        return this;
    }

    public PictureSelectionSystemModel setAddBitmapWatermarkListener(OnBitmapWatermarkEventListener onBitmapWatermarkEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onBitmapWatermarkListener = onBitmapWatermarkEventListener;
        }
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setCompressEngine(CompressEngine compressEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressEngine = compressEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setCropEngine(CropEngine cropEngine) {
        this.selectionConfig.cropEngine = cropEngine;
        return this;
    }

    public PictureSelectionSystemModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionSystemModel setPermissionDeniedListener(OnPermissionDeniedListener onPermissionDeniedListener) {
        this.selectionConfig.onPermissionDeniedListener = onPermissionDeniedListener;
        return this;
    }

    public PictureSelectionSystemModel setPermissionDescriptionListener(OnPermissionDescriptionListener onPermissionDescriptionListener) {
        this.selectionConfig.onPermissionDescriptionListener = onPermissionDescriptionListener;
        return this;
    }

    public PictureSelectionSystemModel setPermissionsInterceptListener(OnPermissionsInterceptListener onPermissionsInterceptListener) {
        this.selectionConfig.onPermissionsEventListener = onPermissionsInterceptListener;
        return this;
    }

    @Deprecated
    public PictureSelectionSystemModel setSandboxFileEngine(SandboxFileEngine sandboxFileEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.sandboxFileEngine = sandboxFileEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectFilterListener(OnSelectFilterListener onSelectFilterListener) {
        this.selectionConfig.onSelectFilterListener = onSelectFilterListener;
        return this;
    }

    public PictureSelectionSystemModel setSelectLimitTipsListener(OnSelectLimitTipsListener onSelectLimitTipsListener) {
        this.selectionConfig.onSelectLimitTipsListener = onSelectLimitTipsListener;
        return this;
    }

    public PictureSelectionSystemModel setSelectMaxDurationSecond(int i11) {
        this.selectionConfig.selectMaxDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionSystemModel setSelectMaxFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMaxFileSize = j11;
        } else {
            this.selectionConfig.selectMaxFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectMinDurationSecond(int i11) {
        this.selectionConfig.selectMinDurationSecond = i11 * 1000;
        return this;
    }

    public PictureSelectionSystemModel setSelectMinFileSize(long j11) {
        if (j11 >= 1048576) {
            this.selectionConfig.selectMinFileSize = j11;
        } else {
            this.selectionConfig.selectMinFileSize = j11 * 1024;
        }
        return this;
    }

    public PictureSelectionSystemModel setSelectionMode(int i11) {
        this.selectionConfig.selectionMode = i11;
        return this;
    }

    public PictureSelectionSystemModel setSkipCropMimeType(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            this.selectionConfig.skipCropList.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public PictureSelectionSystemModel setVideoThumbnailListener(OnVideoThumbnailEventListener onVideoThumbnailEventListener) {
        if (this.selectionConfig.chooseMode != SelectMimeType.ofAudio()) {
            this.selectionConfig.onVideoThumbnailEventListener = onVideoThumbnailEventListener;
        }
        return this;
    }

    public PictureSelectionSystemModel setCropEngine(CropFileEngine cropFileEngine) {
        this.selectionConfig.cropFileEngine = cropFileEngine;
        return this;
    }

    public PictureSelectionSystemModel setCompressEngine(CompressFileEngine compressFileEngine) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.compressFileEngine = compressFileEngine;
        selectorConfig.isCompressEngine = true;
        return this;
    }

    public PictureSelectionSystemModel setSandboxFileEngine(UriToFileTransformEngine uriToFileTransformEngine) {
        if (SdkVersionUtils.isQ()) {
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.uriToFileTransformEngine = uriToFileTransformEngine;
            selectorConfig.isSandboxFileEngine = true;
        } else {
            this.selectionConfig.isSandboxFileEngine = false;
        }
        return this;
    }

    public void forSystemResultActivity(ActivityResultLauncher<Intent> activityResultLauncher) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(activityResultLauncher, "ActivityResultLauncher cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = false;
            selectorConfig.isActivityResultBack = true;
            Intent intent = new Intent(activity, PictureSelectorTransparentActivity.class);
            intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
            activityResultLauncher.a(intent);
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
    }

    public void forSystemResult() {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            if (activity instanceof IBridgePictureBehavior) {
                SelectorConfig selectorConfig = this.selectionConfig;
                selectorConfig.isActivityResultBack = true;
                FragmentManager fragmentManager = null;
                selectorConfig.onResultCallListener = null;
                selectorConfig.isResultListenerBack = false;
                if (activity instanceof FragmentActivity) {
                    fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                }
                Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
                String str = PictureSelectorSystemFragment.TAG;
                Fragment m02 = fragmentManager.m0(str);
                if (m02 != null) {
                    fragmentManager.q().s(m02).k();
                }
                FragmentInjectManager.injectSystemRoomFragment(fragmentManager, str, PictureSelectorSystemFragment.newInstance());
                return;
            }
            throw new NullPointerException("Use only forSystemResult();,Activity or Fragment interface needs to be implemented " + IBridgePictureBehavior.class);
        }
    }

    public void forSystemResultActivity(OnResultCallbackListener<LocalMedia> onResultCallbackListener) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            Objects.requireNonNull(onResultCallbackListener, "OnResultCallbackListener cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            selectorConfig.isResultListenerBack = true;
            selectorConfig.isActivityResultBack = false;
            selectorConfig.onResultCallListener = onResultCallbackListener;
            Intent intent = new Intent(activity, PictureSelectorTransparentActivity.class);
            intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 1);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.ps_anim_fade_in, 0);
        }
    }
}

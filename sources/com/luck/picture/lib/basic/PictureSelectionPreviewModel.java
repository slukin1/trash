package com.luck.picture.lib.basic;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.PictureSelectorPreviewFragment;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnCustomLoadingListener;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnInjectActivityPreviewListener;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import java.util.ArrayList;
import java.util.Objects;

public final class PictureSelectionPreviewModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionPreviewModel(PictureSelector pictureSelector) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.isPreviewZoomEffect = false;
    }

    public PictureSelectionPreviewModel isAutoVideoPlay(boolean z11) {
        this.selectionConfig.isAutoVideoPlay = z11;
        return this;
    }

    @Deprecated
    public PictureSelectionPreviewModel isEnableVideoSize(boolean z11) {
        this.selectionConfig.isSyncWidthAndHeight = z11;
        return this;
    }

    public PictureSelectionPreviewModel isHidePreviewDownload(boolean z11) {
        this.selectionConfig.isHidePreviewDownload = z11;
        return this;
    }

    public PictureSelectionPreviewModel isLoopAutoVideoPlay(boolean z11) {
        this.selectionConfig.isLoopAutoPlay = z11;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewFullScreenMode(boolean z11) {
        this.selectionConfig.isPreviewFullScreenMode = z11;
        return this;
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z11, ViewGroup viewGroup) {
        return isPreviewZoomEffect(z11, this.selectionConfig.isPreviewFullScreenMode, viewGroup);
    }

    public PictureSelectionPreviewModel isSyncWidthAndHeight(boolean z11) {
        this.selectionConfig.isSyncWidthAndHeight = z11;
        return this;
    }

    public PictureSelectionPreviewModel isUseSystemVideoPlayer(boolean z11) {
        this.selectionConfig.isUseSystemVideoPlayer = z11;
        return this;
    }

    public PictureSelectionPreviewModel isVideoPauseResumePlay(boolean z11) {
        this.selectionConfig.isPauseResumePlay = z11;
        return this;
    }

    public PictureSelectionPreviewModel setAttachViewLifecycle(IBridgeViewLifecycle iBridgeViewLifecycle) {
        this.selectionConfig.viewLifecycle = iBridgeViewLifecycle;
        return this;
    }

    public PictureSelectionPreviewModel setCustomLoadingListener(OnCustomLoadingListener onCustomLoadingListener) {
        this.selectionConfig.onCustomLoadingListener = onCustomLoadingListener;
        return this;
    }

    public PictureSelectionPreviewModel setDefaultLanguage(int i11) {
        this.selectionConfig.defaultLanguage = i11;
        return this;
    }

    public PictureSelectionPreviewModel setExternalPreviewEventListener(OnExternalPreviewEventListener onExternalPreviewEventListener) {
        this.selectionConfig.onExternalPreviewEventListener = onExternalPreviewEventListener;
        return this;
    }

    public PictureSelectionPreviewModel setImageEngine(ImageEngine imageEngine) {
        this.selectionConfig.imageEngine = imageEngine;
        return this;
    }

    public PictureSelectionPreviewModel setInjectActivityPreviewFragment(OnInjectActivityPreviewListener onInjectActivityPreviewListener) {
        this.selectionConfig.onInjectActivityPreviewListener = onInjectActivityPreviewListener;
        return this;
    }

    public PictureSelectionPreviewModel setInjectLayoutResourceListener(OnInjectLayoutResourceListener onInjectLayoutResourceListener) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isInjectLayoutResource = onInjectLayoutResourceListener != null;
        selectorConfig.onLayoutResourceListener = onInjectLayoutResourceListener;
        return this;
    }

    public PictureSelectionPreviewModel setLanguage(int i11) {
        this.selectionConfig.language = i11;
        return this;
    }

    public PictureSelectionPreviewModel setSelectorUIStyle(PictureSelectorStyle pictureSelectorStyle) {
        if (pictureSelectorStyle != null) {
            this.selectionConfig.selectorStyle = pictureSelectorStyle;
        }
        return this;
    }

    public PictureSelectionPreviewModel setVideoPlayerEngine(VideoPlayerEngine videoPlayerEngine) {
        this.selectionConfig.videoPlayerEngine = videoPlayerEngine;
        return this;
    }

    public void startActivityPreview(int i11, boolean z11, ArrayList<LocalMedia> arrayList) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            } else if (arrayList == null || arrayList.size() == 0) {
                throw new NullPointerException("preview data is null");
            } else {
                Intent intent = new Intent(activity, PictureSelectorTransparentActivity.class);
                this.selectionConfig.addSelectedPreviewResult(arrayList);
                intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW, true);
                intent.putExtra(PictureConfig.EXTRA_MODE_TYPE_SOURCE, 2);
                intent.putExtra(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, i11);
                intent.putExtra(PictureConfig.EXTRA_EXTERNAL_PREVIEW_DISPLAY_DELETE, z11);
                Fragment fragment = this.selector.getFragment();
                if (fragment != null) {
                    fragment.startActivity(intent);
                } else {
                    activity.startActivity(intent);
                }
                SelectorConfig selectorConfig2 = this.selectionConfig;
                if (selectorConfig2.isPreviewZoomEffect) {
                    int i12 = R.anim.ps_anim_fade_in;
                    activity.overridePendingTransition(i12, i12);
                    return;
                }
                activity.overridePendingTransition(selectorConfig2.selectorStyle.getWindowAnimationStyle().activityEnterAnimation, R.anim.ps_anim_fade_in);
            }
        }
    }

    public void startFragmentPreview(int i11, boolean z11, ArrayList<LocalMedia> arrayList) {
        startFragmentPreview((PictureSelectorPreviewFragment) null, i11, z11, arrayList);
    }

    public PictureSelectionPreviewModel isPreviewZoomEffect(boolean z11, boolean z12, ViewGroup viewGroup) {
        if ((viewGroup instanceof RecyclerView) || (viewGroup instanceof ListView)) {
            if (z11) {
                if (z12) {
                    BuildRecycleItemViewParams.generateViewParams(viewGroup, 0);
                } else {
                    BuildRecycleItemViewParams.generateViewParams(viewGroup, DensityUtil.getStatusBarHeight(this.selector.getActivity()));
                }
            }
            this.selectionConfig.isPreviewZoomEffect = z11;
            return this;
        }
        throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
    }

    public void startFragmentPreview(PictureSelectorPreviewFragment pictureSelectorPreviewFragment, int i11, boolean z11, ArrayList<LocalMedia> arrayList) {
        String str;
        if (!DoubleUtils.isFastDoubleClick()) {
            Activity activity = this.selector.getActivity();
            Objects.requireNonNull(activity, "Activity cannot be null");
            SelectorConfig selectorConfig = this.selectionConfig;
            if (selectorConfig.imageEngine == null && selectorConfig.chooseMode != SelectMimeType.ofAudio()) {
                throw new NullPointerException("imageEngine is null,Please implement ImageEngine");
            } else if (arrayList == null || arrayList.size() == 0) {
                throw new NullPointerException("preview data is null");
            } else {
                FragmentManager fragmentManager = null;
                if (activity instanceof FragmentActivity) {
                    fragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                }
                Objects.requireNonNull(fragmentManager, "FragmentManager cannot be null");
                if (pictureSelectorPreviewFragment != null) {
                    str = pictureSelectorPreviewFragment.getFragmentTag();
                } else {
                    str = PictureSelectorPreviewFragment.TAG;
                    pictureSelectorPreviewFragment = PictureSelectorPreviewFragment.newInstance();
                }
                if (ActivityCompatHelper.checkFragmentNonExits((FragmentActivity) activity, str)) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    pictureSelectorPreviewFragment.setExternalPreviewData(i11, arrayList2.size(), arrayList2, z11);
                    FragmentInjectManager.injectSystemRoomFragment(fragmentManager, str, pictureSelectorPreviewFragment);
                }
            }
        }
    }
}

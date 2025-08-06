package com.luck.picture.lib.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.utils.BitmapUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.MediaUtils;

public abstract class BasePreviewHolder extends RecyclerView.ViewHolder {
    public static final int ADAPTER_TYPE_AUDIO = 3;
    public static final int ADAPTER_TYPE_IMAGE = 1;
    public static final int ADAPTER_TYPE_VIDEO = 2;
    public PhotoView coverImageView;
    public OnPreviewEventListener mPreviewEventListener;
    public LocalMedia media;
    public final int screenAppInHeight;
    public final int screenHeight;
    public final int screenWidth;
    public final SelectorConfig selectorConfig = SelectorProviders.getInstance().getSelectorConfig();

    public interface OnPreviewEventListener {
        void onBackPressed();

        void onLongPressDownload(LocalMedia localMedia);

        void onPreviewVideoTitle(String str);
    }

    public BasePreviewHolder(View view) {
        super(view);
        this.screenWidth = DensityUtil.getRealScreenWidth(view.getContext());
        this.screenHeight = DensityUtil.getScreenHeight(view.getContext());
        this.screenAppInHeight = DensityUtil.getRealScreenHeight(view.getContext());
        this.coverImageView = (PhotoView) view.findViewById(R.id.preview_image);
        findViews(view);
    }

    public static BasePreviewHolder generate(ViewGroup viewGroup, int i11, int i12) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i12, viewGroup, false);
        if (i11 == 2) {
            return new PreviewVideoHolder(inflate);
        }
        if (i11 == 3) {
            return new PreviewAudioHolder(inflate);
        }
        return new PreviewImageHolder(inflate);
    }

    public void bindData(LocalMedia localMedia, int i11) {
        this.media = localMedia;
        int[] realSizeFromMedia = getRealSizeFromMedia(localMedia);
        int[] maxImageSize = BitmapUtils.getMaxImageSize(realSizeFromMedia[0], realSizeFromMedia[1]);
        loadImage(localMedia, maxImageSize[0], maxImageSize[1]);
        setScaleDisplaySize(localMedia);
        setCoverScaleType(localMedia);
        onClickBackPressed();
        onLongPressDownload(localMedia);
    }

    public abstract void findViews(View view);

    public int[] getRealSizeFromMedia(LocalMedia localMedia) {
        if (!localMedia.isCut() || localMedia.getCropImageWidth() <= 0 || localMedia.getCropImageHeight() <= 0) {
            return new int[]{localMedia.getWidth(), localMedia.getHeight()};
        }
        return new int[]{localMedia.getCropImageWidth(), localMedia.getCropImageHeight()};
    }

    public boolean isPlaying() {
        return false;
    }

    public abstract void loadImage(LocalMedia localMedia, int i11, int i12);

    public abstract void onClickBackPressed();

    public abstract void onLongPressDownload(LocalMedia localMedia);

    public void onViewAttachedToWindow() {
    }

    public void onViewDetachedFromWindow() {
    }

    public void release() {
    }

    public void resumePausePlay() {
    }

    public void setCoverScaleType(LocalMedia localMedia) {
        if (MediaUtils.isLongImage(localMedia.getWidth(), localMedia.getHeight())) {
            this.coverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            this.coverImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void setOnPreviewEventListener(OnPreviewEventListener onPreviewEventListener) {
        this.mPreviewEventListener = onPreviewEventListener;
    }

    public void setScaleDisplaySize(LocalMedia localMedia) {
        if (!this.selectorConfig.isPreviewZoomEffect && this.screenWidth < this.screenHeight && localMedia.getWidth() > 0 && localMedia.getHeight() > 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.coverImageView.getLayoutParams();
            layoutParams.width = this.screenWidth;
            layoutParams.height = this.screenAppInHeight;
            layoutParams.gravity = 17;
        }
    }
}

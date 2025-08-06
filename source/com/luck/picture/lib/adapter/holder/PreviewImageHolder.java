package com.luck.picture.lib.adapter.holder;

import android.view.View;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;

public class PreviewImageHolder extends BasePreviewHolder {
    public PreviewImageHolder(View view) {
        super(view);
    }

    public void findViews(View view) {
    }

    public void loadImage(LocalMedia localMedia, int i11, int i12) {
        if (this.selectorConfig.imageEngine != null) {
            String availablePath = localMedia.getAvailablePath();
            if (i11 == -1 && i12 == -1) {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), availablePath, this.coverImageView);
            } else {
                this.selectorConfig.imageEngine.loadImage(this.itemView.getContext(), this.coverImageView, availablePath, i11, i12);
            }
        }
    }

    public void onClickBackPressed() {
        this.coverImageView.setOnViewTapListener(new OnViewTapListener() {
            public void onViewTap(View view, float f11, float f12) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewImageHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewImageHolder.this.mPreviewEventListener;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }
}

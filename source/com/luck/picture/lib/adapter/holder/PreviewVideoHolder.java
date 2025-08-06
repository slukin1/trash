package com.luck.picture.lib.adapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.MediaPlayerEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.IntentUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class PreviewVideoHolder extends BasePreviewHolder {
    private boolean isPlayed = false;
    public ImageView ivPlayButton;
    private final OnPlayerListener mPlayerListener = new OnPlayerListener() {
        public void onPlayerEnd() {
            PreviewVideoHolder.this.playerDefaultUI();
        }

        public void onPlayerError() {
            PreviewVideoHolder.this.playerDefaultUI();
        }

        public void onPlayerLoading() {
            PreviewVideoHolder.this.progress.setVisibility(0);
        }

        public void onPlayerReady() {
            PreviewVideoHolder.this.playerIngUI();
        }
    };
    public ProgressBar progress;
    public View videoPlayer;

    public PreviewVideoHolder(View view) {
        super(view);
        this.ivPlayButton = (ImageView) view.findViewById(R.id.iv_play_video);
        this.progress = (ProgressBar) view.findViewById(R.id.progress);
        this.ivPlayButton.setVisibility(this.selectorConfig.isPreviewZoomEffect ? 8 : 0);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.videoPlayerEngine == null) {
            selectorConfig.videoPlayerEngine = new MediaPlayerEngine();
        }
        View onCreateVideoPlayer = this.selectorConfig.videoPlayerEngine.onCreateVideoPlayer(view.getContext());
        this.videoPlayer = onCreateVideoPlayer;
        if (onCreateVideoPlayer != null) {
            if (onCreateVideoPlayer.getLayoutParams() == null) {
                this.videoPlayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.indexOfChild(this.videoPlayer) != -1) {
                viewGroup.removeView(this.videoPlayer);
            }
            viewGroup.addView(this.videoPlayer, 0);
            this.videoPlayer.setVisibility(8);
            return;
        }
        throw new NullPointerException("onCreateVideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
    }

    /* access modifiers changed from: private */
    public void dispatchPlay() {
        if (!this.isPlayed) {
            startPlay();
        } else if (isPlaying()) {
            onPause();
        } else {
            onResume();
        }
    }

    private void onResume() {
        this.ivPlayButton.setVisibility(8);
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onResume(this.videoPlayer);
        }
    }

    /* access modifiers changed from: private */
    public void playerDefaultUI() {
        this.isPlayed = false;
        this.ivPlayButton.setVisibility(0);
        this.progress.setVisibility(8);
        this.coverImageView.setVisibility(0);
        this.videoPlayer.setVisibility(8);
        BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = this.mPreviewEventListener;
        if (onPreviewEventListener != null) {
            onPreviewEventListener.onPreviewVideoTitle((String) null);
        }
    }

    /* access modifiers changed from: private */
    public void playerIngUI() {
        this.progress.setVisibility(8);
        this.ivPlayButton.setVisibility(8);
        this.coverImageView.setVisibility(8);
        this.videoPlayer.setVisibility(0);
    }

    public void bindData(LocalMedia localMedia, int i11) {
        super.bindData(localMedia, i11);
        setScaleDisplaySize(localMedia);
        this.ivPlayButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.selectorConfig.isPauseResumePlay) {
                    previewVideoHolder.dispatchPlay();
                } else {
                    previewVideoHolder.startPlay();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PreviewVideoHolder previewVideoHolder = PreviewVideoHolder.this;
                if (previewVideoHolder.selectorConfig.isPauseResumePlay) {
                    previewVideoHolder.dispatchPlay();
                } else {
                    BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = previewVideoHolder.mPreviewEventListener;
                    if (onPreviewEventListener != null) {
                        onPreviewEventListener.onBackPressed();
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void findViews(View view) {
    }

    public boolean isPlaying() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        return videoPlayerEngine != null && videoPlayerEngine.isPlaying(this.videoPlayer);
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
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewVideoHolder.this.mPreviewEventListener;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }

    public void onPause() {
        this.ivPlayButton.setVisibility(0);
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPause(this.videoPlayer);
        }
    }

    public void onViewAttachedToWindow() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPlayerAttachedToWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.addPlayListener(this.mPlayerListener);
        }
    }

    public void onViewDetachedFromWindow() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.onPlayerDetachedFromWindow(this.videoPlayer);
            this.selectorConfig.videoPlayerEngine.removePlayListener(this.mPlayerListener);
        }
        playerDefaultUI();
    }

    public void release() {
        VideoPlayerEngine videoPlayerEngine = this.selectorConfig.videoPlayerEngine;
        if (videoPlayerEngine != null) {
            videoPlayerEngine.removePlayListener(this.mPlayerListener);
            this.selectorConfig.videoPlayerEngine.destroy(this.videoPlayer);
        }
    }

    public void resumePausePlay() {
        if (isPlaying()) {
            onPause();
        } else {
            onResume();
        }
    }

    public void setScaleDisplaySize(LocalMedia localMedia) {
        super.setScaleDisplaySize(localMedia);
        if (!this.selectorConfig.isPreviewZoomEffect && this.screenWidth < this.screenHeight) {
            ViewGroup.LayoutParams layoutParams = this.videoPlayer.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = this.screenWidth;
                layoutParams2.height = this.screenAppInHeight;
                layoutParams2.gravity = 17;
            } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.width = this.screenWidth;
                layoutParams3.height = this.screenAppInHeight;
                layoutParams3.addRule(13);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams4.width = this.screenWidth;
                layoutParams4.height = this.screenAppInHeight;
                layoutParams4.gravity = 17;
            } else if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams5.width = this.screenWidth;
                layoutParams5.height = this.screenAppInHeight;
                layoutParams5.f7942h = 0;
                layoutParams5.f7948k = 0;
            }
        }
    }

    public void startPlay() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.isUseSystemVideoPlayer) {
            IntentUtils.startSystemPlayerVideo(this.itemView.getContext(), this.media.getAvailablePath());
        } else if (this.videoPlayer == null) {
            throw new NullPointerException("VideoPlayer cannot be empty,Please implement " + VideoPlayerEngine.class);
        } else if (selectorConfig.videoPlayerEngine != null) {
            this.progress.setVisibility(0);
            this.ivPlayButton.setVisibility(8);
            this.mPreviewEventListener.onPreviewVideoTitle(this.media.getFileName());
            this.isPlayed = true;
            this.selectorConfig.videoPlayerEngine.onStarPlayer(this.videoPlayer, this.media);
        }
    }
}

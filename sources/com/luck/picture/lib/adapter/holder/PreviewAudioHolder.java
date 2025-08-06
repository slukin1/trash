package com.luck.picture.lib.adapter.holder;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BasePreviewHolder;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.IOException;

public class PreviewAudioHolder extends BasePreviewHolder {
    private static final long MAX_BACK_FAST_MS = 3000;
    private static final long MAX_UPDATE_INTERVAL_MS = 1000;
    private static final long MIN_CURRENT_POSITION = 1000;
    /* access modifiers changed from: private */
    public boolean isPausePlayer = false;
    public ImageView ivPlayBack;
    public ImageView ivPlayButton;
    public ImageView ivPlayFast;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    private final MediaPlayer.OnCompletionListener mPlayCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            PreviewAudioHolder.this.stopUpdateProgress();
            PreviewAudioHolder.this.resetMediaPlayer();
            PreviewAudioHolder.this.playerDefaultUI(true);
        }
    };
    private final MediaPlayer.OnErrorListener mPlayErrorListener = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            PreviewAudioHolder.this.resetMediaPlayer();
            PreviewAudioHolder.this.playerDefaultUI(true);
            return false;
        }
    };
    private final MediaPlayer.OnPreparedListener mPlayPreparedListener = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (mediaPlayer.isPlaying()) {
                PreviewAudioHolder.this.seekBar.setMax(mediaPlayer.getDuration());
                PreviewAudioHolder.this.startUpdateProgress();
                PreviewAudioHolder.this.playerIngUI();
                return;
            }
            PreviewAudioHolder.this.stopUpdateProgress();
            PreviewAudioHolder.this.resetMediaPlayer();
            PreviewAudioHolder.this.playerDefaultUI(true);
        }
    };
    /* access modifiers changed from: private */
    public MediaPlayer mPlayer = new MediaPlayer();
    public Runnable mTickerRunnable = new Runnable() {
        public void run() {
            long currentPosition = (long) PreviewAudioHolder.this.mPlayer.getCurrentPosition();
            String formatDurationTime = DateUtils.formatDurationTime(currentPosition);
            if (!TextUtils.equals(formatDurationTime, PreviewAudioHolder.this.tvCurrentTime.getText())) {
                PreviewAudioHolder.this.tvCurrentTime.setText(formatDurationTime);
                if (((long) PreviewAudioHolder.this.mPlayer.getDuration()) - currentPosition > 1000) {
                    PreviewAudioHolder.this.seekBar.setProgress((int) currentPosition);
                } else {
                    PreviewAudioHolder previewAudioHolder = PreviewAudioHolder.this;
                    previewAudioHolder.seekBar.setProgress(previewAudioHolder.mPlayer.getDuration());
                }
            }
            PreviewAudioHolder.this.mHandler.postDelayed(this, 1000 - (currentPosition % 1000));
        }
    };
    public SeekBar seekBar;
    public TextView tvAudioName;
    public TextView tvCurrentTime;
    public TextView tvTotalDuration;

    public PreviewAudioHolder(View view) {
        super(view);
        this.ivPlayButton = (ImageView) view.findViewById(R.id.iv_play_video);
        this.tvAudioName = (TextView) view.findViewById(R.id.tv_audio_name);
        this.tvCurrentTime = (TextView) view.findViewById(R.id.tv_current_time);
        this.tvTotalDuration = (TextView) view.findViewById(R.id.tv_total_duration);
        this.seekBar = (SeekBar) view.findViewById(R.id.music_seek_bar);
        this.ivPlayBack = (ImageView) view.findViewById(R.id.iv_play_back);
        this.ivPlayFast = (ImageView) view.findViewById(R.id.iv_play_fast);
    }

    /* access modifiers changed from: private */
    public void fastAudioPlay() {
        long progress = ((long) this.seekBar.getProgress()) + 3000;
        if (progress >= ((long) this.seekBar.getMax())) {
            SeekBar seekBar2 = this.seekBar;
            seekBar2.setProgress(seekBar2.getMax());
        } else {
            this.seekBar.setProgress((int) progress);
        }
        setCurrentPlayTime(this.seekBar.getProgress());
        this.mPlayer.seekTo(this.seekBar.getProgress());
    }

    /* access modifiers changed from: private */
    public void pausePlayer() {
        this.mPlayer.pause();
        this.isPausePlayer = true;
        playerDefaultUI(false);
        stopUpdateProgress();
    }

    /* access modifiers changed from: private */
    public void playerDefaultUI(boolean z11) {
        stopUpdateProgress();
        if (z11) {
            this.seekBar.setProgress(0);
            this.tvCurrentTime.setText("00:00");
        }
        setBackFastUI(false);
        this.ivPlayButton.setImageResource(R.drawable.ps_ic_audio_play);
        BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = this.mPreviewEventListener;
        if (onPreviewEventListener != null) {
            onPreviewEventListener.onPreviewVideoTitle((String) null);
        }
    }

    /* access modifiers changed from: private */
    public void playerIngUI() {
        startUpdateProgress();
        setBackFastUI(true);
        this.ivPlayButton.setImageResource(R.drawable.ps_ic_audio_stop);
    }

    /* access modifiers changed from: private */
    public void resetMediaPlayer() {
        this.isPausePlayer = false;
        this.mPlayer.stop();
        this.mPlayer.reset();
    }

    /* access modifiers changed from: private */
    public void resumePlayer() {
        this.mPlayer.seekTo(this.seekBar.getProgress());
        this.mPlayer.start();
        startUpdateProgress();
        playerIngUI();
    }

    private void setBackFastUI(boolean z11) {
        this.ivPlayBack.setEnabled(z11);
        this.ivPlayFast.setEnabled(z11);
        if (z11) {
            this.ivPlayBack.setAlpha(1.0f);
            this.ivPlayFast.setAlpha(1.0f);
            return;
        }
        this.ivPlayBack.setAlpha(0.5f);
        this.ivPlayFast.setAlpha(0.5f);
    }

    /* access modifiers changed from: private */
    public void setCurrentPlayTime(int i11) {
        this.tvCurrentTime.setText(DateUtils.formatDurationTime((long) i11));
    }

    private void setMediaPlayerListener() {
        this.mPlayer.setOnCompletionListener(this.mPlayCompletionListener);
        this.mPlayer.setOnErrorListener(this.mPlayErrorListener);
        this.mPlayer.setOnPreparedListener(this.mPlayPreparedListener);
    }

    private void setNullMediaPlayerListener() {
        this.mPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
        this.mPlayer.setOnErrorListener((MediaPlayer.OnErrorListener) null);
        this.mPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
    }

    /* access modifiers changed from: private */
    public void slowAudioPlay() {
        long progress = ((long) this.seekBar.getProgress()) - 3000;
        if (progress <= 0) {
            this.seekBar.setProgress(0);
        } else {
            this.seekBar.setProgress((int) progress);
        }
        setCurrentPlayTime(this.seekBar.getProgress());
        this.mPlayer.seekTo(this.seekBar.getProgress());
    }

    /* access modifiers changed from: private */
    public void startPlayer(String str) {
        try {
            if (PictureMimeType.isContent(str)) {
                this.mPlayer.setDataSource(this.itemView.getContext(), Uri.parse(str));
            } else {
                this.mPlayer.setDataSource(str);
            }
            this.mPlayer.prepare();
            this.mPlayer.seekTo(this.seekBar.getProgress());
            this.mPlayer.start();
            this.isPausePlayer = false;
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void startUpdateProgress() {
        this.mHandler.post(this.mTickerRunnable);
    }

    /* access modifiers changed from: private */
    public void stopUpdateProgress() {
        this.mHandler.removeCallbacks(this.mTickerRunnable);
    }

    public void bindData(final LocalMedia localMedia, int i11) {
        final String availablePath = localMedia.getAvailablePath();
        String yearDataFormat = DateUtils.getYearDataFormat(localMedia.getDateAddedTime());
        String formatAccurateUnitFileSize = PictureFileUtils.formatAccurateUnitFileSize(localMedia.getSize());
        loadImage(localMedia, -1, -1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(localMedia.getFileName());
        sb2.append("\n");
        sb2.append(yearDataFormat);
        sb2.append(" - ");
        sb2.append(formatAccurateUnitFileSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb2.toString());
        String str = yearDataFormat + " - " + formatAccurateUnitFileSize;
        int indexOf = sb2.indexOf(str);
        int length = str.length() + indexOf;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(DensityUtil.dip2px(this.itemView.getContext(), 12.0f)), indexOf, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-10132123), indexOf, length, 17);
        this.tvAudioName.setText(spannableStringBuilder);
        this.tvTotalDuration.setText(DateUtils.formatDurationTime(localMedia.getDuration()));
        this.seekBar.setMax((int) localMedia.getDuration());
        setBackFastUI(false);
        this.ivPlayBack.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PreviewAudioHolder.this.slowAudioPlay();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.ivPlayFast.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                PreviewAudioHolder.this.fastAudioPlay();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i11, boolean z11) {
                if (z11) {
                    seekBar.setProgress(i11);
                    PreviewAudioHolder.this.setCurrentPlayTime(i11);
                    if (PreviewAudioHolder.this.isPlaying()) {
                        PreviewAudioHolder.this.mPlayer.seekTo(seekBar.getProgress());
                    }
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @SensorsDataInstrumented
            public void onStopTrackingTouch(SeekBar seekBar) {
                SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.ivPlayButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                try {
                    if (DoubleUtils.isFastDoubleClick()) {
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                    PreviewAudioHolder.this.mPreviewEventListener.onPreviewVideoTitle(localMedia.getFileName());
                    if (PreviewAudioHolder.this.isPlaying()) {
                        PreviewAudioHolder.this.pausePlayer();
                    } else if (PreviewAudioHolder.this.isPausePlayer) {
                        PreviewAudioHolder.this.resumePlayer();
                    } else {
                        PreviewAudioHolder.this.startPlayer(availablePath);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.mPreviewEventListener;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }

    public void findViews(View view) {
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void loadImage(LocalMedia localMedia, int i11, int i12) {
        this.tvAudioName.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.ps_ic_audio_play_cover, 0, 0);
    }

    public void onClickBackPressed() {
        this.coverImageView.setOnViewTapListener(new OnViewTapListener() {
            public void onViewTap(View view, float f11, float f12) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.mPreviewEventListener;
                if (onPreviewEventListener != null) {
                    onPreviewEventListener.onBackPressed();
                }
            }
        });
    }

    public void onLongPressDownload(final LocalMedia localMedia) {
        this.coverImageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                BasePreviewHolder.OnPreviewEventListener onPreviewEventListener = PreviewAudioHolder.this.mPreviewEventListener;
                if (onPreviewEventListener == null) {
                    return false;
                }
                onPreviewEventListener.onLongPressDownload(localMedia);
                return false;
            }
        });
    }

    public void onViewAttachedToWindow() {
        this.isPausePlayer = false;
        setMediaPlayerListener();
        playerDefaultUI(true);
    }

    public void onViewDetachedFromWindow() {
        this.isPausePlayer = false;
        this.mHandler.removeCallbacks(this.mTickerRunnable);
        setNullMediaPlayerListener();
        resetMediaPlayer();
        playerDefaultUI(true);
    }

    public void release() {
        this.mHandler.removeCallbacks(this.mTickerRunnable);
        if (this.mPlayer != null) {
            setNullMediaPlayerListener();
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }

    public void resumePausePlay() {
        if (isPlaying()) {
            pausePlayer();
        } else {
            resumePlayer();
        }
    }
}

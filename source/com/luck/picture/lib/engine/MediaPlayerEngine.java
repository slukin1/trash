package com.luck.picture.lib.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.widget.MediaPlayerView;
import java.util.concurrent.CopyOnWriteArrayList;

public class MediaPlayerEngine implements VideoPlayerEngine<MediaPlayerView> {
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<OnPlayerListener> listeners = new CopyOnWriteArrayList<>();

    public void addPlayListener(OnPlayerListener onPlayerListener) {
        if (!this.listeners.contains(onPlayerListener)) {
            this.listeners.add(onPlayerListener);
        }
    }

    public View onCreateVideoPlayer(Context context) {
        return new MediaPlayerView(context);
    }

    public void removePlayListener(OnPlayerListener onPlayerListener) {
        if (onPlayerListener != null) {
            this.listeners.remove(onPlayerListener);
        } else {
            this.listeners.clear();
        }
    }

    public void destroy(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.release();
    }

    public boolean isPlaying(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void onPause(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void onPlayerAttachedToWindow(final MediaPlayerView mediaPlayerView) {
        MediaPlayer initMediaPlayer = mediaPlayerView.initMediaPlayer();
        initMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                for (int i11 = 0; i11 < MediaPlayerEngine.this.listeners.size(); i11++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i11)).onPlayerReady();
                }
            }
        });
        initMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                for (int i11 = 0; i11 < MediaPlayerEngine.this.listeners.size(); i11++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i11)).onPlayerEnd();
                }
                mediaPlayerView.clearCanvas();
            }
        });
        initMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
                for (int i13 = 0; i13 < MediaPlayerEngine.this.listeners.size(); i13++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i13)).onPlayerError();
                }
                return false;
            }
        });
    }

    public void onPlayerDetachedFromWindow(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.release();
    }

    public void onResume(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void onStarPlayer(MediaPlayerView mediaPlayerView, LocalMedia localMedia) {
        String availablePath = localMedia.getAvailablePath();
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        mediaPlayerView.getSurfaceView().setZOrderOnTop(PictureMimeType.isHasHttp(availablePath));
        mediaPlayer.setLooping(SelectorProviders.getInstance().getSelectorConfig().isLoopAutoPlay);
        mediaPlayerView.start(availablePath);
    }
}

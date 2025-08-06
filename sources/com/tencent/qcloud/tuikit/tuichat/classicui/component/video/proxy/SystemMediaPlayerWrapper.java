package com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer;
import java.io.IOException;

public class SystemMediaPlayerWrapper implements IPlayer {
    private MediaPlayer mMediaPlayer = new MediaPlayer();

    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    public int getVideoHeight() {
        return this.mMediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.mMediaPlayer.getVideoWidth();
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public void pause() {
        this.mMediaPlayer.pause();
    }

    public void prepareAsync() {
        this.mMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mMediaPlayer.release();
    }

    public void seekTo(int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mMediaPlayer.seekTo((long) i11, 3);
        } else {
            this.mMediaPlayer.seekTo(i11);
        }
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    public void setOnCompletionListener(final IPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                onCompletionListener.onCompletion(SystemMediaPlayerWrapper.this);
            }
        });
    }

    public void setOnErrorListener(final IPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
                return onErrorListener.onError(SystemMediaPlayerWrapper.this, i11, i12);
            }
        });
    }

    public void setOnInfoListener(final IPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
                onInfoListener.onInfo(SystemMediaPlayerWrapper.this, i11, i12);
                return false;
            }
        });
    }

    public void setOnPreparedListener(final IPlayer.OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                onPreparedListener.onPrepared(SystemMediaPlayerWrapper.this);
            }
        });
    }

    public void setOnSeekCompleteListener(final IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                onSeekCompleteListener.OnSeekComplete(SystemMediaPlayerWrapper.this);
            }
        });
    }

    public void setOnVideoSizeChangedListener(final IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
                onVideoSizeChangedListener.onVideoSizeChanged(SystemMediaPlayerWrapper.this, i11, i12);
            }
        });
    }

    public void setSurface(Surface surface) {
        this.mMediaPlayer.setSurface(surface);
    }

    public void start() {
        this.mMediaPlayer.start();
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }
}

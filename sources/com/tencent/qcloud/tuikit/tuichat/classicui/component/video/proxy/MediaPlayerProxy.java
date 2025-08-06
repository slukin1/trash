package com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer;
import java.io.IOException;

public class MediaPlayerProxy implements IPlayer {
    private static final String TAG = "MediaPlayerProxy";
    private IPlayer mMediaPlayer = new SystemMediaPlayerWrapper();

    public MediaPlayerProxy() {
        String str = TAG;
        Log.i(str, "use mMediaPlayer: " + this.mMediaPlayer);
    }

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
        this.mMediaPlayer.seekTo(i11);
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        this.mMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mMediaPlayer.setDisplay(surfaceHolder);
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(onInfoListener);
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mMediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mMediaPlayer.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
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

package com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;

public interface IPlayer {

    public interface OnCompletionListener {
        void onCompletion(IPlayer iPlayer);
    }

    public interface OnErrorListener {
        boolean onError(IPlayer iPlayer, int i11, int i12);
    }

    public interface OnInfoListener {
        void onInfo(IPlayer iPlayer, int i11, int i12);
    }

    public interface OnPreparedListener {
        void onPrepared(IPlayer iPlayer);
    }

    public interface OnSeekCompleteListener {
        void OnSeekComplete(IPlayer iPlayer);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IPlayer iPlayer, int i11, int i12);
    }

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i11);

    void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException;

    void setDisplay(SurfaceHolder surfaceHolder);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setSurface(Surface surface);

    void start();

    void stop();
}

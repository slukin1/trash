package com.tencent.thumbplayer.tcmedia.adapter.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.util.Map;

public class b extends MediaPlayer {
    public void finalize() {
        try {
            super.finalize();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public int getCurrentPosition() {
        try {
            return super.getCurrentPosition();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return 0;
        }
    }

    public int getDuration() {
        try {
            return super.getDuration();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return 0;
        }
    }

    public int getSelectedTrack(int i11) {
        try {
            return super.getSelectedTrack(i11);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return 0;
        }
    }

    public MediaPlayer.TrackInfo[] getTrackInfo() {
        try {
            return super.getTrackInfo();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return new MediaPlayer.TrackInfo[0];
        }
    }

    public int getVideoHeight() {
        try {
            return super.getVideoHeight();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return 0;
        }
    }

    public int getVideoWidth() {
        try {
            return super.getVideoWidth();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
            return 0;
        }
    }

    public void prepare() {
        try {
            super.prepare();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void release() {
        try {
            if ("N1W".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909T".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "X909".equalsIgnoreCase(TPSystemInfo.getDeviceName()) || "N1T".equalsIgnoreCase(TPSystemInfo.getDeviceName())) {
                super.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                super.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                super.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                super.setOnInfoListener((MediaPlayer.OnInfoListener) null);
                super.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener) null);
                super.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener) null);
                super.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener) null);
                ((Handler) super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages((Object) null);
            }
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", e11);
        }
        try {
            super.release();
        } catch (Exception e12) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e12);
        }
    }

    public void reset() {
        try {
            super.reset();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setDataSource(Context context, Uri uri) {
        try {
            super.setDataSource(context, uri);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        try {
            super.setDataSource(context, uri, map);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        try {
            super.setDataSource(fileDescriptor);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            super.setDisplay(surfaceHolder);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setLooping(boolean z11) {
        try {
            super.setLooping(z11);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setPlaybackParams(PlaybackParams playbackParams) {
        try {
            super.setPlaybackParams(playbackParams);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setSurface(Surface surface) {
        try {
            super.setSurface(surface);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void setVolume(float f11, float f12) {
        try {
            super.setVolume(f11, f12);
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }

    public void stop() {
        try {
            super.stop();
        } catch (Exception e11) {
            TPLogUtil.e("TPThumbPlayer[TPMediaPlayer.java]", (Throwable) e11);
        }
    }
}

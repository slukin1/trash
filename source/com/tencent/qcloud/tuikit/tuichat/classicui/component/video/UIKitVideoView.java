package com.tencent.qcloud.tuikit.tuichat.classicui.component.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.video.proxy.MediaPlayerProxy;

public class UIKitVideoView extends TextureView {
    /* access modifiers changed from: private */
    public static int STATE_ERROR = -1;
    private static int STATE_IDLE = 0;
    private static int STATE_PAUSED = 4;
    /* access modifiers changed from: private */
    public static int STATE_PLAYBACK_COMPLETED = 5;
    private static int STATE_PLAYING = 3;
    /* access modifiers changed from: private */
    public static int STATE_PREPARED = 2;
    private static int STATE_PREPARING = 1;
    private static int STATE_STOPPED = 6;
    /* access modifiers changed from: private */
    public static final String TAG = UIKitVideoView.class.getSimpleName();
    private Context mContext;
    /* access modifiers changed from: private */
    public int mCurrentState = STATE_IDLE;
    private MediaPlayerProxy mMediaPlayer;
    private IPlayer.OnCompletionListener mOnCompletionListener = new IPlayer.OnCompletionListener() {
        public void onCompletion(IPlayer iPlayer) {
            Log.i(UIKitVideoView.TAG, "onCompletion");
            int unused = UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PLAYBACK_COMPLETED;
            if (UIKitVideoView.this.mOutOnCompletionListener != null) {
                UIKitVideoView.this.mOutOnCompletionListener.onCompletion(iPlayer);
            }
        }
    };
    private IPlayer.OnErrorListener mOnErrorListener = new IPlayer.OnErrorListener() {
        public boolean onError(IPlayer iPlayer, int i11, int i12) {
            String access$400 = UIKitVideoView.TAG;
            Log.w(access$400, "onError: what/extra: " + i11 + "/" + i12);
            int unused = UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_ERROR;
            UIKitVideoView.this.stop_l();
            if (UIKitVideoView.this.mOutOnErrorListener == null) {
                return true;
            }
            UIKitVideoView.this.mOutOnErrorListener.onError(iPlayer, i11, i12);
            return true;
        }
    };
    private IPlayer.OnInfoListener mOnInfoListener = new IPlayer.OnInfoListener() {
        public void onInfo(IPlayer iPlayer, int i11, int i12) {
            String access$400 = UIKitVideoView.TAG;
            Log.w(access$400, "onInfo: what/extra: " + i11 + "/" + i12);
            if (i11 == 10001) {
                int unused = UIKitVideoView.this.mVideoRotationDegree = i12;
                UIKitVideoView uIKitVideoView = UIKitVideoView.this;
                uIKitVideoView.setRotation((float) uIKitVideoView.mVideoRotationDegree);
                UIKitVideoView.this.requestLayout();
            }
        }
    };
    private IPlayer.OnPreparedListener mOnPreparedListener = new IPlayer.OnPreparedListener() {
        public void onPrepared(IPlayer iPlayer) {
            int unused = UIKitVideoView.this.mCurrentState = UIKitVideoView.STATE_PREPARED;
            int unused2 = UIKitVideoView.this.mVideoHeight = iPlayer.getVideoHeight();
            int unused3 = UIKitVideoView.this.mVideoWidth = iPlayer.getVideoWidth();
            String access$400 = UIKitVideoView.TAG;
            Log.i(access$400, "onPrepared mVideoWidth: " + UIKitVideoView.this.mVideoWidth + " mVideoHeight: " + UIKitVideoView.this.mVideoHeight + " mVideoRotationDegree: " + UIKitVideoView.this.mVideoRotationDegree);
            if (UIKitVideoView.this.mOutOnPreparedListener != null) {
                UIKitVideoView.this.mOutOnPreparedListener.onPrepared(iPlayer);
            }
        }
    };
    /* access modifiers changed from: private */
    public IPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = new IPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(IPlayer iPlayer, int i11, int i12) {
        }
    };
    /* access modifiers changed from: private */
    public IPlayer.OnCompletionListener mOutOnCompletionListener;
    /* access modifiers changed from: private */
    public IPlayer.OnErrorListener mOutOnErrorListener;
    /* access modifiers changed from: private */
    public IPlayer.OnPreparedListener mOutOnPreparedListener;
    /* access modifiers changed from: private */
    public Surface mSurface;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            Log.i(UIKitVideoView.TAG, "onSurfaceTextureAvailable");
            Surface unused = UIKitVideoView.this.mSurface = new Surface(surfaceTexture);
            UIKitVideoView.this.openVideo();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Log.i(UIKitVideoView.TAG, "onSurfaceTextureDestroyed");
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            Log.i(UIKitVideoView.TAG, "onSurfaceTextureSizeChanged");
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private Uri mUri;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoRotationDegree;
    /* access modifiers changed from: private */
    public int mVideoWidth;
    private IPlayer.OnSeekCompleteListener onSeekCompleteListener = new IPlayer.OnSeekCompleteListener() {
        public void OnSeekComplete(IPlayer iPlayer) {
            if (UIKitVideoView.this.mOnSeekCompleteListener != null) {
                UIKitVideoView.this.mOnSeekCompleteListener.OnSeekComplete(iPlayer);
            }
        }
    };

    public UIKitVideoView(Context context) {
        super(context);
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        Log.i(TAG, "initVideoView");
        this.mContext = context;
        setSurfaceTextureListener(this.mSurfaceTextureListener);
        this.mCurrentState = STATE_IDLE;
    }

    /* access modifiers changed from: private */
    public void openVideo() {
        if (this.mUri == null) {
            Log.e(TAG, "openVideo: mUri is null ");
            return;
        }
        String str = TAG;
        Log.i(str, "openVideo: mUri: " + this.mUri.getPath() + " mSurface: " + this.mSurface);
        if (this.mSurface == null) {
            Log.e(str, "openVideo: mSurface is null ");
            return;
        }
        stop_l();
        try {
            MediaPlayerProxy mediaPlayerProxy = new MediaPlayerProxy();
            this.mMediaPlayer = mediaPlayerProxy;
            mediaPlayerProxy.setOnPreparedListener(this.mOnPreparedListener);
            this.mMediaPlayer.setOnCompletionListener(this.mOnCompletionListener);
            this.mMediaPlayer.setOnErrorListener(this.mOnErrorListener);
            this.mMediaPlayer.setOnInfoListener(this.mOnInfoListener);
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mMediaPlayer.setOnSeekCompleteListener(this.mOnSeekCompleteListener);
            this.mMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setDataSource(getContext(), this.mUri);
            this.mMediaPlayer.prepareAsync();
            this.mCurrentState = STATE_PREPARING;
        } catch (Exception e11) {
            String str2 = TAG;
            Log.w(str2, "ex = " + e11.getMessage());
            this.mCurrentState = STATE_ERROR;
        }
    }

    public int getCurrentPosition() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.getDuration();
        }
        return 0;
    }

    public boolean isPlaying() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            return mediaPlayerProxy.isPlaying();
        }
        return false;
    }

    public boolean isPrepared() {
        if (this.mUri == null) {
            Log.e(TAG, "isPrepared: mUri is null ");
            return false;
        }
        String str = TAG;
        Log.i(str, "isPrepared: mUri: " + this.mUri.getPath() + " mSurface: " + this.mSurface);
        if (this.mSurface != null) {
            return true;
        }
        Log.e(str, "isPrepared: mSurface is null ");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r0 > r7) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.mVideoWidth
            int r0 = android.view.TextureView.getDefaultSize(r0, r7)
            int r1 = r6.mVideoHeight
            int r1 = android.view.TextureView.getDefaultSize(r1, r8)
            int r2 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r3 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            int r4 = r6.mVideoWidth
            if (r4 <= 0) goto L_0x006d
            int r5 = r6.mVideoHeight
            if (r5 <= 0) goto L_0x006d
            r0 = 1073741824(0x40000000, float:2.0)
            if (r2 != r0) goto L_0x003e
            if (r3 != r0) goto L_0x003e
            int r0 = r4 * r8
            int r1 = r7 * r5
            if (r0 >= r1) goto L_0x0034
            int r4 = r4 * r8
            int r0 = r4 / r5
            goto L_0x0057
        L_0x0034:
            int r0 = r4 * r8
            int r1 = r7 * r5
            if (r0 <= r1) goto L_0x0056
            int r5 = r5 * r7
            int r1 = r5 / r4
            goto L_0x004b
        L_0x003e:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r0) goto L_0x004d
            int r5 = r5 * r7
            int r0 = r5 / r4
            if (r3 != r1) goto L_0x004a
            if (r0 <= r8) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            r1 = r0
        L_0x004b:
            r0 = r7
            goto L_0x006d
        L_0x004d:
            if (r3 != r0) goto L_0x0059
            int r4 = r4 * r8
            int r0 = r4 / r5
            if (r2 != r1) goto L_0x0057
            if (r0 <= r7) goto L_0x0057
        L_0x0056:
            r0 = r7
        L_0x0057:
            r1 = r8
            goto L_0x006d
        L_0x0059:
            if (r3 != r1) goto L_0x0062
            if (r5 <= r8) goto L_0x0062
            int r0 = r8 * r4
            int r0 = r0 / r5
            r3 = r8
            goto L_0x0064
        L_0x0062:
            r0 = r4
            r3 = r5
        L_0x0064:
            if (r2 != r1) goto L_0x006c
            if (r0 <= r7) goto L_0x006c
            int r5 = r5 * r7
            int r1 = r5 / r4
            goto L_0x004b
        L_0x006c:
            r1 = r3
        L_0x006d:
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "onMeasure width: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = " height: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r5 = " rotation degree: "
            r3.append(r5)
            int r5 = r6.mVideoRotationDegree
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r2, r3)
            r6.setMeasuredDimension(r0, r1)
            int r3 = r6.mVideoRotationDegree
            int r3 = r3 + 180
            int r3 = r3 % 180
            if (r3 == 0) goto L_0x00d4
            int[] r7 = com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil.scaledSize(r7, r8, r1, r0)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "onMeasure scaled width: "
            r8.append(r3)
            r3 = 0
            r5 = r7[r3]
            r8.append(r5)
            r8.append(r4)
            r4 = 1
            r5 = r7[r4]
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r2, r8)
            r8 = r7[r3]
            float r8 = (float) r8
            float r1 = (float) r1
            float r8 = r8 / r1
            r6.setScaleX(r8)
            r7 = r7[r4]
            float r7 = (float) r7
            float r8 = (float) r0
            float r7 = r7 / r8
            r6.setScaleY(r7)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.video.UIKitVideoView.onMeasure(int, int):void");
    }

    public boolean pause() {
        String str = TAG;
        Log.i(str, "pause mCurrentState:" + this.mCurrentState);
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy == null) {
            return true;
        }
        mediaPlayerProxy.pause();
        this.mCurrentState = STATE_PAUSED;
        return true;
    }

    public void resetVideo() {
        openVideo();
    }

    public void seekTo(int i11) {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.seekTo(i11);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24 && drawable != null) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        this.mOutOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        this.mOutOnErrorListener = onErrorListener;
    }

    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        this.mOutOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener2) {
        this.mOnSeekCompleteListener = onSeekCompleteListener2;
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        openVideo();
    }

    public boolean start() {
        String str = TAG;
        Log.i(str, "start mCurrentState:" + this.mCurrentState);
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy == null) {
            return true;
        }
        mediaPlayerProxy.start();
        this.mCurrentState = STATE_PLAYING;
        return true;
    }

    public boolean stop() {
        String str = TAG;
        Log.i(str, "stop mCurrentState:" + this.mCurrentState);
        stop_l();
        return true;
    }

    public void stop_l() {
        MediaPlayerProxy mediaPlayerProxy = this.mMediaPlayer;
        if (mediaPlayerProxy != null) {
            mediaPlayerProxy.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = STATE_IDLE;
        }
    }

    public UIKitVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVideoView(context);
    }

    public UIKitVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initVideoView(context);
    }
}

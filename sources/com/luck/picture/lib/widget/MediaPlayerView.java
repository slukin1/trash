package com.luck.picture.lib.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.IOException;

public class MediaPlayerView extends FrameLayout implements SurfaceHolder.Callback {
    private MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public VideoSurfaceView surfaceView;

    public static class VideoSurfaceView extends SurfaceView {
        private int videoHeight;
        private int videoWidth;

        public VideoSurfaceView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void adjustVideoSize(int i11, int i12) {
            if (i11 != 0 && i12 != 0) {
                this.videoWidth = i11;
                this.videoHeight = i12;
                getHolder().setFixedSize(i11, i12);
                requestLayout();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
            if (r1 > r6) goto L_0x005f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMeasure(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.videoWidth
                int r0 = android.view.SurfaceView.getDefaultSize(r0, r6)
                int r1 = r5.videoHeight
                int r1 = android.view.SurfaceView.getDefaultSize(r1, r7)
                int r2 = r5.videoWidth
                if (r2 <= 0) goto L_0x007a
                int r2 = r5.videoHeight
                if (r2 <= 0) goto L_0x007a
                int r0 = android.view.View.MeasureSpec.getMode(r6)
                int r6 = android.view.View.MeasureSpec.getSize(r6)
                int r1 = android.view.View.MeasureSpec.getMode(r7)
                int r7 = android.view.View.MeasureSpec.getSize(r7)
                r2 = 1073741824(0x40000000, float:2.0)
                if (r0 != r2) goto L_0x0041
                if (r1 != r2) goto L_0x0041
                int r0 = r5.videoWidth
                int r1 = r0 * r7
                int r2 = r5.videoHeight
                int r3 = r6 * r2
                if (r1 >= r3) goto L_0x0037
                int r0 = r0 * r7
                int r0 = r0 / r2
                goto L_0x0062
            L_0x0037:
                int r1 = r0 * r7
                int r3 = r6 * r2
                if (r1 <= r3) goto L_0x005f
                int r2 = r2 * r6
                int r1 = r2 / r0
                goto L_0x0051
            L_0x0041:
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r0 != r2) goto L_0x0053
                int r0 = r5.videoHeight
                int r0 = r0 * r6
                int r2 = r5.videoWidth
                int r0 = r0 / r2
                if (r1 != r3) goto L_0x0050
                if (r0 <= r7) goto L_0x0050
                goto L_0x005f
            L_0x0050:
                r1 = r0
            L_0x0051:
                r0 = r6
                goto L_0x007a
            L_0x0053:
                if (r1 != r2) goto L_0x0064
                int r1 = r5.videoWidth
                int r1 = r1 * r7
                int r2 = r5.videoHeight
                int r1 = r1 / r2
                if (r0 != r3) goto L_0x0061
                if (r1 <= r6) goto L_0x0061
            L_0x005f:
                r0 = r6
                goto L_0x0062
            L_0x0061:
                r0 = r1
            L_0x0062:
                r1 = r7
                goto L_0x007a
            L_0x0064:
                int r2 = r5.videoWidth
                int r4 = r5.videoHeight
                if (r1 != r3) goto L_0x0070
                if (r4 <= r7) goto L_0x0070
                int r1 = r7 * r2
                int r1 = r1 / r4
                goto L_0x0072
            L_0x0070:
                r1 = r2
                r7 = r4
            L_0x0072:
                if (r0 != r3) goto L_0x0061
                if (r1 <= r6) goto L_0x0061
                int r4 = r4 * r6
                int r1 = r4 / r2
                goto L_0x0051
            L_0x007a:
                r5.setMeasuredDimension(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.MediaPlayerView.VideoSurfaceView.onMeasure(int, int):void");
        }

        public VideoSurfaceView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public VideoSurfaceView(Context context, AttributeSet attributeSet, int i11) {
            super(context, attributeSet, i11);
        }
    }

    public MediaPlayerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.surfaceView = new VideoSurfaceView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.surfaceView.setLayoutParams(layoutParams);
        addView(this.surfaceView);
        SurfaceHolder holder = this.surfaceView.getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
    }

    public void clearCanvas() {
        this.surfaceView.getHolder().setFormat(-1);
        this.surfaceView.getHolder().setFormat(-2);
    }

    public MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }

    public VideoSurfaceView getSurfaceView() {
        return this.surfaceView;
    }

    public MediaPlayer initMediaPlayer() {
        if (this.mediaPlayer == null) {
            this.mediaPlayer = new MediaPlayer();
        }
        this.mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
                MediaPlayerView.this.surfaceView.adjustVideoSize(mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
            }
        });
        return this.mediaPlayer;
    }

    public void release() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            this.mediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
            this.mediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
            this.mediaPlayer.setOnErrorListener((MediaPlayer.OnErrorListener) null);
            this.mediaPlayer = null;
        }
    }

    public void start(String str) {
        try {
            if (PictureMimeType.isContent(str)) {
                this.mediaPlayer.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.prepareAsync();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mediaPlayer.setAudioStreamType(3);
        this.mediaPlayer.setDisplay(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public MediaPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MediaPlayerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}

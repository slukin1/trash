package com.tencent.ugc.beauty.decoder;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.TextureHolderPool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.io.IOException;

public class VideoFrameReader implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DEFAULT_FRAME_PROCESS_INTERVAL = 3;
    private static final String TAG = "VideoFrameReader";
    private final Context mContext;
    private EGLCore mEGLCore;
    private volatile boolean mIsCancelled = false;
    private final boolean mIsLoop;
    private final float[] mMatrix = new float[16];
    private volatile boolean mNeedUpdateTexture = false;
    private int mOesTextureId = -1;
    private VideoFrameReaderListener mReadListener;
    private final Object mSharedGLContext;
    private long mStartTimeMs = -1;
    private SurfaceTexture mSurfaceTexture;
    private TextureHolderPool mTextureHolderPool;
    private Thread mThread;
    private Decoder mVideoDecoder;
    private int mVideoHeight = 0;
    private final String mVideoPath;
    private int mVideoWidth = 0;

    public interface VideoFrameReaderListener {
        void onFrameAvailable(PixelFrame pixelFrame);

        void onReadFinished();
    }

    public VideoFrameReader(Context context, Object obj, String str, boolean z11) {
        this.mContext = context.getApplicationContext();
        this.mVideoPath = str;
        this.mIsLoop = z11;
        this.mSharedGLContext = obj;
    }

    private void setup() throws SetupException {
        Extractor extractor;
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            eGLCore.initialize(this.mSharedGLContext, (Surface) null, 128, 128);
            this.mEGLCore.makeCurrent();
            this.mOesTextureId = OpenGlUtils.generateTextureOES();
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mOesTextureId);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mTextureHolderPool = new TextureHolderPool(1);
            RangeExtractorAdvancer rangeExtractorAdvancer = new RangeExtractorAdvancer();
            if (this.mVideoPath.startsWith("/")) {
                extractor = new Extractor(true, this.mVideoPath, (ExtractorAdvancer) rangeExtractorAdvancer);
            } else {
                try {
                    extractor = new Extractor(true, this.mContext.getAssets().openFd(this.mVideoPath), (ExtractorAdvancer) rangeExtractorAdvancer);
                } catch (IOException e11) {
                    throw new SetupException("open assets failed. " + this.mVideoPath, e11);
                }
            }
            Decoder decoder = new Decoder(extractor, this.mSurfaceTexture);
            this.mVideoDecoder = decoder;
            decoder.setLooping(this.mIsLoop);
            this.mVideoDecoder.setup();
            MediaFormat mediaFormat = extractor.getMediaFormat();
            int i11 = 0;
            if (mediaFormat.containsKey(MediaUtils.KEY_ROTATION)) {
                i11 = mediaFormat.getInteger(MediaUtils.KEY_ROTATION);
            }
            if (i11 == 90 || i11 == 270) {
                this.mVideoWidth = mediaFormat.getInteger("height");
                this.mVideoHeight = mediaFormat.getInteger("width");
            } else {
                this.mVideoWidth = mediaFormat.getInteger("width");
                this.mVideoHeight = mediaFormat.getInteger("height");
            }
            LiteavLog.i(TAG, "setup finished");
        } catch (EGLException e12) {
            throw new SetupException("EGL create failed", e12);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void threadLoop() {
        /*
            r5 = this;
            r5.setup()     // Catch:{ all -> 0x002a }
        L_0x0003:
            boolean r0 = r5.mIsCancelled     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0026
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x002a }
            r5.processFrame()     // Catch:{ all -> 0x002a }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x002a }
            long r2 = r2 - r0
            r0 = 3
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0003
            long r0 = r0 - r2
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x001e }
            goto L_0x0003
        L_0x001e:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002a }
            r0.interrupt()     // Catch:{ all -> 0x002a }
            goto L_0x0003
        L_0x0026:
            r5.release()
            return
        L_0x002a:
            r0 = move-exception
            java.lang.String r1 = "VideoFrameReader"
            java.lang.String r2 = "process failed."
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0036 }
            r5.release()
            return
        L_0x0036:
            r0 = move-exception
            r5.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.beauty.decoder.VideoFrameReader.threadLoop():void");
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mNeedUpdateTexture = true;
    }

    public void processFrame() throws ProcessException {
        TextureHolderPool.TextureHolder textureHolder;
        if (this.mStartTimeMs == -1) {
            this.mStartTimeMs = SystemClock.elapsedRealtime();
        }
        if (this.mNeedUpdateTexture) {
            this.mNeedUpdateTexture = false;
            long timestamp = this.mSurfaceTexture.getTimestamp() / 1000000;
            try {
                textureHolder = (TextureHolderPool.TextureHolder) this.mTextureHolderPool.obtain();
            } catch (InterruptedException unused) {
                textureHolder = null;
            }
            if (textureHolder != null) {
                this.mSurfaceTexture.updateTexImage();
                textureHolder.updateTexture(36197, this.mOesTextureId, this.mVideoWidth, this.mVideoHeight);
                textureHolder.setColorFormat(GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
                PixelFrame wrap = textureHolder.wrap(this.mEGLCore.getEglContext());
                wrap.setTimestamp(timestamp);
                this.mSurfaceTexture.getTransformMatrix(this.mMatrix);
                wrap.setMatrix(this.mMatrix);
                wrap.setGLContext(this.mEGLCore.getEglContext());
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTimeMs;
                if (timestamp > elapsedRealtime) {
                    try {
                        Thread.sleep(timestamp - elapsedRealtime);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                }
                VideoFrameReaderListener videoFrameReaderListener = this.mReadListener;
                if (videoFrameReaderListener != null) {
                    videoFrameReaderListener.onFrameAvailable(wrap);
                }
                textureHolder.release();
                wrap.release();
            } else {
                return;
            }
        }
        if (this.mVideoDecoder.isDone()) {
            VideoFrameReaderListener videoFrameReaderListener2 = this.mReadListener;
            if (videoFrameReaderListener2 != null) {
                LiteavLog.i(TAG, "notify read finished");
                videoFrameReaderListener2.onReadFinished();
            }
            this.mReadListener = null;
            return;
        }
        this.mVideoDecoder.processFrame();
        Frame frame = (Frame) this.mVideoDecoder.dequeueOutputBuffer();
        if (frame != null) {
            this.mVideoDecoder.enqueueOutputBuffer(frame);
        }
    }

    public void release() {
        int i11 = this.mOesTextureId;
        if (i11 != -1) {
            OpenGlUtils.deleteTexture(i11);
            this.mOesTextureId = -1;
        }
        TextureHolderPool textureHolderPool = this.mTextureHolderPool;
        if (textureHolderPool != null) {
            textureHolderPool.destroy();
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
        Decoder decoder = this.mVideoDecoder;
        if (decoder != null) {
            decoder.release();
            this.mVideoDecoder = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        LiteavLog.i(TAG, "released");
    }

    public synchronized void setVideoFrameReadListener(VideoFrameReaderListener videoFrameReaderListener) {
        this.mReadListener = videoFrameReaderListener;
    }

    public synchronized boolean start() {
        if (this.mThread != null) {
            LiteavLog.i(TAG, "already started");
            return false;
        }
        Thread thread = new Thread(a.a(this), "videoframereader");
        this.mThread = thread;
        thread.start();
        return true;
    }

    public synchronized void stop() {
        this.mIsCancelled = true;
        Thread thread = this.mThread;
        if (thread != null) {
            thread.interrupt();
            this.mThread = null;
        }
    }
}

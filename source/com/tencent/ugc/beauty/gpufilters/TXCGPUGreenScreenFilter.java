package com.tencent.ugc.beauty.gpufilters;

import android.content.Context;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.beauty.decoder.VideoFrameReader;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

public class TXCGPUGreenScreenFilter extends TXCGPUImageFilter {
    private static final String TAG = "TXCGPUGreenScreenFilter";
    private TXCGPUColorScreenFilter mColorScreenFilter;
    private final Context mContext;
    private GreenScreenFilterEventListener mEventListener = null;
    private String mGreenScreenFile;
    private boolean mLoopVideo = false;
    private boolean mMirrorX;
    /* access modifiers changed from: private */
    public final PixelFrame mPixelFrame = new PixelFrame();
    private PixelFrameRenderer mPixelFrameRenderer;
    private GLConstants.GLScaleType mScaleType;
    /* access modifiers changed from: private */
    public VideoFrameReader mVideoFrameReader;
    private VideoFrameReader.VideoFrameReaderListener mVideoFrameReaderListener = new VideoFrameReader.VideoFrameReaderListener() {
        public static /* synthetic */ void a(AnonymousClass1 r22) {
            if (TXCGPUGreenScreenFilter.this.mVideoFrameReader != null) {
                TXCGPUGreenScreenFilter.this.mPixelFrame.setTextureId(-1);
                TXCGPUGreenScreenFilter.this.destroyPlayer();
            }
        }

        public final void onFrameAvailable(PixelFrame pixelFrame) {
            if (TXCGPUGreenScreenFilter.this.mPixelFrame.getMatrix() == null) {
                TXCGPUGreenScreenFilter.this.mPixelFrame.setMatrix(new float[16]);
            }
            TXCGPUGreenScreenFilter.this.mPixelFrame.setPixelBufferType(pixelFrame.getPixelBufferType());
            TXCGPUGreenScreenFilter.this.mPixelFrame.setPixelFormatType(pixelFrame.getPixelFormatType());
            System.arraycopy(pixelFrame.getMatrix(), 0, TXCGPUGreenScreenFilter.this.mPixelFrame.getMatrix(), 0, pixelFrame.getMatrix().length);
            TXCGPUGreenScreenFilter.this.mPixelFrame.setTimestamp(pixelFrame.getTimestamp());
            TXCGPUGreenScreenFilter.this.mPixelFrame.setTextureId(pixelFrame.getTextureId());
            TXCGPUGreenScreenFilter.this.mPixelFrame.setWidth(pixelFrame.getWidth());
            TXCGPUGreenScreenFilter.this.mPixelFrame.setHeight(pixelFrame.getHeight());
        }

        public final void onReadFinished() {
            TXCGPUGreenScreenFilter.this.runOnDrawAndWaitDone(c.a(this));
        }
    };

    public interface GreenScreenFilterEventListener {
        void onLoadFailed();
    }

    public TXCGPUGreenScreenFilter(Context context) {
        this.mContext = context;
    }

    private void deleteTextureInPixelFrame() {
        if (this.mPixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
            OpenGlUtils.deleteTexture(this.mPixelFrame.getTextureId());
            this.mPixelFrame.setTextureId(-1);
        }
    }

    /* access modifiers changed from: private */
    public void destroyPlayer() {
        VideoFrameReader videoFrameReader = this.mVideoFrameReader;
        if (videoFrameReader != null) {
            videoFrameReader.setVideoFrameReadListener((VideoFrameReader.VideoFrameReaderListener) null);
            this.mVideoFrameReader.stop();
            this.mVideoFrameReader = null;
        }
    }

    private boolean initializeVideoPlayer() {
        VideoFrameReader videoFrameReader = new VideoFrameReader(this.mContext, OpenGlUtils.getCurrentContext(), this.mGreenScreenFile, this.mLoopVideo);
        this.mVideoFrameReader = videoFrameReader;
        videoFrameReader.setVideoFrameReadListener(this.mVideoFrameReaderListener);
        boolean start = this.mVideoFrameReader.start();
        if (start) {
            this.mPixelFrame.setWidth(-1);
            this.mPixelFrame.setHeight(-1);
            this.mPixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_OES);
            this.mPixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
            this.mPixelFrame.setTextureId(-1);
        }
        return start;
    }

    public static /* synthetic */ void lambda$setGreenScreenFile$0(TXCGPUGreenScreenFilter tXCGPUGreenScreenFilter, String str, boolean z11) {
        tXCGPUGreenScreenFilter.mGreenScreenFile = str;
        tXCGPUGreenScreenFilter.mLoopVideo = z11;
        tXCGPUGreenScreenFilter.loadGreenScreenFile();
    }

    private void loadGreenScreenFile() {
        boolean z11;
        String str;
        boolean z12;
        String str2 = this.mGreenScreenFile;
        if (str2 == null || str2.isEmpty()) {
            LiteavLog.e(TAG, "green file is empty!");
            return;
        }
        String fileExtension = CommonUtil.getFileExtension(this.mGreenScreenFile);
        if (fileExtension == null) {
            destroyPlayer();
            z11 = true;
        } else {
            String lowerCase = fileExtension.toLowerCase();
            if ("jpg".equals(lowerCase) || "png".equals(lowerCase) || "bmp".equals(lowerCase)) {
                destroyPlayer();
                deleteTextureInPixelFrame();
                z12 = loadPictureToTexture(this.mGreenScreenFile);
            } else if ("mp4".equals(lowerCase)) {
                destroyPlayer();
                deleteTextureInPixelFrame();
                z12 = initializeVideoPlayer();
            } else {
                z11 = false;
            }
            z11 = !z12;
        }
        if (z11 && (str = this.mGreenScreenFile) != null && !str.isEmpty()) {
            GreenScreenFilterEventListener greenScreenFilterEventListener = this.mEventListener;
            if (greenScreenFilterEventListener != null) {
                greenScreenFilterEventListener.onLoadFailed();
            }
            LiteavLog.e(TAG, "Load GreenScreenFile: %s fail, and report EVENT_GREENFILE_DECODE_FAILED", this.mGreenScreenFile);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r6 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r6 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r6.close();
        r2 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[SYNTHETIC, Splitter:B:27:0x0086] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean loadPictureToTexture(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "/"
            boolean r0 = r6.startsWith(r0)
            java.lang.String r1 = "TXCGPUGreenScreenFilter"
            r2 = 0
            if (r0 == 0) goto L_0x0010
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r6)
            goto L_0x0032
        L_0x0010:
            android.content.Context r0 = r5.mContext     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            java.io.InputStream r6 = r0.open(r6)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ IOException -> 0x0024 }
            if (r6 == 0) goto L_0x0032
        L_0x0020:
            r6.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0032
        L_0x0024:
            r0 = move-exception
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            goto L_0x0084
        L_0x0028:
            r0 = move-exception
            r6 = r2
        L_0x002a:
            java.lang.String r3 = "open file failed."
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r1, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0032
            goto L_0x0020
        L_0x0032:
            r6 = 0
            if (r2 != 0) goto L_0x0036
            return r6
        L_0x0036:
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r5.mPixelFrame
            int r3 = r2.getWidth()
            r0.setWidth(r3)
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r5.mPixelFrame
            int r3 = r2.getHeight()
            r0.setHeight(r3)
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r5.mPixelFrame
            com.tencent.ugc.videobase.base.GLConstants$PixelBufferType r3 = com.tencent.ugc.videobase.base.GLConstants.PixelBufferType.TEXTURE_2D
            r0.setPixelBufferType(r3)
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r5.mPixelFrame
            r3 = -1
            r4 = 1
            int r2 = com.tencent.ugc.videobase.utils.OpenGlUtils.loadTexture(r2, r3, r4)
            r0.setTextureId(r2)
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r5.mPixelFrame
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r2 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.RGBA
            r0.setPixelFormatType(r2)
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.tencent.ugc.videobase.frame.PixelFrame r2 = r5.mPixelFrame
            int r2 = r2.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r6] = r2
            com.tencent.ugc.videobase.frame.PixelFrame r6 = r5.mPixelFrame
            int r6 = r6.getHeight()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0[r4] = r6
            java.lang.String r6 = "picture set GreenFile %dx%d"
            com.tencent.liteav.base.util.LiteavLog.i(r1, r6, r0)
            return r4
        L_0x0082:
            r0 = move-exception
            r2 = r6
        L_0x0084:
            if (r2 == 0) goto L_0x0089
            r2.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.beauty.gpufilters.TXCGPUGreenScreenFilter.loadPictureToTexture(java.lang.String):boolean");
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i12;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (this.mPixelFrame.getTextureId() == -1) {
                super.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
                return;
            }
            GLTexturePool gLTexturePool = this.mTexturePool;
            Size size = this.mOutputSize;
            GLTexture obtain = gLTexturePool.obtain(size.width, size.height);
            if (this.mPixelFrameRenderer == null) {
                Size size2 = this.mOutputSize;
                this.mPixelFrameRenderer = new PixelFrameRenderer(size2.width, size2.height);
            }
            if (!this.mPixelFrame.hasTransformParams() && this.mPixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D && this.mPixelFrame.getPixelFormatType() == GLConstants.PixelFormatType.RGBA) {
                i12 = this.mPixelFrame.getTextureId();
            } else {
                this.mPixelFrameRenderer.renderFrame(this.mPixelFrame, this.mScaleType, obtain);
                i12 = obtain.getId();
            }
            this.mColorScreenFilter.setScreenMirrorX(this.mMirrorX);
            this.mColorScreenFilter.setSecondInputTexture(i11);
            this.mColorScreenFilter.setThirdInputTexture(i12);
            this.mColorScreenFilter.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
            obtain.release();
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        TXCGPUColorScreenFilter tXCGPUColorScreenFilter = new TXCGPUColorScreenFilter();
        this.mColorScreenFilter = tXCGPUColorScreenFilter;
        tXCGPUColorScreenFilter.initialize(gLTexturePool);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        this.mColorScreenFilter.onOutputSizeChanged(i11, i12);
        PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.mPixelFrameRenderer = null;
        }
    }

    public void onUninit() {
        destroyPlayer();
        TXCGPUColorScreenFilter tXCGPUColorScreenFilter = this.mColorScreenFilter;
        if (tXCGPUColorScreenFilter != null) {
            tXCGPUColorScreenFilter.uninitialize();
            this.mColorScreenFilter = null;
        }
        PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.mPixelFrameRenderer = null;
        }
        super.onUninit();
    }

    public void setEventListener(GreenScreenFilterEventListener greenScreenFilterEventListener) {
        this.mEventListener = greenScreenFilterEventListener;
    }

    public void setGreenScreenFile(String str, boolean z11) {
        runOnDraw(b.a(this, str, z11));
    }

    public void setGreenScreenParam(GLConstants.GLScaleType gLScaleType, boolean z11) {
        this.mScaleType = gLScaleType;
        this.mMirrorX = z11;
    }
}

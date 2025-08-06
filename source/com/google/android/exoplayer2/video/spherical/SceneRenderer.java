package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {
    private volatile int defaultStereoMode = 0;
    private final AtomicBoolean frameAvailable = new AtomicBoolean();
    private final FrameRotationQueue frameRotationQueue = new FrameRotationQueue();
    private byte[] lastProjectionData;
    private int lastStereoMode = -1;
    private final TimedValueQueue<Projection> projectionQueue = new TimedValueQueue<>();
    private final ProjectionRenderer projectionRenderer = new ProjectionRenderer();
    private final AtomicBoolean resetRotationAtNextFrame = new AtomicBoolean(true);
    private final float[] rotationMatrix = new float[16];
    private final TimedValueQueue<Long> sampleTimestampQueue = new TimedValueQueue<>();
    private SurfaceTexture surfaceTexture;
    private final float[] tempMatrix = new float[16];
    private int textureId;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(SurfaceTexture surfaceTexture2) {
        this.frameAvailable.set(true);
    }

    private void setProjection(byte[] bArr, int i11, long j11) {
        byte[] bArr2 = this.lastProjectionData;
        int i12 = this.lastStereoMode;
        this.lastProjectionData = bArr;
        if (i11 == -1) {
            i11 = this.defaultStereoMode;
        }
        this.lastStereoMode = i11;
        if (i12 != i11 || !Arrays.equals(bArr2, this.lastProjectionData)) {
            Projection projection = null;
            byte[] bArr3 = this.lastProjectionData;
            if (bArr3 != null) {
                projection = ProjectionDecoder.decode(bArr3, this.lastStereoMode);
            }
            if (projection == null || !ProjectionRenderer.isSupported(projection)) {
                projection = Projection.createEquirectangular(this.lastStereoMode);
            }
            this.projectionQueue.add(j11, projection);
        }
    }

    public void drawFrame(float[] fArr, boolean z11) {
        GLES20.glClear(16384);
        GlUtil.checkGlError();
        if (this.frameAvailable.compareAndSet(true, false)) {
            ((SurfaceTexture) Assertions.checkNotNull(this.surfaceTexture)).updateTexImage();
            GlUtil.checkGlError();
            if (this.resetRotationAtNextFrame.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.rotationMatrix, 0);
            }
            long timestamp = this.surfaceTexture.getTimestamp();
            Long poll = this.sampleTimestampQueue.poll(timestamp);
            if (poll != null) {
                this.frameRotationQueue.pollRotationMatrix(this.rotationMatrix, poll.longValue());
            }
            Projection pollFloor = this.projectionQueue.pollFloor(timestamp);
            if (pollFloor != null) {
                this.projectionRenderer.setProjection(pollFloor);
            }
        }
        Matrix.multiplyMM(this.tempMatrix, 0, fArr, 0, this.rotationMatrix, 0);
        this.projectionRenderer.draw(this.textureId, this.tempMatrix, z11);
    }

    public SurfaceTexture init() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.checkGlError();
        this.projectionRenderer.init();
        GlUtil.checkGlError();
        this.textureId = GlUtil.createExternalTexture();
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.textureId);
        this.surfaceTexture = surfaceTexture2;
        surfaceTexture2.setOnFrameAvailableListener(new a(this));
        return this.surfaceTexture;
    }

    public void onCameraMotion(long j11, float[] fArr) {
        this.frameRotationQueue.setRotation(j11, fArr);
    }

    public void onCameraMotionReset() {
        this.sampleTimestampQueue.clear();
        this.frameRotationQueue.reset();
        this.resetRotationAtNextFrame.set(true);
    }

    public void onVideoFrameAboutToBeRendered(long j11, long j12, Format format, MediaFormat mediaFormat) {
        this.sampleTimestampQueue.add(j12, Long.valueOf(j11));
        setProjection(format.projectionData, format.stereoMode, j12);
    }

    public void setDefaultStereoMode(int i11) {
        this.defaultStereoMode = i11;
    }

    public void shutdown() {
        this.projectionRenderer.shutdown();
    }
}

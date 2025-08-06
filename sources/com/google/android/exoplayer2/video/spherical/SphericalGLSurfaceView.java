package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.OrientationListener;
import com.google.android.exoplayer2.video.spherical.TouchTracker;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {
    private static final int FIELD_OF_VIEW_DEGREES = 90;
    private static final float PX_PER_DEGREES = 25.0f;
    public static final float UPRIGHT_ROLL = 3.1415927f;
    private static final float Z_FAR = 100.0f;
    private static final float Z_NEAR = 0.1f;
    private boolean isOrientationListenerRegistered;
    private boolean isStarted;
    private final Handler mainHandler;
    private final OrientationListener orientationListener;
    private final Sensor orientationSensor;
    private final SceneRenderer scene;
    private final SensorManager sensorManager;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TouchTracker touchTracker;
    private boolean useSensorRotation;
    private final CopyOnWriteArrayList<VideoSurfaceListener> videoSurfaceListeners;

    public final class Renderer implements GLSurfaceView.Renderer, TouchTracker.Listener, OrientationListener.Listener {
        private final float[] deviceOrientationMatrix;
        private float deviceRoll;
        private final float[] projectionMatrix = new float[16];
        private final SceneRenderer scene;
        private final float[] tempMatrix;
        private float touchPitch;
        private final float[] touchPitchMatrix;
        private final float[] touchYawMatrix;
        private final float[] viewMatrix;
        private final float[] viewProjectionMatrix = new float[16];

        public Renderer(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.deviceOrientationMatrix = fArr;
            float[] fArr2 = new float[16];
            this.touchPitchMatrix = fArr2;
            float[] fArr3 = new float[16];
            this.touchYawMatrix = fArr3;
            this.viewMatrix = new float[16];
            this.tempMatrix = new float[16];
            this.scene = sceneRenderer;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.deviceRoll = 3.1415927f;
        }

        private float calculateFieldOfViewInYDirection(float f11) {
            if (f11 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f11))) * 2.0d);
            }
            return 90.0f;
        }

        private void updatePitchMatrix() {
            Matrix.setRotateM(this.touchPitchMatrix, 0, -this.touchPitch, (float) Math.cos((double) this.deviceRoll), (float) Math.sin((double) this.deviceRoll), 0.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.tempMatrix, 0, this.deviceOrientationMatrix, 0, this.touchYawMatrix, 0);
                Matrix.multiplyMM(this.viewMatrix, 0, this.touchPitchMatrix, 0, this.tempMatrix, 0);
            }
            Matrix.multiplyMM(this.viewProjectionMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
            this.scene.drawFrame(this.viewProjectionMatrix, false);
        }

        public synchronized void onOrientationChange(float[] fArr, float f11) {
            float[] fArr2 = this.deviceOrientationMatrix;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.deviceRoll = -f11;
            updatePitchMatrix();
        }

        public synchronized void onScrollChange(PointF pointF) {
            this.touchPitch = pointF.y;
            updatePitchMatrix();
            Matrix.setRotateM(this.touchYawMatrix, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return SphericalGLSurfaceView.this.performClick();
        }

        public void onSurfaceChanged(GL10 gl10, int i11, int i12) {
            GLES20.glViewport(0, 0, i11, i12);
            float f11 = ((float) i11) / ((float) i12);
            Matrix.perspectiveM(this.projectionMatrix, 0, calculateFieldOfViewInYDirection(f11), f11, 0.1f, 100.0f);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.onSurfaceTextureAvailable(this.scene.init());
        }
    }

    public interface VideoSurfaceListener {
        void onVideoSurfaceCreated(Surface surface);

        void onVideoSurfaceDestroyed(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDetachedFromWindow$0() {
        Surface surface2 = this.surface;
        if (surface2 != null) {
            Iterator<VideoSurfaceListener> it2 = this.videoSurfaceListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onVideoSurfaceDestroyed(surface2);
            }
        }
        releaseSurface(this.surfaceTexture, surface2);
        this.surfaceTexture = null;
        this.surface = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceTextureAvailable$1(SurfaceTexture surfaceTexture2) {
        SurfaceTexture surfaceTexture3 = this.surfaceTexture;
        Surface surface2 = this.surface;
        Surface surface3 = new Surface(surfaceTexture2);
        this.surfaceTexture = surfaceTexture2;
        this.surface = surface3;
        Iterator<VideoSurfaceListener> it2 = this.videoSurfaceListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onVideoSurfaceCreated(surface3);
        }
        releaseSurface(surfaceTexture3, surface2);
    }

    /* access modifiers changed from: private */
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2) {
        this.mainHandler.post(new c(this, surfaceTexture2));
    }

    private static void releaseSurface(SurfaceTexture surfaceTexture2, Surface surface2) {
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface2 != null) {
            surface2.release();
        }
    }

    private void updateOrientationListenerRegistration() {
        boolean z11 = this.useSensorRotation && this.isStarted;
        Sensor sensor = this.orientationSensor;
        if (sensor != null && z11 != this.isOrientationListenerRegistered) {
            if (z11) {
                this.sensorManager.registerListener(this.orientationListener, sensor, 0);
            } else {
                this.sensorManager.unregisterListener(this.orientationListener);
            }
            this.isOrientationListenerRegistered = z11;
        }
    }

    public void addVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.videoSurfaceListeners.add(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.scene;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.scene;
    }

    public Surface getVideoSurface() {
        return this.surface;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mainHandler.post(new b(this));
    }

    public void onPause() {
        this.isStarted = false;
        updateOrientationListenerRegistration();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.isStarted = true;
        updateOrientationListenerRegistration();
    }

    public void removeVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.videoSurfaceListeners.remove(videoSurfaceListener);
    }

    public void setDefaultStereoMode(int i11) {
        this.scene.setDefaultStereoMode(i11);
    }

    public void setUseSensorRotation(boolean z11) {
        this.useSensorRotation = z11;
        updateOrientationListenerRegistration();
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoSurfaceListeners = new CopyOnWriteArrayList<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        SensorManager sensorManager2 = (SensorManager) Assertions.checkNotNull(context.getSystemService("sensor"));
        this.sensorManager = sensorManager2;
        Sensor defaultSensor = Util.SDK_INT >= 18 ? sensorManager2.getDefaultSensor(15) : null;
        this.orientationSensor = defaultSensor == null ? sensorManager2.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.scene = sceneRenderer;
        Renderer renderer = new Renderer(sceneRenderer);
        TouchTracker touchTracker2 = new TouchTracker(context, renderer, PX_PER_DEGREES);
        this.touchTracker = touchTracker2;
        this.orientationListener = new OrientationListener(((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), touchTracker2, renderer);
        this.useSensorRotation = true;
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setOnTouchListener(touchTracker2);
    }
}

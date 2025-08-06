package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.widget.ImageView;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.util.AngleUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CameraParamUtil;
import com.tencent.qcloud.tuikit.tuichat.util.CheckPermission;
import com.tencent.qcloud.tuikit.tuichat.util.DeviceUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.rtmp.TXLivePushConfig;
import com.youth.banner.config.BannerConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CameraInterface implements Camera.PreviewCallback {
    private static final String TAG = CameraInterface.class.getSimpleName();
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    private static volatile CameraInterface mCameraInterface;
    /* access modifiers changed from: private */
    public int CAMERA_FRONT_POSITION = -1;
    /* access modifiers changed from: private */
    public int CAMERA_POST_POSITION = -1;
    /* access modifiers changed from: private */
    public int SELECTED_CAMERA = -1;
    /* access modifiers changed from: private */
    public int angle = 0;
    private int cameraAngle = 90;
    private ErrorListener errorLisenter;
    private byte[] firstFrame_data;
    public int handlerTime = 0;
    private boolean isPreviewing = false;
    private boolean isRecorder = false;
    private Camera mCamera;
    private ImageView mFlashLamp;
    private SurfaceHolder mHolder = null;
    private Camera.Parameters mParams;
    private ImageView mSwitchView;
    private int mediaQuality = JCameraView.MEDIA_QUALITY_MIDDLE;
    private MediaRecorder mediaRecorder;
    /* access modifiers changed from: private */
    public int nowAngle;
    private int nowScaleRate = 0;
    private int preview_height;
    private int preview_width;
    private int recordScleRate = 0;
    private int rotation = 0;
    private String saveVideoPath = TUIConfig.getMediaDir();
    private float screenProp = -1.0f;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i11) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 == sensorEvent.sensor.getType()) {
                float[] fArr = sensorEvent.values;
                int unused = CameraInterface.this.angle = AngleUtil.getSensorAngle(fArr[0], fArr[1]);
                CameraInterface.this.rotationAnimation();
            }
        }
    };

    /* renamed from: sm  reason: collision with root package name */
    private SensorManager f48587sm = null;
    private String videoFileAbsPath;
    private String videoFileName;
    private Bitmap videoFirstFrame = null;

    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    public interface ErrorCallback {
        void onError();
    }

    public interface FocusCallback {
        void focusSuccess();
    }

    public interface StopRecordCallback {
        void recordResult(String str, Bitmap bitmap);
    }

    public interface TakePictureCallback {
        void captureResult(Bitmap bitmap, boolean z11);
    }

    private CameraInterface() {
        findAvailableCameras();
        this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
    }

    private static Rect calculateTapArea(float f11, float f12, float f13, Context context) {
        int intValue = Float.valueOf(f13 * 300.0f).intValue();
        int i11 = intValue / 2;
        int clamp = clamp(((int) (((f11 / ((float) ScreenUtil.getScreenWidth(context))) * 2000.0f) - 1000.0f)) - i11, -1000, 1000);
        int clamp2 = clamp(((int) (((f12 / ((float) ScreenUtil.getScreenHeight(context))) * 2000.0f) - 1000.0f)) - i11, -1000, 1000);
        RectF rectF = new RectF((float) clamp, (float) clamp2, (float) (clamp + intValue), (float) (clamp2 + intValue));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i11, int i12, int i13) {
        return i11 > i13 ? i13 : i11 < i12 ? i12 : i11;
    }

    public static void destroyCameraInterface() {
        if (mCameraInterface != null) {
            mCameraInterface.doDestroyCamera();
            mCameraInterface = null;
        }
    }

    private void findAvailableCameras() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i11 = 0; i11 < numberOfCameras; i11++) {
            Camera.getCameraInfo(i11, cameraInfo);
            int i12 = cameraInfo.facing;
            if (i12 == 0) {
                this.CAMERA_POST_POSITION = i12;
            } else if (i12 == 1) {
                this.CAMERA_FRONT_POSITION = i12;
            }
        }
    }

    public static synchronized CameraInterface getInstance() {
        CameraInterface cameraInterface;
        synchronized (CameraInterface.class) {
            if (mCameraInterface == null) {
                synchronized (CameraInterface.class) {
                    if (mCameraInterface == null) {
                        mCameraInterface = new CameraInterface();
                    }
                }
            }
            cameraInterface = mCameraInterface;
        }
        return cameraInterface;
    }

    private synchronized void openCamera(int i11) {
        Camera camera;
        try {
            this.mCamera = Camera.open(i11);
        } catch (Exception e11) {
            e11.printStackTrace();
            ErrorListener errorListener = this.errorLisenter;
            if (errorListener != null) {
                errorListener.onError();
            }
        }
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e12) {
                e12.printStackTrace();
                TUIChatLog.e(TAG, "enable shutter sound faild");
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    public void rotationAnimation() {
        int i11;
        int i12;
        ImageView imageView = this.mSwitchView;
        if (imageView != null && (i11 = this.rotation) != (i12 = this.angle)) {
            int i13 = -90;
            int i14 = 270;
            int i15 = 180;
            if (i11 != 0) {
                if (i11 != 90) {
                    if (i11 == 180) {
                        if (i12 != 90) {
                            i14 = i12 != 270 ? 0 : 90;
                        }
                        i13 = 180;
                        i15 = i14;
                    } else if (i11 != 270) {
                        i13 = 0;
                        i15 = 0;
                    } else if (i12 == 0 || i12 != 180) {
                        i13 = 90;
                    } else {
                        i13 = 90;
                    }
                } else if (i12 != 0 && i12 == 180) {
                    i15 = -180;
                }
                i15 = 0;
            } else {
                if (i12 != 90) {
                    i13 = i12 != 270 ? 0 : 90;
                }
                i15 = i13;
                i13 = 0;
            }
            float f11 = (float) i13;
            float f12 = (float) i15;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{f11, f12});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFlashLamp, "rotation", new float[]{f11, f12});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.setDuration(500);
            animatorSet.start();
            this.rotation = this.angle;
        }
    }

    private void setFlashModel() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        this.mParams = parameters;
        parameters.setFlashMode("torch");
        this.mCamera.setParameters(this.mParams);
    }

    public void doDestroyCamera() {
        this.errorLisenter = null;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mSwitchView = null;
                this.mFlashLamp = null;
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay((SurfaceHolder) null);
                this.mHolder = null;
                this.isPreviewing = false;
                this.mCamera.release();
                this.mCamera = null;
                TUIChatLog.i(TAG, "=== Destroy Camera ===");
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } else {
            TUIChatLog.i(TAG, "=== Camera  Null===");
        }
    }

    public void doOpenCamera(CameraOpenOverCallback cameraOpenOverCallback) {
        ErrorListener errorListener;
        if (Build.VERSION.SDK_INT >= 23 || CheckPermission.isCameraUseable(this.SELECTED_CAMERA) || (errorListener = this.errorLisenter) == null) {
            if (this.mCamera == null) {
                openCamera(this.SELECTED_CAMERA);
            }
            cameraOpenOverCallback.cameraHasOpened();
            return;
        }
        errorListener.onError();
    }

    public void doStartPreview(SurfaceHolder surfaceHolder, float f11) {
        if (this.isPreviewing) {
            TUIChatLog.i(TAG, "doStartPreview isPreviewing");
        }
        if (this.screenProp < 0.0f) {
            this.screenProp = f11;
        }
        if (surfaceHolder != null) {
            this.mHolder = surfaceHolder;
            if (this.mCamera != null) {
                try {
                    if (DeviceUtil.isVivoX21()) {
                        Camera camera = this.mCamera;
                        if (camera != null) {
                            camera.release();
                            this.mCamera = null;
                        }
                        openCamera(this.SELECTED_CAMERA);
                    }
                    this.mParams = this.mCamera.getParameters();
                    Camera.Size previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 1000, f11);
                    Camera.Size pictureSize = CameraParamUtil.getInstance().getPictureSize(this.mParams.getSupportedPictureSizes(), 1200, f11);
                    this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                    this.preview_width = previewSize.width;
                    this.preview_height = previewSize.height;
                    this.mParams.setPictureSize(pictureSize.width, pictureSize.height);
                    if (CameraParamUtil.getInstance().isSupportedFocusMode(this.mParams.getSupportedFocusModes(), TtmlNode.TEXT_EMPHASIS_AUTO)) {
                        this.mParams.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
                    }
                    if (CameraParamUtil.getInstance().isSupportedPictureFormats(this.mParams.getSupportedPictureFormats(), 256)) {
                        this.mParams.setPictureFormat(256);
                        this.mParams.setJpegQuality(100);
                    }
                    this.mCamera.setParameters(this.mParams);
                    this.mParams = this.mCamera.getParameters();
                    this.mCamera.setPreviewDisplay(surfaceHolder);
                    this.mCamera.setDisplayOrientation(this.cameraAngle);
                    this.mCamera.setPreviewCallback(this);
                    this.mCamera.startPreview();
                    this.isPreviewing = true;
                    TUIChatLog.i(TAG, "=== Start Preview ===");
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public void doStopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback((Camera.PreviewCallback) null);
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay((SurfaceHolder) null);
                this.isPreviewing = false;
                TUIChatLog.i(TAG, "=== Stop Preview ===");
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void handleFocus(Context context, float f11, float f12, FocusCallback focusCallback) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            Rect calculateTapArea = calculateTapArea(f11, f12, 1.0f, context);
            this.mCamera.cancelAutoFocus();
            if (parameters.getMaxNumFocusAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(calculateTapArea, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE));
                parameters.setFocusAreas(arrayList);
                final String focusMode = parameters.getFocusMode();
                try {
                    parameters.setFocusMode(TtmlNode.TEXT_EMPHASIS_AUTO);
                    this.mCamera.setParameters(parameters);
                    final FocusCallback focusCallback2 = focusCallback;
                    final Context context2 = context;
                    final float f13 = f11;
                    final float f14 = f12;
                    this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
                            r4 = r3.this$0;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void onAutoFocus(boolean r4, android.hardware.Camera r5) {
                            /*
                                r3 = this;
                                if (r4 != 0) goto L_0x001b
                                com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface r4 = com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface.this
                                int r0 = r4.handlerTime
                                r1 = 10
                                if (r0 <= r1) goto L_0x000b
                                goto L_0x001b
                            L_0x000b:
                                int r0 = r0 + 1
                                r4.handlerTime = r0
                                android.content.Context r5 = r4
                                float r0 = r5
                                float r1 = r6
                                com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface$FocusCallback r2 = r3
                                r4.handleFocus(r5, r0, r1, r2)
                                goto L_0x0031
                            L_0x001b:
                                android.hardware.Camera$Parameters r4 = r5.getParameters()
                                java.lang.String r0 = r2
                                r4.setFocusMode(r0)
                                r5.setParameters(r4)
                                com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface r4 = com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface.this
                                r5 = 0
                                r4.handlerTime = r5
                                com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface$FocusCallback r4 = r3
                                r4.focusSuccess()
                            L_0x0031:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface.AnonymousClass3.onAutoFocus(boolean, android.hardware.Camera):void");
                        }
                    });
                } catch (Exception unused) {
                    TUIChatLog.e(TAG, "autoFocus failer");
                }
            } else {
                TUIChatLog.i(TAG, "focus areas not supported");
                focusCallback.focusSuccess();
            }
        }
    }

    public void isPreview(boolean z11) {
        this.isPreviewing = z11;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.firstFrame_data = bArr;
    }

    public void registerSensorManager(Context context) {
        if (this.f48587sm == null) {
            this.f48587sm = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.f48587sm;
        sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 3);
    }

    public void setErrorLinsenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
    }

    public void setFlashMode(String str) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(str);
            this.mCamera.setParameters(parameters);
        }
    }

    public void setMediaQuality(int i11) {
        this.mediaQuality = i11;
    }

    public void setSwitchView(ImageView imageView, ImageView imageView2) {
        this.mSwitchView = imageView;
        this.mFlashLamp = imageView2;
        if (imageView != null) {
            this.cameraAngle = CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.SELECTED_CAMERA);
        }
    }

    public void setZoom(float f11, int i11) {
        int i12;
        Camera camera = this.mCamera;
        if (camera != null) {
            if (this.mParams == null) {
                this.mParams = camera.getParameters();
            }
            if (this.mParams.isZoomSupported() && this.mParams.isSmoothZoomSupported()) {
                if (i11 != 144) {
                    if (i11 == 145 && !this.isRecorder) {
                        int i13 = (int) (f11 / 50.0f);
                        if (i13 < this.mParams.getMaxZoom()) {
                            int i14 = this.nowScaleRate + i13;
                            this.nowScaleRate = i14;
                            if (i14 < 0) {
                                this.nowScaleRate = 0;
                            } else if (i14 > this.mParams.getMaxZoom()) {
                                this.nowScaleRate = this.mParams.getMaxZoom();
                            }
                            this.mParams.setZoom(this.nowScaleRate);
                            this.mCamera.setParameters(this.mParams);
                        }
                        String str = TAG;
                        TUIChatLog.i(str, "setZoom = " + this.nowScaleRate);
                    }
                } else if (this.isRecorder && f11 >= 0.0f && (i12 = (int) (f11 / 40.0f)) <= this.mParams.getMaxZoom() && i12 >= this.nowScaleRate && this.recordScleRate != i12) {
                    this.mParams.setZoom(i12);
                    this.mCamera.setParameters(this.mParams);
                    this.recordScleRate = i12;
                }
            }
        }
    }

    public void startRecord(Surface surface, float f11, ErrorCallback errorCallback) {
        Camera.Size size;
        this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
        int i11 = (this.angle + 90) % 360;
        Camera.Parameters parameters = this.mCamera.getParameters();
        int i12 = parameters.getPreviewSize().width;
        int i13 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(this.firstFrame_data, parameters.getPreviewFormat(), i12, i13, (int[]) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i12, i13), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.videoFirstFrame = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        int i14 = this.SELECTED_CAMERA;
        if (i14 == this.CAMERA_POST_POSITION) {
            matrix.setRotate((float) i11);
        } else if (i14 == this.CAMERA_FRONT_POSITION) {
            matrix.setRotate(270.0f);
        }
        Bitmap bitmap = this.videoFirstFrame;
        this.videoFirstFrame = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.videoFirstFrame.getHeight(), matrix, true);
        if (!this.isRecorder) {
            if (this.mCamera == null) {
                openCamera(this.SELECTED_CAMERA);
            }
            if (this.mediaRecorder == null) {
                this.mediaRecorder = new MediaRecorder();
            }
            if (this.mParams == null) {
                this.mParams = this.mCamera.getParameters();
            }
            if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
                this.mParams.setFocusMode("continuous-video");
            }
            this.mCamera.setParameters(this.mParams);
            this.mCamera.unlock();
            this.mediaRecorder.reset();
            if (DeviceUtil.isVivoX21()) {
                this.mCamera.release();
                this.mCamera = null;
                openCamera(this.SELECTED_CAMERA);
                this.mCamera.setDisplayOrientation(90);
                this.mCamera.unlock();
            }
            this.mediaRecorder.setCamera(this.mCamera);
            this.mediaRecorder.setVideoSource(1);
            this.mediaRecorder.setAudioSource(1);
            this.mediaRecorder.setOutputFormat(2);
            this.mediaRecorder.setVideoEncoder(2);
            this.mediaRecorder.setAudioEncoder(3);
            if (this.mParams.getSupportedVideoSizes() == null) {
                size = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), BannerConfig.SCROLL_TIME, f11);
            } else {
                size = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedVideoSizes(), BannerConfig.SCROLL_TIME, f11);
            }
            String str = TAG;
            TUIChatLog.i(str, "setVideoSize    width = " + size.width + "height = " + size.height);
            int i15 = size.width;
            int i16 = size.height;
            if (i15 == i16) {
                this.mediaRecorder.setVideoSize(this.preview_width, this.preview_height);
            } else {
                this.mediaRecorder.setVideoSize(i15, i16);
            }
            if (this.SELECTED_CAMERA != this.CAMERA_FRONT_POSITION) {
                this.mediaRecorder.setOrientationHint(i11);
            } else if (this.cameraAngle == 270) {
                if (i11 == 0) {
                    this.mediaRecorder.setOrientationHint(180);
                } else if (i11 == 270) {
                    this.mediaRecorder.setOrientationHint(270);
                } else {
                    this.mediaRecorder.setOrientationHint(90);
                }
            } else if (i11 == 90) {
                this.mediaRecorder.setOrientationHint(270);
            } else if (i11 == 270) {
                this.mediaRecorder.setOrientationHint(90);
            } else {
                this.mediaRecorder.setOrientationHint(i11);
            }
            if (DeviceUtil.isHuaWeiOrHonor()) {
                this.mediaRecorder.setVideoEncodingBitRate(JCameraView.MEDIA_QUALITY_FUNNY);
            } else {
                this.mediaRecorder.setVideoEncodingBitRate(this.mediaQuality);
            }
            this.mediaRecorder.setPreviewDisplay(surface);
            this.videoFileName = "video_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + PictureMimeType.MP4;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.saveVideoPath);
            sb2.append(this.videoFileName);
            String sb3 = sb2.toString();
            this.videoFileAbsPath = sb3;
            this.mediaRecorder.setOutputFile(sb3);
            try {
                this.mediaRecorder.prepare();
                this.mediaRecorder.start();
                this.isRecorder = true;
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
                TUIChatLog.i(TAG, "startRecord IllegalStateException");
                ErrorListener errorListener = this.errorLisenter;
                if (errorListener != null) {
                    errorListener.onError();
                }
            } catch (IOException e12) {
                e12.printStackTrace();
                TUIChatLog.i(TAG, "startRecord IOException");
                ErrorListener errorListener2 = this.errorLisenter;
                if (errorListener2 != null) {
                    errorListener2.onError();
                }
            } catch (RuntimeException unused) {
                TUIChatLog.i(TAG, "startRecord RuntimeException");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r2 != null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopRecord(boolean r4, com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface.StopRecordCallback r5) {
        /*
            r3 = this;
            boolean r0 = r3.isRecorder
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.media.MediaRecorder r0 = r3.mediaRecorder
            if (r0 == 0) goto L_0x006f
            r1 = 0
            r0.setOnErrorListener(r1)
            android.media.MediaRecorder r0 = r3.mediaRecorder
            r0.setOnInfoListener(r1)
            android.media.MediaRecorder r0 = r3.mediaRecorder
            r0.setPreviewDisplay(r1)
            r0 = 0
            android.media.MediaRecorder r2 = r3.mediaRecorder     // Catch:{ RuntimeException -> 0x002b }
            r2.stop()     // Catch:{ RuntimeException -> 0x002b }
            android.media.MediaRecorder r2 = r3.mediaRecorder
            if (r2 == 0) goto L_0x0024
        L_0x0021:
            r2.release()
        L_0x0024:
            r3.mediaRecorder = r1
            r3.isRecorder = r0
            goto L_0x0039
        L_0x0029:
            r4 = move-exception
            goto L_0x0063
        L_0x002b:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x0029 }
            r3.mediaRecorder = r1     // Catch:{ all -> 0x0029 }
            android.media.MediaRecorder r2 = new android.media.MediaRecorder     // Catch:{ all -> 0x0029 }
            r2.<init>()     // Catch:{ all -> 0x0029 }
            r3.mediaRecorder = r2     // Catch:{ all -> 0x0029 }
            goto L_0x0021
        L_0x0039:
            if (r4 == 0) goto L_0x0047
            java.lang.String r4 = r3.videoFileAbsPath
            boolean r4 = com.tencent.qcloud.tuikit.timcommon.util.FileUtil.deleteFile(r4)
            if (r4 == 0) goto L_0x0046
            r5.recordResult(r1, r1)
        L_0x0046:
            return
        L_0x0047:
            r3.doStopPreview()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = r3.saveVideoPath
            r4.append(r0)
            java.lang.String r0 = r3.videoFileName
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            android.graphics.Bitmap r0 = r3.videoFirstFrame
            r5.recordResult(r4, r0)
            goto L_0x006f
        L_0x0063:
            android.media.MediaRecorder r5 = r3.mediaRecorder
            if (r5 == 0) goto L_0x006a
            r5.release()
        L_0x006a:
            r3.mediaRecorder = r1
            r3.isRecorder = r0
            throw r4
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface.stopRecord(boolean, com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface$StopRecordCallback):void");
    }

    public synchronized void switchCamera(SurfaceHolder surfaceHolder, float f11) {
        Camera camera;
        int i11 = this.SELECTED_CAMERA;
        int i12 = this.CAMERA_POST_POSITION;
        if (i11 == i12) {
            this.SELECTED_CAMERA = this.CAMERA_FRONT_POSITION;
        } else {
            this.SELECTED_CAMERA = i12;
        }
        doDestroyCamera();
        TUIChatLog.i(TAG, "open start");
        openCamera(this.SELECTED_CAMERA);
        if (Build.VERSION.SDK_INT > 17 && (camera = this.mCamera) != null) {
            try {
                camera.enableShutterSound(false);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        TUIChatLog.i(TAG, "open end");
        doStartPreview(surfaceHolder, f11);
    }

    public void takePicture(final TakePictureCallback takePictureCallback) {
        if (this.mCamera != null) {
            int i11 = this.cameraAngle;
            if (i11 == 90) {
                this.nowAngle = Math.abs(this.angle + i11) % 360;
            } else if (i11 == 270) {
                this.nowAngle = Math.abs(i11 - this.angle);
            }
            String str = TAG;
            TUIChatLog.i(str, this.angle + " = " + this.cameraAngle + " = " + this.nowAngle);
            this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                    Matrix matrix = new Matrix();
                    if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_POST_POSITION) {
                        matrix.setRotate((float) CameraInterface.this.nowAngle);
                    } else if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_FRONT_POSITION) {
                        matrix.setRotate((float) (360 - CameraInterface.this.nowAngle));
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                    if (takePictureCallback == null) {
                        return;
                    }
                    if (CameraInterface.this.nowAngle == 90 || CameraInterface.this.nowAngle == 270) {
                        takePictureCallback.captureResult(createBitmap, true);
                    } else {
                        takePictureCallback.captureResult(createBitmap, false);
                    }
                }
            });
        }
    }

    public void unregisterSensorManager(Context context) {
        if (this.f48587sm == null) {
            this.f48587sm = (SensorManager) context.getSystemService("sensor");
        }
        this.f48587sm.unregisterListener(this.sensorEventListener);
    }
}

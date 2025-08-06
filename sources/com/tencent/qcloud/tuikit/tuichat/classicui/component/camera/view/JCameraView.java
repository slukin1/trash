package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.internal.ml.autocapture.a;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.CaptureListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.JCameraListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.TypeListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.state.CameraMachine;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.IOException;

public class JCameraView extends FrameLayout implements CameraInterface.CameraOpenOverCallback, SurfaceHolder.Callback, CameraView {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int MEDIA_QUALITY_DESPAIR = 200000;
    public static final int MEDIA_QUALITY_FUNNY = 400000;
    public static final int MEDIA_QUALITY_HIGH = 2000000;
    public static final int MEDIA_QUALITY_LOW = 1200000;
    public static final int MEDIA_QUALITY_MIDDLE = 1600000;
    public static final int MEDIA_QUALITY_POOR = 800000;
    public static final int MEDIA_QUALITY_SORRY = 80000;
    /* access modifiers changed from: private */
    public static final String TAG = JCameraView.class.getSimpleName();
    public static final int TYPE_DEFAULT = 4;
    private static final int TYPE_FLASH_AUTO = 33;
    private static final int TYPE_FLASH_OFF = 35;
    private static final int TYPE_FLASH_ON = 34;
    public static final int TYPE_PICTURE = 1;
    public static final int TYPE_SHORT = 3;
    public static final int TYPE_VIDEO = 2;
    private Bitmap captureBitmap;
    private int duration;
    /* access modifiers changed from: private */
    public ErrorListener errorLisenter;
    private Bitmap firstFrame;
    private boolean firstTouch;
    private float firstTouchLength;
    private int iconLeft;
    private int iconMargin;
    private int iconRight;
    private int iconSize;
    private int iconSrc;
    private JCameraListener jCameraLisenter;
    private int layout_width;
    /* access modifiers changed from: private */
    public ClickListener leftClickListener;
    /* access modifiers changed from: private */
    public CaptureLayout mCaptureLayout;
    private Context mContext;
    /* access modifiers changed from: private */
    public FoucsView mFoucsView;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer;
    private ImageView mPhoto;
    /* access modifiers changed from: private */
    public ImageView mSwitchCamera;
    /* access modifiers changed from: private */
    public VideoView mVideoView;
    /* access modifiers changed from: private */
    public CameraMachine machine;
    /* access modifiers changed from: private */
    public long recordTime;
    /* access modifiers changed from: private */
    public ClickListener rightClickListener;
    /* access modifiers changed from: private */
    public float screenProp;
    private int type_flash;
    private String videoUrl;
    private int zoomGradient;

    public JCameraView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initData() {
        int screenWidth = ScreenUtil.getScreenWidth(this.mContext);
        this.layout_width = screenWidth;
        this.zoomGradient = (int) (((float) screenWidth) / 16.0f);
        String str = TAG;
        TUIChatLog.i(str, "zoom = " + this.zoomGradient);
        this.machine = new CameraMachine(getContext(), this, this);
    }

    private void initView() {
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.chat_input_camera_view, this);
        this.mVideoView = (VideoView) inflate.findViewById(R.id.video_preview);
        this.mPhoto = (ImageView) inflate.findViewById(R.id.image_photo);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_switch);
        this.mSwitchCamera = imageView;
        imageView.setImageResource(this.iconSrc);
        setFlashRes();
        CaptureLayout captureLayout = (CaptureLayout) inflate.findViewById(R.id.capture_layout);
        this.mCaptureLayout = captureLayout;
        captureLayout.setDuration(this.duration);
        this.mCaptureLayout.setIconSrc(this.iconLeft, this.iconRight);
        this.mFoucsView = (FoucsView) inflate.findViewById(R.id.fouce_view);
        this.mVideoView.getHolder().addCallback(this);
        this.mSwitchCamera.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                JCameraView.this.machine.swtich(JCameraView.this.mVideoView.getHolder(), JCameraView.this.screenProp);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.mCaptureLayout.setCaptureLisenter(new CaptureListener() {
            public void recordEnd(long j11) {
                JCameraView.this.machine.stopRecord(false, j11);
                long unused = JCameraView.this.recordTime = j11;
            }

            public void recordError() {
                if (JCameraView.this.errorLisenter != null) {
                    JCameraView.this.errorLisenter.AudioPermissionError();
                }
            }

            public void recordShort(final long j11) {
                JCameraView.this.mCaptureLayout.setTextWithAnimation(ServiceInitializer.getAppContext().getString(R.string.record_time_tip));
                JCameraView.this.mSwitchCamera.setVisibility(0);
                JCameraView.this.postDelayed(new Runnable() {
                    public void run() {
                        JCameraView.this.machine.stopRecord(true, j11);
                    }
                }, a.f34923p - j11);
            }

            public void recordStart() {
                JCameraView.this.mSwitchCamera.setVisibility(4);
                JCameraView.this.machine.record(JCameraView.this.mVideoView.getHolder().getSurface(), JCameraView.this.screenProp);
            }

            public void recordZoom(float f11) {
                TUIChatLog.i(JCameraView.TAG, "recordZoom");
                JCameraView.this.machine.zoom(f11, 144);
            }

            public void takePictures() {
                JCameraView.this.mSwitchCamera.setVisibility(4);
                JCameraView.this.machine.capture();
            }
        });
        this.mCaptureLayout.setTypeLisenter(new TypeListener() {
            public void cancel() {
                JCameraView.this.machine.cancle(JCameraView.this.mVideoView.getHolder(), JCameraView.this.screenProp);
            }

            public void confirm() {
                JCameraView.this.machine.confirm();
            }
        });
        this.mCaptureLayout.setLeftClickListener(new ClickListener() {
            public void onClick() {
                if (JCameraView.this.leftClickListener != null) {
                    JCameraView.this.leftClickListener.onClick();
                }
            }
        });
        this.mCaptureLayout.setRightClickListener(new ClickListener() {
            public void onClick() {
                if (JCameraView.this.rightClickListener != null) {
                    JCameraView.this.rightClickListener.onClick();
                }
            }
        });
    }

    private void setFlashRes() {
        switch (this.type_flash) {
            case 33:
                this.machine.flash(TtmlNode.TEXT_EMPHASIS_AUTO);
                return;
            case 34:
                this.machine.flash("on");
                return;
            case 35:
                this.machine.flash("off");
                return;
            default:
                return;
        }
    }

    private void setFocusViewWidthAnimation(float f11, float f12) {
        this.machine.foucs(f11, f12, new CameraInterface.FocusCallback() {
            public void focusSuccess() {
                JCameraView.this.mFoucsView.setVisibility(4);
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateVideoViewSize(float f11, float f12) {
        if (f11 > f12) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f12 / f11) * ((float) getWidth())));
            layoutParams.gravity = 17;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    public void cameraHasOpened() {
        CameraInterface.getInstance().doStartPreview(this.mVideoView.getHolder(), this.screenProp);
    }

    public void confirmState(int i11) {
        if (i11 == 1) {
            this.mPhoto.setVisibility(4);
            JCameraListener jCameraListener = this.jCameraLisenter;
            if (jCameraListener != null) {
                jCameraListener.captureSuccess(this.captureBitmap);
            }
        } else if (i11 == 2) {
            stopVideo();
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
            JCameraListener jCameraListener2 = this.jCameraLisenter;
            if (jCameraListener2 != null) {
                jCameraListener2.recordSuccess(this.videoUrl, this.firstFrame, this.recordTime);
            }
        }
        this.mCaptureLayout.resetCaptureLayout();
    }

    public boolean handlerFoucs(float f11, float f12) {
        if (f12 > ((float) this.mCaptureLayout.getTop())) {
            return false;
        }
        this.mFoucsView.setVisibility(0);
        if (f11 < ((float) (this.mFoucsView.getWidth() / 2))) {
            f11 = (float) (this.mFoucsView.getWidth() / 2);
        }
        if (f11 > ((float) (this.layout_width - (this.mFoucsView.getWidth() / 2)))) {
            f11 = (float) (this.layout_width - (this.mFoucsView.getWidth() / 2));
        }
        if (f12 < ((float) (this.mFoucsView.getWidth() / 2))) {
            f12 = (float) (this.mFoucsView.getWidth() / 2);
        }
        if (f12 > ((float) (this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2)))) {
            f12 = (float) (this.mCaptureLayout.getTop() - (this.mFoucsView.getWidth() / 2));
        }
        FoucsView foucsView = this.mFoucsView;
        foucsView.setX(f11 - ((float) (foucsView.getWidth() / 2)));
        FoucsView foucsView2 = this.mFoucsView;
        foucsView2.setY(f12 - ((float) (foucsView2.getHeight() / 2)));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mFoucsView, "scaleX", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mFoucsView, "scaleY", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mFoucsView, "alpha", new float[]{1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.setDuration(400);
        animatorSet.start();
        return true;
    }

    public void onDestroy() {
        stopVideo();
        resetState(1);
        CameraInterface.getInstance().isPreview(false);
        CameraInterface.getInstance().unregisterSensorManager(this.mContext);
        CameraInterface.destroyCameraInterface();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        float measuredWidth = (float) this.mVideoView.getMeasuredWidth();
        float measuredHeight = (float) this.mVideoView.getMeasuredHeight();
        if (this.screenProp == 0.0f) {
            this.screenProp = measuredHeight / measuredWidth;
        }
    }

    public void onPause() {
        TUIChatLog.i(TAG, "CameraView onPause");
        this.machine.stop();
        CameraInterface.getInstance().unregisterSensorManager(this.mContext);
    }

    public void onResume() {
        TUIChatLog.i(TAG, "CameraView onResume");
        resetState(4);
        CameraInterface.getInstance().registerSensorManager(this.mContext);
        this.machine.start(this.mVideoView.getHolder(), this.screenProp);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                setFocusViewWidthAnimation(motionEvent.getX(), motionEvent.getY());
            }
            if (motionEvent.getPointerCount() == 2) {
                TUIChatLog.i(TAG, "ACTION_DOWN = 2");
            }
        } else if (action == 1) {
            this.firstTouch = true;
        } else if (action == 2) {
            if (motionEvent.getPointerCount() == 1) {
                this.firstTouch = true;
            }
            if (motionEvent.getPointerCount() == 2) {
                float x11 = motionEvent.getX(0);
                float y11 = motionEvent.getY(0);
                float sqrt = (float) Math.sqrt(Math.pow((double) (x11 - motionEvent.getX(1)), 2.0d) + Math.pow((double) (y11 - motionEvent.getY(1)), 2.0d));
                if (this.firstTouch) {
                    this.firstTouchLength = sqrt;
                    this.firstTouch = false;
                }
                float f11 = this.firstTouchLength;
                if (((int) (sqrt - f11)) / this.zoomGradient != 0) {
                    this.firstTouch = true;
                    this.machine.zoom(sqrt - f11, 145);
                }
            }
        }
        return true;
    }

    public void playVideo(Bitmap bitmap, String str) {
        this.videoUrl = str;
        this.firstFrame = bitmap;
        try {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                this.mMediaPlayer = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            this.mMediaPlayer.setDataSource(str);
            this.mMediaPlayer.setSurface(this.mVideoView.getHolder().getSurface());
            this.mMediaPlayer.setVideoScalingMode(1);
            this.mMediaPlayer.setAudioStreamType(3);
            this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
                    JCameraView jCameraView = JCameraView.this;
                    jCameraView.updateVideoViewSize((float) jCameraView.mMediaPlayer.getVideoWidth(), (float) JCameraView.this.mMediaPlayer.getVideoHeight());
                }
            });
            this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    JCameraView.this.mMediaPlayer.start();
                }
            });
            this.mMediaPlayer.setLooping(true);
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void resetState(int i11) {
        if (i11 == 1) {
            this.mPhoto.setVisibility(4);
        } else if (i11 == 2) {
            stopVideo();
            FileUtil.deleteFile(this.videoUrl);
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.machine.start(this.mVideoView.getHolder(), this.screenProp);
        } else if (i11 == 4) {
            this.mVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        this.mSwitchCamera.setVisibility(0);
        this.mCaptureLayout.resetCaptureLayout();
    }

    public void setErrorLisenter(ErrorListener errorListener) {
        this.errorLisenter = errorListener;
        CameraInterface.getInstance().setErrorLinsenter(errorListener);
    }

    public void setFeatures(int i11) {
        this.mCaptureLayout.setButtonFeatures(i11);
    }

    public void setJCameraLisenter(JCameraListener jCameraListener) {
        this.jCameraLisenter = jCameraListener;
    }

    public void setLeftClickListener(ClickListener clickListener) {
        this.leftClickListener = clickListener;
    }

    public void setMediaQuality(int i11) {
        CameraInterface.getInstance().setMediaQuality(i11);
    }

    public void setRightClickListener(ClickListener clickListener) {
        this.rightClickListener = clickListener;
    }

    public void setTip(String str) {
        this.mCaptureLayout.setTip(str);
    }

    public void showPicture(Bitmap bitmap, boolean z11) {
        if (z11) {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            this.mPhoto.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.captureBitmap = bitmap;
        this.mPhoto.setImageBitmap(bitmap);
        this.mPhoto.setVisibility(0);
        this.mCaptureLayout.startAlphaAnimation();
        this.mCaptureLayout.startTypeBtnAnimator();
    }

    public void startPreviewCallback() {
        TUIChatLog.i(TAG, "startPreviewCallback");
        handlerFoucs((float) (this.mFoucsView.getWidth() / 2), (float) (this.mFoucsView.getHeight() / 2));
    }

    public void stopVideo() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        TUIChatLog.i(TAG, "CameraView SurfaceCreated");
        new Thread() {
            public void run() {
                CameraInterface.getInstance().doOpenCamera(JCameraView.this);
            }
        }.start();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        TUIChatLog.i(TAG, "CameraView SurfaceDestroyed");
        CameraInterface.getInstance().doDestroyCamera();
    }

    public JCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JCameraView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.type_flash = 35;
        this.screenProp = 0.0f;
        this.iconSize = 0;
        this.iconMargin = 0;
        this.iconSrc = 0;
        this.iconLeft = 0;
        this.iconRight = 0;
        this.duration = 0;
        this.zoomGradient = 0;
        this.firstTouch = true;
        this.firstTouchLength = 0.0f;
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.JCameraView, i11, 0);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.JCameraView_iconSize, (int) TypedValue.applyDimension(2, 35.0f, getResources().getDisplayMetrics()));
        this.iconMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.JCameraView_iconMargin, (int) TypedValue.applyDimension(2, 15.0f, getResources().getDisplayMetrics()));
        this.iconSrc = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconSrc, R.drawable.chat_camera_switchcamera);
        this.iconLeft = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconLeft, 0);
        this.iconRight = obtainStyledAttributes.getResourceId(R.styleable.JCameraView_iconRight, 0);
        this.duration = TUIChatConfigs.getConfigs().getGeneralConfig().getVideoRecordMaxTime() * 1000;
        obtainStyledAttributes.recycle();
        initData();
        initView();
    }
}

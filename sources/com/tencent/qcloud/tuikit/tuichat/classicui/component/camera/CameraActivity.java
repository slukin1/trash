package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import com.luck.picture.lib.config.SelectMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.qcloud.tuicore.util.TUIBuild;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.ErrorListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.listener.JCameraListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.JCameraView;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class CameraActivity extends Activity {
    private static final int REQUEST_CODE_PHOTO_AND_VIDEO = 1000;
    /* access modifiers changed from: private */
    public static final String TAG = "CameraActivity";
    public static IUIKitCallback mCallBack;
    private JCameraView jCameraView;

    /* access modifiers changed from: private */
    public void startSendPhoto() {
        TUIChatLog.i(TAG, "startSendPhoto");
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{SelectMimeType.SYSTEM_IMAGE, SelectMimeType.SYSTEM_VIDEO});
        startActivityForResult(intent, 1000);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1000 && i12 == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "onCreate");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(1);
        setContentView(R.layout.activity_camera);
        this.jCameraView = (JCameraView) findViewById(R.id.jcameraview);
        int intExtra = getIntent().getIntExtra(TUIChatConstants.CAMERA_TYPE, 259);
        this.jCameraView.setFeatures(intExtra);
        if (intExtra == 257) {
            this.jCameraView.setTip(getString(R.string.tap_capture));
        } else if (intExtra == 258) {
            this.jCameraView.setTip(getString(R.string.tap_video));
        }
        this.jCameraView.setMediaQuality(JCameraView.MEDIA_QUALITY_MIDDLE);
        this.jCameraView.setErrorLisenter(new ErrorListener() {
            public void AudioPermissionError() {
                ToastUtil.toastShortMessage(CameraActivity.this.getString(R.string.audio_permission_error));
            }

            public void onError() {
                TUIChatLog.i(CameraActivity.TAG, "camera error");
                CameraActivity.this.setResult(103, new Intent());
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setJCameraLisenter(new JCameraListener() {
            public void captureSuccess(Bitmap bitmap) {
                String saveBitmap = FileUtil.saveBitmap("JCamera", bitmap);
                IUIKitCallback iUIKitCallback = CameraActivity.mCallBack;
                if (iUIKitCallback != null) {
                    iUIKitCallback.onSuccess(saveBitmap);
                }
                CameraActivity.this.finish();
            }

            public void recordSuccess(String str, Bitmap bitmap, long j11) {
                String saveBitmap = FileUtil.saveBitmap("JCamera", bitmap);
                Intent intent = new Intent();
                intent.putExtra(TUIChatConstants.IMAGE_WIDTH, bitmap.getWidth());
                intent.putExtra(TUIChatConstants.IMAGE_HEIGHT, bitmap.getHeight());
                intent.putExtra(TUIChatConstants.VIDEO_TIME, j11);
                intent.putExtra(TUIChatConstants.CAMERA_IMAGE_PATH, saveBitmap);
                intent.putExtra(TUIChatConstants.CAMERA_VIDEO_PATH, str);
                bitmap.getWidth();
                IUIKitCallback iUIKitCallback = CameraActivity.mCallBack;
                if (iUIKitCallback != null) {
                    iUIKitCallback.onSuccess(intent);
                }
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setLeftClickListener(new ClickListener() {
            public void onClick() {
                CameraActivity.this.finish();
            }
        });
        this.jCameraView.setRightClickListener(new ClickListener() {
            public void onClick() {
                CameraActivity.this.startSendPhoto();
            }
        });
        TUIChatLog.i(str, TUIBuild.getDevice());
    }

    public void onDestroy() {
        TUIChatLog.i(TAG, "onDestroy");
        super.onDestroy();
        this.jCameraView.onDestroy();
        mCallBack = null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        TUIChatLog.i(TAG, "onPause");
        super.onPause();
        this.jCameraView.onPause();
    }

    public void onResume() {
        TUIChatLog.i(TAG, "onResume");
        super.onResume();
        this.jCameraView.onResume();
    }

    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }
}

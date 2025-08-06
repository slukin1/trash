package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.state;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

class PreviewState implements State {
    public static final String TAG = "PreviewState";
    /* access modifiers changed from: private */
    public CameraMachine machine;

    public PreviewState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    public void cancle(SurfaceHolder surfaceHolder, float f11) {
        TUIChatLog.i(TAG, ServiceInitializer.getAppContext().getString(R.string.no_event_cancle_tip));
    }

    public void capture() {
        CameraInterface.getInstance().takePicture(new CameraInterface.TakePictureCallback() {
            public void captureResult(Bitmap bitmap, boolean z11) {
                PreviewState.this.machine.getView().showPicture(bitmap, z11);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowPictureState());
                TUIChatLog.i(PreviewState.TAG, OptionsBridge.CAPTURE_KEY);
            }
        });
    }

    public void confirm() {
        TUIChatLog.i(TAG, ServiceInitializer.getAppContext().getString(R.string.no_event_confirm_tip));
    }

    public void flash(String str) {
        CameraInterface.getInstance().setFlashMode(str);
    }

    public void foucs(float f11, float f12, CameraInterface.FocusCallback focusCallback) {
        TUIChatLog.i(TAG, "preview state foucs");
        if (this.machine.getView().handlerFoucs(f11, f12)) {
            CameraInterface.getInstance().handleFocus(this.machine.getContext(), f11, f12, focusCallback);
        }
    }

    public void record(Surface surface, float f11) {
        CameraInterface.getInstance().startRecord(surface, f11, (CameraInterface.ErrorCallback) null);
    }

    public void restart() {
    }

    public void start(SurfaceHolder surfaceHolder, float f11) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f11);
    }

    public void stop() {
        CameraInterface.getInstance().doStopPreview();
    }

    public void stopRecord(final boolean z11, long j11) {
        CameraInterface.getInstance().stopRecord(z11, new CameraInterface.StopRecordCallback() {
            public void recordResult(String str, Bitmap bitmap) {
                if (z11) {
                    PreviewState.this.machine.getView().resetState(3);
                    return;
                }
                PreviewState.this.machine.getView().playVideo(bitmap, str);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowVideoState());
            }
        });
    }

    public void swtich(SurfaceHolder surfaceHolder, float f11) {
        CameraInterface.getInstance().switchCamera(surfaceHolder, f11);
    }

    public void zoom(float f11, int i11) {
        TUIChatLog.i(TAG, "zoom");
        CameraInterface.getInstance().setZoom(f11, i11);
    }
}

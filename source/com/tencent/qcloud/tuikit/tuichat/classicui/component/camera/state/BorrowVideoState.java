package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class BorrowVideoState implements State {
    private static final String TAG = "BorrowVideoState";
    private CameraMachine machine;

    public BorrowVideoState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    public void cancle(SurfaceHolder surfaceHolder, float f11) {
        this.machine.getView().resetState(2);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    public void capture() {
    }

    public void confirm() {
        this.machine.getView().confirmState(2);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    public void flash(String str) {
    }

    public void foucs(float f11, float f12, CameraInterface.FocusCallback focusCallback) {
    }

    public void record(Surface surface, float f11) {
    }

    public void restart() {
    }

    public void start(SurfaceHolder surfaceHolder, float f11) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f11);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    public void stop() {
    }

    public void stopRecord(boolean z11, long j11) {
    }

    public void swtich(SurfaceHolder surfaceHolder, float f11) {
    }

    public void zoom(float f11, int i11) {
        TUIChatLog.i(TAG, "zoom");
    }
}

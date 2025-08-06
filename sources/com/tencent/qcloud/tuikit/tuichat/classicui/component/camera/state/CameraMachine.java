package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.state;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraView;

public class CameraMachine implements State {
    private State borrowPictureState = new BorrowPictureState(this);
    private State borrowVideoState = new BorrowVideoState(this);
    private Context context;
    private State previewState = new PreviewState(this);
    private State state = this.previewState;
    private CameraView view;

    public CameraMachine(Context context2, CameraView cameraView, CameraInterface.CameraOpenOverCallback cameraOpenOverCallback) {
        this.context = context2;
        this.view = cameraView;
    }

    public void cancle(SurfaceHolder surfaceHolder, float f11) {
        this.state.cancle(surfaceHolder, f11);
    }

    public void capture() {
        this.state.capture();
    }

    public void confirm() {
        this.state.confirm();
    }

    public void flash(String str) {
        this.state.flash(str);
    }

    public void foucs(float f11, float f12, CameraInterface.FocusCallback focusCallback) {
        this.state.foucs(f11, f12, focusCallback);
    }

    public State getBorrowPictureState() {
        return this.borrowPictureState;
    }

    public State getBorrowVideoState() {
        return this.borrowVideoState;
    }

    public Context getContext() {
        return this.context;
    }

    public State getPreviewState() {
        return this.previewState;
    }

    public State getState() {
        return this.state;
    }

    public CameraView getView() {
        return this.view;
    }

    public void record(Surface surface, float f11) {
        this.state.record(surface, f11);
    }

    public void restart() {
        this.state.restart();
    }

    public void setState(State state2) {
        this.state = state2;
    }

    public void start(SurfaceHolder surfaceHolder, float f11) {
        this.state.start(surfaceHolder, f11);
    }

    public void stop() {
        this.state.stop();
    }

    public void stopRecord(boolean z11, long j11) {
        this.state.stopRecord(z11, j11);
    }

    public void swtich(SurfaceHolder surfaceHolder, float f11) {
        this.state.swtich(surfaceHolder, f11);
    }

    public void zoom(float f11, int i11) {
        this.state.zoom(f11, i11);
    }
}

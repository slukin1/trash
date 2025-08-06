package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.CameraInterface;

public interface State {
    void cancle(SurfaceHolder surfaceHolder, float f11);

    void capture();

    void confirm();

    void flash(String str);

    void foucs(float f11, float f12, CameraInterface.FocusCallback focusCallback);

    void record(Surface surface, float f11);

    void restart();

    void start(SurfaceHolder surfaceHolder, float f11);

    void stop();

    void stopRecord(boolean z11, long j11);

    void swtich(SurfaceHolder surfaceHolder, float f11);

    void zoom(float f11, int i11);
}

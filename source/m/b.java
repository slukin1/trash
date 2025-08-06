package m;

import android.content.Context;
import androidx.camera.camera2.internal.w;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

public final /* synthetic */ class b implements CameraFactory.Provider {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f58084a = new b();

    public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
        return new w(context, cameraThreadConfig, cameraSelector);
    }
}

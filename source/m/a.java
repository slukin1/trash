package m;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import java.util.Set;

public final /* synthetic */ class a implements CameraDeviceSurfaceManager.Provider {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ a f58083a = new a();

    public final CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set set) {
        return Camera2Config.d(context, obj, set);
    }
}

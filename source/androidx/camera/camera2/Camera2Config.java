package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.l1;
import androidx.camera.camera2.internal.p1;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;
import m.a;
import m.b;
import m.c;

public final class Camera2Config {

    public static final class DefaultProvider implements CameraXConfig.Provider {
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.c();
        }
    }

    public static CameraXConfig c() {
        b bVar = b.f58084a;
        a aVar = a.f58083a;
        return new CameraXConfig.Builder().setCameraFactoryProvider(bVar).setDeviceSurfaceManagerProvider(aVar).setUseCaseConfigFactoryProvider(c.f58085a).build();
    }

    public static /* synthetic */ CameraDeviceSurfaceManager d(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new l1(context, obj, set);
        } catch (CameraUnavailableException e11) {
            throw new InitializationException((Throwable) e11);
        }
    }

    public static /* synthetic */ UseCaseConfigFactory e(Context context) throws InitializationException {
        return new p1(context);
    }
}

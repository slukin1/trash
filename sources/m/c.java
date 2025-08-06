package m;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

public final /* synthetic */ class c implements UseCaseConfigFactory.Provider {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f58085a = new c();

    public final UseCaseConfigFactory newInstance(Context context) {
        return Camera2Config.e(context);
    }
}

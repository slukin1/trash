package w4;

import com.fluttercandies.photo_manager.PhotoManagerPlugin;
import com.fluttercandies.photo_manager.permission.PermissionsUtils;
import io.flutter.plugin.common.PluginRegistry;

public final /* synthetic */ class a implements PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PermissionsUtils f61221b;

    public /* synthetic */ a(PermissionsUtils permissionsUtils) {
        this.f61221b = permissionsUtils;
    }

    public final boolean onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        return PhotoManagerPlugin.a.c(this.f61221b, i11, strArr, iArr);
    }
}

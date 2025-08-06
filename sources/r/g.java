package r;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16421a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f16422b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f16423c;

    public g(Quirks quirks, Quirks quirks2) {
        this.f16421a = quirks2.contains(TextureViewIsClosedQuirk.class);
        this.f16422b = quirks.contains(PreviewOrientationIncorrectQuirk.class);
        this.f16423c = quirks.contains(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }

    public void a(List<DeferrableSurface> list) {
        if (b() && list != null) {
            for (DeferrableSurface close : list) {
                close.close();
            }
            Logger.d("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }

    public boolean b() {
        return this.f16421a || this.f16422b || this.f16423c;
    }
}

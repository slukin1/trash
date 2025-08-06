package s;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.e;
import androidx.camera.core.impl.Identifier;
import java.util.List;

public final /* synthetic */ class a implements CameraFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f53423a;

    public /* synthetic */ a(String str) {
        this.f53423a = str;
    }

    public final List filter(List list) {
        return b.c(this.f53423a, list);
    }

    public /* synthetic */ Identifier getIdentifier() {
        return e.a(this);
    }
}

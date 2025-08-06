package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.ScanFragment;
import kotlin.Pair;

public final /* synthetic */ class u implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScanFragment f53296b;

    public /* synthetic */ u(ScanFragment scanFragment) {
        this.f53296b = scanFragment;
    }

    public final void onChanged(Object obj) {
        ScanFragment.scanUpdateObserver$lambda$4(this.f53296b, (Pair) obj);
    }
}

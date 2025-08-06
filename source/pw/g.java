package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.DigitalIdentityFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class g implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DigitalIdentityFragment f53282b;

    public /* synthetic */ g(DigitalIdentityFragment digitalIdentityFragment) {
        this.f53282b = digitalIdentityFragment;
    }

    public final void onChanged(Object obj) {
        DigitalIdentityFragment.scanStepObserver$lambda$2(this.f53282b, (JumioScanStep) obj);
    }
}

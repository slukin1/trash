package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.NfcScanFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class q implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NfcScanFragment f53292b;

    public /* synthetic */ q(NfcScanFragment nfcScanFragment) {
        this.f53292b = nfcScanFragment;
    }

    public final void onChanged(Object obj) {
        NfcScanFragment.scanStepObserver$lambda$4(this.f53292b, (JumioScanStep) obj);
    }
}

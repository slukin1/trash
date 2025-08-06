package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.ScanFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class s implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScanFragment f53294b;

    public /* synthetic */ s(ScanFragment scanFragment) {
        this.f53294b = scanFragment;
    }

    public final void onChanged(Object obj) {
        ScanFragment.scanStepObserver$lambda$0(this.f53294b, (JumioScanStep) obj);
    }
}

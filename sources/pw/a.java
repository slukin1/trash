package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.ConfirmationFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class a implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConfirmationFragment f53274b;

    public /* synthetic */ a(ConfirmationFragment confirmationFragment) {
        this.f53274b = confirmationFragment;
    }

    public final void onChanged(Object obj) {
        ConfirmationFragment.scanStepObserver$lambda$0(this.f53274b, (JumioScanStep) obj);
    }
}

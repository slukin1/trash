package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.FaceHelpFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class k implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FaceHelpFragment f53286b;

    public /* synthetic */ k(FaceHelpFragment faceHelpFragment) {
        this.f53286b = faceHelpFragment;
    }

    public final void onChanged(Object obj) {
        FaceHelpFragment.scanStepObserver$lambda$0(this.f53286b, (JumioScanStep) obj);
    }
}

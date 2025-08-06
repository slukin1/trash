package pw;

import androidx.lifecycle.z;
import com.jumio.defaultui.view.UploadDocumentFragment;
import com.jumio.sdk.enums.JumioScanStep;

public final /* synthetic */ class y implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UploadDocumentFragment f53301b;

    public /* synthetic */ y(UploadDocumentFragment uploadDocumentFragment) {
        this.f53301b = uploadDocumentFragment;
    }

    public final void onChanged(Object obj) {
        UploadDocumentFragment.scanStepObserver$lambda$0(this.f53301b, (JumioScanStep) obj);
    }
}

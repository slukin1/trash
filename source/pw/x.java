package pw;

import androidx.activity.result.ActivityResult;
import androidx.lifecycle.z;
import com.jumio.defaultui.view.UploadDocumentFragment;

public final /* synthetic */ class x implements z {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UploadDocumentFragment f53300b;

    public /* synthetic */ x(UploadDocumentFragment uploadDocumentFragment) {
        this.f53300b = uploadDocumentFragment;
    }

    public final void onChanged(Object obj) {
        UploadDocumentFragment.activityResultObserver$lambda$2(this.f53300b, (ActivityResult) obj);
    }
}

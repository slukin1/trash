package pw;

import android.view.View;
import com.jumio.defaultui.view.UploadDocumentFragment;
import com.jumio.sdk.views.JumioFileAttacher;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UploadDocumentFragment f53298b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JumioFileAttacher.JumioFileRequirements f53299c;

    public /* synthetic */ w(UploadDocumentFragment uploadDocumentFragment, JumioFileAttacher.JumioFileRequirements jumioFileRequirements) {
        this.f53298b = uploadDocumentFragment;
        this.f53299c = jumioFileRequirements;
    }

    public final void onClick(View view) {
        UploadDocumentFragment.createLayout$lambda$5(this.f53298b, this.f53299c, view);
    }
}

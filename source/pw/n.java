package pw;

import android.content.DialogInterface;
import com.jumio.defaultui.view.JumioDialog;

public final /* synthetic */ class n implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JumioDialog.DialogAction f53289b;

    public /* synthetic */ n(JumioDialog.DialogAction dialogAction) {
        this.f53289b = dialogAction;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        JumioDialog.create$lambda$1(this.f53289b, dialogInterface, i11);
    }
}

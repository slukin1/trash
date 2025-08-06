package pw;

import android.content.DialogInterface;
import com.jumio.defaultui.view.JumioDialog;

public final /* synthetic */ class m implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JumioDialog.DialogAction f53288b;

    public /* synthetic */ m(JumioDialog.DialogAction dialogAction) {
        this.f53288b = dialogAction;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        JumioDialog.create$lambda$0(this.f53288b, dialogInterface, i11);
    }
}

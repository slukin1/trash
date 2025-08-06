package v6;

import android.content.DialogInterface;
import com.hbg.lib.core.webview.HBBaseWebActivity;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBBaseWebActivity f60981b;

    public /* synthetic */ a(HBBaseWebActivity hBBaseWebActivity) {
        this.f60981b = hBBaseWebActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f60981b.lambda$onPermissionsDenied$10(dialogInterface, i11);
    }
}

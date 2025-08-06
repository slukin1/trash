package sr;

import android.content.DialogInterface;
import com.huobi.sharev2.helper.NewShareHelper;

public final /* synthetic */ class g implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewShareHelper f26148b;

    public /* synthetic */ g(NewShareHelper newShareHelper) {
        this.f26148b = newShareHelper;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f26148b.r(dialogInterface);
    }
}

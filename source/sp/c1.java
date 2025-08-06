package sp;

import android.content.DialogInterface;
import com.huobi.otc.ui.OtcLiteChatActivity;

public final /* synthetic */ class c1 implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26002b;

    public /* synthetic */ c1(OtcLiteChatActivity otcLiteChatActivity) {
        this.f26002b = otcLiteChatActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.f26002b.Ai(dialogInterface, i11);
    }
}

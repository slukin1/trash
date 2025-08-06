package sp;

import android.view.KeyEvent;
import android.widget.TextView;
import com.huobi.otc.ui.OtcLiteChatActivity;

public final /* synthetic */ class c2 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26003b;

    public /* synthetic */ c2(OtcLiteChatActivity otcLiteChatActivity) {
        this.f26003b = otcLiteChatActivity;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f26003b.yi(textView, i11, keyEvent);
    }
}

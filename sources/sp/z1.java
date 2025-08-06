package sp;

import android.view.View;
import com.huobi.otc.ui.OtcLiteChatActivity;

public final /* synthetic */ class z1 implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcLiteChatActivity f26117b;

    public /* synthetic */ z1(OtcLiteChatActivity otcLiteChatActivity) {
        this.f26117b = otcLiteChatActivity;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f26117b.xi(view, z11);
    }
}

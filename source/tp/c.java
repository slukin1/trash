package tp;

import android.view.View;
import com.huobi.otc.ui.fragments.CallPhoneBottomMenuFragment;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallPhoneBottomMenuFragment f37335b;

    public /* synthetic */ c(CallPhoneBottomMenuFragment callPhoneBottomMenuFragment) {
        this.f37335b = callPhoneBottomMenuFragment;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f37335b.yh(view, z11);
    }
}

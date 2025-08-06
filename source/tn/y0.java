package tn;

import android.view.View;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.view.radiogroup.RadioGroupContainer;

public final /* synthetic */ class y0 implements RadioGroupContainer.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV2 f37327a;

    public /* synthetic */ y0(UserLoginActivityV2 userLoginActivityV2) {
        this.f37327a = userLoginActivityV2;
    }

    public final void onCheckedChanged(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.f37327a.bj(radioGroupContainer, view, i11, i12);
    }
}

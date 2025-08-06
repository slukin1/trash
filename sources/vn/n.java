package vn;

import android.view.View;
import com.huobi.login.v3.ui.UserLoginActivityV3;
import com.huobi.view.radiogroup.RadioGroupContainer;

public final /* synthetic */ class n implements RadioGroupContainer.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV3 f61110a;

    public /* synthetic */ n(UserLoginActivityV3 userLoginActivityV3) {
        this.f61110a = userLoginActivityV3;
    }

    public final void onCheckedChanged(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        this.f61110a.Mh(radioGroupContainer, view, i11, i12);
    }
}

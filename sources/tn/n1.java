package tn;

import android.view.View;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.login.usercenter.data.source.bean.RegisterCheckIpData;
import com.huobi.login.v2.ui.UserRegisterActivityV2;

public final /* synthetic */ class n1 implements HBDialogFragment.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RegisterCheckIpData f37296a;

    public /* synthetic */ n1(RegisterCheckIpData registerCheckIpData) {
        this.f37296a = registerCheckIpData;
    }

    public final void a(View view, HBDialogFragment hBDialogFragment) {
        UserRegisterActivityV2.hi(this.f37296a, view, hBDialogFragment);
    }
}

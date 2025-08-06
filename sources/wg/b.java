package wg;

import android.view.View;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.huobi.account.widget.AccountInfoView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyKycInfo f61239b;

    public /* synthetic */ b(UnifyKycInfo unifyKycInfo) {
        this.f61239b = unifyKycInfo;
    }

    public final void onClick(View view) {
        AccountInfoView.G(this.f61239b, view);
    }
}

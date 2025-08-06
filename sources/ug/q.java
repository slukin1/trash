package ug;

import android.view.View;
import com.huobi.account.presenter.DominicaKycPagePresenter;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;

public final /* synthetic */ class q implements MenuItemOnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DominicaKycPagePresenter f60636b;

    public /* synthetic */ q(DominicaKycPagePresenter dominicaKycPagePresenter) {
        this.f60636b = dominicaKycPagePresenter;
    }

    public final void onClickMenuItem(View view, MenuItem menuItem, int i11) {
        this.f60636b.Z(view, menuItem, i11);
    }
}

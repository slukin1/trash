package ug;

import android.view.View;
import com.huobi.account.presenter.DominicaKycPagePresenter;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;

public final /* synthetic */ class r implements MenuItemOnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DominicaKycPagePresenter f60639b;

    public /* synthetic */ r(DominicaKycPagePresenter dominicaKycPagePresenter) {
        this.f60639b = dominicaKycPagePresenter;
    }

    public final void onClickMenuItem(View view, MenuItem menuItem, int i11) {
        this.f60639b.Y(view, menuItem, i11);
    }
}

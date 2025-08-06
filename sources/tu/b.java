package tu;

import android.view.MenuItem;
import android.view.View;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;

public final /* synthetic */ class b implements MenuItemOnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomMenuFragment f60472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuItem.OnMenuItemClickListener f60473c;

    public /* synthetic */ b(BottomMenuFragment bottomMenuFragment, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f60472b = bottomMenuFragment;
        this.f60473c = onMenuItemClickListener;
    }

    public final void onClickMenuItem(View view, com.huobi.view.bottompopfragmentmenu.MenuItem menuItem, int i11) {
        c.f(this.f60472b, this.f60473c, view, menuItem, i11);
    }
}

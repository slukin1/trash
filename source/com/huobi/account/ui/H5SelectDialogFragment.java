package com.huobi.account.ui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import com.huobi.account.entity.H5SelectWidgetData;
import com.huobi.account.entity.H5SelectWidgetDataItem;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class H5SelectDialogFragment extends BottomMenuFragment {

    /* renamed from: b  reason: collision with root package name */
    public H5SelectWidgetData f41179b;

    /* renamed from: c  reason: collision with root package name */
    public a f41180c = null;

    /* renamed from: d  reason: collision with root package name */
    public List<MenuItem> f41181d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public MenuItemOnClickListener f41182e = new u(this);

    public interface a {
        void select(int i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view, MenuItem menuItem, int i11) {
        int type = menuItem.getType();
        a aVar = this.f41180c;
        if (aVar != null) {
            aVar.select(type);
        }
        dismiss();
    }

    public static H5SelectDialogFragment d(H5SelectWidgetData h5SelectWidgetData) {
        H5SelectDialogFragment h5SelectDialogFragment = new H5SelectDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("H5_INIT_DATA", h5SelectWidgetData);
        h5SelectDialogFragment.setArguments(bundle);
        return h5SelectDialogFragment;
    }

    public void b() {
        MenuItem.MenuItemStyle menuItemStyle;
        this.f41181d.clear();
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("H5_INIT_DATA");
            if (serializable instanceof H5SelectWidgetData) {
                this.f41179b = (H5SelectWidgetData) serializable;
            }
            int i11 = -1;
            H5SelectWidgetData h5SelectWidgetData = this.f41179b;
            if (h5SelectWidgetData != null) {
                i11 = (int) h5SelectWidgetData.getDefaultId();
            }
            for (H5SelectWidgetDataItem next : this.f41179b.getList()) {
                List<MenuItem> list = this.f41181d;
                int id2 = (int) next.getId();
                String name = next.getName();
                if (((long) i11) == next.getId()) {
                    menuItemStyle = MenuItem.MenuItemStyle.STRESS;
                } else {
                    menuItemStyle = MenuItem.MenuItemStyle.COMMON;
                }
                list.add(new MenuItem(id2, "", name, menuItemStyle, this.f41182e));
            }
            setMenuItems(this.f41181d);
        }
    }

    public void e(a aVar) {
        this.f41180c = aVar;
    }

    public void show(FragmentManager fragmentManager, String str) {
        b();
        super.show(fragmentManager, str);
    }
}

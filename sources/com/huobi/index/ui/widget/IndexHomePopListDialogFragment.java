package com.huobi.index.ui.widget;

import androidx.fragment.app.FragmentManager;
import bh.j;
import com.hbg.lib.widgets.dialog.bean.HomeCommonPopListItem;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseTopRightListDialogFragment;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class IndexHomePopListDialogFragment extends BaseTopRightListDialogFragment<HomeCommonPopListItem> {

    /* renamed from: b  reason: collision with root package name */
    public HomeCommonPopListItem.a f74009b;

    /* renamed from: c  reason: collision with root package name */
    public String f74010c;

    /* renamed from: d  reason: collision with root package name */
    public int f74011d;

    /* renamed from: e  reason: collision with root package name */
    public int f74012e;

    public void afterInit() {
        super.afterInit();
        getRootLayout().setPadding(0, this.f74011d, this.f74012e, 0);
    }

    public List<HomeCommonPopListItem> getDataList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HomeCommonPopListItem(0, R.drawable.home_page_nav_desposit, j.d(R.string.n_home_golden), this.f74010c, this.f74009b));
        arrayList.add(new HomeCommonPopListItem(1, R.drawable.home_page_nav_scan, j.d(R.string.n_risk_title_scan), (String) null, this.f74009b));
        arrayList.add(new HomeCommonPopListItem(2, R.drawable.home_page_customer_service, j.d(R.string.n_home_customer_service), (String) null, this.f74009b));
        return arrayList;
    }

    public void setLocationRight(int i11) {
        this.f74012e = i11;
    }

    public void setLocationTop(int i11) {
        this.f74011d = i11;
    }

    public void sh(HomeCommonPopListItem.a aVar) {
        this.f74009b = aVar;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }

    public void th(String str) {
        this.f74010c = str;
        reloadDataList();
    }
}

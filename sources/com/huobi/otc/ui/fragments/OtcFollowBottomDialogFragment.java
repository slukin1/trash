package com.huobi.otc.ui.fragments;

import android.view.View;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuNewDialogFragment;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import java.util.ArrayList;

public class OtcFollowBottomDialogFragment extends BottomMenuNewDialogFragment implements MenuItemBean.a {

    /* renamed from: d  reason: collision with root package name */
    public a f79624d;

    public interface a {
        void a(String str);
    }

    public void Xf(View view, MenuItemBean menuItemBean, int i11) {
        a aVar = this.f79624d;
        if (aVar != null) {
            aVar.a(menuItemBean.getType());
        }
        dismiss();
    }

    public void afterInit() {
        ArrayList arrayList = new ArrayList();
        String string = getString(R$string.n_content_live_unfollow);
        MenuItemBean.MenuItemStyle menuItemStyle = MenuItemBean.MenuItemStyle.COMMON_BOLD;
        arrayList.add(new MenuItemBean("Unfollow", string, menuItemStyle, this));
        arrayList.add(new MenuItemBean("Retrict", getString(R$string.n_title_block), menuItemStyle, this));
        vh(arrayList);
        super.afterInit();
    }

    public int getContentViewResId() {
        return R$layout.dialog_fragment_otc_follow_layout;
    }
}

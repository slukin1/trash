package com.hbg.lib.widgets.dialog.viewhander;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import da.g;
import s9.c;

public class PaymentMethodMenuHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(MenuItemBean.a aVar, MenuItemBean menuItemBean, int i11, View view) {
        aVar.Xf(view, menuItemBean, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MenuItemBean menuItemBean, ViewGroup viewGroup) {
        View b11 = cVar.e().b(R$id.menu_color_view);
        ImageView imageView = (ImageView) cVar.e().b(R$id.menu_checkbox);
        ((TextView) cVar.e().b(R$id.menu_text_left)).setText(menuItemBean.getTextLeft());
        ((TextView) cVar.e().b(R$id.menu_text_right)).setText(menuItemBean.getTextRight());
        b11.setBackgroundColor(menuItemBean.getColorView());
        if (menuItemBean.getStyle() == MenuItemBean.MenuItemStyle.COMMON) {
            imageView.setImageResource(R$drawable.common_check_unselected);
        } else {
            imageView.setImageResource(R$drawable.common_check_selected);
        }
        MenuItemBean.a menuItemOnClickListener = menuItemBean.getMenuItemOnClickListener();
        if (menuItemOnClickListener != null) {
            ((LinearLayout) cVar.e().b(R$id.menu_container)).setOnClickListener(new g(menuItemOnClickListener, menuItemBean, i11));
        }
    }

    public int getResId() {
        return R$layout.bottom_menu_paymethod_item_layout;
    }
}

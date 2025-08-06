package com.hbg.lib.widgets.dialog.viewhander;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import da.a;
import s9.c;

public class BottomMenuHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(MenuItemBean.a aVar, MenuItemBean menuItemBean, int i11, View view) {
        aVar.Xf(view, menuItemBean, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MenuItemBean menuItemBean, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.menu_item);
        textView.setText(menuItemBean.getText());
        Context context = textView.getContext();
        if (menuItemBean.getStyle() == MenuItemBean.MenuItemStyle.COMMON) {
            textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryIconButton));
        } else if (menuItemBean.getStyle() == MenuItemBean.MenuItemStyle.COMMON_BOLD) {
            textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
            textView.setTextSize(1, 14.0f);
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        }
        MenuItemBean.a menuItemOnClickListener = menuItemBean.getMenuItemOnClickListener();
        if (menuItemOnClickListener != null) {
            textView.setOnClickListener(new a(menuItemOnClickListener, menuItemBean, i11));
        }
    }

    public int getResId() {
        return R$layout.bottom_menu_dialog_item_layout;
    }
}

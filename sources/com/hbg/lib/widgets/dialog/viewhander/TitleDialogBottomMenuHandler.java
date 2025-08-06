package com.hbg.lib.widgets.dialog.viewhander;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.TitleDialogMenuItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import da.h;
import s9.c;

public class TitleDialogBottomMenuHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(TitleDialogMenuItemBean.a aVar, TitleDialogMenuItemBean titleDialogMenuItemBean, int i11, View view) {
        aVar.a(view, titleDialogMenuItemBean, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TitleDialogMenuItemBean titleDialogMenuItemBean, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.menu_item);
        textView.setText(titleDialogMenuItemBean.getText());
        Context context = textView.getContext();
        if (titleDialogMenuItemBean.getStyle() == TitleDialogMenuItemBean.MenuItemStyle.COMMON) {
            textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        }
        TitleDialogMenuItemBean.a menuItemOnClickListener = titleDialogMenuItemBean.getMenuItemOnClickListener();
        if (menuItemOnClickListener != null) {
            textView.setOnClickListener(new h(menuItemOnClickListener, titleDialogMenuItemBean, i11));
        }
    }

    public int getResId() {
        return R$layout.bottom_title_menu_dialog_item_layout;
    }
}

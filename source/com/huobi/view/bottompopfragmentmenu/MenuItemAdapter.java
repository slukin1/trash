package com.huobi.view.bottompopfragmentmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;

public class MenuItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater listContainer;
    private List<MenuItem> menuItems;

    public MenuItemAdapter(Context context2, List<MenuItem> list) {
        this.context = context2;
        this.listContainer = LayoutInflater.from(context2);
        this.menuItems = list;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$getView$0(MenuItemOnClickListener menuItemOnClickListener, MenuItem menuItem, int i11, View view) {
        menuItemOnClickListener.onClickMenuItem(view, menuItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getCount() {
        List<MenuItem> list = this.menuItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i11) {
        if (i11 >= this.menuItems.size() || i11 < 0) {
            return null;
        }
        return this.menuItems.get(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.listContainer.inflate(R.layout.menu_item, (ViewGroup) null);
        }
        MenuItem menuItem = this.menuItems.get(i11);
        TextView textView = (TextView) view.findViewById(R.id.menu_item);
        textView.setText(menuItem.getText());
        if (menuItem.getStyle() == MenuItem.MenuItemStyle.COMMON) {
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.bottom_menu_btn_text_commom_color));
        } else {
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.bottom_menu_btn_text_stress_color));
        }
        MenuItemOnClickListener menuItemOnClickListener = menuItem.getMenuItemOnClickListener();
        if (menuItemOnClickListener != null) {
            textView.setOnClickListener(new d(menuItemOnClickListener, menuItem, i11));
        }
        return view;
    }
}

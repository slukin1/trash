package com.tencent.qcloud.tuikit.timcommon.component.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

public class PopMenuAdapter extends BaseAdapter {
    private List<PopMenuAction> dataSource = new ArrayList();

    public static class ViewHolder {
        public ImageView menu_icon;
        public TextView menu_lable;
    }

    public int getCount() {
        return this.dataSource.size();
    }

    public Object getItem(int i11) {
        return this.dataSource.get(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(TUIConfig.getAppContext()).inflate(R.layout.pop_menu_adapter, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.menu_icon = (ImageView) view.findViewById(R.id.pop_menu_icon);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.core_pop_menu_icon_size);
            ViewGroup.LayoutParams layoutParams = viewHolder.menu_icon.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            viewHolder.menu_icon.setLayoutParams(layoutParams);
            viewHolder.menu_lable = (TextView) view.findViewById(R.id.pop_menu_label);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PopMenuAction popMenuAction = (PopMenuAction) getItem(i11);
        viewHolder.menu_icon.setVisibility(0);
        if (popMenuAction.getIcon() != null) {
            viewHolder.menu_icon.setImageBitmap(popMenuAction.getIcon());
        } else if (popMenuAction.getIconResId() > 0) {
            viewHolder.menu_icon.setImageResource(popMenuAction.getIconResId());
        } else {
            viewHolder.menu_icon.setVisibility(8);
        }
        viewHolder.menu_lable.setText(popMenuAction.getActionName());
        return view;
    }

    public void setDataSource(List list) {
        this.dataSource = list;
        ThreadUtils.postOnUiThread(new Runnable() {
            public void run() {
                PopMenuAdapter.this.notifyDataSetChanged();
            }
        });
    }
}

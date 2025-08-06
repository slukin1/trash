package com.tencent.qcloud.tuikit.timcommon.component.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.util.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

public class PopDialogAdapter extends BaseAdapter {
    private List<PopMenuAction> dataSource = new ArrayList();

    public static class ViewHolder {
        public TextView text;
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
            view = LayoutInflater.from(TUIConfig.getAppContext()).inflate(R.layout.pop_dialog_adapter, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.pop_dialog_text);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.text.setText(((PopMenuAction) getItem(i11)).getActionName());
        return view;
    }

    public void setDataSource(List list) {
        this.dataSource = list;
        ThreadUtils.postOnUiThread(new Runnable() {
            public void run() {
                PopDialogAdapter.this.notifyDataSetChanged();
            }
        });
    }
}

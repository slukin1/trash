package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import java.util.List;

public class ActionsGridViewAdapter extends BaseAdapter {
    private List<InputMoreActionUnit> baseActions;
    private Context context;

    public ActionsGridViewAdapter(Context context2, List<InputMoreActionUnit> list) {
        this.context = context2;
        this.baseActions = list;
    }

    public int getCount() {
        return this.baseActions.size();
    }

    public Object getItem(int i11) {
        return this.baseActions.get(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        InputMoreActionUnit inputMoreActionUnit = this.baseActions.get(i11);
        View unitView = inputMoreActionUnit.getUnitView();
        if (unitView != null) {
            return unitView;
        }
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.chat_input_layout_actoin, viewGroup, false);
        }
        if (inputMoreActionUnit.getIconResId() > 0) {
            ((ImageView) view.findViewById(R.id.imageView)).setImageResource(inputMoreActionUnit.getIconResId());
        }
        if (!TextUtils.isEmpty(inputMoreActionUnit.getName())) {
            ((TextView) view.findViewById(R.id.textView)).setText(inputMoreActionUnit.getName());
        }
        return view;
    }
}

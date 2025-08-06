package com.huobi.points.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import pro.huobi.R;
import s9.c;

public class PolicyGroupItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, gq.c cVar2, ViewGroup viewGroup) {
        ((TextView) cVar.itemView).setText(cVar2.a());
    }

    public int getResId() {
        return R.layout.layout_policy_group_item;
    }
}

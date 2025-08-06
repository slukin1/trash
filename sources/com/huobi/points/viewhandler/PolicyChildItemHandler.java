package com.huobi.points.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import gq.b;
import pro.huobi.R;
import s9.c;

public class PolicyChildItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        ((TextView) cVar.itemView).setText(bVar.a());
    }

    public int getResId() {
        return R.layout.layout_policy_child_item;
    }
}

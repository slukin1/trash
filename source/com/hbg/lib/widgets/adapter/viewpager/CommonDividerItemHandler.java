package com.hbg.lib.widgets.adapter.viewpager;

import android.view.ViewGroup;
import com.hbg.lib.widgets.R$layout;
import s9.c;
import t9.a;

public class CommonDividerItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        if (aVar.c() != -1) {
            cVar.itemView.setBackgroundColor(aVar.c());
        } else if (aVar.d() != -1) {
            cVar.itemView.setBackgroundResource(aVar.d());
        }
        if (aVar.e() != 0) {
            ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
            layoutParams.height = aVar.e();
            cVar.itemView.setLayoutParams(layoutParams);
        }
    }

    public int getResId() {
        return R$layout.layout_common_divider;
    }
}

package com.hbg.lib.widgets.adapter.viewpager;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import s9.c;
import t9.b;

public class CommonOffsetDividerItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        View b11 = cVar.e().b(R$id.divider_view);
        if (bVar.c() != -1) {
            cVar.itemView.setBackgroundColor(bVar.c());
        } else if (bVar.f() != -1) {
            b11.setBackgroundResource(bVar.f());
        }
        if (bVar.e() != 0) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b11.getLayoutParams();
            layoutParams.height = bVar.e();
            layoutParams.setMarginStart(bVar.g());
            layoutParams.setMarginEnd(bVar.d());
            b11.setLayoutParams(layoutParams);
        }
    }

    public int getResId() {
        return R$layout.layout_common_offset_divider;
    }
}

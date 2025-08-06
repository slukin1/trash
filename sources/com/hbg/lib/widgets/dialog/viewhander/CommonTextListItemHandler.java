package com.hbg.lib.widgets.dialog.viewhander;

import android.view.ViewGroup;
import android.widget.TextView;
import ba.b;
import com.hbg.lib.widgets.R$layout;
import s9.c;

public class CommonTextListItemHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        ((TextView) cVar.itemView).setText(bVar.c());
    }

    public int getResId() {
        return R$layout.layout_common_text_list_item;
    }
}

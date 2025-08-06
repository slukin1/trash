package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import pro.huobi.R;
import s9.c;
import vk.a;

public class AccountChooseItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R.id.tv_title);
        TextView textView2 = (TextView) cVar.e().b(R.id.tv_arrow);
        textView.setText(aVar.d());
        textView2.setVisibility(aVar.h() ? 0 : 4);
        textView.setOnClickListener(aVar.c());
    }

    public int getResId() {
        return R.layout.item_account_choose;
    }
}

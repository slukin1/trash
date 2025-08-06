package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryDetailBean;
import com.huobi.finance.utils.UiFillUtil;
import d7.k;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.p;

public class HtExchangeHistoryDetailViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, p pVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        HtExchangeHistoryDetailBean c11 = pVar.c();
        String z11 = k.C().z(c11.getCurrency());
        ((TextView) e11.b(R.id.tv_coin)).setText(z11);
        ((TextView) e11.b(R.id.tv_amount)).setText(UiFillUtil.c(c11.getVolume()) + " " + z11);
        cVar.itemView.getContext().getResources().getString(R.string.ht_suffix);
        ((TextView) e11.b(R.id.tv_actual_exchange)).setText(String.format("%s %s", new Object[]{UiFillUtil.c(c11.getHtVolume()), c11.getUnit()}));
    }

    public int getResId() {
        return R.layout.item_ht_exchange_history_detail;
    }
}

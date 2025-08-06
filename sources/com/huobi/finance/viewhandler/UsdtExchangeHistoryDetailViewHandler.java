package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryDetailBean;
import com.huobi.finance.utils.UiFillUtil;
import d7.k;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.w;

public class UsdtExchangeHistoryDetailViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, w wVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        UsdtExchangeHistoryDetailBean c11 = wVar.c();
        String z11 = k.C().z(c11.getCurrency());
        ((TextView) e11.b(R.id.tv_coin)).setText(z11);
        ((TextView) e11.b(R.id.tv_amount)).setText(UiFillUtil.d(c11.getVolume()) + " " + z11);
        ((TextView) e11.b(R.id.tv_actual_exchange)).setText(String.format(cVar.itemView.getContext().getResources().getString(R.string.usdt_suffix), new Object[]{UiFillUtil.d(c11.getUsdtVolume())}));
    }

    public int getResId() {
        return R.layout.item_usdt_exchange_history_detail;
    }
}

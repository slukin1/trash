package com.huobi.finance.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.s;

public class LimitDescriptionViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, s sVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R.id.label_tv)).setText(sVar.c());
        String d11 = sVar.d();
        TradeType tradeType = TradeType.PRO;
        ((TextView) e11.b(R.id.total_limit_tv)).setText(m.m(d11, PrecisionUtil.a(tradeType, "")));
        ((TextView) e11.b(R.id.available_limit_tv)).setText(m.m(sVar.a(), PrecisionUtil.a(tradeType, "")));
    }

    public int getResId() {
        return R.layout.item_limit_description;
    }
}

package com.huobi.finance.viewhandler;

import al.p;
import al.s;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.network.pro.core.bean.WalletItem;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.PocketListItem;
import i6.r;
import s9.c;

public class PocketItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, PocketListItem pocketListItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        WalletItem data = pocketListItem.getData();
        s.g((ImageView) e11.b(R$id.iv_logo), data.getIcon());
        ((TextView) e11.b(R$id.tv_name)).setText(data.getName());
        String str = LegalCurrencyConfigUtil.w() + " ";
        ((TextView) e11.b(R$id.tv_price)).setText(String.format("%s%s", new Object[]{str, LegalCurrencyConfigUtil.B(data.getPrice())}));
        p.e((TextView) e11.b(R$id.tv_amount), data.getAmount());
        p.g((TextView) e11.b(R$id.tv_value), "≈ " + str, LegalCurrencyConfigUtil.B(data.getValue()));
    }

    public int getResId() {
        return R$layout.item_on_chain_pocket;
    }
}

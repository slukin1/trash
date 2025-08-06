package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.SavingsDataTotal;
import com.huobi.finance.utils.UiFillUtil;
import i6.m;
import i6.r;
import s9.c;

public class AssetTotalSavingViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f67608b;

    /* renamed from: c  reason: collision with root package name */
    public String f67609c;

    public String b(BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal.getNetAssetToBtc();
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, SavingsDataTotal savingsDataTotal, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        if (this.f67608b == null) {
            this.f67608b = cVar.itemView.getResources().getString(R$string.global_crossbar);
        }
        if (this.f67609c == null) {
            this.f67609c = cVar.itemView.getResources().getString(R$string.balance_hide_star);
        }
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.balance_header_hint);
        TextView textView2 = (TextView) e11.b(R$id.tv_total_amount);
        TextView textView3 = (TextView) e11.b(R$id.tv_total_amount_legal);
        if (savingsDataTotal == null) {
            str = "";
        } else {
            str = savingsDataTotal.getTitle();
        }
        UiFillUtil.a(textView, str);
        String str4 = null;
        String b11 = savingsDataTotal != null ? b(savingsDataTotal) : null;
        if (savingsDataTotal != null) {
            str4 = savingsDataTotal.getNetAsset();
        }
        if (TextUtils.isEmpty(b11)) {
            str2 = this.f67608b;
        } else if (savingsDataTotal.isShow()) {
            str2 = m.u0(b11, 12, 8);
        } else {
            str2 = this.f67609c;
        }
        if (TextUtils.isEmpty(str4)) {
            str3 = this.f67608b;
        } else if (savingsDataTotal.isShow()) {
            str3 = LegalCurrencyConfigUtil.J(textView3.getContext(), str4);
        } else {
            str3 = this.f67609c;
        }
        UiFillUtil.a(textView3, str3);
        UiFillUtil.a(textView2, str2);
    }

    public int getResId() {
        return R$layout.item_saving_total;
    }
}

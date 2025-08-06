package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import bh.j;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.utils.UiFillUtil;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;

public class C2CLendAssetTotalViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f67614b;

    /* renamed from: c  reason: collision with root package name */
    public String f67615c;

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, C2CLendBalanceDataTotal c2CLendBalanceDataTotal, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        if (this.f67614b == null) {
            this.f67614b = cVar.itemView.getResources().getString(R.string.global_crossbar);
        }
        if (this.f67615c == null) {
            this.f67615c = cVar.itemView.getResources().getString(R.string.balance_hide_star);
        }
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.tv_total);
        TextView e13 = e11.e(R.id.tv_total_estimate);
        e11.e(R.id.tv_benefit);
        e11.e(R.id.tv_benefit_estimate);
        TextView textView = (TextView) e11.b(R.id.balance_header_hint);
        if (c2CLendBalanceDataTotal == null) {
            str = "";
        } else {
            str = c2CLendBalanceDataTotal.getTitle();
        }
        UiFillUtil.a(textView, str);
        String str4 = null;
        String netAssetToBtc = c2CLendBalanceDataTotal != null ? c2CLendBalanceDataTotal.getNetAssetToBtc() : null;
        if (c2CLendBalanceDataTotal != null) {
            str4 = c2CLendBalanceDataTotal.getNetAsset();
        }
        if (c2CLendBalanceDataTotal == null || !c2CLendBalanceDataTotal.isShow()) {
            str2 = this.f67615c;
        } else {
            str2 = m.u0(netAssetToBtc, 12, 8);
        }
        if (TextUtils.isEmpty(str4)) {
            str3 = LegalCurrencyConfigUtil.J(j.c(), this.f67614b);
        } else if (c2CLendBalanceDataTotal.isShow()) {
            str3 = LegalCurrencyConfigUtil.J(j.c(), str4);
        } else {
            str3 = this.f67615c;
        }
        UiFillUtil.a(e12, str2);
        UiFillUtil.a(e13, str3);
    }

    public int getResId() {
        return R.layout.item_balance_c2c_lend_total;
    }
}

package com.huobi.homemarket.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;

public class MarketContractInfoView extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f73056b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73057c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f73058d;

    /* renamed from: e  reason: collision with root package name */
    public View f73059e;

    public MarketContractInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    public final void h(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_market_contract_info_view, this);
        this.f73056b = (TextView) inflate.findViewById(R$id.item_chart_basecurrency);
        this.f73057c = (TextView) inflate.findViewById(R$id.id_market_item_type);
        this.f73058d = (TextView) inflate.findViewById(R$id.item_chart_amount);
        this.f73059e = inflate.findViewById(R$id.font_icon_text_view_market_item_collection_sign);
    }

    public void setAmount(String str) {
        this.f73058d.setText(str);
    }

    public void setContractType(String str) {
        this.f73057c.setText(str);
    }

    public void setIsCollected(boolean z11) {
        ViewUtil.m(this.f73059e, z11);
    }

    public void setPaintColor(boolean z11) {
        if (z11) {
            TextView textView = this.f73056b;
            Resources resources = getResources();
            int i11 = R$color.baseColorThreeLevelText;
            textView.setTextColor(resources.getColor(i11));
            this.f73058d.setTextColor(getResources().getColor(i11));
            return;
        }
        this.f73056b.setTextColor(getResources().getColor(R$color.global_main_text_color));
        this.f73058d.setTextColor(getResources().getColor(R$color.baseColorSecondaryTextNew));
    }

    public void setSymbolName(String str) {
        this.f73056b.setText(str);
    }

    public MarketContractInfoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h(context);
    }
}

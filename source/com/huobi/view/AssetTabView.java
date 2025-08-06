package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;

public class AssetTabView extends LinearLayout {
    private Integer distributionType;
    private int selectorColor;
    private TextView subTitle;
    private TextView title;
    private int unSelectorColor;

    public AssetTabView(Context context) {
        this(context, (AttributeSet) null);
    }

    public Integer getDistributionType() {
        return this.distributionType;
    }

    public void init(int i11, int i12) {
        this.selectorColor = i11;
        this.unSelectorColor = i12;
    }

    public void setDistributionType(Integer num) {
        this.distributionType = num;
    }

    public void setSubText(CharSequence charSequence) {
        this.subTitle.setText(charSequence);
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        this.title.setText(charSequence);
        this.subTitle.setText(charSequence2);
    }

    public void tabSelect() {
        this.title.setTextColor(ContextCompat.getColor(getContext(), this.selectorColor));
        this.subTitle.setTextColor(ContextCompat.getColor(getContext(), this.selectorColor));
    }

    public void tabUnSelect() {
        this.title.setTextColor(ContextCompat.getColor(getContext(), this.unSelectorColor));
        this.subTitle.setTextColor(ContextCompat.getColor(getContext(), this.unSelectorColor));
    }

    public AssetTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.selectorColor = R$color.kColorPrimaryText;
        this.unSelectorColor = R$color.kColorThreeLevelText;
        this.distributionType = -1;
        LayoutInflater.from(context).inflate(R$layout.tab_asset_account_tab_view, this);
        this.title = (TextView) findViewById(R$id.tab_title);
        this.subTitle = (TextView) findViewById(R$id.sub_tab_title);
    }
}

package com.huobi.otc.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.otc.core.bean.P2PPayMethodBean;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import ip.a;
import jp.v1;

public class OtcFilterHistoryItem extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public a f79965b;

    public OtcFilterHistoryItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.item_filter_ads, this);
        a(context, (String) null);
    }

    public void a(Context context, String str) {
        int i11;
        int i12;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R$id.checkbox);
        if (!TextUtils.isEmpty(str)) {
            appCompatCheckBox.setText(str);
        }
        if (this.f79965b != null) {
            Context context2 = appCompatCheckBox.getContext();
            if (this.f79965b.g()) {
                i11 = R$color.baseColorMajorTheme100;
            } else {
                i11 = R$color.global_main_text_color;
            }
            appCompatCheckBox.setTextColor(ContextCompat.getColor(context2, i11));
            LinearLayout linearLayout = (LinearLayout) findViewById(R$id.checkbox_container);
            if (this.f79965b.g()) {
                linearLayout.setBackgroundResource(R$drawable.ads_filter_item_select_blue);
            } else {
                linearLayout.setBackgroundResource(R$drawable.ads_filter_item_normal);
            }
            View findViewById = findViewById(R$id.checkbox_color_view);
            if (this.f79965b.c() == null || !(this.f79965b.c() instanceof P2PPayMethodBean)) {
                findViewById.setVisibility(0);
                findViewById.setBackgroundColor(v1.b());
                return;
            }
            findViewById.setVisibility(0);
            try {
                i12 = Color.parseColor(((P2PPayMethodBean) this.f79965b.c()).getColor());
            } catch (Exception e11) {
                e11.printStackTrace();
                i12 = ContextCompat.getColor(BaseApplication.b(), com.hbg.lite.R$color.baseColorMajorTheme100);
            }
            findViewById.setBackgroundColor(i12);
        }
    }
}

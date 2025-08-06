package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.finance.bean.BaseAssetInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.y;

public class UsdtExchangeViewHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonCheckBox f67634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f67635c;

        public a(CommonCheckBox commonCheckBox, y yVar) {
            this.f67634b = commonCheckBox;
            this.f67635c = yVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f67634b.toggle();
            this.f67635c.i(this.f67634b.isChecked());
            y.a d11 = this.f67635c.d();
            if (d11 != null) {
                d11.i(this.f67635c, this.f67634b.isChecked());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, y yVar, ViewGroup viewGroup) {
        String str;
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_available);
        TextView textView2 = (TextView) e11.b(R.id.tv_estimate);
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R.id.check_box);
        BaseAssetInfo c11 = yVar.c();
        commonCheckBox.setChecked(yVar.g());
        ((TextView) e11.b(R.id.tv_coin_name)).setText(c11.getDisplayName());
        String avaialAble = c11.getAvaialAble();
        if (TextUtils.isEmpty(avaialAble)) {
            str = "--";
        } else {
            str = m.u0(avaialAble, 12, 8);
        }
        textView.setText(str);
        String e12 = yVar.e();
        if (TextUtils.isEmpty(e12)) {
            e12 = "0";
        }
        textView2.setText(m.u0(e12, 12, 8));
        cVar.itemView.setOnClickListener(new a(commonCheckBox, yVar));
    }

    public int getResId() {
        return R.layout.item_usdt_exchange;
    }
}

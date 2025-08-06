package com.huobi.finance.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.huobi.finance.bean.BaseAssetInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;
import vk.r;

public class HtExchangeViewHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonCheckBox f67618b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f67619c;

        public a(CommonCheckBox commonCheckBox, r rVar) {
            this.f67618b = commonCheckBox;
            this.f67619c = rVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            this.f67618b.toggle();
            this.f67619c.i(this.f67618b.isChecked());
            r.a d11 = this.f67619c.d();
            if (d11 != null) {
                d11.v(this.f67619c, this.f67618b.isChecked());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, r rVar, ViewGroup viewGroup) {
        i6.r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_available);
        TextView textView2 = (TextView) e11.b(R.id.tv_estimate);
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R.id.check_box);
        BaseAssetInfo c11 = rVar.c();
        commonCheckBox.setChecked(rVar.g());
        ((TextView) e11.b(R.id.tv_coin_name)).setText(c11.getDisplayName());
        String avaialAble = c11.getAvaialAble();
        String str = "--";
        if (TextUtils.isEmpty(avaialAble)) {
            avaialAble = str;
        }
        textView.setText(avaialAble);
        String e12 = rVar.e();
        if (!TextUtils.isEmpty(e12)) {
            str = e12;
        }
        textView2.setText(str);
        cVar.itemView.setOnClickListener(new a(commonCheckBox, rVar));
    }

    public int getResId() {
        return R.layout.item_ht_exchange;
    }
}

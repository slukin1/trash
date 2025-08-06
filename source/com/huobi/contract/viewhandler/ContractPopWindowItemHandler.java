package com.huobi.contract.viewhandler;

import aj.b;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class ContractPopWindowItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        cVar.itemView.setTag(bVar);
        cVar.itemView.setOnClickListener(this);
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R$id.id_contract_trade_popwindow_item_img);
        TextView textView = (TextView) e11.b(R$id.id_contract_trade_popwindow_item_name);
        int i12 = 0;
        e11.b(R$id.id_contract_trade_popwindow_item_dot).setVisibility(bVar.g() ? 0 : 8);
        View b11 = e11.b(R$id.llTag);
        AppCompatTextView appCompatTextView = (AppCompatTextView) e11.b(R$id.tvTag);
        View b12 = e11.b(R$id.redDot);
        imageView.setImageResource(bVar.d());
        textView.setText(bVar.f());
        if (bVar.e() == 22) {
            appCompatTextView.setText(R$string.n_live_free);
            b11.setVisibility(0);
        } else {
            b11.setVisibility(4);
        }
        if (!bVar.h()) {
            i12 = 4;
        }
        b12.setVisibility(i12);
    }

    public int getResId() {
        return R$layout.list_item_contract_popwindow;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        b bVar = (b) view.getTag();
        if (!(bVar == null || bVar.c() == null)) {
            bVar.c().a(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}

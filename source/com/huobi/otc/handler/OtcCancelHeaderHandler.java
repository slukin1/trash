package com.huobi.otc.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcCancelReasonDataType;
import s9.c;

public class OtcCancelHeaderHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OtcCancelReasonDataType otcCancelReasonDataType, ViewGroup viewGroup) {
        ((TextView) cVar.e().b(R$id.tv_title)).setText(otcCancelReasonDataType.getDataBean().getTitle());
    }

    public int getResId() {
        return R$layout.item_cancel_header;
    }
}

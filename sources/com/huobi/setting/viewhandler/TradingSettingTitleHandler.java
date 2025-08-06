package com.huobi.setting.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import hr.j;
import i6.r;
import pro.huobi.R;
import s9.c;

public class TradingSettingTitleHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, j jVar, ViewGroup viewGroup) {
        if (cVar != null && jVar != null) {
            r e11 = cVar.e();
            ViewUtil.m(e11.b(R.id.trading_setting_item_top_line), jVar.c());
            ((TextView) e11.b(R.id.trading_setting_item_title)).setText(jVar.a());
        }
    }

    public int getResId() {
        return R.layout.layout_trading_setting_title_item;
    }
}

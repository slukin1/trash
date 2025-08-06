package com.huobi.setting.viewhandler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import hr.i;
import i6.r;
import pro.huobi.R;
import s9.c;

public class TradingSettingNotificationTitleHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, i iVar, ViewGroup viewGroup) {
        if (cVar != null && iVar != null) {
            r e11 = cVar.e();
            ViewUtil.m(e11.b(R.id.trading_setting_item_top_line), iVar.c());
            ((TextView) e11.b(R.id.trading_setting_item_title)).setText(iVar.a());
        }
    }

    public int getResId() {
        return R.layout.layout_trading_setting_notification_title_item;
    }
}

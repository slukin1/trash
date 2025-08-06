package com.huobi.otc.ui;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$layout;

@Route(path = "/otc/trade/exchange")
public class OtcExchangeShellActivity extends EmptyMVPActivity {
    public int getContentView() {
        return R$layout.common_empty_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = null;
        String stringExtra = getIntent().hasExtra("from") ? getIntent().getStringExtra("from") : null;
        if (getIntent().hasExtra("to")) {
            str = getIntent().getStringExtra("to");
        }
        OtcModuleConfig.b().u(this, stringExtra, str);
        finish();
    }
}

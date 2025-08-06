package com.hbg.module.kline.ui;

import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.module.kline.R$anim;
import com.hbg.module.kline.R$layout;

public class MarketInfoRestartActivity extends EmptyMVPActivity {
    public int getContentView() {
        return R$layout.activity_market_info_restart;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intent intent2 = intent.hasExtra("extra_intent") ? (Intent) intent.getParcelableExtra("extra_intent") : null;
        if (intent2 != null) {
            startActivity(intent2);
        }
        finish();
    }

    public void overridePendingTransition(int i11, int i12) {
        super.overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
    }
}

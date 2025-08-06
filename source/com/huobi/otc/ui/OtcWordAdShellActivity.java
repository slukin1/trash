package com.huobi.otc.ui;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$layout;

@Route(path = "/otc/word/ad")
public class OtcWordAdShellActivity extends EmptyMVPActivity {
    public int getContentView() {
        return R$layout.common_empty_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("shareCode", (String) null);
            OtcModuleConfig.b().M(this, extras.getString("watchword", (String) null), string);
        }
        finish();
    }
}

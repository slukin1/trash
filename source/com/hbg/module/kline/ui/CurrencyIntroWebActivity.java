package com.hbg.module.kline.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;

public class CurrencyIntroWebActivity extends HBBaseWebActivity {
    public static void startWebView(Context context, String str, String str2, boolean z11) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!NetworkStatus.c(context)) {
                HuobiToastUtil.k(context, R$string.string_network_disconnect);
                return;
            }
            Intent intent = new Intent(context, CurrencyIntroWebActivity.class);
            intent.putExtra("url", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("title", str2);
            }
            intent.putExtra("isauth", z11);
            intent.addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public void init() {
        super.init();
        if (isSupportBlankLabel()) {
            this.mWebView.getSettings().setSupportMultipleWindows(true);
        }
    }

    public boolean isSupportBlankLabel() {
        return true;
    }
}

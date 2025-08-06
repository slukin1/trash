package com.huobi.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.ColorUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huawei.hms.framework.common.ContainerUtils;

public class CurrencyIntroWebActivity extends HBBaseWebActivity {
    public static void start(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(BaseModuleConfig.a().W());
            sb2.append("asset-introduction/details/h5/?currency=");
            sb2.append(str);
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append("refresh=2&");
            sb2.append("color=" + ColorUtils.c(ContextCompat.getColor(context, R$color.finance_web_refresh_color)));
            startWebView(context, sb2.toString(), (String) null, false);
        }
    }

    private static void startWebView(Context context, String str, String str2, boolean z11) {
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

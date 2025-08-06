package com.huobi.webview2.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import pro.huobi.R;

public class IndexWebActivity extends HBBaseWebActivity {
    public static boolean xh(Context context, String str, String str2, String str3, boolean z11) {
        if (context == null || !(context instanceof Activity) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(context, R.string.string_network_disconnect);
            return false;
        }
        Intent intent = new Intent(context, IndexWebActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("title", str2);
        }
        intent.putExtra("title_back", str3);
        intent.putExtra("isauth", z11);
        context.startActivity(intent);
        return true;
    }

    public String buildParams(String str) {
        return str;
    }
}

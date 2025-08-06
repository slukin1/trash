package com.huobi.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.CommonFunc;
import com.huobi.domain.d;
import com.huobi.webview2.ui.IndexWebActivity;
import java.net.URI;
import java.net.URISyntaxException;
import oa.a;
import pro.huobi.R;

public final class v {
    public static void a(Context context, String str, String str2) {
        Context b11 = context instanceof Application ? a.g().b() : context;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("holigeit")) {
            BaseModuleConfig.a().k0(str);
        } else if (str.startsWith("huobiapp://?action=openbrowser")) {
            try {
                String m11 = StringUtils.m(StringUtils.l(new URI(str).getQuery()), "url");
                if (!TextUtils.isEmpty(m11)) {
                    CommonFunc.a(b11, m11);
                }
            } catch (URISyntaxException e11) {
                e11.printStackTrace();
            }
        } else {
            String c11 = d.c(str);
            Intent intent = new Intent();
            intent.putExtra("url", c11);
            intent.putExtra("title_back", context.getString(R.string.head_return));
            intent.putExtra("title", str2);
            intent.setClass(b11, IndexWebActivity.class);
            b11.startActivity(intent);
        }
    }
}

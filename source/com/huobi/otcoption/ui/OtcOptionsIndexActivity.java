package com.huobi.otcoption.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import xp.a;

@Route(path = "/Contract/OtcOptions")
public class OtcOptionsIndexActivity extends AbsOtcOptionsBaseActivity {
    public static void Qi(String str, String str2, Context context) {
        if (!TextUtils.isEmpty(str)) {
            a.e(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a.h(str2);
        } else {
            a.h("");
        }
        context.startActivity(new Intent(context, OtcOptionsIndexActivity.class));
    }

    public String Nh() {
        return "otc_options_index";
    }

    public void onResume() {
        super.onResume();
        is.a.m("1005379");
    }
}

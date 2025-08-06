package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class OtcAdvertPublishDetailActivity extends OtcAdPublishEditActivity {
    public static void Pi(Context context, String str) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("key_ad_id", str);
        }
        intent.setClass(context, OtcAdvertPublishDetailActivity.class);
        context.startActivity(intent);
    }

    public String Nh() {
        return "otc_advert_publish_detail";
    }
}

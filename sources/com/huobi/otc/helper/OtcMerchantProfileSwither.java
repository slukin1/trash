package com.huobi.otc.helper;

import android.app.Activity;
import android.content.Intent;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.flutter.OtcMerchantProfileActivity;

public class OtcMerchantProfileSwither {
    public static void a(Activity activity, Long l11) {
        Intent intent = new Intent(activity, OtcMerchantProfileActivity.class);
        intent.putExtra("merchant_id", l11);
        if (OtcModuleConfig.a().a()) {
            activity.startActivity(intent);
        } else {
            OtcModuleConfig.a().l(activity, (Intent) null, (Intent) null);
        }
    }
}

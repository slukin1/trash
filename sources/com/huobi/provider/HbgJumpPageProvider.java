package com.huobi.provider;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.module.libkt.provider.BaseJumpPageProvider;
import com.hbg.module.libkt.provider.JumpPageScheme;
import com.huobi.activity.SettingActivity;
import com.huobi.utils.v;
import kn.a;
import rn.c;

@Route(path = "/provider/jumpPage")
public class HbgJumpPageProvider implements BaseJumpPageProvider {
    public void d(Context context, JumpPageScheme jumpPageScheme) {
        if (jumpPageScheme.getPageName().equals("setting")) {
            SettingActivity.di(context);
        } else if (jumpPageScheme.getPageName().equals(FirebaseAnalytics.Event.LOGIN)) {
            c.i().p(context, (a) null, false);
        }
    }

    public void e(Context context, String str, String str2) {
        v.a(context, str, str2);
    }

    public void init(Context context) {
    }
}

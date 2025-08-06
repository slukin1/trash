package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Intent;
import com.huobi.login.bean.JumpTarget;
import rn.c;
import tg.r;

public class LiteDwRecordActivity extends DwRecordActivity {
    public static void Ki(Activity activity) {
        Intent intent = new Intent(activity, LiteDwRecordActivity.class);
        if (r.x().F0()) {
            activity.startActivity(intent);
        } else {
            c.i().d(activity, new JumpTarget(intent, (Intent) null));
        }
    }

    public String Nh() {
        return "lite_dw_record";
    }
}

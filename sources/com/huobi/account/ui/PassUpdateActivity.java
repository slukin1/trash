package com.huobi.account.ui;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Keep;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class PassUpdateActivity extends AbsGlobalFlutterActivity {
    public static void Di(Activity activity) {
        activity.startActivity(new Intent(activity, PassUpdateActivity.class));
    }

    public String Nh() {
        return "change_pwd_app";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
        finish();
    }
}

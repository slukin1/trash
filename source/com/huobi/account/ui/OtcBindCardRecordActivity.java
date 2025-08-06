package com.huobi.account.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public class OtcBindCardRecordActivity extends AbsGlobalFlutterActivity {
    public static void Di(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, OtcBindCardRecordActivity.class);
        context.startActivity(intent);
    }

    public String Nh() {
        return "otc_bind_card_record";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        finish();
    }
}

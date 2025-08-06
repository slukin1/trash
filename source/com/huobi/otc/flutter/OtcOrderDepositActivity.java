package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import jp.v0;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;

public class OtcOrderDepositActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public final v0 f78520k = new v0(this);

    public static void Di(Context context) {
        context.startActivity(new Intent(context, OtcOrderDepositActivity.class));
    }

    public String Nh() {
        v0 v0Var = this.f78520k;
        if (v0Var == null) {
            return "otc_all_order";
        }
        return v0Var.l();
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        this.f78520k.q(getIntent());
        this.f78520k.g(flutterEngine);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }
}

package com.huobi.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import mo.a;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rd.d;
import rn.c;

public class UserGroupSettingActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f41620k;

    public static void Ei(Activity activity) {
        activity.startActivityForResult(new Intent(activity, UserGroupSettingActivity.class), 666);
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if ("selectedGroup".equals(methodCall.method)) {
                Intent intent = new Intent();
                intent.putExtra("groupData", d.f23353a.a(methodCall.arguments));
                setResult(-1, intent);
                return;
            }
            result.notImplemented();
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "user_setting_group_list";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "user_setting_channel");
        this.f41620k = methodChannel;
        methodChannel.setMethodCallHandler(new e6(this));
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
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }
}

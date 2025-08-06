package com.huobi.integration;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import androidx.annotation.Keep;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rn.c;
import yl.o;

@Route(path = "/account/score")
public class IntegrationActivity extends AbsGlobalFlutterActivity {

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            IntegrationActivity.this.Di(methodCall, result);
        }
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if ("gotoTask".equals(methodCall.method)) {
                String str = (String) methodCall.argument("target");
                IndexFeatureItem indexFeatureItem = new IndexFeatureItem();
                indexFeatureItem.setNeedLogin(1);
                if (methodCall.hasArgument(RemoteMessageConst.MessageBody.PARAM)) {
                    indexFeatureItem.setJumpSymbol((String) methodCall.argument(RemoteMessageConst.MessageBody.PARAM));
                }
                int parseInt = Integer.parseInt(str);
                indexFeatureItem.setJumpMode(parseInt);
                if ((parseInt == 1 || parseInt == 2) && methodCall.hasArgument(RemoteMessageConst.MessageBody.PARAM)) {
                    indexFeatureItem.setJumpSymbol((String) null);
                    indexFeatureItem.setJumpUrl((String) methodCall.argument(RemoteMessageConst.MessageBody.PARAM));
                }
                o.p(this, indexFeatureItem);
            }
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public String Nh() {
        return "integration";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), "integration_channel").setMethodCallHandler(new a());
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
    public void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }

    public SplashScreen provideSplashScreen() {
        return new DrawableSplashScreen(new ColorDrawable(getResources().getColor(R.color.baseColorContentBackground)), ImageView.ScaleType.FIT_XY, 200);
    }
}

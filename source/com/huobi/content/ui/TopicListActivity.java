package com.huobi.content.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.core.BaseModuleConfig;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qiu.niorgai.StatusBarCompat;
import rn.c;
import we.b;
import xi.a;

public class TopicListActivity extends AbsGlobalFlutterActivity {

    /* renamed from: k  reason: collision with root package name */
    public MethodChannel f43042k;

    public final void Ei(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        if ("initTopicData".equals(str)) {
            Intent intent = getIntent();
            HashMap hashMap = new HashMap();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("topicData");
                int intExtra = intent.getIntExtra("fromType", 0);
                hashMap.put("topicData", stringExtra);
                hashMap.put("fromType", String.valueOf(intExtra));
            }
            result.success(hashMap);
        } else if ("sendTopicData".equals(str)) {
            b.l("topicSendData", String.class).g((String) methodCall.argument("topicData"));
            result.success((Object) null);
            finish();
        } else if ("jumpTopicDetail".equals(str)) {
            try {
                String str2 = (String) methodCall.argument("topicUrl");
                if (!TextUtils.isEmpty(str2)) {
                    BaseModuleConfig.a().k0(str2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            result.success((Object) null);
        }
    }

    public String Nh() {
        return "content_topic_list_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "topic_channel");
        this.f43042k = methodChannel;
        methodChannel.setMethodCallHandler(new a(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarCompat.c(this, getResources().getColor(R.color.topic_status_bar_color));
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
}

package com.huobi.message.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.utils.k0;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import k20.h;
import ko.q;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qiu.niorgai.StatusBarCompat;
import rn.c;

public final class MessageDetailListActivity extends AbsGlobalFlutterActivity {

    /* renamed from: n  reason: collision with root package name */
    public static final a f78019n = new a((r) null);

    /* renamed from: o  reason: collision with root package name */
    public static final String f78020o = "type";

    /* renamed from: k  reason: collision with root package name */
    public final String f78021k = "message_detail_list_channel";

    /* renamed from: l  reason: collision with root package name */
    public int f78022l;

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel f78023m;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final String a() {
            return MessageDetailListActivity.f78020o;
        }
    }

    public static final void Fi(MessageDetailListActivity messageDetailListActivity, MethodCall methodCall, MethodChannel.Result result) {
        messageDetailListActivity.Gi(methodCall, result);
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        if (x.b("initMessageList", methodCall.method)) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf(this.f78022l));
            result.success(hashMap);
        }
    }

    public String Nh() {
        return "message_detail_list";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), this.f78021k);
        this.f78023m = methodChannel;
        methodChannel.setMethodCallHandler(new q(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f78022l = intent.getIntExtra(f78020o, this.f78022l);
        }
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
    public final void onTokenError(mo.a aVar) {
        Intent h11 = k0.h(this);
        c.i().m(this, new JumpTarget(h11, h11));
    }
}

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
import ko.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qiu.niorgai.StatusBarCompat;
import rn.c;

public final class MessageDetailActivity extends AbsGlobalFlutterActivity {

    /* renamed from: n  reason: collision with root package name */
    public static final a f78014n = new a((r) null);

    /* renamed from: o  reason: collision with root package name */
    public static final String f78015o = "data";

    /* renamed from: k  reason: collision with root package name */
    public final String f78016k = "message_detail_channel";

    /* renamed from: l  reason: collision with root package name */
    public String f78017l = "";

    /* renamed from: m  reason: collision with root package name */
    public MethodChannel f78018m;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final String a() {
            return MessageDetailActivity.f78015o;
        }
    }

    public static final void Fi(MessageDetailActivity messageDetailActivity, MethodCall methodCall, MethodChannel.Result result) {
        messageDetailActivity.Gi(methodCall, result);
    }

    public final void Gi(MethodCall methodCall, MethodChannel.Result result) {
        if (x.b("initMessageDetail", methodCall.method)) {
            HashMap hashMap = new HashMap();
            hashMap.put("data", this.f78017l);
            result.success(hashMap);
        }
    }

    public String Nh() {
        return "message_detail_page";
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), this.f78016k);
        this.f78018m = methodChannel;
        methodChannel.setMethodCallHandler(new p(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f78017l = String.valueOf(intent.getStringExtra(f78015o));
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

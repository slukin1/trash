package com.huobi.message.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.hbg.module.huobi.im.event.MessageSwitchEvent;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import d10.l;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import k20.h;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;

public final class MessageNotificationFragment extends AbsGlobalFlutterFragment {

    /* renamed from: l  reason: collision with root package name */
    public static final a f78024l = new a((r) null);

    /* renamed from: m  reason: collision with root package name */
    public static final String f78025m = Constants.ScionAnalytics.PARAM_MESSAGE_CHANNEL;

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78026i;

    /* renamed from: j  reason: collision with root package name */
    public l<? super Integer, Unit> f78027j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f78028k;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final MessageNotificationFragment a() {
            MessageNotificationFragment messageNotificationFragment = new MessageNotificationFragment();
            messageNotificationFragment.setArguments(new Bundle());
            return messageNotificationFragment;
        }
    }

    public static final class b implements MethodChannel.Result {
        public void error(String str, String str2, Object obj) {
        }

        public void notImplemented() {
        }

        public void success(Object obj) {
        }
    }

    public static final MessageNotificationFragment Th() {
        return f78024l.a();
    }

    public String Bh() {
        return "message";
    }

    public final void Uh() {
        HashMap hashMap = new HashMap();
        MethodChannel methodChannel = this.f78026i;
        if (methodChannel != null) {
            methodChannel.invokeMethod("readMessageAll", hashMap, new b());
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), f78025m);
        this.f78026i = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onMessageNoDisturbUpdate(MessageSwitchEvent messageSwitchEvent) {
        if (!TextUtils.equals("Push-Chat", messageSwitchEvent.f19696a)) {
            this.f78028k = true;
        }
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        try {
            String str2 = methodCall.method;
            if (x.b("jumpMessageList", str2)) {
                Integer num = (Integer) methodCall.argument("type");
                if (num != null) {
                    Intent intent = new Intent(getContext(), MessageDetailListActivity.class);
                    intent.putExtra(MessageDetailListActivity.f78019n.a(), num.intValue());
                    startActivity(intent);
                }
            } else if (x.b("updateReadCount", str2)) {
                Integer num2 = (Integer) methodCall.argument("readNum");
                if (num2 != null) {
                    int intValue = num2.intValue();
                    l<? super Integer, Unit> lVar = this.f78027j;
                    if (lVar != null) {
                        lVar.invoke(Integer.valueOf(intValue));
                    }
                }
            } else if (x.b("jumpMessageDetail", str2) && (str = (String) methodCall.argument("data")) != null) {
                Intent intent2 = new Intent(getContext(), MessageDetailActivity.class);
                intent2.putExtra(MessageDetailActivity.f78014n.a(), str);
                startActivity(intent2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            result.notImplemented();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f78028k) {
            Uh();
            this.f78028k = false;
        }
    }
}

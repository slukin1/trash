package com.huobi.otc.flutter;

import android.os.Bundle;
import androidx.activity.o;
import androidx.fragment.app.FragmentActivity;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.ui.OtcLiteChatActivity;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

public class OtcOrderTransConfirmFlutterFragemnt extends AbsGlobalFlutterFragment {

    /* renamed from: i  reason: collision with root package name */
    public String f78526i;

    /* renamed from: j  reason: collision with root package name */
    public MethodChannel f78527j;

    /* renamed from: k  reason: collision with root package name */
    public o f78528k = new a(true);

    public class a extends o {
        public a(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            OtcOrderTransConfirmFlutterFragemnt.this.Vh();
        }
    }

    public static OtcOrderTransConfirmFlutterFragemnt Uh(String str) {
        OtcOrderTransConfirmFlutterFragemnt otcOrderTransConfirmFlutterFragemnt = new OtcOrderTransConfirmFlutterFragemnt();
        Bundle bundle = new Bundle();
        bundle.putString("orderId", str);
        bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.texture.name());
        otcOrderTransConfirmFlutterFragemnt.setArguments(bundle);
        return otcOrderTransConfirmFlutterFragemnt;
    }

    public String Bh() {
        return "otc_chat_trans_confirm";
    }

    public final void Vh() {
        FragmentActivity activity = getActivity();
        if (activity instanceof OtcLiteChatActivity) {
            ((OtcLiteChatActivity) activity).ii(true);
        }
    }

    public void Wh(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getInitData")) {
            HashMap hashMap = new HashMap();
            String str = this.f78526i;
            if (str == null) {
                str = "";
            }
            hashMap.put("orderId", str);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_chat_trans_confirm_channel");
        this.f78527j = methodChannel;
        methodChannel.setMethodCallHandler(new d0(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f78526i = (String) arguments.get("orderId");
        }
        getActivity().getOnBackPressedDispatcher().h(this.f78528k);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f78528k.remove();
        this.f78528k.setEnabled(false);
        this.f78528k = null;
    }
}

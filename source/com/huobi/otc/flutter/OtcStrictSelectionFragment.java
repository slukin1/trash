package com.huobi.otc.flutter;

import android.os.Bundle;
import androidx.activity.o;
import androidx.fragment.app.FragmentActivity;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.persenter.OtcTradePresenter;
import i6.d;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class OtcStrictSelectionFragment extends AbsGlobalFlutterFragment {

    /* renamed from: k  reason: collision with root package name */
    public static final String f78587k = OtcStrictSelectionFragment.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    public MethodChannel f78588i;

    /* renamed from: j  reason: collision with root package name */
    public o f78589j = new b(true);

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcStrictSelectionFragment.this.Wh(methodCall, result);
        }
    }

    public class b extends o {
        public b(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            d.c(OtcStrictSelectionFragment.f78587k, " OnBackPressedDispatcher handleOnBackPressed");
            OtcStrictSelectionFragment.this.Vh();
        }
    }

    public static OtcStrictSelectionFragment Uh() {
        OtcStrictSelectionFragment otcStrictSelectionFragment = new OtcStrictSelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.texture.name());
        otcStrictSelectionFragment.setArguments(bundle);
        return otcStrictSelectionFragment;
    }

    public String Bh() {
        return "otc_strict_selection";
    }

    public final void Vh() {
        FragmentActivity activity = getActivity();
        if (activity instanceof OtcTradePresenter.i) {
            ((OtcTradePresenter.i) activity).uc();
        } else if (activity instanceof OtcMerchantProfileActivity) {
            ((OtcMerchantProfileActivity) activity).Fi();
        }
    }

    public void Wh(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == 1671672458) {
                if (str.equals("dismiss")) {
                    c11 = 0;
                }
            }
            if (c11 != 0) {
                result.notImplemented();
                return;
            }
            Vh();
            result.success((Object) null);
        } catch (Exception e11) {
            e11.printStackTrace();
            result.success((Object) null);
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "advert_strict_selection_channel");
        this.f78588i = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().getOnBackPressedDispatcher().h(this.f78589j);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f78589j.remove();
        this.f78589j.setEnabled(false);
        this.f78589j = null;
    }

    public void onResume() {
        super.onResume();
        this.f78588i.invokeMethod("showStrictSelectionContent", (Object) null);
    }
}

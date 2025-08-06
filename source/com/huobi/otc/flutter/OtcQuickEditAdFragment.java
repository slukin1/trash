package com.huobi.otc.flutter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.o;
import androidx.fragment.app.FragmentActivity;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.utils.Security2FADialogHelper;
import com.huobi.flutter.base.AbsGlobalFlutterFragment;
import com.huobi.otc.persenter.OtcTradePresenter;
import com.huobi.share.ImageUtil;
import com.huobi.sharev2.manager.ShareManager;
import com.tencent.android.tpush.common.MessageKey;
import dp.t;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
import pro.huobi.R;
import u6.g;
import up.f;

public class OtcQuickEditAdFragment extends AbsGlobalFlutterFragment {

    /* renamed from: n  reason: collision with root package name */
    public static final String f78544n = OtcQuickEditAdFragment.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    public String f78545i;

    /* renamed from: j  reason: collision with root package name */
    public com.huobi.otc.helper.a f78546j;

    /* renamed from: k  reason: collision with root package name */
    public t f78547k;

    /* renamed from: l  reason: collision with root package name */
    public MethodChannel f78548l;

    /* renamed from: m  reason: collision with root package name */
    public o f78549m = new d(true);

    public class a implements MethodChannel.MethodCallHandler {
        public a() {
        }

        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            OtcQuickEditAdFragment.this.ci(methodCall, result);
        }
    }

    public class b implements cp.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodCall f78551a;

        public b(MethodCall methodCall) {
            this.f78551a = methodCall;
        }

        public void a() {
        }

        public void b() {
        }

        public void c(String str) {
            String access$200 = OtcQuickEditAdFragment.f78544n;
            i6.d.c(access$200, "token=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78551a.argument("userPayMethodId"));
            hashMap.put("action", this.f78551a.argument("action"));
            hashMap.put(MessageKey.MSG_TRACE_ID, this.f78551a.argument(MessageKey.MSG_TRACE_ID));
            hashMap.put("securityToken", str);
            OtcQuickEditAdFragment.this.f78548l.invokeMethod("payMethodCode", hashMap);
        }

        public void d(BaseDialogFragment baseDialogFragment) {
        }

        public void e() {
        }

        public void f(t tVar) {
            t unused = OtcQuickEditAdFragment.this.f78547k = tVar;
        }

        public boolean g() {
            return false;
        }

        public void h(String str) {
            String access$200 = OtcQuickEditAdFragment.f78544n;
            i6.d.c(access$200, "password=" + str);
            HashMap hashMap = new HashMap();
            hashMap.put("userPayMethodId", this.f78551a.argument("userPayMethodId"));
            hashMap.put("action", this.f78551a.argument("action"));
            hashMap.put(MessageKey.MSG_TRACE_ID, this.f78551a.argument(MessageKey.MSG_TRACE_ID));
            hashMap.put(MTCoreConstants.Register.KEY_PASSWORD, str);
            OtcQuickEditAdFragment.this.f78548l.invokeMethod("payMethodCode", hashMap);
            if (OtcQuickEditAdFragment.this.f78547k != null && OtcQuickEditAdFragment.this.f78547k.isShowing()) {
                OtcQuickEditAdFragment.this.f78547k.dismiss();
            }
        }
    }

    public class c implements jp.c {

        public class a extends Security2FADialogHelper.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Security2FADialogHelper f78554a;

            public a(Security2FADialogHelper security2FADialogHelper) {
                this.f78554a = security2FADialogHelper;
            }

            public void onFailed(String str) {
            }

            public void onSuccess(Security2FADialogHelper.AuthResult authResult) {
                OtcQuickEditAdFragment.this.f78546j.s().c(authResult.getToken());
                this.f78554a.v();
            }
        }

        public class b implements jp.c {
            public b() {
            }

            public void call() {
                OtcQuickEditAdFragment.this.f78546j.I();
            }
        }

        public c() {
        }

        public void call() {
            Security2FADialogHelper security2FADialogHelper = new Security2FADialogHelper(OtcQuickEditAdFragment.this.getActivity(), OtcQuickEditAdFragment.this, "VERIFY_SETTING_POLICY_OTC_FUND_PASSWORD");
            security2FADialogHelper.L(true);
            security2FADialogHelper.M(true);
            security2FADialogHelper.S(new a(security2FADialogHelper), new b());
        }
    }

    public class d extends o {
        public d(boolean z11) {
            super(z11);
        }

        public void handleOnBackPressed() {
            i6.d.c(OtcQuickEditAdFragment.f78544n, " OnBackPressedDispatcher handleOnBackPressed");
            OtcQuickEditAdFragment.this.ai(true);
        }
    }

    public static OtcQuickEditAdFragment Zh(String str) {
        OtcQuickEditAdFragment otcQuickEditAdFragment = new OtcQuickEditAdFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_adId", str);
        bundle.putString(FlutterFragment.ARG_FLUTTERVIEW_RENDER_MODE, RenderMode.texture.name());
        otcQuickEditAdFragment.setArguments(bundle);
        return otcQuickEditAdFragment;
    }

    public String Bh() {
        return "otc_ad_quick_edit";
    }

    public final void ai(boolean z11) {
        FragmentActivity activity = getActivity();
        if (activity instanceof OtcTradePresenter.i) {
            ((OtcTradePresenter.i) activity).J6(z11);
        }
    }

    public View bi(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i11) {
        String str12;
        String str13;
        String str14 = str3;
        String str15 = str5;
        String str16 = str7;
        String str17 = str10;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_otc_ad_share, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(R.id.tv_time)).setText(DateTimeUtils.i(System.currentTimeMillis(), "MM/dd/yyyy HH:mm", (Locale) null));
        f6.c.a().f((ImageView) inflate.findViewById(R.id.iv_coin_icon), f.b().c(str16), R.drawable.coin_default_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_buy_or_sell);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_coin_name);
        if (i11 == 0) {
            textView.setText(getResources().getString(R.string.n_otc_buy));
        } else {
            textView.setText(getResources().getString(R.string.n_otc_sell));
        }
        String str18 = "";
        textView2.setText(str16 == null ? str18 : str16);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_price_num);
        if (TextUtils.equals("on", str9)) {
            if (str17 == null) {
                str13 = str18;
            } else {
                str13 = str17 + " " + str15;
            }
            textView3.setText(str13);
        } else {
            if (str14 == null) {
                str12 = str18;
            } else {
                str12 = str3 + " " + str15;
            }
            textView3.setText(str12);
        }
        ((TextView) inflate.findViewById(R.id.tv_count_num)).setText(str6 + " " + str16);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_rang_num);
        StringBuilder sb2 = new StringBuilder();
        String str19 = "--";
        sb2.append(str == null ? str19 : str);
        sb2.append(" - ");
        if (str2 != null) {
            str19 = str2;
        }
        sb2.append(str19);
        sb2.append(" ");
        sb2.append(str15);
        textView4.setText(sb2.toString());
        ((TextView) inflate.findViewById(R.id.tv_payment_value)).setText(str8 == null ? str18 : str8);
        ((TextView) inflate.findViewById(R.id.tv_ad_word_content)).setText(str4 == null ? str18 : str4);
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_invite);
        if (str11 != null) {
            str18 = str11;
        }
        textView5.setText(str18);
        ((TextView) inflate.findViewById(R.id.tv_tips)).setText("*" + context.getResources().getString(R.string.n_otc_advert_code_word_tip));
        return inflate;
    }

    public final void ci(MethodCall methodCall, MethodChannel.Result result) {
        boolean z11;
        OtcQuickEditAdFragment otcQuickEditAdFragment;
        Object obj;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        try {
            String str = methodCall2.method;
            i6.d.c(f78544n, "onMethodCall method=" + str + ",arguments=" + methodCall2.arguments);
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1949106608:
                    if (str.equals("getInitData")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1836262593:
                    if (str.equals("showFundPasswordAlert")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1556421602:
                    if (str.equals("showAdPublishPage")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1371982791:
                    if (str.equals("dismissPage")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -465631085:
                    if (str.equals("shareAdvert")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            if (c11 == 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adId", this.f78545i);
                result2.success(jSONObject.toString());
            } else if (c11 != 1) {
                if (c11 == 2) {
                    di(methodCall);
                    result2.success((Object) null);
                } else if (c11 == 3) {
                    OtcAdPublishEditActivity.Pi(getActivity(), (String) methodCall2.argument("adId"));
                    result2.success((Object) null);
                } else if (c11 != 4) {
                    result.notImplemented();
                    return;
                } else {
                    try {
                        try {
                            Bitmap a11 = ImageUtil.a(getActivity(), bi(getActivity(), (String) methodCall2.argument("minTradeLimit"), (String) methodCall2.argument("maxTradeLimit"), (String) methodCall2.argument("floatPrice"), (String) methodCall2.argument("codeWord"), (String) methodCall2.argument("currencyName"), (String) methodCall2.argument("tradeCount"), (String) methodCall2.argument("coinName"), (String) methodCall2.argument("paymentsString"), (String) methodCall2.argument("isFixed"), (String) methodCall2.argument("fixedPrice"), (String) methodCall2.argument("shareContentTip"), ((Integer) methodCall2.argument("tradeType")).intValue()));
                            ArrayList arrayList = new ArrayList();
                            if (a11 != null) {
                                try {
                                    arrayList.add(a11);
                                } catch (Exception e11) {
                                    e = e11;
                                    MethodChannel.Result result3 = result;
                                }
                            }
                            ShareManager.getInstance().newShareWithImages((ArrayList<Bitmap>) arrayList, true, false, "");
                            try {
                                result.success((Object) null);
                            } catch (Exception e12) {
                                e = e12;
                                e.printStackTrace();
                                result.notImplemented();
                            }
                        } catch (Exception e13) {
                            e = e13;
                            MethodChannel.Result result4 = result;
                            e.printStackTrace();
                            result.notImplemented();
                        }
                    } catch (Exception e14) {
                        e = e14;
                        MethodChannel.Result result5 = result2;
                        e.printStackTrace();
                        result.notImplemented();
                    }
                }
            } else {
                MethodChannel.Result result6 = result2;
                Object argument = methodCall2.argument("updated");
                if (argument == null || ((Integer) argument).intValue() != 1) {
                    otcQuickEditAdFragment = this;
                    obj = null;
                    z11 = false;
                } else {
                    obj = null;
                    z11 = true;
                    otcQuickEditAdFragment = this;
                }
                try {
                    otcQuickEditAdFragment.ai(z11);
                    result6.success(obj);
                } catch (Exception e15) {
                    e = e15;
                    e.printStackTrace();
                    result.notImplemented();
                }
            }
        } catch (Exception e16) {
            e = e16;
            MethodChannel.Result result7 = result2;
            e.printStackTrace();
            result.notImplemented();
        }
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "otc_ad_quick_edit_channel");
        this.f78548l = methodChannel;
        methodChannel.setMethodCallHandler(new a());
    }

    public void di(MethodCall methodCall) {
        if (this.f78546j == null) {
            this.f78546j = new com.huobi.otc.helper.a(getActivity(), (g) getActivity());
        }
        this.f78546j.J(new b(methodCall));
        this.f78546j.M(new c());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        getActivity().getWindow().setSoftInputMode(16);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f78545i = (String) arguments.get("key_adId");
        }
        getActivity().getOnBackPressedDispatcher().h(this.f78549m);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f78549m.remove();
        this.f78549m.setEnabled(false);
        this.f78549m = null;
    }

    public void onDetach() {
        super.onDetach();
        getActivity().getWindow().setSoftInputMode(0);
    }
}

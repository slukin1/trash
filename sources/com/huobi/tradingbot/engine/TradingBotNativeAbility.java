package com.huobi.tradingbot.engine;

import a7.e;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.v8.V8Object;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.copytrading.engine.CopytradingNativeAbility;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.trade.bean.TradingBotSelectMarketInfo;
import com.huobi.tradingbot.manager.GridLeverageRangeController;
import com.huobi.tradingbot.ui.SelectMarketDialogFragment;
import com.huobi.webview2.action.JsBusinessActionHelper;
import com.huobi.webview2.ui.ContractWebActivity;
import com.huochat.community.util.JsonTool;
import com.xiaomi.mipush.sdk.Constants;
import i6.i;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.x;
import pro.huobi.R;
import rx.Observable;
import rx.schedulers.Schedulers;
import v6.u;
import yt.c;
import yt.d;
import yt.f;
import yt.g;
import yt.h;
import yt.j;
import yt.k;

public final class TradingBotNativeAbility extends CopytradingNativeAbility {

    public static final class a extends EasySubscriber<List<? extends String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TradingBotNativeAbility f83572b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f83573c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f83574d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f83575e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ rj.b f83576f;

        public a(TradingBotNativeAbility tradingBotNativeAbility, Ref$ObjectRef<String> ref$ObjectRef, Ref$ObjectRef<String> ref$ObjectRef2, Ref$ObjectRef<String> ref$ObjectRef3, rj.b bVar) {
            this.f83572b = tradingBotNativeAbility;
            this.f83573c = ref$ObjectRef;
            this.f83574d = ref$ObjectRef2;
            this.f83575e = ref$ObjectRef3;
            this.f83576f = bVar;
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            boolean unused = this.f83572b.T((String) this.f83573c.element, (String) this.f83574d.element, (String) this.f83575e.element, this.f83576f);
        }
    }

    public static final class b implements LeverSelectDialogFragment.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ rj.b f83577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f83578b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<FutureContractInfo> f83579c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<FragmentActivity> f83580d;

        public b(rj.b bVar, String str, Ref$ObjectRef<FutureContractInfo> ref$ObjectRef, Ref$ObjectRef<FragmentActivity> ref$ObjectRef2) {
            this.f83577a = bVar;
            this.f83578b = str;
            this.f83579c = ref$ObjectRef;
            this.f83580d = ref$ObjectRef2;
        }

        public void N0() {
            String str;
            if (this.f83579c.element != null) {
                TradeType tradeType = TradeType.LINEAR_SWAP;
                if (e.E(tradeType)) {
                    str = "symbol";
                } else {
                    str = e.G(tradeType) ? "usdt" : "sheet";
                }
                ContractWebActivity.ii((Activity) this.f83580d.element, ((FutureContractInfo) this.f83579c.element).getSymbol(), str, x.b("cny", LegalCurrencyConfigUtil.y()) ? "cny" : "usd", ((FutureContractInfo) this.f83579c.element).getContractCode(), ((FutureContractInfo) this.f83579c.element).getContractShortType(), FutureContractInfo.MARGIN_CROSS, 4);
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return null;
        }

        public void P0(String str) {
            rj.b bVar = this.f83577a;
            bVar.I(this.f83578b + '(' + str + ')');
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return new String[0];
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            leverSelectDialogFragment.oi();
            return true;
        }
    }

    public static final void Q(rj.b bVar) {
        bVar.B();
    }

    public static final void U(String str, List list, String str2, rj.b bVar, String str3) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (FragmentActivity) oa.a.g().b();
        LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(str);
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        T futureContractInfo = new FutureContractInfo();
        ref$ObjectRef2.element = futureContractInfo;
        if (n11 != null) {
            FutureContractInfo futureContractInfo2 = (FutureContractInfo) futureContractInfo;
            FutureContractInfo futureContractInfo3 = (FutureContractInfo) futureContractInfo;
            futureContractInfo.convert(futureContractInfo, n11);
        } else {
            List L0 = StringsKt__StringsKt.L0(str, new String[]{Constants.ACCEPT_TIME_SEPARATOR_SERVER}, false, 0, 6, (Object) null);
            T t11 = ref$ObjectRef2.element;
            ((FutureContractInfo) t11).contractCode = str;
            ((FutureContractInfo) t11).symbol = (String) L0.get(0);
            ((FutureContractInfo) ref$ObjectRef2.element).quoteCurrency = (String) L0.get(1);
            T t12 = ref$ObjectRef2.element;
            ((FutureContractInfo) t12).contractType = "swap";
            ((FutureContractInfo) t12).contractCode = str;
        }
        LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
        leverSelectDialogFragment.ui(true);
        leverSelectDialogFragment.tc(list);
        leverSelectDialogFragment.wi(1);
        leverSelectDialogFragment.bc(((FutureContractInfo) ref$ObjectRef2.element).getSymbol());
        leverSelectDialogFragment.xi(e.m((Context) ref$ObjectRef.element, ((FutureContractInfo) ref$ObjectRef2.element).getSymbol(), ((FutureContractInfo) ref$ObjectRef2.element).getQuoteCurrency(), ((FutureContractInfo) ref$ObjectRef2.element).getContractCode(), ((FutureContractInfo) ref$ObjectRef2.element).getContractType(), 1));
        leverSelectDialogFragment.vi(new b(bVar, str3, ref$ObjectRef2, ref$ObjectRef));
        leverSelectDialogFragment.ti(str2);
        leverSelectDialogFragment.setTradeType(TradeType.LINEAR_SWAP);
        leverSelectDialogFragment.zi(ContractWebActivity.Eh(4));
        leverSelectDialogFragment.si(str);
        leverSelectDialogFragment.show(((FragmentActivity) ref$ObjectRef.element).getSupportFragmentManager(), "LinearSwapLeverSelectDialogFragment");
    }

    public static final void W(rj.b bVar) {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        AlertDialog.a aVar = new AlertDialog.a(fragmentActivity);
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R.layout.dialog_tradingbot_agreement, (ViewGroup) null);
        aVar.setView(inflate);
        Button button = (Button) inflate.findViewById(R.id.dialog_confirm_btn);
        View findViewById = inflate.findViewById(R.id.dialog_close);
        button.setBackgroundResource(R.drawable.bg_order_tutorial_btn);
        button.setEnabled(false);
        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.sv_dialog_content);
        nestedScrollView.setOnScrollChangeListener(new yt.e(button));
        nestedScrollView.post(new g(nestedScrollView, button));
        AlertDialog create = aVar.create();
        findViewById.setOnClickListener(new yt.b(create));
        ((Button) inflate.findViewById(R.id.dialog_cancel_btn)).setOnClickListener(new c(create));
        button.setOnClickListener(new d(create, bVar));
        create.setCancelable(false);
        create.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        create.getWindow().setGravity(17);
        create.show();
        WindowManager.LayoutParams attributes = create.getWindow().getAttributes();
        attributes.width = (PixelUtils.g() * 325) / 375;
        attributes.gravity = 17;
        create.getWindow().setAttributes(attributes);
    }

    public static final void X(Button button, NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        if (!nestedScrollView.canScrollVertically(1)) {
            i6.d.c("ScrollView", "滚动到了底部");
            button.setEnabled(true);
        }
    }

    public static final void Y(NestedScrollView nestedScrollView, Button button) {
        if (!nestedScrollView.canScrollVertically(1)) {
            i6.d.c("ScrollView", "滚动到了底部");
            button.setEnabled(true);
        }
    }

    public static final void Z(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void a0(Dialog dialog, View view) {
        dialog.dismiss();
    }

    public static final void b0(Dialog dialog, rj.b bVar, View view) {
        dialog.dismiss();
        bVar.I("sendAgreementConfirm()");
    }

    public static final void d0(String str, rj.b bVar) {
        JSONObject parseObject = JsonTool.parseObject(str);
        String string = parseObject.getString("symbol");
        int intValue = parseObject.getIntValue("searchType");
        SelectMarketDialogFragment selectMarketDialogFragment = new SelectMarketDialogFragment();
        selectMarketDialogFragment.Ph(string);
        selectMarketDialogFragment.Oh(intValue == 2);
        selectMarketDialogFragment.Nh(new f(bVar));
        selectMarketDialogFragment.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "SelectMarketDialogFragment");
    }

    public static final void e0(rj.b bVar, TradingBotSelectMarketInfo tradingBotSelectMarketInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("symbol", tradingBotSelectMarketInfo.symbol);
        String str = tradingBotSelectMarketInfo.callBackStr;
        if (str == null) {
            str = tradingBotSelectMarketInfo.displayName;
        }
        jSONObject.put("displayName", str);
        bVar.I("sendMarketSearchSymbol(" + jSONObject + ')');
    }

    public final void R(V8Object v8Object, rj.b bVar, AbilityFunction.a aVar) {
        String str;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        String str2;
        boolean z11 = false;
        if (v8Object != null) {
            try {
                if (v8Object.contains("params")) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (z11) {
            str = v8Object.getString("params");
            JSONObject parseObject = JsonTool.parseObject(str);
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = parseObject.getString("contractCode");
            ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = parseObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE);
            ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = parseObject.getString("callBackName");
            if (!T((String) ref$ObjectRef.element, (String) ref$ObjectRef2.element, (String) ref$ObjectRef3.element, bVar) && (str2 = (String) ref$ObjectRef.element) != null) {
                GridLeverageRangeController.b(true, str2).subscribeOn(Schedulers.io()).retry(3).subscribe(new a(this, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, bVar));
            }
            aVar.a(true, "");
        }
        str = "";
        JSONObject parseObject2 = JsonTool.parseObject(str);
        ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = parseObject2.getString("contractCode");
        ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = parseObject2.getString(HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE);
        ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = parseObject2.getString("callBackName");
        GridLeverageRangeController.b(true, str2).subscribeOn(Schedulers.io()).retry(3).subscribe(new a(this, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, bVar));
        aVar.a(true, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A[Catch:{ all -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void S(com.eclipsesource.v8.V8Object r7, rj.b r8, com.huobi.edgeengine.ability.AbilityFunction.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "page"
            r1 = 1
            r2 = 0
            if (r7 == 0) goto L_0x000e
            boolean r3 = r7.contains(r0)
            if (r3 != r1) goto L_0x000e
            r3 = r1
            goto L_0x000f
        L_0x000e:
            r3 = r2
        L_0x000f:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0018
            java.lang.String r0 = r7.getString(r0)
            goto L_0x0019
        L_0x0018:
            r0 = r4
        L_0x0019:
            java.lang.String r3 = "params"
            if (r7 == 0) goto L_0x0026
            boolean r5 = r7.contains(r3)     // Catch:{ all -> 0x0024 }
            if (r5 != r1) goto L_0x0026
            goto L_0x0027
        L_0x0024:
            r1 = move-exception
            goto L_0x002f
        L_0x0026:
            r1 = r2
        L_0x0027:
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = r7.getString(r3)     // Catch:{ all -> 0x0024 }
            r4 = r1
            goto L_0x0032
        L_0x002f:
            r1.printStackTrace()
        L_0x0032:
            java.lang.String r1 = "tradingBotSelectMarket"
            boolean r1 = kotlin.jvm.internal.x.b(r0, r1)
            if (r1 == 0) goto L_0x003e
            r6.c0(r8, r4, r9)
            goto L_0x0051
        L_0x003e:
            java.lang.String r1 = "tradingBotAgreementShow"
            boolean r0 = kotlin.jvm.internal.x.b(r0, r1)
            if (r0 == 0) goto L_0x004a
            r6.V(r8, r4, r9)
            goto L_0x0051
        L_0x004a:
            android.content.Context r8 = r8.d()
            super.j(r7, r8, r9)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradingbot.engine.TradingBotNativeAbility.S(com.eclipsesource.v8.V8Object, rj.b, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final boolean T(String str, String str2, String str3, rj.b bVar) {
        List<String> c11 = GridLeverageRangeController.c(str);
        if (c11 == null || c11.size() <= 0) {
            return false;
        }
        i.b().d(new h(str, c11, str2, bVar, str3));
        return true;
    }

    public final void V(rj.b bVar, String str, AbilityFunction.a aVar) {
        i.b().d(new k(bVar));
        aVar.a(true, "");
    }

    public void a(rj.b bVar, Object obj, AbilityFunction.a aVar) {
        if (aVar == null || obj == null || bVar == null) {
            Log.d("Console", "call TradingBotNativeAbility error");
            return;
        }
        try {
            V8Object v8Object = (V8Object) obj;
            String string = v8Object.contains("action") ? v8Object.getString("action") : "";
            if (string != null) {
                switch (string.hashCode()) {
                    case -2065996633:
                        if (string.equals("H5FilterSetData")) {
                            Activity b11 = oa.a.g().b();
                            if (b11 instanceof HBBaseWebActivity) {
                                String string2 = v8Object.contains("params") ? v8Object.getString("params") : null;
                                if (string2 != null) {
                                    JSONObject parseObject = JsonTool.parseObject(string2);
                                    JsMessage jsMessage = new JsMessage();
                                    jsMessage.setData(parseObject);
                                    jsMessage.setCode(200);
                                    jsMessage.setAction(JsBusinessActionHelper.tradingBotFilterCallBack);
                                    x6.b.e(jsMessage, (u) b11, false);
                                }
                            }
                            aVar.a(true, "");
                            return;
                        }
                        break;
                    case -554263646:
                        if (!string.equals("changeLeverDialog")) {
                            break;
                        } else {
                            R(v8Object, bVar, aVar);
                            return;
                        }
                    case -504772615:
                        if (!string.equals("openPage")) {
                            break;
                        } else {
                            S(v8Object, bVar, aVar);
                            return;
                        }
                    case -384864244:
                        if (!string.equals("H5FilterPopClose")) {
                            break;
                        } else {
                            aVar.a(true, "");
                            i.b().d(new j(bVar));
                            return;
                        }
                }
            }
            super.a(bVar, obj, aVar);
        } catch (Throwable th2) {
            Log.d("Console", "call TradingBotNativeAbility error ");
            th2.printStackTrace();
            aVar.a(false, th2.getMessage());
        }
    }

    public final void c0(rj.b bVar, String str, AbilityFunction.a aVar) {
        i.b().d(new yt.i(str, bVar));
        aVar.a(true, "");
    }
}

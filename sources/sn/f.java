package sn;

import a7.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.common.utils.ColorUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.core.lang.EnLang;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.kline.ui.MarketInfoActivity;
import com.huobi.account.ui.ContractCustomerServiceActivity;
import com.huobi.account.ui.FeedbackActivity;
import com.huobi.account.ui.HuobiZopimChatActivity;
import com.huobi.account.ui.KycAuthInfoActivity;
import com.huobi.domain.DomainSwitcher;
import com.huobi.fee.FeeRateActivity;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import com.huobi.webview2.ui.CustomServiceWebActivity;
import com.huobi.webview2.ui.SecurityWebActivity;
import com.huochat.community.network.domain.DomainTool;
import com.zopim.android.sdk.api.ZopimChat;
import d7.a1;
import ej.g;
import ht.o;
import i6.d;
import i6.k;
import java.io.Serializable;
import kn.a;
import pro.huobi.R;
import rn.c;
import tg.r;
import us.j;
import wi.b;

public final class f {
    public static void A(Context context, String str, boolean z11, boolean z12, TradeType tradeType, boolean z13) {
        Bundle bundle = new Bundle();
        String X = a1.v().X(str, tradeType);
        bundle.putString("symbolId", str);
        bundle.getBoolean("market_is_hadax", a1.v().N(X));
        bundle.getBoolean("market_is_st", a1.v().T(X));
        bundle.putString("market_title", X);
        bundle.putString("market_trade_type", tradeType.toString());
        bundle.putBoolean("kline_show_info", z13);
        HbgRouter.i(context, "/kline/index", bundle);
    }

    public static void B(Context context, IndexCurrencyInfo indexCurrencyInfo, TradeType tradeType) {
        Intent m11 = m(context, indexCurrencyInfo, tradeType);
        if (m11 != null) {
            context.startActivity(m11);
        }
    }

    public static void C(Context context, String str, boolean z11, TradeType tradeType) {
        E(context, str, z11, false, tradeType);
    }

    public static void D(Context context, String str, boolean z11, TradeType tradeType, String str2) {
        if (o(context, str, z11, z11, tradeType) != null) {
            Bundle bundle = new Bundle();
            String X = a1.v().X(str, tradeType);
            bundle.putString("symbolId", str);
            bundle.putString("from", str2);
            bundle.getBoolean("market_is_hadax", a1.v().N(X));
            bundle.getBoolean("market_is_st", a1.v().T(X));
            bundle.putString("market_title", X);
            bundle.putString("market_trade_type", tradeType.toString());
            HbgRouter.i(context, "/kline/index", bundle);
        }
    }

    public static void E(Context context, String str, boolean z11, boolean z12, TradeType tradeType) {
        if (o(context, str, z11, z12, tradeType) != null) {
            Bundle bundle = new Bundle();
            String X = a1.v().X(str, tradeType);
            bundle.putString("symbolId", str);
            bundle.getBoolean("market_is_hadax", a1.v().N(X));
            bundle.getBoolean("market_is_st", a1.v().T(X));
            bundle.putString("market_title", X);
            bundle.putString("market_trade_type", tradeType.toString());
            Log.d("Console", "goToKLine call  navigation");
            HbgRouter.i(context, "/kline/index", bundle);
        }
    }

    public static void F(Context context, String str, boolean z11, boolean z12, TradeType tradeType) {
        TradeType tradeType2;
        if (t(context, str, z11, z12, tradeType) != null) {
            Bundle bundle = new Bundle();
            String X = a1.v().X(str, tradeType);
            if (TextUtils.isEmpty(X) && tradeType != (tradeType2 = TradeType.PRO)) {
                X = a1.v().X(str, tradeType2);
                tradeType = tradeType2;
            }
            bundle.putString("symbolId", str);
            bundle.getBoolean("market_is_hadax", a1.v().N(X));
            bundle.getBoolean("market_is_st", a1.v().T(X));
            bundle.putString("market_title", X);
            bundle.putString("market_trade_type", tradeType.toString());
            HbgRouter.i(context, "/kline/index", bundle);
        }
    }

    public static void G(Context context, FutureContractInfo futureContractInfo) {
        Intent u11 = u(context, futureContractInfo);
        if (u11 != null) {
            context.startActivity(u11);
        }
    }

    public static void H(Context context, FutureContractInfo futureContractInfo) {
        if (futureContractInfo != null) {
            context.startActivity(w(context, futureContractInfo));
        }
    }

    public static void I(Context context, String str, String str2, SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
        Intent x11 = x(context, str, str2, swapCurrencyInfo, tradeType);
        if (x11 != null) {
            context.startActivity(x11);
        }
    }

    public static void J(Activity activity) {
        activity.startActivity(h(activity));
    }

    public static /* synthetic */ void K(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        J(fragmentActivity);
    }

    public static /* synthetic */ void L(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        fragmentActivity.startActivity(new Intent(fragmentActivity, FeedbackActivity.class));
    }

    public static void M(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        sb2.append(str);
        sb2.append(s());
        sb2.append("finance-beta/analysis/h5/");
        sb2.append("?");
        sb2.append("refresh=1&");
        sb2.append("color=" + ColorUtils.c(ContextCompat.getColor(context, R.color.finance_web_refresh_color)));
        context.startActivity(HBBaseWebActivity.createIntent(context, sb2.toString(), (String) null));
    }

    public static void N(Context context, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        d.c("JUMP_EARN_DEPOSIT", "projectInfoUrl :" + str2 + s() + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(s());
        sb2.append(str);
        HBBaseWebActivity.showWebView(context, sb2.toString(), "", "", true);
    }

    public static void O(Activity activity) {
        String str;
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            str = str2 + "/zh-cn/" + "feedback/h5/";
        } else {
            str = str2 + "/en-us/" + "feedback/h5/";
        }
        HBBaseWebActivity.showWebView(activity, str, (String) null, "", false);
    }

    public static void P(Activity activity, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str2 + s() + ("ladder-lending/h5/cross-margin/?hideNav=1&name=" + str), "", "", false);
    }

    public static void Q(Activity activity, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str2 + s() + ("evaluation-etp/?symbol=" + str), "", "", false);
    }

    public static void R(Activity activity) {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str + s() + "evaluation-grid/", "", "", false);
    }

    public static void S(FragmentActivity fragmentActivity) {
        new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getResources().getString(R.string.allow_access_dialog_title)).C0(fragmentActivity.getString(R.string.n_me_about_feedback_tip)).R0(fragmentActivity.getString(R.string.feedback_to_online_service)).T0(true).S0(Integer.valueOf(ContextCompat.getColor(fragmentActivity, R.color.baseColorMajorTheme100))).P0(fragmentActivity.getString(R.string.n_me_about_feedback_start)).s0(fragmentActivity.getResources().getString(R.string.string_cancel)).U0(new d(fragmentActivity)).Q0(new e(fragmentActivity)).N0(o0.f12469a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public static void T(Context context, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(context, str2 + s() + str, (String) null, "", false);
    }

    public static void U(Activity activity) {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str + s() + "grid-exchange/rank/h5/?tabIndex=ai", "", "", false);
    }

    public static void V(Context context, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        d.c("JUMP_EARN_DEPOSIT", "projectInfoUrl :" + str2 + s() + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(s());
        sb2.append(str);
        HBBaseWebActivity.showWebView(context, sb2.toString(), "", "", true);
    }

    public static void W(Context context) {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        HBBaseWebActivity.showWebView(context, str + s() + "financial/earnings/h5/", "", "", true);
    }

    public static void X(Context context, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(context, str2 + s() + str, "", "", true);
    }

    public static void Y(Activity activity, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str2 + s() + ("ladder-lending/h5/margin/?hideNav=1&name=" + str), "", "", false);
    }

    public static void Z(Activity activity) {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str + "/" + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/" + "verification/", (String) null, "", false);
    }

    public static void a0(Activity activity) {
        PrimeInfo F = o.B().F();
        if (F != null) {
            String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
            if (!SystemUtils.c()) {
                str = b.f48038b;
            }
            String positionPath = F.getPositionPath();
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                HBBaseWebActivity.showWebView(activity, str + "/zh-cn/" + positionPath, (String) null, "", false);
            } else if (AppLanguageHelper.getInstance().isRussianLanguage()) {
                HBBaseWebActivity.showWebView(activity, str + "/ru-ru/" + positionPath, (String) null, "", false);
            } else if (AppLanguageHelper.getInstance().isKoreaLanguage()) {
                HBBaseWebActivity.showWebView(activity, str + "/ko-kr/" + positionPath, (String) null, "", false);
            } else if (AppLanguageHelper.getInstance().isVietnamLanguage()) {
                HBBaseWebActivity.showWebView(activity, str + "/vi-vi/" + positionPath, (String) null, "", false);
            } else {
                HBBaseWebActivity.showWebView(activity, str + "/en-us/" + positionPath, (String) null, "", false);
            }
        }
    }

    public static void b0(Activity activity) {
        HBBaseWebActivity.showWebView(activity, v0.c("360000298601"), "", activity.getResources().getString(R.string.head_return), false);
    }

    @Deprecated
    public static Intent c(Intent intent, a aVar) {
        if (aVar == null) {
            return intent;
        }
        if (aVar instanceof Serializable) {
            intent.putExtra("target", (Serializable) aVar);
        } else if (aVar instanceof Parcelable) {
            intent.putExtra("target", (Parcelable) aVar);
        }
        return intent;
    }

    public static void c0(Activity activity, String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        HBBaseWebActivity.showWebView(activity, str2 + "/" + AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase() + "/" + "fee/h5/" + "?feeType=" + str + "&hideNav=1", (String) null, "", false);
    }

    @Deprecated
    public static boolean d(Activity activity, a aVar) {
        return c.i().d(activity, aVar);
    }

    public static void d0(Context context) {
        HBBaseWebActivity.showWebView(context, d1.l(), (String) null, (String) null, false);
    }

    @Deprecated
    public static void e(Activity activity, a aVar) {
        if (aVar != null) {
            aVar.show(activity);
        }
    }

    public static Intent e0(Activity activity, String str) {
        String str2;
        String str3 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str3 = b.f48038b;
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = "?loginToken=" + str;
        } else {
            str2 = "";
        }
        return SecurityWebActivity.createIntent(activity, str3 + m6.a.h() + "account/security-reset-h5/" + str2, (String) null);
    }

    public static void f(TradeType tradeType, Context context) {
        Activity activity = (Activity) context;
        boolean z11 = activity != null && (activity instanceof HuobiMainActivity);
        if (TradeType.MARGIN == tradeType) {
            Intent j11 = k0.j(context, z11);
            if (!z11) {
                j11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(j11, j11), false);
        } else if (TradeType.SUPERMARGIN == tradeType) {
            Intent u11 = k0.u(context, z11);
            if (!z11) {
                u11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(u11, u11), false);
        } else if (TradeType.C2C == tradeType) {
            c.i().d(activity, new JumpTarget(k0.B(context), k0.B(context)));
        } else if (TradeType.C2C_LEND == tradeType) {
            c.i().d(activity, new JumpTarget(k0.A(context, ""), k0.A(context, "")));
        } else if (TradeType.CONTRACT == tradeType) {
            Intent d11 = k0.d(context, z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(d11, d11), false);
        } else if (TradeType.SWAP == tradeType) {
            Intent v11 = k0.v(context, z11);
            if (!z11) {
                v11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(v11, v11), false);
        } else if (TradeType.OPTION == tradeType) {
            c.i().e(activity, new JumpTarget(k0.o(context), k0.o(context)), false);
        } else if (TradeType.LINEAR_SWAP == tradeType) {
            Intent i11 = k0.i(context, z11);
            if (!z11) {
                i11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(i11, i11), false);
        } else {
            Intent t11 = k0.t(context, z11);
            if (!z11) {
                t11.addFlags(67108864);
            }
            c.i().e(activity, new JumpTarget(t11, t11), false);
        }
    }

    public static void f0(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        sb2.append(str);
        sb2.append(s());
        sb2.append("finance-beta/analysis/h5/");
        sb2.append("?");
        sb2.append("type=1&");
        sb2.append("refresh=1&");
        sb2.append("color=" + ColorUtils.c(ContextCompat.getColor(context, R.color.finance_web_refresh_color)));
        context.startActivity(HBBaseWebActivity.createIntent(context, sb2.toString(), (String) null));
    }

    public static Intent g(Context context, String str, String str2, ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
        Intent intent = new Intent();
        SymbolBean J = a1.v().J(str, tradeType);
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState()) && !J.isWhiteEnabled()) {
            return null;
        }
        String d11 = g.d(contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), 1);
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", contractCurrencyInfo.getContractShortType());
        intent.putExtra("contractCode", str2);
        intent.putExtra("contractName", d11);
        intent.putExtra("contract_currency_symble", contractCurrencyInfo.getSymbol());
        intent.putExtra("contract_currency_info", contractCurrencyInfo);
        intent.putExtra("market_title", a1.v().X(str, tradeType));
        intent.putExtra("market_trade_type", tradeType.toString());
        return intent;
    }

    public static void g0(Activity activity) {
        HBBaseWebActivity.showWebView(activity, v0.c("360000298561"), "", activity.getResources().getString(R.string.head_return), false);
    }

    public static Intent h(Activity activity) {
        String i11 = gj.b.j().i();
        if (!SystemUtils.c()) {
            i11 = "http://hbg-fed-baymax.test-1.huobiapps.com/#/h5/?sceneCode=77";
        }
        Intent createIntent = CustomServiceWebActivity.createIntent(activity, i11 + "&lang=" + s().replaceAll("/", ""), (String) null);
        k.f("CustomService", i11);
        return createIntent;
    }

    public static void h0(Activity activity, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String string = activity.getString(R.string.lite_index_video_tutorial);
            String str3 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
            if (!SystemUtils.c()) {
                str3 = b.f48038b;
            }
            String str4 = "topic/app/video/?video=" + str;
            AppLanguageHelper.getInstance().getCurAppLocale();
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                HBBaseWebActivity.showWebView(activity, str3 + "/zh-cn/" + str4, string, "", false);
            } else if (AppLanguageHelper.getInstance().isRussianLanguage()) {
                HBBaseWebActivity.showWebView(activity, str3 + "/ru-ru/" + str4, string, "", false);
            } else if (AppLanguageHelper.getInstance().isKoreaLanguage()) {
                HBBaseWebActivity.showWebView(activity, str3 + "/ko-kr/" + str4, string, "", false);
            } else if (AppLanguageHelper.getInstance().isVietnamLanguage()) {
                HBBaseWebActivity.showWebView(activity, str3 + "/vi-vi/" + str4, string, "", false);
            } else if (AppLanguageHelper.getInstance().isFrenchLanguage()) {
                HBBaseWebActivity.showWebView(activity, str3 + "/fr-fr/" + str4, string, "", false);
            } else {
                HBBaseWebActivity.showWebView(activity, str3 + "/en-us/" + str4, string, "", false);
            }
        }
    }

    public static String i() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + EnLang.getInstance().getLanguageUrlPath();
    }

    public static void i0(Context context) {
        StringBuilder sb2 = new StringBuilder();
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        sb2.append(str);
        sb2.append(s());
        sb2.append("finance-beta/security/");
        sb2.append("?");
        sb2.append("refresh=1&");
        sb2.append("color=" + ColorUtils.c(ContextCompat.getColor(context, R.color.finance_web_refresh_color)));
        context.startActivity(HBBaseWebActivity.createIntent(context, sb2.toString(), (String) null));
    }

    public static String j() {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        return str + s();
    }

    public static void j0(Context context) {
        HBBaseWebActivity.showWebView(context, d1.s(), (String) null, (String) null, false);
    }

    public static Intent k(Context context, String str, boolean z11, TradeType tradeType) {
        Intent o11 = o(context, str, true, z11, tradeType);
        o11.putExtra("market_grid", true);
        return o11;
    }

    public static void k0(Context context) {
        HBBaseWebActivity.showWebView(context, d1.r(), (String) null, (String) null, false);
    }

    public static String l(String str) {
        String str2 = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str2 = b.f48038b;
        }
        return str2 + "/support" + s() + "detail/" + str;
    }

    public static Intent m(Context context, IndexCurrencyInfo indexCurrencyInfo, TradeType tradeType) {
        Intent intent = new Intent();
        String f11 = j.f(indexCurrencyInfo.getSymbol(), context);
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", indexCurrencyInfo.getContractCode());
        intent.putExtra("contractCode", indexCurrencyInfo.getContractCode());
        intent.putExtra("contractName", f11);
        intent.putExtra("contract_currency_symble", indexCurrencyInfo.getSymbol());
        intent.putExtra("contract_currency_info", indexCurrencyInfo);
        intent.putExtra("market_title", a1.v().X(indexCurrencyInfo.getSymbol(), TradeType.CONTRACT_INDEX));
        intent.putExtra("market_trade_type", tradeType.toString());
        return intent;
    }

    public static Intent n(Context context, String str, boolean z11, TradeType tradeType) {
        return o(context, str, true, z11, tradeType);
    }

    public static Intent o(Context context, String str, boolean z11, boolean z12, TradeType tradeType) {
        Intent intent = new Intent();
        SymbolBean J = a1.v().J(str, tradeType);
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState()) && !J.isWhiteEnabled() && z12) {
            return null;
        }
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", str);
        String X = a1.v().X(str, tradeType);
        intent.putExtra("market_is_hadax", a1.v().N(X));
        intent.putExtra("market_is_st", a1.v().T(X));
        intent.putExtra("market_title", X);
        intent.putExtra("market_trade_type", tradeType.toString());
        return intent;
    }

    public static Intent p(Context context, String str) {
        return q(context, str, "0");
    }

    public static Intent q(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        Intent intent = new Intent(context, KycAuthInfoActivity.class);
        FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
        flutterKycConfig.setPhone(r.x().F());
        flutterKycConfig.setEmail(r.x().u());
        flutterKycConfig.setAuthBizCode(str);
        flutterKycConfig.setSource(str2);
        intent.putExtra("flag_kyc_config", flutterKycConfig);
        return intent;
    }

    public static Intent r(Activity activity) {
        String k11 = gj.b.j().k();
        if (!SystemUtils.c()) {
            k11 = "http://hbg-fed-baymax.test-1.huobiapps.com/#/h5/?sceneCode=0928";
        }
        Intent createIntent = CustomServiceWebActivity.createIntent(activity, k11 + "&lang=" + s().replaceAll("/", ""), (String) null);
        k.f("KycService", k11);
        return createIntent;
    }

    public static String s() {
        return m6.a.h();
    }

    public static Intent t(Context context, String str, boolean z11, boolean z12, TradeType tradeType) {
        TradeType tradeType2;
        Intent intent = new Intent();
        SymbolBean J = a1.v().J(str, tradeType);
        if (J == null && tradeType != (tradeType2 = TradeType.PRO)) {
            J = a1.v().J(str, tradeType2);
            tradeType = tradeType2;
        }
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState()) && !J.isWhiteEnabled() && z12) {
            return null;
        }
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", str);
        String X = a1.v().X(str, tradeType);
        intent.putExtra("market_is_hadax", a1.v().N(X));
        intent.putExtra("market_is_st", a1.v().T(X));
        intent.putExtra("market_title", X);
        intent.putExtra("market_trade_type", tradeType.toString());
        return intent;
    }

    public static Intent u(Context context, FutureContractInfo futureContractInfo) {
        Intent intent = new Intent();
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", futureContractInfo.getContractShortType());
        intent.putExtra("contractCode", futureContractInfo.getContractCode());
        intent.putExtra("contractName", e.p(context, futureContractInfo.getSymbol(), futureContractInfo.getQuoteCurrency()) + " " + e.e(context, futureContractInfo.getContractType()));
        intent.putExtra("contract_currency_symble", futureContractInfo.getSymbol());
        intent.putExtra("contract_currency_info", futureContractInfo);
        intent.putExtra("market_trade_type", TradeType.LINEAR_SWAP.toString());
        return intent;
    }

    public static Intent v(Activity activity) {
        String str = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w();
        if (!SystemUtils.c()) {
            str = b.f48038b;
        }
        Intent intent = new Intent(activity, FeeRateActivity.class);
        intent.putExtra("url", str + s() + "fee/new-h5/");
        return intent;
    }

    public static Intent w(Context context, FutureContractInfo futureContractInfo) {
        Intent intent = new Intent();
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", futureContractInfo.getOptionCode());
        intent.putExtra("contractCode", futureContractInfo.getContractCode());
        intent.putExtra("optionCode", futureContractInfo.getOptionCode());
        intent.putExtra("contractName", futureContractInfo.getContractShortType());
        intent.putExtra("contract_currency_symble", futureContractInfo.getSymbol());
        intent.putExtra("contract_currency_info", futureContractInfo);
        intent.putExtra("market_trade_type", TradeType.OPTION.toString());
        return intent;
    }

    public static Intent x(Context context, String str, String str2, SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
        Intent intent = new Intent();
        String f11 = j.f(swapCurrencyInfo.getSymbol(), context);
        intent.setClass(context, MarketInfoActivity.class);
        intent.putExtra("symbolId", swapCurrencyInfo.getContractShortType());
        intent.putExtra("contractCode", str2);
        intent.putExtra("contractName", f11);
        intent.putExtra("contract_currency_symble", swapCurrencyInfo.getSymbol());
        intent.putExtra("contract_currency_info", swapCurrencyInfo);
        intent.putExtra("market_title", a1.v().X(str, tradeType));
        intent.putExtra("market_trade_type", tradeType.toString());
        return intent;
    }

    public static void y(Context context, ZopimChat.SessionConfig sessionConfig) {
        if (sessionConfig == null) {
            sessionConfig = HuobiZopimChatActivity.gg();
        }
        if (gj.d.n().A() || p.f(context) || p.c(context)) {
            context.startActivity(ContractCustomerServiceActivity.Xf(context));
        } else {
            HuobiZopimChatActivity.startActivity(context, sessionConfig);
        }
    }

    public static void z(Context context, String str, String str2, ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
        Intent g11 = g(context, str, str2, contractCurrencyInfo, tradeType);
        if (g11 != null) {
            context.startActivity(g11);
        }
    }
}

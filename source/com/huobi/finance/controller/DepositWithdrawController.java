package com.huobi.finance.controller;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.currencyconfig.util.StableCurrencyRateConfigUtil;
import com.huobi.finance.utils.DepositWithdrawHelper;
import d7.k;
import java.util.Locale;
import pro.huobi.R;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class DepositWithdrawController {
    public static boolean j(FragmentActivity fragmentActivity, String str, boolean z11) {
        CurrencyBean s11;
        if (TextUtils.isEmpty(str) || (s11 = k.C().s(str)) == null || !s11.isEtpTag()) {
            return false;
        }
        new DialogUtils.b.d(fragmentActivity).c1(String.format(fragmentActivity.getString(z11 ? R.string.n_balance_deposit_nosupport : R.string.n_balance_withdraw_nosupport), new Object[]{s11.getDisplayName()})).i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).P0(fragmentActivity.getResources().getString(R.string.balance_forbiden_instruction_dialog_ok)).q0(false).Q0(o0.f12469a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        return true;
    }

    public static Observable<CurrencyBean> k(String str) {
        return k.C().n(true, p.b(), "2").map(new g(str)).observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Boolean> l(FragmentActivity fragmentActivity, String str) {
        if (j(fragmentActivity, str, true)) {
            return Observable.just(Boolean.FALSE);
        }
        String f11 = StableCurrencyRateConfigUtil.f();
        if (f11 == null || !f11.equalsIgnoreCase(str)) {
            return k(str).doOnNext(new e(str, fragmentActivity)).map(h.f45424b);
        }
        return Observable.just(Boolean.TRUE);
    }

    public static Observable<Boolean> m(FragmentActivity fragmentActivity, String str) {
        if (j(fragmentActivity, str, false)) {
            return Observable.just(Boolean.FALSE);
        }
        String f11 = StableCurrencyRateConfigUtil.f();
        if (f11 == null || !f11.equalsIgnoreCase(str)) {
            return k(str).doOnNext(new f(str, fragmentActivity)).map(i.f45425b);
        }
        return Observable.just(Boolean.TRUE);
    }

    public static boolean n(int i11, String str, FragmentActivity fragmentActivity, String str2) {
        String str3;
        if (j(fragmentActivity, str2, true)) {
            return false;
        }
        String f11 = StableCurrencyRateConfigUtil.f();
        if (f11 != null && f11.equalsIgnoreCase(str2)) {
            return true;
        }
        if (!((i11 & 2) != 0)) {
            return true;
        }
        String string = fragmentActivity.getResources().getString(R.string.balance_forbiden_recharge_content_txt);
        Object[] objArr = new Object[1];
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2.toUpperCase(Locale.US);
        }
        objArr[0] = str3;
        String format = String.format(string, objArr);
        String string2 = fragmentActivity.getResources().getString(R.string.balance_forbiden_instruction_dialog_ok);
        DialogUtils.b.d dVar = new DialogUtils.b.d(fragmentActivity);
        if (!TextUtils.isEmpty(str)) {
            dVar.c1(str);
        } else {
            dVar.c1(format);
        }
        dVar.i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).P0(string2).q0(false).Q0(c.f45417a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        return false;
    }

    public static boolean o(int i11, String str, FragmentActivity fragmentActivity, String str2) {
        String str3;
        if (j(fragmentActivity, str2, false)) {
            return false;
        }
        String f11 = StableCurrencyRateConfigUtil.f();
        if (f11 != null && f11.equalsIgnoreCase(str2)) {
            return true;
        }
        if (!((i11 & 4) != 0)) {
            return true;
        }
        String string = fragmentActivity.getResources().getString(R.string.balance_forbiden_withdraw_content_txt);
        Object[] objArr = new Object[1];
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2.toUpperCase(Locale.US);
        }
        objArr[0] = str3;
        String format = String.format(string, objArr);
        String string2 = fragmentActivity.getResources().getString(R.string.balance_forbiden_instruction_dialog_ok);
        DialogUtils.b.d dVar = new DialogUtils.b.d(fragmentActivity);
        if (!TextUtils.isEmpty(str)) {
            dVar.c1(str);
        } else {
            dVar.c1(format);
        }
        dVar.i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).P0(string2).q0(false).Q0(d.f45418a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        return false;
    }

    public static /* synthetic */ void q(String str, FragmentActivity fragmentActivity, CurrencyBean currencyBean) {
        if (currencyBean != null && !currencyBean.isDepositEnabled()) {
            ChainInfo c11 = DepositWithdrawHelper.c(currencyBean.getChainInfos());
            if (c11 == null) {
                c11 = new ChainInfo();
                c11.setCurrency(str);
            }
            y(fragmentActivity, c11);
        }
    }

    public static /* synthetic */ Boolean r(CurrencyBean currencyBean) {
        return Boolean.valueOf(currencyBean == null || currencyBean.isDepositEnabled());
    }

    public static /* synthetic */ void s(String str, FragmentActivity fragmentActivity, CurrencyBean currencyBean) {
        if (currencyBean != null && !currencyBean.isWithdrawEnabled()) {
            ChainInfo c11 = DepositWithdrawHelper.c(currencyBean.getChainInfos());
            if (c11 == null) {
                c11 = new ChainInfo();
                c11.setCurrency(str);
            }
            z(fragmentActivity, c11);
        }
    }

    public static /* synthetic */ Boolean t(CurrencyBean currencyBean) {
        return Boolean.valueOf(currencyBean == null || currencyBean.isWithdrawEnabled());
    }

    public static void y(FragmentActivity fragmentActivity, ChainInfo chainInfo) {
        String str;
        if (chainInfo != null) {
            Resources resources = fragmentActivity.getResources();
            String suspendDepositAnnouncement = chainInfo.getSuspendDepositAnnouncement();
            String z11 = k.C().z(chainInfo.getCurrency());
            DialogUtils.b.d S0 = new DialogUtils.b.d(fragmentActivity).c1(String.format(resources.getString(R.string.balance_forbiden_recharge_content_txt), new Object[]{StringUtils.i(z11)})).i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).C0(chainInfo.getSuspendDepositDesc()).S0(Integer.valueOf(resources.getColor(R.color.dialog_confirm_text_color)));
            if (TextUtils.isEmpty(suspendDepositAnnouncement)) {
                str = null;
            } else {
                str = fragmentActivity.getString(R.string.n_exchange_filled_orders_tip_view_detail);
            }
            S0.R0(str).U0(new b(fragmentActivity, suspendDepositAnnouncement)).P0(resources.getString(R.string.balance_forbiden_instruction_dialog_ok)).q0(false).Q0(o0.f12469a).k0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public static void z(FragmentActivity fragmentActivity, ChainInfo chainInfo) {
        String str;
        if (chainInfo != null) {
            Resources resources = fragmentActivity.getResources();
            String suspendWithdrawAnnouncement = chainInfo.getSuspendWithdrawAnnouncement();
            String z11 = k.C().z(chainInfo.getCurrency());
            DialogUtils.b.d S0 = new DialogUtils.b.d(fragmentActivity).c1(String.format(resources.getString(R.string.balance_forbiden_withdraw_content_txt), new Object[]{StringUtils.i(z11)})).i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).C0(chainInfo.getSuspendWithdrawDesc()).S0(Integer.valueOf(resources.getColor(R.color.dialog_confirm_text_color)));
            if (TextUtils.isEmpty(suspendWithdrawAnnouncement)) {
                str = null;
            } else {
                str = fragmentActivity.getString(R.string.n_exchange_filled_orders_tip_view_detail);
            }
            S0.R0(str).U0(new a(fragmentActivity, suspendWithdrawAnnouncement)).P0(resources.getString(R.string.balance_forbiden_instruction_dialog_ok)).q0(false).Q0(o0.f12469a).k0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }
}

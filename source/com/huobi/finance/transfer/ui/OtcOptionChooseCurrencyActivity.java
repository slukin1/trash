package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.common.utils.StringUtils;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import d7.c0;
import d7.q0;
import java.util.List;
import rx.Observable;
import rx.functions.Func2;
import yk.d;

public class OtcOptionChooseCurrencyActivity extends TransferChooseCurrencyActivity<String> {

    public class a implements Func2<String, String, Integer> {
        public a() {
        }

        /* renamed from: a */
        public Integer call(String str, String str2) {
            return Integer.valueOf(Integer.compare(q0.i(StringUtils.g(str2)), q0.i(StringUtils.g(str))));
        }
    }

    public static void Aj(Activity activity, String str, boolean z11) {
        Intent intent = new Intent(activity, OtcOptionChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        intent.putExtra("JUST_SELECT_CURRENCY", z11);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public static void Bj(Activity activity, boolean z11) {
        Aj(activity, (String) null, z11);
    }

    public String getAccount() {
        return "12";
    }

    public Observable<List<String>> sj() {
        return c0.f(true).flatMap(d.f61787b).sorted(new a()).toList();
    }

    /* renamed from: yj */
    public String rj(String str) {
        return str;
    }
}

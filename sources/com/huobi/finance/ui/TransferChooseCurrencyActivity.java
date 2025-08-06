package com.huobi.finance.ui;

import ad.i;
import android.app.Activity;
import android.content.Intent;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.huobi.finance.bean.CurrencySearchEntity;
import com.huobi.finance.bean.CurrencySearchItem;
import com.tencent.android.tpush.common.Constants;
import i6.d;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;

public abstract class TransferChooseCurrencyActivity<T extends Serializable> extends CurrencySearchActivity {

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, T> f46800p = new HashMap();

    public class a extends EasySubscriber<List<CurrencySearchItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f46801b;

        public a(MethodChannel.Result result) {
            this.f46801b = result;
        }

        public void onNext(List<CurrencySearchItem> list) {
            super.onNext(list);
            CurrencySearchEntity currencySearchEntity = new CurrencySearchEntity();
            currencySearchEntity.setList(list);
            currencySearchEntity.setType(3);
            String stringExtra = TransferChooseCurrencyActivity.this.getIntent().getStringExtra("transfer_coin_select");
            if (!StringUtils.p(stringExtra)) {
                currencySearchEntity.setSelectedCurrency(StringUtils.i(stringExtra));
            }
            this.f46801b.success(new Gson().toJson((Object) currencySearchEntity));
        }
    }

    public static void startForResult(Activity activity, Intent intent, int i11) {
        if (activity != null) {
            try {
                activity.startActivityForResult(intent, i11);
            } catch (Exception e11) {
                d.f(activity + "-->start-->", e11);
                e11.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Boolean tj(Serializable serializable) {
        return Boolean.valueOf(serializable != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String uj(Serializable serializable) {
        String rj2 = rj(serializable);
        this.f46800p.put(StringUtils.g(rj2), serializable);
        return rj2;
    }

    public static /* synthetic */ CurrencySearchItem vj(String str) {
        CurrencySearchItem currencySearchItem = new CurrencySearchItem();
        currencySearchItem.setCurrency(str);
        return currencySearchItem;
    }

    public String Nh() {
        return "transfer_coin_list";
    }

    public String Qi(String str) {
        return SP.i(pj(), "");
    }

    public void fj(String str) {
        wj(str);
    }

    public abstract String getAccount();

    public void hj(MethodChannel.Result result) {
        sj().flatMap(i.f3526b).filter(v7.f47364b).map(new u7(this)).map(w7.f47380b).toList().subscribe(new a(result));
    }

    public void ij(String str, String str2) {
        SP.s(pj(), str);
    }

    public void onStop() {
        super.onStop();
        is.a.m("1005382");
    }

    public final String pj() {
        return getClass().getName();
    }

    public T qj(String str) {
        return (Serializable) this.f46800p.get(str);
    }

    public abstract String rj(T t11);

    public abstract Observable<List<T>> sj();

    public void wj(String str) {
        Intent intent = new Intent();
        intent.putExtra("JUST_SELECT_CURRENCY", getIntent().getBooleanExtra("JUST_SELECT_CURRENCY", false));
        intent.putExtra("coin", (Serializable) this.f46800p.get(StringUtils.g(str)));
        intent.putExtra(Constants.FLAG_ACCOUNT, getAccount());
        setResult(-1, intent);
        finish();
    }
}

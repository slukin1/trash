package al;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.OtcOptionDataTotal;
import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.Locale;
import rx.Observable;
import rx.functions.Func1;

public final class b {

    public class a implements Func1<BaseAssetInfo, OtcOptionsDetailInfo> {
        /* renamed from: a */
        public OtcOptionsDetailInfo call(BaseAssetInfo baseAssetInfo) {
            return (OtcOptionsDetailInfo) baseAssetInfo;
        }
    }

    /* renamed from: al.b$b  reason: collision with other inner class name */
    public class C0557b implements Func1<BaseAssetInfo, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40732b;

        public C0557b(String str) {
            this.f40732b = str;
        }

        /* renamed from: a */
        public Boolean call(BaseAssetInfo baseAssetInfo) {
            return Boolean.valueOf(!TextUtils.isEmpty(this.f40732b) && this.f40732b.equalsIgnoreCase(baseAssetInfo.getCurrency()));
        }
    }

    public class c implements Func1<OtcOptionDataTotal, Observable<BaseAssetInfo>> {
        /* renamed from: a */
        public Observable<BaseAssetInfo> call(OtcOptionDataTotal otcOptionDataTotal) {
            return Observable.from(otcOptionDataTotal.getDetailInfos());
        }
    }

    public static String a(Context context, int i11) {
        String str;
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        if (9 == i11) {
            str = context.getResources().getString(R$string.n_balance_savings_tips);
        } else if (10 == i11) {
            str = context.getResources().getString(R$string.n_balance_option_tips);
        } else if (6 == i11) {
            str = context.getResources().getString(R$string.n_balance_swap_tips);
        } else if (11 == i11) {
            str = context.getResources().getString(R$string.n_balance_linear_swap_usdt_tips);
        } else if (15 == i11) {
            str = context.getResources().getString(R$string.n_otc_options_balance_tips);
        } else if (i11 == 0) {
            str = context.getResources().getString(R$string.n_balance_margin_tips);
        } else if (7 == i11) {
            str = context.getResources().getString(R$string.n_balance_c2c_margin_tips);
        } else if (4 == i11) {
            str = context.getResources().getString(R$string.n_balance_super_margin_tips);
        } else if (3 == i11) {
            str = context.getResources().getString(R$string.n_balance_contract_tips);
        } else if (8 == i11) {
            str = context.getResources().getString(R$string.n_balance_c2c_lend_tips);
        } else if (2 == i11) {
            str = context.getResources().getString(R$string.n_balance_legal_tips);
        } else if (5 == i11) {
            str = context.getResources().getString(R$string.n_balance_mine_tips);
        } else if (1 == i11) {
            str = context.getResources().getString(R$string.n_balance_exchange_tips);
        } else {
            str = 16 == i11 ? context.getResources().getString(R$string.n_balance_spot_ybb_total) : "";
        }
        return str.replaceAll("BTC", upperCase);
    }

    public static Observable<OtcOptionsDetailInfo> b(String str) {
        return AssetDataCacheManager.k0().H0().a(false).flatMap(new c()).filter(new C0557b(str)).map(new a());
    }
}

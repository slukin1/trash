package vk;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BasePositionSortAccountItem;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import i6.m;

public class e extends BasePositionSortAccountItem<e> {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f47981b = AssetAccountType.HUOBI_EARN;

    /* renamed from: c  reason: collision with root package name */
    public MiningItem f47982c;

    /* renamed from: d  reason: collision with root package name */
    public String f47983d;

    /* renamed from: e  reason: collision with root package name */
    public String f47984e;

    public e(MiningItem miningItem) {
        o(miningItem);
    }

    /* renamed from: e */
    public int a(int i11, e eVar) {
        int f11 = f(i11, eVar);
        return f11 == 0 ? this.f47982c.getCurrency().compareTo(eVar.f47982c.getCurrency()) : f11;
    }

    public final int f(int i11, e eVar) {
        if (i11 == 2) {
            return m.a(m()).compareTo(m.a(eVar.m()));
        }
        if (i11 == 3) {
            return m.a(this.f47982c.getMiningYearRate()).compareTo(m.a(eVar.f47982c.getMiningYearRate()));
        }
        return m.a(LegalCurrencyConfigUtil.E(this.f47982c.getCurrency(), this.f47982c.getMiningAmount())).compareTo(m.a(LegalCurrencyConfigUtil.E(eVar.f47982c.getCurrency(), eVar.f47982c.getMiningAmount())));
    }

    public String g() {
        return LegalCurrencyConfigUtil.E(this.f47982c.getCurrency(), h());
    }

    public String getViewHandlerName() {
        return AssetPositionEarnItemViewHandler.class.getName();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f47984e)) {
            return "0";
        }
        return this.f47984e;
    }

    public AssetAccountType i() {
        return this.f47981b;
    }

    public MiningItem j() {
        return this.f47982c;
    }

    public String k() {
        return LegalCurrencyConfigUtil.E(this.f47982c.getCurrency(), l());
    }

    public String l() {
        if (TextUtils.isEmpty(this.f47983d)) {
            return "0";
        }
        return this.f47983d;
    }

    public String m() {
        MiningItem miningItem = this.f47982c;
        if (miningItem == null) {
            return "0";
        }
        String currency = miningItem.getCurrency();
        if (this.f47982c.getProjectType() == 0) {
            return LegalCurrencyConfigUtil.E(currency, this.f47982c.getYesterdayIncome());
        }
        return k();
    }

    public void n(String str) {
        this.f47984e = str;
    }

    public void o(MiningItem miningItem) {
        this.f47982c = miningItem;
        p(miningItem.getEstFixedTodayInterest());
        n(miningItem.getConfirmedFixedTotalInterest());
    }

    public void p(String str) {
        this.f47983d = str;
    }
}

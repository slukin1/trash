package com.huobi.finance.ui;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$string;
import com.huobi.coupon.bean.CouponReturn;
import java.util.HashMap;
import java.util.List;

public class r7 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Integer> f47308a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f47309b;

    public r7(Context context) {
        this.f47309b = context;
        HashMap<String, Integer> hashMap = new HashMap<>();
        this.f47308a = hashMap;
        hashMap.put("1", Integer.valueOf(R$string.n_fixing_exchange));
        hashMap.put("2", Integer.valueOf(R$string.n_fixing_margin));
        hashMap.put("3", Integer.valueOf(R$string.n_fixing_super_margin));
        hashMap.put("4", Integer.valueOf(R$string.n_fixing_contract));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, Integer.valueOf(R$string.n_fixing_otc));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, Integer.valueOf(R$string.n_fixing_mine_pool));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, Integer.valueOf(R$string.n_fixing_swap));
        hashMap.put("8", Integer.valueOf(R$string.n_fixing_c2c_lend));
        hashMap.put("9", Integer.valueOf(R$string.n_fixing_c2c_margin));
        hashMap.put(CouponReturn.TYPE_EXPERIENCE, Integer.valueOf(R$string.n_fixing_savings));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, Integer.valueOf(R$string.n_fixing_linear_usdt_swap));
        hashMap.put("12", Integer.valueOf(R$string.n_fixing_option));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT, Integer.valueOf(R$string.n_fixing_out_option));
        hashMap.put("14", Integer.valueOf(R$string.n_fixing_pledge));
        hashMap.put("15", Integer.valueOf(R$string.n_fixing_quantization));
        hashMap.put(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN, Integer.valueOf(R$string.n_fixing_mining));
    }

    public String a(List<BalanceProfitLossData.AccountBalance> list) {
        Integer num;
        StringBuilder sb2 = new StringBuilder(this.f47309b.getString(R$string.n_fixing_leading));
        boolean z11 = true;
        for (BalanceProfitLossData.AccountBalance next : list) {
            boolean isSuccess = next.isSuccess();
            z11 = z11 && isSuccess;
            if (!isSuccess && (num = this.f47308a.get(next.getDistributionType())) != null) {
                sb2.append("\n");
                sb2.append("• ");
                sb2.append(this.f47309b.getString(num.intValue()));
            }
        }
        if (z11) {
            return null;
        }
        return sb2.toString();
    }
}

package com.huobi.asset.feature.summary;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.coupon.bean.CouponReturn;

public enum AssetSummaryAccountType {
    EXCHANGE("1", R$string.n_spot, R$drawable.balances_overview_exchange, AssetAccountType.SPOT),
    CONTRACT("2_0", r12, r13, r1),
    MARGIN("3_0", r18, r19, r3),
    SINGLE_MARGIN("2", R$string.balance_margin_title, -1, r14),
    SUPER_MARGIN("3", R$string.balance_super_margin_title, -1, r14),
    DELIVERY_CONTRACT("4", R$string.n_balance_contract_contract_title, -1, r1),
    OTC(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, R$string.n_blance_fiat_assets, R$drawable.balances_overview_fiat, AssetAccountType.OTC),
    MINE_POOL(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, R$string.mine_toolbar_header_title, R$drawable.balances_overview_pool, AssetAccountType.POOL),
    SWAP(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, R$string.n_balance_contract_swap_title, -1, r1),
    C2C_LEND("8", -1, -1, (int) null),
    C2C_MARGIN("9", R$string.balance_c2c_margin_title, -1, (int) null),
    SAVINGS(CouponReturn.TYPE_EXPERIENCE, R$string.n_balance_detail_savings, -1, (int) null),
    LINEAR_SWAP(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, R$string.n_balance_contract_linear_swap_title, -1, r20),
    OPTION("12", R$string.n_balance_option_contract, -1, r20),
    OUT_OPTION(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT, R$string.n_otc_options, R$drawable.balances_overview_warrant, AssetAccountType.WARRANT),
    PLEDGE("14", R$string.n_asset_mortgage, R$drawable.balances_overview_collateral, AssetAccountType.MORTGAGE),
    QUANTIZATION("15", R$string.n_balance_strategy, R$drawable.balances_overview_quant, AssetAccountType.QUANT),
    HUOBI_EARN(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN, R$string.n_mining_title, R$drawable.balances_overview_huobiearn, AssetAccountType.HUOBI_EARN);
    
    private final int accountDisplayNameRes;
    private final String accountDistributionType;
    private final int accountIconRes;
    private final AssetAccountType assetAccountType;

    private AssetSummaryAccountType(String str, int i11, int i12, AssetAccountType assetAccountType2) {
        this.accountDistributionType = str;
        this.accountDisplayNameRes = i11;
        this.accountIconRes = i12;
        this.assetAccountType = assetAccountType2;
    }

    public static AssetSummaryAccountType get(String str) {
        for (AssetSummaryAccountType assetSummaryAccountType : values()) {
            if (assetSummaryAccountType.getAccountDistributionType().equals(str)) {
                return assetSummaryAccountType;
            }
        }
        return null;
    }

    public int getAccountDisplayNameRes() {
        return this.accountDisplayNameRes;
    }

    public String getAccountDistributionType() {
        return this.accountDistributionType;
    }

    public int getAccountIconRes() {
        return this.accountIconRes;
    }

    public AssetAccountType getAssetAccountType() {
        return this.assetAccountType;
    }
}

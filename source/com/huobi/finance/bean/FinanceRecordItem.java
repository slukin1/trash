package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.finance.viewhandler.CurrencyRecordViewHandler;
import java.io.Serializable;
import s9.a;

public class FinanceRecordItem implements Serializable, a {
    public static final String DIRECTION_IN = "in";
    public static final String DIRECTION_OUT = "out";
    public static final String ETP_SHARES_MERGE_SPOT_TO_SYS = "etp-shares-merge-spot-to-sys";
    public static final String ETP_SHARES_MERGE_SYS_TO_SPOT = "etp-shares-merge-sys-to-spot";
    public static final int LAYOUT_CURRENCY_LABEL = 1;
    public static final String STABLE_CURRENCY_TRANSFER_IN = "stable-currency-transfer-in";
    public static final String STABLE_CURRENCY_TRANSFER_OUT = "stable-currency-transfer-out";
    public static final String STATE_CANCELED = "canceled";
    public static final String STATE_CONFIRMED = "confirmed";
    public static final String STATE_CONFIRMING = "confirming";
    public static final String STATE_CONFIRM_ERROR = "confirm-error";
    public static final String STATE_FAILED = "Failed";
    public static final String STATE_INVALID = "invalid";
    public static final String STATE_LARGE_AMOUNT_EXAMINE = "large-amount-examine";
    public static final String STATE_ORPHAN = "orphan";
    public static final String STATE_ORPHAN_CONFIRMED = "orphan-confirmed";
    public static final String STATE_ORPHAN_CONFIRMING = "orphan-confirming";
    public static final String STATE_ORPHAN_SAFE = "orphan-safe";
    public static final String STATE_PASS = "pass";
    public static final String STATE_PENDING_TINY_AMOUNT = "pending-tiny-amount";
    public static final String STATE_PRE_SUBMITTED = "pre-submitted";
    public static final String STATE_PRE_TRANSFER = "pre-transfer";
    public static final String STATE_REEXAMINE = "reexamine";
    public static final String STATE_REJECT = "reject";
    public static final String STATE_REPEALED = "repealed";
    public static final String STATE_RISK_DELAY = "risk-delay";
    public static final String STATE_ROLLBACK_CONFIRMED = "rollback-confirmed";
    public static final String STATE_ROLLBACK_CONFIRMING = "rollback-confirming";
    public static final String STATE_ROLLBACK_ORPHAN = "rollback-orphan";
    public static final String STATE_ROLLBACK_SAFE = "rollback-safe";
    public static final String STATE_SAFE = "safe";
    public static final String STATE_SUBMITTED = "submitted";
    public static final String STATE_VALID = "valid";
    public static final String STATE_VERIFYING = "Verifying";
    public static final String STATE_WAITING_TINY_AMOUNT = "waiting-tiny-amount";
    public static final String STATE_WALLET_REJECT = "wallet-reject";
    public static final String STATE_WALLET_TRANSFER = "wallet-transfer";
    public static final String TYPE_ACTIVITY = "airdrop-user-spot-oneside-in";
    public static final String TYPE_AIRDROP = "project-airdrop-user-spot-oneside-in";
    public static final String TYPE_BITEXPRO_TO_BITEX = "bitexpro-to-bitex";
    public static final String TYPE_BITEXPRO_TO_OLDHUOBI = "bitexpro-to-oldhuobi";
    public static final String TYPE_BITEX_TO_BITEXPRO = "bitex-to-bitexpro";
    public static final String TYPE_BUY_NFT = "ibox-spot-to-sys-benefit";
    public static final String TYPE_BUY_NFT_FAIL_REFUND = "ibox-sys-benefit-to-spot";
    public static final String TYPE_C2C_MARGIN_BETWEEN_PRO = "spot-to-borrow,borrow-to-spot";
    public static final String TYPE_C2C_MARGIN_TRANSFER_IN = "spot-to-borrow";
    public static final String TYPE_C2C_MARGIN_TRANSFER_OUT = "borrow-to-spot";
    public static final String TYPE_DEPOSIT_VIRTUAL = "deposit-virtual";
    public static final String TYPE_DEPOSIT_VIRTUAL_COMMON_FAST = "deposit-virtual,deposit-virtual-fast,deposit-virtual-mgt-special";
    public static final String TYPE_DEPOSIT_VIRTUAL_FAST = "deposit-virtual-fast";
    public static final String TYPE_DEPOSIT_VIRTUAL_MGT_SPECIAL = "deposit-virtual-mgt-special";
    public static final String TYPE_EARN_SYS_COMMISSION = "earn-sys-commission-to-spot";
    public static final String TYPE_EARN_SYS_RATE = "earn-sys-rate-to-spot";
    public static final String TYPE_ETP_OPERATIONS_TO_SPOT = "etp-operations-to-spot";
    public static final String TYPE_ETP_PEPEL_SYS_TO_USER = "etp-pepel-sys-to-user";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_ACTIVITY_SYSTEM = "finance-project-system-to-activity";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_BRAND_SYSTEM = "finance-project-system-to-brand";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_CHANNEL_SYSTEM = "finance-project-system-to-channel";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_KOL_MARKET_SYSTEM = "finance-project-system-to-kol-market";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_KOL_SYSTEM = "finance-project-system-to-kol";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_MARKET_SYSTEM = "finance-project-system-to-market";
    public static final String TYPE_FINANCE_PROJECT_SYSTEM_TO_RELATIONS_SYSTEM = "finance-project-system-to-relations";
    public static final String TYPE_FORK_TRANSFER_IN = "fork-transfer-in";
    public static final String TYPE_FORK_TRANSFER_OUT = "fork-transfer-out";
    public static final String TYPE_FUND_ORG_TO_FUND_RISE_SYSTEM = "fund-org-to-fund-rise-system";
    public static final String TYPE_FUND_RISE_SYSTEM_TO_FUNDER = "fund-rise-system-to-funder";
    public static final String TYPE_FUND_RISE_SYSTEM_TO_FUND_ORG = "fund-rise-system-to-fund-org";
    public static final String TYPE_FUND_RISE_SYSTEM_TO_INSTITUTION_INVESTOR = "fund-rise-system-to-institution-investor";
    public static final String TYPE_FUND_RISE_SYSTEM_TO_INVESTOR = "fund-rise-system-to-investor";
    public static final String TYPE_FUTURES_TO_PRO = "futures-to-pro";
    public static final String TYPE_FUTURE_BETWEEN_PRO = "futures-to-pro,pro-to-futures";
    public static final String TYPE_FUTURE_LINEAR_SWAP_ALL = "0";
    public static final String TYPE_FUTURE_LINEAR_SWAP_INNER = "39";
    public static final String TYPE_FUTURE_LINEAR_SWAP_TO_PRO = "15";
    public static final String TYPE_FUTURE_PRO_TO_LINEAR_SWAP = "14";
    public static final String TYPE_GLOBAL_ACTIVITY_TO_SPOT = "global-activity-to-spot";
    public static final String TYPE_GLOBAL_FORCE_FROM_SPOT = "global-force-spot-to-system";
    public static final String TYPE_GLOBAL_FORCE_TO_SPOT = "global-force-system-to-spot";
    public static final String TYPE_GLOBAL_MINING_SYSTEM_TO_SPOT = "global-mining-system-to-spot";
    public static final String TYPE_GLOBAL_REBATE_1 = "global-rebate-brokerage-to-spot-brokerage";
    public static final String TYPE_GLOBAL_REBATE_2 = "global-rebate-brokerage-to-spot-cashback";
    public static final String TYPE_GLOBAL_REBATE_3 = "global-rebate-brokerage-to-spot-2nd";
    public static final String TYPE_GLOBAL_REBATE_4 = "api-brokerage-auto-brokerage-to-spot";
    public static final String TYPE_GLOBAL_REBATE_5 = "api-brokerage-futures-auto-brokerage-to-spot";
    public static final String TYPE_GLOBAL_REBATE_6 = "api-brokerage-brokerage-to-spot";
    public static final String TYPE_GLOBAL_REBATE_7 = "api-brokerage-futures-brokerage-to-spot";
    public static final String TYPE_GLOBAL_REBATE_8 = "api-matching-fee-brokerage";
    public static final String TYPE_GLOBAL_REBATE_9 = "futures-brokerage-to-spot";
    public static final String TYPE_GRID_TRANSFER_IN = "grid-transfer-in";
    public static final String TYPE_GRID_TRANSFER_OUT = "grid-transfer-out";
    public static final String TYPE_INSTITUTION_INVESTOR_TO_FUND_RISE_SYSTEM = "institution-investor-to-fund-rise-system";
    public static final String TYPE_INSTITUTION_TO_PRO = "institution-to-pro";
    public static final String TYPE_INVESTOR_TO_FUND_RISE_SYSTEM = "investor-to-fund-rise-system";
    public static final String TYPE_LINEAR_SWAP_BETWEEN_PRO = "linear-swap-to-spot,spot-to-linear-swap";
    public static final String TYPE_LINEAR_SWAP_TO_PRO = "linear-swap-to-spot";
    public static final String TYPE_MARGIN_BETWEEN_PRO = "margin-transfer-in,margin-transfer-out";
    public static final String TYPE_MARGIN_TRANSFER_IN = "margin-transfer-in";
    public static final String TYPE_MARGIN_TRANSFER_OUT = "margin-transfer-out";
    public static final String TYPE_MASTER_TRANSFER_IN = "master-transfer-in";
    public static final String TYPE_MASTER_TRANSFER_OUT = "master-transfer-out";
    public static final String TYPE_MINE_BETWEEN = "mine-pool-transfer-out,mine-pool-transfer-in";
    public static final String TYPE_MINE_IN = "mine-pool-transfer-in";
    public static final String TYPE_MINE_OUT = "mine-pool-transfer-out";
    public static final String TYPE_MINE_POOL_ALL = "mine-pool-transfer-in,mine-pool-transfer-out";
    public static final String TYPE_MINE_POOL_IN = "mine-pool-transfer-in";
    public static final String TYPE_MINE_POOL_OUT = "mine-pool-transfer-out";
    public static final String TYPE_MINING_IN = "pool-savings-ops-to-asset-management-spot";
    public static final String TYPE_MINING_OUT_1 = "pool-savings-asset-management-spot-to-ops";
    public static final String TYPE_MINING_OUT_2 = "pool-savings-asset-management-spot-to-interest";
    public static final String TYPE_MINING_TO_PRO_1 = "pool-savings-expend-to-spot";
    public static final String TYPE_MINING_TO_PRO_2 = "pool-savings-interest-to-spot";
    public static final String TYPE_OLDHUOBI_TO_BITEXPRO = "oldhuobi-to-bitexpro";
    public static final String TYPE_OPTION_BETWEEN_PRO = "option-to-spot,spot-to-option";
    public static final String TYPE_OPTION_TO_PRO = "option-to-spot";
    public static final String TYPE_OTC_BETWEEN_PRO = "otc-to-pro,pro-to-otc";
    public static final String TYPE_OTC_OPTIONS_BETWEEN_PRO = "spot-to-otc-options,otc-options-to-spot";
    public static final String TYPE_OTC_OPTIONS_TO_PRO = "otc-options-to-spot";
    public static final String TYPE_OTC_TO_PRO = "otc-to-pro";
    public static final String TYPE_POINTS_TYPES = "point-purchased-pay,point-purchased-gift,point-transfer-earning,point-transfer-expense";
    public static final String TYPE_POINT_PURCHASED_GIFT = "point-purchased-gift";
    public static final String TYPE_POINT_PURCHASED_PAY = "point-purchased-pay";
    public static final String TYPE_POINT_REFUND = "point-buy-back-system-to-spot";
    public static final String TYPE_POINT_TRANSFER_EARNING = "point-transfer-earning";
    public static final String TYPE_POINT_TRANSFER_EXPENSE = "point-transfer-expense";
    public static final String TYPE_PRO_TO_FUTURES = "pro-to-futures";
    public static final String TYPE_PRO_TO_INSTITUTION = "pro-to-institution";
    public static final String TYPE_PRO_TO_LINEAR_SWAP = "spot-to-linear-swap";
    public static final String TYPE_PRO_TO_MINING = "pool-savings-spot-to-clct";
    public static final String TYPE_PRO_TO_OPTION = "spot-to-option";
    public static final String TYPE_PRO_TO_OTC = "pro-to-otc";
    public static final String TYPE_PRO_TO_OTC_OPTIONS = "spot-to-otc-options";
    public static final String TYPE_PRO_TO_SWAP = "dm-pro-to-swap";
    public static final String TYPE_REBATE_ACCOUNT_TRANSFER_IN = "rebate-account-transfer-in";
    public static final String TYPE_RED_ENVELOPE = "reward-activity-system-to-user";
    public static final String TYPE_SAVINGS_ALL = "spot-to-deposit-earning,deposit-earning-to-spot";
    public static final String TYPE_SAVINGS_TRANSFER_IN = "spot-to-deposit-earning";
    public static final String TYPE_SAVINGS_TRANSFER_OUT = "deposit-earning-to-spot";
    public static final String TYPE_SUB_TRANSFER_IN = "sub-transfer-in";
    public static final String TYPE_SUB_TRANSFER_OUT = "sub-transfer-out";
    public static final String TYPE_SUPPER_MARGIN_BETWEEN = "pro-to-super-margin,super-margin-to-pro";
    public static final String TYPE_SUPPER_MARGIN_IN = "pro-to-super-margin";
    public static final String TYPE_SUPPER_MARGIN_OUT = "super-margin-to-pro";
    public static final String TYPE_SWAP_BETWEEN_PRO = "dm-swap-to-pro,dm-pro-to-swap";
    public static final String TYPE_SWAP_TO_PRO = "dm-swap-to-pro";
    public static final String TYPE_SYSTEM_TYPES = "marketing-account-transfer-in,operations-account-loan-to-user-trade,operations-account-recycling-user-trade-principal,operations-account-expenditure,operations-account-earning,operations-account-deposit-compensate-expenditure,operations-account-withdraw-compensate-expenditure,operations-account-deposit-compensate-earning,operations-account-withdraw-compensate-earning,inspire-account-to-user-trade,user-trade-to-inspire-account,member-enroll,member-renew,member-upgrade,fund-org-to-fund-rise-system,investor-to-fund-rise-system,institution-investor-to-fund-rise-system,fund-rise-system-to-fund-org,fund-rise-system-to-investor,fund-rise-system-to-institution-investor,fund-rise-system-to-funder,airdrop-user-spot-oneside-in,project-airdrop-user-spot-oneside-in,reward-activity-system-to-user,etp-operations-to-spot,global-activity-to-spot,global-mining-system-to-spot,point-buy-back-system-to-spot,global-force-system-to-spot,global-force-spot-to-system,global-rebate-brokerage-to-spot-brokerage,global-rebate-brokerage-to-spot-cashback,global-rebate-brokerage-to-spot-2nd,api-brokerage-auto-brokerage-to-spot,api-brokerage-futures-auto-brokerage-to-spot,api-brokerage-brokerage-to-spot,api-brokerage-futures-brokerage-to-spot,api-matching-fee-brokerage,futures-brokerage-to-spot,global-sys-overseas-activity-to-spot,finance-project-system-to-kol,finance-project-system-to-kol-market,finance-project-system-to-channel,finance-project-system-to-market,finance-project-system-to-brand,finance-project-system-to-relations,finance-project-system-to-activity,global-spot-to-sys-overseas-activity,global-coupon-system-to-spot";
    public static final String TYPE_SYS_COUPON_YSTEM_TO_SPOT = "global-coupon-system-to-spot";
    public static final String TYPE_SYS_OVERSEAS_ACTIVITY_TO_SPOT = "global-sys-overseas-activity-to-spot";
    public static final String TYPE_SYS_SPOT_TO_OVERSEAS = "global-spot-to-sys-overseas-activity";
    public static final String TYPE_TRANSFER_IN_TYPES = "bitex-to-bitexpro,oldhuobi-to-bitexpro,fork-transfer-out,rebate-account-transfer-in,otc-to-pro,margin-transfer-out,master-transfer-in,futures-to-pro,super-margin-to-pro,dm-swap-to-pro,option-to-spot,deposit-earning-to-spot,linear-swap-to-spot,pool-savings-expend-to-spot,pool-savings-interest-to-spot,pool-savings-ops-to-asset-management-spot,grid-transfer-out,earn-sys-rate-to-spot,earn-sys-commission-to-spot";
    public static final String TYPE_TRANSFER_OUT_TYPES = "bitexpro-to-bitex,bitexpro-to-oldhuobi,fork-transfer-in,pro-to-otc,margin-transfer-in,master-transfer-out,pro-to-futures,pro-to-super-margin,dm-pro-to-swap,spot-to-option,spot-to-deposit-earning,spot-to-linear-swap,pool-savings-spot-to-clct,pool-savings-asset-management-spot-to-ops,pool-savings-asset-management-spot-to-interest,grid-transfer-in";
    public static final String TYPE_USER_TO_ETP_PEPEL_SYS = "user-to-etp-pepel-sys";
    public static final String TYPE_WITHDRAW_VIRTUAL = "withdraw-virtual";
    public static final String TYPE_WITHDRAW_VIRTUAL_COMMON_FAST = "withdraw-virtual,withdraw-virtual-fast";
    public static final String TYPE_WITHDRAW_VIRTUAL_FAST = "withdraw-virtual-fast";
    private static final long serialVersionUID = -7680531614198279091L;
    private String amount;
    private String chain;
    @SerializedName("created-at")
    private long createdAt;
    private String currency;
    private String direction;
    @SerializedName("error-code")
    private String errorCode;
    @SerializedName("error-msg")
    private String errorMsg;
    private String fees;

    /* renamed from: id  reason: collision with root package name */
    private long f45355id;
    private int layoutType;
    private String state;
    @SerializedName("to-addr-tag")
    private String toAddrTag;
    @SerializedName("to-address")
    private String toAddress;
    private TradeType tradeType = TradeType.PRO;
    @SerializedName("transaction-id")
    private long transactionId;
    @SerializedName("tx-hash")
    private String txHash;
    private String type;
    @SerializedName("updated-at")
    private long updatedAt;

    public String getAmount() {
        return this.amount;
    }

    public String getChain() {
        return this.chain;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getFees() {
        return this.fees;
    }

    public long getId() {
        return this.f45355id;
    }

    public int getLayoutType() {
        return this.layoutType;
    }

    public String getState() {
        return this.state;
    }

    public String getToAddrTag() {
        return this.toAddrTag;
    }

    public String getToAddress() {
        return this.toAddress;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public long getTransactionId() {
        return this.transactionId;
    }

    public String getTxHash() {
        return this.txHash;
    }

    public String getType() {
        return this.type;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getViewHandlerName() {
        return CurrencyRecordViewHandler.class.getName();
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setFees(String str) {
        this.fees = str;
    }

    public void setId(long j11) {
        this.f45355id = j11;
    }

    public void setLayoutType(int i11) {
        this.layoutType = i11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setToAddrTag(String str) {
        this.toAddrTag = str;
    }

    public void setToAddress(String str) {
        this.toAddress = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public void setTransactionId(long j11) {
        this.transactionId = j11;
    }

    public void setTxHash(String str) {
        this.txHash = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }
}

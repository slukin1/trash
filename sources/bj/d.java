package bj;

import com.hbg.lib.contract.R$string;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractPriceInfo;
import com.huobi.contract.helper.ContractAccountConfigImpl;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f40783a = new ContractAccountConfigImpl();

    public static void a() {
        f40783a.b();
    }

    public static Observable<List<ContractAccountInfo>> b(Map<String, Object> map) {
        return f40783a.d(map);
    }

    public static Observable<List<ContractAccountInfo>> c(boolean z11) {
        return f40783a.k(z11);
    }

    public static ContractHeartBeat d() {
        return f40783a.c();
    }

    public static long e() {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        return c11.getTime();
    }

    public static int f(int i11) {
        switch (i11) {
            case 1:
                return R$string.currency_detail_contract_status_open;
            case 2:
                return R$string.currency_detail_contract_status_flat;
            case 3:
                return R$string.currency_detail_contract_status_force_flat;
            case 4:
                return R$string.currency_detail_contract_status_settle;
            case 5:
                return R$string.currency_detail_transfer_out;
            case 6:
                return R$string.currency_detail_transfer_in;
            case 7:
                return R$string.currency_detail_contract_status_fee;
            case 8:
                return R$string.currency_detail_contract_status_reward;
            default:
                return R$string.currency_detail_system;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        return 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return 6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int g(int r1) {
        /*
            r0 = 28
            if (r1 == r0) goto L_0x001f
            r0 = 29
            if (r1 == r0) goto L_0x001f
            switch(r1) {
                case 1: goto L_0x001d;
                case 2: goto L_0x001d;
                case 3: goto L_0x001b;
                case 4: goto L_0x001b;
                case 5: goto L_0x0019;
                case 6: goto L_0x0019;
                case 7: goto L_0x0019;
                case 8: goto L_0x0019;
                case 9: goto L_0x0017;
                case 10: goto L_0x0017;
                case 11: goto L_0x0019;
                case 12: goto L_0x0015;
                case 13: goto L_0x0015;
                case 14: goto L_0x0013;
                case 15: goto L_0x0011;
                case 16: goto L_0x0017;
                case 17: goto L_0x0017;
                case 18: goto L_0x0017;
                case 19: goto L_0x0017;
                default: goto L_0x000b;
            }
        L_0x000b:
            switch(r1) {
                case 34: goto L_0x0011;
                case 35: goto L_0x0013;
                case 36: goto L_0x0011;
                case 37: goto L_0x0013;
                default: goto L_0x000e;
            }
        L_0x000e:
            r1 = 9
            goto L_0x0021
        L_0x0011:
            r1 = 5
            goto L_0x0021
        L_0x0013:
            r1 = 6
            goto L_0x0021
        L_0x0015:
            r1 = 3
            goto L_0x0021
        L_0x0017:
            r1 = 4
            goto L_0x0021
        L_0x0019:
            r1 = 7
            goto L_0x0021
        L_0x001b:
            r1 = 2
            goto L_0x0021
        L_0x001d:
            r1 = 1
            goto L_0x0021
        L_0x001f:
            r1 = 8
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bj.d.g(int):int");
    }

    public static long h() {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        return c11.getLinearSwapEstimatedRecoveryTime();
    }

    public static String i(int i11) {
        switch (i11) {
            case 1:
                return String.format("%s,%s", new Object[]{1, 2});
            case 2:
                return String.format("%s,%s", new Object[]{3, 4});
            case 3:
                return String.format("%s,%s", new Object[]{12, 13});
            case 4:
                return String.format("%s,%s,%s,%s,%s,%s", new Object[]{9, 10, 18, 17, 16, 19});
            case 5:
                return String.format("%s,%s,%s", new Object[]{15, 34, 36});
            case 6:
                return String.format("%s,%s,%s", new Object[]{14, 35, 37});
            case 7:
                return String.format("%s,%s,%s,%s,%s", new Object[]{5, 6, 7, 8, 11});
            case 8:
                return String.format("%s,%s", new Object[]{28, 29});
            case 9:
                return String.format("%s,%s,%s,%s,%s,%s", new Object[]{20, 21, 22, 23, 26, 27});
            default:
                return String.valueOf(20);
        }
    }

    public static long j() {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        return c11.getOptionEstimatedRecoveryTime();
    }

    public static String k(int i11) {
        switch (i11) {
            case 1:
                return String.format("%s,%s", new Object[]{1, 2});
            case 2:
                return String.format("%s,%s", new Object[]{3, 4});
            case 3:
                return String.format("%s,%s", new Object[]{12, 13});
            case 4:
                return String.format("%s,%s,%s,%s,%s,%s", new Object[]{9, 10, 18, 17, 16, 19});
            case 5:
                return String.format("%s,%s,%s", new Object[]{15, 34, 36});
            case 6:
                return String.format("%s,%s,%s", new Object[]{14, 35, 37});
            case 7:
                return String.format("%s,%s,%s,%s,%s", new Object[]{5, 6, 7, 8, 11});
            case 8:
                return String.format("%s,%s", new Object[]{28, 29});
            case 9:
                return String.format("%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{20, 21, 22, 23, 24, 25, 26, 27});
            default:
                return String.valueOf(20);
        }
    }

    public static Observable<List<ContractPriceInfo>> l(boolean z11) {
        return f40783a.l(z11);
    }

    public static long m(int i11) {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        if (i11 == 6) {
            return c11.getSwapEstimatedRecoveryTime();
        }
        if (i11 == 10) {
            return c11.getOptionEstimatedRecoveryTime();
        }
        if (i11 != 11) {
            return c11.getTime();
        }
        return c11.getLinearSwapEstimatedRecoveryTime();
    }

    public static long n(TradeType tradeType) {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        if (tradeType == TradeType.OPTION) {
            return c11.getOptionEstimatedRecoveryTime();
        }
        if (tradeType == TradeType.SWAP) {
            return c11.getSwapEstimatedRecoveryTime();
        }
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        if (tradeType == tradeType2) {
            return c11.getLinearSwapEstimatedRecoveryTime();
        }
        if (tradeType == TradeType.CONTRACT) {
            return c11.getTime();
        }
        if (tradeType == tradeType2) {
            return c11.getLinearSwapEstimatedRecoveryTime();
        }
        return c11.getTime();
    }

    public static long o() {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return 0;
        }
        return c11.getSwapEstimatedRecoveryTime();
    }

    public static Observable<ContractHeartBeat> p() {
        return f40783a.a();
    }

    public static int q(int i11) {
        return r(i11, 3);
    }

    public static int r(int i11, int i12) {
        switch (i11) {
            case 1:
                return R$string.currency_detail_contract_status_open_more;
            case 2:
                return R$string.currency_detail_contract_status_open_low;
            case 3:
                return R$string.currency_detail_contract_status_flat_more;
            case 4:
                return R$string.currency_detail_contract_status_flat_low;
            case 5:
                return R$string.currency_detail_contract_status_fee_open_taker;
            case 6:
                return R$string.currency_detail_contract_status_fee_open_maker;
            case 7:
                return R$string.currency_detail_contract_status_fee_flat_taker;
            case 8:
                return R$string.currency_detail_contract_status_fee_flat_maker;
            case 9:
                return R$string.currency_detail_contract_status_settle_flat_more;
            case 10:
                return R$string.currency_detail_contract_status_settle_flat_low;
            case 11:
                return R$string.currency_detail_contract_status_fee_settle;
            case 12:
                return R$string.currency_detail_contract_status_force_flat_more;
            case 13:
                return R$string.currency_detail_contract_status_force_flat_low;
            case 14:
                if (10 == i12) {
                    return R$string.n_balance_pro_to_option;
                }
                return R$string.n_balance_pro_to_contract;
            case 15:
                if (10 == i12) {
                    return R$string.n_balance_option_to_pro;
                }
                return R$string.n_balance_contract_to_pro;
            case 16:
                return R$string.currency_detail_contract_status_settle_flat_profit_unrea_more;
            case 17:
                return R$string.currency_detail_contract_status_settle_flat_profit_unrea_low;
            case 18:
                return R$string.currency_detail_contract_status_settle_flat_profit_rea;
            case 19:
                return R$string.currency_detail_contract_status_settle_flat_pass_avg;
            case 20:
                return R$string.currency_detail_contract_status_flat_sys;
            case 21:
                return R$string.currency_detail_contract_status_loan_to_manager;
            case 22:
                return R$string.currency_detail_contract_status_manager_to_loan;
            case 23:
                return R$string.currency_detail_contract_status_fee_to_manager;
            case 24:
                return R$string.currency_detail_contract_status_inject_force;
            case 25:
                return R$string.currency_detail_contract_status_from_force;
            case 26:
                return R$string.currency_detail_contract_status_user_gain;
            case 27:
                return R$string.currency_detail_contract_status_punish;
            case 28:
                return R$string.currency_detail_contract_status_reward_act;
            case 29:
                return R$string.currency_detail_contract_status_return;
            case 34:
                return R$string.currency_detail_transfer_to_sub_account;
            case 35:
                return R$string.currency_detail_transfer_from_sub_account;
            case 36:
                return R$string.currency_detail_transfer_to_parent_account;
            case 37:
                return R$string.currency_detail_transfer_from_parent_account;
            default:
                return R$string.currency_detail_system;
        }
    }

    public static boolean s() {
        ContractHeartBeat c11 = f40783a.c();
        return c11 != null && c11.isSysSafeguard();
    }

    public static boolean t() {
        ContractHeartBeat c11 = f40783a.c();
        return c11 != null && c11.isLinearSwapSafeguard();
    }

    @Deprecated
    public static boolean u() {
        ContractHeartBeat c11 = f40783a.c();
        return c11 != null && c11.isSafeguard();
    }

    public static boolean v(int i11) {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return false;
        }
        if (i11 == 6) {
            return c11.isSwapSafeguard();
        }
        if (i11 == 10) {
            return c11.isOptionSafeguard();
        }
        if (i11 != 11) {
            return c11.isSysSafeguard();
        }
        return c11.isLinearSwapSafeguard();
    }

    public static boolean w(TradeType tradeType) {
        ContractHeartBeat c11 = f40783a.c();
        if (c11 == null) {
            return false;
        }
        if (tradeType == TradeType.OPTION) {
            return c11.isOptionSafeguard();
        }
        if (tradeType == TradeType.SWAP) {
            return c11.isSwapSafeguard();
        }
        if (tradeType == TradeType.LINEAR_SWAP) {
            return c11.isLinearSwapSafeguard();
        }
        if (tradeType == TradeType.CONTRACT) {
            return c11.isSysSafeguard();
        }
        return c11.isSysSafeguard();
    }

    public static boolean x() {
        ContractHeartBeat c11 = f40783a.c();
        return c11 != null && c11.isSwapSafeguard();
    }
}

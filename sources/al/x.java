package al;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.finance.bean.FinanceRecordItem;
import com.xiaomi.mipush.sdk.Constants;
import pro.huobi.R;

public final class x {
    public static String a(String str, String str2, TradeType tradeType, Context context) {
        boolean z11;
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        str.hashCode();
        char c11 = 65535;
        int i11 = 0;
        boolean z12 = true;
        switch (str.hashCode()) {
            case -2016699684:
                if (str.equals(FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1655215789:
                if (str.equals(FinanceRecordItem.TYPE_BUY_NFT_FAIL_REFUND)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1425513535:
                if (str.equals(FinanceRecordItem.TYPE_WITHDRAW_VIRTUAL_FAST)) {
                    c11 = 2;
                    break;
                }
                break;
            case -478623571:
                if (str.equals(FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL_FAST)) {
                    c11 = 3;
                    break;
                }
                break;
            case -53128555:
                if (str.equals(FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL_MGT_SPECIAL)) {
                    c11 = 4;
                    break;
                }
                break;
            case 482632520:
                if (str.equals(FinanceRecordItem.TYPE_WITHDRAW_VIRTUAL)) {
                    c11 = 5;
                    break;
                }
                break;
            case 961513413:
                if (str.equals(FinanceRecordItem.TYPE_POINT_TRANSFER_EARNING)) {
                    c11 = 6;
                    break;
                }
                break;
            case 968552854:
                if (str.equals(FinanceRecordItem.STABLE_CURRENCY_TRANSFER_OUT)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1152528151:
                if (str.equals(FinanceRecordItem.TYPE_POINT_PURCHASED_GIFT)) {
                    c11 = 8;
                    break;
                }
                break;
            case 1416716765:
                if (str.equals(FinanceRecordItem.STABLE_CURRENCY_TRANSFER_IN)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1422660065:
                if (str.equals(FinanceRecordItem.TYPE_POINT_PURCHASED_PAY)) {
                    c11 = 10;
                    break;
                }
                break;
            case 1551416293:
                if (str.equals(FinanceRecordItem.TYPE_BUY_NFT)) {
                    c11 = 11;
                    break;
                }
                break;
            case 1617873683:
                if (str.equals(FinanceRecordItem.TYPE_POINT_TRANSFER_EXPENSE)) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 4:
                str3 = context.getString(R.string.currency_detail_deposit_common);
                break;
            case 1:
                str3 = context.getString(R.string.n_cloud_wallet_ibox_to_spot);
                break;
            case 2:
                str3 = context.getString(R.string.currency_detail_withdraw_fast);
                break;
            case 3:
                str3 = context.getString(R.string.currency_detail_deposit_fast);
                break;
            case 5:
                str3 = context.getString(R.string.currency_detail_withdraw_common);
                break;
            case 6:
            case 8:
            case 10:
            case 12:
                str3 = context.getString(R.string.currency_detail_points);
                break;
            case 7:
                str3 = context.getString(R.string.currency_detail_stable_currency_transfer_out);
                break;
            case 9:
                str3 = context.getString(R.string.currency_detail_stable_currency_transfer_in);
                break;
            case 11:
                str3 = context.getString(R.string.n_cloud_wallet_spot_to_ibox);
                break;
            default:
                z11 = false;
                break;
        }
        z11 = true;
        if (!z11) {
            String[] split = FinanceRecordItem.TYPE_SYSTEM_TYPES.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            while (true) {
                if (i11 < length) {
                    if (split[i11].equals(str)) {
                        str3 = context.getString(R.string.currency_detail_system);
                    } else {
                        i11++;
                    }
                }
            }
        }
        z12 = z11;
        if (z12) {
            return str3;
        }
        if ("in".equalsIgnoreCase(str2)) {
            if (tradeType == TradeType.PRO) {
                return context.getString(R.string.currency_detail_transfer_in);
            }
            return context.getString(R.string.currency_detail_transfer_out);
        } else if (!"out".equalsIgnoreCase(str2)) {
            return context.getString(R.string.n_other);
        } else {
            if (tradeType == TradeType.PRO) {
                return context.getString(R.string.currency_detail_transfer_out);
            }
            return context.getString(R.string.currency_detail_transfer_in);
        }
    }
}

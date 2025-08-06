package a7;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CoinStringUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.R$color;
import com.hbg.lib.data.R$string;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.xiaomi.mipush.sdk.Constants;
import rx.Observable;

public final class e {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68394a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f68394a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f68394a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a7.e.a.<clinit>():void");
        }
    }

    public static SpannableStringBuilder A(String str, String str2, Context context, int i11, String str3) {
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtils.isEmpty(str2) || !str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return new SpannableStringBuilder();
        }
        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        try {
            String str4 = split[2];
            if (str4.length() >= 4) {
                str4 = str4.substring(str4.length() - 4);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(str4);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(split[4]);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(sb2.toString());
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(i11), 0, sb2.length(), 33);
            spannableStringBuilder2.append(y(split[3], context));
            if (OptionDirection.BUY.direction.equalsIgnoreCase(str3)) {
                spannableStringBuilder = new SpannableStringBuilder("·" + context.getString(R$string.contarct_position_more));
                if (w.l()) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
                }
            } else {
                spannableStringBuilder = new SpannableStringBuilder("·" + context.getString(R$string.contarct_position_empty));
                if (w.l()) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
                }
            }
            spannableStringBuilder2.append(spannableStringBuilder);
            return spannableStringBuilder2;
        } catch (Exception unused) {
            return new SpannableStringBuilder();
        }
    }

    public static String B(TradeType tradeType, Context context) {
        return context.getString(R$string.n_contract_service_in_maintain_market);
    }

    public static String C(Context context, String str, boolean z11, boolean z12) {
        if (TextUtils.isEmpty(str) || !str.equals("open")) {
            if (TextUtils.isEmpty(str) || !str.equals(LinearSwapCurrentOrderInfo.ORDER_OFFSET_SINGLE_SIDE)) {
                if (z12) {
                    return context.getString(R$string.currency_detail_contract_status_force_delivry);
                }
                if (z11) {
                    return context.getString(R$string.n_contract_trade_close_low);
                }
                return context.getString(R$string.n_contract_trade_close_more);
            } else if (z11) {
                return context.getString(R$string.n_spot_order_buy);
            } else {
                return context.getString(R$string.n_spot_order_sell);
            }
        } else if (z11) {
            return context.getString(R$string.n_contract_trade_open_more);
        } else {
            return context.getString(R$string.n_contract_trade_open_low);
        }
    }

    public static int D() {
        return R$string.two_label_with_space_with_abount;
    }

    public static boolean E(TradeType tradeType) {
        return CoinStringUtil.c(tradeType);
    }

    public static boolean F(TradeType tradeType) {
        if (tradeType == TradeType.LINEAR_SWAP) {
            return true;
        }
        return CoinStringUtil.c(tradeType);
    }

    public static boolean G(TradeType tradeType) {
        return CoinStringUtil.d(tradeType);
    }

    public static boolean H(TradeType tradeType) {
        return CoinStringUtil.e(tradeType);
    }

    public static /* synthetic */ Integer I(TradeType tradeType, Integer num) {
        if (num != null) {
            if (num.intValue() == 1) {
                M(0, tradeType);
            } else if (num.intValue() == 2) {
                M(1, tradeType);
            } else if (num.intValue() == 3) {
                M(2, tradeType);
            } else if (num.intValue() == 4) {
                M(3, tradeType);
            }
        }
        return num;
    }

    public static Observable<Integer> K(TradeType tradeType) {
        d9.a<Integer> aVar;
        int i11 = a.f68394a[tradeType.ordinal()];
        if (i11 == 1) {
            aVar = l9.a.a().queryTradeUnit();
        } else if (i11 != 2) {
            aVar = q7.a.a().queryTradeUnit();
        } else {
            aVar = h8.a.a().queryTradeUnit();
        }
        return aVar.b().map(new d(tradeType));
    }

    public static Observable<Object> L(int i11, TradeType tradeType) {
        d9.a<Object> aVar;
        String str = i11 == 2 ? "3" : i11 == 1 ? "2" : i11 == 3 ? "4" : "1";
        int i12 = a.f68394a[tradeType.ordinal()];
        if (i12 == 1) {
            aVar = l9.a.a().n(str);
        } else if (i12 != 2) {
            aVar = q7.a.a().n(str);
        } else {
            aVar = h8.a.a().n(str);
        }
        return aVar.b().map(new c(i11, tradeType));
    }

    public static void M(int i11, TradeType tradeType) {
        CoinStringUtil.f(i11, tradeType);
    }

    public static String c(TradeType tradeType) {
        return E(tradeType) ? "symbol" : "usdt";
    }

    public static String d(Context context, String str, String str2, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(l(context, str, str2));
        stringBuffer.append("·");
        stringBuffer.append(w(context, i11));
        return stringBuffer.toString();
    }

    public static String e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase("this_week")) {
            return context.getString(R$string.n_market_contract_symbol_thisweek);
        }
        if (str.equalsIgnoreCase("next_week")) {
            return context.getString(R$string.n_market_contract_symbol_nextweek);
        }
        if (str.equalsIgnoreCase("quarter")) {
            return context.getString(R$string.n_market_contract_symbol_quarter);
        }
        if (str.equalsIgnoreCase("next_quarter")) {
            return context.getString(R$string.n_market_contract_trade_next_quarter);
        }
        return context.getString(R$string.n_market_contract_swap_trade_name);
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_swap_trade_name);
        }
        if (str.contains("CW")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek);
        }
        if (str.contains("NW")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek);
        }
        if (str.contains("CQ")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter);
        }
        return str.contains("NQ") ? BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter) : "";
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_swap_trade_name_abbr);
        }
        if (str.contains("CW")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek_abbr);
        }
        if (str.contains("NW")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek_abbr);
        }
        if (str.contains("CQ")) {
            return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter_abbr);
        }
        return str.contains("NQ") ? BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter_abbr) : "";
    }

    public static String h(String str, String str2) {
        if (str == null || str2 == null || str2.length() < 5) {
            return "";
        }
        return i(str) + str2.substring(4);
    }

    public static String i(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("this_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek);
            }
            if ("next_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek);
            }
            if ("quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter);
            }
            if ("next_quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter);
            }
        }
        return "";
    }

    public static SpannableStringBuilder j(Context context, String str, int i11, String str2, String str3, boolean z11, boolean z12, int i12, String str4, String str5) {
        SpannableStringBuilder spannableStringBuilder;
        String u11 = u(context, str, str2, str4, str5);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(u11 + "·");
        if (i11 == 2) {
            spannableStringBuilder = new SpannableStringBuilder(context.getString(R$string.n_contract_trade_margin));
        } else {
            spannableStringBuilder = new SpannableStringBuilder(context.getString(R$string.n_contract_super_margin));
        }
        spannableStringBuilder2.append(spannableStringBuilder).append(" ");
        String C = C(context, str3, z11, z12);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorPrimaryText)), 0, spannableStringBuilder2.length(), 33);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(i12 + "X·" + C);
        if (z11) {
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, w.h())), 0, spannableStringBuilder3.length(), 33);
        } else {
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, w.d())), 0, spannableStringBuilder3.length(), 33);
        }
        spannableStringBuilder2.append(spannableStringBuilder3);
        return spannableStringBuilder2;
    }

    public static SpannableStringBuilder k(Context context, String str, String str2, String str3, String str4, int i11, int i12, String str5) {
        String str6;
        SpannableStringBuilder spannableStringBuilder;
        String t11 = t(context, str, str2, str5);
        if (i12 == 1) {
            str6 = context.getResources().getString(R$string.n_contract_super_margin);
        } else {
            str6 = context.getResources().getString(R$string.n_contract_trade_margin);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t11);
        sb2.append("·");
        sb2.append(str6);
        sb2.append(" ");
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(sb2.toString());
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(i11), 0, sb2.length(), 33);
        if (OptionDirection.BUY.direction.equalsIgnoreCase(str3)) {
            spannableStringBuilder = new SpannableStringBuilder(str4 + "X·" + context.getString(R$string.contarct_position_more));
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder(str4 + "X·" + context.getString(R$string.contarct_position_empty));
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            }
        }
        spannableStringBuilder2.append(spannableStringBuilder);
        return spannableStringBuilder2;
    }

    @Deprecated
    public static String l(Context context, String str, String str2) {
        return String.format(context.getString(R$string.n_linear_swap_trade_name), new Object[]{str, str2});
    }

    public static String m(Context context, String str, String str2, String str3, String str4, int i11) {
        String o11 = o(context, str, str2, str3, str4);
        if (i11 == 2) {
            return o11 + "·" + context.getString(R$string.n_contract_trade_margin);
        }
        return o11 + "·" + context.getString(R$string.n_contract_super_margin);
    }

    public static String n(Context context, String str) {
        return String.format(context.getString(R$string.n_contract_swap_trade_name), new Object[]{str});
    }

    public static String o(Context context, String str, String str2, String str3, String str4) {
        if (AppLanguageHelper.getInstance().isHkChineseLanguage() || AppLanguageHelper.getInstance().isChineseLanguage()) {
            return p(context, str, str2) + q(context, str3, str4);
        }
        return p(context, str, str2) + " " + q(context, str3, str4);
    }

    public static String p(Context context, String str, String str2) {
        return str + str2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r6.equals("next_quarter") == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String q(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 4
            if (r1 != 0) goto L_0x001c
            int r1 = r5.length()
            if (r1 <= r2) goto L_0x001c
            int r1 = r5.length()
            int r1 = r1 - r2
            java.lang.String r5 = r5.substring(r1)
            goto L_0x001e
        L_0x001c:
            java.lang.String r5 = ""
        L_0x001e:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x00a6
            r6.hashCode()
            r1 = -1
            int r3 = r6.hashCode()
            switch(r3) {
                case -560300811: goto L_0x005b;
                case 3543443: goto L_0x0050;
                case 651403948: goto L_0x0045;
                case 1217310144: goto L_0x003a;
                case 1902260576: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r2 = r1
            goto L_0x0065
        L_0x0031:
            java.lang.String r3 = "next_quarter"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0065
            goto L_0x002f
        L_0x003a:
            java.lang.String r2 = "next_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0043
            goto L_0x002f
        L_0x0043:
            r2 = 3
            goto L_0x0065
        L_0x0045:
            java.lang.String r2 = "quarter"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x004e
            goto L_0x002f
        L_0x004e:
            r2 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r2 = "swap"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0059
            goto L_0x002f
        L_0x0059:
            r2 = 1
            goto L_0x0065
        L_0x005b:
            java.lang.String r2 = "this_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0064
            goto L_0x002f
        L_0x0064:
            r2 = 0
        L_0x0065:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0090;
                case 2: goto L_0x0083;
                case 3: goto L_0x0076;
                case 4: goto L_0x0069;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x00a6
        L_0x0069:
            int r6 = com.hbg.lib.data.R$string.n_market_contract_trade_next_quarter
            java.lang.String r4 = r4.getString(r6)
            r0.append(r4)
            r0.append(r5)
            goto L_0x00a6
        L_0x0076:
            int r6 = com.hbg.lib.data.R$string.n_market_contract_symbol_nextweek
            java.lang.String r4 = r4.getString(r6)
            r0.append(r4)
            r0.append(r5)
            goto L_0x00a6
        L_0x0083:
            int r6 = com.hbg.lib.data.R$string.n_market_contract_symbol_quarter
            java.lang.String r4 = r4.getString(r6)
            r0.append(r4)
            r0.append(r5)
            goto L_0x00a6
        L_0x0090:
            int r5 = com.hbg.lib.data.R$string.n_market_contract_swap_trade_name
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x00a6
        L_0x009a:
            int r6 = com.hbg.lib.data.R$string.n_market_contract_symbol_thisweek
            java.lang.String r4 = r4.getString(r6)
            r0.append(r4)
            r0.append(r5)
        L_0x00a6:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.e.q(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r6.equals("next_quarter") == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String r(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 4
            if (r1 != 0) goto L_0x001c
            int r1 = r5.length()
            if (r1 <= r2) goto L_0x001c
            int r1 = r5.length()
            int r1 = r1 - r2
            java.lang.String r5 = r5.substring(r1)
            goto L_0x001e
        L_0x001c:
            java.lang.String r5 = ""
        L_0x001e:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x00a6
            r6.hashCode()
            r1 = -1
            int r3 = r6.hashCode()
            switch(r3) {
                case -560300811: goto L_0x005b;
                case 3543443: goto L_0x0050;
                case 651403948: goto L_0x0045;
                case 1217310144: goto L_0x003a;
                case 1902260576: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r2 = r1
            goto L_0x0065
        L_0x0031:
            java.lang.String r3 = "next_quarter"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0065
            goto L_0x002f
        L_0x003a:
            java.lang.String r2 = "next_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0043
            goto L_0x002f
        L_0x0043:
            r2 = 3
            goto L_0x0065
        L_0x0045:
            java.lang.String r2 = "quarter"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x004e
            goto L_0x002f
        L_0x004e:
            r2 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r2 = "swap"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0059
            goto L_0x002f
        L_0x0059:
            r2 = 1
            goto L_0x0065
        L_0x005b:
            java.lang.String r2 = "this_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0064
            goto L_0x002f
        L_0x0064:
            r2 = 0
        L_0x0065:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0090;
                case 2: goto L_0x0083;
                case 3: goto L_0x0076;
                case 4: goto L_0x0069;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x00a6
        L_0x0069:
            r0.append(r5)
            int r5 = com.hbg.lib.data.R$string.n_market_contract_trade_next_quarter_abbr
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x00a6
        L_0x0076:
            r0.append(r5)
            int r5 = com.hbg.lib.data.R$string.n_market_contract_symbol_nextweek_abbr
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x00a6
        L_0x0083:
            r0.append(r5)
            int r5 = com.hbg.lib.data.R$string.n_market_contract_symbol_quarter_abbr
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x00a6
        L_0x0090:
            int r5 = com.hbg.lib.data.R$string.n_market_contract_swap_trade_name_abbr
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x00a6
        L_0x009a:
            r0.append(r5)
            int r5 = com.hbg.lib.data.R$string.n_market_contract_symbol_thisweek_abbr
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
        L_0x00a6:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.e.r(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r6.equals("next_quarter") == false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String s(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 4
            if (r1 != 0) goto L_0x001c
            int r1 = r5.length()
            if (r1 <= r2) goto L_0x001c
            int r1 = r5.length()
            int r1 = r1 - r2
            java.lang.String r5 = r5.substring(r1)
            goto L_0x001e
        L_0x001c:
            java.lang.String r5 = ""
        L_0x001e:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0076
            r6.hashCode()
            r1 = -1
            int r3 = r6.hashCode()
            switch(r3) {
                case -560300811: goto L_0x005b;
                case 3543443: goto L_0x0050;
                case 651403948: goto L_0x0045;
                case 1217310144: goto L_0x003a;
                case 1902260576: goto L_0x0031;
                default: goto L_0x002f;
            }
        L_0x002f:
            r2 = r1
            goto L_0x0065
        L_0x0031:
            java.lang.String r3 = "next_quarter"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0065
            goto L_0x002f
        L_0x003a:
            java.lang.String r2 = "next_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0043
            goto L_0x002f
        L_0x0043:
            r2 = 3
            goto L_0x0065
        L_0x0045:
            java.lang.String r2 = "quarter"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x004e
            goto L_0x002f
        L_0x004e:
            r2 = 2
            goto L_0x0065
        L_0x0050:
            java.lang.String r2 = "swap"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0059
            goto L_0x002f
        L_0x0059:
            r2 = 1
            goto L_0x0065
        L_0x005b:
            java.lang.String r2 = "this_week"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0064
            goto L_0x002f
        L_0x0064:
            r2 = 0
        L_0x0065:
            switch(r2) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0069;
                case 2: goto L_0x0073;
                case 3: goto L_0x0073;
                case 4: goto L_0x0073;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x0076
        L_0x0069:
            int r5 = com.hbg.lib.data.R$string.n_market_contract_swap_trade_name
            java.lang.String r4 = r4.getString(r5)
            r0.append(r4)
            goto L_0x0076
        L_0x0073:
            r0.append(r5)
        L_0x0076:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.e.s(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String t(Context context, String str, String str2, String str3) {
        if (AppLanguageHelper.getInstance().isHkChineseLanguage() || AppLanguageHelper.getInstance().isChineseLanguage()) {
            return p(context, str, str2) + e(context, str3);
        }
        return p(context, str, str2) + " " + e(context, str3);
    }

    public static String u(Context context, String str, String str2, String str3, String str4) {
        if (AppLanguageHelper.getInstance().isHkChineseLanguage() || AppLanguageHelper.getInstance().isChineseLanguage()) {
            return p(context, str, str2) + s(context, str3, str4);
        }
        return p(context, str, str2) + " " + s(context, str3, str4);
    }

    public static String v(Context context, String str, String str2, String str3, String str4) {
        return p(context, str, str2) + " " + q(context, str3, str4);
    }

    public static String w(Context context, int i11) {
        if (i11 == 1) {
            return context.getResources().getString(R$string.n_contract_super_margin);
        }
        return context.getResources().getString(R$string.n_contract_trade_margin);
    }

    public static String x(TradeType tradeType, Context context) {
        if (tradeType == TradeType.OPTION) {
            return context.getString(R$string.n_option_open);
        }
        if (tradeType == TradeType.CONTRACT) {
            return context.getString(R$string.n_contract_open_future);
        }
        if (tradeType == TradeType.SWAP) {
            return context.getString(R$string.n_contract_open_swap);
        }
        if (tradeType == TradeType.LINEAR_SWAP) {
            return context.getString(R$string.n_linear_swap_open_usdt_title);
        }
        return context.getString(R$string.n_contract_open_future);
    }

    public static SpannableStringBuilder y(String str, Context context) {
        if (w.l()) {
            if ("C".equalsIgnoreCase(str)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(R$string.n_option_right_c));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_down_color)), 0, spannableStringBuilder.length(), 33);
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(context.getString(R$string.n_option_right_p));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_up_color)), 0, spannableStringBuilder2.length(), 33);
            return spannableStringBuilder2;
        } else if ("C".equalsIgnoreCase(str)) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(context.getString(R$string.n_option_right_c));
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_up_color)), 0, spannableStringBuilder3.length(), 33);
            return spannableStringBuilder3;
        } else {
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(context.getString(R$string.n_option_right_p));
            spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_down_color)), 0, spannableStringBuilder4.length(), 33);
            return spannableStringBuilder4;
        }
    }

    public static SpannableStringBuilder z(String str, String str2, Context context, int i11) {
        if (TextUtils.isEmpty(str2) || !str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return new SpannableStringBuilder();
        }
        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        try {
            String str3 = split[2];
            if (str3.length() >= 4) {
                str3 = str3.substring(str3.length() - 4);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(str3);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(split[4]);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb2.toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i11), 0, sb2.length(), 33);
            spannableStringBuilder.append(y(split[3], context));
            return spannableStringBuilder;
        } catch (Exception unused) {
            return new SpannableStringBuilder();
        }
    }
}

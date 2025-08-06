package al;

import android.content.Context;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import hh.f;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uh.c;

public final class a {

    /* renamed from: al.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0556a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40731a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huobi.asset.feature.summary.AssetSummaryAccountType[] r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40731a = r0
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.DELIVERY_CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40731a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40731a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40731a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.OPTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: al.a.C0556a.<clinit>():void");
        }
    }

    public static List<BalanceProfitLossData.AccountBalance> a(List<BalanceProfitLossData.AccountBalance> list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            for (BalanceProfitLossData.AccountBalance next : list) {
                List<BalanceProfitLossData.AccountBalance> accountBalances = next.getAccountBalances();
                if (!CollectionsUtils.b(accountBalances)) {
                    List<BalanceProfitLossData.AccountBalance> a11 = a(accountBalances);
                    if (!CollectionsUtils.b(a11)) {
                        next.setAccountBalances(a11);
                        arrayList.add(next);
                    }
                } else if (!l(next) || j(next) || k(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public static List<BalanceProfitLossData.AccountBalance> b(List<BalanceProfitLossData.AccountBalance> list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtils.b(list)) {
            List<f.a<?>> f11 = f.h().f();
            if (CollectionsUtils.b(f11)) {
                arrayList.addAll(list);
            } else {
                for (BalanceProfitLossData.AccountBalance next : list) {
                    if (m(f11, next)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    public static BalanceProfitLossData.AccountBalance c(Context context, List<BalanceProfitLossData.AccountBalance> list, AssetSummaryAccountType assetSummaryAccountType) {
        for (BalanceProfitLossData.AccountBalance next : list) {
            if (assetSummaryAccountType.getAccountDistributionType().equals(next.getDistributionType())) {
                next.setDistributionName(context.getResources().getString(assetSummaryAccountType.getAccountDisplayNameRes()));
                next.setDistributionIconRes(assetSummaryAccountType.getAccountIconRes());
                return next;
            }
        }
        return null;
    }

    public static AssetAccountType d(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
            case 53:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC)) {
                    c11 = 4;
                    break;
                }
                break;
            case 54:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                    c11 = 5;
                    break;
                }
                break;
            case 55:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                    c11 = 6;
                    break;
                }
                break;
            case 1568:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                    c11 = 7;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1570:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
                    c11 = 9;
                    break;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1572:
                if (str.equals("15")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1573:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN)) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return AssetAccountType.SPOT;
            case 1:
            case 2:
                return AssetAccountType.MARGIN;
            case 3:
            case 6:
            case 7:
            case 8:
                return AssetAccountType.FUTURE;
            case 4:
                return AssetAccountType.OTC;
            case 5:
                return AssetAccountType.POOL;
            case 9:
                return AssetAccountType.WARRANT;
            case 10:
                return AssetAccountType.MORTGAGE;
            case 11:
                return AssetAccountType.QUANT;
            case 12:
                return AssetAccountType.HUOBI_EARN;
            default:
                return null;
        }
    }

    public static List<BalanceProfitLossData.AccountBalance> e(Context context, BalanceProfitLossData balanceProfitLossData) {
        return b(g(context, balanceProfitLossData));
    }

    public static List<BalanceProfitLossData.AccountBalance> f(Context context, List<BalanceProfitLossData.AccountBalance> list) {
        c b11 = c.b();
        ArrayList arrayList = new ArrayList();
        BalanceProfitLossData.AccountBalance c11 = c(context, list, AssetSummaryAccountType.LINEAR_SWAP);
        if (c11 != null) {
            c11.setOpened(b11.h());
            arrayList.add(c11);
        }
        BalanceProfitLossData.AccountBalance c12 = c(context, list, AssetSummaryAccountType.DELIVERY_CONTRACT);
        if (c12 != null) {
            c12.setOpened(b11.d());
            arrayList.add(c12);
        }
        BalanceProfitLossData.AccountBalance c13 = c(context, list, AssetSummaryAccountType.SWAP);
        if (c13 != null) {
            c13.setOpened(b11.k());
            arrayList.add(c13);
        }
        BalanceProfitLossData.AccountBalance c14 = c(context, list, AssetSummaryAccountType.OPTION);
        if (c14 != null) {
            c14.setOpened(b11.f());
            arrayList.add(c14);
        }
        return arrayList;
    }

    public static List<BalanceProfitLossData.AccountBalance> g(Context context, BalanceProfitLossData balanceProfitLossData) {
        List<BalanceProfitLossData.AccountBalance> profitAccountBalanceList = balanceProfitLossData.getProfitAccountBalanceList();
        ArrayList arrayList = new ArrayList();
        BalanceProfitLossData.AccountBalance c11 = c(context, profitAccountBalanceList, AssetSummaryAccountType.EXCHANGE);
        if (c11 != null) {
            arrayList.add(c11);
        }
        BalanceProfitLossData.AccountBalance accountBalance = new BalanceProfitLossData.AccountBalance();
        AssetSummaryAccountType assetSummaryAccountType = AssetSummaryAccountType.CONTRACT;
        accountBalance.setDistributionType(assetSummaryAccountType.getAccountDistributionType());
        accountBalance.setDistributionName(context.getResources().getString(assetSummaryAccountType.getAccountDisplayNameRes()));
        accountBalance.setDistributionIconRes(assetSummaryAccountType.getAccountIconRes());
        List<BalanceProfitLossData.AccountBalance> f11 = f(context, profitAccountBalanceList);
        boolean z11 = false;
        Iterator<BalanceProfitLossData.AccountBalance> it2 = f11.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().isOpened()) {
                    z11 = true;
                    break;
                }
            } else {
                break;
            }
        }
        accountBalance.setAccountBalances(f11);
        accountBalance.setAccountBalance(i(accountBalance));
        accountBalance.setOpened(z11);
        arrayList.add(accountBalance);
        BalanceProfitLossData.AccountBalance accountBalance2 = new BalanceProfitLossData.AccountBalance();
        AssetSummaryAccountType assetSummaryAccountType2 = AssetSummaryAccountType.MARGIN;
        accountBalance2.setDistributionType(assetSummaryAccountType2.getAccountDistributionType());
        accountBalance2.setDistributionName(context.getResources().getString(assetSummaryAccountType2.getAccountDisplayNameRes()));
        accountBalance2.setDistributionIconRes(assetSummaryAccountType2.getAccountIconRes());
        accountBalance2.setAccountBalances(h(context, profitAccountBalanceList));
        accountBalance2.setAccountBalance(i(accountBalance2));
        arrayList.add(accountBalance2);
        BalanceProfitLossData.AccountBalance c12 = c(context, profitAccountBalanceList, AssetSummaryAccountType.OTC);
        if (c12 != null) {
            arrayList.add(c12);
        }
        BalanceProfitLossData.AccountBalance c13 = c(context, profitAccountBalanceList, AssetSummaryAccountType.HUOBI_EARN);
        if (c13 != null) {
            arrayList.add(c13);
        }
        BalanceProfitLossData.AccountBalance c14 = c(context, profitAccountBalanceList, AssetSummaryAccountType.QUANTIZATION);
        if (c14 != null) {
            arrayList.add(c14);
        }
        BalanceProfitLossData.AccountBalance c15 = c(context, profitAccountBalanceList, AssetSummaryAccountType.MINE_POOL);
        if (c15 != null) {
            arrayList.add(c15);
        }
        BalanceProfitLossData.AccountBalance c16 = c(context, profitAccountBalanceList, AssetSummaryAccountType.OUT_OPTION);
        if (c16 != null) {
            arrayList.add(c16);
        }
        BalanceProfitLossData.AccountBalance c17 = c(context, profitAccountBalanceList, AssetSummaryAccountType.PLEDGE);
        if (c17 != null) {
            arrayList.add(c17);
        }
        return arrayList;
    }

    public static List<BalanceProfitLossData.AccountBalance> h(Context context, List<BalanceProfitLossData.AccountBalance> list) {
        ArrayList arrayList = new ArrayList();
        BalanceProfitLossData.AccountBalance c11 = c(context, list, AssetSummaryAccountType.SUPER_MARGIN);
        if (c11 != null) {
            arrayList.add(c11);
        }
        BalanceProfitLossData.AccountBalance c12 = c(context, list, AssetSummaryAccountType.SINGLE_MARGIN);
        if (c12 != null) {
            arrayList.add(c12);
        }
        return arrayList;
    }

    public static String i(BalanceProfitLossData.AccountBalance accountBalance) {
        if (accountBalance == null) {
            return null;
        }
        List<BalanceProfitLossData.AccountBalance> accountBalances = accountBalance.getAccountBalances();
        if (CollectionsUtils.b(accountBalances)) {
            return accountBalance.getAccountBalance();
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (BalanceProfitLossData.AccountBalance next : accountBalances) {
            if (next != null) {
                bigDecimal = bigDecimal.add(m.a(next.getAccountBalance()));
            }
        }
        return bigDecimal.toString();
    }

    public static boolean j(BalanceProfitLossData.AccountBalance accountBalance) {
        if (!(AssetSummaryAccountType.get(accountBalance.getDistributionType()) == AssetSummaryAccountType.CONTRACT)) {
            return false;
        }
        List<BalanceProfitLossData.AccountBalance> accountBalances = accountBalance.getAccountBalances();
        if (!CollectionsUtils.b(accountBalances)) {
            for (BalanceProfitLossData.AccountBalance k11 : accountBalances) {
                if (k(k11)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean k(BalanceProfitLossData.AccountBalance accountBalance) {
        if (accountBalance == null) {
            return false;
        }
        c b11 = c.b();
        AssetSummaryAccountType assetSummaryAccountType = AssetSummaryAccountType.get(accountBalance.getDistributionType());
        if (assetSummaryAccountType == null) {
            return false;
        }
        int i11 = C0556a.f40731a[assetSummaryAccountType.ordinal()];
        if (i11 == 1) {
            return b11.e();
        }
        if (i11 == 2) {
            return b11.j();
        }
        if (i11 == 3) {
            return b11.g();
        }
        if (i11 != 4) {
            return false;
        }
        return b11.i();
    }

    public static boolean l(BalanceProfitLossData.AccountBalance accountBalance) {
        if (accountBalance == null) {
            return true;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(accountBalance.getAccountBalance());
            if (bigDecimal.compareTo(wi.a.f48036a) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return true;
        }
    }

    public static boolean m(List<f.a<?>> list, BalanceProfitLossData.AccountBalance accountBalance) {
        AssetSummaryAccountType assetSummaryAccountType;
        if (CollectionsUtils.b(list) || accountBalance == null || (assetSummaryAccountType = AssetSummaryAccountType.get(accountBalance.getDistributionType())) == null) {
            return false;
        }
        AssetAccountType assetAccountType = assetSummaryAccountType.getAssetAccountType();
        for (f.a<?> d11 : list) {
            if (d11.d() == assetAccountType) {
                return true;
            }
        }
        return false;
    }

    public static boolean n() {
        List<f.a<?>> f11 = f.h().f();
        if (CollectionsUtils.b(f11)) {
            return false;
        }
        for (f.a next : f11) {
            if (next != null && next.d() == AssetAccountType.HUOBI_EARN) {
                return true;
            }
        }
        return false;
    }
}

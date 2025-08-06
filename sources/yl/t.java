package yl;

import android.content.Context;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.RankLabelBean;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.presenter.g;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static RankScreenBean f76857a = null;

    /* renamed from: b  reason: collision with root package name */
    public static RankScreenBean f76858b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f76859c = false;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, String> f76860d = new HashMap<>();

    public interface a {
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RankScreenBean f76861a;

        public b(RankScreenBean rankScreenBean) {
            this.f76861a = rankScreenBean;
        }

        public boolean a(Object obj) {
            return obj instanceof b;
        }

        public RankScreenBean b() {
            return this.f76861a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a(this)) {
                return false;
            }
            RankScreenBean b11 = b();
            RankScreenBean b12 = bVar.b();
            return b11 != null ? b11.equals(b12) : b12 == null;
        }

        public int hashCode() {
            RankScreenBean b11 = b();
            return 59 + (b11 == null ? 43 : b11.hashCode());
        }

        public String toString() {
            return "RankListHelper.RankFilterChangedEvent(rankScreenBean=" + b() + ")";
        }
    }

    static {
        String i11 = SP.i("index_rank_list_filter_bean", (String) null);
        d.j("RankListHelper", "init json=" + i11);
    }

    public static List<RankDynamicItem> a(Context context, List<g.b> list) {
        ArrayList arrayList = new ArrayList();
        for (g.b next : list) {
            RankDynamicItem rankDynamicItem = new RankDynamicItem();
            rankDynamicItem.v(true);
            rankDynamicItem.u(true);
            rankDynamicItem.o(next);
            rankDynamicItem.n(next.getTitle());
            rankDynamicItem.r(next.a());
            rankDynamicItem.q(next.d(context));
            String str = next.e() + "";
            String Q = m.Q(str, PrecisionUtil.v((String) null), 1);
            if (m.a(str).compareTo(BigDecimal.ZERO) > 0) {
                Q = "+" + Q;
            }
            rankDynamicItem.p(Q);
            arrayList.add(rankDynamicItem);
        }
        return arrayList;
    }

    public static List<RankListItemBean> b(boolean z11, int i11, RankList rankList) {
        List<RankListItemBean> list;
        if (rankList.isScreen()) {
            List<RankScreenBean> screenListObject = rankList.getScreenListObject();
            if (screenListObject != null && screenListObject.size() > 0) {
                if (f76857a == null) {
                    g(screenListObject);
                } else {
                    s(screenListObject);
                }
                Map<String, List<RankListItemBean>> multipleMap = rankList.getMultipleMap();
                if (multipleMap != null) {
                    list = multipleMap.get((z11 ? screenListObject.get(i11) : f76857a).getScreenValue());
                }
            }
            list = null;
        } else {
            list = rankList.getSingleList();
        }
        return list == null ? new ArrayList() : list;
    }

    public static List<RankListItemBean> c(RankList rankList, String str) {
        Map<String, List<RankListItemBean>> multipleMap = rankList.getMultipleMap();
        List<RankListItemBean> list = multipleMap != null ? multipleMap.get(str) : null;
        return list == null ? new ArrayList() : list;
    }

    public static List<RankDynamicItem> d(RankList rankList) {
        List<RankListItemBean> c11 = c(rankList, "untradeable");
        List list = rankList.getTitleMap() == null ? null : rankList.getTitleMap().get("untradeable");
        if (list == null || list.size() != 3) {
            return new ArrayList();
        }
        return f(true, rankList.getType(), rankList.isScreen(), list, c11);
    }

    public static List<RankDynamicItem> e(boolean z11, int i11, RankList rankList, a aVar) {
        List<RankListItemBean> list;
        List<RankLabelBean> list2;
        if (rankList.getType() == 4) {
            list = c(rankList, "tradeable");
            list2 = rankList.getTitleMap() == null ? null : rankList.getTitleMap().get("tradeable");
            if (list2 != null) {
                rankList.setTitle(list2);
            }
        } else if (rankList.getType() == 9) {
            List<RankListItemBean> b11 = b(z11, i11, rankList);
            if (rankList.getTitle() == null) {
                if (rankList.getScreenListObject() == null || rankList.getScreenListObject().size() <= i11) {
                    rankList.setTitle(rankList.getTitleMap().get(rankList.getTitleMap().keySet().toArray()[0]));
                } else {
                    rankList.setTitle(rankList.getTitleMap().get(rankList.getScreenListObject().get(i11).getScreenValue()));
                }
            }
            list = b11;
            list2 = rankList.getTitle();
        } else {
            list = b(z11, i11, rankList);
            list2 = rankList.getTitle();
        }
        if (list2 == null || list2.size() != 3) {
            return new ArrayList();
        }
        if (n(rankList) || k(rankList) || rankList.getType() == 7 || rankList.getType() == 8) {
            return f(false, rankList.getType(), rankList.isScreen(), list2, list);
        }
        return f(true, rankList.getType(), rankList.isScreen(), list2, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.huobi.index.bean.RankDynamicItem> f(boolean r16, int r17, boolean r18, java.util.List<com.hbg.lib.network.hbg.core.bean.RankLabelBean> r19, java.util.List<com.hbg.lib.network.hbg.core.bean.RankListItemBean> r20) {
        /*
            r0 = r17
            r1 = r19
            r2 = 0
            java.lang.Object r3 = r1.get(r2)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r3 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r3
            int r3 = r3.getTitleProperty()
            r4 = 1
            java.lang.Object r5 = r1.get(r4)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r5 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r5
            int r5 = r5.getTitleProperty()
            r6 = 2
            java.lang.Object r1 = r1.get(r6)
            com.hbg.lib.network.hbg.core.bean.RankLabelBean r1 = (com.hbg.lib.network.hbg.core.bean.RankLabelBean) r1
            int r1 = r1.getTitleProperty()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r20 != 0) goto L_0x002d
            return r7
        L_0x002d:
            java.util.Iterator r8 = r20.iterator()
        L_0x0031:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01af
            java.lang.Object r9 = r8.next()
            com.hbg.lib.network.hbg.core.bean.RankListItemBean r9 = (com.hbg.lib.network.hbg.core.bean.RankListItemBean) r9
            com.huobi.index.bean.RankDynamicItem r10 = new com.huobi.index.bean.RankDynamicItem
            r10.<init>()
            r10.s(r9)
            r10.x(r0)
            r11 = r18
            r10.t(r11)
            r12 = 9
            if (r3 != r4) goto L_0x0065
            d7.k r13 = d7.k.C()
            java.lang.String r14 = r9.getCurrency()
            java.lang.String r13 = r13.z(r14)
            r10.n(r13)
            r10.v(r2)
            goto L_0x00e9
        L_0x0065:
            java.lang.String r13 = "/"
            if (r16 == 0) goto L_0x00bd
            d7.a1 r14 = d7.a1.v()
            java.lang.String r15 = r9.getSymbol()
            com.hbg.lib.data.symbol.TradeType r2 = com.hbg.lib.data.symbol.TradeType.PRO
            com.hbg.lib.network.pro.core.bean.SymbolBean r2 = r14.J(r15, r2)
            if (r0 == r12) goto L_0x008f
            if (r2 == 0) goto L_0x008d
            java.lang.String r14 = "hiddenup"
            boolean r14 = r2.hasTag(r14)
            if (r14 != 0) goto L_0x008d
            java.lang.String r2 = r2.getSymbol()
            boolean r2 = yl.m.a(r2)
            if (r2 == 0) goto L_0x008f
        L_0x008d:
            r2 = 0
            goto L_0x0031
        L_0x008f:
            d7.a1 r2 = d7.a1.v()
            java.lang.String r14 = r9.getSymbol()
            java.lang.String r2 = r2.p(r14)
            r10.n(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            d7.a1 r13 = d7.a1.v()
            java.lang.String r14 = r9.getSymbol()
            java.lang.String r13 = r13.F(r14)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r10.r(r2)
            goto L_0x00e6
        L_0x00bd:
            java.lang.String r2 = r9.getBaseCurrency()
            r10.n(r2)
            int r2 = r9.getContractBusinessType()
            if (r2 != r6) goto L_0x00e1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            java.lang.String r13 = r9.getQuoteCurrency()
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r10.r(r2)
            goto L_0x00e6
        L_0x00e1:
            java.lang.String r2 = ""
            r10.r(r2)
        L_0x00e6:
            r10.v(r4)
        L_0x00e9:
            java.lang.String r2 = r9.getTagUrl()
            r10.w(r2)
            r2 = 3
            java.lang.String r13 = "--"
            if (r5 != r2) goto L_0x0117
            java.lang.String r2 = r9.getPrice()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0103
            r10.q(r13)
            goto L_0x0134
        L_0x0103:
            java.lang.String r2 = r9.getPrice()
            java.lang.String r14 = r9.getSymbol()
            int r14 = com.hbg.lib.data.symbol.PrecisionUtil.x(r14)
            java.lang.String r2 = i6.m.m(r2, r14)
            r10.q(r2)
            goto L_0x0134
        L_0x0117:
            java.lang.String r2 = r9.getPrice()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0125
            r10.q(r13)
            goto L_0x0134
        L_0x0125:
            java.lang.String r2 = r9.getPrice()
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.B(r2)
            java.lang.String r2 = i6.m.c(r2, r2)
            r10.q(r2)
        L_0x0134:
            r2 = 5
            if (r1 == r2) goto L_0x016c
            r2 = 7
            if (r0 == r2) goto L_0x016c
            r2 = 8
            if (r0 == r2) goto L_0x016c
            if (r0 != r12) goto L_0x0141
            goto L_0x016c
        L_0x0141:
            r2 = 0
            r10.u(r2)
            java.lang.String r2 = r9.getVolume()
            java.lang.String r2 = com.huobi.currencyconfig.util.LegalCurrencyConfigUtil.B(r2)
            com.hbg.lib.core.util.AppLanguageHelper r9 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            boolean r9 = r9.isChineseLanguage()
            if (r9 == 0) goto L_0x015c
            java.lang.String r2 = i6.m.g(r2)
            goto L_0x0160
        L_0x015c:
            java.lang.String r2 = i6.m.X(r2)
        L_0x0160:
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 == 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r13 = r2
        L_0x0168:
            r10.p(r13)
            goto L_0x01aa
        L_0x016c:
            r10.u(r4)
            java.lang.String r2 = r9.getUpAndDown()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x017d
            r10.p(r13)
            goto L_0x01aa
        L_0x017d:
            r2 = 0
            int r2 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r9 = r9.getUpAndDown()
            java.lang.String r2 = i6.m.Q(r9, r2, r4)
            java.math.BigDecimal r9 = i6.m.a(r9)
            java.math.BigDecimal r12 = java.math.BigDecimal.ZERO
            int r9 = r9.compareTo(r12)
            if (r9 <= 0) goto L_0x01a7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "+"
            r9.append(r12)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
        L_0x01a7:
            r10.p(r2)
        L_0x01aa:
            r7.add(r10)
            goto L_0x008d
        L_0x01af:
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x01c4
            r0 = 10
            int r1 = r7.size()
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            java.util.List r7 = r7.subList(r1, r0)
        L_0x01c4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: yl.t.f(boolean, int, boolean, java.util.List, java.util.List):java.util.List");
    }

    public static void g(List<RankScreenBean> list) {
        RankScreenBean rankScreenBean = f76858b;
        if (!(rankScreenBean == null || rankScreenBean.getScreenValue() == null)) {
            for (RankScreenBean next : list) {
                if (f76858b.getScreenValue().equals(next.getScreenValue())) {
                    f76857a = next;
                    return;
                }
            }
        }
        o(list.get(0));
    }

    public static RankScreenBean h() {
        return f76857a;
    }

    public static boolean i() {
        return f76859c;
    }

    public static String j(String str) {
        String h11 = m.h(LegalCurrencyConfigUtil.B(str), AppLanguageHelper.getInstance().isChineseLanguage());
        return h11.isEmpty() ? "--" : h11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = f76857a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(com.hbg.lib.network.hbg.core.bean.RankList r1) {
        /*
            boolean r1 = r1.isScreen()
            if (r1 == 0) goto L_0x0018
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r1 = f76857a
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r1.getScreenValue()
            java.lang.String r0 = "future"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: yl.t.k(com.hbg.lib.network.hbg.core.bean.RankList):boolean");
    }

    public static boolean l(int i11, String str) {
        return RankScreenBean.SCREEN_VALUE_SYMBOL_SWAP.equals(str);
    }

    public static boolean m(int i11, String str) {
        return RankScreenBean.SCREEN_VALUE_USDT_SWAP.equals(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = f76857a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean n(com.hbg.lib.network.hbg.core.bean.RankList r1) {
        /*
            boolean r1 = r1.isScreen()
            if (r1 == 0) goto L_0x0026
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r1 = f76857a
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = r1.getScreenValue()
            java.lang.String r0 = "usdtSwap"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0024
            com.hbg.lib.network.hbg.core.bean.RankScreenBean r1 = f76857a
            java.lang.String r1 = r1.getScreenValue()
            java.lang.String r0 = "symbolSwap"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0026
        L_0x0024:
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: yl.t.n(com.hbg.lib.network.hbg.core.bean.RankList):boolean");
    }

    public static void o(RankScreenBean rankScreenBean) {
        f76857a = rankScreenBean;
        EventBus.d().k(new b(rankScreenBean));
        SP.s("index_rank_list_filter_bean", new Gson().toJson((Object) rankScreenBean));
    }

    public static void p(boolean z11) {
        f76859c = z11;
    }

    public static boolean q(String str) {
        return (RankScreenBean.SCREEN_VALUE_USDT_SWAP.equals(str) || RankScreenBean.SCREEN_VALUE_SYMBOL_SWAP.equals(str) || RankScreenBean.SCREEN_VALUE_FUTURE.equals(str)) && !gj.d.n().E();
    }

    public static boolean r(int i11, boolean z11) {
        return i11 == 9 && !z11;
    }

    public static void s(List<RankScreenBean> list) {
        RankScreenBean rankScreenBean;
        Iterator<RankScreenBean> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                rankScreenBean = null;
                break;
            }
            rankScreenBean = it2.next();
            if (f76857a.getScreenValue().equals(rankScreenBean.getScreenValue())) {
                break;
            }
        }
        if (rankScreenBean == null) {
            f76857a = list.get(0);
        } else {
            f76857a = rankScreenBean;
        }
    }
}

package ll;

import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static volatile j f76234c;

    /* renamed from: a  reason: collision with root package name */
    public String f76235a;

    /* renamed from: b  reason: collision with root package name */
    public String f76236b;

    public static class a implements Comparator<ml.b> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f76237b;

        public a(boolean z11) {
            this.f76237b = z11;
        }

        /* renamed from: a */
        public int compare(ml.b bVar, ml.b bVar2) {
            String i11 = StringUtils.i(bVar.getBaseCurrencyDisplayName());
            String i12 = StringUtils.i(bVar2.getBaseCurrencyDisplayName());
            String i13 = StringUtils.i(bVar.getQuoteCurrency());
            String i14 = StringUtils.i(bVar2.getQuoteCurrency());
            int weight = bVar.getWeight();
            int weight2 = bVar2.getWeight();
            if (this.f76237b) {
                int compareTo = i11.compareTo(i12);
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!TextUtils.isEmpty(i13) && !TextUtils.isEmpty(i14)) {
                    return i13.compareTo(i14);
                }
                if (!TextUtils.isEmpty(i13) || !TextUtils.isEmpty(i14)) {
                    return (!TextUtils.isEmpty(i13) || TextUtils.isEmpty(i14)) ? -1 : 1;
                }
                return weight - weight2;
            }
            int compareTo2 = i12.compareTo(i11);
            if (compareTo2 != 0) {
                return compareTo2;
            }
            if (!TextUtils.isEmpty(i13) && !TextUtils.isEmpty(i14)) {
                return i14.compareTo(i13);
            }
            if (!TextUtils.isEmpty(i13) || !TextUtils.isEmpty(i14)) {
                return (!TextUtils.isEmpty(i13) || TextUtils.isEmpty(i14)) ? -1 : 1;
            }
            return weight2 - weight;
        }
    }

    public static class b implements Comparator<MarketSymbolPriceItem> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f76238b;

        public b(boolean z11) {
            this.f76238b = z11;
        }

        /* renamed from: a */
        public int compare(MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
            return j.k(this.f76238b, marketSymbolPriceItem, marketSymbolPriceItem2);
        }
    }

    public static int k(boolean z11, MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
        String baseCurrencyDisplayName = marketSymbolPriceItem.k().getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName2 = marketSymbolPriceItem2.k().getBaseCurrencyDisplayName();
        if (z11) {
            int compareTo = baseCurrencyDisplayName.compareTo(baseCurrencyDisplayName2);
            if (compareTo != 0) {
                return compareTo;
            }
            return marketSymbolPriceItem.k().getQuoteCurrencyDisplayName().compareTo(marketSymbolPriceItem2.k().getQuoteCurrencyDisplayName());
        }
        int compareTo2 = baseCurrencyDisplayName2.compareTo(baseCurrencyDisplayName);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        return marketSymbolPriceItem2.k().getQuoteCurrencyDisplayName().compareTo(marketSymbolPriceItem.k().getQuoteCurrencyDisplayName());
    }

    public static j n() {
        if (f76234c == null) {
            synchronized (j.class) {
                if (f76234c == null) {
                    f76234c = new j();
                }
            }
        }
        return f76234c;
    }

    public static /* synthetic */ void o(List list, List list2, int i11, MarketSymbolPriceItem marketSymbolPriceItem) {
        if (marketSymbolPriceItem != null) {
            if (marketSymbolPriceItem.getSymbolPrice() == null || TextUtils.isEmpty(marketSymbolPriceItem.f())) {
                list.add(marketSymbolPriceItem);
            } else {
                list2.add(marketSymbolPriceItem);
            }
        }
    }

    public static /* synthetic */ int p(String str, boolean z11, MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
        int i11;
        if (!"type_amount".equals(str)) {
            return 0;
        }
        Double valueOf = Double.valueOf(Double.parseDouble(marketSymbolPriceItem.f()));
        Double valueOf2 = Double.valueOf(Double.parseDouble(marketSymbolPriceItem2.f()));
        if (z11) {
            i11 = valueOf.compareTo(valueOf2);
        } else {
            i11 = valueOf2.compareTo(valueOf);
        }
        return i11 == 0 ? k(z11, marketSymbolPriceItem, marketSymbolPriceItem2) : i11;
    }

    public static /* synthetic */ void q(List list, List list2, int i11, MarketSymbolPriceItem marketSymbolPriceItem) {
        if (marketSymbolPriceItem != null) {
            if (marketSymbolPriceItem.getSymbolPrice() == null || marketSymbolPriceItem.getSymbolPrice().getClose() == null || marketSymbolPriceItem.getSymbolPrice().getOpen() == null) {
                list.add(marketSymbolPriceItem);
            } else {
                list2.add(marketSymbolPriceItem);
            }
        }
    }

    public static /* synthetic */ int r(String str, boolean z11, MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
        if ("type_heigh_low".equals(str)) {
            int compareTo = Double.valueOf((marketSymbolPriceItem.getSymbolPrice().getClose().doubleValue() - marketSymbolPriceItem.getSymbolPrice().getOpen().doubleValue()) / marketSymbolPriceItem.getSymbolPrice().getOpen().doubleValue()).compareTo(Double.valueOf((marketSymbolPriceItem2.getSymbolPrice().getClose().doubleValue() - marketSymbolPriceItem2.getSymbolPrice().getOpen().doubleValue()) / marketSymbolPriceItem2.getSymbolPrice().getOpen().doubleValue()));
            if (compareTo == 0) {
                return k(z11, marketSymbolPriceItem, marketSymbolPriceItem2);
            }
            return z11 ? compareTo : -compareTo;
        } else if (!"type_price".equals(str)) {
            return 0;
        } else {
            int compareTo2 = marketSymbolPriceItem.getSymbolPrice().getClose().compareTo(marketSymbolPriceItem2.getSymbolPrice().getClose());
            if (compareTo2 == 0) {
                return k(z11, marketSymbolPriceItem, marketSymbolPriceItem2);
            }
            return z11 ? compareTo2 : -compareTo2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int s(boolean z11, ml.b bVar, ml.b bVar2) {
        Double d11;
        Double valueOf = Double.valueOf(0.0d);
        if (bVar instanceof MarketSymbolPriceItem) {
            d11 = Double.valueOf(Double.parseDouble(((MarketSymbolPriceItem) bVar).f()));
        } else if (bVar instanceof MarketContractSymbolPriceItem) {
            d11 = Double.valueOf(Double.parseDouble(((MarketContractSymbolPriceItem) bVar).h()));
        } else if (bVar instanceof MarketSwapPriceItem) {
            d11 = Double.valueOf(Double.parseDouble(((MarketSwapPriceItem) bVar).f()));
        } else {
            d11 = bVar instanceof MarketLinearSwapPriceItem ? Double.valueOf(Double.parseDouble(((MarketLinearSwapPriceItem) bVar).f())) : valueOf;
        }
        if (bVar2 instanceof MarketSymbolPriceItem) {
            valueOf = Double.valueOf(Double.parseDouble(((MarketSymbolPriceItem) bVar2).f()));
        } else if (bVar2 instanceof MarketContractSymbolPriceItem) {
            valueOf = Double.valueOf(Double.parseDouble(((MarketContractSymbolPriceItem) bVar2).h()));
        } else if (bVar2 instanceof MarketSwapPriceItem) {
            valueOf = Double.valueOf(Double.parseDouble(((MarketSwapPriceItem) bVar2).f()));
        } else if (bVar2 instanceof MarketLinearSwapPriceItem) {
            valueOf = Double.valueOf(Double.parseDouble(((MarketLinearSwapPriceItem) bVar2).f()));
        }
        int compareTo = d11.compareTo(valueOf);
        if (compareTo == 0) {
            return u(z11, bVar, bVar2);
        }
        return z11 ? compareTo : -compareTo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int t(String str, boolean z11, ml.b bVar, ml.b bVar2) {
        Double close = bVar.getSymbolPrice().getClose();
        Double close2 = bVar2.getSymbolPrice().getClose();
        if ("type_heigh_low".equals(str)) {
            int compareTo = Double.valueOf((close.doubleValue() - bVar.getSymbolPrice().getOpen().doubleValue()) / bVar.getSymbolPrice().getOpen().doubleValue()).compareTo(Double.valueOf((close2.doubleValue() - bVar2.getSymbolPrice().getOpen().doubleValue()) / bVar2.getSymbolPrice().getOpen().doubleValue()));
            if (compareTo == 0) {
                return u(z11, bVar, bVar2);
            }
            return z11 ? compareTo : -compareTo;
        } else if (!"type_price".equals(str)) {
            return 0;
        } else {
            int compareTo2 = close.compareTo(close2);
            if (compareTo2 == 0) {
                return u(z11, bVar, bVar2);
            }
            return z11 ? compareTo2 : -compareTo2;
        }
    }

    public static /* synthetic */ int v(String str, boolean z11, ml.b bVar, ml.b bVar2) {
        int weight = bVar.getWeight();
        int weight2 = bVar2.getWeight();
        Double close = bVar.getSymbolPrice().getClose();
        Double close2 = bVar2.getSymbolPrice().getClose();
        String i11 = StringUtils.i(bVar.getBaseCurrencyDisplayName());
        String i12 = StringUtils.i(bVar2.getBaseCurrencyDisplayName());
        if ("type_heigh_low".equals(str)) {
            Double valueOf = Double.valueOf(0.0d);
            Double valueOf2 = Double.valueOf(0.0d);
            if ("type_heigh_low".equals(str)) {
                close = Double.valueOf((close.doubleValue() - bVar.getSymbolPrice().getOpen().doubleValue()) / bVar.getSymbolPrice().getOpen().doubleValue());
                close2 = Double.valueOf((close2.doubleValue() - bVar2.getSymbolPrice().getOpen().doubleValue()) / bVar2.getSymbolPrice().getOpen().doubleValue());
            } else if (!"type_price".equals(str)) {
                close2 = valueOf2;
                close = valueOf;
            }
            if (z11) {
                int compareTo = close.compareTo(close2);
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = i11.compareTo(i12);
                return compareTo2 != 0 ? compareTo2 : weight - weight2;
            }
            int compareTo3 = close2.compareTo(close);
            if (compareTo3 != 0) {
                return compareTo3;
            }
            int compareTo4 = i12.compareTo(i11);
            return compareTo4 != 0 ? compareTo4 : weight2 - weight;
        } else if (z11) {
            int compareTo5 = close.compareTo(close2);
            if (compareTo5 != 0) {
                return compareTo5;
            }
            int compareTo6 = i11.compareTo(i12);
            return compareTo6 != 0 ? compareTo6 : weight - weight2;
        } else {
            int compareTo7 = close2.compareTo(close);
            if (compareTo7 != 0) {
                return compareTo7;
            }
            int compareTo8 = i12.compareTo(i11);
            return compareTo8 != 0 ? compareTo8 : weight2 - weight;
        }
    }

    public List<MarketSymbolPriceItem> A(List<MarketSymbolPriceItem> list, String str, String str2) {
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        List synchronizedList2 = Collections.synchronizedList(new ArrayList());
        List<MarketSymbolPriceItem> synchronizedList3 = Collections.synchronizedList(new ArrayList());
        if (list != null && list.size() > 0) {
            UtilCollections.c(list, new c(synchronizedList, synchronizedList2));
        }
        boolean equals = "sort_asc".equals(str2);
        Collections.sort(synchronizedList2, new f(str, equals));
        List<MarketSymbolPriceItem> z11 = n().z(synchronizedList, "type_name");
        if (equals) {
            Collections.reverse(z11);
        }
        synchronizedList3.addAll(synchronizedList2);
        synchronizedList3.addAll(z11);
        return synchronizedList3;
    }

    public List<ml.b> B(List<? extends ml.b> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list != null) {
            for (ml.b bVar : list) {
                if (bVar.getSymbolPrice() == null || bVar.getSymbolPrice().getClose() == null || bVar.getSymbolPrice().getOpen() == null || bVar.getSymbolPrice().getVol() == null) {
                    arrayList.add(bVar);
                } else {
                    arrayList2.add(bVar);
                }
            }
        }
        boolean equals = "sort_asc".equals(str2);
        Collections.sort(arrayList2, new i(this, equals));
        List<ml.b> C = n().C(arrayList, "type_name");
        if (equals) {
            Collections.reverse(C);
        }
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(C);
        return arrayList3;
    }

    public List<ml.b> C(List<? extends ml.b> list, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (ml.b bVar : new ArrayList(list)) {
            char[] charArray = StringUtils.i(bVar.getBaseCurrencyDisplayName()).toCharArray();
            if (charArray[0] < 'A' || charArray[0] > 'Z') {
                arrayList3.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        a aVar = new a("sort_asc".equals(str));
        Collections.sort(arrayList2, aVar);
        Collections.sort(arrayList3, aVar);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    public List<ml.b> D(List<? extends ml.b> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list != null) {
            try {
                for (ml.b bVar : list) {
                    if (!(bVar.getSymbolPrice() == null || bVar.getSymbolPrice().getClose() == null)) {
                        if (bVar.getSymbolPrice().getOpen() != null) {
                            arrayList2.add(bVar);
                        }
                    }
                    arrayList.add(bVar);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        boolean equals = "sort_asc".equals(str2);
        Collections.sort(arrayList2, new g(this, str, equals));
        Collections.sort(arrayList, new h(this, equals));
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(arrayList);
        return arrayList3;
    }

    public List<ml.b> E(List<ml.b> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (ml.b next : list) {
            if (next.getSymbolPrice() == null || next.getSymbolPrice().getClose() == null || next.getSymbolPrice().getOpen() == null) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        boolean equals = "sort_asc".equals(str2);
        Collections.sort(arrayList2, new d(str, equals));
        List<ml.b> C = n().C(arrayList, "type_name");
        if (equals) {
            Collections.reverse(C);
        }
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(C);
        return arrayList3;
    }

    /* renamed from: j */
    public final int u(boolean z11, ml.b bVar, ml.b bVar2) {
        String i11 = StringUtils.i(bVar.getBaseCurrencyDisplayName());
        String i12 = StringUtils.i(bVar2.getBaseCurrencyDisplayName());
        String i13 = StringUtils.i(bVar.getQuoteCurrency());
        String i14 = StringUtils.i(bVar2.getQuoteCurrency());
        int weight = bVar.getWeight();
        int weight2 = bVar2.getWeight();
        int compareTo = i11.compareTo(i12);
        if (compareTo == 0) {
            if (TextUtils.isEmpty(i13) || TextUtils.isEmpty(i14)) {
                return weight - weight2;
            }
            compareTo = i13.compareTo(i14);
        }
        return z11 ? compareTo : -compareTo;
    }

    public String l() {
        return TextUtils.isEmpty(this.f76235a) ? "" : this.f76235a;
    }

    public String m() {
        return TextUtils.isEmpty(this.f76236b) ? "" : this.f76236b;
    }

    public void w(String str) {
        this.f76235a = str;
    }

    public void x(String str) {
        this.f76236b = str;
    }

    public List<MarketSymbolPriceItem> y(List<MarketSymbolPriceItem> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list != null && list.size() > 0) {
            UtilCollections.c(list, new b(arrayList, arrayList2));
        }
        boolean equals = "sort_asc".equals(str2);
        Collections.sort(arrayList2, new e(str, equals));
        List<MarketSymbolPriceItem> z11 = n().z(arrayList, "type_name");
        if (equals) {
            Collections.reverse(z11);
        }
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(z11);
        return arrayList3;
    }

    public List<MarketSymbolPriceItem> z(List<MarketSymbolPriceItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        try {
            for (MarketSymbolPriceItem next : list) {
                String baseCurrencyDisplayName = next.k().getBaseCurrencyDisplayName();
                if (baseCurrencyDisplayName != null) {
                    char[] charArray = baseCurrencyDisplayName.toCharArray();
                    if (charArray[0] < 'A' || charArray[0] > 'Z') {
                        arrayList.add(next);
                    } else {
                        arrayList2.add(next);
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        b bVar = new b("sort_asc".equals(str));
        Collections.sort(arrayList2, bVar);
        Collections.sort(arrayList, bVar);
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(arrayList);
        return arrayList3;
    }
}

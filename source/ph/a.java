package ph;

import aj.d;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$string;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.ui.PieChartDialogFragment;
import com.huobi.view.chart.data.PieEntry;
import d7.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f47711e = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f47712a;

    /* renamed from: b  reason: collision with root package name */
    public final PieChartDialogFragment f47713b = new PieChartDialogFragment();

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f47714c;

    /* renamed from: d  reason: collision with root package name */
    public final PieEntry.PieChartHandleCallback f47715d = new C0581a();

    /* renamed from: ph.a$a  reason: collision with other inner class name */
    public class C0581a implements PieEntry.PieChartHandleCallback {
        public C0581a() {
        }

        public void onPieItemClick(int i11, PieEntry pieEntry) {
            a.this.f47713b.onPieItemClick(i11, pieEntry);
        }
    }

    public static a c() {
        return f47711e;
    }

    public final String b(Context context) {
        if (this.f47712a == null) {
            this.f47712a = context.getResources().getString(R$string.balance_detail_chart_item_other);
        }
        return this.f47712a;
    }

    public final List<PieEntry> d(Context context, BaseAssetTotal baseAssetTotal) {
        BigDecimal bigDecimal;
        int fixedTitleRes;
        ArrayList arrayList = new ArrayList();
        List<? extends BaseAssetInfo> detailInfos = baseAssetTotal.getDetailInfos();
        ArrayList<BaseAssetInfo> arrayList2 = new ArrayList<>();
        if (detailInfos != null && !detailInfos.isEmpty()) {
            arrayList2.addAll(detailInfos);
        }
        if (!arrayList2.isEmpty()) {
            Collections.sort(arrayList2);
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            ArrayList arrayList3 = new ArrayList();
            for (BaseAssetInfo baseAssetInfo : arrayList2) {
                BigDecimal a11 = m.a(baseAssetInfo.getEstimateAmount());
                if (a11.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
                arrayList3.add(baseAssetInfo);
                bigDecimal2 = bigDecimal2.add(a11);
            }
            int size = arrayList3.size();
            if (BigDecimal.ZERO.compareTo(bigDecimal2) != 0) {
                BigDecimal bigDecimal3 = BigDecimal.ZERO;
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    BaseAssetInfo baseAssetInfo2 = (BaseAssetInfo) arrayList3.get(i11);
                    if (arrayList.size() == 5) {
                        arrayList.add(new PieEntry(BigDecimal.ONE.subtract(bigDecimal3).floatValue(), b(context), "", this.f47715d));
                        break;
                    }
                    BigDecimal a12 = m.a(baseAssetInfo2.getEstimateAmount());
                    if (a12.compareTo(bigDecimal2) >= 0) {
                        bigDecimal = BigDecimal.ONE;
                    } else if (i11 == size - 1) {
                        bigDecimal = BigDecimal.ONE.subtract(bigDecimal3);
                    } else {
                        bigDecimal = a12.divide(bigDecimal2, 4, 1);
                    }
                    if (bigDecimal.compareTo(new BigDecimal("0.01")) < 0) {
                        arrayList.add(new PieEntry(BigDecimal.ONE.subtract(bigDecimal3).floatValue(), b(context), "", this.f47715d));
                        break;
                    }
                    String str = null;
                    if ((baseAssetInfo2 instanceof d) && (fixedTitleRes = ((d) baseAssetInfo2).getFixedTitleRes()) != 0) {
                        str = context.getResources().getString(fixedTitleRes);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = baseAssetInfo2.getDisplayName();
                    }
                    if (StringUtils.p(str)) {
                        str = k.C().z(baseAssetInfo2.getCurrency());
                    }
                    arrayList.add(new PieEntry(bigDecimal.floatValue(), str, "", this.f47715d));
                    bigDecimal3 = bigDecimal3.add(bigDecimal);
                    i11++;
                }
            } else {
                arrayList.add(new PieEntry(BigDecimal.ZERO.floatValue(), "", "", this.f47715d));
            }
        }
        return arrayList;
    }

    public final int e(Activity activity, int i11) {
        if (this.f47714c == null) {
            ArrayList arrayList = new ArrayList();
            this.f47714c = arrayList;
            arrayList.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_first)));
            this.f47714c.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_second)));
            this.f47714c.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_third)));
            this.f47714c.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_fouth)));
            this.f47714c.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_five)));
            this.f47714c.add(Integer.valueOf(ContextCompat.getColor(activity, R$color.balance_main_pie_chart_six)));
        }
        List<Integer> list = this.f47714c;
        if (i11 < 0 || i11 >= list.size()) {
            i11 = this.f47714c.size() - 1;
        }
        return list.get(i11).intValue();
    }

    public void f(FragmentActivity fragmentActivity, BaseAssetTotal baseAssetTotal) {
        List<PieEntry> d11 = d(fragmentActivity, baseAssetTotal);
        ArrayList arrayList = new ArrayList();
        int size = d11.size();
        if (size != 0) {
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                PieEntry pieEntry = d11.get(i11);
                if (pieEntry != null) {
                    if (b(fragmentActivity).equals(pieEntry.getTitle())) {
                        int e11 = e(fragmentActivity, 5);
                        pieEntry.setColor(Integer.valueOf(e11));
                        arrayList.add(Integer.valueOf(e11));
                        break;
                    }
                    int e12 = e(fragmentActivity, i11);
                    pieEntry.setColor(Integer.valueOf(e12));
                    arrayList.add(Integer.valueOf(e12));
                }
                i11++;
            }
        }
        g(fragmentActivity, baseAssetTotal, d11, arrayList);
    }

    public final void g(FragmentActivity fragmentActivity, BaseAssetTotal baseAssetTotal, List<PieEntry> list, List<Integer> list2) {
        this.f47713b.xh(baseAssetTotal, list, list2);
        this.f47713b.show(fragmentActivity.getSupportFragmentManager(), "pieChart");
    }
}

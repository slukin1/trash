package dt;

import com.huobi.finance.bean.SavingsDetailInfo;
import i6.m;
import java.util.Comparator;

public final /* synthetic */ class g2 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g2 f54028b = new g2();

    public final int compare(Object obj, Object obj2) {
        return m.a(((SavingsDetailInfo) obj2).getEstimateAmount()).compareTo(m.a(((SavingsDetailInfo) obj).getEstimateAmount()));
    }
}

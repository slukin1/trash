package dt;

import com.huobi.finance.bean.MineDetailInfo;
import i6.m;
import java.util.Comparator;

public final /* synthetic */ class o1 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ o1 f54119b = new o1();

    public final int compare(Object obj, Object obj2) {
        return m.a(((MineDetailInfo) obj2).getEstimateAmount()).compareTo(m.a(((MineDetailInfo) obj).getEstimateAmount()));
    }
}

package xk;

import com.huobi.finance.bean.OtcOptionsDetailInfo;
import com.huobi.finance.model.subaccount.OtcOptonDataProvider;
import java.util.Comparator;

public final /* synthetic */ class u implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u f61648b = new u();

    public final int compare(Object obj, Object obj2) {
        return OtcOptonDataProvider.m((OtcOptionsDetailInfo) obj, (OtcOptionsDetailInfo) obj2);
    }
}

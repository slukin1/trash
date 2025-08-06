package wn;

import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f61436b = new e();

    public final int compare(Object obj, Object obj2) {
        return ((LoginInfoData.Login2FAOption) obj).getPriority().compareTo(((LoginInfoData.Login2FAOption) obj2).getPriority());
    }
}

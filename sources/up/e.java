package up;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.otc.utils.OtcPayMethodUtil;
import rx.functions.Func2;

public final /* synthetic */ class e implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e f60905b = new e();

    public final Object call(Object obj, Object obj2) {
        return OtcPayMethodUtil.g((UserVO) obj, (UserKycInfoNew) obj2);
    }
}

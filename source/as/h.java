package as;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import d10.p;

public final /* synthetic */ class h implements p {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ h f12209b = new h();

    public final Object invoke(Object obj, Object obj2) {
        return HuobiToastUtil.i(((APIStatusErrorException) obj2).getErrMsg());
    }
}

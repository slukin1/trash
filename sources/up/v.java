package up;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class v implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f60921b;

    public /* synthetic */ v(FragmentActivity fragmentActivity) {
        this.f60921b = fragmentActivity;
    }

    public final void call(Object obj) {
        w.u(this.f60921b, (UserVO) obj);
    }
}

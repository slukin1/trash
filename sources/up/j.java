package up;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f60907b;

    public /* synthetic */ j(FragmentActivity fragmentActivity) {
        this.f60907b = fragmentActivity;
    }

    public final void call(Object obj) {
        w.x(this.f60907b, (UserVO) obj);
    }
}

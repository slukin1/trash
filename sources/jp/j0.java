package jp;

import android.app.Activity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f56031b;

    public /* synthetic */ j0(Activity activity) {
        this.f56031b = activity;
    }

    public final void call(Object obj) {
        k0.j(this.f56031b, (UserVO) obj);
    }
}

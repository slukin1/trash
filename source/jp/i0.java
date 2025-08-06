package jp;

import android.app.Activity;
import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class i0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f56028b;

    public /* synthetic */ i0(Activity activity) {
        this.f56028b = activity;
    }

    public final void call(Object obj) {
        k0.i(this.f56028b, (UserVO) obj);
    }
}

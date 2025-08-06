package bl;

import android.view.View;
import com.hbg.lib.common.utils.ViewUtil;
import rx.functions.Action1;

public final /* synthetic */ class a2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f12542b;

    public /* synthetic */ a2(View view) {
        this.f12542b = view;
    }

    public final void call(Object obj) {
        ViewUtil.m(this.f12542b, ((Boolean) obj).booleanValue());
    }
}

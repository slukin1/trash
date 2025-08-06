package pm;

import android.view.View;
import com.huobi.kline.CommunityModuleCallbackImpl;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f53171b;

    public /* synthetic */ a(View view) {
        this.f53171b = view;
    }

    public final Object call(Object obj) {
        return CommunityModuleCallbackImpl.c(this.f53171b, (Integer) obj);
    }
}

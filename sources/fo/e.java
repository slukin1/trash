package fo;

import android.view.View;
import com.huobi.main.ui.HuobiMainActivity;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f54715b;

    public /* synthetic */ e(View view) {
        this.f54715b = view;
    }

    public final Object call(Object obj) {
        return HuobiMainActivity.Sh(this.f54715b, (Integer) obj);
    }
}

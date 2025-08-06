package wg;

import android.view.View;
import i6.r;
import pro.huobi.R;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f61252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f61253c;

    public /* synthetic */ k(View.OnClickListener onClickListener, r rVar) {
        this.f61252b = onClickListener;
        this.f61253c = rVar;
    }

    public final void call(Object obj) {
        this.f61252b.onClick(this.f61253c.b(R.id.fans_container));
    }
}

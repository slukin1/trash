package wg;

import android.view.View;
import i6.r;
import pro.huobi.R;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f61254b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f61255c;

    public /* synthetic */ l(View.OnClickListener onClickListener, r rVar) {
        this.f61254b = onClickListener;
        this.f61255c = rVar;
    }

    public final void call(Object obj) {
        this.f61254b.onClick(this.f61255c.b(R.id.dynamic_container));
    }
}

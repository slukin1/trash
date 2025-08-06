package wg;

import android.view.View;
import i6.r;
import pro.huobi.R;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f61250b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f61251c;

    public /* synthetic */ j(View.OnClickListener onClickListener, r rVar) {
        this.f61250b = onClickListener;
        this.f61251c = rVar;
    }

    public final void call(Object obj) {
        this.f61250b.onClick(this.f61251c.b(R.id.focus_container));
    }
}

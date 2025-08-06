package cs;

import android.view.View;
import bs.a;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f53474b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f53475c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f53476d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f53477e;

    public /* synthetic */ e(h hVar, View view, View view2, a aVar) {
        this.f53474b = hVar;
        this.f53475c = view;
        this.f53476d = view2;
        this.f53477e = aVar;
    }

    public final void call(Object obj) {
        this.f53474b.B(this.f53475c, this.f53476d, this.f53477e, obj);
    }
}

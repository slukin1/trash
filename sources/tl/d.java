package tl;

import com.huobi.homemarket.presenter.EditCollectionPresenter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EditCollectionPresenter f29336b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f29337c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f29338d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f29339e;

    public /* synthetic */ d(EditCollectionPresenter editCollectionPresenter, List list, List list2, List list3) {
        this.f29336b = editCollectionPresenter;
        this.f29337c = list;
        this.f29338d = list2;
        this.f29339e = list3;
    }

    public final void call(Object obj) {
        this.f29336b.i0(this.f29337c, this.f29338d, this.f29339e, obj);
    }
}

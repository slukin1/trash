package c7;

import com.hbg.lib.data.main.BaseDataDiffTools;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class a implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseDataDiffTools f13005b;

    public /* synthetic */ a(BaseDataDiffTools baseDataDiffTools) {
        this.f13005b = baseDataDiffTools;
    }

    public final void call(Object obj) {
        this.f13005b.m((Subscriber) obj);
    }
}

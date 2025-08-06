package kq;

import com.huobi.points.entity.PointsPack;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PointsPack f57973b;

    public /* synthetic */ b(PointsPack pointsPack) {
        this.f57973b = pointsPack;
    }

    public final Object call(Object obj) {
        return Long.valueOf(this.f57973b.getOpenAt() - System.currentTimeMillis());
    }
}

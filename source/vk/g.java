package vk;

import com.huobi.finance.bean.BasePositionSortAccountItem;
import java.util.Comparator;

public final /* synthetic */ class g implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61065c;

    public /* synthetic */ g(boolean z11, int i11) {
        this.f61064b = z11;
        this.f61065c = i11;
    }

    public final int compare(Object obj, Object obj2) {
        return i.n(this.f61064b, this.f61065c, (BasePositionSortAccountItem) obj, (BasePositionSortAccountItem) obj2);
    }
}

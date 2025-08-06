package vk;

import com.huobi.finance.bean.BasePositionSortAccountItem;
import java.util.Comparator;

public final /* synthetic */ class h implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61067c;

    public /* synthetic */ h(boolean z11, int i11) {
        this.f61066b = z11;
        this.f61067c = i11;
    }

    public final int compare(Object obj, Object obj2) {
        return i.m(this.f61066b, this.f61067c, (BasePositionSortAccountItem) obj, (BasePositionSortAccountItem) obj2);
    }
}

package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "", "", "a", "Ljava/util/ArrayList;", "Landroidx/customview/poolingcontainer/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "listeners", "<init>", "()V", "customview-poolingcontainer_release"}, k = 1, mv = {1, 6, 0})
final class PoolingContainerListenerHolder {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<b> f8821a = new ArrayList<>();

    public final void a() {
        for (int m11 = CollectionsKt__CollectionsKt.m(this.f8821a); -1 < m11; m11--) {
            this.f8821a.get(m11).a();
        }
    }
}

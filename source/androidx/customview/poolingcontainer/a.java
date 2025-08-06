package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006\"(\u0010\u000b\u001a\u00020\t*\u00020\u00002\u0006\u0010\n\u001a\u00020\t8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroid/view/View;", "", "a", "Landroid/view/ViewGroup;", "b", "", "I", "PoolingContainerListenerHolderTag", "IsPoolingContainerTag", "", "value", "isPoolingContainer", "(Landroid/view/View;)Z", "d", "(Landroid/view/View;Z)V", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "c", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "poolingContainerListenerHolder", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8822a = R$id.pooling_container_listener_holder_tag;

    /* renamed from: b  reason: collision with root package name */
    public static final int f8823b = R$id.is_pooling_container_tag;

    public static final void a(View view) {
        for (View c11 : ViewKt.a(view)) {
            c(c11).a();
        }
    }

    public static final void b(ViewGroup viewGroup) {
        for (View c11 : ViewGroupKt.a(viewGroup)) {
            c(c11).a();
        }
    }

    public static final PoolingContainerListenerHolder c(View view) {
        int i11 = f8822a;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i11);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i11, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final void d(View view, boolean z11) {
        view.setTag(f8823b, Boolean.valueOf(z11));
    }
}

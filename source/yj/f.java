package yj;

import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.template.widget.NodeSequence;
import com.huobi.edgeengine.template.widget.NodeSequenceWidget;
import java.lang.ref.WeakReference;
import java.util.List;

public final /* synthetic */ class f implements ArrayListener.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeSequenceWidget f61744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f61745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NodeSequence f61746c;

    public /* synthetic */ f(NodeSequenceWidget nodeSequenceWidget, WeakReference weakReference, NodeSequence nodeSequence) {
        this.f61744a = nodeSequenceWidget;
        this.f61745b = weakReference;
        this.f61746c = nodeSequence;
    }

    public final void a(int i11, List list, List list2) {
        this.f61744a.a0(this.f61745b, this.f61746c, i11, list, list2);
    }
}

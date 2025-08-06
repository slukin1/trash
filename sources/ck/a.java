package ck;

import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.template.widget.NodeSequence;
import java.util.List;

public final /* synthetic */ class a implements ArrayListener.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f13108a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeSequence f13109b;

    public /* synthetic */ a(b bVar, NodeSequence nodeSequence) {
        this.f13108a = bVar;
        this.f13109b = nodeSequence;
    }

    public final void a(int i11, List list, List list2) {
        this.f13108a.c(this.f13109b, i11, list, list2);
    }
}

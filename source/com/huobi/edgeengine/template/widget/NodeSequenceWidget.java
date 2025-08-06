package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sumsub.sns.internal.core.analytics.d;
import java.lang.ref.WeakReference;
import java.util.List;
import rj.n;
import yj.f;

public abstract class NodeSequenceWidget extends ContainerWidget {

    /* renamed from: i0  reason: collision with root package name */
    public NodeSequence f44093i0 = new NodeSequence();

    /* renamed from: j0  reason: collision with root package name */
    public NodeSequence f44094j0;

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(WeakReference weakReference, NodeSequence nodeSequence, int i11, List list, List list2) {
        if (weakReference.get() != null) {
            Z((ViewGroup) weakReference.get(), nodeSequence);
        }
    }

    public void O() {
        super.O();
        NodeSequence nodeSequence = this.f44094j0;
        if (nodeSequence != null) {
            nodeSequence.i();
        }
    }

    public void X(Widget widget) {
        this.f44093i0.b(widget);
    }

    public void Z(ViewGroup viewGroup, NodeSequence nodeSequence) {
        viewGroup.removeAllViews();
        for (Pair next : nodeSequence.g()) {
            View Q = ((Widget) next.first).Q(viewGroup.getContext(), (n) next.second);
            if ((viewGroup instanceof FrameLayout) && ((Widget) next.first).G != 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) Q.getLayoutParams());
                layoutParams.gravity = ((Widget) next.first).G;
                Q.setLayoutParams(layoutParams);
            }
            viewGroup.addView(Q);
        }
    }

    /* renamed from: b0 */
    public ViewGroup Q(Context context, n nVar) {
        NodeSequence e11 = NodeSequence.e(this.f44093i0);
        this.f44094j0 = e11;
        e11.j(context, nVar);
        ViewGroup viewGroup = (ViewGroup) super.Q(context, nVar);
        if (d.f31895b.equals(this.f44168r)) {
            viewGroup.setClipChildren(false);
        }
        return viewGroup;
    }

    public void c0(ViewGroup viewGroup, NodeSequence nodeSequence) {
        Z(viewGroup, nodeSequence);
        nodeSequence.c(new f(this, new WeakReference(viewGroup), nodeSequence));
    }
}

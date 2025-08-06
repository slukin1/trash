package ck;

import ak.b;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.edgeengine.template.widget.NodeSequence;
import com.huobi.edgeengine.template.widget.slider.RollPagerView;
import java.lang.ref.WeakReference;
import java.util.List;

public class b extends RecyclerView.Adapter<b.C0555b> {

    /* renamed from: a  reason: collision with root package name */
    public NodeSequence f40900a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<RollPagerView> f40901b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40902c;

    /* renamed from: d  reason: collision with root package name */
    public int f40903d = -1;

    public b(NodeSequence nodeSequence, RollPagerView rollPagerView) {
        this.f40901b = new WeakReference<>(rollPagerView);
        this.f40900a = nodeSequence;
        rollPagerView.setDataSize(nodeSequence.h());
        nodeSequence.c(new a(this, nodeSequence));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(NodeSequence nodeSequence, int i11, List list, List list2) {
        if (this.f40901b.get() != null) {
            ((RollPagerView) this.f40901b.get()).setDataSize(nodeSequence.h());
        }
        notifyDataSetChanged();
        if (nodeSequence.h() != 0 && this.f40903d != -1 && this.f40901b.get() != null) {
            ((RollPagerView) this.f40901b.get()).u(this.f40903d, false);
            this.f40903d = -1;
        }
    }

    /* renamed from: d */
    public void onBindViewHolder(b.C0555b bVar, int i11) {
        int realCount = i11 % getRealCount();
        ((FrameLayout) bVar.itemView).removeAllViews();
        View view = bVar.itemView;
        ((FrameLayout) view).addView(this.f40900a.d(view.getContext(), realCount));
        if (this.f40901b.get() != null) {
            ((RollPagerView) this.f40901b.get()).s(realCount);
        }
    }

    /* renamed from: e */
    public b.C0555b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new b.C0555b(frameLayout);
    }

    public void f(int i11) {
        this.f40903d = i11;
    }

    public void g(boolean z11) {
        this.f40902c = z11;
    }

    public int getItemCount() {
        if (!this.f40902c) {
            return getRealCount();
        }
        if (getRealCount() <= 1) {
            return getRealCount();
        }
        return Integer.MAX_VALUE;
    }

    public int getItemViewType(int i11) {
        return i11 % getRealCount();
    }

    public int getRealCount() {
        return this.f40900a.h();
    }
}

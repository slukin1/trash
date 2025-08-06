package ak;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.FooterWidget;
import com.huobi.edgeengine.template.widget.HeaderWidget;
import com.huobi.edgeengine.template.widget.list.CellWidget;
import com.huobi.edgeengine.template.widget.list.SectionWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rj.n;

public class b extends RecyclerView.Adapter<C0555b> {

    /* renamed from: a  reason: collision with root package name */
    public FooterWidget f40717a;

    /* renamed from: b  reason: collision with root package name */
    public HeaderWidget f40718b;

    /* renamed from: c  reason: collision with root package name */
    public List<CellWidget> f40719c;

    /* renamed from: d  reason: collision with root package name */
    public int f40720d;

    /* renamed from: e  reason: collision with root package name */
    public String f40721e = "type";

    /* renamed from: f  reason: collision with root package name */
    public String f40722f;

    /* renamed from: g  reason: collision with root package name */
    public String f40723g;

    /* renamed from: h  reason: collision with root package name */
    public String f40724h;

    /* renamed from: i  reason: collision with root package name */
    public Context f40725i;

    /* renamed from: j  reason: collision with root package name */
    public n f40726j;

    /* renamed from: k  reason: collision with root package name */
    public List<TraceMap.a> f40727k = new ArrayList();

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f40728a;

        public a(GridLayoutManager gridLayoutManager) {
            this.f40728a = gridLayoutManager;
        }

        public int getSpanSize(int i11) {
            if (b.this.f(i11) || b.this.e(i11)) {
                return this.f40728a.k();
            }
            return 1;
        }
    }

    /* renamed from: ak.b$b  reason: collision with other inner class name */
    public static class C0555b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public n f40730a;

        public C0555b(View view) {
            super(view);
        }

        public C0555b(View view, n nVar) {
            super(view);
            this.f40730a = nVar;
        }
    }

    public b(Context context) {
        this.f40725i = context;
    }

    public static /* synthetic */ void g(WeakReference weakReference, int i11, List list, List list2) {
        b bVar = (b) weakReference.get();
        if (bVar != null) {
            int i12 = 0;
            if (i11 != 0) {
                if (i11 == 1) {
                    int i13 = bVar.f40720d;
                    if (list != null) {
                        i12 = list.size();
                    }
                    bVar.f40720d = i13 + i12;
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        bVar.notifyItemInserted(((Integer) it2.next()).intValue());
                    }
                    return;
                } else if (i11 == 2) {
                    int i14 = bVar.f40720d;
                    if (list != null) {
                        i12 = list.size();
                    }
                    bVar.f40720d = i14 - i12;
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        bVar.notifyItemRemoved(((Integer) it3.next()).intValue());
                    }
                    return;
                } else if (i11 == 3) {
                    Iterator it4 = list2.iterator();
                    while (it4.hasNext()) {
                        bVar.notifyItemChanged(((Integer) it4.next()).intValue());
                    }
                    return;
                } else if (i11 != 4) {
                    return;
                }
            }
            if (list != null) {
                i12 = list.size();
            }
            bVar.f40720d = i12;
            Log.e("EdgeEngine", "listen array state: " + i11 + " items " + bVar.f40720d);
            bVar.notifyDataSetChanged();
        }
    }

    public int c() {
        return this.f40717a != null ? 1 : 0;
    }

    public int d() {
        return this.f40718b != null ? 1 : 0;
    }

    public boolean e(int i11) {
        return this.f40717a != null && i11 == getItemCount() - 1;
    }

    public boolean f(int i11) {
        return this.f40718b != null && i11 == 0;
    }

    public int getItemCount() {
        int i11 = this.f40718b != null ? 1 : 0;
        if (this.f40717a != null) {
            i11++;
        }
        return i11 + this.f40720d;
    }

    public int getItemViewType(int i11) {
        int i12 = this.f40718b != null ? 1 : 0;
        int i13 = i11 - i12;
        if (i11 == 0 && i12 != 0) {
            return -2;
        }
        if (i11 == getItemCount() - 1 && this.f40717a != null) {
            return -3;
        }
        try {
            if (this.f40719c.size() == 1) {
                return 0;
            }
            for (int i14 = 0; i14 < this.f40719c.size(); i14++) {
                CellWidget cellWidget = this.f40719c.get(i14);
                if (cellWidget != null) {
                    if (TextUtils.equals(cellWidget.d0(), this.f40726j.p(this.f40722f, this.f40724h, i13, this.f40723g).s(this.f40721e))) {
                        return i14;
                    }
                }
            }
            return -1;
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    /* renamed from: h */
    public void onBindViewHolder(C0555b bVar, int i11) {
        n nVar = bVar.f40730a;
        if (nVar != null) {
            nVar.J(this.f40726j.r(this.f40724h, i11 - (this.f40718b != null ? 1 : 0), this.f40723g));
        }
    }

    /* renamed from: i */
    public C0555b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == -2) {
            return new C0555b(this.f40718b.Q(this.f40725i, this.f40726j));
        }
        if (i11 == -3) {
            return new C0555b(this.f40717a.Q(this.f40725i, this.f40726j));
        }
        if (i11 == -1) {
            return new C0555b(new View(this.f40725i));
        }
        CellWidget cellWidget = this.f40719c.get(i11);
        if (cellWidget == null) {
            return new C0555b(new View(this.f40725i));
        }
        n p11 = this.f40726j.p(this.f40722f, this.f40724h, 0, this.f40723g);
        C0555b bVar = new C0555b(cellWidget.Q(this.f40725i, p11), p11);
        if (cellWidget instanceof SectionWidget) {
            bVar.itemView.setTag(Boolean.TRUE);
        }
        return bVar;
    }

    public void j() {
        HeaderWidget headerWidget = this.f40718b;
        if (headerWidget != null) {
            headerWidget.O();
        }
        FooterWidget footerWidget = this.f40717a;
        if (footerWidget != null) {
            footerWidget.O();
        }
        this.f40726j = null;
        for (TraceMap.a destroy : this.f40727k) {
            destroy.destroy();
        }
        List<CellWidget> list = this.f40719c;
        if (list != null) {
            for (CellWidget O : list) {
                O.O();
            }
        }
    }

    public void k(List<CellWidget> list) {
        this.f40719c = list;
    }

    public void l(String str, String str2) {
        this.f40723g = str;
        this.f40724h = str2;
    }

    public void m(FooterWidget footerWidget) {
        this.f40717a = footerWidget;
    }

    public void n(HeaderWidget headerWidget) {
        this.f40718b = headerWidget;
    }

    public void o(String str) {
        this.f40722f = str;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.t(new a(gridLayoutManager));
        }
    }

    public void p(n nVar) {
        this.f40726j = nVar;
        TraceMap.a G = nVar.G(this.f40724h, new a(new WeakReference(this)), nVar.f47793e);
        if (G != null) {
            this.f40727k.add(G);
            this.f40727k.add(G);
        }
    }

    public void q(String str) {
        this.f40721e = str;
    }

    public void r() {
        n nVar = this.f40726j;
        if (nVar != null) {
            this.f40720d = nVar.q(this.f40724h, this.f40723g);
        }
    }
}

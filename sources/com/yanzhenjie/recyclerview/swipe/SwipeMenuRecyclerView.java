package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.yanzhenjie.recyclerview.swipe.touch.DefaultItemTouchHelper;
import dz.g;
import java.util.ArrayList;
import java.util.List;

public class SwipeMenuRecyclerView extends RecyclerView {

    /* renamed from: b  reason: collision with root package name */
    public int f52657b;

    /* renamed from: c  reason: collision with root package name */
    public SwipeMenuLayout f52658c;

    /* renamed from: d  reason: collision with root package name */
    public int f52659d;

    /* renamed from: e  reason: collision with root package name */
    public int f52660e;

    /* renamed from: f  reason: collision with root package name */
    public int f52661f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52662g;

    /* renamed from: h  reason: collision with root package name */
    public DefaultItemTouchHelper f52663h;

    /* renamed from: i  reason: collision with root package name */
    public dz.e f52664i;

    /* renamed from: j  reason: collision with root package name */
    public g f52665j;

    /* renamed from: k  reason: collision with root package name */
    public dz.b f52666k;

    /* renamed from: l  reason: collision with root package name */
    public dz.a f52667l;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f52668m;

    /* renamed from: n  reason: collision with root package name */
    public List<View> f52669n;

    /* renamed from: o  reason: collision with root package name */
    public List<View> f52670o;

    /* renamed from: p  reason: collision with root package name */
    public int f52671p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f52672q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f52673r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f52674s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f52675t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f52676u;

    /* renamed from: v  reason: collision with root package name */
    public e f52677v;

    /* renamed from: w  reason: collision with root package name */
    public d f52678w;

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f52679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f52680b;

        public a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f52679a = gridLayoutManager;
            this.f52680b = spanSizeLookup;
        }

        public int getSpanSize(int i11) {
            if (SwipeMenuRecyclerView.this.f52667l.isHeaderView(i11) || SwipeMenuRecyclerView.this.f52667l.isFooterView(i11)) {
                return this.f52679a.k();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f52680b;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i11 - SwipeMenuRecyclerView.this.getHeaderItemCount());
            }
            return 1;
        }
    }

    public static class c implements dz.b {

        /* renamed from: a  reason: collision with root package name */
        public SwipeMenuRecyclerView f52683a;

        /* renamed from: b  reason: collision with root package name */
        public dz.b f52684b;

        public c(SwipeMenuRecyclerView swipeMenuRecyclerView, dz.b bVar) {
            this.f52683a = swipeMenuRecyclerView;
            this.f52684b = bVar;
        }

        public void onItemClick(View view, int i11) {
            int headerItemCount = i11 - this.f52683a.getHeaderItemCount();
            if (headerItemCount >= 0) {
                this.f52684b.onItemClick(view, headerItemCount);
            }
        }
    }

    public interface d {
        void a();
    }

    public interface e {
        void b();

        void c(d dVar);
    }

    public static class f implements g {

        /* renamed from: a  reason: collision with root package name */
        public SwipeMenuRecyclerView f52685a;

        /* renamed from: b  reason: collision with root package name */
        public g f52686b;

        public f(SwipeMenuRecyclerView swipeMenuRecyclerView, g gVar) {
            this.f52685a = swipeMenuRecyclerView;
            this.f52686b = gVar;
        }

        public void a(dz.d dVar) {
            int a11 = dVar.a() - this.f52685a.getHeaderItemCount();
            if (a11 >= 0) {
                dVar.f52823e = a11;
                this.f52686b.a(dVar);
            }
        }
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void b(String str) {
        if (this.f52667l != null) {
            throw new IllegalStateException(str);
        }
    }

    public final void c() {
        if (!this.f52674s) {
            if (!this.f52673r) {
                e eVar = this.f52677v;
                if (eVar != null) {
                    eVar.c(this.f52678w);
                }
            } else if (!this.f52672q && !this.f52675t && this.f52676u) {
                this.f52672q = true;
                e eVar2 = this.f52677v;
                if (eVar2 != null) {
                    eVar2.b();
                }
                d dVar = this.f52678w;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public final View d(View view) {
        if (view instanceof SwipeMenuLayout) {
            return view;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ViewGroup) {
                if (view2 instanceof SwipeMenuLayout) {
                    return view2;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    arrayList.add(viewGroup.getChildAt(i11));
                }
            }
        }
        return view;
    }

    public final boolean e(int i11, int i12, boolean z11) {
        int i13 = this.f52660e - i11;
        int i14 = this.f52661f - i12;
        if (Math.abs(i13) > this.f52657b && Math.abs(i13) > Math.abs(i14)) {
            return false;
        }
        if (Math.abs(i14) >= this.f52657b || Math.abs(i13) >= this.f52657b) {
            return z11;
        }
        return false;
    }

    public final void f() {
        if (this.f52663h == null) {
            DefaultItemTouchHelper defaultItemTouchHelper = new DefaultItemTouchHelper();
            this.f52663h = defaultItemTouchHelper;
            defaultItemTouchHelper.b(this);
        }
    }

    public int getFooterItemCount() {
        dz.a aVar = this.f52667l;
        if (aVar == null) {
            return 0;
        }
        return aVar.d();
    }

    public int getHeaderItemCount() {
        dz.a aVar = this.f52667l;
        if (aVar == null) {
            return 0;
        }
        return aVar.e();
    }

    public RecyclerView.Adapter getOriginAdapter() {
        dz.a aVar = this.f52667l;
        if (aVar == null) {
            return null;
        }
        return aVar.f();
    }

    public void onDetachedFromWindow() {
        dz.a aVar = this.f52667l;
        if (aVar != null) {
            aVar.f().unregisterAdapterDataObserver(this.f52668m);
        }
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        SwipeMenuLayout swipeMenuLayout;
        ViewParent parent;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.f52662g) {
            return onInterceptTouchEvent;
        }
        boolean z12 = true;
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int action = motionEvent.getAction();
        int x11 = (int) motionEvent.getX();
        int y11 = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    onInterceptTouchEvent = e(x11, y11, onInterceptTouchEvent);
                    if (this.f52658c == null || (parent = getParent()) == null) {
                        return onInterceptTouchEvent;
                    }
                    int i11 = this.f52660e - x11;
                    boolean z13 = i11 > 0 && (this.f52658c.e() || this.f52658c.f());
                    boolean z14 = i11 < 0 && (this.f52658c.d() || this.f52658c.j());
                    if (!z13 && !z14) {
                        z12 = false;
                    }
                    parent.requestDisallowInterceptTouchEvent(z12);
                } else if (action != 3) {
                    return onInterceptTouchEvent;
                }
            }
            return e(x11, y11, onInterceptTouchEvent);
        }
        this.f52660e = x11;
        this.f52661f = y11;
        int childAdapterPosition = getChildAdapterPosition(findChildViewUnder((float) x11, (float) y11));
        if (childAdapterPosition == this.f52659d || (swipeMenuLayout = this.f52658c) == null || !swipeMenuLayout.a()) {
            z11 = false;
        } else {
            this.f52658c.o();
            z11 = true;
        }
        if (z11) {
            this.f52658c = null;
            this.f52659d = -1;
            return z11;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(childAdapterPosition);
        if (findViewHolderForAdapterPosition == null) {
            return z11;
        }
        View d11 = d(findViewHolderForAdapterPosition.itemView);
        if (!(d11 instanceof SwipeMenuLayout)) {
            return z11;
        }
        this.f52658c = (SwipeMenuLayout) d11;
        this.f52659d = childAdapterPosition;
        return z11;
    }

    public void onScrollStateChanged(int i11) {
        this.f52671p = i11;
    }

    public void onScrolled(int i11, int i12) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int itemCount = layoutManager.getItemCount();
            if (itemCount > 0 && itemCount == linearLayoutManager.findLastVisibleItemPosition() + 1) {
                int i13 = this.f52671p;
                if (i13 == 1 || i13 == 2) {
                    c();
                }
            }
        } else if (layoutManager != null && (layoutManager instanceof StaggeredGridLayoutManager)) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int itemCount2 = layoutManager.getItemCount();
            if (itemCount2 > 0) {
                int[] r11 = staggeredGridLayoutManager.r((int[]) null);
                if (itemCount2 == r11[r11.length - 1] + 1) {
                    int i14 = this.f52671p;
                    if (i14 == 1 || i14 == 2) {
                        c();
                    }
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        if (motionEvent.getAction() == 2 && (swipeMenuLayout = this.f52658c) != null && swipeMenuLayout.a()) {
            this.f52658c.o();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        dz.a aVar = this.f52667l;
        if (aVar != null) {
            aVar.f().unregisterAdapterDataObserver(this.f52668m);
        }
        if (adapter == null) {
            this.f52667l = null;
        } else {
            adapter.registerAdapterDataObserver(this.f52668m);
            dz.a aVar2 = new dz.a(getContext(), adapter);
            this.f52667l = aVar2;
            aVar2.h(this.f52666k);
            this.f52667l.i(this.f52664i);
            this.f52667l.j(this.f52665j);
            if (this.f52669n.size() > 0) {
                for (View addHeaderView : this.f52669n) {
                    this.f52667l.addHeaderView(addHeaderView);
                }
            }
            if (this.f52670o.size() > 0) {
                for (View addFooterView : this.f52670o) {
                    this.f52667l.addFooterView(addFooterView);
                }
            }
        }
        super.setAdapter(this.f52667l);
    }

    public void setAutoLoadMore(boolean z11) {
        this.f52673r = z11;
    }

    public void setItemViewSwipeEnabled(boolean z11) {
        f();
        this.f52662g = z11;
        this.f52663h.C(z11);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.t(new a(gridLayoutManager, gridLayoutManager.o()));
        }
        super.setLayoutManager(layoutManager);
    }

    public void setLoadMoreListener(d dVar) {
        this.f52678w = dVar;
    }

    public void setLoadMoreView(e eVar) {
        this.f52677v = eVar;
    }

    public void setLongPressDragEnabled(boolean z11) {
        f();
        this.f52663h.D(z11);
    }

    public void setOnItemMoveListener(ez.a aVar) {
        f();
        this.f52663h.E(aVar);
    }

    public void setOnItemMovementListener(ez.b bVar) {
        f();
        this.f52663h.F(bVar);
    }

    public void setOnItemStateChangedListener(ez.c cVar) {
        f();
        this.f52663h.G(cVar);
    }

    public void setSwipeItemClickListener(dz.b bVar) {
        if (bVar != null) {
            b("Cannot set item click listener, setAdapter has already been called.");
            this.f52666k = new c(this, bVar);
        }
    }

    public void setSwipeMenuCreator(dz.e eVar) {
        if (eVar != null) {
            b("Cannot set menu creator, setAdapter has already been called.");
            this.f52664i = eVar;
        }
    }

    public void setSwipeMenuItemClickListener(g gVar) {
        if (gVar != null) {
            b("Cannot set menu item click listener, setAdapter has already been called.");
            this.f52665j = new f(this, gVar);
        }
    }

    public class b extends RecyclerView.AdapterDataObserver {
        public b() {
        }

        public void onChanged() {
            SwipeMenuRecyclerView.this.f52667l.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i11, int i12) {
            SwipeMenuRecyclerView.this.f52667l.notifyItemRangeChanged(i11 + SwipeMenuRecyclerView.this.getHeaderItemCount(), i12);
        }

        public void onItemRangeInserted(int i11, int i12) {
            SwipeMenuRecyclerView.this.f52667l.notifyItemRangeInserted(i11 + SwipeMenuRecyclerView.this.getHeaderItemCount(), i12);
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            SwipeMenuRecyclerView.this.f52667l.notifyItemMoved(i11 + SwipeMenuRecyclerView.this.getHeaderItemCount(), i12 + SwipeMenuRecyclerView.this.getHeaderItemCount());
        }

        public void onItemRangeRemoved(int i11, int i12) {
            SwipeMenuRecyclerView.this.f52667l.notifyItemRangeRemoved(i11 + SwipeMenuRecyclerView.this.getHeaderItemCount(), i12);
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            SwipeMenuRecyclerView.this.f52667l.notifyItemRangeChanged(i11 + SwipeMenuRecyclerView.this.getHeaderItemCount(), i12, obj);
        }
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52659d = -1;
        this.f52662g = false;
        this.f52668m = new b();
        this.f52669n = new ArrayList();
        this.f52670o = new ArrayList();
        this.f52671p = -1;
        this.f52672q = false;
        this.f52673r = true;
        this.f52674s = false;
        this.f52675t = true;
        this.f52676u = false;
        this.f52657b = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}

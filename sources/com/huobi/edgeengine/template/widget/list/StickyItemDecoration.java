package com.huobi.edgeengine.template.widget.list;

import ak.g;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class StickyItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public View f44287a;

    /* renamed from: b  reason: collision with root package name */
    public int f44288b;

    /* renamed from: c  reason: collision with root package name */
    public int f44289c;

    /* renamed from: d  reason: collision with root package name */
    public g f44290d = new ExampleStickyView();

    /* renamed from: e  reason: collision with root package name */
    public boolean f44291e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView.Adapter<RecyclerView.ViewHolder> f44292f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.ViewHolder f44293g;

    /* renamed from: h  reason: collision with root package name */
    public List<Integer> f44294h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f44295i;

    /* renamed from: j  reason: collision with root package name */
    public int f44296j = -1;

    /* renamed from: k  reason: collision with root package name */
    public Paint f44297k;

    public StickyItemDecoration() {
        h();
    }

    public final void a(int i11, int i12) {
        RecyclerView.ViewHolder viewHolder;
        if (this.f44296j != i11 && (viewHolder = this.f44293g) != null) {
            this.f44296j = i11;
            this.f44292f.onBindViewHolder(viewHolder, i11);
            i(i12);
            this.f44289c = this.f44293g.itemView.getBottom() - this.f44293g.itemView.getTop();
        }
    }

    public final void b(int i11) {
        int g11 = g(i11);
        if (!this.f44294h.contains(Integer.valueOf(g11))) {
            this.f44294h.add(Integer.valueOf(g11));
        }
    }

    public final void c() {
        if (this.f44295i.findFirstVisibleItemPosition() == 0) {
            this.f44294h.clear();
        }
    }

    public final void d(Canvas canvas) {
        if (this.f44287a != null) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f44288b));
            this.f44287a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public final View e(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        View view = null;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            if (this.f44290d.a(childAt)) {
                i11++;
                view = childAt;
            }
            if (i11 == 2) {
                break;
            }
        }
        if (i11 >= 2) {
            return view;
        }
        return null;
    }

    public final void f(RecyclerView recyclerView, int i11) {
        if (this.f44292f == null) {
            RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = recyclerView.getAdapter();
            this.f44292f = adapter;
            RecyclerView.ViewHolder onCreateViewHolder = adapter.onCreateViewHolder(recyclerView, adapter.getItemViewType(g(i11)));
            this.f44293g = onCreateViewHolder;
            this.f44287a = onCreateViewHolder.itemView;
        }
    }

    public final int g(int i11) {
        return this.f44295i.findFirstVisibleItemPosition() + i11;
    }

    public final void h() {
        Paint paint = new Paint();
        this.f44297k = paint;
        paint.setAntiAlias(true);
    }

    public final void i(int i11) {
        int i12;
        int i13;
        View view = this.f44287a;
        if (view != null && view.isLayoutRequested()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            ViewGroup.LayoutParams layoutParams = this.f44287a.getLayoutParams();
            if (layoutParams == null || (i13 = layoutParams.height) <= 0) {
                i12 = View.MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                i12 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            }
            this.f44287a.measure(makeMeasureSpec, i12);
            View view2 = this.f44287a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f44287a.getMeasuredHeight());
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int i12;
        super.onDrawOver(canvas, recyclerView, state);
        if (recyclerView.getAdapter().getItemCount() > 0) {
            this.f44295i = (LinearLayoutManager) recyclerView.getLayoutManager();
            this.f44291e = false;
            c();
            int childCount = recyclerView.getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i13);
                if (this.f44290d.a(childAt)) {
                    this.f44291e = true;
                    f(recyclerView, g(i13));
                    b(i13);
                    if (childAt.getTop() <= 0) {
                        a(this.f44295i.findFirstVisibleItemPosition(), recyclerView.getMeasuredWidth());
                    } else if (this.f44294h.size() > 0) {
                        if (this.f44294h.size() == 1) {
                            a(this.f44294h.get(0).intValue(), recyclerView.getMeasuredWidth());
                        } else {
                            int lastIndexOf = this.f44294h.lastIndexOf(Integer.valueOf(g(i13)));
                            if (lastIndexOf >= 1) {
                                a(this.f44294h.get(lastIndexOf - 1).intValue(), recyclerView.getMeasuredWidth());
                            }
                        }
                    }
                    if (childAt.getTop() <= 0 || childAt.getTop() > (i12 = this.f44289c)) {
                        this.f44288b = 0;
                        View e11 = e(recyclerView);
                        if (e11 != null && e11.getTop() <= (i11 = this.f44289c)) {
                            this.f44288b = i11 - e11.getTop();
                        }
                    } else {
                        this.f44288b = i12 - childAt.getTop();
                    }
                    d(canvas);
                } else {
                    i13++;
                }
            }
            if (!this.f44291e) {
                this.f44288b = 0;
                if (this.f44295i.findFirstVisibleItemPosition() + recyclerView.getChildCount() == recyclerView.getAdapter().getItemCount() && this.f44294h.size() > 0) {
                    List<Integer> list = this.f44294h;
                    a(list.get(list.size() - 1).intValue(), recyclerView.getMeasuredWidth());
                }
                d(canvas);
            }
        }
    }
}

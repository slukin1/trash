package com.yanzhenjie.recyclerview.swipe.touch;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ez.a;
import ez.b;
import ez.c;

public class DefaultItemTouchHelperCallback extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public b f52691a;

    /* renamed from: b  reason: collision with root package name */
    public a f52692b;

    /* renamed from: c  reason: collision with root package name */
    public c f52693c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52694d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52695e;

    public void a(boolean z11) {
        this.f52694d = z11;
    }

    public void b(boolean z11) {
        this.f52695e = z11;
    }

    public void c(a aVar) {
        this.f52692b = aVar;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        c cVar = this.f52693c;
        if (cVar != null) {
            cVar.a(viewHolder, 0);
        }
    }

    public void d(b bVar) {
        this.f52691a = bVar;
    }

    public void e(c cVar) {
        this.f52693c = cVar;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        b bVar = this.f52691a;
        if (bVar != null) {
            return ItemTouchHelper.Callback.makeMovementFlags(bVar.b(recyclerView, viewHolder), this.f52691a.a(recyclerView, viewHolder));
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                return ItemTouchHelper.Callback.makeMovementFlags(15, 3);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(15, 12);
        } else if (!(layoutManager instanceof LinearLayoutManager)) {
            return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
        } else {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                return ItemTouchHelper.Callback.makeMovementFlags(12, 3);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(3, 12);
        }
    }

    public boolean isItemViewSwipeEnabled() {
        return this.f52694d;
    }

    public boolean isLongPressDragEnabled() {
        return this.f52695e;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f11, float f12, int i11, boolean z11) {
        float abs;
        int width;
        if (i11 == 1) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            float f13 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
                if (orientation == 0) {
                    abs = Math.abs(f12);
                    width = viewHolder.itemView.getHeight();
                } else if (orientation == 1) {
                    abs = Math.abs(f11);
                    width = viewHolder.itemView.getWidth();
                }
                f13 = 1.0f - (abs / ((float) width));
            }
            viewHolder.itemView.setAlpha(f13);
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f11, f12, i11, z11);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        a aVar = this.f52692b;
        if (aVar != null) {
            return aVar.a(viewHolder, viewHolder2);
        }
        return false;
    }

    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i11) {
        super.onSelectedChanged(viewHolder, i11);
        c cVar = this.f52693c;
        if (cVar != null && i11 != 0) {
            cVar.a(viewHolder, i11);
        }
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i11) {
        a aVar = this.f52692b;
        if (aVar != null) {
            aVar.b(viewHolder);
        }
    }
}

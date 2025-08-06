package rl;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class b extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public a f76453a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f76454b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76455c = false;

    public interface a {
        void a(int i11);

        boolean onMove(int i11, int i12);
    }

    public b(a aVar) {
        this.f76453a = aVar;
    }

    public void a(boolean z11) {
        this.f76454b = z11;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i11 = 0;
        if (layoutManager instanceof GridLayoutManager) {
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return 0;
        }
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        int i12 = 12;
        if (orientation == 0) {
            i11 = 12;
            i12 = 3;
        } else if (orientation == 1) {
            i11 = 3;
        } else {
            i12 = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i11, i12);
    }

    public boolean isItemViewSwipeEnabled() {
        return this.f76455c;
    }

    public boolean isLongPressDragEnabled() {
        return this.f76454b;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        a aVar = this.f76453a;
        if (aVar != null) {
            return aVar.onMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        return false;
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i11) {
        a aVar = this.f76453a;
        if (aVar != null) {
            aVar.a(viewHolder.getAdapterPosition());
        }
    }
}

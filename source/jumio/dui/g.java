package jumio.dui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class g implements RecyclerView.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.LayoutManager f56398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f56399b;

    public g(RecyclerView.LayoutManager layoutManager, RecyclerView recyclerView) {
        this.f56398a = layoutManager;
        this.f56399b = recyclerView;
    }

    public final void onChildViewAttachedToWindow(View view) {
        if (((LinearLayoutManager) this.f56398a).findLastCompletelyVisibleItemPosition() != this.f56399b.getChildCount() - 1 || ((LinearLayoutManager) this.f56398a).findFirstCompletelyVisibleItemPosition() != 0) {
            RecyclerView recyclerView = this.f56399b;
            recyclerView.setScrollBarFadeDuration(0);
            recyclerView.setVerticalFadingEdgeEnabled(false);
        }
    }

    public final void onChildViewDetachedFromWindow(View view) {
    }
}

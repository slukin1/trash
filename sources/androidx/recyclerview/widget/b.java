package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;

public final class b implements p {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.Adapter f10814b;

    public b(RecyclerView.Adapter adapter) {
        this.f10814b = adapter;
    }

    @SuppressLint({"UnknownNullness"})
    public void onChanged(int i11, int i12, Object obj) {
        this.f10814b.notifyItemRangeChanged(i11, i12, obj);
    }

    public void onInserted(int i11, int i12) {
        this.f10814b.notifyItemRangeInserted(i11, i12);
    }

    public void onMoved(int i11, int i12) {
        this.f10814b.notifyItemMoved(i11, i12);
    }

    public void onRemoved(int i11, int i12) {
        this.f10814b.notifyItemRangeRemoved(i11, i12);
    }
}

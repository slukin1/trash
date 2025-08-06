package oa;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$dimen;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f76381a;

    public b(Context context) {
        this.f76381a = context.getResources().getDimensionPixelOffset(R$dimen.dimen_10);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.set(childAdapterPosition % 3 > 0 ? this.f76381a : 0, childAdapterPosition >= 3 ? this.f76381a : 0, 0, 0);
    }
}

package oa;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$dimen;

public class l extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f76385a;

    public l(Context context) {
        this.f76385a = context.getResources().getDimensionPixelOffset(R$dimen.dimen_6);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int i11 = recyclerView.getChildAdapterPosition(view) >= 3 ? this.f76385a * 2 : 0;
        int i12 = this.f76385a;
        rect.set(i12, i11, i12, 0);
    }
}

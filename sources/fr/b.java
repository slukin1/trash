package fr;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f84126a = PixelUtils.a(10.0f);

    /* renamed from: b  reason: collision with root package name */
    public int f84127b;

    public b(int i11) {
        this.f84127b = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.top = this.f84126a;
        int i11 = this.f84127b;
        rect.left = i11 / 2;
        rect.right = i11 / 2;
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view) % 3;
        if (childLayoutPosition == 0) {
            rect.left = 0;
        } else if (childLayoutPosition == 2) {
            rect.right = 0;
        }
    }
}

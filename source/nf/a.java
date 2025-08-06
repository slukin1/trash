package nf;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;

public class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f29154a = PixelUtils.a(10.0f);

    /* renamed from: b  reason: collision with root package name */
    public int f29155b;

    public a(int i11) {
        this.f29155b = i11;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.top = this.f29154a;
        int i11 = this.f29155b;
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

package am;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f70959a;

    /* renamed from: b  reason: collision with root package name */
    public int f70960b;

    public b(int i11, int i12) {
        this.f70959a = i11;
        this.f70960b = i12;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i11 = this.f70960b;
        if (i11 == 2) {
            if (recyclerView.getChildAdapterPosition(view) % 2 == 1) {
                rect.left = this.f70959a / 2;
            } else {
                rect.right = this.f70959a / 2;
            }
        } else if (i11 <= 2) {
        } else {
            if ((recyclerView.getChildAdapterPosition(view) - 1) % 2 == 1) {
                rect.left = this.f70959a / 2;
            } else {
                rect.right = this.f70959a / 2;
            }
        }
    }
}

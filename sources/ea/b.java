package ea;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class b extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f76158a;

    /* renamed from: b  reason: collision with root package name */
    public int f76159b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76160c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76161d;

    /* renamed from: e  reason: collision with root package name */
    public int f76162e;

    /* renamed from: f  reason: collision with root package name */
    public int f76163f;

    public b(Context context, int i11, int i12, boolean z11, int i13, int i14) {
        this.f76158a = ContextCompat.getDrawable(context, i11);
        this.f76159b = i12;
        this.f76160c = z11;
        this.f76162e = i13;
        this.f76163f = i14;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0 || !this.f76161d) {
            rect.set(0, 0, 0, this.f76159b);
            return;
        }
        int i11 = this.f76159b;
        rect.set(0, i11, 0, i11);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition;
        if (recyclerView.getAdapter() != null) {
            int paddingLeft = recyclerView.getPaddingLeft() + this.f76162e;
            int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f76163f;
            int childCount = recyclerView.getChildCount();
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = recyclerView.getChildAt(i11);
                if (this.f76160c || !((childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) == -1 || childAdapterPosition == itemCount - 1)) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                    this.f76158a.setBounds(paddingLeft, bottom, width, this.f76159b + bottom);
                    this.f76158a.draw(canvas);
                }
            }
        }
    }
}

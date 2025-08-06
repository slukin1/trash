package me;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.r;

public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final int f25314a;

    /* renamed from: b  reason: collision with root package name */
    public final int f25315b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f25316c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f25317d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i11, int i12, boolean z11, boolean z12, int i13, r rVar) {
        this(i11, i12, z11, (i13 & 8) != 0 ? false : z12);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        boolean z11 = this.f25317d;
        int i11 = childAdapterPosition - (z11 ? 1 : 0);
        int i12 = this.f25314a;
        int i13 = i11 % i12;
        if (z11 && i11 == -1) {
            return;
        }
        if (this.f25316c) {
            int i14 = this.f25315b;
            rect.left = i14 - ((i13 * i14) / i12);
            rect.right = ((i13 + 1) * i14) / i12;
            if (i11 < i12) {
                rect.top = i14;
            }
            rect.bottom = i14;
            return;
        }
        int i15 = this.f25315b;
        rect.left = (i13 * i15) / i12;
        rect.right = i15 - (((i13 + 1) * i15) / i12);
        if (i11 >= i12) {
            rect.top = i15;
        }
    }

    public a(int i11, int i12, boolean z11, boolean z12) {
        this.f25314a = i11;
        this.f25315b = i12;
        this.f25316c = z11;
        this.f25317d = z12;
    }
}

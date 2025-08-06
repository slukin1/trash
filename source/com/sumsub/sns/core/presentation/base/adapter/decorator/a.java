package com.sumsub.sns.core.presentation.base.adapter.decorator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.internal.core.common.i;
import kotlin.jvm.internal.r;

public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public final float f30901a;

    /* renamed from: b  reason: collision with root package name */
    public final float f30902b;

    /* renamed from: c  reason: collision with root package name */
    public final float f30903c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30904d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f30905e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(float f11, float f12, float f13, int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? 0.0f : f11, (i12 & 2) != 0 ? 0.0f : f12, (i12 & 4) != 0 ? (float) i.a(1) : f13, i11);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        int i11 = 0;
        for (View next : ViewGroupKt.a(recyclerView)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            View view = next;
            if (i11 != childCount - 1) {
                float bottom = (float) view.getBottom();
                canvas.drawLine(this.f30901a, bottom, ((float) view.getRight()) - this.f30902b, bottom, this.f30905e);
            }
            i11 = i12;
        }
    }

    public a(float f11, float f12, float f13, int i11) {
        this.f30901a = f11;
        this.f30902b = f12;
        this.f30903c = f13;
        this.f30904d = i11;
        Paint paint = new Paint();
        paint.setColor(i11);
        paint.setStrokeWidth(f13);
        this.f30905e = paint;
    }
}

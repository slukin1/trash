package com.huobi.homemarket.view.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.h0;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.homemarket.view.decoration.FlexibleDividerDecoration;

public class a extends FlexibleDividerDecoration {

    /* renamed from: p  reason: collision with root package name */
    public b f73143p;

    /* renamed from: com.huobi.homemarket.view.decoration.a$a  reason: collision with other inner class name */
    public static class C0797a extends FlexibleDividerDecoration.d<C0797a> {

        /* renamed from: m  reason: collision with root package name */
        public b f73144m = new C0798a();

        /* renamed from: com.huobi.homemarket.view.decoration.a$a$a  reason: collision with other inner class name */
        public class C0798a implements b {
            public C0798a() {
            }

            public int a(int i11, RecyclerView recyclerView) {
                return 0;
            }

            public int b(int i11, RecyclerView recyclerView) {
                return 0;
            }
        }

        public C0797a(Context context) {
            super(context);
        }

        public a s() {
            l();
            return new a(this);
        }
    }

    public interface b {
        int a(int i11, RecyclerView recyclerView);

        int b(int i11, RecyclerView recyclerView);
    }

    public a(C0797a aVar) {
        super(aVar);
        this.f73143p = aVar.f73144m;
    }

    public Rect a(int i11, RecyclerView recyclerView, View view) {
        Rect rect = new Rect(0, 0, 0, 0);
        int Q = (int) h0.Q(view);
        int R = (int) h0.R(view);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        rect.left = recyclerView.getPaddingLeft() + this.f73143p.b(i11, recyclerView) + Q;
        rect.right = ((recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f73143p.a(i11, recyclerView)) + Q;
        int g11 = g(i11, recyclerView);
        if (this.f73108a != FlexibleDividerDecoration.DividerType.DRAWABLE) {
            if (this.f73115h) {
                rect.top = ((view.getBottom() + layoutParams.topMargin) - (g11 / 2)) + R;
            } else {
                rect.top = view.getBottom() + layoutParams.topMargin + (g11 / 2) + R;
            }
            rect.bottom = rect.top;
        } else if (this.f73115h) {
            int bottom = view.getBottom() + layoutParams.topMargin + R;
            rect.bottom = bottom;
            rect.top = bottom - g11;
        } else {
            int bottom2 = view.getBottom() + layoutParams.topMargin + R;
            rect.top = bottom2;
            rect.bottom = bottom2 + g11;
        }
        return rect;
    }

    public void d(Rect rect, int i11, RecyclerView recyclerView) {
        if (this.f73115h) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, 0, g(i11, recyclerView));
        }
    }

    public final int g(int i11, RecyclerView recyclerView) {
        FlexibleDividerDecoration.g gVar = this.f73110c;
        if (gVar != null) {
            return (int) gVar.a(i11, recyclerView).getStrokeWidth();
        }
        FlexibleDividerDecoration.h hVar = this.f73113f;
        if (hVar != null) {
            return hVar.a(i11, recyclerView);
        }
        FlexibleDividerDecoration.f fVar = this.f73112e;
        if (fVar != null) {
            return fVar.a(i11, recyclerView).getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }
}

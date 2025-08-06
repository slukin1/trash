package com.huobi.homemarket.view.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FlexibleDividerDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: o  reason: collision with root package name */
    public static final int[] f73107o = {16843284};

    /* renamed from: a  reason: collision with root package name */
    public DividerType f73108a;

    /* renamed from: b  reason: collision with root package name */
    public i f73109b;

    /* renamed from: c  reason: collision with root package name */
    public g f73110c;

    /* renamed from: d  reason: collision with root package name */
    public e f73111d;

    /* renamed from: e  reason: collision with root package name */
    public f f73112e;

    /* renamed from: f  reason: collision with root package name */
    public h f73113f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73114g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73115h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f73116i;

    /* renamed from: j  reason: collision with root package name */
    public int f73117j = -1;

    /* renamed from: k  reason: collision with root package name */
    public Paint f73118k;

    /* renamed from: l  reason: collision with root package name */
    public int f73119l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f73120m = -1;

    /* renamed from: n  reason: collision with root package name */
    public boolean f73121n;

    public enum DividerType {
        DRAWABLE,
        PAINT,
        COLOR
    }

    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Drawable f73122a;

        public a(Drawable drawable) {
            this.f73122a = drawable;
        }

        public Drawable a(int i11, RecyclerView recyclerView) {
            return this.f73122a;
        }
    }

    public class b implements h {
        public b() {
        }

        public int a(int i11, RecyclerView recyclerView) {
            return 2;
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f73125a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.homemarket.view.decoration.FlexibleDividerDecoration$DividerType[] r0 = com.huobi.homemarket.view.decoration.FlexibleDividerDecoration.DividerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f73125a = r0
                com.huobi.homemarket.view.decoration.FlexibleDividerDecoration$DividerType r1 = com.huobi.homemarket.view.decoration.FlexibleDividerDecoration.DividerType.DRAWABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f73125a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.homemarket.view.decoration.FlexibleDividerDecoration$DividerType r1 = com.huobi.homemarket.view.decoration.FlexibleDividerDecoration.DividerType.PAINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f73125a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.homemarket.view.decoration.FlexibleDividerDecoration$DividerType r1 = com.huobi.homemarket.view.decoration.FlexibleDividerDecoration.DividerType.COLOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.view.decoration.FlexibleDividerDecoration.c.<clinit>():void");
        }
    }

    public static class d<T extends d> {

        /* renamed from: a  reason: collision with root package name */
        public Context f73126a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f73127b;

        /* renamed from: c  reason: collision with root package name */
        public g f73128c;

        /* renamed from: d  reason: collision with root package name */
        public e f73129d;

        /* renamed from: e  reason: collision with root package name */
        public f f73130e;

        /* renamed from: f  reason: collision with root package name */
        public h f73131f;

        /* renamed from: g  reason: collision with root package name */
        public i f73132g = new a();

        /* renamed from: h  reason: collision with root package name */
        public boolean f73133h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f73134i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f73135j = false;

        /* renamed from: k  reason: collision with root package name */
        public int f73136k = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f73137l = -1;

        public class a implements i {
            public a() {
            }

            public boolean a(int i11, RecyclerView recyclerView) {
                return false;
            }
        }

        public class b implements e {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f73139a;

            public b(int i11) {
                this.f73139a = i11;
            }

            public int a(int i11, RecyclerView recyclerView) {
                return this.f73139a;
            }
        }

        public class c implements h {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f73141a;

            public c(int i11) {
                this.f73141a = i11;
            }

            public int a(int i11, RecyclerView recyclerView) {
                return this.f73141a;
            }
        }

        public d(Context context) {
            this.f73126a = context;
            this.f73127b = context.getResources();
        }

        public void l() {
            if (this.f73128c == null) {
                return;
            }
            if (this.f73129d != null) {
                throw new IllegalArgumentException("Use setColor method of Paint class to specify line color. Do not provider ColorProvider if you set PaintProvider.");
            } else if (this.f73131f != null) {
                throw new IllegalArgumentException("Use setStrokeWidth method of Paint class to specify line size. Do not provider SizeProvider if you set PaintProvider.");
            }
        }

        public T m(int i11) {
            return n(new b(i11));
        }

        public T n(e eVar) {
            this.f73129d = eVar;
            return this;
        }

        public T o(boolean z11) {
            this.f73133h = z11;
            return this;
        }

        public T p(int i11) {
            return q(new c(i11));
        }

        public T q(h hVar) {
            this.f73131f = hVar;
            return this;
        }
    }

    public interface e {
        int a(int i11, RecyclerView recyclerView);
    }

    public interface f {
        Drawable a(int i11, RecyclerView recyclerView);
    }

    public interface g {
        Paint a(int i11, RecyclerView recyclerView);
    }

    public interface h {
        int a(int i11, RecyclerView recyclerView);
    }

    public interface i {
        boolean a(int i11, RecyclerView recyclerView);
    }

    public FlexibleDividerDecoration(d dVar) {
        DividerType dividerType = DividerType.DRAWABLE;
        this.f73108a = dividerType;
        if (dVar.f73128c != null) {
            this.f73108a = DividerType.PAINT;
            this.f73110c = dVar.f73128c;
        } else if (dVar.f73129d != null) {
            this.f73108a = DividerType.COLOR;
            this.f73111d = dVar.f73129d;
            this.f73116i = new Paint();
            e(dVar);
        } else {
            this.f73108a = dividerType;
            if (dVar.f73130e == null) {
                TypedArray obtainStyledAttributes = dVar.f73126a.obtainStyledAttributes(f73107o);
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                this.f73112e = new a(drawable);
            } else {
                this.f73112e = dVar.f73130e;
            }
            this.f73113f = dVar.f73131f;
        }
        this.f73109b = dVar.f73132g;
        this.f73114g = dVar.f73133h;
        this.f73115h = dVar.f73134i;
        this.f73121n = dVar.f73135j;
        this.f73119l = dVar.f73136k;
        this.f73120m = dVar.f73137l;
    }

    public abstract Rect a(int i11, RecyclerView recyclerView, View view);

    public final int b(int i11, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return i11;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        return gridLayoutManager.o().getSpanGroupIndex(i11, gridLayoutManager.k());
    }

    public final int c(RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return 1;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        GridLayoutManager.SpanSizeLookup o11 = gridLayoutManager.o();
        int k11 = gridLayoutManager.k();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i11 = itemCount - 1; i11 >= 0; i11--) {
            if (o11.getSpanIndex(i11, k11) == 0) {
                return itemCount - i11;
            }
        }
        return 1;
    }

    public abstract void d(Rect rect, int i11, RecyclerView recyclerView);

    public final void e(d dVar) {
        h f11 = dVar.f73131f;
        this.f73113f = f11;
        if (f11 == null) {
            this.f73113f = new b();
        }
    }

    public final boolean f(int i11, RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager.o().getSpanIndex(i11, gridLayoutManager.k()) > 0) {
            return true;
        }
        return false;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int c11 = c(recyclerView);
        if (this.f73114g || childAdapterPosition < itemCount - c11) {
            d(rect, b(childAdapterPosition, recyclerView), recyclerView);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i11;
        int i12;
        RecyclerView recyclerView2 = recyclerView;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            int c11 = c(recyclerView2);
            int childCount = recyclerView.getChildCount();
            int i13 = -1;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = recyclerView2.getChildAt(i14);
                int childAdapterPosition = recyclerView2.getChildAdapterPosition(childAt);
                if ((!this.f73121n || childAdapterPosition != 0) && childAdapterPosition >= this.f73119l && (((i11 = this.f73120m) == -1 || childAdapterPosition != i11) && childAdapterPosition >= i13)) {
                    if ((this.f73114g || childAdapterPosition < itemCount - c11) && !f(childAdapterPosition, recyclerView2)) {
                        int b11 = b(childAdapterPosition, recyclerView2);
                        if (!this.f73109b.a(b11, recyclerView2)) {
                            Rect a11 = a(b11, recyclerView2, childAt);
                            int i15 = c.f73125a[this.f73108a.ordinal()];
                            if (i15 == 1) {
                                Drawable a12 = this.f73112e.a(b11, recyclerView2);
                                a12.setBounds(a11);
                                a12.draw(canvas);
                                i13 = childAdapterPosition;
                            } else if (i15 == 2) {
                                Paint a13 = this.f73110c.a(b11, recyclerView2);
                                this.f73116i = a13;
                                canvas.drawLine((float) a11.left, (float) a11.top, (float) a11.right, (float) a11.bottom, a13);
                            } else if (i15 == 3) {
                                this.f73116i.setColor(this.f73111d.a(b11, recyclerView2));
                                this.f73116i.setStrokeWidth((float) this.f73113f.a(b11, recyclerView2));
                                canvas.drawLine((float) a11.left, (float) a11.top, (float) a11.right, (float) a11.bottom, this.f73116i);
                                if (a11.left > 0 && (i12 = this.f73117j) != -1) {
                                    this.f73116i.setColor(i12);
                                    this.f73118k.setStrokeWidth((float) this.f73113f.a(b11, recyclerView2));
                                    canvas.drawLine(0.0f, (float) a11.top, (float) a11.left, (float) a11.bottom, this.f73118k);
                                }
                            }
                        }
                    }
                    Canvas canvas2 = canvas;
                    i13 = childAdapterPosition;
                } else {
                    Canvas canvas3 = canvas;
                }
            }
        }
    }
}

package nl;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class b implements RecyclerView.k {

    /* renamed from: a  reason: collision with root package name */
    public ml.a f76364a;

    /* renamed from: b  reason: collision with root package name */
    public View f76365b;

    /* renamed from: c  reason: collision with root package name */
    public int f76366c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f76367d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<ml.a> f76368e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f76369f;

    /* renamed from: g  reason: collision with root package name */
    public a f76370g;

    /* renamed from: h  reason: collision with root package name */
    public int f76371h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f76372i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f76373j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView.Adapter f76374k;

    /* renamed from: nl.b$b  reason: collision with other inner class name */
    public class C0816b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        public boolean f76375b;

        public C0816b() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            this.f76375b = true;
            b.this.r(motionEvent);
            if (!b.this.f76372i && b.this.f76369f && b.this.f76370g != null && b.this.f76374k != null && b.this.f76371h <= b.this.f76374k.getItemCount() - 1) {
                try {
                    b.this.f76370g.a(b.this.f76365b, b.this.f76366c, b.this.f76371h);
                } catch (IndexOutOfBoundsException e11) {
                    e11.printStackTrace();
                }
            }
            b.this.f76367d.setIsLongpressEnabled(false);
            return b.this.f76369f;
        }

        public boolean onDown(MotionEvent motionEvent) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            ml.a aVar = (ml.a) b.this.f76368e.valueAt(0);
            boolean unused = b.this.f76373j = x11 >= ((float) aVar.d()) && x11 <= ((float) aVar.e()) && y11 >= ((float) aVar.f()) && y11 <= ((float) aVar.a());
            if (!this.f76375b) {
                boolean unused2 = b.this.f76369f = false;
            } else {
                this.f76375b = false;
            }
            return super.onDown(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            b.this.r(motionEvent);
            if (!b.this.f76372i && b.this.f76369f && b.this.f76370g != null && b.this.f76374k != null && b.this.f76371h <= b.this.f76374k.getItemCount() - 1) {
                try {
                    b.this.f76370g.c(b.this.f76365b, b.this.f76366c, b.this.f76371h);
                } catch (IndexOutOfBoundsException e11) {
                    e11.printStackTrace();
                    Log.e("TAG", "GestureListener-156行-onLongPress(): " + e11);
                }
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (!b.this.f76372i && b.this.f76369f && b.this.f76370g != null && b.this.f76374k != null && b.this.f76371h <= b.this.f76374k.getItemCount() - 1) {
                try {
                    b.this.f76370g.b(b.this.f76365b, b.this.f76366c, b.this.f76371h);
                } catch (IndexOutOfBoundsException e11) {
                    e11.printStackTrace();
                }
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            b.this.r(motionEvent);
            return b.this.f76369f;
        }
    }

    public b(Context context) {
        this.f76367d = new GestureDetector(context, new C0816b());
    }

    public void m(boolean z11) {
        this.f76372i = z11;
    }

    public void n(int i11) {
        for (int i12 = 0; i12 < this.f76368e.size(); i12++) {
            ml.a valueAt = this.f76368e.valueAt(i12);
            valueAt.j(valueAt.c() + i11);
            valueAt.h(valueAt.b() + i11);
        }
    }

    public void o(int i11, View view) {
        if (this.f76368e.get(i11) == null) {
            this.f76368e.put(i11, new ml.a(view, view.getLeft(), view.getTop(), view.getLeft() + view.getMeasuredWidth(), view.getTop() + view.getMeasuredHeight()));
            return;
        }
        this.f76368e.get(i11).i(view.getLeft(), view.getTop(), view.getLeft() + view.getMeasuredWidth(), view.getTop() + view.getMeasuredHeight());
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f76374k != recyclerView.getAdapter()) {
            this.f76374k = recyclerView.getAdapter();
        }
        this.f76367d.setIsLongpressEnabled(true);
        this.f76367d.onTouchEvent(motionEvent);
        if (motionEvent.getAction() != 1 || this.f76369f || !this.f76373j) {
            return this.f76369f;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        ml.a valueAt = this.f76368e.valueAt(0);
        if (x11 < ((float) valueAt.d()) || x11 > ((float) valueAt.e()) || y11 < ((float) valueAt.f()) || y11 > ((float) valueAt.a())) {
            return false;
        }
        return true;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z11) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void p(int i11) {
        this.f76371h = i11;
    }

    public void q(a aVar) {
        this.f76370g = aVar;
    }

    public final void r(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        for (int i11 = 0; i11 < this.f76368e.size(); i11++) {
            ml.a valueAt = this.f76368e.valueAt(i11);
            if (x11 >= ((float) valueAt.d()) && x11 <= ((float) valueAt.e()) && y11 >= ((float) valueAt.f()) && y11 <= ((float) valueAt.a())) {
                this.f76369f = true;
                if (this.f76364a == null) {
                    this.f76364a = valueAt;
                } else if (valueAt.d() >= this.f76364a.d() && valueAt.e() <= this.f76364a.e() && valueAt.f() >= this.f76364a.f() && valueAt.a() <= this.f76364a.a()) {
                    this.f76364a = valueAt;
                }
            }
        }
        if (this.f76369f) {
            SparseArray<ml.a> sparseArray = this.f76368e;
            this.f76366c = sparseArray.keyAt(sparseArray.indexOfValue(this.f76364a));
            this.f76365b = this.f76364a.g();
            this.f76364a = null;
        }
    }
}

package bz;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public a f48147a;

    /* renamed from: b  reason: collision with root package name */
    public a f48148b;

    /* renamed from: c  reason: collision with root package name */
    public Context f48149c;

    /* renamed from: d  reason: collision with root package name */
    public List<T> f48150d;

    public static abstract class a extends a {

        /* renamed from: p  reason: collision with root package name */
        public b f48151p;

        public a(b bVar, Context context, RecyclerView recyclerView) {
            super(context, recyclerView);
            this.f48151p = bVar;
        }

        public int getItemCount() {
            if (this.f48151p.e()) {
                return 0;
            }
            return this.f48151p.b() + e();
        }

        public Object k(int i11) {
            List a11 = this.f48151p.a();
            if (f()) {
                i11++;
            }
            return a11.get(i11);
        }
    }

    public b(Context context) {
        this.f48149c = context;
    }

    public List<T> a() {
        return this.f48150d;
    }

    public int b() {
        List<T> list = this.f48150d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public a c() {
        return this.f48147a;
    }

    public a d() {
        return this.f48148b;
    }

    public boolean e() {
        List<T> list = this.f48150d;
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    public void f() {
        if (c() != null) {
            c().notifyDataSetChanged();
        }
        if (d() != null) {
            d().notifyDataSetChanged();
        }
    }

    public void g(a aVar, a aVar2) {
        this.f48147a = aVar;
        this.f48148b = aVar2;
    }

    public void h(List<T> list) {
        this.f48150d = list;
        f();
    }
}

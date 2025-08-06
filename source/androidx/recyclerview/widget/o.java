package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import java.util.List;

public abstract class o<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f10910a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b<T> f10911b;

    public class a implements d.b<T> {
        public a() {
        }

        public void a(List<T> list, List<T> list2) {
            o.this.d(list, list2);
        }
    }

    public o(DiffUtil.ItemCallback<T> itemCallback) {
        a aVar = new a();
        this.f10911b = aVar;
        d<T> dVar = new d<>(new b(this), new c.a(itemCallback).a());
        this.f10910a = dVar;
        dVar.a(aVar);
    }

    public T c(int i11) {
        return this.f10910a.b().get(i11);
    }

    public void d(List<T> list, List<T> list2) {
    }

    public void e(List<T> list) {
        this.f10910a.e(list);
    }

    public int getItemCount() {
        return this.f10910a.b().size();
    }
}

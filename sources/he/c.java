package he;

import android.os.Handler;
import android.view.LayoutInflater;
import androidx.databinding.f;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class c<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f25278a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<T> f25279b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f25280c = LayoutInflater.from(this.f25278a);

    /* renamed from: d  reason: collision with root package name */
    public final Handler f25281d = new Handler(this.f25278a.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<T> f25282e = new LinkedHashSet<>();

    public static final class a<B extends f> extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public B f25283a;

        public a(B b11) {
            super(b11.getRoot());
            this.f25283a = b11;
        }

        public final B e() {
            return this.f25283a;
        }
    }

    public c(FragmentActivity fragmentActivity) {
        this.f25278a = fragmentActivity;
    }

    public void a(int i11, List<? extends T> list) {
        c(i11, list, true);
    }

    public final void c(int i11, List<? extends T> list, boolean z11) {
        if (i11 == 0) {
            this.f25279b.clear();
        }
        if (list != null) {
            this.f25279b.addAll(list);
            this.f25282e.addAll(this.f25279b);
            this.f25279b.clear();
            this.f25279b.addAll(this.f25282e);
            this.f25282e.clear();
            if (z11) {
                notifyItemRangeChanged(0, this.f25279b.size());
            }
        }
    }

    public final FragmentActivity d() {
        return this.f25278a;
    }

    public final ArrayList<T> e() {
        return this.f25279b;
    }

    public final FragmentActivity f() {
        return this.f25278a;
    }

    public final ArrayList<T> g() {
        return this.f25279b;
    }

    public int getItemCount() {
        return this.f25279b.size();
    }

    public final LayoutInflater h() {
        return this.f25280c;
    }

    public final boolean i(int i11) {
        return i11 == this.f25279b.size() - 1;
    }

    public final void j(ArrayList<T> arrayList) {
        this.f25279b = arrayList;
    }

    public void onBindViewHolder(VH vh2, int i11) {
    }
}

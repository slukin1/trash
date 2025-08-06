package zendesk.belvedere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import zendesk.belvedere.c;

public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<c.b> f62269a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<c.b> f62270b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<c.b> f62271c = new ArrayList();

    public class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* renamed from: zendesk.belvedere.b$b  reason: collision with other inner class name */
    public interface C0682b {
        boolean a(c.b bVar);

        void b();
    }

    public void a(c.b bVar) {
        e(Collections.singletonList(bVar), this.f62270b);
    }

    public void c(List<c.b> list) {
        e(this.f62269a, list);
    }

    public void d(List<MediaResult> list) {
        ArrayList<c.b> arrayList = new ArrayList<>(this.f62270b);
        HashSet hashSet = new HashSet();
        for (MediaResult originalUri : list) {
            hashSet.add(originalUri.getOriginalUri());
        }
        for (c.b bVar : arrayList) {
            bVar.f(hashSet.contains(bVar.d().getOriginalUri()));
        }
        e(this.f62269a, arrayList);
    }

    public final void e(List<c.b> list, List<c.b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        this.f62269a = list;
        this.f62270b = list2;
        this.f62271c = arrayList;
    }

    public int getItemCount() {
        return this.f62271c.size();
    }

    public long getItemId(int i11) {
        return this.f62271c.get(i11).b();
    }

    public int getItemViewType(int i11) {
        return this.f62271c.get(i11).c();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        this.f62271c.get(i11).a(viewHolder.itemView);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false));
    }
}

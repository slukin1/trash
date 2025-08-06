package v9;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s9.a;
import s9.c;
import s9.d;

public class b<T extends a> extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f76601a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Integer> f76602b = new HashMap();

    public b(List<T> list) {
        h(list);
    }

    public List<T> c() {
        return this.f76601a;
    }

    public T d(int i11) {
        return (a) this.f76601a.get(i11);
    }

    /* renamed from: e */
    public void onBindViewHolder(c cVar, int i11) {
        c a11;
        a d11 = d(i11);
        if (d11 != null) {
            String viewHandlerName = d11.getViewHandlerName();
            if (!TextUtils.isEmpty(viewHandlerName) && (a11 = ViewHandlerFactory.a(viewHandlerName)) != null) {
                a11.handleView(cVar, i11, d(i11), (ViewGroup) cVar.itemView.getParent());
            }
        }
    }

    /* renamed from: f */
    public void onBindViewHolder(c cVar, int i11, List<Object> list) {
        c a11;
        if (list == null || list.isEmpty()) {
            super.onBindViewHolder(cVar, i11, list);
            return;
        }
        a d11 = d(i11);
        if (d11 != null) {
            String viewHandlerName = d11.getViewHandlerName();
            if (TextUtils.isEmpty(viewHandlerName) || (a11 = ViewHandlerFactory.a(viewHandlerName)) == null) {
                return;
            }
            if (a11 instanceof d) {
                ((d) a11).a(cVar, i11, d(i11), (ViewGroup) cVar.itemView.getParent(), list);
                return;
            }
            a11.handleView(cVar, i11, d(i11), (ViewGroup) cVar.itemView.getParent());
        }
    }

    /* renamed from: g */
    public c onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return c.b(viewGroup, this.f76602b.get(Integer.valueOf(i11)).intValue());
    }

    public int getItemCount() {
        List<T> list = this.f76601a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemViewType(int i11) {
        a d11 = d(i11);
        if (d11 == null) {
            return 0;
        }
        c a11 = ViewHandlerFactory.a(d11.getViewHandlerName());
        this.f76602b.put(Integer.valueOf(a11.getClass().hashCode()), Integer.valueOf(a11.getResId()));
        return a11.getClass().hashCode();
    }

    public void h(List<T> list) {
        this.f76601a = list;
    }
}

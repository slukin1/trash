package v9;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s9.a;
import s9.c;
import s9.d;

public class a<T extends s9.a> extends RecyclerView.Adapter<c> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f76598a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, Integer> f76599b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public View f76600c;

    public a(List<T> list) {
        i(list);
    }

    public List<T> c() {
        return this.f76598a;
    }

    public T d(int i11) {
        return (s9.a) this.f76598a.get(i11);
    }

    public int e(T t11) {
        List<T> list = this.f76598a;
        if (list != null && list.contains(t11)) {
            try {
                return this.f76598a.indexOf(t11);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return -1;
    }

    /* renamed from: f */
    public void onBindViewHolder(c cVar, int i11) {
        c a11;
        s9.a d11 = d(i11);
        if (d11 != null) {
            String viewHandlerName = d11.getViewHandlerName();
            if (!TextUtils.isEmpty(viewHandlerName) && (a11 = ViewHandlerFactory.a(viewHandlerName)) != null) {
                a11.handleView(cVar, i11, d(i11), (ViewGroup) cVar.itemView.getParent());
            }
        }
    }

    /* renamed from: g */
    public void onBindViewHolder(c cVar, int i11, List<Object> list) {
        c a11;
        if (list == null || list.isEmpty()) {
            onBindViewHolder(cVar, i11);
            return;
        }
        s9.a d11 = d(i11);
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

    public int getItemCount() {
        List<T> list = this.f76598a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemViewType(int i11) {
        s9.a d11 = d(i11);
        if (d11 == null) {
            return 0;
        }
        c a11 = ViewHandlerFactory.a(d11.getViewHandlerName());
        this.f76599b.put(Integer.valueOf(a11.getClass().hashCode()), Integer.valueOf(a11.getResId()));
        return a11.getClass().hashCode();
    }

    /* renamed from: h */
    public c onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (this.f76599b.get(Integer.valueOf(i11)) != null && this.f76599b.get(Integer.valueOf(i11)).intValue() != 0) {
            return c.b(viewGroup, this.f76599b.get(Integer.valueOf(i11)).intValue());
        }
        if (this.f76600c.getParent() != null) {
            return c.a(new View(viewGroup.getContext()));
        }
        return c.a(this.f76600c);
    }

    public void i(List<T> list) {
        this.f76598a = list;
    }

    public void j(View view) {
        this.f76600c = view;
    }
}

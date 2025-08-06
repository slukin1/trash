package u9;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.hbg.lib.widgets.adapter.ViewHandlerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s9.a;
import s9.c;

public class a<T extends s9.a> extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public int f76592b;

    /* renamed from: c  reason: collision with root package name */
    public int f76593c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f76594d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f76595e;

    public a(List<T> list) {
        this(list, 1);
    }

    /* renamed from: a */
    public T getItem(int i11) {
        return (s9.a) this.f76595e.get(i11);
    }

    public void b(List<T> list) {
        this.f76595e = list;
    }

    public int getCount() {
        List<T> list = this.f76595e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public int getItemViewType(int i11) {
        c a11 = ViewHandlerFactory.a(getItem(i11).getViewHandlerName());
        Integer num = this.f76594d.get(a11.getClass().getName());
        if (num == null) {
            int i12 = this.f76593c;
            this.f76593c = i12 + 1;
            num = Integer.valueOf(i12);
            this.f76594d.put(a11.getClass().getName(), num);
        }
        return num.intValue();
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        c a11 = ViewHandlerFactory.a(getItem(i11).getViewHandlerName());
        b a12 = b.a(viewGroup.getContext(), view, viewGroup, a11.getResId());
        a11.handleView(a12, i11, getItem(i11), viewGroup);
        return a12.b();
    }

    public int getViewTypeCount() {
        return this.f76592b;
    }

    public a(List<T> list, int i11) {
        this.f76593c = 0;
        b(list);
        this.f76592b = i11;
        this.f76594d = new HashMap();
    }
}

package ja;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.recycler.holder.BaseViewHolder;
import com.hbg.lib.widgets.recycler.holder.IViewHolder;
import java.util.List;
import ka.a;

public class a<I extends ka.a> extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f76223a;

    /* renamed from: b  reason: collision with root package name */
    public List<I> f76224b;

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<String> f76225c = new SparseArray<>();

    public a(Context context, List<I> list) {
        this.f76223a = context;
        e(list);
    }

    public I c(int i11) {
        if (this.f76224b == null || i11 < 0 || i11 >= getItemCount()) {
            return null;
        }
        return (ka.a) this.f76224b.get(i11);
    }

    public final BaseViewHolder d(Context context, String str, int i11, ViewGroup viewGroup) {
        try {
            return (BaseViewHolder) Class.forName(str).getConstructor(new Class[]{Context.class, View.class}).newInstance(new Object[]{context, LayoutInflater.from(context).inflate(i11, viewGroup, false)});
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public void e(List<I> list) {
        this.f76224b = list;
    }

    public int getItemCount() {
        List<I> list = this.f76224b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i11) {
        ka.a c11 = c(i11);
        if (c11 == null) {
            return super.getItemViewType(i11);
        }
        this.f76225c.put(c11.getResId(), c11.getViewHandlerName());
        return c11.getResId();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ka.a c11 = c(i11);
        if ((viewHolder instanceof IViewHolder) && c11 != null) {
            ((IViewHolder) viewHolder).bind(c11, i11);
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return d(this.f76223a, this.f76225c.get(i11), i11, viewGroup);
    }
}

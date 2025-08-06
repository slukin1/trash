package og;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class g extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<EasyRecyclerView<s9.a>> f47674a;

    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public g(List<EasyRecyclerView<s9.a>> list) {
        if (this.f47674a == null) {
            this.f47674a = new ArrayList();
        }
        if (list != null) {
            this.f47674a.clear();
            this.f47674a.addAll(list);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        FrameLayout frameLayout = (FrameLayout) aVar.itemView;
        frameLayout.removeAllViews();
        frameLayout.addView(this.f47674a.get(i11));
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new a(frameLayout);
    }

    public void d(List<EasyRecyclerView<s9.a>> list) {
        this.f47674a.clear();
        this.f47674a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<EasyRecyclerView<s9.a>> list = this.f47674a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

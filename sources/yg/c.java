package yg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class c extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<EasyRecyclerView<wl.c>> f48106a;

    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public c(List<EasyRecyclerView<wl.c>> list) {
        if (this.f48106a == null) {
            this.f48106a = new ArrayList();
        }
        if (list != null) {
            this.f48106a.clear();
            this.f48106a.addAll(list);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        FrameLayout frameLayout = (FrameLayout) aVar.itemView;
        frameLayout.removeAllViews();
        if (!(this.f48106a.get(i11) == null || this.f48106a.get(i11).getParent() == null)) {
            ((FrameLayout) this.f48106a.get(i11).getParent()).removeAllViews();
        }
        frameLayout.addView(this.f48106a.get(i11));
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.index_market_page_layout_view, viewGroup, false));
    }

    public void d(List<EasyRecyclerView<wl.c>> list) {
        this.f48106a.clear();
        this.f48106a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<EasyRecyclerView<wl.c>> list = this.f48106a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

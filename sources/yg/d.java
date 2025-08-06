package yg;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.index.bean.IndexFeatureItem;
import java.util.ArrayList;
import java.util.List;

public class d extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<EasyRecyclerView<IndexFeatureItem>> f48107a;

    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public d(List<EasyRecyclerView<IndexFeatureItem>> list) {
        if (this.f48107a == null) {
            this.f48107a = new ArrayList();
        }
        if (list != null) {
            this.f48107a.clear();
            this.f48107a.addAll(list);
        }
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i11) {
        FrameLayout frameLayout = (FrameLayout) aVar.itemView;
        frameLayout.removeAllViews();
        frameLayout.addView(this.f48107a.get(i11));
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new a(frameLayout);
    }

    public void d(List<EasyRecyclerView<IndexFeatureItem>> list) {
        this.f48107a.clear();
        this.f48107a.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<EasyRecyclerView<IndexFeatureItem>> list = this.f48107a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}

package mv;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.copytrading.widget.HBNestedScrollView;
import java.util.List;

public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List<View> f22969a;

    /* renamed from: mv.a$a  reason: collision with other inner class name */
    public static final class C0202a extends RecyclerView.ViewHolder {
        public C0202a(HBNestedScrollView hBNestedScrollView) {
            super(hBNestedScrollView);
        }
    }

    public a(List<? extends View> list) {
        this.f22969a = list;
    }

    public int getItemCount() {
        return this.f22969a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ((ViewGroup) viewHolder.itemView).addView(this.f22969a.get(i11), new ViewGroup.LayoutParams(-1, -1));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        HBNestedScrollView hBNestedScrollView = new HBNestedScrollView(viewGroup.getContext());
        hBNestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new C0202a(hBNestedScrollView);
    }
}

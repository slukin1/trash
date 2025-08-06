package bz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.wtree.helper.Utils;
import java.util.List;

public abstract class a<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final int f48128a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final int f48129b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f48130c = 3;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48131d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48132e;

    /* renamed from: f  reason: collision with root package name */
    public List<T> f48133f;

    /* renamed from: g  reason: collision with root package name */
    public Context f48134g;

    /* renamed from: h  reason: collision with root package name */
    public int f48135h = 5;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f48136i;

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f48137j;

    /* renamed from: k  reason: collision with root package name */
    public int f48138k;

    /* renamed from: l  reason: collision with root package name */
    public int f48139l = 0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f48140m = false;

    /* renamed from: n  reason: collision with root package name */
    public Fragment f48141n;

    /* renamed from: o  reason: collision with root package name */
    public LayoutInflater f48142o;

    /* renamed from: bz.a$a  reason: collision with other inner class name */
    public static class C0588a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f48143a;

        /* renamed from: b  reason: collision with root package name */
        public View f48144b;

        /* renamed from: c  reason: collision with root package name */
        public View f48145c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f48146d;

        public C0588a(View view) {
            super(view);
            this.f48143a = view.findViewById(R$id.rl_loading);
            this.f48144b = view.findViewById(R$id.rl_error_retry_view);
            this.f48145c = view.findViewById(R$id.lin_content);
            this.f48146d = (TextView) view.findViewById(R$id.tv_error_state);
        }

        public void a(int i11, View.OnClickListener onClickListener) {
            if (!(i11 == 5 || onClickListener == null)) {
                this.f48144b.setOnClickListener(onClickListener);
            }
            b(i11, onClickListener);
        }

        public void b(int i11, View.OnClickListener onClickListener) {
            if (i11 == 5) {
                this.f48143a.setVisibility(0);
                this.f48144b.setVisibility(8);
                this.f48145c.setVisibility(0);
                this.itemView.setVisibility(0);
            } else if (i11 == 10) {
                this.f48145c.setVisibility(8);
                this.f48143a.setVisibility(8);
                this.f48144b.setVisibility(8);
                this.itemView.setVisibility(8);
                this.f48146d.setText("隐藏");
            } else {
                this.itemView.setVisibility(0);
                this.f48143a.setVisibility(8);
                this.f48145c.setVisibility(0);
                this.f48144b.setVisibility(0);
                this.f48144b.setEnabled(true);
                if (onClickListener != null) {
                    this.f48144b.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public a(Context context, RecyclerView recyclerView) {
        this.f48134g = context;
        this.f48137j = recyclerView;
        this.f48139l = (context.getResources().getDisplayMetrics().widthPixels - Utils.a(context, 24.0f)) / 2;
        this.f48142o = LayoutInflater.from(this.f48134g);
    }

    public int c() {
        return this.f48135h;
    }

    public void clear() {
        List<T> list = this.f48133f;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public int d(int i11) {
        return -1;
    }

    public int e() {
        return (this.f48132e ? 1 : 0) + (this.f48131d ? 1 : 0);
    }

    public boolean f() {
        return this.f48131d;
    }

    public abstract void g(RecyclerView.ViewHolder viewHolder, int i11);

    public abstract int getItemCount();

    public int getItemViewType(int i11) {
        if (this.f48131d && i11 == 0) {
            return 1;
        }
        if (this.f48132e && i11 == getItemCount() - 1) {
            return 3;
        }
        int d11 = d(i11);
        if (d11 == -1) {
            return 2;
        }
        return d11;
    }

    public RecyclerView.ViewHolder h(ViewGroup viewGroup, int i11) {
        return null;
    }

    public abstract RecyclerView.ViewHolder i(ViewGroup viewGroup, int i11);

    public void j(boolean z11) {
        this.f48132e = z11;
        this.f48138k = z11 ? 1 : 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        int itemViewType = getItemViewType(i11);
        if (itemViewType != 1) {
            if (itemViewType != 3) {
                g(viewHolder, i11);
            } else if (viewHolder instanceof C0588a) {
                ((C0588a) viewHolder).a(this.f48135h, this.f48136i);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 1) {
            return h(viewGroup, i11);
        }
        if (i11 == 3) {
            return new C0588a(View.inflate(this.f48134g, R$layout.item_foot_view_layout, (ViewGroup) null));
        }
        return i(viewGroup, i11);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f48141n = null;
        clear();
    }
}

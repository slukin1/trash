package dz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.exoplayer2.audio.AacUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view.JCameraView;
import com.yanzhenjie.recyclerview.swipe.R$id;
import com.yanzhenjie.recyclerview.swipe.R$layout;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuLayout;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuView;
import java.lang.reflect.Field;
import java.util.List;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public SparseArrayCompat<View> f52806a = new SparseArrayCompat<>();

    /* renamed from: b  reason: collision with root package name */
    public SparseArrayCompat<View> f52807b = new SparseArrayCompat<>();

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView.Adapter f52808c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f52809d;

    /* renamed from: e  reason: collision with root package name */
    public e f52810e;

    /* renamed from: f  reason: collision with root package name */
    public g f52811f;

    /* renamed from: g  reason: collision with root package name */
    public b f52812g;

    /* renamed from: dz.a$a  reason: collision with other inner class name */
    public class C0645a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f52813b;

        public C0645a(RecyclerView.ViewHolder viewHolder) {
            this.f52813b = viewHolder;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            a.this.f52812g.onItemClick(view, this.f52813b.getAdapterPosition());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    public a(Context context, RecyclerView.Adapter adapter) {
        this.f52809d = LayoutInflater.from(context);
        this.f52808c = adapter;
    }

    public void addFooterView(View view) {
        this.f52807b.m(d() + JCameraView.MEDIA_QUALITY_DESPAIR, view);
    }

    public void addHeaderView(View view) {
        this.f52806a.m(e() + AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, view);
    }

    public final int c() {
        return this.f52808c.getItemCount();
    }

    public int d() {
        return this.f52807b.p();
    }

    public int e() {
        return this.f52806a.p();
    }

    public RecyclerView.Adapter f() {
        return this.f52808c;
    }

    public final Class<?> g(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == null || superclass.equals(Object.class)) ? cls : g(superclass);
    }

    public int getItemCount() {
        return e() + c() + d();
    }

    public long getItemId(int i11) {
        if (isHeaderView(i11) || isFooterView(i11)) {
            return super.getItemId(i11);
        }
        return this.f52808c.getItemId(i11);
    }

    public int getItemViewType(int i11) {
        if (isHeaderView(i11)) {
            return this.f52806a.l(i11);
        }
        if (isFooterView(i11)) {
            return this.f52807b.l((i11 - e()) - c());
        }
        return this.f52808c.getItemViewType(i11 - e());
    }

    public void h(b bVar) {
        this.f52812g = bVar;
    }

    public void i(e eVar) {
        this.f52810e = eVar;
    }

    public boolean isFooterView(int i11) {
        return i11 >= e() + c();
    }

    public boolean isHeaderView(int i11) {
        return i11 >= 0 && i11 < e();
    }

    public void j(g gVar) {
        this.f52811f = gVar;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f52808c.onAttachedToRecyclerView(recyclerView);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11, List<Object> list) {
        if (!isHeaderView(i11) && !isFooterView(i11)) {
            View view = viewHolder.itemView;
            if (view instanceof SwipeMenuLayout) {
                SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
                int childCount = swipeMenuLayout.getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = swipeMenuLayout.getChildAt(i12);
                    if (childAt instanceof SwipeMenuView) {
                        ((SwipeMenuView) childAt).a(viewHolder);
                    }
                }
            }
            this.f52808c.onBindViewHolder(viewHolder, i11 - e(), list);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (this.f52806a.g(i11) != null) {
            return new b(this.f52806a.g(i11));
        }
        if (this.f52807b.g(i11) != null) {
            return new b(this.f52807b.g(i11));
        }
        RecyclerView.ViewHolder onCreateViewHolder = this.f52808c.onCreateViewHolder(viewGroup, i11);
        if (this.f52812g != null) {
            onCreateViewHolder.itemView.setOnClickListener(new C0645a(onCreateViewHolder));
        }
        if (this.f52810e == null) {
            return onCreateViewHolder;
        }
        SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) this.f52809d.inflate(R$layout.recycler_swipe_view_item, viewGroup, false);
        c cVar = new c(swipeMenuLayout, i11);
        c cVar2 = new c(swipeMenuLayout, i11);
        this.f52810e.a(cVar, cVar2, i11);
        if (cVar.a().size() > 0) {
            SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.findViewById(R$id.swipe_left);
            swipeMenuView.setOrientation(cVar.b());
            swipeMenuView.c(cVar, swipeMenuLayout, this.f52811f, 1);
        }
        if (cVar2.a().size() > 0) {
            SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.findViewById(R$id.swipe_right);
            swipeMenuView2.setOrientation(cVar2.b());
            swipeMenuView2.c(cVar2, swipeMenuLayout, this.f52811f, -1);
        }
        ((ViewGroup) swipeMenuLayout.findViewById(R$id.swipe_content)).addView(onCreateViewHolder.itemView);
        try {
            Field declaredField = g(onCreateViewHolder.getClass()).getDeclaredField("itemView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(onCreateViewHolder, swipeMenuLayout);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return onCreateViewHolder;
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f52808c.onDetachedFromRecyclerView(recyclerView);
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (isHeaderView(adapterPosition) || isFooterView(adapterPosition)) {
            return false;
        }
        return this.f52808c.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (isHeaderView(adapterPosition) || isFooterView(adapterPosition)) {
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).c(true);
                return;
            }
            return;
        }
        this.f52808c.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!isHeaderView(adapterPosition) && !isFooterView(adapterPosition)) {
            this.f52808c.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!isHeaderView(adapterPosition) && !isFooterView(adapterPosition)) {
            this.f52808c.onViewRecycled(viewHolder);
        }
    }

    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    public void setHasStableIds(boolean z11) {
        this.f52808c.setHasStableIds(z11);
    }

    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
    }
}

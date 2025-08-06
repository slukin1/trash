package com.huobi.index.ui.widget;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.index.bean.IndexFeatureItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import java.util.List;
import pro.huobi.R;

public class QuickAdditionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<IndexFeatureItem> f74062a;

    /* renamed from: b  reason: collision with root package name */
    public c f74063b;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f74064b;

        public a(RecyclerView.ViewHolder viewHolder) {
            this.f74064b = viewHolder;
        }

        public void onGlobalLayout() {
            int lineCount = ((b) this.f74064b).f74068d.getLineCount();
            Log.d("QuickAdditionAdapter", "position:" + this.f74064b.getBindingAdapterPosition() + " 行数:" + lineCount);
            if (lineCount > 1) {
                ((b) this.f74064b).f74068d.setTextSize(1, 9.0f);
            } else {
                ((b) this.f74064b).f74068d.setTextSize(1, 11.0f);
            }
            ((b) this.f74064b).f74068d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static class b extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public c f74066b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f74067c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f74068d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f74069e;

        public b(View view, c cVar) {
            super(view);
            view.setOnClickListener(this);
            this.f74066b = cVar;
            this.f74067c = (ImageView) view.findViewById(R.id.item_image);
            this.f74068d = (TextView) view.findViewById(R.id.item_name);
            this.f74069e = (ImageView) view.findViewById(R.id.item_select_icon);
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (this.f74066b != null && this.f74069e.getVisibility() == 0) {
                this.f74066b.onItemClick(view, getBindingAdapterPosition());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface c {
        void onItemClick(View view, int i11);
    }

    public void a(c cVar) {
        this.f74063b = cVar;
    }

    public void c(List<IndexFeatureItem> list) {
        this.f74062a = list;
    }

    public int getItemCount() {
        List<IndexFeatureItem> list = this.f74062a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        List<IndexFeatureItem> list = this.f74062a;
        if (list != null && list.get(i11) != null) {
            int i12 = NightHelper.e().g() ? R.drawable.home_ac_image_night : R.drawable.home_ac_image;
            IndexFeatureItem indexFeatureItem = this.f74062a.get(i11);
            b bVar = (b) viewHolder;
            f6.c.a().f(bVar.f74067c, indexFeatureItem.getNewImgUrl(), i12);
            bVar.f74068d.setText(indexFeatureItem.getTitle());
            bVar.f74068d.getViewTreeObserver().addOnGlobalLayoutListener(new a(viewHolder));
            if ("1".equals(indexFeatureItem.getHomePageFixed())) {
                bVar.f74069e.setVisibility(8);
                return;
            }
            bVar.f74069e.setVisibility(0);
            bVar.f74069e.setImageResource(indexFeatureItem.isSelected() ? R.drawable.quick_addition_selected : R.drawable.quick_addition_unselected);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quick_addition_list_item, viewGroup, false);
        int g11 = ((int) (((float) n.g(viewGroup.getContext())) - ((n.e() * 2.0f) * 4.0f))) / 5;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g11, g11);
        layoutParams.topMargin = (int) (n.e() * 2.0f);
        inflate.setLayoutParams(layoutParams);
        return new b(inflate, this.f74063b);
    }
}

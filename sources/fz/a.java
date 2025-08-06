package fz;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.youth.banner.adapter.BannerAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerAdapter f54759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f54760c;

    public /* synthetic */ a(BannerAdapter bannerAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f54759b = bannerAdapter;
        this.f54760c = viewHolder;
    }

    public final void onClick(View view) {
        this.f54759b.lambda$onCreateViewHolder$1(this.f54760c, view);
    }
}

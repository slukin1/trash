package com.huobi.lancher.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import wm.e;
import wm.f;
import wm.g;

public class GuidePageAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<e> f74930a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public g f74931b;

    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f74932a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f74933b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f74934c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f74935d;

        public a(View view) {
            super(view);
            initView();
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(View view) {
            if (GuidePageAdapter.this.f74931b != null) {
                GuidePageAdapter.this.f74931b.a(getLayoutPosition());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final void c(int i11) {
            e eVar = (e) GuidePageAdapter.this.f74930a.get(i11);
            this.f74933b.setImageResource(eVar.f76661a);
            this.f74934c.setText(eVar.f76662b);
            this.f74935d.setText(eVar.f76663c);
        }

        public final void initView() {
            this.f74932a = this.itemView.findViewById(R.id.guide_btn_skip);
            this.f74933b = (ImageView) this.itemView.findViewById(R.id.guide_image);
            this.f74934c = (TextView) this.itemView.findViewById(R.id.guide_title);
            this.f74935d = (TextView) this.itemView.findViewById(R.id.guide_sub_title);
            this.f74932a.setOnClickListener(new f(this));
        }
    }

    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i11) {
        aVar.c(i11);
    }

    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_welcome_step, viewGroup, false));
    }

    public void f(g gVar) {
        this.f74931b = gVar;
    }

    public int getItemCount() {
        return this.f74930a.size();
    }

    public void setData(List<e> list) {
        this.f74930a.clear();
        this.f74930a.addAll(list);
        notifyDataSetChanged();
    }
}

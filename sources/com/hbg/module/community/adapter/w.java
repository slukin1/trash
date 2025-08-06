package com.hbg.module.community.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.ContentUGCModel;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import lc.a6;
import rd.s;

public final class w extends c<ContentUGCModel.UGCTaskModel, c.a<a6>> {

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17227b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17228c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ContentUGCModel.UGCTaskModel f17229d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f17230e;

        public a(View view, long j11, ContentUGCModel.UGCTaskModel uGCTaskModel, w wVar) {
            this.f17227b = view;
            this.f17228c = j11;
            this.f17229d = uGCTaskModel;
            this.f17230e = wVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17227b) > this.f17228c || (this.f17227b instanceof Checkable)) {
                sVar.e(this.f17227b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17227b;
                if (this.f17229d.status != 4 && b.e(this.f17230e.f())) {
                    b2.a.d().a("/webView/index").withString("url", this.f17229d.url).navigation(this.f17230e.f());
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public w(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    /* renamed from: k */
    public void onBindViewHolder(c.a<a6> aVar, int i11) {
        super.onBindViewHolder(aVar, i11);
        ContentUGCModel.UGCTaskModel uGCTaskModel = (ContentUGCModel.UGCTaskModel) g().get(i11);
        aVar.e().M(uGCTaskModel);
        Float valueOf = Float.valueOf(12.0f);
        if (i11 == 0) {
            aVar.e().J.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = aVar.e().K.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = sd.a.b(valueOf);
            }
        } else if (i11 == getItemCount() - 1) {
            aVar.e().J.setVisibility(8);
            ViewGroup.LayoutParams layoutParams2 = aVar.e().K.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = sd.a.b(Float.valueOf(16.0f));
            }
        } else {
            ViewGroup.LayoutParams layoutParams3 = aVar.e().K.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = sd.a.b(valueOf);
            }
            aVar.e().J.setVisibility(8);
        }
        int i12 = uGCTaskModel.status;
        if (i12 == 1) {
            aVar.e().E.setBackgroundResource(R$drawable.shape_next_btn_bg);
            if (uGCTaskModel.totalCount <= 1 || uGCTaskModel.finishCount <= 0) {
                aVar.e().F.setText(f().getResources().getString(R$string.n_content_ugc_to_complete_task));
            } else {
                aVar.e().F.setText(f().getResources().getString(R$string.n_content_ugc_task_finished));
                TextView textView = aVar.e().F;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(uGCTaskModel.finishCount);
                sb2.append('/');
                sb2.append(uGCTaskModel.totalCount);
                textView.append(sb2.toString());
            }
            aVar.e().F.setVisibility(0);
            aVar.e().C.setVisibility(8);
            aVar.e().G.setVisibility(8);
        } else if (i12 == 2) {
            aVar.e().E.setBackgroundResource(R$drawable.shape_next_btn_bg);
            aVar.e().F.setText(f().getResources().getString(R$string.n_content_ugc_pending_awards));
            aVar.e().F.setVisibility(0);
            aVar.e().C.setVisibility(8);
            aVar.e().G.setVisibility(8);
        } else if (i12 != 3) {
            aVar.e().E.setBackgroundResource(R$drawable.shape_ugc_finish_btn_bg);
            aVar.e().F.setVisibility(8);
            aVar.e().C.setImageResource(R$drawable.ic_task_already_get_gift);
            ViewGroup.LayoutParams layoutParams4 = aVar.e().C.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.width = sd.a.b(Float.valueOf(20.0f));
                layoutParams4.height = sd.a.b(Float.valueOf(20.0f));
            }
            aVar.e().C.setVisibility(0);
            aVar.e().G.setText(f().getResources().getString(R$string.n_content_ugc_coin_received));
            aVar.e().G.setVisibility(0);
        } else {
            aVar.e().E.setBackgroundResource(R$drawable.shape_next_btn_bg);
            aVar.e().F.setVisibility(8);
            aVar.e().C.setImageResource(R$drawable.ic_ugc_task_gift);
            ViewGroup.LayoutParams layoutParams5 = aVar.e().C.getLayoutParams();
            if (layoutParams5 != null) {
                layoutParams5.width = sd.a.b(Float.valueOf(18.0f));
                layoutParams5.height = sd.a.b(Float.valueOf(18.0f));
            }
            aVar.e().C.setVisibility(0);
            aVar.e().G.setText(f().getResources().getString(R$string.n_content_ugc_coin_obtained));
            aVar.e().G.setVisibility(0);
        }
        s sVar = s.f23381a;
        RelativeLayout relativeLayout = aVar.e().E;
        relativeLayout.setOnClickListener(new a(relativeLayout, 800, uGCTaskModel, this));
    }

    /* renamed from: l */
    public c.a<a6> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(a6.K(h(), viewGroup, false));
    }
}

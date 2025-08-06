package com.hbg.module.content.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.SisterBean;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$string;
import com.hbg.module.content.helper.live.f;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import java.util.ArrayList;
import lc.q5;

public final class t extends c<SisterBean, c.a<q5>> {

    /* renamed from: f  reason: collision with root package name */
    public r f17941f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f17942g = new ArrayList<>();

    public t(FragmentActivity fragmentActivity, r rVar) {
        super(fragmentActivity);
        this.f17941f = rVar;
    }

    @SensorsDataInstrumented
    public static final void n(t tVar, SisterBean sisterBean, int i11, View view) {
        boolean z11 = false;
        if (tVar.f17942g.contains(sisterBean.uniqueUid)) {
            tVar.f17942g.remove(sisterBean.uniqueUid);
            f fVar = f.f18246a;
            fVar.h(fVar.b() - 1);
            tVar.f17941f.a(false);
        } else {
            tVar.f17942g.add(sisterBean.uniqueUid);
            f fVar2 = f.f18246a;
            fVar2.h(fVar2.b() + 1);
            r rVar = tVar.f17941f;
            if (tVar.f17942g.size() == tVar.g().size()) {
                z11 = true;
            }
            rVar.a(z11);
        }
        tVar.notifyItemChanged(i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public final ArrayList<String> l() {
        return this.f17942g;
    }

    /* renamed from: m */
    public void onBindViewHolder(c.a<q5> aVar, int i11) {
        String str;
        super.onBindViewHolder(aVar, i11);
        SisterBean sisterBean = (SisterBean) g().get(i11);
        aVar.e().M(sisterBean);
        TextView textView = aVar.e().E;
        if (i11 == 0) {
            str = f().getResources().getString(R$string.n_live_gift_live_owner);
        } else {
            str = "No." + (i11 + 1);
        }
        textView.setText(str);
        if (this.f17942g.contains(sisterBean.uniqueUid)) {
            aVar.e().C.setVisibility(0);
            aVar.e().E.setBackgroundResource(R$drawable.bg_sister_name_sel);
        } else {
            aVar.e().C.setVisibility(8);
            aVar.e().E.setBackgroundResource(R$drawable.bg_sister_name);
        }
        if (i11 == 0) {
            aVar.e().F.setVisibility(0);
        } else {
            aVar.e().F.setVisibility(8);
        }
        if (i11 == g().size() - 1) {
            aVar.e().G.setVisibility(0);
        } else {
            aVar.e().G.setVisibility(8);
        }
        aVar.e().D.setOnClickListener(new s(this, sisterBean, i11));
    }

    /* renamed from: o */
    public c.a<q5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(q5.K(h(), viewGroup, false));
    }
}

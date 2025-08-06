package com.hbg.module.content.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.libkt.utils.r;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import he.c;
import lc.y5;

public final class v extends c<TraderRank.TraderInfo, c.a<y5>> {

    /* renamed from: f  reason: collision with root package name */
    public int f17946f;

    /* renamed from: g  reason: collision with root package name */
    public String f17947g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17948h;

    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17950c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TraderRank.TraderInfo f17951d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f17952e;

        public a(View view, long j11, TraderRank.TraderInfo traderInfo, v vVar) {
            this.f17949b = view;
            this.f17950c = j11;
            this.f17951d = traderInfo;
            this.f17952e = vVar;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            r rVar = r.f24939a;
            if (currentTimeMillis - rVar.b(this.f17949b) > this.f17950c || (this.f17949b instanceof Checkable)) {
                rVar.e(this.f17949b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17949b;
                Postcard a11 = b2.a.d().a("/webView/index");
                BaseModuleConfig.a a12 = BaseModuleConfig.a();
                a11.withString("url", a12.k("tradingbot/h5/futures/trader-detail?login=1&userSign=" + this.f17951d.userSign)).navigation(this.f17952e.f());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public v(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @SensorsDataInstrumented
    public static final void n(v vVar, int i11, TraderRank.TraderInfo traderInfo, View view) {
        if (vVar.f17946f != i11) {
            vVar.f17946f = i11;
            vVar.f17947g = traderInfo.userSign;
            vVar.notifyDataSetChanged();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public final String l() {
        return this.f17947g;
    }

    /* renamed from: m */
    public void onBindViewHolder(c.a<y5> aVar, int i11) {
        int i12;
        int i13;
        String str;
        int i14;
        super.onBindViewHolder(aVar, i11);
        TraderRank.TraderInfo traderInfo = (TraderRank.TraderInfo) g().get(i11);
        aVar.e().M(traderInfo);
        r rVar = r.f24939a;
        ImageView imageView = aVar.e().C;
        imageView.setOnClickListener(new a(imageView, 800, traderInfo, this));
        ImageView imageView2 = aVar.e().D;
        if (this.f17946f == i11) {
            this.f17947g = traderInfo.userSign;
            i12 = R$drawable.ic_popups_selected_icon;
        } else {
            i12 = R$drawable.ic_popups_unselected_icon;
        }
        imageView2.setImageResource(i12);
        TextView textView = aVar.e().K;
        if (traderInfo.apy >= 0.0d) {
            aVar.e().E.setMode(1);
            if (w.l()) {
                i13 = f().getResources().getColor(R$color.live_bg_integral_free_tips);
            } else {
                i13 = f().getResources().getColor(R$color.topic_symbol_color);
            }
        } else {
            aVar.e().E.setMode(2);
            if (w.l()) {
                i13 = f().getResources().getColor(R$color.topic_symbol_color);
            } else {
                i13 = f().getResources().getColor(R$color.live_bg_integral_free_tips);
            }
        }
        textView.setTextColor(i13);
        if (this.f17948h) {
            aVar.e().J.setVisibility(8);
        } else {
            TextView textView2 = aVar.e().J;
            int i15 = traderInfo.f70270no;
            if (i15 <= 3) {
                str = "";
            } else {
                str = i15 < 100 ? String.valueOf(i15) : "99+";
            }
            textView2.setText(str);
            TextView textView3 = aVar.e().J;
            int i16 = traderInfo.f70270no;
            if (i16 == 1) {
                i14 = R$drawable.copy_trading_num_1;
            } else if (i16 == 2) {
                i14 = R$drawable.copy_trading_num_2;
            } else if (i16 != 3) {
                i14 = R$drawable.bg_trader_rank;
            } else {
                i14 = R$drawable.copy_trading_num_3;
            }
            textView3.setBackgroundResource(i14);
        }
        aVar.e().E.setData(traderInfo.profitList);
        aVar.e().B.setOnClickListener(new u(this, i11, traderInfo));
    }

    /* renamed from: o */
    public c.a<y5> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new c.a<>(y5.K(h(), viewGroup, false));
    }

    public final void p(boolean z11) {
        this.f17948h = z11;
    }
}

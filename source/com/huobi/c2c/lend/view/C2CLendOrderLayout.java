package com.huobi.c2c.lend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.List;
import pro.huobi.R;
import qi.c;
import qi.e;

public class C2CLendOrderLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f42933b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f42934c;

    /* renamed from: d  reason: collision with root package name */
    public View f42935d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42936e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42937f;

    /* renamed from: g  reason: collision with root package name */
    public View f42938g;

    /* renamed from: h  reason: collision with root package name */
    public View f42939h;

    /* renamed from: i  reason: collision with root package name */
    public a f42940i;

    public interface a {
        void c(boolean z11);

        void d();
    }

    public C2CLendOrderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g(View view) {
        d.b("C2CLendOrderLayout-->addEvent-->mOrderTmAllOrderBtnitleTv");
        a aVar = this.f42940i;
        if (aVar != null) {
            aVar.d();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(View view) {
        d.b("C2CLendOrderLayout-->addEvent-->mOrderTitleTv");
        a aVar = this.f42940i;
        if (aVar != null) {
            aVar.c(true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        d.b("C2CLendOrderLayout-->addEvent-->mOrderHistoryTitleTv");
        a aVar = this.f42940i;
        if (aVar != null) {
            aVar.c(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void d() {
        this.f42933b.setOnClickListener(new qi.d(this));
        this.f42936e.setOnClickListener(new c(this));
        this.f42937f.setOnClickListener(new e(this));
    }

    public final void e(Context context) {
        f(context);
        d();
    }

    public final void f(Context context) {
        FrameLayout.inflate(context, R.layout.c2c_lend_order_layout, this);
        this.f42935d = findViewById(R.id.c2c_lend_trade_order_empty_view);
        this.f42933b = (TextView) findViewById(R.id.c2c_lend_trade_order_btn);
        this.f42934c = (EasyRecyclerView) findViewById(R.id.c2c_lend_trade_order_recyclerView);
        this.f42936e = (TextView) findViewById(R.id.c2c_lend_trade_order_title);
        this.f42937f = (TextView) findViewById(R.id.c2c_lend_trade_order_history_title);
        this.f42938g = findViewById(R.id.c2c_lend_trade_order_divider);
        this.f42939h = findViewById(R.id.c2c_lend_trade_order_history_divider);
    }

    public void j(boolean z11) {
        ViewUtil.m(this.f42938g, z11);
        ViewUtil.m(this.f42939h, !z11);
        if (z11) {
            this.f42936e.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
            this.f42937f.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
            return;
        }
        this.f42936e.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
        this.f42937f.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
    }

    public void setAllOrderBtnVisible(boolean z11) {
        this.f42933b.setVisibility(z11 ? 0 : 8);
    }

    public void setCallback(a aVar) {
        this.f42940i = aVar;
    }

    public void setOrderList(List<s9.a> list) {
        this.f42934c.setData(list);
        ViewUtil.m(this.f42935d, list.isEmpty());
    }

    public C2CLendOrderLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(context);
    }
}

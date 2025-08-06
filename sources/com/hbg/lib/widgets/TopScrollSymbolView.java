package com.hbg.lib.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.t;
import java.util.HashMap;
import java.util.List;

public class TopScrollSymbolView extends FrameLayout implements t.a {

    /* renamed from: b  reason: collision with root package name */
    public TopScrollSymbolItemView f71675b;

    /* renamed from: c  reason: collision with root package name */
    public TopScrollSymbolItemView f71676c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, View.OnClickListener> f71677d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f71678e;

    /* renamed from: f  reason: collision with root package name */
    public a f71679f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71680g;

    /* renamed from: h  reason: collision with root package name */
    public int f71681h;

    /* renamed from: i  reason: collision with root package name */
    public List<List<TopScrollSymbolData>> f71682i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71683j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71684k;

    public interface a {
        void a(TopScrollSymbolData topScrollSymbolData);
    }

    public TopScrollSymbolView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        this.f71679f.a((TopScrollSymbolData) view.getTag());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final List<TopScrollSymbolData> b(int i11) {
        List<List<TopScrollSymbolData>> list = this.f71682i;
        if (list == null || list.isEmpty() || i11 >= this.f71682i.size()) {
            return null;
        }
        return this.f71682i.get(i11);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        this.f71678e = new t(this);
        d(context);
    }

    public final void d(Context context) {
        FrameLayout.inflate(context, R$layout.top_scroll_symbol_view, this);
        this.f71675b = (TopScrollSymbolItemView) findViewById(R$id.top_scroll_item_view_front);
        this.f71676c = (TopScrollSymbolItemView) findViewById(R$id.top_scroll_item_view_behind);
    }

    public void f(List<List<TopScrollSymbolData>> list, boolean z11) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            for (int i12 = 0; i12 < list.get(i11).size(); i12++) {
                TopScrollSymbolData topScrollSymbolData = (TopScrollSymbolData) list.get(i11).get(i12);
                topScrollSymbolData.i(i12);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(topScrollSymbolData.g());
                sb2.append(topScrollSymbolData.h());
                View.OnClickListener onClickListener = this.f71677d.get(sb2.toString());
                if (onClickListener == null) {
                    t1 t1Var = new t1(this);
                    topScrollSymbolData.j(t1Var);
                    this.f71677d.put(sb2.toString(), t1Var);
                } else {
                    topScrollSymbolData.j(onClickListener);
                }
            }
        }
        this.f71682i = list;
        if (z11) {
            this.f71683j = false;
            this.f71675b.g();
            this.f71676c.g();
        }
        if (!this.f71683j) {
            this.f71683j = true;
            this.f71681h = 0;
            this.f71680g = true;
            g();
        }
    }

    public final void g() {
        List<TopScrollSymbolData> b11 = b(this.f71681h);
        if (this.f71680g) {
            this.f71675b.h(b11);
            this.f71676c.c();
        } else {
            this.f71676c.h(b11);
            this.f71675b.c();
        }
        this.f71680g = !this.f71680g;
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i11 = this.f71681h + 1;
            this.f71681h = i11;
            List<TopScrollSymbolData> b11 = b(i11);
            if (b11 != null && b11.isEmpty()) {
                this.f71681h++;
            }
            List<List<TopScrollSymbolData>> list = this.f71682i;
            if (list == null || this.f71681h >= list.size()) {
                this.f71681h = 0;
            }
            g();
            if (this.f71684k) {
                this.f71678e.sendEmptyMessageDelayed(1, 5000);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    public void setCallback(a aVar) {
        this.f71679f = aVar;
    }

    public void setDatas(List<List<TopScrollSymbolData>> list) {
        f(list, false);
    }

    public TopScrollSymbolView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71677d = new HashMap<>(9);
        this.f71680g = true;
        c(context, attributeSet);
    }
}

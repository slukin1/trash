package com.huobi.main.trade.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import eo.i;
import eo.j;
import eo.k;
import eo.l;
import eo.m;
import eo.n;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class TradeDialogFilterDialog extends BaseOrderFilterDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f77848b;

    /* renamed from: c  reason: collision with root package name */
    public View f77849c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77850d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77851e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f77852f;

    /* renamed from: g  reason: collision with root package name */
    public CheckBox f77853g;

    /* renamed from: h  reason: collision with root package name */
    public CheckBox f77854h;

    /* renamed from: i  reason: collision with root package name */
    public CheckBox f77855i;

    /* renamed from: j  reason: collision with root package name */
    public List<CheckBox> f77856j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public int f77857k;

    /* renamed from: l  reason: collision with root package name */
    public int f77858l;

    /* renamed from: m  reason: collision with root package name */
    public List<String> f77859m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public d f77860n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f77861o;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean z11 = false;
            TradeDialogFilterDialog.this.f77852f.setChecked(TradeDialogFilterDialog.this.f77858l == 0);
            TradeDialogFilterDialog.this.f77853g.setChecked(TradeDialogFilterDialog.this.f77858l == 1);
            TradeDialogFilterDialog.this.f77854h.setChecked(TradeDialogFilterDialog.this.f77858l == 2);
            CheckBox Dh = TradeDialogFilterDialog.this.f77855i;
            if (TradeDialogFilterDialog.this.f77858l == 3) {
                z11 = true;
            }
            Dh.setChecked(z11);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (TradeDialogFilterDialog.this.f77860n == null || TradeDialogFilterDialog.this.f77857k == 0) {
                TradeDialogFilterDialog.this.dismiss();
            } else {
                TradeDialogFilterDialog.this.f77860n.b(0);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (TradeDialogFilterDialog.this.f77860n == null || TradeDialogFilterDialog.this.f77857k == 1) {
                TradeDialogFilterDialog.this.dismiss();
            } else {
                TradeDialogFilterDialog.this.f77860n.b(1);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface d {
        void a(int i11, int i12, String str);

        void b(int i11);

        void c(int i11, int i12);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        reset();
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f77858l = 0;
        Ih();
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.f77858l = 1;
        Ih();
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        this.f77858l = 2;
        Ih();
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        this.f77858l = 3;
        Ih();
        Gh();
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Gh() {
        if (this.f77860n != null) {
            this.f77860n.a(this.f77857k, this.f77858l, this.f77858l < this.f77859m.size() ? this.f77859m.get(this.f77858l) : "");
        }
    }

    public void Hh(d dVar) {
        this.f77860n = dVar;
    }

    public final void Ih() {
        this.f77852f.post(new a());
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        this.f77850d.setOnClickListener(new n(this));
        this.f77851e.setOnClickListener(new m(this));
        this.f77852f.setOnClickListener(new k(this));
        this.f77853g.setOnClickListener(new l(this));
        this.f77854h.setOnClickListener(new j(this));
        this.f77855i.setOnClickListener(new i(this));
        this.f77848b.setOnClickListener(new b());
        this.f77849c.setOnClickListener(new c());
    }

    public void afterInit() {
        this.f77852f.setVisibility(4);
        this.f77853g.setVisibility(4);
        this.f77854h.setVisibility(4);
        this.f77855i.setVisibility(4);
        int i11 = this.f77857k;
        if (i11 == 1) {
            this.f77852f.setText(this.f77859m.get(0));
            this.f77853g.setText(this.f77859m.get(1));
            this.f77854h.setText(this.f77859m.get(2));
            this.f77852f.setVisibility(0);
            this.f77853g.setVisibility(0);
            this.f77854h.setVisibility(0);
            this.f77855i.setVisibility(4);
        } else if (i11 == 0) {
            int i12 = 0;
            while (i12 < this.f77859m.size() && i12 < 4) {
                this.f77856j.get(i12).setVisibility(0);
                this.f77856j.get(i12).setText(this.f77859m.get(i12));
                i12++;
            }
            if (this.f77859m.size() < 3) {
                this.f77854h.setVisibility(8);
                this.f77855i.setVisibility(8);
            }
        }
        Ih();
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_150);
        layoutParams.rightMargin = (int) (((double) (PixelUtils.g() / 15)) * 3.6d);
    }

    public void dismiss() {
        super.dismiss();
        d dVar = this.f77860n;
        if (dVar != null) {
            dVar.c(this.f77857k, this.f77858l);
        }
    }

    public View getBackBtn() {
        return null;
    }

    public int getContentViewResId() {
        return this.f77861o ? R.layout.trade_dialog_filter_night : R.layout.trade_dialog_filter;
    }

    public View getFilterLayout() {
        return this.viewFinder.b(R.id.filter_view);
    }

    public void initView(r rVar) {
        this.f77850d = (TextView) rVar.b(R.id.tv_filter_reset_tv);
        this.f77851e = (TextView) rVar.b(R.id.tv_filter_sure_tv);
        this.f77852f = (CheckBox) rVar.b(R.id.cb_status_1);
        this.f77853g = (CheckBox) rVar.b(R.id.cb_status_2);
        this.f77854h = (CheckBox) rVar.b(R.id.cb_status_3);
        this.f77855i = (CheckBox) rVar.b(R.id.cb_status_4);
        this.f77856j.clear();
        this.f77856j.add(this.f77852f);
        this.f77856j.add(this.f77853g);
        this.f77856j.add(this.f77854h);
        this.f77856j.add(this.f77855i);
        this.f77848b = rVar.b(R.id.v_type1);
        this.f77849c = rVar.b(R.id.v_type2);
    }

    public void reset() {
        this.f77858l = 0;
        Ih();
    }
}

package com.hbg.module.kline.ui;

import a7.e;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.hbg.component.kline.db.KlineDbHelper;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.view.KlineScrollView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.n;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$anim;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.draw.LineColorEnum;
import com.hbg.module.kline.draw.LineSizeEnum;
import com.hbg.module.kline.draw.LineStyleEnum;
import com.hbg.module.kline.draw.LineTypeEnum;
import com.hbg.module.kline.enums.CommentSwitchEnum;
import com.hbg.module.kline.enums.CommunitySwitchEnum;
import com.hbg.module.kline.enums.SymbolTypeEnum;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import fe.c;
import fe.y;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q5.b;
import td.i;

public class MarketInfoLandscapeActivity extends AbstractKlineActivity implements View.OnClickListener, c.a, b, y.a {
    public View W0;
    public FrameLayout X0;
    public View Y0;
    public RelativeLayout Z0;

    /* renamed from: a1  reason: collision with root package name */
    public RelativeLayout f24099a1;

    /* renamed from: b1  reason: collision with root package name */
    public ImageView f24100b1;

    /* renamed from: c1  reason: collision with root package name */
    public ImageView f24101c1;

    /* renamed from: d1  reason: collision with root package name */
    public RelativeLayout f24102d1;

    /* renamed from: e1  reason: collision with root package name */
    public ImageView f24103e1;

    /* renamed from: f1  reason: collision with root package name */
    public ImageView f24104f1;

    /* renamed from: g1  reason: collision with root package name */
    public RelativeLayout f24105g1;

    /* renamed from: h1  reason: collision with root package name */
    public RelativeLayout f24106h1;

    /* renamed from: i1  reason: collision with root package name */
    public RelativeLayout f24107i1;

    /* renamed from: j1  reason: collision with root package name */
    public RelativeLayout f24108j1;

    /* renamed from: k1  reason: collision with root package name */
    public TextView f24109k1;

    /* renamed from: l1  reason: collision with root package name */
    public TextView f24110l1;

    /* renamed from: m1  reason: collision with root package name */
    public c f24111m1;

    /* renamed from: n1  reason: collision with root package name */
    public c f24112n1;

    /* renamed from: o1  reason: collision with root package name */
    public y f24113o1;

    /* renamed from: p1  reason: collision with root package name */
    public KlineViewWrapper f24114p1;

    /* renamed from: q1  reason: collision with root package name */
    public boolean f24115q1 = false;

    /* renamed from: r1  reason: collision with root package name */
    public boolean f24116r1 = false;

    /* renamed from: s1  reason: collision with root package name */
    public LineTypeEnum f24117s1 = null;

    /* renamed from: t1  reason: collision with root package name */
    public View f24118t1;

    /* renamed from: u1  reason: collision with root package name */
    public View f24119u1;

    /* renamed from: v1  reason: collision with root package name */
    public View f24120v1;

    /* renamed from: w1  reason: collision with root package name */
    public TextView f24121w1;

    /* renamed from: x1  reason: collision with root package name */
    public ImageView f24122x1;

    /* renamed from: y1  reason: collision with root package name */
    public NewSymbolCountDownLayout f24123y1;

    /* renamed from: z1  reason: collision with root package name */
    public ViewGroup f24124z1;

    public class a implements vd.a {
        public a() {
        }

        public void b(int i11, long j11, long[] jArr) {
            if (jArr.length <= 0) {
                return;
            }
            if (jArr[0] <= 0) {
                MarketInfoLandscapeActivity.this.f24123y1.setDayVisible(false);
            } else {
                MarketInfoLandscapeActivity.this.f24123y1.setDayVisible(true);
            }
        }

        public void c(int i11) {
            MarketInfoLandscapeActivity.this.f24123y1.g();
            ViewUtil.m(MarketInfoLandscapeActivity.this.f24123y1, false);
            ViewUtil.m(MarketInfoLandscapeActivity.this.f24118t1, true);
            ViewUtil.m(MarketInfoLandscapeActivity.this.f24124z1, true);
            MarketInfoLandscapeActivity.this.Dj();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        this.f24116r1 = false;
        this.f24114p1.m(false);
        Fj(false);
        nj();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        Aj("4239", (Map<String, Object>) null);
        DialogUtils.c0(this, getString(R$string.n_kline_draw_delete_sure), (String) null, getString(R$string.string_cancel), getString(R$string.string_confirm), ad.b.f3517a, new o4(this));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Aj("4234", (Map<String, Object>) null);
        Oj();
        Fj(true);
        this.f24114p1.m(true);
        this.f24116r1 = true;
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (!this.f24114p1.n()) {
            Mj(getString(R$string.n_kline_cannot_draw));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f24099a1.setSelected(true);
        Hj();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        if (!this.f24114p1.n()) {
            Mj(getString(R$string.n_kline_cannot_draw));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f24102d1.setSelected(true);
        Kj();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        RelativeLayout relativeLayout = this.f24105g1;
        relativeLayout.setSelected(!relativeLayout.isSelected());
        ConfigPreferences.n("user_config", "kline_continuous_draw_key", this.f24105g1.isSelected());
        if (this.f24105g1.isSelected()) {
            Mj(getResources().getString(R$string.n_kline_draw_line_continue_open));
        } else {
            Mj(getResources().getString(R$string.n_kline_draw_line_continue_close));
        }
        zj(this.f24105g1.isSelected());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sj(HBDialogFragment hBDialogFragment) {
        nj();
        this.f24114p1.o();
        hBDialogFragment.dismiss();
        Aj("4240", (Map<String, Object>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tj() {
        finish();
        Intent intent = new Intent(this, MarketInfoLandscapeActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uj() {
        LineTypeEnum lineTypeEnum;
        if (!this.f24115q1 || (lineTypeEnum = this.f24117s1) == null) {
            Bj();
        } else if (lineTypeEnum.getGroupId() != 1) {
            Bj();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vj() {
        LineTypeEnum lineTypeEnum;
        if (!this.f24115q1 || (lineTypeEnum = this.f24117s1) == null) {
            Cj();
        } else if (lineTypeEnum.getGroupId() != 2) {
            Cj();
        }
    }

    public final void Aj(String str, Map<String, Object> map) {
        i.a().b().b(str, map);
    }

    public final void Bj() {
        this.f24099a1.setSelected(false);
        this.f24100b1.setImageResource(LineTypeEnum.getIconResourceId(this, LineTypeEnum.LINE_SEGMENT));
    }

    public final void Cj() {
        this.f24102d1.setSelected(false);
        this.f24103e1.setImageResource(LineTypeEnum.getIconResourceId(this, LineTypeEnum.RECTANGLE));
    }

    public void D5(yd.b bVar) {
        q5.a.g().n(bVar.d().getStyleId());
        this.f24114p1.y();
    }

    public final void Dj() {
        runOnUiThread(new p4(this));
    }

    public final void Ej(boolean z11) {
        if (z11) {
            this.f24108j1.animate().setDuration(270).setInterpolator(new FastOutSlowInInterpolator()).alpha(1.0f).translationY(0.0f);
        } else {
            this.f24108j1.animate().setDuration(270).setInterpolator(new FastOutSlowInInterpolator()).alpha(0.0f).translationY((float) PixelUtils.a(-77.0f));
        }
    }

    public final void Fj(boolean z11) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.kline_tool_alpha_in);
        loadAnimation.setInterpolator(new FastOutSlowInInterpolator());
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R$anim.kline_tool_alpha_out);
        loadAnimation2.setInterpolator(new FastOutSlowInInterpolator());
        this.Z0.setAnimation(z11 ? loadAnimation : loadAnimation2);
        int i11 = 0;
        this.Z0.setVisibility(z11 ? 0 : 8);
        View view = this.f24118t1;
        if (z11) {
            loadAnimation = loadAnimation2;
        }
        view.setAnimation(loadAnimation);
        View view2 = this.f24118t1;
        if (z11) {
            i11 = 4;
        }
        view2.setVisibility(i11);
        if (z11) {
            KLineHelper.k();
        }
    }

    public void G2(yd.c cVar) {
        q5.a.g().j(getResources().getColor(cVar.c().getColorId()));
        q5.a.g().k(cVar.c().getIndex());
        this.f24114p1.y();
    }

    public final void Gj() {
        if (this.f24113o1 == null) {
            y yVar = new y(this);
            this.f24113o1 = yVar;
            yVar.G(this);
        }
        if (!this.f24113o1.isShowing()) {
            this.f24113o1.showAtLocation(getWindow().peekDecorView(), 51, (PixelUtils.g() / 2) - (this.f24113o1.getWidth() / 2), PixelUtils.f() - PixelUtils.a(105.0f));
        }
    }

    public void H9() {
        Mj(getResources().getString(R$string.n_kline_only_in_main));
    }

    public final void Hj() {
        if (this.f24111m1 == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(LineTypeEnum.LINE_SEGMENT);
            arrayList.add(LineTypeEnum.H_LINE_SEGMENT);
            arrayList.add(LineTypeEnum.V_LINE_SEGMENT);
            arrayList.add(LineTypeEnum.RAY);
            arrayList.add(LineTypeEnum.PARALLEL_CHANNEL);
            c cVar = new c(this, arrayList);
            this.f24111m1 = cVar;
            cVar.c(this);
            this.f24111m1.setOnDismissListener(new m4(this));
        }
        Lj(this.f24111m1, this.f24099a1);
    }

    public void I9() {
        this.f24114p1.q();
        this.f24113o1.dismiss();
    }

    public final void Ij() {
        q5.a.g().q(this.A0);
        this.f24121w1.setText(R$string.n_kline_net_worth);
        this.f24122x1.setImageResource(R$drawable.icon_nav_kline);
        int i11 = 0;
        ((AbstractKlinePresenter) getPresenter()).a0(false);
        this.f24114p1.setSymbolId(this.A0);
        KLineHelper.j(this.f23756w0, false);
        ((AbstractKlinePresenter) getPresenter()).a0(true);
        this.f24114p1.setSlaveIndex1("");
        TextView textView = this.f23721c0;
        if (TextUtils.isEmpty(this.f24114p1.getSlaveIndex1())) {
            i11 = 8;
        }
        textView.setVisibility(i11);
    }

    public final void Jj() {
        q5.a.g().q(this.f23756w0);
        this.f24121w1.setText(R$string.n_kline_exch);
        this.f24122x1.setImageResource(R$drawable.icon_normal_kline);
        int i11 = 0;
        ((AbstractKlinePresenter) getPresenter()).a0(false);
        this.f24114p1.setSymbolId(this.f23756w0);
        KLineHelper.j(this.f23756w0, true);
        ((AbstractKlinePresenter) getPresenter()).a0(true);
        this.f24114p1.setSlaveIndex1("VOL");
        TextView textView = this.f23721c0;
        if (TextUtils.isEmpty(this.f24114p1.getSlaveIndex1())) {
            i11 = 8;
        }
        textView.setVisibility(i11);
    }

    public final void Kj() {
        if (this.f24112n1 == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(LineTypeEnum.RECTANGLE);
            arrayList.add(LineTypeEnum.PARALLELOGRAM);
            c cVar = new c(this, arrayList);
            this.f24112n1 = cVar;
            cVar.c(this);
            this.f24112n1.setOnDismissListener(new n4(this));
        }
        Lj(this.f24112n1, this.f24102d1);
    }

    public final void Lj(c cVar, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int indexOfChild = this.Z0.indexOfChild(view);
        int width = (iArr[0] - cVar.getWidth()) + PixelUtils.a(8.0f);
        int a11 = (indexOfChild * PixelUtils.a(40.0f)) - PixelUtils.a(8.0f);
        cVar.d(this.f24117s1);
        cVar.showAsDropDown(this.f24119u1, width, a11);
    }

    public final void Mj(String str) {
        HuobiToastUtil.m(str);
    }

    public final void Nj(boolean z11) {
        this.f24115q1 = z11;
        if (!z11) {
            this.f24117s1 = null;
        }
        this.f24114p1.L(z11);
    }

    public final void Oj() {
        q5.a g11 = q5.a.g();
        int styleId = LineStyleEnum.SOLID_LINE.getStyleId();
        LineSizeEnum lineSizeEnum = LineSizeEnum.LINE_SIZE_2;
        int index = lineSizeEnum.getIndex();
        Resources resources = getResources();
        LineColorEnum lineColorEnum = LineColorEnum.LINE_COLOR_1;
        int color = resources.getColor(lineColorEnum.getColorId());
        g11.r(styleId, (float) lineSizeEnum.getSize(), index, color, lineColorEnum.getIndex());
    }

    public final void Pj(int i11, int i12) {
        this.f24110l1.setText(getString(R$string.n_kline_draw_line_tip_content, new Object[]{Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public void R5(KlineDrawLineBean klineDrawLineBean) {
        LineTypeEnum lineType = LineTypeEnum.getLineType(klineDrawLineBean.getLineType());
        int size = klineDrawLineBean.getPointList().size();
        if (lineType.getAnchorCount() == size) {
            wj(klineDrawLineBean);
        } else {
            Pj(size, lineType.getAnchorCount());
        }
    }

    public void addEvent() {
        super.addEvent();
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.W0.setClickable(true);
        this.W0.setOnClickListener(this);
        this.Y0.setOnClickListener(new h4(this));
        this.f24107i1.setOnClickListener(new l4(this));
        this.f24099a1.setOnClickListener(new k4(this));
        this.f24102d1.setOnClickListener(new g4(this));
        this.f24105g1.setOnClickListener(new j4(this));
        this.f24106h1.setOnClickListener(new i4(this));
        this.f24114p1.setOnPointDrawListener(this);
        if (getIntent().getBooleanExtra("kline_draw_bundle_key", false)) {
            this.Y0.performClick();
        }
        this.f24120v1.setOnClickListener(this);
    }

    public boolean canFullScreen() {
        return false;
    }

    public void d6(CommunitySwitchEnum communitySwitchEnum, CommentSwitchEnum commentSwitchEnum, SymbolTypeEnum symbolTypeEnum) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (motionEvent.getAction() == 0 && this.f24115q1 && !mj(x11, y11, this.W0) && !mj(x11, y11, this.Z0) && !mj(x11, y11, this.f24114p1)) {
            H9();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getContentView() {
        return R$layout.activity_market_info_landscape;
    }

    public void initView() {
        super.initView();
        if (KLineHelper.f()) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 16);
        }
        getWindow().setNavigationBarColor(Oh(R$attr.kline_content_background_color));
        this.f24114p1 = (KlineViewWrapper) findViewById(R$id.klineViewWrapper);
        this.f24120v1 = findViewById(R$id.kline_type_layout_landscape);
        this.f24121w1 = (TextView) findViewById(R$id.kline_type_text_landscape);
        this.f24122x1 = (ImageView) findViewById(R$id.kline_type_icon_landscape);
        this.f24114p1.setLandScape(true);
        this.f24114p1.setScrollView((KlineScrollView) findViewById(R$id.klineScrollView));
        this.f24114p1.setDrawLineLayerEnable(true);
        Zh(this.f24114p1, true);
        qj();
        Yh();
        Ki();
        pj();
        rj();
        if (ae()) {
            ViewUtil.m(this.f24120v1, true);
        }
    }

    public void j8(yd.a aVar) {
        q5.a.g().l((float) aVar.d().getSize());
        q5.a.g().m(aVar.d().getIndex());
        this.f24114p1.y();
    }

    public void m9(boolean z11) {
        this.f24114p1.w(z11);
        if (z11) {
            Mj(getResources().getString(R$string.n_kline_lock));
        } else {
            Mj(getResources().getString(R$string.n_kline_unlock));
        }
    }

    public final boolean mj(float f11, float f12, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()).contains((int) f11, (int) f12);
    }

    public final void nj() {
        Nj(false);
        Ej(false);
        Bj();
        Cj();
        y yVar = this.f24113o1;
        if (yVar != null && yVar.isShowing()) {
            this.f24113o1.dismiss();
        }
    }

    public final String oj(int i11) {
        switch (i11) {
            case 1:
                return "segment";
            case 2:
                return MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL;
            case 3:
                return "vertical";
            case 4:
                return "ray";
            case 5:
                return "parallel-channel";
            case 6:
                return "rectangle";
            default:
                return "parallelogram";
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.market_info_more_layout || id2 == R$id.target_checkbox_layout || id2 == R$id.time_sharing_radio_layout || id2 == R$id.one_min_radio_layout || id2 == R$id.five_min_radio_layout || id2 == R$id.fifteen_min_radio_layout || id2 == R$id.thirty_min_radio_layout || id2 == R$id.sixty_min_radio_layout || id2 == R$id.four_hour_radio_layout || id2 == R$id.one_day_radio_layout || id2 == R$id.one_week_radio_layout || id2 == R$id.one_month_radio_layout) {
            y yVar = this.f24113o1;
            if (yVar == null || !yVar.isShowing()) {
                Pi(view);
            } else {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
        } else if (id2 == R$id.market_land_info_close) {
            finish();
            setRequestedOrientation(1);
        } else if (id2 == R$id.kline_type_layout_landscape) {
            if (KLineHelper.d(this.f23756w0, true)) {
                Ij();
            } else {
                Jj();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
    }

    public void onResume() {
        super.onResume();
        if (!ae()) {
            return;
        }
        if (KLineHelper.d(this.f23756w0, true)) {
            Jj();
        } else {
            Ij();
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11 && !this.f24116r1) {
            n.o().E(this.Y0);
        }
    }

    public final void pj() {
        this.Y0 = this.viewFinder.b(R$id.drawBtn);
        this.Z0 = (RelativeLayout) this.viewFinder.b(R$id.drawToolWindow);
        this.f24099a1 = (RelativeLayout) this.viewFinder.b(R$id.klineDrawLineLayout);
        this.f24100b1 = (ImageView) this.viewFinder.b(R$id.klineDrawLineIcon);
        this.f24101c1 = (ImageView) this.viewFinder.b(R$id.lineIconArrow);
        this.f24102d1 = (RelativeLayout) this.viewFinder.b(R$id.klineDrawPolygonLayout);
        this.f24103e1 = (ImageView) this.viewFinder.b(R$id.klineDrawPolygonIcon);
        this.f24104f1 = (ImageView) this.viewFinder.b(R$id.polygonIconArrow);
        this.f24105g1 = (RelativeLayout) this.viewFinder.b(R$id.klineDrawContinuousLayout);
        this.f24106h1 = (RelativeLayout) this.viewFinder.b(R$id.klineDrawDeleteLayout);
        this.f24107i1 = (RelativeLayout) this.viewFinder.b(R$id.klineDrawCloseLayout);
        this.f24108j1 = (RelativeLayout) this.viewFinder.b(R$id.drawLineTipsLayout);
        this.f24109k1 = (TextView) this.viewFinder.b(R$id.selectedLineName);
        this.f24110l1 = (TextView) this.viewFinder.b(R$id.selectedLineTips);
        this.f24118t1 = this.viewFinder.b(R$id.layout_index_root);
        this.f24119u1 = this.viewFinder.b(R$id.appbar);
        this.f24105g1.setSelected(ConfigPreferences.c("user_config", "kline_continuous_draw_key", false));
    }

    public final void qj() {
        this.f23722d = (TextView) this.viewFinder.b(R$id.market_info_symbol);
        this.W0 = this.viewFinder.b(R$id.market_land_info_close);
        this.X0 = (FrameLayout) this.viewFinder.b(R$id.hq_snapshot_container);
        if (TradeType.isContract(this.D0) || TradeType.isSwap(this.D0) || TradeType.isOption(this.D0) || TradeType.isLinearSwap(this.D0)) {
            getLayoutInflater().inflate(R$layout.activity_market_info_landscape_contract_snapshot, this.X0, true);
            this.f23746q = (TextView) findViewById(R$id.contract_hold_num_label);
            this.f23747r = (TextView) findViewById(R$id.contract_hold_num_tv);
            this.f23734j = (TextView) findViewById(R$id.volume_sum_amount_label2);
            this.f23736k = (TextView) findViewById(R$id.volume_sum_amount_text2);
            return;
        }
        getLayoutInflater().inflate(R$layout.activity_market_info_landscape_pro_snapshot, this.X0, true);
    }

    public void rb(LineTypeEnum lineTypeEnum) {
        Gj();
        this.f24113o1.F(false);
        this.f24113o1.E(false);
        this.f24113o1.O(LineStyleEnum.getLineStyle(q5.a.g().e()));
        this.f24113o1.N(LineSizeEnum.getLineSize(q5.a.g().d()));
        this.f24113o1.L(LineColorEnum.getLineColor(q5.a.g().b()));
        q5.a.g().o(lineTypeEnum.getType());
        Nj(true);
        String string = getString(lineTypeEnum.getNameId());
        this.f24117s1 = lineTypeEnum;
        Ej(true);
        this.f24109k1.setText(getString(R$string.n_kline_draw_line_tip, new Object[]{string}));
        Pj(0, lineTypeEnum.getAnchorCount());
        if (lineTypeEnum.getGroupId() == 1) {
            this.f24100b1.setImageResource(LineTypeEnum.getIconResourceId(this, lineTypeEnum));
            Cj();
        } else if (lineTypeEnum.getGroupId() == 2) {
            this.f24103e1.setImageResource(LineTypeEnum.getIconResourceId(this, lineTypeEnum));
            Bj();
        }
        xj(lineTypeEnum);
    }

    public final void rj() {
        this.f24124z1 = (ViewGroup) this.viewFinder.b(R$id.trade_time_group);
        SymbolBean J = a1.v().J(this.f23756w0, TradeType.PRO);
        if (J == null || J.getTradeOpenAt() <= 0 || !J.getState().equalsIgnoreCase(SymbolBean.PRE_ONLINE) || J.getTradeOpenAt() <= DateTimeUtils.v()) {
            ViewUtil.m(this.f24123y1, false);
            ViewUtil.m(this.f24118t1, true);
            ViewUtil.m(this.f24124z1, true);
            return;
        }
        NewSymbolCountDownLayout newSymbolCountDownLayout = (NewSymbolCountDownLayout) this.viewFinder.b(R$id.new_symbol_count_down_layout);
        this.f24123y1 = newSymbolCountDownLayout;
        newSymbolCountDownLayout.setSymbolName(J.getSymbolName());
        this.f24123y1.setNightMode(!KLineHelper.f());
        this.f24123y1.f();
        this.f24123y1.e(0, J.getTradeOpenAt());
        this.f24123y1.setCountDownCallback(new a());
        ViewUtil.m(this.f24118t1, false);
        ViewUtil.m(this.f24124z1, false);
        ViewUtil.m(this.f24123y1, true);
    }

    @SuppressLint({"SetTextI18n"})
    public void v9(OptionMarketIndexInfo optionMarketIndexInfo) {
        if (e.F(TradeType.valueOf(this.D0))) {
            String T = ((AbstractKlinePresenter) getPresenter()).T();
            TextView textView = this.f23747r;
            textView.setText(m.o(FutureUnitUtil.c(optionMarketIndexInfo.getVolume(), this.G0, ((AbstractKlinePresenter) getPresenter()).V().getContractFace(), TradeType.valueOf(this.D0), e.F(TradeType.valueOf(this.D0))), FuturePrecisionUtil.s(this.B0, "", this.C0), true) + T);
            return;
        }
        this.f23747r.setText(getString(R$string.contract_hold_num_value, new Object[]{m.o(optionMarketIndexInfo.getVolume(), FuturePrecisionUtil.B(), true)}));
    }

    public void wa(KlineDrawLineBean klineDrawLineBean) {
        if (klineDrawLineBean != null) {
            Gj();
            this.f24113o1.M(klineDrawLineBean.getLock());
            this.f24113o1.E(true);
            this.f24113o1.O(LineStyleEnum.getLineStyle(klineDrawLineBean.getLineStyle()));
            this.f24113o1.N(LineSizeEnum.getLineSize(klineDrawLineBean.getLineSizeIndex()));
            this.f24113o1.L(LineColorEnum.getLineColor(klineDrawLineBean.getLineColorIndex()));
            return;
        }
        y yVar = this.f24113o1;
        if (yVar != null && yVar.isShowing()) {
            this.f24113o1.dismiss();
        }
    }

    public final void wj(KlineDrawLineBean klineDrawLineBean) {
        KlineDbHelper.g(klineDrawLineBean);
        Nj(this.f24105g1.isSelected());
        LineTypeEnum lineType = LineTypeEnum.getLineType(klineDrawLineBean.getLineType());
        if (this.f24105g1.isSelected()) {
            Pj(0, lineType.getAnchorCount());
            this.f24113o1.F(false);
            this.f24113o1.E(false);
        } else {
            Ej(false);
            Mj(getResources().getString(R$string.n_kline_draw_line_success));
            this.f24113o1.F(true);
            this.f24113o1.E(true);
            if (lineType.getGroupId() == 1) {
                Bj();
            } else if (lineType.getGroupId() == 2) {
                Cj();
            }
        }
        yj(klineDrawLineBean);
    }

    public final void xj(LineTypeEnum lineTypeEnum) {
        if (lineTypeEnum != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("icon", oj(lineTypeEnum.getType()));
            Aj("4235", hashMap);
        }
    }

    public final void yj(KlineDrawLineBean klineDrawLineBean) {
        if (klineDrawLineBean != null) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("icon", oj(klineDrawLineBean.getLineType()));
            Aj("4236", hashMap);
        }
    }

    public final void zj(boolean z11) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("select", Integer.valueOf(z11 ? 1 : 0));
        Aj("4238", hashMap);
    }
}

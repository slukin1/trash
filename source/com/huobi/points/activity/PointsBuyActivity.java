package com.huobi.points.activity;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.verificationsdk.ui.VerifyType;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsPack;
import com.huobi.points.presenter.PointsBuyPresenter;
import com.huobi.view.PointsPriceEditext;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fq.f;
import fq.g;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;

public class PointsBuyActivity extends BaseActivity<PointsBuyPresenter, PointsBuyPresenter.e> implements PointsBuyPresenter.e {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f80355b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80356c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80357d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80358e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f80359f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f80360g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80361h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f80362i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f80363j;

    /* renamed from: k  reason: collision with root package name */
    public PointsPriceEditext f80364k;

    /* renamed from: l  reason: collision with root package name */
    public EditText f80365l;

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f80366m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f80367n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f80368o;

    /* renamed from: p  reason: collision with root package name */
    public List<gq.a> f80369p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public v9.a<gq.a> f80370q;

    /* renamed from: r  reason: collision with root package name */
    public jq.d f80371r;

    /* renamed from: s  reason: collision with root package name */
    public String f80372s;

    /* renamed from: t  reason: collision with root package name */
    public e f80373t;

    /* renamed from: u  reason: collision with root package name */
    public View.OnClickListener f80374u = new a();

    /* renamed from: v  reason: collision with root package name */
    public View.OnClickListener f80375v = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag(R.id.item_data1)).intValue();
            int size = PointsBuyActivity.this.f80369p.size();
            boolean d11 = ((gq.a) PointsBuyActivity.this.f80369p.get(intValue)).d();
            String a11 = ((gq.a) PointsBuyActivity.this.f80369p.get(intValue)).a();
            ((PointsBuyPresenter) PointsBuyActivity.this.getPresenter()).p0(a11);
            if (!d11) {
                int i11 = 0;
                while (i11 < size) {
                    ((gq.a) PointsBuyActivity.this.f80369p.get(i11)).e(i11 == intValue);
                    i11++;
                }
                PointsBuyActivity.this.f80370q.notifyDataSetChanged();
                PointsBuyActivity pointsBuyActivity = PointsBuyActivity.this;
                pointsBuyActivity.gd(((PointsBuyPresenter) pointsBuyActivity.getPresenter()).b0(), a11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (PointsBuyActivity.this.f80373t == null) {
                PointsBuyActivity pointsBuyActivity = PointsBuyActivity.this;
                e unused = pointsBuyActivity.f80373t = new e(pointsBuyActivity);
            }
            PointsBuyActivity pointsBuyActivity2 = PointsBuyActivity.this;
            VerifyActivity.startSimpleVerifyUI(pointsBuyActivity2, VerifyType.NOCAPTCHA, "0335", (String) null, pointsBuyActivity2.f80373t);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() != 1 || !editable.toString().equals("0")) {
                int indexOf = editable.toString().indexOf(InstructionFileId.DOT);
                if (indexOf != -1) {
                    PointsBuyActivity.this.f80365l.setText(editable.toString().substring(0, indexOf));
                    PointsBuyActivity.this.f80365l.setSelection(PointsBuyActivity.this.f80365l.getText().length());
                } else if (m.a(editable.toString()).compareTo(new BigDecimal(((PointsBuyPresenter) PointsBuyActivity.this.getPresenter()).d0().getLimit())) > 0) {
                    PointsBuyActivity.this.f80365l.setText(String.valueOf(((PointsBuyPresenter) PointsBuyActivity.this.getPresenter()).d0().getLimit()));
                    PointsBuyActivity.this.f80365l.setSelection(PointsBuyActivity.this.f80365l.getText().length());
                } else {
                    PointsBuyActivity pointsBuyActivity = PointsBuyActivity.this;
                    pointsBuyActivity.gd(((PointsBuyPresenter) pointsBuyActivity.getPresenter()).b0(), ((PointsBuyPresenter) PointsBuyActivity.this.getPresenter()).c0());
                }
            } else {
                PointsBuyActivity.this.f80365l.setText("1");
                PointsBuyActivity.this.f80365l.setSelection(PointsBuyActivity.this.f80365l.getText().length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d implements TextView.OnEditorActionListener {
        public d() {
        }

        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (i11 != 6) {
                return false;
            }
            SoftInputUtils.f(PointsBuyActivity.this);
            return false;
        }
    }

    public static class e implements IActivityCallback {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<PointsBuyActivity> f80380a;

        public e(PointsBuyActivity pointsBuyActivity) {
            this.f80380a = new WeakReference<>(pointsBuyActivity);
        }

        public void onNotifyBackPressed() {
            PointsBuyActivity pointsBuyActivity = (PointsBuyActivity) this.f80380a.get();
            if (pointsBuyActivity != null) {
                pointsBuyActivity.zh();
            }
        }

        public void onResult(int i11, Map<String, String> map) {
            PointsBuyActivity pointsBuyActivity = (PointsBuyActivity) this.f80380a.get();
            if (pointsBuyActivity != null) {
                pointsBuyActivity.Ah(i11, map);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        uh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(View view, boolean z11) {
        Bh(this.f80364k, z11);
    }

    public void Ad(PointsPack pointsPack) {
        this.f80356c.setText(pointsPack.getName());
        if (TextUtils.isEmpty(pointsPack.getGiftAmount()) || new BigDecimal(pointsPack.getGiftAmount()).compareTo(BigDecimal.ZERO) == 0) {
            this.f80357d.setText(String.format(getString(R.string.points_buy_contains_points), new Object[]{String.valueOf(pointsPack.getPoints())}));
        } else {
            this.f80357d.setText(String.format(getString(R.string.points_buy_contains_points_gift), new Object[]{String.valueOf(pointsPack.getPoints()), m.m(pointsPack.getGiftAmount(), PrecisionUtil.a(TradeType.PRO, pointsPack.getGiftCurrency())), pointsPack.getGiftCurrency().toUpperCase(Locale.US)}));
        }
        this.f80358e.setText(String.format(getString(R.string.points_buy_only_sell_usdt_number), new Object[]{m.m(pointsPack.getPrice(), PrecisionUtil.n())}));
        this.f80359f.setText(String.format(getString(R.string.points_pack_deductible_fee), new Object[]{String.valueOf(pointsPack.getPoints())}));
        this.f80360g.setText(String.format(getString(R.string.points_buy_limit_buy_number), new Object[]{String.valueOf(pointsPack.getLimit())}));
    }

    public void Ah(int i11, Map<String, String> map) {
        if (i11 != 0) {
            ((PointsBuyPresenter) getPresenter()).n0(map);
            this.f80371r.dismiss();
        }
    }

    public void B8(Points points) {
        this.f80371r.show();
        this.f80371r.j(String.valueOf(points.getQuantity()));
        this.f80371r.l(m.m(points.getTotalAmount(), PrecisionUtil.a(TradeType.PRO, points.getCurrency())), points.getCurrency().toUpperCase(Locale.US));
    }

    public final void Bh(View view, boolean z11) {
        if (z11) {
            view.setBackgroundResource(R.drawable.custom_trade_edittext_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public final void Ch(String str) {
        TextView textView = this.f80361h;
        String string = getString(R.string.points_buy_convert);
        TradeType tradeType = TradeType.PRO;
        Locale locale = Locale.US;
        textView.setText(String.format(string, new Object[]{m.m("0", PrecisionUtil.a(tradeType, str.toLowerCase(locale))), str.toUpperCase(locale)}));
        this.f80372s = "0";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m.m(this.f80372s, PrecisionUtil.a(tradeType, str.toLowerCase(locale))));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str.toUpperCase(locale));
        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder2.length(), 33);
        this.f80363j.setText(spannableStringBuilder.append(spannableStringBuilder2));
    }

    public void addEvent() {
        this.f80365l.addTextChangedListener(new c());
        this.f80365l.setOnEditorActionListener(new d());
        this.f80367n.setOnClickListener(new fq.e(this));
        this.f80368o.setOnClickListener(new f(this));
        this.f80365l.setOnFocusChangeListener(new g(this));
    }

    public void gd(Map<String, String> map, String str) {
        Map<String, String> map2 = map;
        String str2 = str;
        String str3 = map2 == null ? "0" : map2.get(str2.toLowerCase(Locale.US));
        TextView textView = this.f80362i;
        String string = getString(R.string.points_buy_available_asset);
        BigDecimal a11 = m.a(str3);
        TradeType tradeType = TradeType.PRO;
        Locale locale = Locale.US;
        textView.setText(String.format(string, new Object[]{m.q(a11, PrecisionUtil.a(tradeType, str2.toLowerCase(locale))), str2.toUpperCase(locale)}));
        if ("usdt".equalsIgnoreCase(str2)) {
            this.f80361h.setVisibility(8);
            this.f80372s = m.a(((PointsBuyPresenter) getPresenter()).d0().getPrice()).multiply(m.a(this.f80365l.getText().toString())).toPlainString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(m.m(this.f80372s, PrecisionUtil.a(tradeType, str2.toLowerCase(locale))));
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder.length(), 33);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2.toUpperCase(locale));
            spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder2.length(), 33);
            this.f80363j.setText(spannableStringBuilder.append(spannableStringBuilder2));
        } else {
            this.f80361h.setVisibility(0);
            Map<String, BigDecimal> f02 = ((PointsBuyPresenter) getPresenter()).f0();
            if (f02 != null) {
                BigDecimal bigDecimal = f02.get(str2.toLowerCase(locale));
                if (bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    Ch(str2);
                } else {
                    this.f80361h.setText(String.format(getString(R.string.points_buy_convert), new Object[]{m.q(BigDecimal.ONE.divide(bigDecimal, 32, 1), PrecisionUtil.a(tradeType, str2.toLowerCase(locale))), str2.toUpperCase(locale)}));
                    this.f80372s = m.F(m.a(m.F(BigDecimal.ONE.divide(bigDecimal, 32, 1).multiply(m.a(((PointsBuyPresenter) getPresenter()).d0().getPrice())).toPlainString(), PrecisionUtil.a(tradeType, str2.toLowerCase(locale)))).multiply(m.a(this.f80365l.getText().toString())).toPlainString(), PrecisionUtil.a(tradeType, str2.toLowerCase(locale)));
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(m.m(this.f80372s, PrecisionUtil.a(tradeType, str2.toLowerCase(locale))));
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder3.length(), 33);
                    SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str2.toUpperCase(locale));
                    spannableStringBuilder4.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder4.length(), 33);
                    this.f80363j.setText(spannableStringBuilder3.append(spannableStringBuilder4));
                }
            } else {
                Ch(str2);
            }
        }
        if (m.a(str3).compareTo(m.a(this.f80372s)) < 0) {
            this.f80368o.setEnabled(false);
            this.f80368o.setText(R.string.points_buy_confirm_error_asset_hint);
            return;
        }
        this.f80368o.setEnabled(true);
        this.f80368o.setText(R.string.points_buy_confirm_pay_confirm);
    }

    public int getContentView() {
        return R.layout.activity_points_buy;
    }

    public void initView() {
        Toolbar toolbar = (Toolbar) this.viewFinder.b(R.id.points_buy_confirm_toolbar);
        this.f80355b = toolbar;
        setToolBar(toolbar, getString(R.string.n_otc_payment_order_step_confirm_order), true);
        this.f80356c = (TextView) this.viewFinder.b(R.id.points_number_tv);
        this.f80357d = (TextView) this.viewFinder.b(R.id.points_contains_number_tv);
        this.f80358e = (TextView) this.viewFinder.b(R.id.points_buy_for_usdt_tv);
        this.f80359f = (TextView) this.viewFinder.b(R.id.points_buy_for_usdt_fee_tv);
        this.f80360g = (TextView) this.viewFinder.b(R.id.points_buy_limit_tv);
        PointsPriceEditext pointsPriceEditext = (PointsPriceEditext) this.viewFinder.b(R.id.point_input_price);
        this.f80364k = pointsPriceEditext;
        EditText editText = pointsPriceEditext.getEditText();
        this.f80365l = editText;
        editText.setText("1");
        EditText editText2 = this.f80365l;
        editText2.setSelection(editText2.getText().length());
        this.f80364k.setReduceEnable(false);
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.points_buy_currency_rv);
        this.f80366m = recyclerView;
        recyclerView.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_item_bg), PixelUtils.a(15.0f)));
        this.f80366m.setLayoutManager(new GridLayoutManager(this, 3));
        this.f80370q = new v9.a<>(this.f80369p);
        this.f80369p.add(new gq.a("USDT", this.f80374u, true));
        this.f80369p.add(new gq.a("BTC", this.f80374u, false));
        this.f80369p.add(new gq.a("BCH", this.f80374u, false));
        this.f80369p.add(new gq.a("LTC", this.f80374u, false));
        this.f80369p.add(new gq.a(DefiChainInfo.CHAIN_ETH, this.f80374u, false));
        this.f80369p.add(new gq.a("ETC", this.f80374u, false));
        this.f80366m.setAdapter(this.f80370q);
        this.f80361h = (TextView) this.viewFinder.b(R.id.points_buy_conversion_price_tv);
        this.f80362i = (TextView) this.viewFinder.b(R.id.points_buy_confirm_available_tv);
        this.f80363j = (TextView) this.viewFinder.b(R.id.points_buy_confirm_pay_usdt_number_tv);
        this.f80367n = (TextView) this.viewFinder.b(R.id.points_buy_confirm_cancel_tv);
        this.f80368o = (TextView) this.viewFinder.b(R.id.points_buy_confirm_ok_tv);
        jq.d dVar = new jq.d(this);
        this.f80371r = dVar;
        dVar.k(this.f80375v);
    }

    public final void uh() {
        if (TextUtils.isEmpty(this.f80365l.getText())) {
            HuobiToastUtil.j(R.string.points_buy_confirm_error_number_hint);
            return;
        }
        ((PointsBuyPresenter) getPresenter()).m0(MapParamsBuilder.c().a(FirebaseAnalytics.Param.CURRENCY, ((PointsBuyPresenter) getPresenter()).c0().toLowerCase(Locale.US)).a("pack-id", Long.valueOf(((PointsBuyPresenter) getPresenter()).d0().getId())).a(FirebaseAnalytics.Param.QUANTITY, this.f80365l.getText().toString()).a("source", com.sumsub.sentry.a.f30241h).b());
    }

    /* renamed from: vh */
    public PointsBuyPresenter createPresenter() {
        return new PointsBuyPresenter();
    }

    /* renamed from: wh */
    public PointsBuyPresenter.e getUI() {
        return this;
    }

    public void zh() {
    }
}

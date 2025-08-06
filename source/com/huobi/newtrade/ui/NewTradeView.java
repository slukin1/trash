package com.huobi.newtrade.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.utils.SymbolUtil;
import com.huobi.view.NewTradePriceEdittext;
import com.huobi.view.TradeAmountEditext;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import ro.k;
import ro.l;
import rx.Observable;
import tg.r;

public class NewTradeView extends ConstraintLayout implements l {
    public EditText A;
    public NewTradePriceEdittext B;
    public EditText C;
    public TradeAmountEditext D;
    public TextView E;
    public RelativeLayout F;
    public TradeAmountEditext G;
    public EditText H;
    public TextView I;
    public CustomBoardView J;
    public int K;
    public int L;
    public List<CommonPopListItem> M;
    public qo.a N;
    public TextWatcher O;
    public View.OnTouchListener P;
    public CommonPopListItem.a Q;

    /* renamed from: b  reason: collision with root package name */
    public Context f78067b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f78068c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f78069d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78070e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f78071f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f78072g;

    /* renamed from: h  reason: collision with root package name */
    public BubbleSeekBar f78073h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f78074i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f78075j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f78076k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f78077l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f78078m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f78079n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f78080o;

    /* renamed from: p  reason: collision with root package name */
    public HuobiKeyboardHelper f78081p;

    /* renamed from: q  reason: collision with root package name */
    public MagicIndicator f78082q;

    /* renamed from: r  reason: collision with root package name */
    public CommonListPopupDialog f78083r;

    /* renamed from: s  reason: collision with root package name */
    public List<String> f78084s;

    /* renamed from: t  reason: collision with root package name */
    public View f78085t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f78086u;

    /* renamed from: v  reason: collision with root package name */
    public View f78087v;

    /* renamed from: w  reason: collision with root package name */
    public View f78088w;

    /* renamed from: x  reason: collision with root package name */
    public NewTradePriceEdittext f78089x;

    /* renamed from: y  reason: collision with root package name */
    public EditText f78090y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f78091z;

    public class a implements CommonPopListItem.a {
        public a() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            NewTradeView.this.f78083r.dismiss();
            NewTradeView.this.N.g(commonPopListItem.getType(), false);
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return NewTradeView.this.N.n() == commonPopListItem.getType();
        }
    }

    public class b extends CommonNavigatorAdapter {
        public b() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 != 0 || !NewTradeView.this.N.o()) {
                boolean z11 = true;
                if (i11 != 1 || NewTradeView.this.N.o()) {
                    NewTradeView.this.N.t(false);
                    if (i11 == 0) {
                        NewTradeView.this.A.setText("");
                        NewTradeView newTradeView = NewTradeView.this;
                        newTradeView.j0(newTradeView.N.k(), true, false);
                        NewTradeView.this.f78082q.setBackgroundResource(R.drawable.shape_exchange_green_vertical_container_bg);
                    } else if (i11 == 1) {
                        NewTradeView.this.A.setText("");
                        NewTradeView newTradeView2 = NewTradeView.this;
                        newTradeView2.j0(newTradeView2.N.i(), true, true);
                        NewTradeView.this.f78082q.setBackgroundResource(R.drawable.shape_exchange_red_vertical_container_bg);
                        z11 = false;
                    }
                    NewTradeView.this.V(z11);
                    NewTradeView.this.N.s(z11);
                    NewTradeView.this.N.f(r.x().F0(), z11);
                    NewTradeView.this.f78082q.c(i11);
                    NewTradeView.this.f78082q.b(i11, 0.0f, 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return NewTradeView.this.f78084s.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            if (i11 == 0) {
                tradeBuySellView.setNormalDrawable(R.color.baseColorContentBackground);
                tradeBuySellView.setNormalColor(ContextCompat.getColor(NewTradeView.this.getContext(), R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(NewTradeView.this.getContext(), R.color.baseTextColor));
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                }
            } else {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(NewTradeView.this.getContext(), R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(NewTradeView.this.getContext(), R.color.baseTextColor));
                tradeBuySellView.setNormalDrawable(R.color.baseColorContentBackground);
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                }
            }
            tradeBuySellView.setTextSize(14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(NewTradeView.this.getContext(), R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) NewTradeView.this.f78084s.get(i11));
            tradeBuySellView.setOnClickListener(new k(this, i11));
            return tradeBuySellView;
        }
    }

    public class c implements TextWatcher {
        public c() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                NewTradeView.this.C.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_regular));
            } else {
                NewTradeView.this.C.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_medium));
            }
            if (!NewTradeView.this.f78068c) {
                NewTradeView.this.N.a(editable, !TextUtils.isEmpty(editable));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                NewTradeView.this.A.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_regular));
            } else {
                NewTradeView.this.A.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_medium));
            }
            NewTradeView.this.N.c(editable, false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                NewTradeView.this.f78090y.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_regular));
            } else {
                NewTradeView.this.f78090y.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_medium));
            }
            NewTradeView.this.N.d(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (NewTradeView.this.N.n() == 3) {
                if (NewTradeView.this.N.o()) {
                    if (NewTradeView.this.K == 1) {
                        NewTradeView.this.R();
                    } else {
                        NewTradeView.this.Q();
                    }
                } else if (NewTradeView.this.L == 1) {
                    NewTradeView.this.R();
                } else {
                    NewTradeView.this.Q();
                }
            }
            NewTradeView.this.f78073h.setProgress(0.0f);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class g implements BaseDialogFragment.c {
        public g() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            NewTradeView.this.f78086u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(NewTradeView.this.f78067b, R.drawable.trade_arrow_down), (Drawable) null);
        }

        public void onDialogFragmentResume() {
            NewTradeView.this.f78086u.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(NewTradeView.this.f78067b, R.drawable.trade_arrow_up), (Drawable) null);
        }
    }

    public class h implements BubbleSeekBar.OnProgressChangedListener {
        public h() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
            NewTradeView.this.N.v(false);
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                NewTradeView.this.N.v(false);
            }
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            NewTradeView.this.N.v(z11);
            NewTradeView.this.N.r(i11, z11);
            if (z11) {
                NewTradeView.this.f78081p.hideKeyboard();
                NewTradeView.this.N.v(false);
            }
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            NewTradeView.this.W();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class j implements TextWatcher {
        public j() {
        }

        public void afterTextChanged(Editable editable) {
            boolean unused = NewTradeView.this.f78068c = true;
            if (editable == null || editable.length() == 0) {
                NewTradeView.this.H.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_regular));
            } else {
                NewTradeView.this.H.setTypeface(ResourcesCompat.h(NewTradeView.this.f78067b, R.font.roboto_medium));
            }
            NewTradeView.this.N.e(editable, false);
            boolean unused2 = NewTradeView.this.f78068c = false;
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public NewTradeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(Void voidR) {
        if (this.N.n() == 0) {
            ContractGuideHelper.e(((FragmentActivity) this.f78067b).getSupportFragmentManager(), 5);
        } else if (this.N.n() == 1) {
            ContractGuideHelper.e(((FragmentActivity) this.f78067b).getSupportFragmentManager(), 6);
        } else if (this.N.n() == 2) {
            ContractGuideHelper.e(((FragmentActivity) this.f78067b).getSupportFragmentManager(), 7);
        } else if (this.N.n() == 3) {
            ContractGuideHelper.e(((FragmentActivity) this.f78067b).getSupportFragmentManager(), 8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(View view, boolean z11) {
        if (z11) {
            this.J.showKeyBoardLayout(this.A, 3);
        }
        if (this.N.n() == 3) {
            i0(this.B.getInputPriceRl(), z11);
        } else {
            i0(this.B, z11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c0(View view, boolean z11) {
        i0(this.f78089x, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(View view, boolean z11) {
        i0(this.D, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(View view, boolean z11) {
        i0(this.G, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f0(View view) {
        if (this.f78067b != null) {
            Z();
            this.f78083r.setData(this.M);
            this.f78083r.setFollowViewWidth(true);
            this.f78083r.showAsDropDown(((FragmentActivity) this.f78067b).getSupportFragmentManager(), this.f78085t);
        }
        this.J.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Void voidR) {
        if (r.x().F0()) {
            this.J.hideKeyboardLayout();
            V(this.N.o());
            return;
        }
        sn.f.f(this.N.m(), this.f78067b);
    }

    private String getStopPrice() {
        String trim = this.f78090y.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public static /* synthetic */ boolean h0(View view, MotionEvent motionEvent) {
        return false;
    }

    public void A1(boolean z11) {
        String str;
        String j11 = this.N.j(this.f78089x.getEditText().getText().toString());
        if (TextUtils.isEmpty(j11) || BigDecimal.ZERO.compareTo(new BigDecimal(j11)) == 0) {
            str = "";
        } else {
            str = String.format(this.f78067b.getString(R.string.balance_total_cny), new Object[]{j11}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        }
        this.f78091z.setText(str);
    }

    public void F(int i11, boolean z11) {
        if (this.f78067b != null) {
            if (z11) {
                this.A.setText("");
                this.f78089x.getEditText().setText("");
            }
            this.C.setText("");
            this.E.setText("--");
            this.f78073h.setProgress(0.0f);
            this.J.hideKeyboardLayout();
        }
    }

    public final void O() {
        Observable<Void> a11 = dw.a.a(this.f78087v);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new ro.j(this));
        this.C.addTextChangedListener(new c());
        this.A.addTextChangedListener(new d());
        this.f78089x.getEditText().addTextChangedListener(new e());
        this.H.addTextChangedListener(this.O);
        this.A.setOnFocusChangeListener(new ro.f(this));
        this.f78089x.getEditText().setOnFocusChangeListener(new ro.e(this));
        this.B.getMarketPriceArea().setOnClickListener(new f());
        this.C.setOnFocusChangeListener(new ro.d(this));
        this.C.setOnTouchListener(new KeyboardTouchListener(this.J, 3, -1, this.P));
        this.H.setOnFocusChangeListener(new ro.g(this));
        this.H.setOnTouchListener(new KeyboardTouchListener(this.J, 3, -1, this.P));
        this.A.setOnTouchListener(new KeyboardTouchListener(this.J, 3, -1, this.P));
        this.f78089x.getEditText().setOnTouchListener(new KeyboardTouchListener(this.J, 3, -1, this.P));
        this.f78083r.setDialogFragmentListener(new g());
        this.f78086u.setOnClickListener(new ro.c(this));
        dw.a.a(this.I).throttleFirst(300, timeUnit).subscribe(new ro.i(this));
        this.f78073h.setOnProgressChangedListener(new h());
        this.f78080o.setOnClickListener(new i());
    }

    public void P(boolean z11, int i11, String str) {
        this.B.setLabel(SymbolUtil.c(str, false));
        this.G.setLabel(SymbolUtil.c(str, false));
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.D.setLabel(SymbolUtil.c(str, false));
            this.D.setEditHint(R.string.n_exchange_order_list_volume);
        } else if (i11 != 3) {
            if (!a1.v().Q(str) || !z11) {
                this.D.setLabel(SymbolUtil.c(str, true));
            } else {
                this.D.setLabel(SymbolUtil.c(str, false));
            }
            this.D.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (!z11) {
            this.D.setLabel(SymbolUtil.c(str, true));
            this.D.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (this.K == 2) {
            this.D.setLabel(SymbolUtil.c(str, false));
            this.D.setEditHint(R.string.n_exchange_order_list_volume);
        } else {
            this.D.setLabel(SymbolUtil.c(str, true));
            this.D.setEditHint(R.string.n_exchange_order_list_amount);
        }
        this.f78069d.setText(SymbolUtil.c(str, !z11));
    }

    public final void Q() {
        this.A.setText("");
        this.C.setText("");
        this.F.setVisibility(0);
        ViewUtil.m(this.G, false);
        this.B.setHintText((int) R.string.trade_input_price);
        this.B.setPriceInputType(3);
        this.B.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        this.B.setMarketPriceStyle(true);
        this.B.setMarketPriceAreaPressStyle(false);
        this.B.getInputPriceRl().setTag((Object) null);
        this.L = 1;
        this.K = 1;
        P(this.N.o(), this.N.n(), this.N.l());
        this.N.x();
    }

    public final void R() {
        this.A.setText("");
        this.C.setText("");
        this.F.setVisibility(4);
        ViewUtil.m(this.G, false);
        this.J.hideKeyboardLayout();
        this.B.setMarketPriceStyle(true);
        this.B.setHintText((int) R.string.n_trade_current_best);
        this.B.setPriceInputType(2);
        this.B.getInputPriceRl().setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
        this.B.setMarketPriceAreaPressStyle(true);
        this.B.getInputPriceRl().setTag("PLAN_MARKET_VIEW_TAG");
        this.L = 2;
        this.K = 2;
        P(this.N.o(), this.N.n(), this.N.l());
        this.N.x();
    }

    public final void S(boolean z11) {
        if (z11) {
            if (w.l()) {
                this.I.setBackgroundResource(R.drawable.trade_btn_sell_selector);
                this.f78082q.setBackgroundResource(R.drawable.shape_exchange_red_vertical_container_bg);
            } else {
                this.I.setBackgroundResource(R.drawable.trade_btn_buy_selector);
                this.f78082q.setBackgroundResource(R.drawable.shape_exchange_green_vertical_container_bg);
            }
        } else if (w.l()) {
            this.I.setBackgroundResource(R.drawable.trade_btn_buy_selector);
            this.f78082q.setBackgroundResource(R.drawable.shape_exchange_green_vertical_container_bg);
        } else {
            this.I.setBackgroundResource(R.drawable.trade_btn_sell_selector);
            this.f78082q.setBackgroundResource(R.drawable.shape_exchange_red_vertical_container_bg);
        }
        if (z11) {
            this.f78073h.setSecondTrackColor(ContextCompat.getColor(this.f78067b, w.h()));
            if (w.l()) {
                this.f78073h.setThumbBitmap(R.drawable.trade_slider_sell);
            } else {
                this.f78073h.setThumbBitmap(R.drawable.trade_slider_buy);
            }
        } else {
            this.f78073h.setSecondTrackColor(ContextCompat.getColor(this.f78067b, w.d()));
            if (w.l()) {
                this.f78073h.setThumbBitmap(R.drawable.trade_slider_buy);
            } else {
                this.f78073h.setThumbBitmap(R.drawable.trade_slider_sell);
            }
        }
    }

    public void T(boolean z11, int i11, String str) {
        String str2;
        if (r.x().F0()) {
            String p11 = a1.v().p(str);
            if (z11) {
                if (TradeType.PRO == this.N.m()) {
                    str2 = String.format(this.f78067b.getString(R.string.string_trade_bid), new Object[]{p11});
                } else {
                    str2 = String.format(this.f78067b.getString(R.string.string_margin_trade_bid), new Object[]{p11});
                }
            } else if (TradeType.PRO == this.N.m()) {
                str2 = String.format(this.f78067b.getString(R.string.string_trade_ask), new Object[]{p11});
            } else {
                str2 = String.format(this.f78067b.getString(R.string.string_margin_trade_ask), new Object[]{p11});
            }
            this.I.setText(str2);
            return;
        }
        this.I.setText(R.string.n_trade_log_in_to_exchange);
    }

    public final void U(int i11) {
        if (i11 < this.M.size()) {
            this.f78086u.setText(this.M.get(i11).getText());
        }
    }

    public void V(boolean z11) {
        this.A.clearFocus();
        this.f78089x.clearFocus();
        this.C.clearFocus();
        this.H.clearFocus();
        CustomBoardView customBoardView = this.J;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    public final void W() {
        String str;
        String l11 = this.N.l();
        if (this.N.m() == TradeType.PRO) {
            if (this.N.o()) {
                str = a1.v().E(l11, this.N.m());
            } else {
                str = a1.v().o(l11, this.N.m());
            }
            UnifyTransferActivity.Vh((Activity) this.f78067b, str, "1", true, (String) null, false, 1);
        } else if (this.N.m() == TradeType.MARGIN) {
            if (l11 != null) {
                UnifyTransferActivity.Uh((Activity) this.f78067b, (String) null, "3", false, l11, false);
            }
        } else if (this.N.m() == TradeType.C2C) {
            if (l11 != null) {
                UnifyTransferActivity.Uh((Activity) this.f78067b, (String) null, "8", false, l11, false);
            }
        } else if (l11 != null) {
            UnifyTransferActivity.Th((Activity) this.f78067b, a1.v().o(l11, this.N.m()), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        }
    }

    public final void X(AttributeSet attributeSet, Context context) {
        this.f78067b = context;
        i6.r rVar = new i6.r(LayoutInflater.from(context).inflate(R.layout.new_trade_layout, this, true));
        FrameLayout frameLayout = (FrameLayout) ((FragmentActivity) this.f78067b).findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        if (childCount > 0) {
            View childAt = frameLayout.getChildAt(childCount - 1);
            if (childAt == null || !(childAt instanceof CustomBoardView)) {
                CustomBoardView customBoardView = new CustomBoardView((Activity) this.f78067b);
                this.J = customBoardView;
                customBoardView.setGravity(80);
                this.J.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                frameLayout.addView(this.J, layoutParams);
            } else {
                this.J = (CustomBoardView) childAt;
            }
        }
        Y(rVar);
        this.f78085t = rVar.b(R.id.order_type_ll);
        this.f78086u = (TextView) rVar.b(R.id.trade_type_tv);
        this.f78087v = rVar.b(R.id.iv_contract_guide);
        Z();
        this.f78088w = rVar.b(R.id.stop_input_price_layout);
        NewTradePriceEdittext newTradePriceEdittext = (NewTradePriceEdittext) rVar.b(R.id.stop_input_price_et);
        this.f78089x = newTradePriceEdittext;
        this.f78090y = newTradePriceEdittext.getEditText();
        this.f78091z = (TextView) rVar.b(R.id.price_convert_stop_tv);
        NewTradePriceEdittext newTradePriceEdittext2 = (NewTradePriceEdittext) rVar.b(R.id.limit_input_price);
        this.B = newTradePriceEdittext2;
        newTradePriceEdittext2.setEditHint(R.string.trade_bid_price);
        this.A = this.B.getEditText();
        TradeAmountEditext tradeAmountEditext = (TradeAmountEditext) rVar.b(R.id.layout_input_amount);
        this.D = tradeAmountEditext;
        this.C = tradeAmountEditext.getEditText();
        this.E = (TextView) rVar.b(R.id.tv_input_volume_value);
        this.F = (RelativeLayout) rVar.b(R.id.layout_input_volume);
        TradeAmountEditext tradeAmountEditext2 = (TradeAmountEditext) rVar.b(R.id.volume_et_layout);
        this.G = tradeAmountEditext2;
        this.H = tradeAmountEditext2.getEditText();
        this.f78073h = (BubbleSeekBar) rVar.b(R.id.leverage_seekbar);
        this.f78074i = (TextView) rVar.b(R.id.progress_leverage);
        this.f78075j = (TextView) rVar.b(R.id.progress_leverage_label_tv);
        this.f78071f = (TextView) rVar.b(R.id.trade_spot_label1);
        this.f78070e = (TextView) rVar.b(R.id.tv_available_fund_value);
        this.f78069d = (TextView) rVar.b(R.id.available_fund_type_tv);
        this.f78080o = (LinearLayout) rVar.b(R.id.trade_transfer_area);
        this.I = (TextView) rVar.b(R.id.btn_trade_confirm);
        this.f78072g = (TextView) rVar.b(R.id.price_convert_tv);
        this.f78076k = (LinearLayout) rVar.b(R.id.stop_trade_ll);
        this.f78077l = (ImageView) rVar.b(R.id.trade_mask_iv);
        this.f78078m = (TextView) rVar.b(R.id.trade_mask_title_tv);
        this.f78079n = (TextView) rVar.b(R.id.trade_suspend_instruction_tv);
        this.f78081p = new HuobiKeyboardHelper().attach((Activity) this.f78067b);
        O();
    }

    public final void Y(i6.r rVar) {
        this.f78084s.add(this.f78067b.getString(R.string.trade_buy_label));
        this.f78084s.add(this.f78067b.getString(R.string.trade_sell_label));
        this.f78082q = (MagicIndicator) rVar.b(R.id.buy_shell_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(this.f78067b);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new b());
        this.f78082q.setNavigator(commonNavigator);
    }

    public void Z() {
        this.M.clear();
        this.M.add(new CommonPopListItem(0, this.f78067b.getString(R.string.n_contract_trade_order_type_limit), this.Q));
        this.M.add(new CommonPopListItem(1, this.f78067b.getString(R.string.trade_price_market_deal), this.Q));
        this.M.add(new CommonPopListItem(2, this.f78067b.getString(R.string.trade_trend_stop), this.Q));
        this.M.add(new CommonPopListItem(3, this.f78067b.getString(R.string.n_exchange_plan_entrusts), this.Q));
    }

    public void d(String str) {
        this.C.setText(str);
        EditText editText = this.C;
        editText.setSelection(editText.getText().length());
    }

    public void e(String str) {
        this.f78090y.setText(str);
        EditText editText = this.f78090y;
        editText.setSelection(editText.getText().length());
    }

    public void f(String str) {
        this.A.setText(str);
        EditText editText = this.A;
        editText.setSelection(editText.getText().length());
    }

    public void g(String str) {
        this.H.setText(str);
        EditText editText = this.H;
        editText.setSelection(editText.getText().length());
    }

    public String getInputAmountText() {
        String trim = this.C.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public String getInputPriceText() {
        String trim = this.A.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public int getUiPlanTradeBuyMode() {
        return this.K;
    }

    public int getUiPlanTradeSellMode() {
        return this.L;
    }

    public final void i0(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            Object tag = view.getTag();
            if ((tag instanceof String) && "PLAN_MARKET_VIEW_TAG".equals((String) tag)) {
                view.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
            }
        } else if (this.N.o()) {
            if (w.l()) {
                view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            } else {
                view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            }
        } else if (w.l()) {
            view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
        }
    }

    public final void j0(String str, boolean z11, boolean z12) {
        if (this.N.n() == 0 && !TextUtils.isEmpty(str) && !this.N.p() && z11) {
            if (m.a(str).compareTo(BigDecimal.ZERO) > 0) {
                this.A.setText(m.m(str, PrecisionUtil.e(this.N.l())));
                EditText editText = this.A;
                editText.setSelection(editText.getText().length());
                this.N.t(true);
                return;
            }
            this.A.setText("");
            this.N.t(true);
        }
    }

    public void l(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            if (this.F.getVisibility() == 0) {
                this.E.setText("--");
            }
            if (this.G.getVisibility() == 0) {
                this.H.removeTextChangedListener(this.O);
                this.H.setText("");
                this.H.addTextChangedListener(this.O);
            }
        } else {
            if (this.F.getVisibility() == 0) {
                this.E.setText(String.format(this.f78067b.getString(R.string.trade_total_volume_value), new Object[]{bigDecimal.toPlainString(), SymbolUtil.c(this.N.l(), false)}));
            }
            if (this.G.getVisibility() == 0) {
                this.H.removeTextChangedListener(this.O);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    this.H.setText("");
                } else {
                    this.H.setText(bigDecimal.toPlainString());
                }
                this.H.addTextChangedListener(this.O);
            }
        }
        if (TextUtils.isEmpty(this.H.getText())) {
            this.H.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.H.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public void n(boolean z11, int i11, String str) {
        int i12;
        P(z11, i11, str);
        T(z11, i11, str);
        S(z11);
        if (i11 == 3) {
            int i13 = this.K;
            if (i13 == 2 || (i12 = this.L) == 2) {
                R();
            } else if (i13 == 1 || i12 == 1) {
                Q();
            }
        }
    }

    public void n1(boolean z11) {
        String str;
        String j11 = this.N.j(this.A.getText().toString());
        if (TextUtils.isEmpty(j11) || BigDecimal.ZERO.compareTo(new BigDecimal(j11)) == 0) {
            str = "";
        } else {
            str = String.format(this.f78067b.getString(R.string.balance_total_cny), new Object[]{j11}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        }
        this.f78072g.setText(str);
    }

    public void setInputAmountText(String str) {
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.C.setText("");
        } else {
            this.C.setText(str);
            EditText editText = this.C;
            editText.setSelection(editText.getText().length());
        }
        if (TextUtils.isEmpty(this.C.getText())) {
            this.C.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.C.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public void setNewTradeViewController(qo.a aVar) {
        this.N = aVar;
    }

    public void setProgress(float f11) {
        this.f78073h.setProgress(f11);
    }

    public void setSelectedTab(int i11) {
        this.f78082q.c(i11);
        this.f78082q.b(i11, 0.0f, 0);
    }

    public void v(int i11, int i12, boolean z11, String str) {
        if (i12 == 3) {
            this.K = 1;
            this.L = 1;
            F(i12, true);
        }
        if (i12 == 1) {
            this.F.setVisibility(4);
            ViewUtil.m(this.G, false);
            this.B.setMarketPriceStyle(false);
            this.B.setHintText((int) R.string.trade_market_input_price_hint);
            this.B.setPriceInputType(2);
            this.B.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
            this.f78089x.setViewVisibilityAndEnable(0, true);
            this.f78089x.setLabelVisibility(8);
            this.f78089x.setMarketPriceStyle(false);
            this.A.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
            F(i12, true);
            ViewUtil.m(this.f78088w, false);
        } else if (i12 == 2) {
            this.F.setVisibility(0);
            ViewUtil.m(this.G, false);
            this.B.setHintText((int) R.string.trade_input_price);
            this.B.setPriceInputType(3);
            this.B.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.B.setMarketPriceStyle(false);
            this.f78089x.setViewVisibilityAndEnable(0, true);
            this.f78089x.setLabelVisibility(8);
            this.f78089x.setMarketPriceStyle(false);
            F(i12, true);
            ViewUtil.m(this.f78088w, true);
        } else if (i12 == 3) {
            this.F.setVisibility(0);
            ViewUtil.m(this.G, false);
            Q();
            this.f78089x.setViewVisibilityAndEnable(8, true);
            this.f78089x.setLabelVisibility(8);
            F(i12, true);
            ViewUtil.m(this.f78088w, true);
        } else {
            if (this.N.o()) {
                this.N.t(false);
                j0(this.N.k(), true, false);
            } else {
                this.N.t(false);
                j0(this.N.i(), true, true);
            }
            this.F.setVisibility(8);
            ViewUtil.m(this.G, true);
            this.B.setHintText((int) R.string.trade_input_price);
            this.B.setPriceInputType(1);
            this.B.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.B.setMarketPriceStyle(false);
            this.f78089x.setViewVisibilityAndEnable(0, true);
            this.f78089x.setLabelVisibility(8);
            this.f78089x.setMarketPriceStyle(false);
            F(i12, false);
            ViewUtil.m(this.f78088w, false);
        }
        U(i12);
        n(z11, i12, str);
    }

    public void z(boolean z11, int i11) {
        if (i11 == 3 && r.x().F0()) {
            this.f78089x.setReduceEnable(z11);
            this.f78089x.setReduceLongClickable(z11);
        }
        if (i11 == 1 && r.x().F0()) {
            this.B.setReduceEnable(z11);
            this.B.setReduceLongClickable(z11);
        }
    }

    public NewTradeView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public NewTradeView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f78083r = new CommonListPopupDialog();
        this.f78084s = new ArrayList();
        this.K = 1;
        this.L = 1;
        this.M = new ArrayList();
        this.O = new j();
        this.P = ro.h.f25770b;
        this.Q = new a();
        X(attributeSet, context);
    }
}

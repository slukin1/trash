package com.huobi.quicktrade.trade.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalBasePresenter;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.ui.x3;
import com.huobi.trade.ui.y3;
import com.huobi.utils.SymbolUtil;
import com.huobi.view.TradeAmountEditext;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.TradeRangeBarView;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.huobi.view.button.CircleStatusButton;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ht.o;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import sq.n;
import sq.p;
import sq.q;
import sq.s;
import sq.t;
import tg.r;

public abstract class QuickTradeVerticalBaseFragment<P extends QuickTradeVerticalBasePresenter<V>, V extends y3> extends QuickTradeBaseFragment<P, V> implements y3, View.OnClickListener {
    public boolean A;
    public TextView B;
    public TextView C;
    public EditText D;
    public TradePriceEditext E;
    public EditText F;
    public TradeAmountEditext G;
    public TextView H;
    public RelativeLayout I;
    public TradeAmountEditext J;
    public EditText K;
    public LinearLayout L;
    public FrameLayout M;
    public FrameLayout N;
    public CircleStatusButton O;
    public TextView P;
    public TextView Q;
    public EasyRecyclerView R;
    public List<CommonPopListItem> S = new ArrayList();
    public List<String> T = new ArrayList();
    public MagicIndicator U;
    public TradeRangeBarView V;
    public View W;
    public TradePriceEditext X;
    public View Y;
    public LinearLayout Z;

    /* renamed from: a0  reason: collision with root package name */
    public ImageView f80650a0;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f80651b0;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f80652c0;

    /* renamed from: d0  reason: collision with root package name */
    public LinearLayout f80653d0;

    /* renamed from: e0  reason: collision with root package name */
    public HuobiKeyboardHelper f80654e0;

    /* renamed from: f0  reason: collision with root package name */
    public View f80655f0;

    /* renamed from: g0  reason: collision with root package name */
    public CommonPopListItem.a f80656g0 = new d();

    /* renamed from: h0  reason: collision with root package name */
    public QuickTradeBaseFragment<P, V>.f f80657h0 = new b();

    public class a implements BubbleSeekBar.OnProgressChangedListener {
        public a() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).b1(false);
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).b1(false);
            }
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).b1(z11);
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).c1(i11, z11);
            if (z11) {
                QuickTradeVerticalBaseFragment.this.f80654e0.hideKeyboard();
                ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).b1(false);
            }
        }
    }

    public class b extends QuickTradeBaseFragment<P, V>.f {
        public b() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            boolean unused = QuickTradeVerticalBaseFragment.this.A = true;
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).W0(QuickTradeVerticalBaseFragment.this.K, editable, false);
            boolean unused2 = QuickTradeVerticalBaseFragment.this.A = false;
        }
    }

    public class c extends RecyclerView.ItemDecoration {
        public c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int dimensionPixelOffset = recyclerView.getResources().getDimensionPixelOffset(R.dimen.dimen_5);
            rect.set(0, recyclerView.getChildAdapterPosition(view) == 0 ? dimensionPixelOffset : 0, 0, dimensionPixelOffset);
        }
    }

    public class d implements CommonPopListItem.a {
        public d() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            QuickTradeVerticalBaseFragment.this.qi();
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).j0(commonPopListItem.getType(), false);
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).v0() == commonPopListItem.getType();
        }
    }

    public class e extends CommonNavigatorAdapter {
        public e() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            QuickTradeVerticalBaseFragment.this.qi();
            if (i11 != 0 || !((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).z0()) {
                boolean z11 = true;
                if (i11 != 1 || ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).z0()) {
                    ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).M0(false);
                    if (i11 == 0) {
                        QuickTradeVerticalBaseFragment.this.D.setText("");
                        QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment = QuickTradeVerticalBaseFragment.this;
                        quickTradeVerticalBaseFragment.Gi(((QuickTradeVerticalBasePresenter) quickTradeVerticalBaseFragment.yh()).r0(), true, false);
                    } else if (i11 == 1) {
                        QuickTradeVerticalBaseFragment.this.D.setText("");
                        QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment2 = QuickTradeVerticalBaseFragment.this;
                        quickTradeVerticalBaseFragment2.Gi(((QuickTradeVerticalBasePresenter) quickTradeVerticalBaseFragment2.yh()).m0(), true, true);
                        z11 = false;
                    }
                    QuickTradeVerticalBaseFragment.this.Q.setText(R.string.trade_asset_available);
                    QuickTradeVerticalBaseFragment.this.I3(z11);
                    ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).J0(z11);
                    ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).i0(r.x().F0(), z11);
                    QuickTradeVerticalBaseFragment.this.U.c(i11);
                    QuickTradeVerticalBaseFragment.this.U.b(i11, 0.0f, 0);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return QuickTradeVerticalBaseFragment.this.T.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) QuickTradeVerticalBaseFragment.this.T.get(i11));
            tradeBuySellView.setNormalColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
            tradeBuySellView.setSelectedColor(ContextCompat.getColor(context, R.color.baseTextColor));
            if (i11 == 0) {
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg);
                }
            } else if (w.l()) {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg_right);
            } else {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg_right);
            }
            tradeBuySellView.setOnClickListener(new t(this, i11));
            return tradeBuySellView;
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            QuickTradeVerticalBaseFragment.this.Ih();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class g extends QuickTradeBaseFragment<P, V>.f {
        public g() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (!QuickTradeVerticalBaseFragment.this.A) {
                ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).S0(QuickTradeVerticalBaseFragment.this.F, editable, !TextUtils.isEmpty(editable));
            }
        }
    }

    public class h extends QuickTradeBaseFragment<P, V>.f {
        public h() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).U0(QuickTradeVerticalBaseFragment.this.D, editable, false);
        }
    }

    public class i extends QuickTradeBaseFragment<P, V>.f {
        public i() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).V0(QuickTradeVerticalBaseFragment.this.X.getEditText(), editable);
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).v0() == 3) {
                if (((QuickTradeVerticalBasePresenter) QuickTradeVerticalBaseFragment.this.yh()).z0()) {
                    QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment = QuickTradeVerticalBaseFragment.this;
                    if (quickTradeVerticalBaseFragment.f80630x == 1) {
                        quickTradeVerticalBaseFragment.ki();
                    } else {
                        quickTradeVerticalBaseFragment.ji();
                    }
                } else {
                    QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment2 = QuickTradeVerticalBaseFragment.this;
                    if (quickTradeVerticalBaseFragment2.f80631y == 1) {
                        quickTradeVerticalBaseFragment2.ki();
                    } else {
                        quickTradeVerticalBaseFragment2.ji();
                    }
                }
            }
            QuickTradeVerticalBaseFragment.this.V.setProgress(0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            QuickTradeVerticalBaseFragment.this.qi();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ai(View view, boolean z11) {
        Ei(this.J, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bi(View view) {
        if (getActivity() != null) {
            if (this.R.getVisibility() == 0) {
                qi();
            } else {
                y2();
                this.P.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getActivity(), R.drawable.trade_arrow_up), (Drawable) null);
                this.R.setVisibility(0);
                this.R.setData(this.S);
            }
        }
        this.f80620n.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ci(View view) {
        qi();
        HashMap hashMap = new HashMap();
        hashMap.put("trade_class_name", ((QuickTradeVerticalBasePresenter) yh()).z0() ? "buy" : "sale");
        hashMap.put("order_class_name", nq.a.a());
        gs.g.i("App_quickcomponent_trade_spot_click", hashMap);
        if (r.x().F0()) {
            Jh();
            I3(((QuickTradeVerticalBasePresenter) yh()).z0());
            if (((QuickTradeVerticalBasePresenter) yh()).z0()) {
                ((QuickTradeVerticalBasePresenter) yh()).K0(this.f80630x);
            } else {
                ((QuickTradeVerticalBasePresenter) yh()).K0(this.f80631y);
            }
            ((QuickTradeVerticalBasePresenter) yh()).O0(getInputPriceText(), getInputAmountText(), ((QuickTradeVerticalBasePresenter) yh()).z0(), eg());
            if (TradeType.PRO == ((QuickTradeVerticalBasePresenter) yh()).u0()) {
                try {
                    gs.g.l(((QuickTradeVerticalBasePresenter) yh()).z0(), ((QuickTradeVerticalBasePresenter) yh()).o0(), "Vertical", ((QuickTradeVerticalBasePresenter) yh()).v0());
                } catch (Exception e11) {
                    i6.k.j("SensorsData", e11);
                }
            }
        } else {
            ((QuickTradeVerticalBasePresenter) yh()).N0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void Ei(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            Object tag = view.getTag();
            if ((tag instanceof String) && "PLAN_MARKET_VIEW_TAG".equals((String) tag)) {
                view.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
            }
        } else if (((QuickTradeVerticalBasePresenter) yh()).z0()) {
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

    /* access modifiers changed from: private */
    public void ji() {
        this.G.setAddReduceVisibility(true);
        this.D.setText("");
        this.F.setText("");
        this.I.setVisibility(0);
        ViewUtil.m(this.J, false);
        this.E.setHintText((int) R.string.trade_input_price);
        this.E.setPriceInputType(3);
        this.E.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        this.E.setMarketPriceStyle(true);
        this.E.setMarketPriceAreaPressStyle(false);
        this.E.getInputPriceRl().setTag((Object) null);
        this.f80631y = 1;
        this.f80630x = 1;
        ii(((QuickTradeVerticalBasePresenter) yh()).z0(), ((QuickTradeVerticalBasePresenter) yh()).v0(), ((QuickTradeVerticalBasePresenter) yh()).o0());
    }

    /* access modifiers changed from: private */
    public void ki() {
        this.G.setAddReduceVisibility(false);
        this.D.setText("");
        this.F.setText("");
        this.I.setVisibility(8);
        ViewUtil.m(this.J, false);
        this.f80620n.hideKeyboardLayout();
        this.E.setMarketPriceStyle(true);
        this.E.setHintText((int) R.string.n_trade_current_best);
        this.E.setHintTextColor(getResources().getColor(R.color.baseColorSecondaryTextNew));
        this.E.setPriceInputType(2);
        this.E.getInputPriceRl().setBackgroundResource(R.drawable.custom_edittext_unenable_bg_rect);
        this.E.setMarketPriceAreaPressStyle(true);
        this.E.getInputPriceRl().setTag("PLAN_MARKET_VIEW_TAG");
        this.f80631y = 2;
        this.f80630x = 2;
        ii(((QuickTradeVerticalBasePresenter) yh()).z0(), ((QuickTradeVerticalBasePresenter) yh()).v0(), ((QuickTradeVerticalBasePresenter) yh()).o0());
    }

    private void li(boolean z11) {
        if (z11) {
            if (w.l()) {
                this.O.setBackgroundResource(R.drawable.trade_btn_sell_selector);
            } else {
                this.O.setBackgroundResource(R.drawable.trade_btn_buy_selector);
            }
        } else if (w.l()) {
            this.O.setBackgroundResource(R.drawable.trade_btn_buy_selector);
        } else {
            this.O.setBackgroundResource(R.drawable.trade_btn_sell_selector);
        }
        if (z11) {
            this.V.setIsBuy(true);
            this.V.setSecondTrackColor(bh.j.b(R.color.baseColorMajorTheme100));
            if (w.l()) {
                this.V.setThumbBitmap(R.drawable.trade_slider_sell);
            } else {
                this.V.setThumbBitmap(R.drawable.trade_slider_buy);
            }
        } else {
            this.V.setIsBuy(false);
            this.V.setSecondTrackColor(bh.j.b(R.color.baseColorMajorTheme100));
            if (w.l()) {
                this.V.setThumbBitmap(R.drawable.trade_slider_buy);
            } else {
                this.V.setThumbBitmap(R.drawable.trade_slider_sell);
            }
        }
    }

    private void si() {
        this.T.add(getString(R.string.trade_buy_label));
        this.T.add(getString(R.string.trade_sell_label));
        this.U = (MagicIndicator) this.f67460i.b(R.id.buy_shell_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new e());
        this.U.setNavigator(commonNavigator);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wi(Void voidR) {
        if (((QuickTradeVerticalBasePresenter) yh()).v0() == 0) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 5);
        } else if (((QuickTradeVerticalBasePresenter) yh()).v0() == 1) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 6);
        } else if (((QuickTradeVerticalBasePresenter) yh()).v0() == 2) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 7);
        } else if (((QuickTradeVerticalBasePresenter) yh()).v0() == 3) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(View view, boolean z11) {
        if (z11) {
            this.f80620n.showKeyBoardLayout(this.D, 3);
        }
        if (((QuickTradeVerticalBasePresenter) yh()).v0() == 3) {
            Ei(this.E.getInputPriceRl(), z11);
        } else {
            Ei(this.E, z11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yi(View view, boolean z11) {
        Ei(this.X, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zi(View view, boolean z11) {
        Ei(this.G, z11);
    }

    public void A1(boolean z11) {
    }

    public void Ah() {
        super.Ah();
        dw.a.a(this.Y).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new s(this));
        ui();
        this.f80653d0.setOnClickListener(new f());
    }

    public void B(int i11) {
        this.U.c(i11);
        this.U.b(i11, 0.0f, 0);
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null && !((QuickTradeVerticalBasePresenter) yh()).z0()) {
            String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
            if (!a1.v().S(((QuickTradeVerticalBasePresenter) yh()).o0())) {
                Gi(valueOf, z11, true);
            }
        }
    }

    public void D2() {
    }

    public final void Di(int i11) {
        TradeAmountEditext tradeAmountEditext = this.G;
        if (i11 == 1) {
            ((ViewGroup) tradeAmountEditext.getParent()).removeView(tradeAmountEditext);
            this.M.addView(tradeAmountEditext, oi());
            this.M.setVisibility(0);
            this.N.setVisibility(8);
        } else if (i11 == 3) {
            ((ViewGroup) tradeAmountEditext.getParent()).removeView(tradeAmountEditext);
            this.N.addView(tradeAmountEditext, oi());
            this.N.setVisibility(0);
            this.M.setVisibility(8);
        } else {
            ((ViewGroup) tradeAmountEditext.getParent()).removeView(tradeAmountEditext);
            this.L.addView(tradeAmountEditext, pi());
            this.M.setVisibility(8);
            this.N.setVisibility(8);
        }
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null && ((QuickTradeVerticalBasePresenter) yh()).z0()) {
            String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
            if (!a1.v().S(((QuickTradeVerticalBasePresenter) yh()).o0())) {
                Gi(valueOf, z11, false);
            }
        }
    }

    public void E3(boolean z11) {
    }

    public void F(int i11, boolean z11) {
        if (getRootView() != null && getActivity() != null) {
            if (z11) {
                this.D.setText("");
                this.X.getEditText().setText("");
            }
            this.F.setText("");
            this.H.setText("--");
            this.V.setProgress(0);
            this.f80620n.hideKeyboardLayout();
        }
    }

    public void Fi(String str) {
        this.D.setText(str);
        EditText editText = this.D;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.D);
    }

    public void Gi(String str, boolean z11, boolean z12) {
        if (((QuickTradeVerticalBasePresenter) yh()).v0() != 1 && ((QuickTradeVerticalBasePresenter) yh()).v0() != 2 && ((QuickTradeVerticalBasePresenter) yh()).v0() != 3 && !TextUtils.isEmpty(str) && !((QuickTradeVerticalBasePresenter) yh()).A0() && z11) {
            if (m.a(str).compareTo(BigDecimal.ZERO) > 0) {
                this.D.setText(m.m(str, PrecisionUtil.e(((QuickTradeVerticalBasePresenter) yh()).o0())));
                EditText editText = this.D;
                editText.setSelection(editText.getText().length());
                ((QuickTradeVerticalBasePresenter) yh()).M0(true);
                return;
            }
            this.D.setText("");
            ((QuickTradeVerticalBasePresenter) yh()).M0(true);
        }
    }

    public void I3(boolean z11) {
        this.D.clearFocus();
        this.X.clearFocus();
        this.F.clearFocus();
        this.K.clearFocus();
        CustomBoardView customBoardView = this.f80620n;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    public void J(String str) {
    }

    public /* synthetic */ String Kc() {
        return x3.b(this);
    }

    public /* synthetic */ void M4(String str) {
        x3.e(this, str);
    }

    public /* synthetic */ void Of() {
        x3.c(this);
    }

    public /* synthetic */ void P4(String str) {
        x3.d(this, str);
    }

    public void Qb(List<DepthItem> list, int i11) {
    }

    public void R1(boolean z11, boolean z12) {
        this.O.setEnabled(z11);
    }

    public TradeRangeBarView T2() {
        return this.V;
    }

    public void U(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.D.getHint()}));
    }

    public void U2() {
    }

    public void X1(boolean z11) {
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f80620n;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f80620n.hideKeyboardLayout();
        return true;
    }

    public void Y2(DepthItem depthItem, String str) {
    }

    public void Ya(String str, boolean z11) {
    }

    public void Yb(int i11, boolean z11, boolean z12) {
    }

    public void b3() {
        this.C.setText("--");
    }

    public void c(int i11) {
    }

    public void c0(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.F.getHint()}));
    }

    public void d(boolean z11) {
        super.d(z11);
        this.E.setBtnClickEnable(z11);
        this.X.setBtnClickEnable(z11);
        this.G.setBtnClickEnable(z11);
        this.J.setBtnClickEnable(z11);
        if (!z11) {
            this.C.setText("--");
        }
    }

    public void d2(int i11) {
        this.E.setLength(i11);
        this.X.setLength(i11);
    }

    public /* synthetic */ String d8() {
        return x3.a(this);
    }

    public MultiColorSeekBar dd() {
        return null;
    }

    public void dismissProgressDialog() {
        CircleStatusButton circleStatusButton = this.O;
        if (circleStatusButton != null) {
            circleStatusButton.dismissAnimator();
        }
    }

    public String eg() {
        String trim = this.X.getEditText().getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public String getInputAmountText() {
        String trim = this.F.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public String getInputPriceText() {
        String trim = this.D.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void h2() {
    }

    public void i3(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.X.getEditText().getHint()}));
    }

    public void ii(boolean z11, int i11, String str) {
        this.E.setLabel(SymbolUtil.c(str, false));
        this.J.setLabel(SymbolUtil.c(str, false));
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.G.setLabel(SymbolUtil.c(str, false));
            this.G.setEditHint(R.string.n_exchange_order_list_volume);
        } else if (i11 != 3) {
            if (!a1.v().Q(str) || !z11) {
                this.G.setLabel(SymbolUtil.c(str, true));
            } else {
                this.G.setLabel(SymbolUtil.c(str, false));
            }
            this.G.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (!z11) {
            this.G.setLabel(SymbolUtil.c(str, true));
            this.G.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (this.f80630x == 2) {
            this.G.setLabel(SymbolUtil.c(str, false));
            this.G.setEditHint(R.string.n_exchange_order_list_volume);
        } else {
            this.G.setLabel(SymbolUtil.c(str, true));
            this.G.setEditHint(R.string.n_exchange_order_list_amount);
        }
        this.B.setText(SymbolUtil.c(str, !z11));
    }

    public void initViews() {
        super.initViews();
        this.W = this.f67460i.b(R.id.stop_input_price_layout);
        this.X = (TradePriceEditext) this.f67460i.b(R.id.stop_input_price_et);
        this.Y = this.f67460i.b(R.id.iv_contract_guide);
        this.Q = (TextView) this.f67460i.b(R.id.trade_spot_label1);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) this.f67460i.b(R.id.rv_trade_type);
        this.R = easyRecyclerView;
        easyRecyclerView.addItemDecoration(new c());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_0_5);
        this.R.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.R.setBackgroundResource(R.drawable.shape_base_pop_list_bg);
        vi();
        ri();
        this.Z = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f80650a0 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f80651b0 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f80652c0 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
        this.f80653d0 = (LinearLayout) this.f67460i.b(R.id.trade_transfer_area);
        this.f80654e0 = new HuobiKeyboardHelper().attach(getActivity());
    }

    public void l(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            if (this.I.getVisibility() == 0) {
                this.H.setText("--");
            }
            if (this.J.getVisibility() == 0) {
                this.K.removeTextChangedListener(this.f80657h0);
                this.K.setText("");
                this.K.addTextChangedListener(this.f80657h0);
            }
        } else {
            if (this.I.getVisibility() == 0) {
                this.H.setText(String.format(getString(R.string.trade_total_volume_value), new Object[]{bigDecimal.toPlainString(), SymbolUtil.c(((QuickTradeVerticalBasePresenter) yh()).o0(), false)}));
            }
            if (this.J.getVisibility() == 0) {
                this.K.removeTextChangedListener(this.f80657h0);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    this.K.setText("");
                } else {
                    this.K.setText(bigDecimal.toPlainString());
                }
                this.K.addTextChangedListener(this.f80657h0);
            }
        }
        if (TextUtils.isEmpty(this.K.getText())) {
            this.K.setTypeface(ResourcesCompat.h(getContext(), R.font.dinpro_regular));
        } else {
            this.K.setTypeface(ResourcesCompat.h(getContext(), R.font.dinpro_medium));
        }
    }

    public void m2(List<DepthItem> list, int i11) {
    }

    public void mi(boolean z11, int i11, String str) {
        String str2;
        if (r.x().F0()) {
            String p11 = a1.v().p(str);
            if (z11) {
                if (TradeType.PRO == ((QuickTradeVerticalBasePresenter) yh()).u0()) {
                    str2 = String.format(getString(R.string.string_trade_bid), new Object[]{p11});
                } else {
                    str2 = String.format(getString(R.string.string_margin_trade_bid), new Object[]{p11});
                }
            } else if (TradeType.PRO == ((QuickTradeVerticalBasePresenter) yh()).u0()) {
                str2 = String.format(getString(R.string.string_trade_ask), new Object[]{p11});
            } else {
                str2 = String.format(getString(R.string.string_margin_trade_ask), new Object[]{p11});
            }
            this.O.setButtonText(str2);
            return;
        }
        this.O.setButtonText((int) R.string.n_trade_log_in_to_exchange);
    }

    public void n(boolean z11, int i11, String str) {
        int i12;
        ii(z11, i11, str);
        mi(z11, i11, str);
        li(z11);
        if (i11 == 3) {
            int i13 = this.f80630x;
            if (i13 == 2 || (i12 = this.f80631y) == 2) {
                ki();
            } else if (i13 == 1 || i12 == 1) {
                ji();
            }
        }
    }

    public void n0() {
        this.U.getNavigator().notifyDataSetChanged();
    }

    public void n1(boolean z11) {
    }

    public void ni(int i11) {
        if (!a1.v().Q(((QuickTradeVerticalBasePresenter) yh()).o0()) && i11 < this.S.size()) {
            this.P.setText(this.S.get(i11).getText());
        }
    }

    public final FrameLayout.LayoutParams oi() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMarginStart(0);
        return layoutParams;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z11 = !((QuickTradeVerticalBasePresenter) yh()).z0();
        this.U.b(z11 ? 1 : 0, 0.0f, 0);
        this.U.c(z11);
    }

    public final LinearLayout.LayoutParams pi() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(DimenUtils.a(10.0f));
        return layoutParams;
    }

    public final void qi() {
        this.R.setVisibility(8);
        this.P.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getActivity(), R.drawable.trade_arrow_down), (Drawable) null);
    }

    public final void ri() {
        this.C = (TextView) this.f67460i.b(R.id.tv_available_fund_value);
        this.B = (TextView) this.f67460i.b(R.id.available_fund_type_tv);
    }

    public void setInputAmountText(String str) {
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.F.setText("");
        } else {
            this.F.setText(str);
            EditText editText = this.F;
            editText.setSelection(editText.getText().length());
        }
        if (TextUtils.isEmpty(this.F.getText())) {
            this.F.setTypeface(ResourcesCompat.h(getContext(), R.font.dinpro_regular));
        } else {
            this.F.setTypeface(ResourcesCompat.h(getContext(), R.font.dinpro_medium));
        }
    }

    public void setProgressText(String str) {
    }

    public void showProgressDialog() {
        CircleStatusButton circleStatusButton = this.O;
        if (circleStatusButton != null) {
            circleStatusButton.showAnimator();
        }
    }

    public void t(SymbolBean symbolBean) {
        if (!MarginBalanceQueryData.STATE_FL_SYS.equals(this.Z.getTag(R.id.item_data1))) {
            if (symbolBean == null) {
                this.Z.setVisibility(8);
            } else if (SymbolBean.PRE_ONLINE.equals(symbolBean.getState())) {
                if (symbolBean.isWhiteEnabled()) {
                    this.Z.setVisibility(8);
                    return;
                }
                this.f80650a0.setImageResource(R.drawable.exchange_forbiden_waiting_image);
                this.f80651b0.setText(R.string.trade_pre_online);
                this.f80652c0.setVisibility(8);
                this.Z.setVisibility(0);
            } else if (SymbolBean.SUSPEND.equals(symbolBean.getState())) {
                if (symbolBean.isWhiteEnabled()) {
                    this.Z.setVisibility(8);
                    return;
                }
                this.f80650a0.setImageResource(R.drawable.exchange_forbiden_image);
                this.f80651b0.setText(R.string.trade_suspend);
                this.f80652c0.setText(symbolBean.getSuspendDesc());
                this.f80652c0.setVisibility(0);
                this.Z.setVisibility(0);
            } else if (SymbolBean.TRANSFER_BOARD.equals(symbolBean.getState())) {
                this.f80650a0.setImageResource(R.drawable.exchange_transfer_type_image);
                this.f80651b0.setText(R.string.trade_transfer_board);
                this.f80652c0.setText(symbolBean.getTransferBoardDesc());
                this.f80652c0.setVisibility(0);
                this.Z.setVisibility(0);
            } else if (SymbolBean.FUSE.equals(symbolBean.getState())) {
                this.f80650a0.setImageResource(R.drawable.exchange_forbiden_image);
                this.f80651b0.setText(R.string.trade_fuse_hint);
                this.f80652c0.setVisibility(8);
                this.Z.setVisibility(0);
            } else {
                this.Z.setVisibility(8);
            }
        }
    }

    public final void ti() {
        TradePriceEditext tradePriceEditext = (TradePriceEditext) this.f67460i.b(R.id.limit_input_price);
        this.E = tradePriceEditext;
        this.D = tradePriceEditext.getEditText();
        TradeAmountEditext tradeAmountEditext = (TradeAmountEditext) this.f67460i.b(R.id.layout_input_amount);
        this.G = tradeAmountEditext;
        this.F = tradeAmountEditext.getEditText();
        this.H = (TextView) this.f67460i.b(R.id.tv_input_volume_value);
        this.I = (RelativeLayout) this.f67460i.b(R.id.layout_input_volume);
        TradeAmountEditext tradeAmountEditext2 = (TradeAmountEditext) this.f67460i.b(R.id.volume_et_layout);
        this.J = tradeAmountEditext2;
        this.K = tradeAmountEditext2.getEditText();
        this.O = (CircleStatusButton) this.f67460i.b(R.id.btn_trade_confirm);
        String o02 = ((QuickTradeVerticalBasePresenter) yh()).o0();
        this.E.setEditHint(R.string.trade_bid_price);
        this.E.setLabel(SymbolUtil.c(o02, false));
        this.X.setLabel(SymbolUtil.c(o02, false));
        this.L = (LinearLayout) this.f67460i.b(R.id.ll_trade_amount_container);
        this.M = (FrameLayout) this.f67460i.b(R.id.fl_market_trade_amount_container);
        this.N = (FrameLayout) this.f67460i.b(R.id.fl_plan_trade_amount_container);
    }

    public void u3(String str) {
        int v02 = ((QuickTradeVerticalBasePresenter) yh()).v0();
        if (v02 == 0 || v02 == 2) {
            if (!a1.v().S(((QuickTradeVerticalBasePresenter) yh()).o0()) || !o.B().P()) {
                Fi(str);
            }
        } else if (v02 == 3) {
            if (1 != this.f80630x && 1 != this.f80631y) {
                return;
            }
            if (!a1.v().S(((QuickTradeVerticalBasePresenter) yh()).o0()) || !o.B().P()) {
                Fi(str);
            }
        }
    }

    public void u9(String str, boolean z11) {
    }

    public final void ui() {
        this.F.addTextChangedListener(new g());
        this.D.addTextChangedListener(new h());
        this.X.getEditText().addTextChangedListener(new i());
        this.K.addTextChangedListener(this.f80657h0);
        this.D.setOnFocusChangeListener(new q(this));
        this.X.getEditText().setOnFocusChangeListener(new p(this));
        this.E.getMarketPriceArea().setOnClickListener(new j());
        this.F.setOnFocusChangeListener(new sq.r(this));
        this.F.setOnTouchListener(new KeyboardTouchListener(this.f80620n, 3, -1, (View.OnTouchListener) null));
        this.K.setOnFocusChangeListener(new sq.o(this));
        this.K.setOnTouchListener(new KeyboardTouchListener(this.f80620n, 3, -1, (View.OnTouchListener) null));
        this.D.setOnTouchListener(new KeyboardTouchListener(this.f80620n, 3, -1, (View.OnTouchListener) null));
        this.X.getEditText().setOnTouchListener(new KeyboardTouchListener(this.f80620n, 3, -1, (View.OnTouchListener) null));
        this.P.setOnClickListener(new sq.m(this));
        this.f67460i.b(R.id.trade_spot_content_parent).setOnClickListener(new k());
        this.O.setOnClickListener(new n(this));
        this.V.setOnProgressChangedListener(new a());
    }

    public void v(int i11, int i12, boolean z11, String str) {
        Di(i12);
        if (i12 == 3) {
            this.f80630x = 1;
            this.f80631y = 1;
            F(i12, true);
        }
        if (i12 == 1) {
            this.I.setVisibility(8);
            ViewUtil.m(this.J, false);
            this.E.setMarketPriceStyle(false);
            this.E.setHintText((int) R.string.trade_market_input_price_hint);
            this.E.setPriceInputType(2);
            this.E.setBackgroundResource(R.drawable.custom_edittext_unable_bg);
            this.X.setViewVisibilityAndEnable(0, true);
            this.X.setLabelVisibility(8);
            this.X.setMarketPriceStyle(false);
            this.D.setTypeface(ResourcesCompat.h(getContext(), R.font.dinpro_regular));
            F(i12, true);
            ViewUtil.m(this.W, false);
        } else if (i12 == 2) {
            this.I.setVisibility(0);
            ViewUtil.m(this.J, false);
            this.E.setHintText((int) R.string.trade_input_price);
            this.E.setPriceInputType(3);
            this.E.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.E.setMarketPriceStyle(false);
            this.X.setViewVisibilityAndEnable(0, true);
            this.X.setLabelVisibility(8);
            this.X.setMarketPriceStyle(false);
            F(i12, true);
            ViewUtil.m(this.W, true);
        } else if (i12 == 3) {
            this.I.setVisibility(0);
            ViewUtil.m(this.J, false);
            ji();
            this.X.setViewVisibilityAndEnable(8, true);
            this.X.setLabelVisibility(8);
            F(i12, true);
            ViewUtil.m(this.W, true);
        } else {
            if (((QuickTradeVerticalBasePresenter) yh()).z0()) {
                ((QuickTradeVerticalBasePresenter) yh()).M0(false);
                Gi(((QuickTradeVerticalBasePresenter) yh()).r0(), true, false);
            } else {
                ((QuickTradeVerticalBasePresenter) yh()).M0(false);
                Gi(((QuickTradeVerticalBasePresenter) yh()).m0(), true, true);
            }
            this.I.setVisibility(8);
            ViewUtil.m(this.J, true);
            this.E.setHintText((int) R.string.trade_input_price);
            this.E.setPriceInputType(1);
            this.E.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.E.setMarketPriceStyle(false);
            this.X.setViewVisibilityAndEnable(0, true);
            this.X.setLabelVisibility(8);
            this.X.setMarketPriceStyle(false);
            F(i12, false);
            ViewUtil.m(this.W, false);
        }
        ni(i12);
        n(z11, i12, str);
    }

    public final void vi() {
        si();
        this.P = (TextView) this.f67460i.b(R.id.trade_type_tv);
        this.f80655f0 = this.f67460i.b(R.id.order_type_ll);
        this.V = (TradeRangeBarView) this.f67460i.b(R.id.trade_range_bar);
        ti();
    }

    public void w3() {
    }

    public void y2() {
        this.S.clear();
        this.S.add(new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f80656g0));
        this.S.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f80656g0));
        this.S.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f80656g0));
        this.S.add(new CommonPopListItem(3, getString(R.string.n_exchange_plan_entrusts), this.f80656g0));
    }

    public void z(boolean z11, int i11) {
        if (i11 == 3 && r.x().F0()) {
            this.X.setReduceEnable(z11);
            this.X.setReduceLongClickable(z11);
        }
        if (i11 == 1 && r.x().F0()) {
            this.E.setReduceEnable(z11);
            this.E.setReduceLongClickable(z11);
        }
    }
}

package com.hbg.module.market.widget.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.market.R$anim;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.hbg.module.market.widget.bean.MarketSearchResultItem;
import com.hbg.module.market.widget.event.MarketSettingEvent;
import com.hbg.module.market.widget.presenter.MarketWidgetSearchPresenter;
import com.huobi.view.HBSearchView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import mf.d;
import mf.e;
import mf.f;
import mf.g;
import mf.h;
import org.greenrobot.eventbus.EventBus;

public class MarketWidgetSearchActivity extends BaseActivity<MarketWidgetSearchPresenter, MarketWidgetSearchPresenter.b> implements MarketWidgetSearchPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26743b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26744c;

    /* renamed from: d  reason: collision with root package name */
    public HBSearchView f26745d;

    /* renamed from: e  reason: collision with root package name */
    public View f26746e;

    /* renamed from: f  reason: collision with root package name */
    public EasyRecyclerView<s9.a> f26747f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f26748g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26749h;

    /* renamed from: i  reason: collision with root package name */
    public InputMethodManager f26750i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f26751j;

    /* renamed from: k  reason: collision with root package name */
    public List<s9.a> f26752k;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                String obj = editable.toString();
                if (TextUtils.isEmpty(obj)) {
                    MarketWidgetSearchActivity.this.zh(true);
                    ((MarketWidgetSearchPresenter) MarketWidgetSearchActivity.this.getPresenter()).S(MarketWidgetSearchActivity.this);
                    return;
                }
                MarketWidgetSearchActivity.this.zh(false);
                MarketWidgetSearchActivity.this.f26745d.setSelection(obj.length());
                MarketWidgetSearchActivity marketWidgetSearchActivity = MarketWidgetSearchActivity.this;
                boolean unused = marketWidgetSearchActivity.f26751j = ((MarketWidgetSearchPresenter) marketWidgetSearchActivity.getPresenter()).b0(MarketWidgetSearchActivity.this, editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            MarketWidgetSearchActivity.this.rh();
            return true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        MarketSettingEvent marketSettingEvent = new MarketSettingEvent();
        marketSettingEvent.e(true);
        EventBus.d().k(marketSettingEvent);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        this.f26745d.setSearchText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vh(View view) {
        uh();
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean wh(TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3) {
            return false;
        }
        this.f26750i.hideSoftInputFromWindow(this.f26745d.getWindowToken(), 0);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh() {
        SoftInputUtils.f(this);
    }

    public static void yh(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, MarketWidgetSearchActivity.class));
        }
    }

    public boolean Y3(EditText editText, TextView textView, int i11, KeyEvent keyEvent) {
        InputMethodManager inputMethodManager;
        if (i11 != 3) {
            return false;
        }
        if (!(editText == null || (inputMethodManager = this.f26750i) == null)) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        rh();
        return true;
    }

    public void addEvent() {
        this.f26743b.setOnClickListener(new e(this));
        this.f26744c.setClickable(true);
        this.f26744c.setOnClickListener(new d(this));
        this.f26745d.setClearOnClickListener(new f(this));
        this.f26745d.addTextChangeListener(new a());
        this.f26745d.setOnEditorActionListener(new g(this));
        this.f26747f.setOnTouchListener(new b());
    }

    public boolean canFullScreen() {
        return true;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R$anim.slide_in_from_left, R$anim.slide_out_to_right);
    }

    public int getContentView() {
        setStatusBarColor(getResources().getColor(R$color.global_item_bg));
        return R$layout.activity_market_widget_search;
    }

    public void h0(boolean z11) {
        int i11;
        if (z11) {
            this.f26748g.setVisibility(0);
        } else {
            this.f26748g.setVisibility(4);
        }
        HBSearchView hBSearchView = this.f26745d;
        if (hBSearchView != null && this.f26749h != null) {
            if (TextUtils.isEmpty(hBSearchView.getSearchText().trim())) {
                i11 = R$string.trade_no_record;
            } else {
                i11 = R$string.search_result_text;
            }
            this.f26749h.setText(getString(i11));
        }
    }

    public void hb(String str) {
        HBSearchView hBSearchView = this.f26745d;
        if (hBSearchView != null) {
            hBSearchView.setSearchText(str);
        }
    }

    public void initView() {
        this.f26743b = (ImageView) this.viewFinder.b(R$id.id_back_btn);
        this.f26744c = (TextView) this.viewFinder.b(R$id.search_symbol_ok);
        View b11 = this.viewFinder.b(R$id.ll_serach_input_container);
        this.f26746e = b11;
        b11.requestFocus();
        this.f26747f = (EasyRecyclerView) this.viewFinder.b(R$id.rlv_search_result_list);
        this.f26745d = (HBSearchView) this.viewFinder.b(R$id.search_symbol_input);
        this.f26748g = (LinearLayout) this.viewFinder.b(R$id.ll_search_norecord);
        this.f26749h = (TextView) this.viewFinder.b(R$id.tv_no_data_tips);
        this.f26750i = (InputMethodManager) getSystemService("input_method");
        this.f26751j = false;
        this.f26752k = new ArrayList();
        this.f26747f.setCallback(new h(this));
        this.f26745d.setInputActionType(3);
        this.f26745d.getEditTextHbsSearchView().setFocusableInTouchMode(true);
        this.f26745d.getEditTextHbsSearchView().clearFocus();
    }

    public void oa(MarketSearchResultItem marketSearchResultItem, ImageView imageView) {
        uh();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        return super.onKeyDown(i11, keyEvent);
    }

    public void onPause() {
        super.onPause();
        uh();
    }

    public void onStop() {
        super.onStop();
        HBSearchView hBSearchView = this.f26745d;
        if (hBSearchView != null) {
            hBSearchView.setSearchText("");
        }
    }

    public final void rh() {
        this.f26746e.requestFocus();
        ((MarketWidgetSearchPresenter) getPresenter()).Z(false);
    }

    /* renamed from: sh */
    public MarketWidgetSearchPresenter createPresenter() {
        return new MarketWidgetSearchPresenter();
    }

    /* renamed from: th */
    public MarketWidgetSearchPresenter.b getUI() {
        return this;
    }

    public final void uh() {
        InputMethodManager inputMethodManager = this.f26750i;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f26745d.getWindowToken(), 40);
        }
        rh();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void x6(List<s9.a> list) {
        if (list != null) {
            this.f26752k.clear();
            this.f26752k.addAll(list);
        }
        this.f26747f.setData(this.f26752k);
    }

    public void yd(Editable editable) {
        if (!TextUtils.isEmpty(editable) && this.f26745d != null) {
            zh(false);
            String obj = editable.toString();
            this.f26745d.setSearchText(obj);
            this.f26745d.setSelection(obj.length());
        }
    }

    public final void zh(boolean z11) {
        if (z11) {
            ((MarketWidgetSearchPresenter) getPresenter()).Z(true);
            return;
        }
        this.f26745d.requestFocus();
        ((MarketWidgetSearchPresenter) getPresenter()).Z(false);
    }
}

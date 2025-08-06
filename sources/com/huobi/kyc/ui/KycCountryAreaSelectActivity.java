package com.huobi.kyc.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.huobi.kyc.presenter.KycCountryAreaSelectPresenter;
import com.huobi.utils.StatusBarUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import um.c;

@Route(path = "/account/kycCountryList")
public class KycCountryAreaSelectActivity extends BaseActivity<KycCountryAreaSelectPresenter, KycCountryAreaSelectPresenter.a> implements KycCountryAreaSelectPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f74856b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f74857c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f74858d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f74859e;

    /* renamed from: f  reason: collision with root package name */
    public View f74860f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            KycCountryAreaSelectActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            TextPaint paint = KycCountryAreaSelectActivity.this.f74858d.getPaint();
            if (charSequence.length() > 0) {
                paint.setTypeface(ResourcesCompat.h(KycCountryAreaSelectActivity.this.f74858d.getContext(), R.font.roboto_medium));
            } else {
                paint.setTypeface(ResourcesCompat.h(KycCountryAreaSelectActivity.this.f74858d.getContext(), R.font.roboto_regular));
            }
            ((KycCountryAreaSelectPresenter) KycCountryAreaSelectActivity.this.getPresenter()).Z(charSequence.toString());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qg(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        ((KycCountryAreaSelectPresenter) getPresenter()).X();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oh(Void voidR) {
        finish();
    }

    /* renamed from: Og */
    public KycCountryAreaSelectPresenter createPresenter() {
        return new KycCountryAreaSelectPresenter();
    }

    /* renamed from: Pg */
    public KycCountryAreaSelectPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
        this.f74857c.setOnClickListener(new a());
        this.f74860f.setOnClickListener(new um.b(this));
        this.f74858d.addTextChangedListener(new b());
        this.f74859e.setOnRetryClickListener(new um.a(this));
    }

    public LoadingLayout f1() {
        return this.f74859e;
    }

    public int getContentView() {
        return R.layout.listview_kyc_select_country;
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.listview_country);
        this.f74856b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f74857c = (TextView) this.viewFinder.b(R.id.choose_country_cancel);
        this.f74858d = (EditText) this.viewFinder.b(R.id.choose_country_edit);
        this.f74860f = this.viewFinder.b(R.id.close_btn);
        this.f74859e = (LoadingLayout) this.viewFinder.b(R.id.select_country_layout);
        this.f74859e.setEmptyView(LayoutInflater.from(this).inflate(R.layout.common_empty_search_view, (ViewGroup) null));
        dw.a.a(findViewById(R.id.topView)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new c(this));
    }

    public void k9(MultiTypeAdapter multiTypeAdapter) {
        this.f74856b.setAdapter(multiTypeAdapter);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtils.g(this, Color.parseColor("#80000000"));
    }
}

package com.huobi.activity;

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
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.login.presenter.CountryAreaSelectPresenter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import xg.r;

public class CountryAreaSelectActivity extends BaseActivity<CountryAreaSelectPresenter, CountryAreaSelectPresenter.a> implements CountryAreaSelectPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f42061b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42062c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f42063d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f42064e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CountryAreaSelectActivity.this.finish();
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
            TextPaint paint = CountryAreaSelectActivity.this.f42063d.getPaint();
            if (charSequence.length() > 0) {
                paint.setTypeface(ResourcesCompat.h(CountryAreaSelectActivity.this.f42063d.getContext(), R.font.roboto_medium));
            } else {
                paint.setTypeface(ResourcesCompat.h(CountryAreaSelectActivity.this.f42063d.getContext(), R.font.roboto_regular));
            }
            ((CountryAreaSelectPresenter) CountryAreaSelectActivity.this.getPresenter()).n0(charSequence.toString());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        ((CountryAreaSelectPresenter) getPresenter()).k0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Jd(v9.a<CountryListData> aVar) {
        this.f42061b.setAdapter(aVar);
    }

    public void addEvent() {
        this.f42062c.setOnClickListener(new a());
        this.f42063d.addTextChangedListener(new b());
        this.f42064e.setOnRetryClickListener(new r(this));
    }

    public LoadingLayout f1() {
        return this.f42064e;
    }

    /* renamed from: fg */
    public CountryAreaSelectPresenter createPresenter() {
        return new CountryAreaSelectPresenter();
    }

    public int getContentView() {
        return R.layout.listview_select_country;
    }

    /* renamed from: gg */
    public CountryAreaSelectPresenter.a getUI() {
        return this;
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.listview_country);
        this.f42061b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f42062c = (TextView) this.viewFinder.b(R.id.choose_country_cancel);
        this.f42063d = (EditText) this.viewFinder.b(R.id.choose_country_edit);
        this.f42064e = (LoadingLayout) this.viewFinder.b(R.id.select_country_layout);
        this.f42064e.setEmptyView(LayoutInflater.from(this).inflate(R.layout.common_empty_search_view, (ViewGroup) null));
    }
}

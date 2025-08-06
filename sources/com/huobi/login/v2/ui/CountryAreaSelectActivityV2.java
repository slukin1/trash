package com.huobi.login.v2.ui;

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
import com.huobi.login.presenter.CountryAreaSelectPresenter;
import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.utils.StatusBarUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;
import pro.huobi.R;
import rx.Observable;
import tn.h;
import tn.i;
import tq.p;

@Route(path = "/login/CountryPicker")
public class CountryAreaSelectActivityV2 extends BaseActivity<CountryAreaSelectPresenter, CountryAreaSelectPresenter.a> implements CountryAreaSelectPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f75777b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75778c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f75779d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f75780e;

    /* renamed from: f  reason: collision with root package name */
    public View f75781f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            CountryAreaSelectActivityV2.this.finish();
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
            TextPaint paint = CountryAreaSelectActivityV2.this.f75779d.getPaint();
            if (charSequence.length() > 0) {
                paint.setTypeface(ResourcesCompat.h(CountryAreaSelectActivityV2.this.f75779d.getContext(), R.font.roboto_medium));
            } else {
                paint.setTypeface(ResourcesCompat.h(CountryAreaSelectActivityV2.this.f75779d.getContext(), R.font.roboto_regular));
            }
            ((CountryAreaSelectPresenter) CountryAreaSelectActivityV2.this.getPresenter()).n0(charSequence.toString());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pg(View view) {
        ((CountryAreaSelectPresenter) getPresenter()).k0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static Observable<List<CountryListData>> Qg() {
        return UserCenterRemoteDataSource.A().t().compose(p.c0());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Jd(v9.a<CountryListData> aVar) {
        this.f75777b.setAdapter(aVar);
    }

    /* renamed from: Og */
    public CountryAreaSelectPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
        this.f75778c.setOnClickListener(new a());
        this.f75781f.setOnClickListener(new h(this));
        this.f75779d.addTextChangedListener(new b());
        this.f75780e.setOnRetryClickListener(new i(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public LoadingLayout f1() {
        return this.f75780e;
    }

    public int getContentView() {
        return R.layout.listview_select_country_v2;
    }

    /* renamed from: gg */
    public CountryAreaSelectPresenter createPresenter() {
        return new CountryAreaSelectPresenter();
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.listview_country);
        this.f75777b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.f75778c = (TextView) this.viewFinder.b(R.id.choose_country_cancel);
        this.f75779d = (EditText) this.viewFinder.b(R.id.choose_country_edit);
        this.f75781f = this.viewFinder.b(R.id.close_btn);
        this.f75780e = (LoadingLayout) this.viewFinder.b(R.id.select_country_layout);
        this.f75780e.setEmptyView(LayoutInflater.from(this).inflate(R.layout.common_empty_search_view, (ViewGroup) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarUtils.e(this, 0);
        changeStatusBarTextColor(!isLightStatusBar());
    }
}

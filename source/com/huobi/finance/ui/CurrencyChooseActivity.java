package com.huobi.finance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.presenter.CurrencyChoosePresenter;
import com.huobi.view.indexlist.IndexPartAdapter;
import com.huobi.view.indexlist.IndexPartLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;

public class CurrencyChooseActivity extends BaseActivity<CurrencyChoosePresenter, CurrencyChoosePresenter.c> implements CurrencyChoosePresenter.c {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f46442b;

    /* renamed from: c  reason: collision with root package name */
    public View f46443c;

    /* renamed from: d  reason: collision with root package name */
    public IndexPartLayout f46444d;

    /* renamed from: e  reason: collision with root package name */
    public LoadingLayout f46445e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f46446f;

    /* renamed from: g  reason: collision with root package name */
    public SearchFragment f46447g;

    /* renamed from: h  reason: collision with root package name */
    public ClearEditText f46448h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46449i;

    /* renamed from: j  reason: collision with root package name */
    public List<SymbolCurrencyEntity> f46450j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public a f46451k;

    public class a extends IndexPartAdapter<SymbolCurrencyEntity> {

        /* renamed from: a  reason: collision with root package name */
        public LayoutInflater f46452a;

        /* renamed from: com.huobi.finance.ui.CurrencyChooseActivity$a$a  reason: collision with other inner class name */
        public class C0572a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f46454a;

            public C0572a(View view) {
                super(view);
                this.f46454a = (TextView) view.findViewById(R.id.tv_name);
            }
        }

        public class b extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f46456a;

            public b(View view) {
                super(view);
                this.f46456a = (TextView) view.findViewById(R.id.tv_index);
            }
        }

        public a(Context context) {
            this.f46452a = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, SymbolCurrencyEntity symbolCurrencyEntity) {
            ((C0572a) viewHolder).f46454a.setText(symbolCurrencyEntity.getName() == null ? "" : symbolCurrencyEntity.getName().toUpperCase(Locale.US));
        }

        public void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str) {
            ((b) viewHolder).f46456a.setText(str);
        }

        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
            return new C0572a(this.f46452a.inflate(R.layout.item_currency_choose, viewGroup, false));
        }

        public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup) {
            return new b(this.f46452a.inflate(R.layout.item_index_currency_choose, viewGroup, false));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void ph(Activity activity, String str, String str2, String str3, boolean z11) {
        Intent intent = new Intent(activity, CurrencyChooseActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("coin", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("KEY_JUMP_FOR", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(Constants.FLAG_ACCOUNT, str3);
        }
        intent.putExtra("JUMP_RECHOOSE", z11);
        if (z11) {
            activity.startActivityForResult(intent, 1001);
        } else {
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(View view) {
        ((CurrencyChoosePresenter) getPresenter()).X();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(View view, int i11, int i12, SymbolCurrencyEntity symbolCurrencyEntity) {
        ((CurrencyChoosePresenter) getPresenter()).V(symbolCurrencyEntity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(CharSequence charSequence, int i11, int i12, int i13) {
        if (charSequence == null || charSequence.toString().trim().length() <= 0) {
            if (!this.f46447g.isHidden()) {
                getSupportFragmentManager().q().q(this.f46447g).j();
            }
        } else if (this.f46447g.isHidden()) {
            getSupportFragmentManager().q().A(this.f46447g).j();
        }
        this.f46447g.rh(charSequence.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh(SymbolCurrencyEntity symbolCurrencyEntity, int i11) {
        ((CurrencyChoosePresenter) getPresenter()).V(symbolCurrencyEntity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(List list) {
        SearchFragment searchFragment = this.f46447g;
        if (searchFragment != null && searchFragment.isAdded()) {
            this.f46447g.qh(this.f46450j);
        }
    }

    public void F0() {
        LoadingLayout loadingLayout = this.f46445e;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(8);
        }
    }

    public final void Pg(Class cls, Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction q11 = supportFragmentManager.q();
        if (supportFragmentManager.B0() != null) {
            for (Fragment next : supportFragmentManager.B0()) {
                if (next != null) {
                    q11.q(next);
                }
            }
        }
        String name = cls.getName();
        Fragment instanceFragment = instanceFragment(cls.getName(), bundle, cls.getName());
        if (cls == SearchFragment.class) {
            SearchFragment searchFragment = (SearchFragment) instanceFragment;
            this.f46447g = searchFragment;
            searchFragment.th(new n3(this));
        }
        if (!instanceFragment.isAdded()) {
            q11.c(R.id.currency_choose_root, instanceFragment, name);
        }
        q11.q(instanceFragment).k();
    }

    /* renamed from: Qg */
    public CurrencyChoosePresenter createPresenter() {
        return new CurrencyChoosePresenter();
    }

    public void addEvent() {
        this.f46449i.setOnClickListener(new l3(this));
        this.f46445e.setOnRetryClickListener(new k3(this));
        this.f46451k.setOnItemContentClickListener(new p3(this));
        this.f46448h.setOnTextChangedListener(new m3(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R.layout.activity_symbol_choose;
    }

    public void initView() {
        this.f46442b = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46443c = this.viewFinder.b(R.id.choose_root);
        this.f46444d = (IndexPartLayout) this.viewFinder.b(R.id.currency_choose_list);
        this.f46445e = (LoadingLayout) this.viewFinder.b(R.id.currency_choose_loading);
        this.f46446f = (FrameLayout) this.viewFinder.b(R.id.currency_choose_root);
        this.f46448h = (ClearEditText) this.viewFinder.b(R.id.currency_search);
        this.f46449i = (TextView) this.viewFinder.b(R.id.currency_search_cancel);
        setToolBar(this.f46442b, "", false);
        this.f46444d.setLayoutManager(new LinearLayoutManager(this));
        this.f46444d.setCompareMode(1);
        this.f46444d.setOverlayStyle_Center();
        a aVar = new a(this);
        this.f46451k = aVar;
        this.f46444d.setAdapter(aVar);
        qh();
    }

    public void m0() {
        LoadingLayout loadingLayout = this.f46445e;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(0);
            this.f46445e.k();
        }
    }

    /* renamed from: oh */
    public CurrencyChoosePresenter.c getUI() {
        return this;
    }

    public void onResume() {
        super.onResume();
        ((CurrencyChoosePresenter) getPresenter()).X();
    }

    public final void qh() {
        Pg(SearchFragment.class, (Bundle) null);
        getSupportFragmentManager().q().q(this.f46447g).j();
    }

    public void showLoading() {
        LoadingLayout loadingLayout = this.f46445e;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(0);
            this.f46445e.p();
        }
    }

    public void wg(List<SymbolCurrencyEntity> list) {
        if (list != null && !list.isEmpty()) {
            this.f46450j.clear();
            this.f46450j.addAll(list);
            this.f46451k.setDatas(this.f46450j, new o3(this));
        }
    }
}

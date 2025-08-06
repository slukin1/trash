package com.hbg.lite.search.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.input.ClearEditText;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.base.LiteBaseActivity;
import com.hbg.lite.search.bean.LiteChooseCurrencyItem;
import com.hbg.lite.search.presenter.LiteCurrencyChoosePresenter;
import com.huobi.view.indexlist.IndexPartAdapter;
import com.huobi.view.indexlist.IndexPartLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mb.b;
import mb.c;
import mb.d;
import mb.e;
import mb.f;

public class LiteCurrencyChooseActivity extends LiteBaseActivity<LiteCurrencyChoosePresenter, LiteCurrencyChoosePresenter.b> implements LiteCurrencyChoosePresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f77446b;

    /* renamed from: c  reason: collision with root package name */
    public IndexPartLayout f77447c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f77448d;

    /* renamed from: e  reason: collision with root package name */
    public LiteSearchFragment f77449e;

    /* renamed from: f  reason: collision with root package name */
    public ClearEditText f77450f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f77451g;

    /* renamed from: h  reason: collision with root package name */
    public List<LiteChooseCurrencyItem> f77452h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public a f77453i;

    public class a extends IndexPartAdapter<LiteChooseCurrencyItem> {

        /* renamed from: a  reason: collision with root package name */
        public LayoutInflater f77454a;

        /* renamed from: com.hbg.lite.search.ui.LiteCurrencyChooseActivity$a$a  reason: collision with other inner class name */
        public class C0829a extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f77456a;

            public C0829a(View view) {
                super(view);
                this.f77456a = (TextView) view.findViewById(R$id.tv_name);
            }
        }

        public class b extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f77458a;

            public b(View view) {
                super(view);
                this.f77458a = (TextView) view.findViewById(R$id.tv_index);
            }
        }

        public a(Context context) {
            this.f77454a = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, LiteChooseCurrencyItem liteChooseCurrencyItem) {
            String str;
            TextView textView = ((C0829a) viewHolder).f77456a;
            if (liteChooseCurrencyItem.getName() == null) {
                str = "";
            } else {
                str = liteChooseCurrencyItem.getName().toUpperCase(Locale.US);
            }
            textView.setText(str);
        }

        public void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str) {
            ((b) viewHolder).f77458a.setText(str);
        }

        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
            return new C0829a(this.f77454a.inflate(R$layout.lite_item_currency_choose, viewGroup, false));
        }

        public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup) {
            return new b(this.f77454a.inflate(R$layout.item_lite_choose_currency_title, viewGroup, false));
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
    public /* synthetic */ void lambda$addEvent$3(View view) {
        ((LiteCurrencyChoosePresenter) getPresenter()).T();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qh(View view, int i11, int i12, LiteChooseCurrencyItem liteChooseCurrencyItem) {
        uh(liteChooseCurrencyItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rh(CharSequence charSequence, int i11, int i12, int i13) {
        if (charSequence == null || charSequence.toString().trim().length() <= 0) {
            if (!this.f77449e.isHidden()) {
                getSupportFragmentManager().q().q(this.f77449e).j();
            }
        } else if (this.f77449e.isHidden()) {
            getSupportFragmentManager().q().A(this.f77449e).j();
        }
        this.f77449e.rh(charSequence.toString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(LiteChooseCurrencyItem liteChooseCurrencyItem, int i11) {
        uh(liteChooseCurrencyItem);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void th(List list) {
        LiteSearchFragment liteSearchFragment = this.f77449e;
        if (liteSearchFragment != null && liteSearchFragment.isAdded()) {
            this.f77449e.qh(this.f77452h);
        }
    }

    public static void vh(Context context) {
        context.startActivity(new Intent(context, LiteCurrencyChooseActivity.class));
    }

    public void F0() {
        LoadingLayout loadingLayout = this.f77448d;
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
        if (cls == LiteSearchFragment.class) {
            LiteSearchFragment liteSearchFragment = (LiteSearchFragment) instanceFragment;
            this.f77449e = liteSearchFragment;
            liteSearchFragment.th(new d(this));
        }
        if (!instanceFragment.isAdded()) {
            q11.c(R$id.currency_choose_root, instanceFragment, name);
        }
        q11.q(instanceFragment).k();
    }

    /* renamed from: Qg */
    public LiteCurrencyChoosePresenter createPresenter() {
        return new LiteCurrencyChoosePresenter();
    }

    public void addEvent() {
        this.f77451g.setOnClickListener(new mb.a(this));
        this.f77453i.setOnItemContentClickListener(new f(this));
        this.f77450f.setOnTextChangedListener(new c(this));
        this.f77448d.setOnRetryClickListener(new b(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public int getContentView() {
        return R$layout.activity_lite_currency_choose;
    }

    public void ia(List<LiteChooseCurrencyItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f77452h.clear();
            this.f77452h.addAll(list);
            this.f77453i.setDatas(this.f77452h, new e(this));
        }
    }

    public void initView() {
        this.f77446b = (Toolbar) this.viewFinder.b(R$id.toolbar);
        this.f77447c = (IndexPartLayout) this.viewFinder.b(R$id.currency_choose_list);
        this.f77448d = (LoadingLayout) this.viewFinder.b(R$id.currency_choose_loading);
        this.f77450f = (ClearEditText) this.viewFinder.b(R$id.currency_search);
        this.f77451g = (TextView) this.viewFinder.b(R$id.currency_search_cancel);
        setToolBar(this.f77446b, "", false);
        this.f77447c.setLayoutManager(new LinearLayoutManager(this));
        this.f77447c.setCompareMode(1);
        this.f77447c.setOverlayStyle_Center();
        a aVar = new a(this);
        this.f77453i = aVar;
        this.f77447c.setAdapter(aVar);
        this.f77447c.setIsShowListSticky(false);
        this.f77447c.setStickyEnable(false);
        this.f77447c.setOverlayStyle_Center();
        ph();
    }

    public void m0() {
        LoadingLayout loadingLayout = this.f77448d;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(0);
            this.f77448d.k();
        }
    }

    /* renamed from: oh */
    public LiteCurrencyChoosePresenter.b getUI() {
        return this;
    }

    public final void ph() {
        Pg(LiteSearchFragment.class, (Bundle) null);
        getSupportFragmentManager().q().q(this.f77449e).j();
    }

    public void showLoading() {
        LoadingLayout loadingLayout = this.f77448d;
        if (loadingLayout != null) {
            loadingLayout.setVisibility(0);
            this.f77448d.p();
        }
    }

    public final void uh(LiteChooseCurrencyItem liteChooseCurrencyItem) {
    }
}

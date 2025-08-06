package com.huobi.account.ui;

import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import java.util.ArrayList;
import pro.huobi.R;
import qg.a;
import tg.f;

@Deprecated
public class KeepLoginTimeActivity extends EmptyMVPActivity implements a.C0582a {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<a> f41206b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41207c;

    public final void Xf() {
        ArrayList arrayList = new ArrayList();
        int b11 = f.b();
        arrayList.add(new a(4, b11, this.f41207c, this));
        arrayList.add(new a(8, b11, this.f41207c, this));
        arrayList.add(new a(12, b11, this.f41207c, this));
        arrayList.add(new a(24, b11, this.f41207c, this));
        this.f41206b.setData(arrayList);
    }

    public void addEvent() {
        super.addEvent();
    }

    public void afterInit() {
        this.f41207c = getIntent().getBooleanExtra("EXTRA_IS_GA_BIND", false);
        Xf();
    }

    public int getContentView() {
        return R.layout.activity_keep_login_time;
    }

    public void initView() {
        super.initView();
        this.f41206b = (EasyRecyclerView) this.viewFinder.b(R.id.id_keep_login_time_recyclerView);
    }

    public void xa(a aVar) {
        f.j(aVar.f());
        Xf();
    }
}

package com.hbg.module.huobi.im.group.ui;

import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.huobi.im.group.ui.adapter.ApplyUserAdapter;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import fd.c;
import ky.j;
import sd.a;
import v7.b;

@Route(path = "/im/applylist")
public final class JoinGroupAdminActivity extends BaseActivity<c> {

    /* renamed from: i  reason: collision with root package name */
    public int f20039i = 1;

    /* renamed from: j  reason: collision with root package name */
    public String f20040j = "";

    /* renamed from: k  reason: collision with root package name */
    public ApplyUserAdapter f20041k;

    public static final /* synthetic */ c zh(JoinGroupAdminActivity joinGroupAdminActivity) {
        return (c) joinGroupAdminActivity.Yf();
    }

    public final void Ch() {
        RequestExtKt.d(b.a().getApplyList(this.f20039i, 20, this.f20040j), new JoinGroupAdminActivity$getApplyList$1(this), new JoinGroupAdminActivity$getApplyList$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Dh */
    public c Og() {
        return c.K(getLayoutInflater());
    }

    public void P8(j jVar) {
        super.P8(jVar);
        Ch();
    }

    public void bf(j jVar) {
        super.bf(jVar);
        this.f20039i = 1;
        ((c) Yf()).E.g(true);
        Ch();
    }

    public void initView() {
        super.initView();
        Qg(NightHelper.e().g());
        ((c) Yf()).M(this);
        ((c) Yf()).E.j0(new SmartRefreshHeader(this));
        ((c) Yf()).E.h0(new SmartRefreshFooter(this));
        ((c) Yf()).E.e0(this);
        this.f20041k = new ApplyUserAdapter(this, this.f20040j);
        ((c) Yf()).F.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((c) Yf()).F.setAdapter(this.f20041k);
        if (!a.c(this.f20040j)) {
            Ch();
        }
    }

    public void oh() {
        String stringExtra;
        super.oh();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("groupId")) != null) {
            this.f20040j = stringExtra;
        }
    }
}

package com.hbg.module.content.ui.activity.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.z;
import com.hbg.module.content.adapter.h;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.utils.event.bean.Financial;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import com.hbg.module.libkt.utils.event.bean.GiftGroup;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lc.i1;
import we.c;

public final class GiftListFragment extends BaseFragment<i1> {

    /* renamed from: u  reason: collision with root package name */
    public static final a f18384u = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public String f18385p;

    /* renamed from: q  reason: collision with root package name */
    public Financial f18386q;

    /* renamed from: r  reason: collision with root package name */
    public List<GiftBean> f18387r;

    /* renamed from: s  reason: collision with root package name */
    public h f18388s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f18389t;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final GiftListFragment a(GiftGroup giftGroup) {
            GiftListFragment giftListFragment = new GiftListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("giftGroup", giftGroup);
            giftListFragment.setArguments(bundle);
            return giftListFragment;
        }
    }

    public static final class b implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f18390b;

        public b(l lVar) {
            this.f18390b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final f<?> getFunctionDelegate() {
            return this.f18390b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f18390b.invoke(obj);
        }
    }

    public void Ah() {
        ArrayList parcelableArrayList;
        GiftGroup giftGroup;
        super.Ah();
        Bundle arguments = getArguments();
        this.f18385p = arguments != null ? arguments.getString("groupId") : null;
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (giftGroup = (GiftGroup) arguments2.getParcelable("giftGroup")) == null)) {
            this.f18385p = String.valueOf(giftGroup.getGroupId());
            this.f18386q = giftGroup.getFinancial();
            this.f18387r = giftGroup.getGifts();
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (parcelableArrayList = arguments3.getParcelableArrayList("gifts")) != null) {
            this.f18387r = parcelableArrayList;
        }
    }

    public void Eh() {
        super.Eh();
        this.f18389t = false;
    }

    public void Fh() {
        super.Fh();
        String str = this.f18385p;
        if (str != null) {
            com.hbg.module.content.helper.live.f.f18246a.f(this.f18386q);
            c.F(str);
        }
        this.f18389t = true;
        h hVar = this.f18388s;
        if (hVar != null) {
            hVar.x(1);
        }
        h hVar2 = this.f18388s;
        if (hVar2 != null) {
            hVar2.notifyDataSetChanged();
        }
    }

    public final List<GiftBean> Th() {
        return this.f18387r;
    }

    /* renamed from: Uh */
    public i1 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return i1.K(layoutInflater, viewGroup, false);
    }

    public void initView() {
        ((i1) uh()).B.setLayoutManager(com.hbg.module.libkt.base.ext.b.k(getActivity(), 3));
        h hVar = new h(getActivity(), this.f18386q);
        this.f18388s = hVar;
        hVar.setHasStableIds(true);
        ((i1) uh()).B.setAdapter(this.f18388s);
        ((i1) uh()).B.addItemDecoration(com.hbg.module.libkt.base.ext.b.l(3, 10.0f));
        com.hbg.module.libkt.base.ext.b.f(((i1) uh()).B);
        ((i1) uh()).B.setHasFixedSize(true);
        h hVar2 = this.f18388s;
        if (hVar2 != null) {
            hVar2.a(0, this.f18387r);
        }
        c.d(this, new b(new GiftListFragment$initView$1(this)));
        c.j(this, new b(new GiftListFragment$initView$2(this)));
    }
}

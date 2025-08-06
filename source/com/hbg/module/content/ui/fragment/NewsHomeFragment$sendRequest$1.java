package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.hbg.core.bean.NewFlashCategory;
import com.hbg.module.content.ui.fragment.H5Fragment;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ui.BaseFragment;
import com.hbg.module.libkt.custom.indicator.TabData;
import d10.l;
import he.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class NewsHomeFragment$sendRequest$1 extends Lambda implements l<List<NewFlashCategory>, Unit> {
    public final /* synthetic */ a $adapter;
    public final /* synthetic */ NewsHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsHomeFragment$sendRequest$1(NewsHomeFragment newsHomeFragment, a aVar) {
        super(1);
        this.this$0 = newsHomeFragment;
        this.$adapter = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<NewFlashCategory>) (List) obj);
        return Unit.f56620a;
    }

    public final void invoke(List<NewFlashCategory> list) {
        Object obj;
        BaseFragment baseFragment;
        this.this$0.sh();
        NewsHomeFragment.Vh(this.this$0).I.setAdapter(this.$adapter);
        this.this$0.f18800r.clear();
        if (!b.w(list)) {
            this.this$0.f18799q.clear();
            NewsHomeFragment.Vh(this.this$0).D.setVisibility(0);
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                NewFlashCategory newFlashCategory = list.get(i11);
                ArrayList Uh = this.this$0.f18799q;
                if (this.this$0.f18801s == 1) {
                    NewsHomeFragment newsHomeFragment = this.this$0;
                    newsHomeFragment.f18804v = newsHomeFragment.f18804v == -1 ? -2 : i11;
                    baseFragment = NewsChildFragment.a.b(NewsChildFragment.H, newFlashCategory.categoryId, newFlashCategory.title, (String) null, this.this$0.f18804v, 4, (Object) null);
                    this.this$0.ei(baseFragment);
                } else if (newFlashCategory.ctype == 2) {
                    String str = newFlashCategory.url;
                    if (str != null && StringsKt__StringsJVMKt.M(str, "/", false, 2, (Object) null)) {
                        newFlashCategory.url = newFlashCategory.url.substring(1);
                    }
                    baseFragment = H5Fragment.a.b(H5Fragment.f18742s, newFlashCategory.url, false, 2, (Object) null);
                } else {
                    baseFragment = DeepNewsChildFragment.f18731x.a(newFlashCategory.categoryId);
                    this.this$0.ei(baseFragment);
                }
                Uh.add(baseFragment);
                this.this$0.f18800r.add(new TabData(newFlashCategory.title, 0, newFlashCategory.categoryId, 2, (r) null));
            }
        } else {
            ArrayList Uh2 = this.this$0.f18799q;
            if (this.this$0.f18801s == 1) {
                obj = NewsChildFragment.a.b(NewsChildFragment.H, -1, "7*24", (String) null, 0, 12, (Object) null);
            } else {
                obj = DeepNewsChildFragment.f18731x.a(-1);
            }
            Uh2.add(obj);
        }
        this.$adapter.a(this.this$0.f18799q);
        if (b.e(this.this$0.getActivity()) && this.this$0.f18800r.size() > 0) {
            NewsHomeFragment newsHomeFragment2 = this.this$0;
            newsHomeFragment2.fi(NewsHomeFragment.Vh(newsHomeFragment2).D);
            NewsHomeFragment.Vh(this.this$0).I.setOffscreenPageLimit(this.this$0.f18800r.size());
            if (this.this$0.f18803u != 0) {
                int size2 = this.this$0.f18800r.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size2) {
                        break;
                    } else if (((TabData) this.this$0.f18800r.get(i12)).getTabId() == this.this$0.f18803u) {
                        NewsHomeFragment.Vh(this.this$0).I.setCurrentItem(i12, false);
                        break;
                    } else {
                        i12++;
                    }
                }
            }
        }
        NewsHomeFragment.Vh(this.this$0).G.finishRefresh();
    }
}

package com.hbg.module.content.adapter;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import oc.a;

public final class NewsAdapter$showTransPop$1 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NewFlashInformation f17831a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsAdapter f17832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17833c;

    public NewsAdapter$showTransPop$1(NewFlashInformation newFlashInformation, NewsAdapter newsAdapter, int i11) {
        this.f17831a = newFlashInformation;
        this.f17832b = newsAdapter;
        this.f17833c = i11;
    }

    public void a() {
        a.C0131a.a(this);
    }

    public void b() {
        if (this.f17831a.getTrans()) {
            NewsAdapter.o(this.f17832b, this.f17831a, this.f17833c, false, 4, (Object) null);
        } else if (b.x(this.f17831a.getOldContent())) {
            RequestExtKt.d(v7.b.a().f0(String.valueOf(this.f17831a.getId()), 1), new NewsAdapter$showTransPop$1$transContent$1(this.f17831a, this.f17832b, this.f17833c), NewsAdapter$showTransPop$1$transContent$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        } else {
            this.f17832b.n(this.f17831a, this.f17833c, true);
        }
    }
}

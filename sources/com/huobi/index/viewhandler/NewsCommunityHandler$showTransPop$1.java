package com.huobi.index.viewhandler;

import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import com.huochat.community.widget.expandable.ExpandableTextView;
import oc.a;

public final class NewsCommunityHandler$showTransPop$1 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommunityFeedInfo.ListBean f74344a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsCommunityHandler f74345b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f74346c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f74347d;

    public NewsCommunityHandler$showTransPop$1(CommunityFeedInfo.ListBean listBean, NewsCommunityHandler newsCommunityHandler, TextView textView, ExpandableTextView expandableTextView) {
        this.f74344a = listBean;
        this.f74345b = newsCommunityHandler;
        this.f74346c = textView;
        this.f74347d = expandableTextView;
    }

    public void a() {
        a.C0131a.a(this);
    }

    public void b() {
        if (this.f74344a.isTrans()) {
            NewsCommunityHandler.x(this.f74345b, this.f74346c, this.f74347d, this.f74344a, false, 8, (Object) null);
        } else if (b.x(this.f74344a.getOldContent())) {
            RequestExtKt.d(v7.b.a().f0(String.valueOf(this.f74344a.getId()), 5), new NewsCommunityHandler$showTransPop$1$transContent$1(this.f74344a, this.f74346c, this.f74347d), NewsCommunityHandler$showTransPop$1$transContent$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        } else {
            this.f74345b.w(this.f74346c, this.f74347d, this.f74344a, true);
        }
    }
}

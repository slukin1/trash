package com.hbg.module.content.adapter;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;
import oc.a;

public final class CommentListAdapter$showTransPop$1 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CommentListAdapter f17813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommentInfo f17814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17815c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f17816d;

    public CommentListAdapter$showTransPop$1(CommentListAdapter commentListAdapter, CommentInfo commentInfo, int i11, Integer num) {
        this.f17813a = commentListAdapter;
        this.f17814b = commentInfo;
        this.f17815c = i11;
        this.f17816d = num;
    }

    public void a() {
        this.f17813a.w(this.f17814b.f70229id, this.f17815c, this.f17816d);
    }

    public void b() {
        CommentInfo commentInfo = this.f17814b;
        if (commentInfo.isTrans) {
            CommentListAdapter.G(this.f17813a, commentInfo, this.f17815c, false, 4, (Object) null);
        } else if (b.x(commentInfo.oldContent)) {
            RequestExtKt.d(v7.b.a().f0(this.f17814b.f70229id, 3), new CommentListAdapter$showTransPop$1$transContent$1(this.f17814b, this.f17813a, this.f17815c), CommentListAdapter$showTransPop$1$transContent$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        } else {
            this.f17813a.F(this.f17814b, this.f17815c, true);
        }
    }
}

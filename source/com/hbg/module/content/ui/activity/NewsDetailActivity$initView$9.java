package com.hbg.module.content.ui.activity;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.module.content.interfaces.NoDoubleClickListener;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.b;

public final class NewsDetailActivity$initView$9 extends NoDoubleClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsDetailActivity f18325b;

    public NewsDetailActivity$initView$9(NewsDetailActivity newsDetailActivity) {
        this.f18325b = newsDetailActivity;
    }

    public void onViewClick(View view) {
        NewFlashInformation Bh = this.f18325b.f18296k;
        if (Bh != null) {
            NewsDetailActivity newsDetailActivity = this.f18325b;
            if (Bh.getTrans()) {
                NewsDetailActivity.ai(newsDetailActivity, Bh, false, 2, (Object) null);
            } else if (b.x(Bh.getOldContent())) {
                RequestExtKt.d(v7.b.a().f0(String.valueOf(Bh.getId()), 1), new NewsDetailActivity$initView$9$onViewClick$1$1(Bh, newsDetailActivity), NewsDetailActivity$initView$9$onViewClick$1$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
            } else {
                newsDetailActivity.Zh(Bh, true);
            }
        }
    }
}

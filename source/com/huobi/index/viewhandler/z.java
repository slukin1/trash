package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexLive;

public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NewsLiveHandler f74502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexLive f74503c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HomeFeedInfoItem f74504d;

    public /* synthetic */ z(NewsLiveHandler newsLiveHandler, IndexLive indexLive, HomeFeedInfoItem homeFeedInfoItem) {
        this.f74502b = newsLiveHandler;
        this.f74503c = indexLive;
        this.f74504d = homeFeedInfoItem;
    }

    public final void onClick(View view) {
        NewsLiveHandler.d(this.f74502b, this.f74503c, this.f74504d, view);
    }
}

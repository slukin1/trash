package com.huobi.index.viewhandler;

import android.content.Context;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexDeep;
import com.huobi.utils.HomeSensorsHelper;
import d10.l;
import gs.g;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewDeepHandler$handleView$1$6 extends Lambda implements l<Void, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ HomeFeedInfoItem $data;
    public final /* synthetic */ IndexDeep $news;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewDeepHandler$handleView$1$6(IndexDeep indexDeep, HomeFeedInfoItem homeFeedInfoItem, Context context) {
        super(1);
        this.$news = indexDeep;
        this.$data = homeFeedInfoItem;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.f56620a;
    }

    public final void invoke(Void voidR) {
        g.g("app_recome_content_click", HomeSensorsHelper.d(this.$news.getId(), this.$data.f73152c, this.$news.getTitle(), "article", this.$data.f73165p, (String) null, 2));
        DynamicDetailActivity.a.b(DynamicDetailActivity.H, this.$news.getDynamicId(), this.$news.getId(), this.$context, false, 8, (Object) null);
    }
}

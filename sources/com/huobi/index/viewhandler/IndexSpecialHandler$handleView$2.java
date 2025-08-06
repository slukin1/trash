package com.huobi.index.viewhandler;

import android.content.Context;
import android.widget.TextView;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexSpecial;
import com.huobi.utils.HomeSensorsHelper;
import com.huobi.utils.v;
import d10.l;
import gs.g;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class IndexSpecialHandler$handleView$2 extends Lambda implements l<Void, Unit> {
    public final /* synthetic */ HomeFeedInfoItem $data;
    public final /* synthetic */ IndexSpecial $indexSpecial;
    public final /* synthetic */ TextView $tvTitle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndexSpecialHandler$handleView$2(TextView textView, IndexSpecial indexSpecial, HomeFeedInfoItem homeFeedInfoItem) {
        super(1);
        this.$tvTitle = textView;
        this.$indexSpecial = indexSpecial;
        this.$data = homeFeedInfoItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Void) obj);
        return Unit.f56620a;
    }

    public final void invoke(Void voidR) {
        Context context = this.$tvTitle.getContext();
        IndexSpecial indexSpecial = this.$indexSpecial;
        v.a(context, indexSpecial != null ? indexSpecial.skipUrl : null, "");
        IndexSpecial indexSpecial2 = this.$indexSpecial;
        if (indexSpecial2 != null) {
            HomeFeedInfoItem homeFeedInfoItem = this.$data;
            g.g("app_recome_content_click", HomeSensorsHelper.d((long) indexSpecial2.f73205id, homeFeedInfoItem.f73152c, indexSpecial2.title, "topic", homeFeedInfoItem.f73165p, (String) null, 14));
        }
    }
}

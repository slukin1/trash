package com.hbg.module.content.ui.activity.live;

import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.d;
import com.hbg.module.huobi.im.utils.MessageBusinessID;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import d10.a;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
import nc.c;
import we.b;

public final class FullScreenLiveActivity$initGiftManager$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ FullScreenLiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullScreenLiveActivity$initGiftManager$1(FullScreenLiveActivity fullScreenLiveActivity) {
        super(0);
        this.this$0 = fullScreenLiveActivity;
    }

    public final void invoke() {
        List<LiveSpeaker> list;
        LiveSpeaker liveSpeaker;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = l.a("state", Integer.valueOf(this.this$0.Oh()));
        LiveDetailBean Nh = this.this$0.Nh();
        pairArr[1] = l.a("liveid", Nh != null ? Nh.f70249id : null);
        pairArr[2] = l.a(VineCardUtils.PLAYER_CARD, 2);
        LiveDetailBean Nh2 = this.this$0.Nh();
        pairArr[3] = l.a("title", Nh2 != null ? Nh2.title : null);
        LiveDetailBean Nh3 = this.this$0.Nh();
        pairArr[4] = l.a("upid", (Nh3 == null || (list = Nh3.speakerList) == null || (liveSpeaker = list.get(0)) == null) ? null : liveSpeaker.showId);
        pairArr[5] = l.a("roundid", "");
        CusMsgGiftSend j11 = d.f19724a.j();
        pairArr[6] = l.a("lotterytype", j11 != null ? j11.getRule() : null);
        c.a("APP_LIVE_notice_luckdrawclk", MapsKt__MapsKt.j(pairArr));
        b.m("liveStatus", (Class) null, 2, (Object) null).g(MessageBusinessID.MSG_BUSINESS_ID_GIFT);
        this.this$0.finish();
    }
}

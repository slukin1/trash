package com.hbg.module.content.ui.activity.live;

import android.os.Looper;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.d;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import d10.a;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.l;
import nc.c;

public final class FullScreenLiveActivity$initGiftManager$2 extends Lambda implements a<Unit> {
    public final /* synthetic */ FullScreenLiveActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullScreenLiveActivity$initGiftManager$2(FullScreenLiveActivity fullScreenLiveActivity) {
        super(0);
        this.this$0 = fullScreenLiveActivity;
    }

    /* access modifiers changed from: private */
    public static final boolean invoke$lambda$0(FullScreenLiveActivity fullScreenLiveActivity) {
        List<LiveSpeaker> list;
        LiveSpeaker liveSpeaker;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = l.a("state", Integer.valueOf(fullScreenLiveActivity.Oh()));
        LiveDetailBean Nh = fullScreenLiveActivity.Nh();
        Integer num = null;
        pairArr[1] = l.a("liveid", Nh != null ? Nh.f70249id : null);
        Pair a11 = l.a(VineCardUtils.PLAYER_CARD, "title");
        LiveDetailBean Nh2 = fullScreenLiveActivity.Nh();
        pairArr[2] = l.a(a11, Nh2 != null ? Nh2.title : null);
        LiveDetailBean Nh3 = fullScreenLiveActivity.Nh();
        pairArr[3] = l.a("upid", (Nh3 == null || (list = Nh3.speakerList) == null || (liveSpeaker = list.get(0)) == null) ? null : liveSpeaker.showId);
        pairArr[4] = l.a("roundid", "");
        CusMsgGiftSend j11 = d.f19724a.j();
        if (j11 != null) {
            num = j11.getRule();
        }
        pairArr[5] = l.a("lotterytype", num);
        c.a("APP_LIVE_notice_luckdraw", MapsKt__MapsKt.j(pairArr));
        return false;
    }

    public final void invoke() {
        Looper.myQueue().addIdleHandler(new e(this.this$0));
    }
}

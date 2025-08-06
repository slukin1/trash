package pd;

import com.hbg.module.huobi.im.gift.LiveGiftShowType;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.hbg.module.huobi.im.manager.ActiveViewManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActiveViewManager f53016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RewardsAnim f53017c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LiveGiftShowType f53018d;

    public /* synthetic */ a(ActiveViewManager activeViewManager, RewardsAnim rewardsAnim, LiveGiftShowType liveGiftShowType) {
        this.f53016b = activeViewManager;
        this.f53017c = rewardsAnim;
        this.f53018d = liveGiftShowType;
    }

    public final void run() {
        this.f53016b.g(this.f53017c, this.f53018d);
    }
}

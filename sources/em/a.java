package em;

import com.huobi.invite.bean.InviteReturnRank;
import com.huobi.invite.presenter.InviteRankingListPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InviteRankingListPresenter f54348b;

    public /* synthetic */ a(InviteRankingListPresenter inviteRankingListPresenter) {
        this.f54348b = inviteRankingListPresenter;
    }

    public final void call(Object obj) {
        this.f54348b.S((InviteReturnRank) obj);
    }
}

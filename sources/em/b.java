package em;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.invite.presenter.InviteRecordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InviteRecordPresenter f54349b;

    public /* synthetic */ b(InviteRecordPresenter inviteRecordPresenter) {
        this.f54349b = inviteRecordPresenter;
    }

    public final void call(Object obj) {
        this.f54349b.f0((APIStatusErrorException) obj);
    }
}

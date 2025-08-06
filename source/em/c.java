package em;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.invite.presenter.InviteRecordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InviteRecordPresenter f54350b;

    public /* synthetic */ c(InviteRecordPresenter inviteRecordPresenter) {
        this.f54350b = inviteRecordPresenter;
    }

    public final void call(Object obj) {
        this.f54350b.a0((APIStatusErrorException) obj);
    }
}

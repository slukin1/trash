package lr;

import android.view.View;
import com.huobi.invite.bean.InviteSharePlatformListItem;
import com.huobi.share.fragment.BaseShareFragment;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseShareFragment.f f58055b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ InviteSharePlatformListItem f58056c;

    public /* synthetic */ f(BaseShareFragment.f fVar, InviteSharePlatformListItem inviteSharePlatformListItem) {
        this.f58055b = fVar;
        this.f58056c = inviteSharePlatformListItem;
    }

    public final void onClick(View view) {
        this.f58055b.e(this.f58056c, view);
    }
}

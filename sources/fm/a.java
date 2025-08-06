package fm;

import android.view.View;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.invite.viewhandler.InvitePosterItemHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InvitePosterListItem f54699b;

    public /* synthetic */ a(InvitePosterListItem invitePosterListItem) {
        this.f54699b = invitePosterListItem;
    }

    public final void onClick(View view) {
        InvitePosterItemHandler.d(this.f54699b, view);
    }
}

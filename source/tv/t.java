package tv;

import android.view.View;
import com.huochat.community.model.CommunityMenuListItem;
import com.huochat.community.viewholder.CommunityMenuListItemHandler;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityMenuListItem.Callback f60515b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityMenuListItem f60516c;

    public /* synthetic */ t(CommunityMenuListItem.Callback callback, CommunityMenuListItem communityMenuListItem) {
        this.f60515b = callback;
        this.f60516c = communityMenuListItem;
    }

    public final void onClick(View view) {
        CommunityMenuListItemHandler.handleView$lambda$1$lambda$0(this.f60515b, this.f60516c, view);
    }
}

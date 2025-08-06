package tv;

import android.view.View;
import com.huochat.community.viewholder.CommunityHolder;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60508b;

    public /* synthetic */ p(CommunityHolder communityHolder) {
        this.f60508b = communityHolder;
    }

    public final void onClick(View view) {
        CommunityHolder.refreshCommentList$lambda$31(this.f60508b, view);
    }
}

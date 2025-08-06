package tv;

import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60511b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60512c;

    public /* synthetic */ r(CommunityHolder communityHolder, CommunityItemBean communityItemBean) {
        this.f60511b = communityHolder;
        this.f60512c = communityItemBean;
    }

    public final void onClick(View view) {
        CommunityHolder.bindData$lambda$22(this.f60511b, this.f60512c, view);
    }
}

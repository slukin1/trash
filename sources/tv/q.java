package tv;

import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60509b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60510c;

    public /* synthetic */ q(CommunityHolder communityHolder, CommunityItemBean communityItemBean) {
        this.f60509b = communityHolder;
        this.f60510c = communityItemBean;
    }

    public final void onClick(View view) {
        CommunityHolder.bindData$lambda$15(this.f60509b, this.f60510c, view);
    }
}

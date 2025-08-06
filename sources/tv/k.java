package tv;

import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60503c;

    public /* synthetic */ k(CommunityItemBean communityItemBean, CommunityHolder communityHolder) {
        this.f60502b = communityItemBean;
        this.f60503c = communityHolder;
    }

    public final void onClick(View view) {
        CommunityHolder.bindData$lambda$12$lambda$11(this.f60502b, this.f60503c, view);
    }
}

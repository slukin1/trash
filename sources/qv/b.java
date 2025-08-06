package qv;

import android.view.View;
import com.huochat.community.adapter.CommunityFromListAdapter;
import com.huochat.community.model.CommunitySymbolBean;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunitySymbolBean f70494b;

    public /* synthetic */ b(CommunitySymbolBean communitySymbolBean) {
        this.f70494b = communitySymbolBean;
    }

    public final void onClick(View view) {
        CommunityFromListAdapter.MyViewHolder.bindData$lambda$0(this.f70494b, view);
    }
}

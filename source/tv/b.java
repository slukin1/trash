package tv;

import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60478b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f60479c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60480d;

    public /* synthetic */ b(CommunityHolder communityHolder, Ref$ObjectRef ref$ObjectRef, CommunityItemBean communityItemBean) {
        this.f60478b = communityHolder;
        this.f60479c = ref$ObjectRef;
        this.f60480d = communityItemBean;
    }

    public final void onClick(View view) {
        CommunityHolder.bindData$lambda$23(this.f60478b, this.f60479c, this.f60480d, view);
    }
}

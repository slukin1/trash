package tv;

import android.app.Activity;
import android.view.View;
import com.huochat.community.model.CommunityItemBean;
import com.huochat.community.viewholder.CommunityHolder;
import com.huochat.community.widget.expandable.ExpandableTextView;
import kotlin.jvm.internal.Ref$BooleanRef;

public final /* synthetic */ class g implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f60488b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpandableTextView f60489c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60490d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Activity f60491e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CommunityItemBean f60492f;

    public /* synthetic */ g(Ref$BooleanRef ref$BooleanRef, ExpandableTextView expandableTextView, CommunityHolder communityHolder, Activity activity, CommunityItemBean communityItemBean) {
        this.f60488b = ref$BooleanRef;
        this.f60489c = expandableTextView;
        this.f60490d = communityHolder;
        this.f60491e = activity;
        this.f60492f = communityItemBean;
    }

    public final boolean onLongClick(View view) {
        return CommunityHolder.bindData$lambda$8$lambda$4(this.f60488b, this.f60489c, this.f60490d, this.f60491e, this.f60492f, view);
    }
}

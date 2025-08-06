package tv;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.huochat.community.viewholder.CommunityHolder;
import kotlin.jvm.internal.Ref$ObjectRef;

public final /* synthetic */ class f implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f60484b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60485c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f60486d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f60487e;

    public /* synthetic */ f(TextView textView, CommunityHolder communityHolder, Activity activity, Ref$ObjectRef ref$ObjectRef) {
        this.f60484b = textView;
        this.f60485c = communityHolder;
        this.f60486d = activity;
        this.f60487e = ref$ObjectRef;
    }

    public final boolean onLongClick(View view) {
        return CommunityHolder.bindData$lambda$12$lambda$10(this.f60484b, this.f60485c, this.f60486d, this.f60487e, view);
    }
}

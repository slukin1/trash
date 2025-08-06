package tv;

import android.app.Activity;
import android.widget.ImageView;
import com.huochat.community.viewholder.CommunityHolder;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommunityHolder f60497b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f60498c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f60499d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f60500e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f60501f;

    public /* synthetic */ j(CommunityHolder communityHolder, ImageView imageView, Activity activity, String str, Ref$IntRef ref$IntRef) {
        this.f60497b = communityHolder;
        this.f60498c = imageView;
        this.f60499d = activity;
        this.f60500e = str;
        this.f60501f = ref$IntRef;
    }

    public final void run() {
        CommunityHolder.displayImage$lambda$37(this.f60497b, this.f60498c, this.f60499d, this.f60500e, this.f60501f);
    }
}

package ae;

import android.view.View;
import com.hbg.module.kline.bean.SocialMediaItem;
import com.hbg.module.kline.handler.SocialMediaHandler;
import v9.c;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f3532b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SocialMediaItem f3533c;

    public /* synthetic */ b(c cVar, SocialMediaItem socialMediaItem) {
        this.f3532b = cVar;
        this.f3533c = socialMediaItem;
    }

    public final void onClick(View view) {
        SocialMediaHandler.d(this.f3532b, this.f3533c, view);
    }
}

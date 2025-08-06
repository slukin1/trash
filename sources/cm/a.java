package cm;

import android.view.View;
import com.huobi.invite.bean.SharePlatformHandler;
import com.huobi.invite.bean.SharePlatformItem;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharePlatformItem f13112b;

    public /* synthetic */ a(SharePlatformItem sharePlatformItem) {
        this.f13112b = sharePlatformItem;
    }

    public final void onClick(View view) {
        SharePlatformHandler.d(this.f13112b, view);
    }
}

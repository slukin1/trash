package xr;

import android.content.Context;
import android.graphics.Bitmap;
import c6.b;
import com.huobi.social.share.HBShareHelper;

public final /* synthetic */ class d implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f61697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61698c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HBShareHelper.HbPlatform f61699d;

    public /* synthetic */ d(i iVar, Context context, HBShareHelper.HbPlatform hbPlatform) {
        this.f61697b = iVar;
        this.f61698c = context;
        this.f61699d = hbPlatform;
    }

    public final void onCallback(Object obj) {
        this.f61697b.s(this.f61698c, this.f61699d, (Bitmap) obj);
    }
}

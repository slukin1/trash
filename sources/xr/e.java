package xr;

import android.content.Context;
import android.graphics.Bitmap;
import c6.b;
import com.huobi.social.share.HBShareHelper;

public final /* synthetic */ class e implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f61700b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61701c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HBShareHelper.HbPlatform f61702d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bitmap f61703e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f61704f;

    public /* synthetic */ e(i iVar, Context context, HBShareHelper.HbPlatform hbPlatform, Bitmap bitmap, String str) {
        this.f61700b = iVar;
        this.f61701c = context;
        this.f61702d = hbPlatform;
        this.f61703e = bitmap;
        this.f61704f = str;
    }

    public final void onCallback(Object obj) {
        this.f61700b.t(this.f61701c, this.f61702d, this.f61703e, this.f61704f, (Bitmap) obj);
    }
}

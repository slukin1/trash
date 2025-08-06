package xr;

import android.content.Context;
import android.graphics.Bitmap;
import c6.b;
import com.huobi.social.share.HBShareHelper;

public final /* synthetic */ class f implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f61705b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f61706c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HBShareHelper.HbPlatform f61707d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f61708e;

    public /* synthetic */ f(i iVar, Context context, HBShareHelper.HbPlatform hbPlatform, String str) {
        this.f61705b = iVar;
        this.f61706c = context;
        this.f61707d = hbPlatform;
        this.f61708e = str;
    }

    public final void onCallback(Object obj) {
        this.f61705b.u(this.f61706c, this.f61707d, this.f61708e, (Bitmap) obj);
    }
}

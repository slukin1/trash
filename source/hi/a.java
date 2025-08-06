package hi;

import com.huobi.asset.AssetAccountType;
import com.huobi.asset2.page.Asset2Activity;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Asset2Activity f54940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetAccountType f54941c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54942d;

    public /* synthetic */ a(Asset2Activity asset2Activity, AssetAccountType assetAccountType, String str) {
        this.f54940b = asset2Activity;
        this.f54941c = assetAccountType;
        this.f54942d = str;
    }

    public final void call(Object obj) {
        this.f54940b.gg(this.f54941c, this.f54942d, (Boolean) obj);
    }
}

package rk;

import androidx.fragment.app.FragmentActivity;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25721b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25722c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25723d;

    public /* synthetic */ e(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25721b = assetModuleCallbackImp;
        this.f25722c = fragmentActivity;
        this.f25723d = str;
    }

    public final void call(Object obj) {
        this.f25721b.A1(this.f25722c, this.f25723d, (Throwable) obj);
    }
}

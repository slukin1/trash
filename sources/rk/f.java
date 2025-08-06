package rk;

import androidx.fragment.app.FragmentActivity;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25724b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25725c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25726d;

    public /* synthetic */ f(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25724b = assetModuleCallbackImp;
        this.f25725c = fragmentActivity;
        this.f25726d = str;
    }

    public final void call(Object obj) {
        this.f25724b.E1(this.f25725c, this.f25726d, (Throwable) obj);
    }
}

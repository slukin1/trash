package rk;

import androidx.fragment.app.FragmentActivity;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25718b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25719c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25720d;

    public /* synthetic */ d(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25718b = assetModuleCallbackImp;
        this.f25719c = fragmentActivity;
        this.f25720d = str;
    }

    public final void call(Object obj) {
        this.f25718b.C1(this.f25719c, this.f25720d, (Boolean) obj);
    }
}

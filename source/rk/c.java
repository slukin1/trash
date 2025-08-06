package rk;

import androidx.fragment.app.FragmentActivity;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25717d;

    public /* synthetic */ c(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25715b = assetModuleCallbackImp;
        this.f25716c = fragmentActivity;
        this.f25717d = str;
    }

    public final void call(Object obj) {
        this.f25715b.y1(this.f25716c, this.f25717d, (Boolean) obj);
    }
}

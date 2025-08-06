package rk;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25713c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25714d;

    public /* synthetic */ b(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25712b = assetModuleCallbackImp;
        this.f25713c = fragmentActivity;
        this.f25714d = str;
    }

    public final void call(Object obj) {
        this.f25712b.D1(this.f25713c, this.f25714d, (APIStatusErrorException) obj);
    }
}

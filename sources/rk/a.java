package rk;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.finance.AssetModuleCallbackImp;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetModuleCallbackImp f25709b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f25710c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25711d;

    public /* synthetic */ a(AssetModuleCallbackImp assetModuleCallbackImp, FragmentActivity fragmentActivity, String str) {
        this.f25709b = assetModuleCallbackImp;
        this.f25710c = fragmentActivity;
        this.f25711d = str;
    }

    public final void call(Object obj) {
        this.f25709b.z1(this.f25710c, this.f25711d, (APIStatusErrorException) obj);
    }
}

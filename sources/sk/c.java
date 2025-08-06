package sk;

import c6.b;
import com.huobi.finance.account.GridAssetAccount;
import vk.o;

public final /* synthetic */ class c implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridAssetAccount f66623b;

    public /* synthetic */ c(GridAssetAccount gridAssetAccount) {
        this.f66623b = gridAssetAccount;
    }

    public final void onCallback(Object obj) {
        this.f66623b.k((o) obj);
    }
}

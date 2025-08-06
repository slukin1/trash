package com.huobi.asset.feature.account.future;

import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.future.subtype.AssetDerivativesFutureFragment;
import com.huobi.asset.feature.account.future.subtype.AssetLinearSwapFutureFragment;
import com.huobi.asset.feature.account.future.subtype.AssetSwapFutureFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import java.util.ArrayList;
import java.util.List;

public class AssetFutureContainerFragment extends AssetSubTypesContainerFragment {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42241a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huobi.asset.feature.summary.AssetSummaryAccountType[] r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42241a = r0
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.DELIVERY_CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42241a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42241a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset.feature.account.future.AssetFutureContainerFragment.a.<clinit>():void");
        }
    }

    public List<Fragment> Oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AssetLinearSwapFutureFragment(this));
        arrayList.add(new AssetDerivativesFutureFragment(this));
        arrayList.add(new AssetSwapFutureFragment(this));
        return arrayList;
    }

    public int Ph(AssetSummaryAccountType assetSummaryAccountType) {
        int i11 = a.f42241a[assetSummaryAccountType.ordinal()];
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (i11 != 2) {
                return i11 != 3 ? -1 : 0;
            }
        }
        return i12;
    }

    public List<String> Rh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_balance_contract_linear_swap_title));
        arrayList.add(getResources().getString(R$string.n_balance_contract_contract_title));
        arrayList.add(getResources().getString(R$string.n_balance_contract_swap_title));
        return arrayList;
    }
}

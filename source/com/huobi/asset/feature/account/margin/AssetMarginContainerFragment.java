package com.huobi.asset.feature.account.margin;

import androidx.fragment.app.Fragment;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.margin.subtype.AssetCrossMarginFragment;
import com.huobi.asset.feature.account.margin.subtype.AssetIsolateMarginFragment;
import com.huobi.asset.feature.base.AssetSubTypesContainerFragment;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import java.util.ArrayList;
import java.util.List;

public class AssetMarginContainerFragment extends AssetSubTypesContainerFragment {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42260a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.huobi.asset.feature.summary.AssetSummaryAccountType[] r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42260a = r0
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SUPER_MARGIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42260a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SINGLE_MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset.feature.account.margin.AssetMarginContainerFragment.a.<clinit>():void");
        }
    }

    public List<Fragment> Oh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AssetCrossMarginFragment(this));
        arrayList.add(new AssetIsolateMarginFragment(this));
        return arrayList;
    }

    public int Ph(AssetSummaryAccountType assetSummaryAccountType) {
        int i11 = a.f42260a[assetSummaryAccountType.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? -1 : 1;
        }
        return 0;
    }

    public List<String> Rh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.balance_super_margin_title));
        arrayList.add(getResources().getString(R$string.balance_margin_title));
        return arrayList;
    }
}

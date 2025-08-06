package com.huobi.asset.feature.account.mortgage;

import android.util.Pair;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.PledgeAssetContent;
import com.hbg.lib.network.hbg.core.bean.PledgeBalance;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.mortgage.subtype.AssetMortgageBorrowedSubFragment;
import com.huobi.asset.feature.account.mortgage.subtype.AssetMortgageSubFragment;
import com.huobi.asset.feature.base.AssetBaseHeaderToSubTypeFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kh.c;
import kh.d;
import kh.e;
import rx.Observable;
import v7.b;

public class AssetMortgageFragment extends AssetBaseHeaderToSubTypeFragment implements lh.a {

    /* renamed from: o  reason: collision with root package name */
    public AssetMortgageSubFragment f42261o;

    /* renamed from: p  reason: collision with root package name */
    public AssetMortgageBorrowedSubFragment f42262p;

    /* renamed from: q  reason: collision with root package name */
    public PledgeAssetContent f42263q;

    public class a extends EasySubscriber<Pair<PledgeAssetContent, PledgeBalance>> {
        public a() {
        }

        /* renamed from: e */
        public void onNext(Pair<PledgeAssetContent, PledgeBalance> pair) {
            super.onNext(pair);
            PledgeBalance pledgeBalance = (PledgeBalance) pair.second;
            List<PledgeBalance.CurrencyBalance> pledging = pledgeBalance.getPledging();
            List<PledgeBalance.CurrencyBalance> loaning = pledgeBalance.getLoaning();
            Collections.sort(pledging, d.f56570b);
            Collections.sort(loaning, e.f56571b);
            AssetMortgageFragment.this.f42261o.Gh(pledging, 0);
            AssetMortgageFragment.this.f42262p.Gh(loaning, 0);
            PledgeAssetContent unused = AssetMortgageFragment.this.f42263q = (PledgeAssetContent) pair.first;
            AssetMortgageFragment assetMortgageFragment = AssetMortgageFragment.this;
            assetMortgageFragment.ai(assetMortgageFragment.f42263q);
            AssetMortgageFragment.this.Kh();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            AssetMortgageFragment.this.f42261o.Gh((List<PledgeBalance.CurrencyBalance>) null, 2);
            AssetMortgageFragment.this.f42262p.Gh((List<PledgeBalance.CurrencyBalance>) null, 2);
            AssetMortgageFragment.this.Kh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            AssetMortgageFragment.this.f42261o.Gh((List<PledgeBalance.CurrencyBalance>) null, 2);
            AssetMortgageFragment.this.f42262p.Gh((List<PledgeBalance.CurrencyBalance>) null, 2);
            AssetMortgageFragment.this.Kh();
        }
    }

    public String Gh() {
        return "app_assets_collateral_account_view";
    }

    public void Ih(boolean z11) {
        super.Ih(z11);
        Zh(z11);
        View view = this.f42301n;
        if (view instanceof AssetMortgageHeaderView) {
            ((AssetMortgageHeaderView) view).i(z11, false);
        }
    }

    public List<Fragment> Lh() {
        Yh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f42262p);
        arrayList.add(this.f42261o);
        return arrayList;
    }

    public View Mh() {
        AssetMortgageHeaderView assetMortgageHeaderView = new AssetMortgageHeaderView(getContext());
        assetMortgageHeaderView.setCallback(new kh.a(this));
        return assetMortgageHeaderView;
    }

    public List<String> Nh() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_asset_mortgage_can_borrow_currency));
        arrayList.add(getResources().getString(R$string.n_asset_mortgage_currency));
        return arrayList;
    }

    public void Oh(View view) {
    }

    public void Qh() {
        Observable.zip(b.a().L0().b(), b.a().getPledgeBalanceList().b(), c.f56569b).compose(RxJavaHelper.t(zh())).subscribe(new a());
    }

    /* renamed from: Xh */
    public void Zh(boolean z11) {
        AssetMortgageSubFragment assetMortgageSubFragment = this.f42261o;
        if (assetMortgageSubFragment != null && this.f42262p != null) {
            assetMortgageSubFragment.Hh();
            this.f42262p.Hh();
        }
    }

    public void Yh() {
        if (this.f42261o == null) {
            AssetMortgageSubFragment assetMortgageSubFragment = new AssetMortgageSubFragment();
            this.f42261o = assetMortgageSubFragment;
            assetMortgageSubFragment.Ih(new kh.b(this));
        }
        if (this.f42262p == null) {
            AssetMortgageBorrowedSubFragment assetMortgageBorrowedSubFragment = new AssetMortgageBorrowedSubFragment();
            this.f42262p = assetMortgageBorrowedSubFragment;
            assetMortgageBorrowedSubFragment.Ih(new kh.b(this));
        }
    }

    public void ai(PledgeAssetContent pledgeAssetContent) {
        View view = this.f42301n;
        if (view instanceof AssetMortgageHeaderView) {
            ((AssetMortgageHeaderView) view).g(pledgeAssetContent);
        }
    }

    public void callback() {
        Qh();
    }
}

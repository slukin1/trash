package kl;

import android.view.View;
import com.huobi.guide.bean.ContractGuideInfo;
import com.huobi.guide.ui.ContractGuideContentFragment;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractGuideContentFragment f56585b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContractGuideInfo f56586c;

    public /* synthetic */ a(ContractGuideContentFragment contractGuideContentFragment, ContractGuideInfo contractGuideInfo) {
        this.f56585b = contractGuideContentFragment;
        this.f56586c = contractGuideInfo;
    }

    public final void onClick(View view) {
        this.f56585b.Fh(this.f56586c, view);
    }
}

package um;

import android.view.View;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationActivity f60838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f60839c;

    public /* synthetic */ j(KycProBaseInformationActivity kycProBaseInformationActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f60838b = kycProBaseInformationActivity;
        this.f60839c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f60838b.Qh(this.f60839c, view);
    }
}

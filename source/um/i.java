package um;

import android.view.View;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationActivity f60836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f60837c;

    public /* synthetic */ i(KycProBaseInformationActivity kycProBaseInformationActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f60836b = kycProBaseInformationActivity;
        this.f60837c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f60836b.Ph(this.f60837c, view);
    }
}

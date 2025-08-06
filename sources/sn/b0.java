package sn;

import android.app.Activity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.huobi.login.utils.VerifyHelper;

public final /* synthetic */ class b0 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f70156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f70157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerifyHelper.c f70158c;

    public /* synthetic */ b0(Activity activity, String str, VerifyHelper.c cVar) {
        this.f70156a = activity;
        this.f70157b = str;
        this.f70158c = cVar;
    }

    public final void onSuccess(Object obj) {
        VerifyHelper.t(this.f70156a, this.f70157b, this.f70158c, (RecaptchaTasksClient) obj);
    }
}

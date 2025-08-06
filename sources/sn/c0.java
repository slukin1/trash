package sn;

import com.google.android.gms.tasks.OnSuccessListener;
import com.huobi.login.utils.VerifyHelper;

public final /* synthetic */ class c0 implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f70159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerifyHelper.c f70160b;

    public /* synthetic */ c0(String str, VerifyHelper.c cVar) {
        this.f70159a = str;
        this.f70160b = cVar;
    }

    public final void onSuccess(Object obj) {
        VerifyHelper.r(this.f70159a, this.f70160b, (String) obj);
    }
}

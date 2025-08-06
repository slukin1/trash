package sn;

import com.google.android.gms.tasks.OnFailureListener;
import com.huobi.login.utils.VerifyHelper;

public final /* synthetic */ class z implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerifyHelper.c f70188a;

    public /* synthetic */ z(VerifyHelper.c cVar) {
        this.f70188a = cVar;
    }

    public final void onFailure(Exception exc) {
        this.f70188a.onFailure((String) null);
    }
}

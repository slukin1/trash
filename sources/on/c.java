package on;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.hbg.lib.core.util.ChannelUtils;
import com.huobi.login.presenter.LoginPresenter;
import com.huobi.login.usercenter.data.source.bean.ThirdData;
import i6.k;
import pro.huobi.R;

public class c implements d<Task<GoogleSignInAccount>> {

    /* renamed from: a  reason: collision with root package name */
    public String f76407a = "Third login GoogleLogin";

    /* renamed from: b  reason: collision with root package name */
    public Activity f76408b;

    /* renamed from: c  reason: collision with root package name */
    public f f76409c;

    /* renamed from: d  reason: collision with root package name */
    public Intent f76410d;

    /* renamed from: e  reason: collision with root package name */
    public GoogleSignInAccount f76411e;

    /* renamed from: f  reason: collision with root package name */
    public int f76412f = 0;

    public c(Activity activity, f fVar) {
        String str;
        k.o("Third login GoogleLogin", "GoogleLogin init: ");
        this.f76408b = activity;
        this.f76409c = fVar;
        if (ChannelUtils.d()) {
            str = activity.getString(R.string.google_server_client_id);
        } else {
            str = activity.getString(R.string.server_client_id);
        }
        GoogleSignInClient client = GoogleSignIn.getClient(activity, new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(str).requestEmail().build());
        client.signOut();
        this.f76411e = GoogleSignIn.getLastSignedInAccount(activity);
        this.f76410d = client.getSignInIntent();
    }

    public final void a(GoogleSignInAccount googleSignInAccount) {
        ThirdData thirdData = new ThirdData();
        thirdData.f75671a = LoginPresenter.f75469u;
        thirdData.f75672b = (googleSignInAccount.getIdToken() == null || googleSignInAccount.getIdToken().isEmpty()) ? googleSignInAccount.getId() : googleSignInAccount.getIdToken();
        thirdData.f75675e = googleSignInAccount.getEmail();
        if (ChannelUtils.d()) {
            thirdData.f75673c = this.f76408b.getString(R.string.google_server_client_id);
        } else {
            thirdData.f75673c = this.f76408b.getString(R.string.server_client_id);
        }
        String str = this.f76407a;
        k.o(str, "initAccountData: " + thirdData.toString());
        this.f76409c.x(thirdData);
    }

    public void b(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            if (result != null) {
                String str = this.f76407a;
                k.o(str, "GoogleLogin account" + result.zac());
                a(result);
                return;
            }
            this.f76409c.onError((Exception) null);
        } catch (ApiException e11) {
            String str2 = this.f76407a;
            k.s(str2, "signInResult:failed code=" + e11.getStatusCode() + " message: " + e11.getMessage());
            this.f76409c.onError(e11);
        }
    }

    public void login() {
        k.o(this.f76407a, "GoogleLogin login");
        if (this.f76408b != null && this.f76410d != null) {
            GoogleSignInAccount googleSignInAccount = this.f76411e;
            if (googleSignInAccount == null) {
                int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.f76408b);
                String str = this.f76407a;
                k.o(str, "GoogleLogin login respCode= " + isGooglePlayServicesAvailable);
                if (isGooglePlayServicesAvailable != 0) {
                    Activity activity = this.f76408b;
                    Toast.makeText(activity, activity.getString(R.string.third_login_device_no_support_google), 0).show();
                    return;
                }
                this.f76412f = 1;
                this.f76408b.startActivityForResult(this.f76410d, 10001);
                return;
            }
            a(googleSignInAccount);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        int i13;
        if (i11 == 10001 && (i13 = this.f76412f) == 1) {
            this.f76412f = i13 - 1;
            String bundle = (intent == null || intent.getExtras() == null) ? "" : intent.getExtras().toString();
            String str = this.f76407a;
            k.o(str, "requestCode: " + i11 + " resultCode: " + i12 + " data: " + bundle);
            b(GoogleSignIn.getSignedInAccountFromIntent(intent));
        }
    }
}

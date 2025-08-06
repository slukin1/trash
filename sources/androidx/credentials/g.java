package androidx.credentials;

import android.app.Activity;
import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.r;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static final a f8808b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f8809a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final g a(Context context) {
            return new g(context, (r) null);
        }
    }

    public g(Context context) {
        this.f8809a = context;
    }

    public /* synthetic */ g(Context context, r rVar) {
        this(context);
    }

    public static final g a(Context context) {
        return f8808b.a(context);
    }

    public final void b(a aVar, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<b, CreateCredentialException> hVar) {
        j b11 = CredentialProviderFactory.f8747a.b(this.f8809a);
        if (b11 == null) {
            hVar.a(new CreateCredentialProviderConfigurationException("createCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            b11.onCreateCredential(aVar, activity, cancellationSignal, executor, hVar);
        }
    }

    public final void c(GetCredentialRequest getCredentialRequest, Activity activity, CancellationSignal cancellationSignal, Executor executor, h<l, GetCredentialException> hVar) {
        j b11 = CredentialProviderFactory.f8747a.b(this.f8809a);
        if (b11 == null) {
            hVar.a(new GetCredentialProviderConfigurationException("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        } else {
            b11.onGetCredential(getCredentialRequest, activity, cancellationSignal, executor, hVar);
        }
    }
}

package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p041authapi.zbao;
import com.google.android.gms.internal.p041authapi.zbay;

public final class Identity {
    private Identity() {
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbao((Activity) Preconditions.checkNotNull(activity), new zbc());
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zbay((Activity) Preconditions.checkNotNull(activity), new zbp());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbao((Context) Preconditions.checkNotNull(context), new zbc());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zbay((Context) Preconditions.checkNotNull(context), new zbp());
    }
}

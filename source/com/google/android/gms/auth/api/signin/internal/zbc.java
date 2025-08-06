package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import r1.a;

public final class zbc extends a implements SignInConnectionListener {
    private final Semaphore zba = new Semaphore(0);
    private final Set zbb;

    public zbc(Context context, Set set) {
        super(context);
        this.zbb = set;
    }

    public final /* bridge */ /* synthetic */ Object loadInBackground() {
        int i11 = 0;
        for (GoogleApiClient maybeSignIn : this.zbb) {
            if (maybeSignIn.maybeSignIn(this)) {
                i11++;
            }
        }
        try {
            this.zba.tryAcquire(i11, 5, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e11) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e11);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    public final void onComplete() {
        this.zba.release();
    }

    public final void onStartLoading() {
        this.zba.drainPermits();
        forceLoad();
    }
}

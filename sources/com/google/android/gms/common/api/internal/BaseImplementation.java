package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class BaseImplementation {

    @KeepForSdk
    public interface ResultHolder<R> {
        @KeepForSdk
        void setFailedResult(Status status);

        @KeepForSdk
        void setResult(R r11);
    }

    @KeepForSdk
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        @KeepForSdk
        private final Api<?> mApi;
        @KeepForSdk
        private final Api.AnyClientKey<A> mClientKey;

        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(Api.AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            this.mClientKey = (Api.AnyClientKey) Preconditions.checkNotNull(anyClientKey);
            this.mApi = null;
        }

        @KeepForSdk
        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        @KeepForSdk
        public abstract void doExecute(A a11) throws RemoteException;

        @KeepForSdk
        public final Api<?> getApi() {
            return this.mApi;
        }

        @KeepForSdk
        public final Api.AnyClientKey<A> getClientKey() {
            return this.mClientKey;
        }

        @KeepForSdk
        public void onSetFailedResult(R r11) {
        }

        @KeepForSdk
        public final void run(A a11) throws DeadObjectException {
            try {
                doExecute(a11);
            } catch (DeadObjectException e11) {
                setFailedResult((RemoteException) e11);
                throw e11;
            } catch (RemoteException e12) {
                setFailedResult(e12);
            }
        }

        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }

        @KeepForSdk
        public ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.checkNotNull(api, "Api must not be null");
            this.mClientKey = api.zab();
            this.mApi = api;
        }

        @KeepForSdk
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            Result createFailedResult = createFailedResult(status);
            setResult(createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        @KeepForSdk
        public ApiMethodImpl(BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.mClientKey = new Api.AnyClientKey<>();
            this.mApi = null;
        }
    }
}

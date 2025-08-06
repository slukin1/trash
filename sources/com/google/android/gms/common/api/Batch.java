package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends BasePendingResult<BatchResult> {
    /* access modifiers changed from: private */
    public int zae;
    /* access modifiers changed from: private */
    public boolean zaf;
    /* access modifiers changed from: private */
    public boolean zag;
    /* access modifiers changed from: private */
    public final PendingResult<?>[] zah;
    /* access modifiers changed from: private */
    public final Object zai = new Object();

    public static final class Builder {
        private List<PendingResult<?>> zaa = new ArrayList();
        private GoogleApiClient zab;

        public Builder(GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zaa.size());
            this.zaa.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zaa, this.zab, (zac) null);
        }
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zac zac) {
        super(googleApiClient);
        int size = list.size();
        this.zae = size;
        PendingResult<?>[] pendingResultArr = new PendingResult[size];
        this.zah = pendingResultArr;
        if (!list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                PendingResult<?> pendingResult = (PendingResult) list.get(i11);
                this.zah[i11] = pendingResult;
                pendingResult.addStatusListener(new zab(this));
            }
            return;
        }
        setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.zah) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }
}

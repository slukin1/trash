package com.zopim.android.sdk.api;

import android.os.AsyncTask;
import android.util.Pair;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.HttpRequest;
import java.io.File;
import java.net.URL;

final class FileUploader extends AsyncTask<Pair<File, URL>, Integer, Void> {
    private static final String LOG_TAG = "FileUploader";
    /* access modifiers changed from: private */
    public ErrorResponse mError;
    public HttpRequest.ProgressListener mProgressListener;
    public RegisteredCallback<Void> mRequestListener;
    /* access modifiers changed from: private */
    public boolean mSuccess;

    public void setProgressListener(HttpRequest.ProgressListener progressListener) {
        this.mProgressListener = progressListener;
    }

    public void setRequestListener(RegisteredCallback<Void> registeredCallback) {
        this.mRequestListener = registeredCallback;
    }

    public Void doInBackground(Pair<File, URL>... pairArr) {
        if (pairArr == null || pairArr.length == 0) {
            Logger.l(LOG_TAG, "File - URL pair validation failed. Will not start file upload.", new Object[0]);
            return null;
        }
        MonitoredUploadHttpRequest monitoredUploadHttpRequest = new MonitoredUploadHttpRequest();
        monitoredUploadHttpRequest.setRequestListener(new RegisteredCallback<Void>() {
            public void onError(ErrorResponse errorResponse) {
                Logger.d(FileUploader.LOG_TAG, "Error occurred. Reason: " + errorResponse, new Object[0]);
                ErrorResponse unused = FileUploader.this.mError = errorResponse;
            }

            public void onSuccess(Void voidR) {
                boolean unused = FileUploader.this.mSuccess = true;
            }
        });
        monitoredUploadHttpRequest.setProgressListener(new HttpRequest.ProgressListener() {
            public int currentProgress = 0;

            public void onProgressUpdate(int i11) {
                if (i11 > this.currentProgress) {
                    this.currentProgress = i11;
                    FileUploader.this.publishProgress(new Integer[]{Integer.valueOf(i11)});
                }
            }
        });
        monitoredUploadHttpRequest.upload((File) pairArr[0].first, (URL) pairArr[0].second);
        return null;
    }

    public void onPostExecute(Void voidR) {
        super.onPostExecute(voidR);
        RegisteredCallback<Void> registeredCallback = this.mRequestListener;
        if (registeredCallback != null) {
            ErrorResponse errorResponse = this.mError;
            if (errorResponse != null) {
                registeredCallback.onErrorInternal(errorResponse);
            } else if (this.mSuccess) {
                registeredCallback.onSuccessInternal(null);
            }
        }
    }

    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        HttpRequest.ProgressListener progressListener = this.mProgressListener;
        if (progressListener != null) {
            progressListener.onProgressUpdate(numArr[0].intValue());
        }
    }
}

package com.zopim.android.sdk.api;

import android.os.AsyncTask;
import android.util.Pair;
import com.zendesk.logger.Logger;
import java.io.File;
import java.net.URL;

final class FileDownloader extends AsyncTask<Pair<URL, File>, Void, File> {
    private static final String LOG_TAG = "FileDownloader";
    /* access modifiers changed from: private */
    public File mDownloadedFile;
    /* access modifiers changed from: private */
    public ErrorResponse mError;
    public RegisteredCallback<File> mRegisteredCallback;

    public void setRequestListener(RegisteredCallback<File> registeredCallback) {
        this.mRegisteredCallback = registeredCallback;
    }

    public File doInBackground(Pair<URL, File>... pairArr) {
        if (pairArr == null || pairArr.length == 0) {
            Logger.l(LOG_TAG, "File - URL pair validation failed. Will not start file upload.", new Object[0]);
            return null;
        }
        DownloadHttpRequest downloadHttpRequest = new DownloadHttpRequest();
        downloadHttpRequest.setRequestListener(new RegisteredCallback<File>() {
            public void onError(ErrorResponse errorResponse) {
                Logger.d(FileDownloader.LOG_TAG, "Error occurred. Reason: " + errorResponse.getReason(), new Object[0]);
                ErrorResponse unused = FileDownloader.this.mError = errorResponse;
            }

            public void onSuccess(File file) {
                File unused = FileDownloader.this.mDownloadedFile = file;
            }
        });
        downloadHttpRequest.downloadFile((URL) pairArr[0].first, (File) pairArr[0].second);
        return this.mDownloadedFile;
    }

    public void onPostExecute(File file) {
        super.onPostExecute(file);
        RegisteredCallback<File> registeredCallback = this.mRegisteredCallback;
        if (registeredCallback != null) {
            ErrorResponse errorResponse = this.mError;
            if (errorResponse != null) {
                registeredCallback.onError(errorResponse);
            } else if (file != null) {
                registeredCallback.onSuccess(file);
            }
        }
    }
}

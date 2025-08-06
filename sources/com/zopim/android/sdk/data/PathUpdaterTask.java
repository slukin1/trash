package com.zopim.android.sdk.data;

import android.os.AsyncTask;

class PathUpdaterTask extends AsyncTask<String, Void, PathName> {
    private final PathUpdater mPathUpdater = new PathUpdater();

    public PathName doInBackground(String... strArr) {
        return this.mPathUpdater.updatePath(strArr[0]);
    }
}

package com.engagelab.privates.common.component;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.engagelab.privates.common.MTCommon;
import com.engagelab.privates.common.business.lifecycle.MTLifecycleBusiness;
import com.engagelab.privates.common.business.network.MTNetworkBusiness;
import com.engagelab.privates.common.observer.MTObservable;

public class MTCommonProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        MTObservable.getInstance().observer(getContext().getApplicationContext(), new MTCommon());
        MTLifecycleBusiness.getInstance().init(getContext().getApplicationContext());
        MTNetworkBusiness.getInstance().init(getContext().getApplicationContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}

package com.sensorsdata.analytics.android.sdk.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.jumio.core.cdn.CDNDownload;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppEndData;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppExitData;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig;
import com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;

class SAProviderHelper {
    private ContentResolver contentResolver;
    /* access modifiers changed from: private */
    public boolean isDbWritable = true;
    private long mAppStartTime = 0;
    private Context mContext;
    private SQLiteOpenHelper mDbHelper;
    private boolean mIsFlushDataState = false;
    private LoginIdKeyPersistent mLoginIdKeyPersistent;
    private int mSessionTime = CDNDownload.DEFAULT_TIMEOUT;
    private UserIdentityPersistent mUserIdsPersistent;
    private PersistentAppEndData persistentAppEndData;
    private PersistentAppExitData persistentAppExitData;
    private PersistentLoginId persistentLoginId;
    private PersistentRemoteSDKConfig persistentRemoteSDKConfig;
    private int startActivityCount = 0;

    public interface QueryEventsListener {
        void insert(String str, String str2);
    }

    public interface URI_CODE {
        public static final int ACTIVITY_START_COUNT = 2;
        public static final int APP_EXIT_DATA = 4;
        public static final int APP_PAUSED_TIME = 5;
        public static final int APP_START_TIME = 3;
        public static final int CHANNEL_PERSISTENT = 8;
        public static final int DISABLE_SDK = 11;
        public static final int EVENTS = 1;
        public static final int FIRST_PROCESS_START = 10;
        public static final int FLUSH_DATA = 9;
        public static final int LOGIN_ID = 7;
        public static final int LOGIN_ID_KEY = 14;
        public static final int PUSH_ID_KEY = 15;
        public static final int REMOTE_CONFIG = 12;
        public static final int SESSION_INTERVAL_TIME = 6;
        public static final int USER_IDENTITY_ID = 13;
    }

    public SAProviderHelper(Context context, SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.mDbHelper = sQLiteOpenHelper;
            this.mContext = context;
            this.contentResolver = context.getContentResolver();
            PersistentLoader.initLoader(context);
            this.persistentAppEndData = (PersistentAppEndData) PersistentLoader.loadPersistent(DbParams.PersistentName.APP_END_DATA);
            this.persistentAppExitData = (PersistentAppExitData) PersistentLoader.loadPersistent(DbParams.APP_EXIT_DATA);
            this.persistentLoginId = (PersistentLoginId) PersistentLoader.loadPersistent(DbParams.PersistentName.LOGIN_ID);
            this.persistentRemoteSDKConfig = (PersistentRemoteSDKConfig) PersistentLoader.loadPersistent(DbParams.PersistentName.REMOTE_CONFIG);
            this.mUserIdsPersistent = (UserIdentityPersistent) PersistentLoader.loadPersistent(DbParams.PersistentName.PERSISTENT_USER_ID);
            this.mLoginIdKeyPersistent = (LoginIdKeyPersistent) PersistentLoader.loadPersistent(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase getWritableDatabase() {
        try {
            if (!isDBExist()) {
                this.mDbHelper.close();
                this.isDbWritable = true;
            }
            return this.mDbHelper.getWritableDatabase();
        } catch (SQLiteException e11) {
            SALog.printStackTrace(e11);
            this.isDbWritable = false;
            return null;
        }
    }

    private boolean isDBExist() {
        return this.mContext.getDatabasePath(DbParams.DATABASE_NAME).exists();
    }

    public void appendUri(UriMatcher uriMatcher, String str) {
        try {
            uriMatcher.addURI(str, DbParams.TABLE_EVENTS, 1);
            uriMatcher.addURI(str, DbParams.TABLE_ACTIVITY_START_COUNT, 2);
            uriMatcher.addURI(str, DbParams.TABLE_APP_START_TIME, 3);
            uriMatcher.addURI(str, DbParams.APP_EXIT_DATA, 4);
            uriMatcher.addURI(str, DbParams.TABLE_SESSION_INTERVAL_TIME, 6);
            uriMatcher.addURI(str, DbParams.PersistentName.LOGIN_ID, 7);
            uriMatcher.addURI(str, DbParams.TABLE_CHANNEL_PERSISTENT, 8);
            uriMatcher.addURI(str, DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, 9);
            uriMatcher.addURI(str, DbParams.TABLE_FIRST_PROCESS_START, 10);
            uriMatcher.addURI(str, DbParams.TABLE_DATA_DISABLE_SDK, 11);
            uriMatcher.addURI(str, DbParams.PersistentName.REMOTE_CONFIG, 12);
            uriMatcher.addURI(str, DbParams.PersistentName.PERSISTENT_USER_ID, 13);
            uriMatcher.addURI(str, DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, 14);
            uriMatcher.addURI(str, DbParams.PUSH_ID_KEY, 15);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public int deleteEvents(String str, String[] strArr) {
        if (!this.isDbWritable) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.delete(DbParams.TABLE_EVENTS, str, strArr);
            }
        } catch (SQLiteException e11) {
            this.isDbWritable = false;
            SALog.printStackTrace(e11);
        }
        return 0;
    }

    public Uri insertChannelPersistent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return !contentValues.containsKey("event_name") ? uri : ContentUris.withAppendedId(uri, writableDatabase.insertWithOnConflict(DbParams.TABLE_CHANNEL_PERSISTENT, (String) null, contentValues, 5));
            }
            return uri;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return uri;
        }
    }

    public Uri insertEvent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !contentValues.containsKey("data")) {
                return uri;
            }
            return !contentValues.containsKey(DbParams.KEY_CREATED_AT) ? uri : ContentUris.withAppendedId(uri, writableDatabase.insert(DbParams.TABLE_EVENTS, "_id", contentValues));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return uri;
        }
    }

    public void insertPersistent(int i11, Uri uri, ContentValues contentValues) {
        switch (i11) {
            case 2:
                this.startActivityCount = contentValues.getAsInteger(DbParams.TABLE_ACTIVITY_START_COUNT).intValue();
                return;
            case 3:
                this.mAppStartTime = contentValues.getAsLong(DbParams.TABLE_APP_START_TIME).longValue();
                return;
            case 4:
                this.persistentAppExitData.commit(contentValues.getAsString(DbParams.APP_EXIT_DATA));
                return;
            case 6:
                this.mSessionTime = contentValues.getAsInteger(DbParams.TABLE_SESSION_INTERVAL_TIME).intValue();
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 7:
                this.persistentLoginId.commit(contentValues.getAsString(DbParams.PersistentName.LOGIN_ID));
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 9:
                this.mIsFlushDataState = contentValues.getAsBoolean(DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA).booleanValue();
                return;
            case 12:
                this.persistentRemoteSDKConfig.commit(contentValues.getAsString(DbParams.PersistentName.REMOTE_CONFIG));
                return;
            case 13:
                this.mUserIdsPersistent.commit(contentValues.getAsString(DbParams.PersistentName.PERSISTENT_USER_ID));
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 14:
                this.mLoginIdKeyPersistent.commit(contentValues.getAsString(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY));
                return;
            case 15:
                try {
                    SAStoreManager.getInstance().setString(contentValues.getAsString(DbParams.PUSH_ID_KEY), contentValues.getAsString(DbParams.PUSH_ID_VALUE));
                    return;
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                    return;
                }
            default:
                return;
        }
    }

    public void migratingDB(final Context context, final String str) {
        try {
            if (AppInfoUtils.getAppInfoBundle(context).getBoolean("com.sensorsdata.analytics.android.EnableMigratingDB", true)) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            if (context.getDatabasePath(str).exists()) {
                                OldBDatabaseHelper oldBDatabaseHelper = new OldBDatabaseHelper(context, str);
                                final SQLiteDatabase access$000 = SAProviderHelper.this.getWritableDatabase();
                                if (access$000 != null) {
                                    final ContentValues contentValues = new ContentValues();
                                    oldBDatabaseHelper.getAllEvents(access$000, new QueryEventsListener() {
                                        public void insert(String str, String str2) {
                                            contentValues.put("data", str);
                                            contentValues.put(DbParams.KEY_CREATED_AT, str2);
                                            access$000.insert(DbParams.TABLE_EVENTS, "_id", contentValues);
                                            contentValues.clear();
                                        }
                                    });
                                }
                            }
                            if (SAProviderHelper.this.isDbWritable) {
                                context.deleteDatabase(str);
                            }
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                        }
                    }
                }).start();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public Cursor queryByTable(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        if (!this.isDbWritable) {
            return null;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.query(str, strArr, str2, strArr2, (String) null, (String) null, str3);
            }
            return null;
        } catch (SQLiteException e11) {
            this.isDbWritable = false;
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public Cursor queryPersistent(int i11, Uri uri) {
        String str;
        String str2 = DbParams.PUSH_ID_KEY;
        switch (i11) {
            case 2:
                Integer valueOf = Integer.valueOf(this.startActivityCount);
                str2 = DbParams.TABLE_ACTIVITY_START_COUNT;
                str = valueOf;
                break;
            case 3:
                Long valueOf2 = Long.valueOf(this.mAppStartTime);
                str2 = DbParams.TABLE_APP_START_TIME;
                str = valueOf2;
                break;
            case 4:
                String str3 = (String) this.persistentAppExitData.get();
                boolean isEmpty = TextUtils.isEmpty(str3);
                String str4 = str3;
                if (isEmpty) {
                    this.persistentAppEndData.remove();
                    str4 = (String) this.persistentAppEndData.get();
                }
                str2 = DbParams.APP_EXIT_DATA;
                str = str4;
                break;
            case 6:
                Integer valueOf3 = Integer.valueOf(this.mSessionTime);
                str2 = DbParams.TABLE_SESSION_INTERVAL_TIME;
                str = valueOf3;
                break;
            case 7:
                Object obj = this.persistentLoginId.get();
                str2 = DbParams.PersistentName.LOGIN_ID;
                str = obj;
                break;
            case 9:
                Integer valueOf4 = Integer.valueOf(this.mIsFlushDataState ? 1 : 0);
                str2 = DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA;
                str = valueOf4;
                break;
            case 12:
                str2 = null;
                str = this.persistentRemoteSDKConfig.get();
                break;
            case 13:
                Object obj2 = this.mUserIdsPersistent.get();
                str2 = DbParams.PersistentName.PERSISTENT_USER_ID;
                str = obj2;
                break;
            case 14:
                Object obj3 = this.mLoginIdKeyPersistent.get();
                str2 = DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY;
                str = obj3;
                break;
            case 15:
                try {
                    str = SAStoreManager.getInstance().getString(uri.getQueryParameter(str2), "");
                    break;
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                    return null;
                }
            default:
                str = null;
                str2 = null;
                break;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str2});
        matrixCursor.addRow(new Object[]{str});
        return matrixCursor;
    }

    public int removeSP(String str) {
        SAStoreManager.getInstance().remove(str);
        return 1;
    }
}

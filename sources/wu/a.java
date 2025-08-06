package wu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.huobi.woodpecker.database.BackupDBHelper;
import com.huobi.woodpecker.database.bean.RequestInfo;
import java.util.ArrayList;
import java.util.List;
import kv.e;

public class a extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    public static int f23433c = 3;

    /* renamed from: b  reason: collision with root package name */
    public Object f23434b = new Object();

    public a(Context context) {
        super(context, "hb_woodpecker.db", (SQLiteDatabase.CursorFactory) null, f23433c);
    }

    public boolean a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.f23434b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                writableDatabase.setTransactionSuccessful();
                e.e("WPDBH", "数据库删除成功 result:" + ((long) writableDatabase.delete("request_data_table", str, strArr)) + ", whereClause=" + str);
                writableDatabase.endTransaction();
            } catch (Exception e11) {
                try {
                    e.p("WPDBH", "数据库删除失败!!!", e11);
                    return false;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        }
        return true;
    }

    public boolean b(ContentValues contentValues) {
        if (contentValues == null) {
            return false;
        }
        synchronized (this.f23434b) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                long insertWithOnConflict = writableDatabase.insertWithOnConflict("request_data_table", (String) null, contentValues, 5);
                writableDatabase.setTransactionSuccessful();
                e.e("WPDBH", "数据库插入成功 result:" + insertWithOnConflict);
                writableDatabase.endTransaction();
            } catch (Exception e11) {
                try {
                    e.p("WPDBH", "数据库插入失败!!! threwrec", e11);
                    return false;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        }
        return true;
    }

    public List<RequestInfo> e(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        List<RequestInfo> f11;
        synchronized (this.f23434b) {
            f11 = f(getReadableDatabase().query("request_data_table", new String[]{"_id", "request_date", "wood_action", "wood_action_priority", "request_info"}, str, strArr, str2, str3, str4, str5));
        }
        return f11;
    }

    public final List<RequestInfo> f(Cursor cursor) {
        ArrayList arrayList;
        Exception e11;
        if (cursor == null) {
            return null;
        }
        int i11 = 0;
        try {
            arrayList = new ArrayList();
            try {
                int columnIndex = cursor.getColumnIndex("_id");
                int columnIndex2 = cursor.getColumnIndex("request_date");
                int columnIndex3 = cursor.getColumnIndex("wood_action");
                int columnIndex4 = cursor.getColumnIndex("wood_action_priority");
                int columnIndex5 = cursor.getColumnIndex("request_info");
                while (cursor.moveToNext()) {
                    RequestInfo requestInfo = new RequestInfo();
                    requestInfo.setId(cursor.getLong(columnIndex));
                    requestInfo.setDate(cursor.getLong(columnIndex2));
                    requestInfo.setAction(cursor.getString(columnIndex3));
                    requestInfo.setPriority(cursor.getInt(columnIndex4));
                    requestInfo.setRequestInfo(cursor.getString(columnIndex5));
                    arrayList.add(requestInfo);
                    i11++;
                }
                e.e("WPDBH", "数据库查询到(count:" + i11 + ")条数据");
            } catch (Exception e12) {
                e11 = e12;
                try {
                    e.p("WPDBH", "数据库查询转换失败!!!", e11);
                    cursor.close();
                    return arrayList;
                } catch (Throwable th2) {
                    cursor.close();
                    throw th2;
                }
            }
        } catch (Exception e13) {
            arrayList = null;
            e11 = e13;
            e.p("WPDBH", "数据库查询转换失败!!!", e11);
            cursor.close();
            return arrayList;
        }
        cursor.close();
        return arrayList;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS request_data_table( _id INTEGER PRIMARY KEY AUTOINCREMENT, request_date INTEGER,wood_action TEXT,wood_action_priority INTEGER,request_info TEXT, UNIQUE(request_date,wood_action));");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        new BackupDBHelper().g(sQLiteDatabase, this);
    }
}

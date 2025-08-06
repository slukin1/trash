package cn.sharesdk.framework.a.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mob.MobSDK;

public class a extends SQLiteOpenHelper {
    public a() {
        super(MobSDK.getContext(), "sharesdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table  message(_id integer primary key autoincrement,post_time timestamp not null, message_data text not null);");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}

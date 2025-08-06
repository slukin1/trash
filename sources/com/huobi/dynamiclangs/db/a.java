package com.huobi.dynamiclangs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class a extends AbstractDaoMaster {

    /* renamed from: com.huobi.dynamiclangs.db.a$a  reason: collision with other inner class name */
    public static class C0568a extends b {
        public C0568a(Context context, String str) {
            super(context, str);
        }

        public void onUpgrade(Database database, int i11, int i12) {
            Log.i("greenDAO", "Upgrading schema from version " + i11 + " to " + i12 + " by dropping all tables");
            a.b(database, true);
            onCreate(database);
        }
    }

    public static abstract class b extends DatabaseOpenHelper {
        public b(Context context, String str) {
            super(context, str, 1);
        }

        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 1");
            a.a(database, false);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this((Database) new StandardDatabase(sQLiteDatabase));
    }

    public static void a(Database database, boolean z11) {
        DynamicStringsBeanDao.c(database, z11);
    }

    public static void b(Database database, boolean z11) {
        DynamicStringsBeanDao.d(database, z11);
    }

    /* renamed from: c */
    public pj.a newSession() {
        return new pj.a(this.f68293db, IdentityScopeType.Session, this.daoConfigMap);
    }

    /* renamed from: d */
    public pj.a newSession(IdentityScopeType identityScopeType) {
        return new pj.a(this.f68293db, identityScopeType, this.daoConfigMap);
    }

    public a(Database database) {
        super(database, 1);
        registerDaoClass(DynamicStringsBeanDao.class);
    }
}

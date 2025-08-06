package com.huobi.dynamiclangs.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.huobi.dynamiclangs.data.DynamicStringsBean;
import com.tencent.mmkv.MMKVContentProvider;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import pj.a;

public class DynamicStringsBeanDao extends AbstractDao<DynamicStringsBean, Long> {
    public static final String TABLENAME = "DYNAMIC_STRINGS_BEAN";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Key = new Property(2, String.class, "key", false, MMKVContentProvider.KEY);
        public static final Property Lang = new Property(1, String.class, "lang", false, "LANG");
        public static final Property Source = new Property(4, Integer.TYPE, "source", false, "SOURCE");
        public static final Property Value = new Property(3, String.class, "value", false, "VALUE");
    }

    public DynamicStringsBeanDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"DYNAMIC_STRINGS_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"LANG\" TEXT NOT NULL ,\"KEY\" TEXT NOT NULL ,\"VALUE\" TEXT,\"SOURCE\" INTEGER NOT NULL );");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"DYNAMIC_STRINGS_BEAN\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, DynamicStringsBean dynamicStringsBean) {
        sQLiteStatement.clearBindings();
        Long id2 = dynamicStringsBean.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        sQLiteStatement.bindString(2, dynamicStringsBean.getLang());
        sQLiteStatement.bindString(3, dynamicStringsBean.getKey());
        String value = dynamicStringsBean.getValue();
        if (value != null) {
            sQLiteStatement.bindString(4, value);
        }
        sQLiteStatement.bindLong(5, (long) dynamicStringsBean.getSource());
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, DynamicStringsBean dynamicStringsBean) {
        databaseStatement.clearBindings();
        Long id2 = dynamicStringsBean.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        databaseStatement.bindString(2, dynamicStringsBean.getLang());
        databaseStatement.bindString(3, dynamicStringsBean.getKey());
        String value = dynamicStringsBean.getValue();
        if (value != null) {
            databaseStatement.bindString(4, value);
        }
        databaseStatement.bindLong(5, (long) dynamicStringsBean.getSource());
    }

    /* renamed from: e */
    public Long getKey(DynamicStringsBean dynamicStringsBean) {
        if (dynamicStringsBean != null) {
            return dynamicStringsBean.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(DynamicStringsBean dynamicStringsBean) {
        return dynamicStringsBean.getId() != null;
    }

    /* renamed from: g */
    public DynamicStringsBean readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        Long valueOf = cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12));
        int i13 = i11 + 3;
        return new DynamicStringsBean(valueOf, cursor.getString(i11 + 1), cursor.getString(i11 + 2), cursor.isNull(i13) ? null : cursor.getString(i13), cursor.getInt(i11 + 4));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, DynamicStringsBean dynamicStringsBean, int i11) {
        int i12 = i11 + 0;
        String str = null;
        dynamicStringsBean.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        dynamicStringsBean.setLang(cursor.getString(i11 + 1));
        dynamicStringsBean.setKey(cursor.getString(i11 + 2));
        int i13 = i11 + 3;
        if (!cursor.isNull(i13)) {
            str = cursor.getString(i13);
        }
        dynamicStringsBean.setValue(str);
        dynamicStringsBean.setSource(cursor.getInt(i11 + 4));
    }

    /* renamed from: i */
    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    /* renamed from: j */
    public final Long updateKeyAfterInsert(DynamicStringsBean dynamicStringsBean, long j11) {
        dynamicStringsBean.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

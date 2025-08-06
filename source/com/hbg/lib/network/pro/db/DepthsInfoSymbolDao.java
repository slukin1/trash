package com.hbg.lib.network.pro.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import com.hbg.lib.network.pro.core.bean.DepthsInfoSymbol;
import com.tencent.mmkv.MMKVContentProvider;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import z8.a;

public class DepthsInfoSymbolDao extends AbstractDao<DepthsInfoSymbol, Long> {
    public static final String TABLENAME = "DEPTHS_INFO_SYMBOL";

    /* renamed from: a  reason: collision with root package name */
    public final DepthsInfoSymbol.DepthStepsConverter f70620a = new DepthsInfoSymbol.DepthStepsConverter();

    public static class Properties {
        public static final Property DepthsInfo = new Property(3, String.class, "depthsInfo", false, "DEPTHS_INFO");
        public static final Property Id = new Property(1, Long.class, "id", true, "_id");
        public static final Property Key = new Property(0, String.class, "key", false, MMKVContentProvider.KEY);
        public static final Property Symbol = new Property(2, String.class, "symbol", false, "SYMBOL");
    }

    public DepthsInfoSymbolDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"DEPTHS_INFO_SYMBOL\" (\"KEY\" TEXT,\"_id\" INTEGER PRIMARY KEY ,\"SYMBOL\" TEXT,\"DEPTHS_INFO\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_DEPTHS_INFO_SYMBOL_KEY_DESC_SYMBOL_DESC ON \"DEPTHS_INFO_SYMBOL\" (\"KEY\" DESC,\"SYMBOL\" DESC);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"DEPTHS_INFO_SYMBOL\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, DepthsInfoSymbol depthsInfoSymbol) {
        sQLiteStatement.clearBindings();
        String key = depthsInfoSymbol.getKey();
        if (key != null) {
            sQLiteStatement.bindString(1, key);
        }
        Long id2 = depthsInfoSymbol.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(2, id2.longValue());
        }
        String symbol = depthsInfoSymbol.getSymbol();
        if (symbol != null) {
            sQLiteStatement.bindString(3, symbol);
        }
        DepthsInfo depthsInfo = depthsInfoSymbol.getDepthsInfo();
        if (depthsInfo != null) {
            sQLiteStatement.bindString(4, this.f70620a.convertToDatabaseValue(depthsInfo));
        }
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, DepthsInfoSymbol depthsInfoSymbol) {
        databaseStatement.clearBindings();
        String key = depthsInfoSymbol.getKey();
        if (key != null) {
            databaseStatement.bindString(1, key);
        }
        Long id2 = depthsInfoSymbol.getId();
        if (id2 != null) {
            databaseStatement.bindLong(2, id2.longValue());
        }
        String symbol = depthsInfoSymbol.getSymbol();
        if (symbol != null) {
            databaseStatement.bindString(3, symbol);
        }
        DepthsInfo depthsInfo = depthsInfoSymbol.getDepthsInfo();
        if (depthsInfo != null) {
            databaseStatement.bindString(4, this.f70620a.convertToDatabaseValue(depthsInfo));
        }
    }

    /* renamed from: e */
    public Long getKey(DepthsInfoSymbol depthsInfoSymbol) {
        if (depthsInfoSymbol != null) {
            return depthsInfoSymbol.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(DepthsInfoSymbol depthsInfoSymbol) {
        return depthsInfoSymbol.getId() != null;
    }

    /* renamed from: g */
    public DepthsInfoSymbol readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        DepthsInfo depthsInfo = null;
        String string = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i11 + 1;
        Long valueOf = cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13));
        int i14 = i11 + 2;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i11 + 3;
        if (!cursor.isNull(i15)) {
            depthsInfo = this.f70620a.convertToEntityProperty(cursor.getString(i15));
        }
        return new DepthsInfoSymbol(string, valueOf, string2, depthsInfo);
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, DepthsInfoSymbol depthsInfoSymbol, int i11) {
        int i12 = i11 + 0;
        DepthsInfo depthsInfo = null;
        depthsInfoSymbol.setKey(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i11 + 1;
        depthsInfoSymbol.setId(cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13)));
        int i14 = i11 + 2;
        depthsInfoSymbol.setSymbol(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        if (!cursor.isNull(i15)) {
            depthsInfo = this.f70620a.convertToEntityProperty(cursor.getString(i15));
        }
        depthsInfoSymbol.setDepthsInfo(depthsInfo);
    }

    /* renamed from: i */
    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 1;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    /* renamed from: j */
    public final Long updateKeyAfterInsert(DepthsInfoSymbol depthsInfoSymbol, long j11) {
        depthsInfoSymbol.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

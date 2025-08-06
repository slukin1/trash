package com.hbg.lib.network.pro.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.tencent.mmkv.MMKVContentProvider;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import z8.a;

public class SuperMarginSymbolDao extends AbstractDao<SuperMarginSymbol, Long> {
    public static final String TABLENAME = "SUPER_MARGIN_SYMBOL";

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property Key = new Property(2, String.class, "key", false, MMKVContentProvider.KEY);
        public static final Property LoanMultiple = new Property(3, String.class, "loanMultiple", false, "LOAN_MULTIPLE");
        public static final Property Symbol = new Property(1, String.class, "symbol", false, "SYMBOL");
    }

    public SuperMarginSymbolDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"SUPER_MARGIN_SYMBOL\" (\"_id\" INTEGER PRIMARY KEY ,\"SYMBOL\" TEXT,\"KEY\" TEXT,\"LOAN_MULTIPLE\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_SUPER_MARGIN_SYMBOL_KEY_DESC_SYMBOL_DESC ON \"SUPER_MARGIN_SYMBOL\" (\"KEY\" DESC,\"SYMBOL\" DESC);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"SUPER_MARGIN_SYMBOL\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, SuperMarginSymbol superMarginSymbol) {
        sQLiteStatement.clearBindings();
        Long id2 = superMarginSymbol.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String symbol = superMarginSymbol.getSymbol();
        if (symbol != null) {
            sQLiteStatement.bindString(2, symbol);
        }
        String key = superMarginSymbol.getKey();
        if (key != null) {
            sQLiteStatement.bindString(3, key);
        }
        String loanMultiple = superMarginSymbol.getLoanMultiple();
        if (loanMultiple != null) {
            sQLiteStatement.bindString(4, loanMultiple);
        }
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, SuperMarginSymbol superMarginSymbol) {
        databaseStatement.clearBindings();
        Long id2 = superMarginSymbol.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String symbol = superMarginSymbol.getSymbol();
        if (symbol != null) {
            databaseStatement.bindString(2, symbol);
        }
        String key = superMarginSymbol.getKey();
        if (key != null) {
            databaseStatement.bindString(3, key);
        }
        String loanMultiple = superMarginSymbol.getLoanMultiple();
        if (loanMultiple != null) {
            databaseStatement.bindString(4, loanMultiple);
        }
    }

    /* renamed from: e */
    public Long getKey(SuperMarginSymbol superMarginSymbol) {
        if (superMarginSymbol != null) {
            return superMarginSymbol.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(SuperMarginSymbol superMarginSymbol) {
        return superMarginSymbol.getId() != null;
    }

    /* renamed from: g */
    public SuperMarginSymbol readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        String str = null;
        Long valueOf = cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i11 + 2;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i11 + 3;
        if (!cursor.isNull(i15)) {
            str = cursor.getString(i15);
        }
        return new SuperMarginSymbol(valueOf, string, string2, str);
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, SuperMarginSymbol superMarginSymbol, int i11) {
        int i12 = i11 + 0;
        String str = null;
        superMarginSymbol.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        superMarginSymbol.setSymbol(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        superMarginSymbol.setKey(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        if (!cursor.isNull(i15)) {
            str = cursor.getString(i15);
        }
        superMarginSymbol.setLoanMultiple(str);
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
    public final Long updateKeyAfterInsert(SuperMarginSymbol superMarginSymbol, long j11) {
        superMarginSymbol.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

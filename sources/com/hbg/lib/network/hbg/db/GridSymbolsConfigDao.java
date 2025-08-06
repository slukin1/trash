package com.hbg.lib.network.hbg.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsBean;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.tencent.mmkv.MMKVContentProvider;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import y7.a;

public class GridSymbolsConfigDao extends AbstractDao<GridSymbolsConfig, Long> {
    public static final String TABLENAME = "GRID_SYMBOLS_CONFIG";

    /* renamed from: a  reason: collision with root package name */
    public final GridSymbolsConfig.GridSymbolBeanBaseConverter f70277a = new GridSymbolsConfig.GridSymbolBeanBaseConverter();

    /* renamed from: b  reason: collision with root package name */
    public final GridSymbolsConfig.GridSymbolBeanBaseConverter f70278b = new GridSymbolsConfig.GridSymbolBeanBaseConverter();

    /* renamed from: c  reason: collision with root package name */
    public final GridSymbolsConfig.GridSymbolBeanConverter f70279c = new GridSymbolsConfig.GridSymbolBeanConverter();

    public static class Properties {
        public static final Property AssetBuff = new Property(3, String.class, "assetBuff", false, "ASSET_BUFF");
        public static final Property AssetMulti = new Property(2, String.class, "assetMulti", false, "ASSET_MULTI");
        public static final Property Bases = new Property(6, String.class, "bases", false, "BASES");
        public static final Property Id = new Property(1, Long.class, "id", true, "_id");
        public static final Property Key = new Property(0, String.class, "key", false, MMKVContentProvider.KEY);
        public static final Property MinPutRate = new Property(4, String.class, "minPutRate", false, "MIN_PUT_RATE");
        public static final Property Quotes = new Property(5, String.class, "quotes", false, "QUOTES");
        public static final Property Symbols = new Property(7, String.class, "symbols", false, "SYMBOLS");
    }

    public GridSymbolsConfigDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"GRID_SYMBOLS_CONFIG\" (\"KEY\" TEXT,\"_id\" INTEGER PRIMARY KEY ,\"ASSET_MULTI\" TEXT,\"ASSET_BUFF\" TEXT,\"MIN_PUT_RATE\" TEXT,\"QUOTES\" TEXT,\"BASES\" TEXT,\"SYMBOLS\" TEXT);");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_GRID_SYMBOLS_CONFIG_KEY_DESC ON \"GRID_SYMBOLS_CONFIG\" (\"KEY\" DESC);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"GRID_SYMBOLS_CONFIG\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, GridSymbolsConfig gridSymbolsConfig) {
        sQLiteStatement.clearBindings();
        String key = gridSymbolsConfig.getKey();
        if (key != null) {
            sQLiteStatement.bindString(1, key);
        }
        Long id2 = gridSymbolsConfig.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(2, id2.longValue());
        }
        String assetMulti = gridSymbolsConfig.getAssetMulti();
        if (assetMulti != null) {
            sQLiteStatement.bindString(3, assetMulti);
        }
        String assetBuff = gridSymbolsConfig.getAssetBuff();
        if (assetBuff != null) {
            sQLiteStatement.bindString(4, assetBuff);
        }
        String minPutRate = gridSymbolsConfig.getMinPutRate();
        if (minPutRate != null) {
            sQLiteStatement.bindString(5, minPutRate);
        }
        List<String> quotes = gridSymbolsConfig.getQuotes();
        if (quotes != null) {
            sQLiteStatement.bindString(6, this.f70277a.convertToDatabaseValue(quotes));
        }
        List<String> bases = gridSymbolsConfig.getBases();
        if (bases != null) {
            sQLiteStatement.bindString(7, this.f70278b.convertToDatabaseValue(bases));
        }
        List<GridSymbolsBean> symbols = gridSymbolsConfig.getSymbols();
        if (symbols != null) {
            sQLiteStatement.bindString(8, this.f70279c.convertToDatabaseValue(symbols));
        }
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, GridSymbolsConfig gridSymbolsConfig) {
        databaseStatement.clearBindings();
        String key = gridSymbolsConfig.getKey();
        if (key != null) {
            databaseStatement.bindString(1, key);
        }
        Long id2 = gridSymbolsConfig.getId();
        if (id2 != null) {
            databaseStatement.bindLong(2, id2.longValue());
        }
        String assetMulti = gridSymbolsConfig.getAssetMulti();
        if (assetMulti != null) {
            databaseStatement.bindString(3, assetMulti);
        }
        String assetBuff = gridSymbolsConfig.getAssetBuff();
        if (assetBuff != null) {
            databaseStatement.bindString(4, assetBuff);
        }
        String minPutRate = gridSymbolsConfig.getMinPutRate();
        if (minPutRate != null) {
            databaseStatement.bindString(5, minPutRate);
        }
        List<String> quotes = gridSymbolsConfig.getQuotes();
        if (quotes != null) {
            databaseStatement.bindString(6, this.f70277a.convertToDatabaseValue(quotes));
        }
        List<String> bases = gridSymbolsConfig.getBases();
        if (bases != null) {
            databaseStatement.bindString(7, this.f70278b.convertToDatabaseValue(bases));
        }
        List<GridSymbolsBean> symbols = gridSymbolsConfig.getSymbols();
        if (symbols != null) {
            databaseStatement.bindString(8, this.f70279c.convertToDatabaseValue(symbols));
        }
    }

    /* renamed from: e */
    public Long getKey(GridSymbolsConfig gridSymbolsConfig) {
        if (gridSymbolsConfig != null) {
            return gridSymbolsConfig.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(GridSymbolsConfig gridSymbolsConfig) {
        return gridSymbolsConfig.getId() != null;
    }

    /* renamed from: g */
    public GridSymbolsConfig readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        String string = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i11 + 1;
        Long valueOf = cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13));
        int i14 = i11 + 2;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i11 + 3;
        String string3 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i11 + 4;
        String string4 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i11 + 5;
        List<String> b11 = cursor.isNull(i17) ? null : this.f70277a.convertToEntityProperty(cursor.getString(i17));
        int i18 = i11 + 6;
        int i19 = i11 + 7;
        return new GridSymbolsConfig(string, valueOf, string2, string3, string4, b11, cursor.isNull(i18) ? null : this.f70278b.convertToEntityProperty(cursor.getString(i18)), cursor.isNull(i19) ? null : this.f70279c.convertToEntityProperty(cursor.getString(i19)));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, GridSymbolsConfig gridSymbolsConfig, int i11) {
        int i12 = i11 + 0;
        List<GridSymbolsBean> list = null;
        gridSymbolsConfig.setKey(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i11 + 1;
        gridSymbolsConfig.setId(cursor.isNull(i13) ? null : Long.valueOf(cursor.getLong(i13)));
        int i14 = i11 + 2;
        gridSymbolsConfig.setAssetMulti(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        gridSymbolsConfig.setAssetBuff(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        gridSymbolsConfig.setMinPutRate(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 5;
        gridSymbolsConfig.setQuotes(cursor.isNull(i17) ? null : this.f70277a.convertToEntityProperty(cursor.getString(i17)));
        int i18 = i11 + 6;
        gridSymbolsConfig.setBases(cursor.isNull(i18) ? null : this.f70278b.convertToEntityProperty(cursor.getString(i18)));
        int i19 = i11 + 7;
        if (!cursor.isNull(i19)) {
            list = this.f70279c.convertToEntityProperty(cursor.getString(i19));
        }
        gridSymbolsConfig.setSymbols(list);
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
    public final Long updateKeyAfterInsert(GridSymbolsConfig gridSymbolsConfig, long j11) {
        gridSymbolsConfig.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

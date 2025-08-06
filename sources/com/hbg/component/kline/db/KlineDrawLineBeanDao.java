package com.hbg.component.kline.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.hbg.component.kline.draw.bean.KlineDrawLineBean;
import com.hbg.component.kline.draw.bean.KlineDrawPointBean;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import p5.a;

public class KlineDrawLineBeanDao extends AbstractDao<KlineDrawLineBean, Long> {
    public static final String TABLENAME = "KLINE_DRAW_LINE_BEAN";

    /* renamed from: a  reason: collision with root package name */
    public final KlineDrawLineBean.PointListConverter f67190a = new KlineDrawLineBean.PointListConverter();

    public static class Properties {
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property LineColor;
        public static final Property LineColorIndex;
        public static final Property LineSize = new Property(5, Float.TYPE, "lineSize", false, "LINE_SIZE");
        public static final Property LineSizeIndex;
        public static final Property LineStyle;
        public static final Property LineType;
        public static final Property Lock = new Property(9, Boolean.TYPE, "lock", false, "LOCK");
        public static final Property Period = new Property(2, String.class, AnimatedPasterJsonConfig.CONFIG_PERIOD, false, "PERIOD");
        public static final Property PointList = new Property(10, String.class, "pointList", false, "POINT_LIST");
        public static final Property SymbolId = new Property(1, String.class, "symbolId", false, "SYMBOL_ID");
        public static final Property UpdateTimestamp = new Property(11, Long.TYPE, "updateTimestamp", false, "UPDATE_TIMESTAMP");

        static {
            Class cls = Integer.TYPE;
            LineType = new Property(3, cls, "lineType", false, "LINE_TYPE");
            Class cls2 = cls;
            LineStyle = new Property(4, cls2, "lineStyle", false, "LINE_STYLE");
            LineSizeIndex = new Property(6, cls2, "lineSizeIndex", false, "LINE_SIZE_INDEX");
            LineColor = new Property(7, cls2, "lineColor", false, "LINE_COLOR");
            LineColorIndex = new Property(8, cls2, "lineColorIndex", false, "LINE_COLOR_INDEX");
        }
    }

    public KlineDrawLineBeanDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"KLINE_DRAW_LINE_BEAN\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"SYMBOL_ID\" TEXT NOT NULL ,\"PERIOD\" TEXT NOT NULL ,\"LINE_TYPE\" INTEGER NOT NULL ,\"LINE_STYLE\" INTEGER NOT NULL ,\"LINE_SIZE\" REAL NOT NULL ,\"LINE_SIZE_INDEX\" INTEGER NOT NULL ,\"LINE_COLOR\" INTEGER NOT NULL ,\"LINE_COLOR_INDEX\" INTEGER NOT NULL ,\"LOCK\" INTEGER NOT NULL ,\"POINT_LIST\" TEXT,\"UPDATE_TIMESTAMP\" INTEGER NOT NULL );");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"KLINE_DRAW_LINE_BEAN\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, KlineDrawLineBean klineDrawLineBean) {
        sQLiteStatement.clearBindings();
        Long id2 = klineDrawLineBean.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        sQLiteStatement.bindString(2, klineDrawLineBean.getSymbolId());
        sQLiteStatement.bindString(3, klineDrawLineBean.getPeriod());
        sQLiteStatement.bindLong(4, (long) klineDrawLineBean.getLineType());
        sQLiteStatement.bindLong(5, (long) klineDrawLineBean.getLineStyle());
        sQLiteStatement.bindDouble(6, (double) klineDrawLineBean.getLineSize());
        sQLiteStatement.bindLong(7, (long) klineDrawLineBean.getLineSizeIndex());
        sQLiteStatement.bindLong(8, (long) klineDrawLineBean.getLineColor());
        sQLiteStatement.bindLong(9, (long) klineDrawLineBean.getLineColorIndex());
        sQLiteStatement.bindLong(10, klineDrawLineBean.getLock() ? 1 : 0);
        List<KlineDrawPointBean> pointList = klineDrawLineBean.getPointList();
        if (pointList != null) {
            sQLiteStatement.bindString(11, this.f67190a.convertToDatabaseValue(pointList));
        }
        sQLiteStatement.bindLong(12, klineDrawLineBean.getUpdateTimestamp());
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, KlineDrawLineBean klineDrawLineBean) {
        databaseStatement.clearBindings();
        Long id2 = klineDrawLineBean.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        databaseStatement.bindString(2, klineDrawLineBean.getSymbolId());
        databaseStatement.bindString(3, klineDrawLineBean.getPeriod());
        databaseStatement.bindLong(4, (long) klineDrawLineBean.getLineType());
        databaseStatement.bindLong(5, (long) klineDrawLineBean.getLineStyle());
        databaseStatement.bindDouble(6, (double) klineDrawLineBean.getLineSize());
        databaseStatement.bindLong(7, (long) klineDrawLineBean.getLineSizeIndex());
        databaseStatement.bindLong(8, (long) klineDrawLineBean.getLineColor());
        databaseStatement.bindLong(9, (long) klineDrawLineBean.getLineColorIndex());
        databaseStatement.bindLong(10, klineDrawLineBean.getLock() ? 1 : 0);
        List<KlineDrawPointBean> pointList = klineDrawLineBean.getPointList();
        if (pointList != null) {
            databaseStatement.bindString(11, this.f67190a.convertToDatabaseValue(pointList));
        }
        databaseStatement.bindLong(12, klineDrawLineBean.getUpdateTimestamp());
    }

    /* renamed from: e */
    public Long getKey(KlineDrawLineBean klineDrawLineBean) {
        if (klineDrawLineBean != null) {
            return klineDrawLineBean.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(KlineDrawLineBean klineDrawLineBean) {
        return klineDrawLineBean.getId() != null;
    }

    /* renamed from: g */
    public KlineDrawLineBean readEntity(Cursor cursor, int i11) {
        Cursor cursor2 = cursor;
        int i12 = i11 + 0;
        List<KlineDrawPointBean> list = null;
        Long valueOf = cursor2.isNull(i12) ? null : Long.valueOf(cursor2.getLong(i12));
        String string = cursor2.getString(i11 + 1);
        String string2 = cursor2.getString(i11 + 2);
        int i13 = cursor2.getInt(i11 + 3);
        int i14 = cursor2.getInt(i11 + 4);
        float f11 = cursor2.getFloat(i11 + 5);
        int i15 = cursor2.getInt(i11 + 6);
        int i16 = cursor2.getInt(i11 + 7);
        int i17 = cursor2.getInt(i11 + 8);
        boolean z11 = cursor2.getShort(i11 + 9) != 0;
        int i18 = i11 + 10;
        if (!cursor2.isNull(i18)) {
            list = this.f67190a.convertToEntityProperty(cursor2.getString(i18));
        }
        return new KlineDrawLineBean(valueOf, string, string2, i13, i14, f11, i15, i16, i17, z11, list, cursor2.getLong(i11 + 11));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, KlineDrawLineBean klineDrawLineBean, int i11) {
        int i12 = i11 + 0;
        List<KlineDrawPointBean> list = null;
        klineDrawLineBean.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        klineDrawLineBean.setSymbolId(cursor.getString(i11 + 1));
        klineDrawLineBean.setPeriod(cursor.getString(i11 + 2));
        klineDrawLineBean.setLineType(cursor.getInt(i11 + 3));
        klineDrawLineBean.setLineStyle(cursor.getInt(i11 + 4));
        klineDrawLineBean.setLineSize(cursor.getFloat(i11 + 5));
        klineDrawLineBean.setLineSizeIndex(cursor.getInt(i11 + 6));
        klineDrawLineBean.setLineColor(cursor.getInt(i11 + 7));
        klineDrawLineBean.setLineColorIndex(cursor.getInt(i11 + 8));
        klineDrawLineBean.setLock(cursor.getShort(i11 + 9) != 0);
        int i13 = i11 + 10;
        if (!cursor.isNull(i13)) {
            list = this.f67190a.convertToEntityProperty(cursor.getString(i13));
        }
        klineDrawLineBean.setPointList(list);
        klineDrawLineBean.setUpdateTimestamp(cursor.getLong(i11 + 11));
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
    public final Long updateKeyAfterInsert(KlineDrawLineBean klineDrawLineBean, long j11) {
        klineDrawLineBean.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

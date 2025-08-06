package wd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.module.kline.bean.KlineWithPeriodAndSymbolInfo;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import i6.d;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f26304d;

    /* renamed from: a  reason: collision with root package name */
    public C0231a f26305a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f26306b = null;

    /* renamed from: c  reason: collision with root package name */
    public String[] f26307c = {"keyId", "symbolId", CrashHianalyticsData.TIME, AnimatedPasterJsonConfig.CONFIG_PERIOD, "priceOpen", "priceHigh", "priceLow", "priceLast", "amount", "volume", "count", "version"};

    /* renamed from: wd.a$a  reason: collision with other inner class name */
    public static class C0231a extends SQLiteOpenHelper {
        public C0231a(Context context) {
            super(context, "huobi.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("create table kline(keyId INTEGER PRIMARY KEY, symbolId text not null, time integer not null, period text not null, priceOpen double not null, priceHigh double not null, priceLow double not null, priceLast double not null, amount double not null, volume double not null, count integer not null, version integer not null);CREATE UNIQUE INDEX unique_index on kline(symbolId, period, time);CREATE INDEX symbol_period on kline(symbolId, period);CREATE INDEX symbolId on kline(symbolId);CREATE INDEX time on kline(time);CREATE INDEX period on kline(period);CREATE INDEX priceHigh on kline(priceHigh);CREATE INDEX priceLow on kline(priceLow);CREATE INDEX version on kline(version);");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX unique_index on kline(symbolId, period, time);");
                sQLiteDatabase.execSQL("CREATE INDEX symbol_period on kline(symbolId, period);");
                sQLiteDatabase.execSQL("CREATE INDEX symbolId on kline(symbolId);");
                sQLiteDatabase.execSQL("CREATE INDEX time on kline(time);");
                sQLiteDatabase.execSQL("CREATE INDEX period on kline(period);");
                sQLiteDatabase.execSQL("CREATE INDEX priceHigh on kline(priceHigh);");
                sQLiteDatabase.execSQL("CREATE INDEX priceLow on kline(priceLow);");
                sQLiteDatabase.execSQL("CREATE INDEX version on kline(version);");
            } catch (Throwable th2) {
                d.g(th2);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        }
    }

    public a(Context context) {
        f26304d = this;
        g(context);
    }

    public static a b(Context context) {
        if (f26304d == null) {
            synchronized (a.class) {
                if (f26304d == null) {
                    f26304d = new a(context);
                }
            }
        }
        return f26304d;
    }

    public boolean a(String str, String str2) {
        try {
            this.f26306b.execSQL(String.format("DELETE  FROM %s WHERE %s = %s AND %s = %s", new Object[]{"kline", "symbolId", "'" + str + "'", AnimatedPasterJsonConfig.CONFIG_PERIOD, "'" + str2 + "'"}));
            return true;
        } catch (Throwable th2) {
            d.g(th2);
            return false;
        }
    }

    public long c(List<KlineInfo> list, String str, String str2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f26306b.beginTransaction();
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        KlineInfo klineInfo = list.get(i11);
                        if (klineInfo != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("symbolId", str);
                            contentValues.put(AnimatedPasterJsonConfig.CONFIG_PERIOD, str2);
                            contentValues.put(CrashHianalyticsData.TIME, Long.valueOf(klineInfo.getId()));
                            contentValues.put("priceOpen", Double.valueOf(klineInfo.getOpen()));
                            contentValues.put("priceHigh", Double.valueOf(klineInfo.getHigh()));
                            contentValues.put("priceLow", Double.valueOf(klineInfo.getLow()));
                            contentValues.put("priceLast", Double.valueOf(klineInfo.getClose()));
                            contentValues.put("amount", Double.valueOf(klineInfo.getAmount()));
                            contentValues.put("volume", Double.valueOf(klineInfo.getVol()));
                            contentValues.put("count", Long.valueOf(klineInfo.getCount()));
                            contentValues.put("version", 0);
                            this.f26306b.replace("kline", (String) null, contentValues);
                        }
                    }
                    this.f26306b.setTransactionSuccessful();
                    try {
                        this.f26306b.endTransaction();
                    } catch (Throwable unused) {
                    }
                    return -1;
                }
            } catch (Throwable th2) {
                try {
                    this.f26306b.endTransaction();
                } catch (Throwable unused2) {
                }
                throw th2;
            }
        }
        try {
            this.f26306b.endTransaction();
        } catch (Throwable unused3) {
        }
        return -1;
    }

    public Vector<KlineWithPeriodAndSymbolInfo> d(String str, String str2, int i11) {
        Vector<KlineWithPeriodAndSymbolInfo> vector = new Vector<>();
        try {
            Cursor rawQuery = this.f26306b.rawQuery(String.format("SELECT * FROM %s WHERE %s = %s AND %s = %s ORDER by %s DESC LIMIT 0, %d", new Object[]{"kline", "symbolId", "'" + str + "'", AnimatedPasterJsonConfig.CONFIG_PERIOD, "'" + str2 + "'", CrashHianalyticsData.TIME, Integer.valueOf(i11)}), (String[]) null);
            vector = f(rawQuery);
            rawQuery.close();
            Collections.sort(vector);
            return vector;
        } catch (Throwable th2) {
            d.g(th2);
            return vector;
        }
    }

    public KlineWithPeriodAndSymbolInfo e(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            KlineWithPeriodAndSymbolInfo klineWithPeriodAndSymbolInfo = new KlineWithPeriodAndSymbolInfo();
            klineWithPeriodAndSymbolInfo.setSymbol(cursor.getString(cursor.getColumnIndex("symbolId")));
            klineWithPeriodAndSymbolInfo.setPeriod(cursor.getString(cursor.getColumnIndex(AnimatedPasterJsonConfig.CONFIG_PERIOD)));
            klineWithPeriodAndSymbolInfo.setId((long) cursor.getInt(cursor.getColumnIndex(CrashHianalyticsData.TIME)));
            klineWithPeriodAndSymbolInfo.setOpen(cursor.getDouble(cursor.getColumnIndex("priceOpen")));
            klineWithPeriodAndSymbolInfo.setHigh(cursor.getDouble(cursor.getColumnIndex("priceHigh")));
            klineWithPeriodAndSymbolInfo.setLow(cursor.getDouble(cursor.getColumnIndex("priceLow")));
            klineWithPeriodAndSymbolInfo.setClose(cursor.getDouble(cursor.getColumnIndex("priceLast")));
            klineWithPeriodAndSymbolInfo.setAmount(cursor.getDouble(cursor.getColumnIndex("amount")));
            klineWithPeriodAndSymbolInfo.setVol(cursor.getDouble(cursor.getColumnIndex("volume")));
            klineWithPeriodAndSymbolInfo.setCount((long) cursor.getInt(cursor.getColumnIndex("count")));
            return klineWithPeriodAndSymbolInfo;
        } catch (Throwable th2) {
            d.g(th2);
            return null;
        }
    }

    public Vector<KlineWithPeriodAndSymbolInfo> f(Cursor cursor) {
        Vector<KlineWithPeriodAndSymbolInfo> vector = new Vector<>();
        if (cursor == null) {
            return vector;
        }
        try {
            if (cursor.getCount() == 0) {
                return vector;
            }
            cursor.moveToFirst();
            do {
                KlineWithPeriodAndSymbolInfo e11 = e(cursor);
                if (e11 != null) {
                    vector.add(e11);
                }
            } while (cursor.moveToNext());
            return vector;
        } catch (Throwable th2) {
            d.g(th2);
        }
    }

    public a g(Context context) {
        try {
            C0231a aVar = new C0231a(context);
            this.f26305a = aVar;
            this.f26306b = aVar.getWritableDatabase();
        } catch (Throwable th2) {
            d.g(th2);
        }
        return this;
    }
}

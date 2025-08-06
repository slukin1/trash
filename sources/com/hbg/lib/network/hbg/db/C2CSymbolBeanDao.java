package com.hbg.lib.network.hbg.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import y7.a;

public class C2CSymbolBeanDao extends AbstractDao<C2CSymbolBean, String> {
    public static final String TABLENAME = "C2_CSYMBOL_BEAN";

    public static class Properties {
        public static final Property BaseCurrency = new Property(1, String.class, "baseCurrency", false, "BASE_CURRENCY");
        public static final Property BaseCurrencyBorrowMaxAmount = new Property(8, String.class, "baseCurrencyBorrowMaxAmount", false, "BASE_CURRENCY_BORROW_MAX_AMOUNT");
        public static final Property BaseCurrencyBorrowMinAmount = new Property(7, String.class, "baseCurrencyBorrowMinAmount", false, "BASE_CURRENCY_BORROW_MIN_AMOUNT");
        public static final Property Enable = new Property(3, Boolean.TYPE, "enable", false, "ENABLE");
        public static final Property LoanMultiple = new Property(4, String.class, "loanMultiple", false, "LOAN_MULTIPLE");
        public static final Property QuoteCurrency = new Property(2, String.class, "quoteCurrency", false, "QUOTE_CURRENCY");
        public static final Property QuoteCurrencyBorrowMaxAmount = new Property(6, String.class, "quoteCurrencyBorrowMaxAmount", false, "QUOTE_CURRENCY_BORROW_MAX_AMOUNT");
        public static final Property QuoteCurrencyBorrowMinAmount = new Property(5, String.class, "quoteCurrencyBorrowMinAmount", false, "QUOTE_CURRENCY_BORROW_MIN_AMOUNT");
        public static final Property Symbol = new Property(0, String.class, "symbol", true, "SYMBOL");
    }

    public C2CSymbolBeanDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"C2_CSYMBOL_BEAN\" (\"SYMBOL\" TEXT PRIMARY KEY NOT NULL ,\"BASE_CURRENCY\" TEXT,\"QUOTE_CURRENCY\" TEXT,\"ENABLE\" INTEGER NOT NULL ,\"LOAN_MULTIPLE\" TEXT,\"QUOTE_CURRENCY_BORROW_MIN_AMOUNT\" TEXT,\"QUOTE_CURRENCY_BORROW_MAX_AMOUNT\" TEXT,\"BASE_CURRENCY_BORROW_MIN_AMOUNT\" TEXT,\"BASE_CURRENCY_BORROW_MAX_AMOUNT\" TEXT);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"C2_CSYMBOL_BEAN\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, C2CSymbolBean c2CSymbolBean) {
        sQLiteStatement.clearBindings();
        String symbol = c2CSymbolBean.getSymbol();
        if (symbol != null) {
            sQLiteStatement.bindString(1, symbol);
        }
        String baseCurrency = c2CSymbolBean.getBaseCurrency();
        if (baseCurrency != null) {
            sQLiteStatement.bindString(2, baseCurrency);
        }
        String quoteCurrency = c2CSymbolBean.getQuoteCurrency();
        if (quoteCurrency != null) {
            sQLiteStatement.bindString(3, quoteCurrency);
        }
        sQLiteStatement.bindLong(4, c2CSymbolBean.getEnable() ? 1 : 0);
        String loanMultiple = c2CSymbolBean.getLoanMultiple();
        if (loanMultiple != null) {
            sQLiteStatement.bindString(5, loanMultiple);
        }
        String quoteCurrencyBorrowMinAmount = c2CSymbolBean.getQuoteCurrencyBorrowMinAmount();
        if (quoteCurrencyBorrowMinAmount != null) {
            sQLiteStatement.bindString(6, quoteCurrencyBorrowMinAmount);
        }
        String quoteCurrencyBorrowMaxAmount = c2CSymbolBean.getQuoteCurrencyBorrowMaxAmount();
        if (quoteCurrencyBorrowMaxAmount != null) {
            sQLiteStatement.bindString(7, quoteCurrencyBorrowMaxAmount);
        }
        String baseCurrencyBorrowMinAmount = c2CSymbolBean.getBaseCurrencyBorrowMinAmount();
        if (baseCurrencyBorrowMinAmount != null) {
            sQLiteStatement.bindString(8, baseCurrencyBorrowMinAmount);
        }
        String baseCurrencyBorrowMaxAmount = c2CSymbolBean.getBaseCurrencyBorrowMaxAmount();
        if (baseCurrencyBorrowMaxAmount != null) {
            sQLiteStatement.bindString(9, baseCurrencyBorrowMaxAmount);
        }
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, C2CSymbolBean c2CSymbolBean) {
        databaseStatement.clearBindings();
        String symbol = c2CSymbolBean.getSymbol();
        if (symbol != null) {
            databaseStatement.bindString(1, symbol);
        }
        String baseCurrency = c2CSymbolBean.getBaseCurrency();
        if (baseCurrency != null) {
            databaseStatement.bindString(2, baseCurrency);
        }
        String quoteCurrency = c2CSymbolBean.getQuoteCurrency();
        if (quoteCurrency != null) {
            databaseStatement.bindString(3, quoteCurrency);
        }
        databaseStatement.bindLong(4, c2CSymbolBean.getEnable() ? 1 : 0);
        String loanMultiple = c2CSymbolBean.getLoanMultiple();
        if (loanMultiple != null) {
            databaseStatement.bindString(5, loanMultiple);
        }
        String quoteCurrencyBorrowMinAmount = c2CSymbolBean.getQuoteCurrencyBorrowMinAmount();
        if (quoteCurrencyBorrowMinAmount != null) {
            databaseStatement.bindString(6, quoteCurrencyBorrowMinAmount);
        }
        String quoteCurrencyBorrowMaxAmount = c2CSymbolBean.getQuoteCurrencyBorrowMaxAmount();
        if (quoteCurrencyBorrowMaxAmount != null) {
            databaseStatement.bindString(7, quoteCurrencyBorrowMaxAmount);
        }
        String baseCurrencyBorrowMinAmount = c2CSymbolBean.getBaseCurrencyBorrowMinAmount();
        if (baseCurrencyBorrowMinAmount != null) {
            databaseStatement.bindString(8, baseCurrencyBorrowMinAmount);
        }
        String baseCurrencyBorrowMaxAmount = c2CSymbolBean.getBaseCurrencyBorrowMaxAmount();
        if (baseCurrencyBorrowMaxAmount != null) {
            databaseStatement.bindString(9, baseCurrencyBorrowMaxAmount);
        }
    }

    /* renamed from: e */
    public String getKey(C2CSymbolBean c2CSymbolBean) {
        if (c2CSymbolBean != null) {
            return c2CSymbolBean.getSymbol();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(C2CSymbolBean c2CSymbolBean) {
        return c2CSymbolBean.getSymbol() != null;
    }

    /* renamed from: g */
    public C2CSymbolBean readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        String string = cursor.isNull(i12) ? null : cursor.getString(i12);
        int i13 = i11 + 1;
        String string2 = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i11 + 2;
        String string3 = cursor.isNull(i14) ? null : cursor.getString(i14);
        boolean z11 = cursor.getShort(i11 + 3) != 0;
        int i15 = i11 + 4;
        String string4 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i11 + 5;
        String string5 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i11 + 6;
        String string6 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i11 + 7;
        int i19 = i11 + 8;
        return new C2CSymbolBean(string, string2, string3, z11, string4, string5, string6, cursor.isNull(i18) ? null : cursor.getString(i18), cursor.isNull(i19) ? null : cursor.getString(i19));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, C2CSymbolBean c2CSymbolBean, int i11) {
        int i12 = i11 + 0;
        String str = null;
        c2CSymbolBean.setSymbol(cursor.isNull(i12) ? null : cursor.getString(i12));
        int i13 = i11 + 1;
        c2CSymbolBean.setBaseCurrency(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        c2CSymbolBean.setQuoteCurrency(cursor.isNull(i14) ? null : cursor.getString(i14));
        c2CSymbolBean.setEnable(cursor.getShort(i11 + 3) != 0);
        int i15 = i11 + 4;
        c2CSymbolBean.setLoanMultiple(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 5;
        c2CSymbolBean.setQuoteCurrencyBorrowMinAmount(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 6;
        c2CSymbolBean.setQuoteCurrencyBorrowMaxAmount(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i11 + 7;
        c2CSymbolBean.setBaseCurrencyBorrowMinAmount(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i11 + 8;
        if (!cursor.isNull(i19)) {
            str = cursor.getString(i19);
        }
        c2CSymbolBean.setBaseCurrencyBorrowMaxAmount(str);
    }

    /* renamed from: i */
    public String readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return cursor.getString(i12);
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    /* renamed from: j */
    public final String updateKeyAfterInsert(C2CSymbolBean c2CSymbolBean, long j11) {
        return c2CSymbolBean.getSymbol();
    }
}

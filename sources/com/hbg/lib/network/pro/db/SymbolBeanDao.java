package com.hbg.lib.network.pro.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mmkv.MMKVContentProvider;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import z8.a;

public class SymbolBeanDao extends AbstractDao<SymbolBean, Long> {
    public static final String TABLENAME = "SYMBOL_BEAN";

    /* renamed from: a  reason: collision with root package name */
    public final SymbolBean.PartitionsListConverter f70622a = new SymbolBean.PartitionsListConverter();

    public static class Properties {
        public static final Property BaseCurrency = new Property(2, String.class, "baseCurrency", false, "BASE_CURRENCY");
        public static final Property BaseCurrencyDisplayName = new Property(4, String.class, "baseCurrencyDisplayName", false, "BASE_CURRENCY_DISPLAY_NAME");
        public static final Property Ca1CloseAt;
        public static final Property Ca1OpenAt;
        public static final Property Ca2CloseAt;
        public static final Property Ca2OpenAt;
        public static final Property CaState = new Property(37, String.class, "caState", false, "CA_STATE");
        public static final Property CancelEnabled;
        public static final Property CountryDisabled;
        public static final Property Direction = new Property(35, String.class, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, false, "DIRECTION");
        public static final Property EtpLeverageRatio = new Property(34, String.class, "etpLeverageRatio", false, "ETP_LEVERAGE_RATIO");
        public static final Property FeePrecision;
        public static final Property FundingLeverageRatio = new Property(33, String.class, "fundingLeverageRatio", false, "FUNDING_LEVERAGE_RATIO");
        public static final Property GlobalVisible;
        public static final Property Id = new Property(0, Long.class, "id", true, "_id");
        public static final Property IsTradeEnabled;
        public static final Property Key = new Property(1, String.class, "key", false, MMKVContentProvider.KEY);
        public static final Property KycRestrictedCountry;
        public static final Property KycRestrictedTimeRange = new Property(42, Long.class, "kycRestrictedTimeRange", false, "KYC_RESTRICTED_TIME_RANGE");
        public static final Property LeverageRatio = new Property(32, String.class, "leverageRatio", false, "LEVERAGE_RATIO");
        public static final Property MarketBuyPriceHigherThanCurrent = new Property(44, Double.TYPE, "marketBuyPriceHigherThanCurrent", false, "MARKET_BUY_PRICE_HIGHER_THAN_CURRENT");
        public static final Property MarketSellPriceLowerThanCurrent = new Property(45, Double.TYPE, "marketSellPriceLowerThanCurrent", false, "MARKET_SELL_PRICE_LOWER_THAN_CURRENT");
        public static final Property Partitions = new Property(36, String.class, "partitions", false, "PARTITIONS");
        public static final Property QuoteCurrency = new Property(3, String.class, "quoteCurrency", false, "QUOTE_CURRENCY");
        public static final Property QuoteCurrencyDisplayName = new Property(5, String.class, "quoteCurrencyDisplayName", false, "QUOTE_CURRENCY_DISPLAY_NAME");
        public static final Property State = new Property(17, String.class, "state", false, "STATE");
        public static final Property SuperMarginLeverageRatio = new Property(31, String.class, "superMarginLeverageRatio", false, "SUPER_MARGIN_LEVERAGE_RATIO");
        public static final Property SupportMargin;
        public static final Property SuspendDesc = new Property(19, String.class, "suspendDesc", false, "SUSPEND_DESC");
        public static final Property Symbol = new Property(7, String.class, "symbol", false, "SYMBOL");
        public static final Property SymbolName = new Property(8, String.class, "symbolName", false, "SYMBOL_NAME");
        public static final Property SymbolPartition = new Property(9, String.class, "symbolPartition", false, "SYMBOL_PARTITION");
        public static final Property Tags = new Property(23, String.class, InnerShareParams.TAGS, false, "TAGS");
        public static final Property TradeAmountPrecision;
        public static final Property TradeCloseAt;
        public static final Property TradeEnableTimestamp;
        public static final Property TradeOpenAt;
        public static final Property TradePricePrecision;
        public static final Property TradeTotalPrecision;
        public static final Property TransferBoardDesc = new Property(20, String.class, "transferBoardDesc", false, "TRANSFER_BOARD_DESC");
        public static final Property VisibleCloseAt;
        public static final Property VisibleOpenAt;
        public static final Property VisitEnabled;
        public static final Property Weight;
        public static final Property WhiteEnabled;
        public static final Property WithdrawRisk = new Property(26, String.class, "withdrawRisk", false, "WITHDRAW_RISK");

        static {
            Class cls = Integer.TYPE;
            SupportMargin = new Property(6, cls, "supportMargin", false, "SUPPORT_MARGIN");
            Weight = new Property(10, cls, "weight", false, "WEIGHT");
            Class cls2 = Long.TYPE;
            TradeOpenAt = new Property(11, cls2, "tradeOpenAt", false, "TRADE_OPEN_AT");
            Class cls3 = cls2;
            TradeCloseAt = new Property(12, cls3, "tradeCloseAt", false, "TRADE_CLOSE_AT");
            VisibleOpenAt = new Property(13, cls3, "visibleOpenAt", false, "VISIBLE_OPEN_AT");
            VisibleCloseAt = new Property(14, cls3, "visibleCloseAt", false, "VISIBLE_CLOSE_AT");
            Class cls4 = Boolean.TYPE;
            VisitEnabled = new Property(15, cls4, "visitEnabled", false, "VISIT_ENABLED");
            CancelEnabled = new Property(16, cls4, "cancelEnabled", false, "CANCEL_ENABLED");
            TradeEnableTimestamp = new Property(18, cls2, "tradeEnableTimestamp", false, "TRADE_ENABLE_TIMESTAMP");
            Class cls5 = cls4;
            WhiteEnabled = new Property(21, cls5, "whiteEnabled", false, "WHITE_ENABLED");
            CountryDisabled = new Property(22, cls5, "countryDisabled", false, "COUNTRY_DISABLED");
            GlobalVisible = new Property(24, cls5, "globalVisible", false, "GLOBAL_VISIBLE");
            IsTradeEnabled = new Property(25, cls5, "isTradeEnabled", false, "IS_TRADE_ENABLED");
            Class cls6 = cls;
            TradePricePrecision = new Property(27, cls6, "tradePricePrecision", false, "TRADE_PRICE_PRECISION");
            TradeAmountPrecision = new Property(28, cls6, "tradeAmountPrecision", false, "TRADE_AMOUNT_PRECISION");
            TradeTotalPrecision = new Property(29, cls6, "tradeTotalPrecision", false, "TRADE_TOTAL_PRECISION");
            FeePrecision = new Property(30, cls6, "feePrecision", false, "FEE_PRECISION");
            Class cls7 = cls2;
            Ca1OpenAt = new Property(38, cls7, "ca1OpenAt", false, "CA1_OPEN_AT");
            Ca1CloseAt = new Property(39, cls7, "ca1CloseAt", false, "CA1_CLOSE_AT");
            Ca2OpenAt = new Property(40, cls7, "ca2OpenAt", false, "CA2_OPEN_AT");
            Ca2CloseAt = new Property(41, cls7, "ca2CloseAt", false, "CA2_CLOSE_AT");
            KycRestrictedCountry = new Property(43, cls4, "kycRestrictedCountry", false, "KYC_RESTRICTED_COUNTRY");
        }
    }

    public SymbolBeanDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"SYMBOL_BEAN\" (\"_id\" INTEGER PRIMARY KEY ,\"KEY\" TEXT,\"BASE_CURRENCY\" TEXT,\"QUOTE_CURRENCY\" TEXT,\"BASE_CURRENCY_DISPLAY_NAME\" TEXT,\"QUOTE_CURRENCY_DISPLAY_NAME\" TEXT,\"SUPPORT_MARGIN\" INTEGER NOT NULL ,\"SYMBOL\" TEXT,\"SYMBOL_NAME\" TEXT,\"SYMBOL_PARTITION\" TEXT,\"WEIGHT\" INTEGER NOT NULL ,\"TRADE_OPEN_AT\" INTEGER NOT NULL ,\"TRADE_CLOSE_AT\" INTEGER NOT NULL ,\"VISIBLE_OPEN_AT\" INTEGER NOT NULL ,\"VISIBLE_CLOSE_AT\" INTEGER NOT NULL ,\"VISIT_ENABLED\" INTEGER NOT NULL ,\"CANCEL_ENABLED\" INTEGER NOT NULL ,\"STATE\" TEXT,\"TRADE_ENABLE_TIMESTAMP\" INTEGER NOT NULL ,\"SUSPEND_DESC\" TEXT,\"TRANSFER_BOARD_DESC\" TEXT,\"WHITE_ENABLED\" INTEGER NOT NULL ,\"COUNTRY_DISABLED\" INTEGER NOT NULL ,\"TAGS\" TEXT,\"GLOBAL_VISIBLE\" INTEGER NOT NULL ,\"IS_TRADE_ENABLED\" INTEGER NOT NULL ,\"WITHDRAW_RISK\" TEXT,\"TRADE_PRICE_PRECISION\" INTEGER NOT NULL ,\"TRADE_AMOUNT_PRECISION\" INTEGER NOT NULL ,\"TRADE_TOTAL_PRECISION\" INTEGER NOT NULL ,\"FEE_PRECISION\" INTEGER NOT NULL ,\"SUPER_MARGIN_LEVERAGE_RATIO\" TEXT,\"LEVERAGE_RATIO\" TEXT,\"FUNDING_LEVERAGE_RATIO\" TEXT,\"ETP_LEVERAGE_RATIO\" TEXT,\"DIRECTION\" TEXT,\"PARTITIONS\" TEXT,\"CA_STATE\" TEXT,\"CA1_OPEN_AT\" INTEGER NOT NULL ,\"CA1_CLOSE_AT\" INTEGER NOT NULL ,\"CA2_OPEN_AT\" INTEGER NOT NULL ,\"CA2_CLOSE_AT\" INTEGER NOT NULL ,\"KYC_RESTRICTED_TIME_RANGE\" INTEGER,\"KYC_RESTRICTED_COUNTRY\" INTEGER NOT NULL ,\"MARKET_BUY_PRICE_HIGHER_THAN_CURRENT\" REAL NOT NULL ,\"MARKET_SELL_PRICE_LOWER_THAN_CURRENT\" REAL NOT NULL );");
        database.execSQL("CREATE UNIQUE INDEX " + str + "IDX_SYMBOL_BEAN_KEY_DESC_SYMBOL_DESC ON \"SYMBOL_BEAN\" (\"KEY\" DESC,\"SYMBOL\" DESC);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"SYMBOL_BEAN\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, SymbolBean symbolBean) {
        sQLiteStatement.clearBindings();
        Long id2 = symbolBean.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String key = symbolBean.getKey();
        if (key != null) {
            sQLiteStatement.bindString(2, key);
        }
        String baseCurrency = symbolBean.getBaseCurrency();
        if (baseCurrency != null) {
            sQLiteStatement.bindString(3, baseCurrency);
        }
        String quoteCurrency = symbolBean.getQuoteCurrency();
        if (quoteCurrency != null) {
            sQLiteStatement.bindString(4, quoteCurrency);
        }
        String baseCurrencyDisplayName = symbolBean.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName != null) {
            sQLiteStatement.bindString(5, baseCurrencyDisplayName);
        }
        String quoteCurrencyDisplayName = symbolBean.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName != null) {
            sQLiteStatement.bindString(6, quoteCurrencyDisplayName);
        }
        sQLiteStatement.bindLong(7, (long) symbolBean.getSupportMargin());
        String symbol = symbolBean.getSymbol();
        if (symbol != null) {
            sQLiteStatement.bindString(8, symbol);
        }
        String symbolName = symbolBean.getSymbolName();
        if (symbolName != null) {
            sQLiteStatement.bindString(9, symbolName);
        }
        String symbolPartition = symbolBean.getSymbolPartition();
        if (symbolPartition != null) {
            sQLiteStatement.bindString(10, symbolPartition);
        }
        sQLiteStatement.bindLong(11, (long) symbolBean.getWeight());
        sQLiteStatement.bindLong(12, symbolBean.getTradeOpenAt());
        sQLiteStatement.bindLong(13, symbolBean.getTradeCloseAt());
        sQLiteStatement.bindLong(14, symbolBean.getVisibleOpenAt());
        sQLiteStatement.bindLong(15, symbolBean.getVisibleCloseAt());
        long j11 = 1;
        sQLiteStatement.bindLong(16, symbolBean.getVisitEnabled() ? 1 : 0);
        sQLiteStatement.bindLong(17, symbolBean.getCancelEnabled() ? 1 : 0);
        String state = symbolBean.getState();
        if (state != null) {
            sQLiteStatement.bindString(18, state);
        }
        sQLiteStatement.bindLong(19, symbolBean.getTradeEnableTimestamp());
        String suspendDesc = symbolBean.getSuspendDesc();
        if (suspendDesc != null) {
            sQLiteStatement.bindString(20, suspendDesc);
        }
        String transferBoardDesc = symbolBean.getTransferBoardDesc();
        if (transferBoardDesc != null) {
            sQLiteStatement.bindString(21, transferBoardDesc);
        }
        sQLiteStatement.bindLong(22, symbolBean.getWhiteEnabled() ? 1 : 0);
        sQLiteStatement.bindLong(23, symbolBean.getCountryDisabled() ? 1 : 0);
        String tags = symbolBean.getTags();
        if (tags != null) {
            sQLiteStatement.bindString(24, tags);
        }
        sQLiteStatement.bindLong(25, symbolBean.getGlobalVisible() ? 1 : 0);
        sQLiteStatement.bindLong(26, symbolBean.getIsTradeEnabled() ? 1 : 0);
        String withdrawRisk = symbolBean.getWithdrawRisk();
        if (withdrawRisk != null) {
            sQLiteStatement.bindString(27, withdrawRisk);
        }
        sQLiteStatement.bindLong(28, (long) symbolBean.getTradePricePrecision());
        sQLiteStatement.bindLong(29, (long) symbolBean.getTradeAmountPrecision());
        sQLiteStatement.bindLong(30, (long) symbolBean.getTradeTotalPrecision());
        sQLiteStatement.bindLong(31, (long) symbolBean.getFeePrecision());
        String superMarginLeverageRatio = symbolBean.getSuperMarginLeverageRatio();
        if (superMarginLeverageRatio != null) {
            sQLiteStatement.bindString(32, superMarginLeverageRatio);
        }
        String leverageRatio = symbolBean.getLeverageRatio();
        if (leverageRatio != null) {
            sQLiteStatement.bindString(33, leverageRatio);
        }
        String fundingLeverageRatio = symbolBean.getFundingLeverageRatio();
        if (fundingLeverageRatio != null) {
            sQLiteStatement.bindString(34, fundingLeverageRatio);
        }
        String etpLeverageRatio = symbolBean.getEtpLeverageRatio();
        if (etpLeverageRatio != null) {
            sQLiteStatement.bindString(35, etpLeverageRatio);
        }
        String direction = symbolBean.getDirection();
        if (direction != null) {
            sQLiteStatement.bindString(36, direction);
        }
        List<Partitions> partitions = symbolBean.getPartitions();
        if (partitions != null) {
            sQLiteStatement.bindString(37, this.f70622a.convertToDatabaseValue(partitions));
        }
        String caState = symbolBean.getCaState();
        if (caState != null) {
            sQLiteStatement.bindString(38, caState);
        }
        sQLiteStatement.bindLong(39, symbolBean.getCa1OpenAt());
        sQLiteStatement.bindLong(40, symbolBean.getCa1CloseAt());
        sQLiteStatement.bindLong(41, symbolBean.getCa2OpenAt());
        sQLiteStatement.bindLong(42, symbolBean.getCa2CloseAt());
        Long kycRestrictedTimeRange = symbolBean.getKycRestrictedTimeRange();
        if (kycRestrictedTimeRange != null) {
            sQLiteStatement.bindLong(43, kycRestrictedTimeRange.longValue());
        }
        if (!symbolBean.getKycRestrictedCountry()) {
            j11 = 0;
        }
        sQLiteStatement.bindLong(44, j11);
        sQLiteStatement.bindDouble(45, symbolBean.getMarketBuyPriceHigherThanCurrent());
        sQLiteStatement.bindDouble(46, symbolBean.getMarketSellPriceLowerThanCurrent());
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, SymbolBean symbolBean) {
        databaseStatement.clearBindings();
        Long id2 = symbolBean.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String key = symbolBean.getKey();
        if (key != null) {
            databaseStatement.bindString(2, key);
        }
        String baseCurrency = symbolBean.getBaseCurrency();
        if (baseCurrency != null) {
            databaseStatement.bindString(3, baseCurrency);
        }
        String quoteCurrency = symbolBean.getQuoteCurrency();
        if (quoteCurrency != null) {
            databaseStatement.bindString(4, quoteCurrency);
        }
        String baseCurrencyDisplayName = symbolBean.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName != null) {
            databaseStatement.bindString(5, baseCurrencyDisplayName);
        }
        String quoteCurrencyDisplayName = symbolBean.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName != null) {
            databaseStatement.bindString(6, quoteCurrencyDisplayName);
        }
        databaseStatement.bindLong(7, (long) symbolBean.getSupportMargin());
        String symbol = symbolBean.getSymbol();
        if (symbol != null) {
            databaseStatement.bindString(8, symbol);
        }
        String symbolName = symbolBean.getSymbolName();
        if (symbolName != null) {
            databaseStatement.bindString(9, symbolName);
        }
        String symbolPartition = symbolBean.getSymbolPartition();
        if (symbolPartition != null) {
            databaseStatement.bindString(10, symbolPartition);
        }
        databaseStatement.bindLong(11, (long) symbolBean.getWeight());
        databaseStatement.bindLong(12, symbolBean.getTradeOpenAt());
        databaseStatement.bindLong(13, symbolBean.getTradeCloseAt());
        databaseStatement.bindLong(14, symbolBean.getVisibleOpenAt());
        databaseStatement.bindLong(15, symbolBean.getVisibleCloseAt());
        long j11 = 1;
        databaseStatement.bindLong(16, symbolBean.getVisitEnabled() ? 1 : 0);
        databaseStatement.bindLong(17, symbolBean.getCancelEnabled() ? 1 : 0);
        String state = symbolBean.getState();
        if (state != null) {
            databaseStatement.bindString(18, state);
        }
        databaseStatement.bindLong(19, symbolBean.getTradeEnableTimestamp());
        String suspendDesc = symbolBean.getSuspendDesc();
        if (suspendDesc != null) {
            databaseStatement.bindString(20, suspendDesc);
        }
        String transferBoardDesc = symbolBean.getTransferBoardDesc();
        if (transferBoardDesc != null) {
            databaseStatement.bindString(21, transferBoardDesc);
        }
        databaseStatement.bindLong(22, symbolBean.getWhiteEnabled() ? 1 : 0);
        databaseStatement.bindLong(23, symbolBean.getCountryDisabled() ? 1 : 0);
        String tags = symbolBean.getTags();
        if (tags != null) {
            databaseStatement.bindString(24, tags);
        }
        databaseStatement.bindLong(25, symbolBean.getGlobalVisible() ? 1 : 0);
        databaseStatement.bindLong(26, symbolBean.getIsTradeEnabled() ? 1 : 0);
        String withdrawRisk = symbolBean.getWithdrawRisk();
        if (withdrawRisk != null) {
            databaseStatement.bindString(27, withdrawRisk);
        }
        databaseStatement.bindLong(28, (long) symbolBean.getTradePricePrecision());
        databaseStatement.bindLong(29, (long) symbolBean.getTradeAmountPrecision());
        databaseStatement.bindLong(30, (long) symbolBean.getTradeTotalPrecision());
        databaseStatement.bindLong(31, (long) symbolBean.getFeePrecision());
        String superMarginLeverageRatio = symbolBean.getSuperMarginLeverageRatio();
        if (superMarginLeverageRatio != null) {
            databaseStatement.bindString(32, superMarginLeverageRatio);
        }
        String leverageRatio = symbolBean.getLeverageRatio();
        if (leverageRatio != null) {
            databaseStatement.bindString(33, leverageRatio);
        }
        String fundingLeverageRatio = symbolBean.getFundingLeverageRatio();
        if (fundingLeverageRatio != null) {
            databaseStatement.bindString(34, fundingLeverageRatio);
        }
        String etpLeverageRatio = symbolBean.getEtpLeverageRatio();
        if (etpLeverageRatio != null) {
            databaseStatement.bindString(35, etpLeverageRatio);
        }
        String direction = symbolBean.getDirection();
        if (direction != null) {
            databaseStatement.bindString(36, direction);
        }
        List<Partitions> partitions = symbolBean.getPartitions();
        if (partitions != null) {
            databaseStatement.bindString(37, this.f70622a.convertToDatabaseValue(partitions));
        }
        String caState = symbolBean.getCaState();
        if (caState != null) {
            databaseStatement.bindString(38, caState);
        }
        databaseStatement.bindLong(39, symbolBean.getCa1OpenAt());
        databaseStatement.bindLong(40, symbolBean.getCa1CloseAt());
        databaseStatement.bindLong(41, symbolBean.getCa2OpenAt());
        databaseStatement.bindLong(42, symbolBean.getCa2CloseAt());
        Long kycRestrictedTimeRange = symbolBean.getKycRestrictedTimeRange();
        if (kycRestrictedTimeRange != null) {
            databaseStatement.bindLong(43, kycRestrictedTimeRange.longValue());
        }
        if (!symbolBean.getKycRestrictedCountry()) {
            j11 = 0;
        }
        databaseStatement.bindLong(44, j11);
        databaseStatement.bindDouble(45, symbolBean.getMarketBuyPriceHigherThanCurrent());
        databaseStatement.bindDouble(46, symbolBean.getMarketSellPriceLowerThanCurrent());
    }

    /* renamed from: e */
    public Long getKey(SymbolBean symbolBean) {
        if (symbolBean != null) {
            return symbolBean.getId();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(SymbolBean symbolBean) {
        return symbolBean.getId() != null;
    }

    /* renamed from: g */
    public SymbolBean readEntity(Cursor cursor, int i11) {
        List<Partitions> list;
        long j11;
        Cursor cursor2 = cursor;
        int i12 = i11 + 0;
        Long valueOf = cursor2.isNull(i12) ? null : Long.valueOf(cursor2.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = i11 + 2;
        String string2 = cursor2.isNull(i14) ? null : cursor2.getString(i14);
        int i15 = i11 + 3;
        String string3 = cursor2.isNull(i15) ? null : cursor2.getString(i15);
        int i16 = i11 + 4;
        String string4 = cursor2.isNull(i16) ? null : cursor2.getString(i16);
        int i17 = i11 + 5;
        String string5 = cursor2.isNull(i17) ? null : cursor2.getString(i17);
        int i18 = cursor2.getInt(i11 + 6);
        int i19 = i11 + 7;
        String string6 = cursor2.isNull(i19) ? null : cursor2.getString(i19);
        int i21 = i11 + 8;
        String string7 = cursor2.isNull(i21) ? null : cursor2.getString(i21);
        int i22 = i11 + 9;
        String string8 = cursor2.isNull(i22) ? null : cursor2.getString(i22);
        int i23 = cursor2.getInt(i11 + 10);
        long j12 = cursor2.getLong(i11 + 11);
        long j13 = cursor2.getLong(i11 + 12);
        long j14 = cursor2.getLong(i11 + 13);
        long j15 = cursor2.getLong(i11 + 14);
        boolean z11 = cursor2.getShort(i11 + 15) != 0;
        boolean z12 = cursor2.getShort(i11 + 16) != 0;
        int i24 = i11 + 17;
        String string9 = cursor2.isNull(i24) ? null : cursor2.getString(i24);
        long j16 = cursor2.getLong(i11 + 18);
        int i25 = i11 + 19;
        String string10 = cursor2.isNull(i25) ? null : cursor2.getString(i25);
        int i26 = i11 + 20;
        String string11 = cursor2.isNull(i26) ? null : cursor2.getString(i26);
        boolean z13 = cursor2.getShort(i11 + 21) != 0;
        boolean z14 = cursor2.getShort(i11 + 22) != 0;
        int i27 = i11 + 23;
        String string12 = cursor2.isNull(i27) ? null : cursor2.getString(i27);
        boolean z15 = cursor2.getShort(i11 + 24) != 0;
        boolean z16 = cursor2.getShort(i11 + 25) != 0;
        int i28 = i11 + 26;
        String string13 = cursor2.isNull(i28) ? null : cursor2.getString(i28);
        int i29 = cursor2.getInt(i11 + 27);
        int i30 = cursor2.getInt(i11 + 28);
        int i31 = cursor2.getInt(i11 + 29);
        int i32 = cursor2.getInt(i11 + 30);
        int i33 = i11 + 31;
        String string14 = cursor2.isNull(i33) ? null : cursor2.getString(i33);
        int i34 = i11 + 32;
        String string15 = cursor2.isNull(i34) ? null : cursor2.getString(i34);
        int i35 = i11 + 33;
        String string16 = cursor2.isNull(i35) ? null : cursor2.getString(i35);
        int i36 = i11 + 34;
        String string17 = cursor2.isNull(i36) ? null : cursor2.getString(i36);
        int i37 = i11 + 35;
        String string18 = cursor2.isNull(i37) ? null : cursor2.getString(i37);
        int i38 = i11 + 36;
        if (cursor2.isNull(i38)) {
            list = null;
            j11 = j12;
        } else {
            j11 = j12;
            list = this.f70622a.convertToEntityProperty(cursor2.getString(i38));
        }
        int i39 = i11 + 37;
        String string19 = cursor2.isNull(i39) ? null : cursor2.getString(i39);
        int i40 = i11 + 42;
        return new SymbolBean(valueOf, string, string2, string3, string4, string5, i18, string6, string7, string8, i23, j11, j13, j14, j15, z11, z12, string9, j16, string10, string11, z13, z14, string12, z15, z16, string13, i29, i30, i31, i32, string14, string15, string16, string17, string18, list, string19, cursor2.getLong(i11 + 38), cursor2.getLong(i11 + 39), cursor2.getLong(i11 + 40), cursor2.getLong(i11 + 41), cursor2.isNull(i40) ? null : Long.valueOf(cursor2.getLong(i40)), cursor2.getShort(i11 + 43) != 0, cursor2.getDouble(i11 + 44), cursor2.getDouble(i11 + 45));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, SymbolBean symbolBean, int i11) {
        int i12 = i11 + 0;
        Long l11 = null;
        symbolBean.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        symbolBean.setKey(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        symbolBean.setBaseCurrency(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        symbolBean.setQuoteCurrency(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        symbolBean.setBaseCurrencyDisplayName(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 5;
        symbolBean.setQuoteCurrencyDisplayName(cursor.isNull(i17) ? null : cursor.getString(i17));
        symbolBean.setSupportMargin(cursor.getInt(i11 + 6));
        int i18 = i11 + 7;
        symbolBean.setSymbol(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i11 + 8;
        symbolBean.setSymbolName(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i21 = i11 + 9;
        symbolBean.setSymbolPartition(cursor.isNull(i21) ? null : cursor.getString(i21));
        symbolBean.setWeight(cursor.getInt(i11 + 10));
        symbolBean.setTradeOpenAt(cursor.getLong(i11 + 11));
        symbolBean.setTradeCloseAt(cursor.getLong(i11 + 12));
        symbolBean.setVisibleOpenAt(cursor.getLong(i11 + 13));
        symbolBean.setVisibleCloseAt(cursor.getLong(i11 + 14));
        boolean z11 = true;
        symbolBean.setVisitEnabled(cursor.getShort(i11 + 15) != 0);
        symbolBean.setCancelEnabled(cursor.getShort(i11 + 16) != 0);
        int i22 = i11 + 17;
        symbolBean.setState(cursor.isNull(i22) ? null : cursor.getString(i22));
        symbolBean.setTradeEnableTimestamp(cursor.getLong(i11 + 18));
        int i23 = i11 + 19;
        symbolBean.setSuspendDesc(cursor.isNull(i23) ? null : cursor.getString(i23));
        int i24 = i11 + 20;
        symbolBean.setTransferBoardDesc(cursor.isNull(i24) ? null : cursor.getString(i24));
        symbolBean.setWhiteEnabled(cursor.getShort(i11 + 21) != 0);
        symbolBean.setCountryDisabled(cursor.getShort(i11 + 22) != 0);
        int i25 = i11 + 23;
        symbolBean.setTags(cursor.isNull(i25) ? null : cursor.getString(i25));
        symbolBean.setGlobalVisible(cursor.getShort(i11 + 24) != 0);
        symbolBean.setIsTradeEnabled(cursor.getShort(i11 + 25) != 0);
        int i26 = i11 + 26;
        symbolBean.setWithdrawRisk(cursor.isNull(i26) ? null : cursor.getString(i26));
        symbolBean.setTradePricePrecision(cursor.getInt(i11 + 27));
        symbolBean.setTradeAmountPrecision(cursor.getInt(i11 + 28));
        symbolBean.setTradeTotalPrecision(cursor.getInt(i11 + 29));
        symbolBean.setFeePrecision(cursor.getInt(i11 + 30));
        int i27 = i11 + 31;
        symbolBean.setSuperMarginLeverageRatio(cursor.isNull(i27) ? null : cursor.getString(i27));
        int i28 = i11 + 32;
        symbolBean.setLeverageRatio(cursor.isNull(i28) ? null : cursor.getString(i28));
        int i29 = i11 + 33;
        symbolBean.setFundingLeverageRatio(cursor.isNull(i29) ? null : cursor.getString(i29));
        int i30 = i11 + 34;
        symbolBean.setEtpLeverageRatio(cursor.isNull(i30) ? null : cursor.getString(i30));
        int i31 = i11 + 35;
        symbolBean.setDirection(cursor.isNull(i31) ? null : cursor.getString(i31));
        int i32 = i11 + 36;
        symbolBean.setPartitions(cursor.isNull(i32) ? null : this.f70622a.convertToEntityProperty(cursor.getString(i32)));
        int i33 = i11 + 37;
        symbolBean.setCaState(cursor.isNull(i33) ? null : cursor.getString(i33));
        symbolBean.setCa1OpenAt(cursor.getLong(i11 + 38));
        symbolBean.setCa1CloseAt(cursor.getLong(i11 + 39));
        symbolBean.setCa2OpenAt(cursor.getLong(i11 + 40));
        symbolBean.setCa2CloseAt(cursor.getLong(i11 + 41));
        int i34 = i11 + 42;
        if (!cursor.isNull(i34)) {
            l11 = Long.valueOf(cursor.getLong(i34));
        }
        symbolBean.setKycRestrictedTimeRange(l11);
        if (cursor.getShort(i11 + 43) == 0) {
            z11 = false;
        }
        symbolBean.setKycRestrictedCountry(z11);
        symbolBean.setMarketBuyPriceHigherThanCurrent(cursor.getDouble(i11 + 44));
        symbolBean.setMarketSellPriceLowerThanCurrent(cursor.getDouble(i11 + 45));
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
    public final Long updateKeyAfterInsert(SymbolBean symbolBean, long j11) {
        symbolBean.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}

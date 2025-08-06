package com.hbg.lib.network.pro.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import z8.a;

public class ChainInfoDao extends AbstractDao<ChainInfo, String> {
    public static final String TABLENAME = "CHAIN_INFO";

    public static class Properties {
        public static final Property AddrOneoff;
        public static final Property AddrWithTag;
        public static final Property AddrdepositTag;
        public static final Property AddressChain = new Property(6, String.class, "addressChain", false, "ADDRESS_CHAIN");
        public static final Property Chain = new Property(4, String.class, "chain", true, "CHAIN");
        public static final Property ChainType = new Property(1, String.class, "chainType", false, "CHAIN_TYPE");
        public static final Property Code = new Property(14, String.class, "code", false, "CODE");
        public static final Property ContractAddress = new Property(3, String.class, "contractAddress", false, "CONTRACT_ADDRESS");
        public static final Property ContractChainType;
        public static final Property Currency = new Property(5, String.class, FirebaseAnalytics.Param.CURRENCY, false, "CURRENCY");
        public static final Property DepositDesc = new Property(23, String.class, "depositDesc", false, "DEPOSIT_DESC");
        public static final Property DepositEnable;
        public static final Property DepositMinAmount = new Property(8, String.class, "depositMinAmount", false, "DEPOSIT_MIN_AMOUNT");
        public static final Property DepositTipsDesc = new Property(32, String.class, "depositTipsDesc", false, "DEPOSIT_TIPS_DESC");
        public static final Property DisplayName = new Property(15, String.class, "displayName", false, "DISPLAY_NAME");
        public static final Property FastConfirms;
        public static final Property FeeType = new Property(13, String.class, "feeType", false, "FEE_TYPE");
        public static final Property FullName = new Property(16, String.class, "fullName", false, "FULL_NAME");
        public static final Property Id = new Property(0, Long.class, "id", false, "ID");
        public static final Property IsDefault;
        public static final Property ReplaceChainInfoDesc = new Property(29, String.class, "replaceChainInfoDesc", false, "REPLACE_CHAIN_INFO_DESC");
        public static final Property ReplaceChainNotificationDesc = new Property(30, String.class, "replaceChainNotificationDesc", false, "REPLACE_CHAIN_NOTIFICATION_DESC");
        public static final Property ReplaceChainPopupDesc = new Property(31, String.class, "replaceChainPopupDesc", false, "REPLACE_CHAIN_POPUP_DESC");
        public static final Property SafeConfirms;
        public static final Property SuspendDepositAnnouncement = new Property(27, String.class, "suspendDepositAnnouncement", false, "SUSPEND_DEPOSIT_ANNOUNCEMENT");
        public static final Property SuspendDepositDesc = new Property(25, String.class, "suspendDepositDesc", false, "SUSPEND_DEPOSIT_DESC");
        public static final Property SuspendWithdrawAnnouncement = new Property(28, String.class, "suspendWithdrawAnnouncement", false, "SUSPEND_WITHDRAW_ANNOUNCEMENT");
        public static final Property SuspendWithdrawDesc = new Property(26, String.class, "suspendWithdrawDesc", false, "SUSPEND_WITHDRAW_DESC");
        public static final Property Visible;
        public static final Property WithdrawDesc = new Property(24, String.class, "withdrawDesc", false, "WITHDRAW_DESC");
        public static final Property WithdrawEnable;
        public static final Property WithdrawMinAmount = new Property(9, String.class, "withdrawMinAmount", false, "WITHDRAW_MIN_AMOUNT");
        public static final Property WithdrawPrecision;
        public static final Property WithdrawTipsDesc = new Property(33, String.class, "withdrawTipsDesc", false, "WITHDRAW_TIPS_DESC");

        static {
            Class cls = Integer.TYPE;
            ContractChainType = new Property(2, cls, "contractChainType", false, "CONTRACT_CHAIN_TYPE");
            IsDefault = new Property(7, cls, "isDefault", false, "IS_DEFAULT");
            Class cls2 = Boolean.TYPE;
            DepositEnable = new Property(10, cls2, "depositEnable", false, "DEPOSIT_ENABLE");
            WithdrawEnable = new Property(11, cls2, "withdrawEnable", false, "WITHDRAW_ENABLE");
            WithdrawPrecision = new Property(12, cls, "withdrawPrecision", false, "WITHDRAW_PRECISION");
            Class cls3 = cls2;
            AddrWithTag = new Property(17, cls3, "addrWithTag", false, "ADDR_WITH_TAG");
            AddrdepositTag = new Property(18, cls3, "addrdepositTag", false, "ADDRDEPOSIT_TAG");
            AddrOneoff = new Property(19, cls3, "addrOneoff", false, "ADDR_ONEOFF");
            Class cls4 = cls;
            FastConfirms = new Property(20, cls4, "fastConfirms", false, "FAST_CONFIRMS");
            SafeConfirms = new Property(21, cls4, "safeConfirms", false, "SAFE_CONFIRMS");
            Visible = new Property(22, cls2, "visible", false, "VISIBLE");
        }
    }

    public ChainInfoDao(DaoConfig daoConfig, a aVar) {
        super(daoConfig, aVar);
    }

    public static void c(Database database, boolean z11) {
        String str = z11 ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"CHAIN_INFO\" (\"ID\" INTEGER,\"CHAIN_TYPE\" TEXT,\"CONTRACT_CHAIN_TYPE\" INTEGER NOT NULL ,\"CONTRACT_ADDRESS\" TEXT,\"CHAIN\" TEXT PRIMARY KEY NOT NULL ,\"CURRENCY\" TEXT,\"ADDRESS_CHAIN\" TEXT,\"IS_DEFAULT\" INTEGER NOT NULL ,\"DEPOSIT_MIN_AMOUNT\" TEXT,\"WITHDRAW_MIN_AMOUNT\" TEXT,\"DEPOSIT_ENABLE\" INTEGER NOT NULL ,\"WITHDRAW_ENABLE\" INTEGER NOT NULL ,\"WITHDRAW_PRECISION\" INTEGER NOT NULL ,\"FEE_TYPE\" TEXT,\"CODE\" TEXT,\"DISPLAY_NAME\" TEXT,\"FULL_NAME\" TEXT,\"ADDR_WITH_TAG\" INTEGER NOT NULL ,\"ADDRDEPOSIT_TAG\" INTEGER NOT NULL ,\"ADDR_ONEOFF\" INTEGER NOT NULL ,\"FAST_CONFIRMS\" INTEGER NOT NULL ,\"SAFE_CONFIRMS\" INTEGER NOT NULL ,\"VISIBLE\" INTEGER NOT NULL ,\"DEPOSIT_DESC\" TEXT,\"WITHDRAW_DESC\" TEXT,\"SUSPEND_DEPOSIT_DESC\" TEXT,\"SUSPEND_WITHDRAW_DESC\" TEXT,\"SUSPEND_DEPOSIT_ANNOUNCEMENT\" TEXT,\"SUSPEND_WITHDRAW_ANNOUNCEMENT\" TEXT,\"REPLACE_CHAIN_INFO_DESC\" TEXT,\"REPLACE_CHAIN_NOTIFICATION_DESC\" TEXT,\"REPLACE_CHAIN_POPUP_DESC\" TEXT,\"DEPOSIT_TIPS_DESC\" TEXT,\"WITHDRAW_TIPS_DESC\" TEXT);");
    }

    public static void d(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"CHAIN_INFO\"");
        database.execSQL(sb2.toString());
    }

    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, ChainInfo chainInfo) {
        sQLiteStatement.clearBindings();
        Long id2 = chainInfo.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String chainType = chainInfo.getChainType();
        if (chainType != null) {
            sQLiteStatement.bindString(2, chainType);
        }
        sQLiteStatement.bindLong(3, (long) chainInfo.getContractChainType());
        String contractAddress = chainInfo.getContractAddress();
        if (contractAddress != null) {
            sQLiteStatement.bindString(4, contractAddress);
        }
        String chain = chainInfo.getChain();
        if (chain != null) {
            sQLiteStatement.bindString(5, chain);
        }
        String currency = chainInfo.getCurrency();
        if (currency != null) {
            sQLiteStatement.bindString(6, currency);
        }
        String addressChain = chainInfo.getAddressChain();
        if (addressChain != null) {
            sQLiteStatement.bindString(7, addressChain);
        }
        sQLiteStatement.bindLong(8, (long) chainInfo.getIsDefault());
        String depositMinAmount = chainInfo.getDepositMinAmount();
        if (depositMinAmount != null) {
            sQLiteStatement.bindString(9, depositMinAmount);
        }
        String withdrawMinAmount = chainInfo.getWithdrawMinAmount();
        if (withdrawMinAmount != null) {
            sQLiteStatement.bindString(10, withdrawMinAmount);
        }
        long j11 = 1;
        sQLiteStatement.bindLong(11, chainInfo.getDepositEnable() ? 1 : 0);
        sQLiteStatement.bindLong(12, chainInfo.getWithdrawEnable() ? 1 : 0);
        sQLiteStatement.bindLong(13, (long) chainInfo.getWithdrawPrecision());
        String feeType = chainInfo.getFeeType();
        if (feeType != null) {
            sQLiteStatement.bindString(14, feeType);
        }
        String code = chainInfo.getCode();
        if (code != null) {
            sQLiteStatement.bindString(15, code);
        }
        String displayName = chainInfo.getDisplayName();
        if (displayName != null) {
            sQLiteStatement.bindString(16, displayName);
        }
        String fullName = chainInfo.getFullName();
        if (fullName != null) {
            sQLiteStatement.bindString(17, fullName);
        }
        sQLiteStatement.bindLong(18, chainInfo.getAddrWithTag() ? 1 : 0);
        sQLiteStatement.bindLong(19, chainInfo.getAddrdepositTag() ? 1 : 0);
        sQLiteStatement.bindLong(20, chainInfo.getAddrOneoff() ? 1 : 0);
        sQLiteStatement.bindLong(21, (long) chainInfo.getFastConfirms());
        sQLiteStatement.bindLong(22, (long) chainInfo.getSafeConfirms());
        if (!chainInfo.getVisible()) {
            j11 = 0;
        }
        sQLiteStatement.bindLong(23, j11);
        String depositDesc = chainInfo.getDepositDesc();
        if (depositDesc != null) {
            sQLiteStatement.bindString(24, depositDesc);
        }
        String withdrawDesc = chainInfo.getWithdrawDesc();
        if (withdrawDesc != null) {
            sQLiteStatement.bindString(25, withdrawDesc);
        }
        String suspendDepositDesc = chainInfo.getSuspendDepositDesc();
        if (suspendDepositDesc != null) {
            sQLiteStatement.bindString(26, suspendDepositDesc);
        }
        String suspendWithdrawDesc = chainInfo.getSuspendWithdrawDesc();
        if (suspendWithdrawDesc != null) {
            sQLiteStatement.bindString(27, suspendWithdrawDesc);
        }
        String suspendDepositAnnouncement = chainInfo.getSuspendDepositAnnouncement();
        if (suspendDepositAnnouncement != null) {
            sQLiteStatement.bindString(28, suspendDepositAnnouncement);
        }
        String suspendWithdrawAnnouncement = chainInfo.getSuspendWithdrawAnnouncement();
        if (suspendWithdrawAnnouncement != null) {
            sQLiteStatement.bindString(29, suspendWithdrawAnnouncement);
        }
        String replaceChainInfoDesc = chainInfo.getReplaceChainInfoDesc();
        if (replaceChainInfoDesc != null) {
            sQLiteStatement.bindString(30, replaceChainInfoDesc);
        }
        String replaceChainNotificationDesc = chainInfo.getReplaceChainNotificationDesc();
        if (replaceChainNotificationDesc != null) {
            sQLiteStatement.bindString(31, replaceChainNotificationDesc);
        }
        String replaceChainPopupDesc = chainInfo.getReplaceChainPopupDesc();
        if (replaceChainPopupDesc != null) {
            sQLiteStatement.bindString(32, replaceChainPopupDesc);
        }
        String depositTipsDesc = chainInfo.getDepositTipsDesc();
        if (depositTipsDesc != null) {
            sQLiteStatement.bindString(33, depositTipsDesc);
        }
        String withdrawTipsDesc = chainInfo.getWithdrawTipsDesc();
        if (withdrawTipsDesc != null) {
            sQLiteStatement.bindString(34, withdrawTipsDesc);
        }
    }

    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, ChainInfo chainInfo) {
        databaseStatement.clearBindings();
        Long id2 = chainInfo.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String chainType = chainInfo.getChainType();
        if (chainType != null) {
            databaseStatement.bindString(2, chainType);
        }
        databaseStatement.bindLong(3, (long) chainInfo.getContractChainType());
        String contractAddress = chainInfo.getContractAddress();
        if (contractAddress != null) {
            databaseStatement.bindString(4, contractAddress);
        }
        String chain = chainInfo.getChain();
        if (chain != null) {
            databaseStatement.bindString(5, chain);
        }
        String currency = chainInfo.getCurrency();
        if (currency != null) {
            databaseStatement.bindString(6, currency);
        }
        String addressChain = chainInfo.getAddressChain();
        if (addressChain != null) {
            databaseStatement.bindString(7, addressChain);
        }
        databaseStatement.bindLong(8, (long) chainInfo.getIsDefault());
        String depositMinAmount = chainInfo.getDepositMinAmount();
        if (depositMinAmount != null) {
            databaseStatement.bindString(9, depositMinAmount);
        }
        String withdrawMinAmount = chainInfo.getWithdrawMinAmount();
        if (withdrawMinAmount != null) {
            databaseStatement.bindString(10, withdrawMinAmount);
        }
        long j11 = 1;
        databaseStatement.bindLong(11, chainInfo.getDepositEnable() ? 1 : 0);
        databaseStatement.bindLong(12, chainInfo.getWithdrawEnable() ? 1 : 0);
        databaseStatement.bindLong(13, (long) chainInfo.getWithdrawPrecision());
        String feeType = chainInfo.getFeeType();
        if (feeType != null) {
            databaseStatement.bindString(14, feeType);
        }
        String code = chainInfo.getCode();
        if (code != null) {
            databaseStatement.bindString(15, code);
        }
        String displayName = chainInfo.getDisplayName();
        if (displayName != null) {
            databaseStatement.bindString(16, displayName);
        }
        String fullName = chainInfo.getFullName();
        if (fullName != null) {
            databaseStatement.bindString(17, fullName);
        }
        databaseStatement.bindLong(18, chainInfo.getAddrWithTag() ? 1 : 0);
        databaseStatement.bindLong(19, chainInfo.getAddrdepositTag() ? 1 : 0);
        databaseStatement.bindLong(20, chainInfo.getAddrOneoff() ? 1 : 0);
        databaseStatement.bindLong(21, (long) chainInfo.getFastConfirms());
        databaseStatement.bindLong(22, (long) chainInfo.getSafeConfirms());
        if (!chainInfo.getVisible()) {
            j11 = 0;
        }
        databaseStatement.bindLong(23, j11);
        String depositDesc = chainInfo.getDepositDesc();
        if (depositDesc != null) {
            databaseStatement.bindString(24, depositDesc);
        }
        String withdrawDesc = chainInfo.getWithdrawDesc();
        if (withdrawDesc != null) {
            databaseStatement.bindString(25, withdrawDesc);
        }
        String suspendDepositDesc = chainInfo.getSuspendDepositDesc();
        if (suspendDepositDesc != null) {
            databaseStatement.bindString(26, suspendDepositDesc);
        }
        String suspendWithdrawDesc = chainInfo.getSuspendWithdrawDesc();
        if (suspendWithdrawDesc != null) {
            databaseStatement.bindString(27, suspendWithdrawDesc);
        }
        String suspendDepositAnnouncement = chainInfo.getSuspendDepositAnnouncement();
        if (suspendDepositAnnouncement != null) {
            databaseStatement.bindString(28, suspendDepositAnnouncement);
        }
        String suspendWithdrawAnnouncement = chainInfo.getSuspendWithdrawAnnouncement();
        if (suspendWithdrawAnnouncement != null) {
            databaseStatement.bindString(29, suspendWithdrawAnnouncement);
        }
        String replaceChainInfoDesc = chainInfo.getReplaceChainInfoDesc();
        if (replaceChainInfoDesc != null) {
            databaseStatement.bindString(30, replaceChainInfoDesc);
        }
        String replaceChainNotificationDesc = chainInfo.getReplaceChainNotificationDesc();
        if (replaceChainNotificationDesc != null) {
            databaseStatement.bindString(31, replaceChainNotificationDesc);
        }
        String replaceChainPopupDesc = chainInfo.getReplaceChainPopupDesc();
        if (replaceChainPopupDesc != null) {
            databaseStatement.bindString(32, replaceChainPopupDesc);
        }
        String depositTipsDesc = chainInfo.getDepositTipsDesc();
        if (depositTipsDesc != null) {
            databaseStatement.bindString(33, depositTipsDesc);
        }
        String withdrawTipsDesc = chainInfo.getWithdrawTipsDesc();
        if (withdrawTipsDesc != null) {
            databaseStatement.bindString(34, withdrawTipsDesc);
        }
    }

    /* renamed from: e */
    public String getKey(ChainInfo chainInfo) {
        if (chainInfo != null) {
            return chainInfo.getChain();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(ChainInfo chainInfo) {
        return chainInfo.getChain() != null;
    }

    /* renamed from: g */
    public ChainInfo readEntity(Cursor cursor, int i11) {
        Cursor cursor2 = cursor;
        int i12 = i11 + 0;
        Long valueOf = cursor2.isNull(i12) ? null : Long.valueOf(cursor2.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor2.isNull(i13) ? null : cursor2.getString(i13);
        int i14 = cursor2.getInt(i11 + 2);
        int i15 = i11 + 3;
        String string2 = cursor2.isNull(i15) ? null : cursor2.getString(i15);
        int i16 = i11 + 4;
        String string3 = cursor2.isNull(i16) ? null : cursor2.getString(i16);
        int i17 = i11 + 5;
        String string4 = cursor2.isNull(i17) ? null : cursor2.getString(i17);
        int i18 = i11 + 6;
        String string5 = cursor2.isNull(i18) ? null : cursor2.getString(i18);
        int i19 = cursor2.getInt(i11 + 7);
        int i21 = i11 + 8;
        String string6 = cursor2.isNull(i21) ? null : cursor2.getString(i21);
        int i22 = i11 + 9;
        String string7 = cursor2.isNull(i22) ? null : cursor2.getString(i22);
        boolean z11 = cursor2.getShort(i11 + 10) != 0;
        boolean z12 = cursor2.getShort(i11 + 11) != 0;
        int i23 = cursor2.getInt(i11 + 12);
        int i24 = i11 + 13;
        String string8 = cursor2.isNull(i24) ? null : cursor2.getString(i24);
        int i25 = i11 + 14;
        String string9 = cursor2.isNull(i25) ? null : cursor2.getString(i25);
        int i26 = i11 + 15;
        String string10 = cursor2.isNull(i26) ? null : cursor2.getString(i26);
        int i27 = i11 + 16;
        String string11 = cursor2.isNull(i27) ? null : cursor2.getString(i27);
        boolean z13 = cursor2.getShort(i11 + 17) != 0;
        boolean z14 = cursor2.getShort(i11 + 18) != 0;
        boolean z15 = cursor2.getShort(i11 + 19) != 0;
        int i28 = cursor2.getInt(i11 + 20);
        int i29 = cursor2.getInt(i11 + 21);
        boolean z16 = cursor2.getShort(i11 + 22) != 0;
        int i30 = i11 + 23;
        String string12 = cursor2.isNull(i30) ? null : cursor2.getString(i30);
        int i31 = i11 + 24;
        String string13 = cursor2.isNull(i31) ? null : cursor2.getString(i31);
        int i32 = i11 + 25;
        String string14 = cursor2.isNull(i32) ? null : cursor2.getString(i32);
        int i33 = i11 + 26;
        String string15 = cursor2.isNull(i33) ? null : cursor2.getString(i33);
        int i34 = i11 + 27;
        String string16 = cursor2.isNull(i34) ? null : cursor2.getString(i34);
        int i35 = i11 + 28;
        String string17 = cursor2.isNull(i35) ? null : cursor2.getString(i35);
        int i36 = i11 + 29;
        String string18 = cursor2.isNull(i36) ? null : cursor2.getString(i36);
        int i37 = i11 + 30;
        String string19 = cursor2.isNull(i37) ? null : cursor2.getString(i37);
        int i38 = i11 + 31;
        String string20 = cursor2.isNull(i38) ? null : cursor2.getString(i38);
        int i39 = i11 + 32;
        String string21 = cursor2.isNull(i39) ? null : cursor2.getString(i39);
        int i40 = i11 + 33;
        return new ChainInfo(valueOf, string, i14, string2, string3, string4, string5, i19, string6, string7, z11, z12, i23, string8, string9, string10, string11, z13, z14, z15, i28, i29, z16, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, cursor2.isNull(i40) ? null : cursor2.getString(i40));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, ChainInfo chainInfo, int i11) {
        int i12 = i11 + 0;
        String str = null;
        chainInfo.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        chainInfo.setChainType(cursor.isNull(i13) ? null : cursor.getString(i13));
        chainInfo.setContractChainType(cursor.getInt(i11 + 2));
        int i14 = i11 + 3;
        chainInfo.setContractAddress(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 4;
        chainInfo.setChain(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 5;
        chainInfo.setCurrency(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 6;
        chainInfo.setAddressChain(cursor.isNull(i17) ? null : cursor.getString(i17));
        chainInfo.setIsDefault(cursor.getInt(i11 + 7));
        int i18 = i11 + 8;
        chainInfo.setDepositMinAmount(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i11 + 9;
        chainInfo.setWithdrawMinAmount(cursor.isNull(i19) ? null : cursor.getString(i19));
        boolean z11 = true;
        chainInfo.setDepositEnable(cursor.getShort(i11 + 10) != 0);
        chainInfo.setWithdrawEnable(cursor.getShort(i11 + 11) != 0);
        chainInfo.setWithdrawPrecision(cursor.getInt(i11 + 12));
        int i21 = i11 + 13;
        chainInfo.setFeeType(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i11 + 14;
        chainInfo.setCode(cursor.isNull(i22) ? null : cursor.getString(i22));
        int i23 = i11 + 15;
        chainInfo.setDisplayName(cursor.isNull(i23) ? null : cursor.getString(i23));
        int i24 = i11 + 16;
        chainInfo.setFullName(cursor.isNull(i24) ? null : cursor.getString(i24));
        chainInfo.setAddrWithTag(cursor.getShort(i11 + 17) != 0);
        chainInfo.setAddrdepositTag(cursor.getShort(i11 + 18) != 0);
        chainInfo.setAddrOneoff(cursor.getShort(i11 + 19) != 0);
        chainInfo.setFastConfirms(cursor.getInt(i11 + 20));
        chainInfo.setSafeConfirms(cursor.getInt(i11 + 21));
        if (cursor.getShort(i11 + 22) == 0) {
            z11 = false;
        }
        chainInfo.setVisible(z11);
        int i25 = i11 + 23;
        chainInfo.setDepositDesc(cursor.isNull(i25) ? null : cursor.getString(i25));
        int i26 = i11 + 24;
        chainInfo.setWithdrawDesc(cursor.isNull(i26) ? null : cursor.getString(i26));
        int i27 = i11 + 25;
        chainInfo.setSuspendDepositDesc(cursor.isNull(i27) ? null : cursor.getString(i27));
        int i28 = i11 + 26;
        chainInfo.setSuspendWithdrawDesc(cursor.isNull(i28) ? null : cursor.getString(i28));
        int i29 = i11 + 27;
        chainInfo.setSuspendDepositAnnouncement(cursor.isNull(i29) ? null : cursor.getString(i29));
        int i30 = i11 + 28;
        chainInfo.setSuspendWithdrawAnnouncement(cursor.isNull(i30) ? null : cursor.getString(i30));
        int i31 = i11 + 29;
        chainInfo.setReplaceChainInfoDesc(cursor.isNull(i31) ? null : cursor.getString(i31));
        int i32 = i11 + 30;
        chainInfo.setReplaceChainNotificationDesc(cursor.isNull(i32) ? null : cursor.getString(i32));
        int i33 = i11 + 31;
        chainInfo.setReplaceChainPopupDesc(cursor.isNull(i33) ? null : cursor.getString(i33));
        int i34 = i11 + 32;
        chainInfo.setDepositTipsDesc(cursor.isNull(i34) ? null : cursor.getString(i34));
        int i35 = i11 + 33;
        if (!cursor.isNull(i35)) {
            str = cursor.getString(i35);
        }
        chainInfo.setWithdrawTipsDesc(str);
    }

    /* renamed from: i */
    public String readKey(Cursor cursor, int i11) {
        int i12 = i11 + 4;
        if (cursor.isNull(i12)) {
            return null;
        }
        return cursor.getString(i12);
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    /* renamed from: j */
    public final String updateKeyAfterInsert(ChainInfo chainInfo, long j11) {
        return chainInfo.getChain();
    }
}

package com.hbg.lib.network.pro.core.bean;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import org.greenrobot.greendao.converter.PropertyConverter;

public class SymbolBean implements Serializable {
    public static final String ALTS = "alts";
    public static final String CA_1 = "ca_1";
    public static final String CA_2 = "ca_2";
    public static final String CRYPTO = "crypto";
    public static final String DIRECTION_LONG = "1";
    public static final String DIRECTION_SHORT = "2";
    private static final String ETP = "etp";
    public static final String FIAT = "fiat";
    public static final String FUSE = "fuse";
    public static final String GRID_DISABLED = "griddisabled";
    private static final String HAD = "had";
    private static final String HADAX = "hadax";
    private static final String HIDDEN = "hidden";
    private static final String INNOVATE = "innovate";
    public static final String NOT_ONLINE = "not-online";
    public static final String OFFLINE = "offline";
    public static final String ONLINE = "online";
    public static final String PIONEER = "pioneer";
    public static final String POTENTIALS = "potentials";
    public static final String PRE_ONLINE = "pre-online";
    private static final String PRIME = "prime";
    private static final String ST = "st";
    public static final String SUSPEND = "suspend";
    public static final String TAG_HIDDEN_UP = "hiddenup";
    public static final String TRANSFER_BOARD = "transfer-board";
    public static final String ZEROFEE = "zerofee";
    private static final long serialVersionUID = -6798145337323918917L;
    @SerializedName(alternate = {"base-currency"}, value = "bc")
    private String baseCurrency;
    @SerializedName("bcdn")
    private String baseCurrencyDisplayName;
    @SerializedName("ca1ca")
    private long ca1CloseAt;
    @SerializedName("ca1oa")
    private long ca1OpenAt;
    @SerializedName("ca2ca")
    private long ca2CloseAt;
    @SerializedName("ca2oa")
    private long ca2OpenAt;
    @SerializedName("castate")
    private String caState;
    @SerializedName("cancel_enabled")
    private boolean cancelEnabled;
    @SerializedName("cd")
    private boolean countryDisabled;
    @SerializedName("d")
    private String direction;
    @SerializedName("elr")
    private String etpLeverageRatio;
    @SerializedName("fp")
    private int feePrecision;
    @SerializedName("flr")
    private String fundingLeverageRatio;
    private boolean globalVisible = true;

    /* renamed from: id  reason: collision with root package name */
    private Long f70616id;
    @SerializedName("te")
    private boolean isTradeEnabled;
    private String key;
    @SerializedName("kycrc")
    private boolean kycRestrictedCountry;
    @SerializedName("kycrtr")
    private Long kycRestrictedTimeRange;
    @SerializedName("lr")
    private String leverageRatio;
    @SerializedName("mbph")
    private double marketBuyPriceHigherThanCurrent;
    @SerializedName("mspl")
    private double marketSellPriceLowerThanCurrent;
    @SerializedName("p")
    private List<Partitions> partitions;
    @SerializedName(alternate = {"quote-currency"}, value = "qc")
    private String quoteCurrency;
    @SerializedName("qcdn")
    private String quoteCurrencyDisplayName;
    private String state;
    @SerializedName("smlr")
    private String superMarginLeverageRatio;
    @SerializedName("sm")
    private int supportMargin;
    @SerializedName("suspend_desc")
    private String suspendDesc;
    @SerializedName(alternate = {"symbol"}, value = "sc")
    private String symbol;
    @SerializedName("dn")
    private String symbolName;
    @SerializedName(alternate = {"symbol-partition"}, value = "sp")
    private String symbolPartition;
    @SerializedName("tags")
    private String tags;
    @SerializedName("tap")
    private int tradeAmountPrecision;
    @SerializedName("trade_close_at")
    private long tradeCloseAt;
    @SerializedName("trade_enable_timestamp")
    private long tradeEnableTimestamp;
    @SerializedName("toa")
    private long tradeOpenAt;
    @SerializedName("tpp")
    private int tradePricePrecision;
    @SerializedName("ttp")
    private int tradeTotalPrecision;
    @SerializedName("transfer_boardDesc")
    private String transferBoardDesc;
    @SerializedName("visible_close_at")
    private long visibleCloseAt;
    @SerializedName("visible_open_at")
    private long visibleOpenAt;
    @SerializedName("visit_enabled")
    private boolean visitEnabled;
    @SerializedName("w")
    private int weight;
    @SerializedName("whe")
    private boolean whiteEnabled;
    @SerializedName("wr")
    private String withdrawRisk;

    public static class PartitionsListConverter implements PropertyConverter<List<Partitions>, String> {

        public class a extends TypeToken<List<Partitions>> {
            public a() {
            }
        }

        /* renamed from: a */
        public String convertToDatabaseValue(List<Partitions> list) {
            if (list == null) {
                return null;
            }
            return new Gson().toJson((Object) list);
        }

        /* renamed from: b */
        public List<Partitions> convertToEntityProperty(String str) {
            if (str == null) {
                return null;
            }
            return (List) new Gson().fromJson(str, new a().getType());
        }
    }

    public SymbolBean(Long l11, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, long j11, long j12, long j13, long j14, boolean z11, boolean z12, String str9, long j15, String str10, String str11, boolean z13, boolean z14, String str12, boolean z15, boolean z16, String str13, int i12, int i13, int i14, int i15, String str14, String str15, String str16, String str17, String str18) {
        this.f70616id = l11;
        this.key = str;
        this.baseCurrency = str2;
        this.quoteCurrency = str3;
        this.baseCurrencyDisplayName = str4;
        this.quoteCurrencyDisplayName = str5;
        this.symbol = str6;
        this.symbolName = str7;
        this.symbolPartition = str8;
        this.weight = i11;
        this.tradeOpenAt = j11;
        this.tradeCloseAt = j12;
        this.visibleOpenAt = j13;
        this.visibleCloseAt = j14;
        this.visitEnabled = z11;
        this.cancelEnabled = z12;
        this.state = str9;
        this.tradeEnableTimestamp = j15;
        this.suspendDesc = str10;
        this.transferBoardDesc = str11;
        this.whiteEnabled = z13;
        this.countryDisabled = z14;
        this.tags = str12;
        this.globalVisible = z15;
        this.isTradeEnabled = z16;
        this.withdrawRisk = str13;
        this.tradePricePrecision = i12;
        this.tradeAmountPrecision = i13;
        this.tradeTotalPrecision = i14;
        this.feePrecision = i15;
        this.superMarginLeverageRatio = str14;
        this.leverageRatio = str15;
        this.fundingLeverageRatio = str16;
        this.etpLeverageRatio = str17;
        this.direction = str18;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyDisplayName() {
        return this.baseCurrencyDisplayName;
    }

    public long getCa1CloseAt() {
        return this.ca1CloseAt;
    }

    public long getCa1OpenAt() {
        return this.ca1OpenAt;
    }

    public long getCa2CloseAt() {
        return this.ca2CloseAt;
    }

    public long getCa2OpenAt() {
        return this.ca2OpenAt;
    }

    public String getCaState() {
        return this.caState;
    }

    public boolean getCancelEnabled() {
        return this.cancelEnabled;
    }

    public boolean getCountryDisabled() {
        return this.countryDisabled;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getEtpLeverageRatio() {
        return this.etpLeverageRatio;
    }

    public int getFeePrecision() {
        return this.feePrecision;
    }

    public String getFundingLeverageRatio() {
        return this.fundingLeverageRatio;
    }

    public boolean getGlobalVisible() {
        return this.globalVisible;
    }

    public Long getId() {
        return this.f70616id;
    }

    public boolean getIsTradeEnabled() {
        return this.isTradeEnabled;
    }

    public String getKey() {
        return this.key;
    }

    public boolean getKycRestrictedCountry() {
        return this.kycRestrictedCountry;
    }

    public Long getKycRestrictedTimeRange() {
        return this.kycRestrictedTimeRange;
    }

    public String getLeverageRatio() {
        return this.leverageRatio;
    }

    public double getMarketBuyPriceHigherThanCurrent() {
        return this.marketBuyPriceHigherThanCurrent;
    }

    public double getMarketSellPriceLowerThanCurrent() {
        return this.marketSellPriceLowerThanCurrent;
    }

    public List<Partitions> getPartitions() {
        return this.partitions;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyDisplayName() {
        return this.quoteCurrencyDisplayName;
    }

    public String getState() {
        return this.state;
    }

    public String getSuperMarginLeverageRatio() {
        return this.superMarginLeverageRatio;
    }

    public int getSupportMargin() {
        return this.supportMargin;
    }

    public String getSuspendDesc() {
        return this.suspendDesc;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public String getSymbolPartition() {
        return this.symbolPartition;
    }

    public String getTags() {
        return this.tags;
    }

    public int getTradeAmountPrecision() {
        return this.tradeAmountPrecision;
    }

    public long getTradeCloseAt() {
        return this.tradeCloseAt;
    }

    public long getTradeEnableTimestamp() {
        return this.tradeEnableTimestamp;
    }

    public long getTradeOpenAt() {
        return this.tradeOpenAt;
    }

    public int getTradePricePrecision() {
        return this.tradePricePrecision;
    }

    public int getTradeTotalPrecision() {
        return this.tradeTotalPrecision;
    }

    public String getTransferBoardDesc() {
        return this.transferBoardDesc;
    }

    public long getVisibleCloseAt() {
        return this.visibleCloseAt;
    }

    public long getVisibleOpenAt() {
        return this.visibleOpenAt;
    }

    public boolean getVisitEnabled() {
        return this.visitEnabled;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean getWhiteEnabled() {
        return this.whiteEnabled;
    }

    public String getWithdrawRisk() {
        return this.withdrawRisk;
    }

    public boolean hasTag(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.tags)) {
            String[] split = this.tags.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String equalsIgnoreCase : split) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAltsTag() {
        return !TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(ALTS);
    }

    public boolean isCallAuction() {
        return isCallAuctionOne() || isCallAuctionTwo();
    }

    public boolean isCallAuctionOne() {
        return System.currentTimeMillis() >= this.ca1OpenAt && System.currentTimeMillis() <= this.ca1CloseAt;
    }

    public boolean isCallAuctionTwo() {
        return System.currentTimeMillis() >= this.ca2OpenAt && System.currentTimeMillis() <= this.ca2CloseAt;
    }

    public boolean isCanTrade() {
        boolean z11 = this.globalVisible && !isHiddenTag();
        if (OFFLINE.equals(this.state) || !z11) {
            return false;
        }
        return true;
    }

    public boolean isCancelEnabled() {
        return this.cancelEnabled;
    }

    public boolean isCountryDisabled() {
        return this.countryDisabled;
    }

    public boolean isCryptoTag() {
        return !TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(CRYPTO);
    }

    public boolean isEtpTag() {
        boolean z11;
        if (!TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(ETP)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int i11 = 0;
            while (true) {
                if (i11 >= split.length) {
                    break;
                } else if (ETP.equals(split[i11].toLowerCase(Locale.US))) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        z11 = false;
        boolean z12 = !TextUtils.isEmpty(this.etpLeverageRatio) && !TextUtils.isEmpty(this.direction);
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    public boolean isFiatTag() {
        return !TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains(FIAT);
    }

    public boolean isGlobalVisible() {
        return this.globalVisible;
    }

    public boolean isHadSt() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains(HAD)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if (HAD.equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHadaxTag() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains(HADAX)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if (HADAX.equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHiddenTag() {
        if (!TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains("hidden")) {
            String[] split = this.tags.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String equalsIgnoreCase : split) {
                if ("hidden".equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInWatchingPartition() {
        return POTENTIALS.equalsIgnoreCase(this.symbolPartition);
    }

    public boolean isInnovateTag() {
        if (!TextUtils.isEmpty(getTags()) && getTags().toLowerCase(Locale.US).contains(INNOVATE)) {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String lowerCase : split) {
                if (INNOVATE.equals(lowerCase.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isIsTradeEnabled() {
        return this.isTradeEnabled;
    }

    public boolean isPioneer() {
        return PIONEER.equalsIgnoreCase(this.symbolPartition);
    }

    public boolean isPrimeTag() {
        if (!TextUtils.isEmpty(this.tags) && this.tags.toLowerCase(Locale.US).contains("prime")) {
            String[] split = this.tags.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String equalsIgnoreCase : split) {
                if ("prime".equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStTag() {
        boolean z11;
        if (TextUtils.isEmpty(getTags()) || !getTags().toLowerCase(Locale.US).contains("st")) {
            z11 = false;
        } else {
            String[] split = getTags().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            z11 = false;
            for (String lowerCase : split) {
                if ("st".equals(lowerCase.toLowerCase(Locale.US))) {
                    z11 = true;
                }
            }
        }
        if (!(z11 || "st".equalsIgnoreCase(this.symbolPartition)) || isEtpTag()) {
            return false;
        }
        return true;
    }

    public boolean isVisitEnabled() {
        return this.visitEnabled;
    }

    public boolean isWhiteEnabled() {
        return this.whiteEnabled;
    }

    public boolean isZerofeeTag() {
        if (TextUtils.isEmpty(this.tags) || !this.tags.toLowerCase(Locale.US).contains(ZEROFEE)) {
            return false;
        }
        String[] split = this.tags.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (String lowerCase : split) {
            if (ZEROFEE.equals(lowerCase.toLowerCase(Locale.US))) {
                return true;
            }
        }
        return false;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyDisplayName(String str) {
        this.baseCurrencyDisplayName = str;
    }

    public void setCa1CloseAt(long j11) {
        this.ca1CloseAt = j11;
    }

    public void setCa1OpenAt(long j11) {
        this.ca1OpenAt = j11;
    }

    public void setCa2CloseAt(long j11) {
        this.ca2CloseAt = j11;
    }

    public void setCa2OpenAt(long j11) {
        this.ca2OpenAt = j11;
    }

    public void setCaState(String str) {
        this.caState = str;
    }

    public void setCancelEnabled(boolean z11) {
        this.cancelEnabled = z11;
    }

    public void setCountryDisabled(boolean z11) {
        this.countryDisabled = z11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setEtpLeverageRatio(String str) {
        this.etpLeverageRatio = str;
    }

    public void setFeePrecision(int i11) {
        this.feePrecision = i11;
    }

    public void setFundingLeverageRatio(String str) {
        this.fundingLeverageRatio = str;
    }

    public void setGlobalVisible(boolean z11) {
        this.globalVisible = z11;
    }

    public void setId(Long l11) {
        this.f70616id = l11;
    }

    public void setIsTradeEnabled(boolean z11) {
        this.isTradeEnabled = z11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKycRestrictedCountry(boolean z11) {
        this.kycRestrictedCountry = z11;
    }

    public void setKycRestrictedTimeRange(Long l11) {
        this.kycRestrictedTimeRange = l11;
    }

    public void setLeverageRatio(String str) {
        this.leverageRatio = str;
    }

    public void setMarketBuyPriceHigherThanCurrent(double d11) {
        this.marketBuyPriceHigherThanCurrent = d11;
    }

    public void setMarketSellPriceLowerThanCurrent(double d11) {
        this.marketSellPriceLowerThanCurrent = d11;
    }

    public void setPartitions(List<Partitions> list) {
        this.partitions = list;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyDisplayName(String str) {
        this.quoteCurrencyDisplayName = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSuperMarginLeverageRatio(String str) {
        this.superMarginLeverageRatio = str;
    }

    public void setSupportMargin(int i11) {
        this.supportMargin = i11;
    }

    public void setSuspendDesc(String str) {
        this.suspendDesc = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public void setSymbolPartition(String str) {
        this.symbolPartition = str;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setTradeAmountPrecision(int i11) {
        this.tradeAmountPrecision = i11;
    }

    public void setTradeCloseAt(long j11) {
        this.tradeCloseAt = j11;
    }

    public void setTradeEnableTimestamp(long j11) {
        this.tradeEnableTimestamp = j11;
    }

    public void setTradeOpenAt(long j11) {
        this.tradeOpenAt = j11;
    }

    public void setTradePricePrecision(int i11) {
        this.tradePricePrecision = i11;
    }

    public void setTradeTotalPrecision(int i11) {
        this.tradeTotalPrecision = i11;
    }

    public void setTransferBoardDesc(String str) {
        this.transferBoardDesc = str;
    }

    public void setVisibleCloseAt(long j11) {
        this.visibleCloseAt = j11;
    }

    public void setVisibleOpenAt(long j11) {
        this.visibleOpenAt = j11;
    }

    public void setVisitEnabled(boolean z11) {
        this.visitEnabled = z11;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public void setWhiteEnabled(boolean z11) {
        this.whiteEnabled = z11;
    }

    public void setWithdrawRisk(String str) {
        this.withdrawRisk = str;
    }

    public SymbolBean() {
    }

    public SymbolBean(Long l11, String str, String str2, String str3, String str4, String str5, int i11, String str6, String str7, String str8, int i12, long j11, long j12, long j13, long j14, boolean z11, boolean z12, String str9, long j15, String str10, String str11, boolean z13, boolean z14, String str12, boolean z15, boolean z16, String str13, int i13, int i14, int i15, int i16, String str14, String str15, String str16, String str17, String str18, List<Partitions> list, String str19, long j16, long j17, long j18, long j19, Long l12, boolean z17, double d11, double d12) {
        this.f70616id = l11;
        this.key = str;
        this.baseCurrency = str2;
        this.quoteCurrency = str3;
        this.baseCurrencyDisplayName = str4;
        this.quoteCurrencyDisplayName = str5;
        this.supportMargin = i11;
        this.symbol = str6;
        this.symbolName = str7;
        this.symbolPartition = str8;
        this.weight = i12;
        this.tradeOpenAt = j11;
        this.tradeCloseAt = j12;
        this.visibleOpenAt = j13;
        this.visibleCloseAt = j14;
        this.visitEnabled = z11;
        this.cancelEnabled = z12;
        this.state = str9;
        this.tradeEnableTimestamp = j15;
        this.suspendDesc = str10;
        this.transferBoardDesc = str11;
        this.whiteEnabled = z13;
        this.countryDisabled = z14;
        this.tags = str12;
        this.globalVisible = z15;
        this.isTradeEnabled = z16;
        this.withdrawRisk = str13;
        this.tradePricePrecision = i13;
        this.tradeAmountPrecision = i14;
        this.tradeTotalPrecision = i15;
        this.feePrecision = i16;
        this.superMarginLeverageRatio = str14;
        this.leverageRatio = str15;
        this.fundingLeverageRatio = str16;
        this.etpLeverageRatio = str17;
        this.direction = str18;
        this.partitions = list;
        this.caState = str19;
        this.ca1OpenAt = j16;
        this.ca1CloseAt = j17;
        this.ca2OpenAt = j18;
        this.ca2CloseAt = j19;
        this.kycRestrictedTimeRange = l12;
        this.kycRestrictedCountry = z17;
        this.marketBuyPriceHigherThanCurrent = d11;
        this.marketSellPriceLowerThanCurrent = d12;
    }
}

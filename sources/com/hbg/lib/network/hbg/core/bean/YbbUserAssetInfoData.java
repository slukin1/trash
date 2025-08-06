package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class YbbUserAssetInfoData implements Serializable {
    @SerializedName("convertCurrency")
    private String convertCurrency;
    private Map<String, DetailsDTO> currencyItemMap;
    @SerializedName("details")
    private List<DetailsDTO> details;
    @SerializedName("digitalAssetTotalAmountByConvertCurrency")
    private String digitalAssetTotalAmountByConvertCurrency;
    @SerializedName("digitalIncomeTodayAmountByConvertCurrency")
    private String digitalIncomeTodayAmountByConvertCurrency;
    @SerializedName("digitalIncomeTotalAmountByConvertCurrency")
    private String digitalIncomeTotalAmountByConvertCurrency;
    @SerializedName("digitalIncomeYesterdayAmountByConvertCurrency")
    private String digitalIncomeYesterdayAmountByConvertCurrency;

    public static class DetailsDTO implements Serializable {
        @SerializedName("digitalAssetTotalAmount")
        private String digitalAssetTotalAmount;
        @SerializedName("digitalCurrency")
        private String digitalCurrency;
        @SerializedName("digitalIncomeTodayAmount")
        private String digitalIncomeTodayAmount;
        @SerializedName("digitalIncomeTotalAmount")
        private String digitalIncomeTotalAmount;
        @SerializedName("digitalIncomeYesterdayAmount")
        private String digitalIncomeYesterdayAmount;

        public DetailsDTO() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof DetailsDTO;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DetailsDTO)) {
                return false;
            }
            DetailsDTO detailsDTO = (DetailsDTO) obj;
            if (!detailsDTO.canEqual(this)) {
                return false;
            }
            String digitalCurrency2 = getDigitalCurrency();
            String digitalCurrency3 = detailsDTO.getDigitalCurrency();
            if (digitalCurrency2 != null ? !digitalCurrency2.equals(digitalCurrency3) : digitalCurrency3 != null) {
                return false;
            }
            String digitalAssetTotalAmount2 = getDigitalAssetTotalAmount();
            String digitalAssetTotalAmount3 = detailsDTO.getDigitalAssetTotalAmount();
            if (digitalAssetTotalAmount2 != null ? !digitalAssetTotalAmount2.equals(digitalAssetTotalAmount3) : digitalAssetTotalAmount3 != null) {
                return false;
            }
            String digitalIncomeTotalAmount2 = getDigitalIncomeTotalAmount();
            String digitalIncomeTotalAmount3 = detailsDTO.getDigitalIncomeTotalAmount();
            if (digitalIncomeTotalAmount2 != null ? !digitalIncomeTotalAmount2.equals(digitalIncomeTotalAmount3) : digitalIncomeTotalAmount3 != null) {
                return false;
            }
            String digitalIncomeYesterdayAmount2 = getDigitalIncomeYesterdayAmount();
            String digitalIncomeYesterdayAmount3 = detailsDTO.getDigitalIncomeYesterdayAmount();
            if (digitalIncomeYesterdayAmount2 != null ? !digitalIncomeYesterdayAmount2.equals(digitalIncomeYesterdayAmount3) : digitalIncomeYesterdayAmount3 != null) {
                return false;
            }
            String digitalIncomeTodayAmount2 = getDigitalIncomeTodayAmount();
            String digitalIncomeTodayAmount3 = detailsDTO.getDigitalIncomeTodayAmount();
            return digitalIncomeTodayAmount2 != null ? digitalIncomeTodayAmount2.equals(digitalIncomeTodayAmount3) : digitalIncomeTodayAmount3 == null;
        }

        public String getDigitalAssetTotalAmount() {
            return this.digitalAssetTotalAmount;
        }

        public String getDigitalCurrency() {
            return this.digitalCurrency;
        }

        public String getDigitalIncomeTodayAmount() {
            return this.digitalIncomeTodayAmount;
        }

        public String getDigitalIncomeTotalAmount() {
            return this.digitalIncomeTotalAmount;
        }

        public String getDigitalIncomeYesterdayAmount() {
            return this.digitalIncomeYesterdayAmount;
        }

        public int hashCode() {
            String digitalCurrency2 = getDigitalCurrency();
            int i11 = 43;
            int hashCode = digitalCurrency2 == null ? 43 : digitalCurrency2.hashCode();
            String digitalAssetTotalAmount2 = getDigitalAssetTotalAmount();
            int hashCode2 = ((hashCode + 59) * 59) + (digitalAssetTotalAmount2 == null ? 43 : digitalAssetTotalAmount2.hashCode());
            String digitalIncomeTotalAmount2 = getDigitalIncomeTotalAmount();
            int hashCode3 = (hashCode2 * 59) + (digitalIncomeTotalAmount2 == null ? 43 : digitalIncomeTotalAmount2.hashCode());
            String digitalIncomeYesterdayAmount2 = getDigitalIncomeYesterdayAmount();
            int hashCode4 = (hashCode3 * 59) + (digitalIncomeYesterdayAmount2 == null ? 43 : digitalIncomeYesterdayAmount2.hashCode());
            String digitalIncomeTodayAmount2 = getDigitalIncomeTodayAmount();
            int i12 = hashCode4 * 59;
            if (digitalIncomeTodayAmount2 != null) {
                i11 = digitalIncomeTodayAmount2.hashCode();
            }
            return i12 + i11;
        }

        public void setDigitalAssetTotalAmount(String str) {
            this.digitalAssetTotalAmount = str;
        }

        public void setDigitalCurrency(String str) {
            this.digitalCurrency = str;
        }

        public void setDigitalIncomeTodayAmount(String str) {
            this.digitalIncomeTodayAmount = str;
        }

        public void setDigitalIncomeTotalAmount(String str) {
            this.digitalIncomeTotalAmount = str;
        }

        public void setDigitalIncomeYesterdayAmount(String str) {
            this.digitalIncomeYesterdayAmount = str;
        }

        public String toString() {
            return "YbbUserAssetInfoData.DetailsDTO(digitalCurrency=" + getDigitalCurrency() + ", digitalAssetTotalAmount=" + getDigitalAssetTotalAmount() + ", digitalIncomeTotalAmount=" + getDigitalIncomeTotalAmount() + ", digitalIncomeYesterdayAmount=" + getDigitalIncomeYesterdayAmount() + ", digitalIncomeTodayAmount=" + getDigitalIncomeTodayAmount() + ")";
        }

        public DetailsDTO(String str, String str2, String str3, String str4, String str5) {
            this.digitalCurrency = str;
            this.digitalAssetTotalAmount = str2;
            this.digitalIncomeTotalAmount = str3;
            this.digitalIncomeYesterdayAmount = str4;
            this.digitalIncomeTodayAmount = str5;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof YbbUserAssetInfoData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof YbbUserAssetInfoData)) {
            return false;
        }
        YbbUserAssetInfoData ybbUserAssetInfoData = (YbbUserAssetInfoData) obj;
        if (!ybbUserAssetInfoData.canEqual(this)) {
            return false;
        }
        String convertCurrency2 = getConvertCurrency();
        String convertCurrency3 = ybbUserAssetInfoData.getConvertCurrency();
        if (convertCurrency2 != null ? !convertCurrency2.equals(convertCurrency3) : convertCurrency3 != null) {
            return false;
        }
        String digitalAssetTotalAmountByConvertCurrency2 = getDigitalAssetTotalAmountByConvertCurrency();
        String digitalAssetTotalAmountByConvertCurrency3 = ybbUserAssetInfoData.getDigitalAssetTotalAmountByConvertCurrency();
        if (digitalAssetTotalAmountByConvertCurrency2 != null ? !digitalAssetTotalAmountByConvertCurrency2.equals(digitalAssetTotalAmountByConvertCurrency3) : digitalAssetTotalAmountByConvertCurrency3 != null) {
            return false;
        }
        String digitalIncomeTotalAmountByConvertCurrency2 = getDigitalIncomeTotalAmountByConvertCurrency();
        String digitalIncomeTotalAmountByConvertCurrency3 = ybbUserAssetInfoData.getDigitalIncomeTotalAmountByConvertCurrency();
        if (digitalIncomeTotalAmountByConvertCurrency2 != null ? !digitalIncomeTotalAmountByConvertCurrency2.equals(digitalIncomeTotalAmountByConvertCurrency3) : digitalIncomeTotalAmountByConvertCurrency3 != null) {
            return false;
        }
        String digitalIncomeYesterdayAmountByConvertCurrency2 = getDigitalIncomeYesterdayAmountByConvertCurrency();
        String digitalIncomeYesterdayAmountByConvertCurrency3 = ybbUserAssetInfoData.getDigitalIncomeYesterdayAmountByConvertCurrency();
        if (digitalIncomeYesterdayAmountByConvertCurrency2 != null ? !digitalIncomeYesterdayAmountByConvertCurrency2.equals(digitalIncomeYesterdayAmountByConvertCurrency3) : digitalIncomeYesterdayAmountByConvertCurrency3 != null) {
            return false;
        }
        String digitalIncomeTodayAmountByConvertCurrency2 = getDigitalIncomeTodayAmountByConvertCurrency();
        String digitalIncomeTodayAmountByConvertCurrency3 = ybbUserAssetInfoData.getDigitalIncomeTodayAmountByConvertCurrency();
        if (digitalIncomeTodayAmountByConvertCurrency2 != null ? !digitalIncomeTodayAmountByConvertCurrency2.equals(digitalIncomeTodayAmountByConvertCurrency3) : digitalIncomeTodayAmountByConvertCurrency3 != null) {
            return false;
        }
        Map<String, DetailsDTO> currencyItemMap2 = getCurrencyItemMap();
        Map<String, DetailsDTO> currencyItemMap3 = ybbUserAssetInfoData.getCurrencyItemMap();
        if (currencyItemMap2 != null ? !currencyItemMap2.equals(currencyItemMap3) : currencyItemMap3 != null) {
            return false;
        }
        List<DetailsDTO> details2 = getDetails();
        List<DetailsDTO> details3 = ybbUserAssetInfoData.getDetails();
        return details2 != null ? details2.equals(details3) : details3 == null;
    }

    public String getConvertCurrency() {
        return this.convertCurrency;
    }

    public Map<String, DetailsDTO> getCurrencyItemMap() {
        return this.currencyItemMap;
    }

    public List<DetailsDTO> getDetails() {
        return this.details;
    }

    public String getDigitalAssetTotalAmountByConvertCurrency() {
        return this.digitalAssetTotalAmountByConvertCurrency;
    }

    public String getDigitalIncomeTodayAmountByConvertCurrency() {
        return this.digitalIncomeTodayAmountByConvertCurrency;
    }

    public String getDigitalIncomeTotalAmountByConvertCurrency() {
        return this.digitalIncomeTotalAmountByConvertCurrency;
    }

    public String getDigitalIncomeYesterdayAmountByConvertCurrency() {
        return this.digitalIncomeYesterdayAmountByConvertCurrency;
    }

    public int hashCode() {
        String convertCurrency2 = getConvertCurrency();
        int i11 = 43;
        int hashCode = convertCurrency2 == null ? 43 : convertCurrency2.hashCode();
        String digitalAssetTotalAmountByConvertCurrency2 = getDigitalAssetTotalAmountByConvertCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (digitalAssetTotalAmountByConvertCurrency2 == null ? 43 : digitalAssetTotalAmountByConvertCurrency2.hashCode());
        String digitalIncomeTotalAmountByConvertCurrency2 = getDigitalIncomeTotalAmountByConvertCurrency();
        int hashCode3 = (hashCode2 * 59) + (digitalIncomeTotalAmountByConvertCurrency2 == null ? 43 : digitalIncomeTotalAmountByConvertCurrency2.hashCode());
        String digitalIncomeYesterdayAmountByConvertCurrency2 = getDigitalIncomeYesterdayAmountByConvertCurrency();
        int hashCode4 = (hashCode3 * 59) + (digitalIncomeYesterdayAmountByConvertCurrency2 == null ? 43 : digitalIncomeYesterdayAmountByConvertCurrency2.hashCode());
        String digitalIncomeTodayAmountByConvertCurrency2 = getDigitalIncomeTodayAmountByConvertCurrency();
        int hashCode5 = (hashCode4 * 59) + (digitalIncomeTodayAmountByConvertCurrency2 == null ? 43 : digitalIncomeTodayAmountByConvertCurrency2.hashCode());
        Map<String, DetailsDTO> currencyItemMap2 = getCurrencyItemMap();
        int hashCode6 = (hashCode5 * 59) + (currencyItemMap2 == null ? 43 : currencyItemMap2.hashCode());
        List<DetailsDTO> details2 = getDetails();
        int i12 = hashCode6 * 59;
        if (details2 != null) {
            i11 = details2.hashCode();
        }
        return i12 + i11;
    }

    public void setConvertCurrency(String str) {
        this.convertCurrency = str;
    }

    public void setCurrencyItemMap(Map<String, DetailsDTO> map) {
        this.currencyItemMap = map;
    }

    public void setDetails(List<DetailsDTO> list) {
        this.details = list;
    }

    public void setDigitalAssetTotalAmountByConvertCurrency(String str) {
        this.digitalAssetTotalAmountByConvertCurrency = str;
    }

    public void setDigitalIncomeTodayAmountByConvertCurrency(String str) {
        this.digitalIncomeTodayAmountByConvertCurrency = str;
    }

    public void setDigitalIncomeTotalAmountByConvertCurrency(String str) {
        this.digitalIncomeTotalAmountByConvertCurrency = str;
    }

    public void setDigitalIncomeYesterdayAmountByConvertCurrency(String str) {
        this.digitalIncomeYesterdayAmountByConvertCurrency = str;
    }

    public String toString() {
        return "YbbUserAssetInfoData(convertCurrency=" + getConvertCurrency() + ", digitalAssetTotalAmountByConvertCurrency=" + getDigitalAssetTotalAmountByConvertCurrency() + ", digitalIncomeTotalAmountByConvertCurrency=" + getDigitalIncomeTotalAmountByConvertCurrency() + ", digitalIncomeYesterdayAmountByConvertCurrency=" + getDigitalIncomeYesterdayAmountByConvertCurrency() + ", digitalIncomeTodayAmountByConvertCurrency=" + getDigitalIncomeTodayAmountByConvertCurrency() + ", currencyItemMap=" + getCurrencyItemMap() + ", details=" + getDetails() + ")";
    }
}

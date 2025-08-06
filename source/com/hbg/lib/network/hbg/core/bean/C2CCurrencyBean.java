package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.pro.core.util.Period;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class C2CCurrencyBean implements Serializable {
    private String currency;
    private boolean enable;
    private List<String> interestRate;
    private String loanMaxAmount;
    private String loanMinAmount;
    private String maxInterestRate;
    private String minInterestRate;
    private Long term;
    private List<Long> termConfigs;
    private String weight;

    public static int getTermDay(Long l11) {
        if (l11 == null) {
            return 0;
        }
        try {
            return (int) (l11.longValue() / Period.DAY_MILLS);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof C2CCurrencyBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CCurrencyBean)) {
            return false;
        }
        C2CCurrencyBean c2CCurrencyBean = (C2CCurrencyBean) obj;
        if (!c2CCurrencyBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CCurrencyBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (isEnable() != c2CCurrencyBean.isEnable()) {
            return false;
        }
        String loanMaxAmount2 = getLoanMaxAmount();
        String loanMaxAmount3 = c2CCurrencyBean.getLoanMaxAmount();
        if (loanMaxAmount2 != null ? !loanMaxAmount2.equals(loanMaxAmount3) : loanMaxAmount3 != null) {
            return false;
        }
        String loanMinAmount2 = getLoanMinAmount();
        String loanMinAmount3 = c2CCurrencyBean.getLoanMinAmount();
        if (loanMinAmount2 != null ? !loanMinAmount2.equals(loanMinAmount3) : loanMinAmount3 != null) {
            return false;
        }
        Long term2 = getTerm();
        Long term3 = c2CCurrencyBean.getTerm();
        if (term2 != null ? !term2.equals(term3) : term3 != null) {
            return false;
        }
        List<Long> termConfigs2 = getTermConfigs();
        List<Long> termConfigs3 = c2CCurrencyBean.getTermConfigs();
        if (termConfigs2 != null ? !termConfigs2.equals(termConfigs3) : termConfigs3 != null) {
            return false;
        }
        List<String> interestRate2 = getInterestRate();
        List<String> interestRate3 = c2CCurrencyBean.getInterestRate();
        if (interestRate2 != null ? !interestRate2.equals(interestRate3) : interestRate3 != null) {
            return false;
        }
        String weight2 = getWeight();
        String weight3 = c2CCurrencyBean.getWeight();
        if (weight2 != null ? !weight2.equals(weight3) : weight3 != null) {
            return false;
        }
        String maxInterestRate2 = getMaxInterestRate();
        String maxInterestRate3 = c2CCurrencyBean.getMaxInterestRate();
        if (maxInterestRate2 != null ? !maxInterestRate2.equals(maxInterestRate3) : maxInterestRate3 != null) {
            return false;
        }
        String minInterestRate2 = getMinInterestRate();
        String minInterestRate3 = c2CCurrencyBean.getMinInterestRate();
        return minInterestRate2 != null ? minInterestRate2.equals(minInterestRate3) : minInterestRate3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public List<String> getInterestRate() {
        return this.interestRate;
    }

    public String getLoanMaxAmount() {
        return this.loanMaxAmount;
    }

    public String getLoanMinAmount() {
        return this.loanMinAmount;
    }

    public String getMaxInterestRate() {
        return this.maxInterestRate;
    }

    public String getMinInterestRate() {
        return this.minInterestRate;
    }

    public int getPrecision() {
        return 3;
    }

    public Long getTerm() {
        return this.term;
    }

    public List<Long> getTermConfigs() {
        return this.termConfigs;
    }

    public List<Integer> getTermDayConfigs() {
        ArrayList arrayList = new ArrayList();
        List<Long> termConfigs2 = getTermConfigs();
        if (termConfigs2 != null) {
            for (Long termDay : termConfigs2) {
                arrayList.add(Integer.valueOf(getTermDay(termDay)));
            }
        }
        return arrayList;
    }

    public String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = (((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + (isEnable() ? 79 : 97);
        String loanMaxAmount2 = getLoanMaxAmount();
        int hashCode2 = (hashCode * 59) + (loanMaxAmount2 == null ? 43 : loanMaxAmount2.hashCode());
        String loanMinAmount2 = getLoanMinAmount();
        int hashCode3 = (hashCode2 * 59) + (loanMinAmount2 == null ? 43 : loanMinAmount2.hashCode());
        Long term2 = getTerm();
        int hashCode4 = (hashCode3 * 59) + (term2 == null ? 43 : term2.hashCode());
        List<Long> termConfigs2 = getTermConfigs();
        int hashCode5 = (hashCode4 * 59) + (termConfigs2 == null ? 43 : termConfigs2.hashCode());
        List<String> interestRate2 = getInterestRate();
        int hashCode6 = (hashCode5 * 59) + (interestRate2 == null ? 43 : interestRate2.hashCode());
        String weight2 = getWeight();
        int hashCode7 = (hashCode6 * 59) + (weight2 == null ? 43 : weight2.hashCode());
        String maxInterestRate2 = getMaxInterestRate();
        int hashCode8 = (hashCode7 * 59) + (maxInterestRate2 == null ? 43 : maxInterestRate2.hashCode());
        String minInterestRate2 = getMinInterestRate();
        int i12 = hashCode8 * 59;
        if (minInterestRate2 != null) {
            i11 = minInterestRate2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEnable(boolean z11) {
        this.enable = z11;
    }

    public void setInterestRate(List<String> list) {
        this.interestRate = list;
    }

    public void setLoanMaxAmount(String str) {
        this.loanMaxAmount = str;
    }

    public void setLoanMinAmount(String str) {
        this.loanMinAmount = str;
    }

    public void setMaxInterestRate(String str) {
        this.maxInterestRate = str;
    }

    public void setMinInterestRate(String str) {
        this.minInterestRate = str;
    }

    public void setTerm(Long l11) {
        this.term = l11;
    }

    public void setTermConfigs(List<Long> list) {
        this.termConfigs = list;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String toString() {
        return "C2CCurrencyBean(currency=" + getCurrency() + ", enable=" + isEnable() + ", loanMaxAmount=" + getLoanMaxAmount() + ", loanMinAmount=" + getLoanMinAmount() + ", term=" + getTerm() + ", termConfigs=" + getTermConfigs() + ", interestRate=" + getInterestRate() + ", weight=" + getWeight() + ", maxInterestRate=" + getMaxInterestRate() + ", minInterestRate=" + getMinInterestRate() + ")";
    }
}

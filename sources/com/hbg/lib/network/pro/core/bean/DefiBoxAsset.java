package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;

public class DefiBoxAsset implements Serializable {
    private String address;
    private String chain;
    private String farmingCost;
    private String farmingIncome;
    private String lending;
    private String outLending;
    private List<ProjectItem> projects;
    private String total;
    @Expose(serialize = false)
    private String totalInBTC;
    private String wallet;
    @Expose(serialize = false)
    private String walletInBTC;
    private List<WalletItem> wallets;

    public boolean canEqual(Object obj) {
        return obj instanceof DefiBoxAsset;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefiBoxAsset)) {
            return false;
        }
        DefiBoxAsset defiBoxAsset = (DefiBoxAsset) obj;
        if (!defiBoxAsset.canEqual(this)) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = defiBoxAsset.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String address2 = getAddress();
        String address3 = defiBoxAsset.getAddress();
        if (address2 != null ? !address2.equals(address3) : address3 != null) {
            return false;
        }
        String total2 = getTotal();
        String total3 = defiBoxAsset.getTotal();
        if (total2 != null ? !total2.equals(total3) : total3 != null) {
            return false;
        }
        String wallet2 = getWallet();
        String wallet3 = defiBoxAsset.getWallet();
        if (wallet2 != null ? !wallet2.equals(wallet3) : wallet3 != null) {
            return false;
        }
        String farmingCost2 = getFarmingCost();
        String farmingCost3 = defiBoxAsset.getFarmingCost();
        if (farmingCost2 != null ? !farmingCost2.equals(farmingCost3) : farmingCost3 != null) {
            return false;
        }
        String farmingIncome2 = getFarmingIncome();
        String farmingIncome3 = defiBoxAsset.getFarmingIncome();
        if (farmingIncome2 != null ? !farmingIncome2.equals(farmingIncome3) : farmingIncome3 != null) {
            return false;
        }
        String lending2 = getLending();
        String lending3 = defiBoxAsset.getLending();
        if (lending2 != null ? !lending2.equals(lending3) : lending3 != null) {
            return false;
        }
        String outLending2 = getOutLending();
        String outLending3 = defiBoxAsset.getOutLending();
        if (outLending2 != null ? !outLending2.equals(outLending3) : outLending3 != null) {
            return false;
        }
        List<WalletItem> wallets2 = getWallets();
        List<WalletItem> wallets3 = defiBoxAsset.getWallets();
        if (wallets2 != null ? !wallets2.equals(wallets3) : wallets3 != null) {
            return false;
        }
        List<ProjectItem> projects2 = getProjects();
        List<ProjectItem> projects3 = defiBoxAsset.getProjects();
        if (projects2 != null ? !projects2.equals(projects3) : projects3 != null) {
            return false;
        }
        String totalInBTC2 = getTotalInBTC();
        String totalInBTC3 = defiBoxAsset.getTotalInBTC();
        if (totalInBTC2 != null ? !totalInBTC2.equals(totalInBTC3) : totalInBTC3 != null) {
            return false;
        }
        String walletInBTC2 = getWalletInBTC();
        String walletInBTC3 = defiBoxAsset.getWalletInBTC();
        return walletInBTC2 != null ? walletInBTC2.equals(walletInBTC3) : walletInBTC3 == null;
    }

    public String getAddress() {
        return this.address;
    }

    public String getChain() {
        return this.chain;
    }

    public String getFarmingCost() {
        return this.farmingCost;
    }

    public String getFarmingIncome() {
        return this.farmingIncome;
    }

    public String getLending() {
        return this.lending;
    }

    public String getOutLending() {
        return this.outLending;
    }

    public List<ProjectItem> getProjects() {
        return this.projects;
    }

    public String getTotal() {
        return this.total;
    }

    public String getTotalInBTC() {
        return this.totalInBTC;
    }

    public String getWallet() {
        return this.wallet;
    }

    public String getWalletInBTC() {
        return this.walletInBTC;
    }

    public List<WalletItem> getWallets() {
        return this.wallets;
    }

    public int hashCode() {
        String chain2 = getChain();
        int i11 = 43;
        int hashCode = chain2 == null ? 43 : chain2.hashCode();
        String address2 = getAddress();
        int hashCode2 = ((hashCode + 59) * 59) + (address2 == null ? 43 : address2.hashCode());
        String total2 = getTotal();
        int hashCode3 = (hashCode2 * 59) + (total2 == null ? 43 : total2.hashCode());
        String wallet2 = getWallet();
        int hashCode4 = (hashCode3 * 59) + (wallet2 == null ? 43 : wallet2.hashCode());
        String farmingCost2 = getFarmingCost();
        int hashCode5 = (hashCode4 * 59) + (farmingCost2 == null ? 43 : farmingCost2.hashCode());
        String farmingIncome2 = getFarmingIncome();
        int hashCode6 = (hashCode5 * 59) + (farmingIncome2 == null ? 43 : farmingIncome2.hashCode());
        String lending2 = getLending();
        int hashCode7 = (hashCode6 * 59) + (lending2 == null ? 43 : lending2.hashCode());
        String outLending2 = getOutLending();
        int hashCode8 = (hashCode7 * 59) + (outLending2 == null ? 43 : outLending2.hashCode());
        List<WalletItem> wallets2 = getWallets();
        int hashCode9 = (hashCode8 * 59) + (wallets2 == null ? 43 : wallets2.hashCode());
        List<ProjectItem> projects2 = getProjects();
        int hashCode10 = (hashCode9 * 59) + (projects2 == null ? 43 : projects2.hashCode());
        String totalInBTC2 = getTotalInBTC();
        int hashCode11 = (hashCode10 * 59) + (totalInBTC2 == null ? 43 : totalInBTC2.hashCode());
        String walletInBTC2 = getWalletInBTC();
        int i12 = hashCode11 * 59;
        if (walletInBTC2 != null) {
            i11 = walletInBTC2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setFarmingCost(String str) {
        this.farmingCost = str;
    }

    public void setFarmingIncome(String str) {
        this.farmingIncome = str;
    }

    public void setLending(String str) {
        this.lending = str;
    }

    public void setOutLending(String str) {
        this.outLending = str;
    }

    public void setProjects(List<ProjectItem> list) {
        this.projects = list;
    }

    public void setTotal(String str) {
        this.total = str;
    }

    public void setTotalInBTC(String str) {
        this.totalInBTC = str;
    }

    public void setWallet(String str) {
        this.wallet = str;
    }

    public void setWalletInBTC(String str) {
        this.walletInBTC = str;
    }

    public void setWallets(List<WalletItem> list) {
        this.wallets = list;
    }

    public String toString() {
        return "DefiBoxAsset(chain=" + getChain() + ", address=" + getAddress() + ", total=" + getTotal() + ", wallet=" + getWallet() + ", farmingCost=" + getFarmingCost() + ", farmingIncome=" + getFarmingIncome() + ", lending=" + getLending() + ", outLending=" + getOutLending() + ", wallets=" + getWallets() + ", projects=" + getProjects() + ", totalInBTC=" + getTotalInBTC() + ", walletInBTC=" + getWalletInBTC() + ")";
    }
}

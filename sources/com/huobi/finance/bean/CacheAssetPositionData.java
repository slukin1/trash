package com.huobi.finance.bean;

import java.io.Serializable;
import java.util.List;
import vk.e;

public class CacheAssetPositionData implements Serializable {
    private long cacheTime;
    private List<AssetPositionCoinData> coinDataList;
    private List<AssetPositionContractData> contractDataList;
    private List<e> earnDataList;
    private List<AssetPositionLevelData> levelDataList;
    private List<AssetPositionOtcData> otcDataList;
    private List<AssetPositionQuantData> quantDataList;
    private List<AssetPositionWarrantData> warrantDataList;

    public CacheAssetPositionData() {
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public List<AssetPositionCoinData> getCoinDataList() {
        return this.coinDataList;
    }

    public List<AssetPositionContractData> getContractDataList() {
        return this.contractDataList;
    }

    public List<e> getEarnDataList() {
        return this.earnDataList;
    }

    public List<AssetPositionLevelData> getLevelDataList() {
        return this.levelDataList;
    }

    public List<AssetPositionOtcData> getOtcDataList() {
        return this.otcDataList;
    }

    public List<AssetPositionQuantData> getQuantDataList() {
        return this.quantDataList;
    }

    public List<AssetPositionWarrantData> getWarrantDataList() {
        return this.warrantDataList;
    }

    public void setCacheTime(long j11) {
        this.cacheTime = j11;
    }

    public void setCoinDataList(List<AssetPositionCoinData> list) {
        this.coinDataList = list;
    }

    public void setContractDataList(List<AssetPositionContractData> list) {
        this.contractDataList = list;
    }

    public void setEarnDataList(List<e> list) {
        this.earnDataList = list;
    }

    public void setLevelDataList(List<AssetPositionLevelData> list) {
        this.levelDataList = list;
    }

    public void setOtcDataList(List<AssetPositionOtcData> list) {
        this.otcDataList = list;
    }

    public void setQuantDataList(List<AssetPositionQuantData> list) {
        this.quantDataList = list;
    }

    public void setWarrantDataList(List<AssetPositionWarrantData> list) {
        this.warrantDataList = list;
    }

    public CacheAssetPositionData(long j11) {
        this.cacheTime = j11;
    }
}

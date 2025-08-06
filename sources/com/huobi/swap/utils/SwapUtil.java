package com.huobi.swap.utils;

import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.huobi.contract.entity.ContractPosition;

public class SwapUtil {
    public static ContractPosition a(SwapPosition swapPosition) {
        ContractPosition contractPosition = new ContractPosition();
        contractPosition.setSymbol(swapPosition.getSymbol());
        contractPosition.setContractCode(swapPosition.getContractCode());
        contractPosition.setContractType(swapPosition.getContractType());
        contractPosition.setVolume(swapPosition.getVolume());
        contractPosition.setAvailable(swapPosition.getAvailable());
        contractPosition.setFrozen(swapPosition.getFrozen());
        contractPosition.setCostOpen(swapPosition.getCostOpen());
        contractPosition.setCostHold(swapPosition.getCostHold());
        contractPosition.setProfitUnreal(swapPosition.getProfitUnreal());
        contractPosition.setProfitRate(swapPosition.getProfitRate());
        contractPosition.setPositionMargin(swapPosition.getPositionMargin());
        contractPosition.setLeverRate(swapPosition.getLeverRate());
        contractPosition.setDirection(swapPosition.getDirection());
        contractPosition.setLastPrice(swapPosition.getLastPrice());
        contractPosition.setProfit(swapPosition.getProfit());
        contractPosition.totalWinRate = swapPosition.totalWinRate;
        contractPosition.storeTime = swapPosition.storeTime;
        contractPosition.totalProfitRate = swapPosition.totalProfitRate;
        contractPosition.costOpenDisplay = swapPosition.costOpenDisplay;
        contractPosition.lastPriceDisplay = swapPosition.lastPriceDisplay;
        return contractPosition;
    }
}

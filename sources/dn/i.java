package dn;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.huobi.contract.entity.ContractPosition;

public final class i {
    public static ContractPosition a(LinearSwapPosition linearSwapPosition) {
        ContractPosition contractPosition = new ContractPosition();
        contractPosition.setSymbol(linearSwapPosition.getSymbol());
        contractPosition.setContractCode(linearSwapPosition.getContractCode());
        contractPosition.setContractType(linearSwapPosition.getContractType());
        contractPosition.setVolume(linearSwapPosition.getVolume());
        contractPosition.setAvailable(linearSwapPosition.getAvailable());
        contractPosition.setFrozen(linearSwapPosition.getFrozen());
        contractPosition.setCostOpen(linearSwapPosition.getCostOpen());
        contractPosition.setCostHold(linearSwapPosition.getCostHold());
        contractPosition.setProfitUnreal(linearSwapPosition.getProfitUnreal());
        contractPosition.setProfitRate(linearSwapPosition.getProfitRate());
        contractPosition.setPositionMargin(linearSwapPosition.getPositionMargin());
        contractPosition.setLeverRate(linearSwapPosition.getLeverRate());
        contractPosition.setDirection(linearSwapPosition.getDirection());
        contractPosition.setLastPrice(linearSwapPosition.getLastPrice());
        contractPosition.setProfit(linearSwapPosition.getProfit());
        contractPosition.totalWinRate = linearSwapPosition.totalWinRate;
        contractPosition.storeTime = linearSwapPosition.storeTime;
        contractPosition.totalProfitRate = linearSwapPosition.totalProfitRate;
        contractPosition.marginMode = linearSwapPosition.marginMode;
        contractPosition.costOpenDisplay = linearSwapPosition.costOpenDisplay;
        contractPosition.lastPriceDisplay = linearSwapPosition.lastPriceDisplay;
        return contractPosition;
    }

    public static String b(int i11) {
        return i11 == 1 ? FutureContractInfo.MARGIN_CROSS : FutureContractInfo.MARGIN_ISOLATED;
    }
}

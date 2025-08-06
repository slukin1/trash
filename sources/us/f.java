package us;

import com.hbg.lib.network.swap.core.bean.SwapActivityInfo;
import com.huobi.contract.entity.FuturesActivityInfo;

public final class f {
    public static FuturesActivityInfo a(SwapActivityInfo swapActivityInfo) {
        if (swapActivityInfo == null) {
            return null;
        }
        FuturesActivityInfo futuresActivityInfo = new FuturesActivityInfo();
        futuresActivityInfo.setStatus(swapActivityInfo.getStatus());
        futuresActivityInfo.setActivityId(swapActivityInfo.getActivityId());
        futuresActivityInfo.setTitle(swapActivityInfo.getTitle());
        futuresActivityInfo.setStartTime(swapActivityInfo.getStartTime());
        futuresActivityInfo.setEndTime(swapActivityInfo.getEndTime());
        futuresActivityInfo.setTotalGift(swapActivityInfo.getTotalGift());
        futuresActivityInfo.setJoinPerson(swapActivityInfo.getJoinPerson());
        futuresActivityInfo.setProductId(swapActivityInfo.getProductId());
        futuresActivityInfo.setUrl(swapActivityInfo.getUrl());
        futuresActivityInfo.setCurrentTime(swapActivityInfo.getCurrentTime());
        futuresActivityInfo.setJoinTime(swapActivityInfo.getJoinTime());
        return futuresActivityInfo;
    }
}

package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractOrderDetailResult implements Serializable {
    private static final long serialVersionUID = 8999235648962297253L;
    @SerializedName("adjust_value")
    private String adjustValue;
    @SerializedName("canceled_at")
    private long cancelDate;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    @SerializedName("final_interest")
    private String finalInterest;
    @SerializedName("instrument_price")
    private String instrumentPrice;
    @SerializedName("lever_rate")
    private Integer leverRate;
    @SerializedName("liquidation_type")
    private String liquidationType;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    private String offset;
    @SerializedName("order_id")
    private Long orderId;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("post_position")
    private String postPosition;
    private String price;
    private String profit;
    private int status;
    private String symbol;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("traded_volume")
    private String tradedVolume;
    private List<ContractOrderDetailInfo> trades;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractOrderDetailResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOrderDetailResult)) {
            return false;
        }
        ContractOrderDetailResult contractOrderDetailResult = (ContractOrderDetailResult) obj;
        if (!contractOrderDetailResult.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractOrderDetailResult.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractOrderDetailResult.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractOrderDetailResult.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = contractOrderDetailResult.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = contractOrderDetailResult.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String adjustValue2 = getAdjustValue();
        String adjustValue3 = contractOrderDetailResult.getAdjustValue();
        if (adjustValue2 != null ? !adjustValue2.equals(adjustValue3) : adjustValue3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = contractOrderDetailResult.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractOrderDetailResult.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = contractOrderDetailResult.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        String instrumentPrice2 = getInstrumentPrice();
        String instrumentPrice3 = contractOrderDetailResult.getInstrumentPrice();
        if (instrumentPrice2 != null ? !instrumentPrice2.equals(instrumentPrice3) : instrumentPrice3 != null) {
            return false;
        }
        String finalInterest2 = getFinalInterest();
        String finalInterest3 = contractOrderDetailResult.getFinalInterest();
        if (finalInterest2 != null ? !finalInterest2.equals(finalInterest3) : finalInterest3 != null) {
            return false;
        }
        if (getStatus() != contractOrderDetailResult.getStatus()) {
            return false;
        }
        Integer leverRate2 = getLeverRate();
        Integer leverRate3 = contractOrderDetailResult.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = contractOrderDetailResult.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = contractOrderDetailResult.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = contractOrderDetailResult.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        Long orderId2 = getOrderId();
        Long orderId3 = contractOrderDetailResult.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = contractOrderDetailResult.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        if (getCreatedAt() != contractOrderDetailResult.getCreatedAt() || getCancelDate() != contractOrderDetailResult.getCancelDate()) {
            return false;
        }
        List<ContractOrderDetailInfo> trades2 = getTrades();
        List<ContractOrderDetailInfo> trades3 = contractOrderDetailResult.getTrades();
        if (trades2 != null ? !trades2.equals(trades3) : trades3 != null) {
            return false;
        }
        String liquidationType2 = getLiquidationType();
        String liquidationType3 = contractOrderDetailResult.getLiquidationType();
        if (liquidationType2 != null ? !liquidationType2.equals(liquidationType3) : liquidationType3 != null) {
            return false;
        }
        String tradedVolume2 = getTradedVolume();
        String tradedVolume3 = contractOrderDetailResult.getTradedVolume();
        if (tradedVolume2 != null ? !tradedVolume2.equals(tradedVolume3) : tradedVolume3 != null) {
            return false;
        }
        String postPosition2 = getPostPosition();
        String postPosition3 = contractOrderDetailResult.getPostPosition();
        return postPosition2 != null ? postPosition2.equals(postPosition3) : postPosition3 == null;
    }

    public String getAdjustValue() {
        return this.adjustValue;
    }

    public long getCancelDate() {
        return this.cancelDate;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFinalInterest() {
        return this.finalInterest;
    }

    public String getInstrumentPrice() {
        return this.instrumentPrice;
    }

    public Integer getLeverRate() {
        return this.leverRate;
    }

    public String getLiquidationType() {
        return this.liquidationType;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getOffset() {
        return this.offset;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r1.equals("optimal_5") == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b4, code lost:
        if (r1.equals("optimal_20_fok") == false) goto L_0x00e5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getOrderPriceTypeString(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = r13.orderSource
            if (r0 == 0) goto L_0x036b
            java.lang.String r0 = r13.orderPriceType
            if (r0 != 0) goto L_0x000a
            goto L_0x036b
        L_0x000a:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r1 = r13.orderSource
            java.lang.String r2 = "trigger"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "optimal_5"
            java.lang.String r3 = "optimal_20"
            java.lang.String r4 = "optimal_10"
            java.lang.String r5 = "limit"
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = -1
            java.lang.String r11 = " - "
            if (r1 == 0) goto L_0x00d9
            java.lang.String r1 = r13.orderPriceType
            r1.hashCode()
            int r12 = r1.hashCode()
            switch(r12) {
                case 102976443: goto L_0x004e;
                case 1305011708: goto L_0x0045;
                case 1305011739: goto L_0x003c;
                case 1843212472: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            r6 = r10
            goto L_0x0056
        L_0x0035:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0056
            goto L_0x0033
        L_0x003c:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0043
            goto L_0x0033
        L_0x0043:
            r6 = r7
            goto L_0x0056
        L_0x0045:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x004c
            goto L_0x0033
        L_0x004c:
            r6 = r8
            goto L_0x0056
        L_0x004e:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0055
            goto L_0x0033
        L_0x0055:
            r6 = r9
        L_0x0056:
            switch(r6) {
                case 0: goto L_0x00b8;
                case 1: goto L_0x0099;
                case 2: goto L_0x007a;
                case 3: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x036a
        L_0x005b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_trigger
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_five
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            goto L_0x00d6
        L_0x007a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_trigger
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_twenty
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            goto L_0x00d6
        L_0x0099:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_trigger
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_ten
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            goto L_0x00d6
        L_0x00b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_trigger
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.trade_price_limit_deal
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
        L_0x00d6:
            r0 = r14
            goto L_0x036a
        L_0x00d9:
            java.lang.String r1 = r13.orderPriceType
            r1.hashCode()
            int r12 = r1.hashCode()
            switch(r12) {
                case -1081306052: goto L_0x01d0;
                case -757447681: goto L_0x01c4;
                case -757444806: goto L_0x01b8;
                case -728818530: goto L_0x01ae;
                case -728815655: goto L_0x01a2;
                case -434974533: goto L_0x0196;
                case -434971658: goto L_0x018a;
                case -407001376: goto L_0x017e;
                case -406998501: goto L_0x0170;
                case -188030627: goto L_0x0162;
                case 101570: goto L_0x0155;
                case 104445: goto L_0x0148;
                case 102976443: goto L_0x013d;
                case 686445258: goto L_0x0130;
                case 851220941: goto L_0x0123;
                case 851223816: goto L_0x0116;
                case 1305011708: goto L_0x010b;
                case 1305011739: goto L_0x0100;
                case 1843212472: goto L_0x00f5;
                case 2002822123: goto L_0x00e8;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            r6 = r10
            goto L_0x01db
        L_0x00e8:
            java.lang.String r2 = "post_only"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f1
            goto L_0x00e5
        L_0x00f1:
            r6 = 19
            goto L_0x01db
        L_0x00f5:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00fc
            goto L_0x00e5
        L_0x00fc:
            r6 = 18
            goto L_0x01db
        L_0x0100:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0107
            goto L_0x00e5
        L_0x0107:
            r6 = 17
            goto L_0x01db
        L_0x010b:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0112
            goto L_0x00e5
        L_0x0112:
            r6 = 16
            goto L_0x01db
        L_0x0116:
            java.lang.String r2 = "lightning_ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x011f
            goto L_0x00e5
        L_0x011f:
            r6 = 15
            goto L_0x01db
        L_0x0123:
            java.lang.String r2 = "lightning_fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012c
            goto L_0x00e5
        L_0x012c:
            r6 = 14
            goto L_0x01db
        L_0x0130:
            java.lang.String r2 = "lightning"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0139
            goto L_0x00e5
        L_0x0139:
            r6 = 13
            goto L_0x01db
        L_0x013d:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0144
            goto L_0x00e5
        L_0x0144:
            r6 = 12
            goto L_0x01db
        L_0x0148:
            java.lang.String r2 = "ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0151
            goto L_0x00e5
        L_0x0151:
            r6 = 11
            goto L_0x01db
        L_0x0155:
            java.lang.String r2 = "fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x015e
            goto L_0x00e5
        L_0x015e:
            r6 = 10
            goto L_0x01db
        L_0x0162:
            java.lang.String r2 = "opponent"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x016c
            goto L_0x00e5
        L_0x016c:
            r6 = 9
            goto L_0x01db
        L_0x0170:
            java.lang.String r2 = "opponent_ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x017a
            goto L_0x00e5
        L_0x017a:
            r6 = 8
            goto L_0x01db
        L_0x017e:
            java.lang.String r2 = "opponent_fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0188
            goto L_0x00e5
        L_0x0188:
            r6 = 7
            goto L_0x01db
        L_0x018a:
            java.lang.String r2 = "optimal_5_ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0194
            goto L_0x00e5
        L_0x0194:
            r6 = 6
            goto L_0x01db
        L_0x0196:
            java.lang.String r2 = "optimal_5_fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01a0
            goto L_0x00e5
        L_0x01a0:
            r6 = 5
            goto L_0x01db
        L_0x01a2:
            java.lang.String r2 = "optimal_20_ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01ac
            goto L_0x00e5
        L_0x01ac:
            r6 = 4
            goto L_0x01db
        L_0x01ae:
            java.lang.String r2 = "optimal_20_fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01db
            goto L_0x00e5
        L_0x01b8:
            java.lang.String r2 = "optimal_10_ioc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01c2
            goto L_0x00e5
        L_0x01c2:
            r6 = r7
            goto L_0x01db
        L_0x01c4:
            java.lang.String r2 = "optimal_10_fok"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01ce
            goto L_0x00e5
        L_0x01ce:
            r6 = r8
            goto L_0x01db
        L_0x01d0:
            java.lang.String r2 = "market"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01da
            goto L_0x00e5
        L_0x01da:
            r6 = r9
        L_0x01db:
            switch(r6) {
                case 0: goto L_0x0364;
                case 1: goto L_0x0345;
                case 2: goto L_0x0326;
                case 3: goto L_0x0307;
                case 4: goto L_0x02e8;
                case 5: goto L_0x02c8;
                case 6: goto L_0x02a8;
                case 7: goto L_0x0288;
                case 8: goto L_0x0268;
                case 9: goto L_0x0260;
                case 10: goto L_0x0258;
                case 11: goto L_0x0250;
                case 12: goto L_0x0248;
                case 13: goto L_0x0240;
                case 14: goto L_0x0220;
                case 15: goto L_0x0200;
                case 16: goto L_0x01f8;
                case 17: goto L_0x01f0;
                case 18: goto L_0x01e8;
                case 19: goto L_0x01e0;
                default: goto L_0x01de;
            }
        L_0x01de:
            goto L_0x036a
        L_0x01e0:
            int r0 = com.hbg.lib.contract.R$string.contract_order_type_post_only
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x01e8:
            int r0 = com.hbg.lib.contract.R$string.contract_trade_optimal_five
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x01f0:
            int r0 = com.hbg.lib.contract.R$string.contract_trade_optimal_twenty
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x01f8:
            int r0 = com.hbg.lib.contract.R$string.contract_trade_optimal_ten
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0200:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_position_close_quick
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0220:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_position_close_quick
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0240:
            int r0 = com.hbg.lib.contract.R$string.contract_trade_position_close_quick
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0248:
            int r0 = com.hbg.lib.contract.R$string.contract_show_limit_order
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0250:
            int r0 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0258:
            int r0 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0260:
            int r0 = com.hbg.lib.contract.R$string.contract_trade_rival_price
            java.lang.String r0 = r14.getString(r0)
            goto L_0x036a
        L_0x0268:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_rival_price
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0288:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_rival_price
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x02a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_five
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x02c8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_five
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x02e8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_twenty
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0307:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_twenty
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0326:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_ten
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_ioc
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0345:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.contract.R$string.contract_trade_optimal_ten
            java.lang.String r1 = r14.getString(r1)
            r0.append(r1)
            r0.append(r11)
            int r1 = com.hbg.lib.contract.R$string.contract_order_type_fok
            java.lang.String r14 = r14.getString(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            goto L_0x036a
        L_0x0364:
            int r0 = com.hbg.lib.contract.R$string.trade_price_market_deal
            java.lang.String r0 = r14.getString(r0)
        L_0x036a:
            return r0
        L_0x036b:
            java.lang.String r14 = ""
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.entity.ContractOrderDetailResult.getOrderPriceTypeString(android.content.Context):java.lang.String");
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public String getPostPosition() {
        return this.postPosition;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProfit() {
        return this.profit;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradeAvgPrice() {
        return this.tradeAvgPrice;
    }

    public String getTradedVolume() {
        return this.tradedVolume;
    }

    public List<ContractOrderDetailInfo> getTrades() {
        return this.trades;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractType2 = getContractType();
        int hashCode2 = ((hashCode + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String volume2 = getVolume();
        int hashCode4 = (hashCode3 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String adjustValue2 = getAdjustValue();
        int hashCode6 = (hashCode5 * 59) + (adjustValue2 == null ? 43 : adjustValue2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode7 = (hashCode6 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        String direction2 = getDirection();
        int hashCode8 = (hashCode7 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode9 = (hashCode8 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        String instrumentPrice2 = getInstrumentPrice();
        int hashCode10 = (hashCode9 * 59) + (instrumentPrice2 == null ? 43 : instrumentPrice2.hashCode());
        String finalInterest2 = getFinalInterest();
        int hashCode11 = (((hashCode10 * 59) + (finalInterest2 == null ? 43 : finalInterest2.hashCode())) * 59) + getStatus();
        Integer leverRate2 = getLeverRate();
        int hashCode12 = (hashCode11 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode13 = (hashCode12 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode14 = (hashCode13 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode15 = (hashCode14 * 59) + (profit2 == null ? 43 : profit2.hashCode());
        Long orderId2 = getOrderId();
        int hashCode16 = (hashCode15 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode17 = (hashCode16 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode17 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        long cancelDate2 = getCancelDate();
        int i13 = (i12 * 59) + ((int) (cancelDate2 ^ (cancelDate2 >>> 32)));
        List<ContractOrderDetailInfo> trades2 = getTrades();
        int hashCode18 = (i13 * 59) + (trades2 == null ? 43 : trades2.hashCode());
        String liquidationType2 = getLiquidationType();
        int hashCode19 = (hashCode18 * 59) + (liquidationType2 == null ? 43 : liquidationType2.hashCode());
        String tradedVolume2 = getTradedVolume();
        int hashCode20 = (hashCode19 * 59) + (tradedVolume2 == null ? 43 : tradedVolume2.hashCode());
        String postPosition2 = getPostPosition();
        int i14 = hashCode20 * 59;
        if (postPosition2 != null) {
            i11 = postPosition2.hashCode();
        }
        return i14 + i11;
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public void setAdjustValue(String str) {
        this.adjustValue = str;
    }

    public void setCancelDate(long j11) {
        this.cancelDate = j11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFinalInterest(String str) {
        this.finalInterest = str;
    }

    public void setInstrumentPrice(String str) {
        this.instrumentPrice = str;
    }

    public void setLeverRate(Integer num) {
        this.leverRate = num;
    }

    public void setLiquidationType(String str) {
        this.liquidationType = str;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(Long l11) {
        this.orderId = l11;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setPostPosition(String str) {
        this.postPosition = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeAvgPrice(String str) {
        this.tradeAvgPrice = str;
    }

    public void setTradedVolume(String str) {
        this.tradedVolume = str;
    }

    public void setTrades(List<ContractOrderDetailInfo> list) {
        this.trades = list;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "ContractOrderDetailResult(symbol=" + getSymbol() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", volume=" + getVolume() + ", price=" + getPrice() + ", adjustValue=" + getAdjustValue() + ", orderPriceType=" + getOrderPriceType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", instrumentPrice=" + getInstrumentPrice() + ", finalInterest=" + getFinalInterest() + ", status=" + getStatus() + ", leverRate=" + getLeverRate() + ", tradeAvgPrice=" + getTradeAvgPrice() + ", marginFrozen=" + getMarginFrozen() + ", profit=" + getProfit() + ", orderId=" + getOrderId() + ", orderSource=" + getOrderSource() + ", createdAt=" + getCreatedAt() + ", cancelDate=" + getCancelDate() + ", trades=" + getTrades() + ", liquidationType=" + getLiquidationType() + ", tradedVolume=" + getTradedVolume() + ", postPosition=" + getPostPosition() + ")";
    }
}

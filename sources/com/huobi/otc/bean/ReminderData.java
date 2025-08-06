package com.huobi.otc.bean;

import android.content.res.Resources;
import com.hbg.lib.common.BaseApplication;
import com.hbg.module.otc.R$string;
import java.io.Serializable;
import java.util.Locale;

public class ReminderData implements Serializable {
    private static final String FORMAT_MM_SS = "%02d:%02d";
    public static final int TRADER_TYPE_BUY = 0;
    public static final int TRADER_TYPE_SELL = 1;
    private String coinIcon;
    private String coinName;
    private long orderId;
    private int remindTime;
    private int status;
    private int tradeType;
    private long userId;

    public ReminderData() {
    }

    public static com.hbg.lite.index.bean.ReminderData toLiteReminderData(ReminderData reminderData) {
        if (reminderData == null) {
            return null;
        }
        com.hbg.lite.index.bean.ReminderData reminderData2 = new com.hbg.lite.index.bean.ReminderData();
        reminderData2.m(reminderData.getCoinName());
        reminderData2.l(reminderData.getCoinIcon());
        reminderData2.n(reminderData.getOrderId());
        reminderData2.o(reminderData.getRemindTime());
        reminderData2.p(reminderData.getStatus());
        reminderData2.q(reminderData.getTradeType());
        reminderData2.r(reminderData.getUserId());
        return reminderData2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ReminderData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReminderData)) {
            return false;
        }
        ReminderData reminderData = (ReminderData) obj;
        if (!reminderData.canEqual(this) || getUserId() != reminderData.getUserId() || getOrderId() != reminderData.getOrderId() || getTradeType() != reminderData.getTradeType() || getRemindTime() != reminderData.getRemindTime()) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = reminderData.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        if (getStatus() != reminderData.getStatus()) {
            return false;
        }
        String coinIcon2 = getCoinIcon();
        String coinIcon3 = reminderData.getCoinIcon();
        return coinIcon2 != null ? coinIcon2.equals(coinIcon3) : coinIcon3 == null;
    }

    public String getCoinIcon() {
        return this.coinIcon;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getDesc() {
        String str;
        Resources resources = BaseApplication.b().getResources();
        if (this.tradeType == 1) {
            str = resources.getString(R$string.otc_reminder_sell);
        } else {
            str = resources.getString(R$string.otc_reminder_buy);
        }
        return str + this.coinName;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public int getRemindTime() {
        return this.remindTime;
    }

    public String getReminderTimeStr() {
        if (this.remindTime <= 0) {
            return "";
        }
        return "(" + String.format(Locale.getDefault(), FORMAT_MM_SS, new Object[]{Integer.valueOf(this.remindTime / 60), Integer.valueOf(this.remindTime % 60)}) + ")";
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        Resources resources = BaseApplication.b().getResources();
        if (this.tradeType == 1) {
            return resources.getString(R$string.otc_reminder_title_sell);
        }
        return resources.getString(R$string.n_otc_trade_order_status_not_pay_buy_show);
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long userId2 = getUserId();
        long orderId2 = getOrderId();
        int tradeType2 = ((((((((int) (userId2 ^ (userId2 >>> 32))) + 59) * 59) + ((int) ((orderId2 >>> 32) ^ orderId2))) * 59) + getTradeType()) * 59) + getRemindTime();
        String coinName2 = getCoinName();
        int i11 = 43;
        int hashCode = (((tradeType2 * 59) + (coinName2 == null ? 43 : coinName2.hashCode())) * 59) + getStatus();
        String coinIcon2 = getCoinIcon();
        int i12 = hashCode * 59;
        if (coinIcon2 != null) {
            i11 = coinIcon2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isBuy() {
        return this.tradeType == 0;
    }

    public void setCoinIcon(String str) {
        this.coinIcon = str;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setRemindTime(int i11) {
        this.remindTime = i11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTradeType(int i11) {
        this.tradeType = i11;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }

    public String toString() {
        return "ReminderData(userId=" + getUserId() + ", orderId=" + getOrderId() + ", tradeType=" + getTradeType() + ", remindTime=" + getRemindTime() + ", coinName=" + getCoinName() + ", status=" + getStatus() + ", coinIcon=" + getCoinIcon() + ")";
    }

    public ReminderData(long j11, long j12, int i11, int i12, String str, int i13, String str2) {
        this.userId = j11;
        this.orderId = j12;
        this.tradeType = i11;
        this.remindTime = i12;
        this.coinName = str;
        this.status = i13;
        this.coinIcon = str2;
    }
}

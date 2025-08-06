package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RiskActionData implements Serializable {
    public static final String ORDER_STATE_DONE = "DONE";
    public static final String ORDER_STATE_FAIL = "FAIL";
    public static final String ORDER_STATE_TODO = "TODO";
    private List<ActionsBean> actions;
    @SerializedName("action-token")
    private String actiontoken;
    @SerializedName("order-state")
    private String orderState;
    @SerializedName("order-id")
    private long orderid;

    public static class ActionsBean implements Serializable {
        @SerializedName("action-num")
        private int actionnum;
        @SerializedName("action-state")
        private int actionstate;
        @SerializedName("action-type")
        private int actiontype;
        @SerializedName("action-way")
        private String actionway;

        public boolean canEqual(Object obj) {
            return obj instanceof ActionsBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ActionsBean)) {
                return false;
            }
            ActionsBean actionsBean = (ActionsBean) obj;
            if (!actionsBean.canEqual(this) || getActiontype() != actionsBean.getActiontype() || getActionstate() != actionsBean.getActionstate()) {
                return false;
            }
            String actionway2 = getActionway();
            String actionway3 = actionsBean.getActionway();
            if (actionway2 != null ? actionway2.equals(actionway3) : actionway3 == null) {
                return getActionnum() == actionsBean.getActionnum();
            }
            return false;
        }

        public int getActionnum() {
            return this.actionnum;
        }

        public int getActionstate() {
            return this.actionstate;
        }

        public int getActiontype() {
            return this.actiontype;
        }

        public String getActionway() {
            return this.actionway;
        }

        public int hashCode() {
            int actiontype2 = ((getActiontype() + 59) * 59) + getActionstate();
            String actionway2 = getActionway();
            return (((actiontype2 * 59) + (actionway2 == null ? 43 : actionway2.hashCode())) * 59) + getActionnum();
        }

        public void setActionnum(int i11) {
            this.actionnum = i11;
        }

        public void setActionstate(int i11) {
            this.actionstate = i11;
        }

        public void setActiontype(int i11) {
            this.actiontype = i11;
        }

        public void setActionway(String str) {
            this.actionway = str;
        }

        public String toString() {
            return "RiskActionData.ActionsBean(actiontype=" + getActiontype() + ", actionstate=" + getActionstate() + ", actionway=" + getActionway() + ", actionnum=" + getActionnum() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof RiskActionData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RiskActionData)) {
            return false;
        }
        RiskActionData riskActionData = (RiskActionData) obj;
        if (!riskActionData.canEqual(this) || getOrderid() != riskActionData.getOrderid()) {
            return false;
        }
        String orderState2 = getOrderState();
        String orderState3 = riskActionData.getOrderState();
        if (orderState2 != null ? !orderState2.equals(orderState3) : orderState3 != null) {
            return false;
        }
        String actiontoken2 = getActiontoken();
        String actiontoken3 = riskActionData.getActiontoken();
        if (actiontoken2 != null ? !actiontoken2.equals(actiontoken3) : actiontoken3 != null) {
            return false;
        }
        List<ActionsBean> actions2 = getActions();
        List<ActionsBean> actions3 = riskActionData.getActions();
        return actions2 != null ? actions2.equals(actions3) : actions3 == null;
    }

    public List<ActionsBean> getActions() {
        return this.actions;
    }

    public String getActiontoken() {
        return this.actiontoken;
    }

    public String getOrderState() {
        return this.orderState;
    }

    public long getOrderid() {
        return this.orderid;
    }

    public int hashCode() {
        long orderid2 = getOrderid();
        String orderState2 = getOrderState();
        int i11 = 43;
        int hashCode = ((((int) (orderid2 ^ (orderid2 >>> 32))) + 59) * 59) + (orderState2 == null ? 43 : orderState2.hashCode());
        String actiontoken2 = getActiontoken();
        int hashCode2 = (hashCode * 59) + (actiontoken2 == null ? 43 : actiontoken2.hashCode());
        List<ActionsBean> actions2 = getActions();
        int i12 = hashCode2 * 59;
        if (actions2 != null) {
            i11 = actions2.hashCode();
        }
        return i12 + i11;
    }

    public void setActions(List<ActionsBean> list) {
        this.actions = list;
    }

    public void setActiontoken(String str) {
        this.actiontoken = str;
    }

    public void setOrderState(String str) {
        this.orderState = str;
    }

    public void setOrderid(long j11) {
        this.orderid = j11;
    }

    public String toString() {
        return "RiskActionData(orderid=" + getOrderid() + ", orderState=" + getOrderState() + ", actiontoken=" + getActiontoken() + ", actions=" + getActions() + ")";
    }
}

package com.huobi.otc.bean;

import android.content.Context;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.huobi.otc.handler.OtcFAQDialogHandler;
import com.huobi.otc.handler.OtcFAQDialogProblemHandler;
import java.io.Serializable;
import s9.a;

public class OtcFAQDialogDataType implements Serializable, a {
    private OtcFAQBean dataBean;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onChangeClick(OtcFAQDialogDataType otcFAQDialogDataType);

        void onClick(OtcFAQDialogDataType otcFAQDialogDataType, OtcFAQBean otcFAQBean);

        void onClickAction(Context context, OtcFAQBean otcFAQBean);

        void onClickGreat(OtcFAQDialogDataType otcFAQDialogDataType, int i11);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcFAQDialogDataType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFAQDialogDataType)) {
            return false;
        }
        OtcFAQDialogDataType otcFAQDialogDataType = (OtcFAQDialogDataType) obj;
        if (!otcFAQDialogDataType.canEqual(this)) {
            return false;
        }
        OtcFAQBean dataBean2 = getDataBean();
        OtcFAQBean dataBean3 = otcFAQDialogDataType.getDataBean();
        if (dataBean2 != null ? !dataBean2.equals(dataBean3) : dataBean3 != null) {
            return false;
        }
        OnItemClickListener onItemClickListener2 = getOnItemClickListener();
        OnItemClickListener onItemClickListener3 = otcFAQDialogDataType.getOnItemClickListener();
        return onItemClickListener2 != null ? onItemClickListener2.equals(onItemClickListener3) : onItemClickListener3 == null;
    }

    public OtcFAQBean getDataBean() {
        return this.dataBean;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public String getViewHandlerName() {
        if (this.dataBean.isLocalAll()) {
            return OtcFAQDialogHandler.class.getName();
        }
        return OtcFAQDialogProblemHandler.class.getName();
    }

    public int hashCode() {
        OtcFAQBean dataBean2 = getDataBean();
        int i11 = 43;
        int hashCode = dataBean2 == null ? 43 : dataBean2.hashCode();
        OnItemClickListener onItemClickListener2 = getOnItemClickListener();
        int i12 = (hashCode + 59) * 59;
        if (onItemClickListener2 != null) {
            i11 = onItemClickListener2.hashCode();
        }
        return i12 + i11;
    }

    public void setDataBean(OtcFAQBean otcFAQBean) {
        this.dataBean = otcFAQBean;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public String toString() {
        return "OtcFAQDialogDataType(dataBean=" + getDataBean() + ", onItemClickListener=" + getOnItemClickListener() + ")";
    }
}

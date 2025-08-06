package com.huobi.otc.bean;

import android.text.TextUtils;
import com.hbg.lib.network.otc.core.bean.OtcCancelActionBean;
import com.hbg.lib.network.otc.core.bean.OtcCancelReasonBean;
import com.huobi.otc.handler.OtcCancelHeaderHandler;
import com.huobi.otc.handler.OtcCancelNoSubsetHandler;
import com.huobi.otc.handler.OtcCancelSubsetContentHandler;
import com.huobi.otc.handler.OtcCancelSubsetOtherHandler;
import com.huobi.otc.handler.OtcCancelSubsetRequiredHandler;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class OtcCancelReasonDataType implements Serializable, a {
    private OtcCancelReasonBean dataBean;
    private OnReasonClickListener onReasonClickListener;

    public interface OnReasonClickListener {
        void onClick(OtcCancelActionBean otcCancelActionBean);

        void onClick(OtcCancelReasonDataType otcCancelReasonDataType, OtcCancelReasonBean otcCancelReasonBean);

        void onTextChange(String str);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCancelReasonDataType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCancelReasonDataType)) {
            return false;
        }
        OtcCancelReasonDataType otcCancelReasonDataType = (OtcCancelReasonDataType) obj;
        if (!otcCancelReasonDataType.canEqual(this)) {
            return false;
        }
        OtcCancelReasonBean dataBean2 = getDataBean();
        OtcCancelReasonBean dataBean3 = otcCancelReasonDataType.getDataBean();
        if (dataBean2 != null ? !dataBean2.equals(dataBean3) : dataBean3 != null) {
            return false;
        }
        OnReasonClickListener onReasonClickListener2 = getOnReasonClickListener();
        OnReasonClickListener onReasonClickListener3 = otcCancelReasonDataType.getOnReasonClickListener();
        return onReasonClickListener2 != null ? onReasonClickListener2.equals(onReasonClickListener3) : onReasonClickListener3 == null;
    }

    public OtcCancelReasonBean getDataBean() {
        return this.dataBean;
    }

    public OnReasonClickListener getOnReasonClickListener() {
        return this.onReasonClickListener;
    }

    public String getViewHandlerName() {
        List<OtcCancelReasonBean> subset = this.dataBean.getSubset();
        if (this.dataBean.isLocalHeader()) {
            return OtcCancelHeaderHandler.class.getName();
        }
        if (this.dataBean.isOtherType()) {
            return OtcCancelSubsetOtherHandler.class.getName();
        }
        if (subset != null && !subset.isEmpty()) {
            return OtcCancelSubsetRequiredHandler.class.getName();
        }
        if (!TextUtils.isEmpty(this.dataBean.getContent())) {
            return OtcCancelSubsetContentHandler.class.getName();
        }
        return OtcCancelNoSubsetHandler.class.getName();
    }

    public int hashCode() {
        OtcCancelReasonBean dataBean2 = getDataBean();
        int i11 = 43;
        int hashCode = dataBean2 == null ? 43 : dataBean2.hashCode();
        OnReasonClickListener onReasonClickListener2 = getOnReasonClickListener();
        int i12 = (hashCode + 59) * 59;
        if (onReasonClickListener2 != null) {
            i11 = onReasonClickListener2.hashCode();
        }
        return i12 + i11;
    }

    public void setDataBean(OtcCancelReasonBean otcCancelReasonBean) {
        this.dataBean = otcCancelReasonBean;
    }

    public void setOnReasonClickListener(OnReasonClickListener onReasonClickListener2) {
        this.onReasonClickListener = onReasonClickListener2;
    }

    public String toString() {
        return "OtcCancelReasonDataType(dataBean=" + getDataBean() + ", onReasonClickListener=" + getOnReasonClickListener() + ")";
    }
}

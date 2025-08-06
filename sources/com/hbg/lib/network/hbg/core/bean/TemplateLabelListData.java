package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class TemplateLabelListData implements Serializable {
    @SerializedName("messageType")
    private Integer messageType;
    @SerializedName("subscribe")
    private List<Subscribe> subscribe;

    public static class Subscribe {
        @SerializedName("id")

        /* renamed from: id  reason: collision with root package name */
        private Integer f70268id;
        @SerializedName("labelName")
        private String labelName;
        @SerializedName("subState")
        private Integer subState;

        public boolean canEqual(Object obj) {
            return obj instanceof Subscribe;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Subscribe)) {
                return false;
            }
            Subscribe subscribe = (Subscribe) obj;
            if (!subscribe.canEqual(this)) {
                return false;
            }
            Integer id2 = getId();
            Integer id3 = subscribe.getId();
            if (id2 != null ? !id2.equals(id3) : id3 != null) {
                return false;
            }
            String labelName2 = getLabelName();
            String labelName3 = subscribe.getLabelName();
            if (labelName2 != null ? !labelName2.equals(labelName3) : labelName3 != null) {
                return false;
            }
            Integer subState2 = getSubState();
            Integer subState3 = subscribe.getSubState();
            return subState2 != null ? subState2.equals(subState3) : subState3 == null;
        }

        public Integer getId() {
            return this.f70268id;
        }

        public String getLabelName() {
            return this.labelName;
        }

        public Integer getSubState() {
            return this.subState;
        }

        public int hashCode() {
            Integer id2 = getId();
            int i11 = 43;
            int hashCode = id2 == null ? 43 : id2.hashCode();
            String labelName2 = getLabelName();
            int hashCode2 = ((hashCode + 59) * 59) + (labelName2 == null ? 43 : labelName2.hashCode());
            Integer subState2 = getSubState();
            int i12 = hashCode2 * 59;
            if (subState2 != null) {
                i11 = subState2.hashCode();
            }
            return i12 + i11;
        }

        public void setId(Integer num) {
            this.f70268id = num;
        }

        public void setLabelName(String str) {
            this.labelName = str;
        }

        public void setSubState(Integer num) {
            this.subState = num;
        }

        public String toString() {
            return "TemplateLabelListData.Subscribe(id=" + getId() + ", labelName=" + getLabelName() + ", subState=" + getSubState() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof TemplateLabelListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TemplateLabelListData)) {
            return false;
        }
        TemplateLabelListData templateLabelListData = (TemplateLabelListData) obj;
        if (!templateLabelListData.canEqual(this)) {
            return false;
        }
        Integer messageType2 = getMessageType();
        Integer messageType3 = templateLabelListData.getMessageType();
        if (messageType2 != null ? !messageType2.equals(messageType3) : messageType3 != null) {
            return false;
        }
        List<Subscribe> subscribe2 = getSubscribe();
        List<Subscribe> subscribe3 = templateLabelListData.getSubscribe();
        return subscribe2 != null ? subscribe2.equals(subscribe3) : subscribe3 == null;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public List<Subscribe> getSubscribe() {
        return this.subscribe;
    }

    public int hashCode() {
        Integer messageType2 = getMessageType();
        int i11 = 43;
        int hashCode = messageType2 == null ? 43 : messageType2.hashCode();
        List<Subscribe> subscribe2 = getSubscribe();
        int i12 = (hashCode + 59) * 59;
        if (subscribe2 != null) {
            i11 = subscribe2.hashCode();
        }
        return i12 + i11;
    }

    public void setMessageType(Integer num) {
        this.messageType = num;
    }

    public void setSubscribe(List<Subscribe> list) {
        this.subscribe = list;
    }

    public String toString() {
        return "TemplateLabelListData(messageType=" + getMessageType() + ", subscribe=" + getSubscribe() + ")";
    }
}

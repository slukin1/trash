package com.huobi.otc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hbg.lib.network.otc.core.bean.OtcPaymentTemplateBean;
import java.io.Serializable;
import java.util.List;
import s9.a;

public class UserPayMethodBean implements a, Serializable, Parcelable {
    public static final Parcelable.Creator<UserPayMethodBean> CREATOR = new Parcelable.Creator<UserPayMethodBean>() {
        public UserPayMethodBean createFromParcel(Parcel parcel) {
            return new UserPayMethodBean(parcel);
        }

        public UserPayMethodBean[] newArray(int i11) {
            return new UserPayMethodBean[i11];
        }
    };
    public static final int IS_ACTIVITE = 1;
    public static final int IS_NOT_ACTIVITE = 0;
    private String bankAddress;
    private String bankName;
    private String bankNumber;
    private int bankType;
    private Callback callback;
    private String color;
    private int currentIndex;

    /* renamed from: id  reason: collision with root package name */
    private String f78269id;
    private boolean isEnd;
    private boolean isSelected;
    private int isShow;
    private boolean isShowItem = true;
    private boolean isShowLoadMore = true;
    private int itemCount;
    private List<OtcPaymentTemplateBean> modelFieldsList;
    private String payMethodName;
    private String qrCode;
    private int showType;
    private int status;
    private String userId;
    private String userName;

    public interface Callback {
        void onClickAdd(String str);

        void onItemClick(int i11, UserPayMethodBean userPayMethodBean);
    }

    public UserPayMethodBean() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof UserPayMethodBean;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserPayMethodBean)) {
            return false;
        }
        UserPayMethodBean userPayMethodBean = (UserPayMethodBean) obj;
        if (!userPayMethodBean.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = userPayMethodBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = userPayMethodBean.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = userPayMethodBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getBankType() != userPayMethodBean.getBankType()) {
            return false;
        }
        String bankNumber2 = getBankNumber();
        String bankNumber3 = userPayMethodBean.getBankNumber();
        if (bankNumber2 != null ? !bankNumber2.equals(bankNumber3) : bankNumber3 != null) {
            return false;
        }
        String bankName2 = getBankName();
        String bankName3 = userPayMethodBean.getBankName();
        if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
            return false;
        }
        String bankAddress2 = getBankAddress();
        String bankAddress3 = userPayMethodBean.getBankAddress();
        if (bankAddress2 != null ? !bankAddress2.equals(bankAddress3) : bankAddress3 != null) {
            return false;
        }
        String qrCode2 = getQrCode();
        String qrCode3 = userPayMethodBean.getQrCode();
        if (qrCode2 != null ? !qrCode2.equals(qrCode3) : qrCode3 != null) {
            return false;
        }
        if (getStatus() != userPayMethodBean.getStatus() || getIsShow() != userPayMethodBean.getIsShow() || getShowType() != userPayMethodBean.getShowType() || isEnd() != userPayMethodBean.isEnd()) {
            return false;
        }
        String color2 = getColor();
        String color3 = userPayMethodBean.getColor();
        if (color2 != null ? !color2.equals(color3) : color3 != null) {
            return false;
        }
        String payMethodName2 = getPayMethodName();
        String payMethodName3 = userPayMethodBean.getPayMethodName();
        if (payMethodName2 != null ? !payMethodName2.equals(payMethodName3) : payMethodName3 != null) {
            return false;
        }
        if (isSelected() != userPayMethodBean.isSelected() || getItemCount() != userPayMethodBean.getItemCount() || getCurrentIndex() != userPayMethodBean.getCurrentIndex() || isShowItem() != userPayMethodBean.isShowItem() || isShowLoadMore() != userPayMethodBean.isShowLoadMore()) {
            return false;
        }
        Callback callback2 = getCallback();
        Callback callback3 = userPayMethodBean.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
        List<OtcPaymentTemplateBean> modelFieldsList3 = userPayMethodBean.getModelFieldsList();
        return modelFieldsList2 != null ? modelFieldsList2.equals(modelFieldsList3) : modelFieldsList3 == null;
    }

    public String getBankAddress() {
        return this.bankAddress;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNumber() {
        return this.bankNumber;
    }

    public int getBankType() {
        return this.bankType;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public String getColor() {
        return this.color;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public String getId() {
        return this.f78269id;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public List<OtcPaymentTemplateBean> getModelFieldsList() {
        return this.modelFieldsList;
    }

    public String getPayMethodName() {
        return this.payMethodName;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public int getShowType() {
        return this.showType;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getViewHandlerName() {
        return "";
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String userId2 = getUserId();
        int hashCode2 = ((hashCode + 59) * 59) + (userId2 == null ? 43 : userId2.hashCode());
        String userName2 = getUserName();
        int hashCode3 = (((hashCode2 * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getBankType();
        String bankNumber2 = getBankNumber();
        int hashCode4 = (hashCode3 * 59) + (bankNumber2 == null ? 43 : bankNumber2.hashCode());
        String bankName2 = getBankName();
        int hashCode5 = (hashCode4 * 59) + (bankName2 == null ? 43 : bankName2.hashCode());
        String bankAddress2 = getBankAddress();
        int hashCode6 = (hashCode5 * 59) + (bankAddress2 == null ? 43 : bankAddress2.hashCode());
        String qrCode2 = getQrCode();
        int i12 = 79;
        int hashCode7 = (((((((((hashCode6 * 59) + (qrCode2 == null ? 43 : qrCode2.hashCode())) * 59) + getStatus()) * 59) + getIsShow()) * 59) + getShowType()) * 59) + (isEnd() ? 79 : 97);
        String color2 = getColor();
        int hashCode8 = (hashCode7 * 59) + (color2 == null ? 43 : color2.hashCode());
        String payMethodName2 = getPayMethodName();
        int hashCode9 = ((((((((((hashCode8 * 59) + (payMethodName2 == null ? 43 : payMethodName2.hashCode())) * 59) + (isSelected() ? 79 : 97)) * 59) + getItemCount()) * 59) + getCurrentIndex()) * 59) + (isShowItem() ? 79 : 97)) * 59;
        if (!isShowLoadMore()) {
            i12 = 97;
        }
        Callback callback2 = getCallback();
        int hashCode10 = ((hashCode9 + i12) * 59) + (callback2 == null ? 43 : callback2.hashCode());
        List<OtcPaymentTemplateBean> modelFieldsList2 = getModelFieldsList();
        int i13 = hashCode10 * 59;
        if (modelFieldsList2 != null) {
            i11 = modelFieldsList2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowItem() {
        return this.isShowItem;
    }

    public boolean isShowLoadMore() {
        return this.isShowLoadMore;
    }

    public void setBankAddress(String str) {
        this.bankAddress = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankNumber(String str) {
        this.bankNumber = str;
    }

    public void setBankType(int i11) {
        this.bankType = i11;
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setCurrentIndex(int i11) {
        this.currentIndex = i11;
    }

    public void setEnd(boolean z11) {
        this.isEnd = z11;
    }

    public void setId(String str) {
        this.f78269id = str;
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setItemCount(int i11) {
        this.itemCount = i11;
    }

    public void setModelFieldsList(List<OtcPaymentTemplateBean> list) {
        this.modelFieldsList = list;
    }

    public void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setShowItem(boolean z11) {
        this.isShowItem = z11;
    }

    public void setShowLoadMore(boolean z11) {
        this.isShowLoadMore = z11;
    }

    public void setShowType(int i11) {
        this.showType = i11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "UserPayMethodBean(id=" + getId() + ", userId=" + getUserId() + ", userName=" + getUserName() + ", bankType=" + getBankType() + ", bankNumber=" + getBankNumber() + ", bankName=" + getBankName() + ", bankAddress=" + getBankAddress() + ", qrCode=" + getQrCode() + ", status=" + getStatus() + ", isShow=" + getIsShow() + ", showType=" + getShowType() + ", isEnd=" + isEnd() + ", color=" + getColor() + ", payMethodName=" + getPayMethodName() + ", isSelected=" + isSelected() + ", itemCount=" + getItemCount() + ", currentIndex=" + getCurrentIndex() + ", isShowItem=" + isShowItem() + ", isShowLoadMore=" + isShowLoadMore() + ", callback=" + getCallback() + ", modelFieldsList=" + getModelFieldsList() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f78269id);
        parcel.writeString(this.userId);
        parcel.writeString(this.userName);
        parcel.writeInt(this.bankType);
        parcel.writeString(this.bankNumber);
        parcel.writeString(this.bankName);
        parcel.writeString(this.bankAddress);
        parcel.writeString(this.qrCode);
        parcel.writeInt(this.status);
        parcel.writeInt(this.isShow);
        parcel.writeInt(this.showType);
        parcel.writeByte(this.isEnd ? (byte) 1 : 0);
        parcel.writeString(this.color);
        parcel.writeString(this.payMethodName);
        parcel.writeTypedList(this.modelFieldsList);
    }

    public UserPayMethodBean(Parcel parcel) {
        boolean z11 = true;
        this.f78269id = parcel.readString();
        this.userId = parcel.readString();
        this.userName = parcel.readString();
        this.bankType = parcel.readInt();
        this.bankNumber = parcel.readString();
        this.bankName = parcel.readString();
        this.bankAddress = parcel.readString();
        this.qrCode = parcel.readString();
        this.status = parcel.readInt();
        this.isShow = parcel.readInt();
        this.showType = parcel.readInt();
        this.isEnd = parcel.readByte() == 0 ? false : z11;
        this.color = parcel.readString();
        this.payMethodName = parcel.readString();
        this.modelFieldsList = parcel.createTypedArrayList(OtcPaymentTemplateBean.CREATOR);
    }
}

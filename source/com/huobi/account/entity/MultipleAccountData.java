package com.huobi.account.entity;

import com.google.gson.annotations.Expose;
import com.huobi.account.viewhandler.MultipleAccountHandler;
import java.io.Serializable;

public class MultipleAccountData implements Serializable, s9.a {
    private static final long serialVersionUID = 8389485209241361331L;
    private String account;
    private boolean editMode;
    private String frameUrl;
    private String headImage;
    private String headImageType;
    private boolean isCurrentAccount;
    private boolean isSubAccount;
    private String nickName;
    @Expose(deserialize = false, serialize = false)
    private a onAccountItemClickListener;
    private String showExtBusinessTag;
    private int status;
    private String uid;

    public interface a {
        void a(MultipleAccountData multipleAccountData, int i11);

        void b(MultipleAccountData multipleAccountData);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MultipleAccountData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultipleAccountData)) {
            return false;
        }
        MultipleAccountData multipleAccountData = (MultipleAccountData) obj;
        if (!multipleAccountData.canEqual(this) || isSubAccount() != multipleAccountData.isSubAccount()) {
            return false;
        }
        String account2 = getAccount();
        String account3 = multipleAccountData.getAccount();
        if (account2 != null ? !account2.equals(account3) : account3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = multipleAccountData.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        if (isCurrentAccount() != multipleAccountData.isCurrentAccount() || isEditMode() != multipleAccountData.isEditMode() || getStatus() != multipleAccountData.getStatus()) {
            return false;
        }
        String headImage2 = getHeadImage();
        String headImage3 = multipleAccountData.getHeadImage();
        if (headImage2 != null ? !headImage2.equals(headImage3) : headImage3 != null) {
            return false;
        }
        String headImageType2 = getHeadImageType();
        String headImageType3 = multipleAccountData.getHeadImageType();
        if (headImageType2 != null ? !headImageType2.equals(headImageType3) : headImageType3 != null) {
            return false;
        }
        String frameUrl2 = getFrameUrl();
        String frameUrl3 = multipleAccountData.getFrameUrl();
        if (frameUrl2 != null ? !frameUrl2.equals(frameUrl3) : frameUrl3 != null) {
            return false;
        }
        String nickName2 = getNickName();
        String nickName3 = multipleAccountData.getNickName();
        if (nickName2 != null ? !nickName2.equals(nickName3) : nickName3 != null) {
            return false;
        }
        String showExtBusinessTag2 = getShowExtBusinessTag();
        String showExtBusinessTag3 = multipleAccountData.getShowExtBusinessTag();
        if (showExtBusinessTag2 != null ? !showExtBusinessTag2.equals(showExtBusinessTag3) : showExtBusinessTag3 != null) {
            return false;
        }
        a onAccountItemClickListener2 = getOnAccountItemClickListener();
        a onAccountItemClickListener3 = multipleAccountData.getOnAccountItemClickListener();
        return onAccountItemClickListener2 != null ? onAccountItemClickListener2.equals(onAccountItemClickListener3) : onAccountItemClickListener3 == null;
    }

    public String getAccount() {
        return this.account;
    }

    public String getFrameUrl() {
        return this.frameUrl;
    }

    public String getHeadImage() {
        return this.headImage;
    }

    public String getHeadImageType() {
        return this.headImageType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public a getOnAccountItemClickListener() {
        return this.onAccountItemClickListener;
    }

    public String getShowExtBusinessTag() {
        return this.showExtBusinessTag;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getViewHandlerName() {
        return MultipleAccountHandler.class.getName();
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = isSubAccount() ? 79 : 97;
        String account2 = getAccount();
        int i13 = 43;
        int hashCode = ((i12 + 59) * 59) + (account2 == null ? 43 : account2.hashCode());
        String uid2 = getUid();
        int hashCode2 = ((((hashCode * 59) + (uid2 == null ? 43 : uid2.hashCode())) * 59) + (isCurrentAccount() ? 79 : 97)) * 59;
        if (!isEditMode()) {
            i11 = 97;
        }
        int status2 = ((hashCode2 + i11) * 59) + getStatus();
        String headImage2 = getHeadImage();
        int hashCode3 = (status2 * 59) + (headImage2 == null ? 43 : headImage2.hashCode());
        String headImageType2 = getHeadImageType();
        int hashCode4 = (hashCode3 * 59) + (headImageType2 == null ? 43 : headImageType2.hashCode());
        String frameUrl2 = getFrameUrl();
        int hashCode5 = (hashCode4 * 59) + (frameUrl2 == null ? 43 : frameUrl2.hashCode());
        String nickName2 = getNickName();
        int hashCode6 = (hashCode5 * 59) + (nickName2 == null ? 43 : nickName2.hashCode());
        String showExtBusinessTag2 = getShowExtBusinessTag();
        int hashCode7 = (hashCode6 * 59) + (showExtBusinessTag2 == null ? 43 : showExtBusinessTag2.hashCode());
        a onAccountItemClickListener2 = getOnAccountItemClickListener();
        int i14 = hashCode7 * 59;
        if (onAccountItemClickListener2 != null) {
            i13 = onAccountItemClickListener2.hashCode();
        }
        return i14 + i13;
    }

    public boolean isCurrentAccount() {
        return this.isCurrentAccount;
    }

    public boolean isEditMode() {
        return this.editMode;
    }

    public boolean isSubAccount() {
        return this.isSubAccount;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCurrentAccount(boolean z11) {
        this.isCurrentAccount = z11;
    }

    public void setEditMode(boolean z11) {
        this.editMode = z11;
    }

    public void setFrameUrl(String str) {
        this.frameUrl = str;
    }

    public void setHeadImage(String str) {
        this.headImage = str;
    }

    public void setHeadImageType(String str) {
        this.headImageType = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOnAccountItemClickListener(a aVar) {
        this.onAccountItemClickListener = aVar;
    }

    public void setShowExtBusinessTag(String str) {
        this.showExtBusinessTag = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSubAccount(boolean z11) {
        this.isSubAccount = z11;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "MultipleAccountData(isSubAccount=" + isSubAccount() + ", account=" + getAccount() + ", uid=" + getUid() + ", isCurrentAccount=" + isCurrentAccount() + ", editMode=" + isEditMode() + ", status=" + getStatus() + ", headImage=" + getHeadImage() + ", headImageType=" + getHeadImageType() + ", frameUrl=" + getFrameUrl() + ", nickName=" + getNickName() + ", showExtBusinessTag=" + getShowExtBusinessTag() + ", onAccountItemClickListener=" + getOnAccountItemClickListener() + ")";
    }
}

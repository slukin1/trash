package com.hbg.lite.index.bean;

import com.hbg.lite.index.viewhandler.LiteGalleryViewHandler;
import java.io.Serializable;
import s9.a;

public class LiteHomeActivityEntity implements Serializable, a {
    public static final int IGNORE_LOGIN = 2;
    public static final int IS_NEED_LOGIN = 0;
    public static final int IS_NOT_LOGIN = 1;
    public static final int IS_NOT_SHOW = 1;
    public static final int IS_SHOW = 0;
    public static final int SUPPORT_ANDROID = 1;
    private static final long serialVersionUID = 466908556479200254L;
    private String adName;
    private int adminId;
    private int appAndroidSupport;
    private String beginTime;
    private String bgColor;
    private String createTime;
    private String describe;
    private String endTime;

    /* renamed from: id  reason: collision with root package name */
    private String f77070id;
    private String img;
    private int isClosable;
    private int isNeedLogin;
    private int isNight;
    private int isShow;
    private String lang;
    private String order;
    private String positionCode;
    private String status;
    private String title;
    private int type;
    private String updateTime;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteHomeActivityEntity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteHomeActivityEntity)) {
            return false;
        }
        LiteHomeActivityEntity liteHomeActivityEntity = (LiteHomeActivityEntity) obj;
        if (!liteHomeActivityEntity.canEqual(this)) {
            return false;
        }
        String adName2 = getAdName();
        String adName3 = liteHomeActivityEntity.getAdName();
        if (adName2 != null ? !adName2.equals(adName3) : adName3 != null) {
            return false;
        }
        String id2 = getId();
        String id3 = liteHomeActivityEntity.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String order2 = getOrder();
        String order3 = liteHomeActivityEntity.getOrder();
        if (order2 != null ? !order2.equals(order3) : order3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = liteHomeActivityEntity.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String img2 = getImg();
        String img3 = liteHomeActivityEntity.getImg();
        if (img2 != null ? !img2.equals(img3) : img3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = liteHomeActivityEntity.getUrl();
        if (url2 != null ? !url2.equals(url3) : url3 != null) {
            return false;
        }
        String bgColor2 = getBgColor();
        String bgColor3 = liteHomeActivityEntity.getBgColor();
        if (bgColor2 != null ? !bgColor2.equals(bgColor3) : bgColor3 != null) {
            return false;
        }
        if (getIsShow() != liteHomeActivityEntity.getIsShow() || getIsClosable() != liteHomeActivityEntity.getIsClosable() || getIsNeedLogin() != liteHomeActivityEntity.getIsNeedLogin() || getType() != liteHomeActivityEntity.getType()) {
            return false;
        }
        String lang2 = getLang();
        String lang3 = liteHomeActivityEntity.getLang();
        if (lang2 != null ? !lang2.equals(lang3) : lang3 != null) {
            return false;
        }
        String beginTime2 = getBeginTime();
        String beginTime3 = liteHomeActivityEntity.getBeginTime();
        if (beginTime2 != null ? !beginTime2.equals(beginTime3) : beginTime3 != null) {
            return false;
        }
        String endTime2 = getEndTime();
        String endTime3 = liteHomeActivityEntity.getEndTime();
        if (endTime2 != null ? !endTime2.equals(endTime3) : endTime3 != null) {
            return false;
        }
        String createTime2 = getCreateTime();
        String createTime3 = liteHomeActivityEntity.getCreateTime();
        if (createTime2 != null ? !createTime2.equals(createTime3) : createTime3 != null) {
            return false;
        }
        String updateTime2 = getUpdateTime();
        String updateTime3 = liteHomeActivityEntity.getUpdateTime();
        if (updateTime2 != null ? !updateTime2.equals(updateTime3) : updateTime3 != null) {
            return false;
        }
        if (getAdminId() != liteHomeActivityEntity.getAdminId()) {
            return false;
        }
        String status2 = getStatus();
        String status3 = liteHomeActivityEntity.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        if (getIsNight() != liteHomeActivityEntity.getIsNight()) {
            return false;
        }
        String positionCode2 = getPositionCode();
        String positionCode3 = liteHomeActivityEntity.getPositionCode();
        if (positionCode2 != null ? !positionCode2.equals(positionCode3) : positionCode3 != null) {
            return false;
        }
        String describe2 = getDescribe();
        String describe3 = liteHomeActivityEntity.getDescribe();
        if (describe2 != null ? describe2.equals(describe3) : describe3 == null) {
            return getAppAndroidSupport() == liteHomeActivityEntity.getAppAndroidSupport();
        }
        return false;
    }

    public String getAdName() {
        return this.adName;
    }

    public int getAdminId() {
        return this.adminId;
    }

    public int getAppAndroidSupport() {
        return this.appAndroidSupport;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getDescribe() {
        return this.describe;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.f77070id;
    }

    public String getImg() {
        return this.img;
    }

    public int getIsClosable() {
        return this.isClosable;
    }

    public int getIsNeedLogin() {
        return this.isNeedLogin;
    }

    public int getIsNight() {
        return this.isNight;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public String getLang() {
        return this.lang;
    }

    public String getOrder() {
        return this.order;
    }

    public String getPositionCode() {
        return this.positionCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String getViewHandlerName() {
        return LiteGalleryViewHandler.class.getName();
    }

    public int hashCode() {
        String adName2 = getAdName();
        int i11 = 43;
        int hashCode = adName2 == null ? 43 : adName2.hashCode();
        String id2 = getId();
        int hashCode2 = ((hashCode + 59) * 59) + (id2 == null ? 43 : id2.hashCode());
        String order2 = getOrder();
        int hashCode3 = (hashCode2 * 59) + (order2 == null ? 43 : order2.hashCode());
        String title2 = getTitle();
        int hashCode4 = (hashCode3 * 59) + (title2 == null ? 43 : title2.hashCode());
        String img2 = getImg();
        int hashCode5 = (hashCode4 * 59) + (img2 == null ? 43 : img2.hashCode());
        String url2 = getUrl();
        int hashCode6 = (hashCode5 * 59) + (url2 == null ? 43 : url2.hashCode());
        String bgColor2 = getBgColor();
        int hashCode7 = (((((((((hashCode6 * 59) + (bgColor2 == null ? 43 : bgColor2.hashCode())) * 59) + getIsShow()) * 59) + getIsClosable()) * 59) + getIsNeedLogin()) * 59) + getType();
        String lang2 = getLang();
        int hashCode8 = (hashCode7 * 59) + (lang2 == null ? 43 : lang2.hashCode());
        String beginTime2 = getBeginTime();
        int hashCode9 = (hashCode8 * 59) + (beginTime2 == null ? 43 : beginTime2.hashCode());
        String endTime2 = getEndTime();
        int hashCode10 = (hashCode9 * 59) + (endTime2 == null ? 43 : endTime2.hashCode());
        String createTime2 = getCreateTime();
        int hashCode11 = (hashCode10 * 59) + (createTime2 == null ? 43 : createTime2.hashCode());
        String updateTime2 = getUpdateTime();
        int hashCode12 = (((hashCode11 * 59) + (updateTime2 == null ? 43 : updateTime2.hashCode())) * 59) + getAdminId();
        String status2 = getStatus();
        int hashCode13 = (((hashCode12 * 59) + (status2 == null ? 43 : status2.hashCode())) * 59) + getIsNight();
        String positionCode2 = getPositionCode();
        int hashCode14 = (hashCode13 * 59) + (positionCode2 == null ? 43 : positionCode2.hashCode());
        String describe2 = getDescribe();
        int i12 = hashCode14 * 59;
        if (describe2 != null) {
            i11 = describe2.hashCode();
        }
        return ((i12 + i11) * 59) + getAppAndroidSupport();
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public void setAdminId(int i11) {
        this.adminId = i11;
    }

    public void setAppAndroidSupport(int i11) {
        this.appAndroidSupport = i11;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(String str) {
        this.f77070id = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setIsClosable(int i11) {
        this.isClosable = i11;
    }

    public void setIsNeedLogin(int i11) {
        this.isNeedLogin = i11;
    }

    public void setIsNight(int i11) {
        this.isNight = i11;
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public void setPositionCode(String str) {
        this.positionCode = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "LiteHomeActivityEntity(adName=" + getAdName() + ", id=" + getId() + ", order=" + getOrder() + ", title=" + getTitle() + ", img=" + getImg() + ", url=" + getUrl() + ", bgColor=" + getBgColor() + ", isShow=" + getIsShow() + ", isClosable=" + getIsClosable() + ", isNeedLogin=" + getIsNeedLogin() + ", type=" + getType() + ", lang=" + getLang() + ", beginTime=" + getBeginTime() + ", endTime=" + getEndTime() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ", adminId=" + getAdminId() + ", status=" + getStatus() + ", isNight=" + getIsNight() + ", positionCode=" + getPositionCode() + ", describe=" + getDescribe() + ", appAndroidSupport=" + getAppAndroidSupport() + ")";
    }
}

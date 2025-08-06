package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AccountNftInfoBean implements Serializable {
    private String buff;
    private int buffShow;
    private String identifier;
    private String img;
    private String imgName;
    private String imgType;
    private String jumpUrl;
    private String nftVerse;
    private String nick;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountNftInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountNftInfoBean)) {
            return false;
        }
        AccountNftInfoBean accountNftInfoBean = (AccountNftInfoBean) obj;
        if (!accountNftInfoBean.canEqual(this)) {
            return false;
        }
        String nick2 = getNick();
        String nick3 = accountNftInfoBean.getNick();
        if (nick2 != null ? !nick2.equals(nick3) : nick3 != null) {
            return false;
        }
        String img2 = getImg();
        String img3 = accountNftInfoBean.getImg();
        if (img2 != null ? !img2.equals(img3) : img3 != null) {
            return false;
        }
        String imgName2 = getImgName();
        String imgName3 = accountNftInfoBean.getImgName();
        if (imgName2 != null ? !imgName2.equals(imgName3) : imgName3 != null) {
            return false;
        }
        if (getBuffShow() != accountNftInfoBean.getBuffShow()) {
            return false;
        }
        String buff2 = getBuff();
        String buff3 = accountNftInfoBean.getBuff();
        if (buff2 != null ? !buff2.equals(buff3) : buff3 != null) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = accountNftInfoBean.getJumpUrl();
        if (jumpUrl2 != null ? !jumpUrl2.equals(jumpUrl3) : jumpUrl3 != null) {
            return false;
        }
        String identifier2 = getIdentifier();
        String identifier3 = accountNftInfoBean.getIdentifier();
        if (identifier2 != null ? !identifier2.equals(identifier3) : identifier3 != null) {
            return false;
        }
        String nftVerse2 = getNftVerse();
        String nftVerse3 = accountNftInfoBean.getNftVerse();
        if (nftVerse2 != null ? !nftVerse2.equals(nftVerse3) : nftVerse3 != null) {
            return false;
        }
        String imgType2 = getImgType();
        String imgType3 = accountNftInfoBean.getImgType();
        return imgType2 != null ? imgType2.equals(imgType3) : imgType3 == null;
    }

    public String getBuff() {
        return this.buff;
    }

    public int getBuffShow() {
        return this.buffShow;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getImg() {
        return this.img;
    }

    public String getImgName() {
        return this.imgName;
    }

    public String getImgType() {
        return this.imgType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getNftVerse() {
        return this.nftVerse;
    }

    public String getNick() {
        return this.nick;
    }

    public int hashCode() {
        String nick2 = getNick();
        int i11 = 43;
        int hashCode = nick2 == null ? 43 : nick2.hashCode();
        String img2 = getImg();
        int hashCode2 = ((hashCode + 59) * 59) + (img2 == null ? 43 : img2.hashCode());
        String imgName2 = getImgName();
        int hashCode3 = (((hashCode2 * 59) + (imgName2 == null ? 43 : imgName2.hashCode())) * 59) + getBuffShow();
        String buff2 = getBuff();
        int hashCode4 = (hashCode3 * 59) + (buff2 == null ? 43 : buff2.hashCode());
        String jumpUrl2 = getJumpUrl();
        int hashCode5 = (hashCode4 * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
        String identifier2 = getIdentifier();
        int hashCode6 = (hashCode5 * 59) + (identifier2 == null ? 43 : identifier2.hashCode());
        String nftVerse2 = getNftVerse();
        int hashCode7 = (hashCode6 * 59) + (nftVerse2 == null ? 43 : nftVerse2.hashCode());
        String imgType2 = getImgType();
        int i12 = hashCode7 * 59;
        if (imgType2 != null) {
            i11 = imgType2.hashCode();
        }
        return i12 + i11;
    }

    public void setBuff(String str) {
        this.buff = str;
    }

    public void setBuffShow(int i11) {
        this.buffShow = i11;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setImgName(String str) {
        this.imgName = str;
    }

    public void setImgType(String str) {
        this.imgType = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setNftVerse(String str) {
        this.nftVerse = str;
    }

    public void setNick(String str) {
        this.nick = str;
    }

    public String toString() {
        return "AccountNftInfoBean(nick=" + getNick() + ", img=" + getImg() + ", imgName=" + getImgName() + ", buffShow=" + getBuffShow() + ", buff=" + getBuff() + ", jumpUrl=" + getJumpUrl() + ", identifier=" + getIdentifier() + ", nftVerse=" + getNftVerse() + ", imgType=" + getImgType() + ")";
    }
}

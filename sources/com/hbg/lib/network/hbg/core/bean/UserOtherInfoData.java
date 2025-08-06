package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserOtherInfoData implements Serializable {
    public static String HEAD_IMAGE_TYPE_NFT = "NFT";
    public static String NICK_NAME_TYPE_DID = "DID";
    private String email;
    private String frame_url;
    private String head_image;
    private String head_image_type;
    private String intro;
    private String kyc_level;
    private String kyc_type;
    private String nft_rarity;
    private String nick_name;
    private String nick_name_type;
    private String phone;
    private String show_ext_business_tag;
    private String uid;
    private String user_id;

    public String getEmail() {
        return this.email;
    }

    public String getFrame_url() {
        return this.frame_url;
    }

    public String getHead_image() {
        return this.head_image;
    }

    public String getHead_image_type() {
        return this.head_image_type;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getKyc_level() {
        return this.kyc_level;
    }

    public String getKyc_type() {
        return this.kyc_type;
    }

    public String getNft_rarity() {
        return this.nft_rarity;
    }

    public String getNick_name() {
        return this.nick_name;
    }

    public String getNick_name_type() {
        return this.nick_name_type;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getShow_ext_business_tag() {
        return this.show_ext_business_tag;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFrame_url(String str) {
        this.frame_url = str;
    }

    public void setHead_image(String str) {
        this.head_image = str;
    }

    public void setHead_image_type(String str) {
        this.head_image_type = str;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setKyc_level(String str) {
        this.kyc_level = str;
    }

    public void setKyc_type(String str) {
        this.kyc_type = str;
    }

    public void setNft_rarity(String str) {
        this.nft_rarity = str;
    }

    public void setNick_name(String str) {
        this.nick_name = str;
    }

    public void setNick_name_type(String str) {
        this.nick_name_type = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setShow_ext_business_tag(String str) {
        this.show_ext_business_tag = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }
}

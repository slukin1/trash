package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;
import kotlin.jvm.internal.r;

public final class ChatBlockEntity implements Serializable {
    private String account;
    private String avatar;
    private int blockState;
    private String nickname;

    public ChatBlockEntity() {
        this((String) null, (String) null, (String) null, 0, 15, (r) null);
    }

    public ChatBlockEntity(String str, String str2, String str3, int i11) {
        this.nickname = str;
        this.avatar = str2;
        this.account = str3;
        this.blockState = i11;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getBlockState() {
        return this.blockState;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setAccount(String str) {
        this.account = str;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBlockState(int i11) {
        this.blockState = i11;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatBlockEntity(String str, String str2, String str3, int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? 1 : i11);
    }
}

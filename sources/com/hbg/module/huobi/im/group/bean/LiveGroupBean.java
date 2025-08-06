package com.hbg.module.huobi.im.group.bean;

import java.io.Serializable;
import java.util.List;

public final class LiveGroupBean implements Serializable {
    private Integer appointed;
    private Long currentTime;

    /* renamed from: id  reason: collision with root package name */
    private Integer f19877id;
    private List<Speaker> speakerList;
    private Long startTime;
    private Integer status;
    private String title;

    public static final class Speaker implements Serializable {
        private String avatar;
        private String nickname;
        private String showId;

        public final String getAvatar() {
            return this.avatar;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final String getShowId() {
            return this.showId;
        }

        public final void setAvatar(String str) {
            this.avatar = str;
        }

        public final void setNickname(String str) {
            this.nickname = str;
        }

        public final void setShowId(String str) {
            this.showId = str;
        }
    }

    public final Integer getAppointed() {
        return this.appointed;
    }

    public final Long getCurrentTime() {
        return this.currentTime;
    }

    public final Integer getId() {
        return this.f19877id;
    }

    public final List<Speaker> getSpeakerList() {
        return this.speakerList;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAppointed(Integer num) {
        this.appointed = num;
    }

    public final void setCurrentTime(Long l11) {
        this.currentTime = l11;
    }

    public final void setId(Integer num) {
        this.f19877id = num;
    }

    public final void setSpeakerList(List<Speaker> list) {
        this.speakerList = list;
    }

    public final void setStartTime(Long l11) {
        this.startTime = l11;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}

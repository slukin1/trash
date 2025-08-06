package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class IndexLive implements Serializable {
    @SerializedName("appointedNum")
    public Integer appointedNum;
    @SerializedName("avatar")
    public String avatar;
    @SerializedName("coverImageUrl")
    public String coverImageUrl;
    @SerializedName("createTime")
    public Long createTime;
    @SerializedName("finishTime")
    public Long finishTime;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public Integer f73197id;
    @SerializedName("nickname")
    public String nickname;
    @SerializedName("onlineNum")
    public Integer onlineNum;
    @SerializedName("showId")
    public Integer showId;
    @SerializedName("speakerList")
    public List<SpeakerListDTO> speakerListX;
    @SerializedName("startTime")
    public Long startTime;
    @SerializedName("status")
    public Integer status;
    @SerializedName("title")
    public String title;

    public static class SpeakerListDTO {
        @SerializedName("avatar")

        /* renamed from: a  reason: collision with root package name */
        public String f73198a;
        @SerializedName("nickname")

        /* renamed from: b  reason: collision with root package name */
        public String f73199b;
        @SerializedName("showId")

        /* renamed from: c  reason: collision with root package name */
        public String f73200c;
        @SerializedName("uidUnique")

        /* renamed from: d  reason: collision with root package name */
        public String f73201d;

        public boolean a(Object obj) {
            return obj instanceof SpeakerListDTO;
        }

        public String b() {
            return this.f73198a;
        }

        public String c() {
            return this.f73199b;
        }

        public String d() {
            return this.f73200c;
        }

        public String e() {
            return this.f73201d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SpeakerListDTO)) {
                return false;
            }
            SpeakerListDTO speakerListDTO = (SpeakerListDTO) obj;
            if (!speakerListDTO.a(this)) {
                return false;
            }
            String b11 = b();
            String b12 = speakerListDTO.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = speakerListDTO.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String d11 = d();
            String d12 = speakerListDTO.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            String e11 = e();
            String e12 = speakerListDTO.e();
            return e11 != null ? e11.equals(e12) : e12 == null;
        }

        public int hashCode() {
            String b11 = b();
            int i11 = 43;
            int hashCode = b11 == null ? 43 : b11.hashCode();
            String c11 = c();
            int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
            String d11 = d();
            int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
            String e11 = e();
            int i12 = hashCode3 * 59;
            if (e11 != null) {
                i11 = e11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "IndexLive.SpeakerListDTO(avatarX=" + b() + ", nicknameX=" + c() + ", showIdX=" + d() + ", uidUnique=" + e() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof IndexLive;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexLive)) {
            return false;
        }
        IndexLive indexLive = (IndexLive) obj;
        if (!indexLive.canEqual(this)) {
            return false;
        }
        Integer appointedNum2 = getAppointedNum();
        Integer appointedNum3 = indexLive.getAppointedNum();
        if (appointedNum2 != null ? !appointedNum2.equals(appointedNum3) : appointedNum3 != null) {
            return false;
        }
        String avatar2 = getAvatar();
        String avatar3 = indexLive.getAvatar();
        if (avatar2 != null ? !avatar2.equals(avatar3) : avatar3 != null) {
            return false;
        }
        String coverImageUrl2 = getCoverImageUrl();
        String coverImageUrl3 = indexLive.getCoverImageUrl();
        if (coverImageUrl2 != null ? !coverImageUrl2.equals(coverImageUrl3) : coverImageUrl3 != null) {
            return false;
        }
        Long createTime2 = getCreateTime();
        Long createTime3 = indexLive.getCreateTime();
        if (createTime2 != null ? !createTime2.equals(createTime3) : createTime3 != null) {
            return false;
        }
        Integer id2 = getId();
        Integer id3 = indexLive.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String nickname2 = getNickname();
        String nickname3 = indexLive.getNickname();
        if (nickname2 != null ? !nickname2.equals(nickname3) : nickname3 != null) {
            return false;
        }
        Integer onlineNum2 = getOnlineNum();
        Integer onlineNum3 = indexLive.getOnlineNum();
        if (onlineNum2 != null ? !onlineNum2.equals(onlineNum3) : onlineNum3 != null) {
            return false;
        }
        Integer showId2 = getShowId();
        Integer showId3 = indexLive.getShowId();
        if (showId2 != null ? !showId2.equals(showId3) : showId3 != null) {
            return false;
        }
        Integer status2 = getStatus();
        Integer status3 = indexLive.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = indexLive.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        Long startTime2 = getStartTime();
        Long startTime3 = indexLive.getStartTime();
        if (startTime2 != null ? !startTime2.equals(startTime3) : startTime3 != null) {
            return false;
        }
        Long finishTime2 = getFinishTime();
        Long finishTime3 = indexLive.getFinishTime();
        if (finishTime2 != null ? !finishTime2.equals(finishTime3) : finishTime3 != null) {
            return false;
        }
        List<SpeakerListDTO> speakerListX2 = getSpeakerListX();
        List<SpeakerListDTO> speakerListX3 = indexLive.getSpeakerListX();
        return speakerListX2 != null ? speakerListX2.equals(speakerListX3) : speakerListX3 == null;
    }

    public Integer getAppointedNum() {
        return this.appointedNum;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Long getFinishTime() {
        return this.finishTime;
    }

    public Integer getId() {
        return this.f73197id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Integer getOnlineNum() {
        return this.onlineNum;
    }

    public Integer getShowId() {
        return this.showId;
    }

    public List<SpeakerListDTO> getSpeakerListX() {
        return this.speakerListX;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer appointedNum2 = getAppointedNum();
        int i11 = 43;
        int hashCode = appointedNum2 == null ? 43 : appointedNum2.hashCode();
        String avatar2 = getAvatar();
        int hashCode2 = ((hashCode + 59) * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
        String coverImageUrl2 = getCoverImageUrl();
        int hashCode3 = (hashCode2 * 59) + (coverImageUrl2 == null ? 43 : coverImageUrl2.hashCode());
        Long createTime2 = getCreateTime();
        int hashCode4 = (hashCode3 * 59) + (createTime2 == null ? 43 : createTime2.hashCode());
        Integer id2 = getId();
        int hashCode5 = (hashCode4 * 59) + (id2 == null ? 43 : id2.hashCode());
        String nickname2 = getNickname();
        int hashCode6 = (hashCode5 * 59) + (nickname2 == null ? 43 : nickname2.hashCode());
        Integer onlineNum2 = getOnlineNum();
        int hashCode7 = (hashCode6 * 59) + (onlineNum2 == null ? 43 : onlineNum2.hashCode());
        Integer showId2 = getShowId();
        int hashCode8 = (hashCode7 * 59) + (showId2 == null ? 43 : showId2.hashCode());
        Integer status2 = getStatus();
        int hashCode9 = (hashCode8 * 59) + (status2 == null ? 43 : status2.hashCode());
        String title2 = getTitle();
        int hashCode10 = (hashCode9 * 59) + (title2 == null ? 43 : title2.hashCode());
        Long startTime2 = getStartTime();
        int hashCode11 = (hashCode10 * 59) + (startTime2 == null ? 43 : startTime2.hashCode());
        Long finishTime2 = getFinishTime();
        int hashCode12 = (hashCode11 * 59) + (finishTime2 == null ? 43 : finishTime2.hashCode());
        List<SpeakerListDTO> speakerListX2 = getSpeakerListX();
        int i12 = hashCode12 * 59;
        if (speakerListX2 != null) {
            i11 = speakerListX2.hashCode();
        }
        return i12 + i11;
    }

    public void setAppointedNum(Integer num) {
        this.appointedNum = num;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCoverImageUrl(String str) {
        this.coverImageUrl = str;
    }

    public void setCreateTime(Long l11) {
        this.createTime = l11;
    }

    public void setFinishTime(Long l11) {
        this.finishTime = l11;
    }

    public void setId(Integer num) {
        this.f73197id = num;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOnlineNum(Integer num) {
        this.onlineNum = num;
    }

    public void setShowId(Integer num) {
        this.showId = num;
    }

    public void setSpeakerListX(List<SpeakerListDTO> list) {
        this.speakerListX = list;
    }

    public void setStartTime(Long l11) {
        this.startTime = l11;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "IndexLive(appointedNum=" + getAppointedNum() + ", avatar=" + getAvatar() + ", coverImageUrl=" + getCoverImageUrl() + ", createTime=" + getCreateTime() + ", id=" + getId() + ", nickname=" + getNickname() + ", onlineNum=" + getOnlineNum() + ", showId=" + getShowId() + ", status=" + getStatus() + ", title=" + getTitle() + ", startTime=" + getStartTime() + ", finishTime=" + getFinishTime() + ", speakerListX=" + getSpeakerListX() + ")";
    }
}

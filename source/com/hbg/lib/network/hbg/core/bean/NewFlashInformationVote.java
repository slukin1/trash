package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class NewFlashInformationVote implements Serializable {
    private static final long serialVersionUID = 7155096726840307001L;
    private int badVote;
    private int bullVote;
    private int votedType;

    public boolean canEqual(Object obj) {
        return obj instanceof NewFlashInformationVote;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewFlashInformationVote)) {
            return false;
        }
        NewFlashInformationVote newFlashInformationVote = (NewFlashInformationVote) obj;
        return newFlashInformationVote.canEqual(this) && getBullVote() == newFlashInformationVote.getBullVote() && getBadVote() == newFlashInformationVote.getBadVote() && getVotedType() == newFlashInformationVote.getVotedType();
    }

    public int getBadVote() {
        return this.badVote;
    }

    public int getBullVote() {
        return this.bullVote;
    }

    public int getVotedType() {
        return this.votedType;
    }

    public int hashCode() {
        return ((((getBullVote() + 59) * 59) + getBadVote()) * 59) + getVotedType();
    }

    public void setBadVote(int i11) {
        this.badVote = i11;
    }

    public void setBullVote(int i11) {
        this.bullVote = i11;
    }

    public void setVotedType(int i11) {
        this.votedType = i11;
    }

    public String toString() {
        return "NewFlashInformationVote(bullVote=" + getBullVote() + ", badVote=" + getBadVote() + ", votedType=" + getVotedType() + ")";
    }
}

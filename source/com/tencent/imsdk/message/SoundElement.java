package com.tencent.imsdk.message;

public class SoundElement extends MessageBaseElement {
    private int soundBusinessID;
    private String soundDownloadUrl;
    private int soundDuration;
    private String soundFilePath;
    private int soundFileSize;
    private String soundUUID;

    public SoundElement() {
        setElementType(4);
    }

    public int getSoundBusinessID() {
        return this.soundBusinessID;
    }

    public String getSoundDownloadUrl() {
        return this.soundDownloadUrl;
    }

    public int getSoundDuration() {
        return this.soundDuration;
    }

    public String getSoundFilePath() {
        return this.soundFilePath;
    }

    public int getSoundFileSize() {
        return this.soundFileSize;
    }

    public String getSoundUUID() {
        return this.soundUUID;
    }

    public void setSoundDuration(int i11) {
        this.soundDuration = i11;
    }

    public void setSoundFilePath(String str) {
        this.soundFilePath = str;
    }

    public void setSoundFileSize(int i11) {
        this.soundFileSize = i11;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType != messageBaseElement.elementType) {
            return false;
        }
        SoundElement soundElement = (SoundElement) messageBaseElement;
        if (!this.soundFilePath.equals(soundElement.soundFilePath)) {
            return false;
        }
        this.soundUUID = soundElement.soundUUID;
        this.soundFileSize = soundElement.soundFileSize;
        this.soundDuration = soundElement.soundDuration;
        this.soundDownloadUrl = soundElement.soundDownloadUrl;
        this.soundBusinessID = soundElement.soundBusinessID;
        return true;
    }
}

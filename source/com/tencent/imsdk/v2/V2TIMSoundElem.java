package com.tencent.imsdk.v2;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMSoundElem extends V2TIMElem {
    public void downloadSound(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() != null) {
            SoundElement soundElement = (SoundElement) getElement();
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(soundElement.getSoundDownloadUrl());
            downloadParam.setUuid(getUUID());
            downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_AUDIO);
            downloadParam.setBusinessID(soundElement.getSoundBusinessID());
            downloadParam.setFileSavePath(str);
            MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() {
                public void onError(int i11, String str) {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onError(i11, str);
                    }
                }

                public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                    V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onProgress(v2ProgressInfo);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(DownloadProgressInfo downloadProgressInfo) {
                    super.success(downloadProgressInfo);
                }
            }, new IMCallback(new V2TIMCallback() {
                public void onError(int i11, String str) {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onError(i11, str);
                    }
                }

                public void onSuccess() {
                    V2TIMDownloadCallback v2TIMDownloadCallback = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback != null) {
                        v2TIMDownloadCallback.onSuccess();
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public int getDataSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((SoundElement) getElement()).getSoundFileSize();
    }

    public int getDuration() {
        if (getElement() == null) {
            return 0;
        }
        return ((SoundElement) getElement()).getSoundDuration();
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        return ((SoundElement) getElement()).getSoundFilePath();
    }

    public String getUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((SoundElement) getElement()).getSoundUUID();
    }

    public void getUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback != null) {
            if (getElement() == null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
            } else {
                v2TIMValueCallback.onSuccess(((SoundElement) getElement()).getSoundDownloadUrl());
            }
        }
    }

    public String toString() {
        return "V2TIMSoundElem--->" + "uuid:" + getUUID() + ", sender local path:" + getPath() + ", duration:" + getDuration() + ", dataSize:" + getDataSize();
    }
}

package com.tencent.imsdk.v2;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMVideoElem extends V2TIMElem {
    public void downloadSnapshot(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() != null) {
            VideoElement videoElement = (VideoElement) getElement();
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(videoElement.getSnapshotDownloadUrl());
            downloadParam.setUuid(videoElement.getSnapshotUUID());
            downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO_THUMB);
            downloadParam.setBusinessID(videoElement.getVideoBusinessID());
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

    public void downloadVideo(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() != null) {
            VideoElement videoElement = (VideoElement) getElement();
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(videoElement.getVideoDownloadUrl());
            downloadParam.setUuid(videoElement.getVideoUUID());
            downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_VIDEO);
            downloadParam.setBusinessID(videoElement.getVideoBusinessID());
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
        } else if (v2TIMDownloadCallback != null) {
            v2TIMDownloadCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "getTIMElem is null");
        }
    }

    public int getDuration() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getVideoDuration();
    }

    public int getSnapshotHeight() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotHeight();
    }

    public String getSnapshotPath() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getSnapshotFilePath();
    }

    public int getSnapshotSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotFileSize();
    }

    public String getSnapshotUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getSnapshotUUID();
    }

    public void getSnapshotUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback != null) {
            if (getElement() == null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
            } else {
                v2TIMValueCallback.onSuccess(((VideoElement) getElement()).getSnapshotDownloadUrl());
            }
        }
    }

    public int getSnapshotWidth() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getSnapshotWidth();
    }

    public String getVideoPath() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getVideoFilePath();
    }

    public int getVideoSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((VideoElement) getElement()).getVideoFileSize();
    }

    public String getVideoUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((VideoElement) getElement()).getVideoUUID();
    }

    public void getVideoUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback != null) {
            if (getElement() == null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
            } else {
                v2TIMValueCallback.onSuccess(((VideoElement) getElement()).getVideoDownloadUrl());
            }
        }
    }

    public String toString() {
        return "V2TIMVideoElem--->" + "video uuid:" + getVideoUUID() + ", snapshot uuid:" + getSnapshotUUID() + ", duration:" + getDuration() + ", sender local video path:" + getVideoPath() + ", video size:" + getVideoSize() + ", sender local snapshot path" + getSnapshotPath() + ", snapshot height:" + getSnapshotHeight() + ", snapshot width:" + getSnapshotWidth() + ", snapshot size:" + getSnapshotSize();
    }
}

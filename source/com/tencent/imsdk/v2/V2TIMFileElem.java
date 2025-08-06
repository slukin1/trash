package com.tencent.imsdk.v2;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.v2.V2TIMElem;

public class V2TIMFileElem extends V2TIMElem {
    public void downloadFile(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
        if (getElement() != null) {
            FileElement fileElement = (FileElement) getElement();
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadUrl(fileElement.getFileDownloadUrl());
            downloadParam.setUuid(getUUID());
            downloadParam.setUuidType(MessageBaseElement.UUID_TYPE_FILE);
            downloadParam.setBusinessID(fileElement.getFileBusinessID());
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

    public String getFileName() {
        if (getElement() == null) {
            return null;
        }
        return ((FileElement) getElement()).getFileName();
    }

    public int getFileSize() {
        if (getElement() == null) {
            return 0;
        }
        return ((FileElement) getElement()).getFileSize();
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        return ((FileElement) getElement()).getFilePath();
    }

    public String getUUID() {
        if (getElement() == null) {
            return null;
        }
        return ((FileElement) getElement()).getFileUUID();
    }

    public void getUrl(V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMValueCallback != null) {
            if (getElement() == null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "elem is null");
            } else {
                v2TIMValueCallback.onSuccess(((FileElement) getElement()).getFileDownloadUrl());
            }
        }
    }

    public String toString() {
        return "V2TIMFileElem--->" + "uuid:" + getUUID() + ", sender local path:" + getPath() + ", file name:" + getFileName() + ", file size:" + getFileSize();
    }
}

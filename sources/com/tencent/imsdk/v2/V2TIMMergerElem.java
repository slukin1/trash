package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import java.util.ArrayList;
import java.util.List;

public class V2TIMMergerElem extends V2TIMElem {
    public void downloadMergerMessage(final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (getElement() != null) {
            MessageCenter.getInstance().downloadRelayMessageList(getMessage(), new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<Message> list) {
                    super.success(list);
                }
            });
        }
    }

    public List<String> getAbstractList() {
        if (getElement() == null) {
            return null;
        }
        return ((MergerElement) getElement()).getAbstractList();
    }

    public String getTitle() {
        if (getElement() == null) {
            return null;
        }
        return ((MergerElement) getElement()).getTitle();
    }

    public boolean isLayersOverLimit() {
        if (getElement() == null) {
            return false;
        }
        return ((MergerElement) getElement()).isLayerOverLimit();
    }

    public String toString() {
        return "V2TIMRelayElem--->" + "title:" + getTitle() + ", abstractList:" + getAbstractList();
    }
}

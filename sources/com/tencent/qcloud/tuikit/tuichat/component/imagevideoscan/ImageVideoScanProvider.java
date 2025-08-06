package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageVideoScanProvider {
    public static final int SCAN_MESSAGE_NUM = 10;
    public static final int SCAN_MESSAGE_REQUEST_NUM = 20;
    /* access modifiers changed from: private */
    public static final String TAG = "ImageVideoScanProvider";

    public void MessageProvider() {
    }

    public void initMessageList(String str, boolean z11, TUIMessageBean tUIMessageBean, IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        if (tUIMessageBean.getStatus() != 1) {
            final TUIMessageBean tUIMessageBean2 = tUIMessageBean;
            final String str2 = str;
            final boolean z12 = z11;
            final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback2 = iUIKitCallback;
            loadLocalMediaMessageList(str, z11, 20, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback2, ImageVideoScanProvider.TAG, i11, str2);
                    String access$000 = ImageVideoScanProvider.TAG;
                    TUIChatLog.e(access$000, "loadChatMessages getHistoryMessageList GET_MESSAGE_BACKWARD failed, code = " + i11 + ", desc = " + str2);
                }

                public void onSuccess(final List<TUIMessageBean> list) {
                    list.add(0, tUIMessageBean2);
                    ImageVideoScanProvider.this.loadLocalMediaMessageList(str2, z12, 20, tUIMessageBean2, 0, new IUIKitCallback<List<TUIMessageBean>>() {
                        public void onError(String str, int i11, String str2) {
                            TUIChatUtils.callbackOnSuccess(iUIKitCallback2, list);
                            String access$000 = ImageVideoScanProvider.TAG;
                            TUIChatLog.e(access$000, "loadChatMessages getHistoryMessageList GET_MESSAGE_FORWARD failed, code = " + i11 + ", desc = " + str2);
                        }

                        public void onSuccess(List<TUIMessageBean> list) {
                            Collections.reverse(list);
                            list.addAll(list);
                            TUIChatUtils.callbackOnSuccess(iUIKitCallback2, list);
                        }
                    });
                }
            });
        }
    }

    public void loadLocalMediaMessageBackward(String str, boolean z11, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        loadLocalMediaMessageList(str, z11, 20, tUIMessageBean, 1, new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i11, str2);
                String access$000 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages loadLocalMediaMessageBackward failed, code = " + i11 + ", desc = " + str2);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
            }
        });
    }

    public void loadLocalMediaMessageForward(String str, boolean z11, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        loadLocalMediaMessageList(str, z11, 20, tUIMessageBean, 0, new IUIKitCallback<List<TUIMessageBean>>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i11, str2);
                String access$000 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages loadLocalMediaMessageForward failed, code = " + i11 + ", desc = " + str2);
            }

            public void onSuccess(List<TUIMessageBean> list) {
                Collections.reverse(list);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
            }
        });
    }

    public void loadLocalMediaMessageList(String str, boolean z11, int i11, TUIMessageBean tUIMessageBean, final int i12, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(5);
        v2TIMMessageListGetOption.setMessageTypeList(arrayList);
        if (i12 == 0) {
            v2TIMMessageListGetOption.setGetType(3);
        } else if (i12 == 1) {
            v2TIMMessageListGetOption.setGetType(4);
        }
        if (tUIMessageBean != null) {
            v2TIMMessageListGetOption.setLastMsg(tUIMessageBean.getV2TIMMessage());
        }
        if (z11) {
            v2TIMMessageListGetOption.setGroupID(str);
        } else {
            v2TIMMessageListGetOption.setUserID(str);
        }
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ImageVideoScanProvider.TAG, i11, str);
                String access$000 = ImageVideoScanProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i11 + ", desc = " + str);
            }

            public void onSuccess(List<V2TIMMessage> list) {
                if (list.isEmpty()) {
                    TUIChatLog.d(ImageVideoScanProvider.TAG, "getHistoryMessageList is null");
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, new ArrayList());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (V2TIMMessage next : list) {
                    String access$000 = ImageVideoScanProvider.TAG;
                    TUIChatLog.d(access$000, "loadLocalMediaMessageList getType = " + i12 + "timMessage seq = " + next.getSeq());
                    int status = next.getStatus();
                    if (!(status == 4 || status == 6)) {
                        arrayList.add(next);
                    }
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(arrayList));
            }
        });
    }
}

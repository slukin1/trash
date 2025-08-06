package com.tencent.qcloud.tuikit.tuichat.util;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageCustom;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageTyping;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatMessageParser {
    private static final String TAG = "ChatMessageParser";
    private static Map<Integer, Class<? extends TUIMessageBean>> messageTypeMap;

    static {
        HashMap hashMap = new HashMap();
        messageTypeMap = hashMap;
        hashMap.put(1, TextMessageBean.class);
        messageTypeMap.put(3, ImageMessageBean.class);
        messageTypeMap.put(4, SoundMessageBean.class);
        messageTypeMap.put(5, VideoMessageBean.class);
        messageTypeMap.put(6, FileMessageBean.class);
        messageTypeMap.put(7, LocationMessageBean.class);
        messageTypeMap.put(8, FaceMessageBean.class);
        messageTypeMap.put(9, TipsMessageBean.class);
        messageTypeMap.put(10, MergeMessageBean.class);
        messageTypeMap.put(2, TUIMessageBean.class);
    }

    private static String getCustomBusinessId(V2TIMMessage v2TIMMessage) {
        HashMap hashMap;
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        if (customElem == null || customElem.getData() == null || customElem.getData().length == 0) {
            return null;
        }
        try {
            hashMap = (HashMap) new Gson().fromJson(new String(customElem.getData()), HashMap.class);
        } catch (JsonSyntaxException unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
            hashMap = null;
        }
        Object obj = hashMap != null ? hashMap.get("businessID") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static String getDisplayName(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNameCard())) {
            return v2TIMMessage.getNameCard();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getFriendRemark())) {
            return v2TIMMessage.getFriendRemark();
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNickName())) {
            return v2TIMMessage.getNickName();
        }
        return v2TIMMessage.getSender();
    }

    public static String getDisplayString(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseMessage;
        String str;
        String str2;
        if (v2TIMMessage == null || (parseMessage = parseMessage(v2TIMMessage)) == null) {
            return null;
        }
        if (parseMessage.getStatus() != 275) {
            str = parseMessage.onGetDisplayString();
        } else if (parseMessage.isSelf()) {
            str = ServiceInitializer.getAppContext().getString(R.string.n_group_message_revoked_owner);
        } else if (parseMessage.isGroup()) {
            if (TextUtils.isEmpty(parseMessage.getNameCard())) {
                str2 = parseMessage.getSender();
            } else {
                str2 = parseMessage.getNameCard();
            }
            String covert2HTMLString = TUIChatConstants.covert2HTMLString(str2);
            str = ServiceInitializer.getAppContext().getString(R.string.n_group_message_revoked_others, new Object[]{covert2HTMLString});
        } else {
            str = ServiceInitializer.getAppContext().getString(R.string.revoke_tips_other);
        }
        return FaceManager.emojiJudge(str);
    }

    public static String getLocalImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        if (tUIMessageBean == null || !tUIMessageBean.isSelf() || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || v2TIMMessage.getElemType() != 3 || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String path = imageElem.getPath();
        if (new File(path).exists()) {
            return path;
        }
        return null;
    }

    public static String getMsgTypeStr(int i11) {
        switch (i11) {
            case 3:
                return ServiceInitializer.getAppContext().getString(R.string.picture_extra);
            case 4:
                return ServiceInitializer.getAppContext().getString(R.string.audio_extra);
            case 5:
                return ServiceInitializer.getAppContext().getString(R.string.video_extra);
            case 6:
                return ServiceInitializer.getAppContext().getString(R.string.file_extra);
            case 7:
                return ServiceInitializer.getAppContext().getString(R.string.location_extra);
            case 8:
                return ServiceInitializer.getAppContext().getString(R.string.custom_emoji);
            default:
                return "";
        }
    }

    public static String getReplyMessageAbstract(TUIMessageBean tUIMessageBean) {
        String str;
        if (tUIMessageBean == null) {
            return "";
        }
        if (tUIMessageBean instanceof TextMessageBean) {
            str = ((TextMessageBean) tUIMessageBean).getText();
        } else if (tUIMessageBean instanceof MergeMessageBean) {
            str = ((MergeMessageBean) tUIMessageBean).getTitle();
        } else if (tUIMessageBean instanceof FileMessageBean) {
            str = ((FileMessageBean) tUIMessageBean).getFileName();
        } else if (tUIMessageBean instanceof CustomLinkMessageBean) {
            str = ((CustomLinkMessageBean) tUIMessageBean).getText();
        } else if ((tUIMessageBean instanceof SoundMessageBean) || (tUIMessageBean instanceof ImageMessageBean) || (tUIMessageBean instanceof VideoMessageBean) || (tUIMessageBean instanceof LocationMessageBean) || (tUIMessageBean instanceof FaceMessageBean)) {
            str = "";
        } else {
            str = tUIMessageBean.getExtra();
        }
        return "" + str;
    }

    public static boolean isFileType(int i11) {
        return i11 == 6;
    }

    public static boolean isTyping(byte[] bArr) {
        try {
            MessageTyping messageTyping = (MessageTyping) new Gson().fromJson(new String(bArr, "UTF-8"), MessageTyping.class);
            if (messageTyping == null || messageTyping.userAction != 14 || !TextUtils.equals(messageTyping.actionParam, MessageTyping.EDIT_START)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            TUIChatLog.e(TAG, "parse json error");
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean parseCallingMessage(com.tencent.imsdk.v2.V2TIMMessage r5) {
        /*
            com.tencent.qcloud.tuikit.tuichat.bean.CallModel r0 = com.tencent.qcloud.tuikit.tuichat.bean.CallModel.convert2VideoCallData(r5)
            if (r0 != 0) goto L_0x0008
            r5 = 0
            return r5
        L_0x0008:
            int r1 = r0.getParticipantType()
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0013
            r1 = r4
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            if (r1 == 0) goto L_0x002d
            com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean r1 = new com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean
            r1.<init>()
            r1.setCommonAttribute(r5)
            java.lang.String r5 = r0.getContent()
            r1.setText(r5)
            java.lang.String r5 = r0.getContent()
            r1.setExtra(r5)
            goto L_0x0062
        L_0x002d:
            com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean r1 = new com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean
            r1.<init>()
            r1.setCommonAttribute(r5)
            java.lang.String r5 = r0.getContent()
            r1.setText(r5)
            java.lang.String r5 = r0.getContent()
            r1.setExtra(r5)
            int r5 = r0.getStreamMediaType()
            r1.setCallType(r5)
            int r5 = r0.getDirection()
            if (r5 != r4) goto L_0x0051
            r3 = r4
        L_0x0051:
            r1.setCaller(r3)
            boolean r5 = r0.isShowUnreadPoint()
            r1.setShowUnreadPoint(r5)
            boolean r5 = r0.isUseReceiverAvatar()
            r1.setUseMsgReceiverAvatar(r5)
        L_0x0062:
            boolean r5 = r0.isExcludeFromHistory()
            r1.setExcludeFromHistory(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser.parseCallingMessage(com.tencent.imsdk.v2.V2TIMMessage):com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean");
    }

    private static TUIMessageBean parseCustomMessage(V2TIMMessage v2TIMMessage) {
        TUIMessageBean parseCallingMessage = parseCallingMessage(v2TIMMessage);
        if (parseCallingMessage == null) {
            TUIMessageBean parseGroupCreateMessage = parseGroupCreateMessage(v2TIMMessage);
            if (parseGroupCreateMessage == null) {
                parseGroupCreateMessage = parseCustomMessageFromMap(v2TIMMessage);
            }
            if (parseGroupCreateMessage != null) {
                return parseGroupCreateMessage;
            }
            TextMessageBean textMessageBean = new TextMessageBean();
            textMessageBean.setText(ServiceInitializer.getAppContext().getString(R.string.no_support_msg));
            return textMessageBean;
        } else if (parseCallingMessage.isExcludeFromHistory()) {
            return null;
        } else {
            return parseCallingMessage;
        }
    }

    private static TUIMessageBean parseCustomMessageFromMap(V2TIMMessage v2TIMMessage) {
        Class<? extends TUIMessageBean> messageBeanClass = TUIChatService.getInstance().getMessageBeanClass(getCustomBusinessId(v2TIMMessage));
        if (messageBeanClass == null) {
            return null;
        }
        try {
            return (TUIMessageBean) messageBeanClass.newInstance();
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (InstantiationException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    private static TUIMessageBean parseGroupCreateMessage(V2TIMMessage v2TIMMessage) {
        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
        if (!(customElem == null || customElem.getData() == null || customElem.getData().length == 0)) {
            String str = new String(customElem.getData());
            Gson gson = new Gson();
            if (str.equals(MessageCustom.BUSINESS_ID_GROUP_CREATE)) {
                TipsMessageBean tipsMessageBean = new TipsMessageBean();
                tipsMessageBean.setCommonAttribute(v2TIMMessage);
                tipsMessageBean.setTipType(257);
                String str2 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + ServiceInitializer.getAppContext().getString(R.string.create_group);
                tipsMessageBean.setText(str2);
                tipsMessageBean.setExtra(str2);
                return tipsMessageBean;
            } else if (isTyping(customElem.getData())) {
                return null;
            } else {
                TUIChatLog.i(TAG, "custom data:" + str);
                try {
                    MessageCustom messageCustom = (MessageCustom) gson.fromJson(str, MessageCustom.class);
                    if (!TextUtils.isEmpty(messageCustom.businessID) && messageCustom.businessID.equals(MessageCustom.BUSINESS_ID_GROUP_CREATE)) {
                        TipsMessageBean tipsMessageBean2 = new TipsMessageBean();
                        tipsMessageBean2.setCommonAttribute(v2TIMMessage);
                        tipsMessageBean2.setTipType(257);
                        String str3 = TUIChatConstants.covert2HTMLString(getDisplayName(v2TIMMessage)) + messageCustom.content;
                        tipsMessageBean2.setText(str3);
                        tipsMessageBean2.setExtra(str3);
                        return tipsMessageBean2;
                    }
                } catch (Exception e11) {
                    TUIChatLog.e(TAG, "invalid json: " + str + ", exception:" + e11);
                }
            }
        }
        return null;
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage) {
        return parseMessage(v2TIMMessage, false);
    }

    public static List<TUIMessageBean> parseMessageList(List<V2TIMMessage> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            TUIMessageBean parseMessage = parseMessage(list.get(i11));
            if (parseMessage != null) {
                arrayList.add(parseMessage);
            }
        }
        return arrayList;
    }

    private static TUIMessageBean parseReplyMessage(V2TIMMessage v2TIMMessage) {
        String cloudCustomData = v2TIMMessage.getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            return null;
        }
        try {
            Gson gson = new Gson();
            HashMap hashMap = (HashMap) gson.fromJson(cloudCustomData, HashMap.class);
            if (hashMap != null) {
                Object obj = hashMap.get(TIMCommonConstants.MESSAGE_REPLY_KEY);
                ReplyPreviewBean replyPreviewBean = obj instanceof Map ? (ReplyPreviewBean) gson.fromJson(gson.toJson(obj), ReplyPreviewBean.class) : null;
                if (replyPreviewBean == null || replyPreviewBean.getVersion() > 1) {
                    return null;
                }
                if (TextUtils.isEmpty(replyPreviewBean.getMessageRootID())) {
                    return new QuoteMessageBean(replyPreviewBean);
                }
                return new ReplyMessageBean(replyPreviewBean);
            }
        } catch (JsonSyntaxException unused) {
            TUIChatLog.e(TAG, " getCustomJsonMap error ");
        }
        return null;
    }

    public static void putCustomMessageType(int i11, Class<? extends TUIMessageBean> cls) {
        messageTypeMap.put(Integer.valueOf(i11), cls);
    }

    public static TUIMessageBean parseMessage(V2TIMMessage v2TIMMessage, boolean z11) {
        TUIMessageBean tUIMessageBean = null;
        if (v2TIMMessage == null) {
            return null;
        }
        if (!(v2TIMMessage.getStatus() == 4 || v2TIMMessage.getElemType() == 0)) {
            if (!z11) {
                tUIMessageBean = parseReplyMessage(v2TIMMessage);
            }
            if (tUIMessageBean == null) {
                int elemType = v2TIMMessage.getElemType();
                if (elemType == 2) {
                    tUIMessageBean = parseCustomMessage(v2TIMMessage);
                } else {
                    Class cls = messageTypeMap.get(Integer.valueOf(elemType));
                    if (cls != null) {
                        try {
                            tUIMessageBean = (TUIMessageBean) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                        } catch (NoSuchMethodException e11) {
                            e11.printStackTrace();
                        } catch (IllegalAccessException e12) {
                            e12.printStackTrace();
                        } catch (InstantiationException e13) {
                            e13.printStackTrace();
                        } catch (InvocationTargetException e14) {
                            e14.printStackTrace();
                        }
                    }
                }
            }
            if (tUIMessageBean != null) {
                tUIMessageBean.setCommonAttribute(v2TIMMessage);
                tUIMessageBean.onProcessMessage(v2TIMMessage);
            }
        }
        return tUIMessageBean;
    }
}

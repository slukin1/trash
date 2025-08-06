package com.hbg.module.huobi.im.group.ui.chat;

import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.module.huobi.im.group.bean.HbImageMessageBean;
import com.hbg.module.huobi.im.group.bean.HbSoundMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTipMessageBean;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.util.FileUtil;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ReplyPreviewBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatMessageBuilder {
    public static TUIMessageBean buildAtReplyMessage(String str, List<String> list, ReplyPreviewBean replyPreviewBean) {
        return buildReplyMessage(V2TIMManager.getMessageManager().createTextAtMessage(str, list), replyPreviewBean);
    }

    public static TUIMessageBean buildAudioMessage(String str, int i11) {
        V2TIMMessage createSoundMessage = V2TIMManager.getMessageManager().createSoundMessage(str, i11 / 1000);
        HbSoundMessageBean hbSoundMessageBean = new HbSoundMessageBean();
        hbSoundMessageBean.setCommonAttribute(createSoundMessage);
        hbSoundMessageBean.onProcessMessage(createSoundMessage);
        hbSoundMessageBean.setDataPath(str);
        return hbSoundMessageBean;
    }

    public static TUIMessageBean buildCustomMessage(String str, String str2, byte[] bArr) {
        TUIMessageBean parseMessage = ChatMessageParser.parseMessage(V2TIMManager.getMessageManager().createCustomMessage(str.getBytes(), str2, bArr));
        if (parseMessage.getExtra() == null) {
            parseMessage.setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_msg));
        }
        return parseMessage;
    }

    public static TUIMessageBean buildFaceMessage(int i11, String str) {
        V2TIMMessage createFaceMessage = V2TIMManager.getMessageManager().createFaceMessage(i11, str.getBytes());
        FaceMessageBean faceMessageBean = new FaceMessageBean();
        faceMessageBean.setCommonAttribute(createFaceMessage);
        faceMessageBean.onProcessMessage(createFaceMessage);
        return faceMessageBean;
    }

    public static TUIMessageBean buildFileMessage(Uri uri) {
        String pathFromUri = FileUtil.getPathFromUri(uri);
        File file = new File(pathFromUri);
        if (!file.exists()) {
            return null;
        }
        V2TIMMessage createFileMessage = V2TIMManager.getMessageManager().createFileMessage(pathFromUri, file.getName());
        FileMessageBean fileMessageBean = new FileMessageBean();
        fileMessageBean.setCommonAttribute(createFileMessage);
        fileMessageBean.onProcessMessage(createFileMessage);
        fileMessageBean.setDataPath(pathFromUri);
        return fileMessageBean;
    }

    public static TUIMessageBean buildForwardMessage(V2TIMMessage v2TIMMessage) {
        return buildMessage(V2TIMManager.getMessageManager().createForwardMessage(v2TIMMessage));
    }

    public static V2TIMMessage buildGroupCustomMessage(String str) {
        return V2TIMManager.getMessageManager().createCustomMessage(str.getBytes());
    }

    public static TUIMessageBean buildImageMessage(Uri uri) {
        String imagePathAfterRotate = ImageUtil.getImagePathAfterRotate(uri);
        V2TIMMessage createImageMessage = V2TIMManager.getMessageManager().createImageMessage(imagePathAfterRotate);
        HbImageMessageBean hbImageMessageBean = new HbImageMessageBean();
        hbImageMessageBean.setCommonAttribute(createImageMessage);
        hbImageMessageBean.onProcessMessage(createImageMessage);
        hbImageMessageBean.setDataUri(uri);
        int[] imageSize = ImageUtil.getImageSize(imagePathAfterRotate);
        hbImageMessageBean.setDataPath(imagePathAfterRotate);
        hbImageMessageBean.setImgWidth(imageSize[0]);
        hbImageMessageBean.setImgHeight(imageSize[1]);
        return hbImageMessageBean;
    }

    public static TUIMessageBean buildMergeMessage(List<TUIMessageBean> list, String str, List<String> list2, String str2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(list.get(i11).getV2TIMMessage());
        }
        V2TIMMessage createMergerMessage = V2TIMManager.getMessageManager().createMergerMessage(arrayList, str, list2, str2);
        MergeMessageBean mergeMessageBean = new MergeMessageBean();
        mergeMessageBean.setCommonAttribute(createMergerMessage);
        mergeMessageBean.onProcessMessage(createMergerMessage);
        return mergeMessageBean;
    }

    public static TUIMessageBean buildMessage(V2TIMMessage v2TIMMessage) {
        return ChatMessageParser.parseMessage(v2TIMMessage);
    }

    public static TUIMessageBean buildReplyMessage(String str, ReplyPreviewBean replyPreviewBean) {
        return buildReplyMessage(V2TIMManager.getMessageManager().createTextMessage(str), replyPreviewBean);
    }

    public static ReplyPreviewBean buildReplyPreviewBean(TUIMessageBean tUIMessageBean) {
        String replyMessageAbstract = ChatMessageParser.getReplyMessageAbstract(tUIMessageBean);
        String nickName = tUIMessageBean.getNickName();
        if (TextUtils.isEmpty(nickName)) {
            nickName = tUIMessageBean.getSender();
        }
        ReplyPreviewBean replyPreviewBean = new ReplyPreviewBean();
        replyPreviewBean.setOriginalMessageBean(tUIMessageBean);
        replyPreviewBean.setMessageID(tUIMessageBean.getId());
        replyPreviewBean.setMessageAbstract(replyMessageAbstract);
        replyPreviewBean.setMessageSender(nickName);
        replyPreviewBean.setMessageType(tUIMessageBean.getMsgType());
        return replyPreviewBean;
    }

    public static HbTextMessageBean buildTextAtMessage(List<String> list, String str) {
        V2TIMMessage createTextAtMessage = V2TIMManager.getMessageManager().createTextAtMessage(str, list);
        HbTextMessageBean hbTextMessageBean = new HbTextMessageBean();
        hbTextMessageBean.setCommonAttribute(createTextAtMessage);
        hbTextMessageBean.onProcessMessage(createTextAtMessage);
        return hbTextMessageBean;
    }

    public static TextMessageBean buildTextMessage(String str) {
        V2TIMMessage createTextMessage = V2TIMManager.getMessageManager().createTextMessage(str);
        HbTextMessageBean hbTextMessageBean = new HbTextMessageBean();
        hbTextMessageBean.setCommonAttribute(createTextMessage);
        hbTextMessageBean.onProcessMessage(createTextMessage);
        return hbTextMessageBean;
    }

    public static HbTipMessageBean buildTipsMessage(String str) {
        V2TIMMessage createTextMessage = V2TIMManager.getMessageManager().createTextMessage(str);
        HbTipMessageBean hbTipMessageBean = new HbTipMessageBean();
        hbTipMessageBean.setCommonAttribute(createTextMessage);
        hbTipMessageBean.onProcessMessage(createTextMessage);
        return hbTipMessageBean;
    }

    public static TUIMessageBean buildVideoMessage(String str, String str2, int i11, int i12, long j11) {
        V2TIMMessage createVideoMessage = V2TIMManager.getMessageManager().createVideoMessage(str2, "mp4", ((int) j11) / 1000, str);
        VideoMessageBean videoMessageBean = new VideoMessageBean();
        videoMessageBean.setCommonAttribute(createVideoMessage);
        videoMessageBean.onProcessMessage(createVideoMessage);
        Uri fromFile = Uri.fromFile(new File(str2));
        videoMessageBean.setImgWidth(i11);
        videoMessageBean.setImgHeight(i12);
        videoMessageBean.setDataPath(str);
        videoMessageBean.setDataUri(fromFile);
        return videoMessageBean;
    }

    private static TUIMessageBean buildReplyMessage(V2TIMMessage v2TIMMessage, ReplyPreviewBean replyPreviewBean) {
        HashMap hashMap = new HashMap();
        Gson gson = new Gson();
        hashMap.put(TIMCommonConstants.MESSAGE_REPLY_KEY, replyPreviewBean);
        v2TIMMessage.setCloudCustomData(gson.toJson((Object) hashMap));
        ReplyMessageBean replyMessageBean = new ReplyMessageBean(replyPreviewBean);
        replyMessageBean.setCommonAttribute(v2TIMMessage);
        replyMessageBean.onProcessMessage(v2TIMMessage);
        return replyMessageBean;
    }
}

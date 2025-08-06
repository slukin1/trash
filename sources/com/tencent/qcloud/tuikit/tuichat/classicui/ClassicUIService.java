package com.tencent.qcloud.tuikit.tuichat.classicui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionEventListener;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.TUIReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomEvaluationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.LocationMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MessageTypingBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.QuoteMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ReplyMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextAtMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TextMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomEvaluationMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomLinkReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.CustomOrderMessageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FileReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ImageReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.LocationReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.MergeReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.ReplyReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.SoundReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TextReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.VideoReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.page.TUIC2CChatActivity;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.FaceReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.FileReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ImageReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.LocationReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.MergeReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.SoundReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TextReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.VideoReplyQuoteView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CallingMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomEvaluationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomLinkMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.CustomOrderMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FaceMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ImageMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.LocationMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MergeMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.QuoteMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.ReplyMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.SoundMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TextMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.TipsMessageHolder;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.VideoMessageHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import zy.a;
import zy.b;

public class ClassicUIService extends ServiceInitializer implements ITUIExtension, ITUIService {
    private static ClassicUIService instance;
    private final Set<Integer> emptyViewGroupMessageSet = new HashSet();
    private final Map<Integer, Class<? extends MessageBaseHolder>> messageViewHolderMap = new HashMap();
    private final Map<Class<? extends TUIMessageBean>, Integer> messageViewTypeMap = new HashMap();
    private final Map<Class<? extends TUIReplyQuoteBean>, Class<? extends TUIReplyQuoteView>> replyMessageViewMap = new HashMap();
    private int viewType = 0;

    private List<TUIExtensionInfo> getClassicFriendProfileExtension(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        tUIExtensionInfo.setWeight(400);
        tUIExtensionInfo.setText(ServiceInitializer.getAppContext().getString(R.string.chat_contact_profile_message));
        final String str = (String) getOrDefault(map, TUIConstants.TUIContact.Extension.FriendProfileItem.USER_ID, (Object) null);
        tUIExtensionInfo.setExtensionListener(new TUIExtensionEventListener() {
            public void onClicked(Map<String, Object> map) {
                Intent intent = new Intent(ServiceInitializer.getAppContext(), TUIC2CChatActivity.class);
                intent.putExtra(TUIConstants.TUIChat.CHAT_TYPE, 1);
                intent.putExtra("chatId", str);
                intent.addFlags(268435456);
                ServiceInitializer.getAppContext().startActivity(intent);
            }
        });
        arrayList.add(tUIExtensionInfo);
        return arrayList;
    }

    public static ClassicUIService getInstance() {
        return instance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r2 = r2.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T getOrDefault(java.util.Map r2, java.lang.Object r3, T r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0010
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0009
            goto L_0x0010
        L_0x0009:
            java.lang.Object r2 = r2.get(r3)
            if (r2 == 0) goto L_0x0010
            return r2
        L_0x0010:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.classicui.ClassicUIService.getOrDefault(java.util.Map, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private void initExtension() {
        TUICore.registerExtension(TUIConstants.TUIContact.Extension.FriendProfileItem.CLASSIC_EXTENSION_ID, this);
    }

    private void initReplyMessage() {
        addReplyMessage(CustomEvaluationMessageReplyQuoteBean.class, TextReplyQuoteView.class);
        addReplyMessage(CustomLinkReplyQuoteBean.class, TextReplyQuoteView.class);
        addReplyMessage(CustomOrderMessageReplyQuoteBean.class, TextReplyQuoteView.class);
        addReplyMessage(FaceReplyQuoteBean.class, FaceReplyQuoteView.class);
        addReplyMessage(FileReplyQuoteBean.class, FileReplyQuoteView.class);
        addReplyMessage(ImageReplyQuoteBean.class, ImageReplyQuoteView.class);
        addReplyMessage(LocationReplyQuoteBean.class, LocationReplyQuoteView.class);
        addReplyMessage(MergeReplyQuoteBean.class, MergeReplyQuoteView.class);
        addReplyMessage(ReplyReplyQuoteBean.class, TextReplyQuoteView.class);
        addReplyMessage(SoundReplyQuoteBean.class, SoundReplyQuoteView.class);
        addReplyMessage(TextReplyQuoteBean.class, TextReplyQuoteView.class);
        addReplyMessage(VideoReplyQuoteBean.class, VideoReplyQuoteView.class);
    }

    private void initService() {
        TUICore.registerService("ChatClassicService", this);
    }

    private void registerCustomMessage(Map<String, Object> map) {
        Class cls = (Class) getOrDefault(map, TUIConstants.TUIChat.Method.RegisterCustomMessage.MESSAGE_BEAN_CLASS, (Object) null);
        Class cls2 = (Class) getOrDefault(map, TUIConstants.TUIChat.Method.RegisterCustomMessage.MESSAGE_VIEW_HOLDER_CLASS, (Object) null);
        Class cls3 = (Class) getOrDefault(map, TUIConstants.TUIChat.Method.RegisterCustomMessage.MESSAGE_REPLY_BEAN_CLASS, (Object) null);
        Class cls4 = (Class) getOrDefault(map, TUIConstants.TUIChat.Method.RegisterCustomMessage.MESSAGE_REPLY_VIEW_CLASS, (Object) null);
        boolean booleanValue = ((Boolean) getOrDefault(map, TUIConstants.TUIChat.Method.RegisterCustomMessage.IS_NEED_EMPTY_VIEW_GROUP, Boolean.FALSE)).booleanValue();
        TUIChatService.getInstance().addCustomMessageType((String) map.get(TUIConstants.TUIChat.Method.RegisterCustomMessage.MESSAGE_BUSINESS_ID), cls, false, cls2);
        if (cls != null) {
            addMessageType(cls, cls2, booleanValue);
        }
        if (cls3 != null && cls4 != null) {
            addReplyMessage(cls3, cls4);
        }
    }

    public void addMessageType(Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2) {
        addMessageType(cls, cls2, false);
    }

    public void addReplyMessage(Class<? extends TUIReplyQuoteBean> cls, Class<? extends TUIReplyQuoteView> cls2) {
        this.replyMessageViewMap.put(cls, cls2);
    }

    public int getLightThemeResId() {
        return R.style.TUIChatLightTheme;
    }

    public int getLivelyThemeResId() {
        return R.style.TUIChatLivelyTheme;
    }

    public Class<? extends MessageBaseHolder> getMessageViewHolderClass(int i11) {
        return this.messageViewHolderMap.get(Integer.valueOf(i11));
    }

    public Class<? extends TUIReplyQuoteView> getReplyMessageViewClass(Class<? extends TUIReplyQuoteBean> cls) {
        return this.replyMessageViewMap.get(cls);
    }

    public int getSeriousThemeResId() {
        return R.style.TUIChatSeriousTheme;
    }

    public int getViewType(Class<? extends TUIMessageBean> cls) {
        Integer num = this.messageViewTypeMap.get(cls);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void init(Context context) {
        instance = this;
        initService();
        initMessage();
        initExtension();
        initReplyMessage();
    }

    public void initMessage() {
        Class<TextMessageHolder> cls = TextMessageHolder.class;
        addMessageType(FaceMessageBean.class, FaceMessageHolder.class);
        addMessageType(FileMessageBean.class, FileMessageHolder.class);
        addMessageType(ImageMessageBean.class, ImageMessageHolder.class);
        addMessageType(LocationMessageBean.class, LocationMessageHolder.class);
        addMessageType(MergeMessageBean.class, MergeMessageHolder.class);
        addMessageType(SoundMessageBean.class, SoundMessageHolder.class);
        addMessageType(TextAtMessageBean.class, cls);
        addMessageType(TextMessageBean.class, cls);
        addMessageType(TipsMessageBean.class, TipsMessageHolder.class, true);
        addMessageType(VideoMessageBean.class, VideoMessageHolder.class);
        addMessageType(ReplyMessageBean.class, ReplyMessageHolder.class);
        addMessageType(QuoteMessageBean.class, QuoteMessageHolder.class);
        addMessageType(CallingMessageBean.class, CallingMessageHolder.class);
        addMessageType(CustomLinkMessageBean.class, CustomLinkMessageHolder.class);
        addMessageType(CustomEvaluationMessageBean.class, CustomEvaluationMessageHolder.class);
        addMessageType(CustomOrderMessageBean.class, CustomOrderMessageHolder.class);
        addMessageType(MessageTypingBean.class, (Class<? extends MessageBaseHolder>) null);
    }

    public boolean isNeedEmptyViewGroup(int i11) {
        return this.emptyViewGroupMessageSet.contains(Integer.valueOf(i11));
    }

    public Object onCall(String str, Map<String, Object> map) {
        if (!TextUtils.equals(TUIConstants.TUIChat.Method.RegisterCustomMessage.METHOD_NAME, str)) {
            return null;
        }
        registerCustomMessage(map);
        return null;
    }

    public /* synthetic */ Object onCall(String str, Map map, TUIServiceCallback tUIServiceCallback) {
        return b.b(this, str, map, tUIServiceCallback);
    }

    public List<TUIExtensionInfo> onGetExtension(String str, Map<String, Object> map) {
        if (TextUtils.equals(str, TUIConstants.TUIContact.Extension.FriendProfileItem.CLASSIC_EXTENSION_ID)) {
            return getClassicFriendProfileExtension(map);
        }
        return null;
    }

    public /* synthetic */ Map onGetExtensionInfo(String str, Map map) {
        return a.b(this, str, map);
    }

    public /* synthetic */ void onRaiseExtension(String str, View view, Map map) {
        a.c(this, str, view, map);
    }

    public void addMessageType(Class<? extends TUIMessageBean> cls, Class<? extends MessageBaseHolder> cls2, boolean z11) {
        int i11 = this.viewType + 1;
        this.viewType = i11;
        if (z11) {
            this.emptyViewGroupMessageSet.add(Integer.valueOf(i11));
        }
        this.messageViewTypeMap.put(cls, Integer.valueOf(this.viewType));
        this.messageViewHolderMap.put(Integer.valueOf(this.viewType), cls2);
    }
}

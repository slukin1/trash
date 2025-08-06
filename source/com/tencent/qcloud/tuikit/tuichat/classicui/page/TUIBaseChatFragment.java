package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.a;
import com.bumptech.glide.request.target.CustomTarget;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;
import com.tencent.qcloud.tuikit.timcommon.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.component.AudioPlayer;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.DataStoreUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TUIBaseChatFragment extends BaseFragment {
    /* access modifiers changed from: private */
    public static final String TAG = TUIBaseChatFragment.class.getSimpleName();
    public View baseView;
    public ChatView chatView;
    public String mChatBackgroundThumbnailUrl;
    public String mChatBackgroundUrl;
    /* access modifiers changed from: private */
    public int mForwardMode;
    /* access modifiers changed from: private */
    public List<TUIMessageBean> mForwardSelectMsgInfos = null;
    /* access modifiers changed from: private */
    public MessageRecyclerView messageRecyclerView;
    /* access modifiers changed from: private */
    public int messageViewBackgroundHeight;
    public TitleBarLayout titleBar;

    /* access modifiers changed from: private */
    public Bitmap zoomImg(Bitmap bitmap, int i11, int i12) {
        float width = (((float) i11) * 1.0f) / ((float) bitmap.getWidth());
        float height = (((float) i12) * 1.0f) / ((float) bitmap.getHeight());
        Matrix matrix = new Matrix();
        matrix.postScale(width, height, 0.0f, 0.0f);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    public ChatInfo getChatInfo() {
        return null;
    }

    public ChatView getChatView() {
        return this.chatView;
    }

    public ChatPresenter getPresenter() {
        return null;
    }

    public void initChatViewBackground() {
        if (getChatInfo() == null) {
            TUIChatLog.e(TAG, "initChatViewBackground getChatInfo is null");
        } else {
            DataStoreUtil.getInstance().getValueAsync(getChatInfo().getId(), new DataStoreUtil.GetResult<String>() {
                public void onFail() {
                    TUIChatLog.e(TUIBaseChatFragment.TAG, "initChatViewBackground onFail");
                }

                public void onSuccess(String str) {
                    TUIBaseChatFragment.this.setChatViewBackground(str);
                }
            }, String.class);
        }
    }

    public void initView() {
        ChatView chatView2 = (ChatView) this.baseView.findViewById(R.id.chat_layout);
        this.chatView = chatView2;
        chatView2.initDefault(this);
        TitleBarLayout titleBar2 = this.chatView.getTitleBar();
        this.titleBar = titleBar2;
        titleBar2.setOnLeftClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ((InputMethodManager) TUIBaseChatFragment.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(TUIBaseChatFragment.this.chatView.getWindowToken(), 0);
                TUIBaseChatFragment.this.getActivity().finish();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.chatView.setForwardSelectActivityListener(new ChatView.ForwardSelectActivityListener() {
            public void onStartForwardSelectActivity(int i11, List<TUIMessageBean> list) {
                int unused = TUIBaseChatFragment.this.mForwardMode = i11;
                List unused2 = TUIBaseChatFragment.this.mForwardSelectMsgInfos = list;
                Bundle bundle = new Bundle();
                bundle.putInt(TUIChatConstants.FORWARD_MODE, i11);
                TUICore.startActivityForResult((a) TUIBaseChatFragment.this.getActivity(), "TUIForwardSelectActivity", bundle, (ActivityResultCallback<ActivityResult>) new ActivityResultCallback<ActivityResult>() {
                    public void onActivityResult(ActivityResult activityResult) {
                        HashMap hashMap;
                        String str;
                        String str2;
                        Intent data = activityResult.getData();
                        if (data != null && TUIBaseChatFragment.this.mForwardSelectMsgInfos != null && !TUIBaseChatFragment.this.mForwardSelectMsgInfos.isEmpty() && (hashMap = (HashMap) data.getSerializableExtra(TUIChatConstants.FORWARD_SELECT_CONVERSATION_KEY)) != null && !hashMap.isEmpty()) {
                            for (Map.Entry entry : hashMap.entrySet()) {
                                boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
                                String str3 = (String) entry.getKey();
                                ChatInfo chatInfo = TUIBaseChatFragment.this.getChatInfo();
                                if (chatInfo != null) {
                                    if (TUIChatUtils.isGroupChat(chatInfo.getType())) {
                                        str2 = TUIBaseChatFragment.this.getString(R.string.forward_chats);
                                    } else {
                                        String selfNickName = TUIConfig.getSelfNickName();
                                        if (TextUtils.isEmpty(selfNickName)) {
                                            selfNickName = TUILogin.getLoginUser();
                                        }
                                        if (!TextUtils.isEmpty(TUIBaseChatFragment.this.getChatInfo().getChatName())) {
                                            str = TUIBaseChatFragment.this.getChatInfo().getChatName();
                                        } else {
                                            str = TUIBaseChatFragment.this.getChatInfo().getId();
                                        }
                                        str2 = selfNickName + TUIBaseChatFragment.this.getString(R.string.and_text) + str + TUIBaseChatFragment.this.getString(R.string.forward_chats_c2c);
                                    }
                                    TUIBaseChatFragment.this.getPresenter().forwardMessage(TUIBaseChatFragment.this.mForwardSelectMsgInfos, booleanValue, str3, str2, TUIBaseChatFragment.this.mForwardMode, str3 != null && str3.equals(chatInfo.getId()), new IUIKitCallback() {
                                        public void onError(String str, int i11, String str2) {
                                            String access$200 = TUIBaseChatFragment.TAG;
                                            TUIChatLog.v(access$200, "sendMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(TUIBaseChatFragment.this.getString(R.string.send_failed));
                                            sb2.append(", ");
                                            sb2.append(str2);
                                            ToastUtil.toastLongMessage(sb2.toString());
                                        }

                                        public void onSuccess(Object obj) {
                                            TUIChatLog.v(TUIBaseChatFragment.TAG, "sendMessage onSuccess:");
                                        }
                                    });
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                });
            }
        });
        this.chatView.getMessageLayout().setOnItemClickListener(new OnItemClickListener() {
            public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if ((tUIMessageBean instanceof MergeMessageBean) && TUIBaseChatFragment.this.getChatInfo() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(TUIChatConstants.FORWARD_MERGE_MESSAGE_KEY, tUIMessageBean);
                    bundle.putSerializable(TUIChatConstants.CHAT_INFO, TUIBaseChatFragment.this.getChatInfo());
                    TUICore.startActivity("TUIForwardChatActivity", bundle);
                }
            }

            public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                TUIChatLog.d(TUIBaseChatFragment.TAG, "chatfragment onTextSelected selectedText = ");
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onMessageReadStatusClick(View view, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null && TUIBaseChatFragment.this.getChatInfo() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("messageBean", tUIMessageBean);
                    bundle.putSerializable(TUIChatConstants.CHAT_INFO, TUIBaseChatFragment.this.getChatInfo());
                    TUICore.startActivity("MessageReceiptDetailActivity", bundle);
                }
            }

            public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int msgType = tUIMessageBean.getMsgType();
                    if (msgType == 1) {
                        TUIBaseChatFragment.this.chatView.getInputLayout().appendText(tUIMessageBean.getV2TIMMessage().getTextElem().getText());
                        return;
                    }
                    String access$200 = TUIBaseChatFragment.TAG;
                    TUIChatLog.e(access$200, "error type: " + msgType);
                }
            }

            public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    int callType = ((CallingMessageBean) tUIMessageBean).getCallType();
                    String str = callType == 2 ? "video" : callType == 1 ? "audio" : "";
                    HashMap hashMap = new HashMap();
                    hashMap.put(TUIConstants.TUICalling.PARAM_NAME_USERIDS, new String[]{tUIMessageBean.getUserId()});
                    hashMap.put("type", str);
                    TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
                }
            }

            public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
                TUIBaseChatFragment.this.chatView.getMessageLayout().setSelectedPosition(i11);
                TUIBaseChatFragment.this.chatView.getMessageLayout().showItemPopMenu(tUIMessageBean, view);
            }

            public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
                if (tUIMessageBean != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("chatId", tUIMessageBean.getSender());
                    TUICore.startActivity("FriendProfileActivity", bundle);
                }
            }
        });
        this.chatView.getInputLayout().setOnInputViewListener(new InputView.OnInputViewListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onStartGroupMemberSelectActivity$0(ActivityResult activityResult) {
                if (activityResult.getData() != null) {
                    ArrayList<String> stringArrayListExtra = activityResult.getData().getStringArrayListExtra(TUIChatConstants.Selection.USER_ID_SELECT);
                    TUIBaseChatFragment.this.chatView.getInputLayout().updateInputText(activityResult.getData().getStringArrayListExtra(TUIChatConstants.Selection.USER_NAMECARD_SELECT), stringArrayListExtra);
                }
            }

            public void onStartGroupMemberSelectActivity() {
                Bundle bundle = new Bundle();
                bundle.putString(TUIConstants.TUIContact.StartActivity.GroupMemberSelect.GROUP_ID, TUIBaseChatFragment.this.getChatInfo().getId());
                TUICore.startActivityForResult((a) TUIBaseChatFragment.this.getActivity(), TUIConstants.TUIContact.StartActivity.GroupMemberSelect.CLASSIC_ACTIVITY_NAME, bundle, (ActivityResultCallback<ActivityResult>) new a(this));
            }

            public void onUpdateChatBackground() {
                TUIBaseChatFragment tUIBaseChatFragment = TUIBaseChatFragment.this;
                tUIBaseChatFragment.setChatViewBackground(tUIBaseChatFragment.mChatBackgroundUrl);
            }
        });
        this.messageRecyclerView = this.chatView.getMessageLayout();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = TAG;
        TUIChatLog.i(str, "oncreate view " + this);
        View inflate = layoutInflater.inflate(R.layout.chat_fragment, viewGroup, false);
        this.baseView = inflate;
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            chatView2.exitChat();
        }
    }

    public void onPause() {
        super.onPause();
        ChatView chatView2 = this.chatView;
        if (chatView2 != null) {
            if (chatView2.getInputLayout() != null) {
                this.chatView.getInputLayout().setDraft();
            }
            if (getPresenter() != null) {
                getPresenter().setChatFragmentShow(false);
            }
        }
        AudioPlayer.getInstance().stopPlay();
    }

    public void onResume() {
        super.onResume();
        if (getPresenter() != null) {
            getPresenter().setChatFragmentShow(true);
        }
        initChatViewBackground();
    }

    public void setChatViewBackground(String str) {
        String str2 = TAG;
        TUIChatLog.d(str2, "setChatViewBackground uri = " + str);
        if (!TextUtils.isEmpty(str)) {
            if (this.chatView == null) {
                TUIChatLog.e(str2, "setChatViewBackground chatview is null");
            } else if (this.messageRecyclerView == null) {
                TUIChatLog.e(str2, "setChatViewBackground messageRecyclerView is null");
            } else {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length > 0) {
                    this.mChatBackgroundThumbnailUrl = split[0];
                }
                if (split.length > 1) {
                    this.mChatBackgroundUrl = split[1];
                }
                if (TextUtils.equals(TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL, this.mChatBackgroundUrl)) {
                    this.mChatBackgroundThumbnailUrl = TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL;
                    this.messageRecyclerView.setBackgroundResource(R.color.chat_background_color);
                    return;
                }
                this.messageRecyclerView.post(new Runnable() {
                    public void run() {
                        final int width = TUIBaseChatFragment.this.messageRecyclerView.getWidth();
                        int height = TUIBaseChatFragment.this.messageRecyclerView.getHeight();
                        if (height > TUIBaseChatFragment.this.messageViewBackgroundHeight) {
                            int unused = TUIBaseChatFragment.this.messageViewBackgroundHeight = height;
                        }
                        String access$200 = TUIBaseChatFragment.TAG;
                        TUIChatLog.d(access$200, "messageRecyclerView  width = " + width + ", height = " + TUIBaseChatFragment.this.messageViewBackgroundHeight);
                        if (width != 0 && TUIBaseChatFragment.this.messageViewBackgroundHeight != 0) {
                            com.bumptech.glide.a.v(TUIBaseChatFragment.this.getContext()).b().M0(TUIBaseChatFragment.this.mChatBackgroundUrl).A0(new CustomTarget<Bitmap>(TUIBaseChatFragment.this.messageViewBackgroundHeight, width) {
                                public void onLoadCleared(Drawable drawable) {
                                }

                                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
                                    String access$200 = TUIBaseChatFragment.TAG;
                                    TUIChatLog.d(access$200, "messageRecyclerView onGlobalLayout url = " + TUIBaseChatFragment.this.mChatBackgroundUrl);
                                    TUIBaseChatFragment tUIBaseChatFragment = TUIBaseChatFragment.this;
                                    final Bitmap access$500 = tUIBaseChatFragment.zoomImg(bitmap, width, tUIBaseChatFragment.messageViewBackgroundHeight);
                                    TUIBaseChatFragment.this.messageRecyclerView.setBackground(new BitmapDrawable(TUIBaseChatFragment.this.getResources(), bitmap) {
                                        public void draw(Canvas canvas) {
                                            canvas.drawBitmap(access$500, canvas.getClipBounds(), canvas.getClipBounds(), (Paint) null);
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        }
    }
}

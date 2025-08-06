package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupChatPresenter extends ChatPresenter {
    /* access modifiers changed from: private */
    public static final String TAG = "GroupChatPresenter";
    private List<GroupApplyInfo> currentApplies = new ArrayList();
    /* access modifiers changed from: private */
    public List<GroupMemberInfo> currentGroupMembers = new ArrayList();
    private GroupChatEventListener groupChatEventListener;
    /* access modifiers changed from: private */
    public GroupInfo groupInfo;

    public GroupChatPresenter() {
        TUIChatLog.i(TAG, "GroupChatPresenter Init");
    }

    private void addGroupMessage(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof TipsMessageBean) {
            TipsMessageBean tipsMessageBean = (TipsMessageBean) tUIMessageBean;
            if (tipsMessageBean.getTipType() == 259) {
                this.provider.addJoinGroupMessage(tipsMessageBean, new IUIKitCallback<List<GroupMemberInfo>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$100 = GroupChatPresenter.TAG;
                        TUIChatLog.e(access$100, "addJoinGroupMessage error : " + str2);
                    }

                    public void onSuccess(List<GroupMemberInfo> list) {
                        GroupChatPresenter.this.currentGroupMembers.addAll(list);
                        GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
                    }
                });
            } else if (tipsMessageBean.getTipType() == 260 || tipsMessageBean.getTipType() == 261) {
                this.provider.addLeaveGroupMessage(tipsMessageBean, new IUIKitCallback<List<String>>() {
                    public void onError(String str, int i11, String str2) {
                    }

                    public void onSuccess(List<String> list) {
                        for (String next : list) {
                            int i11 = 0;
                            while (true) {
                                if (i11 >= GroupChatPresenter.this.currentGroupMembers.size()) {
                                    break;
                                } else if (((GroupMemberInfo) GroupChatPresenter.this.currentGroupMembers.get(i11)).getAccount().equals(next)) {
                                    GroupChatPresenter.this.currentGroupMembers.remove(i11);
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        GroupChatPresenter.this.groupInfo.setMemberDetails(GroupChatPresenter.this.currentGroupMembers);
                    }
                });
            } else if (tipsMessageBean.getTipType() == 262 || tipsMessageBean.getTipType() == 263) {
                this.provider.addModifyGroupMessage(tipsMessageBean, new IUIKitCallback<Pair<Integer, String>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$100 = GroupChatPresenter.TAG;
                        TUIChatLog.e(access$100, "addModifyGroupMessage error " + str2);
                    }

                    public void onSuccess(Pair<Integer, String> pair) {
                        if (((Integer) pair.first).intValue() == 262) {
                            GroupChatPresenter.this.groupInfo.setGroupName((String) pair.second);
                            WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = GroupChatPresenter.this.chatNotifyHandler;
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((ChatPresenter.ChatNotifyHandler) GroupChatPresenter.this.chatNotifyHandler.get()).onGroupNameChanged((String) pair.second);
                            }
                        }
                        if (((Integer) pair.first).intValue() == 263) {
                            GroupChatPresenter.this.groupInfo.setNotice((String) pair.second);
                        }
                    }
                });
            }
        }
    }

    private void sendGroupTipsMessage(final String str, String str2, final IUIKitCallback<String> iUIKitCallback) {
        this.provider.sendGroupTipsMessage(str, str2, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        super.addMessageInfo(tUIMessageBean);
        addGroupMessage(tUIMessageBean);
    }

    public void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
        tUIMessageBean.setGroup(true);
        String groupType = this.groupInfo.getGroupType();
        if (TextUtils.equals(groupType, "AVChatRoom") || TextUtils.equals(groupType, "Community") || TUIChatUtils.isCommunityGroup(this.groupInfo.getId())) {
            tUIMessageBean.setNeedReadReceipt(false);
        }
    }

    public void getChatFaceUrl(final String str, final IUIKitCallback<List<Object>> iUIKitCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.provider.getChatFaceUrl(str, true, new IUIKitCallback<String>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(String str) {
                    if (!TextUtils.isEmpty(str) || !TUIConfig.isEnableGroupGridAvatar()) {
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, Collections.singletonList(str));
                    } else {
                        GroupChatPresenter.this.provider.getChatGridFaceUrls(str, new IUIKitCallback<List<Object>>() {
                            public void onError(String str, int i11, String str2) {
                                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                            }

                            public void onSuccess(List<Object> list) {
                                TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                            }
                        });
                    }
                }
            });
        }
    }

    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    public void getChatName(final String str, final IUIKitCallback<String> iUIKitCallback) {
        if (!TextUtils.isEmpty(str)) {
            this.provider.getChatName(str, true, new IUIKitCallback<String>() {
                public void onError(String str, int i11, String str2) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                }

                public void onSuccess(String str) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                }
            });
        }
    }

    public void initListener() {
        this.groupChatEventListener = new GroupChatEventListener() {
            public void addMessage(TUIMessageBean tUIMessageBean, String str) {
                if (TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.addMessageInfo(tUIMessageBean);
                }
            }

            public void clearGroupMessage(String str) {
                if (TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.clearMessage();
                }
            }

            public void exitGroupChat(String str) {
                GroupChatPresenter.this.onExitChat(str);
            }

            public void handleRevoke(String str) {
                GroupChatPresenter.this.handleRevoke(str);
            }

            public void onApplied(int i11) {
                GroupChatPresenter.this.onApplied();
            }

            public void onGroupFaceUrlChanged(String str, String str2) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onGroupFaceUrlChanged(str2);
                }
            }

            public void onGroupForceExit(String str) {
                GroupChatPresenter.this.onGroupForceExit(str);
            }

            public void onGroupNameChanged(String str, String str2) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(str, GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onGroupNameChanged(str2);
                }
            }

            public void onMessageChanged(TUIMessageBean tUIMessageBean, int i11) {
                GroupChatPresenter.this.updateMessageInfo(tUIMessageBean, i11);
            }

            public void onReadReport(List<MessageReceiptInfo> list) {
                GroupChatPresenter.this.onReadReport(list);
            }

            public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
                if (GroupChatPresenter.this.groupInfo != null && TextUtils.equals(tUIMessageBean.getGroupId(), GroupChatPresenter.this.groupInfo.getId())) {
                    GroupChatPresenter.this.onRecvMessageModified(tUIMessageBean);
                }
            }

            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (GroupChatPresenter.this.groupInfo == null || !TextUtils.equals(tUIMessageBean.getGroupId(), GroupChatPresenter.this.groupInfo.getId())) {
                    TUIChatLog.i(GroupChatPresenter.TAG, "receive a new message , not belong to current chat.");
                } else {
                    GroupChatPresenter.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().addGroupChatEventListener(this.groupChatEventListener);
        initMessageSender();
    }

    public void loadGroupMembers(String str, IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        this.provider.loadGroupMembers(str, 0, iUIKitCallback);
    }

    public void loadMessage(final int i11, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        GroupInfo groupInfo2 = this.groupInfo;
        if (groupInfo2 != null && !this.isLoading) {
            this.isLoading = true;
            String id2 = groupInfo2.getId();
            if (i11 == 0) {
                this.provider.loadGroupMessage(id2, 20, tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$100 = GroupChatPresenter.TAG;
                        TUIChatLog.e(access$100, "load group message failed " + i11 + "  " + str2);
                        TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                    }

                    public void onSuccess(List<TUIMessageBean> list) {
                        String access$100 = GroupChatPresenter.TAG;
                        TUIChatLog.i(access$100, "load group message success " + list.size());
                        if (tUIMessageBean == null) {
                            GroupChatPresenter.this.isHaveMoreNewMessage = false;
                        }
                        if (list.size() < 20) {
                            GroupChatPresenter.this.isHaveMoreOldMessage = false;
                        }
                        GroupChatPresenter.this.onMessageLoadCompleted(list, i11);
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                    }
                });
            } else {
                loadHistoryMessageList(id2, true, i11, 20, tUIMessageBean, iUIKitCallback);
            }
        }
    }

    public void onApplied() {
        loadApplyList(new IUIKitCallback<List<GroupApplyInfo>>() {
            public void onError(String str, int i11, String str2) {
                super.onError(str, i11, str2);
            }

            public void onSuccess(List<GroupApplyInfo> list) {
                WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = GroupChatPresenter.this.chatNotifyHandler;
                if (weakReference != null && weakReference.get() != null) {
                    ((ChatPresenter.ChatNotifyHandler) GroupChatPresenter.this.chatNotifyHandler.get()).onApplied(list.size());
                }
            }
        });
    }

    public void onGroupFaceUrlChanged(String str) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onGroupFaceUrlChanged(str);
        }
    }

    public void onGroupForceExit(String str) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null && TextUtils.equals(str, this.groupInfo.getId())) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onGroupForceExit();
        }
    }

    public void onGroupNameChanged(String str) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onGroupNameChanged(str);
        }
    }

    public void onMessageLoadCompleted(List<TUIMessageBean> list, int i11) {
        groupReadReport(this.groupInfo.getId());
        getMessageReadReceipt(list, i11);
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
        if (this.groupInfo != null) {
            ArrayList arrayList = new ArrayList();
            for (MessageReceiptInfo next : list) {
                if (TextUtils.equals(next.getGroupID(), this.groupInfo.getId())) {
                    arrayList.add(next);
                }
            }
            onMessageReadReceiptUpdated(this.loadedMessageInfoList, arrayList);
        }
    }

    public void setGroupInfo(GroupInfo groupInfo2) {
        this.groupInfo = groupInfo2;
    }
}

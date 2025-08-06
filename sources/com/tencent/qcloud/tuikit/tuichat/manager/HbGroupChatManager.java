package com.tencent.qcloud.tuikit.tuichat.manager;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageCustom;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.GroupChatEventListener;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HbGroupChatManager extends ChatPresenter {
    /* access modifiers changed from: private */
    public static final String TAG = "HbGroupChatManager";
    private static HbGroupChatManager instance = new HbGroupChatManager();
    /* access modifiers changed from: private */
    public List<GroupMemberInfo> currentGroupMembers = new ArrayList();
    private GroupChatEventListener groupChatEventListener;
    /* access modifiers changed from: private */
    public GroupInfo groupInfo;
    /* access modifiers changed from: private */
    public List<WeakReference<BusinessCallbacks.ImGroupMessageListener>> imGroupMessageListeners = new ArrayList();
    /* access modifiers changed from: private */
    public V2TIMGroupMemberInfoResult result;
    private V2TIMGroupListener v2TIMGroupListener;

    private HbGroupChatManager() {
        initListener();
    }

    private void addGroupMessage(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof TipsMessageBean) {
            TipsMessageBean tipsMessageBean = (TipsMessageBean) tUIMessageBean;
            if (tipsMessageBean.getTipType() == 259) {
                this.provider.addJoinGroupMessage(tipsMessageBean, new IUIKitCallback<List<GroupMemberInfo>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$400 = HbGroupChatManager.TAG;
                        TUIChatLog.e(access$400, "addJoinGroupMessage error : " + str2);
                    }

                    public void onSuccess(List<GroupMemberInfo> list) {
                        HbGroupChatManager.this.currentGroupMembers.addAll(list);
                        HbGroupChatManager.this.groupInfo.setMemberDetails(HbGroupChatManager.this.currentGroupMembers);
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
                                if (i11 >= HbGroupChatManager.this.currentGroupMembers.size()) {
                                    break;
                                } else if (((GroupMemberInfo) HbGroupChatManager.this.currentGroupMembers.get(i11)).getAccount().equals(next)) {
                                    HbGroupChatManager.this.currentGroupMembers.remove(i11);
                                    break;
                                } else {
                                    i11++;
                                }
                            }
                        }
                        HbGroupChatManager.this.groupInfo.setMemberDetails(HbGroupChatManager.this.currentGroupMembers);
                    }
                });
            } else if (tipsMessageBean.getTipType() == 262 || tipsMessageBean.getTipType() == 263) {
                this.provider.addModifyGroupMessage(tipsMessageBean, new IUIKitCallback<Pair<Integer, String>>() {
                    public void onError(String str, int i11, String str2) {
                        String access$400 = HbGroupChatManager.TAG;
                        TUIChatLog.e(access$400, "addModifyGroupMessage error " + str2);
                    }

                    public void onSuccess(Pair<Integer, String> pair) {
                        if (((Integer) pair.first).intValue() == 262) {
                            HbGroupChatManager.this.groupInfo.setGroupName((String) pair.second);
                            if (!(HbGroupChatManager.this.chatNotifyHandler == null || HbGroupChatManager.this.chatNotifyHandler.get() == null)) {
                                ((ChatPresenter.ChatNotifyHandler) HbGroupChatManager.this.chatNotifyHandler.get()).onGroupNameChanged((String) pair.second);
                            }
                        }
                        if (((Integer) pair.first).intValue() == 263) {
                            HbGroupChatManager.this.groupInfo.setNotice((String) pair.second);
                        }
                    }
                });
            }
        }
    }

    public static HbGroupChatManager getInstance() {
        TUIChatLog.i(TAG, "GroupChatManager getInstance");
        return instance;
    }

    /* access modifiers changed from: private */
    public void sendGroupTipsMessage(final String str, String str2, final IUIKitCallback<String> iUIKitCallback) {
        this.provider.sendGroupTipsMessage(str, str2, new IUIKitCallback<TUIMessageBean>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str, i11, str2);
            }

            public void onSuccess(TUIMessageBean tUIMessageBean) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
            }
        });
    }

    public void addImGroupMessageListener(BusinessCallbacks.ImGroupMessageListener imGroupMessageListener) {
        this.imGroupMessageListeners.add(new WeakReference(imGroupMessageListener));
    }

    public void addMessageInfo(TUIMessageBean tUIMessageBean) {
        super.addMessageInfo(tUIMessageBean);
        addGroupMessage(tUIMessageBean);
    }

    public void assembleGroupMessage(TUIMessageBean tUIMessageBean) {
        tUIMessageBean.setGroup(true);
    }

    public void createGroupChat(final GroupInfo groupInfo2, final IUIKitCallback<String> iUIKitCallback) {
        this.provider.createGroup(groupInfo2, new IUIKitCallback<String>() {
            public void onError(String str, int i11, String str2) {
                TUIChatUtils.callbackOnError(iUIKitCallback, str, i11, str2);
            }

            public void onSuccess(String str) {
                groupInfo2.setId(str);
                Gson gson = new Gson();
                MessageCustom messageCustom = new MessageCustom();
                messageCustom.version = TUIChatConstants.version;
                messageCustom.businessID = MessageCustom.BUSINESS_ID_GROUP_CREATE;
                messageCustom.opUser = TUILogin.getLoginUser();
                messageCustom.content = ServiceInitializer.getAppContext().getString(R.string.create_group);
                String json = gson.toJson((Object) messageCustom);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                }
                HbGroupChatManager.this.sendGroupTipsMessage(str, json, new IUIKitCallback<String>() {
                    public void onError(String str, int i11, String str2) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, str, i11, str2);
                    }

                    public void onSuccess(String str) {
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                    }
                });
            }
        });
    }

    public ChatInfo getChatInfo() {
        return this.groupInfo;
    }

    public void getGroupAdminMemberList(String str) {
        this.provider.getGroupMemberList(str, 2, 0, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() {
            public void onError(int i11, String str) {
            }

            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                V2TIMGroupMemberInfoResult unused = HbGroupChatManager.this.result = v2TIMGroupMemberInfoResult;
            }
        });
    }

    public void initListener() {
        this.groupChatEventListener = new GroupChatEventListener() {
            public void clearGroupMessage(String str) {
                if (TextUtils.equals(str, HbGroupChatManager.this.groupInfo.getId()) && HbGroupChatManager.this.chatNotifyHandler != null && HbGroupChatManager.this.chatNotifyHandler.get() != null) {
                    ((ChatPresenter.ChatNotifyHandler) HbGroupChatManager.this.chatNotifyHandler.get()).clearMessage();
                }
            }

            public void exitGroupChat(String str) {
                HbGroupChatManager.this.onExitChat(str);
            }

            public void handleRevoke(String str) {
                HbGroupChatManager.this.handleRevoke(str);
            }

            public void onApplied(int i11) {
                HbGroupChatManager.this.onApplied(i11);
            }

            public void onGroupForceExit(String str) {
                HbGroupChatManager.this.onGroupForceExit(str);
            }

            public void onGroupNameChanged(String str, String str2) {
                if (HbGroupChatManager.this.groupInfo != null && TextUtils.equals(str, HbGroupChatManager.this.groupInfo.getId())) {
                    HbGroupChatManager.this.onGroupNameChanged(str2);
                }
            }

            public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
                if (HbGroupChatManager.this.groupInfo == null || !TextUtils.equals(tUIMessageBean.getGroupId(), HbGroupChatManager.this.groupInfo.getId())) {
                    TUIChatLog.i(HbGroupChatManager.TAG, "receive a new message , not belong to current chat.");
                } else {
                    HbGroupChatManager.this.onRecvNewMessage(tUIMessageBean);
                }
            }
        };
        TUIChatService.getInstance().addGroupChatEventListener(this.groupChatEventListener);
        initMessageSender();
        if (this.groupInfo != null) {
            String str = TAG;
            IMLog.d(str, "踢出群聊初始化，当前群ID：" + this.groupInfo.getId());
        }
        this.v2TIMGroupListener = new V2TIMGroupListener() {
            public void onMemberKicked(String str, V2TIMGroupMemberInfo v2TIMGroupMemberInfo, final List<V2TIMGroupMemberInfo> list) {
                super.onMemberKicked(str, v2TIMGroupMemberInfo, list);
                String access$400 = HbGroupChatManager.TAG;
                IMLog.d(access$400, "踢出群聊成功，过滤前：" + str + v2TIMGroupMemberInfo + list);
                if (HbGroupChatManager.this.groupInfo == null || !TextUtils.equals(str, HbGroupChatManager.this.groupInfo.getId()) || list.size() <= 0) {
                    String access$4002 = HbGroupChatManager.TAG;
                    IMLog.d(access$4002, "踢出群聊失败，群ID不匹配：" + str + "，" + HbGroupChatManager.this.groupInfo.getId() + "，" + list);
                    return;
                }
                String access$4003 = HbGroupChatManager.TAG;
                IMLog.d(access$4003, "踢出群聊成功过滤后：" + list);
                String loginUser = V2TIMManager.getInstance().getLoginUser();
                ArrayList arrayList = new ArrayList();
                arrayList.add(loginUser);
                V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                    public void onError(int i11, String str) {
                        String access$400 = HbGroupChatManager.TAG;
                        IMLog.d(access$400, "踢出群聊失败:" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:6:0x001b  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onSuccess(java.util.List<com.tencent.imsdk.v2.V2TIMUserFullInfo> r5) {
                        /*
                            r4 = this;
                            if (r5 == 0) goto L_0x0075
                            int r0 = r5.size()
                            if (r0 <= 0) goto L_0x0075
                            r0 = 0
                            java.lang.Object r5 = r5.get(r0)
                            com.tencent.imsdk.v2.V2TIMUserFullInfo r5 = (com.tencent.imsdk.v2.V2TIMUserFullInfo) r5
                            java.util.List r0 = r6
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0015:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x0075
                            java.lang.Object r1 = r0.next()
                            com.tencent.imsdk.v2.V2TIMGroupMemberInfo r1 = (com.tencent.imsdk.v2.V2TIMGroupMemberInfo) r1
                            java.lang.String r2 = r1.getUserID()
                            java.lang.String r3 = r5.getUserID()
                            boolean r2 = android.text.TextUtils.equals(r2, r3)
                            if (r2 != 0) goto L_0x003d
                            java.lang.String r1 = r1.getNickName()
                            java.lang.String r2 = r5.getNickName()
                            boolean r1 = android.text.TextUtils.equals(r1, r2)
                            if (r1 == 0) goto L_0x0015
                        L_0x003d:
                            com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager$2 r0 = com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager.AnonymousClass2.this
                            com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager r0 = com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager.this
                            java.util.List r0 = r0.imGroupMessageListeners
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0049:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x0075
                            java.lang.Object r1 = r0.next()
                            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
                            java.lang.Object r2 = r1.get()
                            if (r2 != 0) goto L_0x005f
                            r0.remove()
                            goto L_0x0049
                        L_0x005f:
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r2.<init>()
                            java.lang.String r3 = r5.getUserID()
                            r2.add(r3)
                            java.lang.Object r1 = r1.get()
                            com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks$ImGroupMessageListener r1 = (com.tencent.qcloud.tuikit.tuichat.BusinessCallbacks.ImGroupMessageListener) r1
                            r1.onGroupMemberKick()
                            goto L_0x0049
                        L_0x0075:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.manager.HbGroupChatManager.AnonymousClass2.AnonymousClass1.onSuccess(java.util.List):void");
                    }
                });
            }
        };
        String str2 = TAG;
        IMLog.d(str2, "踢出群聊初始化，listener：" + this.v2TIMGroupListener);
        V2TIMManager.getInstance().addGroupListener(this.v2TIMGroupListener);
        IMLog.d(str2, "踢出群聊初始化完成");
    }

    public boolean isGroupAdmin(String str) {
        V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult = this.result;
        if (v2TIMGroupMemberInfoResult == null || v2TIMGroupMemberInfoResult.getMemberInfoList().size() <= 0) {
            return false;
        }
        for (V2TIMGroupMemberFullInfo userID : this.result.getMemberInfoList()) {
            if (TextUtils.equals(userID.getUserID(), str)) {
                return true;
            }
        }
        return false;
    }

    public void loadAtMessage(long j11, String str) {
        super.loadAtMessage(j11, this.groupInfo.getId());
        this.isHaveMoreNewMessage = true;
    }

    public void loadMessage(final int i11, final TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        GroupInfo groupInfo2 = this.groupInfo;
        if (groupInfo2 != null && !this.isLoading) {
            this.isLoading = true;
            this.provider.loadHistoryMessageList(groupInfo2.getId(), true, 20, tUIMessageBean, i11, new IUIKitCallback<List<TUIMessageBean>>() {
                public void onError(String str, int i11, String str2) {
                    String access$400 = HbGroupChatManager.TAG;
                    TUIChatLog.e(access$400, "load group message failed " + i11 + "  " + str2);
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str2);
                }

                public void onSuccess(List<TUIMessageBean> list) {
                    String access$400 = HbGroupChatManager.TAG;
                    TUIChatLog.i(access$400, "load group message success " + list.size());
                    if (tUIMessageBean == null) {
                        HbGroupChatManager.this.isHaveMoreNewMessage = false;
                    }
                    HbGroupChatManager.this.onMessageLoadCompleted(list, i11);
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list);
                }
            });
        }
    }

    public void muteGroupMember(String str, String str2, IUIKitCallback<Void> iUIKitCallback) {
        this.provider.muteGroupMember(str, str2, Integer.MAX_VALUE, iUIKitCallback);
    }

    public void onApplied(int i11) {
        WeakReference<ChatPresenter.ChatNotifyHandler> weakReference = this.chatNotifyHandler;
        if (weakReference != null && weakReference.get() != null) {
            ((ChatPresenter.ChatNotifyHandler) this.chatNotifyHandler.get()).onApplied(i11);
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
        processLoadedMessage(list, i11);
    }

    public void onReceiveCustomMessage(TUIMessageBean tUIMessageBean) {
        Iterator<WeakReference<BusinessCallbacks.ImGroupMessageListener>> it2 = this.imGroupMessageListeners.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next.get() == null) {
                it2.remove();
            } else {
                ((BusinessCallbacks.ImGroupMessageListener) next.get()).onGroupReceiveCustomMsg(tUIMessageBean);
            }
        }
    }

    public void setGroupInfo(GroupInfo groupInfo2) {
        this.groupInfo = groupInfo2;
    }
}

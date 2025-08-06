package com.tencent.qcloud.tuikit.tuichat.model;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMCompleteCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationOperationResult;
import com.tencent.imsdk.v2.V2TIMCreateGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupApplication;
import com.tencent.imsdk.v2.V2TIMGroupApplicationResult;
import com.tencent.imsdk.v2.V2TIMGroupChangeInfo;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMGroupInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMGroupMessageReadMemberList;
import com.tencent.imsdk.v2.V2TIMGroupTipsElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMergerElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageListGetOption;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMMessageReceipt;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageFeature;
import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.ReactUserBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupApplyInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMemberInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflineMessageContainerBean;
import com.tencent.qcloud.tuikit.tuichat.bean.OfflinePushInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.UserStatusBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import com.tencent.qcloud.tuikit.tuichat.util.OfflinePushInfoUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.tencent.qcloud.tuikit.tuichat.util.TUIGroupUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatProvider {
    public static final int ERR_REVOKE_TIME_LIMIT_EXCEED = 6223;
    public static final int ERR_REVOKE_TIME_LIMIT_SVR_GROUP = 10031;
    public static final int ERR_REVOKE_TIME_LIMIT_SVR_MESSAGE = 20016;
    /* access modifiers changed from: private */
    public static final String TAG = "ChatProvider";
    private static final ChatProvider instance = new ChatProvider();

    private ChatProvider() {
    }

    public static ChatProvider getInstance() {
        return instance;
    }

    private void setMessageTypingFeature(TUIMessageBean tUIMessageBean) {
        MessageFeature messageFeature = new MessageFeature();
        messageFeature.setNeedTyping(1);
        tUIMessageBean.setMessageTypingFeature(messageFeature);
    }

    public void addJoinGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = groupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            for (V2TIMGroupMemberInfo covertTIMGroupMemberInfo : memberList) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.covertTIMGroupMemberInfo(covertTIMGroupMemberInfo);
                arrayList.add(groupMemberInfo);
            }
        } else {
            GroupMemberInfo groupMemberInfo2 = new GroupMemberInfo();
            groupMemberInfo2.covertTIMGroupMemberInfo(groupTipsElem.getOpMember());
            arrayList.add(groupMemberInfo2);
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addLeaveGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<List<String>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupMemberInfo> memberList = groupTipsElem.getMemberList();
        ArrayList arrayList = new ArrayList();
        if (memberList.size() > 0) {
            for (V2TIMGroupMemberInfo userID : memberList) {
                arrayList.add(userID.getUserID());
            }
        } else {
            arrayList.add(groupTipsElem.getOpMember().getUserID());
        }
        TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
    }

    public void addModifyGroupMessage(TUIMessageBean tUIMessageBean, IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage != null ? v2TIMMessage.getGroupTipsElem() : null;
        if (groupTipsElem == null) {
            TUIChatUtils.callbackOnError(iUIKitCallback, TAG, -1, "groupTips is null");
            return;
        }
        List<V2TIMGroupChangeInfo> groupChangeInfoList = groupTipsElem.getGroupChangeInfoList();
        if (groupChangeInfoList.size() > 0) {
            V2TIMGroupChangeInfo v2TIMGroupChangeInfo = groupChangeInfoList.get(0);
            int type = v2TIMGroupChangeInfo.getType();
            if (type == 1) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf(TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME), v2TIMGroupChangeInfo.getValue()));
            } else if (type == 3) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new Pair(263, v2TIMGroupChangeInfo.getValue()));
            }
        }
    }

    public void c2cReadReport(String str) {
        V2TIMManager.getMessageManager().markC2CMessageAsRead(str, new V2TIMCallback() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "markC2CMessageAsRead setReadMessage failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markC2CMessageAsRead setReadMessage success");
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add("c2c_" + str);
        V2TIMManager.getConversationManager().markConversation(arrayList, V2TIMConversation.V2TIM_CONVERSATION_MARK_TYPE_UNREAD, false, new V2TIMValueCallback<List<V2TIMConversationOperationResult>>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "mark C2C conversation unread disable failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMConversationOperationResult> list) {
                if (list.size() > 0) {
                    V2TIMConversationOperationResult v2TIMConversationOperationResult = list.get(0);
                    String access$000 = ChatProvider.TAG;
                    TUIChatLog.d(access$000, "mark C2C conversation unread disable success, code:" + v2TIMConversationOperationResult.getResultCode() + "|msg:" + v2TIMConversationOperationResult.getResultInfo());
                    return;
                }
                TUIChatLog.e(ChatProvider.TAG, "mark C2C conversation unread disable failed, results size = 0");
            }
        });
    }

    public boolean checkFailedMessageInfo(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean == null || tUIMessageBean.getV2TIMMessage().getStatus() == 3) {
            return true;
        }
        return false;
    }

    public void createGroup(GroupInfo groupInfo, final IUIKitCallback<String> iUIKitCallback) {
        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
        v2TIMGroupInfo.setGroupType(groupInfo.getGroupType());
        v2TIMGroupInfo.setGroupName(groupInfo.getGroupName());
        v2TIMGroupInfo.setGroupAddOpt(groupInfo.getJoinType());
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < groupInfo.getMemberDetails().size(); i11++) {
            V2TIMCreateGroupMemberInfo v2TIMCreateGroupMemberInfo = new V2TIMCreateGroupMemberInfo();
            v2TIMCreateGroupMemberInfo.setUserID(groupInfo.getMemberDetails().get(i11).getAccount());
            arrayList.add(v2TIMCreateGroupMemberInfo);
        }
        V2TIMManager.getGroupManager().createGroup(v2TIMGroupInfo, arrayList, new V2TIMValueCallback<String>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "createGroup failed, code: " + i11 + "|desc: " + ErrorMessageConverter.convertIMError(i11, str));
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
            }

            public void onSuccess(String str) {
            }
        });
    }

    public void deleteMessages(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(list.get(i11).getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().deleteMessages(arrayList, new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
                String access$000 = ChatProvider.TAG;
                TUIChatLog.w(access$000, "deleteMessages code:" + i11 + "|desc:" + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess() {
                TUIChatLog.i(ChatProvider.TAG, "deleteMessages success");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMergerElem mergerElem = mergeMessageBean.getMergerElem();
        if (mergerElem != null) {
            mergerElem.downloadMergerMessage(new V2TIMValueCallback<List<V2TIMMessage>>() {
                public void onError(int i11, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, "MergeMessageElemBean", i11, str);
                }

                public void onSuccess(List<V2TIMMessage> list) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
                }
            });
        }
    }

    public void findMessage(List<String> list, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().findMessages(list, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void getChatFaceUrl(String str, boolean z11, final IUIKitCallback<String> iUIKitCallback) {
        if (z11) {
            V2TIMManager.getGroupManager().getGroupsInfo(Collections.singletonList(str), new V2TIMValueCallback<List<V2TIMGroupInfoResult>>() {
                public void onError(int i11, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
                }

                public void onSuccess(List<V2TIMGroupInfoResult> list) {
                    V2TIMGroupInfoResult v2TIMGroupInfoResult = list.get(0);
                    if (v2TIMGroupInfoResult.getResultCode() == 0) {
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, v2TIMGroupInfoResult.getGroupInfo().getFaceUrl());
                    } else {
                        TUIChatUtils.callbackOnError(iUIKitCallback, v2TIMGroupInfoResult.getResultCode(), v2TIMGroupInfoResult.getResultMessage());
                    }
                }
            });
        } else {
            V2TIMManager.getInstance().getUsersInfo(Collections.singletonList(str), new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                public void onError(int i11, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
                }

                public void onSuccess(List<V2TIMUserFullInfo> list) {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0).getFaceUrl());
                }
            });
        }
    }

    public void getChatGridFaceUrls(String str, final IUIKitCallback<List<Object>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, 0, 0, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                List<V2TIMGroupMemberFullInfo> memberInfoList = v2TIMGroupMemberInfoResult.getMemberInfoList();
                ArrayList arrayList = new ArrayList();
                int i11 = 9;
                for (V2TIMGroupMemberFullInfo next : memberInfoList) {
                    if (i11 <= 0) {
                        break;
                    }
                    arrayList.add(next.getFaceUrl());
                    i11--;
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getChatName(final String str, boolean z11, final IUIKitCallback<String> iUIKitCallback) {
        if (!z11) {
            V2TIMManager.getFriendshipManager().getFriendsInfo(Collections.singletonList(str), new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() {
                public void onError(int i11, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
                }

                public void onSuccess(List<V2TIMFriendInfoResult> list) {
                    String str;
                    if (list == null || list.isEmpty()) {
                        V2TIMManager.getInstance().getUsersInfo(Collections.singletonList(str), new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
                            public void onError(int i11, String str) {
                                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
                            }

                            public void onSuccess(List<V2TIMUserFullInfo> list) {
                                if (list == null || list.isEmpty()) {
                                    TUIChatUtils.callbackOnError(iUIKitCallback, -1, "get userInfo failed");
                                } else {
                                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, list.get(0).getUserID());
                                }
                            }
                        });
                        return;
                    }
                    V2TIMFriendInfo friendInfo = list.get(0).getFriendInfo();
                    if (friendInfo != null) {
                        str = friendInfo.getFriendRemark();
                        String str2 = null;
                        String userID = friendInfo.getUserID();
                        V2TIMUserFullInfo userProfile = friendInfo.getUserProfile();
                        if (userProfile != null) {
                            str2 = userProfile.getNickName();
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = !TextUtils.isEmpty(str2) ? str2 : userID;
                        }
                    } else {
                        str = str;
                    }
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                }
            });
        } else {
            V2TIMManager.getGroupManager().getGroupsInfo(Collections.singletonList(str), new V2TIMValueCallback<List<V2TIMGroupInfoResult>>() {
                public void onError(int i11, String str) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
                }

                public void onSuccess(List<V2TIMGroupInfoResult> list) {
                    String str;
                    if (list == null || list.isEmpty()) {
                        TUIChatUtils.callbackOnError(iUIKitCallback, -1, "getGroupsInfo failed");
                        return;
                    }
                    V2TIMGroupInfoResult v2TIMGroupInfoResult = list.get(0);
                    if (v2TIMGroupInfoResult.getResultCode() == 0) {
                        V2TIMGroupInfo groupInfo = list.get(0).getGroupInfo();
                        if (groupInfo != null) {
                            str = groupInfo.getGroupName();
                        } else {
                            str = str;
                        }
                        TUIChatUtils.callbackOnSuccess(iUIKitCallback, str);
                        return;
                    }
                    TUIChatUtils.callbackOnError(iUIKitCallback, v2TIMGroupInfoResult.getResultCode(), v2TIMGroupInfoResult.getResultMessage());
                }
            });
        }
    }

    public void getConversationLastMessage(String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getConversationManager().getConversation(str, new V2TIMValueCallback<V2TIMConversation>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                Log.e(access$000, "getConversationLastMessage error:" + i11 + ", desc:" + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(V2TIMConversation v2TIMConversation) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMConversation.getLastMessage()));
            }
        });
    }

    public void getFriendName(String str, final IUIKitCallback<String[]> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getFriendshipManager().getFriendsInfo(arrayList, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMFriendInfoResult> list) {
                V2TIMFriendInfoResult v2TIMFriendInfoResult = list.get(0);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, new String[]{v2TIMFriendInfoResult.getFriendInfo().getFriendRemark(), v2TIMFriendInfoResult.getFriendInfo().getUserProfile().getNickName()});
            }
        });
    }

    public void getGroupInfo(List<String> list, final IUIKitCallback<List<GroupInfo>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupsInfo(list, new V2TIMValueCallback<List<V2TIMGroupInfoResult>>() {
            public void onError(int i11, String str) {
                TUIGroupUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMGroupInfoResult> list) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMGroupInfoResult next : list) {
                    if (next.getResultCode() != 0) {
                        TUIGroupUtils.callbackOnError(iUIKitCallback, next.getResultCode(), next.getResultMessage());
                        return;
                    }
                    GroupInfo groupInfo = new GroupInfo();
                    groupInfo.setId(next.getGroupInfo().getGroupID());
                    groupInfo.setFaceUrl(next.getGroupInfo().getFaceUrl());
                    groupInfo.setGroupName(next.getGroupInfo().getGroupName());
                    groupInfo.setMemberCount(next.getGroupInfo().getMemberCount());
                    groupInfo.setGroupType(next.getGroupInfo().getGroupType());
                    arrayList.add(groupInfo);
                }
                TUIGroupUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getGroupMemberList(String str, int i11, long j11, V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, i11, j11, v2TIMValueCallback);
    }

    public void getGroupMembersInfo(String str, List<String> list, final IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        if (TUIChatUtils.isTopicGroup(str)) {
            str = TUIChatUtils.getGroupIDFromTopicID(str);
        }
        V2TIMManager.getGroupManager().getGroupMembersInfo(str, list, new V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMGroupMemberFullInfo> list) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMGroupMemberFullInfo covertTIMGroupMemberInfo : list) {
                    arrayList.add(new GroupMemberInfo().covertTIMGroupMemberInfo(covertTIMGroupMemberInfo));
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getGroupMessageBySeq(String str, long j11, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(1);
        v2TIMMessageListGetOption.setGetType(3);
        v2TIMMessageListGetOption.setLastMsgSeq(j11);
        v2TIMMessageListGetOption.setGroupID(str);
        V2TIMManager.getMessageManager().getHistoryMessageList(v2TIMMessageListGetOption, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i11 + ", desc = " + str);
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z11, int i11, long j11, final IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        AnonymousClass24 r62 = new V2TIMValueCallback<V2TIMGroupMessageReadMemberList>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(V2TIMGroupMessageReadMemberList v2TIMGroupMessageReadMemberList) {
                GroupMessageReadMembersInfo groupMessageReadMembersInfo = new GroupMessageReadMembersInfo();
                groupMessageReadMembersInfo.setReadMembers(v2TIMGroupMessageReadMemberList);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, groupMessageReadMembersInfo);
            }
        };
        messageManager.getGroupMessageReadMemberList(v2TIMMessage, z11 ^ true ? 1 : 0, j11, i11, r62);
    }

    public void getMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<List<MessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean v2TIMMessage : list) {
            arrayList.add(v2TIMMessage.getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().getMessageReadReceipts(arrayList, new V2TIMValueCallback<List<V2TIMMessageReceipt>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMMessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMMessageReceipt messageReceipt : list) {
                    MessageReceiptInfo messageReceiptInfo = new MessageReceiptInfo();
                    messageReceiptInfo.setMessageReceipt(messageReceipt);
                    arrayList.add(messageReceiptInfo);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getReactUserBean(List<String> list, final IUIKitCallback<List<ReactUserBean>> iUIKitCallback) {
        V2TIMManager.getFriendshipManager().getFriendsInfo(list, new V2TIMValueCallback<List<V2TIMFriendInfoResult>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMFriendInfoResult> list) {
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfoResult next : list) {
                    ReactUserBean reactUserBean = new ReactUserBean();
                    reactUserBean.setUserId(next.getFriendInfo().getUserID());
                    reactUserBean.setFriendRemark(next.getFriendInfo().getFriendRemark());
                    reactUserBean.setFaceUrl(next.getFriendInfo().getUserProfile().getFaceUrl());
                    if (next.getFriendInfo().getUserProfile() != null) {
                        reactUserBean.setNikeName(next.getFriendInfo().getUserProfile().getNickName());
                    }
                    arrayList.add(reactUserBean);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void groupReadReport(String str) {
        V2TIMManager.getMessageManager().markGroupMessageAsRead(str, new V2TIMCallback() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "markGroupMessageAsRead failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess() {
                TUIChatLog.d(ChatProvider.TAG, "markGroupMessageAsRead success");
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add("group_" + str);
        V2TIMManager.getConversationManager().markConversation(arrayList, V2TIMConversation.V2TIM_CONVERSATION_MARK_TYPE_UNREAD, false, new V2TIMValueCallback<List<V2TIMConversationOperationResult>>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "mark group conversation unread disable failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMConversationOperationResult> list) {
                if (list.size() > 0) {
                    V2TIMConversationOperationResult v2TIMConversationOperationResult = list.get(0);
                    String access$000 = ChatProvider.TAG;
                    TUIChatLog.d(access$000, "mark group conversation unread disable success, code:" + v2TIMConversationOperationResult.getResultCode() + "|msg:" + v2TIMConversationOperationResult.getResultInfo());
                    return;
                }
                TUIChatLog.e(ChatProvider.TAG, "mark group conversation unread disable failed, results size = 0");
            }
        });
    }

    public void loadApplyInfo(final IUIKitCallback<List<GroupApplyInfo>> iUIKitCallback) {
        final ArrayList arrayList = new ArrayList();
        V2TIMManager.getGroupManager().getGroupApplicationList(new V2TIMValueCallback<V2TIMGroupApplicationResult>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "getGroupPendencyList failed, code: " + i11 + "|desc: " + ErrorMessageConverter.convertIMError(i11, str));
                iUIKitCallback.onError(ChatProvider.TAG, i11, ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(V2TIMGroupApplicationResult v2TIMGroupApplicationResult) {
                List<V2TIMGroupApplication> groupApplicationList = v2TIMGroupApplicationResult.getGroupApplicationList();
                for (int i11 = 0; i11 < groupApplicationList.size(); i11++) {
                    GroupApplyInfo groupApplyInfo = new GroupApplyInfo(groupApplicationList.get(i11));
                    groupApplyInfo.setStatus(0);
                    arrayList.add(groupApplyInfo);
                }
                iUIKitCallback.onSuccess(arrayList);
            }
        });
    }

    public void loadC2CMessage(String str, int i11, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, i11, tUIMessageBean != null ? tUIMessageBean.getV2TIMMessage() : null, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getC2CHistoryMessageList failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadGroupMembers(String str, long j11, final IUIKitCallback<List<GroupMemberInfo>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, 0, j11, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "loadGroupMembers failed, code: " + i11 + "|desc: " + ErrorMessageConverter.convertIMError(i11, str));
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < v2TIMGroupMemberInfoResult.getMemberInfoList().size(); i11++) {
                    arrayList.add(new GroupMemberInfo().covertTIMGroupMemberInfo(v2TIMGroupMemberInfoResult.getMemberInfoList().get(i11)));
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void loadGroupMessage(String str, int i11, TUIMessageBean tUIMessageBean, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMManager.getMessageManager().getGroupHistoryMessageList(str, i11, tUIMessageBean != null ? tUIMessageBean.getV2TIMMessage() : null, new V2TIMValueCallback<List<V2TIMMessage>>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getC2CHistoryMessageList failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadHistoryMessageList(String str, boolean z11, int i11, TUIMessageBean tUIMessageBean, int i12, final IUIKitCallback<List<TUIMessageBean>> iUIKitCallback) {
        V2TIMMessageListGetOption v2TIMMessageListGetOption = new V2TIMMessageListGetOption();
        v2TIMMessageListGetOption.setCount(i11);
        if (i12 == 0) {
            v2TIMMessageListGetOption.setGetType(1);
        } else if (i12 == 1) {
            v2TIMMessageListGetOption.setGetType(2);
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
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "loadChatMessages getHistoryMessageList optionBackward failed, code = " + i11 + ", desc = " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess(List<V2TIMMessage> list) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessageList(list));
            }
        });
    }

    public void loadUserStatus(List<String> list, final IUIKitCallback<Map<String, UserStatusBean>> iUIKitCallback) {
        if (list == null || list.size() == 0) {
            TUIChatLog.d(TAG, "loadContactUserStatus datasource is null");
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "data list is empty");
            return;
        }
        V2TIMManager.getInstance().getUserStatus(list, new V2TIMValueCallback<List<V2TIMUserStatus>>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "getUserStatus error code = " + i11 + ",des = " + str);
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess(List<V2TIMUserStatus> list) {
                TUIChatLog.i(ChatProvider.TAG, "getUserStatus success");
                HashMap hashMap = new HashMap();
                for (V2TIMUserStatus next : list) {
                    UserStatusBean userStatusBean = new UserStatusBean();
                    userStatusBean.setUserID(next.getUserID());
                    userStatusBean.setOnlineStatus(next.getStatusType());
                    hashMap.put(next.getUserID(), userStatusBean);
                }
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, hashMap);
            }
        });
    }

    public void modifyMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getMessageManager().modifyMessage(tUIMessageBean.getV2TIMMessage(), new V2TIMCompleteCallback<V2TIMMessage>() {
            public void onComplete(int i11, String str, V2TIMMessage v2TIMMessage) {
                TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
                if (i11 == 8006) {
                    TUIChatUtils.callbackOnError(iUIKitCallback, i11, str, parseMessage);
                } else {
                    TUIChatUtils.callbackOnSuccess(iUIKitCallback, parseMessage);
                }
            }
        });
    }

    public void muteGroupMember(String str, String str2, int i11, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getGroupManager().muteGroupMember(str, str2, i11, new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUIGroupUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess() {
                TUIGroupUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void revokeMessage(TUIMessageBean tUIMessageBean, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getMessageManager().revokeMessage(tUIMessageBean.getV2TIMMessage(), new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
            }

            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void sendGroupTipsMessage(String str, String str2, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMManager.getMessageManager().sendMessage(ChatMessageBuilder.buildGroupCustomMessage(str2), (String) null, str, 0, false, (V2TIMOfflinePushInfo) null, new V2TIMSendCallback<V2TIMMessage>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
            }

            public void onProgress(int i11) {
            }

            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIChatLog.i(ChatProvider.TAG, "sendTipsMessage onSuccess");
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage));
            }
        });
    }

    public String sendMessage(TUIMessageBean tUIMessageBean, ChatInfo chatInfo, IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        boolean z11;
        String str;
        setMessageTypingFeature(tUIMessageBean);
        OfflineMessageContainerBean offlineMessageContainerBean = new OfflineMessageContainerBean();
        OfflineMessageBean offlineMessageBean = new OfflineMessageBean();
        offlineMessageBean.content = tUIMessageBean.getExtra();
        offlineMessageBean.sender = tUIMessageBean.getSender();
        offlineMessageBean.nickname = chatInfo.getChatName();
        offlineMessageBean.faceUrl = TUIConfig.getSelfFaceUrl();
        offlineMessageContainerBean.entity = offlineMessageBean;
        String str2 = "";
        if (chatInfo.getType() == 2) {
            str = chatInfo.getId();
            z11 = true;
            offlineMessageBean.chatType = 2;
            offlineMessageBean.sender = str;
        } else {
            z11 = false;
            str = str2;
            str2 = chatInfo.getId();
        }
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setExt(new Gson().toJson((Object) offlineMessageContainerBean).getBytes());
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isAndroidPrivateRing()) {
            v2TIMOfflinePushInfo.setAndroidSound(OfflinePushInfoUtils.PRIVATE_RING_NAME);
            v2TIMOfflinePushInfo.setAndroidFCMChannelID(OfflinePushInfoUtils.FCM_PUSH_CHANNEL_ID);
        }
        v2TIMOfflinePushInfo.setAndroidHuaWeiCategory("IM");
        v2TIMOfflinePushInfo.setAndroidVIVOCategory("IM");
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        if (z11) {
            str2 = null;
        }
        if (!z11) {
            str = null;
        }
        final IUIKitCallback<TUIMessageBean> iUIKitCallback2 = iUIKitCallback;
        final V2TIMMessage v2TIMMessage2 = v2TIMMessage;
        final TUIMessageBean tUIMessageBean2 = tUIMessageBean;
        final ChatInfo chatInfo2 = chatInfo;
        return messageManager.sendMessage(v2TIMMessage, str2, str, 0, false, v2TIMOfflinePushInfo, new V2TIMSendCallback<V2TIMMessage>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback2, ChatProvider.TAG, i11, str);
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUIChat.V2TIMMESSAGE, v2TIMMessage2);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_FAILED, hashMap);
            }

            public void onProgress(int i11) {
                TUIChatUtils.callbackOnProgress(iUIKitCallback2, Integer.valueOf(i11));
            }

            public void onSuccess(V2TIMMessage v2TIMMessage) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.v(access$000, "sendMessage onSuccess:" + v2TIMMessage.getMsgID());
                tUIMessageBean2.setV2TIMMessage(v2TIMMessage);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback2, tUIMessageBean2);
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", chatInfo2.getId());
                hashMap.put(TUIConstants.TUIChat.V2TIMMESSAGE, v2TIMMessage);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }

    public void sendMessageReadReceipt(List<TUIMessageBean> list, final IUIKitCallback<Void> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        for (TUIMessageBean v2TIMMessage : list) {
            arrayList.add(v2TIMMessage.getV2TIMMessage());
        }
        V2TIMManager.getMessageManager().sendMessageReadReceipts(arrayList, new V2TIMCallback() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, i11, str);
            }

            public void onSuccess() {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public String sendTypingStatusMessage(final TUIMessageBean tUIMessageBean, final String str, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        return V2TIMManager.getMessageManager().sendMessage(tUIMessageBean.getV2TIMMessage(), str, (String) null, 0, true, (V2TIMOfflinePushInfo) null, new V2TIMSendCallback<V2TIMMessage>() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.v(access$000, "sendMessage fail:" + i11 + ContainerUtils.KEY_VALUE_DELIMITER + ErrorMessageConverter.convertIMError(i11, str));
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
            }

            public void onProgress(int i11) {
            }

            public void onSuccess(V2TIMMessage v2TIMMessage) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.v(access$000, "sendMessage onSuccess:" + v2TIMMessage.getMsgID());
                tUIMessageBean.setStatus(2);
                tUIMessageBean.setV2TIMMessage(v2TIMMessage);
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, tUIMessageBean);
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", str);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }

    public void setDraft(String str, final String str2) {
        V2TIMManager.getConversationManager().setConversationDraft(str, str2, new V2TIMCallback() {
            public void onError(int i11, String str) {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.e(access$000, "set drafts error : " + i11 + " " + ErrorMessageConverter.convertIMError(i11, str));
            }

            public void onSuccess() {
                String access$000 = ChatProvider.TAG;
                TUIChatLog.i(access$000, "set draft success " + str2);
            }
        });
    }

    public String sendMessage(TUIMessageBean tUIMessageBean, boolean z11, final String str, OfflinePushInfo offlinePushInfo, final IUIKitCallback<TUIMessageBean> iUIKitCallback) {
        V2TIMMessage v2TIMMessage = tUIMessageBean.getV2TIMMessage();
        v2TIMMessage.setExcludedFromUnreadCount(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromUnreadCount());
        v2TIMMessage.setExcludedFromLastMessage(TUIChatConfigs.getConfigs().getGeneralConfig().isExcludedFromLastMessage());
        return V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, z11 ? null : str, z11 ? str : null, 0, false, OfflinePushInfoUtils.convertOfflinePushInfoToV2PushInfo(offlinePushInfo), new V2TIMSendCallback<V2TIMMessage>() {
            public void onError(int i11, String str) {
                TUIChatUtils.callbackOnError(iUIKitCallback, ChatProvider.TAG, i11, str);
            }

            public void onProgress(int i11) {
            }

            public void onSuccess(V2TIMMessage v2TIMMessage) {
                TUIChatUtils.callbackOnSuccess(iUIKitCallback, ChatMessageParser.parseMessage(v2TIMMessage));
                HashMap hashMap = new HashMap();
                hashMap.put("chatId", str);
                TUICore.notifyEvent(TUIConstants.TUIChat.EVENT_KEY_MESSAGE_EVENT, TUIConstants.TUIChat.EVENT_SUB_KEY_SEND_MESSAGE_SUCCESS, hashMap);
            }
        });
    }
}

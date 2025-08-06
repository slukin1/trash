package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupApplicationResult;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupInfoGetResult;
import com.tencent.imsdk.group.GroupInfoModifyParam;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoModifyParam;
import com.tencent.imsdk.group.GroupMemberInfoResult;
import com.tencent.imsdk.group.GroupMemberOperationResult;
import com.tencent.imsdk.group.TopicInfo;
import com.tencent.imsdk.group.TopicOperationResult;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2TIMGroupManagerImpl extends V2TIMGroupManager {
    private final String TAG;

    public static class V2TIMGroupManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMGroupManagerImpl v2TIMGroupManagerImpl = new V2TIMGroupManagerImpl();

        private V2TIMGroupManagerImplHolder() {
        }
    }

    public static V2TIMGroupManagerImpl getInstance() {
        return V2TIMGroupManagerImplHolder.v2TIMGroupManagerImpl;
    }

    public void acceptGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().acceptGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void createGroup(V2TIMGroupInfo v2TIMGroupInfo, List<V2TIMCreateGroupMemberInfo> list, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "createGroup, null info");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "info is null");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (V2TIMCreateGroupMemberInfo next : list) {
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                groupMemberInfo.setUserID(next.getUserID());
                groupMemberInfo.setRole(next.getRole());
                arrayList.add(groupMemberInfo);
            }
        }
        GroupManager.getInstance().createGroup(v2TIMGroupInfo.getGroupInfo(), arrayList, new IMCallback<String>(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(String str) {
                super.success(str);
            }
        });
    }

    public void createTopicInCommunity(String str, V2TIMTopicInfo v2TIMTopicInfo, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else if (v2TIMTopicInfo != null) {
            GroupInfo groupInfo = v2TIMTopicInfo.getGroupInfo();
            groupInfo.setCommunityID(str);
            GroupManager.getInstance().createTopic(groupInfo, new IMCallback<String>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(String str) {
                    super.success(str);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "topicInfo is null");
        }
    }

    public void decreaseGroupCounter(String str, String str2, long j11, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else if (TextUtils.isEmpty(str2)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, key is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "key is empty");
            }
        } else {
            GroupManager.getInstance().decreaseGroupCounter(str, str2, j11, new IMCallback<Map<String, Long>>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Map<String, Long> map) {
                    super.success(map);
                }
            });
        }
    }

    public void deleteGroupAttributes(String str, List<String> list, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "deleteGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().deleteGroupAttributes(str, list, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void deleteTopicFromCommunity(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicOperationResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            GroupManager.getInstance().deleteTopic(str, list, new IMCallback(new V2TIMValueCallback<List<TopicOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<TopicOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicOperationResult topicOperationResult : list) {
                            V2TIMTopicOperationResult v2TIMTopicOperationResult = new V2TIMTopicOperationResult();
                            v2TIMTopicOperationResult.setTopicOperationResult(topicOperationResult);
                            arrayList.add(v2TIMTopicOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
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
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID or topicIDList");
        }
    }

    public void getGroupApplicationList(final V2TIMValueCallback<V2TIMGroupApplicationResult> v2TIMValueCallback) {
        GroupManager.getInstance().getGroupApplicationList(new IMCallback<GroupApplicationResult>(new V2TIMValueCallback<GroupApplicationResult>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(GroupApplicationResult groupApplicationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupApplicationResult v2TIMGroupApplicationResult = new V2TIMGroupApplicationResult();
                    v2TIMGroupApplicationResult.setGroupApplicationResult(groupApplicationResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupApplicationResult);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(GroupApplicationResult groupApplicationResult) {
                super.success(groupApplicationResult);
            }
        });
    }

    public void getGroupAttributes(String str, List<String> list, V2TIMValueCallback<Map<String, String>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupAttributes error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupAttributes(str, list, new IMCallback<Map<String, String>>(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Map<String, String> map) {
                super.success(map);
            }
        });
    }

    public void getGroupCounters(String str, List<String> list, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupCounters(str, list, new IMCallback<Map<String, Long>>(v2TIMValueCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Map<String, Long> map) {
                super.success(map);
            }
        });
    }

    public void getGroupMemberList(String str, int i11, long j11, final V2TIMValueCallback<V2TIMGroupMemberInfoResult> v2TIMValueCallback) {
        int i12;
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMemberList error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        int i13 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ALL;
        if (i11 != 0) {
            if (i11 == 1) {
                i11 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_OWNER;
            } else if (i11 == 2) {
                i11 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_ADMINISTRATOR;
            } else if (i11 == 4) {
                i11 = GroupMemberInfo.GROUP_MEMBER_FILTER_FLAG_MEMBER;
            }
            i12 = i11;
        } else {
            i12 = i13;
        }
        String str2 = str;
        long j12 = j11;
        GroupManager.getInstance().getGroupMemberList(str2, i12, j12, new IMCallback<GroupMemberInfoResult>(new V2TIMValueCallback<GroupMemberInfoResult>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(GroupMemberInfoResult groupMemberInfoResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult = new V2TIMGroupMemberInfoResult();
                    v2TIMGroupMemberInfoResult.setGroupMemberInfoResult(groupMemberInfoResult);
                    v2TIMValueCallback.onSuccess(v2TIMGroupMemberInfoResult);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(GroupMemberInfoResult groupMemberInfoResult) {
                super.success(groupMemberInfoResult);
            }
        });
    }

    public void getGroupMembersInfo(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberFullInfo>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupMembersInfo fail, memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "memberList is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupMembersInfo(str, list, new IMCallback<List<GroupMemberInfo>>(new V2TIMValueCallback<List<GroupMemberInfo>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupMemberInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMemberInfo groupMemberInfo : list) {
                        V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                        v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                        arrayList.add(v2TIMGroupMemberFullInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupMemberInfo> list) {
                super.success(list);
            }
        });
    }

    public void getGroupOnlineMemberCount(String str, V2TIMValueCallback<Integer> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().getGroupOnlineMemberCount(str, new IMCallback<Integer>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Integer num) {
                    super.success(num);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
        }
    }

    public void getGroupsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMGroupInfoResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "getGroupsInfo error, empty groupIDList");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty groupIDList");
                return;
            }
            return;
        }
        GroupManager.getInstance().getGroupsInfo(list, new IMCallback<List<GroupInfoGetResult>>(new V2TIMValueCallback<List<GroupInfoGetResult>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupInfoGetResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfoGetResult groupInfoGetResult : list) {
                        V2TIMGroupInfoResult v2TIMGroupInfoResult = new V2TIMGroupInfoResult();
                        v2TIMGroupInfoResult.setGroupInfoGetResult(groupInfoGetResult);
                        arrayList.add(v2TIMGroupInfoResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupInfoGetResult> list) {
                super.success(list);
            }
        });
    }

    public void getJoinedCommunityList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedCommunityList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupInfo> list) {
                super.success(list);
            }
        });
        BaseManager.getInstance().checkTUIComponent(8);
    }

    public void getJoinedGroupList(final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        GroupManager.getInstance().getJoinedGroupList(new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupInfo> list) {
                super.success(list);
            }
        });
    }

    public void getTopicInfoList(String str, List<String> list, final V2TIMValueCallback<List<V2TIMTopicInfoResult>> v2TIMValueCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().getTopicList(str, list, new IMCallback<List<TopicInfo>>(new V2TIMValueCallback<List<TopicInfo>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<TopicInfo> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (TopicInfo topicInfo : list) {
                            V2TIMTopicInfoResult v2TIMTopicInfoResult = new V2TIMTopicInfoResult();
                            v2TIMTopicInfoResult.setTopicInfo(topicInfo);
                            arrayList.add(v2TIMTopicInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<TopicInfo> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
        }
    }

    public void increaseGroupCounter(String str, String str2, long j11, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else if (TextUtils.isEmpty(str2)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, key is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "key is empty");
            }
        } else {
            GroupManager.getInstance().increaseGroupCounter(str, str2, j11, new IMCallback<Map<String, Long>>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Map<String, Long> map) {
                    super.success(map);
                }
            });
        }
    }

    public void initGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "initGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().initGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void inviteUserToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "inviteUserToGroup error, groupID or userList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userList is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().inviteUserToGroup(str, list, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupMemberOperationResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMemberOperationResult groupMemberOperationResult : list) {
                        V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                        v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                        arrayList.add(v2TIMGroupMemberOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupMemberOperationResult> list) {
                super.success(list);
            }
        });
    }

    public void kickGroupMember(String str, List<String> list, String str2, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "kickGroupMember error, groupID or memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or memberList is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().kickGroupMember(str, list, str2, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupMemberOperationResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMemberOperationResult groupMemberOperationResult : list) {
                        V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                        v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                        arrayList.add(v2TIMGroupMemberOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupMemberOperationResult> list) {
                super.success(list);
            }
        });
    }

    public void markGroupMemberList(String str, List<String> list, int i11, boolean z11, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid groupID");
            }
        } else if (list != null && !list.isEmpty()) {
            GroupManager.getInstance().markGroupMemberList(str, list, i11, z11, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty member list");
        }
    }

    public void muteGroupMember(String str, String str2, int i11, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            GroupManager.getInstance().muteGroupMember(str, str2, i11, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
        }
    }

    public void refuseGroupApplication(V2TIMGroupApplication v2TIMGroupApplication, String str, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupApplication == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "acceptGroupApplication err, v2TIMGroupApplication is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMGroupApplication is null");
                return;
            }
            return;
        }
        GroupManager.getInstance().refuseGroupApplication(v2TIMGroupApplication.getGroupApplication(), str, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void searchGroupMembers(V2TIMGroupMemberSearchParam v2TIMGroupMemberSearchParam, final V2TIMValueCallback<HashMap<String, List<V2TIMGroupMemberFullInfo>>> v2TIMValueCallback) {
        if (v2TIMGroupMemberSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupMemberSearchParam.getKeywordList() != null && !v2TIMGroupMemberSearchParam.getKeywordList().isEmpty()) {
            GroupManager.getInstance().searchGroupMembersInfo(v2TIMGroupMemberSearchParam.getGroupMemberSearchParam(), new IMCallback<HashMap<String, List<GroupMemberInfo>>>(new V2TIMValueCallback<HashMap<String, List<GroupMemberInfo>>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry next : hashMap.entrySet()) {
                        ArrayList arrayList = new ArrayList();
                        for (GroupMemberInfo groupMemberInfo : (List) next.getValue()) {
                            V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                            v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                            arrayList.add(v2TIMGroupMemberFullInfo);
                        }
                        hashMap2.put(next.getKey(), arrayList);
                    }
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onSuccess(hashMap2);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(HashMap<String, List<GroupMemberInfo>> hashMap) {
                    super.success(hashMap);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "keywordList cannot be empty");
        }
    }

    public void searchGroups(V2TIMGroupSearchParam v2TIMGroupSearchParam, final V2TIMValueCallback<List<V2TIMGroupInfo>> v2TIMValueCallback) {
        if (v2TIMGroupSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMGroupSearchParam.getKeywordList() != null && v2TIMGroupSearchParam.getKeywordList().size() != 0) {
            GroupManager.getInstance().searchGroups(v2TIMGroupSearchParam.getGroupSearchParam(), new IMCallback<List<GroupInfo>>(new V2TIMValueCallback<List<GroupInfo>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<GroupInfo> list) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupInfo groupInfo : list) {
                        V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                        v2TIMGroupInfo.setGroupInfo(groupInfo);
                        arrayList.add(v2TIMGroupInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<GroupInfo> list) {
                    super.success(list);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "empty keywordList");
        }
    }

    public void setGroupApplicationRead(V2TIMCallback v2TIMCallback) {
        GroupManager.getInstance().setGroupApplicationRead(new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setGroupAttributes(String str, HashMap<String, String> hashMap, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else if (hashMap == null || hashMap.size() == 0) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupAttributes error, attributes is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "attributes is empty");
            }
        } else {
            GroupManager.getInstance().setGroupAttributes(str, hashMap, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    public void setGroupCounters(String str, HashMap<String, Long> hashMap, V2TIMValueCallback<Map<String, Long>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, groupID is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty");
            }
        } else if (hashMap == null || hashMap.isEmpty()) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupCounters error, counters is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "counters is empty");
            }
        } else {
            GroupManager.getInstance().setGroupCounters(str, hashMap, new IMCallback<Map<String, Long>>(v2TIMValueCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Map<String, Long> map) {
                    super.success(map);
                }
            });
        }
    }

    public void setGroupInfo(V2TIMGroupInfo v2TIMGroupInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMGroupInfo == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupInfo error, null info");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "null info");
                return;
            }
            return;
        }
        GroupInfo groupInfo = v2TIMGroupInfo.getGroupInfo();
        GroupInfoModifyParam groupInfoModifyParam = new GroupInfoModifyParam();
        groupInfoModifyParam.setGroupInfo(groupInfo);
        groupInfoModifyParam.setModifyFlag((long) v2TIMGroupInfo.getModifyFlag());
        GroupManager.getInstance().setGroupInfo(groupInfoModifyParam, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setGroupMemberInfo(String str, V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || v2TIMGroupMemberFullInfo == null) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberInfo error, groupID is empty or profile is null");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID is empty or profile is null");
                return;
            }
            return;
        }
        GroupMemberInfoModifyParam groupMemberInfoModifyParam = new GroupMemberInfoModifyParam();
        groupMemberInfoModifyParam.setModifyFlag(v2TIMGroupMemberFullInfo.getModifyFlag());
        groupMemberInfoModifyParam.setMemberInfo(v2TIMGroupMemberFullInfo.getGroupMemberInfo());
        groupMemberInfoModifyParam.getMemberInfo().setGroupID(str);
        GroupManager.getInstance().setGroupMemberInfo(groupMemberInfoModifyParam, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setGroupMemberRole(String str, String str2, int i11, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "setGroupMemberRole error, groupID or userID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
                return;
            }
            return;
        }
        int i12 = GroupMemberInfo.MEMBER_ROLE_MEMBER;
        if (400 == i11) {
            i11 = GroupMemberInfo.MEMBER_ROLE_OWNER;
        } else if (300 == i11) {
            i11 = GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR;
        }
        GroupManager.getInstance().setGroupMemberRole(str, str2, i11, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setTopicInfo(V2TIMTopicInfo v2TIMTopicInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMTopicInfo != null) {
            GroupInfo groupInfo = v2TIMTopicInfo.getGroupInfo();
            GroupInfoModifyParam groupInfoModifyParam = new GroupInfoModifyParam();
            groupInfoModifyParam.setGroupInfo(groupInfo);
            groupInfoModifyParam.setModifyFlag((long) v2TIMTopicInfo.getModifyFlag());
            GroupManager.getInstance().setTopicInfo(groupInfoModifyParam, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
            if (v2TIMTopicInfo.isNeedModifyDraft()) {
                ConversationKey conversationKey = new ConversationKey();
                conversationKey.setConversationID(v2TIMTopicInfo.getTopicID());
                conversationKey.setConversationType(2);
                DraftMessage draftMessage = new DraftMessage();
                String tempDraft = v2TIMTopicInfo.getTopicInfo().getTempDraft();
                if (tempDraft != null) {
                    draftMessage.setUserDefinedData(tempDraft.getBytes());
                }
                ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(new V2TIMCallback() {
                    public void onError(int i11, String str) {
                        IMLog.i("V2TIMAdvGroupMgrImpl", "setTopicDraft failed, code:" + i11 + ", desc:" + str);
                    }

                    public void onSuccess() {
                        IMLog.i("V2TIMAdvGroupMgrImpl", "setTopicDraft success");
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
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "invalid topicInfo");
        }
    }

    public void transferGroupOwner(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "transferGroupOwner error, groupID or userID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or userID is empty");
                return;
            }
            return;
        }
        GroupManager.getInstance().transferGroupOwner(str, str2, new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private V2TIMGroupManagerImpl() {
        this.TAG = "V2TIMAdvGroupMgrImpl";
    }

    public void kickGroupMember(String str, List<String> list, String str2, int i11, final V2TIMValueCallback<List<V2TIMGroupMemberOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            IMLog.e("V2TIMAdvGroupMgrImpl", "kickGroupMember error, groupID or memberList is empty");
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupID or memberList is empty");
                return;
            }
            return;
        }
        String str3 = str;
        List<String> list2 = list;
        String str4 = str2;
        int i12 = i11;
        GroupManager.getInstance().banGroupMember(str3, list2, str4, i12, new IMCallback<List<GroupMemberOperationResult>>(new V2TIMValueCallback<List<GroupMemberOperationResult>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<GroupMemberOperationResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMemberOperationResult groupMemberOperationResult : list) {
                        V2TIMGroupMemberOperationResult v2TIMGroupMemberOperationResult = new V2TIMGroupMemberOperationResult();
                        v2TIMGroupMemberOperationResult.setGroupMemberOperationResult(groupMemberOperationResult);
                        arrayList.add(v2TIMGroupMemberOperationResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<GroupMemberOperationResult> list) {
                super.success(list);
            }
        });
    }
}

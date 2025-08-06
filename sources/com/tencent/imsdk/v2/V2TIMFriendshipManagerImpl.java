package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.relationship.FriendApplication;
import com.tencent.imsdk.relationship.FriendApplicationResult;
import com.tencent.imsdk.relationship.FriendCheckResult;
import com.tencent.imsdk.relationship.FriendGroup;
import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.FriendInfoResult;
import com.tencent.imsdk.relationship.FriendOperationResult;
import com.tencent.imsdk.relationship.FriendResponse;
import com.tencent.imsdk.relationship.FriendshipListener;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V2TIMFriendshipManagerImpl extends V2TIMFriendshipManager {
    private final String TAG;
    private FriendshipListener mFriendshipInternalListener;
    /* access modifiers changed from: private */
    public final List<V2TIMFriendshipListener> mFriendshipListenerList;
    /* access modifiers changed from: private */
    public V2TIMFriendshipListener mV2TIMFriendshipListener;

    public static class V2TIMFriendshipManagerImplHolder {
        /* access modifiers changed from: private */
        public static final V2TIMFriendshipManagerImpl v2TIMFriendshipManagerImpl = new V2TIMFriendshipManagerImpl();

        private V2TIMFriendshipManagerImplHolder() {
        }
    }

    public static V2TIMFriendshipManagerImpl getInstance() {
        return V2TIMFriendshipManagerImplHolder.v2TIMFriendshipManagerImpl;
    }

    private void initFriendshipListener() {
        this.mFriendshipInternalListener = new FriendshipListener() {
            public void OnBlackListAdded(List<FriendInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                for (V2TIMFriendshipListener onBlackListAdd : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onBlackListAdd.onBlackListAdd(unmodifiableList);
                }
            }

            public void OnBlackListDeleted(List<String> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(list);
                for (V2TIMFriendshipListener onBlackListDeleted : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onBlackListDeleted.onBlackListDeleted(unmodifiableList);
                }
            }

            public void OnFriendApplicationListAdded(List<FriendApplication> list) {
                ArrayList arrayList = new ArrayList();
                for (FriendApplication friendApplication : list) {
                    V2TIMFriendApplication v2TIMFriendApplication = new V2TIMFriendApplication();
                    v2TIMFriendApplication.setFriendApplication(friendApplication);
                    arrayList.add(v2TIMFriendApplication);
                }
                List unmodifiableList = Collections.unmodifiableList(arrayList);
                for (V2TIMFriendshipListener onFriendApplicationListAdded : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendApplicationListAdded.onFriendApplicationListAdded(unmodifiableList);
                }
            }

            public void OnFriendApplicationListDelete(List<String> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(list);
                for (V2TIMFriendshipListener onFriendApplicationListDeleted : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendApplicationListDeleted.onFriendApplicationListDeleted(unmodifiableList);
                }
            }

            public void OnFriendApplicationListRead() {
                for (V2TIMFriendshipListener onFriendApplicationListRead : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendApplicationListRead.onFriendApplicationListRead();
                }
            }

            public void OnFriendInfoChanged(List<FriendInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                for (V2TIMFriendshipListener onFriendInfoChanged : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendInfoChanged.onFriendInfoChanged(unmodifiableList);
                }
            }

            public void OnFriendListAdded(List<FriendInfo> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(convertToV2FriendInfoList(list));
                for (V2TIMFriendshipListener onFriendListAdded : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendListAdded.onFriendListAdded(unmodifiableList);
                }
            }

            public void OnFriendListDeleted(List<String> list) {
                List<T> unmodifiableList = Collections.unmodifiableList(list);
                for (V2TIMFriendshipListener onFriendListDeleted : V2TIMFriendshipManagerImpl.this.mFriendshipListenerList) {
                    onFriendListDeleted.onFriendListDeleted(unmodifiableList);
                }
            }

            public void OnSelfInfoUpdated(UserInfo userInfo) {
            }

            public V2TIMFriendInfo convertToV2FriendInfo(FriendInfo friendInfo) {
                V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                if (friendInfo != null) {
                    v2TIMFriendInfo.setFriendInfo(friendInfo);
                }
                return v2TIMFriendInfo;
            }

            public List<V2TIMFriendInfo> convertToV2FriendInfoList(List<FriendInfo> list) {
                ArrayList arrayList = new ArrayList();
                for (FriendInfo convertToV2FriendInfo : list) {
                    arrayList.add(convertToV2FriendInfo(convertToV2FriendInfo));
                }
                return arrayList;
            }
        };
        RelationshipManager.getInstance().setFriendshipListener(this.mFriendshipInternalListener);
    }

    public void acceptFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, int i11, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        int i12 = 1;
        if (i11 == 0 || i11 == 1) {
            if (v2TIMFriendApplication != null) {
                AnonymousClass19 r02 = new V2TIMValueCallback<FriendOperationResult>() {
                    public void onError(int i11, String str) {
                        V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(i11, str);
                        }
                    }

                    public void onSuccess(FriendOperationResult friendOperationResult) {
                        if (v2TIMValueCallback != null) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                        }
                    }
                };
                FriendResponse friendResponse = new FriendResponse();
                friendResponse.setUserID(v2TIMFriendApplication.getUserID());
                if (i11 != 0) {
                    i12 = 2;
                }
                friendResponse.setResponseType(i12);
                RelationshipManager.getInstance().responseFriendApplication(friendResponse, new IMCallback<FriendOperationResult>(r02) {
                    public void fail(int i11, String str) {
                        super.fail(i11, str);
                    }

                    public void success(FriendOperationResult friendOperationResult) {
                        super.success(friendOperationResult);
                    }
                });
            } else if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMFriendApplication is null");
            }
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "responseType is invalid : " + i11);
        }
    }

    public void addFriend(V2TIMFriendAddApplication v2TIMFriendAddApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendAddApplication != null) {
            RelationshipManager.getInstance().addFriend(v2TIMFriendAddApplication.getFriendAddApplication(), new IMCallback<FriendOperationResult>(new V2TIMValueCallback<FriendOperationResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(FriendOperationResult friendOperationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                        v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(FriendOperationResult friendOperationResult) {
                    super.success(friendOperationResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "v2TIMFriendApplication is null");
        }
    }

    public void addFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        if (v2TIMFriendshipListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    if (!V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.contains(v2TIMFriendshipListener)) {
                        V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.add(v2TIMFriendshipListener);
                    }
                }
            });
        }
    }

    public void addFriendsToFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().addFriendsToFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    public void addToBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().addToBlackList(list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    public void checkFriend(List<String> list, int i11, final V2TIMValueCallback<List<V2TIMFriendCheckResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList maybe empty");
            }
        } else if (i11 == 1 || i11 == 2) {
            RelationshipManager.getInstance().checkFriend(list, i11, new IMCallback<List<FriendCheckResult>>(new V2TIMValueCallback<List<FriendCheckResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendCheckResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendCheckResult friendCheckResult : list) {
                            V2TIMFriendCheckResult v2TIMFriendCheckResult = new V2TIMFriendCheckResult();
                            v2TIMFriendCheckResult.setFriendCheckResult(friendCheckResult);
                            arrayList.add(v2TIMFriendCheckResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendCheckResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "checkType is invalid : " + i11);
        }
    }

    public void createFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (str != null) {
            RelationshipManager.getInstance().createFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupNames is empty");
        }
    }

    public void deleteFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendApplication == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application is null");
            }
        } else if (!TextUtils.isEmpty(v2TIMFriendApplication.getUserID())) {
            RelationshipManager.getInstance().deleteFriendApplication(v2TIMFriendApplication.getType(), v2TIMFriendApplication.getUserID(), new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application userID is empty");
        }
    }

    public void deleteFriendGroup(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFriendGroup(list, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupNames is empty");
        }
    }

    public void deleteFriendsFromFriendGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "groupName is empty");
            }
        } else if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFrendsFromFriendGroup(str, list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    public void deleteFromBlackList(List<String> list, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().deleteFromBlackList(list, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    public void deleteFromFriendList(List<String> list, int i11, final V2TIMValueCallback<List<V2TIMFriendOperationResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList maybe empty");
            }
        } else if (i11 == 1 || i11 == 2) {
            RelationshipManager.getInstance().deleteFromFriendList(list, i11, new IMCallback<List<FriendOperationResult>>(new V2TIMValueCallback<List<FriendOperationResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendOperationResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendOperationResult friendOperationResult : list) {
                            V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                            v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                            arrayList.add(v2TIMFriendOperationResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendOperationResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "deleteType is invalid : " + i11);
        }
    }

    public void getBlackList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        RelationshipManager.getInstance().getBlackList(new IMCallback<List<FriendInfo>>(new V2TIMValueCallback<List<FriendInfo>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<FriendInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (FriendInfo friendInfo : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setFriendInfo(friendInfo);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<FriendInfo> list) {
                super.success(list);
            }
        });
    }

    public void getFriendApplicationList(final V2TIMValueCallback<V2TIMFriendApplicationResult> v2TIMValueCallback) {
        RelationshipManager.getInstance().getFriendApplicationList(new IMCallback<FriendApplicationResult>(new V2TIMValueCallback<FriendApplicationResult>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(FriendApplicationResult friendApplicationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMFriendApplicationResult v2TIMFriendApplicationResult = new V2TIMFriendApplicationResult();
                    v2TIMFriendApplicationResult.setFriendApplicationResult(friendApplicationResult);
                    v2TIMValueCallback.onSuccess(v2TIMFriendApplicationResult);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(FriendApplicationResult friendApplicationResult) {
                super.success(friendApplicationResult);
            }
        });
    }

    public void getFriendGroups(List<String> list, final V2TIMValueCallback<List<V2TIMFriendGroup>> v2TIMValueCallback) {
        if (list != null && list.size() == 0) {
            list = null;
        }
        if (v2TIMValueCallback != null) {
            RelationshipManager.getInstance().getFriendGroups(list, new IMCallback<List<FriendGroup>>(new V2TIMValueCallback<List<FriendGroup>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendGroup> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendGroup friendGroup : list) {
                            V2TIMFriendGroup v2TIMFriendGroup = new V2TIMFriendGroup();
                            v2TIMFriendGroup.setFriendGroup(friendGroup);
                            arrayList.add(v2TIMFriendGroup);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendGroup> list) {
                    super.success(list);
                }
            });
        }
    }

    public void getFriendList(final V2TIMValueCallback<List<V2TIMFriendInfo>> v2TIMValueCallback) {
        RelationshipManager.getInstance().getFriendList(new IMCallback<List<FriendInfo>>(new V2TIMValueCallback<List<FriendInfo>>() {
            public void onError(int i11, String str) {
                V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i11, str);
                }
            }

            public void onSuccess(List<FriendInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (FriendInfo friendInfo : list) {
                        V2TIMFriendInfo v2TIMFriendInfo = new V2TIMFriendInfo();
                        v2TIMFriendInfo.setFriendInfo(friendInfo);
                        arrayList.add(v2TIMFriendInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        }) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(List<FriendInfo> list) {
                super.success(list);
            }
        });
        BaseManager.getInstance().checkTUIComponent(4);
    }

    public void getFriendsInfo(List<String> list, final V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            RelationshipManager.getInstance().getFriendsInfo(list, new IMCallback<List<FriendInfoResult>>(new V2TIMValueCallback<List<FriendInfoResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendInfoResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendInfoResult friendInfoResult : list) {
                            V2TIMFriendInfoResult v2TIMFriendInfoResult = new V2TIMFriendInfoResult();
                            v2TIMFriendInfoResult.setFriendInfoResult(friendInfoResult);
                            arrayList.add(v2TIMFriendInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendInfoResult> list) {
                    super.success(list);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "userIDList is empty");
        }
    }

    public void refuseFriendApplication(V2TIMFriendApplication v2TIMFriendApplication, final V2TIMValueCallback<V2TIMFriendOperationResult> v2TIMValueCallback) {
        if (v2TIMFriendApplication != null) {
            AnonymousClass21 r02 = new V2TIMValueCallback<FriendOperationResult>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(FriendOperationResult friendOperationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMFriendOperationResult v2TIMFriendOperationResult = new V2TIMFriendOperationResult();
                        v2TIMFriendOperationResult.setFriendOperationResult(friendOperationResult);
                        v2TIMValueCallback.onSuccess(v2TIMFriendOperationResult);
                    }
                }
            };
            FriendResponse friendResponse = new FriendResponse();
            friendResponse.setUserID(v2TIMFriendApplication.getUserID());
            friendResponse.setResponseType(3);
            RelationshipManager.getInstance().responseFriendApplication(friendResponse, new IMCallback<FriendOperationResult>(r02) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(FriendOperationResult friendOperationResult) {
                    super.success(friendOperationResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "application is null");
        }
    }

    public void removeFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        if (v2TIMFriendshipListener != null) {
            IMContext.getInstance().runOnMainThread(new Runnable() {
                public void run() {
                    V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.remove(v2TIMFriendshipListener);
                }
            });
        }
    }

    public void renameFriendGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "newName is empty");
            }
        } else if (!TextUtils.isEmpty(str)) {
            RelationshipManager.getInstance().renameFriendGroup(str, str2, new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "oldName is empty");
        }
    }

    public void searchFriends(V2TIMFriendSearchParam v2TIMFriendSearchParam, final V2TIMValueCallback<List<V2TIMFriendInfoResult>> v2TIMValueCallback) {
        if (v2TIMFriendSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "searchParam is null");
            }
        } else if (v2TIMFriendSearchParam.getKeywordList() != null && v2TIMFriendSearchParam.getKeywordList().size() != 0) {
            RelationshipManager.getInstance().searchFriends(v2TIMFriendSearchParam.getFriendSearchParam(), new IMCallback<List<FriendInfoResult>>(new V2TIMValueCallback<List<FriendInfoResult>>() {
                public void onError(int i11, String str) {
                    V2TIMValueCallback v2TIMValueCallback = v2TIMValueCallback;
                    if (v2TIMValueCallback != null) {
                        v2TIMValueCallback.onError(i11, str);
                    }
                }

                public void onSuccess(List<FriendInfoResult> list) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (FriendInfoResult friendInfoResult : list) {
                            V2TIMFriendInfoResult v2TIMFriendInfoResult = new V2TIMFriendInfoResult();
                            v2TIMFriendInfoResult.setFriendInfoResult(friendInfoResult);
                            arrayList.add(v2TIMFriendInfoResult);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(List<FriendInfoResult> list) {
                    super.success(list);
                }
            });
            BaseManager.getInstance().checkTUIComponent(6);
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "keywordList is empty");
        }
    }

    public void setFriendApplicationRead(V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().setFriendApplicationRead(new IMCallback(v2TIMCallback) {
            public void fail(int i11, String str) {
                super.fail(i11, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public void setFriendInfo(V2TIMFriendInfo v2TIMFriendInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMFriendInfo != null) {
            RelationshipManager.getInstance().setFriendInfo(v2TIMFriendInfo.getUserID(), v2TIMFriendInfo.getModifyFriendInfo(), new IMCallback(v2TIMCallback) {
                public void fail(int i11, String str) {
                    super.fail(i11, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(BaseConstants.ERR_INVALID_PARAMETERS, "info is null");
        }
    }

    public void setFriendListener(final V2TIMFriendshipListener v2TIMFriendshipListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() {
            public void run() {
                if (V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.remove(V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener);
                }
                if (v2TIMFriendshipListener != null) {
                    V2TIMFriendshipManagerImpl.this.mFriendshipListenerList.add(v2TIMFriendshipListener);
                }
                V2TIMFriendshipListener unused = V2TIMFriendshipManagerImpl.this.mV2TIMFriendshipListener = v2TIMFriendshipListener;
            }
        });
    }

    private V2TIMFriendshipManagerImpl() {
        this.TAG = "V2TIMFriendshipManagerImpl";
        this.mFriendshipListenerList = new ArrayList();
        initFriendshipListener();
    }
}

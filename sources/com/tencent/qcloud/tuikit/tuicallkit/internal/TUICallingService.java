package com.tencent.qcloud.tuikit.tuicallkit.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.a;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUIExtension;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIObjectFactory;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionEventListener;
import com.tencent.qcloud.tuicore.interfaces.TUIExtensionInfo;
import com.tencent.qcloud.tuicore.interfaces.TUIServiceCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.TUICallKit;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.recents.RecentCallsFragment;
import com.youth.banner.config.BannerConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import zy.b;

final class TUICallingService implements ITUINotification, ITUIService, ITUIExtension, ITUIObjectFactory {
    private static final int CALL_MEMBER_LIMIT = 9;
    private static final TUICallingService INSTANCE = new TUICallingService();
    private static final String TAG = "TUICallingService";
    /* access modifiers changed from: private */
    public Context appContext;

    public class ResultTUIExtensionEventListener extends TUIExtensionEventListener {
        public a activityResultCaller;
        public String groupID;
        public boolean isClassicUI = true;
        public TUICallDefine.MediaType mediaType;
        public String userID;

        public ResultTUIExtensionEventListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onClicked$0(ActivityResult activityResult) {
            Intent data = activityResult.getData();
            if (data != null) {
                TUICallKit.createInstance(TUICallingService.this.appContext).groupCall(this.groupID, data.getStringArrayListExtra(TUIConstants.TUIContact.StartActivity.GroupMemberSelect.DATA_LIST), this.mediaType);
            }
        }

        public void onClicked(Map<String, Object> map) {
            if (!TextUtils.isEmpty(this.groupID)) {
                String str = !this.isClassicUI ? TUIConstants.TUIContact.StartActivity.GroupMemberSelect.MINIMALIST_ACTIVITY_NAME : TUIConstants.TUIContact.StartActivity.GroupMemberSelect.CLASSIC_ACTIVITY_NAME;
                Bundle bundle = new Bundle();
                bundle.putString(TUIConstants.TUIContact.StartActivity.GroupMemberSelect.GROUP_ID, this.groupID);
                bundle.putBoolean(TUIConstants.TUIContact.StartActivity.GroupMemberSelect.SELECT_FOR_CALL, true);
                bundle.putInt(TUIConstants.TUIContact.StartActivity.GroupMemberSelect.MEMBER_LIMIT, 9);
                TUICore.startActivityForResult(this.activityResultCaller, str, bundle, (ActivityResultCallback<ActivityResult>) new a(this));
            } else if (!TextUtils.isEmpty(this.userID)) {
                TUICallKit.createInstance(TUICallingService.this.appContext).call(this.userID, this.mediaType);
            } else {
                Log.e("TUICallingService", "onClicked event ignored, groupId is empty or userId is empty, cannot start call");
            }
        }
    }

    private TUICallingService() {
    }

    private void adaptiveComponentReport() {
        ITUIService service = TUICore.getService("TUIChatService");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("framework", 1);
            if (service == null) {
                jSONObject.put("component", 14);
            } else {
                jSONObject.put("component", 15);
            }
            jSONObject.put("language", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("api", V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework);
            jSONObject2.put("params", jSONObject);
            TUICallEngine.createInstance(this.appContext).callExperimentalAPI(jSONObject2.toString());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    private List<TUIExtensionInfo> getClassicChatInputMoreExtension(Map<String, Object> map) {
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        tUIExtensionInfo.setWeight(BannerConfig.SCROLL_TIME);
        TUIExtensionInfo tUIExtensionInfo2 = new TUIExtensionInfo();
        tUIExtensionInfo2.setWeight(500);
        String str = (String) getOrDefault(map, TUIConstants.TUIChat.Extension.InputMore.USER_ID, (Object) null);
        String str2 = (String) getOrDefault(map, TUIConstants.TUIChat.Extension.InputMore.GROUP_ID, (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener.mediaType = TUICallDefine.MediaType.Audio;
        resultTUIExtensionEventListener.userID = str;
        resultTUIExtensionEventListener.groupID = str2;
        ResultTUIExtensionEventListener resultTUIExtensionEventListener2 = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener2.mediaType = TUICallDefine.MediaType.Video;
        resultTUIExtensionEventListener2.userID = str;
        resultTUIExtensionEventListener2.groupID = str2;
        tUIExtensionInfo.setText(this.appContext.getString(R.string.tuicalling_audio_call));
        tUIExtensionInfo.setIcon(Integer.valueOf(R.drawable.tuicalling_ic_audio_call));
        tUIExtensionInfo.setExtensionListener(resultTUIExtensionEventListener);
        resultTUIExtensionEventListener.activityResultCaller = (a) getOrDefault(map, "ChatContext", (Object) null);
        tUIExtensionInfo2.setText(this.appContext.getString(R.string.tuicalling_video_call));
        tUIExtensionInfo2.setIcon(Integer.valueOf(R.drawable.tuicalling_ic_video_call));
        tUIExtensionInfo2.setExtensionListener(resultTUIExtensionEventListener2);
        resultTUIExtensionEventListener2.activityResultCaller = (a) getOrDefault(map, "ChatContext", (Object) null);
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) getOrDefault(map, TUIConstants.TUIChat.Extension.InputMore.FILTER_VOICE_CALL, bool)).booleanValue();
        boolean booleanValue2 = ((Boolean) getOrDefault(map, TUIConstants.TUIChat.Extension.InputMore.FILTER_VIDEO_CALL, bool)).booleanValue();
        ArrayList arrayList = new ArrayList();
        if (!booleanValue) {
            arrayList.add(tUIExtensionInfo);
        }
        if (!booleanValue2) {
            arrayList.add(tUIExtensionInfo2);
        }
        return arrayList;
    }

    private List<TUIExtensionInfo> getClassicFriendProfileExtension(Map<String, Object> map) {
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        tUIExtensionInfo.setWeight(300);
        TUIExtensionInfo tUIExtensionInfo2 = new TUIExtensionInfo();
        tUIExtensionInfo2.setWeight(200);
        String str = (String) getOrDefault(map, TUIConstants.TUIContact.Extension.FriendProfileItem.USER_ID, (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener.mediaType = TUICallDefine.MediaType.Audio;
        resultTUIExtensionEventListener.userID = str;
        ResultTUIExtensionEventListener resultTUIExtensionEventListener2 = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener2.mediaType = TUICallDefine.MediaType.Video;
        resultTUIExtensionEventListener2.userID = str;
        tUIExtensionInfo.setText(this.appContext.getString(R.string.tuicalling_audio_call));
        tUIExtensionInfo.setExtensionListener(resultTUIExtensionEventListener);
        tUIExtensionInfo2.setText(this.appContext.getString(R.string.tuicalling_video_call));
        tUIExtensionInfo2.setExtensionListener(resultTUIExtensionEventListener2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIExtensionInfo2);
        arrayList.add(tUIExtensionInfo);
        return arrayList;
    }

    private List<TUIExtensionInfo> getMinimalistChatNavigationMoreExtension(Map<String, Object> map) {
        String str = (String) getOrDefault(map, TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.USER_ID, (Object) null);
        String str2 = (String) getOrDefault(map, TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.GROUP_ID, (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener.mediaType = TUICallDefine.MediaType.Audio;
        resultTUIExtensionEventListener.groupID = str2;
        resultTUIExtensionEventListener.userID = str;
        resultTUIExtensionEventListener.isClassicUI = false;
        resultTUIExtensionEventListener.activityResultCaller = (a) getOrDefault(map, "ChatContext", (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener2 = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener2.mediaType = TUICallDefine.MediaType.Video;
        resultTUIExtensionEventListener2.groupID = str2;
        resultTUIExtensionEventListener2.userID = str;
        resultTUIExtensionEventListener2.isClassicUI = false;
        resultTUIExtensionEventListener2.activityResultCaller = (a) getOrDefault(map, "ChatContext", (Object) null);
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        TUIExtensionInfo tUIExtensionInfo2 = new TUIExtensionInfo();
        tUIExtensionInfo.setIcon(Integer.valueOf(R.drawable.tuicallkit_chat_title_bar_minimalist_audio_call_icon));
        tUIExtensionInfo.setExtensionListener(resultTUIExtensionEventListener);
        tUIExtensionInfo2.setIcon(Integer.valueOf(R.drawable.tuicallkit_chat_title_bar_minimalist_video_call_icon));
        tUIExtensionInfo2.setExtensionListener(resultTUIExtensionEventListener2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIExtensionInfo);
        arrayList.add(tUIExtensionInfo2);
        return arrayList;
    }

    private List<TUIExtensionInfo> getMinimalistFriendProfileExtension(Map<String, Object> map) {
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        tUIExtensionInfo.setWeight(300);
        TUIExtensionInfo tUIExtensionInfo2 = new TUIExtensionInfo();
        tUIExtensionInfo2.setWeight(200);
        String str = (String) getOrDefault(map, TUIConstants.TUIContact.Extension.FriendProfileItem.USER_ID, (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener.mediaType = TUICallDefine.MediaType.Audio;
        resultTUIExtensionEventListener.userID = str;
        resultTUIExtensionEventListener.isClassicUI = false;
        ResultTUIExtensionEventListener resultTUIExtensionEventListener2 = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener2.mediaType = TUICallDefine.MediaType.Video;
        resultTUIExtensionEventListener2.userID = str;
        resultTUIExtensionEventListener2.isClassicUI = false;
        tUIExtensionInfo.setIcon(Integer.valueOf(R.drawable.tuicallkit_profile_minimalist_audio_icon));
        tUIExtensionInfo.setText(this.appContext.getString(R.string.tuicalling_audio_call));
        tUIExtensionInfo.setExtensionListener(resultTUIExtensionEventListener);
        tUIExtensionInfo2.setIcon(Integer.valueOf(R.drawable.tuicallkit_profile_minimalist_video_icon));
        tUIExtensionInfo2.setText(this.appContext.getString(R.string.tuicalling_video_call));
        tUIExtensionInfo2.setExtensionListener(resultTUIExtensionEventListener2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIExtensionInfo2);
        arrayList.add(tUIExtensionInfo);
        return arrayList;
    }

    private List<TUIExtensionInfo> getMinimalistGroupProfileExtension(Map<String, Object> map) {
        TUIExtensionInfo tUIExtensionInfo = new TUIExtensionInfo();
        tUIExtensionInfo.setWeight(200);
        TUIExtensionInfo tUIExtensionInfo2 = new TUIExtensionInfo();
        tUIExtensionInfo2.setWeight(100);
        String str = (String) getOrDefault(map, TUIConstants.TUIGroup.Extension.GroupProfileItem.GROUP_ID, (Object) null);
        ResultTUIExtensionEventListener resultTUIExtensionEventListener = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener.mediaType = TUICallDefine.MediaType.Audio;
        resultTUIExtensionEventListener.groupID = str;
        resultTUIExtensionEventListener.isClassicUI = false;
        ResultTUIExtensionEventListener resultTUIExtensionEventListener2 = new ResultTUIExtensionEventListener();
        resultTUIExtensionEventListener2.mediaType = TUICallDefine.MediaType.Video;
        resultTUIExtensionEventListener2.groupID = str;
        resultTUIExtensionEventListener2.isClassicUI = false;
        tUIExtensionInfo.setText(this.appContext.getString(R.string.tuicalling_audio_call));
        tUIExtensionInfo.setIcon(Integer.valueOf(R.drawable.tuicallkit_profile_minimalist_audio_icon));
        tUIExtensionInfo.setExtensionListener(resultTUIExtensionEventListener);
        resultTUIExtensionEventListener.activityResultCaller = (a) getOrDefault(map, TUIConstants.TUIGroup.Extension.GroupProfileItem.CONTEXT, (Object) null);
        resultTUIExtensionEventListener.isClassicUI = false;
        tUIExtensionInfo2.setText(this.appContext.getString(R.string.tuicalling_video_call));
        tUIExtensionInfo2.setIcon(Integer.valueOf(R.drawable.tuicallkit_profile_minimalist_video_icon));
        tUIExtensionInfo2.setExtensionListener(resultTUIExtensionEventListener2);
        resultTUIExtensionEventListener2.isClassicUI = false;
        resultTUIExtensionEventListener2.activityResultCaller = (a) getOrDefault(map, TUIConstants.TUIGroup.Extension.GroupProfileItem.CONTEXT, (Object) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIExtensionInfo2);
        arrayList.add(tUIExtensionInfo);
        return arrayList;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallkit.internal.TUICallingService.getOrDefault(java.util.Map, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public static TUICallingService sharedInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        this.appContext = context;
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, this);
        TUICore.registerExtension(TUIConstants.TUIChat.Extension.InputMore.CLASSIC_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIChat.Extension.InputMore.MINIMALIST_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIGroup.Extension.GroupProfileItem.MINIMALIST_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIGroup.Extension.GroupProfileItem.CLASSIC_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIContact.Extension.FriendProfileItem.CLASSIC_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIContact.Extension.FriendProfileItem.MINIMALIST_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.CLASSIC_EXTENSION_ID, this);
        TUICore.registerExtension(TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.MINIMALIST_EXTENSION_ID, this);
        TUICore.registerObjectFactory(TUIConstants.TUICalling.ObjectFactory.FACTORY_NAME, this);
    }

    public Object onCall(String str, Map<String, Object> map) {
        Log.i("TUICallingService", "onCall, method: " + str + " ,param: " + map);
        if (map != null && TextUtils.equals(TUIConstants.TUICalling.METHOD_NAME_ENABLE_FLOAT_WINDOW, str)) {
            boolean booleanValue = ((Boolean) map.get(TUIConstants.TUICalling.PARAM_NAME_ENABLE_FLOAT_WINDOW)).booleanValue();
            Log.i("TUICallingService", "onCall, enableFloatWindow: " + booleanValue);
            TUICallKit.createInstance(this.appContext).enableFloatWindow(booleanValue);
            return null;
        } else if (map == null || !TextUtils.equals(TUIConstants.TUICalling.METHOD_NAME_ENABLE_MULTI_DEVICE, str)) {
            if (map != null && TextUtils.equals(TUIConstants.TUICalling.METHOD_NAME_CALL, str)) {
                String str2 = (String) map.get("type");
                String str3 = (String) map.get("groupId");
                ArrayList arrayList = new ArrayList(Arrays.asList((String[]) map.get(TUIConstants.TUICalling.PARAM_NAME_USERIDS)));
                TUICallDefine.MediaType mediaType = TUICallDefine.MediaType.Unknown;
                if ("audio".equals(str2)) {
                    mediaType = TUICallDefine.MediaType.Audio;
                } else if ("video".equals(str2)) {
                    mediaType = TUICallDefine.MediaType.Video;
                }
                if (!TextUtils.isEmpty(str3)) {
                    TUICallKit.createInstance(this.appContext).groupCall(str3, arrayList, mediaType);
                } else if (arrayList.size() == 1) {
                    TUICallKit.createInstance(this.appContext).call((String) arrayList.get(0), mediaType);
                } else {
                    Log.e("TUICallingService", "onCall ignored, groupId is empty and userList is not 1, cannot start call or groupCall");
                }
            }
            return null;
        } else {
            boolean booleanValue2 = ((Boolean) map.get(TUIConstants.TUICalling.PARAM_NAME_ENABLE_MULTI_DEVICE)).booleanValue();
            Log.i("TUICallingService", "onCall, enableMultiDevice: " + booleanValue2);
            TUICallEngine.createInstance(this.appContext).enableMultiDeviceAbility(booleanValue2, new TUICommonDefine.Callback() {
                public void onError(int i11, String str) {
                }

                public void onSuccess() {
                }
            });
            return null;
        }
    }

    public /* synthetic */ Object onCall(String str, Map map, TUIServiceCallback tUIServiceCallback) {
        return b.b(this, str, map, tUIServiceCallback);
    }

    public Object onCreateObject(String str, Map<String, Object> map) {
        if (!TextUtils.equals(str, TUIConstants.TUICalling.ObjectFactory.RecentCalls.OBJECT_NAME)) {
            return null;
        }
        String str2 = TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_CLASSIC;
        if (map == null || !str2.equals(map.get(TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE))) {
            str2 = TUIConstants.TUICalling.ObjectFactory.RecentCalls.UI_STYLE_MINIMALIST;
        }
        return new RecentCallsFragment(str2);
    }

    public List<TUIExtensionInfo> onGetExtension(String str, Map<String, Object> map) {
        Log.i("TUICallingService", "onGetExtension, extensionID: " + str + " ,param: " + map);
        if (TextUtils.equals(str, TUIConstants.TUIChat.Extension.InputMore.CLASSIC_EXTENSION_ID)) {
            return getClassicChatInputMoreExtension(map);
        }
        if (TextUtils.equals(str, TUIConstants.TUIGroup.Extension.GroupProfileItem.MINIMALIST_EXTENSION_ID)) {
            return getMinimalistGroupProfileExtension(map);
        }
        if (TextUtils.equals(str, TUIConstants.TUIContact.Extension.FriendProfileItem.CLASSIC_EXTENSION_ID)) {
            return getClassicFriendProfileExtension(map);
        }
        if (TextUtils.equals(str, TUIConstants.TUIContact.Extension.FriendProfileItem.MINIMALIST_EXTENSION_ID)) {
            return getMinimalistFriendProfileExtension(map);
        }
        if (TextUtils.equals(str, TUIConstants.TUIChat.Extension.ChatNavigationMoreItem.MINIMALIST_EXTENSION_ID)) {
            return getMinimalistChatNavigationMoreExtension(map);
        }
        return null;
    }

    public /* synthetic */ Map onGetExtensionInfo(String str, Map map) {
        return zy.a.b(this, str, map);
    }

    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED.equals(str) && TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT.equals(str2)) {
            TUICallKit.createInstance(this.appContext);
            adaptiveComponentReport();
        }
    }

    public /* synthetic */ void onRaiseExtension(String str, View view, Map map) {
        zy.a.c(this, str, view, map);
    }
}

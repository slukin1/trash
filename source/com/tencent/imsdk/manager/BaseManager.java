package com.tencent.imsdk.manager;

import android.content.Context;
import android.util.Log;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.NetworkInfoCenter;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserStatus;
import com.tencent.imsdk.signaling.SignalingManager;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseManager implements NetworkInfoCenter.INetworkChangeListener {
    private static final String TAG = "BaseManager";
    public static final long TUI_COMPONENT_CHAT = 3;
    private static final int TUI_COMPONENT_CHECK_COUNT_LIMIT = 5;
    public static final long TUI_COMPONENT_COMMUNITY = 8;
    public static final long TUI_COMPONENT_CONTACT = 4;
    public static final long TUI_COMPONENT_CONVERSATION = 2;
    public static final long TUI_COMPONENT_CORE = 1;
    public static final long TUI_COMPONENT_GROUP = 5;
    public static final long TUI_COMPONENT_OFFLINEPUSH = 7;
    public static final long TUI_COMPONENT_SEARCH = 6;
    private static final int TUI_COMPONENT_STACK_LAYER_LIMIT = 10;
    public static final long TUI_COMPONENT_UNKNOWN = 0;
    public static final long TUI_PLUGIN_GROUP_NOTE = 9;
    public static final long TUI_PLUGIN_POLL = 10;
    public static final long TUI_STYLE_TYPE_CLASSIC = 0;
    public static final long TUI_STYLE_TYPE_MINIMALIST = 1;
    private static final int UI_PLATFORM_FLUTTER = 1;
    private static final int UI_PLATFORM_FLUTTER_UIKIT = 2;
    private static final int UI_PLATFORM_TUIKIT = 15;
    private static final int UI_PLATFORM_TUIKIT_MINIMALIST = 26;
    private static final int UI_PLATFORM_UNITY = 5;
    private static final int UI_PLATFORM_UNITY_UIKIT = 6;
    private static final int UI_PLATFORM_UNKNOWN = 0;
    private static boolean mLoadLibrarySuccess = false;
    private boolean forceUseQuicChannel = false;
    private boolean isIPv6Prior = false;
    private boolean isInit = false;
    private boolean isTestEnvironment = false;
    private SDKConfig.DatabaseEncryptInfo mDatabaseEncryptInfo = new SDKConfig.DatabaseEncryptInfo();
    private boolean mInvokeFromTUICore = false;
    private boolean mInvokeFromTUIKit = false;
    private SDKConfig.NetworkInfo mLastNetworkInfo = new SDKConfig.NetworkInfo();
    private int mNumberUIPlatform = 0;
    private SDKConfig.PacketRetryInfo mPacketRetryInfo = new SDKConfig.PacketRetryInfo();
    private SDKConfig.ProxyInfo mProxyInfo = new SDKConfig.ProxyInfo();
    private String mStringUIPlatform = "";
    private HashMap<Long, Integer> mTUIComponentCheckCountMap = new HashMap<>();
    private Map<Long, Long> mTUIComponentMap = new HashMap();
    private WeakReference<SDKListener> sdkListenerWeakReference;
    private UserPreference userPreference = new UserPreference();

    public static class BaseManagerHolder {
        /* access modifiers changed from: private */
        public static final BaseManager baseManager = new BaseManager();

        private BaseManagerHolder() {
        }
    }

    static {
        try {
            mLoadLibrarySuccess = SystemUtil.loadIMLibrary();
        } catch (Exception e11) {
            Log.e(TAG, e11.toString());
        }
    }

    public static BaseManager getInstance() {
        return BaseManagerHolder.baseManager;
    }

    private long getTUIChatStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuichat.minimalistui.MinimalistUIService");
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private long getTUIContactStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicontact.minimalistui.widget.FriendProfileLayout");
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private long getTUIConversationStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuiconversation.minimalistui.widget.ConversationListLayout");
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private long getTUIGroupStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuigroup.minimalistui.widget.GroupInfoLayout");
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private long getTUISearchStyle() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuisearch.minimalistui.page.SearchMainMinimalistActivity");
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private int getUIPlatform() {
        int i11 = this.mNumberUIPlatform;
        if (i11 != 0) {
            return i11;
        }
        this.mInvokeFromTUIKit = isTUIKit();
        boolean isFlutter = isFlutter();
        boolean isUnity = isUnity();
        if (isFlutter) {
            return this.mInvokeFromTUIKit ? 2 : 1;
        }
        if (isUnity) {
            return this.mInvokeFromTUIKit ? 6 : 5;
        }
        if (this.mInvokeFromTUIKit) {
            return hasTUIKitMinimalist() ? 26 : 15;
        }
        return 0;
    }

    private boolean hasTUIChat() {
        try {
            int i11 = ChatProvider.ERR_REVOKE_TIME_LIMIT_EXCEED;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUICommunity() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicommunity.model.CommunityProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIContact() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIConversation() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIGroup() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuigroup.model.GroupInfoProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIGroupNote() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuigroupnote.TUIGroupNoteService");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIKitMinimalist() {
        return getTUIConversationStyle() == 1 || getTUIChatStyle() == 1 || getTUIContactStyle() == 1 || getTUIGroupStyle() == 1 || getTUISearchStyle() == 1;
    }

    private boolean hasTUIOfflinePush() {
        try {
            Class.forName("com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIPoll() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuipoll.TUIPollService");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUISearch() {
        try {
            Class.forName("com.tencent.qcloud.tuikit.tuisearch.model.SearchDataProvider");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isFlutter() {
        try {
            Class.forName("com.qq.qcloud.tencent_im_sdk_plugin.tencent_im_sdk_plugin");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isTUICore() {
        try {
            int i11 = TUICore.f48154a;
            return true;
        } catch (ClassNotFoundException unused) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i12 = 0;
            while (i12 < stackTrace.length && i12 <= 15) {
                if (stackTrace[i12].getClassName().toLowerCase().contains("tuicore")) {
                    return true;
                }
                i12++;
            }
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r3 < r1.length) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        r4 = r1[r3].getClassName().toLowerCase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r4.contains("tuikitimpl") != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r1 = com.tencent.qcloud.tuicore.TUICore.f48154a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0009, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000a, code lost:
        r1 = new java.lang.Throwable().getStackTrace();
        r3 = 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isTUIKit() {
        /*
            r6 = this;
            r0 = 1
            java.lang.String r1 = "com.tencent.qcloud.tim.uikit.TUIKit"
            java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x0007 }
            return r0
        L_0x0007:
            int r1 = com.tencent.qcloud.tuicore.TUICore.f48154a     // Catch:{ ClassNotFoundException -> 0x000a }
            return r0
        L_0x000a:
            java.lang.Throwable r1 = new java.lang.Throwable
            r1.<init>()
            java.lang.StackTraceElement[] r1 = r1.getStackTrace()
            r2 = 0
            r3 = r2
        L_0x0015:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x003c
            r4 = 15
            if (r3 <= r4) goto L_0x001d
            return r2
        L_0x001d:
            r4 = r1[r3]
            java.lang.String r4 = r4.getClassName()
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r5 = "tuikitimpl"
            boolean r5 = r4.contains(r5)
            if (r5 != 0) goto L_0x003b
            java.lang.String r5 = "tuicore"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x003b:
            return r0
        L_0x003c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.manager.BaseManager.isTUIKit():boolean");
    }

    private boolean isUnity() {
        try {
            Class.forName("com.qcloud.tencentimsdk.TencentImSDKPluginUnity");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void reportTUIComponentUsage() {
        this.mInvokeFromTUICore = isTUICore();
        this.mTUIComponentCheckCountMap.put(2L, 0);
        this.mTUIComponentCheckCountMap.put(3L, 0);
        this.mTUIComponentCheckCountMap.put(4L, 0);
        this.mTUIComponentCheckCountMap.put(5L, 0);
        this.mTUIComponentCheckCountMap.put(6L, 0);
        this.mTUIComponentCheckCountMap.put(7L, 0);
        this.mTUIComponentCheckCountMap.put(8L, 0);
        this.mTUIComponentCheckCountMap.put(9L, 0);
        this.mTUIComponentCheckCountMap.put(10L, 0);
        if (this.mInvokeFromTUIKit) {
            if (this.mInvokeFromTUICore) {
                this.mTUIComponentMap.put(1L, 0L);
                if (hasTUIConversation() && !this.mTUIComponentMap.containsKey(2L)) {
                    this.mTUIComponentMap.put(2L, Long.valueOf(getTUIConversationStyle()));
                }
                if (hasTUIChat() && !this.mTUIComponentMap.containsKey(3L)) {
                    this.mTUIComponentMap.put(3L, Long.valueOf(getTUIChatStyle()));
                }
                if (hasTUIContact() && !this.mTUIComponentMap.containsKey(4L)) {
                    this.mTUIComponentMap.put(4L, Long.valueOf(getTUIContactStyle()));
                }
                if (hasTUIGroup() && !this.mTUIComponentMap.containsKey(5L)) {
                    this.mTUIComponentMap.put(5L, Long.valueOf(getTUIGroupStyle()));
                }
                if (hasTUISearch() && !this.mTUIComponentMap.containsKey(6L)) {
                    this.mTUIComponentMap.put(6L, Long.valueOf(getTUISearchStyle()));
                }
                if (hasTUIOfflinePush() && !this.mTUIComponentMap.containsKey(7L)) {
                    this.mTUIComponentMap.put(7L, 0L);
                }
                if (hasTUICommunity() && !this.mTUIComponentMap.containsKey(8L)) {
                    this.mTUIComponentMap.put(8L, 0L);
                }
                if (hasTUIGroupNote() && !this.mTUIComponentMap.containsKey(9L)) {
                    this.mTUIComponentMap.put(9L, 0L);
                }
                if (hasTUIPoll() && !this.mTUIComponentMap.containsKey(10L)) {
                    this.mTUIComponentMap.put(10L, 0L);
                }
            } else {
                this.mTUIComponentMap.put(0L, 0L);
            }
            nativeReportTUIComponentUsage(this.mTUIComponentMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkTUIComponent(long r12) {
        /*
            r11 = this;
            boolean r0 = r11.isInit
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r11.mInvokeFromTUICore
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            java.util.Map<java.lang.Long, java.lang.Long> r0 = r11.mTUIComponentMap
            java.lang.Long r1 = java.lang.Long.valueOf(r12)
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0017
            return
        L_0x0017:
            java.util.HashMap<java.lang.Long, java.lang.Integer> r0 = r11.mTUIComponentCheckCountMap
            java.lang.Long r1 = java.lang.Long.valueOf(r12)
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0024
            return
        L_0x0024:
            r0 = 2
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0030
            java.lang.String r0 = "conversationprovider"
        L_0x002e:
            r3 = r2
            goto L_0x0079
        L_0x0030:
            r3 = 3
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "chatprovider"
            goto L_0x002e
        L_0x0039:
            r3 = 5
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = "groupInfoprovider"
            goto L_0x002e
        L_0x0042:
            r3 = 4
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = "contactprovider"
            goto L_0x002e
        L_0x004b:
            r3 = 6
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0054
            java.lang.String r0 = "searchdataprovider"
            goto L_0x002e
        L_0x0054:
            r3 = 7
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x005e
            java.lang.String r0 = "tuiofflinepushmanager"
        L_0x005c:
            r3 = r1
            goto L_0x0079
        L_0x005e:
            r3 = 8
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "communityprovider"
            goto L_0x005c
        L_0x0067:
            r3 = 9
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0070
            java.lang.String r0 = "tuigroupnoteservice"
            goto L_0x002e
        L_0x0070:
            r3 = 10
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x010e
            java.lang.String r0 = "tuipollservice"
            goto L_0x002e
        L_0x0079:
            java.util.HashMap<java.lang.Long, java.lang.Integer> r4 = r11.mTUIComponentCheckCountMap
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.lang.Object r4 = r4.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r5 = 5
            if (r4 >= r5) goto L_0x010d
            int r4 = r4 + r2
            java.util.HashMap<java.lang.Long, java.lang.Integer> r5 = r11.mTUIComponentCheckCountMap
            java.lang.Long r6 = java.lang.Long.valueOf(r12)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5.put(r6, r4)
            java.lang.Throwable r4 = new java.lang.Throwable
            r4.<init>()
            java.lang.StackTraceElement[] r4 = r4.getStackTrace()
            r5 = 0
            r7 = r5
            r5 = r1
            r6 = r5
        L_0x00a8:
            int r9 = r4.length
            if (r1 >= r9) goto L_0x010d
            r9 = r4[r1]
            java.lang.String r9 = r9.getClassName()
            java.lang.String r9 = r9.toLowerCase()
            if (r5 != 0) goto L_0x00be
            boolean r10 = r9.contains(r0)
            if (r10 == 0) goto L_0x00be
            r5 = r2
        L_0x00be:
            if (r3 == 0) goto L_0x00d8
            if (r6 != 0) goto L_0x00d8
            java.lang.String r10 = "classic"
            boolean r10 = r9.contains(r10)
            if (r10 == 0) goto L_0x00cc
        L_0x00ca:
            r6 = r2
            goto L_0x00d8
        L_0x00cc:
            java.lang.String r10 = "minimalist"
            boolean r9 = r9.contains(r10)
            if (r9 == 0) goto L_0x00d8
            r6 = 1
            r7 = r6
            goto L_0x00ca
        L_0x00d8:
            if (r5 == 0) goto L_0x00f1
            if (r3 == 0) goto L_0x00de
            if (r6 == 0) goto L_0x00f1
        L_0x00de:
            java.util.Map<java.lang.Long, java.lang.Long> r0 = r11.mTUIComponentMap
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            r0.put(r12, r13)
            java.util.Map<java.lang.Long, java.lang.Long> r12 = r11.mTUIComponentMap
            r11.nativeReportTUIComponentUsage(r12)
            goto L_0x010d
        L_0x00f1:
            r9 = 10
            if (r1 < r9) goto L_0x010a
            if (r5 == 0) goto L_0x010d
            java.util.Map<java.lang.Long, java.lang.Long> r0 = r11.mTUIComponentMap
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            r0.put(r12, r13)
            java.util.Map<java.lang.Long, java.lang.Long> r12 = r11.mTUIComponentMap
            r11.nativeReportTUIComponentUsage(r12)
            goto L_0x010d
        L_0x010a:
            int r1 = r1 + 1
            goto L_0x00a8
        L_0x010d:
            return
        L_0x010e:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "unknown tui component type:"
            r1.append(r2)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            com.tencent.imsdk.common.IMLog.e(r0, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.manager.BaseManager.checkTUIComponent(long):void");
    }

    public void enableSignaling(boolean z11) {
        this.userPreference.setEnableSignaling(Boolean.valueOf(z11));
        nativeSetUserPreference(this.userPreference);
    }

    public void getAIDenoiseSignature(IMCallback iMCallback) {
        if (this.isInit) {
            nativeGetAIDenoiseSignature(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public long getClockTickInHz() {
        if (this.isInit) {
            return nativeGetClockTickInHz();
        }
        Log.e(TAG, "sdk not init");
        return 0;
    }

    public int getLoginStatus() {
        if (this.isInit) {
            return nativeGetLoginStatus();
        }
        Log.e(TAG, "sdk not init");
        return 3;
    }

    public String getLoginUser() {
        if (this.isInit) {
            return nativeGetLoginUser();
        }
        Log.e(TAG, "sdk not init");
        return null;
    }

    public long getServerTime() {
        if (this.isInit) {
            return nativeGetServerTime();
        }
        Log.e(TAG, "sdk not init");
        return 0;
    }

    public long getTimeTick() {
        if (this.isInit) {
            return nativeGetTimeTick();
        }
        Log.e(TAG, "sdk not init");
        return 0;
    }

    public String getVersion() {
        if (this.isInit) {
            return nativeGetSDKVersion();
        }
        Log.e(TAG, "sdk not init");
        return null;
    }

    public void initLocalStorage(String str, IMCallback iMCallback) {
        if (this.isInit) {
            nativeInitLocalStorage(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public boolean initSDK(Context context, SDKConfig sDKConfig, boolean z11, SDKListener sDKListener) {
        if (!mLoadLibrarySuccess) {
            IMLog.e(TAG, "libimsdk.so is not loaded");
            return false;
        } else if (sDKConfig.sdkAppId <= 0) {
            String str = TAG;
            IMLog.e(str, "invalid sdkAppID:" + sDKConfig.sdkAppId);
            return false;
        } else if (context == null) {
            IMLog.e(TAG, "null context");
            return false;
        } else if (this.isInit) {
            IMLog.w(TAG, "Has initSDK");
            return true;
        } else {
            IMContext.getInstance().init(context.getApplicationContext());
            NetworkInfoCenter.getInstance().init(context.getApplicationContext(), this);
            MessageCenter.getInstance().init();
            GroupManager.getInstance().init();
            ConversationManager.getInstance().init();
            RelationshipManager.getInstance().init();
            SignalingManager.getInstance().init();
            sDKConfig.sdkInitPath = SystemUtil.getSDKInitPath();
            sDKConfig.sdkInstanceType = (long) SystemUtil.getInstanceType();
            sDKConfig.isTestEnvironment = this.isTestEnvironment;
            sDKConfig.forceUseQuicChannel = this.forceUseQuicChannel;
            sDKConfig.isIPv6Prior = this.isIPv6Prior;
            sDKConfig.deviceInfo.deviceType = SystemUtil.getDeviceType();
            sDKConfig.deviceInfo.deviceId = SystemUtil.getDeviceID();
            sDKConfig.deviceInfo.deviceBrand = (long) SystemUtil.getInstanceType();
            sDKConfig.deviceInfo.systemVersion = SystemUtil.getSystemVersion();
            sDKConfig.networkInfo.networkType = NetworkInfoCenter.getInstance().getNetworkType();
            sDKConfig.networkInfo.ipType = NetworkInfoCenter.getInstance().getIPType();
            sDKConfig.networkInfo.networkId = NetworkInfoCenter.getInstance().getNetworkID();
            sDKConfig.networkInfo.wifiNetworkHandle = NetworkInfoCenter.getInstance().getWifiNetworkHandle();
            sDKConfig.networkInfo.xgNetworkHandle = NetworkInfoCenter.getInstance().getXgNetworkHandle();
            sDKConfig.networkInfo.initializeCostTime = NetworkInfoCenter.getInstance().getInitializeCostTime();
            sDKConfig.networkInfo.networkConnected = NetworkInfoCenter.getInstance().isNetworkConnected();
            sDKConfig.proxyInfo = this.mProxyInfo;
            sDKConfig.databaseEncryptInfo = this.mDatabaseEncryptInfo;
            sDKConfig.packetRetryInfo = this.mPacketRetryInfo;
            SDKConfig.LogSetting logSetting = sDKConfig.logSetting;
            logSetting.enableConsoleLog = true;
            logSetting.logFilePath = SystemUtil.getSDKLogPath();
            sDKConfig.stringUIPlatform = this.mStringUIPlatform;
            sDKConfig.numberUIPlatform = getUIPlatform();
            this.mLastNetworkInfo = sDKConfig.networkInfo;
            nativeInitSDK(sDKConfig, z11, sDKListener);
            this.sdkListenerWeakReference = new WeakReference<>(sDKListener);
            reportTUIComponentUsage();
            this.isInit = true;
            return true;
        }
    }

    public void isCommercialAbilityEnabled(long j11, IMCallback<Object> iMCallback) {
        nativeIsCommercialAbilityEnabled(j11, iMCallback);
    }

    public boolean isInited() {
        return this.isInit;
    }

    public void login(String str, String str2, IMCallback iMCallback) {
        if (this.isInit) {
            nativeLogin(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void logout(IMCallback iMCallback) {
        if (this.isInit) {
            nativeLogout(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public native void nativeGetAIDenoiseSignature(IMCallback iMCallback);

    public native long nativeGetClockTickInHz();

    public native int nativeGetLoginStatus();

    public native String nativeGetLoginUser();

    public native String nativeGetSDKVersion();

    public native long nativeGetServerTime();

    public native long nativeGetTimeTick();

    public native void nativeInitLocalStorage(String str, IMCallback iMCallback);

    public native void nativeInitSDK(SDKConfig sDKConfig, boolean z11, SDKListener sDKListener);

    public native void nativeIsCommercialAbilityEnabled(long j11, IMCallback iMCallback);

    public native void nativeLogin(String str, String str2, IMCallback iMCallback);

    public native void nativeLogout(IMCallback iMCallback);

    public native void nativeNotifyNetworkChange(boolean z11, int i11, int i12, String str, long j11, long j12, long j13);

    public native void nativeReportTUIComponentUsage(Map<Long, Long> map);

    public native void nativeSendTRTCCustomData(byte[] bArr, IMCallback iMCallback);

    public native void nativeSetCustomServerInfo(CustomServerInfo customServerInfo);

    public native void nativeSetUserPreference(UserPreference userPreference2);

    public native void nativeUninitSDK();

    public void notifySelfInfoUpdated(UserInfo userInfo) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = (SDKListener) weakReference.get()) != null) {
            sDKListener.onSelfInfoUpdated(userInfo);
        }
    }

    public void notifyUserStatusChanged(List<UserStatus> list) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference != null && (sDKListener = (SDKListener) weakReference.get()) != null) {
            sDKListener.onUserStatusChanged(list);
        }
    }

    public void onNetworkChange(boolean z11, int i11, int i12, String str, long j11, long j12, long j13) {
        SDKConfig.NetworkInfo networkInfo = this.mLastNetworkInfo;
        if (z11 == networkInfo.networkConnected && i11 == networkInfo.networkType && i12 == networkInfo.ipType && str != null && str.equals(networkInfo.networkId)) {
            Log.w(TAG, "onNetworkChange, networkinfo is same");
            return;
        }
        SDKConfig.NetworkInfo networkInfo2 = this.mLastNetworkInfo;
        networkInfo2.networkConnected = z11;
        networkInfo2.networkType = i11;
        networkInfo2.ipType = i12;
        networkInfo2.networkId = str;
        networkInfo2.initializeCostTime = j13;
        nativeNotifyNetworkChange(z11, i11, i12, str, j11, j12, j13);
    }

    public void sendTRTCCustomData(byte[] bArr, IMCallback iMCallback) {
        if (this.isInit) {
            nativeSendTRTCCustomData(bArr, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setCustomServerInfo(CustomServerInfo customServerInfo) {
        nativeSetCustomServerInfo(customServerInfo);
    }

    public void setCustomUIPlatform(String str, int i11) {
        this.mStringUIPlatform = str;
        this.mNumberUIPlatform = i11;
    }

    public void setDatabaseEncryptInfo(SDKConfig.DatabaseEncryptInfo databaseEncryptInfo) {
        this.mDatabaseEncryptInfo = databaseEncryptInfo;
    }

    public void setForceUseQuicChannel(boolean z11) {
        this.forceUseQuicChannel = z11;
    }

    public void setIPv6Prior(boolean z11) {
        this.isIPv6Prior = z11;
    }

    public boolean setLibraryPath(String str) {
        boolean loadIMLibrary = SystemUtil.loadIMLibrary(str);
        mLoadLibrarySuccess = loadIMLibrary;
        return loadIMLibrary;
    }

    public void setPacketRetryInfo(SDKConfig.PacketRetryInfo packetRetryInfo) {
        this.mPacketRetryInfo = packetRetryInfo;
    }

    public void setProxyInfo(SDKConfig.ProxyInfo proxyInfo) {
        this.mProxyInfo = proxyInfo;
    }

    public void setTestEnvironment(boolean z11) {
        this.isTestEnvironment = z11;
    }

    public void unInitSDK() {
        nativeUninitSDK();
        this.mStringUIPlatform = "";
        this.mNumberUIPlatform = 0;
        this.isInit = false;
        this.isTestEnvironment = false;
        this.forceUseQuicChannel = false;
        this.isIPv6Prior = false;
        this.mLastNetworkInfo.clean();
        this.mProxyInfo.clean();
        this.mDatabaseEncryptInfo.clean();
        this.mPacketRetryInfo.clean();
        this.mInvokeFromTUIKit = false;
        this.mInvokeFromTUICore = false;
        this.mTUIComponentMap.clear();
        this.mTUIComponentCheckCountMap.clear();
    }
}

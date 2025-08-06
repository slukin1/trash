package com.tencent.qcloud.tuikit.tuicallkit;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.permission.PermissionCallback;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallEngine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.utils.PermissionUtils;
import com.tencent.qcloud.tuikit.tuicallkit.base.CallingUserModel;
import com.tencent.qcloud.tuikit.tuicallkit.base.Constants;
import com.tencent.qcloud.tuikit.tuicallkit.base.TUICallingStatusManager;
import com.tencent.qcloud.tuikit.tuicallkit.config.OfflinePushInfoConfig;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.CallingBellFeature;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.CallingKeepAliveFeature;
import com.tencent.qcloud.tuikit.tuicallkit.extensions.CallingScreenSensorFeature;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DeviceUtils;
import com.tencent.qcloud.tuikit.tuicallkit.utils.PermissionRequest;
import com.tencent.qcloud.tuikit.tuicallkit.utils.UserInfoUtils;
import com.tencent.qcloud.tuikit.tuicallkit.view.TUICallingViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class TUICallKitImpl extends TUICallKit implements ITUINotification {
    private static final String TAG = "TUICallKit";
    private static TUICallKitImpl sInstance;
    /* access modifiers changed from: private */
    public final CallingBellFeature mCallingBellFeature;
    /* access modifiers changed from: private */
    public final CallingKeepAliveFeature mCallingKeepAliveFeature;
    /* access modifiers changed from: private */
    public final CallingScreenSensorFeature mCallingScreenSensorFeature;
    /* access modifiers changed from: private */
    public final TUICallingViewManager mCallingViewManager;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public List<CallingUserModel> mInviteeList = new ArrayList();
    /* access modifiers changed from: private */
    public CallingUserModel mInviter = new CallingUserModel();
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private long mOtherUserLowQualityTime;
    private long mSelfLowQualityTime;
    private final TUICallObserver mTUICallObserver;
    /* access modifiers changed from: private */
    public TUICallObserver mTUICallObserverOut;
    /* access modifiers changed from: private */
    public int mTimeCount;
    /* access modifiers changed from: private */
    public Handler mTimeHandler;
    private HandlerThread mTimeHandlerThread;
    /* access modifiers changed from: private */
    public Runnable mTimeRunnable;
    private final UserInfoUtils mUserInfoUtils;

    /* renamed from: com.tencent.qcloud.tuikit.tuicallkit.TUICallKitImpl$12  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass12 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$qcloud$tuikit$TUICommonDefine$NetworkQuality;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tencent.qcloud.tuikit.TUICommonDefine$NetworkQuality[] r0 = com.tencent.qcloud.tuikit.TUICommonDefine.NetworkQuality.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tencent$qcloud$tuikit$TUICommonDefine$NetworkQuality = r0
                com.tencent.qcloud.tuikit.TUICommonDefine$NetworkQuality r1 = com.tencent.qcloud.tuikit.TUICommonDefine.NetworkQuality.Vbad     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$TUICommonDefine$NetworkQuality     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.qcloud.tuikit.TUICommonDefine$NetworkQuality r1 = com.tencent.qcloud.tuikit.TUICommonDefine.NetworkQuality.Down     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallkit.TUICallKitImpl.AnonymousClass12.<clinit>():void");
        }
    }

    private TUICallKitImpl(Context context) {
        AnonymousClass4 r02 = new TUICallObserver() {
            public void onCallBegin(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role) {
                super.onCallBegin(roomId, mediaType, role);
                TUICallKitImpl.this.mCallingBellFeature.stopMusic();
                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).updateCallStatus(TUICallDefine.Status.Accept);
                TUICallKitImpl.this.showTimeCount();
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onCallBegin(roomId, mediaType, role);
                }
            }

            public void onCallCancelled(String str) {
                super.onCallCancelled(str);
                TUICallKitImpl.this.resetCall();
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onCallCancelled(str);
                }
            }

            public void onCallEnd(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role, long j11) {
                super.onCallEnd(roomId, mediaType, role, j11);
                TUICallKitImpl.this.resetCall();
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onCallEnd(roomId, mediaType, role, j11);
                }
            }

            public void onCallMediaTypeChanged(TUICallDefine.MediaType mediaType, TUICallDefine.MediaType mediaType2) {
                super.onCallMediaTypeChanged(mediaType, mediaType2);
                if (!mediaType.equals(mediaType2)) {
                    TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setMediaType(mediaType2);
                }
            }

            public void onCallReceived(String str, List<String> list, String str2, TUICallDefine.MediaType mediaType, String str3) {
                super.onCallReceived(str, list, str2, mediaType, str3);
                if (TUICallDefine.MediaType.Unknown.equals(mediaType) || list == null || list.isEmpty()) {
                    return;
                }
                if (list.size() >= 9) {
                    ToastUtil.toastLongMessage(TUICallKitImpl.this.mContext.getString(R.string.tuicalling_user_exceed_limit));
                } else if (DeviceUtils.isAppRunningForeground(TUICallKitImpl.this.mContext) || PermissionUtils.hasPermission(TUICallKitImpl.this.mContext)) {
                    TUICallKitImpl.this.mInviter.userId = str;
                    final List<String> list2 = list;
                    final String str4 = str2;
                    final TUICallDefine.MediaType mediaType2 = mediaType;
                    final String str5 = str;
                    final String str6 = str3;
                    PermissionRequest.requestPermissions(TUICallKitImpl.this.mContext, mediaType, new PermissionCallback() {
                        public void onDenied() {
                            TUICallEngine.createInstance(TUICallKitImpl.this.mContext).reject((TUICommonDefine.Callback) null);
                            TUICallKitImpl.this.resetCall();
                        }

                        public void onGranted() {
                            TUICallDefine.Scene scene;
                            if (!TextUtils.isEmpty(TUICallKitImpl.this.mInviter.userId)) {
                                for (String str : list2) {
                                    if (!TextUtils.isEmpty(str)) {
                                        CallingUserModel callingUserModel = new CallingUserModel();
                                        callingUserModel.userId = str;
                                        TUICallKitImpl.this.mInviteeList.add(callingUserModel);
                                    }
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    scene = TUICallDefine.Scene.GROUP_CALL;
                                } else {
                                    scene = list2.size() > 1 ? TUICallDefine.Scene.MULTI_CALL : TUICallDefine.Scene.SINGLE_CALL;
                                }
                                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setMediaType(mediaType2);
                                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallRole(TUICallDefine.Role.Called);
                                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallScene(scene);
                                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setGroupId(str4);
                                TUICallKitImpl.this.showCallingView();
                                TUICallKitImpl.this.mCallingBellFeature.startRing();
                                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                                    TUICallKitImpl.this.mTUICallObserverOut.onCallReceived(str5, list2, str4, mediaType2, str6);
                                }
                            }
                        }
                    });
                } else {
                    TUILog.w("TUICallKit", "App is in background");
                    TUICallKitImpl.this.mCallingBellFeature.startRing();
                }
            }

            public void onError(int i11, String str) {
                super.onError(i11, str);
                ToastUtil.toastLongMessage(TUICallKitImpl.this.mContext.getString(R.string.tuicalling_toast_call_error_msg, new Object[]{Integer.valueOf(i11), str}));
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onError(i11, str);
                }
            }

            public void onKickedOffline() {
                super.onKickedOffline();
                TUICallEngine.createInstance(TUICallKitImpl.this.mContext).hangup((TUICommonDefine.Callback) null);
                TUICallKitImpl.this.resetCall();
            }

            public void onUserAudioAvailable(String str, boolean z11) {
                super.onUserAudioAvailable(str, z11);
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                if (access$1000 != null && access$1000.isAudioAvailable != z11) {
                    access$1000.isAudioAvailable = z11;
                    TUICallKitImpl.this.mCallingViewManager.updateUser(access$1000);
                }
            }

            public void onUserJoin(String str) {
                super.onUserJoin(str);
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                if (access$1000 == null) {
                    access$1000 = new CallingUserModel();
                    access$1000.userId = str;
                }
                TUICallKitImpl.this.mCallingViewManager.userEnter(access$1000);
            }

            public void onUserLeave(String str) {
                super.onUserLeave(str);
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                TUICallKitImpl.this.mCallingViewManager.userLeave(access$1000);
                TUICallKitImpl.this.showUserToast(access$1000, R.string.tuicalling_toast_user_end);
                TUICallKitImpl.this.mInviteeList.remove(access$1000);
            }

            public void onUserLineBusy(String str) {
                super.onUserLineBusy(str);
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onUserLineBusy(str);
                }
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                TUICallKitImpl.this.mCallingViewManager.userLeave(access$1000);
                TUICallKitImpl.this.showUserToast(access$1000, R.string.tuicalling_toast_user_busy);
                TUICallKitImpl.this.mInviteeList.remove(access$1000);
            }

            public void onUserNetworkQualityChanged(List<TUICommonDefine.NetworkQualityInfo> list) {
                super.onUserNetworkQualityChanged(list);
                TUICallKitImpl.this.updateNetworkQuality(list);
            }

            public void onUserNoResponse(String str) {
                super.onUserNoResponse(str);
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onUserNoResponse(str);
                }
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                TUICallKitImpl.this.mCallingViewManager.userLeave(access$1000);
                TUICallKitImpl.this.showUserToast(access$1000, R.string.tuicalling_toast_user_not_response);
                TUICallKitImpl.this.mInviteeList.remove(access$1000);
            }

            public void onUserReject(String str) {
                super.onUserReject(str);
                if (TUICallKitImpl.this.mTUICallObserverOut != null) {
                    TUICallKitImpl.this.mTUICallObserverOut.onUserReject(str);
                }
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                TUICallKitImpl.this.mCallingViewManager.userLeave(access$1000);
                TUICallKitImpl.this.showUserToast(access$1000, R.string.tuicalling_toast_user_reject_call);
                TUICallKitImpl.this.mInviteeList.remove(access$1000);
            }

            public void onUserSigExpired() {
                super.onUserSigExpired();
                TUICallEngine.createInstance(TUICallKitImpl.this.mContext).hangup((TUICommonDefine.Callback) null);
                TUICallKitImpl.this.resetCall();
            }

            public void onUserVideoAvailable(String str, boolean z11) {
                super.onUserVideoAvailable(str, z11);
                CallingUserModel access$1000 = TUICallKitImpl.this.findCallingUserModel(str);
                if (access$1000 != null && access$1000.isVideoAvailable != z11) {
                    access$1000.isVideoAvailable = z11;
                    TUICallKitImpl.this.mCallingViewManager.updateUser(access$1000);
                }
            }

            public void onUserVoiceVolumeChanged(Map<String, Integer> map) {
                CallingUserModel access$1000;
                super.onUserVoiceVolumeChanged(map);
                if (!TUICallDefine.Scene.SINGLE_CALL.equals(TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).getCallScene())) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!(next == null || TextUtils.isEmpty((CharSequence) next.getKey()) || (access$1000 = TUICallKitImpl.this.findCallingUserModel((String) next.getKey())) == null || access$1000.volume == ((Integer) next.getValue()).intValue())) {
                            access$1000.volume = ((Integer) next.getValue()).intValue();
                            TUICallKitImpl.this.mCallingViewManager.updateUser(access$1000);
                        }
                    }
                }
            }
        };
        this.mTUICallObserver = r02;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        TUICallEngine.createInstance(applicationContext).addObserver(r02);
        this.mCallingKeepAliveFeature = new CallingKeepAliveFeature(applicationContext);
        this.mCallingScreenSensorFeature = new CallingScreenSensorFeature(applicationContext);
        this.mCallingBellFeature = new CallingBellFeature(applicationContext);
        this.mCallingViewManager = new TUICallingViewManager(applicationContext);
        this.mUserInfoUtils = new UserInfoUtils();
        createTimeHandler();
        registerCallingEvent();
    }

    public static /* synthetic */ int access$1608(TUICallKitImpl tUICallKitImpl) {
        int i11 = tUICallKitImpl.mTimeCount;
        tUICallKitImpl.mTimeCount = i11 + 1;
        return i11;
    }

    public static TUICallKitImpl createInstance(Context context) {
        if (sInstance == null) {
            synchronized (TUICallKitImpl.class) {
                if (sInstance == null) {
                    sInstance = new TUICallKitImpl(context);
                }
            }
        }
        return sInstance;
    }

    private void createTimeHandler() {
        HandlerThread handlerThread = new HandlerThread("time-count-thread");
        this.mTimeHandlerThread = handlerThread;
        handlerThread.start();
        this.mTimeHandler = new Handler(this.mTimeHandlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    public CallingUserModel findCallingUserModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(this.mInviter.userId)) {
            return this.mInviter;
        }
        for (CallingUserModel next : this.mInviteeList) {
            if (next != null && !TextUtils.isEmpty(next.userId) && str.equals(next.userId)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int generateRoomId() {
        return new Random().nextInt(Integer.MAX_VALUE) + 1;
    }

    public static TUICallKit getInstance() {
        return sInstance;
    }

    /* access modifiers changed from: private */
    public String getShowTime(int i11) {
        return this.mContext.getString(R.string.tuicalling_called_time_format, new Object[]{Integer.valueOf(i11 / 60), Integer.valueOf(i11 % 60)});
    }

    private void initCallBeautyParams() {
        TXBeautyManager beautyManager = TUICallEngine.createInstance(this.mContext).getTRTCCloudInstance().getBeautyManager();
        beautyManager.setBeautyStyle(1);
        beautyManager.setBeautyLevel(6.0f);
    }

    private void initCallEngine() {
        TUICallEngine.createInstance(this.mContext).init(TUILogin.getSdkAppId(), TUILogin.getLoginUser(), TUILogin.getUserSig(), new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
            }

            public void onSuccess() {
            }
        });
        initCallVideoParams();
        initCallBeautyParams();
    }

    private void initCallVideoParams() {
        TUICommonDefine.VideoRenderParams videoRenderParams = new TUICommonDefine.VideoRenderParams();
        videoRenderParams.fillMode = TUICommonDefine.VideoRenderParams.FillMode.Fill;
        videoRenderParams.rotation = TUICommonDefine.VideoRenderParams.Rotation.Rotation_0;
        TUICallEngine.createInstance(this.mContext).setVideoRenderParams(TUILogin.getLoginUser(), videoRenderParams, new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
            }

            public void onSuccess() {
            }
        });
        TUICommonDefine.VideoEncoderParams videoEncoderParams = new TUICommonDefine.VideoEncoderParams();
        videoEncoderParams.resolution = TUICommonDefine.VideoEncoderParams.Resolution.Resolution_640_360;
        videoEncoderParams.resolutionMode = TUICommonDefine.VideoEncoderParams.ResolutionMode.Portrait;
        TUICallEngine.createInstance(this.mContext).setVideoEncoderParams(videoEncoderParams, new TUICommonDefine.Callback() {
            public void onError(int i11, String str) {
            }

            public void onSuccess() {
            }
        });
    }

    private boolean isLowQuality(TUICommonDefine.NetworkQuality networkQuality) {
        if (networkQuality == null) {
            return false;
        }
        int i11 = AnonymousClass12.$SwitchMap$com$tencent$qcloud$tuikit$TUICommonDefine$NetworkQuality[networkQuality.ordinal()];
        return i11 == 1 || i11 == 2;
    }

    private void queryUserInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mInviter);
        arrayList.addAll(this.mInviteeList);
        this.mUserInfoUtils.getUserInfo((List<CallingUserModel>) arrayList, (UserInfoUtils.UserCallback) new UserInfoUtils.UserCallback() {
            public void onFailed(int i11, String str) {
            }

            public void onSuccess(List<CallingUserModel> list) {
                CallingUserModel access$1000;
                if (list != null && !list.isEmpty()) {
                    for (CallingUserModel next : list) {
                        if (!(next == null || TextUtils.isEmpty(next.userId) || (access$1000 = TUICallKitImpl.this.findCallingUserModel(next.userId)) == null)) {
                            access$1000.userName = next.userName;
                            access$1000.userAvatar = next.userAvatar;
                        }
                    }
                    TUICallKitImpl.this.mCallingViewManager.updateCallingUserView(TUICallKitImpl.this.mInviteeList, TUICallKitImpl.this.mInviter);
                }
            }
        });
    }

    private void registerCallingEvent() {
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, this);
        TUICore.registerEvent(Constants.EVENT_TUICALLING_CHANGED, Constants.EVENT_SUB_CALL_STATUS_CHANGED, this);
    }

    /* access modifiers changed from: private */
    public void resetCall() {
        runOnMainThread(new Runnable() {
            public void run() {
                TUICallKitImpl.this.stopTimeCount();
                TUICallKitImpl.this.mCallingBellFeature.stopMusic();
                TUICallKitImpl.this.mCallingKeepAliveFeature.stopKeepAlive();
                TUICallKitImpl.this.mCallingScreenSensorFeature.unregisterSensorEventListener();
                TUICallKitImpl.this.mCallingViewManager.closeCallingView();
                CallingUserModel unused = TUICallKitImpl.this.mInviter = new CallingUserModel();
                TUICallKitImpl.this.mInviteeList.clear();
                TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).clear();
            }
        });
    }

    private void runOnMainThread(Runnable runnable) {
        if (runnable != null) {
            this.mMainHandler.post(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void showCallingView() {
        this.mCallingViewManager.createCallingView(this.mInviteeList, this.mInviter);
        TUICallingStatusManager.sharedInstance(this.mContext).updateCallStatus(TUICallDefine.Status.Waiting);
        queryUserInfo();
        this.mCallingKeepAliveFeature.startKeepAlive();
        this.mCallingScreenSensorFeature.registerSensorEventListener();
        this.mCallingViewManager.showCallingView();
    }

    /* access modifiers changed from: private */
    public void showTimeCount() {
        if (this.mTimeRunnable == null) {
            this.mTimeCount = 0;
            AnonymousClass8 r02 = new Runnable() {
                public void run() {
                    TUICallKitImpl.access$1608(TUICallKitImpl.this);
                    TUICallingViewManager access$600 = TUICallKitImpl.this.mCallingViewManager;
                    TUICallKitImpl tUICallKitImpl = TUICallKitImpl.this;
                    access$600.userCallingTimeStr(tUICallKitImpl.getShowTime(tUICallKitImpl.mTimeCount));
                    TUICallKitImpl.this.mTimeHandler.postDelayed(TUICallKitImpl.this.mTimeRunnable, 1000);
                }
            };
            this.mTimeRunnable = r02;
            this.mTimeHandler.post(r02);
        }
    }

    /* access modifiers changed from: private */
    public void showUserToast(final CallingUserModel callingUserModel, final int i11) {
        if (callingUserModel != null && !TextUtils.isEmpty(callingUserModel.userId)) {
            if (!TextUtils.isEmpty(callingUserModel.userName)) {
                ToastUtil.toastLongMessage(this.mContext.getString(i11, new Object[]{callingUserModel.userName}));
                return;
            }
            new UserInfoUtils().getUserInfo(callingUserModel.userId, (UserInfoUtils.UserCallback) new UserInfoUtils.UserCallback() {
                public void onFailed(int i11, String str) {
                    ToastUtil.toastLongMessage(TUICallKitImpl.this.mContext.getString(i11, new Object[]{callingUserModel.userId}));
                }

                public void onSuccess(List<CallingUserModel> list) {
                    if (list == null || list.isEmpty() || list.get(0) == null || TextUtils.isEmpty(list.get(0).userId)) {
                        ToastUtil.toastLongMessage(TUICallKitImpl.this.mContext.getString(i11, new Object[]{callingUserModel.userId}));
                        return;
                    }
                    callingUserModel.userName = list.get(0).userName;
                    callingUserModel.userAvatar = list.get(0).userAvatar;
                    ToastUtil.toastLongMessage(TUICallKitImpl.this.mContext.getString(i11, new Object[]{callingUserModel.userName}));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void stopTimeCount() {
        this.mTimeHandler.removeCallbacks(this.mTimeRunnable);
        this.mTimeRunnable = null;
        this.mTimeCount = 0;
    }

    private void updateLowQualityTip(boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z11) {
            if (currentTimeMillis - this.mSelfLowQualityTime > 5000) {
                ToastUtil.toastShortMessage(this.mContext.getString(R.string.tuicalling_self_network_low_quality));
                this.mSelfLowQualityTime = currentTimeMillis;
            }
        } else if (currentTimeMillis - this.mOtherUserLowQualityTime > 5000) {
            ToastUtil.toastShortMessage(this.mContext.getString(R.string.tuicalling_other_party_network_low_quality));
            this.mOtherUserLowQualityTime = currentTimeMillis;
        }
    }

    /* access modifiers changed from: private */
    public void updateNetworkQuality(List<TUICommonDefine.NetworkQualityInfo> list) {
        if (!list.isEmpty()) {
            TUICommonDefine.NetworkQualityInfo networkQualityInfo = null;
            Iterator<TUICommonDefine.NetworkQualityInfo> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TUICommonDefine.NetworkQualityInfo next = it2.next();
                if (TUILogin.getLoginUser().equals(next.userId)) {
                    networkQualityInfo = next;
                    break;
                }
            }
            if (networkQualityInfo != null ? isLowQuality(networkQualityInfo.quality) : false) {
                updateLowQualityTip(true);
            } else if (it2.hasNext() && isLowQuality(it2.next().quality)) {
                updateLowQualityTip(false);
            }
        }
    }

    public void call(String str, TUICallDefine.MediaType mediaType) {
        TUICallDefine.CallParams callParams = new TUICallDefine.CallParams();
        callParams.offlinePushInfo = OfflinePushInfoConfig.createOfflinePushInfo(this.mContext);
        callParams.timeout = Constants.SIGNALING_MAX_TIME;
        call(str, mediaType, callParams, (TUICommonDefine.Callback) null);
    }

    public void callbackError(TUICommonDefine.Callback callback, int i11, String str) {
        if (callback != null) {
            callback.onError(i11, str);
        }
    }

    public void callbackSuccess(TUICommonDefine.Callback callback) {
        if (callback != null) {
            callback.onSuccess();
        }
    }

    public TUICallKit enableFloatWindow(boolean z11) {
        TUILog.i("TUICallKit", "enableFloatWindow, enable: " + z11);
        this.mCallingViewManager.enableFloatWindow(z11);
        return this;
    }

    public void enableMuteMode(boolean z11) {
        TUILog.i("TUICallKit", "enableMuteMode, enable: " + z11);
        SPUtils.getInstance(CallingBellFeature.PROFILE_TUICALLKIT).put(CallingBellFeature.PROFILE_MUTE_MODE, z11);
    }

    public void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType) {
        TUICallDefine.CallParams callParams = new TUICallDefine.CallParams();
        callParams.offlinePushInfo = OfflinePushInfoConfig.createOfflinePushInfo(this.mContext);
        callParams.timeout = Constants.SIGNALING_MAX_TIME;
        groupCall(str, list, mediaType, callParams, (TUICommonDefine.Callback) null);
    }

    public void hangup(TUICommonDefine.Callback callback) {
        TUICallEngine.createInstance(this.mContext).hangup(callback);
    }

    public void joinInGroupCall(final TUICommonDefine.RoomId roomId, final String str, final TUICallDefine.MediaType mediaType) {
        TUILog.i("TUICallKit", "joinInGroupCall, roomId: " + roomId + " ,groupId: " + str + " ,mediaType: " + mediaType);
        int i11 = roomId != null ? roomId.intRoomId : 0;
        if (i11 <= 0 || i11 >= Integer.MAX_VALUE) {
            TUILog.e("TUICallKit", "joinInGroupCall failed, roomId is invalid");
        } else if (TextUtils.isEmpty(str)) {
            TUILog.e("TUICallKit", "joinInGroupCall failed, groupId is empty");
        } else if (TUICallDefine.MediaType.Unknown.equals(mediaType)) {
            TUILog.e("TUICallKit", "joinInGroupCall failed, mediaType is unknown");
        } else {
            PermissionRequest.requestPermissions(this.mContext, mediaType, new PermissionCallback() {
                public void onDenied() {
                    TUICallKitImpl.this.resetCall();
                }

                public void onGranted() {
                    TUICallEngine.createInstance(TUICallKitImpl.this.mContext).joinInGroupCall(roomId, str, mediaType, new TUICommonDefine.Callback() {
                        public void onError(int i11, String str) {
                            if (i11 == TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED) {
                                str = TUICallKitImpl.this.mContext.getString(R.string.tuicalling_package_not_support);
                            }
                            ToastUtil.toastLongMessage(str);
                        }

                        public void onSuccess() {
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).updateCallStatus(TUICallDefine.Status.Accept);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setMediaType(mediaType);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallScene(TUICallDefine.Scene.GROUP_CALL);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallRole(TUICallDefine.Role.Called);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setGroupId(str);
                            TUICallKitImpl.this.mCallingViewManager.createGroupCallingAcceptView();
                            TUICallKitImpl.this.mCallingViewManager.showCallingView();
                            TUICallKitImpl.this.showTimeCount();
                        }
                    });
                }
            });
        }
    }

    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED.equals(str)) {
            if (TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS.equals(str2)) {
                TUICallEngine.createInstance(this.mContext).hangup((TUICommonDefine.Callback) null);
                TUICallEngine.destroyInstance();
                resetCall();
            } else if (TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS.equals(str2)) {
                TUILog.i("TUICallKit", "login success");
                TUICallEngine.createInstance(this.mContext).addObserver(this.mTUICallObserver);
                initCallEngine();
            }
        }
        if (Constants.EVENT_TUICALLING_CHANGED.equals(str) && Constants.EVENT_SUB_CALL_STATUS_CHANGED.equals(str2) && map != null && TUICallDefine.Status.None.equals(map.get(Constants.CALL_STATUS))) {
            resetCall();
        }
    }

    public void queryOfflineCall() {
        if (TUICallDefine.Status.None.equals(TUICallingStatusManager.sharedInstance(this.mContext).getCallStatus())) {
            TUICallEngine.createInstance(this.mContext).queryOfflineCall();
        }
    }

    public void setCallingBell(String str) {
        TUILog.i("TUICallKit", "setCallingBell, filePath: " + str);
        SPUtils.getInstance(CallingBellFeature.PROFILE_TUICALLKIT).put(CallingBellFeature.PROFILE_CALL_BELL, str);
    }

    public void setSelfInfo(String str, String str2, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallKit", "setSelfInfo, nickname: " + str + " ,avatar: " + str2);
        TUICallEngine.createInstance(this.mContext).setSelfInfo(str, str2, callback);
    }

    public TUICallKit setTUICallObserverOut(TUICallObserver tUICallObserver) {
        this.mTUICallObserverOut = tUICallObserver;
        return this;
    }

    public void call(String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallKit", "call, userId: " + str + " ,callMediaType: " + mediaType + " ,params: " + callParams);
        if (TextUtils.isEmpty(str)) {
            TUILog.e("TUICallKit", "call failed, userId is empty");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "call failed, userId is empty");
        } else if (TUICallDefine.MediaType.Unknown.equals(mediaType)) {
            TUILog.e("TUICallKit", "call failed, callMediaType is Unknown");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "call failed, callMediaType is Unknown");
        } else {
            final String str2 = str;
            final TUICallDefine.MediaType mediaType2 = mediaType;
            final TUICallDefine.CallParams callParams2 = callParams;
            final TUICommonDefine.Callback callback2 = callback;
            PermissionRequest.requestPermissions(this.mContext, mediaType, new PermissionCallback() {
                public void onDenied() {
                    TUICallKitImpl.this.callbackError(callback2, TUICallDefine.ERROR_PERMISSION_DENIED, "permission denied");
                    TUICallKitImpl.this.resetCall();
                }

                public void onGranted() {
                    TUICommonDefine.RoomId roomId = new TUICommonDefine.RoomId();
                    roomId.intRoomId = TUICallKitImpl.this.generateRoomId();
                    TUICallEngine.createInstance(TUICallKitImpl.this.mContext).call(roomId, str2, mediaType2, callParams2, new TUICommonDefine.Callback() {
                        public void onError(int i11, String str) {
                            if (i11 == TUICallDefine.ERROR_PACKAGE_NOT_PURCHASED) {
                                str = TUICallKitImpl.this.mContext.getString(R.string.tuicalling_package_not_purchased);
                            }
                            ToastUtil.toastLongMessage(str);
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            TUICallKitImpl.this.callbackError(callback2, i11, str);
                        }

                        public void onSuccess() {
                            CallingUserModel callingUserModel = new CallingUserModel();
                            AnonymousClass1 r12 = AnonymousClass1.this;
                            callingUserModel.userId = str2;
                            TUICallKitImpl.this.mInviteeList.add(callingUserModel);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setMediaType(mediaType2);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallRole(TUICallDefine.Role.Caller);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallScene(TUICallDefine.Scene.SINGLE_CALL);
                            TUICallKitImpl.this.showCallingView();
                            TUICallKitImpl.this.mCallingBellFeature.startDialingMusic();
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            TUICallKitImpl.this.callbackSuccess(callback2);
                        }
                    });
                }
            });
        }
    }

    public void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallKit", "groupCall, groupId: " + str + " ,userIdList: " + list + " ,callMediaType: " + mediaType + " ,params: " + callParams);
        if (TextUtils.isEmpty(str)) {
            TUILog.e("TUICallKit", "groupCall failed, groupId is empty");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "groupCall failed, groupId is empty");
        } else if (TUICallDefine.MediaType.Unknown.equals(mediaType)) {
            TUILog.e("TUICallKit", "groupCall failed, callMediaType is Unknown");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "groupCall failed, callMediaType is Unknown");
        } else if (list == null || list.isEmpty()) {
            TUILog.e("TUICallKit", "groupCall failed, userIdList is empty");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "groupCall failed, userIdList is empty");
        } else if (list.size() >= 9) {
            ToastUtil.toastLongMessage(this.mContext.getString(R.string.tuicalling_user_exceed_limit));
            TUILog.e("TUICallKit", "groupCall failed, exceeding max user number: 9");
            callbackError(callback, TUICallDefine.ERROR_PARAM_INVALID, "groupCall failed, exceeding max user number");
        } else {
            final String str2 = str;
            final List<String> list2 = list;
            final TUICallDefine.MediaType mediaType2 = mediaType;
            final TUICallDefine.CallParams callParams2 = callParams;
            final TUICommonDefine.Callback callback2 = callback;
            PermissionRequest.requestPermissions(this.mContext, mediaType, new PermissionCallback() {
                public void onDenied() {
                    TUICallKitImpl.this.callbackError(callback2, TUICallDefine.ERROR_PERMISSION_DENIED, "permission denied");
                    TUICallKitImpl.this.resetCall();
                }

                public void onGranted() {
                    TUICommonDefine.RoomId roomId = new TUICommonDefine.RoomId();
                    roomId.intRoomId = TUICallKitImpl.this.generateRoomId();
                    TUICallEngine.createInstance(TUICallKitImpl.this.mContext).groupCall(roomId, str2, list2, mediaType2, callParams2, new TUICommonDefine.Callback() {
                        public void onError(int i11, String str) {
                            if (i11 == TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED) {
                                str = TUICallKitImpl.this.mContext.getString(R.string.tuicalling_package_not_support);
                            }
                            ToastUtil.toastLongMessage(str);
                            AnonymousClass2 r02 = AnonymousClass2.this;
                            TUICallKitImpl.this.callbackError(callback2, i11, str);
                        }

                        public void onSuccess() {
                            for (String str : list2) {
                                if (!TextUtils.isEmpty(str)) {
                                    CallingUserModel callingUserModel = new CallingUserModel();
                                    callingUserModel.userId = str;
                                    TUICallKitImpl.this.mInviteeList.add(callingUserModel);
                                }
                            }
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setMediaType(mediaType2);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallRole(TUICallDefine.Role.Caller);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setCallScene(TUICallDefine.Scene.GROUP_CALL);
                            TUICallingStatusManager.sharedInstance(TUICallKitImpl.this.mContext).setGroupId(str2);
                            TUICallKitImpl.this.showCallingView();
                            TUICallKitImpl.this.mCallingBellFeature.startDialingMusic();
                            AnonymousClass2 r02 = AnonymousClass2.this;
                            TUICallKitImpl.this.callbackSuccess(callback2);
                        }
                    });
                }
            });
        }
    }
}

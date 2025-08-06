package com.tencent.qcloud.tuikit.tuicallengine.f;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.f.n;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static Context f48439a;

    /* renamed from: b  reason: collision with root package name */
    public final List<TRTCCloudListener> f48440b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48441c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48442d;

    /* renamed from: e  reason: collision with root package name */
    public final TRTCCloudListener f48443e = new a();

    public class a extends TRTCCloudListener {
        public a() {
        }

        public void onCameraDidReady() {
            super.onCameraDidReady();
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onCameraDidReady();
                }
            }
        }

        public void onEnterRoom(long j11) {
            super.onEnterRoom(j11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onEnterRoom(j11);
                }
            }
        }

        public void onError(int i11, String str, Bundle bundle) {
            super.onError(i11, str, bundle);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onError(i11, str, bundle);
                }
            }
        }

        public void onExitRoom(int i11) {
            super.onExitRoom(i11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onExitRoom(i11);
                }
            }
            k kVar = k.this;
            kVar.getClass();
            TRTCCloud.sharedInstance(k.f48439a).removeListener(kVar.f48443e);
        }

        public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
            super.onNetworkQuality(tRTCQuality, arrayList);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onNetworkQuality(tRTCQuality, arrayList);
                }
            }
        }

        public void onRemoteUserEnterRoom(String str) {
            super.onRemoteUserEnterRoom(str);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onRemoteUserEnterRoom(str);
                }
            }
        }

        public void onRemoteUserLeaveRoom(String str, int i11) {
            super.onRemoteUserLeaveRoom(str, i11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onRemoteUserLeaveRoom(str, i11);
                }
            }
        }

        public void onRemoteVideoStatusUpdated(String str, int i11, int i12, int i13, Bundle bundle) {
            super.onRemoteVideoStatusUpdated(str, i11, i12, i13, bundle);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onRemoteVideoStatusUpdated(str, i11, i12, i13, bundle);
                }
            }
        }

        public void onUserAudioAvailable(String str, boolean z11) {
            super.onUserAudioAvailable(str, z11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onUserAudioAvailable(str, z11);
                }
            }
        }

        public void onUserVideoAvailable(String str, boolean z11) {
            super.onUserVideoAvailable(str, z11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onUserVideoAvailable(str, z11);
                }
            }
        }

        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i11) {
            super.onUserVoiceVolume(arrayList, i11);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onUserVoiceVolume(arrayList, i11);
                }
            }
        }

        public void onWarning(int i11, String str, Bundle bundle) {
            super.onWarning(i11, str, bundle);
            for (TRTCCloudListener next : k.this.f48440b) {
                if (next != null) {
                    next.onWarning(i11, str, bundle);
                }
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final k f48445a = new k(k.f48439a);
    }

    public k(Context context) {
        f48439a = context;
        this.f48440b = new ArrayList();
    }

    public static k a(Context context) {
        f48439a = context;
        return b.f48445a;
    }

    public void b(TRTCCloudListener tRTCCloudListener) {
        Iterator<TRTCCloudListener> it2 = this.f48440b.iterator();
        while (it2.hasNext()) {
            TRTCCloudListener next = it2.next();
            if (next == null) {
                it2.remove();
            } else if (next == tRTCCloudListener) {
                it2.remove();
            }
        }
    }

    public void c() {
        TRTCCloud.sharedInstance(f48439a).startLocalAudio(1);
        this.f48441c = true;
    }

    public void a() {
        TRTCCloud.sharedInstance(f48439a).addListener(this.f48443e);
    }

    public void a(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null) {
            for (TRTCCloudListener equals : this.f48440b) {
                if (tRTCCloudListener.equals(equals)) {
                    return;
                }
            }
            this.f48440b.add(tRTCCloudListener);
        }
    }

    public void b() {
        TUILog.i("TRTCCloudService", "exitRoom userId: " + V2TIMManager.getInstance().getLoginUser());
        TRTCCloud.sharedInstance(f48439a).stopLocalPreview();
        TRTCCloud.sharedInstance(f48439a).stopLocalAudio();
        TRTCCloud.sharedInstance(f48439a).exitRoom();
    }

    public void a(TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("enterRoom userId: ");
        sb2.append(V2TIMManager.getInstance().getLoginUser());
        sb2.append(" roomId: ");
        sb2.append(roomId);
        sb2.append(" ,SDKAppID: ");
        n nVar = n.a.f48451a;
        sb2.append(nVar.f48449a);
        TUILog.i("TRTCCloudService", sb2.toString());
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.role = 20;
        tRTCParams.sdkAppId = nVar.f48449a;
        tRTCParams.userId = V2TIMManager.getInstance().getLoginUser();
        tRTCParams.userSig = nVar.f48450b;
        tRTCParams.roomId = roomId.intRoomId;
        tRTCParams.strRoomId = roomId.strRoomId;
        TRTCCloud sharedInstance = TRTCCloud.sharedInstance(f48439a);
        sharedInstance.enableAudioVolumeEvaluation(300);
        sharedInstance.setDefaultStreamRecvMode(true, true);
        Context context = f48439a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api", V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("framework", com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a);
            jSONObject2.put("component", com.tencent.qcloud.tuikit.tuicallengine.k.a.f48520b);
            jSONObject2.put("language", com.tencent.qcloud.tuikit.tuicallengine.k.a.f48521c);
            jSONObject.put("params", jSONObject2);
            TRTCCloud.sharedInstance(context).callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        sharedInstance.enterRoom(tRTCParams, TUICallDefine.MediaType.Video.equals(mediaType) ? 0 : 2);
    }
}

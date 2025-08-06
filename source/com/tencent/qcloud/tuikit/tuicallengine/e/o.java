package com.tencent.qcloud.tuikit.tuicallengine.e;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.common.n0;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.f.n;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.k.f;
import com.tencent.qcloud.tuikit.tuicallengine.k.g;
import com.tencent.qcloud.tuikit.tuicallengine.k.i;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import com.tencent.rtmp.TXLiveBase;
import java.util.List;
import java.util.Map;

public class o {
    public static SignalingData a() {
        SignalingData signalingData = new SignalingData();
        signalingData.setVersion(4);
        signalingData.setBusinessID(TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID);
        signalingData.setPlatform(n0.f32119g);
        return signalingData;
    }

    public static long b() {
        long networkTimestamp = TXLiveBase.getNetworkTimestamp();
        if (networkTimestamp > 0) {
            return networkTimestamp;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TXLiveBase.updateNetworkTime();
        return currentTimeMillis;
    }

    public static boolean c(SignalingData signalingData) {
        if (signalingData == null) {
            return false;
        }
        if (4 < signalingData.getVersion() || d(signalingData)) {
            SignalingData.DataInfo data = signalingData.getData();
            if (data == null) {
                return false;
            }
            return "lineBusy".equals(data.getMessage());
        }
        int i11 = a.f48519a;
        return "line_busy".equals(signalingData.getLineBusy());
    }

    public static boolean d(SignalingData signalingData) {
        return !TextUtils.isEmpty(signalingData.getPlatform()) && !TextUtils.isEmpty(signalingData.getBusinessID());
    }

    public static boolean e(SignalingData signalingData) {
        if (!d(signalingData)) {
            return !TextUtils.isEmpty(signalingData.getSwitchToAudioCall());
        }
        if (signalingData.getData() == null) {
            return false;
        }
        return "switchToAudio".equals(signalingData.getData().getCmd());
    }

    public static boolean d() {
        String valueOf = String.valueOf(n.a.f48451a.f48449a);
        return valueOf.startsWith("14") || valueOf.startsWith("17") || valueOf.startsWith(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_HUOBI_EARN);
    }

    public static boolean b(SignalingData signalingData) {
        if (TextUtils.isEmpty(signalingData.getBusinessID())) {
            return false;
        }
        return TUIConstants.TUICalling.CUSTOM_MESSAGE_BUSINESS_ID.equals(signalingData.getBusinessID());
    }

    public static String a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            return V2TIMConversation.CONVERSATION_GROUP_TYPE;
        }
        return (list == null || list.size() <= 1) ? "single" : "multi";
    }

    public static SignalingData c(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar) {
        if (aVar == null) {
            return null;
        }
        SignalingData a11 = a();
        a11.setCallType(aVar.f48384n.get().ordinal());
        a11.setRoomId(aVar.f48371a.intRoomId);
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        dataInfo.setInviter(aVar.f48373c);
        a11.setData(dataInfo);
        return a11;
    }

    public static String b(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar) {
        if (aVar == null) {
            return null;
        }
        SignalingData a11 = a();
        a11.setCallType(aVar.f48384n.get().ordinal());
        a11.setRoomId(aVar.f48371a.intRoomId);
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        String str = aVar.f48373c;
        if (str == null) {
            str = "";
        }
        dataInfo.setInviter(str);
        a11.setData(dataInfo);
        return a(a11);
    }

    public static SignalingData a(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar, long j11) {
        if (aVar == null) {
            return null;
        }
        int ordinal = aVar.f48384n.get().ordinal();
        SignalingData a11 = a();
        a11.setCallType(ordinal);
        a11.setRoomId(aVar.f48371a.intRoomId);
        TUICallDefine.CallParams callParams = aVar.f48380j;
        if (callParams != null && !TextUtils.isEmpty(callParams.userData)) {
            a11.setUserData(aVar.f48380j.userData);
        }
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        if (ordinal == TUICallDefine.MediaType.Audio.ordinal()) {
            dataInfo.setCmd("audioCall");
        } else if (ordinal == TUICallDefine.MediaType.Video.ordinal()) {
            dataInfo.setCmd("videoCall");
        }
        if (j11 > 0) {
            dataInfo.setInviteTime(j11);
        }
        String str = aVar.f48373c;
        if (str == null) {
            str = "";
        }
        dataInfo.setInviter(str);
        dataInfo.setRoomID(aVar.f48371a.intRoomId);
        dataInfo.setStrRoomId(aVar.f48371a.strRoomId);
        dataInfo.setUserIDs(aVar.f48374d);
        a11.setData(dataInfo);
        return a11;
    }

    public static String c() {
        int i11;
        String str = d() ? "https://buy.cloud.tencent.com/avc?addRavLicense=1" : "https://buy.tencentcloud.com/avc?addRavLicense=1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("&position=");
        n nVar = n.a.f48451a;
        sb2.append(nVar.f48449a);
        sb2.append("&regionId=");
        int i12 = nVar.f48449a;
        if ((i12 >= 20000000 && i12 < 30000000) || (i12 >= 1720000000 && i12 < 1730000000)) {
            int i13 = a.f48519a;
            i11 = 9;
        } else if ((i12 >= 30000000 && i12 < 40000000) || (i12 >= 1730000000 && i12 < 1740000000)) {
            int i14 = a.f48519a;
            i11 = 18;
        } else if ((i12 >= 40000000 && i12 < 50000000) || (i12 >= 1740000000 && i12 < 1750000000)) {
            int i15 = a.f48519a;
            i11 = 17;
        } else if ((i12 >= 50000000 && i12 < 60000000) || (i12 >= 1750000000 && i12 < 1760000000)) {
            int i16 = a.f48519a;
            i11 = 21;
        } else if ((i12 < 70000000 || i12 >= 80000000) && (i12 < 1770000000 || i12 >= 1780000000)) {
            int i17 = a.f48519a;
            i11 = 1;
        } else {
            int i18 = a.f48519a;
            i11 = 15;
        }
        sb2.append(i11);
        return sb2.toString();
    }

    public static void a(TUICallDefine.Status status, TUICommonDefine.Callback callback) {
        V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
        int ordinal = status.ordinal();
        if (ordinal == 1) {
            v2TIMUserStatus.setCustomStatus("call_wait");
        } else if (ordinal != 2) {
            v2TIMUserStatus.setCustomStatus((String) null);
        } else {
            v2TIMUserStatus.setCustomStatus("call_accept");
        }
        V2TIMManager.getInstance().setSelfStatus(v2TIMUserStatus, new f((TUICommonDefine.Callback) null));
    }

    public static SignalingData a(String str) {
        SignalingData signalingData = new SignalingData();
        try {
            Object obj = TUIConstants.TUIGroup.USER_DATA;
            Map map = (Map) new Gson().fromJson(str, Map.class);
            if (map == null) {
                TUILog.e("SignalingParseUtils", "extraMap is null, ignore");
                return signalingData;
            }
            int i11 = a.f48519a;
            if (map.containsKey("version")) {
                Object obj2 = map.get("version");
                if (obj2 instanceof Double) {
                    signalingData.setVersion(((Double) obj2).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "version is not Double, value is :" + obj2);
                }
            }
            if (map.containsKey("platform")) {
                Object obj3 = map.get("platform");
                if (obj3 instanceof String) {
                    signalingData.setPlatform((String) obj3);
                } else {
                    TUILog.e("SignalingParseUtils", "platform is not string, value is :" + obj3);
                }
            }
            if (map.containsKey("businessID")) {
                Object obj4 = map.get("businessID");
                if (obj4 instanceof String) {
                    signalingData.setBusinessID((String) obj4);
                } else {
                    TUILog.e("SignalingParseUtils", "businessId is not string, value is :" + obj4);
                }
            }
            if (map.containsKey(TUIConstants.Message.CALLING_TYPE_KEY)) {
                Object obj5 = map.get(TUIConstants.Message.CALLING_TYPE_KEY);
                if (obj5 instanceof Double) {
                    signalingData.setCallType(((Double) obj5).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "callType is not Double, value is :" + obj5);
                }
            }
            if (map.containsKey("room_id")) {
                Object obj6 = map.get("room_id");
                if (obj6 instanceof Double) {
                    signalingData.setRoomId(((Double) obj6).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "roomId is not Double, value is :" + obj6);
                }
            }
            if (map.containsKey("line_busy")) {
                Object obj7 = map.get("line_busy");
                if (obj7 instanceof String) {
                    signalingData.setLineBusy((String) obj7);
                } else {
                    TUILog.e("SignalingParseUtils", "lineBusy is not string, value is :" + obj7);
                }
            }
            if (map.containsKey("call_end")) {
                Object obj8 = map.get("call_end");
                if (obj8 instanceof Double) {
                    signalingData.setCallEnd(((Double) obj8).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "callEnd is not Double, value is :" + obj8);
                }
            }
            if (map.containsKey("switch_to_audio_call")) {
                Object obj9 = map.get("switch_to_audio_call");
                if (obj9 instanceof String) {
                    signalingData.setSwitchToAudioCall((String) obj9);
                } else {
                    TUILog.e("SignalingParseUtils", "switchToAudioCall is not string, value is :" + obj9);
                }
            }
            if (map.containsKey("data")) {
                Object obj10 = map.get("data");
                if (obj10 == null || !(obj10 instanceof Map)) {
                    TUILog.e("SignalingParseUtils", "dataMapObj is not map, value is :" + obj10);
                } else {
                    signalingData.setData(a((Map<String, Object>) (Map) obj10));
                }
            }
            if (map.containsKey("call_action")) {
                Object obj11 = map.get("call_action");
                if (obj11 instanceof Double) {
                    signalingData.setCallAction(((Double) obj11).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "callAciton is not Double, value is :" + obj11);
                }
            }
            if (map.containsKey("user")) {
                Object obj12 = map.get("user");
                if (obj12 instanceof String) {
                    signalingData.setUser((String) obj12);
                } else {
                    TUILog.e("SignalingParseUtils", "user is not String, value is :" + obj12);
                }
            }
            Object obj13 = obj;
            if (map.containsKey(obj13)) {
                Object obj14 = map.get(obj13);
                if (obj14 instanceof String) {
                    signalingData.setUserData((String) obj14);
                } else {
                    TUILog.e("SignalingParseUtils", "userData is not String, value is :" + obj14);
                }
            }
            return signalingData;
        } catch (Exception e11) {
            TUILog.e("SignalingParseUtils", "convertToCallingData json parse error" + e11);
        }
    }

    public static String a(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar, List<String> list, List<String> list2, TUICallDefine.CallParams callParams, long j11) {
        if (aVar == null) {
            return null;
        }
        int ordinal = aVar.f48384n.get().ordinal();
        SignalingData a11 = a();
        a11.setCallType(ordinal);
        a11.setRoomId(aVar.f48371a.intRoomId);
        if (callParams != null && !TextUtils.isEmpty(callParams.userData)) {
            a11.setUserData(callParams.userData);
        }
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        if (ordinal == TUICallDefine.MediaType.Audio.ordinal()) {
            dataInfo.setCmd("audioCall");
        } else if (ordinal == TUICallDefine.MediaType.Video.ordinal()) {
            dataInfo.setCmd("videoCall");
        }
        if (j11 > 0) {
            dataInfo.setInviteTime(j11);
        }
        dataInfo.setRoomID(aVar.f48371a.intRoomId);
        dataInfo.setStrRoomId(aVar.f48371a.strRoomId);
        dataInfo.setUserIDs(list);
        dataInfo.setInCallUserIDs(list2);
        String str = aVar.f48382l.get();
        String str2 = aVar.f48383m.get();
        if (!TextUtils.isEmpty(str2) && !OptionsBridge.NULL_VALUE.equalsIgnoreCase(str2)) {
            str = aVar.f48383m.get();
        }
        dataInfo.setInitialCallId(str);
        a11.setData(dataInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        int i11 = a.f48519a;
        a(gsonBuilder, "call_end");
        return gsonBuilder.create().toJson((Object) a11);
    }

    public static void a(List<String> list, TUICommonDefine.ValueCallback valueCallback) {
        if (list.isEmpty()) {
            valueCallback.onError(-1, "getUserStatus, userList is empty");
        } else {
            V2TIMManager.getInstance().getUserStatus(list, new g(valueCallback));
        }
    }

    public static String a(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar) {
        if (aVar == null) {
            return null;
        }
        SignalingData a11 = a();
        a11.setCallType(aVar.f48384n.get().ordinal());
        a11.setRoomId(aVar.f48371a.intRoomId);
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        dataInfo.setInviter(aVar.f48373c);
        dataInfo.setExcludeFromHistoryMessage(true);
        a11.setData(dataInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        int i11 = a.f48519a;
        a(gsonBuilder, "call_end");
        return gsonBuilder.create().toJson((Object) a11);
    }

    public static String a(String str, TUICallDefine.MediaType mediaType, boolean z11) {
        SignalingData a11 = a();
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        if (z11) {
            int i11 = a.f48519a;
            a11.setLineBusy("line_busy");
            dataInfo.setMessage("lineBusy");
        } else {
            dataInfo.setCmd("lineBusy");
        }
        a11.setCallType(mediaType.ordinal());
        dataInfo.setInviter(str);
        a11.setData(dataInfo);
        return a(a11);
    }

    public static void a(long j11, TUICommonDefine.ValueCallback valueCallback) {
        TUILog.i("TUICallingUtils", "checkCallingAbility, param: " + Long.toBinaryString(j11));
        V2TIMManager.getInstance().callExperimentalAPI("isCommercialAbilityEnabled", Long.valueOf(j11), new i(valueCallback));
    }

    public static SignalingData a(com.tencent.qcloud.tuikit.tuicallengine.f.a aVar, int i11) {
        if (aVar == null) {
            return null;
        }
        SignalingData a11 = a();
        a11.setCallType(aVar.f48384n.get().ordinal());
        a11.setRoomId(aVar.f48371a.intRoomId);
        a11.setCallEnd(i11);
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        dataInfo.setCmd("hangup");
        dataInfo.setRoomID(aVar.f48371a.intRoomId);
        dataInfo.setInviter(aVar.f48373c);
        a11.setData(dataInfo);
        return a11;
    }

    public static SignalingData.DataInfo a(Map<String, Object> map) {
        SignalingData.DataInfo dataInfo = new SignalingData.DataInfo();
        try {
            int i11 = a.f48519a;
            if (map.containsKey(Constants.MQTT_STATISTISC_MSGTYPE_KEY)) {
                Object obj = map.get(Constants.MQTT_STATISTISC_MSGTYPE_KEY);
                if (obj instanceof String) {
                    dataInfo.setCmd((String) obj);
                } else {
                    TUILog.e("SignalingParseUtils", "cmd is not string, value is :" + obj);
                }
            }
            if (map.containsKey(TUIConstants.TUICalling.PARAM_NAME_USERIDS)) {
                Object obj2 = map.get(TUIConstants.TUICalling.PARAM_NAME_USERIDS);
                if (obj2 instanceof List) {
                    dataInfo.setUserIDs((List) obj2);
                } else {
                    TUILog.e("SignalingParseUtils", "userIDs is not List, value is :" + obj2);
                }
            }
            if (map.containsKey("room_id")) {
                Object obj3 = map.get("room_id");
                if (obj3 instanceof Double) {
                    dataInfo.setRoomID(((Double) obj3).intValue());
                } else {
                    TUILog.e("SignalingParseUtils", "roomId is not Double, value is :" + obj3);
                }
            }
            if (map.containsKey("str_room_id")) {
                Object obj4 = map.get("str_room_id");
                if (obj4 instanceof String) {
                    dataInfo.setStrRoomId((String) obj4);
                } else {
                    TUILog.e("SignalingParseUtils", "strRoomId is not string, value is: " + obj4);
                }
            }
            if (map.containsKey("message")) {
                Object obj5 = map.get("message");
                if (obj5 instanceof String) {
                    dataInfo.setMessage((String) obj5);
                } else {
                    TUILog.e("SignalingParseUtils", "message is not string, value is :" + obj5);
                }
            }
            if (map.containsKey("inviteTime")) {
                Object obj6 = map.get("inviteTime");
                if (obj6 instanceof Double) {
                    dataInfo.setInviteTime(((Double) obj6).longValue());
                } else {
                    TUILog.e("SignalingParseUtils", "inviteTime is not Long, value is :" + obj6);
                }
            }
            if (map.containsKey("inCallUserIDs")) {
                Object obj7 = map.get("inCallUserIDs");
                if (obj7 instanceof List) {
                    dataInfo.setInCallUserIDs((List) obj7);
                } else {
                    TUILog.e("SignalingParseUtils", "inCallUserIds is not List, value is :" + obj7);
                }
            }
            if (map.containsKey("consumed")) {
                Object obj8 = map.get("consumed");
                if (obj8 instanceof Boolean) {
                    dataInfo.setConsumed((Boolean) obj8);
                } else {
                    TUILog.e("SignalingParseUtils", "consumed is Boolean, value is: " + obj8);
                }
            }
            if (map.containsKey("initialCallId")) {
                Object obj9 = map.get("initialCallId");
                if (obj9 instanceof String) {
                    dataInfo.setInitialCallId((String) obj9);
                } else {
                    TUILog.e("SignalingParseUtils", "initialCallId is not String, value is :" + obj9);
                }
            }
        } catch (Exception e11) {
            TUILog.e("SignalingParseUtils", "convertToDataInfo json parse error: " + e11);
        }
        return dataInfo;
    }

    public static void a(GsonBuilder gsonBuilder, String... strArr) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            gsonBuilder.setExclusionStrategies(new com.tencent.qcloud.tuikit.tuicallengine.j.a(strArr[i11]));
        }
    }

    public static String a(SignalingData signalingData) {
        if (signalingData == null) {
            return null;
        }
        SignalingData.DataInfo data = signalingData.getData();
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (!(data == null || data.getCmd() == null || data.getCmd().equals("hangup"))) {
            int i11 = a.f48519a;
            a(gsonBuilder, "call_end");
        }
        boolean z11 = data != null && data.isExcludeFromHistoryMessage();
        if (!z11) {
            z11 = a.f48522d;
        }
        if (!z11) {
            int i12 = a.f48519a;
            a(gsonBuilder, "excludeFromHistoryMessage");
        }
        return gsonBuilder.create().toJson((Object) signalingData);
    }
}

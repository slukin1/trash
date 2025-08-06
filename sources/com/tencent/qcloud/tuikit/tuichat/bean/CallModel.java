package com.tencent.qcloud.tuikit.tuichat.bean;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSignalingInfo;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.timcommon.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.io.Serializable;
import java.util.Map;

public class CallModel implements Cloneable, Serializable {
    public static final int CALL_MESSAGE_DIRECTION_INCOMING = 0;
    public static final int CALL_MESSAGE_DIRECTION_OUTGOING = 1;
    public static final int CALL_PARTICIPANT_ROLE_CALLEE = 2;
    public static final int CALL_PARTICIPANT_ROLE_CALLER = 1;
    public static final int CALL_PARTICIPANT_ROLE_UNKNOWN = 0;
    public static final int CALL_PARTICIPANT_TYPE_C2C = 1;
    public static final int CALL_PARTICIPANT_TYPE_GROUP = 2;
    public static final int CALL_PARTICIPANT_TYPE_UNKNOWN = 0;
    public static final int CALL_PROTOCOL_TYPE_ACCEPT = 2;
    public static final int CALL_PROTOCOL_TYPE_CANCEL = 4;
    public static final int CALL_PROTOCOL_TYPE_HANGUP = 5;
    public static final int CALL_PROTOCOL_TYPE_LINE_BUSY = 7;
    public static final int CALL_PROTOCOL_TYPE_REJECT = 3;
    public static final int CALL_PROTOCOL_TYPE_SEND = 1;
    public static final int CALL_PROTOCOL_TYPE_SWITCH_TO_AUDIO = 8;
    public static final int CALL_PROTOCOL_TYPE_SWITCH_TO_AUDIO_COMFIRM = 9;
    public static final int CALL_PROTOCOL_TYPE_TIMEOUT = 6;
    public static final int CALL_PROTOCOL_TYPE_UNKNOWN = 0;
    public static final int CALL_STREAM_MEDIA_TYPE_UNKNOWN = 0;
    public static final int CALL_STREAM_MEDIA_TYPE_VIDEO = 2;
    public static final int CALL_STREAM_MEDIA_TYPE_VOICE = 1;
    public static final int CHAT_CALLING_MESSAGE_APPEARANCE_DETAILS = 0;
    public static final int CHAT_CALLING_MESSAGE_APPEARANCE_SIMPLIFY = 1;
    private static final String TAG = CallModel.class.getSimpleName();
    private V2TIMMessage innerMessage;
    private Map jsonData;
    private V2TIMSignalingInfo signalingInfo;
    public int style = 1;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.qcloud.tuikit.tuichat.bean.CallModel convert2VideoCallData(com.tencent.imsdk.v2.V2TIMMessage r8) {
        /*
            com.tencent.imsdk.v2.V2TIMSignalingManager r0 = com.tencent.imsdk.v2.V2TIMManager.getSignalingManager()
            com.tencent.imsdk.v2.V2TIMSignalingInfo r0 = r0.getSignalingInfo(r8)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            r2 = 0
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            com.google.gson.Gson r3 = new com.google.gson.Gson
            r3.<init>()
            java.lang.String r4 = r0.getData()     // Catch:{ JsonSyntaxException -> 0x002c }
            java.lang.Class<java.util.HashMap> r5 = java.util.HashMap.class
            java.lang.Object r3 = r3.fromJson((java.lang.String) r4, r5)     // Catch:{ JsonSyntaxException -> 0x002c }
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ JsonSyntaxException -> 0x002c }
            if (r3 == 0) goto L_0x0034
            java.lang.String r4 = "businessID"
            java.lang.Object r4 = r3.get(r4)     // Catch:{ JsonSyntaxException -> 0x002d }
            goto L_0x0035
        L_0x002c:
            r3 = r1
        L_0x002d:
            java.lang.String r4 = TAG
            java.lang.String r5 = " get signalingInfoCustomJsonMap error "
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.e(r4, r5)
        L_0x0034:
            r4 = r1
        L_0x0035:
            boolean r5 = r4 instanceof java.lang.String
            if (r5 == 0) goto L_0x003c
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0044
        L_0x003c:
            boolean r5 = r4 instanceof java.lang.Double
            if (r5 == 0) goto L_0x0043
            r2 = r4
            java.lang.Double r2 = (java.lang.Double) r2
        L_0x0043:
            r4 = r1
        L_0x0044:
            java.lang.String r5 = "av_call"
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            if (r4 != 0) goto L_0x0065
            double r4 = r2.doubleValue()
            java.lang.Double r2 = com.tencent.qcloud.tuicore.TUIConstants.TUICalling.CALL_TIMEOUT_BUSINESS_ID
            double r6 = r2.doubleValue()
            double r4 = r4 - r6
            double r4 = java.lang.Math.abs(r4)
            r6 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0065
            return r1
        L_0x0065:
            com.tencent.qcloud.tuikit.tuichat.bean.CallModel r1 = new com.tencent.qcloud.tuikit.tuichat.bean.CallModel
            r1.<init>()
            r1.jsonData = r3
            r1.signalingInfo = r0
            r1.innerMessage = r8
            r8 = 1
            r1.style = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.bean.CallModel.convert2VideoCallData(com.tencent.imsdk.v2.V2TIMMessage):com.tencent.qcloud.tuikit.tuichat.bean.CallModel");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if ((r0 instanceof java.lang.String) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCaller() {
        /*
            r2 = this;
            java.util.Map r0 = r2.jsonData
            java.lang.String r1 = "data"
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x001f
            java.lang.String r1 = "inviter"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x001f
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            if (r0 != 0) goto L_0x002a
            com.tencent.imsdk.v2.V2TIMManager r0 = com.tencent.imsdk.v2.V2TIMManager.getInstance()
            java.lang.String r0 = r0.getLoginUser()
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.bean.CallModel.getCaller():java.lang.String");
    }

    public String getContent() {
        if (this.style == 1) {
            return getContentForSimplifyAppearance();
        }
        return getContentForDetailsAppearance();
    }

    public String getContentForDetailsAppearance() {
        String string;
        Context appContext = ServiceInitializer.getAppContext();
        int protocolType = getProtocolType();
        boolean z11 = getParticipantType() == 2;
        if (protocolType == 0) {
            return appContext.getString(R.string.invalid_command);
        }
        String string2 = appContext.getString(R.string.invalid_command);
        String displayName = getDisplayName();
        if (protocolType == 1) {
            if (z11) {
                string = "\"" + displayName + "\"" + appContext.getString(R.string.start_group_call);
            } else {
                string = appContext.getString(R.string.start_call);
            }
        } else if (protocolType == 2) {
            if (z11) {
                string = "\"" + displayName + "\"" + appContext.getString(R.string.accept_call);
            } else {
                string = appContext.getString(R.string.accept_call);
            }
        } else if (protocolType == 3) {
            if (z11) {
                string = "\"" + displayName + "\"" + appContext.getString(R.string.reject_group_calls);
            } else {
                string = appContext.getString(R.string.reject_calls);
            }
        } else if (protocolType == 4) {
            string = appContext.getString(z11 ? R.string.cancle_group_call : R.string.cancle_call);
        } else if (protocolType == 5) {
            int parseInt = Integer.parseInt(String.valueOf(this.jsonData.get("call_end")));
            if (z11) {
                string = appContext.getString(R.string.stop_group_call);
            } else {
                string = appContext.getString(R.string.stop_call_tip) + DateTimeUtil.formatSecondsTo00(parseInt);
            }
        } else if (protocolType == 6) {
            StringBuilder sb2 = new StringBuilder();
            if (z11) {
                for (String append : this.signalingInfo.getInviteeList()) {
                    sb2.append("\"");
                    sb2.append(append);
                    sb2.append("\"、");
                }
                if (sb2.length() > 0) {
                    sb2.delete(sb2.length() - 1, sb2.length());
                }
            }
            sb2.append(appContext.getString(R.string.no_response_call));
            return sb2.toString();
        } else if (protocolType == 7) {
            if (z11) {
                string = "\"" + displayName + "\"" + appContext.getString(R.string.line_busy);
            } else {
                string = appContext.getString(R.string.other_line_busy);
            }
        } else if (protocolType == 8) {
            return appContext.getString(R.string.chat_calling_switch_to_audio);
        } else {
            return protocolType == 9 ? appContext.getString(R.string.chat_calling_switch_to_audio_accept) : string2;
        }
        return string;
    }

    public String getContentForSimplifyAppearance() {
        if (isExcludeFromHistory()) {
            return null;
        }
        getParticipantType();
        int protocolType = getProtocolType();
        boolean z11 = getParticipantRole() == 1;
        Context appContext = ServiceInitializer.getAppContext();
        String displayName = getDisplayName();
        if (getParticipantType() == 1) {
            if (protocolType == 3) {
                return appContext.getString(z11 ? R.string.chat_call_reject_caller : R.string.chat_call_reject_callee);
            } else if (protocolType == 4) {
                return appContext.getString(z11 ? R.string.chat_call_cancel_caller : R.string.chat_call_cancel_callee);
            } else if (protocolType == 5) {
                double parseDouble = Double.parseDouble(String.valueOf(this.jsonData.get("call_end")));
                return appContext.getString(R.string.stop_call_tip) + DateTimeUtil.formatSecondsTo00((int) parseDouble);
            } else if (protocolType == 6) {
                return appContext.getString(z11 ? R.string.chat_call_timeout_caller : R.string.chat_call_timeout_callee);
            } else if (protocolType == 7) {
                return appContext.getString(z11 ? R.string.chat_call_line_busy_caller : R.string.chat_call_line_busy_callee);
            } else if (protocolType == 1) {
                return appContext.getString(R.string.start_call);
            } else {
                if (protocolType == 2) {
                    return appContext.getString(R.string.accept_call);
                }
                if (protocolType == 8) {
                    return appContext.getString(R.string.chat_calling_switch_to_audio);
                }
                if (protocolType == 9) {
                    return appContext.getString(R.string.chat_calling_switch_to_audio_accept);
                }
                return appContext.getString(R.string.invalid_command);
            }
        } else if (getParticipantType() != 2) {
            return appContext.getString(R.string.invalid_command);
        } else {
            if (protocolType == 1) {
                return "\"" + displayName + "\"" + appContext.getString(R.string.chat_group_call_send);
            } else if (protocolType == 4) {
                return appContext.getString(R.string.chat_group_call_end);
            } else {
                if (protocolType == 5) {
                    return appContext.getString(R.string.chat_group_call_end);
                }
                if (protocolType == 6 || protocolType == 7) {
                    StringBuilder sb2 = new StringBuilder();
                    if (getParticipantType() == 2) {
                        for (String append : this.signalingInfo.getInviteeList()) {
                            sb2.append("\"");
                            sb2.append(append);
                            sb2.append("\"、");
                        }
                        if (sb2.length() > 0) {
                            sb2.delete(sb2.length() - 1, sb2.length());
                        }
                    }
                    sb2.append(appContext.getString(R.string.chat_group_call_no_answer));
                    return sb2.toString();
                } else if (protocolType == 3) {
                    return appContext.getString(R.string.chat_group_call_reject_format, new Object[]{displayName});
                } else if (protocolType == 2) {
                    return appContext.getString(R.string.chat_group_call_accept_format, new Object[]{displayName});
                } else if (protocolType == 8) {
                    return appContext.getString(R.string.chat_group_call_switch_to_audio_format, new Object[]{displayName});
                } else if (protocolType != 9) {
                    return appContext.getString(R.string.invalid_command);
                } else {
                    return appContext.getString(R.string.chat_group_call_confirm_switch_to_audio_format, new Object[]{displayName});
                }
            }
        }
    }

    public int getDirection() {
        if (this.style == 1) {
            return getDirectionForSimplifyAppearance();
        }
        return getDirectionForDetailsAppearance();
    }

    public int getDirectionForDetailsAppearance() {
        return this.innerMessage.isSelf() ? 1 : 0;
    }

    public int getDirectionForSimplifyAppearance() {
        return getParticipantRole() == 1 ? 1 : 0;
    }

    public String getDisplayName() {
        V2TIMMessage v2TIMMessage = this.innerMessage;
        if (v2TIMMessage == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMMessage.getNameCard())) {
            return this.innerMessage.getNameCard();
        }
        if (!TextUtils.isEmpty(this.innerMessage.getFriendRemark())) {
            return this.innerMessage.getFriendRemark();
        }
        if (!TextUtils.isEmpty(this.innerMessage.getNickName())) {
            return this.innerMessage.getNickName();
        }
        return this.innerMessage.getSender();
    }

    public int getParticipantRole() {
        return TextUtils.equals(getCaller(), V2TIMManager.getInstance().getLoginUser()) ? 1 : 2;
    }

    public int getParticipantType() {
        if (getProtocolType() == 0) {
            return 0;
        }
        return this.signalingInfo.getGroupID().length() > 0 ? 2 : 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        if (r10.jsonData.containsKey("call_end") != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getProtocolType() {
        /*
            r10 = this;
            java.util.Map r0 = r10.jsonData
            r1 = 0
            if (r0 == 0) goto L_0x00ab
            com.tencent.imsdk.v2.V2TIMSignalingInfo r0 = r10.signalingInfo
            if (r0 == 0) goto L_0x00ab
            com.tencent.imsdk.v2.V2TIMMessage r2 = r10.innerMessage
            if (r2 != 0) goto L_0x000f
            goto L_0x00ab
        L_0x000f:
            int r0 = r0.getActionType()
            java.lang.String r2 = "switchToAudio"
            java.lang.String r3 = "calling protocol error, invalid cmd"
            java.lang.String r4 = "cmd"
            java.lang.String r5 = "data"
            r6 = 4
            r7 = 3
            r8 = 5
            r9 = 1
            if (r0 == r9) goto L_0x0063
            r9 = 2
            if (r0 == r9) goto L_0x0061
            if (r0 == r7) goto L_0x003f
            if (r0 == r6) goto L_0x002f
            if (r0 == r8) goto L_0x002c
            goto L_0x00ab
        L_0x002c:
            r1 = 6
            goto L_0x00ab
        L_0x002f:
            java.util.Map r0 = r10.jsonData
            java.lang.String r1 = "line_busy"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x003c
            r1 = 7
            goto L_0x00ab
        L_0x003c:
            r1 = r7
            goto L_0x00ab
        L_0x003f:
            java.util.Map r0 = r10.jsonData
            java.lang.Object r0 = r0.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x005a
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x005f
            r9 = 9
            goto L_0x005f
        L_0x005a:
            java.lang.String r0 = TAG
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.e(r0, r3)
        L_0x005f:
            r1 = r9
            goto L_0x00ab
        L_0x0061:
            r1 = r6
            goto L_0x00ab
        L_0x0063:
            java.util.Map r0 = r10.jsonData
            java.lang.Object r0 = r0.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r0 = r0.get(r4)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x009a
            boolean r2 = android.text.TextUtils.equals(r0, r2)
            if (r2 == 0) goto L_0x007e
            r1 = 8
            goto L_0x00ab
        L_0x007e:
            java.lang.String r2 = "hangup"
            boolean r2 = android.text.TextUtils.equals(r0, r2)
            if (r2 == 0) goto L_0x0088
        L_0x0086:
            r1 = r8
            goto L_0x00ab
        L_0x0088:
            java.lang.String r2 = "videoCall"
            boolean r2 = android.text.TextUtils.equals(r0, r2)
            if (r2 == 0) goto L_0x0091
            goto L_0x005f
        L_0x0091:
            java.lang.String r2 = "audioCall"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x00ab
            goto L_0x005f
        L_0x009a:
            java.lang.String r0 = TAG
            com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog.e(r0, r3)
            goto L_0x00ab
        L_0x00a0:
            java.util.Map r0 = r10.jsonData
            java.lang.String r1 = "call_end"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x005f
            goto L_0x0086
        L_0x00ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuichat.bean.CallModel.getProtocolType():int");
    }

    public int getStreamMediaType() {
        String str;
        int i11 = 0;
        if (getProtocolType() == 0) {
            return 0;
        }
        if (this.jsonData.containsKey(TUIConstants.Message.CALLING_TYPE_KEY)) {
            double doubleValue = ((Double) this.jsonData.get(TUIConstants.Message.CALLING_TYPE_KEY)).doubleValue();
            if (doubleValue == 1.0d) {
                i11 = 1;
            } else if (doubleValue == 2.0d) {
                i11 = 2;
            }
        }
        int protocolType = getProtocolType();
        if (protocolType == 1) {
            Map map = (Map) this.jsonData.get("data");
            if (!(map == null || (str = (String) map.get(Constants.MQTT_STATISTISC_MSGTYPE_KEY)) == null)) {
                if (TextUtils.equals(str, "audioCall")) {
                    return 1;
                }
                if (TextUtils.equals(str, "videoCall")) {
                    return 2;
                }
            }
        } else if (protocolType == 8 || protocolType == 9) {
            return 2;
        }
        return i11;
    }

    public boolean isExcludeFromHistory() {
        if (this.style != 1 || getProtocolType() == 0 || !this.innerMessage.isExcludedFromLastMessage() || !this.innerMessage.isExcludedFromUnreadCount()) {
            return false;
        }
        return true;
    }

    public boolean isShowUnreadPoint() {
        if (isExcludeFromHistory() || this.innerMessage.getLocalCustomInt() != 0 || getParticipantRole() != 2 || getParticipantType() != 1) {
            return false;
        }
        if (getProtocolType() == 4 || getProtocolType() == 6 || getProtocolType() == 7) {
            return true;
        }
        return false;
    }

    public boolean isUseReceiverAvatar() {
        if (this.style == 1) {
            return isUseReceiverAvatarForSimplifyAppearance();
        }
        return isUseReceiverAvatarForDetailsAppearance();
    }

    public boolean isUseReceiverAvatarForDetailsAppearance() {
        return false;
    }

    public boolean isUseReceiverAvatarForSimplifyAppearance() {
        if (getDirection() == 1) {
            return !this.innerMessage.isSelf();
        }
        return this.innerMessage.isSelf();
    }

    public void setInnerMessage(V2TIMMessage v2TIMMessage) {
        this.innerMessage = v2TIMMessage;
    }

    public void setJsonData(Map map) {
        this.jsonData = map;
    }

    public void setSignalingInfo(V2TIMSignalingInfo v2TIMSignalingInfo) {
        this.signalingInfo = v2TIMSignalingInfo;
    }
}

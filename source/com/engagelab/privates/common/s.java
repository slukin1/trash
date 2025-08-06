package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import com.engagelab.privates.push.api.TagMessage;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huobi.finance.bean.FinanceRecordItem;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class s extends p {

    /* renamed from: c  reason: collision with root package name */
    public static volatile s f64979c;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Integer, String[]> f64980b = new ConcurrentHashMap<>();

    public static s b() {
        if (f64979c == null) {
            synchronized (s.class) {
                f64979c = new s();
            }
        }
        return f64979c;
    }

    public final int a(int i11) {
        switch (i11) {
            case MTPushConstants.RemoteWhat.TAG_QUERY_ALL /*3984*/:
                return MTPushConstants.MainWhat.TAG_QUERY_ALL;
            case MTPushConstants.RemoteWhat.TAG_DELETE_ALL /*3985*/:
                return MTPushConstants.MainWhat.TAG_DELETE_ALL;
            case MTPushConstants.RemoteWhat.TAG_QUERY /*3986*/:
                return MTPushConstants.MainWhat.TAG_QUERY;
            case MTPushConstants.RemoteWhat.TAG_UPDATE /*3987*/:
                return MTPushConstants.MainWhat.TAG_UPDATE;
            case MTPushConstants.RemoteWhat.TAG_DELETE /*3988*/:
                return MTPushConstants.MainWhat.TAG_DELETE;
            case MTPushConstants.RemoteWhat.TAG_ADD /*3989*/:
                return MTPushConstants.MainWhat.TAG_ADD;
            default:
                return 0;
        }
    }

    public void a(Context context, int i11, Bundle bundle) {
        MTCommonReceiver commonReceiver;
        try {
            bundle.setClassLoader(TagMessage.class.getClassLoader());
            TagMessage tagMessage = (TagMessage) bundle.getParcelable("tag");
            if (tagMessage != null && (commonReceiver = MTGlobal.getCommonReceiver(context)) != null) {
                switch (i11) {
                    case MTPushConstants.MainWhat.TAG_ADD /*3011*/:
                    case MTPushConstants.MainWhat.TAG_DELETE /*3012*/:
                    case MTPushConstants.MainWhat.TAG_UPDATE /*3013*/:
                    case MTPushConstants.MainWhat.TAG_QUERY /*3014*/:
                    case MTPushConstants.MainWhat.TAG_DELETE_ALL /*3015*/:
                    case MTPushConstants.MainWhat.TAG_QUERY_ALL /*3016*/:
                        commonReceiver.onTagMessage(context, tagMessage);
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTTagBusiness", "processMainMessage failed " + th2.getMessage());
        }
    }

    public final String b(int i11) {
        switch (i11) {
            case MTPushConstants.RemoteWhat.TAG_QUERY_ALL /*3984*/:
                return "get";
            case MTPushConstants.RemoteWhat.TAG_DELETE_ALL /*3985*/:
                return "clean";
            case MTPushConstants.RemoteWhat.TAG_QUERY /*3986*/:
                return FinanceRecordItem.STATE_VALID;
            case MTPushConstants.RemoteWhat.TAG_UPDATE /*3987*/:
                return "set";
            case MTPushConstants.RemoteWhat.TAG_DELETE /*3988*/:
                return "del";
            case MTPushConstants.RemoteWhat.TAG_ADD /*3989*/:
                return "add";
            default:
                return "";
        }
    }

    public void a(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (mTProtocol != null) {
                int rid = (int) mTProtocol.getRid();
                this.f64980b.remove(Integer.valueOf(rid));
                TagMessage tags = new TagMessage().setSequence(rid).setCode(MTPushPrivatesApi.Code.TIMEOUT).setTags(this.f64980b.get(Integer.valueOf(rid)));
                MTCommonLog.d("MTTagBusiness", "onAliasOperationFailed sequence:" + rid + ", tagMessage:" + tags.toString());
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("tag", tags);
                MTCommonPrivatesApi.sendMessageToMainProcess(context, MTPushConstants.MainWhat.TAG_ADD, bundle2);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTTagBusiness", "onAliasOperationFailed failed " + th2.getMessage());
        }
    }

    public void b(Context context, int i11, Bundle bundle) {
        try {
            int i12 = bundle.getInt(MTPushConstants.Operation.KEY_SEQUENCE);
            String b11 = b(i11);
            int a11 = a(i11);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            jSONObject.put("op", b11);
            switch (i11) {
                case MTPushConstants.RemoteWhat.TAG_QUERY_ALL /*3984*/:
                    jSONObject.put("curr", 1);
                    break;
                case MTPushConstants.RemoteWhat.TAG_QUERY /*3986*/:
                    String string = bundle.getString("tag");
                    int a12 = a(string);
                    if (a12 == 0) {
                        this.f64980b.put(Integer.valueOf(i12), new String[]{string});
                        jSONObject.put(InnerShareParams.TAGS, string);
                        break;
                    } else {
                        TagMessage queryTag = new TagMessage().setSequence(i12).setCode(a12).setQueryTag(string);
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("tag", queryTag);
                        MTCommonPrivatesApi.sendMessageToMainProcess(context, a11, bundle2);
                        return;
                    }
                case MTPushConstants.RemoteWhat.TAG_UPDATE /*3987*/:
                case MTPushConstants.RemoteWhat.TAG_DELETE /*3988*/:
                case MTPushConstants.RemoteWhat.TAG_ADD /*3989*/:
                    String[] stringArray = bundle.getStringArray("tag");
                    int a13 = a(stringArray);
                    if (a13 == 0) {
                        this.f64980b.put(Integer.valueOf(i12), stringArray);
                        jSONObject.put(InnerShareParams.TAGS, b(stringArray));
                        break;
                    } else {
                        TagMessage tags = new TagMessage().setSequence(i12).setCode(a13).setTags(stringArray);
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("tag", tags);
                        MTCommonPrivatesApi.sendMessageToMainProcess(context, a11, bundle3);
                        return;
                    }
            }
            MTCommonLog.d("MTTagBusiness", "sendAliasOperation sequence:" + i12 + ", content:" + MTCommonLog.toLogString(jSONObject));
            byte[] b12 = v.b(jSONObject.toString());
            if (b12 != null) {
                MTProtocol threadName = new MTProtocol().setRid((long) i12).setCommand(28).setVersion(1).setBody(b12).setThreadName("ENGAGELAB-PRIVATES-PUSH");
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, threadName);
                MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle4);
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTTagBusiness", "sendTagOperation failed " + th2.getMessage());
        }
    }

    public final int a(String[] strArr) {
        int a11 = a();
        if (a11 != 0) {
            return a11;
        }
        if (strArr.length > 1000) {
            return MTPushPrivatesApi.Code.TOO_MANY_TAGS;
        }
        int length = strArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            if (TextUtils.isEmpty(str)) {
                return MTPushPrivatesApi.Code.INVALID_TAGS;
            }
            if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
                return MTPushPrivatesApi.Code.INVALID_TAGS;
            }
            try {
                int length2 = str.getBytes("UTF-8").length;
                if (length2 > 40) {
                    return MTPushPrivatesApi.Code.TOO_LONG_TAG;
                }
                i12 += length2;
                i11++;
            } catch (Throwable th2) {
                MTCommonLog.w("MTTagBusiness", "getBytes failed " + th2.getMessage());
            }
        }
        if (i12 > 5000) {
            return MTPushPrivatesApi.Code.TOO_LONG_TAGS;
        }
        return 0;
    }

    public final int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return MTPushPrivatesApi.Code.INVALID_TAGS;
        }
        if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
            return MTPushPrivatesApi.Code.INVALID_TAGS;
        }
        try {
            if (str.getBytes("UTF-8").length > 40) {
                return MTPushPrivatesApi.Code.TOO_LONG_TAG;
            }
            return 0;
        } catch (Throwable th2) {
            MTCommonLog.w("MTTagBusiness", "getBytes failed " + th2.getMessage());
            return 0;
        }
    }

    public final String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            strArr[i11] = jSONArray.optString(i11);
        }
        return strArr;
    }

    public void b(Context context, Bundle bundle) {
        try {
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (mTProtocol != null) {
                int rid = (int) mTProtocol.getRid();
                JSONObject jSONObject = new JSONObject(StringUtil.getTlv2(ByteBuffer.wrap(mTProtocol.getBody())));
                MTCommonLog.d("MTTagBusiness", "onTagOperationSuccess sequence:" + rid + ", content:" + MTCommonLog.toLogString(jSONObject));
                int optInt = jSONObject.optInt("code");
                TagMessage code = new TagMessage().setSequence(rid).setCode(optInt);
                String optString = jSONObject.optString("op");
                int b11 = b(optString);
                char c11 = 65535;
                switch (optString.hashCode()) {
                    case 96417:
                        if (optString.equals("add")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 99339:
                        if (optString.equals("del")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 102230:
                        if (optString.equals("get")) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case 113762:
                        if (optString.equals("set")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 94746185:
                        if (optString.equals("clean")) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 111972348:
                        if (optString.equals(FinanceRecordItem.STATE_VALID)) {
                            c11 = 3;
                            break;
                        }
                        break;
                }
                if (c11 == 0 || c11 == 1 || c11 == 2) {
                    this.f64980b.remove(Integer.valueOf(rid));
                    code.setTags(this.f64980b.get(Integer.valueOf(rid)));
                } else if (c11 == 3) {
                    String str = this.f64980b.get(Integer.valueOf(rid))[0];
                    this.f64980b.remove(Integer.valueOf(rid));
                    code.setQueryTag(str).setQueryTagValid(jSONObject.optBoolean("validated"));
                } else if (c11 == 5) {
                    Context context2 = context;
                    code = a(context2, optInt, rid, jSONObject.optInt("curr"), jSONObject.optInt("total"), a(jSONObject.optJSONArray(InnerShareParams.TAGS)));
                }
                if (code != null) {
                    MTCommonLog.d("MTTagBusiness", "onTagOperationSuccess tagMessage:" + code.toString());
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("tag", code);
                    MTCommonPrivatesApi.sendMessageToMainProcess(context, b11, bundle2);
                }
            }
        } catch (Throwable th2) {
            MTCommonLog.w("MTTagBusiness", "onTagOperationSuccess failed " + th2.getMessage());
        }
    }

    public final TagMessage a(Context context, int i11, int i12, int i13, int i14, String[] strArr) {
        if (!(i14 == 0 || i13 == 0)) {
            try {
                if (this.f64980b.containsKey(Integer.valueOf(i12))) {
                    String[] strArr2 = this.f64980b.get(Integer.valueOf(i12));
                    String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + strArr2.length);
                    System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
                    strArr = strArr3;
                }
                if (i13 < i14) {
                    this.f64980b.put(Integer.valueOf(i12), strArr);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("platform", "a");
                    jSONObject.put("op", FinanceRecordItem.STATE_VALID);
                    jSONObject.put("curr", i13 + 1);
                    String jSONObject2 = jSONObject.toString();
                    MTCommonLog.d("MTTagBusiness", "sendTagOperation sequence:" + i12 + ", content:" + MTCommonLog.toLogString(jSONObject));
                    MTProtocol threadName = new MTProtocol().setRid((long) i12).setCommand(28).setVersion(1).setBody(v.b(jSONObject2)).setThreadName("ENGAGELAB-PRIVATES-PUSH");
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, threadName);
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.UPLOAD, bundle);
                    return null;
                }
                this.f64980b.remove(Integer.valueOf(i12));
                return new TagMessage().setSequence(i12).setCode(i11).setTags(strArr);
            } catch (Throwable th2) {
                MTCommonLog.w("MTTagBusiness", "onTagQueryAll failed " + th2.getMessage());
            }
        }
        return null;
    }

    public final int b(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 96417:
                if (str.equals("add")) {
                    c11 = 0;
                    break;
                }
                break;
            case 99339:
                if (str.equals("del")) {
                    c11 = 1;
                    break;
                }
                break;
            case 102230:
                if (str.equals("get")) {
                    c11 = 2;
                    break;
                }
                break;
            case 113762:
                if (str.equals("set")) {
                    c11 = 3;
                    break;
                }
                break;
            case 94746185:
                if (str.equals("clean")) {
                    c11 = 4;
                    break;
                }
                break;
            case 111972348:
                if (str.equals(FinanceRecordItem.STATE_VALID)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return MTPushConstants.MainWhat.TAG_ADD;
            case 1:
                return MTPushConstants.MainWhat.TAG_DELETE;
            case 2:
                return MTPushConstants.MainWhat.TAG_QUERY_ALL;
            case 3:
                return MTPushConstants.MainWhat.TAG_UPDATE;
            case 4:
                return MTPushConstants.MainWhat.TAG_DELETE_ALL;
            case 5:
                return MTPushConstants.MainWhat.TAG_QUERY;
            default:
                return 0;
        }
    }

    public final JSONArray b(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }
}

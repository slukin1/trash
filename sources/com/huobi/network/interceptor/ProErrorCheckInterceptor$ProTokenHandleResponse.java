package com.huobi.network.interceptor;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.huobi.network.interceptor.BaseTokenErrorCheckInterceptor;

public class ProErrorCheckInterceptor$ProTokenHandleResponse extends BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse {
    private static final long serialVersionUID = 5913587566679015928L;
    @SerializedName("code")
    private int code;
    @SerializedName(alternate = {"err_code"}, value = "err-code")
    private String errCode;
    @SerializedName(alternate = {"err_msg"}, value = "err-msg")
    private String errMsg;
    private String message;
    private String status;
    @SerializedName("success")
    private boolean success;

    private boolean isHbgGroup() {
        return this.code != 0;
    }

    public String getErrCode() {
        if (isHbgGroup()) {
            return String.valueOf(this.code);
        }
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        if (isHbgGroup()) {
            return this.success;
        }
        if (TextUtils.isEmpty(this.status)) {
            return false;
        }
        if (this.status.equalsIgnoreCase(BaseHbgResponse.STATUS_OK) || this.status.equals("0")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r1.equals("token-not-valid") == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bd, code lost:
        if (r1.equals("10001") == false) goto L_0x00a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isTokenError() {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = r0.status
            boolean r1 = i6.m.a0(r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = r0.status
            int r1 = i6.m.k0(r1)
            r4 = -9
            if (r1 == r4) goto L_0x00fd
            r4 = -7
            if (r1 == r4) goto L_0x00fd
            r4 = 10001(0x2711, float:1.4014E-41)
            if (r1 == r4) goto L_0x00fd
            r4 = 10017(0x2721, float:1.4037E-41)
            if (r1 == r4) goto L_0x00fd
            goto L_0x00fe
        L_0x0023:
            java.lang.String r1 = r0.errCode
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r4 = 6
            java.lang.String r5 = "token-not-valid"
            r6 = 5
            java.lang.String r7 = "token-not-exist"
            r8 = 4
            java.lang.String r9 = "10001"
            r10 = 3
            java.lang.String r11 = "555"
            r12 = 2
            java.lang.String r13 = "login-required"
            java.lang.String r14 = "uc-invalid-identity"
            java.lang.String r15 = "login-failed"
            r16 = -1
            if (r1 != 0) goto L_0x0090
            java.lang.String r1 = r0.errCode
            r1.hashCode()
            int r17 = r1.hashCode()
            switch(r17) {
                case -1970694367: goto L_0x0083;
                case -1820299981: goto L_0x007a;
                case -825293437: goto L_0x0071;
                case 52629: goto L_0x0068;
                case 46730162: goto L_0x005f;
                case 1452062889: goto L_0x0056;
                case 1467080110: goto L_0x004f;
                default: goto L_0x004c;
            }
        L_0x004c:
            r4 = r16
            goto L_0x008b
        L_0x004f:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x008b
            goto L_0x004c
        L_0x0056:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x005d
            goto L_0x004c
        L_0x005d:
            r4 = r6
            goto L_0x008b
        L_0x005f:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0066
            goto L_0x004c
        L_0x0066:
            r4 = r8
            goto L_0x008b
        L_0x0068:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x006f
            goto L_0x004c
        L_0x006f:
            r4 = r10
            goto L_0x008b
        L_0x0071:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x0078
            goto L_0x004c
        L_0x0078:
            r4 = r12
            goto L_0x008b
        L_0x007a:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x0081
            goto L_0x004c
        L_0x0081:
            r4 = r3
            goto L_0x008b
        L_0x0083:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x008a
            goto L_0x004c
        L_0x008a:
            r4 = r2
        L_0x008b:
            switch(r4) {
                case 0: goto L_0x00fd;
                case 1: goto L_0x00fd;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00fd;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00fd;
                case 6: goto L_0x00fd;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x00fe
        L_0x0090:
            int r1 = r0.code
            if (r1 == 0) goto L_0x00fe
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r1.hashCode()
            int r17 = r1.hashCode()
            switch(r17) {
                case -1970694367: goto L_0x00f1;
                case -1820299981: goto L_0x00e8;
                case -825293437: goto L_0x00df;
                case 52502: goto L_0x00d4;
                case 52629: goto L_0x00cb;
                case 1507426: goto L_0x00c0;
                case 46730162: goto L_0x00b9;
                case 1452062889: goto L_0x00b0;
                case 1467080110: goto L_0x00a6;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            r4 = r16
            goto L_0x00f9
        L_0x00a6:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x00ad
            goto L_0x00a2
        L_0x00ad:
            r4 = 8
            goto L_0x00f9
        L_0x00b0:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00b7
            goto L_0x00a2
        L_0x00b7:
            r4 = 7
            goto L_0x00f9
        L_0x00b9:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00f9
            goto L_0x00a2
        L_0x00c0:
            java.lang.String r4 = "1003"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00c9
            goto L_0x00a2
        L_0x00c9:
            r4 = r6
            goto L_0x00f9
        L_0x00cb:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x00d2
            goto L_0x00a2
        L_0x00d2:
            r4 = r8
            goto L_0x00f9
        L_0x00d4:
            java.lang.String r4 = "512"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00dd
            goto L_0x00a2
        L_0x00dd:
            r4 = r10
            goto L_0x00f9
        L_0x00df:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x00e6
            goto L_0x00a2
        L_0x00e6:
            r4 = r12
            goto L_0x00f9
        L_0x00e8:
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00ef
            goto L_0x00a2
        L_0x00ef:
            r4 = r3
            goto L_0x00f9
        L_0x00f1:
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x00f8
            goto L_0x00a2
        L_0x00f8:
            r4 = r2
        L_0x00f9:
            switch(r4) {
                case 0: goto L_0x00fd;
                case 1: goto L_0x00fd;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00fd;
                case 4: goto L_0x00fd;
                case 5: goto L_0x00fd;
                case 6: goto L_0x00fd;
                case 7: goto L_0x00fd;
                case 8: goto L_0x00fd;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            goto L_0x00fe
        L_0x00fd:
            r2 = r3
        L_0x00fe:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.network.interceptor.ProErrorCheckInterceptor$ProTokenHandleResponse.isTokenError():boolean");
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}

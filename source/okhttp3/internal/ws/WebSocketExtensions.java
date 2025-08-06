package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Headers;
import okhttp3.internal.Util;

public final class WebSocketExtensions {
    public static final Companion Companion = new Companion((r) null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final WebSocketExtensions parse(Headers headers) throws IOException {
            Headers headers2 = headers;
            int size = headers.size();
            boolean z11 = false;
            Integer num = null;
            boolean z12 = false;
            Integer num2 = null;
            boolean z13 = false;
            boolean z14 = false;
            for (int i11 = 0; i11 < size; i11++) {
                if (StringsKt__StringsJVMKt.w(headers2.name(i11), "Sec-WebSocket-Extensions", true)) {
                    String value = headers2.value(i11);
                    int i12 = 0;
                    while (i12 < value.length()) {
                        int delimiterOffset$default = Util.delimiterOffset$default(value, ',', i12, 0, 4, (Object) null);
                        int delimiterOffset = Util.delimiterOffset(value, ';', i12, delimiterOffset$default);
                        String trimSubstring = Util.trimSubstring(value, i12, delimiterOffset);
                        int i13 = delimiterOffset + 1;
                        if (StringsKt__StringsJVMKt.w(trimSubstring, "permessage-deflate", true)) {
                            if (z11) {
                                z14 = true;
                            }
                            i12 = i13;
                            while (i12 < delimiterOffset$default) {
                                int delimiterOffset2 = Util.delimiterOffset(value, ';', i12, delimiterOffset$default);
                                int delimiterOffset3 = Util.delimiterOffset(value, '=', i12, delimiterOffset2);
                                String trimSubstring2 = Util.trimSubstring(value, i12, delimiterOffset3);
                                String D0 = delimiterOffset3 < delimiterOffset2 ? StringsKt__StringsKt.D0(Util.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"") : null;
                                i12 = delimiterOffset2 + 1;
                                if (StringsKt__StringsJVMKt.w(trimSubstring2, "client_max_window_bits", true)) {
                                    if (num != null) {
                                        z14 = true;
                                    }
                                    num = D0 != null ? StringsKt__StringNumberConversionsKt.m(D0) : null;
                                    if (num != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.w(trimSubstring2, "client_no_context_takeover", true)) {
                                    if (z12) {
                                        z14 = true;
                                    }
                                    if (D0 != null) {
                                        z14 = true;
                                    }
                                    z12 = true;
                                } else if (StringsKt__StringsJVMKt.w(trimSubstring2, "server_max_window_bits", true)) {
                                    if (num2 != null) {
                                        z14 = true;
                                    }
                                    num2 = D0 != null ? StringsKt__StringNumberConversionsKt.m(D0) : null;
                                    if (num2 != null) {
                                    }
                                } else if (StringsKt__StringsJVMKt.w(trimSubstring2, "server_no_context_takeover", true)) {
                                    if (z13) {
                                        z14 = true;
                                    }
                                    if (D0 != null) {
                                        z14 = true;
                                    }
                                    z13 = true;
                                }
                                z14 = true;
                            }
                            z11 = true;
                        } else {
                            i12 = i13;
                            z14 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
        }
    }

    public WebSocketExtensions() {
        this(false, (Integer) null, false, (Integer) null, false, false, 63, (r) null);
    }

    public WebSocketExtensions(boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14) {
        this.perMessageDeflate = z11;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z12;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z13;
        this.unknownValues = z14;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = webSocketExtensions.perMessageDeflate;
        }
        if ((i11 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            z12 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z15 = z12;
        if ((i11 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            z13 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z16 = z13;
        if ((i11 & 32) != 0) {
            z14 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z11, num3, z15, num4, z16, z14);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z11, Integer num, boolean z12, Integer num2, boolean z13, boolean z14) {
        return new WebSocketExtensions(z11, num, z12, num2, z13, z14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && x.b(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && x.b(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        boolean z11 = this.perMessageDeflate;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i12 = 0;
        int hashCode = (i11 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z13 = this.clientNoContextTakeover;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode + (z13 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i12 = num2.hashCode();
        }
        int i14 = (i13 + i12) * 31;
        boolean z14 = this.serverNoContextTakeover;
        if (z14) {
            z14 = true;
        }
        int i15 = (i14 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.unknownValues;
        if (!z15) {
            z12 = z15;
        }
        return i15 + (z12 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z11) {
        if (z11) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.r r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = r0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.r):void");
    }
}

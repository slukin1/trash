package com.huobi.edgeengine.ability;

import kotlin.jvm.internal.r;

public final class ClipBoardAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43883a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (sd.a.c(r6) == false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r5, java.lang.Object r6, com.huobi.edgeengine.ability.AbilityFunction.a r7) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L_0x0073
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            java.lang.Object r6 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r6, r0)
            java.util.Map r6 = (java.util.Map) r6
            if (r6 == 0) goto L_0x006a
            java.lang.String r0 = "content"
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r1 = "toast"
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r2 = "label"
            java.lang.Object r6 = r6.get(r2)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 == 0) goto L_0x0053
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = sd.a.c(r2)
            if (r2 != 0) goto L_0x0053
            android.content.Context r2 = r5.d()
            java.lang.String r3 = "clipboard"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.content.ClipboardManager r2 = (android.content.ClipboardManager) r2
            boolean r3 = r6 instanceof java.lang.String
            if (r3 == 0) goto L_0x0048
            java.lang.String r6 = (java.lang.String) r6
            boolean r3 = sd.a.c(r6)
            if (r3 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            java.lang.String r6 = ""
        L_0x004a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            android.content.ClipData r6 = android.content.ClipData.newPlainText(r6, r0)
            r2.setPrimaryClip(r6)
        L_0x0053:
            boolean r6 = r1 instanceof java.lang.String
            if (r6 == 0) goto L_0x006a
            java.lang.String r1 = (java.lang.String) r1
            boolean r6 = sd.a.c(r1)
            if (r6 != 0) goto L_0x006a
            if (r5 == 0) goto L_0x0066
            android.content.Context r5 = r5.d()
            goto L_0x0067
        L_0x0066:
            r5 = 0
        L_0x0067:
            com.hbg.lib.widgets.utils.HuobiToastUtil.q(r5, r1)
        L_0x006a:
            if (r7 == 0) goto L_0x007b
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r7.a(r5, r6)
            goto L_0x007b
        L_0x0073:
            if (r7 == 0) goto L_0x007b
            r5 = 0
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r7.a(r5, r6)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.ability.ClipBoardAbility.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }
}

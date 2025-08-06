package jp.wasabeef.glide.transformations.internal;

public class RSBlur {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.renderscript.RenderScript} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.Context r6, android.graphics.Bitmap r7, int r8) throws android.renderscript.RSRuntimeException {
        /*
            r0 = 23
            r1 = 0
            android.renderscript.RenderScript r6 = android.renderscript.RenderScript.create(r6)     // Catch:{ all -> 0x0056 }
            android.renderscript.RenderScript$RSMessageHandler r2 = new android.renderscript.RenderScript$RSMessageHandler     // Catch:{ all -> 0x0050 }
            r2.<init>()     // Catch:{ all -> 0x0050 }
            r6.setMessageHandler(r2)     // Catch:{ all -> 0x0050 }
            android.renderscript.Allocation$MipmapControl r2 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0050 }
            r3 = 1
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createFromBitmap(r6, r7, r2, r3)     // Catch:{ all -> 0x0050 }
            android.renderscript.Type r3 = r2.getType()     // Catch:{ all -> 0x004d }
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createTyped(r6, r3)     // Catch:{ all -> 0x004d }
            android.renderscript.Element r4 = android.renderscript.Element.U8_4(r6)     // Catch:{ all -> 0x0048 }
            android.renderscript.ScriptIntrinsicBlur r1 = android.renderscript.ScriptIntrinsicBlur.create(r6, r4)     // Catch:{ all -> 0x0048 }
            r1.setInput(r2)     // Catch:{ all -> 0x0048 }
            float r8 = (float) r8     // Catch:{ all -> 0x0048 }
            r1.setRadius(r8)     // Catch:{ all -> 0x0048 }
            r1.forEach(r3)     // Catch:{ all -> 0x0048 }
            r3.copyTo(r7)     // Catch:{ all -> 0x0048 }
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r0) goto L_0x003b
            android.renderscript.RenderScript.releaseAllContexts()
            goto L_0x003e
        L_0x003b:
            r6.destroy()
        L_0x003e:
            r2.destroy()
            r3.destroy()
            r1.destroy()
            return r7
        L_0x0048:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x005a
        L_0x004d:
            r7 = move-exception
            r3 = r1
            goto L_0x0053
        L_0x0050:
            r7 = move-exception
            r2 = r1
            r3 = r2
        L_0x0053:
            r1 = r6
            r6 = r3
            goto L_0x005a
        L_0x0056:
            r7 = move-exception
            r6 = r1
            r2 = r6
            r3 = r2
        L_0x005a:
            if (r1 == 0) goto L_0x0067
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r0) goto L_0x0064
            android.renderscript.RenderScript.releaseAllContexts()
            goto L_0x0067
        L_0x0064:
            r1.destroy()
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.destroy()
        L_0x006c:
            if (r3 == 0) goto L_0x0071
            r3.destroy()
        L_0x0071:
            if (r6 == 0) goto L_0x0076
            r6.destroy()
        L_0x0076:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.internal.RSBlur.a(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}

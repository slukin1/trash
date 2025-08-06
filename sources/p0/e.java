package p0;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f16306a = new Object();

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|(2:37|38)|39|40) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r2 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0050, code lost:
        if (r2 == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        if (r1.isEmpty() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        r8.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0066 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0053=Splitter:B:29:0x0053, B:39:0x0066=Splitter:B:39:0x0066} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8) {
        /*
            java.lang.Object r0 = f16306a
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r8.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x0067 }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            int r4 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
        L_0x0018:
            int r5 = r3.next()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            r6 = 1
            if (r5 == r6) goto L_0x0041
            r6 = 3
            if (r5 != r6) goto L_0x0028
            int r7 = r3.getDepth()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            if (r7 <= r4) goto L_0x0041
        L_0x0028:
            if (r5 == r6) goto L_0x0018
            r6 = 4
            if (r5 != r6) goto L_0x002e
            goto L_0x0018
        L_0x002e:
            java.lang.String r5 = r3.getName()     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            java.lang.String r6 = "locales"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
            if (r5 == 0) goto L_0x0018
            r4 = 0
            java.lang.String r5 = "application_locales"
            java.lang.String r1 = r3.getAttributeValue(r4, r5)     // Catch:{ IOException | XmlPullParserException -> 0x0049 }
        L_0x0041:
            if (r2 == 0) goto L_0x0053
        L_0x0043:
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0047:
            r8 = move-exception
            goto L_0x0061
        L_0x0049:
            java.lang.String r3 = "AppLocalesStorageHelper"
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r3, r4)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0053
            goto L_0x0043
        L_0x0053:
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r8.deleteFile(r2)     // Catch:{ all -> 0x0069 }
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x0061:
            if (r2 == 0) goto L_0x0066
            r2.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            throw r8     // Catch:{ all -> 0x0069 }
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            return r1
        L_0x0069:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0069 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.a(android.content.Context):java.lang.String");
    }
}

package com.facebook.stetho.dumpapp.plugins;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.inspector.domstorage.SharedPreferencesHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SharedPreferencesDumperPlugin implements DumperPlugin {
    private static final String NAME = "prefs";
    private static final String XML_SUFFIX = ".xml";
    private final Context mAppContext;

    /* renamed from: com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type[] r0 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type = r0
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.INT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.LONG     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.STRING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin$Type r1 = com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.Type.SET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        BOOLEAN("boolean"),
        INT("int"),
        LONG("long"),
        FLOAT("float"),
        STRING("string"),
        SET("set");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        public static StringBuilder appendNamesList(StringBuilder sb2, String str) {
            boolean z11 = true;
            for (Type type : values()) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(str);
                }
                sb2.append(type.name);
            }
            return sb2;
        }

        public static Type of(String str) {
            for (Type type : values()) {
                if (type.name.equals(str)) {
                    return type;
                }
            }
            return null;
        }
    }

    public SharedPreferencesDumperPlugin(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    private void doPrint(PrintStream printStream, List<String> list) {
        String str;
        String str2 = this.mAppContext.getApplicationInfo().dataDir + "/shared_prefs";
        String str3 = list.isEmpty() ? "" : list.get(0);
        if (list.size() > 1) {
            str = list.get(1);
        } else {
            str = "";
        }
        printRecursive(printStream, str2, "", str3, str);
    }

    private void doUsage(PrintStream printStream) {
        printStream.println("Usage: dumpapp prefs " + "<command> [command-options]");
        printStream.println("Usage: dumpapp prefs " + "print [pathPrefix [keyPrefix]]");
        StringBuilder sb2 = new StringBuilder("       dumpapp prefs ");
        sb2.append("write <path> <key> <");
        StringBuilder appendNamesList = Type.appendNamesList(sb2, HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        appendNamesList.append("> <value>");
        printStream.println(appendNamesList);
        printStream.println();
        printStream.println("dumpapp prefs print: Print all matching values from the shared preferences");
        printStream.println();
        printStream.println("dumpapp prefs write: Writes a value to the shared preferences");
    }

    @SuppressLint({"CommitPrefEdits"})
    private void doWrite(List<String> list) throws DumpUsageException {
        Iterator<String> it2 = list.iterator();
        String nextArg = nextArg(it2, "Expected <path>");
        String nextArg2 = nextArg(it2, "Expected <key>");
        Type of2 = Type.of(nextArg(it2, "Expected <type>"));
        if (of2 != null) {
            SharedPreferences.Editor edit = getSharedPreferences(nextArg).edit();
            switch (AnonymousClass1.$SwitchMap$com$facebook$stetho$dumpapp$plugins$SharedPreferencesDumperPlugin$Type[of2.ordinal()]) {
                case 1:
                    edit.putBoolean(nextArg2, Boolean.valueOf(nextArgValue(it2)).booleanValue());
                    break;
                case 2:
                    edit.putInt(nextArg2, Integer.valueOf(nextArgValue(it2)).intValue());
                    break;
                case 3:
                    edit.putLong(nextArg2, Long.valueOf(nextArgValue(it2)).longValue());
                    break;
                case 4:
                    edit.putFloat(nextArg2, Float.valueOf(nextArgValue(it2)).floatValue());
                    break;
                case 5:
                    edit.putString(nextArg2, nextArgValue(it2));
                    break;
                case 6:
                    putStringSet(edit, nextArg2, it2);
                    break;
            }
            edit.commit();
            return;
        }
        throw new DumpUsageException(Type.appendNamesList(new StringBuilder("Usage: prefs write <path> <key> <type> <value>, where type is one of: "), ", ").toString());
    }

    private SharedPreferences getSharedPreferences(String str) {
        return this.mAppContext.getSharedPreferences(str, 4);
    }

    private static String nextArg(Iterator<String> it2, String str) throws DumpUsageException {
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new DumpUsageException(str);
    }

    private static String nextArgValue(Iterator<String> it2) throws DumpUsageException {
        return nextArg(it2, "Expected <value>");
    }

    private void printFile(PrintStream printStream, String str, String str2) {
        printStream.println(str + ":");
        for (Map.Entry next : SharedPreferencesHelper.getSharedPreferenceEntriesSorted(getSharedPreferences(str))) {
            if (((String) next.getKey()).startsWith(str2)) {
                printStream.println("  " + ((String) next.getKey()) + " = " + next.getValue());
            }
        }
    }

    private void printRecursive(PrintStream printStream, String str, String str2, String str3, String str4) {
        String[] list;
        String str5;
        File file = new File(str, str2);
        if (file.isFile()) {
            if (str2.endsWith(XML_SUFFIX)) {
                printFile(printStream, str2.substring(0, str2.length() - 4), str4);
            }
        } else if (file.isDirectory() && (list = file.list()) != null) {
            for (int i11 = 0; i11 < list.length; i11++) {
                if (TextUtils.isEmpty(str2)) {
                    str5 = list[i11];
                } else {
                    str5 = str2 + File.separator + list[i11];
                }
                String str6 = str5;
                if (str6.startsWith(str3)) {
                    printRecursive(printStream, str, str6, str3, str4);
                }
            }
        }
    }

    @TargetApi(11)
    private static void putStringSet(SharedPreferences.Editor editor, String str, Iterator<String> it2) {
        HashSet hashSet = new HashSet();
        while (it2.hasNext()) {
            hashSet.add(it2.next());
        }
        editor.putStringSet(str, hashSet);
    }

    public void dump(DumperContext dumperContext) throws DumpUsageException {
        PrintStream stdout = dumperContext.getStdout();
        List<String> argsAsList = dumperContext.getArgsAsList();
        String remove = argsAsList.isEmpty() ? "" : argsAsList.remove(0);
        if (remove.equals("print")) {
            doPrint(stdout, argsAsList);
        } else if (remove.equals("write")) {
            doWrite(argsAsList);
        } else {
            doUsage(stdout);
        }
    }

    public String getName() {
        return NAME;
    }
}

package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

public final class ApplicationInfoLoader {
    public static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME;
    public static final String PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY = "io.flutter.automatically-register-plugins";
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY;
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY;
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY;

    static {
        Class<FlutterLoader> cls = FlutterLoader.class;
        PUBLIC_AOT_SHARED_LIBRARY_NAME = cls.getName() + '.' + FlutterLoader.AOT_SHARED_LIBRARY_NAME;
        PUBLIC_VM_SNAPSHOT_DATA_KEY = cls.getName() + '.' + FlutterLoader.VM_SNAPSHOT_DATA_KEY;
        PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = cls.getName() + '.' + FlutterLoader.ISOLATE_SNAPSHOT_DATA_KEY;
        PUBLIC_FLUTTER_ASSETS_DIR_KEY = cls.getName() + '.' + FlutterLoader.FLUTTER_ASSETS_DIR_KEY;
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static boolean getBoolean(Bundle bundle, String str, boolean z11) {
        return bundle == null ? z11 : bundle.getBoolean(str, z11);
    }

    private static String getNetworkPolicy(ApplicationInfo applicationInfo, Context context) {
        int i11;
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i11 = bundle.getInt(NETWORK_POLICY_METADATA_KEY, 0)) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            XmlResourceParser xml = context.getResources().getXml(i11);
            xml.next();
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2 && xml.getName().equals("domain-config")) {
                    parseDomainConfig(xml, jSONArray, false);
                }
            }
            return jSONArray.toString();
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    private static String getString(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, (String) null);
    }

    public static FlutterApplicationInfo load(Context context) {
        ApplicationInfo applicationInfo = getApplicationInfo(context);
        return new FlutterApplicationInfo(getString(applicationInfo.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), getString(applicationInfo.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), getString(applicationInfo.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), getString(applicationInfo.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), getNetworkPolicy(applicationInfo, context), applicationInfo.nativeLibraryDir, getBoolean(applicationInfo.metaData, PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY, true));
    }

    private static void parseDomain(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z11) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "includeSubdomains", false);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() == 4) {
            String trim = xmlResourceParser.getText().trim();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(trim);
            jSONArray2.put(attributeBooleanValue);
            jSONArray2.put(z11);
            jSONArray.put(jSONArray2);
            xmlResourceParser.next();
            if (xmlResourceParser.getEventType() != 3) {
                throw new IllegalStateException("Expected end of domain tag");
            }
            return;
        }
        throw new IllegalStateException("Expected text");
    }

    private static void parseDomainConfig(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z11) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "cleartextTrafficPermitted", z11);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    parseDomain(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    parseDomainConfig(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    skipTag(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    private static void skipTag(XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType != 3 || xmlResourceParser.getName() != name) {
                eventType = xmlResourceParser.next();
            } else {
                return;
            }
        }
    }
}

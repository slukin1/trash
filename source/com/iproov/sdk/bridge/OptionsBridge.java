package com.iproov.sdk.bridge;

import android.content.Context;
import androidx.annotation.Keep;
import com.iproov.sdk.Cdo;
import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.InvalidOptionsException;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.Cif;
import java.util.List;
import org.json.JSONObject;

@Keep
public class OptionsBridge {
    public static final String CAMERA_KEY = "camera";
    public static final String CAPTURE_KEY = "capture";
    public static final String CERTIFICATES_KEY = "certificates";
    public static final String CLOSE_BUTTON_IMAGE_KEY = "close_button_image";
    public static final String CLOSE_BUTTON_IMAGE_RESOURCE_KEY = "close_button_image_resource";
    public static final String CLOSE_BUTTON_TINT_COLOR_KEY = "close_button_tint_color";
    public static final String CUSTOM_VALUE = "custom";
    public static final String DEFAULT_VALUE = "default";
    public static final String DISABLE_EXTERIOR_EFFECTS_KEY = "disable_exterior_effects";
    public static final String EMPTY_VALUE = "empty";
    public static final String ENABLE_SCREENSHOTS_KEY = "enable_screenshots";
    public static final String FACE_DETECTOR_KEY = "face_detector";
    public static final String FILTER_BACKGROUND_COLOR = "background_color";
    public static final String FILTER_FOREGROUND_COLOR = "foreground_color";
    public static final String FILTER_KEY = "filter";
    public static final String FILTER_LINE_DRAWING = "line_drawing";
    public static final String FILTER_NAME = "name";
    public static final String FILTER_NATURAL = "natural";
    public static final String FILTER_STYLE = "style";
    public static final String FONT_KEY = "font";
    public static final String FONT_PATH_KEY = "font_path";
    public static final String FONT_RESOURCE_KEY = "font_resource";
    public static final String GENUINE_PRESENCE_ASSURANCE_KEY = "genuine_presence_assurance";
    public static final String GPA_NOT_READY_OVAL_STROKE_COLOR_KEY = "not_ready_oval_stroke_color";
    public static final String GPA_READY_OVAL_STROKE_COLOR_KEY = "ready_oval_stroke_color";
    public static final String HEADER_BACKGROUND_COLOR_KEY = "header_background_color";
    public static final String LIVENESS_ASSURANCE_KEY = "liveness_assurance";
    public static final String LIVENESS_COMPLETED_OVAL_STROKE_COLOR_KEY = "completed_oval_stroke_color";
    public static final String LIVENESS_OVAL_STROKE_COLOR_KEY = "oval_stroke_color";
    public static final String LOGO_IMAGE_KEY = "logo_image";
    public static final String LOGO_IMAGE_RESOURCE_KEY = "logo_image_resource";
    public static final String LOGO_KEY = "logo";
    public static final String MAX_PITCH_KEY = "max_pitch";
    public static final String MAX_ROLL_KEY = "max_roll";
    public static final String MAX_YAW_KEY = "max_yaw";
    public static final String NETWORK_KEY = "network";
    public static final String NULL_VALUE = "null";
    public static final String ORIENTATION_KEY = "orientation";
    public static final String PROMPT_BACKGROUND_COLOR_KEY = "prompt_background_color";
    public static final String PROMPT_ROUNDED_CORNERS = "prompt_rounded_corners";
    public static final String PROMPT_TEXT_COLOR_KEY = "prompt_text_color";
    public static final String SURROUND_COLOR = "surround_color";
    private static final String TAG = "OptionsBridge";
    public static final String TIMEOUT_KEY = "timeout";
    public static final String TITLE_KEY = "title";
    public static final String TITLE_TEXT_COLOR_KEY = "title_text_color";
    public static final String UI_KEY = "ui";
    private static Cextends lazyDefaultSessionOptions;

    public static String asAnalytics(Object obj, Object obj2) {
        if (obj != null && obj.equals(obj2)) {
            return "default";
        }
        if (obj == null && obj2 == null) {
            return "default";
        }
        if ((obj instanceof List) && ((List) obj).isEmpty()) {
            return EMPTY_VALUE;
        }
        if (!(obj instanceof String) || !((String) obj).isEmpty()) {
            return obj == null ? NULL_VALUE : "custom";
        }
        return EMPTY_VALUE;
    }

    private static Cextends.Cif captureOptionsFromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        Cextends.Cif ifVar = defaultSessionOptions(context).m1477do();
        if (jSONObject == null) {
            return ifVar;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(GENUINE_PRESENCE_ASSURANCE_KEY);
        if (optJSONObject == null) {
            optJSONObject = jSONObject;
        }
        return new Cextends.Cif(Cif.m2255do(jSONObject, CAMERA_KEY, ifVar.m1515do()), Cif.m2258do(jSONObject, FACE_DETECTOR_KEY, ifVar.m1517if()), new Cextends.Cif.Cdo(Cif.m2244do(optJSONObject, MAX_YAW_KEY, ifVar.m1516for().m1519for()), Cif.m2244do(optJSONObject, MAX_ROLL_KEY, ifVar.m1516for().m1520if()), Cif.m2244do(optJSONObject, MAX_PITCH_KEY, ifVar.m1516for().m1518do())));
    }

    private static JSONObject captureToJsonForAnalytics(Cextends.Cif ifVar) {
        JSONObject jSONObject = new JSONObject();
        Cif.m2279if(jSONObject, CAMERA_KEY, ifVar.m1515do());
        Cif.m2280if(jSONObject, FACE_DETECTOR_KEY, ifVar.m1517if());
        JSONObject jSONObject2 = new JSONObject();
        Cif.m2276do(jSONObject2, MAX_YAW_KEY, (Object) Float.valueOf(ifVar.m1516for().m1519for()));
        Cif.m2276do(jSONObject2, MAX_ROLL_KEY, (Object) Float.valueOf(ifVar.m1516for().m1520if()));
        Cif.m2276do(jSONObject2, MAX_PITCH_KEY, (Object) Float.valueOf(ifVar.m1516for().m1518do()));
        Cif.m2276do(jSONObject, GENUINE_PRESENCE_ASSURANCE_KEY, (Object) jSONObject2);
        return jSONObject;
    }

    private static Cextends defaultSessionOptions(Context context) throws InvalidOptionsException {
        if (lazyDefaultSessionOptions == null) {
            lazyDefaultSessionOptions = Cdo.m557do(new IProov.Options(), context);
        }
        return lazyDefaultSessionOptions;
    }

    public static IProov.Options fromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        return Cdo.m542do(sessionOptionsFromJson(context, jSONObject));
    }

    private static Cextends.Cclass.Cdo genuinePresenceAssuranceUIOptionsFromJSON(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        JSONObject optJSONObject;
        Cextends.Cclass.Cdo doVar = defaultSessionOptions(context).m1478for().m1488case();
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(GENUINE_PRESENCE_ASSURANCE_KEY)) == null) {
            return doVar;
        }
        return new Cextends.Cclass.Cdo(Cif.m2246do(optJSONObject, GPA_READY_OVAL_STROKE_COLOR_KEY, doVar.m1504if()), Cif.m2246do(optJSONObject, GPA_NOT_READY_OVAL_STROKE_COLOR_KEY, doVar.m1503do()));
    }

    private static Cextends.Cclass.Cif livenessAssuranceUIOptionsFromJSON(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        JSONObject optJSONObject;
        Cextends.Cclass.Cif ifVar = defaultSessionOptions(context).m1478for().m1496goto();
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(LIVENESS_ASSURANCE_KEY)) == null) {
            return ifVar;
        }
        return new Cextends.Cclass.Cif(Cif.m2246do(optJSONObject, LIVENESS_OVAL_STROKE_COLOR_KEY, ifVar.m1506if()), Cif.m2246do(optJSONObject, LIVENESS_COMPLETED_OVAL_STROKE_COLOR_KEY, ifVar.m1505do()));
    }

    private static Cextends.Ccatch networkOptionsFromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        Cextends.Ccatch catchR = defaultSessionOptions(context).m1479if();
        if (jSONObject == null) {
            return catchR;
        }
        return new Cextends.Ccatch(Cif.m2269do(context, jSONObject, CERTIFICATES_KEY, catchR.m1485do()), jSONObject.optInt(TIMEOUT_KEY, catchR.m1486if()));
    }

    private static JSONObject networkToJsonForAnalytics(Context context, Cextends.Ccatch catchR) throws InvalidOptionsException {
        JSONObject jSONObject = new JSONObject();
        Cif.m2276do(jSONObject, CERTIFICATES_KEY, (Object) asAnalytics(catchR.m1485do(), defaultSessionOptions(context).m1479if().m1485do()));
        Cif.m2276do(jSONObject, TIMEOUT_KEY, (Object) Integer.valueOf(catchR.m1486if()));
        return jSONObject;
    }

    private static void putColorOrNullIfNull(JSONObject jSONObject, String str, Integer num) {
        if (num == null) {
            Cif.m2276do(jSONObject, str, (Object) NULL_VALUE);
        } else {
            Cif.m2281if(jSONObject, str, num);
        }
    }

    public static Cextends sessionOptionsFromJson(Context context, JSONObject jSONObject) throws InvalidOptionsException {
        if (jSONObject == null) {
            return defaultSessionOptions(context);
        }
        return new Cextends(uiOptionsFromJson(context, jSONObject), networkOptionsFromJson(context, jSONObject), captureOptionsFromJson(context, jSONObject));
    }

    public static JSONObject toJsonForAnalytics(Context context, Cextends extendsR) throws InvalidOptionsException {
        JSONObject jSONObject = new JSONObject();
        Cif.m2276do(jSONObject, UI_KEY, (Object) uiToJsonForAnalytics(context, extendsR.m1478for()));
        Cif.m2276do(jSONObject, CAPTURE_KEY, (Object) captureToJsonForAnalytics(extendsR.m1477do()));
        Cif.m2276do(jSONObject, NETWORK_KEY, (Object) networkToJsonForAnalytics(context, extendsR.m1479if()));
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.iproov.sdk.p026return.Cextends.Cclass uiOptionsFromJson(android.content.Context r24, org.json.JSONObject r25) throws com.iproov.sdk.core.exception.InvalidOptionsException {
        /*
            r0 = r25
            com.iproov.sdk.return.extends r1 = defaultSessionOptions(r24)
            com.iproov.sdk.return.extends$class r1 = r1.m1478for()
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.String r2 = "font"
            r3 = 0
            java.lang.String r4 = com.iproov.sdk.utils.Cif.m2268do((org.json.JSONObject) r0, (java.lang.String) r2, (java.lang.String) r3)
            r5 = -1
            if (r4 == 0) goto L_0x001e
            r6 = r24
            int r2 = com.iproov.sdk.utils.Cif.m2245do(r6, r0, r2, r2, r5)
            goto L_0x0021
        L_0x001e:
            r6 = r24
            r2 = r5
        L_0x0021:
            if (r2 == r5) goto L_0x002a
            com.iproov.sdk.return.extends$else$if r4 = new com.iproov.sdk.return.extends$else$if
            r4.<init>(r2)
        L_0x0028:
            r12 = r4
            goto L_0x0038
        L_0x002a:
            if (r4 == 0) goto L_0x0033
            com.iproov.sdk.return.extends$else$do r2 = new com.iproov.sdk.return.extends$else$do
            r2.<init>(r4)
            r12 = r2
            goto L_0x0038
        L_0x0033:
            com.iproov.sdk.return.extends$else r4 = r1.m1502try()
            goto L_0x0028
        L_0x0038:
            java.lang.String r2 = "logo_image"
            android.graphics.Bitmap r2 = com.iproov.sdk.utils.Cif.m2248do((org.json.JSONObject) r0, (java.lang.String) r2, (android.graphics.Bitmap) r3)
            if (r2 == 0) goto L_0x0047
            com.iproov.sdk.return.extends$goto$do r4 = new com.iproov.sdk.return.extends$goto$do
            r4.<init>(r2)
            r13 = r4
            goto L_0x004c
        L_0x0047:
            com.iproov.sdk.return.extends$goto r2 = r1.m1500this()
            r13 = r2
        L_0x004c:
            java.lang.String r2 = "close_button_image"
            android.graphics.Bitmap r2 = com.iproov.sdk.utils.Cif.m2248do((org.json.JSONObject) r0, (java.lang.String) r2, (android.graphics.Bitmap) r3)
            if (r2 == 0) goto L_0x005a
            com.iproov.sdk.return.extends$goto$do r3 = new com.iproov.sdk.return.extends$goto$do
            r3.<init>(r2)
            goto L_0x0062
        L_0x005a:
            com.iproov.sdk.return.extends$new r2 = r1.m1492do()
            com.iproov.sdk.return.extends$goto r3 = r2.m1522if()
        L_0x0062:
            com.iproov.sdk.return.extends$new r2 = new com.iproov.sdk.return.extends$new
            r16 = r2
            com.iproov.sdk.return.extends$new r4 = r1.m1492do()
            int r4 = r4.m1521do()
            java.lang.String r5 = "close_button_tint_color"
            int r4 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r5, (int) r4)
            r2.<init>(r3, r4)
            com.iproov.sdk.return.extends$class r2 = new com.iproov.sdk.return.extends$class
            r7 = r2
            java.lang.String r3 = r1.m1499super()
            java.lang.String r4 = "title"
            java.lang.String r8 = com.iproov.sdk.utils.Cif.m2268do((org.json.JSONObject) r0, (java.lang.String) r4, (java.lang.String) r3)
            int r3 = r1.m1501throw()
            java.lang.String r4 = "title_text_color"
            int r9 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r4, (int) r3)
            int r3 = r1.m1493else()
            java.lang.String r4 = "header_background_color"
            int r10 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r4, (int) r3)
            com.iproov.sdk.return.extends$case r3 = r1.m1498new()
            java.lang.String r4 = "filter"
            com.iproov.sdk.return.extends$case r11 = com.iproov.sdk.utils.Cif.m2253do((org.json.JSONObject) r0, (java.lang.String) r4, (com.iproov.sdk.p026return.Cextends.Ccase) r3)
            boolean r3 = r1.m1495for()
            java.lang.String r4 = "enable_screenshots"
            boolean r14 = r0.optBoolean(r4, r3)
            com.iproov.sdk.cameray.Orientation r3 = r1.m1487break()
            java.lang.String r4 = "orientation"
            com.iproov.sdk.cameray.Orientation r15 = com.iproov.sdk.utils.Cif.m2250do((org.json.JSONObject) r0, (java.lang.String) r4, (com.iproov.sdk.cameray.Orientation) r3)
            int r3 = r1.m1491const()
            java.lang.String r4 = "prompt_text_color"
            int r17 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r4, (int) r3)
            int r3 = r1.m1489catch()
            java.lang.String r4 = "prompt_background_color"
            int r18 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r4, (int) r3)
            boolean r3 = r1.m1490class()
            java.lang.String r4 = "prompt_rounded_corners"
            boolean r19 = r0.optBoolean(r4, r3)
            boolean r3 = r1.m1497if()
            java.lang.String r4 = "disable_exterior_effects"
            boolean r20 = r0.optBoolean(r4, r3)
            int r1 = r1.m1494final()
            java.lang.String r3 = "surround_color"
            int r21 = com.iproov.sdk.utils.Cif.m2246do((org.json.JSONObject) r0, (java.lang.String) r3, (int) r1)
            com.iproov.sdk.return.extends$class$do r22 = genuinePresenceAssuranceUIOptionsFromJSON(r24, r25)
            com.iproov.sdk.return.extends$class$if r23 = livenessAssuranceUIOptionsFromJSON(r24, r25)
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.bridge.OptionsBridge.uiOptionsFromJson(android.content.Context, org.json.JSONObject):com.iproov.sdk.return.extends$class");
    }

    private static JSONObject uiToJsonForAnalytics(Context context, Cextends.Cclass classR) throws InvalidOptionsException {
        JSONObject jSONObject = new JSONObject();
        Cif.m2274do(jSONObject, TITLE_TEXT_COLOR_KEY, classR.m1501throw(), defaultSessionOptions(context).m1478for().m1501throw());
        Cif.m2274do(jSONObject, HEADER_BACKGROUND_COLOR_KEY, classR.m1493else(), defaultSessionOptions(context).m1478for().m1493else());
        Cif.m2274do(jSONObject, PROMPT_TEXT_COLOR_KEY, classR.m1491const(), defaultSessionOptions(context).m1478for().m1491const());
        Cif.m2274do(jSONObject, PROMPT_BACKGROUND_COLOR_KEY, classR.m1489catch(), defaultSessionOptions(context).m1478for().m1489catch());
        Cif.m2276do(jSONObject, PROMPT_ROUNDED_CORNERS, (Object) Boolean.valueOf(classR.m1490class()));
        Cif.m2276do(jSONObject, DISABLE_EXTERIOR_EFFECTS_KEY, (Object) Boolean.valueOf(classR.m1497if()));
        Cif.m2276do(jSONObject, "title", (Object) asAnalytics(classR.m1499super(), defaultSessionOptions(context).m1478for().m1499super()));
        Cif.m2275do(jSONObject, "filter", classR.m1498new(), defaultSessionOptions(context).m1478for().m1498new());
        Cif.m2276do(jSONObject, LOGO_KEY, (Object) asAnalytics(classR.m1500this(), defaultSessionOptions(context).m1478for().m1500this()));
        Cif.m2276do(jSONObject, FONT_KEY, (Object) asAnalytics(classR.m1502try(), defaultSessionOptions(context).m1478for().m1502try()));
        Cif.m2278if(jSONObject, "orientation", classR.m1487break());
        Cif.m2276do(jSONObject, CLOSE_BUTTON_IMAGE_KEY, (Object) asAnalytics(classR.m1492do().m1522if(), defaultSessionOptions(context).m1478for().m1492do().m1522if()));
        Cif.m2274do(jSONObject, CLOSE_BUTTON_TINT_COLOR_KEY, classR.m1492do().m1521do(), defaultSessionOptions(context).m1478for().m1492do().m1521do());
        Cif.m2274do(jSONObject, SURROUND_COLOR, classR.m1494final(), defaultSessionOptions(context).m1478for().m1494final());
        JSONObject jSONObject2 = new JSONObject();
        Cif.m2274do(jSONObject2, GPA_READY_OVAL_STROKE_COLOR_KEY, classR.m1488case().m1504if(), defaultSessionOptions(context).m1478for().m1488case().m1504if());
        Cif.m2274do(jSONObject2, GPA_NOT_READY_OVAL_STROKE_COLOR_KEY, classR.m1488case().m1503do(), defaultSessionOptions(context).m1478for().m1488case().m1503do());
        JSONObject jSONObject3 = new JSONObject();
        Cif.m2274do(jSONObject3, LIVENESS_OVAL_STROKE_COLOR_KEY, classR.m1496goto().m1506if(), defaultSessionOptions(context).m1478for().m1496goto().m1506if());
        Cif.m2274do(jSONObject3, LIVENESS_COMPLETED_OVAL_STROKE_COLOR_KEY, classR.m1496goto().m1505do(), defaultSessionOptions(context).m1478for().m1496goto().m1505do());
        Cif.m2276do(jSONObject, GENUINE_PRESENCE_ASSURANCE_KEY, (Object) jSONObject2);
        Cif.m2276do(jSONObject, LIVENESS_ASSURANCE_KEY, (Object) jSONObject3);
        return jSONObject;
    }
}

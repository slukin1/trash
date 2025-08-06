package com.google.android.exoplayer2.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {
    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map<String, Integer> DEFAULT_BACKGROUND_COLORS;
    public static final float DEFAULT_POSITION = 0.5f;
    private static final Map<String, Integer> DEFAULT_TEXT_COLORS;
    private static final String ENTITY_AMPERSAND = "amp";
    private static final String ENTITY_GREATER_THAN = "gt";
    private static final String ENTITY_LESS_THAN = "lt";
    private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final String TAG = "WebvttCueParser";
    private static final String TAG_BOLD = "b";
    private static final String TAG_CLASS = "c";
    private static final String TAG_ITALIC = "i";
    private static final String TAG_LANG = "lang";
    private static final String TAG_RUBY = "ruby";
    private static final String TAG_RUBY_TEXT = "rt";
    private static final String TAG_UNDERLINE = "u";
    private static final String TAG_VOICE = "v";
    private static final int TEXT_ALIGNMENT_CENTER = 2;
    private static final int TEXT_ALIGNMENT_END = 3;
    private static final int TEXT_ALIGNMENT_LEFT = 4;
    private static final int TEXT_ALIGNMENT_RIGHT = 5;
    private static final int TEXT_ALIGNMENT_START = 1;

    public static class Element {
        /* access modifiers changed from: private */
        public static final Comparator<Element> BY_START_POSITION_ASC = a.f66065b;
        /* access modifiers changed from: private */
        public final int endPosition;
        /* access modifiers changed from: private */
        public final StartTag startTag;

        private Element(StartTag startTag2, int i11) {
            this.startTag = startTag2;
            this.endPosition = i11;
        }
    }

    public static final class StartTag {
        public final Set<String> classes;
        public final String name;
        public final int position;
        public final String voice;

        private StartTag(String str, int i11, String str2, Set<String> set) {
            this.position = i11;
            this.name = str;
            this.voice = str2;
            this.classes = set;
        }

        public static StartTag buildStartTag(String str, int i11) {
            String str2;
            String trim = str.trim();
            Assertions.checkArgument(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = Util.split(trim, "\\.");
            String str3 = split[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < split.length; i12++) {
                hashSet.add(split[i12]);
            }
            return new StartTag(str3, i11, str2, hashSet);
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", Collections.emptySet());
        }
    }

    public static final class StyleMatch implements Comparable<StyleMatch> {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i11, WebvttCssStyle webvttCssStyle) {
            this.score = i11;
            this.style = webvttCssStyle;
        }

        public int compareTo(StyleMatch styleMatch) {
            return Integer.compare(this.score, styleMatch.score);
        }
    }

    public static final class WebvttCueInfoBuilder {
        public long endTimeUs = 0;
        public float line = -3.4028235E38f;
        public int lineAnchor = 0;
        public int lineType = 1;
        public float position = -3.4028235E38f;
        public int positionAnchor = Integer.MIN_VALUE;
        public float size = 1.0f;
        public long startTimeUs = 0;
        public CharSequence text;
        public int textAlignment = 2;
        public int verticalType = Integer.MIN_VALUE;

        private static float computeLine(float f11, int i11) {
            int i12 = (f11 > -3.4028235E38f ? 1 : (f11 == -3.4028235E38f ? 0 : -1));
            if (i12 == 0 || i11 != 0 || (f11 >= 0.0f && f11 <= 1.0f)) {
                return i12 != 0 ? f11 : i11 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment convertTextAlignment(int i11) {
            if (i11 != 1) {
                if (i11 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            StringBuilder sb2 = new StringBuilder(34);
                            sb2.append("Unknown textAlignment: ");
                            sb2.append(i11);
                            Log.w(WebvttCueParser.TAG, sb2.toString());
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float deriveMaxSize(int i11, float f11) {
            if (i11 == 0) {
                return 1.0f - f11;
            }
            if (i11 == 1) {
                return f11 <= 0.5f ? f11 * 2.0f : (1.0f - f11) * 2.0f;
            }
            if (i11 == 2) {
                return f11;
            }
            throw new IllegalStateException(String.valueOf(i11));
        }

        private static float derivePosition(int i11) {
            if (i11 != 4) {
                return i11 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int derivePositionAnchor(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 3) {
                return 2;
            }
            if (i11 != 4) {
                return i11 != 5 ? 1 : 2;
            }
            return 0;
        }

        public WebvttCueInfo build() {
            return new WebvttCueInfo(toCueBuilder().build(), this.startTimeUs, this.endTimeUs);
        }

        public Cue.Builder toCueBuilder() {
            float f11 = this.position;
            if (f11 == -3.4028235E38f) {
                f11 = derivePosition(this.textAlignment);
            }
            int i11 = this.positionAnchor;
            if (i11 == Integer.MIN_VALUE) {
                i11 = derivePositionAnchor(this.textAlignment);
            }
            Cue.Builder verticalType2 = new Cue.Builder().setTextAlignment(convertTextAlignment(this.textAlignment)).setLine(computeLine(this.line, this.lineType), this.lineType).setLineAnchor(this.lineAnchor).setPosition(f11).setPositionAnchor(i11).setSize(Math.min(this.size, deriveMaxSize(i11, f11))).setVerticalType(this.verticalType);
            CharSequence charSequence = this.text;
            if (charSequence != null) {
                verticalType2.setText(charSequence);
            }
            return verticalType2;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_TEXT_COLORS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_BACKGROUND_COLORS = Collections.unmodifiableMap(hashMap2);
    }

    private static void applyDefaultColors(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i11, int i12) {
        for (String next : set) {
            Map<String, Integer> map = DEFAULT_TEXT_COLORS;
            if (map.containsKey(next)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(next).intValue()), i11, i12, 33);
            } else {
                Map<String, Integer> map2 = DEFAULT_BACKGROUND_COLORS;
                if (map2.containsKey(next)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(next).intValue()), i11, i12, 33);
                }
            }
        }
    }

    private static void applyEntity(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals(ENTITY_GREATER_THAN)) {
                    c11 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals(ENTITY_LESS_THAN)) {
                    c11 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals(ENTITY_AMPERSAND)) {
                    c11 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals(ENTITY_NON_BREAK_SPACE)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                spannableStringBuilder.append(CHAR_GREATER_THAN);
                return;
            case 1:
                spannableStringBuilder.append(CHAR_LESS_THAN);
                return;
            case 2:
                spannableStringBuilder.append(CHAR_AMPERSAND);
                return;
            case 3:
                spannableStringBuilder.append(' ');
                return;
            default:
                StringBuilder sb2 = new StringBuilder(str.length() + 33);
                sb2.append("ignoring unsupported entity: '&");
                sb2.append(str);
                sb2.append(";'");
                Log.w(TAG, sb2.toString());
                return;
        }
    }

    private static void applyRubySpans(SpannableStringBuilder spannableStringBuilder, String str, StartTag startTag, List<Element> list, List<WebvttCssStyle> list2) {
        int rubyPosition = getRubyPosition(list2, str, startTag);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, Element.BY_START_POSITION_ASC);
        int i11 = startTag.position;
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if (TAG_RUBY_TEXT.equals(((Element) arrayList.get(i13)).startTag.name)) {
                Element element = (Element) arrayList.get(i13);
                int firstKnownRubyPosition = firstKnownRubyPosition(getRubyPosition(list2, str, element.startTag), rubyPosition, 1);
                int i14 = element.startTag.position - i12;
                int access$300 = element.endPosition - i12;
                CharSequence subSequence = spannableStringBuilder.subSequence(i14, access$300);
                spannableStringBuilder.delete(i14, access$300);
                spannableStringBuilder.setSpan(new RubySpan(subSequence.toString(), firstKnownRubyPosition), i11, i14, 33);
                i12 += subSequence.length();
                i11 = i14;
            }
        }
    }

    private static void applySpansForTag(String str, StartTag startTag, List<Element> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        int i11 = startTag.position;
        int length = spannableStringBuilder.length();
        String str2 = startTag.name;
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c11 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c11 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals("c")) {
                    c11 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals(TAG_ITALIC)) {
                    c11 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals(TAG_UNDERLINE)) {
                    c11 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals("lang")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
                break;
            case 2:
                applyDefaultColors(spannableStringBuilder, startTag.classes, i11, length);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case 7:
                applyRubySpans(spannableStringBuilder, str, startTag, list, list2);
                break;
            default:
                return;
        }
        List<StyleMatch> applicableStyles = getApplicableStyles(list2, str, startTag);
        for (int i12 = 0; i12 < applicableStyles.size(); i12++) {
            applyStyleToText(spannableStringBuilder, applicableStyles.get(i12).style, i11, length);
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i11, int i12) {
        if (webvttCssStyle != null) {
            if (webvttCssStyle.getStyle() != -1) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new StyleSpan(webvttCssStyle.getStyle()), i11, i12, 33);
            }
            if (webvttCssStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
            }
            if (webvttCssStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
            }
            if (webvttCssStyle.hasFontColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.getFontColor()), i11, i12, 33);
            }
            if (webvttCssStyle.hasBackgroundColor()) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i11, i12, 33);
            }
            if (webvttCssStyle.getFontFamily() != null) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.getFontFamily()), i11, i12, 33);
            }
            int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
            if (fontSizeUnit == 1) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i11, i12, 33);
            } else if (fontSizeUnit == 2) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize()), i11, i12, 33);
            } else if (fontSizeUnit == 3) {
                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i11, i12, 33);
            }
            if (webvttCssStyle.getCombineUpright()) {
                spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i11, i12, 33);
            }
        }
    }

    private static int findEndOfTag(String str, int i11) {
        int indexOf = str.indexOf(62, i11);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int firstKnownRubyPosition(int i11, int i12, int i13) {
        if (i11 != -1) {
            return i11;
        }
        if (i12 != -1) {
            return i12;
        }
        if (i13 != -1) {
            return i13;
        }
        throw new IllegalArgumentException();
    }

    private static List<StyleMatch> getApplicableStyles(List<WebvttCssStyle> list, String str, StartTag startTag) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            WebvttCssStyle webvttCssStyle = list.get(i11);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
            if (specificityScore > 0) {
                arrayList.add(new StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int getRubyPosition(List<WebvttCssStyle> list, String str, StartTag startTag) {
        List<StyleMatch> applicableStyles = getApplicableStyles(list, str, startTag);
        for (int i11 = 0; i11 < applicableStyles.size(); i11++) {
            WebvttCssStyle webvttCssStyle = applicableStyles.get(i11).style;
            if (webvttCssStyle.getRubyPosition() != -1) {
                return webvttCssStyle.getRubyPosition();
            }
        }
        return -1;
    }

    private static String getTagName(String str) {
        String trim = str.trim();
        Assertions.checkArgument(!trim.isEmpty());
        return Util.splitAtFirst(trim, "[ \\.]")[0];
    }

    private static boolean isSupportedTag(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c11 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c11 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals(TAG_ITALIC)) {
                    c11 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals(TAG_UNDERLINE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c11 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals(TAG_RUBY_TEXT)) {
                    c11 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    public static Cue newCueForText(CharSequence charSequence) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        webvttCueInfoBuilder.text = charSequence;
        return webvttCueInfoBuilder.toCueBuilder().build();
    }

    public static WebvttCueInfo parseCue(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String readLine = parsableByteArray.readLine();
        if (readLine == null) {
            return null;
        }
        Pattern pattern = CUE_HEADER_PATTERN;
        Matcher matcher = pattern.matcher(readLine);
        if (matcher.matches()) {
            return parseCue((String) null, matcher, parsableByteArray, list);
        }
        String readLine2 = parsableByteArray.readLine();
        if (readLine2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(readLine2);
        if (matcher2.matches()) {
            return parseCue(readLine.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    public static Cue.Builder parseCueSettingsList(String str) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        parseCueSettingsList(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.toCueBuilder();
    }

    public static SpannedString parseCueText(String str, String str2, List<WebvttCssStyle> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < str2.length()) {
            char charAt = str2.charAt(i11);
            if (charAt == '&') {
                i11++;
                int indexOf = str2.indexOf(59, i11);
                int indexOf2 = str2.indexOf(32, i11);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    applyEntity(str2.substring(i11, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i11 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i11++;
            } else {
                int i12 = i11 + 1;
                if (i12 < str2.length()) {
                    int i13 = 1;
                    boolean z11 = str2.charAt(i12) == '/';
                    i12 = findEndOfTag(str2, i12);
                    int i14 = i12 - 2;
                    boolean z12 = str2.charAt(i14) == '/';
                    if (z11) {
                        i13 = 2;
                    }
                    int i15 = i11 + i13;
                    if (!z12) {
                        i14 = i12 - 1;
                    }
                    String substring = str2.substring(i15, i14);
                    if (!substring.trim().isEmpty()) {
                        String tagName = getTagName(substring);
                        if (isSupportedTag(tagName)) {
                            if (z11) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    applySpansForTag(str, startTag, arrayList, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList.add(new Element(startTag, spannableStringBuilder.length()));
                                    } else {
                                        arrayList.clear();
                                    }
                                    if (startTag.name.equals(tagName)) {
                                        break;
                                    }
                                }
                            } else if (!z12) {
                                arrayDeque.push(StartTag.buildStartTag(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i11 = i12;
            }
        }
        while (!arrayDeque.isEmpty()) {
            applySpansForTag(str, (StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        applySpansForTag(str, StartTag.buildWholeCueVirtualTag(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int parseLineAnchor(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c11 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                Log.w(TAG, str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    private static void parseLineAttribute(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.lineAnchor = parseLineAnchor(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.line = WebvttParserUtil.parsePercentage(str);
            webvttCueInfoBuilder.lineType = 0;
            return;
        }
        webvttCueInfoBuilder.line = (float) Integer.parseInt(str);
        webvttCueInfoBuilder.lineType = 1;
    }

    private static int parsePositionAnchor(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c11 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                Log.w(TAG, str.length() != 0 ? "Invalid anchor value: ".concat(str) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    private static void parsePositionAttribute(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.positionAnchor = parsePositionAnchor(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        webvttCueInfoBuilder.position = WebvttParserUtil.parsePercentage(str);
    }

    private static int parseTextAlignment(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c11 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c11 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c11 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c11 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                Log.w(TAG, str.length() != 0 ? "Invalid alignment value: ".concat(str) : new String("Invalid alignment value: "));
                return 2;
        }
    }

    private static int parseVerticalAttribute(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        Log.w(TAG, str.length() != 0 ? "Invalid 'vertical' value: ".concat(str) : new String("Invalid 'vertical' value: "));
        return Integer.MIN_VALUE;
    }

    private static void parseCueSettingsList(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                if (Constants.LINE.equals(str2)) {
                    parseLineAttribute(str3, webvttCueInfoBuilder);
                } else if ("align".equals(str2)) {
                    webvttCueInfoBuilder.textAlignment = parseTextAlignment(str3);
                } else if ("position".equals(str2)) {
                    parsePositionAttribute(str3, webvttCueInfoBuilder);
                } else if ("size".equals(str2)) {
                    webvttCueInfoBuilder.size = WebvttParserUtil.parsePercentage(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.verticalType = parseVerticalAttribute(str3);
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 21 + String.valueOf(str3).length());
                    sb2.append("Unknown cue setting ");
                    sb2.append(str2);
                    sb2.append(":");
                    sb2.append(str3);
                    Log.w(TAG, sb2.toString());
                }
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(matcher.group());
                Log.w(TAG, valueOf.length() != 0 ? "Skipping bad cue setting: ".concat(valueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    private static WebvttCueInfo parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.startTimeUs = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(1)));
            webvttCueInfoBuilder.endTimeUs = WebvttParserUtil.parseTimestampUs((String) Assertions.checkNotNull(matcher.group(2)));
            parseCueSettingsList((String) Assertions.checkNotNull(matcher.group(3)), webvttCueInfoBuilder);
            StringBuilder sb2 = new StringBuilder();
            String readLine = parsableByteArray.readLine();
            while (!TextUtils.isEmpty(readLine)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(readLine.trim());
                readLine = parsableByteArray.readLine();
            }
            webvttCueInfoBuilder.text = parseCueText(str, sb2.toString(), list);
            return webvttCueInfoBuilder.build();
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(matcher.group());
            Log.w(TAG, valueOf.length() != 0 ? "Skipping cue with bad header: ".concat(valueOf) : new String("Skipping cue with bad header: "));
            return null;
        }
    }
}

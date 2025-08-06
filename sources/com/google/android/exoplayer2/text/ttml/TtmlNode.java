package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    public static final String ANNOTATION_POSITION_AFTER = "after";
    public static final String ANNOTATION_POSITION_BEFORE = "before";
    public static final String ANNOTATION_POSITION_OUTSIDE = "outside";
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_EBUTTS_MULTI_ROW_ALIGN = "multiRowAlign";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_RUBY = "ruby";
    public static final String ATTR_TTS_RUBY_POSITION = "rubyPosition";
    public static final String ATTR_TTS_SHEAR = "shear";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_COMBINE = "textCombine";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String ATTR_TTS_TEXT_EMPHASIS = "textEmphasis";
    public static final String ATTR_TTS_WRITING_MODE = "writingMode";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String COMBINE_ALL = "all";
    public static final String COMBINE_NONE = "none";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String RUBY_BASE = "base";
    public static final String RUBY_BASE_CONTAINER = "baseContainer";
    public static final String RUBY_CONTAINER = "container";
    public static final String RUBY_DELIMITER = "delimiter";
    public static final String RUBY_TEXT = "text";
    public static final String RUBY_TEXT_CONTAINER = "textContainer";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DATA = "data";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_IMAGE = "image";
    public static final String TAG_INFORMATION = "information";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String TEXT_EMPHASIS_AUTO = "auto";
    public static final String TEXT_EMPHASIS_MARK_CIRCLE = "circle";
    public static final String TEXT_EMPHASIS_MARK_DOT = "dot";
    public static final String TEXT_EMPHASIS_MARK_FILLED = "filled";
    public static final String TEXT_EMPHASIS_MARK_OPEN = "open";
    public static final String TEXT_EMPHASIS_MARK_SESAME = "sesame";
    public static final String TEXT_EMPHASIS_NONE = "none";
    public static final String UNDERLINE = "underline";
    public static final String VERTICAL = "tb";
    public static final String VERTICAL_LR = "tblr";
    public static final String VERTICAL_RL = "tbrl";
    private List<TtmlNode> children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap<String, Integer> nodeEndsByRegion;
    private final HashMap<String, Integer> nodeStartsByRegion;
    public final TtmlNode parent;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    private TtmlNode(String str, String str2, long j11, long j12, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        this.tag = str;
        this.text = str2;
        this.imageId = str4;
        this.style = ttmlStyle;
        this.styleIds = strArr;
        this.isTextNode = str2 != null;
        this.startTimeUs = j11;
        this.endTimeUs = j12;
        this.regionId = (String) Assertions.checkNotNull(str3);
        this.parent = ttmlNode;
        this.nodeStartsByRegion = new HashMap<>();
        this.nodeEndsByRegion = new HashMap<>();
    }

    private void applyStyleToOutput(Map<String, TtmlStyle> map, Cue.Builder builder, int i11, int i12, int i13) {
        TtmlStyle resolveStyle = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.getText();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.setText(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (resolveStyle != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder2, i11, i12, resolveStyle, this.parent, map, i13);
            if (TAG_P.equals(this.tag)) {
                if (resolveStyle.getShearPercentage() != Float.MAX_VALUE) {
                    builder.setShearDegrees((resolveStyle.getShearPercentage() * -90.0f) / 100.0f);
                }
                if (resolveStyle.getTextAlign() != null) {
                    builder.setTextAlignment(resolveStyle.getTextAlign());
                }
                if (resolveStyle.getMultiRowAlign() != null) {
                    builder.setMultiRowAlignment(resolveStyle.getMultiRowAlign());
                }
            }
        }
    }

    public static TtmlNode buildNode(String str, long j11, long j12, TtmlStyle ttmlStyle, String[] strArr, String str2, String str3, TtmlNode ttmlNode) {
        return new TtmlNode(str, (String) null, j11, j12, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    public static TtmlNode buildTextNode(String str) {
        return new TtmlNode((String) null, TtmlRenderUtil.applyTextElementSpacePolicy(str), -9223372036854775807L, -9223372036854775807L, (TtmlStyle) null, (String[]) null, "", (String) null, (TtmlNode) null);
    }

    private static void cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i11 = 0; i11 < spannableStringBuilder.length(); i11++) {
            if (spannableStringBuilder.charAt(i11) == ' ') {
                int i12 = i11 + 1;
                int i13 = i12;
                while (i13 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i13) == ' ') {
                    i13++;
                }
                int i14 = i13 - i12;
                if (i14 > 0) {
                    spannableStringBuilder.delete(i11, i14 + i11);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i15 = 0; i15 < spannableStringBuilder.length() - 1; i15++) {
            if (spannableStringBuilder.charAt(i15) == 10) {
                int i16 = i15 + 1;
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    spannableStringBuilder.delete(i16, i15 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i17 = 0; i17 < spannableStringBuilder.length() - 1; i17++) {
            if (spannableStringBuilder.charAt(i17) == ' ') {
                int i18 = i17 + 1;
                if (spannableStringBuilder.charAt(i18) == 10) {
                    spannableStringBuilder.delete(i17, i18);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void getEventTimes(TreeSet<Long> treeSet, boolean z11) {
        boolean equals = TAG_P.equals(this.tag);
        boolean equals2 = TAG_DIV.equals(this.tag);
        if (z11 || equals || (equals2 && this.imageId != null)) {
            long j11 = this.startTimeUs;
            if (j11 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j11));
            }
            long j12 = this.endTimeUs;
            if (j12 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j12));
            }
        }
        if (this.children != null) {
            for (int i11 = 0; i11 < this.children.size(); i11++) {
                this.children.get(i11).getEventTimes(treeSet, z11 || equals);
            }
        }
    }

    private static SpannableStringBuilder getRegionOutputText(String str, Map<String, Cue.Builder> map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.setText(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.checkNotNull(map.get(str).getText());
    }

    private void traverseForImage(long j11, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.regionId)) {
            str = this.regionId;
        }
        if (!isActive(j11) || !TAG_DIV.equals(this.tag) || this.imageId == null) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                getChild(i11).traverseForImage(j11, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.imageId));
    }

    private void traverseForStyle(long j11, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.Builder> map3) {
        int i11;
        if (isActive(j11)) {
            String str2 = "".equals(this.regionId) ? str : this.regionId;
            Iterator<Map.Entry<String, Integer>> it2 = this.nodeEndsByRegion.entrySet().iterator();
            while (true) {
                i11 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                String str3 = (String) next.getKey();
                if (this.nodeStartsByRegion.containsKey(str3)) {
                    i11 = this.nodeStartsByRegion.get(str3).intValue();
                }
                int i12 = i11;
                int intValue = ((Integer) next.getValue()).intValue();
                if (i12 != intValue) {
                    applyStyleToOutput(map, (Cue.Builder) Assertions.checkNotNull(map3.get(str3)), i12, intValue, ((TtmlRegion) Assertions.checkNotNull(map2.get(str2))).verticalType);
                } else {
                    Map<String, TtmlRegion> map4 = map2;
                    Map<String, Cue.Builder> map5 = map3;
                }
            }
            Map<String, TtmlRegion> map6 = map2;
            Map<String, Cue.Builder> map7 = map3;
            while (i11 < getChildCount()) {
                getChild(i11).traverseForStyle(j11, map, map2, str2, map3);
                i11++;
                Map<String, TtmlRegion> map8 = map2;
            }
        }
    }

    private void traverseForText(long j11, boolean z11, String str, Map<String, Cue.Builder> map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if (!"metadata".equals(this.tag)) {
            if (!"".equals(this.regionId)) {
                str = this.regionId;
            }
            if (this.isTextNode && z11) {
                getRegionOutputText(str, map).append((CharSequence) Assertions.checkNotNull(this.text));
            } else if (TAG_BR.equals(this.tag) && z11) {
                getRegionOutputText(str, map).append(10);
            } else if (isActive(j11)) {
                for (Map.Entry next : map.entrySet()) {
                    this.nodeStartsByRegion.put((String) next.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) next.getValue()).getText())).length()));
                }
                boolean equals = TAG_P.equals(this.tag);
                for (int i11 = 0; i11 < getChildCount(); i11++) {
                    getChild(i11).traverseForText(j11, z11 || equals, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.endParagraph(getRegionOutputText(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.nodeEndsByRegion.put((String) next2.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) next2.getValue()).getText())).length()));
                }
            }
        }
    }

    public void addChild(TtmlNode ttmlNode) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public TtmlNode getChild(int i11) {
        List<TtmlNode> list = this.children;
        if (list != null) {
            return list.get(i11);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getChildCount() {
        List<TtmlNode> list = this.children;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> getCues(long j11, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        traverseForImage(j11, this.regionId, arrayList);
        TreeMap treeMap = new TreeMap();
        long j12 = j11;
        traverseForText(j12, false, this.regionId, treeMap);
        traverseForStyle(j12, map, map2, this.regionId, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.checkNotNull(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().setBitmap(decodeByteArray).setPosition(ttmlRegion.position).setPositionAnchor(0).setLine(ttmlRegion.line, 0).setLineAnchor(ttmlRegion.lineAnchor).setSize(ttmlRegion.width).setBitmapHeight(ttmlRegion.height).setVerticalType(ttmlRegion.verticalType).build());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.checkNotNull(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            cleanUpText((SpannableStringBuilder) Assertions.checkNotNull(builder.getText()));
            builder.setLine(ttmlRegion2.line, ttmlRegion2.lineType);
            builder.setLineAnchor(ttmlRegion2.lineAnchor);
            builder.setPosition(ttmlRegion2.position);
            builder.setSize(ttmlRegion2.width);
            builder.setTextSize(ttmlRegion2.textSize, ttmlRegion2.textSizeType);
            builder.setVerticalType(ttmlRegion2.verticalType);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    public long[] getEventTimesUs() {
        TreeSet treeSet = new TreeSet();
        int i11 = 0;
        getEventTimes(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i11] = ((Long) it2.next()).longValue();
            i11++;
        }
        return jArr;
    }

    public String[] getStyleIds() {
        return this.styleIds;
    }

    public boolean isActive(long j11) {
        long j12 = this.startTimeUs;
        return (j12 == -9223372036854775807L && this.endTimeUs == -9223372036854775807L) || (j12 <= j11 && this.endTimeUs == -9223372036854775807L) || ((j12 == -9223372036854775807L && j11 < this.endTimeUs) || (j12 <= j11 && j11 < this.endTimeUs));
    }
}

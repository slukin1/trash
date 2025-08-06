package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.Constants;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {
    private static final Pattern CEA_608_ACCESSIBILITY_PATTERN = Pattern.compile("CC([1-4])=.*");
    private static final Pattern CEA_708_ACCESSIBILITY_PATTERN = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final int[] MPEG_CHANNEL_CONFIGURATION_MAPPING = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    private static final String TAG = "MpdParser";
    private final XmlPullParserFactory xmlParserFactory;

    public static final class RepresentationInfo {
        public final String baseUrl;
        public final ArrayList<DrmInitData.SchemeData> drmSchemeDatas;
        public final String drmSchemeType;
        public final Format format;
        public final ArrayList<Descriptor> inbandEventStreams;
        public final long revisionId;
        public final SegmentBase segmentBase;

        public RepresentationInfo(Format format2, String str, SegmentBase segmentBase2, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, long j11) {
            this.format = format2;
            this.baseUrl = str;
            this.segmentBase = segmentBase2;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j11;
        }
    }

    public DashManifestParser() {
        try {
            this.xmlParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    private long addSegmentTimelineElementsToList(List<SegmentBase.SegmentTimelineElement> list, long j11, long j12, int i11, long j13) {
        int ceilDivide = i11 >= 0 ? i11 + 1 : (int) Util.ceilDivide(j13 - j11, j12);
        for (int i12 = 0; i12 < ceilDivide; i12++) {
            list.add(buildSegmentTimelineElement(j11, j12));
            j11 += j12;
        }
        return j11;
    }

    private static int checkContentTypeConsistency(int i11, int i12) {
        if (i11 == -1) {
            return i12;
        }
        if (i12 == -1) {
            return i11;
        }
        Assertions.checkState(i11 == i12);
        return i11;
    }

    private static String checkLanguageConsistency(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.checkState(str.equals(str2));
        return str;
    }

    private static void filterRedundantIncompleteSchemeDatas(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i11).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
    }

    private static long getFinalAvailabilityTimeOffset(long j11, long j12) {
        if (j12 != -9223372036854775807L) {
            j11 = j12;
        }
        if (j11 == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j11;
    }

    private static String getSampleMimeType(String str, String str2) {
        if (MimeTypes.isAudio(str)) {
            return MimeTypes.getAudioMediaMimeType(str2);
        }
        if (MimeTypes.isVideo(str)) {
            return MimeTypes.getVideoMediaMimeType(str2);
        }
        if (MimeTypes.isText(str)) {
            return MimeTypes.APPLICATION_RAWCC.equals(str) ? MimeTypes.getTextMediaMimeType(str2) : str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            return null;
        }
        String mediaMimeType = MimeTypes.getMediaMimeType(str2);
        return "text/vtt".equals(mediaMimeType) ? MimeTypes.APPLICATION_MP4VTT : mediaMimeType;
    }

    public static void maybeSkipTag(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i11 = 1;
            while (i11 != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i11++;
                } else if (XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i11--;
                }
            }
        }
    }

    public static int parseCea608AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(descriptor.value);
                Log.w(TAG, valueOf.length() != 0 ? "Unable to parse CEA-608 channel number from: ".concat(valueOf) : new String("Unable to parse CEA-608 channel number from: "));
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<Descriptor> list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.schemeIdUri) && (str = descriptor.value) != null) {
                Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(descriptor.value);
                Log.w(TAG, valueOf.length() != 0 ? "Unable to parse CEA-708 service block number from: ".concat(valueOf) : new String("Unable to parse CEA-708 service block number from: "));
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j11) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j11;
        }
        return Util.parseXsDateTime(attributeValue);
    }

    public static Descriptor parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", (String) null);
        String parseString3 = parseString(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new Descriptor(parseString, parseString2, parseString3);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            r0 = -1
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.String r4 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r4)
            r4.hashCode()
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L_0x003f;
                case 2937391: goto L_0x0034;
                case 3094035: goto L_0x0029;
                case 3133436: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            r4 = r0
            goto L_0x0049
        L_0x001e:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0027
            goto L_0x001c
        L_0x0027:
            r4 = 3
            goto L_0x0049
        L_0x0029:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0032
            goto L_0x001c
        L_0x0032:
            r4 = r2
            goto L_0x0049
        L_0x0034:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x003d
            goto L_0x001c
        L_0x003d:
            r4 = r3
            goto L_0x0049
        L_0x003f:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0048
            goto L_0x001c
        L_0x0048:
            r4 = 0
        L_0x0049:
            switch(r4) {
                case 0: goto L_0x0053;
                case 1: goto L_0x0052;
                case 2: goto L_0x0050;
                case 3: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            return r0
        L_0x004d:
            r4 = 8
            return r4
        L_0x0050:
            r4 = 6
            return r4
        L_0x0052:
            return r2
        L_0x0053:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j11;
        }
        return Util.parseXsDuration(attributeValue);
    }

    public static String parseEac3SupplementalProperties(List<Descriptor> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            String str = descriptor.schemeIdUri;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.value)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(descriptor.value)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    public static float parseFloat(XmlPullParser xmlPullParser, String str, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? f11 : Float.parseFloat(attributeValue);
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f11;
        }
        Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f11;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i11 : Integer.parseInt(attributeValue);
    }

    public static long parseLastSegmentNumberSupplementalProperty(List<Descriptor> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Descriptor descriptor = list.get(i11);
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/last-segment-number", descriptor.schemeIdUri)) {
                return Long.parseLong(descriptor.value);
            }
        }
        return -1;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j11 : Long.parseLong(attributeValue);
    }

    public static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int parseInt = parseInt(xmlPullParser, "value", -1);
        if (parseInt < 0) {
            return -1;
        }
        int[] iArr = MPEG_CHANNEL_CONFIGURATION_MAPPING;
        if (parseInt < iArr.length) {
            return iArr[parseInt];
        }
        return -1;
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String parseText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return str2;
    }

    public AdaptationSet buildAdaptationSet(int i11, int i12, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(i11, i12, list, list2, list3, list4);
    }

    public EventMessage buildEvent(String str, String str2, long j11, long j12, byte[] bArr) {
        return new EventMessage(str, str2, j12, j11, bArr);
    }

    public EventStream buildEventStream(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j11, jArr, eventMessageArr);
    }

    public Format buildFormat(String str, String str2, int i11, int i12, float f11, int i13, int i14, int i15, String str3, List<Descriptor> list, List<Descriptor> list2, String str4, List<Descriptor> list3, List<Descriptor> list4) {
        String str5 = str2;
        List<Descriptor> list5 = list;
        String str6 = str4;
        String sampleMimeType = getSampleMimeType(str2, str6);
        if (MimeTypes.AUDIO_E_AC3.equals(sampleMimeType)) {
            sampleMimeType = parseEac3SupplementalProperties(list4);
        }
        int parseSelectionFlagsFromRoleDescriptors = parseSelectionFlagsFromRoleDescriptors(list5);
        String str7 = str;
        Format.Builder language = new Format.Builder().setId(str).setContainerMimeType(str2).setSampleMimeType(sampleMimeType).setCodecs(str6).setPeakBitrate(i15).setSelectionFlags(parseSelectionFlagsFromRoleDescriptors).setRoleFlags(parseRoleFlagsFromRoleDescriptors(list5) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).setLanguage(str3);
        if (MimeTypes.isVideo(sampleMimeType)) {
            int i16 = i11;
            int i17 = i12;
            float f12 = f11;
            language.setWidth(i11).setHeight(i12).setFrameRate(f11);
        } else if (MimeTypes.isAudio(sampleMimeType)) {
            int i18 = i13;
            language.setChannelCount(i13).setSampleRate(i14);
        } else if (MimeTypes.isText(sampleMimeType)) {
            int i19 = -1;
            if (MimeTypes.APPLICATION_CEA608.equals(sampleMimeType)) {
                i19 = parseCea608AccessibilityChannel(list2);
            } else if (MimeTypes.APPLICATION_CEA708.equals(sampleMimeType)) {
                i19 = parseCea708AccessibilityChannel(list2);
            }
            language.setAccessibilityChannel(i19);
        }
        return language.build();
    }

    public DashManifest buildMediaPresentationDescription(long j11, long j12, long j13, boolean z11, long j14, long j15, long j16, long j17, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List<Period> list) {
        return new DashManifest(j11, j12, j13, z11, j14, j15, j16, j17, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    public Period buildPeriod(String str, long j11, List<AdaptationSet> list, List<EventStream> list2, Descriptor descriptor) {
        return new Period(str, j11, list, list2, descriptor);
    }

    public RangedUri buildRangedUri(String str, long j11, long j12) {
        return new RangedUri(str, j11, j12);
    }

    public Representation buildRepresentation(RepresentationInfo representationInfo, String str, String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        Format.Builder buildUpon = representationInfo.format.buildUpon();
        if (str != null) {
            buildUpon.setLabel(str);
        }
        String str3 = representationInfo.drmSchemeType;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            buildUpon.setDrmInitData(new DrmInitData(str2, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return Representation.newInstance(representationInfo.revisionId, buildUpon.build(), representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    public SegmentBase.SegmentList buildSegmentList(RangedUri rangedUri, long j11, long j12, long j13, long j14, List<SegmentBase.SegmentTimelineElement> list, long j15, List<RangedUri> list2, long j16, long j17) {
        return new SegmentBase.SegmentList(rangedUri, j11, j12, j13, j14, list, j15, list2, C.msToUs(j16), C.msToUs(j17));
    }

    public SegmentBase.SegmentTemplate buildSegmentTemplate(RangedUri rangedUri, long j11, long j12, long j13, long j14, long j15, List<SegmentBase.SegmentTimelineElement> list, long j16, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long j17, long j18) {
        return new SegmentBase.SegmentTemplate(rangedUri, j11, j12, j13, j14, j15, list, j16, urlTemplate, urlTemplate2, C.msToUs(j17), C.msToUs(j18));
    }

    public SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j11, long j12) {
        return new SegmentBase.SegmentTimelineElement(j11, j12);
    }

    public SegmentBase.SingleSegmentBase buildSingleSegmentBase(RangedUri rangedUri, long j11, long j12, long j13, long j14) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j11, j12, j13, j14);
    }

    public UtcTimingElement buildUtcTimingElement(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x032c A[LOOP:0: B:1:0x007a->B:67:0x032c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02ec A[EDGE_INSN: B:68:0x02ec->B:61:0x02ec ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser r54, java.lang.String r55, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r56, long r57, long r59, long r61, long r63, long r65) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            java.lang.String r0 = "id"
            r1 = -1
            int r26 = parseInt(r14, r0, r1)
            int r0 = r53.parseContentType(r54)
            r13 = 0
            java.lang.String r2 = "mimeType"
            java.lang.String r27 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "codecs"
            java.lang.String r28 = r14.getAttributeValue(r13, r2)
            java.lang.String r2 = "width"
            int r29 = parseInt(r14, r2, r1)
            java.lang.String r2 = "height"
            int r30 = parseInt(r14, r2, r1)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r31 = parseFrameRate(r14, r2)
            java.lang.String r2 = "audioSamplingRate"
            int r32 = parseInt(r14, r2, r1)
            java.lang.String r12 = "lang"
            java.lang.String r2 = r14.getAttributeValue(r13, r12)
            java.lang.String r3 = "label"
            java.lang.String r3 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r33 = 0
            r4 = r55
            r34 = r56
            r35 = r0
            r36 = r1
            r37 = r2
            r38 = r3
            r40 = r13
            r39 = r33
            r2 = r59
            r0 = r61
        L_0x007a:
            r54.next()
            java.lang.String r13 = "BaseURL"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r13)
            if (r13 == 0) goto L_0x00bf
            if (r39 != 0) goto L_0x00a5
            long r2 = r15.parseAvailabilityTimeOffsetUs(r14, r2)
            java.lang.String r4 = r15.parseBaseUrl(r14, r4)
            r39 = 1
        L_0x0091:
            r41 = r2
            r15 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r3 = r10
            r49 = r11
            r50 = r12
            r51 = 0
            goto L_0x02e4
        L_0x00a5:
            r41 = r2
            r15 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r3 = r10
            r49 = r11
            r50 = r12
            r52 = r35
            r35 = r37
            r51 = 0
            r37 = r4
            goto L_0x02de
        L_0x00bf:
            java.lang.String r13 = "ContentProtection"
            boolean r13 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r13)
            if (r13 == 0) goto L_0x00e1
            android.util.Pair r13 = r53.parseContentProtection(r54)
            r55 = r0
            java.lang.Object r0 = r13.first
            if (r0 == 0) goto L_0x00d5
            r40 = r0
            java.lang.String r40 = (java.lang.String) r40
        L_0x00d5:
            java.lang.Object r0 = r13.second
            if (r0 == 0) goto L_0x00de
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r0
            r11.add(r0)
        L_0x00de:
            r0 = r55
            goto L_0x0091
        L_0x00e1:
            r55 = r0
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x011a
            r13 = 0
            java.lang.String r0 = r14.getAttributeValue(r13, r12)
            r1 = r37
            java.lang.String r0 = checkLanguageConsistency(r1, r0)
            int r1 = r53.parseContentType(r54)
            r15 = r35
            int r1 = checkContentTypeConsistency(r15, r1)
            r37 = r0
            r35 = r1
            r41 = r2
            r15 = r5
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r3 = r10
            r49 = r11
            r50 = r12
            r51 = r13
            r0 = r55
            goto L_0x02e4
        L_0x011a:
            r15 = r35
            r1 = r37
            r13 = 0
            java.lang.String r0 = "Role"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x014a
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r8.add(r0)
        L_0x012e:
            r35 = r1
            r41 = r2
            r37 = r4
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r3 = r10
            r49 = r11
            r50 = r12
            r51 = r13
            r52 = r15
            r0 = r55
            r15 = r5
            goto L_0x02de
        L_0x014a:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0172
            int r0 = r53.parseAudioChannelConfiguration(r54)
            r36 = r0
            r37 = r1
            r41 = r2
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r3 = r10
            r49 = r11
            r50 = r12
            r51 = r13
            r35 = r15
            r0 = r55
            r15 = r5
            goto L_0x02e4
        L_0x0172:
            java.lang.String r0 = "Accessibility"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0182
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r9.add(r0)
            goto L_0x012e
        L_0x0182:
            java.lang.String r0 = "EssentialProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x0192
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r7.add(r0)
            goto L_0x012e
        L_0x0192:
            java.lang.String r0 = "SupplementalProperty"
            boolean r16 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r16 == 0) goto L_0x01a2
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r14, r0)
            r6.add(r0)
            goto L_0x012e
        L_0x01a2:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r0)
            if (r0 == 0) goto L_0x0214
            r59 = r55
            r0 = r53
            r35 = r1
            r1 = r54
            r41 = r2
            r2 = r4
            r3 = r27
            r37 = r4
            r4 = r28
            r43 = r5
            r5 = r29
            r44 = r6
            r6 = r30
            r45 = r7
            r7 = r31
            r46 = r8
            r8 = r36
            r47 = r9
            r9 = r32
            r48 = r10
            r10 = r35
            r49 = r11
            r11 = r46
            r50 = r12
            r12 = r47
            r51 = r13
            r13 = r45
            r14 = r44
            r52 = r15
            r15 = r34
            r16 = r63
            r18 = r57
            r20 = r41
            r22 = r59
            r24 = r65
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.parseRepresentation(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r22, r24)
            com.google.android.exoplayer2.Format r1 = r0.format
            java.lang.String r1 = r1.sampleMimeType
            int r1 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r1)
            r14 = r52
            int r1 = checkContentTypeConsistency(r14, r1)
            r15 = r43
            r15.add(r0)
            r14 = r54
            r4 = r37
            r3 = r48
            r37 = r35
            r35 = r1
            r0 = r59
            goto L_0x02e4
        L_0x0214:
            r59 = r55
            r35 = r1
            r41 = r2
            r37 = r4
            r44 = r6
            r45 = r7
            r46 = r8
            r47 = r9
            r48 = r10
            r49 = r11
            r50 = r12
            r51 = r13
            r14 = r15
            r15 = r5
            java.lang.String r0 = "SegmentBase"
            r13 = r54
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x0251
            r0 = r34
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            r11 = r53
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r11.parseSegmentBase(r13, r0)
            r34 = r0
            r4 = r37
            r3 = r48
            r0 = r59
            r37 = r35
            r35 = r14
            r14 = r13
            goto L_0x02e4
        L_0x0251:
            r11 = r53
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r0)
            if (r0 == 0) goto L_0x0284
            r0 = r59
            long r16 = r11.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r34
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r53
            r1 = r54
            r3 = r63
            r5 = r57
            r7 = r41
            r9 = r16
            r52 = r14
            r14 = r11
            r11 = r65
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r34 = r0
            r14 = r13
        L_0x027d:
            r0 = r16
            r4 = r37
            r3 = r48
            goto L_0x02e0
        L_0x0284:
            r0 = r59
            r52 = r14
            r14 = r11
            java.lang.String r2 = "SegmentTemplate"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r13, r2)
            if (r2 == 0) goto L_0x02b1
            long r16 = r14.parseAvailabilityTimeOffsetUs(r13, r0)
            r2 = r34
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r53
            r1 = r54
            r3 = r44
            r4 = r63
            r6 = r57
            r8 = r41
            r10 = r16
            r14 = r13
            r12 = r65
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            r34 = r0
            goto L_0x027d
        L_0x02b1:
            r14 = r13
            java.lang.String r2 = "InbandEventStream"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r3 == 0) goto L_0x02c4
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r2 = parseDescriptor(r14, r2)
            r3 = r48
            r3.add(r2)
            goto L_0x02de
        L_0x02c4:
            r3 = r48
            java.lang.String r2 = "Label"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = r53.parseLabel(r54)
            r38 = r2
            goto L_0x02de
        L_0x02d5:
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r54)
            if (r2 == 0) goto L_0x02de
            r53.parseAdaptationSetChild(r54)
        L_0x02de:
            r4 = r37
        L_0x02e0:
            r37 = r35
            r35 = r52
        L_0x02e4:
            java.lang.String r2 = "AdaptationSet"
            boolean r2 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r14, r2)
            if (r2 == 0) goto L_0x032c
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            r1 = r33
        L_0x02f7:
            int r2 = r15.size()
            if (r1 >= r2) goto L_0x0319
            java.lang.Object r2 = r15.get(r1)
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r2 = (com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) r2
            r54 = r53
            r55 = r2
            r56 = r38
            r57 = r40
            r58 = r49
            r59 = r3
            com.google.android.exoplayer2.source.dash.manifest.Representation r2 = r54.buildRepresentation(r55, r56, r57, r58, r59)
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x02f7
        L_0x0319:
            r54 = r53
            r55 = r26
            r56 = r35
            r57 = r0
            r58 = r47
            r59 = r45
            r60 = r44
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r0 = r54.buildAdaptationSet(r55, r56, r57, r58, r59, r60)
            return r0
        L_0x032c:
            r10 = r3
            r5 = r15
            r2 = r41
            r6 = r44
            r7 = r45
            r8 = r46
            r9 = r47
            r11 = r49
            r12 = r50
            r13 = r51
            r15 = r53
            goto L_0x007a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseAdaptationSet(org.xmlpull.v1.XmlPullParser, java.lang.String, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long):com.google.android.exoplayer2.source.dash.manifest.AdaptationSet");
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = parseString(r4, r0, r1)
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -1352850286: goto L_0x0038;
                case -1138141449: goto L_0x002c;
                case -986633423: goto L_0x0020;
                case 2036691300: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = r2
            goto L_0x0043
        L_0x0014:
            java.lang.String r1 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x0012
        L_0x001e:
            r0 = 3
            goto L_0x0043
        L_0x0020:
            java.lang.String r1 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            goto L_0x0012
        L_0x002a:
            r0 = 2
            goto L_0x0043
        L_0x002c:
            java.lang.String r1 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0036
            goto L_0x0012
        L_0x0036:
            r0 = 1
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0042
            goto L_0x0012
        L_0x0042:
            r0 = 0
        L_0x0043:
            switch(r0) {
                case 0: goto L_0x0051;
                case 1: goto L_0x004c;
                case 2: goto L_0x0047;
                case 3: goto L_0x004c;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x0058
        L_0x0047:
            int r2 = parseMpegChannelConfiguration(r4)
            goto L_0x0058
        L_0x004c:
            int r2 = parseDolbyChannelConfiguration(r4)
            goto L_0x0058
        L_0x0051:
            java.lang.String r0 = "value"
            int r2 = parseInt(r4, r0, r2)
        L_0x0058:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r4, r0)
            if (r0 == 0) goto L_0x0058
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    public long parseAvailabilityTimeOffsetUs(XmlPullParser xmlPullParser, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j11;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public String parseBaseUrl(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return UriUtil.resolve(str, parseText(xmlPullParser, "BaseURL"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.util.UUID} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r1 = null;
        r4 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "schemeIdUri"
            java.lang.String r1 = r11.getAttributeValue(r0, r1)
            r2 = 0
            if (r1 == 0) goto L_0x0086
            java.lang.String r1 = com.google.common.base.Ascii.toLowerCase((java.lang.String) r1)
            r1.hashCode()
            r3 = -1
            int r4 = r1.hashCode()
            switch(r4) {
                case 489446379: goto L_0x0032;
                case 755418770: goto L_0x0026;
                case 1812765994: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x003d
        L_0x001a:
            java.lang.String r4 = "urn:mpeg:dash:mp4protection:2011"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0024
            goto L_0x003d
        L_0x0024:
            r3 = 2
            goto L_0x003d
        L_0x0026:
            java.lang.String r4 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0030
            goto L_0x003d
        L_0x0030:
            r3 = 1
            goto L_0x003d
        L_0x0032:
            java.lang.String r4 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            switch(r3) {
                case 0: goto L_0x0081;
                case 1: goto L_0x007e;
                case 2: goto L_0x0041;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0086
        L_0x0041:
            java.lang.String r1 = "value"
            java.lang.String r1 = r11.getAttributeValue(r0, r1)
            java.lang.String r3 = "default_KID"
            java.lang.String r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValueIgnorePrefix(r11, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x007c
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x007c
            java.lang.String r4 = "\\s+"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            java.util.UUID[] r4 = new java.util.UUID[r4]
            r5 = r2
        L_0x0066:
            int r6 = r3.length
            if (r5 >= r6) goto L_0x0074
            r6 = r3[r5]
            java.util.UUID r6 = java.util.UUID.fromString(r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x0066
        L_0x0074:
            java.util.UUID r3 = com.google.android.exoplayer2.C.COMMON_PSSH_UUID
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r3, r4, r0)
            r5 = r0
            goto L_0x008a
        L_0x007c:
            r3 = r0
            goto L_0x0088
        L_0x007e:
            java.util.UUID r3 = com.google.android.exoplayer2.C.WIDEVINE_UUID
            goto L_0x0083
        L_0x0081:
            java.util.UUID r3 = com.google.android.exoplayer2.C.PLAYREADY_UUID
        L_0x0083:
            r1 = r0
            r4 = r1
            goto L_0x0089
        L_0x0086:
            r1 = r0
            r3 = r1
        L_0x0088:
            r4 = r3
        L_0x0089:
            r5 = r4
        L_0x008a:
            r11.next()
            java.lang.String r6 = "ms:laurl"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r6)
            if (r6 == 0) goto L_0x009c
            java.lang.String r5 = "licenseUrl"
            java.lang.String r5 = r11.getAttributeValue(r0, r5)
            goto L_0x00f1
        L_0x009c:
            r6 = 4
            if (r4 != 0) goto L_0x00c9
            java.lang.String r7 = "pssh"
            boolean r7 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTagIgnorePrefix(r11, r7)
            if (r7 == 0) goto L_0x00c9
            int r7 = r11.next()
            if (r7 != r6) goto L_0x00c9
            java.lang.String r3 = r11.getText()
            byte[] r3 = android.util.Base64.decode(r3, r2)
            java.util.UUID r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(r3)
            if (r4 != 0) goto L_0x00c5
            java.lang.String r3 = "MpdParser"
            java.lang.String r6 = "Skipping malformed cenc:pssh data"
            com.google.android.exoplayer2.util.Log.w(r3, r6)
            r3 = r4
            r4 = r0
            goto L_0x00f1
        L_0x00c5:
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x00f1
        L_0x00c9:
            if (r4 != 0) goto L_0x00ee
            java.util.UUID r7 = com.google.android.exoplayer2.C.PLAYREADY_UUID
            boolean r8 = r7.equals(r3)
            if (r8 == 0) goto L_0x00ee
            java.lang.String r8 = "mspr:pro"
            boolean r8 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r8)
            if (r8 == 0) goto L_0x00ee
            int r8 = r11.next()
            if (r8 != r6) goto L_0x00ee
            java.lang.String r4 = r11.getText()
            byte[] r4 = android.util.Base64.decode(r4, r2)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(r7, r4)
            goto L_0x00f1
        L_0x00ee:
            maybeSkipTag(r11)
        L_0x00f1:
            java.lang.String r6 = "ContentProtection"
            boolean r6 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r11, r6)
            if (r6 == 0) goto L_0x008a
            if (r3 == 0) goto L_0x0103
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r0 = new com.google.android.exoplayer2.drm.DrmInitData$SchemeData
            java.lang.String r11 = "video/mp4"
            r0.<init>(r3, r5, r11, r4)
        L_0x0103:
            android.util.Pair r11 = android.util.Pair.create(r1, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, InnerShareParams.CONTENT_TYPE);
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return -1;
    }

    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j11, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long parseLong = parseLong(xmlPullParser2, "id", 0);
        long parseLong2 = parseLong(xmlPullParser2, IBridgeMediaLoader.COLUMN_DURATION, -9223372036854775807L);
        long parseLong3 = parseLong(xmlPullParser2, "presentationTime", 0);
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(parseLong2, 1000, j11);
        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(parseLong3, 1000000, j11);
        String parseString = parseString(xmlPullParser2, "messageData", (String) null);
        byte[] parseEventObject = parseEventObject(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(scaleLargeTimestamp2);
        if (parseString != null) {
            parseEventObject = Util.getUtf8Bytes(parseString);
        }
        return Pair.create(valueOf, buildEvent(str, str2, parseLong, scaleLargeTimestamp, parseEventObject));
    }

    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument((String) null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i11), xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public EventStream parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String parseString = parseString(xmlPullParser, "schemeIdUri", "");
        String parseString2 = parseString(xmlPullParser, "value", "");
        long parseLong = parseLong(xmlPullParser, "timescale", 1);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, parseString, parseString2, parseLong, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            jArr[i11] = ((Long) pair.first).longValue();
            eventMessageArr[i11] = (EventMessage) pair.second;
        }
        return buildEventStream(parseString, parseString2, parseLong, jArr, eventMessageArr);
    }

    public RangedUri parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    public String parseLabel(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseText(xmlPullParser, "Label");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4 A[LOOP:0: B:18:0x0079->B:69:0x01a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser r43, java.lang.String r44) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r42 = this;
            r14 = r42
            r11 = r43
            java.lang.String r0 = "availabilityStartTime"
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r15 = parseDateTime(r11, r0, r12)
            java.lang.String r0 = "mediaPresentationDuration"
            long r17 = parseDuration(r11, r0, r12)
            java.lang.String r0 = "minBufferTime"
            long r19 = parseDuration(r11, r0, r12)
            r0 = 0
            java.lang.String r1 = "type"
            java.lang.String r1 = r11.getAttributeValue(r0, r1)
            java.lang.String r2 = "dynamic"
            boolean r21 = r2.equals(r1)
            if (r21 == 0) goto L_0x0034
            java.lang.String r1 = "minimumUpdatePeriod"
            long r1 = parseDuration(r11, r1, r12)
            r22 = r1
            goto L_0x0036
        L_0x0034:
            r22 = r12
        L_0x0036:
            if (r21 == 0) goto L_0x0042
            java.lang.String r1 = "timeShiftBufferDepth"
            long r1 = parseDuration(r11, r1, r12)
            r24 = r1
            goto L_0x0044
        L_0x0042:
            r24 = r12
        L_0x0044:
            if (r21 == 0) goto L_0x0050
            java.lang.String r1 = "suggestedPresentationDelay"
            long r1 = parseDuration(r11, r1, r12)
            r26 = r1
            goto L_0x0052
        L_0x0050:
            r26 = r12
        L_0x0052:
            java.lang.String r1 = "publishTime"
            long r28 = parseDateTime(r11, r1, r12)
            r1 = 0
            if (r21 == 0) goto L_0x005e
            r3 = r1
            goto L_0x005f
        L_0x005e:
            r3 = r12
        L_0x005f:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r21 == 0) goto L_0x0067
            r1 = r12
        L_0x0067:
            r5 = 0
            r10 = r44
            r30 = r0
            r31 = r30
            r32 = r31
            r33 = r32
            r34 = r1
            r7 = r3
            r36 = r5
            r37 = r36
        L_0x0079:
            r43.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            r38 = 1
            if (r0 == 0) goto L_0x009f
            if (r36 != 0) goto L_0x0098
            long r0 = r14.parseAvailabilityTimeOffsetUs(r11, r7)
            java.lang.String r2 = r14.parseBaseUrl(r11, r10)
            r7 = r0
            r41 = r2
            r10 = r9
            r36 = r38
            goto L_0x0156
        L_0x0098:
            r39 = r7
            r41 = r10
            r10 = r9
            goto L_0x0154
        L_0x009f:
            java.lang.String r0 = "ProgramInformation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            if (r0 == 0) goto L_0x00b2
            com.google.android.exoplayer2.source.dash.manifest.ProgramInformation r0 = r42.parseProgramInformation(r43)
            r30 = r0
        L_0x00ad:
            r41 = r10
            r10 = r9
            goto L_0x0156
        L_0x00b2:
            java.lang.String r0 = "UTCTiming"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            if (r0 == 0) goto L_0x00c1
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r0 = r42.parseUtcTiming(r43)
            r31 = r0
            goto L_0x00ad
        L_0x00c1:
            java.lang.String r0 = "Location"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = r43.nextText()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r32 = r0
            goto L_0x00ad
        L_0x00d4:
            java.lang.String r0 = "ServiceDescription"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            if (r0 == 0) goto L_0x00e3
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r0 = r42.parseServiceDescription(r43)
            r33 = r0
            goto L_0x00ad
        L_0x00e3:
            java.lang.String r0 = "Period"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r11, r0)
            if (r0 == 0) goto L_0x014c
            if (r37 != 0) goto L_0x014c
            r0 = r42
            r1 = r43
            r2 = r10
            r3 = r34
            r5 = r7
            r39 = r7
            r7 = r15
            r44 = r9
            r41 = r10
            r9 = r24
            android.util.Pair r0 = r0.parsePeriod(r1, r2, r3, r5, r7, r9)
            java.lang.Object r1 = r0.first
            com.google.android.exoplayer2.source.dash.manifest.Period r1 = (com.google.android.exoplayer2.source.dash.manifest.Period) r1
            long r2 = r1.startMs
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0130
            if (r21 == 0) goto L_0x0113
            r10 = r44
            r37 = r38
            goto L_0x0154
        L_0x0113:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            int r1 = r44.size()
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unable to determine start of period "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0130:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0141
            r10 = r44
            r34 = r12
            goto L_0x0148
        L_0x0141:
            long r4 = r1.startMs
            long r4 = r4 + r2
            r10 = r44
            r34 = r4
        L_0x0148:
            r10.add(r1)
            goto L_0x0154
        L_0x014c:
            r39 = r7
            r41 = r10
            r10 = r9
            maybeSkipTag(r43)
        L_0x0154:
            r7 = r39
        L_0x0156:
            java.lang.String r0 = "MPD"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r11, r0)
            if (r0 == 0) goto L_0x01a4
            int r0 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0174
            int r0 = (r34 > r12 ? 1 : (r34 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0169
            r3 = r34
            goto L_0x0176
        L_0x0169:
            if (r21 == 0) goto L_0x016c
            goto L_0x0174
        L_0x016c:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Unable to determine duration of static manifest."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0174:
            r3 = r17
        L_0x0176:
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto L_0x019c
            r0 = r42
            r1 = r15
            r5 = r19
            r7 = r21
            r8 = r22
            r38 = r10
            r10 = r24
            r12 = r26
            r14 = r28
            r16 = r30
            r17 = r31
            r18 = r33
            r19 = r32
            r20 = r38
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r0.buildMediaPresentationDescription(r1, r3, r5, r7, r8, r10, r12, r14, r16, r17, r18, r19, r20)
            return r0
        L_0x019c:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "No periods found."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01a4:
            r14 = r42
            r9 = r10
            r10 = r41
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser, java.lang.String):com.google.android.exoplayer2.source.dash.manifest.DashManifest");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0187 A[LOOP:0: B:5:0x0041->B:36:0x0187, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x016e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<com.google.android.exoplayer2.source.dash.manifest.Period, java.lang.Long> parsePeriod(org.xmlpull.v1.XmlPullParser r36, java.lang.String r37, long r38, long r40, long r42, long r44) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r14 = r35
            r15 = r36
            r12 = 0
            java.lang.String r0 = "id"
            java.lang.String r16 = r15.getAttributeValue(r12, r0)
            java.lang.String r0 = "start"
            r1 = r38
            long r17 = parseDuration(r15, r0, r1)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r42 > r10 ? 1 : (r42 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0022
            long r0 = r42 + r17
            r19 = r0
            goto L_0x0024
        L_0x0022:
            r19 = r10
        L_0x0024:
            java.lang.String r0 = "duration"
            long r21 = parseDuration(r15, r0, r10)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r0 = 0
            r9 = r37
            r6 = r40
            r23 = r0
            r25 = r10
            r24 = r12
            r27 = r24
        L_0x0041:
            r36.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x0071
            if (r23 != 0) goto L_0x0064
            long r0 = r14.parseAvailabilityTimeOffsetUs(r15, r6)
            java.lang.String r2 = r14.parseBaseUrl(r15, r9)
            r3 = 1
            r6 = r0
            r9 = r2
            r23 = r3
            r32 = r8
            r33 = r10
            r31 = r12
            r14 = r13
            goto L_0x0166
        L_0x0064:
            r28 = r6
            r32 = r8
            r30 = r9
            r33 = r10
            r31 = r12
            r14 = r13
            goto L_0x0162
        L_0x0071:
            java.lang.String r0 = "AdaptationSet"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x00a2
            r0 = r35
            r1 = r36
            r2 = r9
            r3 = r24
            r4 = r21
            r28 = r6
            r14 = r8
            r30 = r9
            r8 = r25
            r10 = r19
            r37 = r14
            r14 = r13
            r12 = r44
            com.google.android.exoplayer2.source.dash.manifest.AdaptationSet r0 = r0.parseAdaptationSet(r1, r2, r3, r4, r6, r8, r10, r12)
            r14.add(r0)
            r32 = r37
        L_0x0099:
            r31 = 0
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0162
        L_0x00a2:
            r28 = r6
            r37 = r8
            r30 = r9
            r14 = r13
            java.lang.String r0 = "EventStream"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x00bd
            com.google.android.exoplayer2.source.dash.manifest.EventStream r0 = r35.parseEventStream(r36)
            r1 = r37
            r1.add(r0)
            r32 = r1
            goto L_0x0099
        L_0x00bd:
            r1 = r37
            java.lang.String r0 = "SegmentBase"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x00df
            r13 = r35
            r32 = r1
            r11 = 0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r13.parseSegmentBase(r15, r11)
            r24 = r0
            r31 = r11
            r6 = r28
            r9 = r30
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0166
        L_0x00df:
            r13 = r35
            r32 = r1
            r11 = 0
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x0118
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r24 = r13.parseAvailabilityTimeOffsetUs(r15, r9)
            r2 = 0
            r0 = r35
            r1 = r36
            r3 = r19
            r5 = r21
            r7 = r28
            r9 = r24
            r31 = r11
            r11 = r44
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r25 = r24
            r6 = r28
            r9 = r30
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0115:
            r24 = r0
            goto L_0x0166
        L_0x0118:
            r31 = r11
            java.lang.String r0 = "SegmentTemplate"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r0 == 0) goto L_0x014b
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r24 = r13.parseAvailabilityTimeOffsetUs(r15, r10)
            r2 = 0
            com.google.common.collect.ImmutableList r3 = com.google.common.collect.ImmutableList.of()
            r0 = r35
            r1 = r36
            r4 = r19
            r6 = r21
            r8 = r28
            r33 = r10
            r10 = r24
            r12 = r44
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            r25 = r24
            r6 = r28
            r9 = r30
            goto L_0x0115
        L_0x014b:
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.lang.String r0 = "AssetIdentifier"
            boolean r1 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r15, r0)
            if (r1 == 0) goto L_0x015f
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r0 = parseDescriptor(r15, r0)
            r27 = r0
            goto L_0x0162
        L_0x015f:
            maybeSkipTag(r36)
        L_0x0162:
            r6 = r28
            r9 = r30
        L_0x0166:
            java.lang.String r0 = "Period"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r15, r0)
            if (r0 == 0) goto L_0x0187
            r36 = r35
            r37 = r16
            r38 = r17
            r40 = r14
            r41 = r32
            r42 = r27
            com.google.android.exoplayer2.source.dash.manifest.Period r0 = r36.buildPeriod(r37, r38, r40, r41, r42)
            java.lang.Long r1 = java.lang.Long.valueOf(r21)
            android.util.Pair r0 = android.util.Pair.create(r0, r1)
            return r0
        L_0x0187:
            r13 = r14
            r12 = r31
            r8 = r32
            r10 = r33
            r14 = r35
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parsePeriod(org.xmlpull.v1.XmlPullParser, java.lang.String, long, long, long, long):android.util.Pair");
    }

    public ProgramInformation parseProgramInformation(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String parseString = parseString(xmlPullParser, "moreInformationURL", (String) null);
        String parseString2 = parseString(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, parseString, parseString2);
            }
            str3 = str4;
        }
    }

    public RangedUri parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j11;
        long j12;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            j12 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j11 = (Long.parseLong(split[1]) - j12) + 1;
                return buildRangedUri(attributeValue, j12, j11);
            }
        } else {
            j12 = 0;
        }
        j11 = -1;
        return buildRangedUri(attributeValue, j12, j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x01e4 A[LOOP:0: B:1:0x0068->B:49:0x01e4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x019b A[EDGE_INSN: B:50:0x019b->B:44:0x019b ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, int r41, float r42, int r43, int r44, java.lang.String r45, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r46, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r47, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r48, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r49, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r50, long r51, long r53, long r55, long r57, long r59) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r15 = r35
            r14 = r36
            r0 = 0
            java.lang.String r1 = "id"
            java.lang.String r16 = r14.getAttributeValue(r0, r1)
            java.lang.String r1 = "bandwidth"
            r2 = -1
            int r17 = parseInt(r14, r1, r2)
            java.lang.String r1 = "mimeType"
            r2 = r38
            java.lang.String r18 = parseString(r14, r1, r2)
            java.lang.String r1 = "codecs"
            r2 = r39
            java.lang.String r19 = parseString(r14, r1, r2)
            java.lang.String r1 = "width"
            r2 = r40
            int r20 = parseInt(r14, r1, r2)
            java.lang.String r1 = "height"
            r2 = r41
            int r21 = parseInt(r14, r1, r2)
            r1 = r42
            float r22 = parseFrameRate(r14, r1)
            java.lang.String r1 = "audioSamplingRate"
            r2 = r44
            int r23 = parseInt(r14, r1, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r1 = r48
            r12.<init>(r1)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r49
            r9.<init>(r10)
            r1 = 0
            r7 = r37
            r24 = r43
            r5 = r55
            r25 = r0
            r26 = r1
            r0 = r50
            r1 = r57
        L_0x0068:
            r36.next()
            java.lang.String r3 = "BaseURL"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0092
            if (r26 != 0) goto L_0x0089
            long r3 = r15.parseAvailabilityTimeOffsetUs(r14, r5)
            java.lang.String r5 = r15.parseBaseUrl(r14, r7)
            r6 = 1
            r31 = r5
            r26 = r6
            r15 = r13
            r7 = r24
            r24 = r0
            r5 = r3
            goto L_0x00a4
        L_0x0089:
            r29 = r5
            r31 = r7
            r15 = r13
            r13 = r11
            r11 = r9
            goto L_0x018d
        L_0x0092:
            java.lang.String r3 = "AudioChannelConfiguration"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x00a8
            int r3 = r35.parseAudioChannelConfiguration(r36)
            r24 = r0
            r31 = r7
            r15 = r13
            r7 = r3
        L_0x00a4:
            r13 = r11
            r11 = r9
            goto L_0x0193
        L_0x00a8:
            java.lang.String r3 = "SegmentBase"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x00be
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.parseSegmentBase(r14, r0)
            r31 = r7
            r15 = r13
            r7 = r24
            r24 = r0
            goto L_0x00a4
        L_0x00be:
            java.lang.String r3 = "SegmentList"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x00f8
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r35
            r1 = r36
            r3 = r51
            r29 = r5
            r5 = r53
            r31 = r7
            r7 = r29
            r32 = r9
            r9 = r27
            r33 = r11
            r34 = r12
            r11 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentList r0 = r0.parseSegmentList(r1, r2, r3, r5, r7, r9, r11)
            r15 = r13
        L_0x00ea:
            r7 = r24
            r1 = r27
        L_0x00ee:
            r5 = r29
            r11 = r32
            r13 = r33
            r12 = r34
            goto L_0x0191
        L_0x00f8:
            r29 = r5
            r31 = r7
            r32 = r9
            r33 = r11
            r34 = r12
            java.lang.String r3 = "SegmentTemplate"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0127
            long r27 = r15.parseAvailabilityTimeOffsetUs(r14, r1)
            r2 = r0
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r2 = (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r35
            r1 = r36
            r3 = r49
            r4 = r51
            r6 = r53
            r8 = r29
            r10 = r27
            r15 = r13
            r12 = r59
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.parseSegmentTemplate(r1, r2, r3, r4, r6, r8, r10, r12)
            goto L_0x00ea
        L_0x0127:
            r15 = r13
            java.lang.String r3 = "ContentProtection"
            boolean r3 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r3 == 0) goto L_0x0148
            android.util.Pair r3 = r35.parseContentProtection(r36)
            java.lang.Object r4 = r3.first
            if (r4 == 0) goto L_0x013c
            r25 = r4
            java.lang.String r25 = (java.lang.String) r25
        L_0x013c:
            java.lang.Object r3 = r3.second
            if (r3 == 0) goto L_0x0145
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r3 = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData) r3
            r15.add(r3)
        L_0x0145:
            r7 = r24
            goto L_0x00ee
        L_0x0148:
            java.lang.String r3 = "InbandEventStream"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x015e
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r13 = r33
            r13.add(r3)
            r11 = r32
            r12 = r34
            goto L_0x018d
        L_0x015e:
            r13 = r33
            java.lang.String r3 = "EssentialProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0174
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r12 = r34
            r12.add(r3)
            r11 = r32
            goto L_0x018d
        L_0x0174:
            r12 = r34
            java.lang.String r3 = "SupplementalProperty"
            boolean r4 = com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(r14, r3)
            if (r4 == 0) goto L_0x0188
            com.google.android.exoplayer2.source.dash.manifest.Descriptor r3 = parseDescriptor(r14, r3)
            r11 = r32
            r11.add(r3)
            goto L_0x018d
        L_0x0188:
            r11 = r32
            maybeSkipTag(r36)
        L_0x018d:
            r7 = r24
            r5 = r29
        L_0x0191:
            r24 = r0
        L_0x0193:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(r14, r0)
            if (r0 == 0) goto L_0x01e4
            r0 = r35
            r1 = r16
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r7
            r7 = r23
            r8 = r17
            r9 = r45
            r10 = r46
            r27 = r11
            r11 = r47
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r28
            r14 = r27
            com.google.android.exoplayer2.Format r0 = r0.buildFormat(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r24 == 0) goto L_0x01c5
            goto L_0x01cc
        L_0x01c5:
            com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase r1 = new com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r24 = r1
        L_0x01cc:
            com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo r1 = new com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo
            r2 = -1
            r36 = r1
            r37 = r0
            r38 = r31
            r39 = r24
            r40 = r25
            r41 = r15
            r42 = r29
            r43 = r2
            r36.<init>(r37, r38, r39, r40, r41, r42, r43)
            return r1
        L_0x01e4:
            r10 = r49
            r9 = r11
            r11 = r13
            r13 = r15
            r0 = r24
            r15 = r35
            r24 = r7
            r7 = r31
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase, long, long, long, long, long):com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    public int parseRoleFlagsFromAccessibilityDescriptors(List<Descriptor> list) {
        int parseTvaAudioPurposeCsValue;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseRoleFlagsFromDashRoleScheme(descriptor.value);
            } else if (Ascii.equalsIgnoreCase("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.schemeIdUri)) {
                parseTvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(descriptor.value);
            }
            i11 |= parseTvaAudioPurposeCsValue;
        }
        return i11;
    }

    public int parseRoleFlagsFromDashRoleScheme(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals(MessengerShareContentUtility.SUBTITLE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals("description")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c11 = 4;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c11 = 5;
                    break;
                }
                break;
            case 3343801:
                if (str.equals(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                    c11 = 6;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c11 = 7;
                    break;
                }
                break;
            case 552573414:
                if (str.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    c11 = 8;
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c11 = 9;
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 3:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 5:
                return 16;
            case 6:
                return 1;
            case 7:
                return 256;
            case 8:
                return 64;
            case 9:
                return 8;
            case 10:
                return 32;
            case 11:
                return 4;
            default:
                return 0;
        }
    }

    public int parseRoleFlagsFromProperties(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/trickmode", list.get(i12).schemeIdUri)) {
                i11 |= 16384;
            }
        }
        return i11;
    }

    public int parseRoleFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i11 |= parseRoleFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i11;
    }

    public SegmentBase.SingleSegmentBase parseSegmentBase(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long parseLong = parseLong(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.timescale : 1);
        long j13 = 0;
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.presentationTimeOffset : 0);
        long j14 = singleSegmentBase2 != null ? singleSegmentBase2.indexStart : 0;
        if (singleSegmentBase2 != null) {
            j13 = singleSegmentBase2.indexLength;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            long parseLong3 = Long.parseLong(split[0]);
            j11 = (Long.parseLong(split[1]) - parseLong3) + 1;
            j12 = parseLong3;
        } else {
            j11 = j13;
            j12 = j14;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.initialization;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentBase"));
        return buildSingleSegmentBase(rangedUri, parseLong, parseLong2, j12, j11);
    }

    public SegmentBase.SegmentList parseSegmentList(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j16 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentList2 != null ? segmentList2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentList2 != null ? segmentList2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, IBridgeMediaLoader.COLUMN_DURATION, segmentList2 != null ? segmentList2.duration : -9223372036854775807L);
        if (segmentList2 != null) {
            j16 = segmentList2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j16);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j13, j14);
        List<SegmentBase.SegmentTimelineElement> list = null;
        List list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list = parseSegmentTimeline(xmlPullParser, parseLong, j12);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.initialization;
            }
            if (list == null) {
                list = segmentList2.segmentTimeline;
            }
            if (list2 == null) {
                list2 = segmentList2.mediaSegments;
            }
        }
        return buildSegmentList(rangedUri, parseLong, parseLong2, parseLong4, parseLong3, list, finalAvailabilityTimeOffset, list2, j15, j11);
    }

    public SegmentBase.SegmentTemplate parseSegmentTemplate(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j11, long j12, long j13, long j14, long j15) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j16 = 1;
        long parseLong = parseLong(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.timescale : 1);
        long parseLong2 = parseLong(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.presentationTimeOffset : 0);
        long parseLong3 = parseLong(xmlPullParser2, IBridgeMediaLoader.COLUMN_DURATION, segmentTemplate2 != null ? segmentTemplate2.duration : -9223372036854775807L);
        if (segmentTemplate2 != null) {
            j16 = segmentTemplate2.startNumber;
        }
        long parseLong4 = parseLong(xmlPullParser2, "startNumber", j16);
        long parseLastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        long finalAvailabilityTimeOffset = getFinalAvailabilityTimeOffset(j13, j14);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        UrlTemplate parseUrlTemplate = parseUrlTemplate(xmlPullParser2, "media", segmentTemplate2 != null ? segmentTemplate2.mediaTemplate : null);
        UrlTemplate parseUrlTemplate2 = parseUrlTemplate(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.initializationTemplate : null);
        RangedUri rangedUri = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Initialization")) {
                rangedUri = parseInitialization(xmlPullParser);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTimeline")) {
                list2 = parseSegmentTimeline(xmlPullParser, parseLong, j12);
            } else {
                maybeSkipTag(xmlPullParser);
            }
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTemplate")) {
                break;
            }
        }
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.initialization;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.segmentTimeline;
            }
        }
        return buildSegmentTemplate(rangedUri, parseLong, parseLong2, parseLong4, parseLastSegmentNumberSupplementalProperty, parseLong3, list2, finalAvailabilityTimeOffset, parseUrlTemplate2, parseUrlTemplate, j15, j11);
    }

    public List<SegmentBase.SegmentTimelineElement> parseSegmentTimeline(XmlPullParser xmlPullParser, long j11, long j12) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j13 = 0;
        boolean z11 = false;
        int i11 = 0;
        long j14 = -9223372036854775807L;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "S")) {
                long parseLong = parseLong(xmlPullParser2, "t", -9223372036854775807L);
                if (z11) {
                    j13 = addSegmentTimelineElementsToList(arrayList, j13, j14, i11, parseLong);
                }
                if (parseLong == -9223372036854775807L) {
                    parseLong = j13;
                }
                j14 = parseLong(xmlPullParser2, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, -9223372036854775807L);
                i11 = parseInt(xmlPullParser2, "r", 0);
                z11 = true;
                j13 = parseLong;
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser2, "SegmentTimeline"));
        if (z11) {
            addSegmentTimelineElementsToList(arrayList, j13, j14, i11, Util.scaleLargeTimestamp(j12, j11, 1000));
        }
        return arrayList;
    }

    public RangedUri parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public int parseSelectionFlagsFromDashRoleScheme(String str) {
        if (str == null) {
            return 0;
        }
        if (!str.equals("forced_subtitle")) {
            return !str.equals(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT) ? 0 : 1;
        }
        return 2;
    }

    public int parseSelectionFlagsFromRoleDescriptors(List<Descriptor> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            Descriptor descriptor = list.get(i12);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", descriptor.schemeIdUri)) {
                i11 |= parseSelectionFlagsFromDashRoleScheme(descriptor.value);
            }
        }
        return i11;
    }

    public ServiceDescriptionElement parseServiceDescription(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        float f11 = -3.4028235E38f;
        float f12 = -3.4028235E38f;
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser2, "Latency")) {
                j11 = parseLong(xmlPullParser2, "target", -9223372036854775807L);
                j12 = parseLong(xmlPullParser2, MessageKey.MSG_ACCEPT_TIME_MIN, -9223372036854775807L);
                j13 = parseLong(xmlPullParser2, "max", -9223372036854775807L);
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser2, "PlaybackRate")) {
                f11 = parseFloat(xmlPullParser2, MessageKey.MSG_ACCEPT_TIME_MIN, -3.4028235E38f);
                f12 = parseFloat(xmlPullParser2, "max", -3.4028235E38f);
            }
            long j14 = j11;
            long j15 = j12;
            long j16 = j13;
            float f13 = f11;
            float f14 = f12;
            if (XmlPullParserUtil.isEndTag(xmlPullParser2, "ServiceDescription")) {
                return new ServiceDescriptionElement(j14, j15, j16, f13, f14);
            }
            j11 = j14;
            j12 = j15;
            j13 = j16;
            f11 = f13;
            f12 = f14;
        }
    }

    public int parseTvaAudioPurposeCsValue(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    public UrlTemplate parseUrlTemplate(XmlPullParser xmlPullParser, String str, UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    public UtcTimingElement parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, "value"));
    }

    public DashManifest parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.xmlParserFactory.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return parseMediaPresentationDescription(newPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e11) {
            throw new ParserException((Throwable) e11);
        }
    }
}

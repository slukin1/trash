package com.tencent.liteav.txcvodplayer.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.base.util.LiteavLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public e f21930a;

    /* renamed from: b  reason: collision with root package name */
    public f f21931b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21932c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21933d = "http://playvideo.qcloud.com/getplayinfo/v2";

    /* renamed from: e  reason: collision with root package name */
    private final String f21934e = "https://playvideo.qcloud.com/getplayinfo/v2";

    /* renamed from: f  reason: collision with root package name */
    private final int f21935f = 0;

    /* renamed from: g  reason: collision with root package name */
    private final int f21936g = 1;

    /* renamed from: h  reason: collision with root package name */
    private Thread f21937h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f21938i = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            d dVar = d.this;
            e eVar = dVar.f21930a;
            if (eVar != null) {
                int i11 = message.what;
                if (i11 == 0) {
                    eVar.a(dVar);
                } else if (i11 == 1) {
                    eVar.a(dVar, (String) message.obj, message.arg1);
                }
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private String f21939j = "{\"code\":0,\"message\":\"\",\"playerInfo\":{\"playerId\":\"0\",\"name\":\"初始播放器\",\"defaultVideoClassification\":\"SD\",\"videoClassification\":[{\"id\":\"FLU\",\"name\":\"流畅\",\"definitionList\":[10,510,210,610,10046,710]},{\"id\":\"SD\",\"name\":\"标清\",\"definitionList\":[20,520,220,620,10047,720]},{\"id\":\"HD\",\"name\":\"高清\",\"definitionList\":[30,530,230,630,10048,730]},{\"id\":\"FHD\",\"name\":\"全高清\",\"definitionList\":[40,540,240,640,10049,740]},{\"id\":\"2K\",\"name\":\"2K\",\"definitionList\":[70,570,270,670,370,770]},{\"id\":\"4K\",\"name\":\"4K\",\"definitionList\":[80,580,280,680,380,780]}],\"logoLocation\":\"1\",\"logoPic\":\"\",\"logoUrl\":\"\"},\"coverInfo\":{\"coverUrl\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/coverBySnapshot/1513156403_1311093072.100_0.jpg?t=5c08d9fa&us=someus&sign=95f34beb353fe32cfe7f8b5e79cc28b1\"},\"imageSpriteInfo\":{\"imageSpriteList\":[{\"definition\":10,\"height\":80,\"width\":142,\"totalCount\":4,\"imageUrls\":[\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271_00001.jpg?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"],\"webVttUrl\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/imageSprite/1513156058_533711271.vtt?t=5c08d9fa&us=someus&sign=79449db4e1fb05a3becfa096613659c3\"}]},\"videoInfo\":{\"sourceVideo\":{\"url\":\"http://1255566655.vod2.myqcloud.com/ca754badvodgzp1255566655/8f5fbff14564972818519602447/uAnXX0OMLSAA.wmv?t=5c08d9fa&us=someus&sign=659af5dd3f27eb92dc4ed74eb561daa4\",\"definition\":0,\"duration\":30,\"floatDuration\":30.093000411987305,\"size\":26246026,\"bitrate\":6134170,\"height\":720,\"width\":1280,\"container\":\"asf\",\"md5\":\"\",\"videoStreamList\":[{\"bitrate\":5942130,\"height\":720,\"width\":1280,\"codec\":\"vc1\",\"fps\":29}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":192040,\"codec\":\"wmav2\"}]},\"mas©terPlayList1\":{\"idrAligned\":false,\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/master_playlist.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10000,\"md5\":\"23ecc2cfe4cb7c8f87af41993ba8c09c\"},\"transcodeList\":[{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f220.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":220,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":796,\"bitrate\":646036,\"height\":360,\"width\":640,\"container\":\"hls,applehttp\",\"md5\":\"dce044407826b4d809c16b6d1a9e9f13\",\"videoStreamList\":[{\"bitrate\":607449,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f230.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":230,\"duration\":30,\"floatDuration\":30.04170036315918,\"size\":802,\"bitrate\":1224776,\"height\":720,\"width\":1280,\"container\":\"hls,applehttp\",\"md5\":\"f07bb0be9e2fee967d87b6c310d3c036\",\"videoStreamList\":[{\"bitrate\":1186189,\"height\":720,\"width\":1280,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f240.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":240,\"duration\":30,\"floatDuration\":0,\"size\":809,\"bitrate\":2866685,\"height\":1080,\"width\":1920,\"container\":\"hls,applehttp\",\"md5\":\"ff8190cf07afceb8ed053b198453e954\",\"videoStreamList\":[{\"bitrate\":2828098,\"height\":1080,\"width\":1920,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f210.m3u8?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":210,\"duration\":30,\"floatDuration\":30.08329963684082,\"size\":788,\"bitrate\":358908,\"height\":180,\"width\":320,\"container\":\"hls,applehttp\",\"md5\":\"5fa784e0a588c51dc2d7428ad6787079\",\"videoStreamList\":[{\"bitrate\":320321,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":38587,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f10.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":10,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":1169168,\"bitrate\":303916,\"height\":180,\"width\":320,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"85002ed20125acf150d014b192cf39a0\",\"videoStreamList\":[{\"bitrate\":255698,\"height\":180,\"width\":320,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]},{\"url\":\"http://1255566655.vod2.myqcloud.com/7e9cee55vodtransgzp1255566655/8f5fbff14564972818519602447/v.f20.mp4?t=5c08d9fa&us=someus&sign=66290475b7182c89193f03b8f74a979d\",\"definition\":20,\"duration\":30,\"floatDuration\":30.139400482177734,\"size\":2158411,\"bitrate\":566647,\"height\":360,\"width\":640,\"container\":\"mov,mp4,m4a,3gp,3g2,mj2\",\"md5\":\"cba3630e5f92325041da7fee336246b6\",\"videoStreamList\":[{\"bitrate\":518429,\"height\":360,\"width\":640,\"codec\":\"h264\",\"fps\":24}],\"audioStreamList\":[{\"samplingRate\":44100,\"bitrate\":48218,\"codec\":\"aac\"}]}]}}";

    public final int a(int i11, String str, String str2, String str3, int i12, String str4) {
        if (i11 == 0 || str == null) {
            return -1;
        } else if ((str2 != null || i12 > 0) && str4 == null) {
            return -1;
        } else {
            final int i13 = i11;
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final int i14 = i12;
            final String str8 = str4;
            AnonymousClass2 r12 = new Thread("getPlayInfo") {
                /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0159 */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x0155 A[SYNTHETIC, Splitter:B:52:0x0155] */
                /* JADX WARNING: Removed duplicated region for block: B:58:0x0162 A[SYNTHETIC, Splitter:B:58:0x0162] */
                /* JADX WARNING: Removed duplicated region for block: B:62:0x0168 A[SYNTHETIC, Splitter:B:62:0x0168] */
                /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
                /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x0137=Splitter:B:49:0x0137, B:55:0x0159=Splitter:B:55:0x0159} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r13 = this;
                        java.lang.String r0 = "TXCVodPlayerNetApi"
                        r1 = -2
                        r2 = 0
                        android.os.Looper.prepare()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        com.tencent.liteav.txcvodplayer.b.d r3 = com.tencent.liteav.txcvodplayer.b.d.this     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        boolean r3 = r3.f21932c     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4 = 2
                        r5 = 0
                        r6 = 3
                        java.lang.String r7 = "%s/%d/%s"
                        r8 = 1
                        if (r3 == 0) goto L_0x002c
                        java.util.Locale r3 = java.util.Locale.ROOT     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r9 = "https://playvideo.qcloud.com/getplayinfo/v2"
                        r6[r5] = r9     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        int r5 = r4     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r6[r8] = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r6[r4] = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r3 = java.lang.String.format(r3, r7, r6)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        goto L_0x0044
                    L_0x002c:
                        java.util.Locale r3 = java.util.Locale.ROOT     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r9 = "http://playvideo.qcloud.com/getplayinfo/v2"
                        r6[r5] = r9     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        int r5 = r4     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r6[r8] = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r6[r4] = r5     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r3 = java.lang.String.format(r3, r7, r6)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x0044:
                        java.lang.String r4 = r6     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = r7     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        int r6 = r8     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r7 = r9     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r9.<init>()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r10 = "&"
                        if (r4 == 0) goto L_0x0069
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r12 = "t="
                        r11.<init>(r12)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r11.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r11.append(r10)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r4 = r11.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r9.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x0069:
                        if (r5 == 0) goto L_0x007f
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r11 = "us="
                        r4.<init>(r11)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r10)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r9.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x007f:
                        if (r7 == 0) goto L_0x0095
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = "sign="
                        r4.<init>(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r7)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r10)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r9.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x0095:
                        if (r6 < 0) goto L_0x00ab
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = "exper="
                        r4.<init>(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r6)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.append(r10)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r9.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x00ab:
                        int r4 = r9.length()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        if (r4 <= r8) goto L_0x00b9
                        int r4 = r9.length()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        int r4 = r4 - r8
                        r9.deleteCharAt(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x00b9:
                        java.lang.String r4 = r9.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        if (r4 == 0) goto L_0x00d3
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r5.<init>()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r5.append(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r3 = "?"
                        r5.append(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r5.append(r4)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r3 = r5.toString()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x00d3:
                        java.net.URL r4 = new java.net.URL     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.<init>(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r5 = "getplayinfo: "
                        java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r3 = r5.concat(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        com.tencent.liteav.base.util.LiteavLog.d(r0, r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.net.URLConnection r3 = r4.openConnection()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r3.connect()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        int r4 = r3.getResponseCode()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r5 = 200(0xc8, float:2.8E-43)
                        if (r4 != r5) goto L_0x0126
                        java.io.InputStream r3 = r3.getInputStream()     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r5.<init>(r3)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        r4.<init>(r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        r2.<init>()     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                    L_0x0109:
                        java.lang.String r3 = r4.readLine()     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        if (r3 == 0) goto L_0x0113
                        r2.append(r3)     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        goto L_0x0109
                    L_0x0113:
                        com.tencent.liteav.txcvodplayer.b.d r3 = com.tencent.liteav.txcvodplayer.b.d.this     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        com.tencent.liteav.txcvodplayer.b.d.a((com.tencent.liteav.txcvodplayer.b.d) r3, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0124, Exception -> 0x0121, all -> 0x011e }
                        r2 = r4
                        goto L_0x012e
                    L_0x011e:
                        r0 = move-exception
                        r2 = r4
                        goto L_0x0166
                    L_0x0121:
                        r3 = move-exception
                        r2 = r4
                        goto L_0x0137
                    L_0x0124:
                        r2 = r4
                        goto L_0x0159
                    L_0x0126:
                        com.tencent.liteav.txcvodplayer.b.d r3 = com.tencent.liteav.txcvodplayer.b.d.this     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                        java.lang.String r4 = "Request failed"
                        r5 = -1
                        r3.a((java.lang.String) r4, (int) r5)     // Catch:{ JSONException -> 0x0159, Exception -> 0x0136 }
                    L_0x012e:
                        if (r2 == 0) goto L_0x0165
                        r2.close()     // Catch:{ IOException -> 0x0133 }
                    L_0x0133:
                        return
                    L_0x0134:
                        r0 = move-exception
                        goto L_0x0166
                    L_0x0136:
                        r3 = move-exception
                    L_0x0137:
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0134 }
                        java.lang.String r5 = "http exception: "
                        r4.<init>(r5)     // Catch:{ all -> 0x0134 }
                        java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0134 }
                        r4.append(r3)     // Catch:{ all -> 0x0134 }
                        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0134 }
                        com.tencent.liteav.base.util.LiteavLog.d(r0, r3)     // Catch:{ all -> 0x0134 }
                        com.tencent.liteav.txcvodplayer.b.d r0 = com.tencent.liteav.txcvodplayer.b.d.this     // Catch:{ all -> 0x0134 }
                        java.lang.String r3 = "The request was exceptional"
                        r0.a((java.lang.String) r3, (int) r1)     // Catch:{ all -> 0x0134 }
                        if (r2 == 0) goto L_0x0165
                        r2.close()     // Catch:{ IOException -> 0x0158 }
                    L_0x0158:
                        return
                    L_0x0159:
                        com.tencent.liteav.txcvodplayer.b.d r0 = com.tencent.liteav.txcvodplayer.b.d.this     // Catch:{ all -> 0x0134 }
                        java.lang.String r3 = "Incorrect format"
                        r0.a((java.lang.String) r3, (int) r1)     // Catch:{ all -> 0x0134 }
                        if (r2 == 0) goto L_0x0165
                        r2.close()     // Catch:{ IOException -> 0x0165 }
                    L_0x0165:
                        return
                    L_0x0166:
                        if (r2 == 0) goto L_0x016b
                        r2.close()     // Catch:{ IOException -> 0x016b }
                    L_0x016b:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.b.d.AnonymousClass2.run():void");
                }
            };
            this.f21937h = r12;
            r12.start();
            return 0;
        }
    }

    public final void a(String str, int i11) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i11;
        message.obj = str;
        this.f21938i.sendMessage(message);
    }

    public final void a(e eVar) {
        this.f21930a = eVar;
    }

    public final f a() {
        return this.f21931b;
    }

    public static /* synthetic */ void a(d dVar, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int i11 = jSONObject.getInt("code");
        if (i11 != 0) {
            String string = jSONObject.getString("message");
            LiteavLog.e("TXCVodPlayerNetApi", string);
            dVar.a(string, i11);
            return;
        }
        f fVar = new f(jSONObject);
        dVar.f21931b = fVar;
        if (fVar.a() == null) {
            dVar.a("No playback address", -3);
        } else {
            dVar.f21938i.sendEmptyMessage(0);
        }
    }
}

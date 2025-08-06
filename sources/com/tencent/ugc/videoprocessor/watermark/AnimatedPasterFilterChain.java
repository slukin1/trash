package com.tencent.ugc.videoprocessor.watermark;

import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPaster;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimatedPasterFilterChain extends PasterBase {
    private static final String TAG = "AnimatedPasterFilterChain";
    private List<TXVideoEditConstants.TXAnimatedPaster> mAnimatedPasterList;
    private CopyOnWriteArrayList<AnimatedPaster> mNormalizedList = new CopyOnWriteArrayList<>();

    private TXVideoEditConstants.TXAnimatedPaster construct(TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster, TXVideoEditConstants.TXRect tXRect) {
        TXVideoEditConstants.TXAnimatedPaster tXAnimatedPaster2 = new TXVideoEditConstants.TXAnimatedPaster();
        tXAnimatedPaster2.frame = tXRect;
        tXAnimatedPaster2.animatedPasterPathFolder = tXAnimatedPaster.animatedPasterPathFolder;
        tXAnimatedPaster2.startTime = tXAnimatedPaster.startTime;
        tXAnimatedPaster2.endTime = tXAnimatedPaster.endTime;
        tXAnimatedPaster2.rotation = tXAnimatedPaster.rotation;
        return tXAnimatedPaster2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r6 != null) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String parseJsonFromFile(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0033, all -> 0x0031 }
        L_0x0012:
            java.lang.String r1 = r6.readLine()     // Catch:{ IOException -> 0x002f }
            if (r1 == 0) goto L_0x0028
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002f }
            r2.<init>()     // Catch:{ IOException -> 0x002f }
            r2.append(r0)     // Catch:{ IOException -> 0x002f }
            r2.append(r1)     // Catch:{ IOException -> 0x002f }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x002f }
            goto L_0x0012
        L_0x0028:
            r6.close()     // Catch:{ IOException -> 0x002f }
        L_0x002b:
            r6.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0041
        L_0x002f:
            r1 = move-exception
            goto L_0x0037
        L_0x0031:
            r0 = move-exception
            goto L_0x0044
        L_0x0033:
            r6 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
        L_0x0037:
            java.lang.String r2 = "AnimatedPasterFilterChain"
            java.lang.String r3 = "read file failed."
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x0041
            goto L_0x002b
        L_0x0041:
            return r0
        L_0x0042:
            r0 = move-exception
            r1 = r6
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.watermark.AnimatedPasterFilterChain.parseJsonFromFile(java.lang.String):java.lang.String");
    }

    private AnimatedPasterJsonConfig parsePaster(String str) {
        String parseJsonFromFile = parseJsonFromFile(str + AnimatedPasterJsonConfig.FILE_NAME);
        if (TextUtils.isEmpty(parseJsonFromFile)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(parseJsonFromFile);
            AnimatedPasterJsonConfig animatedPasterJsonConfig = new AnimatedPasterJsonConfig();
            try {
                animatedPasterJsonConfig.mName = jSONObject.getString("name");
                animatedPasterJsonConfig.mCount = jSONObject.getInt("count");
                animatedPasterJsonConfig.mPeriod = jSONObject.getInt(AnimatedPasterJsonConfig.CONFIG_PERIOD);
                animatedPasterJsonConfig.mWidth = jSONObject.getInt("width");
                animatedPasterJsonConfig.mHeight = jSONObject.getInt("height");
                animatedPasterJsonConfig.mKeyframe = jSONObject.getInt(AnimatedPasterJsonConfig.CONFIG_KEYFRAME);
                JSONArray jSONArray = jSONObject.getJSONArray(AnimatedPasterJsonConfig.CONFIG_KEYFRAME_ARRAY);
                for (int i11 = 0; i11 < animatedPasterJsonConfig.mCount; i11++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                    AnimatedPasterJsonConfig.PasterPicture pasterPicture = new AnimatedPasterJsonConfig.PasterPicture();
                    pasterPicture.mPictureName = jSONObject2.getString("picture");
                    animatedPasterJsonConfig.mFrameArray.add(pasterPicture);
                }
            } catch (JSONException e11) {
                LiteavLog.e(TAG, "failed to get value from json.", (Throwable) e11);
            }
            return animatedPasterJsonConfig;
        } catch (JSONException e12) {
            LiteavLog.e(TAG, "parse invalid json string", (Throwable) e12);
            return null;
        }
    }

    public void clear() {
        super.clear();
        this.mNormalizedList.clear();
        List<TXVideoEditConstants.TXAnimatedPaster> list = this.mAnimatedPasterList;
        if (list != null) {
            list.clear();
        }
        this.mAnimatedPasterList = null;
    }

    public List<AnimatedPaster> getAnimatedPasterList() {
        return this.mNormalizedList;
    }

    public void normalized(int i11, int i12, int i13) {
        int i14;
        Iterator<TXVideoEditConstants.TXAnimatedPaster> it2;
        AnimatedPasterJsonConfig animatedPasterJsonConfig;
        int i15;
        List<TXVideoEditConstants.TXAnimatedPaster> list = this.mAnimatedPasterList;
        if (list != null && list.size() != 0) {
            Iterator<TXVideoEditConstants.TXAnimatedPaster> it3 = this.mAnimatedPasterList.iterator();
            while (it3.hasNext()) {
                TXVideoEditConstants.TXAnimatedPaster next = it3.next();
                if (next != null) {
                    TXVideoEditConstants.TXAnimatedPaster construct = construct(next, calculateRect(i11, i12, i13, next.frame));
                    AnimatedPasterJsonConfig parsePaster = parsePaster(construct.animatedPasterPathFolder);
                    if (parsePaster != null && (i14 = parsePaster.mCount) > 0) {
                        long j11 = construct.startTime;
                        long j12 = construct.endTime - j11;
                        int i16 = parsePaster.mPeriod;
                        int i17 = i16 / i14;
                        int i18 = (int) (j12 / ((long) i16));
                        if (j12 % ((long) i16) > 0) {
                            i18++;
                        }
                        int i19 = 0;
                        while (i19 < i18) {
                            int i21 = 0;
                            while (true) {
                                if (i21 >= parsePaster.mCount) {
                                    it2 = it3;
                                    animatedPasterJsonConfig = parsePaster;
                                    i15 = i19;
                                    break;
                                }
                                long j13 = ((long) i17) + j11;
                                i15 = i19;
                                if (j13 > construct.endTime) {
                                    it2 = it3;
                                    animatedPasterJsonConfig = parsePaster;
                                    break;
                                }
                                AnimatedPaster animatedPaster = new AnimatedPaster();
                                Iterator<TXVideoEditConstants.TXAnimatedPaster> it4 = it3;
                                animatedPaster.mPasterPath = construct.animatedPasterPathFolder + parsePaster.mFrameArray.get(i21).mPictureName + PictureMimeType.PNG;
                                animatedPaster.mFrame = construct.frame;
                                animatedPaster.mStartTime = j11;
                                animatedPaster.mEndTime = j13;
                                animatedPaster.mRotation = construct.rotation;
                                this.mNormalizedList.add(animatedPaster);
                                j11 = animatedPaster.mEndTime;
                                i21++;
                                i19 = i15;
                                it3 = it4;
                                parsePaster = parsePaster;
                            }
                            i19 = i15 + 1;
                            it3 = it2;
                            parsePaster = animatedPasterJsonConfig;
                        }
                    }
                } else {
                    int i22 = i11;
                    int i23 = i12;
                    int i24 = i13;
                }
            }
        }
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list, Size size) {
        this.mRenderSize = size;
        this.mAnimatedPasterList = list;
        this.mNormalizedList.clear();
    }
}

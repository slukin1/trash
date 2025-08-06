package com.huawei.face.antispoofing.service;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.face.antispoofing.listener.FaceAntispoofingResultListener;
import com.huawei.face.antispoofing.meta.DetectTypeEnum;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;
import com.huawei.face.antispoofing.utils.LogFace;
import com.huawei.face.antispoofing.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class DetectorSession {

    /* renamed from: a  reason: collision with root package name */
    private volatile long f37586a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f37587b;

    /* renamed from: c  reason: collision with root package name */
    private volatile DetectTypeEnum f37588c;

    /* renamed from: d  reason: collision with root package name */
    private volatile List<DetectTypeEnum> f37589d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile String f37590e;

    /* renamed from: f  reason: collision with root package name */
    private volatile AtomicLong f37591f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public FaceAntispoofingResultListener f37592g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicBoolean f37593h;

    /* renamed from: i  reason: collision with root package name */
    private int f37594i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            String unused = DetectorSession.this.f37590e = null;
        }
    }

    public DetectorSession(FaceAntispoofingSdk.InputData inputData, FaceAntispoofingResultListener faceAntispoofingResultListener) {
        DetectTypeEnum detectTypeEnum;
        this.f37592g = faceAntispoofingResultListener;
        List<DetectTypeEnum> list = inputData.detectTypeList;
        if (list == null || list.size() <= 0) {
            int i11 = inputData.detectTimes;
            Random random = new Random(System.currentTimeMillis());
            LinkedList linkedList = new LinkedList();
            if (i11 == 1) {
                List asList = Arrays.asList(DetectTypeEnum.values());
                linkedList.add(asList.get(random.nextInt(asList.size())));
            } else {
                ArrayList arrayList = new ArrayList(Arrays.asList(DetectTypeEnum.values()));
                for (int i12 = 0; i12 < i11; i12++) {
                    if (i12 != 0) {
                        detectTypeEnum = (DetectTypeEnum) arrayList.get(random.nextInt(arrayList.size()));
                    } else if (random.nextBoolean()) {
                        detectTypeEnum = DetectTypeEnum.blink_eye;
                    } else {
                        detectTypeEnum = DetectTypeEnum.open_mouth;
                    }
                    linkedList.add(detectTypeEnum);
                    arrayList.remove(detectTypeEnum);
                }
            }
            Collections.shuffle(linkedList);
            this.f37589d = linkedList;
        } else {
            this.f37589d = new ArrayList(inputData.detectTypeList);
        }
        this.f37594i = this.f37589d.size();
        this.f37587b = new AtomicInteger(0);
        this.f37591f = new AtomicLong(System.currentTimeMillis() + 3000);
        a();
        this.f37593h = new AtomicBoolean(false);
    }

    public DetectTypeEnum getCurrDetectType() {
        return this.f37588c;
    }

    public long getDetectTypeStartTimestamp() {
        return this.f37586a;
    }

    public String getLastError() {
        return this.f37590e;
    }

    public boolean isDetectSuccess() {
        return this.f37593h.get();
    }

    public boolean onTypeDetected() {
        if (System.currentTimeMillis() - this.f37586a < 2000) {
            StringBuilder c11 = a.a.c("detected type ");
            c11.append(this.f37588c.name());
            c11.append(" but time not great than 2000ms, ignore.");
            LogFace.i("DetectorSession", c11.toString());
            return false;
        }
        int incrementAndGet = this.f37587b.incrementAndGet();
        StringBuilder c12 = a.a.c("detected type ");
        c12.append(this.f37588c.name());
        c12.append(" total times is ");
        c12.append(incrementAndGet);
        c12.append(", config detect times is ");
        c12.append(this.f37594i);
        LogFace.i("DetectorSession", c12.toString());
        if (this.f37589d.size() == 0) {
            this.f37588c = null;
            this.f37593h.set(true);
            return true;
        }
        a();
        return false;
    }

    public void removeError() {
        long currentTimeMillis = System.currentTimeMillis() - this.f37591f.get();
        if (currentTimeMillis < 1000) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), currentTimeMillis);
        } else {
            this.f37590e = null;
        }
    }

    public void updateError(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f37591f.get() > 2000) {
                this.f37590e = str;
                this.f37591f.set(currentTimeMillis);
            }
        }
    }

    private void a() {
        DetectTypeEnum detectTypeEnum = this.f37589d.get(0);
        this.f37589d.remove(0);
        this.f37588c = detectTypeEnum;
        ThreadUtils.getInstance().runOnUiThread(new dg.a(this, detectTypeEnum));
        this.f37586a = System.currentTimeMillis();
    }
}

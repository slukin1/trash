package com.jumio.core.views;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.lifecycle.u;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.Camera1Manager;
import com.jumio.commons.camera.CameraCallbackInterface;
import com.jumio.commons.camera.CameraManagerInterface;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.R;
import com.jumio.core.ServiceLocator;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.MissingPermissionException;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.c1;
import jumio.core.m;
import jumio.core.p;
import jumio.core.q;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public class CameraScanView extends RelativeLayout implements u {
    public static final Companion Companion = new Companion((r) null);
    public static final float DEFAULT_FRAME_RATE_THRESHOLD = 0.8f;

    /* renamed from: a  reason: collision with root package name */
    public PreviewProperties f39507a;

    /* renamed from: b  reason: collision with root package name */
    public CameraManagerInterface f39508b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f39509c;

    /* renamed from: d  reason: collision with root package name */
    public q f39510d;

    /* renamed from: e  reason: collision with root package name */
    public c1.a f39511e;

    /* renamed from: f  reason: collision with root package name */
    public p f39512f;

    /* renamed from: g  reason: collision with root package name */
    public c1 f39513g;

    /* renamed from: h  reason: collision with root package name */
    public CameraCallbackInterface f39514h;

    /* renamed from: i  reason: collision with root package name */
    public int f39515i;

    /* renamed from: j  reason: collision with root package name */
    public final float f39516j;

    /* renamed from: k  reason: collision with root package name */
    public float f39517k;

    /* renamed from: l  reason: collision with root package name */
    public JumioCameraFacing f39518l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f39519m;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public class a implements CameraCallbackInterface {

        /* renamed from: a  reason: collision with root package name */
        public final q f39520a;

        public a(q qVar) {
            this.f39520a = qVar;
        }

        public final void onCameraAvailable(boolean z11) {
            q qVar = this.f39520a;
            if (qVar != null) {
                qVar.cameraAvailable();
            }
        }

        public final void onCameraError(Throwable th2) {
            q qVar = this.f39520a;
            if (qVar != null) {
                qVar.cameraError(th2);
            }
        }

        public final void onPreviewAvailable(PreviewProperties previewProperties) {
            CameraScanView.this.setPreviewProperties$jumio_core_release(previewProperties);
            q qVar = this.f39520a;
            if (qVar != null) {
                qVar.onPreviewAvailable(previewProperties);
            }
        }

        public final void onPreviewFrame(Frame frame) {
            q qVar;
            CameraManagerInterface cameraManager$jumio_core_release = CameraScanView.this.getCameraManager$jumio_core_release();
            if ((cameraManager$jumio_core_release != null && !cameraManager$jumio_core_release.getFocusing()) && (qVar = this.f39520a) != null) {
                qVar.feedFrame(frame);
            }
        }

        public final void onStopPreview() {
        }
    }

    public static final class b extends Lambda implements d10.a<CameraManagerInterface> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f39522a = new b();

        public b() {
            super(0);
        }

        public final Object invoke() {
            return new Camera1Manager();
        }
    }

    public CameraScanView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public CameraScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CameraScanView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static CameraManagerInterface a(JumioScanPart jumioScanPart) {
        if (((SettingsModel) jumioScanPart.getScanPart$jumio_core_release().getController().getDataManager().get(SettingsModel.class)).getUseCamera1() || Build.VERSION.SDK_INT < 23) {
            return new Camera1Manager();
        }
        return (CameraManagerInterface) ServiceLocator.INSTANCE.getServiceImplementation(CameraManagerInterface.class, b.f39522a);
    }

    public void attach(JumioScanPart jumioScanPart) {
        m mVar;
        ViewTreeObserver viewTreeObserver;
        detach$jumio_core_release();
        ScanPart<?> scanPart$jumio_core_release = jumioScanPart.getScanPart$jumio_core_release();
        Size size = null;
        q qVar = scanPart$jumio_core_release instanceof q ? (q) scanPart$jumio_core_release : null;
        boolean z11 = true;
        if (qVar != null) {
            qVar.setScanView(this);
            qVar.isPresented(true);
            this.f39510d = qVar;
            this.f39514h = new a(qVar);
        }
        ScanPart<?> scanPart$jumio_core_release2 = jumioScanPart.getScanPart$jumio_core_release();
        c1.a aVar = scanPart$jumio_core_release2 instanceof c1.a ? (c1.a) scanPart$jumio_core_release2 : null;
        if (aVar != null) {
            this.f39511e = aVar;
        }
        if (this.f39510d != null) {
            removeAllViews();
            c1 c1Var = new c1(getContext());
            c1Var.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            c1Var.setDrawViewInterface(this.f39511e);
            this.f39513g = c1Var;
            addView(c1Var);
            c1.a aVar2 = this.f39511e;
            Integer valueOf = aVar2 != null ? Integer.valueOf(aVar2.getPreferredBrandTextColor()) : null;
            q qVar2 = this.f39510d;
            if (qVar2 == null || !qVar2.isBrandingEnabled()) {
                z11 = false;
            }
            if (!z11) {
                mVar = null;
            } else {
                int b11 = MathKt__MathJVMKt.b(ScreenUtil.dipToPx(getContext(), 24.0f));
                mVar = new m(getContext(), valueOf != null ? valueOf.intValue() : R.color.jumio_black);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(10);
                layoutParams.addRule(14);
                int i11 = this.f39515i;
                if (i11 <= b11 || i11 >= mVar.getMeasuredHeight() - (b11 * 2)) {
                    layoutParams.topMargin = b11;
                } else {
                    layoutParams.topMargin = this.f39515i;
                }
                mVar.setLayoutParams(layoutParams);
            }
            if (mVar != null) {
                addView(mVar);
            }
            invalidate();
            CameraManagerInterface cameraManagerInterface = this.f39508b;
            if (cameraManagerInterface == null) {
                try {
                    CameraManagerInterface a11 = a(jumioScanPart);
                    a11.setCameraFacing(getCameraFacing());
                    a11.setEnableFlashOnStart(getFlash());
                    q qVar3 = this.f39510d;
                    if (qVar3 != null) {
                        size = qVar3.getPreviewSize();
                    }
                    a11.setRequestedSize(size);
                    a11.setRotationManager(jumioScanPart.getScanPart$jumio_core_release().getController().getRotationManager());
                    this.f39508b = a11;
                } catch (RuntimeException unused) {
                    return;
                }
            } else {
                cameraManagerInterface.setCameraFacing(getCameraFacing());
                cameraManagerInterface.setEnableFlashOnStart(getFlash());
                q qVar4 = this.f39510d;
                if (qVar4 != null) {
                    size = qVar4.getPreviewSize();
                }
                cameraManagerInterface.setRequestedSize(size);
                cameraManagerInterface.setRotationManager(jumioScanPart.getScanPart$jumio_core_release().getController().getRotationManager());
                cameraManagerInterface.startPreview();
            }
            CameraCallbackInterface cameraCallbackInterface = this.f39514h;
            if (cameraCallbackInterface != null) {
                CameraManagerInterface cameraManagerInterface2 = this.f39508b;
                if (cameraManagerInterface2 != null) {
                    cameraManagerInterface2.setup(getContext(), this, cameraCallbackInterface);
                }
                p pVar = this.f39512f;
                c1 c1Var2 = this.f39513g;
                CameraManagerInterface cameraManagerInterface3 = this.f39508b;
                pVar.a();
                pVar.f56295e = c1Var2;
                pVar.f56294d = cameraManagerInterface3;
                if (c1Var2 != null && (viewTreeObserver = c1Var2.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(pVar);
                }
            }
        }
    }

    public final void detach$jumio_core_release() {
        this.f39512f.a();
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        if (cameraManagerInterface != null) {
            cameraManagerInterface.stopPreview(true);
            cameraManagerInterface.destroy();
        }
        this.f39508b = null;
        q qVar = this.f39510d;
        if (qVar != null) {
            qVar.isPresented(false);
        }
        this.f39510d = null;
        this.f39511e = null;
    }

    public final Unit fillImageData$jumio_core_release(ImageData imageData) {
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        if (cameraManagerInterface == null) {
            return null;
        }
        cameraManagerInterface.fillImageData(imageData);
        return Unit.f56620a;
    }

    public final int getBrandingLogoTopMargin() {
        return this.f39515i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 == null) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.jumio.sdk.enums.JumioCameraFacing getCameraFacing() {
        /*
            r2 = this;
            com.jumio.commons.camera.CameraManagerInterface r0 = r2.f39508b
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.isFrontFacing()
            if (r0 == 0) goto L_0x000d
            com.jumio.sdk.enums.JumioCameraFacing r0 = com.jumio.sdk.enums.JumioCameraFacing.FRONT
            goto L_0x000f
        L_0x000d:
            com.jumio.sdk.enums.JumioCameraFacing r0 = com.jumio.sdk.enums.JumioCameraFacing.BACK
        L_0x000f:
            if (r0 != 0) goto L_0x0013
        L_0x0011:
            com.jumio.sdk.enums.JumioCameraFacing r0 = com.jumio.sdk.enums.JumioCameraFacing.BACK
        L_0x0013:
            r2.f39518l = r0
            jumio.core.q r0 = r2.f39510d
            if (r0 == 0) goto L_0x0033
            com.jumio.sdk.enums.JumioCameraFacing[] r0 = r0.getSupportedFacing()
            if (r0 == 0) goto L_0x0033
            com.jumio.sdk.enums.JumioCameraFacing r1 = r2.f39518l
            boolean r1 = kotlin.collections.ArraysKt___ArraysKt.C(r0, r1)
            if (r1 != 0) goto L_0x0033
            r1 = 0
            r0 = r0[r1]
            r2.f39518l = r0
            com.jumio.commons.camera.CameraManagerInterface r1 = r2.f39508b
            if (r1 == 0) goto L_0x0033
            r1.setCameraFacing(r0)
        L_0x0033:
            com.jumio.sdk.enums.JumioCameraFacing r0 = r2.f39518l
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.views.CameraScanView.getCameraFacing():com.jumio.sdk.enums.JumioCameraFacing");
    }

    public final CameraCallbackInterface getCameraInterface() {
        return this.f39514h;
    }

    public final CameraManagerInterface getCameraManager$jumio_core_release() {
        return this.f39508b;
    }

    public final q getCameraScanPartInterface() {
        return this.f39510d;
    }

    public final c1 getDrawView$jumio_core_release() {
        return this.f39513g;
    }

    public final c1.a getDrawViewInterface() {
        return this.f39511e;
    }

    public boolean getExtraction() {
        q qVar = this.f39510d;
        return qVar != null && qVar.getEnableExtraction();
    }

    public boolean getFlash() {
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        if (cameraManagerInterface != null) {
            this.f39519m = cameraManagerInterface.isFlashOn();
        }
        return this.f39519m;
    }

    public boolean getHasFlash() {
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        return cameraManagerInterface != null && cameraManagerInterface.isFlashSupported();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getHasMultipleCameras() {
        /*
            r3 = this;
            com.jumio.commons.camera.CameraManagerInterface r0 = r3.f39508b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.getHasMultipleCameras()
            if (r0 != r2) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 == 0) goto L_0x0029
            jumio.core.q r0 = r3.f39510d
            if (r0 == 0) goto L_0x0025
            com.jumio.sdk.enums.JumioCameraFacing[] r0 = r0.getSupportedFacing()
            if (r0 == 0) goto L_0x0025
            int r0 = r0.length
            if (r0 <= r2) goto L_0x0020
            r0 = r2
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            if (r0 != r2) goto L_0x0025
            r0 = r2
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 == 0) goto L_0x0029
            r1 = r2
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.views.CameraScanView.getHasMultipleCameras():boolean");
    }

    public final p getLayoutListener() {
        return this.f39512f;
    }

    public float getMinRatio() {
        return this.f39516j;
    }

    public final PreviewProperties getPreviewProperties$jumio_core_release() {
        return this.f39507a;
    }

    public float getRatio() {
        return this.f39517k;
    }

    public final c1 getScanOverlayView() {
        return this.f39513g;
    }

    public final Handler getUiHandler() {
        return this.f39509c;
    }

    public boolean isAttached() {
        return this.f39510d != null;
    }

    public boolean isShutterEnabled() {
        q qVar = this.f39510d;
        if (qVar != null) {
            return qVar.getShowShutterButton();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00dd, code lost:
        if ((getRatio() != 0.0f) != false) goto L_0x00e0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            int r1 = android.view.View.MeasureSpec.getMode(r10)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.orientation
            r3 = 0
            r4 = 1
            if (r2 == r4) goto L_0x002f
            android.content.Context r2 = r8.getContext()
            boolean r2 = com.jumio.commons.utils.DeviceRotationManager.isTabletDevice(r2)
            if (r2 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r2 = r3
            goto L_0x0030
        L_0x002f:
            r2 = r4
        L_0x0030:
            r5 = 0
            if (r2 == 0) goto L_0x004f
            float r6 = r8.getRatio()
            int r6 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r6 != 0) goto L_0x003d
            r6 = r4
            goto L_0x003e
        L_0x003d:
            r6 = r3
        L_0x003e:
            if (r6 != 0) goto L_0x004f
            float r6 = r8.getRatio()
            float r7 = r8.getMinRatio()
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r6 = r3
            goto L_0x0050
        L_0x004f:
            r6 = r4
        L_0x0050:
            if (r6 == 0) goto L_0x0127
            if (r2 != 0) goto L_0x0070
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x005e
            r2 = r4
            goto L_0x005f
        L_0x005e:
            r2 = r3
        L_0x005f:
            if (r2 != 0) goto L_0x0070
            float r2 = r8.getRatio()
            float r6 = r8.getMinRatio()
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r2 = r3
            goto L_0x0071
        L_0x0070:
            r2 = r4
        L_0x0071:
            if (r2 == 0) goto L_0x0108
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L_0x007c
            if (r0 != 0) goto L_0x007a
            goto L_0x007c
        L_0x007a:
            r0 = r3
            goto L_0x007d
        L_0x007c:
            r0 = r4
        L_0x007d:
            if (r1 == r2) goto L_0x0084
            if (r1 != 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r1 = r3
            goto L_0x0085
        L_0x0084:
            r1 = r4
        L_0x0085:
            if (r9 == 0) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0093
            r2 = r4
            goto L_0x0094
        L_0x0093:
            r2 = r3
        L_0x0094:
            if (r2 != 0) goto L_0x009e
            float r10 = (float) r9
            float r2 = r8.getRatio()
            float r10 = r10 / r2
            int r10 = (int) r10
            goto L_0x00ce
        L_0x009e:
            if (r0 == 0) goto L_0x00b7
            if (r10 == 0) goto L_0x00b7
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00ac
            r2 = r4
            goto L_0x00ad
        L_0x00ac:
            r2 = r3
        L_0x00ad:
            if (r2 != 0) goto L_0x00b7
            float r9 = (float) r10
            float r2 = r8.getRatio()
            float r2 = r2 * r9
            int r9 = (int) r2
            goto L_0x00ce
        L_0x00b7:
            if (r0 == 0) goto L_0x00cb
            if (r1 == 0) goto L_0x00cb
            float r2 = r8.getRatio()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00c5
            r2 = r4
            goto L_0x00c6
        L_0x00c5:
            r2 = r3
        L_0x00c6:
            if (r2 == 0) goto L_0x00c9
            goto L_0x00cb
        L_0x00c9:
            r2 = r3
            goto L_0x00cc
        L_0x00cb:
            r2 = r4
        L_0x00cc:
            if (r2 == 0) goto L_0x00fc
        L_0x00ce:
            if (r0 != 0) goto L_0x00d2
            if (r1 == 0) goto L_0x00df
        L_0x00d2:
            float r0 = r8.getRatio()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00dc
            r0 = r4
            goto L_0x00dd
        L_0x00dc:
            r0 = r3
        L_0x00dd:
            if (r0 != 0) goto L_0x00e0
        L_0x00df:
            r3 = r4
        L_0x00e0:
            if (r3 == 0) goto L_0x00f0
            r0 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r0)
            super.onMeasure(r9, r10)
            return
        L_0x00f0:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "ratio should be set"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00fc:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "layout_width or layout_height should be set to a fixed value when ratio is used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0108:
            float r9 = r8.getMinRatio()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Landscape ratio must be >= "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L_0x0127:
            float r9 = r8.getMinRatio()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Portrait ratio must be <= "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.views.CameraScanView.onMeasure(int, int):void");
    }

    public void pause() {
        CameraManagerInterface cameraManagerInterface;
        CameraManagerInterface cameraManagerInterface2 = this.f39508b;
        if ((cameraManagerInterface2 != null && !cameraManagerInterface2.isPausePreview()) && (cameraManagerInterface = this.f39508b) != null) {
            cameraManagerInterface.stopPreview(false);
        }
        q qVar = this.f39510d;
        if (qVar != null) {
            qVar.isPresented(false);
        }
    }

    public void resume() {
        CameraManagerInterface cameraManagerInterface;
        JumioSDK.Companion companion = JumioSDK.Companion;
        if (companion.hasAllRequiredPermissions(getContext())) {
            CameraManagerInterface cameraManagerInterface2 = this.f39508b;
            if ((cameraManagerInterface2 != null && !cameraManagerInterface2.isPausePreview()) && (cameraManagerInterface = this.f39508b) != null) {
                cameraManagerInterface.startPreview();
            }
            q qVar = this.f39510d;
            if (qVar != null) {
                qVar.isPresented(true);
                return;
            }
            return;
        }
        q qVar2 = this.f39510d;
        if (qVar2 != null) {
            qVar2.cameraError(new MissingPermissionException(companion.getMissingPermissions(getContext())));
        }
    }

    public final void setBrandingLogoTopMargin(int i11) {
        this.f39515i = i11;
    }

    public void setCameraFacing(JumioCameraFacing jumioCameraFacing) {
        JumioCameraFacing[] supportedFacing;
        q qVar = this.f39510d;
        boolean z11 = true;
        if (qVar == null || (supportedFacing = qVar.getSupportedFacing()) == null || !ArraysKt___ArraysKt.C(supportedFacing, jumioCameraFacing)) {
            z11 = false;
        }
        if (z11) {
            this.f39518l = jumioCameraFacing;
            CameraManagerInterface cameraManagerInterface = this.f39508b;
            if (cameraManagerInterface != null) {
                cameraManagerInterface.setCameraFacing(jumioCameraFacing);
                Analytics.Companion.add(MobileEvents.userAction$default(OptionsBridge.CAMERA_KEY, (JumioScanStep) null, jumioCameraFacing.name(), 2, (Object) null));
            }
        }
    }

    public final void setCameraInterface(CameraCallbackInterface cameraCallbackInterface) {
        this.f39514h = cameraCallbackInterface;
    }

    public final void setCameraManager$jumio_core_release(CameraManagerInterface cameraManagerInterface) {
        this.f39508b = cameraManagerInterface;
    }

    public final void setCameraScanPartInterface(q qVar) {
        this.f39510d = qVar;
    }

    public final void setDrawViewInterface(c1.a aVar) {
        this.f39511e = aVar;
    }

    public void setExtraction(boolean z11) {
        q qVar = this.f39510d;
        if (qVar != null) {
            qVar.setEnableExtraction(z11);
        }
    }

    public void setFlash(boolean z11) {
        this.f39519m = z11;
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        if (cameraManagerInterface != null) {
            cameraManagerInterface.setFlash(z11);
            Analytics.Companion.add(MobileEvents.userAction$default("flash", (JumioScanStep) null, this.f39519m ? "ON" : "OFF", 2, (Object) null));
        }
    }

    public final void setLayoutListener(p pVar) {
        this.f39512f = pVar;
    }

    public final void setPreviewProperties$jumio_core_release(PreviewProperties previewProperties) {
        this.f39507a = previewProperties;
    }

    public void setRatio(float f11) {
        this.f39517k = f11;
    }

    public final void setScanOverlayView(c1 c1Var) {
        this.f39513g = c1Var;
    }

    public final void setUiHandler(Handler handler) {
        this.f39509c = handler;
    }

    public final Unit stopPreview$jumio_core_release(boolean z11) {
        CameraManagerInterface cameraManagerInterface = this.f39508b;
        if (cameraManagerInterface == null) {
            return null;
        }
        cameraManagerInterface.stopPreview(z11);
        return Unit.f56620a;
    }

    public void switchCamera() {
        if (getHasMultipleCameras()) {
            CameraManagerInterface cameraManagerInterface = this.f39508b;
            if (cameraManagerInterface != null) {
                cameraManagerInterface.changeCamera();
            }
            Analytics.Companion.add(MobileEvents.userAction$default(OptionsBridge.CAMERA_KEY, (JumioScanStep) null, getCameraFacing().name(), 2, (Object) null));
        }
    }

    public void takePicture() {
        q qVar = this.f39510d;
        if (qVar != null) {
            qVar.takePicture();
        }
    }

    public final void update$jumio_core_release(boolean z11) {
        this.f39509c.post(new nw.a(z11, this));
    }

    public CameraScanView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f39507a = new PreviewProperties();
        this.f39509c = new Handler(Looper.getMainLooper());
        this.f39512f = new p();
        this.f39516j = 1.0f;
        this.f39517k = getMinRatio();
        this.f39518l = JumioCameraFacing.BACK;
    }

    public static final void a(boolean z11, CameraScanView cameraScanView) {
        c1 c1Var;
        if (z11 && (c1Var = cameraScanView.f39513g) != null) {
            c1Var.requestLayout();
        }
        c1 c1Var2 = cameraScanView.f39513g;
        if (c1Var2 != null) {
            c1Var2.invalidate();
        }
    }
}

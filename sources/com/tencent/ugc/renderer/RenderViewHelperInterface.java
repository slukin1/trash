package com.tencent.ugc.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.ugc.videobase.base.GLConstants;

@JNINamespace("liteav::ugc")
public abstract class RenderViewHelperInterface {
    private static final String TAG = "RenderViewHelperInterface";

    /* renamed from: com.tencent.ugc.renderer.RenderViewHelperInterface$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50753a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.videobase.videobase.DisplayTarget$a[] r0 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50753a = r0
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.SURFACEVIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50753a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TEXTUREVIEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50753a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50753a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.videobase.videobase.DisplayTarget$a r1 = com.tencent.liteav.videobase.videobase.DisplayTarget.a.TXCLOUDVIEW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.renderer.RenderViewHelperInterface.AnonymousClass1.<clinit>():void");
        }
    }

    public interface RenderViewListener {
        void onRequestRedraw(Bitmap bitmap);

        void onSurfaceChanged(Surface surface, boolean z11);

        void onSurfaceDestroy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.tencent.rtmp.ui.TXCloudVideoView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: android.view.TextureView} */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.ugc.renderer.RenderViewHelperInterface create(com.tencent.liteav.videobase.videobase.DisplayTarget r6, com.tencent.ugc.renderer.RenderViewHelperInterface.RenderViewListener r7) {
        /*
            java.lang.String r0 = "RenderViewHelperInterface"
            r1 = 0
            if (r6 == 0) goto L_0x008c
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r2 = r6.getType()
            if (r2 != 0) goto L_0x000d
            goto L_0x008c
        L_0x000d:
            int[] r2 = com.tencent.ugc.renderer.RenderViewHelperInterface.AnonymousClass1.f50753a
            com.tencent.liteav.videobase.videobase.DisplayTarget$a r3 = r6.getType()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L_0x0056
            r3 = 2
            if (r2 == r3) goto L_0x004d
            r3 = 3
            if (r2 == r3) goto L_0x0047
            r3 = 4
            if (r2 == r3) goto L_0x002a
            r2 = r1
            r3 = r2
        L_0x0027:
            r4 = r3
            r5 = r4
            goto L_0x005e
        L_0x002a:
            com.tencent.rtmp.ui.TXCloudVideoView r2 = r6.getTXCloudVideoView()
            if (r2 != 0) goto L_0x003a
            java.lang.String r3 = "txCloudVideoView is null."
            com.tencent.liteav.base.util.LiteavLog.w(r0, r3)
            r4 = r1
            r5 = r4
            r3 = r2
            r2 = r5
            goto L_0x005e
        L_0x003a:
            android.view.SurfaceView r3 = r2.getSurfaceView()
            android.view.TextureView r4 = com.tencent.ugc.videobase.videobase.TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(r2)
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x005e
        L_0x0047:
            android.view.Surface r2 = r6.getSurface()
            r3 = r1
            goto L_0x0027
        L_0x004d:
            android.view.TextureView r4 = r6.getTextureView()
            r2 = r1
            r3 = r2
            r5 = r4
            r4 = r3
            goto L_0x005e
        L_0x0056:
            android.view.SurfaceView r3 = r6.getSurfaceView()
            r2 = r1
            r5 = r2
            r4 = r3
            r3 = r5
        L_0x005e:
            if (r4 == 0) goto L_0x0066
            com.tencent.ugc.renderer.SurfaceViewRenderHelper r6 = new com.tencent.ugc.renderer.SurfaceViewRenderHelper
            r6.<init>(r4, r7)
            return r6
        L_0x0066:
            if (r5 == 0) goto L_0x006e
            com.tencent.ugc.renderer.TextureViewRenderHelper r6 = new com.tencent.ugc.renderer.TextureViewRenderHelper
            r6.<init>((android.view.TextureView) r5, (com.tencent.ugc.renderer.RenderViewHelperInterface.RenderViewListener) r7)
            return r6
        L_0x006e:
            if (r2 == 0) goto L_0x0076
            com.tencent.ugc.renderer.SurfaceRenderHelper r6 = new com.tencent.ugc.renderer.SurfaceRenderHelper
            r6.<init>(r2, r7)
            return r6
        L_0x0076:
            if (r3 == 0) goto L_0x007e
            com.tencent.ugc.renderer.TextureViewRenderHelper r6 = new com.tencent.ugc.renderer.TextureViewRenderHelper
            r6.<init>((com.tencent.rtmp.ui.TXCloudVideoView) r3, (com.tencent.ugc.renderer.RenderViewHelperInterface.RenderViewListener) r7)
            return r6
        L_0x007e:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "RenderViewHelper not created. displayTarget="
            java.lang.String r6 = r7.concat(r6)
            com.tencent.liteav.base.util.LiteavLog.w(r0, r6)
            return r1
        L_0x008c:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "displayTarget or type is null. displayTarget="
            java.lang.String r6 = r7.concat(r6)
            com.tencent.liteav.base.util.LiteavLog.w(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.renderer.RenderViewHelperInterface.create(com.tencent.liteav.videobase.videobase.DisplayTarget, com.tencent.ugc.renderer.RenderViewHelperInterface$RenderViewListener):com.tencent.ugc.renderer.RenderViewHelperInterface");
    }

    public static GLConstants.GLScaleType createScaleType(int i11) {
        return GLConstants.GLScaleType.fromInt(i11);
    }

    public abstract void checkViewAvailability();

    public abstract Matrix getTransformMatrix(int i11, int i12);

    public abstract boolean isUsingTextureView();

    public abstract void release(boolean z11);

    public abstract void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i11, int i12, boolean z11);
}

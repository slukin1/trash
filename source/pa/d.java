package pa;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.request.target.CustomTarget;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.o0;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.hbg.lib.widgets.utils.crop.CropParams;
import com.luck.picture.lib.basic.PictureSelectionModel;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropImageEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public CropParams f76421a;

    /* renamed from: b  reason: collision with root package name */
    public a f76422b;

    /* renamed from: c  reason: collision with root package name */
    public File f76423c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76424d;

    public class a extends BaseSubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f76425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f76426c;

        public a(ArrayList arrayList, a aVar) {
            this.f76425b = arrayList;
            this.f76426c = aVar;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String[] strArr = new String[this.f76425b.size()];
            for (int i11 = 0; i11 < this.f76425b.size(); i11++) {
                LocalMedia localMedia = (LocalMedia) this.f76425b.get(i11);
                if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                    linkedHashMap.put(localMedia.getPath(), Boolean.TRUE);
                } else if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                    linkedHashMap.put(localMedia.getPath(), Boolean.FALSE);
                }
                strArr[i11] = localMedia.getFileName();
            }
            this.f76426c.c(linkedHashMap, strArr);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class b extends BaseSubscriber<LocalMedia> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f76428b;

        public b(a aVar) {
            this.f76428b = aVar;
        }

        /* renamed from: a */
        public void onNext(LocalMedia localMedia) {
            super.onNext(localMedia);
            if (PictureMimeType.isHasImage(localMedia.getMimeType())) {
                this.f76428b.a(Uri.parse(localMedia.getPath()), localMedia.getFileName(), true);
            } else if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                this.f76428b.a(Uri.parse(localMedia.getPath()), localMedia.getFileName(), false);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class c implements OnResultCallbackListener<LocalMedia> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f76430a;

        public c(e eVar) {
            this.f76430a = eVar;
        }

        public void onCancel() {
            e eVar = this.f76430a;
            if (eVar != null) {
                eVar.onCancel();
            }
        }

        public void onResult(ArrayList<LocalMedia> arrayList) {
            e eVar = this.f76430a;
            if (eVar != null) {
                eVar.onResult(arrayList);
            }
        }
    }

    /* renamed from: pa.d$d  reason: collision with other inner class name */
    public class C0819d implements OnResultCallbackListener<LocalMedia> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f76432a;

        public C0819d(e eVar) {
            this.f76432a = eVar;
        }

        public void onCancel() {
            e eVar = this.f76432a;
            if (eVar != null) {
                eVar.onCancel();
            }
        }

        public void onResult(ArrayList<LocalMedia> arrayList) {
            e eVar = this.f76432a;
            if (eVar != null) {
                eVar.onResult(arrayList);
            }
        }
    }

    public class e implements OnQueryFilterListener {
        public e() {
        }

        public boolean onFilter(LocalMedia localMedia) {
            return false;
        }
    }

    public class f implements CropFileEngine {
        public f() {
        }

        public void onStartCrop(Fragment fragment, Uri uri, Uri uri2, ArrayList<String> arrayList, int i11) {
            if (PermissionUtils.j(fragment.getActivity()) != 1) {
                UCrop.Options c11 = d.this.e();
                UCrop of2 = UCrop.of(uri, uri2, arrayList);
                of2.withOptions(c11);
                of2.setImageEngine(new a());
                of2.start(fragment.requireActivity(), fragment, i11);
            }
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this();
        }

        public class a implements UCropImageEngine {

            /* renamed from: pa.d$f$a$a  reason: collision with other inner class name */
            public class C0820a extends CustomTarget<Bitmap> {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ UCropImageEngine.OnCallbackListener f76437b;

                public C0820a(UCropImageEngine.OnCallbackListener onCallbackListener) {
                    this.f76437b = onCallbackListener;
                }

                public void onLoadCleared(Drawable drawable) {
                    UCropImageEngine.OnCallbackListener onCallbackListener = this.f76437b;
                    if (onCallbackListener != null) {
                        onCallbackListener.onCall(null);
                    }
                }

                public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.transition.a<? super Bitmap> aVar) {
                    UCropImageEngine.OnCallbackListener onCallbackListener = this.f76437b;
                    if (onCallbackListener != null) {
                        onCallbackListener.onCall(bitmap);
                    }
                }
            }

            public a() {
            }

            public void loadImage(Context context, String str, ImageView imageView) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.isFinishing() || activity.isDestroyed()) {
                        return;
                    }
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext() instanceof Activity) {
                        Activity activity2 = (Activity) contextWrapper.getBaseContext();
                        if (activity2.isFinishing() || activity2.isDestroyed()) {
                            return;
                        }
                    }
                }
                ((com.bumptech.glide.c) com.bumptech.glide.a.v(context).q(str).Z(180, 180)).D0(imageView);
            }

            public void loadImage(Context context, Uri uri, int i11, int i12, UCropImageEngine.OnCallbackListener<Bitmap> onCallbackListener) {
                ((com.bumptech.glide.c) com.bumptech.glide.a.v(context).b().I0(uri).Z(i11, i12)).A0(new C0820a(onCallbackListener));
            }
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static d f76439a = new d((a) null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Activity activity, PictureSelector pictureSelector, e eVar, int i11) {
        if (i11 == 0) {
            activity.runOnUiThread(new c(this, pictureSelector, eVar));
        }
    }

    public static d o() {
        return g.f76439a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(PictureSelector pictureSelector, e eVar) {
        pictureSelector.openCamera(SelectMimeType.ofImage()).forResult(new C0819d(eVar));
    }

    public d B(boolean z11) {
        this.f76424d = z11;
        return this;
    }

    public d C(a aVar) {
        this.f76422b = aVar;
        return this;
    }

    public final Intent d(Activity activity) {
        Intent putExtra = new Intent("com.android.camera.action.CROP").putExtra("crop", this.f76421a.f72417c).putExtra("scale", this.f76421a.f72418d).putExtra("aspectX", this.f76421a.f72422h).putExtra("aspectY", this.f76421a.f72423i).putExtra("outputX", this.f76421a.f72424j).putExtra("outputY", this.f76421a.f72425k).putExtra("return-data", this.f76421a.f72419e).putExtra("outputFormat", this.f76421a.f72416b).putExtra("noFaceDetection", this.f76421a.f72420f).putExtra("scaleUpIfNeeded", this.f76421a.f72421g).putExtra("output", Uri.fromFile(l(activity, true)));
        if (Build.VERSION.SDK_INT > 23) {
            putExtra.setDataAndType(FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", l(activity, false)), this.f76421a.f72415a).addFlags(1);
        } else {
            putExtra.setDataAndType(Uri.fromFile(l(activity, false)), this.f76421a.f72415a);
        }
        return putExtra;
    }

    public final UCrop.Options e() {
        UCrop.Options options = new UCrop.Options();
        options.setHideBottomControls(true);
        options.setFreeStyleCropEnabled(false);
        options.setShowCropFrame(false);
        options.withAspectRatio(1.0f, 1.0f);
        return options;
    }

    public final void f(Activity activity, PictureSelector pictureSelector, String str, int i11, e eVar, boolean z11) {
        if (!"Album".equals(str)) {
            PermissionUtils.h(activity, new b(this, activity, pictureSelector, eVar), true);
        } else if (PermissionUtils.i(activity) != 1) {
            PictureSelectionModel openGallery = pictureSelector.openGallery(SelectMimeType.ofImage());
            if (i11 == 1) {
                openGallery.setSelectionMode(1);
                if (z11) {
                    openGallery.setCropEngine((CropFileEngine) new f(this, (a) null));
                }
                openGallery.isDirectReturnSingle(true);
            } else if (i11 > 1) {
                openGallery.setSelectionMode(2);
                openGallery.isDirectReturnSingle(false);
                openGallery.setMaxSelectNum(i11);
            }
            openGallery.setImageEngine(o0.a()).forResult((OnResultCallbackListener<LocalMedia>) new c(eVar));
        }
    }

    public void g(Activity activity, String str, int i11, e eVar) {
        if (TextUtils.equals(str, PictureMimeType.CAMERA)) {
            SP.y("isAdEnabled", false);
        }
        f(activity, PictureSelector.create((Context) activity), str, i11, eVar, false);
    }

    public void h(Activity activity, String str, int i11, boolean z11, e eVar) {
        if (TextUtils.equals(str, PictureMimeType.CAMERA)) {
            SP.y("isAdEnabled", false);
        }
        f(activity, PictureSelector.create((Context) activity), str, i11, eVar, z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[SYNTHETIC, Splitter:B:28:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0046 A[Catch:{ IOException -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0054 A[SYNTHETIC, Splitter:B:37:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005c A[Catch:{ IOException -> 0x0058 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(android.app.Activity r3, android.net.Uri r4, java.io.File r5) {
        /*
            r2 = this;
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0030, all -> 0x002c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0030, all -> 0x002c }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
        L_0x0012:
            int r0 = r3.read(r5)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r1 = -1
            if (r0 == r1) goto L_0x001e
            r1 = 0
            r4.write(r5, r1, r0)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            goto L_0x0012
        L_0x001e:
            r3.close()     // Catch:{ IOException -> 0x0042 }
            r4.flush()     // Catch:{ IOException -> 0x0042 }
            r4.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0050
        L_0x0028:
            r5 = move-exception
            goto L_0x002e
        L_0x002a:
            r5 = move-exception
            goto L_0x0032
        L_0x002c:
            r5 = move-exception
            r4 = r0
        L_0x002e:
            r0 = r3
            goto L_0x0052
        L_0x0030:
            r5 = move-exception
            r4 = r0
        L_0x0032:
            r0 = r3
            goto L_0x0039
        L_0x0034:
            r5 = move-exception
            r4 = r0
            goto L_0x0052
        L_0x0037:
            r5 = move-exception
            r4 = r0
        L_0x0039:
            i6.d.g(r5)     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            r3 = move-exception
            goto L_0x004d
        L_0x0044:
            if (r4 == 0) goto L_0x0050
            r4.flush()     // Catch:{ IOException -> 0x0042 }
            r4.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0050
        L_0x004d:
            i6.d.g(r3)
        L_0x0050:
            return
        L_0x0051:
            r5 = move-exception
        L_0x0052:
            if (r0 == 0) goto L_0x005a
            r0.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            r3 = move-exception
            goto L_0x0063
        L_0x005a:
            if (r4 == 0) goto L_0x0066
            r4.flush()     // Catch:{ IOException -> 0x0058 }
            r4.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0066
        L_0x0063:
            i6.d.g(r3)
        L_0x0066:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.d.i(android.app.Activity, android.net.Uri, java.io.File):void");
    }

    public File j(Context context, String str) {
        File file = new File(context.getExternalCacheDir(), "crop");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file.getPath(), str);
    }

    public File k(Context context, String str) {
        File file = new File(context.getExternalCacheDir(), "pdf");
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file.getPath(), str);
    }

    public final File l(Context context, boolean z11) {
        File file;
        if (z11) {
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "crop");
        } else {
            file = new File(context.getCacheDir(), "crop");
        }
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file.getPath(), z11 ? "crop_cache_file.jpg" : "pic_cache_file.jpg");
    }

    public final Uri m(Context context) {
        File file = new File(context.getExternalCacheDir(), "crop");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.getPath(), "camera_cache_file.jpg");
        this.f76423c = file2;
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file2);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", this.f76423c);
    }

    public String n(Context context) {
        File file = new File(context.getExternalCacheDir(), "crop");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public String p() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdir();
        }
        return externalStoragePublicDirectory.getAbsolutePath();
    }

    public void q(Activity activity) {
        try {
            activity.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", m(activity)), 128);
        } catch (Exception e11) {
            i6.d.d("capture image exception - " + e11.getMessage());
        }
    }

    public void r(Fragment fragment) {
        try {
            fragment.startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", m(fragment.getActivity())), 128);
        } catch (Exception e11) {
            i6.d.d("capture image exception - " + e11.getMessage());
        }
    }

    public final void s(Activity activity) {
        try {
            File l11 = l(activity, true);
            if (l11.exists()) {
                l11.delete();
            }
            activity.startActivityForResult(d(activity), 69);
        } catch (Exception e11) {
            i6.d.g(e11);
        }
    }

    public void t(Activity activity) {
        try {
            activity.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 126);
        } catch (Exception e11) {
            i6.d.f("no action:android.intent.action.PICK", e11);
        }
    }

    public void u(Fragment fragment) {
        try {
            fragment.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 126);
        } catch (Exception e11) {
            i6.d.f("no action:android.intent.action.PICK", e11);
        }
    }

    public void v(Activity activity, int i11) {
        try {
            PictureSelector.create((Context) activity).openGallery(SelectMimeType.ofAll()).setImageEngine(o0.a()).isAutoVideoPlay(false).isLoopAutoVideoPlay(false).isPageSyncAlbumCount(true).setQueryFilterListener(new e()).setSelectionMode(2).isDisplayTimeAxis(true).isPageStrategy(true).isWithSelectVideoImage(true).isPreviewFullScreenMode(true).isVideoPauseResumePlay(false).isMaxSelectEnabledMask(true).setFilterMaxFileSize(62914560).setMaxSelectNum(i11).setMaxVideoSelectNum(i11).setRecyclerAnimationMode(-1).isGif(true).setSelectedData((List<LocalMedia>) null).forResult(129);
        } catch (Exception e11) {
            i6.d.f("no action:android.intent.action.PICK", e11);
        }
    }

    public void w(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, SelectMimeType.SYSTEM_IMAGE);
            activity.startActivityForResult(intent, 126);
        } catch (Exception e11) {
            i6.d.f("no action:android.intent.action.PICK", e11);
        }
    }

    public void x(Activity activity, int i11, int i12, Intent intent) {
        y(activity, i11, i12, intent, false);
    }

    public void y(Activity activity, int i11, int i12, Intent intent, boolean z11) {
        a aVar = this.f76422b;
        this.f76422b = null;
        if (aVar != null) {
            if (i12 == 0) {
                aVar.onCancel();
            } else if (i11 != 69) {
                if (i11 != 126) {
                    if (i11 != 128) {
                        if (i11 == 129) {
                            if (intent == null) {
                                aVar.b("");
                                return;
                            }
                            ArrayList<LocalMedia> obtainSelectorList = PictureSelector.obtainSelectorList(intent);
                            if (obtainSelectorList == null || obtainSelectorList.isEmpty()) {
                                aVar.b("");
                            } else if (z11) {
                                Observable.just(0).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(obtainSelectorList, aVar));
                            } else {
                                Observable.from(obtainSelectorList).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(aVar));
                            }
                        }
                    } else if (i12 != -1) {
                        aVar.b("");
                    } else {
                        if (this.f76424d) {
                            s(activity);
                        } else {
                            aVar.a(Uri.fromFile(this.f76423c), "", true);
                        }
                        this.f76423c = null;
                    }
                } else if (intent == null) {
                    aVar.b("");
                } else if (this.f76424d) {
                    i(activity, intent.getData(), l(activity, false));
                    s(activity);
                } else {
                    i(activity, intent.getData(), j(activity, "pic_cache_file.jpg"));
                    aVar.a(Uri.fromFile(j(activity, "pic_cache_file.jpg")), "", true);
                }
            } else if (i12 == -1) {
                i6.d.b("Photo cropped!");
                aVar.a(Uri.fromFile(l(activity, true)), "", true);
            }
        }
    }

    public d() {
        this.f76424d = true;
        this.f76421a = new CropParams();
    }
}

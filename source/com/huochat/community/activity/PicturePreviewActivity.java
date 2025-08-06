package com.huochat.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.util.c;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import com.huochat.community.fragment.FragmentPicturePreview;
import com.huochat.community.model.MediaBean;
import com.huochat.community.widget.DragImageHelperLayout;
import com.huochat.community.widget.HackyViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.r;

public class PicturePreviewActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((r) null);
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";
    private final String STATE_POSITION = "STATE_POSITION";
    private String currenturl = "";
    private DragImageHelperLayout dragImageHelperLayout;
    /* access modifiers changed from: private */
    public FrameLayout flMaskParent;
    /* access modifiers changed from: private */
    public final HashMap<String, FragmentPicturePreview> fragmentHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public HackyViewPager hackyViewPagerCircleImage;
    private ImagePagerAdapter imagePagerAdapter;
    /* access modifiers changed from: private */
    public TextView indicator;
    /* access modifiers changed from: private */
    public ArrayList<MediaBean> mediaBeans;
    private int pagerPosition;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final void startActivity(Activity activity, c<View, String>[] cVarArr, ArrayList<MediaBean> arrayList, int i11) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(PicturePreviewActivity.EXTRA_IMAGE_URLS, arrayList);
            bundle.putInt(PicturePreviewActivity.EXTRA_IMAGE_INDEX, i11);
            Intent intent = new Intent(activity, PicturePreviewActivity.class);
            intent.putExtras(bundle);
            if (Build.VERSION.SDK_INT > 21) {
                Bundle bundle2 = null;
                try {
                    bundle2 = p0.c.a(activity, (c[]) Arrays.copyOf(cVarArr, cVarArr.length)).b();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                ContextCompat.startActivity(activity, intent, bundle2);
                return;
            }
            activity.startActivity(intent);
        }
    }

    public final class ImagePagerAdapter extends b0 {
        private ArrayList<MediaBean> fileList;

        public ImagePagerAdapter(FragmentManager fragmentManager, ArrayList<MediaBean> arrayList) {
            super(fragmentManager);
            this.fileList = arrayList;
        }

        public void destroyItem(ViewGroup viewGroup, int i11, Object obj) {
            super.destroyItem(viewGroup, i11, obj);
            PicturePreviewActivity.this.fragmentHashMap.remove(this.fileList.get(i11).imageUrl);
        }

        public int getCount() {
            ArrayList<MediaBean> arrayList = this.fileList;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public final ArrayList<MediaBean> getFileList() {
            return this.fileList;
        }

        public final void setFileList(ArrayList<MediaBean> arrayList) {
            this.fileList = arrayList;
        }

        public FragmentPicturePreview getItem(int i11) {
            MediaBean mediaBean = this.fileList.get(i11);
            FragmentPicturePreview newInstance = FragmentPicturePreview.Companion.newInstance(mediaBean);
            PicturePreviewActivity.this.fragmentHashMap.put(mediaBean.imageUrl, newInstance);
            return newInstance;
        }
    }

    private final void initDragHelper() {
        DragImageHelperLayout dragImageHelperLayout2 = this.dragImageHelperLayout;
        if (dragImageHelperLayout2 != null) {
            dragImageHelperLayout2.setOnMoveExitListener(new PicturePreviewActivity$initDragHelper$1(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(PicturePreviewActivity picturePreviewActivity) {
        picturePreviewActivity.supportStartPostponedEnterTransition();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final String getCurrenturl() {
        return this.currenturl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b2, code lost:
        r3 = r3.getAdapter();
     */
    @android.annotation.SuppressLint({"StringFormatMatches"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.view.Window r0 = r5.getWindow()
            r1 = 1024(0x400, float:1.435E-42)
            r0.setFlags(r1, r1)
            r0 = 1
            r5.requestWindowFeature(r0)
            int r1 = com.huochat.community.R.layout.activity_picture_preview
            r5.setContentView((int) r1)
            r5.supportPostponeEnterTransition()
            android.view.Window r1 = r5.getWindow()
            android.view.View r1 = r1.getDecorView()
            pv.m r2 = new pv.m
            r2.<init>(r5)
            r3 = 100
            r1.postDelayed(r2, r3)
            android.content.Intent r1 = r5.getIntent()
            java.lang.String r2 = "image_index"
            r3 = 0
            int r1 = r1.getIntExtra(r2, r3)
            r5.pagerPosition = r1
            android.content.Intent r1 = r5.getIntent()
            java.lang.String r2 = "image_urls"
            java.io.Serializable r1 = r1.getSerializableExtra(r2)
            if (r1 == 0) goto L_0x004b
            boolean r2 = r1 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x004b
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r5.mediaBeans = r1
        L_0x004b:
            java.util.ArrayList<com.huochat.community.model.MediaBean> r1 = r5.mediaBeans
            if (r1 == 0) goto L_0x005b
            int r2 = r5.pagerPosition
            java.lang.Object r1 = r1.get(r2)
            com.huochat.community.model.MediaBean r1 = (com.huochat.community.model.MediaBean) r1
            java.lang.String r1 = r1.imageUrl
            r5.currenturl = r1
        L_0x005b:
            int r1 = com.huochat.community.R.id.fl_mask_parent
            android.view.View r1 = r5.findViewById(r1)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r5.flMaskParent = r1
            int r1 = com.huochat.community.R.id.drag_image_helper_layout
            android.view.View r1 = r5.findViewById(r1)
            com.huochat.community.widget.DragImageHelperLayout r1 = (com.huochat.community.widget.DragImageHelperLayout) r1
            r5.dragImageHelperLayout = r1
            int r1 = com.huochat.community.R.id.hacky_viewPager_circle_image
            android.view.View r1 = r5.findViewById(r1)
            com.huochat.community.widget.HackyViewPager r1 = (com.huochat.community.widget.HackyViewPager) r1
            r5.hackyViewPagerCircleImage = r1
            if (r1 == 0) goto L_0x0083
            com.huochat.community.activity.PicturePreviewActivity$onCreate$2 r2 = new com.huochat.community.activity.PicturePreviewActivity$onCreate$2
            r2.<init>(r5)
            r1.addOnPageChangeListener(r2)
        L_0x0083:
            com.huochat.community.activity.PicturePreviewActivity$ImagePagerAdapter r1 = new com.huochat.community.activity.PicturePreviewActivity$ImagePagerAdapter
            androidx.fragment.app.FragmentManager r2 = r5.getSupportFragmentManager()
            java.util.ArrayList<com.huochat.community.model.MediaBean> r4 = r5.mediaBeans
            r1.<init>(r2, r4)
            r5.imagePagerAdapter = r1
            com.huochat.community.widget.HackyViewPager r2 = r5.hackyViewPagerCircleImage
            if (r2 != 0) goto L_0x0095
            goto L_0x0098
        L_0x0095:
            r2.setAdapter(r1)
        L_0x0098:
            int r1 = com.huochat.community.R.id.indicator
            android.view.View r1 = r5.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r5.indicator = r1
            int r1 = com.huochat.community.R.string.bm_viewpager_indicator
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r2[r3] = r4
            com.huochat.community.widget.HackyViewPager r3 = r5.hackyViewPagerCircleImage
            r4 = 0
            if (r3 == 0) goto L_0x00c1
            androidx.viewpager.widget.PagerAdapter r3 = r3.getAdapter()
            if (r3 == 0) goto L_0x00c1
            int r3 = r3.getCount()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00c2
        L_0x00c1:
            r3 = r4
        L_0x00c2:
            r2[r0] = r3
            java.lang.String r0 = r5.getString(r1, r2)
            android.widget.TextView r1 = r5.indicator
            if (r1 != 0) goto L_0x00cd
            goto L_0x00d0
        L_0x00cd:
            r1.setText(r0)
        L_0x00d0:
            if (r6 == 0) goto L_0x00dc
            java.lang.String r0 = r5.STATE_POSITION
            int r6 = r6.getInt(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
        L_0x00dc:
            if (r4 == 0) goto L_0x00e7
            r4.intValue()
            int r6 = r4.intValue()
            r5.pagerPosition = r6
        L_0x00e7:
            com.huochat.community.widget.HackyViewPager r6 = r5.hackyViewPagerCircleImage
            if (r6 != 0) goto L_0x00ec
            goto L_0x00f1
        L_0x00ec:
            int r0 = r5.pagerPosition
            r6.setCurrentItem(r0)
        L_0x00f1:
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r6 < r0) goto L_0x00ff
            com.huochat.community.activity.PicturePreviewActivity$onCreate$4 r6 = new com.huochat.community.activity.PicturePreviewActivity$onCreate$4
            r6.<init>(r5)
            r5.setEnterSharedElementCallback(r6)
        L_0x00ff:
            r5.initDragHelper()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.activity.PicturePreviewActivity.onCreate(android.os.Bundle):void");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        HackyViewPager hackyViewPager = this.hackyViewPagerCircleImage;
        if (hackyViewPager != null) {
            bundle.putInt(this.STATE_POSITION, hackyViewPager.getCurrentItem());
        }
    }

    public final void setCurrenturl(String str) {
        this.currenturl = str;
    }
}

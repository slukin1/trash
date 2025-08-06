package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class GalleryActivity extends Activity {
    public static final String GALLERY_ITEM = "GALLERY_ITEM";
    public static final String MEDIA_ENTITY = "MEDIA_ENTITY";
    public GalleryItem galleryItem;

    public static class GalleryItem implements Serializable {
        public final List<MediaEntity> mediaEntities;
        public final int mediaEntityIndex;
        public final long tweetId;

        public GalleryItem(int i11, List<MediaEntity> list) {
            this(0, i11, list);
        }

        public GalleryItem(long j11, int i11, List<MediaEntity> list) {
            this.tweetId = j11;
            this.mediaEntityIndex = i11;
            this.mediaEntities = list;
        }
    }

    public GalleryItem getGalleryItem() {
        MediaEntity mediaEntity = (MediaEntity) getIntent().getSerializableExtra(MEDIA_ENTITY);
        if (mediaEntity != null) {
            return new GalleryItem(0, Collections.singletonList(mediaEntity));
        }
        return (GalleryItem) getIntent().getSerializableExtra(GALLERY_ITEM);
    }

    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            public int galleryPosition = -1;

            public void onPageScrollStateChanged(int i11) {
            }

            public void onPageScrolled(int i11, float f11, int i12) {
                int i13 = this.galleryPosition;
                if (i13 == -1 && i11 == 0 && ((double) f11) == 0.0d) {
                    this.galleryPosition = i13 + 1;
                }
            }

            public void onPageSelected(int i11) {
                this.galleryPosition++;
            }
        };
    }

    public SwipeToDismissTouchListener.Callback getSwipeToDismissCallback() {
        return new SwipeToDismissTouchListener.Callback() {
            public void onDismiss() {
                GalleryActivity.this.finish();
                GalleryActivity.this.overridePendingTransition(0, R.anim.tw__slide_out);
            }

            public void onMove(float f11) {
            }
        };
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.tw__slide_out);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__gallery_activity);
        this.galleryItem = getGalleryItem();
        GalleryAdapter galleryAdapter = new GalleryAdapter(this, getSwipeToDismissCallback());
        galleryAdapter.addAll(this.galleryItem.mediaEntities);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tw__view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.tw__gallery_page_margin));
        viewPager.addOnPageChangeListener(getOnPageChangeListener());
        viewPager.setAdapter(galleryAdapter);
        viewPager.setCurrentItem(this.galleryItem.mediaEntityIndex);
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}

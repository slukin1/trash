package com.hbg.lib.widgets.photoviewer;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.e0;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import java.util.ArrayList;
import qiu.niorgai.StatusBarCompat;

@Route(path = "/photoviewer/main")
public class PhotoViewerActivity extends AppCompatActivity {

    /* renamed from: g  reason: collision with root package name */
    public static final String f72139g = "PhotoViewerActivity";

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f72140b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f72141c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f72142d;

    /* renamed from: e  reason: collision with root package name */
    public PhotoViewPager f72143e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f72144f = new a();

    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            PhotoViewerActivity.this.f72141c.setText(String.valueOf(i11 + 1));
        }
    }

    public class b extends e0 {

        /* renamed from: h  reason: collision with root package name */
        public ArrayList<ImageData> f72146h;

        public b(FragmentManager fragmentManager, int i11, ArrayList<ImageData> arrayList) {
            super(fragmentManager, i11);
            this.f72146h = arrayList;
        }

        public int getCount() {
            return this.f72146h.size();
        }

        public Fragment getItem(int i11) {
            return PhotoViewFragment.uh(this.f72146h.get(i11));
        }
    }

    public final void Af() {
        getWindow().getDecorView().setSystemUiVisibility(4354);
        StatusBarCompat.d(this, true);
    }

    public final void Bf(PhotoViewPager photoViewPager) {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("photoviewer_extra_images");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            Log.e(f72139g, "images is null ");
            finish();
            return;
        }
        b bVar = new b(getSupportFragmentManager(), 1, parcelableArrayListExtra);
        int intExtra = getIntent().getIntExtra("photoviewer_extra_position", 0);
        photoViewPager.setAdapter(bVar);
        photoViewPager.setCurrentItem((intExtra >= parcelableArrayListExtra.size() || intExtra <= 0) ? 0 : intExtra);
        if (parcelableArrayListExtra.size() > 0) {
            this.f72140b.setVisibility(0);
            this.f72141c.setText(String.valueOf(intExtra + 1));
            this.f72142d.setText(String.valueOf(parcelableArrayListExtra.size()));
        }
        photoViewPager.addOnPageChangeListener(this.f72144f);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Af();
        setContentView(R$layout.activity_photo_verwer);
        this.f72143e = (PhotoViewPager) findViewById(R$id.view_pager);
        this.f72140b = (LinearLayout) findViewById(R$id.llIndicator);
        this.f72141c = (TextView) findViewById(R$id.tvIndicator);
        this.f72142d = (TextView) findViewById(R$id.tvIndicatorAll);
        Bf(this.f72143e);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f72143e.removeOnPageChangeListener(this.f72144f);
        this.f72144f = null;
    }
}

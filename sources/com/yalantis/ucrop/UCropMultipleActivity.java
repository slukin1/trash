package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropFragment;
import com.yalantis.ucrop.UCropGalleryAdapter;
import com.yalantis.ucrop.decoration.GridSpacingItemDecoration;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.statusbar.ImmersiveManager;
import com.yalantis.ucrop.util.DensityUtil;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class UCropMultipleActivity extends AppCompatActivity implements UCropFragmentCallback {
    private ArrayList<AspectRatio> aspectRatioList;
    private int currentFragmentPosition;
    /* access modifiers changed from: private */
    public final HashSet<String> filterSet = new HashSet<>();
    /* access modifiers changed from: private */
    public final List<UCropFragment> fragments = new ArrayList();
    /* access modifiers changed from: private */
    public UCropGalleryAdapter galleryAdapter;
    private boolean isForbidCropGifWebp;
    /* access modifiers changed from: private */
    public boolean isSkipCropForbid;
    private boolean mShowLoader;
    private int mStatusBarColor;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarTitleSize;
    private int mToolbarWidgetColor;
    private String outputCropFileName;
    private UCropFragment uCropCurrentFragment;
    private ArrayList<String> uCropNotSupportList;
    /* access modifiers changed from: private */
    public ArrayList<String> uCropSupportList;
    private final LinkedHashMap<String, JSONObject> uCropTotalQueue = new LinkedHashMap<>();

    static {
        AppCompatDelegate.I(true);
    }

    private int getCropSupportPosition() {
        ArrayList<String> stringArrayList;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (stringArrayList = extras.getStringArrayList(UCrop.Options.EXTRA_SKIP_CROP_MIME_TYPE)) == null || stringArrayList.size() <= 0) {
            return 0;
        }
        this.filterSet.addAll(stringArrayList);
        int i11 = -1;
        for (int i12 = 0; i12 < this.uCropSupportList.size(); i12++) {
            i11++;
            if (!this.filterSet.contains(getPathToMimeType(this.uCropSupportList.get(i12)))) {
                break;
            }
        }
        if (i11 == -1 || i11 > this.fragments.size()) {
            return 0;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public String getPathToMimeType(String str) {
        if (FileUtils.isContent(str)) {
            return FileUtils.getMimeTypeFromMediaContentUri(this, Uri.parse(str));
        }
        return FileUtils.getMimeTypeFromMediaContentUri(this, Uri.fromFile(new File(str)));
    }

    private String getSandboxPathDir() {
        File file;
        String stringExtra = getIntent().getStringExtra(UCrop.Options.EXTRA_CROP_OUTPUT_DIR);
        if (stringExtra == null || "".equals(stringExtra)) {
            file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "Sandbox");
        } else {
            file = new File(stringExtra);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    private void handleCropError(Intent intent) {
        Throwable error = UCrop.getError(intent);
        if (error != null) {
            Toast.makeText(this, error.getMessage(), 1).show();
        } else {
            Toast.makeText(this, "Unexpected error", 0).show();
        }
    }

    private void immersive() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(UCrop.Options.EXTRA_DARK_STATUS_BAR_BLACK, false);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mStatusBarColor = intExtra;
        ImmersiveManager.immersiveAboveAPI23(this, intExtra, intExtra, booleanExtra);
    }

    private void initCropFragments(Intent intent) {
        String str;
        int i11 = 0;
        this.isSkipCropForbid = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_SKIP, false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(UCrop.EXTRA_CROP_TOTAL_DATA_SOURCE);
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            throw new IllegalArgumentException("Missing required parameters, count cannot be less than 1");
        }
        this.uCropSupportList = new ArrayList<>();
        this.uCropNotSupportList = new ArrayList<>();
        while (i11 < stringArrayListExtra.size()) {
            String str2 = stringArrayListExtra.get(i11);
            this.uCropTotalQueue.put(str2, new JSONObject());
            String path = FileUtils.isContent(str2) ? FileUtils.getPath(this, Uri.parse(str2)) : str2;
            String pathToMimeType = getPathToMimeType(str2);
            if (FileUtils.isUrlHasVideo(path) || FileUtils.isHasVideo(pathToMimeType) || FileUtils.isHasAudio(pathToMimeType)) {
                this.uCropNotSupportList.add(str2);
            } else {
                this.uCropSupportList.add(str2);
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Uri parse = (FileUtils.isContent(str2) || FileUtils.isHasHttp(str2)) ? Uri.parse(str2) : Uri.fromFile(new File(str2));
                    String postfixDefaultJPEG = FileUtils.getPostfixDefaultJPEG(this, this.isForbidCropGifWebp, parse);
                    if (TextUtils.isEmpty(this.outputCropFileName)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(FileUtils.getCreateFileName("CROP_" + (i11 + 1)));
                        sb2.append(postfixDefaultJPEG);
                        str = sb2.toString();
                    } else {
                        str = (i11 + 1) + FileUtils.getCreateFileName() + "_" + this.outputCropFileName;
                    }
                    Uri fromFile = Uri.fromFile(new File(getSandboxPathDir(), str));
                    extras.putParcelable(UCrop.EXTRA_INPUT_URI, parse);
                    extras.putParcelable("com.yalantis.ucrop.OutputUri", fromFile);
                    ArrayList<AspectRatio> arrayList = this.aspectRatioList;
                    AspectRatio aspectRatio = (arrayList == null || arrayList.size() <= i11) ? null : this.aspectRatioList.get(i11);
                    float f11 = -1.0f;
                    extras.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, aspectRatio != null ? aspectRatio.getAspectRatioX() : -1.0f);
                    if (aspectRatio != null) {
                        f11 = aspectRatio.getAspectRatioY();
                    }
                    extras.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, f11);
                    this.fragments.add(UCropFragment.newInstance(extras));
                }
            }
            i11++;
        }
        if (this.uCropSupportList.size() != 0) {
            setGalleryAdapter();
            switchCropFragment(this.fragments.get(getCropSupportPosition()), getCropSupportPosition());
            this.galleryAdapter.setCurrentSelectPosition(getCropSupportPosition());
            return;
        }
        throw new IllegalArgumentException("No clipping data sources are available");
    }

    private void mergeCropResult(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(UCrop.EXTRA_CROP_INPUT_ORIGINAL);
            JSONObject jSONObject = this.uCropTotalQueue.get(stringExtra);
            Uri output = UCrop.getOutput(intent);
            jSONObject.put("outPutPath", output != null ? output.getPath() : "");
            jSONObject.put("imageWidth", UCrop.getOutputImageWidth(intent));
            jSONObject.put("imageHeight", UCrop.getOutputImageHeight(intent));
            jSONObject.put("offsetX", UCrop.getOutputImageOffsetX(intent));
            jSONObject.put("offsetY", UCrop.getOutputImageOffsetY(intent));
            jSONObject.put("aspectRatio", (double) UCrop.getOutputCropAspectRatio(intent));
            this.uCropTotalQueue.put(stringExtra, jSONObject);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void onCropCompleteFinish() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, JSONObject> value : this.uCropTotalQueue.entrySet()) {
            jSONArray.put((JSONObject) value.getValue());
        }
        Intent intent = new Intent();
        intent.putExtra("output", jSONArray.toString());
        setResult(-1, intent);
        finish();
    }

    private void setGalleryAdapter() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_gallery);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(Integer.MAX_VALUE, DensityUtil.dip2px(this, 6.0f), true));
        }
        recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(this, R.anim.ucrop_layout_animation_fall_down));
        recyclerView.setBackgroundResource(getIntent().getIntExtra(UCrop.Options.EXTRA_GALLERY_BAR_BACKGROUND, R.drawable.ucrop_gallery_bg));
        UCropGalleryAdapter uCropGalleryAdapter = new UCropGalleryAdapter(this.uCropSupportList);
        this.galleryAdapter = uCropGalleryAdapter;
        uCropGalleryAdapter.setOnItemClickListener(new UCropGalleryAdapter.OnItemClickListener() {
            public void onItemClick(int i11, View view) {
                if (!UCropMultipleActivity.this.isSkipCropForbid) {
                    if (UCropMultipleActivity.this.filterSet.contains(UCropMultipleActivity.this.getPathToMimeType((String) UCropMultipleActivity.this.uCropSupportList.get(i11)))) {
                        Toast.makeText(UCropMultipleActivity.this.getApplicationContext(), UCropMultipleActivity.this.getString(R.string.ucrop_not_crop), 0).show();
                    } else if (UCropMultipleActivity.this.galleryAdapter.getCurrentSelectPosition() != i11) {
                        UCropMultipleActivity.this.galleryAdapter.notifyItemChanged(UCropMultipleActivity.this.galleryAdapter.getCurrentSelectPosition());
                        UCropMultipleActivity.this.galleryAdapter.setCurrentSelectPosition(i11);
                        UCropMultipleActivity.this.galleryAdapter.notifyItemChanged(i11);
                        UCropMultipleActivity.this.switchCropFragment((UCropFragment) UCropMultipleActivity.this.fragments.get(i11), i11);
                    }
                }
            }
        });
        recyclerView.setAdapter(this.galleryAdapter);
    }

    @TargetApi(21)
    private void setStatusBarColor(int i11) {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i11);
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        textView.setTextSize((float) this.mToolbarTitleSize);
        Drawable mutate = a.b(this, this.mToolbarCancelDrawable).mutate();
        mutate.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setupViews(Intent intent) {
        this.aspectRatioList = getIntent().getParcelableArrayListExtra(UCrop.Options.EXTRA_MULTIPLE_ASPECT_RATIO);
        this.isForbidCropGifWebp = intent.getBooleanExtra(UCrop.Options.EXTRA_CROP_FORBID_GIF_WEBP, false);
        this.outputCropFileName = intent.getStringExtra(UCrop.Options.EXTRA_CROP_OUTPUT_FILE_NAME);
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        this.mToolbarTitle = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitleSize = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_SIZE_TOOLBAR, 18);
        String str = this.mToolbarTitle;
        if (str == null) {
            str = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = str;
        setupAppBar();
    }

    /* access modifiers changed from: private */
    public void switchCropFragment(UCropFragment uCropFragment, int i11) {
        FragmentTransaction q11 = getSupportFragmentManager().q();
        if (!uCropFragment.isAdded()) {
            UCropFragment uCropFragment2 = this.uCropCurrentFragment;
            if (uCropFragment2 != null) {
                q11.q(uCropFragment2);
            }
            int i12 = R.id.fragment_container;
            q11.c(i12, uCropFragment, UCropFragment.TAG + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11);
        } else {
            q11.q(this.uCropCurrentFragment).A(uCropFragment);
            uCropFragment.fragmentReVisible();
        }
        this.currentFragmentPosition = i11;
        this.uCropCurrentFragment = uCropFragment;
        q11.k();
    }

    public void loadingProgress(boolean z11) {
        this.mShowLoader = z11;
        supportInvalidateOptionsMenu();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        immersive();
        setContentView(R.layout.ucrop_activity_multiple);
        setupViews(getIntent());
        initCropFragments(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
                findItem.setIcon(icon);
            } catch (IllegalStateException e11) {
                e11.printStackTrace();
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable == null) {
            return true;
        }
        drawable.mutate();
        drawable.setColorFilter(t0.a.a(this.mToolbarWidgetColor, BlendModeCompat.SRC_ATOP));
        findItem2.setIcon(drawable);
        return true;
    }

    public void onCropFinish(UCropFragment.UCropResult uCropResult) {
        int i11 = uCropResult.mResultCode;
        if (i11 == -1) {
            int size = this.currentFragmentPosition + this.uCropNotSupportList.size();
            boolean z11 = true;
            int size2 = (this.uCropNotSupportList.size() + this.uCropSupportList.size()) - 1;
            mergeCropResult(uCropResult.mResultData);
            if (size == size2) {
                onCropCompleteFinish();
                return;
            }
            int i12 = this.currentFragmentPosition + 1;
            String pathToMimeType = getPathToMimeType(this.uCropSupportList.get(i12));
            while (true) {
                if (!this.filterSet.contains(pathToMimeType)) {
                    z11 = false;
                    break;
                } else if (i12 == size2) {
                    break;
                } else {
                    i12++;
                    pathToMimeType = getPathToMimeType(this.uCropSupportList.get(i12));
                }
            }
            if (z11) {
                onCropCompleteFinish();
                return;
            }
            switchCropFragment(this.fragments.get(i12), i12);
            UCropGalleryAdapter uCropGalleryAdapter = this.galleryAdapter;
            uCropGalleryAdapter.notifyItemChanged(uCropGalleryAdapter.getCurrentSelectPosition());
            this.galleryAdapter.setCurrentSelectPosition(i12);
            UCropGalleryAdapter uCropGalleryAdapter2 = this.galleryAdapter;
            uCropGalleryAdapter2.notifyItemChanged(uCropGalleryAdapter2.getCurrentSelectPosition());
        } else if (i11 == 96) {
            handleCropError(uCropResult.mResultData);
        }
    }

    public void onDestroy() {
        UCropDevelopConfig.destroy();
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            UCropFragment uCropFragment = this.uCropCurrentFragment;
            if (uCropFragment != null && uCropFragment.isAdded()) {
                this.uCropCurrentFragment.cropAndSaveImage();
            }
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }
}

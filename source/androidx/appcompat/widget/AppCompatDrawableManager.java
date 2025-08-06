package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import t0.c;

public final class AppCompatDrawableManager {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f4345b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static AppCompatDrawableManager f4346c;

    /* renamed from: a  reason: collision with root package name */
    public ResourceManagerInternal f4347a;

    public class a implements ResourceManagerInternal.f {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f4348a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        public final int[] f4349b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        public final int[] f4350c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d  reason: collision with root package name */
        public final int[] f4351d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        public final int[] f4352e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        public final int[] f4353f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        public Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i11) {
            if (i11 == R$drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.j(context, R$drawable.abc_cab_background_internal_bg), resourceManagerInternal.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i11 == R$drawable.abc_ratingbar_material) {
                return l(resourceManagerInternal, context, R$dimen.abc_star_big);
            } else {
                if (i11 == R$drawable.abc_ratingbar_indicator_material) {
                    return l(resourceManagerInternal, context, R$dimen.abc_star_medium);
                }
                if (i11 == R$drawable.abc_ratingbar_small_material) {
                    return l(resourceManagerInternal, context, R$dimen.abc_star_small);
                }
                return null;
            }
        }

        public ColorStateList b(Context context, int i11) {
            if (i11 == R$drawable.abc_edit_text_material) {
                return c.a.a(context, R$color.abc_tint_edittext);
            }
            if (i11 == R$drawable.abc_switch_track_mtrl_alpha) {
                return c.a.a(context, R$color.abc_tint_switch_track);
            }
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i11 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i11 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i11 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i11 == R$drawable.abc_spinner_mtrl_am_alpha || i11 == R$drawable.abc_spinner_textfield_background_material) {
                return c.a.a(context, R$color.abc_tint_spinner);
            }
            if (f(this.f4349b, i11)) {
                return z.e(context, R$attr.colorControlNormal);
            }
            if (f(this.f4352e, i11)) {
                return c.a.a(context, R$color.abc_tint_default);
            }
            if (f(this.f4353f, i11)) {
                return c.a.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i11 == R$drawable.abc_seekbar_thumb_material) {
                return c.a.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        public PorterDuff.Mode c(int i11) {
            if (i11 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public boolean d(Context context, int i11, Drawable drawable) {
            if (i11 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i12 = R$attr.colorControlNormal;
                m(findDrawableByLayerId, z.c(context, i12), AppCompatDrawableManager.f4345b);
                m(layerDrawable.findDrawableByLayerId(16908303), z.c(context, i12), AppCompatDrawableManager.f4345b);
                m(layerDrawable.findDrawableByLayerId(16908301), z.c(context, R$attr.colorControlActivated), AppCompatDrawableManager.f4345b);
                return true;
            } else if (i11 != R$drawable.abc_ratingbar_material && i11 != R$drawable.abc_ratingbar_indicator_material && i11 != R$drawable.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(16908288), z.b(context, R$attr.colorControlNormal), AppCompatDrawableManager.f4345b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i13 = R$attr.colorControlActivated;
                m(findDrawableByLayerId2, z.c(context, i13), AppCompatDrawableManager.f4345b);
                m(layerDrawable2.findDrawableByLayerId(16908301), z.c(context, i13), AppCompatDrawableManager.f4345b);
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean e(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.f4345b
                int[] r1 = r6.f4348a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = androidx.appcompat.R$attr.colorControlNormal
            L_0x0014:
                r8 = r3
            L_0x0015:
                r1 = r5
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f4350c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = androidx.appcompat.R$attr.colorControlActivated
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f4351d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = r3
                r1 = r4
                r2 = r1
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.r.a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.z.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.a.e(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public final boolean f(int[] iArr, int i11) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i11) {
            int c11 = z.c(context, R$attr.colorControlHighlight);
            int b11 = z.b(context, R$attr.colorButtonNormal);
            return new ColorStateList(new int[][]{z.f4727b, z.f4730e, z.f4728c, z.f4734i}, new int[]{b11, c.f(c11, i11), c.f(c11, i11), i11});
        }

        public final ColorStateList i(Context context) {
            return h(context, z.c(context, R$attr.colorAccent));
        }

        public final ColorStateList j(Context context) {
            return h(context, z.c(context, R$attr.colorButtonNormal));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i11 = R$attr.colorSwitchThumbNormal;
            ColorStateList e11 = z.e(context, i11);
            if (e11 == null || !e11.isStateful()) {
                iArr[0] = z.f4727b;
                iArr2[0] = z.b(context, i11);
                iArr[1] = z.f4731f;
                iArr2[1] = z.c(context, R$attr.colorControlActivated);
                iArr[2] = z.f4734i;
                iArr2[2] = z.c(context, i11);
            } else {
                iArr[0] = z.f4727b;
                iArr2[0] = e11.getColorForState(iArr[0], 0);
                iArr[1] = z.f4731f;
                iArr2[1] = z.c(context, R$attr.colorControlActivated);
                iArr[2] = z.f4734i;
                iArr2[2] = e11.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(ResourceManagerInternal resourceManagerInternal, Context context, int i11) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i11);
            Drawable j11 = resourceManagerInternal.j(context, R$drawable.abc_star_black_48dp);
            Drawable j12 = resourceManagerInternal.j(context, R$drawable.abc_star_half_black_48dp);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) j11;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((j12 instanceof BitmapDrawable) && j12.getIntrinsicWidth() == dimensionPixelSize && j12.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j12;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j12.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j12.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i11, PorterDuff.Mode mode) {
            if (r.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = AppCompatDrawableManager.f4345b;
            }
            drawable.setColorFilter(AppCompatDrawableManager.e(i11, mode));
        }
    }

    public static synchronized AppCompatDrawableManager b() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (f4346c == null) {
                h();
            }
            appCompatDrawableManager = f4346c;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter e(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter l11;
        synchronized (AppCompatDrawableManager.class) {
            l11 = ResourceManagerInternal.l(i11, mode);
        }
        return l11;
    }

    public static synchronized void h() {
        synchronized (AppCompatDrawableManager.class) {
            if (f4346c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f4346c = appCompatDrawableManager;
                appCompatDrawableManager.f4347a = ResourceManagerInternal.h();
                f4346c.f4347a.u(new a());
            }
        }
    }

    public static void i(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.w(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(Context context, int i11) {
        return this.f4347a.j(context, i11);
    }

    public synchronized Drawable d(Context context, int i11, boolean z11) {
        return this.f4347a.k(context, i11, z11);
    }

    public synchronized ColorStateList f(Context context, int i11) {
        return this.f4347a.m(context, i11);
    }

    public synchronized void g(Context context) {
        this.f4347a.s(context);
    }
}

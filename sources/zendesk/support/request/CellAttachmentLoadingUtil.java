package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.r;
import com.squareup.picasso.v;
import com.zendesk.logger.Logger;
import com.zendesk.sdk.R$color;
import com.zendesk.sdk.R$dimen;
import com.zendesk.service.ZendeskCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lz.a;
import mz.f;
import zendesk.support.PicassoTransformations;

class CellAttachmentLoadingUtil {
    private static final String LOG_TAG = "AttachmentLoadingUtil";
    /* access modifiers changed from: private */
    public final ImageLoadingLogic imageLoadingLogic;
    private final ImageSizingLogic imageSizingLogic;

    public static class ImageLoadingLogic {
        private static final int IMAGE_DOWNSCALE_FACTOR = 2;
        private final Picasso picasso;

        public static class DefaultDisplayStrategy implements LoadingStrategy {
            private DefaultDisplayStrategy() {
            }

            public void load(ImageView imageView, ImageSizingLogic.ImageDimensions imageDimensions) {
            }
        }

        public static class DisplayImageFromLocalSource implements LoadingStrategy {
            private final r requestCreator;

            public void load(ImageView imageView, ImageSizingLogic.ImageDimensions imageDimensions) {
                ImageLoadingLogic.loadImage(imageView, this.requestCreator.k().j(), imageDimensions, (Callback) null);
            }

            private DisplayImageFromLocalSource(r rVar) {
                this.requestCreator = rVar;
            }
        }

        public static class DisplayImageFromWeb implements LoadingStrategy {
            public final Picasso picasso;
            public final String thumbnailUrl;
            public final String url;

            public void load(final ImageView imageView, final ImageSizingLogic.ImageDimensions imageDimensions) {
                ImageLoadingLogic.loadImage(imageView, this.picasso.l(this.thumbnailUrl).n(PicassoTransformations.getBlurTransformation(imageView.getContext().getApplicationContext())), imageDimensions, new Callback() {
                    public void onError(Exception exc) {
                        Logger.b(RequestActivity.LOG_TAG, "Unable to load thumbnail. Url: '%s'", DisplayImageFromWeb.this.thumbnailUrl, exc);
                        ImageView imageView = imageView;
                        DisplayImageFromWeb displayImageFromWeb = DisplayImageFromWeb.this;
                        ImageLoadingLogic.loadImage(imageView, displayImageFromWeb.picasso.l(displayImageFromWeb.url).k(), imageDimensions, (Callback) null);
                    }

                    public void onSuccess() {
                        ImageView imageView = imageView;
                        DisplayImageFromWeb displayImageFromWeb = DisplayImageFromWeb.this;
                        ImageLoadingLogic.loadImage(imageView, displayImageFromWeb.picasso.l(displayImageFromWeb.url).k(), imageDimensions, (Callback) null);
                    }
                });
            }

            private DisplayImageFromWeb(Picasso picasso2, String str, String str2) {
                this.picasso = picasso2;
                this.url = str;
                this.thumbnailUrl = str2;
            }
        }

        public interface LoadingStrategy {
            void load(ImageView imageView, ImageSizingLogic.ImageDimensions imageDimensions);
        }

        public ImageLoadingLogic(Picasso picasso2) {
            this.picasso = picasso2;
        }

        private LoadingStrategy getLoadingStrategy(StateRequestAttachment stateRequestAttachment) {
            if (stateRequestAttachment.getLocalFile() != null && stateRequestAttachment.getLocalFile().exists() && stateRequestAttachment.getLocalFile().length() > 0) {
                return new DisplayImageFromLocalSource(this.picasso.k(stateRequestAttachment.getLocalFile()));
            }
            if (f.c(stateRequestAttachment.getLocalUri()) && Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                return new DisplayImageFromLocalSource(this.picasso.j(stateRequestAttachment.getParsedLocalUri()));
            }
            if (f.c(stateRequestAttachment.getUrl()) && f.c(stateRequestAttachment.getThumbnailUrl())) {
                return new DisplayImageFromWeb(this.picasso, stateRequestAttachment.getUrl(), stateRequestAttachment.getThumbnailUrl());
            }
            Logger.b(RequestActivity.LOG_TAG, "Can't load image. Id: %s", Long.valueOf(stateRequestAttachment.getId()));
            return new DefaultDisplayStrategy();
        }

        /* access modifiers changed from: private */
        public static void loadImage(ImageView imageView, r rVar, ImageSizingLogic.ImageDimensions imageDimensions, Callback callback) {
            rVar.n(PicassoTransformations.getRoundedTransformation(imageView.getContext().getResources().getDimensionPixelOffset(R$dimen.zs_request_attachment_corner_radius) / 2)).m(imageDimensions.getImageWidth() / 2, imageDimensions.getImageHeight() / 2).a().h(imageView, callback);
        }

        public void initImageView(ImageView imageView) {
            this.picasso.b(imageView);
            imageView.setImageResource(R$color.zs_color_transparent);
        }

        public boolean isImageLoading(ImageView imageView, StateRequestAttachment stateRequestAttachment) {
            Object tag = imageView.getTag();
            return (tag instanceof StateRequestAttachment) && ((StateRequestAttachment) tag).getId() == stateRequestAttachment.getId();
        }

        public void loadAttachment(ImageView imageView, StateRequestAttachment stateRequestAttachment, ImageSizingLogic.ImageDimensions imageDimensions) {
            getLoadingStrategy(stateRequestAttachment).load(imageView, imageDimensions);
        }

        public void setImageViewLoading(ImageView imageView, StateRequestAttachment stateRequestAttachment) {
            imageView.setTag(stateRequestAttachment);
        }
    }

    public static class ImageSizingLogic {
        private static final double ASPECT_RATIO = 1.7777777777777777d;
        /* access modifiers changed from: private */
        public final Map<String, ImageDimensions> cachedDimensions = new HashMap();
        private final ImageDimensions maxSize;
        private final Picasso picasso;

        public static class DefaultStrategy implements DimensionStrategy {
            private DefaultStrategy() {
            }

            public void findDimensions(ZendeskCallback<ImageDimensions> zendeskCallback) {
                zendeskCallback.onSuccess(new ImageDimensions());
            }
        }

        public interface DimensionStrategy {
            void findDimensions(ZendeskCallback<ImageDimensions> zendeskCallback);
        }

        public static class ExistingDimensions implements DimensionStrategy {
            private final int height;
            private final ImageDimensions maxSize;
            private final int width;

            public ExistingDimensions(int i11, int i12, ImageDimensions imageDimensions) {
                this.width = i11;
                this.height = i12;
                this.maxSize = imageDimensions;
            }

            public void findDimensions(ZendeskCallback<ImageDimensions> zendeskCallback) {
                zendeskCallback.onSuccess(ImageSizingLogic.determineTargetDimensions(this.width, this.height, this.maxSize.getImageWidth(), this.maxSize.getImageHeight()));
            }
        }

        public static class ReadFromBitmap implements DimensionStrategy {
            public final File file;
            private final ImageDimensions maxSize;

            public ReadFromBitmap(File file2, ImageDimensions imageDimensions) {
                this.maxSize = imageDimensions;
                this.file = file2;
            }

            private ImageDimensions loadImageDimensions(File file2) {
                ImageDimensions imageDimensions = new ImageDimensions();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file2.getAbsolutePath(), options);
                imageDimensions.setDimensions(options.outWidth, options.outHeight);
                return imageDimensions;
            }

            public void findDimensions(ZendeskCallback<ImageDimensions> zendeskCallback) {
                ImageDimensions loadImageDimensions = loadImageDimensions(this.file);
                zendeskCallback.onSuccess(ImageSizingLogic.determineTargetDimensions(loadImageDimensions.getImageWidth(), loadImageDimensions.getImageHeight(), this.maxSize.getImageWidth(), this.maxSize.getImageHeight()));
            }
        }

        public static class ReadFromPicasso implements DimensionStrategy {
            /* access modifiers changed from: private */
            public static final List<v> TARGET_REFERENCE_TRAP = new ArrayList();
            /* access modifiers changed from: private */
            public final ImageDimensions maxSize;
            private final r requestCreator;

            public void findDimensions(final ZendeskCallback<ImageDimensions> zendeskCallback) {
                AnonymousClass1 r02 = new v() {
                    public void onBitmapFailed(Exception exc, Drawable drawable) {
                        Logger.b(RequestActivity.LOG_TAG, "Unable to load image.", new Object[0]);
                        zendeskCallback.onSuccess(new ImageDimensions());
                        ReadFromPicasso.TARGET_REFERENCE_TRAP.remove(this);
                    }

                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                        zendeskCallback.onSuccess(ImageSizingLogic.determineTargetDimensions(bitmap.getWidth(), bitmap.getHeight(), ReadFromPicasso.this.maxSize.getImageWidth(), ReadFromPicasso.this.maxSize.getImageHeight()));
                        ReadFromPicasso.TARGET_REFERENCE_TRAP.remove(this);
                    }

                    public void onPrepareLoad(Drawable drawable) {
                    }
                };
                TARGET_REFERENCE_TRAP.add(r02);
                this.requestCreator.i(r02);
            }

            private ReadFromPicasso(r rVar, ImageDimensions imageDimensions) {
                this.requestCreator = rVar;
                this.maxSize = imageDimensions;
            }
        }

        public ImageSizingLogic(Picasso picasso2, Context context) {
            this.picasso = picasso2;
            this.maxSize = getMaxSize(context);
        }

        private int calculateMaxWidth(Context context) {
            Resources resources = context.getResources();
            return (resources.getDisplayMetrics().widthPixels - resources.getDimensionPixelSize(R$dimen.zs_request_message_composer_expanded_side_margin)) - resources.getDimensionPixelSize(R$dimen.zs_request_message_margin_side);
        }

        public static ImageDimensions determineTargetDimensions(int i11, int i12, int i13, int i14) {
            ImageDimensions imageDimensions = new ImageDimensions();
            int i15 = (int) (((double) i13) / ((((double) i11) * 1.0d) / ((double) i12)));
            if (i11 > i12) {
                if (i11 > i13) {
                    i11 = i13;
                }
                imageDimensions.setDimensions(i11, Math.max(Math.min(i14, i12), 0));
                return imageDimensions;
            }
            if (i12 > i15) {
                i11 = Math.min(i13, i11);
            }
            imageDimensions.setDimensions(i11, Math.max(Math.min(i14, i12), 0));
            return imageDimensions;
            i12 = i15;
            imageDimensions.setDimensions(i11, Math.max(Math.min(i14, i12), 0));
            return imageDimensions;
        }

        private DimensionStrategy getDimensionStrategy(StateRequestAttachment stateRequestAttachment, ImageDimensions imageDimensions) {
            if (stateRequestAttachment.getHeight() > 0 && stateRequestAttachment.getWidth() > 0) {
                return new ExistingDimensions(stateRequestAttachment.getWidth(), stateRequestAttachment.getHeight(), imageDimensions);
            }
            if (f.c(stateRequestAttachment.getLocalUri()) && this.cachedDimensions.containsKey(stateRequestAttachment.getLocalUri())) {
                ImageDimensions imageDimensions2 = this.cachedDimensions.get(stateRequestAttachment.getLocalUri());
                return new ExistingDimensions(imageDimensions2.getImageWidth(), imageDimensions2.getImageHeight(), imageDimensions);
            } else if (stateRequestAttachment.getLocalFile() != null && stateRequestAttachment.getLocalFile().exists() && stateRequestAttachment.getLocalFile().length() > 0) {
                return new ReadFromBitmap(stateRequestAttachment.getLocalFile(), imageDimensions);
            } else {
                if (f.c(stateRequestAttachment.getLocalUri()) && Uri.parse(stateRequestAttachment.getLocalUri()) != null) {
                    return new ReadFromPicasso(this.picasso.j(Uri.parse(stateRequestAttachment.getLocalUri())), imageDimensions);
                } else if (f.c(stateRequestAttachment.getUrl())) {
                    return new ReadFromPicasso(this.picasso.l(stateRequestAttachment.getUrl()), imageDimensions);
                } else {
                    Logger.b(RequestActivity.LOG_TAG, "Can't load dimensions. Id: %s", Long.valueOf(stateRequestAttachment.getId()));
                    return new DefaultStrategy();
                }
            }
        }

        public ImageDimensions getMaxSize() {
            return this.maxSize;
        }

        public void loadDimensionsForAttachment(final StateRequestAttachment stateRequestAttachment, final ZendeskCallback<ImageDimensions> zendeskCallback) {
            getDimensionStrategy(stateRequestAttachment, this.maxSize).findDimensions(new ZendeskCallback<ImageDimensions>() {
                public void onError(a aVar) {
                }

                public void onSuccess(ImageDimensions imageDimensions) {
                    if (f.c(stateRequestAttachment.getLocalUri()) && imageDimensions.areKnown()) {
                        ImageSizingLogic.this.cachedDimensions.put(stateRequestAttachment.getLocalUri(), imageDimensions);
                    }
                    zendeskCallback.onSuccess(imageDimensions);
                }
            });
        }

        private ImageDimensions getMaxSize(Context context) {
            int calculateMaxWidth = calculateMaxWidth(context);
            return new ImageDimensions(calculateMaxWidth, (int) (((double) calculateMaxWidth) / 1.7777777777777777d));
        }

        public static class ImageDimensions {
            private static final int UNKNOWN_DIMENSION = -1;
            private int imageHeight = -1;
            private int imageWidth = -1;

            public ImageDimensions(int i11, int i12) {
                this.imageWidth = i11;
                this.imageHeight = i12;
            }

            public boolean areKnown() {
                return (this.imageWidth == -1 || this.imageHeight == -1) ? false : true;
            }

            public int getImageHeight() {
                return this.imageHeight;
            }

            public int getImageWidth() {
                return this.imageWidth;
            }

            public void setDimensions(int i11, int i12) {
                this.imageWidth = i11;
                this.imageHeight = i12;
            }

            public String toString() {
                return "ImageDimensions{width=" + this.imageWidth + ", height=" + this.imageHeight + '}';
            }

            public ImageDimensions() {
            }
        }
    }

    public CellAttachmentLoadingUtil(Picasso picasso, Context context) {
        this.imageSizingLogic = new ImageSizingLogic(picasso, context);
        this.imageLoadingLogic = new ImageLoadingLogic(picasso);
    }

    /* access modifiers changed from: private */
    public void adjustImageViewDimensions(ImageView imageView, ImageSizingLogic.ImageDimensions imageDimensions) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = imageDimensions.getImageWidth();
        layoutParams.height = imageDimensions.getImageHeight();
        imageView.setLayoutParams(layoutParams);
    }

    public void bindImage(final ImageView imageView, final StateRequestAttachment stateRequestAttachment) {
        if (!this.imageLoadingLogic.isImageLoading(imageView, stateRequestAttachment)) {
            this.imageLoadingLogic.setImageViewLoading(imageView, stateRequestAttachment);
            adjustImageViewDimensions(imageView, this.imageSizingLogic.getMaxSize());
            this.imageLoadingLogic.initImageView(imageView);
            this.imageSizingLogic.loadDimensionsForAttachment(stateRequestAttachment, new ZendeskCallback<ImageSizingLogic.ImageDimensions>() {
                public void onError(a aVar) {
                }

                public void onSuccess(ImageSizingLogic.ImageDimensions imageDimensions) {
                    if (imageDimensions.areKnown()) {
                        CellAttachmentLoadingUtil.this.adjustImageViewDimensions(imageView, imageDimensions);
                        CellAttachmentLoadingUtil.this.imageLoadingLogic.loadAttachment(imageView, stateRequestAttachment, imageDimensions);
                        return;
                    }
                    Logger.b(RequestActivity.LOG_TAG, "Unable retrieve image size. Id: %s", Long.valueOf(stateRequestAttachment.getId()));
                }
            });
        }
    }
}

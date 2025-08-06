package zendesk.support.request;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.zendesk.sdk.R$id;
import com.zendesk.sdk.R$layout;
import com.zendesk.sdk.R$string;
import java.util.Collections;
import zendesk.support.suas.Dispatcher;

class AdapterAttachmentCarousel extends RecyclerView.Adapter<CarouselViewHolder> {
    private static final int FILE_ATTACHMENT = 1;
    private static final int IMAGE_ATTACHMENT = 2;
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public final ActionFactory f62972af;
    private final AttachmentHelper attachmentHelper;
    /* access modifiers changed from: private */
    public final Dispatcher dispatcher;
    private final Picasso picasso;
    private final CarouselViewHolder.OnRemoveListener removeListener = new CarouselViewHolder.OnRemoveListener() {
        public void onRemove(StateRequestAttachment stateRequestAttachment) {
            AdapterAttachmentCarousel.this.dispatcher.dispatch(AdapterAttachmentCarousel.this.f62972af.deselectAttachment(Collections.singletonList(StateRequestAttachment.convert(stateRequestAttachment))));
        }
    };

    public static abstract class CarouselViewHolder extends RecyclerView.ViewHolder {

        public interface OnRemoveListener {
            void onRemove(StateRequestAttachment stateRequestAttachment);
        }

        public CarouselViewHolder(View view) {
            super(view);
        }

        public abstract void bind(StateRequestAttachment stateRequestAttachment, OnRemoveListener onRemoveListener);
    }

    public static class FileAttachmentViewHolder extends CarouselViewHolder {
        private final ImageView appIcon = ((ImageView) this.itemView.findViewById(R$id.request_attachment_carousel_file_icon));
        private final TextView appName = ((TextView) this.itemView.findViewById(R$id.request_attachment_carousel_file_app_name));
        private final View container = this.itemView.findViewById(R$id.request_attachment_file_carousel_container);
        private final TextView name = ((TextView) this.itemView.findViewById(R$id.request_attachment_carousel_file_title));
        private final View remove = this.itemView.findViewById(R$id.request_attachment_carousel_remove);

        public FileAttachmentViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.zs_request_carousel_file, viewGroup, false));
        }

        public void bind(final StateRequestAttachment stateRequestAttachment, final CarouselViewHolder.OnRemoveListener onRemoveListener) {
            Context context = this.itemView.getContext();
            ResolveInfo appInfoForFile = UtilsAttachment.getAppInfoForFile(context, stateRequestAttachment.getName());
            this.appIcon.setImageDrawable(UtilsAttachment.getAppIcon(context, appInfoForFile));
            this.appName.setText(UtilsAttachment.getAppName(context, appInfoForFile));
            this.name.setText(stateRequestAttachment.getName());
            this.remove.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    onRemoveListener.onRemove(stateRequestAttachment);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            this.remove.setContentDescription(context.getString(R$string.zs_request_attachment_carousel_remove_attachment_accessibility, new Object[]{stateRequestAttachment.getName()}));
            this.container.setContentDescription(context.getString(R$string.zs_request_attachment_carousel_attachment_accessibility, new Object[]{stateRequestAttachment.getName()}));
        }
    }

    public static class ImageAttachmentViewHolder extends CarouselViewHolder {
        private final View container = this.itemView.findViewById(R$id.request_attachment_image_carousel_container);
        private final ImageView imageView = ((ImageView) this.itemView.findViewById(R$id.request_attachment_carousel_image));
        private final Picasso picasso;
        private final View remove = this.itemView.findViewById(R$id.request_attachment_carousel_remove);

        public ImageAttachmentViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, Picasso picasso2) {
            super(layoutInflater.inflate(R$layout.zs_request_carousel_image, viewGroup, false));
            this.picasso = picasso2;
        }

        public void bind(final StateRequestAttachment stateRequestAttachment, final CarouselViewHolder.OnRemoveListener onRemoveListener) {
            this.picasso.j(stateRequestAttachment.getParsedLocalUri()).e().a().g(this.imageView);
            this.remove.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    onRemoveListener.onRemove(stateRequestAttachment);
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            Context context = this.itemView.getContext();
            this.remove.setContentDescription(context.getString(R$string.zs_request_attachment_carousel_remove_attachment_accessibility, new Object[]{stateRequestAttachment.getName()}));
            this.container.setContentDescription(context.getString(R$string.zs_request_attachment_carousel_attachment_accessibility, new Object[]{stateRequestAttachment.getName()}));
        }
    }

    public AdapterAttachmentCarousel(AttachmentHelper attachmentHelper2, Picasso picasso2, ActionFactory actionFactory, Dispatcher dispatcher2) {
        this.attachmentHelper = attachmentHelper2;
        this.picasso = picasso2;
        this.f62972af = actionFactory;
        this.dispatcher = dispatcher2;
        setHasStableIds(true);
    }

    public int getItemCount() {
        return this.attachmentHelper.getSelectedAttachments().size();
    }

    public long getItemId(int i11) {
        return (long) this.attachmentHelper.getSelectedAttachments().get(i11).getLocalUri().hashCode();
    }

    public int getItemViewType(int i11) {
        return UtilsAttachment.isImageAttachment(this.attachmentHelper.getSelectedAttachments().get(i11)) ? 2 : 1;
    }

    public void onBindViewHolder(CarouselViewHolder carouselViewHolder, int i11) {
        carouselViewHolder.bind(this.attachmentHelper.getSelectedAttachments().get(i11), this.removeListener);
    }

    public CarouselViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == 1) {
            return new FileAttachmentViewHolder(from, viewGroup);
        }
        if (i11 != 2) {
            return null;
        }
        return new ImageAttachmentViewHolder(from, viewGroup, this.picasso);
    }
}

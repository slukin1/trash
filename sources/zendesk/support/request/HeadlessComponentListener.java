package zendesk.support.request;

import zendesk.support.suas.Store;

class HeadlessComponentListener {
    private final AttachmentDownloaderComponent attachment;
    private final ComponentPersistence persistence;
    private boolean registered = false;
    private final ComponentUpdateActionHandlers updateActionHandlersComponent;

    public HeadlessComponentListener(ComponentPersistence componentPersistence, AttachmentDownloaderComponent attachmentDownloaderComponent, ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        this.persistence = componentPersistence;
        this.attachment = attachmentDownloaderComponent;
        this.updateActionHandlersComponent = componentUpdateActionHandlers;
    }

    public void startListening(Store store) {
        if (!this.registered) {
            store.addListener(this.persistence.getSelector(), this.persistence);
            store.addListener(StateConversation.class, this.attachment);
            store.addListener(StateConversation.class, this.updateActionHandlersComponent);
            this.registered = true;
        }
    }
}

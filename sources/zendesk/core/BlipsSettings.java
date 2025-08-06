package zendesk.core;

class BlipsSettings {
    private BlipsPermissions permissions;

    public BlipsSettings(BlipsPermissions blipsPermissions) {
        this.permissions = blipsPermissions;
    }

    public BlipsPermissions getBlipsPermissions() {
        return this.permissions;
    }
}

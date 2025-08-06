package com.amazonaws.services.s3.model;

import java.util.Map;

public class StaticEncryptionMaterialsProvider implements EncryptionMaterialsAccessor {
    private final EncryptionMaterials materials;

    public StaticEncryptionMaterialsProvider(EncryptionMaterials encryptionMaterials) {
        this.materials = encryptionMaterials;
    }

    public EncryptionMaterials getEncryptionMaterials() {
        return this.materials;
    }

    public void refresh() {
    }

    public EncryptionMaterials getEncryptionMaterials(Map<String, String> map) {
        EncryptionMaterials encryptionMaterials;
        Map<String, String> materialsDescription = this.materials.getMaterialsDescription();
        if (map != null && map.equals(materialsDescription)) {
            return this.materials;
        }
        EncryptionMaterialsAccessor accessor = this.materials.getAccessor();
        if (accessor != null && (encryptionMaterials = accessor.getEncryptionMaterials(map)) != null) {
            return encryptionMaterials;
        }
        boolean z11 = false;
        boolean z12 = map == null || map.size() == 0;
        if (materialsDescription == null || materialsDescription.size() == 0) {
            z11 = true;
        }
        if (!z12 || !z11) {
            return null;
        }
        return this.materials;
    }
}

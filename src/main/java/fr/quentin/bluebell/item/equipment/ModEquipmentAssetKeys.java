package fr.quentin.bluebell.item.equipment;

import fr.quentin.bluebell.Bluebell;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public interface ModEquipmentAssetKeys {
    RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    RegistryKey<EquipmentAsset> EMERALD = register("emerald");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(REGISTRY_KEY, Identifier.of(Bluebell.MOD_ID, name));
    }
}
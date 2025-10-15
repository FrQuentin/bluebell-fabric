package fr.quentin.bluebell.item.equipment;

import com.google.common.collect.Maps;
import fr.quentin.bluebell.tag.ModItemTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial EMERALD = new ArmorMaterial(
            35, createDefenseMap(3, 6, 8, 3, 11), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, ModItemTags.REPAIRS_EMERALD_ARMOR, ModEquipmentAssetKeys.EMERALD
    );

    private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
        return Maps.newEnumMap(
                Map.of(
                        EquipmentType.BOOTS,
                        bootsDefense,
                        EquipmentType.LEGGINGS,
                        leggingsDefense,
                        EquipmentType.CHESTPLATE,
                        chestplateDefense,
                        EquipmentType.HELMET,
                        helmetDefense,
                        EquipmentType.BODY,
                        bodyDefense
                )
        );
    }
}
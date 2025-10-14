package fr.quentin.bluebell;

import fr.quentin.bluebell.item.ModItemGroups;
import fr.quentin.bluebell.item.ModItems;
import fr.quentin.bluebell.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bluebell implements ModInitializer {
	public static final String MOD_ID = "bluebell";
	public static final String MOD_NAME = "Bluebell";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModItemGroups.register();

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
        HammerUsageEvent.registerCleanupEvent();
	}
}
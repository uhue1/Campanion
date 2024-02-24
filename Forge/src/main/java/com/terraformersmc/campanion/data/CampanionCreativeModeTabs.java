package com.terraformersmc.campanion.data;

import com.terraformersmc.campanion.Campanion;
import com.terraformersmc.campanion.block.CampanionBlocks;
import com.terraformersmc.campanion.item.CampanionItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CampanionCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
		DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Campanion.MOD_ID);

	public static final RegistryObject<CreativeModeTab> CAMPANION_TAB = CREATIVE_MODE_TABS.register("campanion_tab",
		() -> CreativeModeTab.builder().icon(() -> new ItemStack(CampanionItems.CAMPING_PACK))
			.title(Component.translatable("Campanion"))
			.displayItems((itemDisplayParameters, output) -> {
				output.accept(CampanionBlocks.ROPE_BRIDGE_POST);
				output.accept(CampanionBlocks.ROPE_BRIDGE_PLANKS);
				output.accept(CampanionBlocks.ROPE_LADDER);
				output.accept(CampanionBlocks.LEATHER_TANNER);

				output.accept(CampanionItems.MRE);
				output.accept(CampanionItems.ROPE);
				output.accept(CampanionItems.LEATHER_POUCH);
				output.accept(CampanionItems.TANNED_LEATHER_POUCH);
				output.accept(CampanionItems.WOODEN_ROD);
				output.accept(CampanionItems.WOOL_TARP);
				output.accept(CampanionItems.TANNED_LEATHER);

				output.accept(CampanionItems.CRACKER);
				output.accept(CampanionItems.MARSHMALLOW);
				output.accept(CampanionItems.COOKED_MARSHMALLOW);
				output.accept(CampanionItems.BLACKENED_MARSHMALLOW);
				output.accept(CampanionItems.MARSHMALLOW_ON_A_STICK);
				output.accept(CampanionItems.COOKED_MARSHMALLOW_ON_A_STICK);
				output.accept(CampanionItems.BLACKENED_MARSHMALLOW_ON_A_STICK);
				output.accept(CampanionItems.SMORE);

				output.accept(CampanionItems.DAY_PACK);
				output.accept(CampanionItems.CAMPING_PACK);
				output.accept(CampanionItems.HIKING_PACK);

				output.accept(CampanionItems.WOODEN_SPEAR);
				output.accept(CampanionItems.STONE_SPEAR);
				output.accept(CampanionItems.IRON_SPEAR);
				output.accept(CampanionItems.GOLDEN_SPEAR);
				output.accept(CampanionItems.DIAMOND_SPEAR);
				output.accept(CampanionItems.NETHERITE_SPEAR);

				output.accept(CampanionItems.SKIPPING_STONE);
				output.accept(CampanionItems.FLARE);
				output.accept(CampanionItems.GRAPPLING_HOOK);
				output.accept(CampanionItems.SLEEPING_BAG);
				output.accept(CampanionItems.TENT_BAG);
				output.accept(CampanionItems.SMALL_UNBUILT_TENT);
				output.accept(CampanionItems.LARGE_UNBUILT_TENT);

				output.accept(CampanionBlocks.WHITE_LAWN_CHAIR);
				output.accept(CampanionBlocks.ORANGE_LAWN_CHAIR);
				output.accept(CampanionBlocks.MAGENTA_LAWN_CHAIR);
				output.accept(CampanionBlocks.LIGHT_BLUE_LAWN_CHAIR);
				output.accept(CampanionBlocks.YELLOW_LAWN_CHAIR);
				output.accept(CampanionBlocks.LIME_LAWN_CHAIR);
				output.accept(CampanionBlocks.PINK_LAWN_CHAIR);
				output.accept(CampanionBlocks.GRAY_LAWN_CHAIR);
				output.accept(CampanionBlocks.LIGHT_GRAY_LAWN_CHAIR);
				output.accept(CampanionBlocks.CYAN_LAWN_CHAIR);
				output.accept(CampanionBlocks.PURPLE_LAWN_CHAIR);
				output.accept(CampanionBlocks.BLUE_LAWN_CHAIR);
				output.accept(CampanionBlocks.BROWN_LAWN_CHAIR);
				output.accept(CampanionBlocks.GREEN_LAWN_CHAIR);
				output.accept(CampanionBlocks.RED_LAWN_CHAIR);
				output.accept(CampanionBlocks.BLACK_LAWN_CHAIR);
			})
			.build());

	public static void registerModeTab(IEventBus eventBus) {
		CREATIVE_MODE_TABS.register(eventBus);
	}
}

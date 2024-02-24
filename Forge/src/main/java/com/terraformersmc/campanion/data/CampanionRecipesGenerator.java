package com.terraformersmc.campanion.data;

import com.terraformersmc.campanion.block.CampanionBlocks;
import com.terraformersmc.campanion.item.CampanionItems;
import com.terraformersmc.campanion.recipe.CampanionRecipeSerializers;
import com.terraformersmc.campanion.tag.CampanionItemTags;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CampanionRecipesGenerator extends RecipeProvider {
	public CampanionRecipesGenerator(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, CampanionItems.MARSHMALLOW, 2).define('S', Items.SUGAR).pattern("SS").pattern("SS").unlockedBy("has_sugar", conditionsFrom(Items.SUGAR)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CampanionItems.MARSHMALLOW_ON_A_STICK).requires(CampanionItems.MARSHMALLOW).requires(Items.STICK).unlockedBy("has_marshmallow", conditionsFrom(CampanionItems.MARSHMALLOW)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CampanionItems.MRE).requires(CampanionItemTags.PROTEINS).requires(CampanionItemTags.FRUITS).requires(CampanionItemTags.GRAINS).requires(CampanionItemTags.VEGETABLES).unlockedBy("has_mre_components", conditionsFrom(CampanionItemTags.MRE_COMPONENTS)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, CampanionItems.CRACKER, 4).define('W', Items.WHEAT).pattern("WW").unlockedBy("has_wheat", conditionsFrom(Items.WHEAT)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CampanionItems.SMORE).requires(CampanionItems.CRACKER).requires(CampanionItemTags.MELTED_MARSHMALLOWS).requires(Items.COCOA_BEANS).requires(CampanionItems.CRACKER).unlockedBy("has_marshmallow", conditionsFrom(CampanionItemTags.MARSHMALLOWS)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CampanionItems.ROPE).define('S', Items.STRING).pattern("SSS").unlockedBy("has_string", conditionsFrom(Items.STRING)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.ROPE_BRIDGE_POST, 2).define('L', net.minecraft.tags.ItemTags.LOGS).pattern("L L").pattern("L L").unlockedBy("has_rope", conditionsFrom(CampanionItems.ROPE)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.ROPE_LADDER, 16).define('R', CampanionItems.ROPE).define('S', Items.STICK).pattern("RSR").pattern("RSR").pattern("RSR").unlockedBy("has_string", conditionsFrom(Items.STRING)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CampanionItems.SKIPPING_STONE, 8).requires(Blocks.COBBLESTONE).unlockedBy("has_cobblestone", conditionsFrom(Blocks.COBBLESTONE)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.SLEEPING_BAG).define('T', CampanionItems.WOOL_TARP).pattern("TT").unlockedBy("has_wool", conditionsFrom(net.minecraft.tags.ItemTags.WOOL)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CampanionItems.WOODEN_ROD).define('S', Items.STICK).pattern("S").pattern("S").pattern("S").unlockedBy("has_stick", conditionsFrom(Items.STICK)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionItems.SMALL_UNBUILT_TENT).define('T', CampanionItems.WOOL_TARP).define('S', CampanionItems.WOODEN_ROD).define('R', CampanionItems.ROPE).pattern(" T ").pattern("TST").pattern("R R").unlockedBy("has_wool", conditionsFrom(net.minecraft.tags.ItemTags.WOOL)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionItems.LARGE_UNBUILT_TENT).define('T', CampanionItems.WOOL_TARP).define('S', CampanionItems.WOODEN_ROD).define('R', CampanionItems.ROPE).pattern("TTT").pattern("TST").pattern("RSR").unlockedBy("has_wool", conditionsFrom(net.minecraft.tags.ItemTags.WOOL)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.TENT_BAG).define('T', CampanionItems.TANNED_LEATHER).define('I', Items.IRON_INGOT).define('R', CampanionItems.ROPE).pattern("IRI").pattern("TTT").unlockedBy("has_rope", conditionsFrom(CampanionItems.ROPE)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CampanionItems.LEATHER_POUCH).define('L', Items.LEATHER).define('S', Items.STRING).pattern("L L").pattern("SLS").unlockedBy("has_leather", conditionsFrom(Items.LEATHER)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CampanionItems.TANNED_LEATHER_POUCH).define('T', CampanionItems.TANNED_LEATHER).define('S', Items.STRING).pattern("T T").pattern("T T").pattern("STS").unlockedBy("has_tanned_leather", conditionsFrom(CampanionItems.TANNED_LEATHER)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.LEATHER_TANNER).define('S', Items.STICK).pattern("S S").pattern("S S").pattern("S S").unlockedBy("has_stick", conditionsFrom(Items.STICK)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.DAY_PACK).define('I', Items.IRON_INGOT).define('R', CampanionItems.ROPE).define('P', CampanionItems.LEATHER_POUCH).pattern(" I ").pattern("RPR").unlockedBy("has_leather", conditionsFrom(Items.LEATHER)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.CAMPING_PACK).define('I', Items.IRON_INGOT).define('R', CampanionItems.ROPE).define('P', CampanionItems.LEATHER_POUCH).define('T', CampanionItems.TANNED_LEATHER_POUCH).pattern(" I ").pattern("RTR").pattern(" P ").unlockedBy("has_tanned_leather", conditionsFrom(CampanionItems.TANNED_LEATHER)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.HIKING_PACK).define('I', Items.IRON_INGOT).define('R', CampanionItems.ROPE).define('T', CampanionItems.TANNED_LEATHER_POUCH).pattern(" I ").pattern("RTR").pattern("ITI").unlockedBy("has_tanned_leather", conditionsFrom(CampanionItems.TANNED_LEATHER)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CampanionItems.GRAPPLING_HOOK).define('I', Items.IRON_INGOT).define('P', net.minecraft.tags.ItemTags.PLANKS).define('R', CampanionItems.ROPE).define('S', Items.STICK).pattern(" I ").pattern("PRI").pattern("SI ").unlockedBy("has_grappling_hook", conditionsFrom(CampanionItems.GRAPPLING_HOOK)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CampanionItems.WOODEN_SPEAR).define('#', CampanionItems.WOODEN_ROD).define('X', net.minecraft.tags.ItemTags.PLANKS).pattern("X").pattern("#").unlockedBy("has_stick", conditionsFrom(Items.STICK)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CampanionItems.STONE_SPEAR).define('#', CampanionItems.WOODEN_ROD).define('X', net.minecraft.tags.ItemTags.STONE_TOOL_MATERIALS).pattern("X").pattern("#").unlockedBy("has_stone", conditionsFrom(Blocks.COBBLESTONE)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CampanionItems.IRON_SPEAR).define('#', CampanionItems.WOODEN_ROD).define('X', Items.IRON_INGOT).pattern("X").pattern("#").unlockedBy("has_iron", conditionsFrom(Items.IRON_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CampanionItems.GOLDEN_SPEAR).define('#', CampanionItems.WOODEN_ROD).define('X', Items.GOLD_INGOT).pattern("X").pattern("#").unlockedBy("has_gold", conditionsFrom(Items.GOLD_INGOT)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CampanionItems.DIAMOND_SPEAR).define('#', CampanionItems.WOODEN_ROD).define('X', Items.DIAMOND).pattern("X").pattern("#").unlockedBy("has_diamond", conditionsFrom(Items.DIAMOND)).save(consumer);

		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.WHITE_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.WHITE_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_white_carpet", conditionsFrom(Blocks.WHITE_CARPET)).save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.ORANGE_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.ORANGE_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_orange_carpet", conditionsFrom(Blocks.ORANGE_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.ORANGE_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.ORANGE_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:orange_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.MAGENTA_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.MAGENTA_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_magenta_carpet", conditionsFrom(Blocks.MAGENTA_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.MAGENTA_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.MAGENTA_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:magenta_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.LIGHT_BLUE_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.LIGHT_BLUE_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_light_blue_carpet", conditionsFrom(Blocks.LIGHT_BLUE_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.LIGHT_BLUE_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.LIGHT_BLUE_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:light_blue_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.YELLOW_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.YELLOW_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_yellow_carpet", conditionsFrom(Blocks.YELLOW_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.YELLOW_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.YELLOW_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:yellow_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.LIME_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.LIME_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_lime_carpet", conditionsFrom(Blocks.LIME_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.LIME_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.LIME_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:lime_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.PINK_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.PINK_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_pink_carpet", conditionsFrom(Blocks.PINK_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.PINK_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.PINK_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:pink_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.GRAY_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.GRAY_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_gray_carpet", conditionsFrom(Blocks.GRAY_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.GRAY_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.GRAY_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:gray_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.LIGHT_GRAY_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.LIGHT_GRAY_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_light_gray_carpet", conditionsFrom(Blocks.LIGHT_GRAY_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.LIGHT_GRAY_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.LIGHT_GRAY_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:light_gray_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.CYAN_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.CYAN_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_cyan_carpet", conditionsFrom(Blocks.CYAN_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.CYAN_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.CYAN_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:cyan_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.PURPLE_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.PURPLE_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_purple_carpet", conditionsFrom(Blocks.PURPLE_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.PURPLE_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.PURPLE_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:purple_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.BLUE_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.BLUE_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_blue_carpet", conditionsFrom(Blocks.BLUE_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.BLUE_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.BLUE_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:blue_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.BROWN_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.BROWN_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_brown_carpet", conditionsFrom(Blocks.BROWN_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.BROWN_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.BROWN_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:brown_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.GREEN_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.GREEN_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_green_carpet", conditionsFrom(Blocks.GREEN_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.GREEN_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.GREEN_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:green_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.RED_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.RED_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_red_carpet", conditionsFrom(Blocks.RED_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.RED_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.RED_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:red_lawn_chair_from_existing_chair");
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CampanionBlocks.BLACK_LAWN_CHAIR).define('P', net.minecraft.tags.ItemTags.PLANKS).define('C', Blocks.BLACK_CARPET).define('S', Items.STICK).pattern("P  ").pattern("PCP").pattern("S S").group("lawn_chair").unlockedBy("has_black_carpet", conditionsFrom(Blocks.BLACK_CARPET)).save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CampanionBlocks.BLACK_LAWN_CHAIR).requires(CampanionItemTags.LAWN_CHAIRS).requires(Items.BLACK_DYE).group("dyed_lawn_chair").unlockedBy("has_lawn_chair", conditionsFrom(CampanionItemTags.LAWN_CHAIRS)).save(consumer, "campanion:black_lawn_chair_from_existing_chair");

		//not working properly
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(CampanionItems.DIAMOND_SPEAR), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, CampanionItems.NETHERITE_SPEAR).unlocks("has_netherite_ingot", conditionsFrom(Items.NETHERITE_INGOT)).save(consumer, "campanion:netherite_spear");

		SpecialRecipeBuilder.special(CampanionRecipeSerializers.TENT_BUILDING_RECIPE).save(consumer, "campanion:tent_building");
		SpecialRecipeBuilder.special(CampanionRecipeSerializers.TARP_RECIPE).save(consumer, "campanion:wool_tarp");
	}

	public static InventoryChangeTrigger.TriggerInstance conditionsFrom(ItemLike itemLike) {
		return inventoryTrigger(ItemPredicate.Builder.item().of(new ItemLike[]{itemLike}).build());
	}

	public static InventoryChangeTrigger.TriggerInstance conditionsFrom(TagKey<Item> tagKey) {
		return inventoryTrigger(ItemPredicate.Builder.item().of(tagKey).build());
	}

	public static InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate @NotNull ... itemPredicates) {
		return new InventoryChangeTrigger.TriggerInstance(ContextAwarePredicate.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, itemPredicates);
	}

}

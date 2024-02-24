package com.terraformersmc.campanion.data;

import com.terraformersmc.campanion.Campanion;
import com.terraformersmc.campanion.block.CampanionBlocks;
import com.terraformersmc.campanion.tag.CampanionBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class CampanionBlockTagsGenerator extends BlockTagsProvider {
	public CampanionBlockTagsGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, Campanion.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider provider) {
		this.tag(CampanionBlockTags.LAWN_CHAIRS).add(CampanionBlocks.LAWN_CHAIRS.toArray(Block[]::new));
		this.tag(CampanionBlockTags.TENT_SIDES).add(CampanionBlocks.TENT_SIDES.toArray(Block[]::new));
		this.tag(CampanionBlockTags.TENT_TOPS).add(CampanionBlocks.TENT_TOPS.toArray(Block[]::new));
		this.tag(CampanionBlockTags.TOPPED_TENT_POLES).add(CampanionBlocks.TOPPED_TENT_POLES.toArray(Block[]::new));
		this.tag(CampanionBlockTags.FLAT_TENT_TOPS).add(CampanionBlocks.FLAT_TENT_TOPS.toArray(Block[]::new));

		this.tag(CampanionBlockTags.TENT_POLES).add(CampanionBlocks.TENT_POLE).addTag(CampanionBlockTags.TOPPED_TENT_POLES);
	}
}

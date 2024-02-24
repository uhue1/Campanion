package com.terraformersmc.campanion.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class ForgeDataGenerators {
	public static void gatherDataGens(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		CampanionBlockTagsGenerator blockTagsGenerator = new CampanionBlockTagsGenerator(packOutput, lookupProvider, existingFileHelper);
		generator.addProvider(event.includeServer(), blockTagsGenerator);
		generator.addProvider(event.includeServer(), new CampanionItemTagsGenerator(packOutput, lookupProvider, blockTagsGenerator.contentsGetter(), existingFileHelper));
		generator.addProvider(event.includeServer(), CampanionLootTablesGenerator.create(packOutput));
		generator.addProvider(event.includeServer(), new CampanionRecipesGenerator(packOutput));
	}
}

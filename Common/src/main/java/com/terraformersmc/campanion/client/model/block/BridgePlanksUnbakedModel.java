package com.terraformersmc.campanion.client.model.block;

import com.terraformersmc.campanion.platform.services.ClientServices;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class BridgePlanksUnbakedModel implements UnbakedModel {
	@Override
	public @NotNull Collection<ResourceLocation> getDependencies() {
		return Collections.emptyList();
	}

	@Override
	public void resolveParents(@NotNull Function<ResourceLocation, UnbakedModel> unbakedModelGetter) {
		List<Material> list = new ArrayList<>();
		Collections.addAll(list, BridgePlanksBakedModel.PLANKS);
		list.add(BridgePlanksBakedModel.ROPE);
		list.add(BridgePlanksBakedModel.STOPPER);
	}

	@Override
	public BakedModel bake(@NotNull ModelBaker modelBaker, @NotNull Function<Material, TextureAtlasSprite> function, @NotNull ModelState modelState, @NotNull ResourceLocation resourceLocation) {
		return ClientServices.CLIENT_PLATFORM.createPlanksModel();
	}
}

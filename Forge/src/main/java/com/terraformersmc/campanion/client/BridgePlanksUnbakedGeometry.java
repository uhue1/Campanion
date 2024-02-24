package com.terraformersmc.campanion.client;

import com.terraformersmc.campanion.client.model.block.BridgePlanksUnbakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;

import java.util.function.Function;

public class BridgePlanksUnbakedGeometry extends BridgePlanksUnbakedModel implements IUnbakedGeometry<BridgePlanksUnbakedGeometry> {
	
	@Override
	public BakedModel bake(IGeometryBakingContext context, ModelBaker bakery, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState, ItemOverrides overrides, ResourceLocation modelLocation) {
		return this.bake(bakery, spriteGetter, modelState, modelLocation);
	}

	@Override
	public void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, IGeometryBakingContext context) {
		IUnbakedGeometry.super.resolveParents(modelGetter, context);
	}

	/*
	@Override
	public Collection<Material> getMaterials(IGeometryBakingContext context, Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
		return this.getMaterials(modelGetter, missingTextureErrors);
	}
	*/
}

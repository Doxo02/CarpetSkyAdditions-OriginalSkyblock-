package com.jsorrell.carpetskyadditions.gen.feature;

import com.jsorrell.carpetskyadditions.config.SkyAdditionsConfig;
import com.mojang.serialization.Codec;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class SandIslandFeature extends Feature<SandIslandFeatureConfiguration> {
    public SandIslandFeature(Codec<SandIslandFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SandIslandFeatureConfiguration> context) {
        SkyAdditionsConfig modConfig =
            AutoConfig.getConfigHolder(SkyAdditionsConfig.class).get();

        SandIslandFeatureConfiguration config = context.config();
        // Always absolute with Y
        BlockPos origin = config.spawnRelative() ? context.origin().atY(0) : BlockPos.ZERO;

        if(modConfig.originalIsland) {
            return SkyAdditionsFeatures.LOCATABLE_STRUCTURE.place(
                config.platformConfig(), context.level(), context.chunkGenerator(), context.random(), origin);
        } else {
            return true;
        }
    }
}

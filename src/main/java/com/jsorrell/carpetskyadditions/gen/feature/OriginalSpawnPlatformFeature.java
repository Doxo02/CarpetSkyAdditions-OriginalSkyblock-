package com.jsorrell.carpetskyadditions.gen.feature;

import com.jsorrell.carpetskyadditions.config.SkyAdditionsConfig;
import com.mojang.serialization.Codec;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class OriginalSpawnPlatformFeature extends Feature<OriginalSpawnPlatformFeatureConfiguration> {
    public OriginalSpawnPlatformFeature(Codec<OriginalSpawnPlatformFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OriginalSpawnPlatformFeatureConfiguration> context) {
        SkyAdditionsConfig modConfig =
            AutoConfig.getConfigHolder(SkyAdditionsConfig.class).get();

        OriginalSpawnPlatformFeatureConfiguration config = context.config();
        // Always absolute with Y
        BlockPos origin = config.spawnRelative() ? context.origin().atY(0) : BlockPos.ZERO;

        if(modConfig.originalIsland) {
            return SkyAdditionsFeatures.LOCATABLE_STRUCTURE.place(
                config.platformConfig(), context.level(), context.chunkGenerator(), context.random(), origin);
        } else {
            return false;
        }
    }
}

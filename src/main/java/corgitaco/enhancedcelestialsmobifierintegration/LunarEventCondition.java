package corgitaco.enhancedcelestialsmobifierintegration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.enhancedcelestials.EnhancedCelestialsWorldData;
import corgitaco.enhancedcelestials.LunarContext;
import corgitaco.mobifier.common.condition.Condition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

import java.util.*;
import java.util.stream.Collectors;

public class LunarEventCondition implements Condition {

    public static final Codec<LunarEventCondition> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            Codec.STRING.listOf().fieldOf("lunar_event_is").forGetter(lunarEventCondition -> lunarEventCondition.lunarEventID)
        ).apply(builder, LunarEventCondition::new));

    private final List<String> lunarEventID;

    public LunarEventCondition(List<String> lunarEventID) {
        this.lunarEventID = lunarEventID.stream().map(String::toLowerCase).collect(Collectors.toList());
    }


    @Override
    public boolean passes(World world, LivingEntity livingEntity, boolean b, int i) {
        LunarContext lunarContext = ((EnhancedCelestialsWorldData) world).getLunarContext();
        if (lunarContext == null) {
            return false;
        }
        return this.lunarEventID.contains(lunarContext.getCurrentEvent().getKey().toLowerCase());
    }

    @Override
    public Codec<? extends Condition> codec() {
        return CODEC;
    }
}

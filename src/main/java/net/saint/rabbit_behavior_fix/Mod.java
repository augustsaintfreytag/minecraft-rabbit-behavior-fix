package net.saint.rabbit_behavior_fix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.saint.rabbit_behavior_fix.config.RabbitBehaviorFixConfig;

public class Mod implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("rabbit_behavior_fix");

	public static RabbitBehaviorFixConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(RabbitBehaviorFixConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(RabbitBehaviorFixConfig.class).getConfig();
	}

}

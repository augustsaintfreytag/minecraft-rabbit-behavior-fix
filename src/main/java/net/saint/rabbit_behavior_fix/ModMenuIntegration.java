package net.saint.rabbit_behavior_fix;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.saint.rabbit_behavior_fix.config.RabbitBehaviorFixConfig;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

	// @Override
	// public ConfigScreenFactory<?> getModConfigScreenFactory() {
	// 	return parent -> AutoConfig.getConfigScreen(WildCatSpawnsConfig.class, parent).get();
	// }

}

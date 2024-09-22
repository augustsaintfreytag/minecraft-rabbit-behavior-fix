package net.saint.rabbit_behavior_fix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.passive.RabbitEntity;
import net.saint.rabbit_behavior_fix.mixinlogic.RabbitEntityMixinLogic;

@Mixin(RabbitEntity.class)
public abstract class RabbitEntityMixin implements RabbitEntityMixinLogic {

	private int ticksSinceLastJump = 0;
	private int ticksSinceLastLand = 0;
	private int ticksStuckInJumpLoop = 0;

	public int getTicksSinceLastJump() {
		return ticksSinceLastJump;
	}

	public void setTicksSinceLastJump(int value) {
		ticksSinceLastJump = value;
	}

	public int getTicksSinceLastLand() {
		return ticksSinceLastLand;
	}

	public void setTicksSinceLastLand(int value) {
		ticksSinceLastLand = value;
	}

	public int getTicksStuckInJumpLoop() {
		return ticksStuckInJumpLoop;
	}

	public void setTicksStuckInJumpLoop(int value) {
		ticksStuckInJumpLoop = value;
	}

	// Injection

	@Inject(method = "mobTick", at = @At("TAIL"))
	public void injectedMobTick(CallbackInfo info) {
		var rabbit = (RabbitEntity) (Object) this;
		onMobTick(rabbit);
	}

}

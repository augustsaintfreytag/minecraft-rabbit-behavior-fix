package net.saint.rabbit_behavior_fix.mixinlogic;

import org.joml.Math;

import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.util.math.Vec3d;

public interface RabbitEntityMixinLogic {

	public int getTicksSinceLastJump();

	public void setTicksSinceLastJump(int value);

	public int getTicksSinceLastLand();

	public void setTicksSinceLastLand(int value);

	public int getTicksStuckInJumpLoop();

	public void setTicksStuckInJumpLoop(int value);

	public default void onMobTick(RabbitEntity rabbit) {
		var world = rabbit.getWorld();

		if (world.isClient) {
			return;
		}

		if (!rabbit.isOnGround()) {
			setTicksSinceLastJump(getTicksSinceLastJump() + 1);
		} else if (getTicksSinceLastJump() > 0) {
			setTicksSinceLastJump(0);
			setTicksSinceLastLand(0);
		} else {
			setTicksSinceLastLand(getTicksSinceLastLand() + 1);
		}

		if (getTicksSinceLastLand() < 2) {
			setTicksStuckInJumpLoop(getTicksStuckInJumpLoop() + 1);
		} else {
			setTicksStuckInJumpLoop(0);
		}

		float rabbitYaw = rabbit.getBodyYaw();
		float radians = (float) Math.toRadians(rabbitYaw);
		Vec3d direction = new Vec3d(-Math.sin(radians), 0, Math.cos(radians));

		// Stuck Check

		if (getTicksStuckInJumpLoop() > 5) {
			setTicksStuckInJumpLoop(-25);
			forceJump(rabbit, direction);
		}
	}

	public default void forceJump(RabbitEntity rabbit, Vec3d direction) {
		rabbit.setJumping(false);

		var rabbitPos = rabbit.getPos();
		rabbit.setPos(rabbitPos.x + direction.x * 0.05D, rabbitPos.y + 0.42D, rabbitPos.z + direction.z * 0.05D);
		rabbit.setVelocity(rabbit.getVelocity().x + direction.x * 0.15D, 0.22D,
				rabbit.getVelocity().z + direction.z * 0.15D);
	}

}

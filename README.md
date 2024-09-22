# Rabbit Behavior Fix

A mod that fixes rabbits getting constantly stuck on terrain, trapped in an eternal jumping loop until they get either shooed away or slaughtered for their incompetence. This issue exists in the popular 1.20.1 version of Minecraft and — to my knowledge — has not yet been addressed and patched by Mojang even in newer releases.

Rabbits spawn, start hopping around, and once they encounter any one-block high obstacle, begin a jump but can never actually clear the obstacle. They get reliably trapped in a loop and try to jump over and over again. Their hopping also makes a sound which can easily become a major annoyance in areas with a lot of spawns.

This mod is built using Fabric for version 1.20.1 of Minecraft.

## 🪐 Features

- Detects jump loops for rabbits and gives them a nudge to complete their jump
- Rabbits will be able to properly navigate terrain in their "regular wander" mode
- Other behavior modes (e.g. fleeing) are not affected at all
- Registers a mixin for `RabbitEntity` and tracks behavior via `mobTick`

## ⚖️ License

This mod was developed by Saint for use by the Minecraft community, published and distributed under the MIT license with basic attribution. This mod may be shared and included in mod packs with attribution.
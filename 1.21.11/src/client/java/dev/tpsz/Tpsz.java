package dev.tpsz;

import net.fabricmc.api.ClientModInitializer;

public class Tpsz implements ClientModInitializer {
	public void onInitializeClient() {
		Cfg.ld();
	}
}

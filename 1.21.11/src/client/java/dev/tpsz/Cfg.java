package dev.tpsz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Files;
import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;

public class Cfg {
	public boolean on = true;
	public int sz = 60;

	static final Gson G = new GsonBuilder().setPrettyPrinting().create();
	static final Path P = FabricLoader.getInstance().getConfigDir().resolve("totempopsize.json");
	public static Cfg c = new Cfg();

	public static void ld() {
		try {
			if (Files.exists(P)) {
				Cfg n = G.fromJson(Files.readString(P), Cfg.class);
				if (n != null) c = n;
			}
		} catch (Exception e) {
			c = new Cfg();
		}
		c.sz = Math.max(0, Math.min(100, c.sz));
	}

	public static void sv() {
		c.sz = Math.max(0, Math.min(100, c.sz));
		try {
			Files.writeString(P, G.toJson(c));
		} catch (Exception e) {
		}
	}
}

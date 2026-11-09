package dev.tpsz;

import dev.wysl.Wl;
import dev.wysl.ui.Frm;
import net.minecraft.client.gui.screens.Screen;

public class Gui {
	public static Screen open(Screen p) {
		Cfg c = Cfg.c;
		Frm f = Frm.of("Totem Pop Size", Cfg::sv)
				.tab("Settings")
				.tgl("Mod on", () -> c.on, v -> c.on = v).tip("Turn this off to get the normal vanilla totem size back.")
				.sld("Size", () -> c.sz, v -> c.sz = v, 0, 100, "%").tip("Size of the totem that flies up on your screen when you pop. 100% is vanilla.")
				.note("Keeps big pack totems small.");
		return Wl.screen(p, f, "Totem Pop Size", null);
	}
}

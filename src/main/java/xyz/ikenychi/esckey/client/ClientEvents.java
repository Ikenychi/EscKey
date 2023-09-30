package xyz.ikenychi.esckey.client;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.ikenychi.esckey.EscKey;

public class ClientEvents {

	@Mod.EventBusSubscriber(modid = EscKey.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		
		// register the keybind at startup
		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent e){
			e.register(Keybind.NewEscape);
		}

	}

	@Mod.EventBusSubscriber(modid = EscKey.MODID, value = Dist.CLIENT)
	public static class ClientForgeEvents {

		// in-game for opening the escape screen
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key e){
			if (Keybind.NewEscape.consumeClick()){
				Minecraft.getInstance().setScreen(new PauseScreen(true));
			}
		}

		// screen key event for closing UIs
		@SubscribeEvent
		public static void onKeyInUI(ScreenEvent.KeyPressed.Post e) {
			if (e.getKeyCode() == Keybind.NewEscape.getKey().getValue()){
				e.getScreen().keyPressed(GLFW.GLFW_KEY_ESCAPE, e.getScanCode(), e.getModifiers());
				e.setCanceled(true);
			}
		}

	}

}

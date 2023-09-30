package xyz.ikenychi.esckey.client;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;


public class Keybind {

	public static final String KEY_CATEGORY_ESCKEY = "key.categories.esckey";
	public static final String KEY_ESCKEY = "key.esckey.esckey";

	public static final KeyMapping NewEscape = new KeyMapping(
		KEY_ESCKEY,
		KeyConflictContext.UNIVERSAL,
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_CAPS_LOCK,
		KEY_CATEGORY_ESCKEY
	);

}

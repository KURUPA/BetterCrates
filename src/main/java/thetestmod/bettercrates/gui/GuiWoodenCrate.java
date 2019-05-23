package thetestmod.bettercrates.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import thetestmod.bettercrates.BetterCrates;
import thetestmod.bettercrates.utils.BlocksRegistry;

public class GuiWoodenCrate extends GuiContainer {

	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(BetterCrates.MODID,
			"textures/gui/wooden_crate.png");

	private InventoryPlayer playerInv;

	public GuiWoodenCrate(Container container, InventoryPlayer playerInv) {

		super(container);
		this.playerInv = playerInv;
		xSize = 184;
		ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

		String name = I18n.format(BlocksRegistry.WOODEN_CRATE.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, ySize - 178, 0x404040);
		// fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8,
		// ySize - 94, 0x404040);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

}
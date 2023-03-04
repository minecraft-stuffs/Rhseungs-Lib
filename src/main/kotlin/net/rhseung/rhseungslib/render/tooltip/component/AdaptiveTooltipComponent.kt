package net.rhseung.rhseungslib.render.tooltip.component

import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.client.item.TooltipData
import net.minecraft.client.render.item.ItemRenderer
import net.minecraft.client.util.math.MatrixStack
import net.rhseung.rhseungslib.Mod.modID
import net.rhseung.rhseungslib.api.TextUtils.toText
import net.rhseung.rhseungslib.api.classes.Color
import net.rhseung.rhseungslib.api.collection.PixelSize
import net.rhseung.rhseungslib.api.math.Point3D
import net.rhseung.rhseungslib.render.tooltip.TooltipHandler.Companion.TAB
import net.rhseung.rhseungslib.render.tooltip.TooltipHandler.Companion.tooltip
import kotlin.math.floor
import kotlin.reflect.full.primaryConstructor

abstract class AdaptiveTooltipComponent(
	open val data: TooltipData,
	open val screen: Screen? = null,
) : TooltipComponent {
	
	open val tooltip = tooltip {}
	
	override fun getHeight(): Int {
		return tooltip.height(screen)
	}
	
	override fun getWidth(textRenderer: TextRenderer): Int {
		return tooltip.width(textRenderer, screen)
	}
	
	override fun drawItems(
		textRenderer: TextRenderer,
		x: Int,
		y: Int,
		matrices: MatrixStack,
		itemRenderer: ItemRenderer,
		z: Int,
	) {
		tooltip.draw(textRenderer, itemRenderer, matrices, Point3D(x, y, z), screen)
	}
	
	fun setScreen(screen: Screen): AdaptiveTooltipComponent {
		return this::class.primaryConstructor!!.call(data, screen)
	}
	
	enum class Icon(private val variants: Int = 1) {
		ATTACK_DAMAGE,
		ATTACK_SPEED,
		ATTACK_KNOCKBACK,
		DURABILITY,
		FIRE,
		HUNGER(2),
		SATURATION(4),
		PROTECTION,
		TOUGHNESS,
		KNOCKBACK_RESISTANCE,
		LUCK,
		MAX_HEALTH,
		SPEED,
		ENCHANTED,
		POSITIVE,
		NEGATIVE;
		
		val path = modID("textures/gui/icon/${name.lowercase()}")
		val width = Icon.ICON_SIZE.width * variants
		val height = Icon.ICON_SIZE.height
		
		fun index(ratio: Double) = if (ratio == 1.0) variants - 1 else floor(ratio * variants).toInt()
		fun u(ratio: Double): Int = index(ratio) * ICON_SIZE.width
		fun v(ratio: Double): Int = 0
		
		companion object {
			val ICON_SIZE = PixelSize(9, 9)
		}
	}
}
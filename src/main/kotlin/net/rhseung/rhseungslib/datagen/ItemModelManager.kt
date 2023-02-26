package net.rhseung.rhseungslib.datagen

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.rhseung.rhseungslib.Mod.minecraftID
import net.rhseung.rhseungslib.registration.RegistryHelper
import java.util.function.BiConsumer
import java.util.function.Supplier

class ItemModelManager (
	val modId: String,
	val modelGenerator: ItemModelGenerator
) {
	object Parents {
		val CUBE = minecraftID("block/cube")
		val CUBE_DIRECTIONAL = minecraftID("block/cube_directional")
		val CUBE_ALL = minecraftID("block/cube_all")
		val CUBE_MIRRORED_ALL = minecraftID("block/cube_mirrored_all")
		val CUBE_NORTH_WEST_MIRRORED_ALL = minecraftID("block/cube_north_west_mirrored_all")
		val CUBE_COLUMN_UV_LOCKED_X = minecraftID("block/cube_column_uv_locked_x")
		val CUBE_COLUMN_UV_LOCKED_Y = minecraftID("block/cube_column_uv_locked_y")
		val CUBE_COLUMN_UV_LOCKED_Z = minecraftID("block/cube_column_uv_locked_z")
		val CUBE_COLUMN = minecraftID("block/cube_column")
		val CUBE_COLUMN_HORIZONTAL = minecraftID("block/cube_column_horizontal")
		val CUBE_COLUMN_MIRRORED = minecraftID("block/cube_column_mirrored")
		val CUBE_TOP = minecraftID("block/cube_top")
		val CUBE_BOTTOM_TOP = minecraftID("block/cube_bottom_top")
		val ORIENTABLE = minecraftID("block/orientable")
		val ORIENTABLE_WITH_BOTTOM = minecraftID("block/orientable_with_bottom")
		val ORIENTABLE_VERTICAL = minecraftID("block/orientable_vertical")
		val BUTTON = minecraftID("block/button")
		val BUTTON_PRESSED = minecraftID("block/button_pressed")
		val BUTTON_INVENTORY = minecraftID("block/button_inventory")
		val DOOR_BOTTOM_LEFT = minecraftID("block/door_bottom_left")
		val DOOR_BOTTOM_LEFT_OPEN = minecraftID("block/door_bottom_left_open")
		val DOOR_BOTTOM_RIGHT = minecraftID("block/door_bottom_right")
		val DOOR_BOTTOM_RIGHT_OPEN = minecraftID("block/door_bottom_right_open")
		val DOOR_TOP_LEFT = minecraftID("block/door_top_left")
		val DOOR_TOP_LEFT_OPEN = minecraftID("block/door_top_left_open")
		val DOOR_TOP_RIGHT = minecraftID("block/door_top_right")
		val DOOR_TOP_RIGHT_OPEN = minecraftID("block/door_top_right_open")
		val CUSTOM_FENCE_POST = minecraftID("block/custom_fence_post")
		val CUSTOM_FENCE_SIDE_NORTH = minecraftID("block/custom_fence_side_north")
		val CUSTOM_FENCE_SIDE_EAST = minecraftID("block/custom_fence_side_east")
		val CUSTOM_FENCE_SIDE_SOUTH = minecraftID("block/custom_fence_side_south")
		val CUSTOM_FENCE_SIDE_WEST = minecraftID("block/custom_fence_side_west")
		val CUSTOM_FENCE_INVENTORY = minecraftID("block/custom_fence_inventory")
		val FENCE_POST = minecraftID("block/fence_post")
		val FENCE_SIDE = minecraftID("block/fence_side")
		val FENCE_INVENTORY = minecraftID("block/fence_inventory")
		val TEMPLATE_WALL_POST = minecraftID("block/template_wall_post")
		val TEMPLATE_WALL_SIDE = minecraftID("block/template_wall_side")
		val TEMPLATE_WALL_SIDE_TALL = minecraftID("block/template_wall_side_tall")
		val WALL_INVENTORY = minecraftID("block/wall_inventory")
		val TEMPLATE_CUSTOM_FENCE_GATE = minecraftID("block/template_custom_fence_gate")
		val TEMPLATE_CUSTOM_FENCE_GATE_OPEN = minecraftID("block/template_custom_fence_gate_open")
		val TEMPLATE_CUSTOM_FENCE_GATE_WALL = minecraftID("block/template_custom_fence_gate_wall")
		val TEMPLATE_CUSTOM_FENCE_GATE_WALL_OPEN = minecraftID("block/template_custom_fence_gate_wall_open")
		val TEMPLATE_FENCE_GATE = minecraftID("block/template_fence_gate")
		val TEMPLATE_FENCE_GATE_OPEN = minecraftID("block/template_fence_gate_open")
		val TEMPLATE_FENCE_GATE_WALL = minecraftID("block/template_fence_gate_wall")
		val TEMPLATE_FENCE_GATE_WALL_OPEN = minecraftID("block/template_fence_gate_wall_open")
		val PRESSURE_PLATE_UP = minecraftID("block/pressure_plate_up")
		val PRESSURE_PLATE_DOWN = minecraftID("block/pressure_plate_down")
		val SLAB = minecraftID("block/slab")
		val SLAB_TOP = minecraftID("block/slab_top")
		val LEAVES = minecraftID("block/leaves")
		val STAIRS = minecraftID("block/stairs")
		val INNER_STAIRS = minecraftID("block/inner_stairs")
		val OUTER_STAIRS = minecraftID("block/outer_stairs")
		val TEMPLATE_TRAPDOOR_TOP = minecraftID("block/template_trapdoor_top")
		val TEMPLATE_TRAPDOOR_BOTTOM = minecraftID("block/template_trapdoor_bottom")
		val TEMPLATE_TRAPDOOR_OPEN = minecraftID("block/template_trapdoor_open")
		val TEMPLATE_ORIENTABLE_TRAPDOOR_TOP = minecraftID("block/template_orientable_trapdoor_top")
		val TEMPLATE_ORIENTABLE_TRAPDOOR_BOTTOM = minecraftID("block/template_orientable_trapdoor_bottom")
		val TEMPLATE_ORIENTABLE_TRAPDOOR_OPEN = minecraftID("block/template_orientable_trapdoor_open")
		val POINTED_DRIPSTONE = minecraftID("block/pointed_dripstone")
		val CROSS = minecraftID("block/cross")
		val TINTED_CROSS = minecraftID("block/tinted_cross")
		val FLOWER_POT_CROSS = minecraftID("block/flower_pot_cross")
		val TINTED_FLOWER_POT_CROSS = minecraftID("block/tinted_flower_pot_cross")
		val RAIL_FLAT = minecraftID("block/rail_flat")
		val RAIL_CURVED = minecraftID("block/rail_curved")
		val TEMPLATE_RAIL_RAISED_NE = minecraftID("block/template_rail_raised_ne")
		val TEMPLATE_RAIL_RAISED_SW = minecraftID("block/template_rail_raised_sw")
		val CARPET = minecraftID("block/carpet")
		val CORAL_FAN = minecraftID("block/coral_fan")
		val CORAL_WALL_FAN = minecraftID("block/coral_wall_fan")
		val TEMPLATE_GLAZED_TERRACOTTA = minecraftID("block/template_glazed_terracotta")
		val TEMPLATE_CHORUS_FLOWER = minecraftID("block/template_chorus_flower")
		val TEMPLATE_DAYLIGHT_DETECTOR = minecraftID("block/template_daylight_detector")
		val TEMPLATE_GLASS_PANE_NOSIDE = minecraftID("block/template_glass_pane_noside")
		val TEMPLATE_GLASS_PANE_NOSIDE_ALT = minecraftID("block/template_glass_pane_noside_alt")
		val TEMPLATE_GLASS_PANE_POST = minecraftID("block/template_glass_pane_post")
		val TEMPLATE_GLASS_PANE_SIDE = minecraftID("block/template_glass_pane_side")
		val TEMPLATE_GLASS_PANE_SIDE_ALT = minecraftID("block/template_glass_pane_side_alt")
		val TEMPLATE_COMMAND_BLOCK = minecraftID("block/template_command_block")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_LEFT = minecraftID("block/template_chiseled_bookshelf_slot_top_left")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_MID = minecraftID("block/template_chiseled_bookshelf_slot_top_mid")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_TOP_RIGHT = minecraftID("block/template_chiseled_bookshelf_slot_top_right")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_LEFT =
			minecraftID("block/template_chiseled_bookshelf_slot_bottom_left")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_MID =
			minecraftID("block/template_chiseled_bookshelf_slot_bottom_mid")
		val TEMPLATE_CHISELED_BOOKSHELF_SLOT_BOTTOM_RIGHT =
			minecraftID("block/template_chiseled_bookshelf_slot_bottom_right")
		val TEMPLATE_ANVIL = minecraftID("block/template_anvil")
		val STEM_FRUIT = minecraftID("block/stem_fruit")
		val CROP = minecraftID("block/crop")
		val TEMPLATE_FARMLAND = minecraftID("block/template_farmland")
		val TEMPLATE_FIRE_FLOOR = minecraftID("block/template_fire_floor")
		val TEMPLATE_FIRE_SIDE = minecraftID("block/template_fire_side")
		val TEMPLATE_FIRE_SIDE_ALT = minecraftID("block/template_fire_side_alt")
		val TEMPLATE_FIRE_UP = minecraftID("block/template_fire_up")
		val TEMPLATE_FIRE_UP_ALT = minecraftID("block/template_fire_up_alt")
		val TEMPLATE_CAMPFIRE = minecraftID("block/template_campfire")
		val TEMPLATE_LANTERN = minecraftID("block/template_lantern")
		val TEMPLATE_HANGING_LANTERN = minecraftID("block/template_hanging_lantern")
		val TEMPLATE_TORCH = minecraftID("block/template_torch")
		val TEMPLATE_TORCH_WALL = minecraftID("block/template_torch_wall")
		val TEMPLATE_PISTON = minecraftID("block/template_piston")
		val TEMPLATE_PISTON_HEAD = minecraftID("block/template_piston_head")
		val TEMPLATE_PISTON_HEAD_SHORT = minecraftID("block/template_piston_head_short")
		val TEMPLATE_SEAGRASS = minecraftID("block/template_seagrass")
		val TEMPLATE_TURTLE_EGG = minecraftID("block/template_turtle_egg")
		val TEMPLATE_TWO_TURTLE_EGGS = minecraftID("block/template_two_turtle_eggs")
		val TEMPLATE_THREE_TURTLE_EGGS = minecraftID("block/template_three_turtle_eggs")
		val TEMPLATE_FOUR_TURTLE_EGGS = minecraftID("block/template_four_turtle_eggs")
		val TEMPLATE_SINGLE_FACE = minecraftID("block/template_single_face")
		val TEMPLATE_CAULDRON_LEVEL1 = minecraftID("block/template_cauldron_level1")
		val TEMPLATE_CAULDRON_LEVEL2 = minecraftID("block/template_cauldron_level2")
		val TEMPLATE_CAULDRON_FULL = minecraftID("block/template_cauldron_full")
		val TEMPLATE_AZALEA = minecraftID("block/template_azalea")
		val TEMPLATE_POTTED_AZALEA_BUSH = minecraftID("block/template_potted_azalea_bush")
		val GENERATED = minecraftID("item/generated")
		val HANDHELD = minecraftID("item/handheld")
		val HANDHELD_ROD = minecraftID("item/handheld_rod")
		val TEMPLATE_SHULKER_BOX = minecraftID("item/template_shulker_box")
		val TEMPLATE_BED = minecraftID("item/template_bed")
		val TEMPLATE_BANNER = minecraftID("item/template_banner")
		val TEMPLATE_SKULL = minecraftID("item/template_skull")
		val TEMPLATE_CANDLE = minecraftID("block/template_candle")
		val TEMPLATE_TWO_CANDLES = minecraftID("block/template_two_candles")
		val TEMPLATE_THREE_CANDLES = minecraftID("block/template_three_candles")
		val TEMPLATE_FOUR_CANDLES = minecraftID("block/template_four_candles")
		val TEMPLATE_CAKE_WITH_CANDLE = minecraftID("block/template_cake_with_candle")
		val TEMPLATE_SCULK_SHRIEKER = minecraftID("block/template_sculk_shrieker")
	}
	
	// Items
	private fun BiConsumer<Identifier, Supplier<JsonElement>>.upload(builder: ItemModelBuilder): Identifier {
		this.accept(builder.id, Supplier {
			val jsonObject = JsonObject()
			
			jsonObject.addProperty("parent", builder.parent.toString())
			
			if (builder.textures.isNotEmpty()) {
				val textureJsonObject = JsonObject()
				builder.textures.forEach { (textureKey: String, textureId: Identifier) ->
					textureJsonObject.addProperty(textureKey, textureId.toString())
				}
				jsonObject.add("textures", textureJsonObject)
			}
			
			if (builder.overrides.isNotEmpty()) {
				val overrideJsonArray = JsonArray()
				builder.overrides.forEach { overrideBuilder ->
					val eachOverride = JsonObject()
					
					val eachPredicate = JsonObject()
					overrideBuilder.predicates.forEach {
						eachPredicate.addProperty(it.key.toString(), it.value)
					}
					
					eachOverride.add("predicate", eachPredicate)
					eachOverride.addProperty("model", overrideBuilder.model.toString())
					
					overrideJsonArray.add(eachOverride)
				}
				jsonObject.add("overrides", overrideJsonArray)
			}
			
			jsonObject
		})
		
		return builder.id
	}
	
	fun generate(builder: ItemModelBuilder) {
		val modelCollector = modelGenerator.writer
		
		modelCollector.upload(builder)
		builder.overrides.forEach { override ->
			modelCollector.upload(
				ItemModelBuilder(override.model)
					.setParent(builder.parent)
					.setTexture(override.textures)
			)
		}
	}
	
	class ItemModelBuilder constructor(val id: Identifier) {
		var parent = Parents.GENERATED
		var textures = mutableMapOf<String, Identifier>()
		var overrides = mutableListOf<OverrideBuilder>()
		
		fun setParent(parent: Identifier): ItemModelBuilder {
			this.parent = parent
			return this
		}
		
		fun setTexture(textures: MutableMap<String, Identifier>): ItemModelBuilder {
			this.textures = textures
			return this
		}
		
		fun addTexture(
			name: String,
			texture: String,
			prefix: String = "item/",
			postfix: String = "",
		): ItemModelBuilder {
			this.textures[name] = Identifier(id.namespace, "$prefix$texture$postfix")
			return this
		}
		
		fun addTexture(
			texture: String,
			prefix: String = "item/",
			postfix: String = "",
		): ItemModelBuilder {
			this.textures["layer${this.textures.count()}"] = Identifier(id.namespace, "$prefix$texture$postfix")
			return this
		}
		
		fun <T : Any> addTextures(
			values: Collection<T>,
			prefix: String = "item/",
			postfix: String = "",
			action: (T) -> String,
		): ItemModelBuilder {
			values.map(action)
				.forEach { texture ->
					this.textures["layer${this.textures.count()}"] = Identifier(id.namespace, "$prefix$texture$postfix")
				}
			return this
		}
		
		fun addOverride(): OverrideBuilder {
			return OverrideBuilder(this)
		}
		
		class OverrideBuilder(val itemModelBuilder: ItemModelBuilder) {
			var model = Identifier(itemModelBuilder.id.namespace, "item/")
			var predicates = mutableMapOf<Identifier, Number>()
			var textures = mutableMapOf<String, Identifier>()
			
			fun addPredicate(
				id: Identifier,
				value: Number,
			): OverrideBuilder {
				this.predicates[id] = value
				return this
			}
			
			fun setModel(
				model: String,
				postfix: String = "",
			): OverrideBuilder {
				this.model = Identifier(this.model.namespace, model).withPath { it + postfix }
				return this
			}
			
			fun setModel(
				model: Identifier,
				postfix: String = "",
			): OverrideBuilder {
				this.model = model.withPath { it + postfix }
				return this
			}
			
			fun addTexture(
				texture: String,
				prefix: String = "item/",
				postfix: String = "",
			): OverrideBuilder {
				this.textures["layer${this.textures.count()}"] = Identifier(this.model.namespace, "$prefix$texture$postfix")
				return this
			}
			
			fun <T : Any> addTextures(
				values: Collection<T>,
				prefix: String = "item/",
				postfix: String = "",
				action: (T) -> String,
			): OverrideBuilder {
				values.map(action)
					.forEach { texture ->
						this.textures["layer${this.textures.count()}"] = Identifier(this.model.namespace, "$prefix$texture$postfix")
					}
				return this
			}
			
			fun end(): ItemModelBuilder {
				itemModelBuilder.overrides.add(this)
				return itemModelBuilder
			}
		}
	}
	
	fun <T : Item> generateItem(
		item: T,
		parent: Identifier = Parents.GENERATED,
	) {
		val identifier = RegistryHelper.getId(item)
		this.generate(
			ItemModelBuilder(identifier)
				.setParent(parent)
				.addTexture(identifier.path, prefix = "")
		)
	}
}
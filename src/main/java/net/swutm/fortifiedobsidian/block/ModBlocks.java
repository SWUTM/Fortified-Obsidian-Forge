package net.swutm.fortifiedobsidian.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.fortifiedobsidian.fortifiedobsidian;
import net.swutm.fortifiedobsidian.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, fortifiedobsidian.MOD_ID);

    public static final RegistryObject<Block> FORTIFIED_OBSIDIAN = registerBlock("fortified_obsidian",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).noOcclusion()), CreativeModeTab.TAB_BUILDING_BLOCKS);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn, tab);
            return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                                CreativeModeTab tab) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(tab)));
        }

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
}

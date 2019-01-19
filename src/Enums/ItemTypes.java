package Enums;

public enum ItemTypes {
    STONE_ITEM, GRASS_ITEM, DIRT_ITEM;

    public static ItemTypes blockToItem(Enum type){
        if(type.equals(BlockTypes.STONE)){
            return ItemTypes.STONE_ITEM;
        }
        if(type.equals(BlockTypes.GRASS)){
            return ItemTypes.GRASS_ITEM;
        }
        if(type.equals(BlockTypes.DIRT)){
            return ItemTypes.DIRT_ITEM;
        }
        return ItemTypes.STONE_ITEM;
    }
}

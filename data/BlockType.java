package data;

public enum BlockType {
    Dirt(0), Stone(0), Coal(1), Iron(5), Gold(15), Diamond(40), Chest(0);
    private final int value;

    BlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

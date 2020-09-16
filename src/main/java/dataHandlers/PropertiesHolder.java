package dataHandlers;

public class PropertiesHolder {

    private final int width;
    private final int height;
    private final int initAliveCount;

    public PropertiesHolder(int width, int height, int initAliveCount) {
        this.width = width;
        this.height = height;
        this.initAliveCount = initAliveCount;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getInitAliveCount() {
        return initAliveCount;
    }

}

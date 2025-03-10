package behavioral.composite;

public class File implements FileComponent{
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showProperties() {
        System.out.println(this.toString());
    }

    @Override
    public long totalSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}

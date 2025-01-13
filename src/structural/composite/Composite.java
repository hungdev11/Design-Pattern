package structural.composite;

import java.util.List;

/**
 * Compose objects into tree structures to represent part-whole hierarchies
 * Composite lets clients treat individual objects and compositions of object
 * When: handle group of objects similar handle an object
 */
public class Composite {
    public static void main(String[] args) {
        FileComponent file1 = new FileLeaf("a.jpeg", 200);
        FileComponent file2 = new FileLeaf("Superman.mp4", 30000);
        FileComponent file3 = new FileLeaf("Flash.mp4", 14000);
        FileComponent folder = new FolderComposite(List.of(file1));
        FileComponent mainFolder = new FolderComposite(List.of(file2, file3, folder));

        System.out.println(mainFolder.totalSize());
        mainFolder.showProperties();

    }
}
interface FileComponent {
    void showProperties();
    long totalSize();
}
class FileLeaf implements FileComponent {
    private String name;
    private long size;
    public FileLeaf(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showProperties() {
        System.out.println("File leaf [name=" + name + ", size=" + size + "]");
    }

    @Override
    public long totalSize() {
        return size;
    }
}
class FolderComposite implements FileComponent {
    List<FileComponent> files;

    public FolderComposite(List<FileComponent> files) {
        this.files = files;
    }

    @Override
    public void showProperties() {
        for (FileComponent file : files) {
            file.showProperties();
        }
    }

    @Override
    public long totalSize() {
        long sum = 0;
        for (FileComponent file : files) {
            sum += file.totalSize();
        }
        return sum;
    }
}

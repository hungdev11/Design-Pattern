package behavioral.composite;

import java.util.List;

public class Folder implements FileComponent{
    private List<FileComponent> children;

    public Folder(List<FileComponent> children) {
        this.children = children;
    }

    @Override
    public void showProperties() {
        System.out.println("Into folder");
        for (FileComponent f : children) {
            f.showProperties();
        }
    }

    @Override
    public long totalSize() {
        return children.stream().map(FileComponent::totalSize).reduce(0L, Long::sum);
    }
}

package behavioral.command;

import java.util.Stack;

public class DocumentApp {
    public static void main(String[] args) {
        DocumentInvoker instance = new DocumentInvoker();
        instance.write("The 1st text. ");
        instance.undo();
        instance.read(); // EMPTY

        instance.redo();
        instance.read(); // The 1st text.

        instance.write("The 2nd text. ");
        instance.write("The 3rd text. ");
        instance.read(); // The 1st text. The 2nd text. The 3rd text.
        instance.undo(); // The 1st text. The 2nd text.
        instance.undo(); // The 1st text.
        instance.undo(); // EMPTY
        instance.undo(); // Nothing to undo
    }
}
class Document {
    private Stack<String> lines = new Stack<>();
    public void write(String text) {
        lines.push(text);
    }
    public void eraseLast() {
        if (!lines.isEmpty()) {
            lines.pop();
        }
    }
    public void readDocument() {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
interface DocCommand {
    void undo();
    void redo();
}
class DocumentEditorCommand implements DocCommand {
    private Document document;
    private String text;
    public DocumentEditorCommand(Document document, String text) {
        this.document = document;
        this.text = text;
        this.document.write(text);
    }
    public void undo() {
        document.eraseLast();
    }
    public void redo() {
        document.write(text);
    }
}
class DocumentInvoker {
    private Stack<DocCommand> undoCommands = new Stack<>();
    private Stack<DocCommand> redoCommands = new Stack<>();
    private Document document = new Document();

    public void undo() {
        if (!undoCommands.isEmpty()) {
            DocCommand cmd = undoCommands.pop();
            cmd.undo();
            redoCommands.push(cmd);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (!redoCommands.isEmpty()) {
            DocCommand cmd = redoCommands.pop();
            cmd.redo();
            undoCommands.push(cmd);
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void write(String text) {
        DocCommand cmd = new DocumentEditorCommand(document, text);
        undoCommands.push(cmd);
        redoCommands.clear();
    }

    public void read() {
        document.readDocument();
    }
}
package classes;

import interfaces.Printer;
import interfaces.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer renderer;
    private String prefix = null;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    @Override
    public void print(String message) {
        if (prefix != null) {
            renderer.render(prefix + message);
        } else {
            renderer.render(message);
        }
    }

}

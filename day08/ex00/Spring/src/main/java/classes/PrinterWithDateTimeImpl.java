package classes;

import interfaces.Printer;
import interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    public Renderer renderer;
    LocalDateTime localDateTime;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public void print(String message) {
        String time = localDateTime.toString();
        if (time != null) {
            renderer.render(time + " " + message);
        } else {
            renderer.render(message);
        }
    }
}

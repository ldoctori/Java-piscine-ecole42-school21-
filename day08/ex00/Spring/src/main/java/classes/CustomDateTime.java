package classes;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class CustomDateTime {

    LocalDateTime ldt;

    public  CustomDateTime() {
        this.ldt = LocalDateTime.now();
    }

    public LocalDateTime getLdt() {
        return this.ldt;
    }

}

package app;


import interfaces.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printerPref = (Printer) context.getBean("printerWithPrefix");
        printerPref.print("Hello!");
        Printer printerTime = (Printer) context.getBean("printerWithTime");
        printerTime.print("Hello!");
        Printer printerPrefLow = (Printer) context.getBean("printerWithPrefixLower");
        printerPrefLow.print("Hello!");
        Printer printerTimeLow = (Printer) context.getBean("printerWithTimeLower");
        printerTimeLow.print("Hello!");

        Printer printerErrPref = (Printer) context.getBean("printerErrWithPrefix");
        printerErrPref.print("Hello!");
        Printer printerErrTime = (Printer) context.getBean("printerErrWithTime");
        printerErrTime.print("Hello!");
        Printer printerErrPrefLow = (Printer) context.getBean("printerErrWithPrefixLower");
        printerErrPrefLow.print("Hello!");
        Printer printerErrTimeLow = (Printer) context.getBean("printerErrWithTimeLower");
        printerErrTimeLow.print("Hello!");

    }
}

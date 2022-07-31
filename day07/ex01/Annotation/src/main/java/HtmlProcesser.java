import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes({"HtmlForm", "HtmlInput"})
@AutoService(Processor.class)

public class HtmlProcesser extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {


        Set<? extends Element> annotatedElements = null;
        for (TypeElement annotation : set) {
            annotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);
            if (!annotatedElements.isEmpty()) {
                try {
                    FileObject file = processingEnv.getFiler()
                            .createResource(StandardLocation.CLASS_OUTPUT,  "","user_form.txt");
                    PrintWriter out = new PrintWriter(file.openWriter());
                    out.print("sometext!!!!!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        return true;
    }
}

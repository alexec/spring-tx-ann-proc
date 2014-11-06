import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("org.springframework.transaction.annotation.Transactional")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class SpringTransactionalProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnvironment) {
        for (Element element : roundEnvironment.getElementsAnnotatedWith(Transactional.class)) {
            Element classElement = element.getEnclosingElement();
            boolean isPublic = element.getModifiers().contains(Modifier.PUBLIC);
            if (!isPublic) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                        classElement + "#" + element + " is not public, but @Transactional only works with public methods");
            }
        }
        return true;
    }
}

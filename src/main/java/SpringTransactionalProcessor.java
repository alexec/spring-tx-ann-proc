import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("org.springframework.transaction.annotation.Transactional")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class SpringTransactionalProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnvironment) {
        System.out.println("not doing much right now");
        return false;
    }
}

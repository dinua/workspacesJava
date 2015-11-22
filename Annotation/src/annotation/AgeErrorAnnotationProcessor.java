package annotation;

import javax.tools.Diagnostic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes(value = { "*" })
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class AgeErrorAnnotationProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		for (Element e : roundEnv.getElementsAnnotatedWith(AgeError.class)) {

			@SuppressWarnings("unchecked")
			List<AnnotationMirror> mirrors = (List<AnnotationMirror>) e
					.getAnnotationMirrors();
			for (AnnotationMirror mirror : mirrors) {
				if (mirror.getAnnotationType().toString()
						.equals(AgeError.class.getName())) {
					@SuppressWarnings("unchecked")
					Map<ExecutableElement, AnnotationValue> valuesMap = (Map<ExecutableElement, AnnotationValue>) mirror
							.getElementValues();
					Set<Map.Entry<ExecutableElement, AnnotationValue>> valueSet = valuesMap
							.entrySet();
					for (Map.Entry<ExecutableElement, AnnotationValue> entry : valueSet) {
						AnnotationValue annotationValue = entry.getValue();
						Object age =  annotationValue.getValue();
						if ((Integer)age < 18) {
							showError("you are underage at " + age, e);
						}
						
					}
				}
			}
		}
		return false;
	}

	private void showError(String msg, Element e) {
		processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, e);
	}
}

package deprecated;

import java.util.Collection;
import java.util.Map;
import java.util.Set;




import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.Messager;
import com.sun.mirror.declaration.AnnotationMirror;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.AnnotationTypeElementDeclaration;
import com.sun.mirror.declaration.AnnotationValue;
import com.sun.mirror.declaration.Declaration;

@SuppressWarnings("deprecation")
public class AgeDeprecatedAnnotationProcessor implements AnnotationProcessor{

	private AnnotationProcessorEnvironment	_env;


	public AgeDeprecatedAnnotationProcessor(AnnotationProcessorEnvironment env){
		_env = env;
	}

	public void process(){
		Messager messager = _env.getMessager();
		
		// obtinem declaratia anotatiei pe care dorim sa o procesam
		AnnotationTypeDeclaration annoDecl = (AnnotationTypeDeclaration)_env.getTypeDeclaration(AgeDeprecated.class.getName());
		
		// obtinem tipurile anotate
		Collection<Declaration> annotatedTypes = _env.getDeclarationsAnnotatedWith(annoDecl);
		
		for (Declaration decl : annotatedTypes) {
			Collection<AnnotationMirror> mirrors = decl.getAnnotationMirrors();
			
			// pentru fiecare anotatie gasita construim o colectie de elemente name/value 
			for (AnnotationMirror mirror : mirrors) {
				Map<AnnotationTypeElementDeclaration, AnnotationValue> valueMap = mirror.getElementValues();
				Set<Map.Entry<AnnotationTypeElementDeclaration, AnnotationValue>> valueSet = valueMap.entrySet();
				
				// procesorul de anotatie intelege doua elemente: "what" si "howMany"
				for (Map.Entry<AnnotationTypeElementDeclaration, AnnotationValue> annoKeyValue : valueSet) {					
					AnnotationValue annoValue = annoKeyValue.getValue();	// obtine name
					 if (annoKeyValue.getKey().getSimpleName().equals("value")) {
						Object howManyValue = annoValue.getValue();
							if (((Integer)howManyValue) < 18) {
								messager.printError(annoValue.getPosition(),"you are underage at " + howManyValue);
							}
					}
				}
			}
		}
	}

}

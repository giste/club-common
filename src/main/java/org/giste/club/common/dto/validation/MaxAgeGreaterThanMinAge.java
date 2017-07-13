package org.giste.club.common.dto.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = MaxAgeGreaterThanMinAgeValidator.class)
@Documented
public @interface MaxAgeGreaterThanMinAge {

	//String message() default "Minimum age has to be lower or equal than maximum age.";
	String message() default "{org.giste.club.common.dto.validation.minAgeGreaterThanMaxAge.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

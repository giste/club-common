package org.giste.club.common.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.giste.club.common.dto.CategoryDto;

public class MaxAgeGreaterThanMinAgeValidator implements ConstraintValidator<MaxAgeGreaterThanMinAge, Object> {

	@Override
	public void initialize(MaxAgeGreaterThanMinAge arg0) {

	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		final CategoryDto category = (CategoryDto) arg0;

		return category.getMaxAge() >= category.getMinAge();
	}

}

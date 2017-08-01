package org.giste.club.common.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.giste.club.common.dto.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxAgeGreaterThanMinAgeValidator implements ConstraintValidator<MaxAgeGreaterThanMinAge, Object> {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Override
	public void initialize(MaxAgeGreaterThanMinAge arg0) {

	}

	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		final CategoryDto category = (CategoryDto) arg0;

		LOGGER.debug("Parameters = {}, {}, {}", category.getMinAge(), category.getMaxAge(),
				category.getMaxAge() >= category.getMinAge());

		boolean valid = category.getMaxAge() >= category.getMinAge();

		if (!valid) {
			arg1.disableDefaultConstraintViolation();
			arg1.buildConstraintViolationWithTemplate("{MaxAgeGreaterThanMinAge.categoryDto.maxAge}")
					.addPropertyNode("maxAge")
					.addConstraintViolation();
		}

		return valid;
	}

}

package org.giste.club.common.dto;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.giste.util.StringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryDtoTest {
	private final static Long ID_OK = 0L;
	private final static String NAME_OK = "Category 1";
	private final static int MIN_AGE_OK = 14;
	private final static int MAX_AGE_OK = 16;
	private final static boolean MIXED_OK = true;

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void categoryIsValid() {
		CategoryDto category = new CategoryDto(ID_OK, NAME_OK, MIN_AGE_OK, MAX_AGE_OK, MIXED_OK);

		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);
		assertEquals(0, violations.size());
	}

	@Test
	public void nameTooShort() {
		CategoryDto category = new CategoryDto(ID_OK, StringUtil.ofLength(2), MIN_AGE_OK, MAX_AGE_OK, MIXED_OK);
		
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("name", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
	}
	
	@Test
	public void nameTooLong() {
		CategoryDto category = new CategoryDto(ID_OK, StringUtil.ofLength(65), MIN_AGE_OK, MAX_AGE_OK, MIXED_OK);
		
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("name", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
	}

	@Test
	public void nameIsNull() {
		CategoryDto category = new CategoryDto(ID_OK, null, MIN_AGE_OK, MAX_AGE_OK, MIXED_OK);
		
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("name", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
	}

	@Test
	public void minAgeTooLow() {
		CategoryDto category = new CategoryDto(ID_OK, NAME_OK, -1, MAX_AGE_OK, MIXED_OK);

		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("minAge", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Min.message}", violation.getMessageTemplate());
	}

	@Test
	public void maxAgeTooHigh() {
		CategoryDto category = new CategoryDto(ID_OK, NAME_OK, MIN_AGE_OK, 101, MIXED_OK);

		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("maxAge", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Max.message}", violation.getMessageTemplate());
	}

	@Test
	public void minAgeGreaterThanMaxAge() {
		CategoryDto category = new CategoryDto(ID_OK, NAME_OK, 10, 1, MIXED_OK);

		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);

		assertEquals(1, violations.size());
		ConstraintViolation<CategoryDto> violation = violations.iterator().next();
		assertEquals("{MaxAgeGreaterThanMinAge.categoryDto.maxAge}",
				violation.getMessageTemplate());
	}

	@Test
	public void minAgeEqualToMaxAge() {
		CategoryDto category = new CategoryDto(ID_OK, NAME_OK, MIN_AGE_OK, MIN_AGE_OK, MIXED_OK);

		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(category);
		assertEquals(0, violations.size());
	}
}

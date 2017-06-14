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

public class PlayerDtoTest {
	private final static Long ID_OK = 0L;
	private final static String NAME_OK = "Name Surname";

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void clubIsValid() {
		PlayerDto player = new PlayerDto(ID_OK, false, NAME_OK, 2000, false, Gender.MALE);

		Set<ConstraintViolation<PlayerDto>> violations = validator.validate(player);
		assertEquals(0, violations.size());
	}

	@Test
	public void nameTooLong() {
		PlayerDto player = new PlayerDto(ID_OK, false, StringUtil.ofLength(41), 2000, false, Gender.MALE);

		Set<ConstraintViolation<PlayerDto>> violations = validator.validate(player);

		assertEquals(1, violations.size());
		ConstraintViolation<PlayerDto> violation = violations.iterator().next();
		assertEquals("name", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
	}

	@Test
	public void parametersAreNull() {
		PlayerDto player = new PlayerDto(1L, false, null, null, false, null);

		Set<ConstraintViolation<PlayerDto>> violations = validator.validate(player);

		assertEquals(3, violations.size());
		for (ConstraintViolation<PlayerDto> violation : violations) {
			assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
		}
	}

}

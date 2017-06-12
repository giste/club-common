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

public class UserDtoTest {
	private final static Long ID_OK = 0L;
	private final static String MAIL_OK = "user@email.org";
	private final static Role ROLE_OK = Role.USER;

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void userIsValid() {
		UserDto user = new UserDto(ID_OK, MAIL_OK, "", ROLE_OK);

		Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
		assertEquals(0, violations.size());
	}

	@Test
	public void mailTooLong() {
		UserDto user = new UserDto(ID_OK, StringUtil.ofLength(56) + "@" + "mail.org", "", ROLE_OK);

		Set<ConstraintViolation<UserDto>> violations = validator.validate(user);

		assertEquals(1, violations.size());
		ConstraintViolation<UserDto> violation = violations.iterator().next();
		assertEquals("email", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Size.message}", violation.getMessageTemplate());
	}

	@Test
	public void parametersAreNull() {
		UserDto user = new UserDto(null, null, "", null);

		Set<ConstraintViolation<UserDto>> violations = validator.validate(user);

		assertEquals(2, violations.size());
		for (ConstraintViolation<UserDto> violation : violations) {
			assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
		}
	}

	@Test
	public void mailInvalid() {
		UserDto user = new UserDto(ID_OK, StringUtil.ofLength(10), "", ROLE_OK);

		Set<ConstraintViolation<UserDto>> violations = validator.validate(user);

		assertEquals(1, violations.size());
		ConstraintViolation<UserDto> violation = violations.iterator().next();
		assertEquals("email", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Pattern.message}", violation.getMessageTemplate());
	}

}

package org.giste.club.common.dto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class SeasonDtoTest {
	private final static Long ID_OK = 0L;
	private final static Integer YEAR_OK = 2017;
	private final static String NAME_OK = "2017-2018";
	
	private static Validator validator;

	@Before
	public void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void seasonIsValid() {
		SeasonDto season = new SeasonDto(ID_OK, YEAR_OK);
		
		Set<ConstraintViolation<SeasonDto>> violations = validator.validate(season);
		assertEquals(0, violations.size());
	}
	
	@Test
	public void yearIsBelowMinimum() {
		SeasonDto season = new SeasonDto(ID_OK, 2000);
		
		Set<ConstraintViolation<SeasonDto>> violations = validator.validate(season);
		assertEquals(1, violations.size());
		ConstraintViolation<SeasonDto> violation = violations.iterator().next();
		assertEquals("year", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.Min.message}", violation.getMessageTemplate());
	}
	
	@Test
	public void yearIsNull() {
		SeasonDto season = new SeasonDto(ID_OK, null);

		Set<ConstraintViolation<SeasonDto>> violations = validator.validate(season);
		assertEquals(1, violations.size());
		ConstraintViolation<SeasonDto> violation = violations.iterator().next();
		assertEquals("year", violation.getPropertyPath().toString());
		assertEquals("{javax.validation.constraints.NotNull.message}", violation.getMessageTemplate());
	}

	@Test
	public void nameIsOk() {
		SeasonDto season = new SeasonDto(ID_OK, YEAR_OK);
		
		assertThat(season.getName(), is(NAME_OK));
	}
}

package org.giste.club.common.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.giste.util.dto.BaseDto;

public class SeasonDto extends BaseDto {

	@NotNull
	@Min(2017)
	private Integer year = java.time.LocalDate.now().getYear();

	public SeasonDto() {

	}

	/**
	 * Creates a new season DTO.
	 * 
	 * @param id Identifier of this season.
	 * @param year Year when the season begins.
	 */
	public SeasonDto(Long id, Integer year) {
		super(id);
		this.year = year;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Gets the name of the season based on the year it begins.
	 * 
	 * @return The name of the season.
	 */
	public String getName() {
		return year + "-" + (year + 1);
	}

	@Override
	public String toString() {
		return String.format("SeasonDto [id=%s, year=%s]", id, year);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeasonDto other = (SeasonDto) obj;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}

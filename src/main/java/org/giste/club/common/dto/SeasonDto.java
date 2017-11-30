package org.giste.club.common.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.giste.util.dto.BaseDto;

public class SeasonDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = -7718666985037630483L;

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
}

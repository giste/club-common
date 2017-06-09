package org.giste.club.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.giste.util.dto.NonRemovableDto;

/**
 * DTO object form transfer values between client and server. It has the
 * following fields.
 * <ul>
 * <li>id: Unique identifier of club.
 * <li>name: Complete name of the club. Size must be between 3 and 64
 * characters.
 * <li>acronym: Short name for the club. Size must be between 3 and 5
 * characters. Has to be formed by capital letters (A-Z) and numbers (0-9).
 * <li>enabled: Indicates if the club is enabled in the application (can be
 * accessed) or not.
 * </ul>
 * 
 * @author Giste
 */
public class ClubDto extends NonRemovableDto {

	private static final long serialVersionUID = -1992057722496454721L;

	@NotNull
	@Size(min = 3, max = 64)
	private String name;

	@NotNull
	@Pattern(regexp = "[A-Z0-9]{3,5}")
	private String acronym;

	public ClubDto() {

	}

	/**
	 * Constructs a ClubDto populated with values.
	 * 
	 * @param id Identifier of the club.
	 * @param name Name of the club.
	 * @param acronym Acronym of the club.
	 * @param enabled Indication of the enabled state of the club.
	 */
	public ClubDto(Long id, String name, String acronym, Boolean enabled) {
		super(id, enabled);
		this.name = name;
		this.setAcronym(acronym);
	}

	/**
	 * Gets the club name.
	 * 
	 * @return The
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the club.
	 * 
	 * @param name The club name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the acronym of the club.
	 * 
	 * @return The acronym of the club.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Sets the acronym of the club.
	 * 
	 * @param acronym The acronym of the club.
	 */
	public void setAcronym(String acronym) {
		if (acronym != null) {
			this.acronym = acronym.toUpperCase();
		}
	}

	@Override
	public String toString() {
		return "ClubDto [id=" + id + ", name=" + name + ", acronym=" + acronym + ", enabled=" + enabled + "]";
	}

}

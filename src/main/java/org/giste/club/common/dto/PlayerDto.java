package org.giste.club.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.giste.util.dto.NonRemovableDto;

/**
 * Represents a player of the club.
 * 
 * @author Giste
 */
public class PlayerDto extends NonRemovableDto {

	private static final long serialVersionUID = -4101436904122552862L;
	
	@NotNull
	@Size(max = 40)
	private String name;
	
	@NotNull
	private Integer birthYear;
	
	private boolean goalie = false;
	
	@NotNull
	private Gender gender;

	/**
	 * Default constructor.
	 */
	public PlayerDto() {
		
	}

	/**
	 * Constructs a new player.
	 * 
	 * @param id Identifier of the player.
	 * @param enabled Indicates if the player is enabled in the application.
	 * @param name Name of the player.
	 * @param birthYear year of the birth of the player. It's used for assign a category to it.
	 * @param goalie Indicates if the player is a goalie.
	 * @param gender Gender of the player.
	 */
	public PlayerDto(Long id, boolean enabled, String name, Integer birthYear, boolean goalie, Gender gender) {
		super(id, enabled);
		this.name = name;
		this.birthYear=birthYear;
		this.goalie=goalie;
		this.gender=gender;
	}

	/**
	 * Gets the players name.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the players name.
	 * 
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the year of birth.
	 * 
	 * @return The year of birth.
	 */
	public Integer getBirthYear() {
		return birthYear;
	}

	/**
	 * Sets the year of birth.
	 * 
	 * @param birthYear The year of birth.
	 */
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * Gets if the player is a goalie.
	 * 
	 * @return <code>true</code> if the player is a goalie or <code>false</code> otherwise.
	 */
	public boolean isGoalie() {
		return goalie;
	}

	/**
	 * Gets if the player is a goalie.
	 * 
	 * @param goalie <code>true</code> if the player is a goalie or <code>false</code> otherwise.
	 */
	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}

	/**
	 * Gets the player's gender.
	 * 
	 * @return The gender of the player.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the player's gender.
	 * 
	 * @param gender The gender of the player.
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}

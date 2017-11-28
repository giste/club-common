package org.giste.club.common.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.giste.spring.util.validation.IntComparation;
import org.giste.spring.util.validation.Relationship;
import org.giste.util.dto.BaseDto;

/**
 * Represents a category for a team. A category has a name and has a minimum and
 * a maximum age for its players. Only the birth year is taken into account for
 * calculating if a player belongs to a category. A category can be mixed (males
 * and females) or not.
 * 
 * @author Giste
 */
@IntComparation(field = "maxAge", reference = "minAge", relationship = Relationship.GreaterOrEqual)
public class CategoryDto extends BaseDto {

	private static final long serialVersionUID = 274894106349156599L;

	@NotNull
	@Size(min = 3, max = 64)
	private String name;

	@Min(0)
	private int minAge;

	@Max(100)
	private int maxAge;

	private boolean mixed;

	/**
	 * Constructs a new empty category.
	 */
	public CategoryDto() {
		super();
	}

	/**
	 * Construct a category with given values.
	 * 
	 * @param id The category identifier.
	 * @param name The category name.
	 * @param minAge The minimum age for this category.
	 * @param maxAge The maximum age for this category.
	 * @param mixed <code>true</code> if it's a mixed category and
	 *            <code>false</code> otherwise.
	 */
	public CategoryDto(Long id, String name, int minAge, int maxAge, boolean mixed) {
		super(id);
		this.name = name;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.mixed = mixed;
	}

	/**
	 * Gets the category name.
	 * 
	 * @return The category name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the category name.
	 * 
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the minimum age for players of this category.
	 * 
	 * @return The minimum age for players of this category.
	 */
	public int getMinAge() {
		return minAge;
	}

	/**
	 * Sets the minimum age for players of this category.
	 * 
	 * @param minAge The minimum age for players of this category.
	 */
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	/**
	 * Gets the maximum age for players of this category.
	 * 
	 * @return The maximum age for players of this category.
	 */
	public int getMaxAge() {
		return maxAge;
	}

	/**
	 * Sets the maximum age for players of this category.
	 * 
	 * @param maxAge The maximum age for players of this category.
	 */
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * Gets if the category is mixed.
	 * 
	 * @return <code>true</code> if it's a mixed category and <code>false</code>
	 *         otherwise.
	 */
	public boolean isMixed() {
		return mixed;
	}

	/**
	 * Gets if the category is mixed.
	 * 
	 * @param mixed Indicator of mixed category.
	 */
	public void setMixed(boolean mixed) {
		this.mixed = mixed;
	}

}

package model;

import java.util.Comparator;

/**
 * A class that provides different comparators to compare a Project by either
 * its name, cost, duration or energy efficiency.
 * 
 * @author Matthew Chan
 */
public class ProjectComparator {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ProjectComparator() {
	}

	/**
	 * Sorts the project list by name in alphabetical order.
	 * 
	 * @return a name comparator
	 */
	public static Comparator<Project> sortByName() {
		return Comparator.comparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by name in reverse alphabetical order.
	 * 
	 * @return a reversed name comparator
	 */
	public static Comparator<Project> sortByNameReversed() {
		return Comparator.comparing(Project::getMyName).reversed();
	}

	/**
	 * Sorts the project list by cost in ascending order.
	 * 
	 * @return a cost comparator
	 */
	public static Comparator<Project> sortByCost() {
		return Comparator.comparing(Project::getMyCost).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by cost in descending order.
	 * 
	 * @return a reversed cost comparator
	 */
	public static Comparator<Project> sortByCostReversed() {
		return Comparator.comparing(Project::getMyCost).reversed().thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by duration in ascending order.
	 * 
	 * @return a duration comparator
	 */
	public static Comparator<Project> sortByDuration() {
		return Comparator.comparing(Project::getMyDays).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by duration in descending order.
	 * 
	 * @return a reversed duration comparator
	 */
	public static Comparator<Project> sortByDurationReversed() {
		return Comparator.comparing(Project::getMyDays).reversed().thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by energy efficiency in LOW, MED, HIGH order.
	 * 
	 * @return an energy efficiency comparator
	 */
	public static Comparator<Project> sortByEnergy() {
		return Comparator.comparing(Project::getMyEnergy).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by energy efficiency in HIGH, MED, LOW order.
	 * 
	 * @return a reversed energy efficiency comparator
	 */
	public static Comparator<Project> sortByEnergyReversed() {
		return Comparator.comparing(Project::getMyEnergy).reversed().thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by calculation comparing cost vs benefit.
	 * 
	 * @return a cost vs benefit comparator
	 */
	public static Comparator<Project> sortByCalculation() {
		return Comparator.comparing(Project::getCostBenefit).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by calculation comparing cost vs benefit.
	 * 
	 * @return a reversed cost vs benefit comparator
	 */
	public static Comparator<Project> sortByCalculationReversed() {
		return Comparator.comparing(Project::getCostBenefit).reversed().thenComparing(Project::getMyName);
	}

}

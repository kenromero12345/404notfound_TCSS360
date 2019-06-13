package model;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for materials.
 * 
 * @author Tammy Vo
 */
public class Materials {

	/** The TreeMap storing all materials needed. */
	private TreeMap<String, Double> myMaterials;

	/** Private constructor. */
	public Materials() {
		myMaterials = new TreeMap<>();
	}

	/**
	 * Adds the material.
	 * 
	 * @author Tammy Vo
	 * @param theName of the material.
	 * @param theCost of the material.
	 */
	public void addMaterial(final String theName, final double theCost) {
		myMaterials.put(theName, theCost);
	}

	/**
	 * Method to delete materials.
	 * 
	 * @author Tammy Vo
	 * @param theName
	 */
	public void deleteMaterial(final String theName) {
		myMaterials.remove(theName);
	}

	/**
	 * Method to returns the materials.
	 * 
	 * @author Tammy Vo
	 * @return the materials.
	 */
	public TreeMap<String, Double> getMaterialMap() {
		return myMaterials;
	}

	@Override
	public String toString() {
		if (!myMaterials.isEmpty()) {
			DecimalFormat df = new DecimalFormat("0.00");
			StringBuilder sb = new StringBuilder();

			for (Map.Entry<String, Double> entry : myMaterials.entrySet()) {
				sb.append(entry.getKey() + " | Cost: $" + df.format(entry.getValue()));
				sb.append("\n");
			}

			sb.delete(sb.lastIndexOf("\n"), sb.length());
			return sb.toString();

		} else {
			return "No Materials is Found.";
		}
	}

}

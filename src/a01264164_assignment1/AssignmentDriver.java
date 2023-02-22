package a01264164_assignment1;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignmentDriver {
	
	private final Address[] ADDRESS_DATA = {new Address("1a", 777, "56th avenue", "v7n2m8", "surrey"),
			new Address(null, 123, "main street", "v7r2g2", "west vancouver"),
			new Address(null, 456, "elm street", "90210", "los angeles"),
			new Address("44", 1111, "maple street", "v8y3r5", "vancouver"),
			new Address("9", 99, "gretzky way", "t6v7h3", "toronto"),
			new Address("b", 711, "country road", "v8h5f5", "maple ridge"),
			new Address(null, 8785, "pinnacle avenue", "v9u3h3", "north vancouver"),
			new Address(null, 800, "elm street", "90557", "los angeles"),
			new Address(null, 1515,"main street", "v8y7r3", "west vancouver"),
			new Address("6", 60, "60th street", "v8u9b1", "burnaby"),
			new Address("7h", 1500, "railway avenue", "v9v5v4", "richmond"),
			new Address(null, 333, "elm street", "90111", "los angeles")};
	
	private final Property[] PROPERTY_DATA = {new Property(499000.00, ADDRESS_DATA[0], 2, false, "residence", "abc123"),
			new Property(5999999.00, ADDRESS_DATA[1], 5, true, "residence", "xyz789"),
			new Property(2500000.00, ADDRESS_DATA[2], 6, true, "residence", "777def"),
			new Property(1000000.00, ADDRESS_DATA[3], 1, false, "retail", "876tru"),
			new Property(99999.00, ADDRESS_DATA[4], 1, false, "commercial", "9999"),
			new Property(740100.00, ADDRESS_DATA[5], 3, false, "residence", "mr6789"),
			new Property(15000000.00, ADDRESS_DATA[6], 20, true, "residence", "78444a"),
			new Property(7100000.00, ADDRESS_DATA[7], 10, false, "residence", "mmm33"),
			new Property(4000000.00, ADDRESS_DATA[8], 2, true, "commercial", "678T"),
			new Property(700000.00, ADDRESS_DATA[9], 2, true, "retail", "y6yyy"),
			new Property(840000.00, ADDRESS_DATA[10], 4, false, "commercial", "A1212"),
			new Property(1600000.00, ADDRESS_DATA[11], 3, false, "residence", "9000a")};

			

	public static void main(String[] args) {
		
		new AssignmentDriver().run();

	}
	
	
	public static String capitalizeWords(String text) {
	    String[] words = text.split(" ");
	    StringBuilder result = new StringBuilder();
	    for (String word : words) {
	        if (word.length() > 0) {
	            result.append(word.substring(0, 1).toUpperCase());
	            if (word.length() > 1) {
	                result.append(word.substring(1));
	            }
	            result.append(" ");
	        }
	    }
	    return result.toString().trim();
	}
	
	public static void printProperty(Property property) {
	    String unitNumber = property.getAddress().getUnitNumber();
	    String unitString = "";
	    if (unitNumber != null && !unitNumber.isEmpty()) {
	        unitString = "unit #" + unitNumber + " at ";
	    }
	    String addressString = "Property " + property.getPropertyID() + ": " + unitString + property.getAddress().getStreetNumber()
	            + " " + capitalizeWords(property.getAddress().getStreetName()) + " " + property.getAddress().getPostalCode().toUpperCase()
	            + " in " + capitalizeWords(property.getAddress().getCity()) + " (" + property.getNumOfBedrooms()
	            + " bedrooms" + (property.isSwimmingPool() ? " plus pool" : "") + "): $" + Double.valueOf(property.getPriceUSD()).intValue() + ".";
	    System.out.println(addressString);
	}


	
	/**
	 * 
	 */
	public void run() {
		
		Agency agency = new Agency("Agency Name");
		
		for(Property property : PROPERTY_DATA) {
			
			agency.addProperty(property);
		}	
		
		System.out.println("Testing Agency.getProperty(876tru)");
		System.out.println(agency.getProperty("876tru"));
		
		System.out.println("Testing Agency.getTotalPropertyValues()");
		System.out.println("Total property values are: $" + String.format("%.2f",agency.getTotalPropertyValues()));
	
		System.out.println("Testing Agency.getPropertiesWithPools()");
		ArrayList<Property> poolProperties = agency.getPropertiesWithPools();
		System.out.println("Here is a list of properties with pools:");
		for(Property properties : poolProperties) {
			System.out.println(properties);
		}		
			
		System.out.println("Testing Agency.getPropertiesBetween(minUsd, maxUsd)");
		Property[] priceRangeProperties = agency.getPropertiesBetween(500000.00, 999999.00);
		System.out.println("Here is a list of properties between " + 500000.00 + " and " + 999999.00 + ": ");
		for(Property prop : priceRangeProperties) {
			System.out.println(prop);
		}		
	
		
		System.out.println("Testing Agency.getPropertiesOn(\"elm street\")");
		ArrayList<Address> streetAddresses = agency.getPropertiesOn("elm street");
		System.out.println("Here is a list of properties on "+ "Elm Street");
		for(Address address : streetAddresses) {
			System.out.println(address);
		}		
	
		
		System.out.println("Testing Agency.getPropertiesWithBedrooms(2, 4)");
		HashMap<String, Property> bedroomProperty = agency.getPropertiesWithBedrooms(2, 4);
		System.out.println("Here is a list of properties with 2 to 4 bedrooms: ");
		for(String properyID : bedroomProperty.keySet()) {
			System.out.println(bedroomProperty.get(properyID));
		}		
		
		
		System.out.println("Testing Agency.getPropertiesOfType(\"residence\")");
		ArrayList<Property> residences = agency.getPropertiesOfType("residence");
		System.out.println("Here is a list of residencial properties: Type: RESIDENCE");

		for(Property property : residences) {
			printProperty(property);
//			System.out.println("Property " + property.getPropertyID() + ": " + (property.getAddress().getUnitNumber() == null ? "" :"unit #" + property.getAddress().getUnitNumber() + " at ") + property.getAddress().getStreetNumber()
//					+ " " + capitalizeWords(property.getAddress().getStreetName()) + " " + property.getAddress().getPostalCode().toUpperCase()
//					+ " in " + capitalizeWords(property.getAddress().getCity()) + " (" + property.getNumOfBedrooms()
//					+ " bedrooms" + (property.isSwimmingPool() ? " plus pool" : "") + "): $" + Double.valueOf(property.getPriceUSD()).intValue() + ".");
		}		
		
		System.out.println("Testing Agency.getPropertiesOfType(\"commercial\")");
		ArrayList<Property> commercials = agency.getPropertiesOfType("commercial");
		System.out.println("Here is a list of commercial properties: Type: COMMERCIAL");

		for(Property property : commercials) {
			printProperty(property);
		}		
		
		System.out.println("Testing Agency.getPropertiesOfType(\"retail\")");
		ArrayList<Property> retails = agency.getPropertiesOfType("retail");
		System.out.println("Here is a list of retail properties: TYPE: RETAIL");
		for(Property property : retails) {
			printProperty(property);
		}				
		
	}

}


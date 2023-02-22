package a01264164_assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Agency {
	private String name;
	private HashMap<String, Property> properties; 
	
	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 30;
	public Agency(String name) {
		super();
		
		if (name == null) {
			throw new NullPointerException("Name is Null");
		}
		
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		this.name = name;
		properties = new HashMap<>();
	}
	
	public void addProperty(Property property){
		properties.put(property.getPropertyID(), property);
	}
	
	public void removePropery(String propertyID){
		if (properties.containsKey(propertyID)){
			properties.remove(propertyID);
		}
	}
	
	public Property getProperty(String propertyID){
		if (properties.containsKey(propertyID)){
			return(properties.get(propertyID));
		} else {
			return null;
		}
	}
	
	public double getTotalPropertyValues() {
		double totalValue = 0;
		Set<String> propertyIDs = properties.keySet();
		
		for (String propertyID: propertyIDs) {
			totalValue += properties.get(propertyID).getPriceUSD();
		}
		return totalValue;
	}
	
	public ArrayList<Property> getPropertiesWithPools(){
		
        ArrayList<Property> poolsArr = new ArrayList<>();

        Set<String> propertyIDs = properties.keySet();

        for(String propertyID: propertyIDs){
        
            Property property =  properties.get(propertyID);

            if(property.isSwimmingPool()){
            	poolsArr.add(property);
            }
        }

        if(poolsArr.size() == 0){        
            return null;
        }

        return poolsArr;
    }
	
	public Property[] getPropertiesBetween(double minUsd, double maxUsd) {
        int count = 0;
        int i = 0;

        Set<String> propertyIDs = properties.keySet();

        for(String propertyID: propertyIDs){
        
            Property property =  properties.get(propertyID);

            if(property.getPriceUSD() <= maxUsd && property.getPriceUSD() >= minUsd){
            
                count++;
            }
        }

        if(count == 0){
            return null;
        }

        Property[] results = new Property[count];

        for(String propertyID: propertyIDs){
        
            Property property =  properties.get(propertyID);

            if(property.getPriceUSD() >= minUsd && property.getPriceUSD() <= maxUsd){
            
                results[i] = property;
                i++;

            }
        }
        return results;
    }
	
	public ArrayList<Address> getPropertiesOn(String streetName){
    
        ArrayList<Address> results = new ArrayList<>();

        Set<String> propertyIDs = properties.keySet();

        for(String propertyID: propertyIDs){
        
            Property property =  properties.get(propertyID);

            if(property.getAddress().getStreetName().equalsIgnoreCase(streetName)){
            
                results.add(property.getAddress());
            }
        }

        if(results.size() == 0){
        
            return new ArrayList<Address>();
        }

        return results;
    }
	
	 public HashMap<String, Property> getPropertiesWithBedrooms(int minBedrooms, int maxBedrooms){
	        HashMap<String, Property> results = new HashMap<>();

	        Set<String> propertyIDs = properties.keySet();

	        for(String propertyID: propertyIDs){
	       
	            Property property =  properties.get(propertyID);

	            if(property.getNumOfBedrooms() >= minBedrooms && property.getNumOfBedrooms() <= maxBedrooms){
	           
	                results.put(property.getPropertyID(), property);
	            }
	        }

	        if(results.size() == 0){
	       
	            return null;
	        }

	        return results;
	    }
	 
	 public ArrayList<Property> getPropertiesOfType(final String propertyType) {
			ArrayList<Property> results = new ArrayList<>();

			for (String key : properties.keySet()) {

				Property prop = properties.get(key);

				if (prop.getType().equalsIgnoreCase(propertyType)) {

					results.add(prop);
				}

			}

			return results;
		}
}

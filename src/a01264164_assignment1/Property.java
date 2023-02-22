package a01264164_assignment1;

public class Property {
	private double priceUSD;
	private Address address;
	private int numOfBedrooms;
	private boolean swimmingPool;
	private String Type;
	private String propertyID;
	
	public static final int MIN_BEDROOMS = 1;
	public static final int MAX_BEDROOMS = 20;
	public static final int MIN_PROPERTY_ID_LENGTH = 1; 
	public static final int MAX_PROPERTY_ID_LENGTH = 6;
	
	public Property(double priceUSD, Address address, int numOfBedrooms, boolean swimmingPool, String type,
			String propertyID) {
		super();
		
		if (priceUSD < 0.0) {
			throw new IllegalArgumentException("Invilad price in usd");
		}
		
		if (address == null) {
			throw new NullPointerException("Address is null");
		}
		
		if (numOfBedrooms < MIN_BEDROOMS || numOfBedrooms > MAX_BEDROOMS) {
			throw new IllegalArgumentException("Invalid number of bedrooms");
		}
		
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		
		if (!type.equalsIgnoreCase("residence") && !type.equalsIgnoreCase("commercial") && !type.equalsIgnoreCase("retail")) {
			throw new IllegalArgumentException("Invalid type");
		}
		
		if (propertyID.length() < MIN_PROPERTY_ID_LENGTH || propertyID.length() > MAX_PROPERTY_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid property length");
		}
		
		this.priceUSD = priceUSD;
		this.address = address;
		this.numOfBedrooms = numOfBedrooms;
		this.swimmingPool = swimmingPool;
		Type = type;
		this.propertyID = propertyID;
		
	}
	public double getPriceUSD() {
		return priceUSD;
	}
	public Address getAddress() {
		return address;
	}
	public int getNumOfBedrooms() {
		return numOfBedrooms;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public String getType() {
		return Type;
	}
	public String getPropertyID() {
		return propertyID;
	}
	public void setPriceUSD(double priceUSD) {
		this.priceUSD = priceUSD;
	}
	@Override
	public String toString() {
		return "Property [priceUSD=" + priceUSD + ", address=" + address + ", numOfBedrooms=" + numOfBedrooms
				+ ", swimmingPool=" + swimmingPool + ", Type=" + Type + ", propertyID=" + propertyID + "]";
	}
	
	
}

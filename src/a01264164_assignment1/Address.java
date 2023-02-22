package a01264164_assignment1;

public class Address {
	private String unitNumber;
	private int streetNumber;
	private String streetName;
	private String postalCode;
	private String city;
	
	public static final int MIN_UNIT_NUMBER = 1;
    public static final int MAX_UNIT_NUMBER= 4;

    public static final int MIN_STREET_NUMBER = 0;
    public static final int MAX_STREET_NUMBER = 999999;

    public static final int MIN_STREET_NAME = 1;
    public static final int MAX_STREET_NAME = 20;

    public static final int MIN_POSTAL_CODE = 5;
    public static final int MAX_POSTAL_CODE = 6;

    public static final int MIN_CITY = 1;
    public static final int MAX_CITY = 30;
	
	
	public Address(String unitNumber, int streetNumber, String streetName, String postalCode, String city) {
		super();
		
		
		
		if (streetName == null) {
			throw new NullPointerException("streetName Null");
		}
		
		if (postalCode == null) {
			throw new NullPointerException("streetName Null");
		}
		
		if (city == null) {
			throw new NullPointerException("city Null");
		}
		
		if(unitNumber != null) {
			if (unitNumber.length() < MIN_UNIT_NUMBER || unitNumber.length() > MAX_UNIT_NUMBER) {
				throw new IllegalArgumentException("Invalid unit number");
			}
		} 
			
		
		if (streetNumber < MIN_STREET_NUMBER || streetNumber > MAX_STREET_NUMBER) {
			throw new IllegalArgumentException("Invalid streetNumber");
		}
		
		if (streetName.length() < MIN_STREET_NAME || streetName.length() > MAX_STREET_NAME) {
			throw new IllegalArgumentException("Invalid streetName");
		}
		
		if (postalCode.length() < MIN_POSTAL_CODE || postalCode.length() > MAX_POSTAL_CODE) {
			throw new IllegalArgumentException("Invalid postalCode");
		}
		
		if (city.length() < MIN_CITY || city.length() > MAX_CITY) {
			throw new IllegalArgumentException("Invalid city");
		}
		
		this.unitNumber = unitNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
		
	}
	
	public String getUnitNumber() {
		return unitNumber;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return "Address [unitNumber=" + unitNumber + ", streetNumber=" + streetNumber + ", streetName=" + streetName
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}
}

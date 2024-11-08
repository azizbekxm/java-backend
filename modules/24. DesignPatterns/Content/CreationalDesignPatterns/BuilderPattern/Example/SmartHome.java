package Creational.BuilderDesignPattern;

public class SmartHome {
	private String name;
	private int serialNumber;
	private String addressName;
	private String addressNumber;
	private String city;
	private String country;
	private String postalCode;
	private int light1PortNum;
	private int light2PortNum;
	private int door1PortNum;
	private int door2PortNum;
	private int microwavePortNum;
	private int tvPortNum;
	private int waterHeaterPortNum;

	SmartHome(String name, int serialNumber, String addressName, String addressNumber, String city, String country,
			String postalCode, int light1PortNum, int light2PortNum, int door1PortNum, int door2PortNum,
			int microwavePortNum, int tvPortNum, int waterHeaterPortNum) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.addressName = addressName;
		this.addressNumber = addressNumber;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.light1PortNum = light1PortNum;
		this.light2PortNum = light2PortNum;
		this.door1PortNum = door1PortNum;
		this.door2PortNum = door2PortNum;
		this.microwavePortNum = microwavePortNum;
		this.tvPortNum = tvPortNum;
		this.waterHeaterPortNum = waterHeaterPortNum;
	}

	public static SmartHome.SmartHomeBuilder builder() {
		return new SmartHome.SmartHomeBuilder();
	}

	public String getName() {
		return this.name;
	}

	public int getSerialNumber() {
		return this.serialNumber;
	}

	public String getAddressName() {
		return this.addressName;
	}

	public String getAddressNumber() {
		return this.addressNumber;
	}

	public String getCity() {
		return this.city;
	}

	public String getCountry() {
		return this.country;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public int getLight1PortNum() {
		return this.light1PortNum;
	}

	public int getLight2PortNum() {
		return this.light2PortNum;
	}

	public int getDoor1PortNum() {
		return this.door1PortNum;
	}

	public int getDoor2PortNum() {
		return this.door2PortNum;
	}

	public int getMicrowavePortNum() {
		return this.microwavePortNum;
	}

	public int getTvPortNum() {
		return this.tvPortNum;
	}

	public int getWaterHeaterPortNum() {
		return this.waterHeaterPortNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setLight1PortNum(int light1PortNum) {
		this.light1PortNum = light1PortNum;
	}

	public void setLight2PortNum(int light2PortNum) {
		this.light2PortNum = light2PortNum;
	}

	public void setDoor1PortNum(int door1PortNum) {
		this.door1PortNum = door1PortNum;
	}

	public void setDoor2PortNum(int door2PortNum) {
		this.door2PortNum = door2PortNum;
	}

	public void setMicrowavePortNum(int microwavePortNum) {
		this.microwavePortNum = microwavePortNum;
	}

	public void setTvPortNum(int tvPortNum) {
		this.tvPortNum = tvPortNum;
	}

	public void setWaterHeaterPortNum(int waterHeaterPortNum) {
		this.waterHeaterPortNum = waterHeaterPortNum;
	}

	public String toString() {
		return "SmartHome(name=" + this.getName() + ", serialNumber=" + this.getSerialNumber() + ", addressName="
				+ this.getAddressName() + ", addressNumber=" + this.getAddressNumber() + ", city=" + this.getCity()
				+ ", country=" + this.getCountry() + ", postalCode=" + this.getPostalCode() + ", light1PortNum="
				+ this.getLight1PortNum() + ", light2PortNum=" + this.getLight2PortNum() + ", door1PortNum="
				+ this.getDoor1PortNum() + ", door2PortNum=" + this.getDoor2PortNum() + ", microwavePortNum="
				+ this.getMicrowavePortNum() + ", tvPortNum=" + this.getTvPortNum() + ", waterHeaterPortNum="
				+ this.getWaterHeaterPortNum() + ")";
	}

	public static class SmartHomeBuilder {
		private String name;
		private int serialNumber;
		private String addressName;
		private String addressNumber;
		private String city;
		private String country;
		private String postalCode;
		private int light1PortNum;
		private int light2PortNum;
		private int door1PortNum;
		private int door2PortNum;
		private int microwavePortNum;
		private int tvPortNum;
		private int waterHeaterPortNum;

		SmartHomeBuilder() {
		}

		public SmartHome.SmartHomeBuilder name(String name) {
			this.name = name;
			return this;
		}

		public SmartHome.SmartHomeBuilder serialNumber(int serialNumber) {
			this.serialNumber = serialNumber;
			return this;
		}

		public SmartHome.SmartHomeBuilder addressName(String addressName) {
			this.addressName = addressName;
			return this;
		}

		public SmartHome.SmartHomeBuilder addressNumber(String addressNumber) {
			this.addressNumber = addressNumber;
			return this;
		}

		public SmartHome.SmartHomeBuilder city(String city) {
			this.city = city;
			return this;
		}

		public SmartHome.SmartHomeBuilder country(String country) {
			this.country = country;
			return this;
		}

		public SmartHome.SmartHomeBuilder postalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public SmartHome.SmartHomeBuilder light1PortNum(int light1PortNum) {
			this.light1PortNum = light1PortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder light2PortNum(int light2PortNum) {
			this.light2PortNum = light2PortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder door1PortNum(int door1PortNum) {
			this.door1PortNum = door1PortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder door2PortNum(int door2PortNum) {
			this.door2PortNum = door2PortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder microwavePortNum(int microwavePortNum) {
			this.microwavePortNum = microwavePortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder tvPortNum(int tvPortNum) {
			this.tvPortNum = tvPortNum;
			return this;
		}

		public SmartHome.SmartHomeBuilder waterHeaterPortNum(int waterHeaterPortNum) {
			this.waterHeaterPortNum = waterHeaterPortNum;
			return this;
		}

		public SmartHome build() {
			return new SmartHome(this.name, this.serialNumber, this.addressName, this.addressNumber, this.city,
					this.country, this.postalCode, this.light1PortNum, this.light2PortNum, this.door1PortNum,
					this.door2PortNum, this.microwavePortNum, this.tvPortNum, this.waterHeaterPortNum);
		}

		public String toString() {
			return "SmartHome.SmartHomeBuilder(name=" + this.name + ", serialNumber=" + this.serialNumber
					+ ", addressName=" + this.addressName + ", addressNumber=" + this.addressNumber + ", city="
					+ this.city + ", country=" + this.country + ", postalCode=" + this.postalCode + ", light1PortNum="
					+ this.light1PortNum + ", light2PortNum=" + this.light2PortNum + ", door1PortNum="
					+ this.door1PortNum + ", door2PortNum=" + this.door2PortNum + ", microwavePortNum="
					+ this.microwavePortNum + ", tvPortNum=" + this.tvPortNum + ", waterHeaterPortNum="
					+ this.waterHeaterPortNum + ")";
		}
	}
}

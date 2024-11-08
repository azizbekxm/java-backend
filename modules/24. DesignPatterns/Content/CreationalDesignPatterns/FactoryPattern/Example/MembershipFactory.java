package Creational.FactoryDesignPattern;

public class MembershipFactory {
	public Membership createMembership(String period) {
		if (period == null || period.isEmpty())
			return null;
		if ("MONTHLY".equalsIgnoreCase(period))
			return new Monthly();
		if ("QUARTERLY".equalsIgnoreCase(period))
			return new Quarterly();
		if ("ANNUAL".equalsIgnoreCase(period))
			return new Annual();
		return null;
	}

}

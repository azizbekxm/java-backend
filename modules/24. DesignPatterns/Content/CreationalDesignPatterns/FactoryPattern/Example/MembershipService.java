package Creational.FactoryDesignPattern;

public class MembershipService {
	public static void main(String... args) {
		MembershipFactory memberFactory = new MembershipFactory();
		Membership membership = memberFactory.createMembership("ANNUAL");
		membership.payment();
	}
}

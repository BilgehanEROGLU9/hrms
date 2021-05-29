package hrmsJava.hrms.core.utilities.validation.email;

public class EmailActivationManager implements EmailActivationService {

	@Override
	public boolean mailSend(String eMail) {
		System.out.println("Aktivasyon kodu mail olarak gönderildi.");
		return true;
	}

}

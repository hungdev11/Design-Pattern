package structural.facade;

/**
 * Facade provide a unified interface to a set of interface in a subsystem
 * Facade defines a higher-level interface that makes the subsystem easier to use by clients.
 *
 */
public class Facade {
    public static void main(String[] args) {
        ShopFacade.getInstance().buyProductByCashWithFreeShipping("abc@gmail.com");
        ShopFacade.getInstance().buyProductByCreditCardWithStandardShipping("aloha@yahoo.vn", "1900100-biet");
    }
}
class ShopFacade {
    private static final ShopFacade INSTANCE = new ShopFacade();
    private AccountService accountService;
    private EmailService emailService;
    private SmsService smsService;
    private ShippingService shippingService;
    private PaymentService paymentService;
    private ShopFacade () {
        accountService = new AccountService();
        paymentService = new PaymentService();
        shippingService = new ShippingService();
        emailService = new EmailService();
        smsService = new SmsService();
    }
    public static ShopFacade getInstance() {
        return INSTANCE;
    }
    public void buyProductByCashWithFreeShipping(String email) {
        accountService.getAccount(email);
        paymentService.payByCash();
        shippingService.freeShipping();
        emailService.sendEmail(email);
        System.out.println("Done\n");
    }

    public void buyProductByCreditCardWithStandardShipping(String email, String mobilePhone) {
        accountService.getAccount(email);
        paymentService.payByCreditCard();
        shippingService.standardShipping();
        emailService.sendEmail(email);
        smsService.sendSMS(mobilePhone);
        System.out.println("Done\n");
    }
}
class AccountService {
    public void getAccount(String email) {
        System.out.println("Getting account of email "+email+ " ....");
    }
}
class PaymentService {
    public void payByPaypal() {
        System.out.println("Pay using paypal");
    }
    public void payByCreditCard() {
        System.out.println("Pay using credit card");
    }
    public void payByEBankingAccount() {
        System.out.println("Pay using E-banking account");
    }
    public void payByCash() {
        System.out.println("Pay using cash");
    }
}
class ShippingService {
    public void freeShipping() {
        System.out.println("Free shipping");
    }
    public void standardShipping() {
        System.out.println("Standard shipping");
    }
    public void expressShipping() {
        System.out.println("Express Shipping");
    }
}
class EmailService {
    public void sendEmail(String to) {
        System.out.println("Sending email to " + to + " ...");
    }
}
class SmsService {
    public void sendSMS(String phoneNumber) {
        System.out.println("Sending sms to " + phoneNumber);
    }
}



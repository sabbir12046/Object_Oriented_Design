//*************************************************************************
// TITLE : A JAVA program to demonstrate Dependency Inversion Principle .
// AUTHOR : MD Sabbir Hasan, UNDERGRADUATE STUDENT (2ND YEAR) Of KHULNA UNIVERSITY
//*************************************************************************


import java.util.ArrayList;
import java.util.List;

/**
 * Interface defining the behavior of a notification service.
 */
interface NotificationService {
    void sendNotification(String message);
}

/**
 * Email notification service implementation.
 */
class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

/**
 * SMS notification service implementation.
 */
class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

/**
 * Class representing a user.
 */
class User {
    private String name;
    private String email;
    private String phoneNumber;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

/**
 * Class representing a notification sender.
 */
class NotificationSender {
    private NotificationService notificationService;

    public NotificationSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Sends a notification to a user.
     *
     * @param user    The user to send the notification to
     * @param message The notification message
     */
    public void sendNotification(User user, String message) {
        if (user.getEmail() != null) {
            notificationService.sendNotification("Email sent to " + user.getName() + " at " + user.getEmail() + ": " + message);
        } else if (user.getPhoneNumber() != null) {
            notificationService.sendNotification("SMS sent to " + user.getName() + " at " + user.getPhoneNumber() + ": " + message);
        } else {
            System.out.println("Unable to send notification to " + user.getName() + ": No email or phone number provided.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("John", "john@example.com", null);
        User user2 = new User("Alice", null, "1234567890");

        // Create notification services
        NotificationService emailService = new EmailNotificationService();
        NotificationService smsService = new SMSNotificationService();

        // Create notification senders
        NotificationSender emailSender = new NotificationSender(emailService);
        NotificationSender smsSender = new NotificationSender(smsService);

        // Send notifications
        emailSender.sendNotification(user1, "Welcome to our platform!");
        smsSender.sendNotification(user2, "Your order has been shipped.");
    }
}
{
}

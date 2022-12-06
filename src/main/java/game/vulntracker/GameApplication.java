package game.vulntracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 990, 730);
        stage.setTitle("CPSC329 Final Project: Security Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static ArrayList<Question> questionList;

    public static void main(String[] args) {
        questionList = new ArrayList<Question>();

        String qs1 = "You’ve been tasked with creating certain requirements for setting company passwords. What requirements offer the best security?";
        String f1 = "Setting no requirement is a risk as this means passwords could be common passwords. Thus adding requirements similar to the NIST password guidelines such as minimum password length as well as this having a combination of numbers, capital/lower case letters and symbols will increase attack time.";
        String[] a1 = {"A. No requirements are needed to offer security ", "B. Set the recruitment to have at least one number and one Capital letter ", "C. Set the recruitment to have the password length of at least 12 letters as well as at least one number, one Capital letter and one symbol. Requirements similar to the NIST password guidelines ", "D. Set the recruitment to have the password length of at least 12 letters "};
        int[] r1 = {20, 10, 0, 10}; // risk values
        String i1 = "/images/q1.jpg";
        Question q1 = new Question(qs1, f1, a1, r1, 2, i1);
        questionList.add(q1);

        String qs2 = "You’ve been tasked with storing created passwords on the company server. What is your method for encrypting passwords?";
        String f2 = "Plaintext involves no encryption so is very easy to access if hacked. MD-5 has been cracked, so it is easy to decrypt, which is unsafe. SHA-256 is currently the best and most common hash function used. Salting the passwords before hashing using SHA-256 is the best option as salting ensures that if two people use the same passwords, the passwords will be stored as two different strings of characters rather than the same ones.";
        String[] a2 = {"A. No method, just store the passwords as plaintext.", "B. You could hash the passwords using the SHA-256 hash function ", "C. You could hash the passwords using the MD5 hash function. ", "D. You could hash the passwords using the SHA-256 hash function with salt "};
        int[] r2 = {20, 10, 10, 0}; // risk values
        String i2 = "/images/q2.jpg";
        Question q2 = new Question(qs2, f2, a2, r2, 3, i2);
        questionList.add(q2);

        String qs3 = "Your company plans to introduce measures to authenticate users before they access the company’s systems. What methods do you take to authenticate users?";
        String f3 = "All 3 of the measures above are valid authentication methods. However, it is best to combine multiple different authentication methods to ensure maximum security.";
        String[] a3 = {"A. Passwords", "B. Location of the device", "C. Biometrics (ex: facial recognition)", "D. All of the above"};
        int[] r3 = {10, 20, 10, 0}; // risk values
        String i3 = "/images/q3.jpg";
        Question q3 = new Question(qs3, f3, a3, r3, 3, i3);
        questionList.add(q3);

        String qs4 = "What group of people should have access to sensitive company data?";
        String f4 = "No one outside the company should be given sensitive company data. People at the company may seem trustworthy, however there is still a risk that the information could be altered or leaked. That's why none of the above mentioned groups should have access to sensitive data. Only people like the CEO should have access to sensitive data.";
        String[] a4 = {"A. Your team leader", "B. Fellow employees", "C. People outside the company", "D. None of the above"};
        int[] r4 = {10, 10, 20, 0}; // risk values
        String i4 = "/images/q4.jpg";
        Question q4 = new Question(qs4, f4, a4, r4, 3, i4);
        questionList.add(q4);

        String qs5 = "The company accountant is requesting permission for a budget file containing employee salary. What type of permissions should you give them?";
        String f5 = "You should not allow someone at that position to alter salary pay, therefore they should not be able to have “write” permissions for the budget file as this could lead to fraud when audited. The “create” permission is a trick question as there's no permission called create. While not posing a threat, it shows a lack of knowledge in file permissions. “Read” is the best choice as it allows them to access the information they need without giving more control than necessary.";
        String[] a5 = {"A. Write", "B. Read", "C. Create", "D. Both read and write"};
        int[] r5 = {20, 0, 10, 20}; // risk values
        String i5 = "/images/q5.jpg";
        Question q5 = new Question(qs5, f5, a5, r5, 1, i5);
        questionList.add(q5);

        String qs6 = "You have been tasked with implementing a customer side security system to decrease bots on the company website. What type of security feature do you implement?";
        String f6 = "Doing nothing in this situation is the worst choice adding risk. More secure passwords would still increase security however it wouldn’t prevent what you were tasked to do. Arithmetic questions would prevent some bots but they could easily get around it. Therefore graphical passwords is the best answer. Image verification is a good way to prevent bots.";
        String[] a6 = {"A. More secure password requirements", "B. Nothing can be done to prevent this", "C. Graphical passwords such as image verification", "D. Arithmetic question"};
        int[] r6 = {10, 20, 0, 10}; // risk values
        String i6 = "/images/q6.jpg";
        Question q6 = new Question(qs6, f6, a6, r6, 2, i6);
        questionList.add(q6);

        String qs7 = "Your company was just involved with a major data breach that led to the personal information of customers being leaked. What steps should the security team take?";
        String f7 = "If the customers’ personal information has been, you are required to inform the public about what data was leaked and how it was leaked. It is also best to fix the issue and add further enhancements to the security system to improve it.";
        String[] a7 = {"A. Reacting to the data breach will attract negative attention", "B. Put out a patch and ask customers for feedback regarding their data", "C. Overhaul the security system to a higher-level control policy", "D. Put out a patch to fix the issue that led to the leak, inform the public of the data breach (what data was leaked and how) and make further improvements to the security system"};
        int[] r7 = {20, 10, 10, 0}; // risk values
        String i7 = "/images/q7.jpg";
        Question q7 = new Question(qs7, f7, a7, r7, 3, i7);
        questionList.add(q7);

        String qs8 = "An employee you work with has just lost their keycard. What should the company’s policy on lost keycards be?";
        String f8 = "Not giving employees opens risk as they are not able to perform the tasks they need which might be directly related to security. Contrasting these cards should not just be given away without a process. Checking for correct permission is important but misses the important step of identification. This is why Identifying and checking permission is the correct answer.";
        String[] a8 = {"A. Check if they have been given permissions to access those areas.", "B. Simply get them a replacement", "C. Have them correctly identify themselves and check if they have been given permissions to access those areas", "D. No second chances"};
        int[] r8 = {10, 20, 0, 20}; // risk values
        String i8 = "/images/q8.jpg";
        Question q8 = new Question(qs8, f8, a8, r8, 2, i8);
        questionList.add(q8);

        String qs9 = "Your company was just involved with a major data breach that led to the personal information of customers being leaked. What type of people do you seek for assistance?";
        String f9 = "When a data breach occurs, it is best to let the people equipped to handle the issue at your company deal with the issue. An example would be your security team members.";
        String[] a9 = {"A. A friend who doesn’t work in the company", "B. Your security team members", "C. Fellow employees", "D. No one. Try and figure it out on your own"};
        int[] r9 = {20, 0, 10, 20}; // risk values
        String i9 = "/images/q9.jpg";
        Question q9 = new Question(qs9, f9, a9, r9, 1, i9);
        questionList.add(q9);

        String qs10 = "Which of these is the most secure authentication method?";
        String f10 = "Just usernames is not nearly enough to make a system secure. Answers to secret security questions and two-factor authentication are on the right track but more can be done. That’s why multi-step authentication is the correct answer.";
        String[] a10 = {"A. Just usernames", "B. Answers to secret security questions", "C. Multi-step authentication", "D. Two-factor authentication"};
        int[] r10 = {20, 10, 0, 10}; // risk values
        String i10 = "/images/q10.jpg";
        Question q10 = new Question(qs10, f10, a10, r10, 2, i10);
        questionList.add(q10);

        String qs11 = "How can you prevent viruses on your device?";
        String f11 = "You will not be fine regardless, a virus might be hidden and you may not know it is on your device. While not going on websites or downloading files might prevent viruses it is unreasonable to never do this. There is a simple solution and that is to download a trusted antivirus such as Bitdefender.";
        String[] a11 = {"A. Have an antivirus", "B. Don't download files", "C. Don’t go on websites", "D. You’ll be fine regardless"};
        int[] r11 = {0, 10, 10, 20}; // risk values
        String i11 = "/images/q11.jpg";
        Question q11 = new Question(qs11, f11, a11, r11, 0, i11);
        questionList.add(q11);

        String qs12 = "You’ve recently been targeted by a ransomware attack. What is the best course action?";
        String f12 = "Due to the amount of money usually involved with ransomware attacks, it is best to raise the issue to the authorities so that the attack can properly be investigated and dealt with. The company dealing with the issue on their own via their security team within the regional laws may be able to deal with the attack, but will not lead to the perpetrators being caught, leading to the possibility of future attacks. Paying the ransom would only encourage this behavior.";
        String[] a12 = {"A. Take it to your security team.", "B. Pay the ransom", "C. Take the issue to the authorities.", "D. Deal with it yourself based on your regional laws."};
        int[] r12 = {10, 20, 0, 10}; // risk values
        String i12 = "/images/q12.jpg";
        Question q12 = new Question(qs12, f12, a12, r12, 2, i12);
        questionList.add(q12);


        String qs13 = "Your company has faced 50 DDOS attacks (influx in network traffic) in the last week resulting in an estimated 1.2M dollars in potential damages. You receive an email from CloudClare, a free DDOS mitigation company, who offer to fix this issue.";
        String f13 = "Since you are unsure if this is a legitimate e-mail, it is best to not respond to the offer by yourself (so do not accept or refuse the offer) and consult with the security team on how to respond to the offer.";
        String[] a13 = {"A. Consult with your security team.", "B. Refuse the offer.", "C. Accept and provide all the details they require.", "D. None of the above."};
        int[] r13 = {0, 10, 20, 10}; // risk values
        String i13 = "/images/q13.jpg";
        Question q13 = new Question(qs13, f13, a13, r13, 0, i13);
        questionList.add(q13);

        String qs14 = "The Company has just suffered from a DDOS attack. Based on your knowledge of cyber security, what is a DDOS attack (so that you may make the correct decisions to combat it)?";
        String f14 = "An attacker on the inside is called an insider threat attack. When an attacker attacks the system on the day of release it is called a 0-day attack. Social Engineering is when an attacker manipulates an employee into giving access to the system. Lastly DDOS attacks are when an attacker floods the system with traffic overwhelming it.";
        String[] a14 = {"A. When an attacker finds a way to flood the system with traffic overwhelming it.", "B. When the attackers manipulates an employee into giving access to the system ", "C. When the attackers attack the system on the exact day of a systems release before the security team has time to patch it.", "D. When the attacker is on the inside of the company stealing or altering data or code"};
        int[] r14 = {0, 20, 20, 20}; // risk values
        String i14 = "/images/q14.jpg";
        Question q14 = new Question(qs14, f14, a14, r14, 0, i14);
        questionList.add(q14);

        String qs15 = "Your CEO has requested an implementation of a firewall but asks that his personal home IP address be allowed through the firewall at all times. How do you respond to their request?";
        String f15 = "A firewall is necessary as it protects a company’s network from hackers. A personal device connected to a company's network can act as a gateway for hackers to infiltrate the system, especially if the personal device is not as secure as standard company devices. It would be safest to deny the CEO’s request. Adding the VPN, but using a VPN is a less safe option, but can also work well.";
        String[] a15 = {"A. Add the CEO’s IP address to the firewall exception list. ", "B. Deny the request of the CEO and explain that it poses a threat to the company’s security. ", "C. Add the CEO’s IP address, and set up a VPN for the CEO to use at home. ", "D. Don’t implement a firewall due to his request."};
        int[] r15 = {20, 0, 10, 20}; // risk values
        String i15 = "/images/q15.jpg";
        Question q15 = new Question(qs15, f15, a15, r15, 1, i15);
        questionList.add(q15);

        String qs16 = "Your company has purchased a new coffee machine for employee use and offered it to the company next door to use as well. The machine is connected to your network through Wi-Fi and therefore the company next door needs to connect to it. What do you do?";
        String f16 = "The coffee machine connected to the company’s network may provide an avenue for attackers to enter the system, therefore the Wi-Fi needs security measures. Allowing someone to freely connect to the Wi-Fi to use the coffee machine would mean connecting them to your company’s network, allowing them access to potentially sensitive information. Therefore, it is best to add restrictions so that people in your company have free access to the Wi-Fi, while the people in the next-door company can only access the Wi-Fi to use the coffee machine (so they cannot do anything else on the Wi-Fi). This is called access control.";
        String[] a16 = {"A. Deny access to the company next door. ", "B. Allow the company next door to have access to the Wi-Fi freely. ", "C. Restrict the next door company’s access to the Wi-Fi so they can only access the coffee machine.", "D. Remove all security measures on the Wi-Fi so the next door company has free access to the Wi-Fi."};
        int[] r16 = {10, 10, 0, 20}; // risk values
        String i16 = "/images/q16.jpg";
        Question q16 = new Question(qs16, f16, a16, r16, 2, i16);
        questionList.add(q16);

        String qs17 = "An email comes through with a suspicious name appearing to be trying to pose as your boss. They are asking you for important information or are sending you a file.";
        String f17 = "There is no reason to send a file to a suspicious person without alerting your boss first. Ignoring the email does create the possibility that it is your boss, as well as it is important to report the phish to someone. Responding to the email creates unnecessary risk, when emailing the person’s confirmed email is available.";
        String[] a17 = {"A. Send the information, your boss is vital in protecting the company from phishing. ", "B. Ignore the email.", "C. Respond to the email and request verification of their identity", "D. Reach out to your boss regarding the file request."};
        int[] r17 = {20, 10, 10, 0}; // risk values
        String i17 = "/images/q17.jpg";
        Question q17 = new Question(qs17, f17, a17, r17, 3, i17);
        questionList.add(q17);

        String qs18 = "How can you limit social engineering attacks at your company?";
        String f18 = "The most effective method at combating social engineering is informing employees about the types of attacks. Having a tight night group does nothing to prevent phishing type attacks. Working closely with a security team is helpful, but does not apply to this type of attack. Reforming the system is a drastic method to reduce social engineering and misses the user error involved in social engineering.";
        String[] a18 = {"A. Have regular security meetings discussing and teaching security issues.", "B. Host multiple teamwork activities to ensure a tight-knit group. ", "C. Have employees work closely and often with the security team on their tasks.", "D. Reform the security system to a stricter level of control. "};
        int[] r18 = {0, 20, 10, 10}; // risk values
        String i18 = "/images/q18.jpg";
        Question q18 = new Question(qs18, f18, a18, r18, 0, i18);
        questionList.add(q18);

        String qs19 = "Which types of control policy should a security system like a government agency employ?";
        String f19 = "Maintaining control and access to documents to a select few is essential to the level of security required. Employees do not need to view all documents, or even the ones they made to complete their work. Improving transparency is important, but not in this manner. Giving control based on roles can run into problems regarding types of information.";
        String[] a19 = {"A. All government employees are able to view their documents", "B. Centralizing access control to a select number of high-ranking employees", "C. Improve transparency by allowing the public to view documents.", "D. Giving access control based on roles of the employees."};
        int[] r19 = {20, 0, 20, 10}; // risk values
        String i19 = "/images/q19.jpg";
        Question q19 = new Question(qs19, f19, a19, r19, 1, i19);
        questionList.add(q19);

        String qs20 = "Your computer has been affected by a malware attack. Which is a malware and what is its correct description?";
        String f20 = "A phisher isn't a malware. Phishing however is an attack that can lead to malware. Phishing is an attack that entices/tricks people to input personal information. A worm is a Malware however its proper description is “a malware that seeks out new hosts through network connections, shared media, etc.";
        String[] a20 = {"A. A worm is a malware that burrows deep into files within a computer hiding.", "B. A worm is a malware that seeks out new hosts through network connections, shared media, etc.", "C. A phisher is a malware that entices you to input personal information.", "D. A phisher is a malware that finds a weak point and starts to delete files outwards from that point."};
        int[] r20 = {10, 0, 10, 20};
        String i20 = "/images/q20.jpg";
        Question q20 = new Question(qs20, f20, a20, r20, 1, i20);
        questionList.add(q20);

        String qs21 = "Which of these types of employee information should you keep private and secure?";
        String f21 = "Personal Identifiable information (PII) is anything that can be traced back to you. This can range from physical things like numbers, to attributes like voice and writing. All PII must be kept private and secure.";
        String[] a21 = {"A. Street address", "B. Handwriting", "C. Student number", "D. All of the above"};
        int[] r21 = {20, 20, 20, 0}; // risk values
        String i21 = "/images/q21.jpg";
        Question q21 = new Question(qs21, f21, a21, r21, 3, i21);
        questionList.add(q21);

        String qs22 = "You sign up for a website with your work email. What information could they now have about you?";
        String f22 = "Websites often use trackers to maintain information about the user. Age, occupation (in a general sense) and name are feasibly taken from the email and commonly tracked sites.";
        String[] a22 = {"A. Age", "B. Occupation", "C. Name", "D. All of the above"};
        int[] r22 = {10, 10, 20, 0}; // risk values
        String i22 = "/images/q22.jpg";
        Question q22 = new Question(qs22, f22, a22, r22, 3, i22);
        questionList.add(q22);

        String qs23 = "You notice your work keyboard is now attached to an unfamiliar USB device. The keyboard still works like normal. What do you do?";
        String f23 = "Doing nothing and continuing to use your computer as normal creates an invitation for an attack. Unplugging the USB device  can still result in the breach remaining. Reporting the device with your keyboard invites risk that can be easily avoided. Asking IT about the correct way to remove it without using the device is the lowest risk possible.";
        String[] a23 = {"A. Nothing. It was probably just the IT department. ", "B. Try unplugging the USB device.", "C. Inquire about the device to IT from a different keyboard", "D. Create a ticket and report the device"};
        int[] r23 = {20, 10, 0, 10}; // risk values
        String i23 = "/images/q23.jpg";
        Question q23 = new Question(qs23, f23, a23, r23, 2, i23);
        questionList.add(q23);

        String qs24 = "After several password breaches, the CEO tasks you with the best option to improve password security. Which option do you choose?";
        String f24 = "You can always increase password security, it just depends on how far you would like to go. Changing passwords and password strength is important, but making sure your passwords are encrypted with hashing creates an immense amount of security.";
        String[] a24 = {"A. Encryption such as Hashing  ", "B. Periodically changing passwords. ", "C. You can’t.", "D. Mandating a password strength"};
        int[] r24 = {0, 10, 20, 10}; // risk values
        String i24 = "/images/q24.jpg";
        Question q24 = new Question(qs24, f24, a24, r24, 0, i24);
        questionList.add(q24);

        String qs25 = "From an attacking point of view, what would be the best attack to target a company's password storage and notice it is in plaintext?  ";
        String f25 = "Since the passwords are in plaintext, running through a list of passwords will work eventually, since it is all stored in plaintext. This is a brute force attack. Viruses are not needed for this level of security, but can be a good bet at removing the firewall. Phishing will only work if the employee inputs their password themselves and does not involve any storage.";
        String[] a25 = {"A. A phishing attack to get the access from a non-suspicious medium. ", "B. Create a virus through a keylogger that can take down the firewall ", "C. Have a program run though passwords until a hit", "D. Disguise yourself as an employee and try to shoulder-surf a password."};
        int[] r25 = {10, 10, 0, 20}; // risk values
        String i25 = "/images/q25.jpg";
        Question q25 = new Question(qs25, f25, a25, r25, 2, i25);
        questionList.add(q25);

        String qs26 = "You are trying to mock attack your company to find weak spots in security. You have noticed there might be a way through their fingerprint biometric. What attack is best? ";
        String f26 = "Disrupting the hardware can sometimes fail due to multiple levels of security existing to prevent common hardware failures. Targeting this is inconsistent. Adding a personal identifying measure like your fingerprint introduces more risk variables than necessary. Breaching the data and hijacking a stored key is the most common and safest method.";
        String[] a26 = {"A. Use parafilm on objects an employee at the company has touched (such as a cup) to create an identical mold of an employee’s fingerprint. ", "B. Create a virus that can go through the biometrics and disrupt the feature recognition. ", "C. Breach the biometric data storage and use registered biometrics", "D. Create a trojan to infiltrate and add your fingerprint to the database."};
        int[] r26 = {20, 10, 0, 10}; // risk values
        String i26 = "/images/q26.jpg";
        Question q26 = new Question(qs26, f26, a26, r26, 2, i26);
        questionList.add(q26);

        String qs27 = "You notice that a USB has been plugged into your CPU that you do not remember plugging in. You take it to the security team who determine that it is a USB keylogger that detects the keys typed on your keyboard. What sensitive information could be at risk due to keylogging? ";
        String f27 = "A keylogger detects and records every key that is typed into your keyboard. Therefore any information that was typed (such as passwords, personal information and company information) is at risk of being recorded and leaked. ";
        String[] a27 = {"A. Passwords", "B. Personal information ", "C. Confidential company information", "D. All of the above  "};
        int[] r27 = {20, 20, 20, 0}; // risk values
        String i27 = "/images/q27.jpg";
        Question q27 = new Question(qs27, f27, a27, r27, 3, i27);
        questionList.add(q27);

        String qs28 = "Which would not be a way a keylogger could be installed on your computer? (ex: via phishing emails). ";
        String f28 = "Keyloggers can be hardware (such as a plugged USB or an overlay on top of your computer) or software (i.e. a file). A device that records your screen is a risk to your security, but is not a keylogger.";
        String[] a28 = {"A. Through a downloadable file sent through an email. ", "B. Through a device plugged into your CPU that records your screen.", "C. Through a USB plugged into a USB port on your CPU..", "D. Through an overlay on top of your keyboard."};
        int[] r28 = {20, 0, 20, 20}; // risk values
        String i28 = "/images/q28.jpg";
        Question q28 = new Question(qs28, f28, a28, r28, 1, i28);
        questionList.add(q28);

        String qs29 = "How could you prevent shoulder surfing at your company? ";
        String f29 = "Setting rules does not prevent something such as shoulder surfing. Even if only employees will shoulder surf, not all employees should have access to all information. Restricting computers to cubicles or separate rooms can help prevent this, but is not an ideal situation. Using privacy scenes makes it more difficult to view screens from other angles and is the best option to prevent shoulder surfing.";
        String[] a29 = {"A. Privacy screens on company devices", "B. Keeping computers in cubicles.", "C. Creating a “No shoulder surfing” rule.", "D. Nothing. Only your employees can access the computers anyways. "};
        int[] r29 = {0, 10, 10, 20}; // risk values
        String i29 = "/images/q29.jpeg";
        Question q29 = new Question(qs29, f29, a29, r29, 0, i29);
        questionList.add(q29);

        String qs30 = "Which of these are objectives of security?";
        String f30 = "The 3 objectives of security are confidentiality, integrity and availability. A computer is said to be secure if all 3 objectives are met. Confidentiality means restricting who has access to what information. Integrity is protecting against the information being changed when it is not supposed to. Availability means that access to the information should be available at all times. ";
        String[] a30 = {"A. Confidentiality ", "B. Integrity ", "C. Availability ", "D. All of the above  "};
        int[] r30 = {20, 20, 20, 0}; // risk values
        String i30 = "/images/q30.jpg";
        Question q30 = new Question(qs30, f30, a30, r30, 3, i30);
        questionList.add(q30);

        Collections.shuffle(questionList);
        for (int i = questionList.size()-1; i > 14; i--) {
            questionList.remove(i);
        }

        launch();
    }
}
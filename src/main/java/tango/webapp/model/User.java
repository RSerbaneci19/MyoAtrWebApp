package tango.webapp.model;

import javax.persistence.*;

/**
 * Created by rserbaneci on 21-Nov-16.
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String type;
    @Column(name = "workshops", columnDefinition = "LONGTEXT")
    private String workshops;
    private String paymentConfirmation = "N/A";
    private String soloOrPartner;
    private String partnerName;
    private String adminUser;
    private String adminPassword;
    private String totalAmount;
    private String totalAmountRon;

    public String getTotalAmountRon() {
        return totalAmountRon;
    }

    public void setTotalAmountRon(String totalAmountRon) {
        this.totalAmountRon = totalAmountRon;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkshops() {
        return workshops;
    }

    public void setWorkshops(String workshops) {
        this.workshops = workshops;
    }

    public String getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(String paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getSoloOrPartner() {
        return soloOrPartner;
    }

    public void setSoloOrPartner(String soloOrPartner) {
        this.soloOrPartner = soloOrPartner;
    }

}
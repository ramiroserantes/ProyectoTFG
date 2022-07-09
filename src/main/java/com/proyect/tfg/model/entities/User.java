package com.proyect.tfg.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    public enum WebRole {ADMIN, MODERATOR, USER};

    @Id
    private Long id;

    private String userName;
    private String passWord;
    private String email;
    private WebRole webRole;
    private Long coins;
    private Long premiumCoins;
    private Long donatedMoney;
    private LocalDateTime registeredDate;
    private LocalDateTime lasTimeOnline;
    private int reputation;
    private int vipRole;
    private Long rank;

    private String link;
    private boolean verified;

    public User() {}

    public User(Long id, String userName, String passWord, String email, WebRole webRole, Long coins, Long premiumCoins,
                Long donatedMoney, LocalDateTime registeredDate, LocalDateTime lasTimeOnline, int reputation, int vipRole,
                Long rank, String link, boolean verified) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.webRole = webRole;
        this.coins = coins;
        this.premiumCoins = premiumCoins;
        this.donatedMoney = donatedMoney;
        this.registeredDate = registeredDate;
        this.lasTimeOnline = lasTimeOnline;
        this.reputation = reputation;
        this.vipRole = vipRole;
        this.rank = rank;
        this.link = link;
        this.verified = verified;
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassWord() { return passWord; }

    public void setPassWord(String passWord) { this.passWord = passWord; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public WebRole getWebRole() { return webRole; }

    public void setWebRole(WebRole webRole) { this.webRole = webRole; }

    public Long getCoins() { return coins; }

    public void setCoins(Long coins) { this.coins = coins; }

    public Long getPremiumCoins() { return premiumCoins; }

    public void setPremiumCoins(Long premiumCoins) { this.premiumCoins = premiumCoins; }

    public Long getDonatedMoney() { return donatedMoney; }

    public void setDonatedMoney(Long donatedMoney) { this.donatedMoney = donatedMoney; }

    public LocalDateTime getRegisteredDate() { return registeredDate; }

    public void setRegisteredDate(LocalDateTime registeredDate) { this.registeredDate = registeredDate; }

    public LocalDateTime getLasTimeOnline() { return lasTimeOnline; }

    public void setLasTimeOnline(LocalDateTime lasTimeOnline) { this.lasTimeOnline = lasTimeOnline; }

    public int getReputation() { return reputation; }

    public void setReputation(int reputation) { this.reputation = reputation; }

    public int getVipRole() { return vipRole; }

    public void setVipRole(int vipRole) { this.vipRole = vipRole; }

    public Long getRank() { return rank; }

    public void setRank(Long rank) { this.rank = rank; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public boolean isVerified() { return verified; }

    public void setVerified(boolean verified) { this.verified = verified; }
}

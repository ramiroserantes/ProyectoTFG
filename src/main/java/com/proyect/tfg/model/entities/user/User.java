package com.proyect.tfg.model.entities.user;

import com.proyect.tfg.model.entities.order.Order;
import com.proyect.tfg.model.entities.purchase.Purchase;
import com.proyect.tfg.model.entities.reply.Reply;
import com.proyect.tfg.model.entities.shoppingCart.ShoppingCart;
import com.proyect.tfg.model.entities.topic.Topic;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    public enum WebRole {ADMIN, MODERATOR, USER};

    private Long id;

    private String userName;
    private String passWord;
    private String email;
    private WebRole webRole;
    private Long coins;
    private Long premiumCoins;
    private BigDecimal donatedMoney;
    private LocalDateTime registeredDate;
    private LocalDateTime lastTimeOnline;
    private int reputation;
    private int vipRole;
    private Long rank;

    private String link;
    private boolean verified;

    private Set<Order> orders = new HashSet<>();
    private Set<Purchase> purchases = new HashSet<>();
    private Set<Reply> replies = new HashSet<>();
    private Set<Topic> topics = new HashSet<>();
    private Set<Stats> stats = new HashSet<>();
    private ShoppingCart shoppingCart;

    public User() {}

    public User(String userName, String passWord, String email, WebRole webRole, Long coins, Long premiumCoins,
                BigDecimal donatedMoney, LocalDateTime registeredDate, LocalDateTime lastTimeOnline, int reputation, int vipRole,
                Long rank, String link, boolean verified) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.webRole = webRole;
        this.coins = coins;
        this.premiumCoins = premiumCoins;
        this.donatedMoney = donatedMoney;
        this.registeredDate = registeredDate;
        this.lastTimeOnline = lastTimeOnline;
        this.reputation = reputation;
        this.vipRole = vipRole;
        this.rank = rank;
        this.link = link;
        this.verified = verified;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public BigDecimal getDonatedMoney() { return donatedMoney; }

    public void setDonatedMoney(BigDecimal donatedMoney) { this.donatedMoney = donatedMoney; }

    public LocalDateTime getRegisteredDate() { return registeredDate; }

    public void setRegisteredDate(LocalDateTime registeredDate) { this.registeredDate = registeredDate; }

    public LocalDateTime getLastTimeOnline() { return lastTimeOnline; }

    public void setLastTimeOnline(LocalDateTime lastTimeOnline) { this.lastTimeOnline = lastTimeOnline; }

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

    /**************************************** Relations ************************************************************/

    @OneToMany(mappedBy = "user")
    public Set<Order> getOrders() { return orders; }

    public void setOrders(Set<Order> orders) { this.orders = orders; }

    @OneToOne(mappedBy = "user", optional = false, fetch = FetchType.LAZY)
    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart; }

    @OneToMany(mappedBy = "user")
    public Set<Purchase> getPurchases() { return purchases; }

    public void setPurchases(Set<Purchase> purchases) { this.purchases = purchases; }

    @OneToMany(mappedBy = "user")
    public Set<Reply> getReplies() { return replies; }

    public void setReplies(Set<Reply> replies) { this.replies = replies; }

    @OneToMany(mappedBy = "user")
    public Set<Topic> getTopics() { return topics; }

    public void setTopics(Set<Topic> topics) { this.topics = topics; }

    @OneToMany(mappedBy = "user")
    public Set<Stats> getStats() { return stats; }

    public void setStats(Set<Stats> stats) { this.stats = stats; }
}

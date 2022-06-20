package com.spodin.v.graphql.demo.common.model;

import com.spodin.v.graphql.demo.common.CardExpireDateJsonSerializer;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column(name = "pan")
    private String pan;

    @Column(name = "type")
    private String type;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    @JsonbTypeSerializer(CardExpireDateJsonSerializer.class)
    private Date expireDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @Column(name = "sms_service_name")
    private String smsServiceName;

    @Column(name = "sms_service_connected")
    private Boolean smsServiceConnected;

    @Column(name = "sms_service_phone_number")
    private String smsServicePhoneNumber;

    @Column(name = "delivered_to_office")
    private String deliveredToOffice;

    @Column(name = "payment_system")
    @Enumerated(EnumType.STRING)
    private PaymentSystem paymentSystem;

    @Column(name = "can_activate")
    private boolean canActivate;

    @Column(name = "can_update_pin_code")
    private boolean canUpdatePinCode;

    @Column(name = "can_tokenize")
    private boolean canTokenize;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CardTokenInfo> tokens;

    @Embedded
    private McRewards rewards;

    @Column(name = "virtual")
    private Boolean virtual;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonbTransient
    private Client client;

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getSmsServiceName() {
        return smsServiceName;
    }

    public void setSmsServiceName(String smsServiceName) {
        this.smsServiceName = smsServiceName;
    }

    public Boolean getSmsServiceConnected() {
        return smsServiceConnected;
    }

    public void setSmsServiceConnected(Boolean smsServiceConnected) {
        this.smsServiceConnected = smsServiceConnected;
    }

    public String getSmsServicePhoneNumber() {
        return smsServicePhoneNumber;
    }

    public void setSmsServicePhoneNumber(String smsServicePhoneNumber) {
        this.smsServicePhoneNumber = smsServicePhoneNumber;
    }

    public String getDeliveredToOffice() {
        return deliveredToOffice;
    }

    public void setDeliveredToOffice(String deliveredToOffice) {
        this.deliveredToOffice = deliveredToOffice;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public boolean isCanActivate() {
        return canActivate;
    }

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean isCanUpdatePinCode() {
        return canUpdatePinCode;
    }

    public void setCanUpdatePinCode(boolean canUpdatePinCode) {
        this.canUpdatePinCode = canUpdatePinCode;
    }

    public boolean isCanTokenize() {
        return canTokenize;
    }

    public void setCanTokenize(boolean canTokenize) {
        this.canTokenize = canTokenize;
    }

    public List<CardTokenInfo> getTokens() {
        return tokens;
    }

    public void setTokens(List<CardTokenInfo> tokens) {
        this.tokens = tokens;
    }

    public McRewards getRewards() {
        return rewards;
    }

    public void setRewards(McRewards rewards) {
        this.rewards = rewards;
    }

    public Boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Card{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", alias='" + alias + '\'' +
            ", account=" + account +
            ", pan='" + pan + '\'' +
            ", type='" + type + '\'' +
            ", holderName='" + holderName + '\'' +
            ", expireDate=" + expireDate +
            ", status=" + status +
            ", smsServiceName='" + smsServiceName + '\'' +
            ", smsServiceConnected=" + smsServiceConnected +
            ", smsServicePhoneNumber='" + smsServicePhoneNumber + '\'' +
            ", deliveredToOffice='" + deliveredToOffice + '\'' +
            ", paymentSystem=" + paymentSystem +
            ", canActivate=" + canActivate +
            ", canUpdatePinCode=" + canUpdatePinCode +
            ", canTokenize=" + canTokenize +
            ", tokens=" + tokens +
            ", rewards=" + rewards +
            ", virtual=" + virtual +
            ", client=" + client +
            '}';
    }
}

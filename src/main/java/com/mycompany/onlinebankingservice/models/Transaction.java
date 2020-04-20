package com.mycompany.onlinebankingservice.models;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
    private int id;
    private boolean credit;
    private boolean debit;
    private Date created;
    private String description;

    public Transaction() {}

    public Transaction(int id, boolean credit, boolean debit, Date created, String description) {
        this.id = id;
        this.credit = credit;
        this.debit = debit;
        this.created = created;
        this.description = description;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the credit
     */
    public boolean isCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    /**
     * @return the debit
     */
    public boolean isDebit() {
        return debit;
    }

    /**
     * @param debit the debit to set
     */
    public void setDebit(boolean debit) {
        this.debit = debit;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}

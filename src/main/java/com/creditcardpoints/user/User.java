package com.creditcardpoints.user;


/**
 * description: user <br>
 * date: 2020/7/24/024 9:32 <br>
 *
 * @author: LouWei <br>
 * version: 1.0 <br>
 */
public class User {
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public User(Card card) {
        this.card = card;
    }
}

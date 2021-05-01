package com.company;

public class Messsage {
    private String text;
    private String recipient;
    private int id;

    public Messsage(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("*******************");
        System.out.println("Contact Name: " + recipient +
                "\nMessage: " + text + "\nId: " + id);
        System.out.println("*******************");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

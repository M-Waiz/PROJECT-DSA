package javachallenge;

import com.company.Contact;
import com.company.Messsage;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id=0;

    public static void main(String[] args) {
        contacts= new ArrayList<>();

        showInitialOptions();
    }

    public static void showInitialOptions(){
        System.out.println("Please select one: "+
                "\n1. Manage Contacts" +
                "\n2. Messages" +
                "\n3. Quit");
        scanner= new Scanner(System.in);
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                System.out.println("Quiting...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one" +
                "\n1. Show all messages" +
                "\n2. Send a new messaage" +
                "\n3. Go Back");
        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a message?");
        String name= scanner.next();

        if(name.equals("")){
            System.out.println("Please enter the name of contact");
            sendNewMessage();
        }
        else{
            boolean doesExist= false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist= true;
                }
            }
            if(doesExist){
                System.out.println("What are you going to say?");
                String text= scanner.next();

                if(text.equals("")){
                    System.out.println("Please enter some message");
                    sendNewMessage();
                }
                else{
                    id++;
                    Messsage newMessage= new Messsage(text, name, id);
                    for(Contact c: contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Messsage> newMessages= c.getMesssages();
                            newMessages.add(newMessage);
                            c.setMesssages(newMessages);
                        }
                    }
                    System.out.println("Messagae sent successfully...");
                }
            }
            else{
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Messsage> allMessages= new ArrayList<>();
        for(Contact c: contacts){
            allMessages.addAll(c.getMesssages());
        }
        if(allMessages.size()>0){
            for(Messsage m: allMessages){
                m.getDetails();
            }
        }
        else{
            System.out.println("You donot have any message");

        }
        showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please select one: " +
                "\n1. Show all contacts"+
                "\n2. Add a new contact"+
                "\n3. Search for a contact"+
                "\n4. Delete a contact"+
                "\n5. Go Back");

        int choice= scanner.nextInt();
        switch (choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact's name: ");
        String name= scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name");
            deleteContact();
        }
        else{
            boolean doesExist= false;
            Contact contact=null;
            for(Contact c: contacts){
                if(c.getName().equals(name)) {
                    doesExist = true;
                    contact= c;
                }
            }
            if(doesExist){
                contacts.remove(contact);
                System.out.println("Contact deleted successfully...");
            }
            else{
                System.out.println("There is no such contact ");
            }
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact's name: ");
        String name= scanner.next();

        if(name.equals("")){
            System.out.println("Please enter the name");
            searchForContact();
        }
        else{
            boolean doesExist= false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist= true;
                    c.getDetails();
                }
            }
            if(!doesExist){
                System.out.println("There is no such contact in your phone");

            }
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name: ");
        String name= scanner.next();
        System.out.println("Please enter contact's number: ");
        String number= scanner.next();
        System.out.println("Please enter contact's email: ");
        String email= scanner.next();

        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContact();
        }
        else{

            boolean doesExist= false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist= true;
                }
            }
            if(doesExist){
                System.out.println("You have a contact named " + name + " saved on this device");
                addNewContact();
            }
            else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        if(contacts.size()>0) {
            for (Contact c : contacts) {
                System.out.println("*********************");
                c.getDetails();
                System.out.println("*********************");
            }
        }
        else{
            System.out.println("You donot have any contact");
        }
        showInitialOptions();
    }
}
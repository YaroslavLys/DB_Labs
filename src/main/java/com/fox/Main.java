package com.fox;

import com.fox.view.View;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        System.err.close();
        System.setErr(System.out);
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
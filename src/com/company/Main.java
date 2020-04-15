package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an ip address: ");
        String ip = sc.nextLine();
        if (validate(ip)) {
            System.out.print("Enter a port number: ");
            int port = sc.nextInt();
            try {
                Socket socket = new Socket(ip, port);
                socket.close();
                System.out.println("Success");
            } catch (Exception e) {
                System.out.println("Failure " + e.getMessage());
            }

        } else {
            System.out.println("Enter a valid ip address.");
        }
    }

    public static boolean validate(final String ip) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

        return ip.matches(PATTERN);
    }
}

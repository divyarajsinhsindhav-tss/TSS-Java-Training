package com.tss.test;

import java.util.Scanner;

public class StringEncodingDecoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = scanner.nextLine().toLowerCase();
        StringBuilder string = new StringBuilder();

        for (int i = 0; i<str.length(); i++) {
            char tempChar = str.charAt(i);
            switch (tempChar) {
                case 'a': string.append('@'); break;
                case 'e': string.append('#'); break;
                case 'i': string.append('!'); break;
                case 'o': string.append('*'); break;
                case 'u': string.append('$'); break;
                case ' ': string.append(' '); break;
                default:
                    if(tempChar >= 'a' && tempChar <= 'z'){
                        if (tempChar == 'z') {
                            string.append('a');
                        } else {
                            string.append((char) (tempChar+1));
                        }
                    } else {
                        string.append(tempChar);
                    }
            }
        }
        string = string.reverse();
        System.out.println("Encoded String");
        System.out.println(string.toString());

        string = string.reverse();
        for (int i = 0; i<string.length(); i++) {
            char tempChar = string.charAt(i);
            switch (tempChar) {
                case '@':
                    string.setCharAt(i, 'a');
                    break;
                case '#':
                    string.setCharAt(i, 'e');
                    break;
                case '!':
                    string.setCharAt(i, 'i');
                    break;
                case '*':
                    string.setCharAt(i, 'o');
                    break;
                case '$':
                    string.setCharAt(i, 'u');
                    break;
                case ' ':
                    string.setCharAt(i, ' ');
                    break;
                default:
                    if(tempChar >= 'a' && tempChar <= 'z'){
                      if (tempChar == 'a') {
                        string.setCharAt(i, 'z');
                      } else {
                        string.setCharAt(i, (char) (tempChar - 1));
                      }
                    } else {
                        string.setCharAt(i, tempChar);
                    }
            }
//            System.out.println(string.toString());
        }
        System.out.println("Decoded String");
        System.out.println(string.toString());

    }
}


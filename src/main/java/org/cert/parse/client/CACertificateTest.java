package org.cert.parse.client;

import java.io.*;
import java.security.*;
import java.security.cert.*;

public class CACertificateTest {
   public static void main(String[] a) {
   
      String input = "src/main/resources/casample.cer";
      String output = "src/main/resources/casampleout.txt";
      try {
         test(input,output);
      } catch (Exception e) {
         System.out.println("Exception: "+e);
         return;
      }
   }
   private static void test(String input, String output)
      throws Exception {
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      System.out.println();
      System.out.println("CertificateFactory Object Info: ");
      System.out.println("Type = "+cf.getType());
      System.out.println("Provider = "+cf.getProvider());
      System.out.println("toString = "+cf.toString());

      FileInputStream fis = new FileInputStream(input);
      java.security.cert.Certificate cert = cf.generateCertificate(fis);
      fis.close();
      System.out.println();
      System.out.println("Certificate Object Info: ");
      System.out.println("Type = "+cert.getType());
      System.out.println("toString = "+cert.toString());

      PublicKey pubKey = cert.getPublicKey();
      System.out.println();
      System.out.println("PublicKey Object Info: ");
      System.out.println("Algorithm = "+pubKey.getAlgorithm());
      System.out.println("Format = "+pubKey.getFormat());
      System.out.println("toString = "+pubKey.toString());
      
      FileOutputStream fos = new FileOutputStream(output);
      byte[] certBytes = cert.getEncoded();
      fos.write(certBytes);
      fos.close();
   }
}
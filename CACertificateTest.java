package org.cert.parse.client;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.cert.parse.manager.CertificateManager;


public class CACertificateTest {
   public static void main(String[] a) {
	 
      try {
    	  CertificateFactory cfactory = new CertificateManager().createCertIns();
    	  X509Certificate certificate = new CertificateManager().generateCertificate(cfactory);
 
      } catch (Exception e) {
        e.printStackTrace();
        return;
      }
   }

}
package org.cert.parse.client;
import java.security.cert.CertificateFactory;
import org.cert.parse.manager.CertificateManager;
import org.cert.parse.model.CertBean;


public class CACertificateTest {
   public static void main(String[] a) {
	   
      try {

    	  CertBean certInfo = new CertificateManager().generateCertificate();
    	  
    	  System.out.println("Issuer **** "+certInfo.getIssuer());
    	  System.out.println("Subject **** "+certInfo.getSubject());
    	  System.out.println("SerialNumber *** "+certInfo.getSerialNumber());
    	  System.out.println("isValid **** "+certInfo.isValid());
    	  System.out.println("From Date *** "+certInfo.getFromDate());
    	  System.out.println("To Date *** "+certInfo.getToDate());
 
      } catch (Exception e) {
        e.printStackTrace();
        return;
      }
   }

}
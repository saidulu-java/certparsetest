package org.cert.parse.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.cert.parse.model.CertBean;
import org.cert.parse.util.PropertyManagerUtil;

public class CertificateManager {
	private CertBean cBean = null;

	public CertificateFactory createCertIns() throws Exception {

		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		 cBean = new CertBean();
		System.out.println("Type = " + cf.getType());
		System.out.println("Provider = " + cf.getProvider());
		System.out.println("toString = " + cf.toString());
		return cf;

	}

	public X509Certificate generateCertificate(CertificateFactory cf)
			throws FileNotFoundException, CertificateException, IOException {
	  	 
		String fileName = PropertyManagerUtil.readCertFile();
		FileInputStream fis = new FileInputStream(fileName);
		X509Certificate cert = (X509Certificate)cf.generateCertificate(fis);
		fis.close();
		
		Date date = new Date();
		try{
			System.out.println("Checking the certificate validity");
			cert.checkValidity(date);
		}
		catch( CertificateExpiredException e){
			e.printStackTrace();
		}
		catch(CertificateNotYetValidException ee){
		ee.printStackTrace();
		}

		System.out.println("Certificate Object Info: ");
		System.out.println("Type = " + cert.getType());
		System.out.println("toString = " + cert.toString());

		PublicKey pubKey = cert.getPublicKey();
		System.out.println();
		System.out.println("PublicKey Object Info: ");
		System.out.println("Algorithm = " + pubKey.getAlgorithm());
		System.out.println("Format = " + pubKey.getFormat());
		System.out.println("toString = " + pubKey.toString());
		return cert;
	}
}

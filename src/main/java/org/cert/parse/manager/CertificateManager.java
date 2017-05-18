package org.cert.parse.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	public CertBean generateCertificate()
			throws FileNotFoundException, CertificateException, IOException {
		cBean = new CertBean();
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		String fileName = PropertyManagerUtil.readCertFile();
		FileInputStream fis = new FileInputStream(fileName);
		X509Certificate cert = (X509Certificate)cf.generateCertificate(fis);
		fis.close();

		cBean.setIssuer(cert.getIssuerDN().getName());
		cBean.setSubject(cert.getSubjectDN().getName());
		cBean.setSerialNumber(cert.getSerialNumber().toString());
		boolean flag = checkValidaity(cert);
		if(flag == true){
			cBean.setValid(true);
			cBean.setFromDate(cert.getNotBefore().toString());
			cBean.setToDate(cert.getNotAfter().toString());
		}

		return cBean;
	}

	private boolean checkValidaity(X509Certificate cert) {
		boolean flag = false;
		Date date = new Date();
		try{
			cert.checkValidity(date);
			flag = true;
		}
		catch( CertificateExpiredException e){
			e.printStackTrace();
		}
		catch(CertificateNotYetValidException ee){
		ee.printStackTrace();
		}
		return flag;
	}

	public CertBean getcBean() {
		return cBean;
	}

	public void setcBean(CertBean cBean) {
		this.cBean = cBean;
	}
}

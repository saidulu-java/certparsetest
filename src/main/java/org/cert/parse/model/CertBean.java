package org.cert.parse.model;

public class CertBean {
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getSigValidity() {
		return sigValidity;
	}
	public void setSigValidity(String sigValidity) {
		this.sigValidity = sigValidity;
	}
	private String issuer;
	private String subject;
	private String serialNumber;
	private String fromDate;
	private String toDate;
	private String sigValidity;

}

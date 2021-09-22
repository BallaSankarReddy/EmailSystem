package com.email.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.entity.EmailEnitity;

@Service
public class EmilServiceImpl implements EmilService {

	@Autowired

	private JavaMailSender javaMailSender;

	@Override
	public String sendingEmail(String toEmail, String body, String subject) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		try {

			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			return e.getCause().getLocalizedMessage();
		}
		System.out.println("Mail been sent");
		return "Mail sent successful.. thanks";
	}

	@Override
	public String sendSampleEmail(EmailEnitity emailEnitity) {
		String sendingEmail = "";
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append("Dear Mr./Mis.").append(" ").append(emailEnitity.getEmpName()).append("\n").append("\n")
			.append("We would like to inform you, your loan account details. Kindly validate the given mail and contract us, if you need any clarification.").append("\n").append("\n")
			
			.append("Employee id:").append(emailEnitity.getId()).append("\n")
			.append("Employee Name:").append(emailEnitity.getEmpName()!=null?emailEnitity.getEmpName():"ADMIN").append("\n")
			.append("Loan Number :").append(emailEnitity.getLoanNumber()).append("\n")
			.append("Loan Terms:").append(emailEnitity.getLoanTerms()!=null ?emailEnitity.getLoanTerms():" ").append("\n")
			
			.append("Org Name:").append(emailEnitity.getOrgId()!=null?emailEnitity.getOrgId():"Default").append("\n")
			.append("Emp PhoneNumber:").append(emailEnitity.getPhoneNumber()!=null?emailEnitity.getPhoneNumber():"0000000").append("\n")
			.append("Monthly Amount:").append(emailEnitity.getMonthlyAmount()!=null?emailEnitity.getMonthlyAmount():"00.0").append("\n")
			.append("OutStanding Amount:").append(emailEnitity.getOutStandingAmount()!=null?emailEnitity.getOutStandingAmount():"00.0").append("\n")
			.append("Total Paid Amount:").append(emailEnitity.getTotalPaidAmount()!=null?emailEnitity.getTotalPaidAmount():"00.0").append("\n")
			.append("Orignal Loan Amount").append(emailEnitity.getOrignalLoanAmount()!=null?emailEnitity.getOrignalLoanAmount():0).append("\n")
			.append("Loan Creation Date/Time:").append(emailEnitity.getCreatedTimeStamp()!=null?emailEnitity.getCreatedTimeStamp(): new Date()).append("\n")
			.append("Loan Modification Date/Time:").append(emailEnitity.getModifiedTimeStamp()!=null?emailEnitity.getModifiedTimeStamp(): new Date()).append("\n")
			.append("\n").append("\n").append("\n").append("\n")
			.append("Best Regards").append("\n")
			.append("Loan System").append("\n")
			;
			
			 sendingEmail = this.sendingEmail(emailEnitity.getEmailId()!=null?emailEnitity.getEmailId():"sankarreddy.hcl@gmail.com", builder.toString(), emailEnitity.getEmilSubject()+"Notification of loan payment deatils..");
		}catch (Exception e) {
			return e.getCause().getLocalizedMessage();
		}

		return sendingEmail;
	}

}

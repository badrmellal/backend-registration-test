package registration.backend.login;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.util.Base64;

import org.hibernate.query.NativeQuery.ReturnableResultNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "about")
	private String about;
	@Lob
	@Column(name = "photobase64")
	private String photoBase64;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email_address")
	private String emailAddress;
	@Nullable
	@Column(name = "country")
	private String country;
	@Column(name = "password")
	private String password;
	@Column(name = "city")
	private String city;
	@Column(name = "phone_number")
	private Integer phoneNumber;
	@Nullable
	@Column(name = "push_notification")
	private String pushNotification;
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
/*
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photoBytes) {
		this.photo = photoBytes;
		
	}
*/
	
	// Converting the Base64 string to byte[] when getting the photo
    // public byte[] getPhoto() {
     //   return Base64.getDecoder().decode(Photo);
    // }
    // Converting the byte[] to Base64 string when setting the photo
	// public void setPhoto(byte[] photo) {
	  //      this.Photo = Base64.getEncoder().encodeToString(photo);
	   // }
	public String getFirstName() {
		return firstName;
	}
	public String getPhotoBase64() {
		return photoBase64;
	}
	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPushNotification() {
		return pushNotification;
	}
	public void setPushNotification(String pushNotification) {
		this.pushNotification = pushNotification;
	}
	

}

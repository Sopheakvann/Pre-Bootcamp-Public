package com.vann.philSci.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table(name = "users")
@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Full Name is required.")
	@Size(min = 3, max = 100, message= "Full Name must be between 3 and 100 characters.")
	private String fullName;

	@NotEmpty(message= "Email is required.")
	@Email(message="Please enter a valid email.")
	private String email;
	
	@NotEmpty(message= "Username is required.")
	@Size(min =3, max= 100, message= "Username must be between 3 and 100 characters.")
	private String userName;

	@NotEmpty(message= "Password is required.")
	@Size(min = 8, max = 128, message= "Password must be between 8 and 128 characters.")
	private String password;

	@Transient
	@NotEmpty(message= "Confirm password is required.")
	@Size(min = 8, max = 128, message="Confirm password must match Password!")
	private String confirm;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Post> posts;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public User() {
		
	}

	public User(String fullName, String email, String userName, String password, String confirm, List<Post> posts) {
		this.fullName= fullName;
		this.userName= userName;
		this.password= password;
		this.confirm= confirm; 
		this.posts= posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}

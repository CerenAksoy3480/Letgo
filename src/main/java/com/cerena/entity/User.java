package com.cerena.entity;


import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")

public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String tel;
	private String profilImageUrl;
	private String konum;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Ilan>ilanlar;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<FavouriteIlan>favoriIlanlar;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Message>mesajlar;
	
	
	
}
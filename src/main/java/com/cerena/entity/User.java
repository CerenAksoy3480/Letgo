package com.cerena.entity;


import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
	private List<Message>mesajlar;
	
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='[PROTECTED]'" + // Şifreyi açık olarak yazdırmayın
				", email='" + email + '\'' +
				", tel='" + tel + '\'' +
				", profilImageUrl='" + profilImageUrl + '\'' +
				", konum='" + konum + '\'' +
				", status=" + status +
				", ilanlar=" + (ilanlar != null ? ilanlar.stream().map(Ilan::getId).collect(Collectors.toList()) : "null") +
				", favoriIlanlar=" + (favoriIlanlar != null ? favoriIlanlar.stream().map(FavouriteIlan::getId).collect(Collectors.toList()) : "null") +
				", mesajlar=" + (mesajlar != null ? mesajlar.stream().map(Message::getId).collect(Collectors.toList()) : "null") +
				'}';
	}
	
}
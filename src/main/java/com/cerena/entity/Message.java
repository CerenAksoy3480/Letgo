package com.cerena.entity;

import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sender_id")
	private com.cerena.entity.User sender;
	
	@ManyToOne
	@JoinColumn(name="receiver_id")
	private com.cerena.entity.User receiver;
	
	@ManyToOne
	@JoinColumn(name="ilan_id")
	private Ilan ilan;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String text;
	private LocalDate sendDate;
	
	
	
}
package com.cerena.entity;

import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
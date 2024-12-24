package com.cerena.entity;


import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_image")

public class Image extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ilan_id")
	private Ilan ilan;
	
	private String imageUrl;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	

}
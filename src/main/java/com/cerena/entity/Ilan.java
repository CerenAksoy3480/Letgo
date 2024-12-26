package com.cerena.entity;


import com.cerena.enums.IlanStatus;
import com.cerena.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_ilan")

public class Ilan extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private String title;
	private String description;
	private String location;
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private IlanStatus status;
	
	@OneToMany(mappedBy = "ilan", cascade = CascadeType.ALL)
	private List<Image> images;
	
	


	@Override
	public String toString() {
		return "Ilan{" +
				"id=" + id +
				", user=" + (user != null ? user.getId() : "null") +
				", category=" + (category != null ? category.getName() : "null") +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", konum='" + konum + '\'' +
				", price=" + price +
				", images=" + (images != null ?
				images.stream().map(Image::getId).collect(Collectors.toList()) : "null") +
				'}';
	}
}
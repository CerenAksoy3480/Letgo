package com.cerena.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_ilan")

public class Ilan extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	private String title;
	private String description;
	private String konum;
	private BigDecimal price;
	
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
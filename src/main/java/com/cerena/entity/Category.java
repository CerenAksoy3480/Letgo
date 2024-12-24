package com.cerena.entity;


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
@Table(name = "tbl_category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "parentcategoryid")
	private  Long parentCategoryid;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Ilan> ilanlar;
	
	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", parentCategoryid=" + parentCategoryid +
				", ilanlar=" + (ilanlar != null ?
				ilanlar.stream().map(Ilan::getId).collect(Collectors.toList()) : "null") +
				'}';
	}
	
}
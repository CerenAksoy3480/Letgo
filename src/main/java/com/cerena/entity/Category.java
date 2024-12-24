package com.cerena.entity;


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
	
	
	
}
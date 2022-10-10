package com.rea.app.category.entity;

import com.rea.app.common.model.BaseEntity;
import com.rea.app.common.model.status.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category", uniqueConstraints = @UniqueConstraint(columnNames = {"category_title"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    @Column(name = "category_title", nullable = false,length = 100, unique = true)
    private String title;

    @Column(name = "category_description", nullable = false, length = 300)
    private String description;

    @NotNull
    private String imageName;

    private String status = CategoryStatus.PUBLISHED.name;
}

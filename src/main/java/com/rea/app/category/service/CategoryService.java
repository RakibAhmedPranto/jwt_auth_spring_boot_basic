package com.rea.app.category.service;

import com.rea.app.category.dtos.CategoryRequestDto;
import com.rea.app.category.dtos.CategoryResponseDto;
import com.rea.app.common.model.Response;

import java.util.List;

public interface CategoryService {

    Response<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto);

    Response<List<CategoryResponseDto>> getAllCategories();
}

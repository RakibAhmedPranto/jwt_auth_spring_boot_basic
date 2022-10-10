package com.rea.app.category.service;

import com.rea.app.category.dtos.CategoryRequestDto;
import com.rea.app.category.dtos.CategoryResponseDto;
import com.rea.app.category.entity.Category;
import com.rea.app.category.repository.CategoryRepository;
import com.rea.app.common.model.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rea.app.common.ResponseObject.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Response<CategoryResponseDto> createCategory(CategoryRequestDto categoryRequestDto) {

        Category category = this.modelMapper.map(categoryRequestDto, Category.class);
        Response<CategoryResponseDto> response = new Response<>();

        try{
            Category savedCategory = this.categoryRepository.save(category);
            CategoryResponseDto categoryResponseDto = this.modelMapper.map(savedCategory, CategoryResponseDto.class);
            return dataSavedOrUpdateSuccess(response,categoryResponseDto,201);
        }catch (RuntimeException ex){
            return dataNotSavedOrUpdate(response);
        }
    }

    @Override
    public Response<List<CategoryResponseDto>> getAllCategories() {
        Response<List<CategoryResponseDto>> response = new Response<>();
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = categories.stream().map(category -> this.modelMapper.map(category,CategoryResponseDto.class)).collect(Collectors.toList());
        return dataFoundSuccess(response,categoryResponseDtos);
    }
}

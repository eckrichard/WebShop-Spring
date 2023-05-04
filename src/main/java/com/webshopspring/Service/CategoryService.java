package com.webshop.Service;

import com.webshop.Model.Category;
import com.webshop.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!categoryOptional.isPresent()){
            return null;
        }
        return categoryOptional.get();
    }

    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if (categoryOptional.isPresent()){
            throw new IllegalStateException("it's already exist");
        }
        categoryRepository.save(category);
    }

    public Category deleteCategory(Long id) {
        Category category = this.getCategory(id);
        if (category != null){
            categoryRepository.deleteById(id);
            return category;
        }
        else {
            return null;
        }
    }

    public Category updateCategory(Long categoryId, Category category) {
        Category categoryFind = getCategory(categoryId);
        if(categoryFind != null){
            categoryFind.setName(category.getName());
            categoryFind.setParentCategory(category.getParentCategory());

            categoryRepository.save(categoryFind);
            return category;
        }
        return null;
    }
}

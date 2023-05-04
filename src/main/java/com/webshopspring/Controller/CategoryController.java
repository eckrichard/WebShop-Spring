package com.webshop.Controller;

import com.webshop.Model.Category;
import com.webshop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(path = "{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> addNewCategory(@RequestBody Category category) {
        categoryService.addNewCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "{categoryId}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.deleteCategory(categoryId);
        return category != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "{categoryId}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable("categoryId") Long categoryId,
            @RequestBody Category category)
    {
        Category categoryFind = categoryService.updateCategory(categoryId, category);
        return categoryFind != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

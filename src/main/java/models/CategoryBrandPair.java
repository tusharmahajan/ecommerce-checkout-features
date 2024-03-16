package models;

import lombok.Data;

import java.util.Objects;

@Data
public class CategoryBrandPair {

    private final String brand;
    private final String category;


    public CategoryBrandPair(String brand, String category) {
        this.brand = brand;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryBrandPair that = (CategoryBrandPair) o;
        return Objects.equals(brand, that.brand) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, category);
    }
}

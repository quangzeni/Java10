package thuchanh;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3f;
    void inputData(Scanner scanner, List<Product> listProduct, List<Categories> listCategories);
    void displayData();
}

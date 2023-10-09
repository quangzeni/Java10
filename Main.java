package thuchanh;

import ra.presentation.CategoriesManagement;
import ra.presentation.ProductManagement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Categories> listCategories = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********SHOP MENU*********");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoat");
            System.out.println("Lựa chọn của bạn là:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    CategoriesManagement.showMenu(listCategories);
                    break;
                case 2:
                    ProductManagement.showProductMenu(listProduct);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-3");
            }
        }while (true);
    }
}

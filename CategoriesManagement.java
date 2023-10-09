package ra.presentation;

import thuchanh.Categories;
import thuchanh.Product;

import java.util.List;
import java.util.Scanner;

//import static ra.presentation.ProductManagement.listProduct;
import static thuchanh.Main.listProduct;

public class CategoriesManagement {


    public static void showMenu(List<Categories> listCategories) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******CATEGORIES MENU******");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật thông tin danh mục (Cập nhật theo mã)");
            System.out.println("4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1:
                    CategoriesManagement.displayListCategories(listCategories);
                    break;
                case 2:
                    CategoriesManagement.inputListCategories(scanner,listProduct,listCategories);
                    break;
                case 3:
                    CategoriesManagement.updateCategories(scanner,listCategories);
                    break;
                case 4:
                    CategoriesManagement.deleteListCategories(scanner,listCategories,listProduct);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-5");
            }
        }while (true);
    }
    public static void displayListCategories(List<Categories> listCategories){
        for (Categories categories:listCategories) {
            categories.displayData();
        }
    }
    public static void inputListCategories(Scanner scanner,List<Product> listProduct,List<Categories> listCategories){
        Categories categories = new Categories();
        categories.inputData(scanner,listProduct, listCategories);
        listCategories.add(categories);
    }
    public static void updateCategories(Scanner scanner, List<Categories> listCategories){
        System.out.println("Nhập mã danh mục cần cập nhật tên:");
        int updateId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listCategories.size(); i++) {
            if (updateId == listCategories.get(i).getId()){
                System.out.println("Nhập Tên Danh mục:");
                String updateName = scanner.nextLine();
                listCategories.get(i).setName(updateName);
            }else {
                System.out.println("Không có ID bạn chọn");
                return;
            }
        }
    }
    public static void deleteListCategories(Scanner scanner,List<Categories> listCategories,List<Product> listProduct){
        System.out.println("Nhập mã danh mục cần xoóa");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listCategories.size(); i++) {
            if (deleteId == listCategories.get(i).getId()){
                for (int j = 0; j < listProduct.size(); j++) {
                    if (listProduct.get(j).getCatalogId()==deleteId){
                        System.out.println("Danh mục có chứa sản phẩm, không xóa được");
                        return;
                    }
                }
                listCategories.remove(i);
                System.out.println("Danh mục đã được xóa");
                return;
            }
        }
        System.out.println("Khng có Id bạn chọn");
    }
}

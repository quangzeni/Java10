package ra.presentation;

import thuchanh.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {

    public static void showProductMenu(List<Product> listProduct) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******PRODUCT MENU******");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm (Cập nhật theo mã)");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo giá nhập giảm dần");
            System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1:
                    ProductManagement.displayListProduct(listProduct);
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1-5");
            }
        }while (true);
    }
    public static void displayListProduct(List<Product> listProduct){
        for (Product product : listProduct) {
            product.displayData();
        }
    }
}

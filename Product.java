package thuchanh;

import ra.presentation.ProductManagement;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String Id;
    private String Name;
    private int CatalogId;
    private float ImportPrice;
    private float ExportPrice;
    private boolean Status;

    public Product() {
    }

    public Product(String id, String name, int catalogId, float importPrice, float exportPrice, boolean status) {
        Id = id;
        Name = name;
        CatalogId = catalogId;
        ImportPrice = importPrice;
        ExportPrice = exportPrice;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCatalogId() {
        return CatalogId;
    }

    public void setCatalogId(int catalogId) {
        CatalogId = catalogId;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float importPrice) {
        ImportPrice = importPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float exportPrice) {
        ExportPrice = exportPrice;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public void inputData(Scanner scanner, List<Product> listProduct, List<Categories> listCategories) {
        System.out.println("Nhập thông tin sản phẩm");
        do {
            System.out.println("Nhập Id sản phẩm:");
            this.Id = scanner.nextLine();
            if (this.Id.length() == 4) {
                boolean isCheck = true;
                if (this.Id.startsWith("P")) {
                    for (int i = 0; i < listProduct.size(); i++) {
                        Product product = listProduct.get(i);
                        if (product.getId().equals(this.Id)) {
                            System.out.println("Id trùng lặp, mời nhập lại");
                            isCheck = false;
                            break;
                        }
                    }
                }
                if (isCheck) {
                    break;
                }
            } else {
                System.out.println("Mã sản phẩm phải gồm 4 ký tự");
            }
        } while (true);

        do {
            System.out.println("Nhập tên sản phẩm:");
            this.Name = scanner.nextLine();
            boolean isCheck = true;
            for (int i = 0; i < listProduct.size(); i++) {
                Product product = listProduct.get(i);
                if (product.getName().equals(this.Name)) {
                    System.out.println("Tên trùng lặp, mời nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck) {
                break;
            }
        } while (true);
        System.out.println("Chọn mã danh mục dưới đây");
        for (int i = 0; i < listCategories.size(); i++) {
            System.out.println(i + 1 + "." + listCategories.get(i).getId());
        }
        System.out.println("Lựa chọn của bạn:");
        do {
            int choice = Integer.parseInt(scanner.nextLine());
            boolean isCheck = true;
            for (int i = 0; i < listCategories.size(); i++) {
                if (choice == listCategories.get(i).getId()) {
                    this.CatalogId = choice;
                    break;
                } else {
                    isCheck = false;
                }
            }
            if (!isCheck) {
                System.out.println("Nhập lại ");
            }else {
                break;
            }
        } while (true);
        System.out.println("Nhập giá sản phẩm");
        do {

            this.ImportPrice = Float.parseFloat(scanner.nextLine());
            if (this.ImportPrice > 0) {
                break;
            } else {
                System.out.println("Giá sản phẩm phải lớn hơn 0, nhập lại");

            }
        } while (true);
        System.out.println("Nhập trạng thái sản phẩm");
        this.Status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Id: %s - Name: %s - Mã danh mục: %d - Giá nhập: %f - Giá bán: %f  - Trạng thái: %s", this.Id, this.Name, this.ImportPrice, exportPrice(), this.Status ? "Hoạt động" : "Không hoạt động");
    }

    public float exportPrice() {
        return this.ImportPrice * RATE;
    }
}

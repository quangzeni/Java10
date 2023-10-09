package thuchanh;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop{
    Scanner scanner = new Scanner(System.in);
    private int Id;
    private String Name;
    private String Descriptions;
    private boolean Status;
    public static int newId = 1;
    public Categories() {
        this.Id = newId++;
    }

    public Categories(Scanner scanner, int id, String name, String descriptions, boolean status) {
        this.scanner = scanner;
        Id = id;
        Name = name;
        Descriptions = descriptions;
        Status = status;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    @Override
    public void inputData(Scanner scanner,List<Product> listProduct, List<Categories> listCategories){
        System.out.println("Nhập thông tin danh mục");
//        this.Id = listCategories.size();
        System.out.println("Nhập tên danh mục");
        this.Name = scanner.nextLine();
        do {
            boolean isCheck = true;
            for (int i = 0; i < listCategories.size(); i++) {
                Categories categories = listCategories.get(i);
                if (categories.getName().equals(this.Name)){
                    System.out.println("Tên trùng lặp vui lòng nhập lại");
                    isCheck = false;
                    break;
                }
            }
            if (isCheck){
                break;
            }
        }while (true);
        System.out.println("Nhập mô tả danh mục");
        this.Descriptions = scanner.nextLine();
        System.out.println("Nhập trạng thái danh mục");
        this.Status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData(){
        System.out.printf("Id: %d - Name: %s - Mô tả: %s - Trạng thái: %s\n",this.Id,this.Name,this.Descriptions,this.Status? "Hoạt động": "Không hoạt động");
    };
}

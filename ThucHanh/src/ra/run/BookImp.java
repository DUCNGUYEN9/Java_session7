package ra.run;

import ra.entity.Book;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BookImp {
    public static void main(String[] args) {
        Book[] arrBooks = new Book[100];
        int index = 0, count;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("*********************🤖 MENU 🤖******************\n" +
                    "1. Nhập thông tin n sách\n" +
                    "2. Tính lợi nhuận các sách\n" +
                    "3. Hiển thị thông tin sách\n" +
                    "4. Sắp xếp sách theo giá bán tăng dần\n" +
                    "5. Sắp xếp sách theo lợi nhuận giảm dần\n" +
                    "6. Tìm sách theo tên sách\n" +
                    "7. Thống kê số lượng sách theo năm xuất bản\n" +
                    "8. Thống kê số lượng sách theo tác giả\n" +
                    "9. Thoát");
            System.out.println("⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜🤖 Lựa chọn của bạn 🤖⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜⁜");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng sách bạn muốn nhập: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrBooks[index] = new Book();
                        arrBooks[index].inputData(sc, arrBooks, index);
                        index++;
                    }
                    break;
                case 2:
                    System.out.println("Lợi nhuận các sách là: ");
                    for (int i = 0; i < index; i++) {
                        arrBooks[i].calInterest();
                    }
                    for (int i = 0; i < index; i++) {
                        System.out.printf("Lợi nhuận sách %s là : %.2f\n", arrBooks[i].getBookName(), arrBooks[i].getInterest());
                    }
                    break;
                case 3:
                    System.out.println("---------------------- Thông Tin Sách --------------------");
                    for (int i = 0; i < index; i++) {
                        arrBooks[i].displayData();
                    }
                    break;
                case 4:
                    System.out.println("Sắp xếp gia ban tăng dần: ");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrBooks[i].getExportPrice() > arrBooks[j].getExportPrice()) {
                                Book temp = arrBooks[i];
                                arrBooks[i] = arrBooks[j];
                                arrBooks[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < index; i++) {
                        arrBooks[i].displayData();
                    }
                    break;
                case 5:
                    System.out.println("Sắp xếp loi nhuan giảm dần: ");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrBooks[i].getInterest() < arrBooks[j].getInterest()) {
                                Book temp = arrBooks[i];
                                arrBooks[i] = arrBooks[j];
                                arrBooks[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < index; i++) {
                        arrBooks[i].displayData();
                    }
                    break;
                case 6:
                    System.out.println("Nhập tên sách cần tìm: ");
                    String searchBook = sc.nextLine();
                    boolean isExist = false;
                    for (int i = 0; i < index; i++) {
                        if (arrBooks[i].getBookName().toLowerCase().contains(searchBook.toLowerCase())) {
                            arrBooks[i].displayData();
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        System.out.println("Sách bạn tìm không tồn tại");
                    }
                    break;
                case 7:
                    System.out.println("Thống kê số lượng sách theo năm xuất bản");
                    int[] yearRepeat = new int[index];
                    int yearCounter = 0;
                    for (int i = 0; i < index; i++) {
                        boolean isRepeat = false;
                        for (int j = 0; j < i; j++) {
                            if (arrBooks[i].getYear() == arrBooks[j].getYear()) {
                                isRepeat = true;
                                break;
                            }
                        }
                        if (!isRepeat) {
                            yearRepeat[yearCounter++] = arrBooks[i].getYear();
                        }
                    }
                    for (int i = 0; i < yearCounter; i++) {
                        count = 0;
                        for (int j = 0; j < index; j++) {
                            if (yearRepeat[i] == arrBooks[j].getYear()) {
                                count++;
                            }
                        }
                        System.out.printf("Sách xuất bản năm %d có: %d Quyển \n", yearRepeat[i], count);
                    }
                    break;
                case 8:
                    System.out.println("Thống kê số lượng sách theo tác giả");
                    String[] authorRepeat = new String[index];
                    int authorCounter = 0;
                    for (int i = 0; i < index; i++) {
                        boolean isRepeat = false;
                        for (int j = 0; j < i; j++) {
                            if (arrBooks[i].getAuthor().equals(arrBooks[j].getAuthor())) {
                                isRepeat = true;
                                break;
                            }
                        }
                        if (!isRepeat) {
                            authorRepeat[authorCounter++] = arrBooks[i].getAuthor();
                        }
                    }
                    for (int i = 0; i < authorCounter; i++) {
                        count = 0;
                        for (int j = 0; j < index; j++) {
                            if (authorRepeat[i].equals(arrBooks[j].getAuthor())) {
                                count++;
                            }
                        }
                        System.out.printf("Sách của tác giả %s có: %d Quyển \n", authorRepeat[i], count);
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Hãy chọn số từ 1 -> 9");
            }
        } while (true);
    }


}

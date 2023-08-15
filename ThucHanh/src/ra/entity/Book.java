package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = interest;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner sc, Book[] arrBooks, int index) {
        System.out.println("Hãy nhập mã sách: ");
        do {
            this.bookId = sc.nextLine();
            char firstChar = 'B';
            if (this.bookId.length() == 4 && firstChar == this.bookId.charAt(0)) {
                if (index > 0) {
                    boolean isExist = false;
                    for (int i = 0; i < index; i++) {
                        if (arrBooks[i].bookId.equals(this.bookId)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        break;
                    } else {
                        System.err.println("Mã sách này đã tồn tại");
                    }
                } else {
                    break;
                }
            } else {
                System.err.println("Hãy nhập mã sách bằng 4 ký tự và bắt đầu bằng B");
            }
        } while (true);
        System.out.println("Hãy nhập tên sách: ");
        do {
            this.bookName = sc.nextLine();
            if (this.bookName.length() > 4) {
                if (index > 0) {
                    boolean isExist = false;
                    for (int i = 0; i < index; i++) {
                        if (arrBooks[i].bookName.equals(this.bookName)) {
                            isExist = true;
                        }
                    }
                    if (!isExist) {
                        break;
                    } else {
                        System.err.println("Tên sách bạn vừa nhập đã tồn tại");
                    }
                } else {
                    break;
                }
            } else {
                System.err.println("Tên sách bạn nhập quá ngắn");
            }
        } while (true);

        System.out.println("Hãy nhập giá nhập sách: ");
        do {
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0");
            }
        } while (true);
        System.out.println("Hãy nhập giá xuất sách: ");
        final float RARE30 = 0.3f;
        do {
            float rarePrice = (this.importPrice * RARE30) + this.importPrice;
            this.exportPrice = Float.parseFloat(sc.nextLine());
            if (this.exportPrice >= rarePrice) {
                break;
            } else {
                System.err.println("Giá xuất phải lớn hơn ít nhất 30% so với giá nhập");
            }
        } while (true);
        System.out.println("Hãy nhập tác giả sách: ");
        do {
            this.author = sc.nextLine();
            if (this.author.length() >= 6 && this.author.length() <= 50) {
                break;
            } else {
                System.err.println("Tên Tác giả phải từ 6-50 ký tự");
            }
        } while (true);
        System.out.println("Hãy nhập năm xuất bản: ");
        do {
            this.year = Integer.parseInt(sc.nextLine());
            if (this.year > 2000 && this.year<=2023) {
                break;
            } else {
                System.err.println("Năm xuất bản ít nhất xuất bản sau năm 2000");
            }
        } while (true);
    }

    public void displayData() {
        System.out.printf("bookId: %s\t\t ⁘⁘⁘ bookName: %s\t\t ⁘⁘⁘ author: %s\n", this.bookId, this.bookName, this.author);
        System.out.printf("importPrice: %.3f\t\t ⁘⁘⁘ exportPrice: %.3f\t\t ⁘⁘⁘ interest: %.3f\t ⁘⁘⁘ year: %d\n", this.importPrice, this.exportPrice, this.interest, this.year);
        System.out.println("‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣‣");
    }

    public void calInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }
}

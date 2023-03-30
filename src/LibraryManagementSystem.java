
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

 class Book {
    int id;
    String title, author, publisher;
    int  booktype,quantity;

    public Book(int id, String title, String author, String publisher, int booktype,int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.booktype=booktype;
        this.quantity = quantity;
    }
}

class Student {
    int rollno;
    String name;
    int books_issued;
    int bookdays;

    public Student(int rollno, String name, int books_issued, int bookdays) {
        this.rollno = rollno;
        this.name = name;
        this.books_issued = books_issued;
        this.bookdays=bookdays;
    }
}
class BookData {
	int id,quantity;
	public BookData(int id,int quantity) {
		this.id=id;
		this.quantity=quantity;
	}

	
	
}
class BorrowBook{
	int student_rollNo,bookId;
	LocalDate issueDate;
	public BorrowBook(int student_rollNo,int bookId,LocalDate issueDate) {
		this.student_rollNo=student_rollNo;
		this.bookId=bookId;
		this.issueDate=issueDate;
	}
}
	class ReturnBook{
		int student_rollNo,bookId;
		LocalDate returndate;
		public ReturnBook(int student_rollNo,int bookId,LocalDate returndate) {
			this.student_rollNo=student_rollNo;
			this.bookId=bookId;
			this.returndate=returndate;
		}
}

public class LibraryManagementSystem {
    List<Book> books = new ArrayList<Book>();
    List<Book>fictionbooks=new ArrayList<Book>();
    List<Book>nonfictionbooks=new ArrayList<Book>();
    List<Student> students = new ArrayList<Student>();
    List<BookData>bookqty=new ArrayList<BookData>();
    List<BorrowBook>borrowbooks=new ArrayList<BorrowBook>();
    List<ReturnBook>returnbooks=new ArrayList<ReturnBook>();
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        while (true) {
            System.out.println("Welcome to Library Management System!");
            System.out.println("1. Student\n2. Librarian\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
            
                case 1:
                	
                    System.out.println("\nStudent Menu");
                    System.out.println("1. Search Book\n2. Borrow Book\n3. Return Book\n4. Pay Fine\n5. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int student_choice = sc.nextInt();
                    while(student_choice!=5) {

                    switch (student_choice) {
                        case 1:
                            library.searchBook();
                            break;

                        case 2:
                            library.borrowBook();
                            break;

                        case 3:
                            library.returnBook();
                            break;

                        case 4:
                            library.calculateFine();
                            break;

                        case 5:
                            System.out.println("\nThank you for using Library Management System!");
                            //System.exit(0);
                            break;

                        default:
                            System.out.println("\nInvalid choice!");
                            break;
                    
            }
                    System.out.println("\nStudent Menu");
                    System.out.println("1. Search Book\n2. Borrow Book\n3. Return Book\n4. Pay Fine\n5. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                     student_choice = sc.nextInt();
                    
                    }
                	

                    break;
                	
            

                case 2:
                	
                	
                    System.out.println("\nLibrarian Menu");
                    System.out.println("\n0. Add Student \n1. Add Book\n2. Remove Book\n3. Dispatch Book \n4. Search Book \n5. DisplayBooks \n6. DisplayStudents \n7. ArrangeBooks \n8. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int librarian_choice = sc.nextInt();
                    while(librarian_choice!=8) {
                    switch (librarian_choice) {
                    
                        
                        case 0:
                        	library.addStudent();
                        	library.displayStudents();
                        	break;
                        case 1:
                        	System.out.println("\nAvailable Books...");
                        	library.displayBooks();
                            library.addBook();
                            library.displayBooks();
                            break;

                        case 2:
                        	System.out.println("\nAvailable Books...");
                        	library.displayBooks();
                            library.removeBook();
                            library.displayBooks();
                            break;

                        case 3:
                            library.dispatchBook();
                            break;

                       // case 4:
                         //   library.calculateFine();
                           // break;

                        case 4:
                            library.searchBook();
                            break;
                            
                        case 5:
                            library.displayBooks();
                            break;
                         
                        case 6:
                            library.displayStudents();
                            break;
                            
                        case 7:
                        	library.arrangeBooks();
                        	break;
                      //  case 9:
                           // System.out.println("\nThank you for using Library Management System!");
                            //System.exit(0);
                      //      break;

                        default:
                            System.out.println("\nInvalid choice!");
                            break;
                    }
                    System.out.println("\nLibrarian Menu");
                    System.out.println("\n0. Add Student \n1. Add Book\n2. Remove Book\n3. Dispatch Book \n4. Search Book \n5. DisplayBooks \n6. DisplayStudents \n7. ArrangeBooks \n8. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    librarian_choice = sc.nextInt();
                	

                  
                	}
                    break;
                	

                case 3:
                    System.out.println("\nThank you for using Library Management System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        }
    }
    
    public void addStudent() {
    	String csvFile = "D:\\HariPrasad\\javaprograms\\StudentDetails.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                
                Student student =new Student(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                students.add(student);
                

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    //	Student student =new Student(rollno,name,booksissued,bookdays);
    //	students.add(student);
    }

    public void addBook() {
       
        
        String csvFile = "D:\\HariPrasad\\javaprograms\\BookDetails.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                
                Book book =new Book(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                books.add(book);
                BookData bookdata=new BookData(Integer.parseInt(data[0]),Integer.parseInt(data[5]));
                bookqty.add(bookdata);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
       


        
      //  Book book = new Book(id, title, author, publisher,booktype, quantity);
       // books.add(book);

        System.out.println("\nBook added successfully!");
    }

    public void removeBook() {
    	int value=0;
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Book ID: ");
        int id = sc.nextInt();
       
        for(BookData intial : bookqty) {
        	if(intial.id==id) {
        		value=intial.quantity;
         for (Book book : books) {
            if (book.id == id) {
            	if(value== book.quantity) {
                books.remove(book);
                System.out.println("\nBook removed successfully!");
                return;
            	}
            	else {
            		System.out.println("Student should return book..in order to remove the book..");
            	}
            }
        }

       // System.out.println("\nBook not found!");
    }
        }
        	}

    public void dispatchBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {
            	if(book.quantity>0) {
              
            	System.out.println("\nEnter the Student Roll No:");
            	int rollno =sc.nextInt();
            	for(Student student : students) {
            		if(rollno == student.rollno) {
            			student.books_issued++;
            			book.quantity--;
            			System.out.println("\nBook Dispatched Successfully..." +"to" +" " +student.name );
            			
            		}
            		
            	}
            	
            	
            	}
            	else
            	{
            	   System.out.println("\nBook quantity is not available.......");
            	}
            }
           // else
           // {
           //     System.out.println("\nBook not found....");
           // }
        }

       
    }

    public void calculateFine() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Student Roll Number: ");
        int rollno = sc.nextInt();
        

        System.out.print("\nEnter Book Id: ");
        int bookid = sc.nextInt();


        for (Student student : students) {
            if (student.rollno == rollno) {
            	for(BorrowBook borrowbook : borrowbooks) {
            		if(borrowbook.bookId==bookid) {
            			LocalDate issuedate=borrowbook.issueDate;
            			for(ReturnBook returnbook :returnbooks) {
            				if(returnbook.bookId==borrowbook.bookId) {
            					LocalDate returndate=returnbook.returndate;
            					long daysBetween = ChronoUnit.DAYS.between(issuedate, returndate);
            					student.bookdays=(int)daysBetween;
            					if(student.bookdays>10) {
            		                 int  fine =  10;
            		                System.out.println("\nFine for student " + student.name + " is " + fine + " rupees.");
            		                return;
            				} else {
            	            	System.out.println("No need to pay fine..");
            	            }
            				
            			}
            			
            			
            		}
            	}
            	// LocalDate issueDate = LocalDate.of(2022, 2, 1);
                 //LocalDate returnDate = LocalDate.of(2022, 2, 15);
                 
              
            	
            }
           
        }

        
    }
        
    }
    
  /*  public void payFine() {
    	//calculateFine();
    	for(Student student :students) {
    		if(student.bookdays > 10) {
    			System.out.println(student.name +" " +"should pay" +" " +"Rs."+student.bookdays*10);
    		}
    	}
    	
    }*/

    public void searchBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {
                System.out.println("\nBook Details");
                System.out.println("ID: " + book.id);
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Publisher: " + book.publisher);
                System.out.println("Quantity: " + book.quantity);
                return;
            }
        }

        System.out.println("\nBook not found!");
    }

    public void borrowBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Student Roll Number: ");
        int rollno = sc.nextInt();

        for (Student student : students) {
            if (student.rollno == rollno) {
                if (student.books_issued < 3) {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                   

                    for (Book book : books) {
                        if (book.id == id) {
                            if (book.quantity > 0) {
                            	System.out.println("\nEnter the year:");
                            	int year=sc.nextInt();
                            	System.out.println("\nEnter the month:");
                            	int month=sc.nextInt();
                            	System.out.println("\nEnter the date:");
                            	int date=sc.nextInt();
                            	LocalDate issueddate=LocalDate.of(year, month, date);
                                book.quantity--;
                                student.books_issued++;
                                System.out.println("\nBook borrowed successfully!"+" " +issueddate);
                                BorrowBook borrowbook=new BorrowBook(student.rollno,book.id,issueddate);
                                borrowbooks.add(borrowbook);
                                //System.out.println(LocalDate.now());
                                return;
                            } else {
                                System.out.println("\nBook not available!");
                                return;
                            }
                        }
                    }

                    System.out.println("\nBook not found!");
                    return;
                } else {
                    System.out.println("\nStudent has already borrowed 3 books!");
                    return;
                }
            }
        }

        System.out.println("\nStudent not found!");
    }

    public void returnBook() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Student Roll Number: ");
        int rollno = sc.nextInt();

        for (Student student : students) {
            if (student.rollno == rollno) {
                if (student.books_issued > 0)
                {
                	System.out.print("Enter Book ID: ");
                	int id = sc.nextInt();
                	for(BorrowBook borrowbook : borrowbooks) {
                		
                		
                	//}
                  
                        if (borrowbook.bookId == id) {
                        	System.out.println("\nEnter the year:");
                        	int year=sc.nextInt();
                        	System.out.println("\nEnter the month:");
                        	int month=sc.nextInt();
                        	System.out.println("\nEnter the date:");
                        	int date=sc.nextInt();
                        	LocalDate returndate=LocalDate.of(year, month, date);
                        	for (Book book : books) {
                        		if(borrowbook.bookId==book.id) {
                            book.quantity++;
                            student.books_issued--;
                            System.out.println("\nBook returned successfully!" +" "+returndate);
                            ReturnBook returnbook=new ReturnBook(student.rollno,book.id, returndate);
                            returnbooks.add(returnbook);
                            return;
                        }
                        	}
                    }

                    System.out.println("\n Book not found!");
                    return;
                }
                }else {
                    System.out.println("\n Student has not borrowed any books!");
                    return;
                }
            }
        }

        System.out.println("\nStudent not found!");
    }

    public void displayBooks() {
    System.out.println("\nBook List");
    for (Book book : books) {
        System.out.println("ID: " + book.id + "\tTitle: " + book.title + "\tAuthor: " + book.author
                + "\tPublisher: " + book.publisher + "\tQuantity: " + book.quantity);
    }
    
    //for(BookData bookdata :bookqty) {
    //	System.out.println(bookdata.id +" " +bookdata.quantity);
    //}
    
    }
    
    public void arrangeBooks() {
    	System.out.println("\nArranging Books:");
    	//System.out.println("\nEnter the type of Book if it fiction type 0 else 1");
    	
    	for(Book book:books) {
    		if(book.booktype==0) {
    			fictionbooks.add(book);
    		}
    		else {
    			nonfictionbooks.add(book);
    		}
    	}
    	
    	System.out.println("---------------------------RACK A----------------------------");
    	for (Book book : nonfictionbooks) {
            System.out.println("ID: " + book.id + "\tTitle: " + book.title + "\tAuthor: " + book.author
                    + "\tPublisher: " + book.publisher + "\tQuantity: " + book.quantity);
        }
    	System.out.println("---------------------------RACK B----------------------------");
    	for (Book book : fictionbooks) {
            System.out.println("ID: " + book.id + "\tTitle: " + book.title + "\tAuthor: " + book.author
                    + "\tPublisher: " + book.publisher + "\tQuantity: " + book.quantity);
        }
    }

    public void displayStudents() {
    System.out.println("\nStudent List");
    for (Student student : students) {
        System.out.println("Roll Number: " + student.rollno + "\tName: " + student.name + "\tBooks Issued: "
                + student.books_issued +"\tBooks Holding days: " +student.bookdays);
    }
    }

 
}




        




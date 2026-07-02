package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService svc = ctx.getBean("bookService", BookService.class);
        System.out.println("=== All Books ===");
        svc.getAllBooks().forEach(System.out::println);
        System.out.println("Book by ID: " + svc.getBookById(1));
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}

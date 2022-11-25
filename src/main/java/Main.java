import az.spring.config.Config;
import az.spring.entity.Book;
import az.spring.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BookService bookService = context.getBean(BookService.class);
        Book bk = new Book();
        bk.setName("Cinayet ve ceza");
        bk.setAuthor("Dostoyevski");
        bk.setPublishYear("2000");

        bookService.save(bk);
    }
}

import com.google.inject.AbstractModule;
import java.time.Clock;

//import dao.BookDao;
//import dao.BookDaoImpl;
//import dao.FakeBookDao;
import dao.*;
import services.*;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {

        bind(HotelDao.class).to(HotelDaoImpl.class);
        bind(UserDao.class).to(UserDaoImpl.class);
        bind(ImageStore.class).to(ImageStoreImpl.class);
        bind(ImageDao.class).to(ImageDaoImpl.class);
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);
       // bind(BookDao.class).to(BookDaoImpl.class);
        //        bind(BookDao.class).to(FakeBookDao.class);

    }

}

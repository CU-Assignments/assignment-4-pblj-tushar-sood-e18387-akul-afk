import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class TicketBooking {
    private int availableSeats = 5;
    private final Lock lock = new ReentrantLock();

    public void bookSeat(String name) {
        lock.lock();
        try {
            if (availableSeats > 0) {
                System.out.println(name + " booked a seat! Remaining: " + (--availableSeats));
                Thread.sleep(1000);
            } else {
                System.out.println(name + " failed to book. No seats left!");
            }
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted!");
        } finally {
            lock.unlock();
        }
    }
}
class Customer extends Thread {
    private final TicketBooking booking;
    private final String customerType;
    public Customer(TicketBooking booking, String name, int priority, String type) {
        super(name);
        this.booking = booking;
        this.customerType = type;
        setPriority(priority);
    }
    public void run() {
        booking.bookSeat(getName() + " (" + customerType + ")");
    }
}
public class prob1 {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        Customer vip1 = new Customer(booking, "VIP 1", Thread.MAX_PRIORITY, "VIP");
        Customer vip2 = new Customer(booking, "VIP 2", Thread.MAX_PRIORITY, "VIP");
        Customer reg1 = new Customer(booking, "Regular 1", Thread.NORM_PRIORITY, "Regular");
        Customer reg2 = new Customer(booking, "Regular 2", Thread.NORM_PRIORITY, "Regular");
        Customer reg3 = new Customer(booking, "Regular 3", Thread.NORM_PRIORITY, "Regular");
        Customer reg4 = new Customer(booking, "Regular 4", Thread.NORM_PRIORITY, "Regular");

        vip1.start();
        vip2.start();
        reg1.start();
        reg2.start();
        reg3.start();
        reg4.start();
    }
}

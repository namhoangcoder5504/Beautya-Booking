package BookingService.BookingService.repository;


import BookingService.BookingService.entity.Booking;
import BookingService.BookingService.entity.User;
import BookingService.BookingService.enums.BookingStatus;
import BookingService.BookingService.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBySpecialistAndBookingDateAndTimeSlot(User specialist, LocalDate bookingDate, String timeSlot);
    List<Booking> findByCustomer(User customer);
    boolean existsBySpecialistUserIdAndBookingDateAndTimeSlot(Long specialistId, LocalDate bookingDate, String timeSlot);
    List<Booking> findByBookingDateBetweenAndStatus(LocalDate startDate, LocalDate endDate, BookingStatus status);
    boolean existsByCustomerAndBookingDateAndTimeSlotAndBookingIdNot(User customer, LocalDate bookingDate, String timeSlot, Long bookingId);
    boolean existsByCustomerAndBookingDateAndTimeSlot(User customer, LocalDate bookingDate, String timeSlot);
}
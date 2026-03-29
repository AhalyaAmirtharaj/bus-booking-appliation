import { useEffect, useState } from 'react';
import { getMyBookings, cancelBooking } from '../services/api';
import '../styles/App.css';
export default function MyTickets() {
const [bookings, setBookings] = useState([]);
const userId = localStorage.getItem('userId');
// load my bookings when page opens
useEffect(() => {
if (userId) {
getMyBookings(userId)
.then(res => setBookings(res.data))
.catch(err => console.log(err));
}
}, []);
// cancel a booking
const handleCancel = async (bookingId) => {
try {
await cancelBooking(bookingId);
alert('Booking cancelled!');
// refresh the list
getMyBookings(userId).then(res => setBookings(res.data));
} catch (err) {
alert('Cancel failed!');
}
};
return (
<div className='list-container'>
<h2>My Tickets</h2>
{bookings.length === 0 && <p>No bookings yet!</p>}
{bookings.map(booking => (
<div key={booking.id} className='card'>
<p><strong>{booking.route.source} → {booking.route.destination}</strong></p>
<p>Date: {booking.route.travelDate}</p>
<p>Seat: {booking.seatNumber}</p>
<p>Status: <span className={booking.status === 'BOOKED' ? 'status-booked' : 'status-cancelled'}>
{booking.status}</span></p>
{booking.status === 'BOOKED' && (
<button className='btn-danger'
onClick={() => handleCancel(booking.id)}>
Cancel Ticket
</button>
)}
</div>
))}
</div>
);
}
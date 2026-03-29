import { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getBookedSeats, bookSeat } from '../services/api';
import '../styles/App.css';
export default function SeatSelection() {
const { routeId } = useParams(); // get routeId from URL
const navigate = useNavigate();
const [bookedSeats, setBookedSeats] = useState([]);
const [selectedSeat, setSelectedSeat] = useState(null);
const totalSeats = 40; // bus has 40 seats
// when page loads, get already booked seats
useEffect(() => {
getBookedSeats(routeId)
.then(res => setBookedSeats(res.data))
.catch(err => console.log(err));
}, []);
// when user clicks Book button
const handleBook = async () => {
if (!selectedSeat) {
alert('Please select a seat!');
return;
}
const userId = localStorage.getItem('userId');
if (!userId) {
alert('Please login first!');
navigate('/login');
return;
}
try {
await bookSeat({ userId, routeId, seatNumber: selectedSeat });
alert('Seat booked successfully!');
navigate('/my-tickets');
} catch (err) {
alert('Booking failed! ' + err.response?.data?.message);
}
};
return (
<div className='seat-container'>
<h2>Select Your Seat</h2>
<div className='seat-grid'>
{Array.from({ length: totalSeats }, (_, i) => i + 1).map(seat => (
<button
key={seat}
className={'seat
${bookedSeats.includes(seat) ? 'booked' : ''}
${selectedSeat === seat ? 'selected' : ''}'}
onClick={() => !bookedSeats.includes(seat) && setSelectedSeat(seat)}
>
{seat}
</button>
))}
</div>
<div className='legend'>
<span className='seat'>Available</span>
<span className='seat booked'>Booked</span>
<span className='seat selected'>Selected</span>
</div>
{selectedSeat && <p>Selected Seat: <strong>{selectedSeat}</strong></p>}
<button className='btn-primary' onClick={handleBook}>
Book Seat {selectedSeat}
</button>
</div>
);
}